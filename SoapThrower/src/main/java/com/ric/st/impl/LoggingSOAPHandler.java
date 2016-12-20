package com.ric.st.impl;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.StringReader;
import java.util.Iterator;
import java.util.Set;

import javax.xml.namespace.QName;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
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
        

		Node nd = null;
		
		// Получить элемент подписи
        DocumentBuilderFactory domFactory = DocumentBuilderFactory.newInstance();
        String signValueId = null;
        String signValueCtx = null;
        
        try {
            DocumentBuilder builder = domFactory.newDocumentBuilder();
            InputSource is = new InputSource(new StringReader(sgn));
            Document dDoc = builder.parse(is);

            XPath xpath = XPathFactory.newInstance().newXPath();
            javax.xml.xpath.XPathExpression expr = xpath.compile("//*[local-name()='Signature']");
            //javax.xml.xpath.XPathExpression expr = xpath.compile("//*:SignedInfo");
            Object result = expr.evaluate(dDoc, XPathConstants.NODESET);
            NodeList nodes = (NodeList) result;

            nd = nodes.item(0);
            
            System.out.println("Check "+nd);
            System.out.println("Check local name "+nd.getLocalName());
            System.out.println("Check node name "+nd.getNodeName());
            System.out.println("Check prefix "+nd.getPrefix());
            //System.out.println("Check text"+nd.getTextContent()); - здесь подпись
            
            NamedNodeMap attributes = nd.getAttributes();
            for (int b = 0; b < attributes.getLength(); b++) {
                System.out.println("Check3 "+attributes.item(b));
            }

            for (int i=0; i < nd.getChildNodes().getLength(); i++) {
            	Node itm = nd.getChildNodes().item(i);
            	log.info("Child={}", itm.getNodeName());
            	
            	if (itm.getNodeName().equals("ds:SignatureValue")) {

	            	for (int a=0; a < itm.getAttributes().getLength(); a++) {
		            	log.info("Attrib ={}", itm.getAttributes().item(a));
		            	//log.info("Attrib ={}", itm.getAttributes().item(a).getNodeName());
		            	log.info("Attrib ={}", itm.getAttributes().item(a).getNodeValue());
		            	signValueId = itm.getAttributes().item(a).getNodeValue();
		            	
	            	}
	            	log.info("Attrib ={}", itm.getTextContent());
	            	signValueCtx = itm.getTextContent();
	        	}

            }
            
            
            //log.info("Element1={}", nd);
            //log.info("Element2={}", nd.getNodeValue());
        } catch (Exception e) {
            e.printStackTrace();
        }
        // 
        
		try {
	        SOAPBody body = soapMsg.getSOAPBody();
			//SOAPBodyElement bodyElement;
			//bodyElement = body.addBodyElement(new QName("http://blog.jdevelop.eu/securitymessage", "message"));
			//bodyElement.addTextNode("Security through obscurity");
			
			
			
			NodeList blst = body.getElementsByTagName("ns6:exportNsiItemRequest");
			
			//log.info("item2= {}", blst.item(0));
			
			Node itm = blst.item(0);

			Document doc = body.getOwnerDocument();
			doc.adoptNode(nd);   // ПРОВЕРИТЬ ЭТО!!!!!!!!!!!!!
			
			itm.appendChild(nd);
			
			// сохранить XML
			soapMsg.saveChanges();
		} catch (SOAPException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
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
