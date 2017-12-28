package com.qasim.framework;

import com.experitest.client.Client;
import com.experitest.client.ClientWrapper;

public class MyClient extends ClientWrapper
{

	public MyClient(Client client)
	{
		super(client);
	}

	public MyClient(String host, int port, boolean useSessionID)
	{
		super(new Client(host, port, true));
	}

	@Override
	public String generateReport(boolean releaseClient)
	{
		String text = super.generateReport(releaseClient);
		System.out.println(String.format("generateReport(%s) > %s", releaseClient, text));
		return text;
	}
}
