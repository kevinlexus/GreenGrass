
package ru.gosuslugi.dom.schema.integration.signature_test;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the ru.gosuslugi.dom.schema.integration.signature_test package. 
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

    private final static QName _Body_QNAME = new QName("http://dom.gosuslugi.ru/schema/integration/signature-test/", "body");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: ru.gosuslugi.dom.schema.integration.signature_test
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link TestSignatureRequest }
     * 
     */
    public TestSignatureRequest createTestSignatureRequest() {
        return new TestSignatureRequest();
    }

    /**
     * Create an instance of {@link TestSignatureResponse }
     * 
     */
    public TestSignatureResponse createTestSignatureResponse() {
        return new TestSignatureResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Object }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://dom.gosuslugi.ru/schema/integration/signature-test/", name = "body")
    public JAXBElement<Object> createBody(Object value) {
        return new JAXBElement<Object>(_Body_QNAME, Object.class, null, value);
    }

}
