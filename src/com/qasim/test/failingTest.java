package com.qasim.test;

import com.experitest.client.Client;
import com.qasim.framework.BaseTest;
import com.qasim.framework.PlatformType;

public class failingTest extends BaseTest
{
	@Override
	protected void setPaltformType()
	{
		platformType = PlatformType.ANDROID;
	}

	@Override
	public void runTest(Client client)
	{
		System.out.println(getClass().getName() + ": test()");
		client.click("NATIVE", "xpath=//*[@text='Confirm']", 0, 1);
	}
}
