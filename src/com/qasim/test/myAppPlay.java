package com.qasim.test;

import com.experitest.client.Client;
import com.qasim.framework.BaseTest;
import com.qasim.framework.PlatformType;

public class myAppPlay extends BaseTest
{
	@Override
	protected PlatformType getPaltformType()
	{
		return PlatformType.ANDROID;
	}

	@Override
	public void runTest(Client client)
	{
		if (client.install(System.getProperty("user.dir") + "\\src\\sources\\app-debug.apk", true, false))
		{
			// If statement
		}
		client.launch("com.experitest.qasimsobeh.task1/.LoginActivity", true, false);
		client.sleep(1000);

		client.elementSendText("myApp", "Entry1", 0, "q");
		client.elementSendText("myApp", "Entry2", 0, "q");
		client.sleep(1000);

		client.click("NATIVE", "xpath=//*[@text='Confirm']", 0, 1);
		client.sleep(1000);

		if (client.isElementFound("NATIVE", "xpath=//*[@id='button_logout']", 0))
		{
			client.sleep(1000);
			client.click("NATIVE", "xpath=//*[@id='button_play']", 0, 1);

			if (client.isElementFound("NATIVE", "xpath=//*[@id='permission_allow_button']", 0))
			{
				client.click("NATIVE", "xpath=//*[@id='permission_allow_button']", 0, 1);
			}

			client.sleep(1000);
			client.click("NATIVE", "xpath=//*[@id='button_startGame']", 0, 1);

			for (int i = 0; i < 3; i++)
			{
				client.click("NATIVE", "xpath=//*[@id='button_startGame']", 0, 1);
				// client.sleep(500 - (i * 50));
				for (int j = 0; j < (5 + i); j++)
					client.click("NATIVE", "xpath=//*[@id='imageButton']", 0, 1);

				client.sleep(3000);
			}
		}

		client.deviceAction("Back");
		client.click("NATIVE", "xpath=//*[@id='button_logout']", 0, 1);
	}
}
