package com.ric.st.impl;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import javax.xml.namespace.QName;
import javax.xml.soap.SOAPBody;
import javax.xml.soap.SOAPBodyElement;
import javax.xml.soap.SOAPElement;
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

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

import ru.gosuslugi.dom.signature.demo.args.SignParameters;
import ru.gosuslugi.dom.signature.demo.commands.Command;
import ru.gosuslugi.dom.signature.demo.commands.SignCommand;

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
	        Command sc = new SignCommand(null);
			
			ByteArrayOutputStream bs = new ByteArrayOutputStream();
			try {
				soapMsg.writeTo(bs);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				ThrowerMng.xmlText = sc.signElem(bs.toString(), "foo", "foo");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

	        //soapMsg.saveChanges();

/*		System.out.println("BEGIN MSG:");
	        try {
				soapMsg.writeTo(System.out);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
*/		} catch (SOAPException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

/*		System.out.println("END MSG:");
*/		
		return false;
	}

	public Set<QName> getHeaders() {
		// TODO Auto-generated method stub
		return null;
	}

}
