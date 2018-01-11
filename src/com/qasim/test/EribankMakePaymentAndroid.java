package com.qasim.test;

import java.util.Random;

import com.experitest.client.Client;
import com.qasim.framework.BaseTest;
import com.qasim.framework.PlatformType;

public class EribankMakePaymentAndroid extends BaseTest
{
	@Override
	protected void setPaltformType()
	{
		platformType = PlatformType.ANDROID;
	}

	@Override
	public void runTest(Client client)
	{
		Random rand = new Random();
		int sumToPay = rand.nextInt(100);
		if (client.install(System.getProperty("user.dir") + "\\src\\sources\\eribank1.apk", true, true))
		{
			// If statement
		}
		client.launch("com.experitest.ExperiBank/.LoginActivity", true, true);
		client.elementSendText("NATIVE", "id=usernameTextField", 0, "company");
		client.elementSendText("NATIVE", "id=passwordTextField", 0, "company");
		client.click("NATIVE", "id=loginButton", 0, 1);
		
		String previousBalanceString = client.elementGetText("WEB", "xpath=//*[contains(@text,'balance')]" , 0);
		double previousBalance =  Double.parseDouble((previousBalanceString.split(":")[1]).replace("$", ""));
		
        client.click("NATIVE", "id=makePaymentButton", 0, 1);
        client.elementSendText("NATIVE", "id=phoneTextField", 0, "1234567890");
        client.elementSendText("NATIVE", "id=nameTextField", 0, "experitest");
        client.elementSendText("NATIVE", "id=amountTextField", 0, "" + sumToPay );
        client.click("NATIVE", "id=countryButton", 0, 1);
        client.click("NATIVE", "id=rowTextView", 0, 1);
        client.click("NATIVE", "id=sendPaymentButton", 0, 1);
        client.click("NATIVE", "id=button1", 0, 1);

		String futureBalanceString = client.elementGetText("WEB", "xpath=//*[contains(@text,'balance')]" , 0);
		double futureBalance =  Double.parseDouble((futureBalanceString.split(":")[1]).replace("$", ""));
		
		if((previousBalance - sumToPay) == futureBalance)
			System.out.println("Payment was made Successfully");
		else
			System.out.println("Payment Failed");
		
        client.click("NATIVE", "id=logoutButton", 0, 1);
	}
}
