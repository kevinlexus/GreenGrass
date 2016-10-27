
package ru.gosuslugi.dom.schema.integration.nsi_base;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the ru.gosuslugi.dom.schema.integration.nsi_base package. 
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

    private final static QName _ListGroup_QNAME = new QName("http://dom.gosuslugi.ru/schema/integration/nsi-base/", "ListGroup");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: ru.gosuslugi.dom.schema.integration.nsi_base
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link NsiElementFiasAddressRefFieldType }
     * 
     */
    public NsiElementFiasAddressRefFieldType createNsiElementFiasAddressRefFieldType() {
        return new NsiElementFiasAddressRefFieldType();
    }

    /**
     * Create an instance of {@link NsiElementEnumFieldType }
     * 
     */
    public NsiElementEnumFieldType createNsiElementEnumFieldType() {
        return new NsiElementEnumFieldType();
    }

    /**
     * Create an instance of {@link NsiElementNsiRefFieldType }
     * 
     */
    public NsiElementNsiRefFieldType createNsiElementNsiRefFieldType() {
        return new NsiElementNsiRefFieldType();
    }

    /**
     * Create an instance of {@link NsiElementNsiFieldType }
     * 
     */
    public NsiElementNsiFieldType createNsiElementNsiFieldType() {
        return new NsiElementNsiFieldType();
    }

    /**
     * Create an instance of {@link ru.gosuslugi.dom.schema.integration.nsi_base.NsiRef }
     * 
     */
    public ru.gosuslugi.dom.schema.integration.nsi_base.NsiRef createNsiRef() {
        return new ru.gosuslugi.dom.schema.integration.nsi_base.NsiRef();
    }

    /**
     * Create an instance of {@link NsiElementIntegerFieldType }
     * 
     */
    public NsiElementIntegerFieldType createNsiElementIntegerFieldType() {
        return new NsiElementIntegerFieldType();
    }

    /**
     * Create an instance of {@link NsiItemInfoType }
     * 
     */
    public NsiItemInfoType createNsiItemInfoType() {
        return new NsiItemInfoType();
    }

    /**
     * Create an instance of {@link NsiElementBooleanFieldType }
     * 
     */
    public NsiElementBooleanFieldType createNsiElementBooleanFieldType() {
        return new NsiElementBooleanFieldType();
    }

    /**
     * Create an instance of {@link NsiElementAttachmentFieldType }
     * 
     */
    public NsiElementAttachmentFieldType createNsiElementAttachmentFieldType() {
        return new NsiElementAttachmentFieldType();
    }

    /**
     * Create an instance of {@link NsiElementStringFieldType }
     * 
     */
    public NsiElementStringFieldType createNsiElementStringFieldType() {
        return new NsiElementStringFieldType();
    }

    /**
     * Create an instance of {@link NsiListType }
     * 
     */
    public NsiListType createNsiListType() {
        return new NsiListType();
    }

    /**
     * Create an instance of {@link NsiElementType }
     * 
     */
    public NsiElementType createNsiElementType() {
        return new NsiElementType();
    }

    /**
     * Create an instance of {@link NsiItemType }
     * 
     */
    public NsiItemType createNsiItemType() {
        return new NsiItemType();
    }

    /**
     * Create an instance of {@link NsiElementOkeiRefFieldType }
     * 
     */
    public NsiElementOkeiRefFieldType createNsiElementOkeiRefFieldType() {
        return new NsiElementOkeiRefFieldType();
    }

    /**
     * Create an instance of {@link NsiElementDateFieldType }
     * 
     */
    public NsiElementDateFieldType createNsiElementDateFieldType() {
        return new NsiElementDateFieldType();
    }

    /**
     * Create an instance of {@link NsiElementFloatFieldType }
     * 
     */
    public NsiElementFloatFieldType createNsiElementFloatFieldType() {
        return new NsiElementFloatFieldType();
    }

    /**
     * Create an instance of {@link NsiElementFiasAddressRefFieldType.NsiRef }
     * 
     */
    public NsiElementFiasAddressRefFieldType.NsiRef createNsiElementFiasAddressRefFieldTypeNsiRef() {
        return new NsiElementFiasAddressRefFieldType.NsiRef();
    }

    /**
     * Create an instance of {@link NsiElementEnumFieldType.Position }
     * 
     */
    public NsiElementEnumFieldType.Position createNsiElementEnumFieldTypePosition() {
        return new NsiElementEnumFieldType.Position();
    }

    /**
     * Create an instance of {@link NsiElementNsiRefFieldType.NsiRef }
     * 
     */
    public NsiElementNsiRefFieldType.NsiRef createNsiElementNsiRefFieldTypeNsiRef() {
        return new NsiElementNsiRefFieldType.NsiRef();
    }

    /**
     * Create an instance of {@link NsiElementNsiFieldType.NsiRef }
     * 
     */
    public NsiElementNsiFieldType.NsiRef createNsiElementNsiFieldTypeNsiRef() {
        return new NsiElementNsiFieldType.NsiRef();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://dom.gosuslugi.ru/schema/integration/nsi-base/", name = "ListGroup")
    public JAXBElement<String> createListGroup(String value) {
        return new JAXBElement<String>(_ListGroup_QNAME, String.class, null, value);
    }

}
