package com.qasim.test;

import com.experitest.client.Client;
import com.qasim.framework.BaseTest;
import com.qasim.framework.PlatformType;

public class topTenAppsAndroid extends BaseTest
{
	@Override
	protected void setPaltformType()
	{
		platformType = PlatformType.ANDROID;
	}

	@SuppressWarnings("deprecation")
	@Override
	public void runTest(Client client)
	{
		System.out.println(getClass().getName() + ": test()");
		String s = "";
		String result = "";

		client.launch("com.android.vending/.AssetBrowserActivity", false, true);

		if (client.isElementFound("NATIVE", "xpath=//*[@contentDescription='Top Charts']"))
		{
			client.click("NATIVE", "xpath=//*[@contentDescription='Top Charts']", 0, 1);
			client.sleep(30000);
			for (int i = 1; i < 11; i++)
			{
				s = client.getTextIn("NATIVE", "xpath=//*[@text='" + i + "' and @width>0]", 0, "TEXT", "Right", 0, 0);
				if (s.equals("P FREE APPS TOP FREE GAMES TOP GROSSI "))
				{
					System.out.println("got here 1");
					s = client.getTextIn("NATIVE", "xpath=//*[@id='play_header_list_tab_container']", 0, "Down", 0, 0);
					System.out.println("got here 2");
				}
				s = s.split("\n")[0];
				result = i + " - " + s + "\n";
				if (i == 5)
				{
					client.swipe("Down", 30, 50);
					client.sleep(30000);
				}
			}
		}
	}
}