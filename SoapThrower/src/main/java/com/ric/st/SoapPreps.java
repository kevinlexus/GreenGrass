package com.ric.st;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.UnknownHostException;
import java.util.Date;
import java.util.UUID;

import javax.xml.bind.JAXBException;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPMessage;
import javax.xml.ws.BindingProvider;

import com.ric.bill.Config;
import com.sun.xml.ws.developer.WSBindingProvider;

import ru.gosuslugi.dom.schema.integration.base.RequestHeader;
import ru.gosuslugi.dom.schema.integration.house_management_service.HouseManagementPortsType;

public interface SoapPreps<T> {

	public RequestHeader getRh();
	public void setRh(RequestHeader rh);
	public void setUp(T o, BindingProvider bs, WSBindingProvider ws);
	public void createRh(Date dt, UUID rUuid, String orgPpaGuid, boolean isSetOperSign) throws DatatypeConfigurationException;
	public BindingProvider getBindingProvider();
	public void setBindingProvider(BindingProvider bindingProvider);
	public WSBindingProvider getWSBindingProvider();
	public void setWSBindingProvider(WSBindingProvider port);
	public void changeHost(String host) throws UnknownHostException, MalformedURLException;
	public String getEndPoint();
	public void setEndPoint(String endPoint);
	public void setSignXML(Boolean sign);
	public boolean getSignXML();
	public SOAPMessage createSM(String xmlText) throws IOException, SOAPException;
	public Object sendSOAP(Object req, String meth, Object result, com.ric.st.impl.Config config) throws Exception;
    public String signXML(String xml) throws Exception;
}
