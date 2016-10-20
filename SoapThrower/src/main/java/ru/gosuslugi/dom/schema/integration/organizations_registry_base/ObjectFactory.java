
package ru.gosuslugi.dom.schema.integration.organizations_registry_base;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the ru.gosuslugi.dom.schema.integration.organizations_registry_base package. 
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

    private final static QName _CommercialName_QNAME = new QName("http://dom.gosuslugi.ru/schema/integration/organizations-registry-base/", "CommercialName");
    private final static QName _RegOrg_QNAME = new QName("http://dom.gosuslugi.ru/schema/integration/organizations-registry-base/", "RegOrg");
    private final static QName _FullName_QNAME = new QName("http://dom.gosuslugi.ru/schema/integration/organizations-registry-base/", "FullName");
    private final static QName _ShortName_QNAME = new QName("http://dom.gosuslugi.ru/schema/integration/organizations-registry-base/", "ShortName");
    private final static QName _RegOrgVersion_QNAME = new QName("http://dom.gosuslugi.ru/schema/integration/organizations-registry-base/", "RegOrgVersion");
    private final static QName _OrgVersionGUID_QNAME = new QName("http://dom.gosuslugi.ru/schema/integration/organizations-registry-base/", "orgVersionGUID");
    private final static QName _OrgRootEntityGUID_QNAME = new QName("http://dom.gosuslugi.ru/schema/integration/organizations-registry-base/", "orgRootEntityGUID");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: ru.gosuslugi.dom.schema.integration.organizations_registry_base
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link SubsidiaryType }
     * 
     */
    public SubsidiaryType createSubsidiaryType() {
        return new SubsidiaryType();
    }

    /**
     * Create an instance of {@link RegOrgVersionType }
     * 
     */
    public RegOrgVersionType createRegOrgVersionType() {
        return new RegOrgVersionType();
    }

    /**
     * Create an instance of {@link RegOrgType }
     * 
     */
    public RegOrgType createRegOrgType() {
        return new RegOrgType();
    }

    /**
     * Create an instance of {@link EntpsType }
     * 
     */
    public EntpsType createEntpsType() {
        return new EntpsType();
    }

    /**
     * Create an instance of {@link LegalType }
     * 
     */
    public LegalType createLegalType() {
        return new LegalType();
    }

    /**
     * Create an instance of {@link SubsidiaryType.SourceName }
     * 
     */
    public SubsidiaryType.SourceName createSubsidiaryTypeSourceName() {
        return new SubsidiaryType.SourceName();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://dom.gosuslugi.ru/schema/integration/organizations-registry-base/", name = "CommercialName")
    public JAXBElement<String> createCommercialName(String value) {
        return new JAXBElement<String>(_CommercialName_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RegOrgType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://dom.gosuslugi.ru/schema/integration/organizations-registry-base/", name = "RegOrg")
    public JAXBElement<RegOrgType> createRegOrg(RegOrgType value) {
        return new JAXBElement<RegOrgType>(_RegOrg_QNAME, RegOrgType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://dom.gosuslugi.ru/schema/integration/organizations-registry-base/", name = "FullName")
    public JAXBElement<String> createFullName(String value) {
        return new JAXBElement<String>(_FullName_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://dom.gosuslugi.ru/schema/integration/organizations-registry-base/", name = "ShortName")
    public JAXBElement<String> createShortName(String value) {
        return new JAXBElement<String>(_ShortName_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RegOrgVersionType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://dom.gosuslugi.ru/schema/integration/organizations-registry-base/", name = "RegOrgVersion")
    public JAXBElement<RegOrgVersionType> createRegOrgVersion(RegOrgVersionType value) {
        return new JAXBElement<RegOrgVersionType>(_RegOrgVersion_QNAME, RegOrgVersionType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://dom.gosuslugi.ru/schema/integration/organizations-registry-base/", name = "orgVersionGUID")
    public JAXBElement<String> createOrgVersionGUID(String value) {
        return new JAXBElement<String>(_OrgVersionGUID_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://dom.gosuslugi.ru/schema/integration/organizations-registry-base/", name = "orgRootEntityGUID")
    public JAXBElement<String> createOrgRootEntityGUID(String value) {
        return new JAXBElement<String>(_OrgRootEntityGUID_QNAME, String.class, null, value);
    }

}
