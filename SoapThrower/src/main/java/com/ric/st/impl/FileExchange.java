package com.ric.st.impl;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.io.FileUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.mime.HttpMultipartMode;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.apache.xml.security.utils.Base64;

import com.ric.bill.Utl;
import com.ric.st.FileExchanges;

public class FileExchange implements FileExchanges {

	
	public void send() throws ClientProtocolException, IOException {
		
		CredentialsProvider credsProvider = new BasicCredentialsProvider();
        credsProvider.setCredentials(
                new AuthScope("127.0.0.1", 8085),
                new UsernamePasswordCredentials("lanit", "tv,n8!Ya"));
        CloseableHttpClient httpclient = HttpClients.custom()
                .setDefaultCredentialsProvider(credsProvider)
                .build();
        
/*        try {
            HttpGet httpget = new HttpGet("http://127.0.0.1:8085/ext-bus-home-management-service/services/HomeManagement");

            System.out.println("Executing request " + httpget.getRequestLine());
            CloseableHttpResponse response = httpclient.execute(httpget);
            try {
                System.out.println("----------------------------------------");
                System.out.println(response.getStatusLine());
                System.out.println(EntityUtils.toString(response.getEntity()));
            } finally {
                response.close();
            }
        } finally {
            httpclient.close();
        }
*/        
        
        File file = new File("c:\\temp\\#26\\scan.jpg");
        String str = Base64.encode(FileUtils.readFileToByteArray(file));
        //String nn = "Trollolo!";
        //String str = Base64.encode(nn.getBytes());
        
        
        HttpPut post = new HttpPut("http://127.0.0.1:8085/ext-bus-file-store-service/rest/homemanagement");
        //FileBody fileBody = new FileBody(file, ContentType.DEFAULT_BINARY);
        
        
        // 
        MultipartEntityBuilder builder = MultipartEntityBuilder.create();
        builder.setMode(HttpMultipartMode.BROWSER_COMPATIBLE);
        //builder.addPart("upfile", fileBody);
        //builder.addBinaryBody("somename", file, ContentType.APPLICATION_OCTET_STREAM, "scan.jpg");
        builder.addBinaryBody("somename", str.getBytes(), ContentType.MULTIPART_FORM_DATA, "scan.jpg");
        post.setHeader("Content-MD5", DigestUtils.md5Hex(str));
        post.setHeader("X-Upload-OrgPPAGUID", "b9fe4d27-020d-44dc-8bfd-b5972a504f45");
        post.setHeader("X-Upload-Filename", "scan.jpg");
        HttpEntity entity = builder.build();
        //
        post.setEntity(entity);
        HttpResponse response = httpclient.execute(post);
	}
}
