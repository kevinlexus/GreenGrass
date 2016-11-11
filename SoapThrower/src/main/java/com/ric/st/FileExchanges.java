package com.ric.st;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;

import org.apache.http.client.ClientProtocolException;

public interface FileExchanges {
	public String send() throws ClientProtocolException, IOException, NoSuchAlgorithmException;
}
