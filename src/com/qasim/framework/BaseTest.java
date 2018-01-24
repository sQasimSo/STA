package com.qasim.framework;

import com.experitest.client.Client;
import com.experitest.client.GridClient;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.ITestContext;
import org.testng.ITestResult;
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

import java.io.BufferedWriter;
import java.io.FileWriter;

import com.experitest.client.*;

public abstract class BaseTest
{
	protected boolean singleDevice = false;
	protected String status;
	protected long runTimeMillis = 0;
	protected PlatformType platformType;
	
	public abstract void runTest(Client client);
	
	protected abstract void setPaltformType();
	
	protected static ArrayList<Long> currentTimeList = new ArrayList<Long>();
	
	protected String seeTestProject = "trainingAssignment";
	protected String deviceQuery;
	protected ITestContext context;
	protected ITestResult result;
	
	protected int runCount = 0;
	
	protected Client client = null;
	
	private String projectBaseDirectory;
	String reporterDirectory;
	private String testName;
	private String device;
	
	public BaseTest()
	{
		setPaltformType();
	}
	
	protected synchronized void setDirectory(String deviceName)
	{
		projectBaseDirectory = System.getProperty("user.dir") + "\\" + seeTestProject;
		reporterDirectory = String.format("%s\\reports\\RUN_%s\\%s\\%s", projectBaseDirectory, this.runTimeMillis, deviceName, testName);
		
		System.out.println(testName + ": getRunTime(runCount=" + runCount + ") > startTimeMillis=" + runTimeMillis);
		try
		{
			new File(this.reporterDirectory).mkdir();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public Client getGridClient(ITestContext context, String deviceQuery)
	{
		XmlTest params = context.getCurrentXmlTest();
		
		String userName = params.getParameter("userName");
		String password = params.getParameter("password");
		String projectName = params.getParameter("projectName");
		String domain = params.getParameter("domain");
		int gridPort = Integer.parseInt(params.getParameter("gridPort"));
		boolean isSecured = Boolean.parseBoolean(params.getParameter("isGridSecured"));
		
		GridClient grid = new GridClient(userName, password, projectName, domain, gridPort, isSecured);
		Client client = new MyClient(grid.lockDeviceForExecution(testName, deviceQuery, 10, 50000)).getClient();
		
		return client;
	}
	
	public static Client getClient(ITestContext context)
	{
		XmlTest params = context.getCurrentXmlTest();
		String host = params.getParameter("host");
		int port = Integer.parseInt(params.getParameter("port"));
		boolean useSessionID = Boolean.parseBoolean(params.getParameter("useSessionID"));
		
		Client client = new MyClient(host, port, useSessionID).getClient();
		return client;
	}
	
	protected void setUp()
	{
		
		XmlTest params = context.getCurrentXmlTest();
		boolean useGrid = Boolean.parseBoolean(params.getParameter("useGrid"));
		if (useGrid)
		{
			client = getGridClient(context, deviceQuery);
			device = client.getDeviceProperty("device.name");
		}
		else
		{
			client = getClient(context);
			device = client.waitForDevice(deviceQuery, 300000);
		}
		System.out.println(" -- waitForDevice >  " + device);
		
		setDirectory(device.split(":")[1]);
		System.out.println("client.setReporter(\"xml\"," + reporterDirectory + ", " + testName + ") ");
		
		client.setProjectBaseDirectory(projectBaseDirectory);
		client.setReporter("xml", reporterDirectory, testName);
		client.openDevice();
	}
	
	@AfterTest
	protected void tearDown()
	{
		client.releaseClient();
		System.out.println(" >> releaseClient(" + context.getName() + ": " + testName + ", deviceQuery=" + deviceQuery + ")");
		
	}
	
	protected void endTest() throws IOException
	{
		client.generateReport(false);
	}
	
	public boolean startTest() throws IOException
	{
		boolean result = false;
		try
		{
			setUp();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		
		TestSummary ts = new TestSummary();
		OverallSummary os = new OverallSummary();
		
		ts.deviceName = device;
		ts.deviceSerialNumber = client.getProperty("device.sn");;
		ts.testName = testName;
		ts.time = "" + runTimeMillis;
		
		for (int i = 0; i < 3; i++)
		{
			
			
			result = runSingleTest();
			
			if (result)
				ts.status = ITestResult.SUCCESS;
			else
				ts.status = ITestResult.FAILURE;
			
			try
			{
				os.overallSummaryWrite(ts, reporterDirectory);
			}
			catch (IOException e1)
			{
				e1.printStackTrace();
			}
			
			try
			{
				endTest();
			}
			catch (Exception e)
			{
				e.printStackTrace();
			}
			if (result)
			{
				break;
			}
			
			if (i == 1)
			{
				os.overallSummaryWrite(ts, reporterDirectory);
				client.collectSupportData(reporterDirectory, "", device, "Failed once", "Success", "Failure");
			}
			if (i == 2)
			{
				os.overallSummaryWrite(ts, reporterDirectory);
				client.reboot(120000);
				client.collectSupportData(reporterDirectory, "", device, "Failed once", "Success", "Failure");
			}
		}
		return result;
	}
	
	public boolean runSingleTest()
	{
		boolean result = false;
		
		System.out.println(" >> runSingleTest: " + context.getName() + ": " + testName + ", deviceQuery=" + deviceQuery);
		try
		{
			runTest(client);
			result = true;
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return result;
	}
	
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
				}
				else
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
		}
		catch (FileNotFoundException e)
		{
			e.printStackTrace();
		}
	}
	
	protected void setDeviceQuery(ITestContext context)
	{
		XmlTest params = context.getCurrentXmlTest();
		deviceQuery = params.getParameter("deviceQuery");
		if (Strings.isNullOrEmpty(deviceQuery))
		{
			switch (platformType)
			{
				case IOS:
					deviceQuery = "@os='ios' and @added='true'";
					break;
				case ANDROID:
					deviceQuery = "@os='android' and @added='true'";
					break;
				
				default:
					deviceQuery = "@os='android' and @added='true'";
					break;
			}
		}
	}
	
	@Test
	public void Start(ITestContext context) throws ParserConfigurationException, SAXException, IOException
	{
		int runCount = 0;
		boolean runByCount = false;
		this.context = context;
		// this.startTimeMillis = startTimeMillis;
		
		testName = this.getClass().getName();
		
		System.out.println(" << Start >> " + context.getName() + ": " + testName);
		
		XmlTest params = context.getCurrentXmlTest();
		String valueString = params.getParameter("runByCount");
		
		boolean runTestParam = true;
		String runTestString = params.getParameter("runTest");
		if (Strings.isNotNullAndNotEmpty(runTestString))
		{
			runTestParam = Boolean.parseBoolean(runTestString);
		}
		
		// accepts the parameters from the testng file and act accordingly. if
		// the runTest parameter is set to false then the class skips the test.
		if (!runTestParam)
		{
			System.out.println(context.getName() + ": skip " + testName + " as runTest = false");
			return;
		}
		
		setDeviceQuery(context);
		
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
		
		int runNumber = 0;
		if (runByCount)
		{
			for (runNumber = 1; runNumber <= runCount; runNumber++)
			{
				runTimeMillis = getRunTime(runNumber);
				this.startTest();
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
				
				System.out.println(String.format(" ** %s:%s : %s < %s test %d ** ", this.platformType, this.getClass().getName(), currentTimeMillis, endTimeMillis, runNumber));
				
				runTimeMillis = getRunTime(runNumber);
				this.startTest();
			}
			currentTimeMillis = System.currentTimeMillis();
		}
		currentTimeMillis = System.currentTimeMillis();
		if (!runByCount && !runByTime)
		{
			runTimeMillis = getRunTime(1);
			this.startTest();
		}
	}
}
