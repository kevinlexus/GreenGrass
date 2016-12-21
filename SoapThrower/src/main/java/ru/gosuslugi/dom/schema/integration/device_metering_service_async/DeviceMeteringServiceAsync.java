
package ru.gosuslugi.dom.schema.integration.device_metering_service_async;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceException;
import javax.xml.ws.WebServiceFeature;


/**
 * Асинхронный сервис управления приборами учета и передачей показаний
 * 
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebServiceClient(name = "DeviceMeteringServiceAsync", targetNamespace = "http://dom.gosuslugi.ru/schema/integration/device-metering-service-async/", wsdlLocation = "file:/C:/work/GIS_MUP/GIS11_5/hcs_wsdl_xsd_v.11.0.0.5/device-metering/hcs-device-metering-service-async.wsdl")
public class DeviceMeteringServiceAsync
    extends Service
{

    private final static URL DEVICEMETERINGSERVICEASYNC_WSDL_LOCATION;
    private final static WebServiceException DEVICEMETERINGSERVICEASYNC_EXCEPTION;
    private final static QName DEVICEMETERINGSERVICEASYNC_QNAME = new QName("http://dom.gosuslugi.ru/schema/integration/device-metering-service-async/", "DeviceMeteringServiceAsync");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("file:/C:/work/GIS_MUP/GIS11_5/hcs_wsdl_xsd_v.11.0.0.5/device-metering/hcs-device-metering-service-async.wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        DEVICEMETERINGSERVICEASYNC_WSDL_LOCATION = url;
        DEVICEMETERINGSERVICEASYNC_EXCEPTION = e;
    }

    public DeviceMeteringServiceAsync() {
        super(__getWsdlLocation(), DEVICEMETERINGSERVICEASYNC_QNAME);
    }

    public DeviceMeteringServiceAsync(WebServiceFeature... features) {
        super(__getWsdlLocation(), DEVICEMETERINGSERVICEASYNC_QNAME, features);
    }

    public DeviceMeteringServiceAsync(URL wsdlLocation) {
        super(wsdlLocation, DEVICEMETERINGSERVICEASYNC_QNAME);
    }

    public DeviceMeteringServiceAsync(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, DEVICEMETERINGSERVICEASYNC_QNAME, features);
    }

    public DeviceMeteringServiceAsync(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public DeviceMeteringServiceAsync(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns DeviceMeteringPortTypesAsync
     */
    @WebEndpoint(name = "DeviceMeteringPortAsync")
    public DeviceMeteringPortTypesAsync getDeviceMeteringPortAsync() {
        return super.getPort(new QName("http://dom.gosuslugi.ru/schema/integration/device-metering-service-async/", "DeviceMeteringPortAsync"), DeviceMeteringPortTypesAsync.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns DeviceMeteringPortTypesAsync
     */
    @WebEndpoint(name = "DeviceMeteringPortAsync")
    public DeviceMeteringPortTypesAsync getDeviceMeteringPortAsync(WebServiceFeature... features) {
        return super.getPort(new QName("http://dom.gosuslugi.ru/schema/integration/device-metering-service-async/", "DeviceMeteringPortAsync"), DeviceMeteringPortTypesAsync.class, features);
    }

    private static URL __getWsdlLocation() {
        if (DEVICEMETERINGSERVICEASYNC_EXCEPTION!= null) {
            throw DEVICEMETERINGSERVICEASYNC_EXCEPTION;
        }
        return DEVICEMETERINGSERVICEASYNC_WSDL_LOCATION;
    }

}