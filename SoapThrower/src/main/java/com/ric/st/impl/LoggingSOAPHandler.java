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

	}

	public boolean handleFault(SOAPMessageContext arg0) {
		return false;
	}

	public boolean handleMessage(SOAPMessageContext context) {
		SOAPMessage soapMsg = context.getMessage();

		
		boolean sign = false; 
		if(context.containsKey("sign")){
			sign = (Boolean) context.get("sign");
		}
		
		try {
			Command sc = new SignCommand(null);
			
			ByteArrayOutputStream bs = new ByteArrayOutputStream();
			try {
				soapMsg.writeTo(bs);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				if (sign) {

					ThrowerMng.xmlText = sc.signElem(bs.toString(), "foo", "foo");
				} else {
					  ThrowerMng.xmlText = bs.toString();
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} catch (SOAPException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return false;
	}

	public Set<QName> getHeaders() {
		return null;
	}

}
