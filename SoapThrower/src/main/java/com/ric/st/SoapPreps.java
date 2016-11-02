package com.ric.st;

import java.util.Date;
import java.util.UUID;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.ws.BindingProvider;

import com.sun.xml.ws.developer.WSBindingProvider;

import ru.gosuslugi.dom.schema.integration.base.RequestHeader;
import ru.gosuslugi.dom.schema.integration.house_management_service.HouseManagementPortsType;

public interface SoapPreps {
	public RequestHeader getRh();
	public void setRh(RequestHeader rh);
	public void createRh(Date dt, UUID rUuid, String orgPpaGuid, boolean isSetOperSign ) throws DatatypeConfigurationException;
	public BindingProvider getBindingProvider();
	public void setBindingProvider(BindingProvider bindingProvider);
	public void setBasicAuth();
	public WSBindingProvider getWSBindingProvider();
	public void setWSBindingProvider(WSBindingProvider port);
}
