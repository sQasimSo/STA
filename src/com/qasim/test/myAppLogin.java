package com.qasim.test;

import java.io.IOException;
import java.util.ArrayList;

import org.apache.commons.codec.binary.Base32;

import com.experitest.client.Client;
import com.qasim.framework.BaseTest;
import com.qasim.framework.PlatformType;

public class myAppLogin extends BaseTest
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

		ArrayList<String> usernames = new ArrayList<String>();
		ArrayList<String> passwords = new ArrayList<String>();
		try
		{
			readCSV(usernames, passwords);
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}

		if (client.install(System.getProperty("user.dir") + "\\src\\sources\\app-debug.apk", true, false))
		{
			// If statement
		}
		client.launch("com.experitest.qasimsobeh.task1/.LoginActivity", true, false);

		for (int i = 0; i < usernames.size(); i++)
		{
			client.sleep(1000);
			client.elementSendText("NATIVE", "xpath=//*[@id='editText_entry1']", 0, usernames.get(i));
			client.elementSendText("NATIVE", "xpath=//*[@id='editText_entry2']", 0, passwords.get(i));
			client.sleep(1000);
			client.click("NATIVE", "xpath=//*[@text='Confirm']", 0, 1);
			client.sleep(1000);
			if (client.isElementFound("NATIVE", "xpath=//*[@id='button_logout']", 0))
			{
				break;
			}
		}
		client.click("NATIVE", "xpath=//*[@id='button_logout']", 0, 1);
	}
}