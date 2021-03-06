package com.qasim.framework;

import java.io.*;

import org.testng.ITestResult;

class TestSummary
{
	public String deviceName;
	public String deviceSerialNumber;
	public String time;
	public String testName;
	public String failureReason;
	public int status;
}

public class OverallSummary
{
	public TestSummary testSummary;
	boolean exists;
	
	public OverallSummary()
	{
		
	}
	
	public void overallSummaryWrite(TestSummary testSummary, String reportDirectory) throws IOException
	{
		
		System.out.println(reportDirectory);
		
		File tempFile = new File(reportDirectory + "\\overall summary.txt");
		
		exists = tempFile.exists();
		
		if (testSummary.status == ITestResult.FAILURE)
		{
			if (exists)
			{
				
				String failedstring = "the device " + testSummary.deviceName + " serial number " + testSummary.deviceSerialNumber + " has Failed on the following test: " + testSummary.testName + " because " + testSummary.failureReason;
				BufferedWriter writer = null;
				
				writer = new BufferedWriter(new FileWriter(reportDirectory + " overall summary.txt", true));
				
				writer.append(' ');
				writer.newLine();
				writer.append(failedstring);
				writer.close();
				
			}
			else
			{
				System.out.println("in else exists");
				
				String failedstring = "the device " + testSummary.deviceName + " serial number " + testSummary.deviceSerialNumber + " has Failed on the following test: " + testSummary.testName + " because " + testSummary.failureReason;
				
				BufferedWriter writer = null;
				
				writer = new BufferedWriter(new FileWriter(reportDirectory + " overall summary.txt"));
				
				writer.write(failedstring);
				writer.close();
				
			}
		}
		
		if (testSummary.status == ITestResult.SUCCESS)
		{
			if (exists)
			{
				System.out.println("in success exists");
				
				String success = "the device " + testSummary.deviceName + " serial number " + testSummary.deviceSerialNumber + " has Passed on the following test: " + testSummary.testName;
				BufferedWriter writer = null;
				
				writer = new BufferedWriter(new FileWriter(reportDirectory + " overall summary.txt", true));
				
				writer.append(" ");
				writer.newLine();
				writer.append(success);
				writer.close();
				
			}
			else
			{
				System.out.println("in success else");
				
				String success = "the device " + testSummary.deviceName + " serial number " + testSummary.deviceSerialNumber + " has Passed on the following test: " + testSummary.testName;
				
				BufferedWriter writer = null;
				writer = new BufferedWriter(new FileWriter(reportDirectory + " overall summary.txt"));
				writer.write(success);
				writer.close();
			}
		}
	}
}
