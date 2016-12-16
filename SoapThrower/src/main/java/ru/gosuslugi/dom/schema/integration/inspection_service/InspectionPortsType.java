
package ru.gosuslugi.dom.schema.integration.inspection_service;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.bind.annotation.XmlSeeAlso;
import ru.gosuslugi.dom.schema.integration.base.ImportResult;
import ru.gosuslugi.dom.schema.integration.inspection.ExportExaminationsRequest;
import ru.gosuslugi.dom.schema.integration.inspection.ExportExaminationsResult;
import ru.gosuslugi.dom.schema.integration.inspection.ExportInspectionPlansRequest;
import ru.gosuslugi.dom.schema.integration.inspection.ExportInspectionPlansResult;
import ru.gosuslugi.dom.schema.integration.inspection.ImportExaminationsRequest;
import ru.gosuslugi.dom.schema.integration.inspection.ImportInspectionPlanRequest;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebService(name = "InspectionPortsType", targetNamespace = "http://dom.gosuslugi.ru/schema/integration/inspection-service/")
@SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.BARE)
@XmlSeeAlso({
    ru.gosuslugi.dom.schema.integration.base.ObjectFactory.class,
    ru.gosuslugi.dom.schema.integration.inspection.ObjectFactory.class,
    ru.gosuslugi.dom.schema.integration.nsi_base.ObjectFactory.class,
    ru.gosuslugi.dom.schema.integration.organizations_registry_base.ObjectFactory.class,
    org.w3._2000._09.xmldsig_.ObjectFactory.class,
    ru.gosuslugi.dom.schema.integration.organizations_base.ObjectFactory.class
})
public interface InspectionPortsType {


    /**
     * ВИ_ПИЖФ_ИПП. Импорт плана проверок.
     * 
     * @param importInspectionPlanRequest
     * @return
     *     returns ru.gosuslugi.dom.schema.integration.base.ImportResult
     * @throws Fault
     */
    @WebMethod(action = "urn:importInspectionPlan")
    @WebResult(name = "ImportResult", targetNamespace = "http://dom.gosuslugi.ru/schema/integration/base/", partName = "importInspectionPlanResult")
    public ImportResult importInspectionPlan(
        @WebParam(name = "importInspectionPlanRequest", targetNamespace = "http://dom.gosuslugi.ru/schema/integration/inspection/", partName = "importInspectionPlanRequest")
        ImportInspectionPlanRequest importInspectionPlanRequest)
        throws Fault
    ;

    /**
     * ВИ_ПИЖФ_ЭПП. Экспорт плана проверок.
     * 
     * @param exportInspectionPlansRequest
     * @return
     *     returns ru.gosuslugi.dom.schema.integration.inspection.ExportInspectionPlansResult
     * @throws Fault
     */
    @WebMethod(action = "urn:exportInspectionPlans")
    @WebResult(name = "exportInspectionPlansResult", targetNamespace = "http://dom.gosuslugi.ru/schema/integration/inspection/", partName = "exportInspectionPlansResult")
    public ExportInspectionPlansResult exportInspectionPlans(
        @WebParam(name = "exportInspectionPlansRequest", targetNamespace = "http://dom.gosuslugi.ru/schema/integration/inspection/", partName = "exportInspectionPlansRequest")
        ExportInspectionPlansRequest exportInspectionPlansRequest)
        throws Fault
    ;

    /**
     * ВИ_ПИЖФ_ИП. Импорт проверок.
     * 
     * @param importExaminationsRequest
     * @return
     *     returns ru.gosuslugi.dom.schema.integration.base.ImportResult
     * @throws Fault
     */
    @WebMethod(action = "urn:importExaminations")
    @WebResult(name = "ImportResult", targetNamespace = "http://dom.gosuslugi.ru/schema/integration/base/", partName = "importExaminationsResult")
    public ImportResult importExaminations(
        @WebParam(name = "importExaminationsRequest", targetNamespace = "http://dom.gosuslugi.ru/schema/integration/inspection/", partName = "importExaminationsRequest")
        ImportExaminationsRequest importExaminationsRequest)
        throws Fault
    ;

    /**
     * ВИ_ПИЖФ_ЭП. Экспорт проверок.
     * 
     * @param exportExaminationsRequest
     * @return
     *     returns ru.gosuslugi.dom.schema.integration.inspection.ExportExaminationsResult
     * @throws Fault
     */
    @WebMethod(action = "urn:exportExaminations")
    @WebResult(name = "exportExaminationsResult", targetNamespace = "http://dom.gosuslugi.ru/schema/integration/inspection/", partName = "exportExaminationsResult")
    public ExportExaminationsResult exportExaminations(
        @WebParam(name = "exportExaminationsRequest", targetNamespace = "http://dom.gosuslugi.ru/schema/integration/inspection/", partName = "exportExaminationsRequest")
        ExportExaminationsRequest exportExaminationsRequest)
        throws Fault
    ;

}
