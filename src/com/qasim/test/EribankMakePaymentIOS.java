package com.qasim.test;

import java.util.Random;

import com.experitest.client.Client;
import com.qasim.framework.BaseTest;
import com.qasim.framework.PlatformType;

public class EribankMakePaymentIOS extends BaseTest
{
	@Override
	protected PlatformType getPaltformType()
	{
		return PlatformType.IOS;
	}

	@Override
	public void runTest(Client client)
	{
		Random rand = new Random();
		int sumToPay = rand.nextInt(100);
		
		if (client.install(System.getProperty("user.dir") + "\\src\\sources\\eribankIOS.ipa", true, true))
		{
			// If statement
		}

		client.launch("cloud:com.experitest.ExperiBank", true, true);
		client.elementSendText("NATIVE", "xpath=//*[@accessibilityLabel='Username']", 0, "company");
		client.elementSendText("NATIVE", "xpath=//*[@accessibilityLabel='Password']", 0, "company");
		client.click("NATIVE", "xpath=//*[@text='Login']", 0, 1);
		
		String previousBalanceString = client.elementGetText("WEB", "xpath=//*[contains(@text,'balance')]" , 0);
		double previousBalance =  Double.parseDouble((previousBalanceString.split(":")[1]).replace("$", ""));
		
        client.click("NATIVE", "xpath=//*[@text='Make Payment']", 0, 1);
        client.elementSendText("NATIVE", "xpath=//*[@accessibilityLabel='Phone']", 0, "1234567890");
        client.elementSendText("NATIVE", "xpath=//*[@accessibilityLabel='Name']", 0, "experitest");
        client.elementSendText("NATIVE", "xpath=//*[@accessibilityLabel='Amount']", 0, "" + sumToPay );
        client.click("NATIVE", "xpath=//*[@text='Select']", 0, 1);
        client.click("NATIVE", "xpath=//*[@accessibilityLabel='Brazil']", 0, 1);
        client.click("NATIVE", "xpath=//*[@text='Send Payment']", 0, 1);
        client.click("NATIVE", "xpath=//*[@text='Yes']", 0, 1);

		String futureBalanceString = client.elementGetText("WEB", "xpath=//*[contains(@text,'balance')]" , 0);
		double futureBalance =  Double.parseDouble((futureBalanceString.split(":")[1]).replace("$", ""));
		
		if((previousBalance - sumToPay) == futureBalance)
			System.out.println("Payment was made Successfully");
		else
			System.out.println("Payment Failed");
		
        client.click("NATIVE", "xpath=//*[@text='Logout']", 0, 1);
	}
}
