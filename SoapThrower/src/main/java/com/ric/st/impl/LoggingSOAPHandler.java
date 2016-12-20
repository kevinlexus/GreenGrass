package com.ric.st.impl;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.StringReader;
import java.util.Iterator;
import java.util.Set;

import javax.xml.namespace.QName;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.soap.Name;
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

import lombok.extern.slf4j.Slf4j;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.xpath.XPathExpression;
import org.xml.sax.InputSource;

import com.ric.st.builder.NsiBindingBuilder;

import ru.gosuslugi.dom.signature.demo.args.SignParameters;
import ru.gosuslugi.dom.signature.demo.commands.Command;
import ru.gosuslugi.dom.signature.demo.commands.SignCommand;

@Slf4j
public class LoggingSOAPHandler implements SOAPHandler<SOAPMessageContext> {

	public void close(MessageContext arg0) {

	}

	public boolean handleFault(SOAPMessageContext arg0) {
		return false;
	}

	public boolean handleMessage(SOAPMessageContext context) {
		//TODO разобраться с эксепшнс
		SOAPMessage soapMsg = context.getMessage();
		
		SOAPEnvelope soapEnv = null;
		try {
			soapEnv = soapMsg.getSOAPPart().getEnvelope();
			
			//QName bodyName = new QName("http://wombat.ztrade.com", "GetLastTradePrice", "m");
			//soapEnv.getBody().addChildElement(bodyName);
			
		} catch (SOAPException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// получить XML
		ByteArrayOutputStream bs = new ByteArrayOutputStream();
		try {
			soapMsg.writeTo(bs);
		} catch (SOAPException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		log.info(" ");
		log.info("Before Signed XML={}", (String) bs.toString());
		log.info(" ");

		// подпись элемента
				String sgn = null;
        try {
			sgn = App.sc.signElem((String) bs.toString(), "foo", "foo");
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		log.info(" ");
		log.info("Signed XML={}", sgn);
		log.info(" ");
        
/*
		// Получить элемент подписи
        DocumentBuilderFactory domFactory = DocumentBuilderFactory.newInstance();
        try {
            DocumentBuilder builder = domFactory.newDocumentBuilder();
            InputSource is = new InputSource(new StringReader(sgn));
            Document dDoc = builder.parse(is);

            XPath xpath = XPathFactory.newInstance().newXPath();
            javax.xml.xpath.XPathExpression expr = xpath.compile("//*[local-name()='Signature']");
            //javax.xml.xpath.XPathExpression expr = xpath.compile("//*:SignedInfo");
            Object result = expr.evaluate(dDoc, XPathConstants.NODESET);
            NodeList nodes = (NodeList) result;
            Node nd = nodes.item(0);
            
            System.out.println("Check0 "+nodes.item(0));
            System.out.println("Check1 "+nodes.item(0).getLocalName());
            System.out.println("Check2 "+nodes.item(0).getNodeName());
            NamedNodeMap attributes = nodes.item(0).getAttributes();
            for (int i = 0; i < attributes.getLength(); i++) {
                System.out.println("Check3 "+attributes.item(i));
            }
            
            //log.info("Element1={}", nd);
            //log.info("Element2={}", nd.getNodeValue());
        } catch (Exception e) {
            e.printStackTrace();
        }*/
        // 
        
/*		try {
	        SOAPBody body = soapMsg.getSOAPBody();
			//SOAPBodyElement bodyElement;
			//bodyElement = body.addBodyElement(new QName("http://blog.jdevelop.eu/securitymessage", "message"));
			//bodyElement.addTextNode("Security through obscurity");
			NodeList blst = body.getElementsByTagName("ns6:exportNsiItemRequest");
			for (int i=0; i <= blst.getLength(); i++) {
				log.info("item2= {}", blst.item(i));
			}
				
			// сохранить XML
			soapMsg.saveChanges();
		} catch (SOAPException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}*/
		
		
		log.info(" ");
        log.info("Sent XML={}", (String) bs.toString());
        log.info(" ");

		try {
				context.put("SOAP_XML", bs.toString());
				context.setScope("SOAP_XML", MessageContext.Scope.APPLICATION);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		// продолжить выполнение - true
		return true;
	}

	public Set<QName> getHeaders() {
		return null;
	}

}
