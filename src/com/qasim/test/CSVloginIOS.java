package com.qasim.test;

import com.experitest.client.Client;
import com.qasim.framework.BaseTest;
import com.qasim.framework.PlatformType;

import java.io.IOException;
import java.util.ArrayList;

public class CSVloginIOS extends BaseTest
{
	@Override
	protected void setPaltformType()
	{
		platformType = PlatformType.IOS;
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
		} catch (IOException e)
		{
			e.printStackTrace();
		}

		client.openDevice();

		if (client.install(System.getProperty("user.dir") + "\\src\\sources\\eribankIOS.ipa", true, true))
		{
			// If statement
		}

		client.launch("com.experitest.ExperiBank", true, true);

		for (int i = 0; i < usernames.size(); i++)
		{
			client.elementSendText("CSVloginIOS", "Username", 0, usernames.get(i));
			client.elementSendText("CSVloginIOS", "Password", 0, passwords.get(i));
			client.click("NATIVE", "xpath=//*[@text='Login']", 0, 1);

			if (client.isElementFound("CSVloginIOS", "Dismiss", 0))
			{
				client.click("CSVloginIOS", "Dismiss", 0, 1);
			} else
			{
				if (client.isElementFound("CSVloginIOS", "Logout", 0))
				{
					this.status = "succeeded";
				}
			}
		}
	}
}
