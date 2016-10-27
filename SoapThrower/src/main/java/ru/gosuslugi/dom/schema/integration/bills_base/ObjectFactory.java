
package ru.gosuslugi.dom.schema.integration.bills_base;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the ru.gosuslugi.dom.schema.integration.bills_base package. 
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

    private final static QName _PaymentDocumentNumber_QNAME = new QName("http://dom.gosuslugi.ru/schema/integration/bills-base/", "PaymentDocumentNumber");
    private final static QName _PaymentDocumentID_QNAME = new QName("http://dom.gosuslugi.ru/schema/integration/bills-base/", "PaymentDocumentID");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: ru.gosuslugi.dom.schema.integration.bills_base
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://dom.gosuslugi.ru/schema/integration/bills-base/", name = "PaymentDocumentNumber")
    public JAXBElement<String> createPaymentDocumentNumber(String value) {
        return new JAXBElement<String>(_PaymentDocumentNumber_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://dom.gosuslugi.ru/schema/integration/bills-base/", name = "PaymentDocumentID")
    public JAXBElement<String> createPaymentDocumentID(String value) {
        return new JAXBElement<String>(_PaymentDocumentID_QNAME, String.class, null, value);
    }

}
