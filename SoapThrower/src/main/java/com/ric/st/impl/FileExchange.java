package com.ric.st.impl;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.apache.commons.io.FileUtils;
import org.apache.http.HttpResponse;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.client.methods.HttpHead;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.FileEntity;
import org.apache.http.entity.mime.HttpMultipartMode;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.xml.security.utils.Base64;

import sun.misc.BASE64Encoder;

import com.ric.st.FileExchanges;

public class FileExchange implements FileExchanges {

	public void send2()  {
		
		
		
	}

	
	public String send() throws ClientProtocolException, IOException, NoSuchAlgorithmException {
		String fileStore = "homemanagement";
				CredentialsProvider credsProvider = new BasicCredentialsProvider();
        credsProvider.setCredentials(
                new AuthScope("127.0.0.1", 8085),
                new UsernamePasswordCredentials("lanit", "tv,n8!Ya"));
        CloseableHttpClient httpclient = HttpClients.custom()
                .setDefaultCredentialsProvider(credsProvider)
                .build();

        File file = new File("c:\\temp\\#26\\scan.jpg");

        MessageDigest md = MessageDigest.getInstance("MD5");
        BufferedInputStream in = new BufferedInputStream(new FileInputStream("c:\\temp\\#26\\scan.jpg"));
        int theByte = 0;
        while ((theByte = in.read()) != -1) {
          md.update((byte) theByte);
        }
        in.close();
        byte[] theDigest = md.digest();
        System.out.println("CHECK MEEEE!"+new BASE64Encoder().encode(theDigest));
        
/*        byte[] bytes = IOUtils.toByteArray(new FileInputStream("/home/zinin/tmp/xxx.pdf")); //госту 34.11
        MessageDigest digest = MessageDigest.getInstance(GostConsts.GOST_DIGEST_ALGORITHM_NAME, CommonConstants.TRUSTED_JAVA_PROVIDER);
        byte[] result = digest.digest(bytes);
        System.out.println(("hash: " + new String(Hex.encodeHex(result, true))));        
*/        
        
        String str = Base64.encode(FileUtils.readFileToByteArray(file));

        HttpPut post = new HttpPut("http://127.0.0.1:8085/ext-bus-file-store-service/rest/"+fileStore);
        
        System.out.println("##START##");
        
        System.out.println(str);

        System.out.println("##END##");
        
        // 
        MultipartEntityBuilder builder = MultipartEntityBuilder.create();
        //builder.setMode(HttpMultipartMode.BROWSER_COMPATIBLE);
        builder.setMode(HttpMultipartMode.BROWSER_COMPATIBLE);
        
        //builder.addPart("upfile", fileBody);
        //builder.addBinaryBody("somename", file, ContentType.APPLICATION_OCTET_STREAM, "scan.jpg");
        //builder.addBinaryBody("somename", str.getBytes(), ContentType., "scan.jpg"); //[zxt91stNQ8EQkWRHnvyZ+Q==]

        //builder.addTextBody("somename", str);
        //post.setHeader("Content-MD5", DigestUtils.md .md5(str).toString());
        //builder.addPart(bodyPart);
        
        builder.setContentType(ContentType.DEFAULT_BINARY);
        post.setHeader("Content-MD5", new BASE64Encoder().encode(theDigest));
        //post.setHeader("Content-MD5", Base64.encode(hashtext.getBytes()));
        post.setHeader("X-Upload-OrgPPAGUID", "b9fe4d27-020d-44dc-8bfd-b5972a504f45");
        post.setHeader("X-Upload-Filename", "scan.jpg");
        
        FileEntity enF = new FileEntity(file);
        post.setEntity(enF);
        //builder.setBoundary("");
        //post
        
        //J/MSPJQzBMOfBoA8QZbn8Q==
        //digest [6zAHDz10f4g8qYfSYT0V9Q==] of the received content. FileGuid is 5d72493e-adb2-4d3a-bba1-4b7202ee7a41.

        
        //HttpEntity entity = builder.build();
        //
        //post.setEntity(entity);
        HttpResponse response = httpclient.execute(post);
        //System.out.println("GIS HEAD1:"+response.getHeaders("X-Upload-UploadID"));

        org.apache.http.Header[] hd = response.getAllHeaders();
        
        String fileGuid = null;
        for (int i=0; i < hd.length ; i++) {
            System.out.println("GIS HEAD2:"+hd[i].getName());
            System.out.println("GIS HEAD2:"+hd[i].getValue());
            if (hd[i].getName().equals("X-Upload-UploadID")) {
            	fileGuid = hd[i].getValue();
            }
        }
        
        
        HttpHead head = new HttpHead("http://127.0.0.1:8085/ext-bus-file-store-service/rest/"+fileStore+"/"+fileGuid);
        head.setHeader("X-Upload-OrgPPAGUID", "b9fe4d27-020d-44dc-8bfd-b5972a504f45");
        response = httpclient.execute(head);
        
        System.out.println("HEAD RESPONSE:"+response.getAllHeaders().toString());
        
        hd = response.getAllHeaders();

        for (int i=0; i < hd.length ; i++) {
            System.out.println("GIS HEAD3:"+hd[i].getName());
            System.out.println("GIS HEAD3:"+hd[i].getValue());
        }

        httpclient.close();
        
        return fileGuid;
        
        
        
	}
}
