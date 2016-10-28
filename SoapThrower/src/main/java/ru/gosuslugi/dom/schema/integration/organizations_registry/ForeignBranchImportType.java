
package ru.gosuslugi.dom.schema.integration.organizations_registry;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;
import ru.gosuslugi.dom.schema.integration.nsi_base.NsiRef;
import ru.gosuslugi.dom.schema.integration.organizations_registry_base.ForeignBranchType;


/**
 * Импорт ФПИЮЛ
 * 
 * <p>Java class for ForeignBranchImportType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ForeignBranchImportType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;choice>
 *         &lt;element name="CreateForeignBranch" type="{http://dom.gosuslugi.ru/schema/integration/organizations-registry-base/}ForeignBranchType"/>
 *         &lt;element name="UpdateForeignBranch">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/organizations-registry-base/}orgVersionGUID"/>
 *                   &lt;element name="FullName">
 *                     &lt;simpleType>
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                         &lt;minLength value="1"/>
 *                         &lt;maxLength value="4000"/>
 *                       &lt;/restriction>
 *                     &lt;/simpleType>
 *                   &lt;/element>
 *                   &lt;element name="ShortName">
 *                     &lt;simpleType>
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                         &lt;minLength value="1"/>
 *                         &lt;maxLength value="255"/>
 *                       &lt;/restriction>
 *                     &lt;/simpleType>
 *                   &lt;/element>
 *                   &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/organizations-base/}INN"/>
 *                   &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/organizations-base/}KPP"/>
 *                   &lt;element name="Address" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="FIASHouseGuid" type="{http://dom.gosuslugi.ru/schema/integration/premises-base/}FIASHouseGUIDType"/>
 *                   &lt;element name="AccreditationStartDate" type="{http://www.w3.org/2001/XMLSchema}date"/>
 *                   &lt;element name="AccreditationEndDate" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
 *                   &lt;element name="RegistrationCountry" type="{http://dom.gosuslugi.ru/schema/integration/nsi-base/}nsiRef"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *       &lt;/choice>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ForeignBranchImportType", propOrder = {
    "createForeignBranch",
    "updateForeignBranch"
})
@XmlSeeAlso({
    ru.gosuslugi.dom.schema.integration.organizations_registry.ImportForeignBranchRequest.ForeignBranch.class
})
public class ForeignBranchImportType {

    @XmlElement(name = "CreateForeignBranch")
    protected ForeignBranchType createForeignBranch;
    @XmlElement(name = "UpdateForeignBranch")
    protected ForeignBranchImportType.UpdateForeignBranch updateForeignBranch;

    /**
     * Gets the value of the createForeignBranch property.
     * 
     * @return
     *     possible object is
     *     {@link ForeignBranchType }
     *     
     */
    public ForeignBranchType getCreateForeignBranch() {
        return createForeignBranch;
    }

    /**
     * Sets the value of the createForeignBranch property.
     * 
     * @param value
     *     allowed object is
     *     {@link ForeignBranchType }
     *     
     */
    public void setCreateForeignBranch(ForeignBranchType value) {
        this.createForeignBranch = value;
    }

    /**
     * Gets the value of the updateForeignBranch property.
     * 
     * @return
     *     possible object is
     *     {@link ForeignBranchImportType.UpdateForeignBranch }
     *     
     */
    public ForeignBranchImportType.UpdateForeignBranch getUpdateForeignBranch() {
        return updateForeignBranch;
    }

    /**
     * Sets the value of the updateForeignBranch property.
     * 
     * @param value
     *     allowed object is
     *     {@link ForeignBranchImportType.UpdateForeignBranch }
     *     
     */
    public void setUpdateForeignBranch(ForeignBranchImportType.UpdateForeignBranch value) {
        this.updateForeignBranch = value;
    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/organizations-registry-base/}orgVersionGUID"/>
     *         &lt;element name="FullName">
     *           &lt;simpleType>
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *               &lt;minLength value="1"/>
     *               &lt;maxLength value="4000"/>
     *             &lt;/restriction>
     *           &lt;/simpleType>
     *         &lt;/element>
     *         &lt;element name="ShortName">
     *           &lt;simpleType>
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *               &lt;minLength value="1"/>
     *               &lt;maxLength value="255"/>
     *             &lt;/restriction>
     *           &lt;/simpleType>
     *         &lt;/element>
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
    @XmlType(name = "", propOrder = {
        "orgVersionGUID",
        "fullName",
        "shortName",
        "inn",
        "kpp",
        "address",
        "fiasHouseGuid",
        "accreditationStartDate",
        "accreditationEndDate",
        "registrationCountry"
    })
    public static class UpdateForeignBranch {

        @XmlElement(namespace = "http://dom.gosuslugi.ru/schema/integration/organizations-registry-base/", required = true)
        protected String orgVersionGUID;
        @XmlElement(name = "FullName", required = true)
        protected String fullName;
        @XmlElement(name = "ShortName", required = true)
        protected String shortName;
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
         * Gets the value of the orgVersionGUID property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getOrgVersionGUID() {
            return orgVersionGUID;
        }

        /**
         * Sets the value of the orgVersionGUID property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setOrgVersionGUID(String value) {
            this.orgVersionGUID = value;
        }

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

}
