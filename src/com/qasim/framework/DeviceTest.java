package com.qasim.framework;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.xml.XmlTest;

import com.experitest.client.*;

public class DeviceTest implements Runnable
{
	protected String seeTestProject = "trainingAssignment";
	protected String deviceQuery;
	protected ITestContext context;
	protected MyTestResultListener listener = new MyTestResultListener();
	protected TestRun test;

	protected long startTimeMillis = 0;
	protected int runCount = 0;

	protected Client client = null;

	private String projectBaseDirectory;
	private String reporterDirectory;
	private String testName;
	private String device;

	public DeviceTest(TestRun testRun, String deviceQuery, ITestContext context, long startTimeMillis)
	{
		this.test = testRun;
		this.deviceQuery = deviceQuery;
		this.context = context;
		this.startTimeMillis = startTimeMillis;

		testName = test.getClass().getName();
		System.out.println(" >> DeviceTest: " + context.getName() + ": " + testName + ", deviceQuery=" + deviceQuery);
	}

	protected synchronized void setDirectory(String deviceName)
	{
		projectBaseDirectory = System.getProperty("user.dir") + "\\" + seeTestProject;
		reporterDirectory = String.format("%s\\reports\\RUN_%s\\%s\\%s", projectBaseDirectory, this.startTimeMillis,
				deviceName, testName);

		System.out.println(testName + ": getRunTime(runCount=" + runCount + ") > startTimeMillis=" + startTimeMillis);
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
		// Client client = new Client(host, port, useSessionID);
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
		System.out.println("client.setReporter(\"xml\"," + reporterDirectory + "," + testName + ") ");

		client.setProjectBaseDirectory(projectBaseDirectory);
		client.setReporter("xml", reporterDirectory, testName);
		client.openDevice();
	}

	protected void tearDown() throws IOException
	{
		OverallSummary os = new OverallSummary();
		TestSummary testSummary = new TestSummary();
		testSummary.deviceName = device;
		testSummary.testName = testName;
		testSummary.time = "" + startTimeMillis;
		
		
		
		File tempFile = new File("overall summary.txt");
		boolean exists = tempFile.exists();
		String failedstring = "the device " + device + " serial number " + client.getProperty("@device serialsnumber") + " has failed on the following test: "  + testName;
		String success = "the device " + device + " serial number " + client.getProperty("@device serialsnumber") + " has Passed on the following test: "  + testName;
		
		if (testSummary.status == ITestResult.FAILURE)
		{
			if (exists)
			{		
				BufferedWriter writer = null;

				writer = new BufferedWriter(new FileWriter("overall summary.txt", true));

				writer.append(' ');
				writer.newLine();
				writer.append(failedstring);
				writer.close();

			}
			else
			{
				System.out.println("in else exists");

				BufferedWriter writer = null;

				writer = new BufferedWriter(new FileWriter("overall summary.txt"));

				writer.write(failedstring);
				writer.close();
			}
		}

		if (testSummary.status == ITestResult.SUCCESS)
		{
			if (exists)
			{
				System.out.println("in success exists");
				BufferedWriter writer = null;

				writer = new BufferedWriter(new FileWriter("overall summary.txt", true));

				writer.append(" ");
				writer.newLine();
				writer.append(success);
				writer.close();

			}
			else
			{
				System.out.println("in success else");

				BufferedWriter writer = null;
				writer = new BufferedWriter(new FileWriter("overall summary.txt"));
				writer.write(success);
				writer.close();
			}
		}
		
		client.generateReport(false);
		client.closeDevice();
		client.releaseClient();
		System.out.println(
				" >> releaseClient(" + context.getName() + ": " + testName + ", deviceQuery=" + deviceQuery + ")");
	}

	@Override
	public void run()
	{
		OverallSummary os = new OverallSummary();
		TestSummary ts = new TestSummary();
		ts.deviceName = device;
		ts.testName = testName;
		ts.time = "" + startTimeMillis;
		//ts.deviceSerialNumber = client.getDeviceProperty("serialnumber");
		
		System.out.println(" >> run: " + context.getName() + ": " + testName + ", deviceQuery=" + deviceQuery);
		try
		{
			setUp();
			test.runTest(this.client);
		}
		catch (Exception e)
		{
			// summry
			try
			{
				os.overallSummaryWrite(ts);
			}
			catch (IOException e1)
			{
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			e.printStackTrace();
			System.out.println(getClass().getName() + ": testName=" + testName + ", device=" + device +  ", run()");
		}
		finally
		{
			try
			{
				try
				{
					os.overallSummaryWrite(ts);
				}
				catch (IOException e1)
				{
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				tearDown();
				System.out.println(getClass().getName() + ": testName=" + testName + ", device=" + device +  ", tearDown()");
			}
			catch (Exception e2)
			{
				// summry
			}
		}
	}
}
