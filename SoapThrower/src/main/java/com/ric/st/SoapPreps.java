package com.ric.st;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.UnknownHostException;
import java.util.Date;
import java.util.UUID;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPMessage;
import javax.xml.ws.BindingProvider;

import ru.gosuslugi.dom.schema.integration.base.RequestHeader;

import com.ric.st.excp.CantSendSoap;
import com.ric.st.excp.CantSignSoap;
import com.sun.xml.ws.developer.WSBindingProvider;

public interface SoapPreps<T> {

	public void setUp(T o, BindingProvider bs, WSBindingProvider ws);
	public void setSignXML(Boolean sign);
	public Object sendSOAP(Object req, String meth, Object result, com.ric.st.impl.Config config, boolean isSetOperSign) throws CantSignSoap, CantSendSoap;
}
