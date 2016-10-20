
package ru.gosuslugi.dom.schema.integration.organizations_base;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the ru.gosuslugi.dom.schema.integration.organizations_base package. 
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

    private final static QName _OGRN_QNAME = new QName("http://dom.gosuslugi.ru/schema/integration/organizations-base/", "OGRN");
    private final static QName _Web_QNAME = new QName("http://dom.gosuslugi.ru/schema/integration/organizations-base/", "Web");
    private final static QName _KPP_QNAME = new QName("http://dom.gosuslugi.ru/schema/integration/organizations-base/", "KPP");
    private final static QName _Fax_QNAME = new QName("http://dom.gosuslugi.ru/schema/integration/organizations-base/", "Fax");
    private final static QName _Mail_QNAME = new QName("http://dom.gosuslugi.ru/schema/integration/organizations-base/", "Mail");
    private final static QName _OGRNIP_QNAME = new QName("http://dom.gosuslugi.ru/schema/integration/organizations-base/", "OGRNIP");
    private final static QName _OKOGU_QNAME = new QName("http://dom.gosuslugi.ru/schema/integration/organizations-base/", "OKOGU");
    private final static QName _OKOPF_QNAME = new QName("http://dom.gosuslugi.ru/schema/integration/organizations-base/", "OKOPF");
    private final static QName _Phone_QNAME = new QName("http://dom.gosuslugi.ru/schema/integration/organizations-base/", "Phone");
    private final static QName _INN_QNAME = new QName("http://dom.gosuslugi.ru/schema/integration/organizations-base/", "INN");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: ru.gosuslugi.dom.schema.integration.organizations_base
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://dom.gosuslugi.ru/schema/integration/organizations-base/", name = "OGRN")
    public JAXBElement<String> createOGRN(String value) {
        return new JAXBElement<String>(_OGRN_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://dom.gosuslugi.ru/schema/integration/organizations-base/", name = "Web")
    public JAXBElement<String> createWeb(String value) {
        return new JAXBElement<String>(_Web_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://dom.gosuslugi.ru/schema/integration/organizations-base/", name = "KPP")
    public JAXBElement<String> createKPP(String value) {
        return new JAXBElement<String>(_KPP_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://dom.gosuslugi.ru/schema/integration/organizations-base/", name = "Fax")
    public JAXBElement<String> createFax(String value) {
        return new JAXBElement<String>(_Fax_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://dom.gosuslugi.ru/schema/integration/organizations-base/", name = "Mail")
    public JAXBElement<String> createMail(String value) {
        return new JAXBElement<String>(_Mail_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://dom.gosuslugi.ru/schema/integration/organizations-base/", name = "OGRNIP")
    public JAXBElement<String> createOGRNIP(String value) {
        return new JAXBElement<String>(_OGRNIP_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://dom.gosuslugi.ru/schema/integration/organizations-base/", name = "OKOGU")
    public JAXBElement<String> createOKOGU(String value) {
        return new JAXBElement<String>(_OKOGU_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://dom.gosuslugi.ru/schema/integration/organizations-base/", name = "OKOPF")
    public JAXBElement<String> createOKOPF(String value) {
        return new JAXBElement<String>(_OKOPF_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://dom.gosuslugi.ru/schema/integration/organizations-base/", name = "Phone")
    public JAXBElement<String> createPhone(String value) {
        return new JAXBElement<String>(_Phone_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://dom.gosuslugi.ru/schema/integration/organizations-base/", name = "INN")
    public JAXBElement<String> createINN(String value) {
        return new JAXBElement<String>(_INN_QNAME, String.class, null, value);
    }

}
