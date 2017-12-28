package com.qasim.framework;

import com.experitest.client.Client;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.ITestContext;
import org.testng.util.Strings;
import org.testng.xml.XmlTest;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import static org.testng.Assert.fail;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Scanner;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;


@Listeners(MyTestResultListener.class)
public abstract class BaseTest implements TestRun
{
	protected boolean singleDevice = false;
	protected String testName;
	protected TestRun test;
	protected String status;
	protected long runTimeMillis = 0;
	protected PlatformType platformType;
	protected ArrayList<String> devicesList = new ArrayList<String>();

	public abstract void runTest(Client client);

	protected abstract PlatformType getPaltformType();

	protected static ArrayList<Long> currentTimeList = new ArrayList<Long>();

	public static synchronized long getRunTime(int runCount)
	{
		while (runCount > currentTimeList.size())
		{
			currentTimeList.add(System.currentTimeMillis());
		}
		return currentTimeList.get(runCount - 1);
	}

	public void readCSV(ArrayList<String> usernames, ArrayList<String> passwords) throws IOException
	{
		String csvFilePath = System.getProperty("user.dir") + "/src/sources/csvfile.csv";
		String line = "";
		Scanner inputStream;

		String csvSplitBy = ",";

		try
		{
			inputStream = new Scanner(new File(csvFilePath));
			inputStream.nextLine();

			while (inputStream.hasNextLine())
			{
				line = inputStream.nextLine();

				if (line.equals(""))
				{
					System.out.println("end of file");
				} else
				{
					String[] credentials = line.split(csvSplitBy);
					if (credentials[0].equals(""))
						usernames.add(" ");
					else
						usernames.add(credentials[0]);

					if (credentials[1].equals(""))
						passwords.add(" ");
					else
						passwords.add(credentials[1]);
				}
			}
		} catch (FileNotFoundException e)
		{
			e.printStackTrace();
		}
	}
	
	protected void setDeviceList(ITestContext context) throws ParserConfigurationException, SAXException, IOException
	{
		XmlTest params = context.getCurrentXmlTest();
		String deviceQuery = params.getParameter("deviceQuery");
		if (!Strings.isNullOrEmpty(deviceQuery))
		{
			devicesList.add(deviceQuery);
			singleDevice = true;
			return;
		}
		
		Client client = DeviceTest.getClient(context);
		String xml = client.getDevicesInformation();
		client.releaseClient();
		
		String os;
		String name;
		String serialNumber;
		String status;
		Element deviceElement;

		// read XML from the given string
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		InputSource is = new InputSource(new StringReader(xml));
		Document document = builder.parse(is);

		// this will return a list of xml tags
		NodeList devicesNodeList = document.getElementsByTagName("device");

		// iterate over hiList and read/process them
		for (int i = 0; i < devicesNodeList.getLength(); i++)
		{
			deviceElement = (Element) devicesNodeList.item(i);

			name = deviceElement.getAttribute("name");
			os = deviceElement.getAttribute("os");
			status = deviceElement.getAttribute("status");
			
			if (!os.contains(platformType.toString().toLowerCase()))
			{
				System.out.println("skip os=" + os + " (" + name + ")");
				continue;
			}
			if (status.contains("reserved"))
			{
				System.out.println("skip status =" + status + " (" + name + ")");
				continue;
			}

			serialNumber = deviceElement.getAttribute("serialnumber");

			deviceQuery = "@serialnumber='" + serialNumber + "' and @added=\"true\"";
			
			devicesList.add(deviceQuery);
		}
	}

	@Test
	public void Start(ITestContext context) throws ParserConfigurationException, SAXException, IOException
	{
		String deviceQuery;
		DeviceTest deviceTest;
		Thread thread;
		ArrayList<Thread> threads = new ArrayList<Thread>();
		int runCount = 0;
		boolean runByCount = false;
		
		
		System.out.println(" << Start >> " + context.getName() + ": " + getClass().getName());
		
		XmlTest params = context.getCurrentXmlTest();
		String valueString = params.getParameter("runByCount");
		boolean runTest = Boolean.parseBoolean(params.getParameter("runTest"));
		
		//accepts the parameters from the testng file and act accordingly. if the runTest parameter is set to false then the class skips the test.
		if (!runTest)
		{
			System.out.println(context.getName() + ": skip " + getClass().getName() + " as runTest = false");
			return;
		}
		this.platformType = getPaltformType();
		
		setDeviceList(context);
		
		if (Strings.isNotNullAndNotEmpty(valueString))
		{
			runByCount = Boolean.parseBoolean(valueString);

			valueString = params.getParameter("runCount");
			if (Strings.isNotNullAndNotEmpty(valueString))
			{
				runCount = Integer.parseInt(valueString);
			}
		}
		if (singleDevice)
		{
			runByCount = true;
			runCount = 1;
		}
		
		int devicesSize = devicesList.size();
		int runNumber = 0;
		if (runByCount)
		{
			for (runNumber = 1; runNumber <= runCount; runNumber++)
			{
				runTimeMillis = getRunTime(runNumber);
				threads.clear(); 
				for (int d = 0; d < devicesSize; d++)
				{
					deviceQuery = devicesList.get(d);
					deviceTest = new DeviceTest(this, deviceQuery, context, runTimeMillis);
					thread = new Thread(deviceTest, this.getClass().getName());
					threads.add(thread);
					thread.start();
				}
				for (int i = 0; i < threads.size(); i++)
				{
					thread = threads.get(i);
					try
					{
						thread.join();
					} catch (InterruptedException e)
					{
						e.printStackTrace();
					}
				}
			}
		}
		
		
		float minutes = 0;
		boolean runByTime = false;
		valueString = params.getParameter("runByTime");
		
		if (Strings.isNotNullAndNotEmpty(valueString))
		{
			runByTime = Boolean.parseBoolean(valueString);

			valueString = params.getParameter("minutes");
			if (Strings.isNotNullAndNotEmpty(valueString))
			{
				minutes = Float.parseFloat(valueString);
			}
		}

		long currentTimeMillis = System.currentTimeMillis();
		long endTimeMillis = (long) (minutes * 60 * 1000) + currentTimeMillis;

		if (singleDevice)
		{
			runByTime = false;
		}
		
		if (runByTime)
		{ 
			while (currentTimeMillis < endTimeMillis)
			{
				runNumber++;
				runTimeMillis = getRunTime(runNumber);
				threads.clear(); 

				System.out.println(String.format(" ** %s:%s : %s < %s test %d ** ", this.platformType,
						this.getClass().getName(), currentTimeMillis, endTimeMillis, runNumber));

				for (int d = 0; d < devicesSize; d++)
				{
					deviceQuery = devicesList.get(d);
					deviceTest = new DeviceTest(this, deviceQuery, context, runTimeMillis);
					thread = new Thread(deviceTest, this.getClass().getName());
					threads.add(thread);
					thread.start();
				}
				
				for (int i = 0; i < threads.size(); i++)
				{
					thread = threads.get(i);
					try
					{
						thread.join();
					} catch (InterruptedException e)
					{
						e.printStackTrace();
					}
				}
			}
			currentTimeMillis = System.currentTimeMillis();
		}
		currentTimeMillis = System.currentTimeMillis();
	}
}
