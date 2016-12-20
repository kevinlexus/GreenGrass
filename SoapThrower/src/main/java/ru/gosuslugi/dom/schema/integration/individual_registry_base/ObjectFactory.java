
package ru.gosuslugi.dom.schema.integration.individual_registry_base;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the ru.gosuslugi.dom.schema.integration.individual_registry_base package. 
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

    private final static QName _FirstName_QNAME = new QName("http://dom.gosuslugi.ru/schema/integration/individual-registry-base/", "FirstName");
    private final static QName _SNILS_QNAME = new QName("http://dom.gosuslugi.ru/schema/integration/individual-registry-base/", "SNILS");
    private final static QName _Surname_QNAME = new QName("http://dom.gosuslugi.ru/schema/integration/individual-registry-base/", "Surname");
    private final static QName _Sex_QNAME = new QName("http://dom.gosuslugi.ru/schema/integration/individual-registry-base/", "Sex");
    private final static QName _PlaceBirth_QNAME = new QName("http://dom.gosuslugi.ru/schema/integration/individual-registry-base/", "PlaceBirth");
    private final static QName _DateOfBirth_QNAME = new QName("http://dom.gosuslugi.ru/schema/integration/individual-registry-base/", "DateOfBirth");
    private final static QName _Patronymic_QNAME = new QName("http://dom.gosuslugi.ru/schema/integration/individual-registry-base/", "Patronymic");
    private final static QName _Ind_QNAME = new QName("http://dom.gosuslugi.ru/schema/integration/individual-registry-base/", "Ind");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: ru.gosuslugi.dom.schema.integration.individual_registry_base
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link FIOType }
     * 
     */
    public FIOType createFIOType() {
        return new FIOType();
    }

    /**
     * Create an instance of {@link ID }
     * 
     */
    public ID createID() {
        return new ID();
    }

    /**
     * Create an instance of {@link IndType }
     * 
     */
    public IndType createIndType() {
        return new IndType();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://dom.gosuslugi.ru/schema/integration/individual-registry-base/", name = "FirstName")
    public JAXBElement<String> createFirstName(String value) {
        return new JAXBElement<String>(_FirstName_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://dom.gosuslugi.ru/schema/integration/individual-registry-base/", name = "SNILS")
    public JAXBElement<String> createSNILS(String value) {
        return new JAXBElement<String>(_SNILS_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://dom.gosuslugi.ru/schema/integration/individual-registry-base/", name = "Surname")
    public JAXBElement<String> createSurname(String value) {
        return new JAXBElement<String>(_Surname_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://dom.gosuslugi.ru/schema/integration/individual-registry-base/", name = "Sex")
    public JAXBElement<String> createSex(String value) {
        return new JAXBElement<String>(_Sex_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://dom.gosuslugi.ru/schema/integration/individual-registry-base/", name = "PlaceBirth")
    public JAXBElement<String> createPlaceBirth(String value) {
        return new JAXBElement<String>(_PlaceBirth_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://dom.gosuslugi.ru/schema/integration/individual-registry-base/", name = "DateOfBirth")
    public JAXBElement<XMLGregorianCalendar> createDateOfBirth(XMLGregorianCalendar value) {
        return new JAXBElement<XMLGregorianCalendar>(_DateOfBirth_QNAME, XMLGregorianCalendar.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://dom.gosuslugi.ru/schema/integration/individual-registry-base/", name = "Patronymic")
    public JAXBElement<String> createPatronymic(String value) {
        return new JAXBElement<String>(_Patronymic_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link IndType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://dom.gosuslugi.ru/schema/integration/individual-registry-base/", name = "Ind")
    public JAXBElement<IndType> createInd(IndType value) {
        return new JAXBElement<IndType>(_Ind_QNAME, IndType.class, null, value);
    }

}
