package com.qasim.test;

import com.experitest.client.Client;
import com.qasim.framework.BaseTest;
import com.qasim.framework.PlatformType;

public class topTenAppsIOS extends BaseTest
{
	@Override
	protected void setPaltformType()
	{
		platformType = PlatformType.IOS;
	}

	@SuppressWarnings("deprecation")
	@Override
	public void runTest(Client client)
	{
		//IOS devices gets disconnected!
		System.out.println(getClass().getName() + ": test()");

		int change = 1;
		boolean iflag = false;
		String s = "Top 10 APP : \n", temp = "", lastapp = "";
		String[] sArray;
		int count = 0, i = 0;
		boolean ExceptionPassed = true;

		String screenSize = "";
		screenSize = client.getDeviceProperty("device.screensize");
		screenSize = screenSize.split("x")[0];
		int swipDown = Integer.parseInt(screenSize);

		client.launch("com.apple.AppStore", true, true);
		client.sleep(10000);

		client.click("NATIVE", "xpath=//*[@text='Top Charts']", 0, 1);

		if (client.isElementFound("NATIVE", "xpath=//*[@text='Cancel']"))
		{
			client.click("NATIVE", "xpath=//*[@text='Cancel']", 0, 1);
		}

		if (!client.getDeviceProperty("device.category").equals("TABLET"))
		{

			client.click("NATIVE", "xpath=//*[@text='Free']", 0, 1);
			if (client.isElementFound("NATIVE", "xpath=//*[@text='Free' and @class='UIACollectionView']"))
			{
				s = client.getTextIn("NATIVE", "xpath=//*[@value='Free' and @class='UIACollectionView']", 0, "Down", 0,
						0);
				change = 2;
			}
			else
			{
				s = client.getTextIn("NATIVE", "xpath=//*[@text='Free']", 0, "Down", 0, 0);
			}

			sArray = s.split("\n");
			for (i = 1; i < sArray.length + 1; i++)
			{
				temp = sArray[(change * i) - 1];
				if ((!temp.equals("Categories	Top Charts	Search	")))
				{
					count++;
				}
				else
				{
					iflag = true;
				}
			}
			if (iflag)
			{
				i--;
				temp = sArray[count - 1];
			}

			while (count < 10 && client.isElementFound("NATIVE", "xpath=//*[@text='Free']"))
			{

				int length = temp.length();
				temp = temp.substring(0, length - 1);

				client.swipe("Down", swipDown / 2, 9900);
				// client.swipe("Down", 800,9900);

				if (temp.contains("GET") || temp.contains("Download"))
				{

					String[] tt;
					if (temp.contains("GET"))
					{
						temp = temp.split("")[0];
					}
					{
						if (temp.contains("Download"))
						{
							temp = temp.split("Download")[0];
						}
					}
					tt = temp.split("	");
					temp = tt[0];
				}

				if ((client.isElementFound("NATIVE", "xpath=//*[@text='" + temp + "']")))
				{

					s = client.getTextIn("NATIVE", "xpath=//*[@text='" + temp + "']", 0, "Down", 0, 0);

					sArray = s.split("\n");
					for (int j = 0; ((j < sArray.length) && count < 10); j++)
					{
						temp = sArray[(change * j)];

						if (String.valueOf(temp.split(",")[0]).equals(String.valueOf(count + 1)))
						{
							count++;
							lastapp = temp;
						}
						else
						{
							temp = lastapp;
						}
					}
				}

			}

		}
	}
}