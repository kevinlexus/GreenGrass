
package ru.gosuslugi.dom.schema.integration.organizations_registry_common;

import javax.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the ru.gosuslugi.dom.schema.integration.organizations_registry_common package. 
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
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: ru.gosuslugi.dom.schema.integration.organizations_registry_common
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link ExportOrgRegistryRequest }
     * 
     */
    public ExportOrgRegistryRequest createExportOrgRegistryRequest() {
        return new ExportOrgRegistryRequest();
    }

    /**
     * Create an instance of {@link ExportOrgRegistryResultType }
     * 
     */
    public ExportOrgRegistryResultType createExportOrgRegistryResultType() {
        return new ExportOrgRegistryResultType();
    }

    /**
     * Create an instance of {@link ExportOrgRegistryResultType.OrgVersion }
     * 
     */
    public ExportOrgRegistryResultType.OrgVersion createExportOrgRegistryResultTypeOrgVersion() {
        return new ExportOrgRegistryResultType.OrgVersion();
    }

    /**
     * Create an instance of {@link ExportOrgRegistryResultType.OrgVersion.Subsidiary }
     * 
     */
    public ExportOrgRegistryResultType.OrgVersion.Subsidiary createExportOrgRegistryResultTypeOrgVersionSubsidiary() {
        return new ExportOrgRegistryResultType.OrgVersion.Subsidiary();
    }

    /**
     * Create an instance of {@link GetStateResult }
     * 
     */
    public GetStateResult createGetStateResult() {
        return new GetStateResult();
    }

    /**
     * Create an instance of {@link ExportDataProviderResultType }
     * 
     */
    public ExportDataProviderResultType createExportDataProviderResultType() {
        return new ExportDataProviderResultType();
    }

    /**
     * Create an instance of {@link ExportOrgRegistryRequest.SearchCriteria }
     * 
     */
    public ExportOrgRegistryRequest.SearchCriteria createExportOrgRegistryRequestSearchCriteria() {
        return new ExportOrgRegistryRequest.SearchCriteria();
    }

    /**
     * Create an instance of {@link ExportOrgRegistryResult }
     * 
     */
    public ExportOrgRegistryResult createExportOrgRegistryResult() {
        return new ExportOrgRegistryResult();
    }

    /**
     * Create an instance of {@link ExportDataProviderRequest }
     * 
     */
    public ExportDataProviderRequest createExportDataProviderRequest() {
        return new ExportDataProviderRequest();
    }

    /**
     * Create an instance of {@link ExportDataProviderResult }
     * 
     */
    public ExportDataProviderResult createExportDataProviderResult() {
        return new ExportDataProviderResult();
    }

    /**
     * Create an instance of {@link ExportOrgRegistryResultType.OrgVersion.Subsidiary.ParentOrg }
     * 
     */
    public ExportOrgRegistryResultType.OrgVersion.Subsidiary.ParentOrg createExportOrgRegistryResultTypeOrgVersionSubsidiaryParentOrg() {
        return new ExportOrgRegistryResultType.OrgVersion.Subsidiary.ParentOrg();
    }

}
