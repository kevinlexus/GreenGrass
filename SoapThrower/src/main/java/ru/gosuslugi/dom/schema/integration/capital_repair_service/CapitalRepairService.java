
package ru.gosuslugi.dom.schema.integration.capital_repair_service;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceException;
import javax.xml.ws.WebServiceFeature;


/**
 * Сервис Капитальный ремонт
 * 
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebServiceClient(name = "CapitalRepairService", targetNamespace = "http://dom.gosuslugi.ru/schema/integration/capital-repair-service/", wsdlLocation = "file:/C:/work/GIS_MUP/\u0413\u0418\u0421%20\u0416\u041a\u0425_\u0418\u043d\u0442\u0435\u0433\u0440\u0430\u0446\u0438\u044f_v.11.0.0.3/hcs_wsdl_xsd_v.11.0.0.3/capital-repair/hcs-capital-repair-service.wsdl")
public class CapitalRepairService
    extends Service
{

    private final static URL CAPITALREPAIRSERVICE_WSDL_LOCATION;
    private final static WebServiceException CAPITALREPAIRSERVICE_EXCEPTION;
    private final static QName CAPITALREPAIRSERVICE_QNAME = new QName("http://dom.gosuslugi.ru/schema/integration/capital-repair-service/", "CapitalRepairService");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("file:/C:/work/GIS_MUP/\u0413\u0418\u0421%20\u0416\u041a\u0425_\u0418\u043d\u0442\u0435\u0433\u0440\u0430\u0446\u0438\u044f_v.11.0.0.3/hcs_wsdl_xsd_v.11.0.0.3/capital-repair/hcs-capital-repair-service.wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        CAPITALREPAIRSERVICE_WSDL_LOCATION = url;
        CAPITALREPAIRSERVICE_EXCEPTION = e;
    }

    public CapitalRepairService() {
        super(__getWsdlLocation(), CAPITALREPAIRSERVICE_QNAME);
    }

    public CapitalRepairService(WebServiceFeature... features) {
        super(__getWsdlLocation(), CAPITALREPAIRSERVICE_QNAME, features);
    }

    public CapitalRepairService(URL wsdlLocation) {
        super(wsdlLocation, CAPITALREPAIRSERVICE_QNAME);
    }

    public CapitalRepairService(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, CAPITALREPAIRSERVICE_QNAME, features);
    }

    public CapitalRepairService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public CapitalRepairService(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns CapitalRepairPort
     */
    @WebEndpoint(name = "CapitalRepairPort")
    public CapitalRepairPort getCapitalRepairPort() {
        return super.getPort(new QName("http://dom.gosuslugi.ru/schema/integration/capital-repair-service/", "CapitalRepairPort"), CapitalRepairPort.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns CapitalRepairPort
     */
    @WebEndpoint(name = "CapitalRepairPort")
    public CapitalRepairPort getCapitalRepairPort(WebServiceFeature... features) {
        return super.getPort(new QName("http://dom.gosuslugi.ru/schema/integration/capital-repair-service/", "CapitalRepairPort"), CapitalRepairPort.class, features);
    }

    private static URL __getWsdlLocation() {
        if (CAPITALREPAIRSERVICE_EXCEPTION!= null) {
            throw CAPITALREPAIRSERVICE_EXCEPTION;
        }
        return CAPITALREPAIRSERVICE_WSDL_LOCATION;
    }

}