package com.qasim.test;

import com.experitest.client.Client;
import com.qasim.framework.BaseTest;
import com.qasim.framework.PlatformType;

public class ebayProfitListingUpgrades extends BaseTest
{

	@Override
	public void runTest(Client client)
	{
		client.launch("com.android.vending/.AssetBrowserActivity", false, true);
		client.click("NATIVE", "xpath=//*[@id='search_box_idle_text']", 0, 1);
		client.elementSendText("NATIVE", "xpath=//*[@id='search_box_text_input']", 0, "ebay profit");
		client.click("NATIVE", "xpath=//*[@id='suggest_text']", 0, 1);
		client.click("NATIVE", "xpath=//*[@text='eBay Seller Profit Calculator']", 0, 1);
		if (client.isElementFound("NATIVE", "xpath=//*[@text='INSTALL']"))
		{
			client.click("NATIVE", "xpath=//*[@text='INSTALL']", 0, 1);
		}
		if (client.waitForElement("NATIVE", "xpath=//*[@text='OPEN']", 0, 30000))
		{
			client.click("NATIVE", "xpath=//*[@text='OPEN']", 0, 1);
		}
		
		client.swipe("Up", 500, 500);
		if (client.swipeWhileNotFound("Up", 0, 500, "NATIVE", "xpath=//*[@text='Fixed price']", 0, 1000, 5, true)){}		
		client.elementSendText("NATIVE", "xpath=//*[@id='item_cost_edit_text']", 0, "5");
		client.elementSendText("NATIVE", "xpath=//*[@id='shipping_cost_edit_text']", 0, "2");
		client.elementSendText("NATIVE", "xpath=//*[@id='sale_price_edit_text']", 0, "10");
		client.elementSendText("NATIVE", "xpath=//*[@id='buyer_shipping_price_edit_text']", 0, "2");
		
		client.swipe("Down", 30, 500);
		if (!client.isElementFound("NATIVE", "xpath=//*[@text='International']"))
		{
			if (client.swipeWhileNotFound("Down", 0, 500, "NATIVE", "xpath=//*[@text='Listing Upgrades']", 0, 1000, 5, true)){}
		}
		else
		{
			client.swipe("Down", 30, 500);
		}
		if (client.swipeWhileNotFound("Down", 0, 500, "NATIVE", "xpath=//*[@text='International']", 0, 1000, 5, true)){}
		if (client.swipeWhileNotFound("Down", 0, 500, "NATIVE", "xpath=//*[@text='Reserve price']", 0, 1000, 5, true)){}
		if (client.swipeWhileNotFound("Down", 0, 500, "NATIVE", "xpath=//*[@text='Scheduled']", 0, 1000, 5, true)){}
		if (client.swipeWhileNotFound("Down", 0, 500, "NATIVE", "xpath=//*[@text='Bold']", 0, 1000, 5, true)){}
		if (client.swipeWhileNotFound("Down", 0, 500, "NATIVE", "xpath=//*[@text='Subtitle']", 0, 1000, 5, true)){}
		if (client.swipeWhileNotFound("Down", 0, 500, "NATIVE", "xpath=//*[@text='Value Pack']", 0, 1000, 5, true)){}
		if (client.swipeWhileNotFound("Down", 0, 500, "NATIVE", "xpath=//*[@text='Gallery Plus']", 0, 1000, 5, true)){}
		if (client.swipeWhileNotFound("Down", 0, 500, "NATIVE", "xpath=//*[@text='Listing Designer']", 0, 1000, 5, true)){}
		client.elementSendText("NATIVE", "xpath=//*[@id='reserve_price_edit_text']", 0, "5");
		
		if (client.swipeWhileNotFound("Down", 0, 500, "NATIVE", "xpath=//*[@text='CALCULATE']", 0, 1000, 5, true)){}
	}

	@Override
	protected PlatformType getPaltformType()
	{
		return PlatformType.ANDROID;
	}

}
