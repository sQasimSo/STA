package com.qasim.test;

import com.experitest.client.Client;
import com.qasim.framework.BaseTest;
import com.qasim.framework.PlatformType;

public class downloadAppAndroid extends BaseTest
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
		client.launch("com.android.vending/.AssetBrowserActivity", false, true);
        client.click("downloadAppAndroid", "search_box_idle_text", 0, 1);
        client.elementSendText("downloadAppAndroid", "Search Google Play", 0, "Empire");
        client.click("downloadAppAndroid", "search_icon", 0, 1);
        client.click("downloadAppAndroid", "li_thumbnail", 0, 1);
        client.click("downloadAppAndroid", "INSTALL", 0, 1);
        client.sleep(60000);
        client.launch("com.android.vending/.AssetBrowserActivity", false, true);
        client.click("downloadAppAndroid", "search_box_idle_text", 0, 1);
        client.elementSendText("downloadAppAndroid", "Search Google Play", 0, "Empire");
        client.click("downloadAppAndroid", "search_icon", 0, 1);
        client.click("downloadAppAndroid", "li_thumbnail", 0, 1);
        client.click("downloadAppAndroid", "UNINSTALL", 0, 1);
        client.click("downloadAppAndroid", "OK", 0, 1);
	}
}
