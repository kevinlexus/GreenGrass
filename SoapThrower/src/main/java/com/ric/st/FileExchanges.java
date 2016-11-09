package com.ric.st;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;

public interface FileExchanges {
	public void send() throws ClientProtocolException, IOException;
}
