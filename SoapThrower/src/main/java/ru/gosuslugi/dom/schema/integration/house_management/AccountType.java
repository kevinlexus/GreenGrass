
package ru.gosuslugi.dom.schema.integration.house_management;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;
import ru.gosuslugi.dom.schema.integration.organizations_registry_base.RegOrgVersionType;


/**
 * <p>Java class for AccountType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="AccountType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;choice>
 *           &lt;element name="isUOAccount" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *           &lt;element name="isRSOAccount" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *           &lt;element name="isCRAccount" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *           &lt;element name="isRCAccount" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *           &lt;element name="isOGVorOMSAccount" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;/choice>
 *         &lt;element name="CreationDate" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="LivingPersonsNumber" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}byte">
 *               &lt;maxInclusive value="99"/>
 *               &lt;minInclusive value="0"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="TotalSquare" type="{http://dom.gosuslugi.ru/schema/integration/premises-base/}PremisesAreaType" minOccurs="0"/>
 *         &lt;element name="ResidentialSquare" type="{http://dom.gosuslugi.ru/schema/integration/premises-base/}PremisesAreaType" minOccurs="0"/>
 *         &lt;element name="HeatedArea" type="{http://dom.gosuslugi.ru/schema/integration/premises-base/}PremisesAreaType" minOccurs="0"/>
 *         &lt;element name="Closed" type="{http://dom.gosuslugi.ru/schema/integration/house-management/}ClosedAccountAttributesType" minOccurs="0"/>
 *         &lt;element name="Accommodation" maxOccurs="unbounded">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;choice>
 *                     &lt;element name="PremisesGUID" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType"/>
 *                     &lt;element name="FIASHouseGuid" type="{http://dom.gosuslugi.ru/schema/integration/premises-base/}FIASHouseGUIDType"/>
 *                     &lt;element name="LivingRoomGUID" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType"/>
 *                   &lt;/choice>
 *                   &lt;element name="SharePercent" minOccurs="0">
 *                     &lt;simpleType>
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}decimal">
 *                         &lt;minInclusive value="0"/>
 *                         &lt;maxInclusive value="100"/>
 *                         &lt;fractionDigits value="2"/>
 *                       &lt;/restriction>
 *                     &lt;/simpleType>
 *                   &lt;/element>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="PayerInfo">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="IsRenter" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *                   &lt;choice minOccurs="0">
 *                     &lt;element name="Ind" type="{http://dom.gosuslugi.ru/schema/integration/house-management/}AccountIndType"/>
 *                     &lt;element name="Org" type="{http://dom.gosuslugi.ru/schema/integration/organizations-registry-base/}RegOrgVersionType"/>
 *                   &lt;/choice>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="IndividualServiceReason" type="{http://www.w3.org/2001/XMLSchema}anyType" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AccountType", propOrder = {
    "isUOAccount",
    "isRSOAccount",
    "isCRAccount",
    "isRCAccount",
    "isOGVorOMSAccount",
    "creationDate",
    "livingPersonsNumber",
    "totalSquare",
    "residentialSquare",
    "heatedArea",
    "closed",
    "accommodation",
    "payerInfo",
    "individualServiceReason"
})
@XmlSeeAlso({
    ExportAccountResultType.class,
    ru.gosuslugi.dom.schema.integration.house_management.ImportAccountRequest.Account.class
})
public class AccountType {

    protected Boolean isUOAccount;
    protected Boolean isRSOAccount;
    protected Boolean isCRAccount;
    protected Boolean isRCAccount;
    protected Boolean isOGVorOMSAccount;
    @XmlElement(name = "CreationDate")
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar creationDate;
    @XmlElement(name = "LivingPersonsNumber")
    protected Byte livingPersonsNumber;
    @XmlElement(name = "TotalSquare")
    protected BigDecimal totalSquare;
    @XmlElement(name = "ResidentialSquare")
    protected BigDecimal residentialSquare;
    @XmlElement(name = "HeatedArea")
    protected BigDecimal heatedArea;
    @XmlElement(name = "Closed")
    protected ClosedAccountAttributesType closed;
    @XmlElement(name = "Accommodation", required = true)
    protected List<AccountType.Accommodation> accommodation;
    @XmlElement(name = "PayerInfo", required = true)
    protected AccountType.PayerInfo payerInfo;
    @XmlElement(name = "IndividualServiceReason")
    protected List<Object> individualServiceReason;

    /**
     * Gets the value of the isUOAccount property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isIsUOAccount() {
        return isUOAccount;
    }

    /**
     * Sets the value of the isUOAccount property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setIsUOAccount(Boolean value) {
        this.isUOAccount = value;
    }

    /**
     * Gets the value of the isRSOAccount property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isIsRSOAccount() {
        return isRSOAccount;
    }

    /**
     * Sets the value of the isRSOAccount property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setIsRSOAccount(Boolean value) {
        this.isRSOAccount = value;
    }

    /**
     * Gets the value of the isCRAccount property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isIsCRAccount() {
        return isCRAccount;
    }

    /**
     * Sets the value of the isCRAccount property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setIsCRAccount(Boolean value) {
        this.isCRAccount = value;
    }

    /**
     * Gets the value of the isRCAccount property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isIsRCAccount() {
        return isRCAccount;
    }

    /**
     * Sets the value of the isRCAccount property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setIsRCAccount(Boolean value) {
        this.isRCAccount = value;
    }

    /**
     * Gets the value of the isOGVorOMSAccount property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isIsOGVorOMSAccount() {
        return isOGVorOMSAccount;
    }

    /**
     * Sets the value of the isOGVorOMSAccount property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setIsOGVorOMSAccount(Boolean value) {
        this.isOGVorOMSAccount = value;
    }

    /**
     * Gets the value of the creationDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getCreationDate() {
        return creationDate;
    }

    /**
     * Sets the value of the creationDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setCreationDate(XMLGregorianCalendar value) {
        this.creationDate = value;
    }

    /**
     * Gets the value of the livingPersonsNumber property.
     * 
     * @return
     *     possible object is
     *     {@link Byte }
     *     
     */
    public Byte getLivingPersonsNumber() {
        return livingPersonsNumber;
    }

    /**
     * Sets the value of the livingPersonsNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link Byte }
     *     
     */
    public void setLivingPersonsNumber(Byte value) {
        this.livingPersonsNumber = value;
    }

    /**
     * Gets the value of the totalSquare property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getTotalSquare() {
        return totalSquare;
    }

    /**
     * Sets the value of the totalSquare property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setTotalSquare(BigDecimal value) {
        this.totalSquare = value;
    }

    /**
     * Gets the value of the residentialSquare property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getResidentialSquare() {
        return residentialSquare;
    }

    /**
     * Sets the value of the residentialSquare property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setResidentialSquare(BigDecimal value) {
        this.residentialSquare = value;
    }

    /**
     * Gets the value of the heatedArea property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getHeatedArea() {
        return heatedArea;
    }

    /**
     * Sets the value of the heatedArea property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setHeatedArea(BigDecimal value) {
        this.heatedArea = value;
    }

    /**
     * Gets the value of the closed property.
     * 
     * @return
     *     possible object is
     *     {@link ClosedAccountAttributesType }
     *     
     */
    public ClosedAccountAttributesType getClosed() {
        return closed;
    }

    /**
     * Sets the value of the closed property.
     * 
     * @param value
     *     allowed object is
     *     {@link ClosedAccountAttributesType }
     *     
     */
    public void setClosed(ClosedAccountAttributesType value) {
        this.closed = value;
    }

    /**
     * Gets the value of the accommodation property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the accommodation property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAccommodation().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link AccountType.Accommodation }
     * 
     * 
     */
    public List<AccountType.Accommodation> getAccommodation() {
        if (accommodation == null) {
            accommodation = new ArrayList<AccountType.Accommodation>();
        }
        return this.accommodation;
    }

    /**
     * Gets the value of the payerInfo property.
     * 
     * @return
     *     possible object is
     *     {@link AccountType.PayerInfo }
     *     
     */
    public AccountType.PayerInfo getPayerInfo() {
        return payerInfo;
    }

    /**
     * Sets the value of the payerInfo property.
     * 
     * @param value
     *     allowed object is
     *     {@link AccountType.PayerInfo }
     *     
     */
    public void setPayerInfo(AccountType.PayerInfo value) {
        this.payerInfo = value;
    }

    /**
     * Gets the value of the individualServiceReason property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the individualServiceReason property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getIndividualServiceReason().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Object }
     * 
     * 
     */
    public List<Object> getIndividualServiceReason() {
        if (individualServiceReason == null) {
            individualServiceReason = new ArrayList<Object>();
        }
        return this.individualServiceReason;
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
     *         &lt;choice>
     *           &lt;element name="PremisesGUID" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType"/>
     *           &lt;element name="FIASHouseGuid" type="{http://dom.gosuslugi.ru/schema/integration/premises-base/}FIASHouseGUIDType"/>
     *           &lt;element name="LivingRoomGUID" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType"/>
     *         &lt;/choice>
     *         &lt;element name="SharePercent" minOccurs="0">
     *           &lt;simpleType>
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}decimal">
     *               &lt;minInclusive value="0"/>
     *               &lt;maxInclusive value="100"/>
     *               &lt;fractionDigits value="2"/>
     *             &lt;/restriction>
     *           &lt;/simpleType>
     *         &lt;/element>
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
        "premisesGUID",
        "fiasHouseGuid",
        "livingRoomGUID",
        "sharePercent"
    })
    public static class Accommodation {

        @XmlElement(name = "PremisesGUID")
        protected String premisesGUID;
        @XmlElement(name = "FIASHouseGuid")
        protected String fiasHouseGuid;
        @XmlElement(name = "LivingRoomGUID")
        protected String livingRoomGUID;
        @XmlElement(name = "SharePercent")
        protected BigDecimal sharePercent;

        /**
         * Gets the value of the premisesGUID property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getPremisesGUID() {
            return premisesGUID;
        }

        /**
         * Sets the value of the premisesGUID property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setPremisesGUID(String value) {
            this.premisesGUID = value;
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
         * Gets the value of the livingRoomGUID property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getLivingRoomGUID() {
            return livingRoomGUID;
        }

        /**
         * Sets the value of the livingRoomGUID property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setLivingRoomGUID(String value) {
            this.livingRoomGUID = value;
        }

        /**
         * Gets the value of the sharePercent property.
         * 
         * @return
         *     possible object is
         *     {@link BigDecimal }
         *     
         */
        public BigDecimal getSharePercent() {
            return sharePercent;
        }

        /**
         * Sets the value of the sharePercent property.
         * 
         * @param value
         *     allowed object is
         *     {@link BigDecimal }
         *     
         */
        public void setSharePercent(BigDecimal value) {
            this.sharePercent = value;
        }

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
     *         &lt;element name="IsRenter" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
     *         &lt;choice minOccurs="0">
     *           &lt;element name="Ind" type="{http://dom.gosuslugi.ru/schema/integration/house-management/}AccountIndType"/>
     *           &lt;element name="Org" type="{http://dom.gosuslugi.ru/schema/integration/organizations-registry-base/}RegOrgVersionType"/>
     *         &lt;/choice>
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
        "isRenter",
        "ind",
        "org"
    })
    public static class PayerInfo {

        @XmlElement(name = "IsRenter")
        protected Boolean isRenter;
        @XmlElement(name = "Ind")
        protected AccountIndType ind;
        @XmlElement(name = "Org")
        protected RegOrgVersionType org;

        /**
         * Gets the value of the isRenter property.
         * 
         * @return
         *     possible object is
         *     {@link Boolean }
         *     
         */
        public Boolean isIsRenter() {
            return isRenter;
        }

        /**
         * Sets the value of the isRenter property.
         * 
         * @param value
         *     allowed object is
         *     {@link Boolean }
         *     
         */
        public void setIsRenter(Boolean value) {
            this.isRenter = value;
        }

        /**
         * Gets the value of the ind property.
         * 
         * @return
         *     possible object is
         *     {@link AccountIndType }
         *     
         */
        public AccountIndType getInd() {
            return ind;
        }

        /**
         * Sets the value of the ind property.
         * 
         * @param value
         *     allowed object is
         *     {@link AccountIndType }
         *     
         */
        public void setInd(AccountIndType value) {
            this.ind = value;
        }

        /**
         * Gets the value of the org property.
         * 
         * @return
         *     possible object is
         *     {@link RegOrgVersionType }
         *     
         */
        public RegOrgVersionType getOrg() {
            return org;
        }

        /**
         * Sets the value of the org property.
         * 
         * @param value
         *     allowed object is
         *     {@link RegOrgVersionType }
         *     
         */
        public void setOrg(RegOrgVersionType value) {
            this.org = value;
        }

    }

}
