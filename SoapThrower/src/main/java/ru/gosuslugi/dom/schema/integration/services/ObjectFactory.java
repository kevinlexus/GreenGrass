
package ru.gosuslugi.dom.schema.integration.services;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the ru.gosuslugi.dom.schema.integration.services package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _WorkListStatus_QNAME = new QName("http://dom.gosuslugi.ru/schema/integration/services/", "WorkListStatus");
    private final static QName _HMServicesTarifsDocTypeKUMServiceTypeName_QNAME = new QName("http://dom.gosuslugi.ru/schema/integration/services/", "Name");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: ru.gosuslugi.dom.schema.integration.services
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link ExportWorkingPlanRequest }
     * 
     */
    public ExportWorkingPlanRequest createExportWorkingPlanRequest() {
        return new ExportWorkingPlanRequest();
    }

    /**
     * Create an instance of {@link ImportWorkingListRequest }
     * 
     */
    public ImportWorkingListRequest createImportWorkingListRequest() {
        return new ImportWorkingListRequest();
    }

    /**
     * Create an instance of {@link ExportWorkingListRequest }
     * 
     */
    public ExportWorkingListRequest createExportWorkingListRequest() {
        return new ExportWorkingListRequest();
    }

    /**
     * Create an instance of {@link CompletedWorkType }
     * 
     */
    public CompletedWorkType createCompletedWorkType() {
        return new CompletedWorkType();
    }

    /**
     * Create an instance of {@link CompletedWorksByPeriodExportType }
     * 
     */
    public CompletedWorksByPeriodExportType createCompletedWorksByPeriodExportType() {
        return new CompletedWorksByPeriodExportType();
    }

    /**
     * Create an instance of {@link CompletedWorksByPeriodExportType.UnplannedWork }
     * 
     */
    public CompletedWorksByPeriodExportType.UnplannedWork createCompletedWorksByPeriodExportTypeUnplannedWork() {
        return new CompletedWorksByPeriodExportType.UnplannedWork();
    }

    /**
     * Create an instance of {@link CompletedWorkExportType }
     * 
     */
    public CompletedWorkExportType createCompletedWorkExportType() {
        return new CompletedWorkExportType();
    }

    /**
     * Create an instance of {@link WorkingListBaseType }
     * 
     */
    public WorkingListBaseType createWorkingListBaseType() {
        return new WorkingListBaseType();
    }

    /**
     * Create an instance of {@link HMServicesTarifsDocType }
     * 
     */
    public HMServicesTarifsDocType createHMServicesTarifsDocType() {
        return new HMServicesTarifsDocType();
    }

    /**
     * Create an instance of {@link HMServicesTarifsDocType.KU }
     * 
     */
    public HMServicesTarifsDocType.KU createHMServicesTarifsDocTypeKU() {
        return new HMServicesTarifsDocType.KU();
    }

    /**
     * Create an instance of {@link HMServicesTarifsDocType.GKU }
     * 
     */
    public HMServicesTarifsDocType.GKU createHMServicesTarifsDocTypeGKU() {
        return new HMServicesTarifsDocType.GKU();
    }

    /**
     * Create an instance of {@link ImportWorkingListRequest.ApprovedWorkingListData }
     * 
     */
    public ImportWorkingListRequest.ApprovedWorkingListData createImportWorkingListRequestApprovedWorkingListData() {
        return new ImportWorkingListRequest.ApprovedWorkingListData();
    }

    /**
     * Create an instance of {@link WorkingPlanType }
     * 
     */
    public WorkingPlanType createWorkingPlanType() {
        return new WorkingPlanType();
    }

    /**
     * Create an instance of {@link CompletedWorksByPeriodType }
     * 
     */
    public CompletedWorksByPeriodType createCompletedWorksByPeriodType() {
        return new CompletedWorksByPeriodType();
    }

    /**
     * Create an instance of {@link CompletedWorksByPeriodType.UnplannedWork }
     * 
     */
    public CompletedWorksByPeriodType.UnplannedWork createCompletedWorksByPeriodTypeUnplannedWork() {
        return new CompletedWorksByPeriodType.UnplannedWork();
    }

    /**
     * Create an instance of {@link ExportWorkingPlanResultType }
     * 
     */
    public ExportWorkingPlanResultType createExportWorkingPlanResultType() {
        return new ExportWorkingPlanResultType();
    }

    /**
     * Create an instance of {@link ExportWorkingPlanResultType.WorkingPlan }
     * 
     */
    public ExportWorkingPlanResultType.WorkingPlan createExportWorkingPlanResultTypeWorkingPlan() {
        return new ExportWorkingPlanResultType.WorkingPlan();
    }

    /**
     * Create an instance of {@link ExportWorkingPlanResultType.WorkingPlan.ReportingPeriod }
     * 
     */
    public ExportWorkingPlanResultType.WorkingPlan.ReportingPeriod createExportWorkingPlanResultTypeWorkingPlanReportingPeriod() {
        return new ExportWorkingPlanResultType.WorkingPlan.ReportingPeriod();
    }

    /**
     * Create an instance of {@link ExportWorkingListResultType }
     * 
     */
    public ExportWorkingListResultType createExportWorkingListResultType() {
        return new ExportWorkingListResultType();
    }

    /**
     * Create an instance of {@link ExportWorkingListResultType.WorkingList }
     * 
     */
    public ExportWorkingListResultType.WorkingList createExportWorkingListResultTypeWorkingList() {
        return new ExportWorkingListResultType.WorkingList();
    }

    /**
     * Create an instance of {@link GetStateResult }
     * 
     */
    public GetStateResult createGetStateResult() {
        return new GetStateResult();
    }

    /**
     * Create an instance of {@link ExportHMServicesTarifsResultType }
     * 
     */
    public ExportHMServicesTarifsResultType createExportHMServicesTarifsResultType() {
        return new ExportHMServicesTarifsResultType();
    }

    /**
     * Create an instance of {@link ExportCompletedWorksResultType }
     * 
     */
    public ExportCompletedWorksResultType createExportCompletedWorksResultType() {
        return new ExportCompletedWorksResultType();
    }

    /**
     * Create an instance of {@link ImportCompletedWorksRequest }
     * 
     */
    public ImportCompletedWorksRequest createImportCompletedWorksRequest() {
        return new ImportCompletedWorksRequest();
    }

    /**
     * Create an instance of {@link ExportHMServicesTarifsRequest }
     * 
     */
    public ExportHMServicesTarifsRequest createExportHMServicesTarifsRequest() {
        return new ExportHMServicesTarifsRequest();
    }

    /**
     * Create an instance of {@link ExportCompletedWorksRequest }
     * 
     */
    public ExportCompletedWorksRequest createExportCompletedWorksRequest() {
        return new ExportCompletedWorksRequest();
    }

    /**
     * Create an instance of {@link ExportCompletedWorksResult }
     * 
     */
    public ExportCompletedWorksResult createExportCompletedWorksResult() {
        return new ExportCompletedWorksResult();
    }

    /**
     * Create an instance of {@link ExportWorkingPlanResult }
     * 
     */
    public ExportWorkingPlanResult createExportWorkingPlanResult() {
        return new ExportWorkingPlanResult();
    }

    /**
     * Create an instance of {@link ExportWorkingPlanRequest.Work }
     * 
     */
    public ExportWorkingPlanRequest.Work createExportWorkingPlanRequestWork() {
        return new ExportWorkingPlanRequest.Work();
    }

    /**
     * Create an instance of {@link ExportWorkingListResult }
     * 
     */
    public ExportWorkingListResult createExportWorkingListResult() {
        return new ExportWorkingListResult();
    }

    /**
     * Create an instance of {@link ExportHMServicesTarifsResult }
     * 
     */
    public ExportHMServicesTarifsResult createExportHMServicesTarifsResult() {
        return new ExportHMServicesTarifsResult();
    }

    /**
     * Create an instance of {@link ImportWorkingPlanRequest }
     * 
     */
    public ImportWorkingPlanRequest createImportWorkingPlanRequest() {
        return new ImportWorkingPlanRequest();
    }

    /**
     * Create an instance of {@link ImportWorkingListRequest.CancelWorkingList }
     * 
     */
    public ImportWorkingListRequest.CancelWorkingList createImportWorkingListRequestCancelWorkingList() {
        return new ImportWorkingListRequest.CancelWorkingList();
    }

    /**
     * Create an instance of {@link ExportWorkingListRequest.MonthYearFrom }
     * 
     */
    public ExportWorkingListRequest.MonthYearFrom createExportWorkingListRequestMonthYearFrom() {
        return new ExportWorkingListRequest.MonthYearFrom();
    }

    /**
     * Create an instance of {@link ExportWorkingListRequest.MonthYearTo }
     * 
     */
    public ExportWorkingListRequest.MonthYearTo createExportWorkingListRequestMonthYearTo() {
        return new ExportWorkingListRequest.MonthYearTo();
    }

    /**
     * Create an instance of {@link WorkingListItemType }
     * 
     */
    public WorkingListItemType createWorkingListItemType() {
        return new WorkingListItemType();
    }

    /**
     * Create an instance of {@link WorkingListItemExportType }
     * 
     */
    public WorkingListItemExportType createWorkingListItemExportType() {
        return new WorkingListItemExportType();
    }

    /**
     * Create an instance of {@link CompletedWorkType.MonthlyWork }
     * 
     */
    public CompletedWorkType.MonthlyWork createCompletedWorkTypeMonthlyWork() {
        return new CompletedWorkType.MonthlyWork();
    }

    /**
     * Create an instance of {@link CompletedWorksByPeriodExportType.PlannedWork }
     * 
     */
    public CompletedWorksByPeriodExportType.PlannedWork createCompletedWorksByPeriodExportTypePlannedWork() {
        return new CompletedWorksByPeriodExportType.PlannedWork();
    }

    /**
     * Create an instance of {@link CompletedWorksByPeriodExportType.Act }
     * 
     */
    public CompletedWorksByPeriodExportType.Act createCompletedWorksByPeriodExportTypeAct() {
        return new CompletedWorksByPeriodExportType.Act();
    }

    /**
     * Create an instance of {@link CompletedWorksByPeriodExportType.UnplannedWork.Accident }
     * 
     */
    public CompletedWorksByPeriodExportType.UnplannedWork.Accident createCompletedWorksByPeriodExportTypeUnplannedWorkAccident() {
        return new CompletedWorksByPeriodExportType.UnplannedWork.Accident();
    }

    /**
     * Create an instance of {@link CompletedWorksByPeriodExportType.UnplannedWork.DeliveryRestriction }
     * 
     */
    public CompletedWorksByPeriodExportType.UnplannedWork.DeliveryRestriction createCompletedWorksByPeriodExportTypeUnplannedWorkDeliveryRestriction() {
        return new CompletedWorksByPeriodExportType.UnplannedWork.DeliveryRestriction();
    }

    /**
     * Create an instance of {@link CompletedWorkExportType.MonthlyWork }
     * 
     */
    public CompletedWorkExportType.MonthlyWork createCompletedWorkExportTypeMonthlyWork() {
        return new CompletedWorkExportType.MonthlyWork();
    }

    /**
     * Create an instance of {@link WorkingListBaseType.MonthYearFrom }
     * 
     */
    public WorkingListBaseType.MonthYearFrom createWorkingListBaseTypeMonthYearFrom() {
        return new WorkingListBaseType.MonthYearFrom();
    }

    /**
     * Create an instance of {@link WorkingListBaseType.MonthYearTo }
     * 
     */
    public WorkingListBaseType.MonthYearTo createWorkingListBaseTypeMonthYearTo() {
        return new WorkingListBaseType.MonthYearTo();
    }

    /**
     * Create an instance of {@link HMServicesTarifsDocType.KU.MServiceType }
     * 
     */
    public HMServicesTarifsDocType.KU.MServiceType createHMServicesTarifsDocTypeKUMServiceType() {
        return new HMServicesTarifsDocType.KU.MServiceType();
    }

    /**
     * Create an instance of {@link HMServicesTarifsDocType.GKU.SKI }
     * 
     */
    public HMServicesTarifsDocType.GKU.SKI createHMServicesTarifsDocTypeGKUSKI() {
        return new HMServicesTarifsDocType.GKU.SKI();
    }

    /**
     * Create an instance of {@link ImportWorkingListRequest.ApprovedWorkingListData.WorkListItem }
     * 
     */
    public ImportWorkingListRequest.ApprovedWorkingListData.WorkListItem createImportWorkingListRequestApprovedWorkingListDataWorkListItem() {
        return new ImportWorkingListRequest.ApprovedWorkingListData.WorkListItem();
    }

    /**
     * Create an instance of {@link WorkingPlanType.WorkPlanItem }
     * 
     */
    public WorkingPlanType.WorkPlanItem createWorkingPlanTypeWorkPlanItem() {
        return new WorkingPlanType.WorkPlanItem();
    }

    /**
     * Create an instance of {@link CompletedWorksByPeriodType.PlannedWork }
     * 
     */
    public CompletedWorksByPeriodType.PlannedWork createCompletedWorksByPeriodTypePlannedWork() {
        return new CompletedWorksByPeriodType.PlannedWork();
    }

    /**
     * Create an instance of {@link CompletedWorksByPeriodType.NewAct }
     * 
     */
    public CompletedWorksByPeriodType.NewAct createCompletedWorksByPeriodTypeNewAct() {
        return new CompletedWorksByPeriodType.NewAct();
    }

    /**
     * Create an instance of {@link CompletedWorksByPeriodType.ExistedAct }
     * 
     */
    public CompletedWorksByPeriodType.ExistedAct createCompletedWorksByPeriodTypeExistedAct() {
        return new CompletedWorksByPeriodType.ExistedAct();
    }

    /**
     * Create an instance of {@link CompletedWorksByPeriodType.UnplannedWork.Accident }
     * 
     */
    public CompletedWorksByPeriodType.UnplannedWork.Accident createCompletedWorksByPeriodTypeUnplannedWorkAccident() {
        return new CompletedWorksByPeriodType.UnplannedWork.Accident();
    }

    /**
     * Create an instance of {@link CompletedWorksByPeriodType.UnplannedWork.DeliveryRestriction }
     * 
     */
    public CompletedWorksByPeriodType.UnplannedWork.DeliveryRestriction createCompletedWorksByPeriodTypeUnplannedWorkDeliveryRestriction() {
        return new CompletedWorksByPeriodType.UnplannedWork.DeliveryRestriction();
    }

    /**
     * Create an instance of {@link ExportWorkingPlanResultType.WorkingPlan.ReportingPeriod.MonthYear }
     * 
     */
    public ExportWorkingPlanResultType.WorkingPlan.ReportingPeriod.MonthYear createExportWorkingPlanResultTypeWorkingPlanReportingPeriodMonthYear() {
        return new ExportWorkingPlanResultType.WorkingPlan.ReportingPeriod.MonthYear();
    }

    /**
     * Create an instance of {@link ExportWorkingPlanResultType.WorkingPlan.ReportingPeriod.WorkPlanItem }
     * 
     */
    public ExportWorkingPlanResultType.WorkingPlan.ReportingPeriod.WorkPlanItem createExportWorkingPlanResultTypeWorkingPlanReportingPeriodWorkPlanItem() {
        return new ExportWorkingPlanResultType.WorkingPlan.ReportingPeriod.WorkPlanItem();
    }

    /**
     * Create an instance of {@link ExportWorkingListResultType.WorkingList.WorkListItem }
     * 
     */
    public ExportWorkingListResultType.WorkingList.WorkListItem createExportWorkingListResultTypeWorkingListWorkListItem() {
        return new ExportWorkingListResultType.WorkingList.WorkListItem();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://dom.gosuslugi.ru/schema/integration/services/", name = "WorkListStatus")
    public JAXBElement<String> createWorkListStatus(String value) {
        return new JAXBElement<String>(_WorkListStatus_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://dom.gosuslugi.ru/schema/integration/services/", name = "Name", scope = HMServicesTarifsDocType.KU.MServiceType.class)
    public JAXBElement<String> createHMServicesTarifsDocTypeKUMServiceTypeName(String value) {
        return new JAXBElement<String>(_HMServicesTarifsDocTypeKUMServiceTypeName_QNAME, String.class, HMServicesTarifsDocType.KU.MServiceType.class, value);
    }

}
