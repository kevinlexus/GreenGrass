
package ru.gosuslugi.dom.schema.integration.organizations_registry_base;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;
import ru.gosuslugi.dom.schema.integration.nsi_base.NsiRef;


/**
 * ФПИЮЛ (Филиал или представительство иностранного юридического лица)
 * 
 * <p>Java class for ForeignBranchType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ForeignBranchType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/organizations-registry-base/}FullName"/>
 *         &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/organizations-registry-base/}ShortName" minOccurs="0"/>
 *         &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/organizations-base/}NZA"/>
 *         &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/organizations-base/}INN"/>
 *         &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/organizations-base/}KPP"/>
 *         &lt;element name="Address" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="FIASHouseGuid" type="{http://dom.gosuslugi.ru/schema/integration/premises-base/}FIASHouseGUIDType"/>
 *         &lt;element name="AccreditationStartDate" type="{http://www.w3.org/2001/XMLSchema}date"/>
 *         &lt;element name="AccreditationEndDate" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
 *         &lt;element name="RegistrationCountry" type="{http://dom.gosuslugi.ru/schema/integration/nsi-base/}nsiRef"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ForeignBranchType", propOrder = {
    "fullName",
    "shortName",
    "nza",
    "inn",
    "kpp",
    "address",
    "fiasHouseGuid",
    "accreditationStartDate",
    "accreditationEndDate",
    "registrationCountry"
})
public class ForeignBranchType {

    @XmlElement(name = "FullName", required = true)
    protected String fullName;
    @XmlElement(name = "ShortName")
    protected String shortName;
    @XmlElement(name = "NZA", namespace = "http://dom.gosuslugi.ru/schema/integration/organizations-base/", required = true)
    protected String nza;
    @XmlElement(name = "INN", namespace = "http://dom.gosuslugi.ru/schema/integration/organizations-base/", required = true)
    protected String inn;
    @XmlElement(name = "KPP", namespace = "http://dom.gosuslugi.ru/schema/integration/organizations-base/", required = true)
    protected String kpp;
    @XmlElement(name = "Address")
    protected String address;
    @XmlElement(name = "FIASHouseGuid", required = true)
    protected String fiasHouseGuid;
    @XmlElement(name = "AccreditationStartDate", required = true)
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar accreditationStartDate;
    @XmlElement(name = "AccreditationEndDate")
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar accreditationEndDate;
    @XmlElement(name = "RegistrationCountry", required = true)
    protected NsiRef registrationCountry;

    /**
     * Gets the value of the fullName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFullName() {
        return fullName;
    }

    /**
     * Sets the value of the fullName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFullName(String value) {
        this.fullName = value;
    }

    /**
     * Gets the value of the shortName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getShortName() {
        return shortName;
    }

    /**
     * Sets the value of the shortName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setShortName(String value) {
        this.shortName = value;
    }

    /**
     * Gets the value of the nza property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNZA() {
        return nza;
    }

    /**
     * Sets the value of the nza property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNZA(String value) {
        this.nza = value;
    }

    /**
     * Gets the value of the inn property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getINN() {
        return inn;
    }

    /**
     * Sets the value of the inn property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setINN(String value) {
        this.inn = value;
    }

    /**
     * Gets the value of the kpp property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getKPP() {
        return kpp;
    }

    /**
     * Sets the value of the kpp property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setKPP(String value) {
        this.kpp = value;
    }

    /**
     * Gets the value of the address property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAddress() {
        return address;
    }

    /**
     * Sets the value of the address property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAddress(String value) {
        this.address = value;
    }

    /**
     * Gets the value of the fiasHouseGuid property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFIASHouseGuid() {
        return fiasHouseGuid;
    }

    /**
     * Sets the value of the fiasHouseGuid property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFIASHouseGuid(String value) {
        this.fiasHouseGuid = value;
    }

    /**
     * Gets the value of the accreditationStartDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getAccreditationStartDate() {
        return accreditationStartDate;
    }

    /**
     * Sets the value of the accreditationStartDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setAccreditationStartDate(XMLGregorianCalendar value) {
        this.accreditationStartDate = value;
    }

    /**
     * Gets the value of the accreditationEndDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getAccreditationEndDate() {
        return accreditationEndDate;
    }

    /**
     * Sets the value of the accreditationEndDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setAccreditationEndDate(XMLGregorianCalendar value) {
        this.accreditationEndDate = value;
    }

    /**
     * Gets the value of the registrationCountry property.
     * 
     * @return
     *     possible object is
     *     {@link NsiRef }
     *     
     */
    public NsiRef getRegistrationCountry() {
        return registrationCountry;
    }

    /**
     * Sets the value of the registrationCountry property.
     * 
     * @param value
     *     allowed object is
     *     {@link NsiRef }
     *     
     */
    public void setRegistrationCountry(NsiRef value) {
        this.registrationCountry = value;
    }

}
