package com.qasim.test;

import com.experitest.client.Client;
import com.qasim.framework.BaseTest;
import com.qasim.framework.PlatformType;

public class downloadAppIOS extends BaseTest
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
		client.launch("com.apple.AppStore", false, true);
        client.click("downloadAppIOS", "SearchElement", 0, 1);
        client.click("downloadAppIOS", "searchBar", 0, 1);
        client.elementSendText("downloadAppIOS", "searchBar", 0, "Empire");
        client.click("downloadAppIOS", "searchButton", 0, 1);
        client.click("downloadAppIOS", "GetButton", 0, 1);
        client.click("downloadAppIOS", "Install", 0, 1);
        client.sleep(90000);
        if(client.uninstall("com.goodgamestudios.empirefourkingdoms ")){
            // If statement
        }
	}
}
