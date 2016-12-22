package com.ric.st.impl;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.UnknownHostException;
import java.util.Arrays;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.ws.Binding;
import javax.xml.ws.BindingProvider;
import javax.xml.ws.handler.Handler;
import javax.xml.ws.handler.MessageContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import ru.gosuslugi.dom.schema.integration.base.RequestHeader;

import com.ric.bill.Utl;
import com.ric.st.excp.CantSendSoap;
import com.sun.xml.ws.developer.WSBindingProvider;


@Service
@Scope("prototype")
public class SoapBuilder {
	@Autowired
	private Config config;

	private BindingProvider bp;
	private WSBindingProvider ws;
	private RequestHeader rh;

	public void setUp(BindingProvider port, WSBindingProvider port2) throws CantSendSoap {
		bp = (BindingProvider) port;
		ws = (WSBindingProvider) port;
		rh = new RequestHeader();

		rh.setOrgPPAGUID(config.getOrgPPGuid());
    	rh.setIsOperatorSignature(true);

    	// установить Random Message GUID и дату
    	GregorianCalendar c = new GregorianCalendar();
		c.setTime(new Date());
		XMLGregorianCalendar cl = null;
		try {
			cl = DatatypeFactory.newInstance().newXMLGregorianCalendar(c);
		} catch (DatatypeConfigurationException e1) {
			e1.printStackTrace();
			throw new CantSendSoap("Ошибка при подготовке даты для SOAP Message");
		}
		rh.setDate(cl);
    	UUID messGUID = Utl.getRndUuid();
		rh.setMessageGUID(messGUID.toString());
    	
    	ws.setOutboundHeaders(rh);
		
		String endPoint = (String) bp.getRequestContext().get(BindingProvider.ENDPOINT_ADDRESS_PROPERTY);
		String urlStr = endPoint;
		String path = null;
		try {
			path = Utl.getPathFromUrl(urlStr);
		} catch (UnknownHostException | MalformedURLException e) {
			e.printStackTrace();
			throw new CantSendSoap("Ошибка при определении хоста");
		}
		
		Map<String, List<String>> requestHeaders = new HashMap<>();
        @SuppressWarnings("restriction")
		String authorization = new sun.misc.BASE64Encoder().encode((config.getBscLogin()+":"+config.getBscPass()).getBytes());
		requestHeaders.put("Authorization", Arrays.asList("Basic " + authorization));
		requestHeaders.put("X-Client-Cert-Fingerprint", Arrays.asList(config.getFingerPrint()));
		
		bp.getRequestContext().put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, 
				config.getSrvTestHost()+path);
		bp.getRequestContext().put(MessageContext.HTTP_REQUEST_HEADERS, requestHeaders);
		
		// добавить хэндлер, для установщика подписи ЭЦП
		Binding binding = bp.getBinding();
    	List<Handler> handlerChain = binding.getHandlerChain();
    	handlerChain.add(new LoggingSOAPHandler());
    	binding.setHandlerChain(handlerChain);
	}

	public void closeResource() throws CantSendSoap {
	   	try {
			ws.close();
		} catch (IOException e) {
			e.printStackTrace();
			throw new CantSendSoap("Ошибка при освобождении ресурса WSBindingProvider");
		}
		
	}


	
}
