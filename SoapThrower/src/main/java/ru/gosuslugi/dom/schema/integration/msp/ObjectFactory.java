
package ru.gosuslugi.dom.schema.integration.msp;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the ru.gosuslugi.dom.schema.integration.msp package. 
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

    private final static QName _Status_QNAME = new QName("http://dom.gosuslugi.ru/schema/integration/msp/", "Status");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: ru.gosuslugi.dom.schema.integration.msp
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link ImportCitizenCompensationRequest }
     * 
     */
    public ImportCitizenCompensationRequest createImportCitizenCompensationRequest() {
        return new ImportCitizenCompensationRequest();
    }

    /**
     * Create an instance of {@link ImportCitizenSubsidyRequest }
     * 
     */
    public ImportCitizenSubsidyRequest createImportCitizenSubsidyRequest() {
        return new ImportCitizenSubsidyRequest();
    }

    /**
     * Create an instance of {@link ImportCitizenSubsidyRequest.ImportCitizenSubsidy }
     * 
     */
    public ImportCitizenSubsidyRequest.ImportCitizenSubsidy createImportCitizenSubsidyRequestImportCitizenSubsidy() {
        return new ImportCitizenSubsidyRequest.ImportCitizenSubsidy();
    }

    /**
     * Create an instance of {@link ImportCitizenCompensationRequest.ImportCitizenCompensation }
     * 
     */
    public ImportCitizenCompensationRequest.ImportCitizenCompensation createImportCitizenCompensationRequestImportCitizenCompensation() {
        return new ImportCitizenCompensationRequest.ImportCitizenCompensation();
    }

    /**
     * Create an instance of {@link ExportCitizenCompensationType }
     * 
     */
    public ExportCitizenCompensationType createExportCitizenCompensationType() {
        return new ExportCitizenCompensationType();
    }

    /**
     * Create an instance of {@link ExportCategoryType }
     * 
     */
    public ExportCategoryType createExportCategoryType() {
        return new ExportCategoryType();
    }

    /**
     * Create an instance of {@link ExportCitizenSubsidyType }
     * 
     */
    public ExportCitizenSubsidyType createExportCitizenSubsidyType() {
        return new ExportCitizenSubsidyType();
    }

    /**
     * Create an instance of {@link ExportCitizenSubsidyResult }
     * 
     */
    public ExportCitizenSubsidyResult createExportCitizenSubsidyResult() {
        return new ExportCitizenSubsidyResult();
    }

    /**
     * Create an instance of {@link GetStateResult }
     * 
     */
    public GetStateResult createGetStateResult() {
        return new GetStateResult();
    }

    /**
     * Create an instance of {@link ExportCategoriesRequest }
     * 
     */
    public ExportCategoriesRequest createExportCategoriesRequest() {
        return new ExportCategoriesRequest();
    }

    /**
     * Create an instance of {@link ExportCitizenSubsidyRequest }
     * 
     */
    public ExportCitizenSubsidyRequest createExportCitizenSubsidyRequest() {
        return new ExportCitizenSubsidyRequest();
    }

    /**
     * Create an instance of {@link ExportCitizenCompensationResult }
     * 
     */
    public ExportCitizenCompensationResult createExportCitizenCompensationResult() {
        return new ExportCitizenCompensationResult();
    }

    /**
     * Create an instance of {@link ExportCitizenCompensationRequest }
     * 
     */
    public ExportCitizenCompensationRequest createExportCitizenCompensationRequest() {
        return new ExportCitizenCompensationRequest();
    }

    /**
     * Create an instance of {@link ExportCategoriesResult }
     * 
     */
    public ExportCategoriesResult createExportCategoriesResult() {
        return new ExportCategoriesResult();
    }

    /**
     * Create an instance of {@link FixedCompensationType }
     * 
     */
    public FixedCompensationType createFixedCompensationType() {
        return new FixedCompensationType();
    }

    /**
     * Create an instance of {@link MSPIndType }
     * 
     */
    public MSPIndType createMSPIndType() {
        return new MSPIndType();
    }

    /**
     * Create an instance of {@link DecisionType }
     * 
     */
    public DecisionType createDecisionType() {
        return new DecisionType();
    }

    /**
     * Create an instance of {@link StandardCompensationType }
     * 
     */
    public StandardCompensationType createStandardCompensationType() {
        return new StandardCompensationType();
    }

    /**
     * Create an instance of {@link ExportCitizenSubsidyCalculationType }
     * 
     */
    public ExportCitizenSubsidyCalculationType createExportCitizenSubsidyCalculationType() {
        return new ExportCitizenSubsidyCalculationType();
    }

    /**
     * Create an instance of {@link PaymentType }
     * 
     */
    public PaymentType createPaymentType() {
        return new PaymentType();
    }

    /**
     * Create an instance of {@link CitizenCompensationCalculationType }
     * 
     */
    public CitizenCompensationCalculationType createCitizenCompensationCalculationType() {
        return new CitizenCompensationCalculationType();
    }

    /**
     * Create an instance of {@link ActType }
     * 
     */
    public ActType createActType() {
        return new ActType();
    }

    /**
     * Create an instance of {@link ActualCompensationType }
     * 
     */
    public ActualCompensationType createActualCompensationType() {
        return new ActualCompensationType();
    }

    /**
     * Create an instance of {@link ExportPaymentType }
     * 
     */
    public ExportPaymentType createExportPaymentType() {
        return new ExportPaymentType();
    }

    /**
     * Create an instance of {@link CitizenSubsidyOverviewType }
     * 
     */
    public CitizenSubsidyOverviewType createCitizenSubsidyOverviewType() {
        return new CitizenSubsidyOverviewType();
    }

    /**
     * Create an instance of {@link CitizenSubsidyCalculationType }
     * 
     */
    public CitizenSubsidyCalculationType createCitizenSubsidyCalculationType() {
        return new CitizenSubsidyCalculationType();
    }

    /**
     * Create an instance of {@link CitizenCompensationCategoryType }
     * 
     */
    public CitizenCompensationCategoryType createCitizenCompensationCategoryType() {
        return new CitizenCompensationCategoryType();
    }

    /**
     * Create an instance of {@link ExportCitizenCompensationCalculationType }
     * 
     */
    public ExportCitizenCompensationCalculationType createExportCitizenCompensationCalculationType() {
        return new ExportCitizenCompensationCalculationType();
    }

    /**
     * Create an instance of {@link CitizenCompensationOverviewType }
     * 
     */
    public CitizenCompensationOverviewType createCitizenCompensationOverviewType() {
        return new CitizenCompensationOverviewType();
    }

    /**
     * Create an instance of {@link ImportCitizenSubsidyRequest.ImportCitizenSubsidy.Calculation }
     * 
     */
    public ImportCitizenSubsidyRequest.ImportCitizenSubsidy.Calculation createImportCitizenSubsidyRequestImportCitizenSubsidyCalculation() {
        return new ImportCitizenSubsidyRequest.ImportCitizenSubsidy.Calculation();
    }

    /**
     * Create an instance of {@link ImportCitizenSubsidyRequest.ImportCitizenSubsidy.Payment }
     * 
     */
    public ImportCitizenSubsidyRequest.ImportCitizenSubsidy.Payment createImportCitizenSubsidyRequestImportCitizenSubsidyPayment() {
        return new ImportCitizenSubsidyRequest.ImportCitizenSubsidy.Payment();
    }

    /**
     * Create an instance of {@link ImportCitizenCompensationRequest.ImportCitizenCompensation.Calculation }
     * 
     */
    public ImportCitizenCompensationRequest.ImportCitizenCompensation.Calculation createImportCitizenCompensationRequestImportCitizenCompensationCalculation() {
        return new ImportCitizenCompensationRequest.ImportCitizenCompensation.Calculation();
    }

    /**
     * Create an instance of {@link ImportCitizenCompensationRequest.ImportCitizenCompensation.Payment }
     * 
     */
    public ImportCitizenCompensationRequest.ImportCitizenCompensation.Payment createImportCitizenCompensationRequestImportCitizenCompensationPayment() {
        return new ImportCitizenCompensationRequest.ImportCitizenCompensation.Payment();
    }

    /**
     * Create an instance of {@link ExportCitizenCompensationType.Overview }
     * 
     */
    public ExportCitizenCompensationType.Overview createExportCitizenCompensationTypeOverview() {
        return new ExportCitizenCompensationType.Overview();
    }

    /**
     * Create an instance of {@link ExportCategoryType.Territory }
     * 
     */
    public ExportCategoryType.Territory createExportCategoryTypeTerritory() {
        return new ExportCategoryType.Territory();
    }

    /**
     * Create an instance of {@link ExportCategoryType.Actual }
     * 
     */
    public ExportCategoryType.Actual createExportCategoryTypeActual() {
        return new ExportCategoryType.Actual();
    }

    /**
     * Create an instance of {@link ExportCitizenSubsidyType.Overview }
     * 
     */
    public ExportCitizenSubsidyType.Overview createExportCitizenSubsidyTypeOverview() {
        return new ExportCitizenSubsidyType.Overview();
    }

    /**
     * Create an instance of {@link ExportCitizenSubsidyType.Payment }
     * 
     */
    public ExportCitizenSubsidyType.Payment createExportCitizenSubsidyTypePayment() {
        return new ExportCitizenSubsidyType.Payment();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://dom.gosuslugi.ru/schema/integration/msp/", name = "Status")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    public JAXBElement<String> createStatus(String value) {
        return new JAXBElement<String>(_Status_QNAME, String.class, null, value);
    }

}
