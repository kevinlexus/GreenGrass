
package ru.gosuslugi.dom.schema.integration.msp_service_async;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.bind.annotation.XmlSeeAlso;
import ru.gosuslugi.dom.schema.integration.base.AckRequest;
import ru.gosuslugi.dom.schema.integration.base.GetStateRequest;
import ru.gosuslugi.dom.schema.integration.msp.ExportCategoriesRequest;
import ru.gosuslugi.dom.schema.integration.msp.GetStateResult;
import ru.gosuslugi.dom.schema.integration.msp.ImportCitizenCompensationRequest;
import ru.gosuslugi.dom.schema.integration.msp.ImportCitizenSubsidyRequest;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebService(name = "MSPAsyncPort", targetNamespace = "http://dom.gosuslugi.ru/schema/integration/msp-service-async/")
@SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.BARE)
@XmlSeeAlso({
    ru.gosuslugi.dom.schema.integration.msp.ObjectFactory.class,
    ru.gosuslugi.dom.schema.integration.base.ObjectFactory.class,
    ru.gosuslugi.dom.schema.integration.nsi_base.ObjectFactory.class,
    org.w3._2000._09.xmldsig_.ObjectFactory.class,
    ru.gosuslugi.dom.schema.integration.bills_base.ObjectFactory.class,
    ru.gosuslugi.dom.schema.integration.individual_registry_base.ObjectFactory.class
})
public interface MSPAsyncPort {


    /**
     * Результат обработки асинхронного вызова
     * 
     * @param getStateRequest
     * @return
     *     returns ru.gosuslugi.dom.schema.integration.msp.GetStateResult
     * @throws Fault
     */
    @WebMethod(action = "urn:getState")
    @WebResult(name = "getStateResult", targetNamespace = "http://dom.gosuslugi.ru/schema/integration/msp/", partName = "getStateResult")
    public GetStateResult getState(
        @WebParam(name = "getStateRequest", targetNamespace = "http://dom.gosuslugi.ru/schema/integration/base/", partName = "getStateRequest")
        GetStateRequest getStateRequest)
        throws Fault
    ;

    /**
     * Импорт сведений о гражданах, получающих субсидии
     * 
     * @param importCitizenSubsidyRequest
     * @return
     *     returns ru.gosuslugi.dom.schema.integration.base.AckRequest
     * @throws Fault
     */
    @WebMethod(action = "urn:importCitizenSubsidy")
    @WebResult(name = "AckRequest", targetNamespace = "http://dom.gosuslugi.ru/schema/integration/base/", partName = "importCitizenSubsidyResult")
    public AckRequest importCitizenSubsidy(
        @WebParam(name = "importCitizenSubsidyRequest", targetNamespace = "http://dom.gosuslugi.ru/schema/integration/msp/", partName = "importCitizenSubsidyRequest")
        ImportCitizenSubsidyRequest importCitizenSubsidyRequest)
        throws Fault
    ;

    /**
     * Импорт сведений о гражданах, получающих компенсации расходов
     * 
     * @param importCitizenCompensationRequest
     * @return
     *     returns ru.gosuslugi.dom.schema.integration.base.AckRequest
     * @throws Fault
     */
    @WebMethod(action = "urn:importCitizenCompensation")
    @WebResult(name = "AckRequest", targetNamespace = "http://dom.gosuslugi.ru/schema/integration/base/", partName = "importCitizenCompensationResult")
    public AckRequest importCitizenCompensation(
        @WebParam(name = "importCitizenCompensationRequest", targetNamespace = "http://dom.gosuslugi.ru/schema/integration/msp/", partName = "importCitizenCompensationRequest")
        ImportCitizenCompensationRequest importCitizenCompensationRequest)
        throws Fault
    ;

    /**
     * Экспорт перечня отдельных категорий граждан, имеющих право на получение компенсации расходов
     * 
     * @param exportCategoriesRequest
     * @return
     *     returns ru.gosuslugi.dom.schema.integration.base.AckRequest
     * @throws Fault
     */
    @WebMethod(action = "urn:exportCategories")
    @WebResult(name = "AckRequest", targetNamespace = "http://dom.gosuslugi.ru/schema/integration/base/", partName = "exportCategoriesResult")
    public AckRequest exportCategories(
        @WebParam(name = "exportCategoriesRequest", targetNamespace = "http://dom.gosuslugi.ru/schema/integration/msp/", partName = "exportCategoriesRequest")
        ExportCategoriesRequest exportCategoriesRequest)
        throws Fault
    ;

}
