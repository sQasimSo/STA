package com.qasim.test;

import com.experitest.client.Client;
import com.qasim.framework.BaseTest;
import com.qasim.framework.PlatformType;

public class CNNbIOS extends BaseTest
{
	@Override
	protected PlatformType getPaltformType()
	{
		return PlatformType.IOS;
	}

	@Override
	public void runTest(Client client)
	{
		client.launch("http://www.cnn.com", false, true);
		if (client.isElementFound("CNNb", "I agree", 0))
		{
			client.click("CNNb", "I agree", 0, 1);
		}
		client.click("WEB", "xpath=//*[@id='menu']", 0, 1);

		// Regions
		if (client.isElementFound("CNNb", "Regions", 0))
		{
			client.click("CNNb", "Regions", 0, 1);
		}

		if (client.isElementFound("CNNb", "Regions_Proof", 0))
		{
			// If statement
		}
		String str0 = client.hybridRunJavascript("", 0, "history.go(-1);");

		// USPolitics
		if (client.isElementFound("CNNb", "USPolitics", 0))
		{
			client.click("CNNb", "USPolitics", 0, 1);
		}

		if (client.isElementFound("CNNb", "USPolitics_proof", 0))
		{
			// If statement
		}
		String str1 = client.hybridRunJavascript("", 0, "history.go(-1);");

		// Money
		if (client.isElementFound("CNNb", "Money", 0))
		{
			client.click("CNNb", "Money", 0, 1);
		}

		if (client.isElementFound("CNNb", "Money_proof", 0))
		{
			// If statement
		}
		String str2 = client.hybridRunJavascript("", 0, "history.go(-1);");

		// Entertainment
		if (client.isElementFound("CNNb", "Entertainment", 0))
		{
			client.click("CNNb", "Entertainment", 0, 1);
		}

		if (client.isElementFound("CNNb", "Entertainment_proof", 0))
		{
			// If statement
		}
		String str3 = client.hybridRunJavascript("", 0, "history.go(-1);");

		// Tech
		if (client.isElementFound("CNNb", "Tech", 0))
		{
			client.click("CNNb", "Tech", 0, 1);
		}

		if (client.isElementFound("CNNb", "Tech_proof", 0))
		{
			// If statement
		}
		String str4 = client.hybridRunJavascript("", 0, "history.go(-1);");

		// Sport
		if (client.isElementFound("CNNb", "Sport", 0))
		{
			client.click("CNNb", "Sport", 0, 1);
		}

		if (client.isElementFound("CNNb", "Sport_Proof", 0))
		{
			// If statement
		}
		String str5 = client.hybridRunJavascript("", 0, "history.go(-1);");

		// Travel
		if (client.isElementFound("CNNb", "Travel", 0))
		{
			client.click("CNNb", "Travel", 0, 1);
		}

		if (client.isElementFound("CNNb", "travel_proof", 0))
		{
			// If statement
		}
		String str6 = client.hybridRunJavascript("", 0, "history.go(-1);");

		// Style
		if (client.isElementFound("CNNb", "Style", 0))
		{
			client.click("CNNb", "Style", 0, 1);
		}

		if (client.isElementFound("CNNb", "style_proof", 0))
		{
			// If statement
		}
		String str7 = client.hybridRunJavascript("", 0, "history.go(-1);");

		// Health
		if (client.isElementFound("CNNb", "Health", 0))
		{
			client.click("CNNb", "Health", 0, 1);
		}

		if (client.isElementFound("CNNb", "Health_proof", 0))
		{
			// If statement
		}
		String str8 = client.hybridRunJavascript("", 0, "history.go(-1);");

		// Features
		if (client.isElementFound("CNNb", "Features", 0))
		{
			client.click("CNNb", "Features", 0, 1);
		}

		if (client.isElementFound("CNNb", "Features_proof", 0))
		{
			// If statement
		}
		String str9 = client.hybridRunJavascript("", 0, "history.go(-1);");

		// Video
		if (client.isElementFound("CNNb", "Video", 0))
		{
			client.click("CNNb", "Video", 0, 1);
		}

		if (client.isElementFound("CNNb", "Video_proof", 0))
		{
			// If statement
		}
		String str10 = client.hybridRunJavascript("", 0, "history.go(-1);");

		// VR
		if (client.isElementFound("CNNb", "VR", 0))
		{
			client.click("CNNb", "VR", 0, 1);
		}

		if (client.isElementFound("CNNb", "VR_proof", 0))
		{
			// If statement
		}
		String str11 = client.hybridRunJavascript("", 0, "history.go(-1);");

		// More
		if (client.isElementFound("CNNb", "More", 0))
		{
			client.click("CNNb", "More", 0, 1);
		}

		if (client.isElementFound("CNNb", "More_proof", 0))
		{
			// If statement
		}
		String str12 = client.hybridRunJavascript("", 0, "history.go(-1);");
		client.hybridClearCache(true, true);
	}
}
