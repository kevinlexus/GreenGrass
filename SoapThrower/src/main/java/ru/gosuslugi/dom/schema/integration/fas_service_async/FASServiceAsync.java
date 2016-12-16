
package ru.gosuslugi.dom.schema.integration.fas_service_async;

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
@WebServiceClient(name = "FASServiceAsync", targetNamespace = "http://dom.gosuslugi.ru/schema/integration/fas-service-async/", wsdlLocation = "file:/C:/work/GIS_MUP/\u0413\u0418\u0421%20\u0416\u041a\u0425_\u0418\u043d\u0442\u0435\u0433\u0440\u0430\u0446\u0438\u044f_v.11.0.0.3/hcs_wsdl_xsd_v.11.0.0.3/fas/hcs-fas-service-async.wsdl")
public class FASServiceAsync
    extends Service
{

    private final static URL FASSERVICEASYNC_WSDL_LOCATION;
    private final static WebServiceException FASSERVICEASYNC_EXCEPTION;
    private final static QName FASSERVICEASYNC_QNAME = new QName("http://dom.gosuslugi.ru/schema/integration/fas-service-async/", "FASServiceAsync");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("file:/C:/work/GIS_MUP/\u0413\u0418\u0421%20\u0416\u041a\u0425_\u0418\u043d\u0442\u0435\u0433\u0440\u0430\u0446\u0438\u044f_v.11.0.0.3/hcs_wsdl_xsd_v.11.0.0.3/fas/hcs-fas-service-async.wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        FASSERVICEASYNC_WSDL_LOCATION = url;
        FASSERVICEASYNC_EXCEPTION = e;
    }

    public FASServiceAsync() {
        super(__getWsdlLocation(), FASSERVICEASYNC_QNAME);
    }

    public FASServiceAsync(WebServiceFeature... features) {
        super(__getWsdlLocation(), FASSERVICEASYNC_QNAME, features);
    }

    public FASServiceAsync(URL wsdlLocation) {
        super(wsdlLocation, FASSERVICEASYNC_QNAME);
    }

    public FASServiceAsync(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, FASSERVICEASYNC_QNAME, features);
    }

    public FASServiceAsync(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public FASServiceAsync(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns FASPortsTypeAsync
     */
    @WebEndpoint(name = "FASPortAsync")
    public FASPortsTypeAsync getFASPortAsync() {
        return super.getPort(new QName("http://dom.gosuslugi.ru/schema/integration/fas-service-async/", "FASPortAsync"), FASPortsTypeAsync.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns FASPortsTypeAsync
     */
    @WebEndpoint(name = "FASPortAsync")
    public FASPortsTypeAsync getFASPortAsync(WebServiceFeature... features) {
        return super.getPort(new QName("http://dom.gosuslugi.ru/schema/integration/fas-service-async/", "FASPortAsync"), FASPortsTypeAsync.class, features);
    }

    private static URL __getWsdlLocation() {
        if (FASSERVICEASYNC_EXCEPTION!= null) {
            throw FASSERVICEASYNC_EXCEPTION;
        }
        return FASSERVICEASYNC_WSDL_LOCATION;
    }

}
