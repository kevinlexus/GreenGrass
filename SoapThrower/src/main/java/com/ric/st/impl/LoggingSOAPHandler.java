package com.ric.st.impl;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Set;

import javax.xml.namespace.QName;
import javax.xml.soap.Node;
import javax.xml.soap.SOAPBody;
import javax.xml.soap.SOAPBodyElement;
import javax.xml.soap.SOAPEnvelope;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPHeader;
import javax.xml.soap.SOAPMessage;
import javax.xml.ws.handler.MessageContext;
import javax.xml.ws.handler.soap.SOAPHandler;
import javax.xml.ws.handler.soap.SOAPMessageContext;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

public class LoggingSOAPHandler implements SOAPHandler<SOAPMessageContext> {

	public void close(MessageContext arg0) {
		// TODO Auto-generated method stub

	}

	public boolean handleFault(SOAPMessageContext arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean handleMessage(SOAPMessageContext context) {
		// TODO Auto-generated method stub
		SOAPMessage soapMsg = context.getMessage();
        SOAPEnvelope soapEnv;
        
		try {
			soapEnv = soapMsg.getSOAPPart().getEnvelope();
	        SOAPHeader soapHeader = soapEnv.getHeader();
	        
	        SOAPBody soapBody = soapMsg.getSOAPBody();

	        XPath xpath = XPathFactory.newInstance().newXPath();
	        try {
				Node resultNode = (Node) xpath.evaluate("//*[local-name() = 'BasicCharacteristicts']", soapMsg.getSOAPBody(), XPathConstants.NODE);
				System.out.println("1="+resultNode);
				System.out.println("2="+resultNode.getLocalName());
		        
				--- и начать здесь подписывание!
				Element et = (Element) resultNode;
		        
		        System.out.println("3="+et.getTextContent());
		        
				//resultNode.setTextContent("VBBBBBBBBBBBBBBBBBBBBBBB");
			} catch (XPathExpressionException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

	        //soapMsg.saveChanges();

	        
	        /*	        
	        NodeList nodeLst = soapMsg
	                                .getSOAPBody()
	                                .getElementsByTagName("*");

	        int len = nodeLst.getLength();
	        for(int i = 0; i < len; i++) {
	        	if (nodeLst.item(i) != null) {
			        System.out.println("Check!!!"+nodeLst.item(i).getTextContent());
			        //nodeLst.item(i).setTextContent("bla bla");
			        System.out.println("1"+nodeLst.item(i).getLocalName());
			        System.out.println("2"+nodeLst.item(i).getNodeName());
			        System.out.println("3"+nodeLst.item(i).getNodeValue());
			        
	        	}
	            //credentials.item(i).setTextContent("new credential content goes here...");
	            //credentials.item(i).setTextContent("new credential content goes here...");
	        }	        
	        soapMsg.saveChanges();
	        */
	        ByteArrayOutputStream baos = new ByteArrayOutputStream();
	        try {
				soapMsg.writeTo(baos);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        
	        System.out.println("CHECK IT:"+baos.toString());
	        
	        //soapMsg.
	        
	        //soapBody.writeTo(System.out);
	        
/*	        java.util.Iterator iterator = soapBody.getChildElements();
	        while (iterator.hasNext()) {
	          SOAPBodyElement bodyElement = (SOAPBodyElement) iterator.next();
	          String val = bodyElement.getValue();
	          System.out.println("The Value is:" + val);
	        }*/	        	

	        soapMsg.saveChanges();
            
			//soapMsg.writeTo(System.out);
		} catch (SOAPException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("CHECCCCCCCCCK!");
		return true;
	}

	public Set<QName> getHeaders() {
		// TODO Auto-generated method stub
		return null;
	}

}
