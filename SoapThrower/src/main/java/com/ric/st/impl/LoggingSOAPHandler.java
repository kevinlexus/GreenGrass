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
		return true;
	}

	public Set<QName> getHeaders() {
		// TODO Auto-generated method stub
		return null;
	}

}
