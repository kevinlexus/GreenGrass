package com.ric.st.impl;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.StringReader;
import java.util.Set;

import javax.annotation.PostConstruct;
import javax.xml.namespace.QName;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.soap.SOAPBody;
import javax.xml.soap.SOAPEnvelope;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPMessage;
import javax.xml.ws.handler.MessageContext;
import javax.xml.ws.handler.soap.SOAPHandler;
import javax.xml.ws.handler.soap.SOAPMessageContext;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathFactory;

import lombok.extern.slf4j.Slf4j;

import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

@Slf4j
public class LoggingSOAPHandler implements SOAPHandler<SOAPMessageContext> {


    /**
     * Is called after constructing the handler and before executing any othe method.
     */
    @PostConstruct
    public void init() {

    }

   
	public void close(MessageContext arg0) {

	}

	public boolean handleMessage(SOAPMessageContext context) {
		log.info("**************** HANDLER2 *************");

	     Boolean outboundProperty = (Boolean)
	    		 context.get (MessageContext.MESSAGE_OUTBOUND_PROPERTY);

       if (outboundProperty.booleanValue()) {
	     
		//TODO разобраться с эксепшнс
		SOAPMessage soapMsg = context.getMessage();
		
		SOAPEnvelope soapEnv = null;
		try {
			soapEnv = soapMsg.getSOAPPart().getEnvelope();
			
		} catch (SOAPException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		log.info("Before sign XML:");
		dumpSOAPMessage(soapMsg);

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
		
		Node nd = null;
		
		// Получить элемент подписи
        DocumentBuilderFactory domFactory = DocumentBuilderFactory.newInstance();
        
        try {
            DocumentBuilder builder = domFactory.newDocumentBuilder();
            InputSource is = new InputSource(new StringReader(sgn));
            Document dDoc = builder.parse(is);

            XPath xpath = XPathFactory.newInstance().newXPath();
            javax.xml.xpath.XPathExpression expr = xpath.compile("//*[local-name()='Signature']");
            Object result = expr.evaluate(dDoc, XPathConstants.NODESET);
            NodeList nodes = (NodeList) result;

            nd = nodes.item(0);
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        // 
        
		try {
	        SOAPBody body = soapMsg.getSOAPBody();
			NodeList blst = body.getElementsByTagName("ns6:exportNsiItemRequest");
			Node itm = blst.item(0);
			Node itm2 = itm.getFirstChild();
			
			Document doc = body.getOwnerDocument();
			doc.adoptNode(nd);
			itm.insertBefore(nd, itm2);
	
			// сохранить XML
			soapMsg.saveChanges();
			log.info("XML saved!");
		} catch (SOAPException e1) {
			log.info("XML DOESN'T saved!");
			e1.printStackTrace();
		}
		
		log.info("Sended XML:");
		dumpSOAPMessage(soapMsg);

	    }
		// продолжить выполнение - true
		return true;
	}

	public Set<QName> getHeaders() {
		return null;
	}

    /**
     * Returns the message encoding (e.g. utf-8)
     *
     * @param msg
     * @return
     * @throws javax.xml.soap.SOAPException
     */
    private String getMessageEncoding(SOAPMessage msg) throws SOAPException {
        String encoding = "utf-8";
        if (msg.getProperty(SOAPMessage.CHARACTER_SET_ENCODING) != null) {
            log.info("getMessageEncoding-1");
            encoding = msg.getProperty(SOAPMessage.CHARACTER_SET_ENCODING).toString();
        }
        log.info("getMessageEncoding-2");
        return encoding;
    }	
    
    
    /**
     * Dump SOAP Message to console
     *
     * @param msg
     */
    private void dumpSOAPMessage(SOAPMessage msg) {
    	
    	if (1==1) {
        	return;
    	}
    	
    	if (msg == null) {
            System.out.println("SOAP Message is null");
            return;
        }
        System.out.println("");
        System.out.println("--------------------");
        System.out.println("DUMP OF SOAP MESSAGE");
        System.out.println("--------------------");
        try {
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            msg.writeTo(baos);
            System.out.println(baos.toString(getMessageEncoding(msg)));

            // show included values
            //String values = msg.getSOAPBody().getTextContent();
            //System.out.println("Included values:" + values);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    
    /**
     * Handles SOAP-Errors.
     *
     * @param context
     * @return
     */
    public boolean handleFault(SOAPMessageContext context) {
        System.out.println("ServerSOAPHandler.handleFault");
        boolean outbound = (Boolean) context.get(MessageContext.MESSAGE_OUTBOUND_PROPERTY);
        if (outbound) {
            System.out.println("Direction=outbound (handleFault)");
        } else {
            System.out.println("Direction=inbound (handleFault)");
        }
        if (!outbound) {
            try {
                SOAPMessage msg = ((SOAPMessageContext) context).getMessage();
                dumpSOAPMessage(msg);
                if (context.getMessage().getSOAPBody().getFault() != null) {
                    String detailName = null;
                    try {
                        detailName = context.getMessage().getSOAPBody().getFault().getDetail().getFirstChild().getLocalName();
                        System.out.println("detailName=" + detailName);
                    } catch (Exception e) {
                    }
                }
            } catch (SOAPException e) {
                e.printStackTrace();
            }
        }
        return true;
    }
    
}
