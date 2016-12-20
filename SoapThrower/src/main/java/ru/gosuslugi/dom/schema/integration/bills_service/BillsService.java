
package ru.gosuslugi.dom.schema.integration.bills_service;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceException;
import javax.xml.ws.WebServiceFeature;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebServiceClient(name = "BillsService", targetNamespace = "http://dom.gosuslugi.ru/schema/integration/bills-service/", wsdlLocation = "file:/C:/work/GIS_MUP/GIS11_5/hcs_wsdl_xsd_v.11.0.0.5/bills/hcs-bills-service.wsdl")
public class BillsService
    extends Service
{

    private final static URL BILLSSERVICE_WSDL_LOCATION;
    private final static WebServiceException BILLSSERVICE_EXCEPTION;
    private final static QName BILLSSERVICE_QNAME = new QName("http://dom.gosuslugi.ru/schema/integration/bills-service/", "BillsService");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("file:/C:/work/GIS_MUP/GIS11_5/hcs_wsdl_xsd_v.11.0.0.5/bills/hcs-bills-service.wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        BILLSSERVICE_WSDL_LOCATION = url;
        BILLSSERVICE_EXCEPTION = e;
    }

    public BillsService() {
        super(__getWsdlLocation(), BILLSSERVICE_QNAME);
    }

    public BillsService(WebServiceFeature... features) {
        super(__getWsdlLocation(), BILLSSERVICE_QNAME, features);
    }

    public BillsService(URL wsdlLocation) {
        super(wsdlLocation, BILLSSERVICE_QNAME);
    }

    public BillsService(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, BILLSSERVICE_QNAME, features);
    }

    public BillsService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public BillsService(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns BillsPortsType
     */
    @WebEndpoint(name = "BillsPort")
    public BillsPortsType getBillsPort() {
        return super.getPort(new QName("http://dom.gosuslugi.ru/schema/integration/bills-service/", "BillsPort"), BillsPortsType.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns BillsPortsType
     */
    @WebEndpoint(name = "BillsPort")
    public BillsPortsType getBillsPort(WebServiceFeature... features) {
        return super.getPort(new QName("http://dom.gosuslugi.ru/schema/integration/bills-service/", "BillsPort"), BillsPortsType.class, features);
    }

    private static URL __getWsdlLocation() {
        if (BILLSSERVICE_EXCEPTION!= null) {
            throw BILLSSERVICE_EXCEPTION;
        }
        return BILLSSERVICE_WSDL_LOCATION;
    }

}
