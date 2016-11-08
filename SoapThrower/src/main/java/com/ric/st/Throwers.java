package com.ric.st;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.UnknownHostException;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.soap.SOAPException;

import com.ric.st.impl.HouseManagementPrep;

import ru.gosuslugi.dom.schema.integration.organizations_registry_common_service.Fault;

public interface Throwers {

    public void importHouse() throws Exception;
    public void importHouseUpd() throws Exception;
    public void exportAccountData() throws Exception;
}
