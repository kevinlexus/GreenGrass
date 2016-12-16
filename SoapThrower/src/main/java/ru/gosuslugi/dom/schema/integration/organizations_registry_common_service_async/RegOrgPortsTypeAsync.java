
package ru.gosuslugi.dom.schema.integration.organizations_registry_common_service_async;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.bind.annotation.XmlSeeAlso;
import ru.gosuslugi.dom.schema.integration.base.AckRequest;
import ru.gosuslugi.dom.schema.integration.base.GetStateRequest;
import ru.gosuslugi.dom.schema.integration.organizations_registry_common.ExportDataProviderRequest;
import ru.gosuslugi.dom.schema.integration.organizations_registry_common.ExportOrgRegistryRequest;
import ru.gosuslugi.dom.schema.integration.organizations_registry_common.GetStateResult;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebService(name = "RegOrgPortsTypeAsync", targetNamespace = "http://dom.gosuslugi.ru/schema/integration/organizations-registry-common-service-async/")
@SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.BARE)
@XmlSeeAlso({
    ru.gosuslugi.dom.schema.integration.organizations_registry_common.ObjectFactory.class,
    ru.gosuslugi.dom.schema.integration.base.ObjectFactory.class,
    ru.gosuslugi.dom.schema.integration.organizations_registry_base.ObjectFactory.class,
    ru.gosuslugi.dom.schema.integration.nsi_base.ObjectFactory.class,
    org.w3._2000._09.xmldsig_.ObjectFactory.class,
    ru.gosuslugi.dom.schema.integration.organizations_base.ObjectFactory.class
})
public interface RegOrgPortsTypeAsync {


    /**
     * 
     * @param getStateRequest
     * @return
     *     returns ru.gosuslugi.dom.schema.integration.organizations_registry_common.GetStateResult
     * @throws Fault
     */
    @WebMethod(action = "urn:getState")
    @WebResult(name = "getStateResult", targetNamespace = "http://dom.gosuslugi.ru/schema/integration/organizations-registry-common/", partName = "getStateResult")
    public GetStateResult getState(
        @WebParam(name = "getStateRequest", targetNamespace = "http://dom.gosuslugi.ru/schema/integration/base/", partName = "getStateRequest")
        GetStateRequest getStateRequest)
        throws Fault
    ;

    /**
     * 
     * @param exportOrgRegistryRequest
     * @return
     *     returns ru.gosuslugi.dom.schema.integration.base.AckRequest
     * @throws Fault
     */
    @WebMethod(action = "urn:exportOrgRegistry")
    @WebResult(name = "AckRequest", targetNamespace = "http://dom.gosuslugi.ru/schema/integration/base/", partName = "AckRequest")
    public AckRequest exportOrgRegistry(
        @WebParam(name = "exportOrgRegistryRequest", targetNamespace = "http://dom.gosuslugi.ru/schema/integration/organizations-registry-common/", partName = "exportOrgRegistryRequest")
        ExportOrgRegistryRequest exportOrgRegistryRequest)
        throws Fault
    ;

    /**
     * экспорт сведений о поставщиках данных
     * 
     * @param exportDataProviderRequest
     * @return
     *     returns ru.gosuslugi.dom.schema.integration.base.AckRequest
     * @throws Fault
     */
    @WebMethod(action = "urn:exportDataProvider")
    @WebResult(name = "AckRequest", targetNamespace = "http://dom.gosuslugi.ru/schema/integration/base/", partName = "AckRequest")
    public AckRequest exportDataProvider(
        @WebParam(name = "exportDataProviderRequest", targetNamespace = "http://dom.gosuslugi.ru/schema/integration/organizations-registry-common/", partName = "exportDataProviderRequest")
        ExportDataProviderRequest exportDataProviderRequest)
        throws Fault
    ;

}
