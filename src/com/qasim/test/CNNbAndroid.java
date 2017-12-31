package com.qasim.test;

import com.experitest.client.Client;
import com.qasim.framework.BaseTest;
import com.qasim.framework.PlatformType;

public class CNNbAndroid extends BaseTest
{
	@Override
	protected PlatformType getPaltformType()
	{
		return PlatformType.ANDROID;
	}

	@Override
	public void runTest(Client client)
	{
		client.launch("http://www.cnn.com", false, true);
		// if (client.isElementFound("WEB", "xpath=//*[@text='I agree']", 0))
		// {
		// client.click("WEB", "xpath=//*[@text='I agree']", 0, 1);
		// }
		// client.click("WEB", "xpath=//*[@nodeName='DIV' and @width>0 and
		// ./parent::*[@id='menu']]", 0, 1);
		// client.click("WEB", "xpath=//*[@text='Regions' and @nodeName='A' and
		// ./parent::*[@nodeName='DIV']]", 0, 1);
		// if (client.isElementFound("WEB", "xpath=//*[@text='Regions' and
		// @nodeName='H2']", 0))
		// {
		// // If statement
		// }
		// String str1 = client.hybridRunJavascript("", 0, "history.go(-1);");
		// client.click("WEB", "xpath=//*[@nodeName='DIV' and @width>0 and
		// ./parent::*[@id='menu']]", 0, 1);
		// client.click("WEB", "xpath=//*[@text='U.S. Politics' and
		// @nodeName='A' and ./parent::*[@nodeName='DIV']]", 0,
		// 1);
		// if (client.isElementFound("WEB",
		// "xpath=(((//*[@nodeName='DIV' and
		// ./parent::*[@id='nav']]/*[@nodeName='DIV'])[1]/*/*[@nodeName='DIV'
		// and ./parent::*[@nodeName='DIV']])[1]/*[@nodeName='A' and
		// @width>0])[2]",
		// 0))
		// {
		// // If statement
		// }
		// String str2 = client.hybridRunJavascript("", 0, "history.go(-1);");
		// client.click("WEB", "xpath=//*[@nodeName='DIV' and @width>0 and
		// ./parent::*[@id='menu']]", 0, 1);
		// client.click("WEB",
		// "xpath=(//*[@id='nav-expanded-menu' and
		// @nodeName='DIV']/*/*/*[@nodeName='IMG' and ./parent::*[@nodeName='A'
		// and @width>0 and ./parent::*[@nodeName='DIV']]])[1]",
		// 0, 1);
		// if (client.isElementFound("WEB", "xpath=//*[@nodeName='SPAN' and
		// ./parent::*[@text=' ' and @nodeName='A']]",
		// 0))
		// {
		// // If statement
		// }
		// String str3 = client.hybridRunJavascript("", 0, "history.go(-1);");
		// client.click("WEB", "xpath=//*[@nodeName='DIV' and @width>0 and
		// ./parent::*[@id='menu']]", 0, 1);
		// client.click("WEB",
		// "xpath=(//*[@id='nav-expanded-menu' and
		// @nodeName='DIV']/*/*/*[@nodeName='IMG' and ./parent::*[@nodeName='A'
		// and @width>0 and ./parent::*[@nodeName='DIV']]])[2]",
		// 0, 1);
		// if (client.isElementFound("WEB",
		// "xpath=(//*[@nodeName='NAV' and
		// ./parent::*[@nodeName='DIV']]/*[@nodeName='A' and @width>0])[2]", 0))
		// {
		// // If statement
		// }
		// String str4 = client.hybridRunJavascript("", 0, "history.go(-1);");
		// client.click("WEB", "xpath=//*[@nodeName='DIV' and @width>0 and
		// ./parent::*[@id='menu']]", 0, 1);
		// client.click("WEB",
		// "xpath=(//*[@id='nav-expanded-menu' and
		// @nodeName='DIV']/*/*/*[@nodeName='IMG' and ./parent::*[@nodeName='A'
		// and @width>0 and ./parent::*[@nodeName='DIV']]])[3]",
		// 0, 1);
		// if (client.isElementFound("WEB",
		// "xpath=(((//*[@nodeName='DIV' and ./parent::*[@nodeName='DIV' and
		// ./parent::*[@id='root']]]/*/*/*/*[@nodeName='DIV' and
		// ./parent::*[@nodeName='DIV' and ./parent::*[@nodeName='DIV' and
		// ./parent::*[@nodeName='DIV']]]])[1]/*[@nodeName='DIV'])[1]/*[@nodeName='A'
		// and @width>0])[2]",
		// 0))
		// {
		// // If statement
		// }
		// String str5 = client.hybridRunJavascript(
		// "xpath=(((//*[@nodeName='DIV' and ./parent::*[@nodeName='DIV' and
		// ./parent::*[@id='root']]]/*/*/*/*[@nodeName='DIV' and
		// ./parent::*[@nodeName='DIV' and ./parent::*[@nodeName='DIV' and
		// ./parent::*[@nodeName='DIV']]]])[1]/*[@nodeName='DIV'])[1]/*[@nodeName='A'
		// and @width>0])[2]",
		// 0, "history.go(-1);");
		// client.click("WEB", "xpath=//*[@nodeName='DIV' and @width>0 and
		// ./parent::*[@id='menu']]", 0, 1);
		// client.click("WEB", "xpath=//*[@text='Sport' and @nodeName='A' and
		// ./parent::*[@nodeName='DIV']]", 0, 1);
		// if (client.isElementFound("WEB", "xpath=//*[@text='Sport' and
		// @nodeName='H2']", 0))
		// {
		// // If statement
		// }
		// String str6 = client.hybridRunJavascript(
		// "xpath=(((//*[@nodeName='DIV' and ./parent::*[@nodeName='DIV' and
		// ./parent::*[@id='root']]]/*/*/*/*[@nodeName='DIV' and
		// ./parent::*[@nodeName='DIV' and ./parent::*[@nodeName='DIV' and
		// ./parent::*[@nodeName='DIV']]]])[1]/*[@nodeName='DIV'])[1]/*[@nodeName='A'
		// and @width>0])[2]",
		// 0, "history.go(-1);");
		// client.click("WEB", "xpath=//*[@nodeName='DIV' and @width>0 and
		// ./parent::*[@id='menu']]", 0, 1);
		// client.click("WEB",
		// "xpath=(//*[@id='nav-expanded-menu' and
		// @nodeName='DIV']/*/*/*[@nodeName='IMG' and ./parent::*[@nodeName='A'
		// and @width>0 and ./parent::*[@nodeName='DIV']]])[4]",
		// 0, 1);
		// if (client.isElementFound("WEB",
		// "xpath=(((//*[@nodeName='DIV' and
		// ./parent::*[@id='mount']]/*/*/*/*/*[@nodeName='DIV' and
		// ./parent::*[@nodeName='DIV' and ./parent::*[@nodeName='DIV' and
		// ./parent::*[@nodeName='DIV' and
		// ./parent::*[@nodeName='DIV']]]]])[1]/*[@nodeName='DIV'])[1]/*[@nodeName='A'
		// and @width>0])[2]",
		// 0))
		// {
		// // If statement
		// }
		// String str7 = client.hybridRunJavascript(
		// "xpath=(((//*[@nodeName='DIV' and ./parent::*[@nodeName='DIV' and
		// ./parent::*[@id='root']]]/*/*/*/*[@nodeName='DIV' and
		// ./parent::*[@nodeName='DIV' and ./parent::*[@nodeName='DIV' and
		// ./parent::*[@nodeName='DIV']]]])[1]/*[@nodeName='DIV'])[1]/*[@nodeName='A'
		// and @width>0])[2]",
		// 0, "history.go(-1);");
		// client.click("WEB", "xpath=//*[@nodeName='DIV' and @width>0 and
		// ./parent::*[@id='menu']]", 0, 1);
		// client.click("WEB",
		// "xpath=(//*[@id='nav-expanded-menu' and
		// @nodeName='DIV']/*/*/*[@nodeName='IMG' and ./parent::*[@nodeName='A'
		// and @width>0 and ./parent::*[@nodeName='DIV']]])[5]",
		// 0, 1);
		// if (client.isElementFound("WEB",
		// "xpath=(((//*[@nodeName='DIV' and
		// ./parent::*[@id='mount']]/*/*/*/*/*[@nodeName='DIV' and
		// ./parent::*[@nodeName='DIV' and ./parent::*[@nodeName='DIV' and
		// ./parent::*[@nodeName='DIV' and
		// ./parent::*[@nodeName='DIV']]]]])[1]/*[@nodeName='DIV'])[1]/*[@nodeName='A'
		// and @width>0])[2]",
		// 0))
		// {
		// // If statement
		// }
		// String str8 = client.hybridRunJavascript(
		// "xpath=(((//*[@nodeName='DIV' and ./parent::*[@nodeName='DIV' and
		// ./parent::*[@id='root']]]/*/*/*/*[@nodeName='DIV' and
		// ./parent::*[@nodeName='DIV' and ./parent::*[@nodeName='DIV' and
		// ./parent::*[@nodeName='DIV']]]])[1]/*[@nodeName='DIV'])[1]/*[@nodeName='A'
		// and @width>0])[2]",
		// 0, "history.go(-1);");
		// client.click("WEB", "xpath=//*[@nodeName='DIV' and @width>0 and
		// ./parent::*[@id='menu']]", 0, 1);
		// client.click("WEB", "xpath=//*[@text='Health' and @nodeName='A' and
		// ./parent::*[@nodeName='DIV']]", 0, 1);
		// if (client.isElementFound("WEB", "xpath=//*[@text='Health' and
		// @nodeName='H2']", 0))
		// {
		// // If statement
		// }
		// String str9 = client.hybridRunJavascript(
		// "xpath=(((//*[@nodeName='DIV' and ./parent::*[@nodeName='DIV' and
		// ./parent::*[@id='root']]]/*/*/*/*[@nodeName='DIV' and
		// ./parent::*[@nodeName='DIV' and ./parent::*[@nodeName='DIV' and
		// ./parent::*[@nodeName='DIV']]]])[1]/*[@nodeName='DIV'])[1]/*[@nodeName='A'
		// and @width>0])[2]",
		// 0, "history.go(-1);");
		// client.click("WEB", "xpath=//*[@nodeName='DIV' and @width>0 and
		// ./parent::*[@id='menu']]", 0, 1);
		// client.click("WEB", "xpath=//*[@text='Features' and @nodeName='A' and
		// ./parent::*[@nodeName='DIV']]", 0, 1);
		// if (client.isElementFound("WEB", "xpath=//*[@text='Special
		// Features']", 0))
		// {
		// // If statement
		// }
		// String str10 = client.hybridRunJavascript(
		// "xpath=(((//*[@nodeName='DIV' and ./parent::*[@nodeName='DIV' and
		// ./parent::*[@id='root']]]/*/*/*/*[@nodeName='DIV' and
		// ./parent::*[@nodeName='DIV' and ./parent::*[@nodeName='DIV' and
		// ./parent::*[@nodeName='DIV']]]])[1]/*[@nodeName='DIV'])[1]/*[@nodeName='A'
		// and @width>0])[2]",
		// 0, "history.go(-1);");
		// client.click("WEB", "xpath=//*[@nodeName='DIV' and @width>0 and
		// ./parent::*[@id='menu']]", 0, 1);
		// client.click("WEB", "xpath=//*[@text='Video' and @nodeName='A' and
		// ./parent::*[@nodeName='DIV']]", 0, 1);
		// if (client.isElementFound("WEB", "xpath=//*[@text='Video' and
		// @nodeName='A' and ./parent::*[@nodeName='DIV']]",
		// 0))
		// {
		// // If statement
		// }
		// String str11 = client.hybridRunJavascript(
		// "xpath=(((//*[@nodeName='DIV' and ./parent::*[@nodeName='DIV' and
		// ./parent::*[@id='root']]]/*/*/*/*[@nodeName='DIV' and
		// ./parent::*[@nodeName='DIV' and ./parent::*[@nodeName='DIV' and
		// ./parent::*[@nodeName='DIV']]]])[1]/*[@nodeName='DIV'])[1]/*[@nodeName='A'
		// and @width>0])[2]",
		// 0, "history.go(-1);");
		// client.click("WEB", "xpath=//*[@nodeName='DIV' and @width>0 and
		// ./parent::*[@id='menu']]", 0, 1);
		// client.click("WEB",
		// "xpath=(//*[@id='nav-expanded-menu' and
		// @nodeName='DIV']/*/*/*[@nodeName='IMG' and ./parent::*[@nodeName='A'
		// and @width>0 and ./parent::*[@nodeName='DIV']]])[6]",
		// 0, 1);
		// if (client.isElementFound("WEB",
		// "xpath=(//*[@nodeName='NAV' and
		// ./parent::*[@nodeName='DIV']]/*[@nodeName='A' and @width>0])[2]", 0))
		// {
		// // If statement
		// }
		// String str12 = client.hybridRunJavascript(
		// "xpath=(((//*[@nodeName='DIV' and ./parent::*[@nodeName='DIV' and
		// ./parent::*[@id='root']]]/*/*/*/*[@nodeName='DIV' and
		// ./parent::*[@nodeName='DIV' and ./parent::*[@nodeName='DIV' and
		// ./parent::*[@nodeName='DIV']]]])[1]/*[@nodeName='DIV'])[1]/*[@nodeName='A'
		// and @width>0])[2]",
		// 0, "history.go(-1);");
		// client.click("WEB", "xpath=//*[@nodeName='DIV' and @width>0 and
		// ./parent::*[@id='menu']]", 0, 1);
		// client.click("WEB", "xpath=//*[@text='More…' and @nodeName='A' and
		// ./parent::*[@nodeName='DIV']]", 0, 1);
		// if (client.isElementFound("WEB", " xpath=//*[@text='Intl - More' and
		// @nodeName='H2']", 0))
		// {
		// // If statement
		// }
		// String str13 = client.hybridRunJavascript(
		// "xpath=(((//*[@nodeName='DIV' and ./parent::*[@nodeName='DIV' and
		// ./parent::*[@id='root']]]/*/*/*/*[@nodeName='DIV' and
		// ./parent::*[@nodeName='DIV' and ./parent::*[@nodeName='DIV' and
		// ./parent::*[@nodeName='DIV']]]])[1]/*[@nodeName='DIV'])[1]/*[@nodeName='A'
		// and @width>0])[2]",
		// 0, "history.go(-1);");
		// client.hybridClearCache(true, true);
		if (client.isElementFound("WEB", "xpath=//*[@text='I agree']", 0))
		{
			client.click("WEB", "xpath=//*[@text='I agree']", 0, 1);
		}
		client.click("WEB", "xpath=//*[@nodeName='DIV' and @width>0 and ./parent::*[@id='menu']]", 0, 1);

		client.sleep(3000);
		client.click("WEB", "xpath=//*[@text='Regions' and @nodeName='A' and ./parent::*[@nodeName='DIV']]", 0, 1);
		if (client.isElementFound("WEB", "xpath=//*[@text='Regions' and @nodeName='H2']", 0))
		{

		}
		String str1 = client.hybridRunJavascript("", 0, "history.go(-1);");
		client.sleep(3000);

		if (!client.isElementFound("WEB", "xpath=//*[@text='Regions' and @nodeName='H2']", 0))
		{
			client.click("WEB", "xpath=//*[@nodeName='DIV' and @width>0 and ./parent::*[@id='menu']]", 0, 1);
		}
		client.sleep(3000);
		client.click("WEB", "xpath=//*[@text='U.S. Politics' and @nodeName='A' and ./parent::*[@nodeName='DIV']]", 0,
				1);
		if (client.isElementFound("WEB",
				"xpath=(((//*[@nodeName='DIV' and ./parent::*[@id='nav']]/*[@nodeName='DIV'])[1]/*/*[@nodeName='DIV' and ./parent::*[@nodeName='DIV']])[1]/*[@nodeName='A' and @width>0])[2]",
				0))
		{
			// If statement
		}
		String str2 = client.hybridRunJavascript("", 0, "history.go(-1);");
		client.sleep(3000);
		if (!client.isElementFound("WEB", "xpath=//*[@text='Regions' and @nodeName='H2']", 0))
		{
			client.click("WEB", "xpath=//*[@nodeName='DIV' and @width>0 and ./parent::*[@id='menu']]", 0, 1);
		}
		client.sleep(3000);
		client.click("WEB",
				"xpath=(//*[@id='nav-expanded-menu' and @nodeName='DIV']/*/*/*[@nodeName='IMG' and ./parent::*[@nodeName='A' and @width>0 and ./parent::*[@nodeName='DIV']]])[1]",
				0, 1);
		if (client.isElementFound("WEB", "xpath=//*[@nodeName='SPAN' and ./parent::*[@text='  ' and @nodeName='A']]",
				0))
		{
			// If statement
		}
		String str3 = client.hybridRunJavascript("", 0, "history.go(-1);");
		client.sleep(3000);
		if (!client.isElementFound("WEB", "xpath=//*[@text='Regions' and @nodeName='H2']", 0))
		{
			client.click("WEB", "xpath=//*[@nodeName='DIV' and @width>0 and ./parent::*[@id='menu']]", 0, 1);
		}
		client.sleep(3000);
		client.click("WEB",
				"xpath=(//*[@id='nav-expanded-menu' and @nodeName='DIV']/*/*/*[@nodeName='IMG' and ./parent::*[@nodeName='A' and @width>0 and ./parent::*[@nodeName='DIV']]])[2]",
				0, 1);
		if (client.isElementFound("WEB",
				"xpath=(//*[@nodeName='NAV' and ./parent::*[@nodeName='DIV']]/*[@nodeName='A' and @width>0])[2]", 0))
		{
			// If statement
		}
		String str4 = client.hybridRunJavascript("", 0, "history.go(-1);");
		client.sleep(3000);

		if (!client.isElementFound("WEB", "xpath=//*[@text='Regions' and @nodeName='H2']", 0))
		{
			client.click("WEB", "xpath=//*[@nodeName='DIV' and @width>0 and ./parent::*[@id='menu']]", 0, 1);
		}
		client.sleep(3000);
		client.click("WEB",
				"xpath=(//*[@id='nav-expanded-menu' and @nodeName='DIV']/*/*/*[@nodeName='IMG' and ./parent::*[@nodeName='A' and @width>0 and ./parent::*[@nodeName='DIV']]])[3]",
				0, 1);
		if (client.isElementFound("WEB",
				"xpath=(((//*[@nodeName='DIV' and ./parent::*[@nodeName='DIV' and ./parent::*[@id='root']]]/*/*/*/*[@nodeName='DIV' and ./parent::*[@nodeName='DIV' and ./parent::*[@nodeName='DIV' and ./parent::*[@nodeName='DIV']]]])[1]/*[@nodeName='DIV'])[1]/*[@nodeName='A' and @width>0])[2]",
				0))
		{
			// If statement
		}
		String str5 = client.hybridRunJavascript("", 0, "history.go(-1);");
		client.sleep(3000);

		if (!client.isElementFound("WEB", "xpath=//*[@text='Regions' and @nodeName='H2']", 0))
		{
			client.click("WEB", "xpath=//*[@nodeName='DIV' and @width>0 and ./parent::*[@id='menu']]", 0, 1);
		}
		client.sleep(3000);
		client.click("WEB", "xpath=//*[@text='Sport' and @nodeName='A' and ./parent::*[@nodeName='DIV']]", 0, 1);
		if (client.isElementFound("WEB", "xpath=//*[@text='Sport' and @nodeName='H2']", 0))
		{
			// If statement
		}
		String str6 = client.hybridRunJavascript("", 0, "history.go(-1);");
		client.sleep(3000);
		if (!client.isElementFound("WEB", "xpath=//*[@text='Regions' and @nodeName='H2']", 0))
		{
			client.click("WEB", "xpath=//*[@nodeName='DIV' and @width>0 and ./parent::*[@id='menu']]", 0, 1);
		}
		client.sleep(3000);

		client.click("WEB",
				"xpath=(//*[@id='nav-expanded-menu' and @nodeName='DIV']/*/*/*[@nodeName='IMG' and ./parent::*[@nodeName='A' and @width>0 and ./parent::*[@nodeName='DIV']]])[4]",
				0, 1);
		if (client.isElementFound("WEB",
				"xpath=(((//*[@nodeName='DIV' and ./parent::*[@id='mount']]/*/*/*/*/*[@nodeName='DIV' and ./parent::*[@nodeName='DIV' and ./parent::*[@nodeName='DIV' and ./parent::*[@nodeName='DIV' and ./parent::*[@nodeName='DIV']]]]])[1]/*[@nodeName='DIV'])[1]/*[@nodeName='A' and @width>0])[2]",
				0))
		{
			// If statement
		}
		String str7 = client.hybridRunJavascript("", 0, "history.go(-1);");
		client.sleep(3000);

		if (!client.isElementFound("WEB", "xpath=//*[@text='Regions' and @nodeName='H2']", 0))
		{
			client.click("WEB", "xpath=//*[@nodeName='DIV' and @width>0 and ./parent::*[@id='menu']]", 0, 1);
		}
		client.sleep(3000);

		client.click("WEB",
				"xpath=(//*[@id='nav-expanded-menu' and @nodeName='DIV']/*/*/*[@nodeName='IMG' and ./parent::*[@nodeName='A' and @width>0 and ./parent::*[@nodeName='DIV']]])[5]",
				0, 1);
		if (client.isElementFound("WEB",
				"xpath=(((//*[@nodeName='DIV' and ./parent::*[@id='mount']]/*/*/*/*/*[@nodeName='DIV' and ./parent::*[@nodeName='DIV' and ./parent::*[@nodeName='DIV' and ./parent::*[@nodeName='DIV' and ./parent::*[@nodeName='DIV']]]]])[1]/*[@nodeName='DIV'])[1]/*[@nodeName='A' and @width>0])[2]",
				0))
		{
			// If statement
		}
		String str8 = client.hybridRunJavascript("", 0, "history.go(-1);");
		client.sleep(3000);

		if (!client.isElementFound("WEB", "xpath=//*[@text='Regions' and @nodeName='H2']", 0))
		{
			client.click("WEB", "xpath=//*[@nodeName='DIV' and @width>0 and ./parent::*[@id='menu']]", 0, 1);
		}
		client.sleep(3000);

		client.click("WEB", "xpath=//*[@text='Health' and @nodeName='A' and ./parent::*[@nodeName='DIV']]", 0, 1);
		if (client.isElementFound("WEB", "xpath=//*[@text='Health' and @nodeName='H2']", 0))
		{
			// If statement
		}
		String str9 = client.hybridRunJavascript("", 0, "history.go(-1);");
		client.sleep(3000);

		if (!client.isElementFound("WEB", "xpath=//*[@text='Regions' and @nodeName='H2']", 0))
		{
			client.click("WEB", "xpath=//*[@nodeName='DIV' and @width>0 and ./parent::*[@id='menu']]", 0, 1);
		}
		client.sleep(3000);

		client.click("WEB", "xpath=//*[@text='Features' and @nodeName='A' and ./parent::*[@nodeName='DIV']]", 0, 1);
		if (client.isElementFound("WEB", "xpath=//*[@text='Special Features']", 0))
		{
			// If statement
		}
		String str10 = client.hybridRunJavascript("", 0, "history.go(-1);");
		client.sleep(3000);

		if (!client.isElementFound("WEB", "xpath=//*[@text='Regions' and @nodeName='H2']", 0))
		{
			client.click("WEB", "xpath=//*[@nodeName='DIV' and @width>0 and ./parent::*[@id='menu']]", 0, 1);
		}
		client.sleep(3000);

		client.click("WEB", "xpath=//*[@text='Video' and @nodeName='A' and ./parent::*[@nodeName='DIV']]", 0, 1);
		if (client.isElementFound("WEB", "xpath=//*[@text='Video' and @nodeName='A' and ./parent::*[@nodeName='DIV']]",
				0))
		{
			// If statement
		}
		String str11 = client.hybridRunJavascript("", 0, "history.go(-1);");
		client.sleep(3000);

		if (!client.isElementFound("WEB", "xpath=//*[@text='Regions' and @nodeName='H2']", 0))
		{
			client.click("WEB", "xpath=//*[@nodeName='DIV' and @width>0 and ./parent::*[@id='menu']]", 0, 1);
		}
		client.sleep(3000);

		client.click("WEB",
				"xpath=(//*[@id='nav-expanded-menu' and @nodeName='DIV']/*/*/*[@nodeName='IMG' and ./parent::*[@nodeName='A' and @width>0 and ./parent::*[@nodeName='DIV']]])[6]",
				0, 1);
		if (client.isElementFound("WEB",
				"xpath=(//*[@nodeName='NAV' and ./parent::*[@nodeName='DIV']]/*[@nodeName='A' and @width>0])[2]", 0))
		{
			// If statement
		}
		String str12 = client.hybridRunJavascript("", 0, "history.go(-1);");
		client.sleep(3000);

		if (!client.isElementFound("WEB", "xpath=//*[@text='Regions' and @nodeName='H2']", 0))
		{
			client.click("WEB", "xpath=//*[@nodeName='DIV' and @width>0 and ./parent::*[@id='menu']]", 0, 1);
		}
		client.sleep(3000);

		client.click("WEB", "xpath=//*[@text='More…' and @nodeName='A' and ./parent::*[@nodeName='DIV']]", 0, 1);
		if (client.isElementFound("WEB", " xpath=//*[@text='Intl - More' and @nodeName='H2']", 0))
		{
			// If statement
		}
		String str13 = client.hybridRunJavascript("", 0, "history.go(-1);");
		client.sleep(3000);

		client.hybridClearCache(true, true);
	}
}
