
package ru.gosuslugi.dom.schema.integration.nsi_common;

import javax.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the ru.gosuslugi.dom.schema.integration.nsi_common package. 
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
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: ru.gosuslugi.dom.schema.integration.nsi_common
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetStateResult }
     * 
     */
    public GetStateResult createGetStateResult() {
        return new GetStateResult();
    }

    /**
     * Create an instance of {@link ExportNsiListRequest }
     * 
     */
    public ExportNsiListRequest createExportNsiListRequest() {
        return new ExportNsiListRequest();
    }

    /**
     * Create an instance of {@link ExportNsiItemRequest }
     * 
     */
    public ExportNsiItemRequest createExportNsiItemRequest() {
        return new ExportNsiItemRequest();
    }

    /**
     * Create an instance of {@link ExportNsiListResult }
     * 
     */
    public ExportNsiListResult createExportNsiListResult() {
        return new ExportNsiListResult();
    }

    /**
     * Create an instance of {@link ExportNsiItemResult }
     * 
     */
    public ExportNsiItemResult createExportNsiItemResult() {
        return new ExportNsiItemResult();
    }

}
