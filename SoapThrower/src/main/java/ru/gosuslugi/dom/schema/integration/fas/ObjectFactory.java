
package ru.gosuslugi.dom.schema.integration.fas;

import javax.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the ru.gosuslugi.dom.schema.integration.fas package. 
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
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: ru.gosuslugi.dom.schema.integration.fas
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link ImportRSORequest }
     * 
     */
    public ImportRSORequest createImportRSORequest() {
        return new ImportRSORequest();
    }

    /**
     * Create an instance of {@link ImportRSORequest.RSO }
     * 
     */
    public ImportRSORequest.RSO createImportRSORequestRSO() {
        return new ImportRSORequest.RSO();
    }

    /**
     * Create an instance of {@link ImportRSORequest.RSO.RSOActualDATA }
     * 
     */
    public ImportRSORequest.RSO.RSOActualDATA createImportRSORequestRSORSOActualDATA() {
        return new ImportRSORequest.RSO.RSOActualDATA();
    }

    /**
     * Create an instance of {@link GetStateResult }
     * 
     */
    public GetStateResult createGetStateResult() {
        return new GetStateResult();
    }

    /**
     * Create an instance of {@link ImportRSORequest.RSO.RemoveRSO }
     * 
     */
    public ImportRSORequest.RSO.RemoveRSO createImportRSORequestRSORemoveRSO() {
        return new ImportRSORequest.RSO.RemoveRSO();
    }

    /**
     * Create an instance of {@link ImportRSORequest.RSO.RSOActualDATA.Resource }
     * 
     */
    public ImportRSORequest.RSO.RSOActualDATA.Resource createImportRSORequestRSORSOActualDATAResource() {
        return new ImportRSORequest.RSO.RSOActualDATA.Resource();
    }

    /**
     * Create an instance of {@link ImportRSORequest.RSO.RSOActualDATA.RegistryOfNaturalMonopolies }
     * 
     */
    public ImportRSORequest.RSO.RSOActualDATA.RegistryOfNaturalMonopolies createImportRSORequestRSORSOActualDATARegistryOfNaturalMonopolies() {
        return new ImportRSORequest.RSO.RSOActualDATA.RegistryOfNaturalMonopolies();
    }

    /**
     * Create an instance of {@link ImportRSORequest.RSO.RSOActualDATA.RegistryGuaranteeingSuppliers }
     * 
     */
    public ImportRSORequest.RSO.RSOActualDATA.RegistryGuaranteeingSuppliers createImportRSORequestRSORSOActualDATARegistryGuaranteeingSuppliers() {
        return new ImportRSORequest.RSO.RSOActualDATA.RegistryGuaranteeingSuppliers();
    }

}
