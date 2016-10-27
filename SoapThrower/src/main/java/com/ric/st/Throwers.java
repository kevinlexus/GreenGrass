package com.ric.st;

import javax.xml.datatype.DatatypeConfigurationException;

import ru.gosuslugi.dom.schema.integration.organizations_registry_common_service.Fault;

public interface Throwers {

    public void importHouse() throws DatatypeConfigurationException, ru.gosuslugi.dom.schema.integration.house_management_service.Fault;
	public void send() throws DatatypeConfigurationException, Fault;
	public void send2() throws DatatypeConfigurationException, ru.gosuslugi.dom.schema.integration.house_management_service.Fault;
	
}
