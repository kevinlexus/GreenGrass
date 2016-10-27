
package ru.gosuslugi.dom.schema.integration.account_base;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the ru.gosuslugi.dom.schema.integration.account_base package. 
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

    private final static QName _AccountGuid_QNAME = new QName("http://dom.gosuslugi.ru/schema/integration/account-base/", "AccountGuid");
    private final static QName _ServiceID_QNAME = new QName("http://dom.gosuslugi.ru/schema/integration/account-base/", "ServiceID");
    private final static QName _UnifiedAccountNumber_QNAME = new QName("http://dom.gosuslugi.ru/schema/integration/account-base/", "UnifiedAccountNumber");
    private final static QName _CheckingAccount_QNAME = new QName("http://dom.gosuslugi.ru/schema/integration/account-base/", "CheckingAccount");
    private final static QName _AccountNumber_QNAME = new QName("http://dom.gosuslugi.ru/schema/integration/account-base/", "AccountNumber");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: ru.gosuslugi.dom.schema.integration.account_base
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link PaymentReasonType }
     * 
     */
    public PaymentReasonType createPaymentReasonType() {
        return new PaymentReasonType();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://dom.gosuslugi.ru/schema/integration/account-base/", name = "AccountGuid")
    public JAXBElement<String> createAccountGuid(String value) {
        return new JAXBElement<String>(_AccountGuid_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://dom.gosuslugi.ru/schema/integration/account-base/", name = "ServiceID")
    public JAXBElement<String> createServiceID(String value) {
        return new JAXBElement<String>(_ServiceID_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://dom.gosuslugi.ru/schema/integration/account-base/", name = "UnifiedAccountNumber")
    public JAXBElement<String> createUnifiedAccountNumber(String value) {
        return new JAXBElement<String>(_UnifiedAccountNumber_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://dom.gosuslugi.ru/schema/integration/account-base/", name = "CheckingAccount")
    public JAXBElement<String> createCheckingAccount(String value) {
        return new JAXBElement<String>(_CheckingAccount_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://dom.gosuslugi.ru/schema/integration/account-base/", name = "AccountNumber")
    public JAXBElement<String> createAccountNumber(String value) {
        return new JAXBElement<String>(_AccountNumber_QNAME, String.class, null, value);
    }

}
