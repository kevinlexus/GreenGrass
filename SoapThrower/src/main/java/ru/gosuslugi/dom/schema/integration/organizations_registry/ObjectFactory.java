
package ru.gosuslugi.dom.schema.integration.organizations_registry;

import javax.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the ru.gosuslugi.dom.schema.integration.organizations_registry package. 
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


    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: ru.gosuslugi.dom.schema.integration.organizations_registry
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link ImportSubsidiaryRequest }
     * 
     */
    public ImportSubsidiaryRequest createImportSubsidiaryRequest() {
        return new ImportSubsidiaryRequest();
    }

    /**
     * Create an instance of {@link ImportForeignBranchRequest }
     * 
     */
    public ImportForeignBranchRequest createImportForeignBranchRequest() {
        return new ImportForeignBranchRequest();
    }

    /**
     * Create an instance of {@link SubsidiaryImportType }
     * 
     */
    public SubsidiaryImportType createSubsidiaryImportType() {
        return new SubsidiaryImportType();
    }

    /**
     * Create an instance of {@link SubsidiaryImportType.UpdateSubsidiary }
     * 
     */
    public SubsidiaryImportType.UpdateSubsidiary createSubsidiaryImportTypeUpdateSubsidiary() {
        return new SubsidiaryImportType.UpdateSubsidiary();
    }

    /**
     * Create an instance of {@link ForeignBranchImportType }
     * 
     */
    public ForeignBranchImportType createForeignBranchImportType() {
        return new ForeignBranchImportType();
    }

    /**
     * Create an instance of {@link GetStateResult }
     * 
     */
    public GetStateResult createGetStateResult() {
        return new GetStateResult();
    }

    /**
     * Create an instance of {@link ImportSubsidiaryRequest.Subsidiary }
     * 
     */
    public ImportSubsidiaryRequest.Subsidiary createImportSubsidiaryRequestSubsidiary() {
        return new ImportSubsidiaryRequest.Subsidiary();
    }

    /**
     * Create an instance of {@link ImportForeignBranchRequest.ForeignBranch }
     * 
     */
    public ImportForeignBranchRequest.ForeignBranch createImportForeignBranchRequestForeignBranch() {
        return new ImportForeignBranchRequest.ForeignBranch();
    }

    /**
     * Create an instance of {@link SubsidiaryImportType.CreateSubsidiary }
     * 
     */
    public SubsidiaryImportType.CreateSubsidiary createSubsidiaryImportTypeCreateSubsidiary() {
        return new SubsidiaryImportType.CreateSubsidiary();
    }

    /**
     * Create an instance of {@link SubsidiaryImportType.UpdateSubsidiary.SourceName }
     * 
     */
    public SubsidiaryImportType.UpdateSubsidiary.SourceName createSubsidiaryImportTypeUpdateSubsidiarySourceName() {
        return new SubsidiaryImportType.UpdateSubsidiary.SourceName();
    }

    /**
     * Create an instance of {@link ForeignBranchImportType.UpdateForeignBranch }
     * 
     */
    public ForeignBranchImportType.UpdateForeignBranch createForeignBranchImportTypeUpdateForeignBranch() {
        return new ForeignBranchImportType.UpdateForeignBranch();
    }

}
