package com.qasim.framework;

import java.io.IOException;

import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

public class MyTestResultListener extends TestListenerAdapter
{
	private OverallSummary os = new OverallSummary();
	public TestSummary ts = new TestSummary();
	
	@Override
	public void onTestFailure(ITestResult result)
	{
		
		ts.status = result.getStatus();
		
		try
		{
			os.overallSummaryWrite(ts);
		}
		catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void onTestSuccess(ITestResult result)
	{
		ts.status = result.getStatus();
		
		try
		{
			os.overallSummaryWrite(ts);
		}
		catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void onTestSkipped(ITestResult result)
	{
		ts.status = result.getStatus();
		
		try
		{
			os.overallSummaryWrite(ts);
		}
		catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}