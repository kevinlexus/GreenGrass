
package ru.gosuslugi.dom.schema.integration.house_management;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;
import ru.gosuslugi.dom.schema.integration.base.AttachmentType;
import ru.gosuslugi.dom.schema.integration.nsi_base.NsiRef;


/**
 * Основные характеристики ПУ
 * 
 * <p>Java class for MeteringDeviceBasicCharacteristicsType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="MeteringDeviceBasicCharacteristicsType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="MeteringDeviceNumber">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="50"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="MeteringDeviceStamp" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="50"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="MeteringDeviceModel" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="50"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="InstallationDate" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
 *         &lt;element name="CommissioningDate" type="{http://www.w3.org/2001/XMLSchema}date"/>
 *         &lt;element name="RemoteMeteringMode" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="FirstVerificationDate" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
 *         &lt;element name="VerificationInterval" type="{http://dom.gosuslugi.ru/schema/integration/nsi-base/}nsiRef" minOccurs="0"/>
 *         &lt;element name="FactorySealDate" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
 *         &lt;element name="TemperatureSensor" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="PressureSensor" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;choice>
 *           &lt;element name="CollectiveDevice">
 *             &lt;complexType>
 *               &lt;complexContent>
 *                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                   &lt;sequence>
 *                     &lt;element name="RemoteMeteringInfo" minOccurs="0">
 *                       &lt;simpleType>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                           &lt;maxLength value="2000"/>
 *                         &lt;/restriction>
 *                       &lt;/simpleType>
 *                     &lt;/element>
 *                     &lt;element name="TemperatureSensingElementInfo" minOccurs="0">
 *                       &lt;simpleType>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                           &lt;maxLength value="2000"/>
 *                         &lt;/restriction>
 *                       &lt;/simpleType>
 *                     &lt;/element>
 *                     &lt;element name="PressureSensingElementInfo" minOccurs="0">
 *                       &lt;simpleType>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                           &lt;maxLength value="2000"/>
 *                         &lt;/restriction>
 *                       &lt;/simpleType>
 *                     &lt;/element>
 *                     &lt;element name="ProjectRegistrationNode" type="{http://dom.gosuslugi.ru/schema/integration/base/}AttachmentType" maxOccurs="100" minOccurs="0"/>
 *                     &lt;element name="Certificate" type="{http://dom.gosuslugi.ru/schema/integration/base/}AttachmentType" maxOccurs="100" minOccurs="0"/>
 *                   &lt;/sequence>
 *                 &lt;/restriction>
 *               &lt;/complexContent>
 *             &lt;/complexType>
 *           &lt;/element>
 *           &lt;element name="ResidentialPremiseDevice">
 *             &lt;complexType>
 *               &lt;complexContent>
 *                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                   &lt;sequence>
 *                     &lt;element name="PremiseGUID" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType"/>
 *                     &lt;element name="AccountGUID" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType" maxOccurs="unbounded"/>
 *                   &lt;/sequence>
 *                 &lt;/restriction>
 *               &lt;/complexContent>
 *             &lt;/complexType>
 *           &lt;/element>
 *           &lt;element name="NonResidentialPremiseDevice">
 *             &lt;complexType>
 *               &lt;complexContent>
 *                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                   &lt;sequence>
 *                     &lt;element name="PremiseGUID" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType"/>
 *                     &lt;element name="AccountGUID" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType" maxOccurs="unbounded"/>
 *                   &lt;/sequence>
 *                 &lt;/restriction>
 *               &lt;/complexContent>
 *             &lt;/complexType>
 *           &lt;/element>
 *           &lt;element name="ApartmentHouseDevice">
 *             &lt;complexType>
 *               &lt;complexContent>
 *                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                   &lt;sequence>
 *                     &lt;element name="AccountGUID" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType" maxOccurs="unbounded"/>
 *                   &lt;/sequence>
 *                 &lt;/restriction>
 *               &lt;/complexContent>
 *             &lt;/complexType>
 *           &lt;/element>
 *           &lt;element name="LivingRoomDevice">
 *             &lt;complexType>
 *               &lt;complexContent>
 *                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                   &lt;sequence>
 *                     &lt;element name="LivingRoomGUID" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType" maxOccurs="unbounded"/>
 *                     &lt;element name="AccountGUID" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType" maxOccurs="unbounded"/>
 *                   &lt;/sequence>
 *                 &lt;/restriction>
 *               &lt;/complexContent>
 *             &lt;/complexType>
 *           &lt;/element>
 *           &lt;element name="CollectiveApartmentDevice">
 *             &lt;complexType>
 *               &lt;complexContent>
 *                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                   &lt;sequence>
 *                     &lt;element name="PremiseGUID" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType"/>
 *                     &lt;element name="AccountGUID" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType" maxOccurs="unbounded"/>
 *                   &lt;/sequence>
 *                 &lt;/restriction>
 *               &lt;/complexContent>
 *             &lt;/complexType>
 *           &lt;/element>
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
@XmlType(name = "MeteringDeviceBasicCharacteristicsType", propOrder = {
    "meteringDeviceNumber",
    "meteringDeviceStamp",
    "meteringDeviceModel",
    "installationDate",
    "commissioningDate",
    "remoteMeteringMode",
    "firstVerificationDate",
    "verificationInterval",
    "factorySealDate",
    "temperatureSensor",
    "pressureSensor",
    "collectiveDevice",
    "residentialPremiseDevice",
    "nonResidentialPremiseDevice",
    "apartmentHouseDevice",
    "livingRoomDevice",
    "collectiveApartmentDevice"
})
public class MeteringDeviceBasicCharacteristicsType {

    @XmlElement(name = "MeteringDeviceNumber", required = true)
    protected String meteringDeviceNumber;
    @XmlElement(name = "MeteringDeviceStamp")
    protected String meteringDeviceStamp;
    @XmlElement(name = "MeteringDeviceModel")
    protected String meteringDeviceModel;
    @XmlElement(name = "InstallationDate")
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar installationDate;
    @XmlElement(name = "CommissioningDate", required = true)
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar commissioningDate;
    @XmlElement(name = "RemoteMeteringMode")
    protected boolean remoteMeteringMode;
    @XmlElement(name = "FirstVerificationDate")
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar firstVerificationDate;
    @XmlElement(name = "VerificationInterval")
    protected NsiRef verificationInterval;
    @XmlElement(name = "FactorySealDate")
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar factorySealDate;
    @XmlElement(name = "TemperatureSensor")
    protected boolean temperatureSensor;
    @XmlElement(name = "PressureSensor")
    protected boolean pressureSensor;
    @XmlElement(name = "CollectiveDevice")
    protected MeteringDeviceBasicCharacteristicsType.CollectiveDevice collectiveDevice;
    @XmlElement(name = "ResidentialPremiseDevice")
    protected MeteringDeviceBasicCharacteristicsType.ResidentialPremiseDevice residentialPremiseDevice;
    @XmlElement(name = "NonResidentialPremiseDevice")
    protected MeteringDeviceBasicCharacteristicsType.NonResidentialPremiseDevice nonResidentialPremiseDevice;
    @XmlElement(name = "ApartmentHouseDevice")
    protected MeteringDeviceBasicCharacteristicsType.ApartmentHouseDevice apartmentHouseDevice;
    @XmlElement(name = "LivingRoomDevice")
    protected MeteringDeviceBasicCharacteristicsType.LivingRoomDevice livingRoomDevice;
    @XmlElement(name = "CollectiveApartmentDevice")
    protected MeteringDeviceBasicCharacteristicsType.CollectiveApartmentDevice collectiveApartmentDevice;

    /**
     * Gets the value of the meteringDeviceNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMeteringDeviceNumber() {
        return meteringDeviceNumber;
    }

    /**
     * Sets the value of the meteringDeviceNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMeteringDeviceNumber(String value) {
        this.meteringDeviceNumber = value;
    }

    /**
     * Gets the value of the meteringDeviceStamp property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMeteringDeviceStamp() {
        return meteringDeviceStamp;
    }

    /**
     * Sets the value of the meteringDeviceStamp property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMeteringDeviceStamp(String value) {
        this.meteringDeviceStamp = value;
    }

    /**
     * Gets the value of the meteringDeviceModel property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMeteringDeviceModel() {
        return meteringDeviceModel;
    }

    /**
     * Sets the value of the meteringDeviceModel property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMeteringDeviceModel(String value) {
        this.meteringDeviceModel = value;
    }

    /**
     * Gets the value of the installationDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getInstallationDate() {
        return installationDate;
    }

    /**
     * Sets the value of the installationDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setInstallationDate(XMLGregorianCalendar value) {
        this.installationDate = value;
    }

    /**
     * Gets the value of the commissioningDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getCommissioningDate() {
        return commissioningDate;
    }

    /**
     * Sets the value of the commissioningDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setCommissioningDate(XMLGregorianCalendar value) {
        this.commissioningDate = value;
    }

    /**
     * Gets the value of the remoteMeteringMode property.
     * 
     */
    public boolean isRemoteMeteringMode() {
        return remoteMeteringMode;
    }

    /**
     * Sets the value of the remoteMeteringMode property.
     * 
     */
    public void setRemoteMeteringMode(boolean value) {
        this.remoteMeteringMode = value;
    }

    /**
     * Gets the value of the firstVerificationDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getFirstVerificationDate() {
        return firstVerificationDate;
    }

    /**
     * Sets the value of the firstVerificationDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setFirstVerificationDate(XMLGregorianCalendar value) {
        this.firstVerificationDate = value;
    }

    /**
     * Gets the value of the verificationInterval property.
     * 
     * @return
     *     possible object is
     *     {@link NsiRef }
     *     
     */
    public NsiRef getVerificationInterval() {
        return verificationInterval;
    }

    /**
     * Sets the value of the verificationInterval property.
     * 
     * @param value
     *     allowed object is
     *     {@link NsiRef }
     *     
     */
    public void setVerificationInterval(NsiRef value) {
        this.verificationInterval = value;
    }

    /**
     * Gets the value of the factorySealDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getFactorySealDate() {
        return factorySealDate;
    }

    /**
     * Sets the value of the factorySealDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setFactorySealDate(XMLGregorianCalendar value) {
        this.factorySealDate = value;
    }

    /**
     * Gets the value of the temperatureSensor property.
     * 
     */
    public boolean isTemperatureSensor() {
        return temperatureSensor;
    }

    /**
     * Sets the value of the temperatureSensor property.
     * 
     */
    public void setTemperatureSensor(boolean value) {
        this.temperatureSensor = value;
    }

    /**
     * Gets the value of the pressureSensor property.
     * 
     */
    public boolean isPressureSensor() {
        return pressureSensor;
    }

    /**
     * Sets the value of the pressureSensor property.
     * 
     */
    public void setPressureSensor(boolean value) {
        this.pressureSensor = value;
    }

    /**
     * Gets the value of the collectiveDevice property.
     * 
     * @return
     *     possible object is
     *     {@link MeteringDeviceBasicCharacteristicsType.CollectiveDevice }
     *     
     */
    public MeteringDeviceBasicCharacteristicsType.CollectiveDevice getCollectiveDevice() {
        return collectiveDevice;
    }

    /**
     * Sets the value of the collectiveDevice property.
     * 
     * @param value
     *     allowed object is
     *     {@link MeteringDeviceBasicCharacteristicsType.CollectiveDevice }
     *     
     */
    public void setCollectiveDevice(MeteringDeviceBasicCharacteristicsType.CollectiveDevice value) {
        this.collectiveDevice = value;
    }

    /**
     * Gets the value of the residentialPremiseDevice property.
     * 
     * @return
     *     possible object is
     *     {@link MeteringDeviceBasicCharacteristicsType.ResidentialPremiseDevice }
     *     
     */
    public MeteringDeviceBasicCharacteristicsType.ResidentialPremiseDevice getResidentialPremiseDevice() {
        return residentialPremiseDevice;
    }

    /**
     * Sets the value of the residentialPremiseDevice property.
     * 
     * @param value
     *     allowed object is
     *     {@link MeteringDeviceBasicCharacteristicsType.ResidentialPremiseDevice }
     *     
     */
    public void setResidentialPremiseDevice(MeteringDeviceBasicCharacteristicsType.ResidentialPremiseDevice value) {
        this.residentialPremiseDevice = value;
    }

    /**
     * Gets the value of the nonResidentialPremiseDevice property.
     * 
     * @return
     *     possible object is
     *     {@link MeteringDeviceBasicCharacteristicsType.NonResidentialPremiseDevice }
     *     
     */
    public MeteringDeviceBasicCharacteristicsType.NonResidentialPremiseDevice getNonResidentialPremiseDevice() {
        return nonResidentialPremiseDevice;
    }

    /**
     * Sets the value of the nonResidentialPremiseDevice property.
     * 
     * @param value
     *     allowed object is
     *     {@link MeteringDeviceBasicCharacteristicsType.NonResidentialPremiseDevice }
     *     
     */
    public void setNonResidentialPremiseDevice(MeteringDeviceBasicCharacteristicsType.NonResidentialPremiseDevice value) {
        this.nonResidentialPremiseDevice = value;
    }

    /**
     * Gets the value of the apartmentHouseDevice property.
     * 
     * @return
     *     possible object is
     *     {@link MeteringDeviceBasicCharacteristicsType.ApartmentHouseDevice }
     *     
     */
    public MeteringDeviceBasicCharacteristicsType.ApartmentHouseDevice getApartmentHouseDevice() {
        return apartmentHouseDevice;
    }

    /**
     * Sets the value of the apartmentHouseDevice property.
     * 
     * @param value
     *     allowed object is
     *     {@link MeteringDeviceBasicCharacteristicsType.ApartmentHouseDevice }
     *     
     */
    public void setApartmentHouseDevice(MeteringDeviceBasicCharacteristicsType.ApartmentHouseDevice value) {
        this.apartmentHouseDevice = value;
    }

    /**
     * Gets the value of the livingRoomDevice property.
     * 
     * @return
     *     possible object is
     *     {@link MeteringDeviceBasicCharacteristicsType.LivingRoomDevice }
     *     
     */
    public MeteringDeviceBasicCharacteristicsType.LivingRoomDevice getLivingRoomDevice() {
        return livingRoomDevice;
    }

    /**
     * Sets the value of the livingRoomDevice property.
     * 
     * @param value
     *     allowed object is
     *     {@link MeteringDeviceBasicCharacteristicsType.LivingRoomDevice }
     *     
     */
    public void setLivingRoomDevice(MeteringDeviceBasicCharacteristicsType.LivingRoomDevice value) {
        this.livingRoomDevice = value;
    }

    /**
     * Gets the value of the collectiveApartmentDevice property.
     * 
     * @return
     *     possible object is
     *     {@link MeteringDeviceBasicCharacteristicsType.CollectiveApartmentDevice }
     *     
     */
    public MeteringDeviceBasicCharacteristicsType.CollectiveApartmentDevice getCollectiveApartmentDevice() {
        return collectiveApartmentDevice;
    }

    /**
     * Sets the value of the collectiveApartmentDevice property.
     * 
     * @param value
     *     allowed object is
     *     {@link MeteringDeviceBasicCharacteristicsType.CollectiveApartmentDevice }
     *     
     */
    public void setCollectiveApartmentDevice(MeteringDeviceBasicCharacteristicsType.CollectiveApartmentDevice value) {
        this.collectiveApartmentDevice = value;
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
     *         &lt;element name="AccountGUID" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType" maxOccurs="unbounded"/>
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
        "accountGUID"
    })
    public static class ApartmentHouseDevice {

        @XmlElement(name = "AccountGUID", required = true)
        protected List<String> accountGUID;

        /**
         * Gets the value of the accountGUID property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the accountGUID property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getAccountGUID().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link String }
         * 
         * 
         */
        public List<String> getAccountGUID() {
            if (accountGUID == null) {
                accountGUID = new ArrayList<String>();
            }
            return this.accountGUID;
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
     *         &lt;element name="PremiseGUID" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType"/>
     *         &lt;element name="AccountGUID" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType" maxOccurs="unbounded"/>
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
        "premiseGUID",
        "accountGUID"
    })
    public static class CollectiveApartmentDevice {

        @XmlElement(name = "PremiseGUID", required = true)
        protected String premiseGUID;
        @XmlElement(name = "AccountGUID", required = true)
        protected List<String> accountGUID;

        /**
         * Gets the value of the premiseGUID property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getPremiseGUID() {
            return premiseGUID;
        }

        /**
         * Sets the value of the premiseGUID property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setPremiseGUID(String value) {
            this.premiseGUID = value;
        }

        /**
         * Gets the value of the accountGUID property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the accountGUID property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getAccountGUID().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link String }
         * 
         * 
         */
        public List<String> getAccountGUID() {
            if (accountGUID == null) {
                accountGUID = new ArrayList<String>();
            }
            return this.accountGUID;
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
     *         &lt;element name="RemoteMeteringInfo" minOccurs="0">
     *           &lt;simpleType>
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *               &lt;maxLength value="2000"/>
     *             &lt;/restriction>
     *           &lt;/simpleType>
     *         &lt;/element>
     *         &lt;element name="TemperatureSensingElementInfo" minOccurs="0">
     *           &lt;simpleType>
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *               &lt;maxLength value="2000"/>
     *             &lt;/restriction>
     *           &lt;/simpleType>
     *         &lt;/element>
     *         &lt;element name="PressureSensingElementInfo" minOccurs="0">
     *           &lt;simpleType>
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *               &lt;maxLength value="2000"/>
     *             &lt;/restriction>
     *           &lt;/simpleType>
     *         &lt;/element>
     *         &lt;element name="ProjectRegistrationNode" type="{http://dom.gosuslugi.ru/schema/integration/base/}AttachmentType" maxOccurs="100" minOccurs="0"/>
     *         &lt;element name="Certificate" type="{http://dom.gosuslugi.ru/schema/integration/base/}AttachmentType" maxOccurs="100" minOccurs="0"/>
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
        "remoteMeteringInfo",
        "temperatureSensingElementInfo",
        "pressureSensingElementInfo",
        "projectRegistrationNode",
        "certificate"
    })
    public static class CollectiveDevice {

        @XmlElement(name = "RemoteMeteringInfo")
        protected String remoteMeteringInfo;
        @XmlElement(name = "TemperatureSensingElementInfo")
        protected String temperatureSensingElementInfo;
        @XmlElement(name = "PressureSensingElementInfo")
        protected String pressureSensingElementInfo;
        @XmlElement(name = "ProjectRegistrationNode")
        protected List<AttachmentType> projectRegistrationNode;
        @XmlElement(name = "Certificate")
        protected List<AttachmentType> certificate;

        /**
         * Gets the value of the remoteMeteringInfo property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getRemoteMeteringInfo() {
            return remoteMeteringInfo;
        }

        /**
         * Sets the value of the remoteMeteringInfo property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setRemoteMeteringInfo(String value) {
            this.remoteMeteringInfo = value;
        }

        /**
         * Gets the value of the temperatureSensingElementInfo property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getTemperatureSensingElementInfo() {
            return temperatureSensingElementInfo;
        }

        /**
         * Sets the value of the temperatureSensingElementInfo property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setTemperatureSensingElementInfo(String value) {
            this.temperatureSensingElementInfo = value;
        }

        /**
         * Gets the value of the pressureSensingElementInfo property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getPressureSensingElementInfo() {
            return pressureSensingElementInfo;
        }

        /**
         * Sets the value of the pressureSensingElementInfo property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setPressureSensingElementInfo(String value) {
            this.pressureSensingElementInfo = value;
        }

        /**
         * Gets the value of the projectRegistrationNode property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the projectRegistrationNode property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getProjectRegistrationNode().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link AttachmentType }
         * 
         * 
         */
        public List<AttachmentType> getProjectRegistrationNode() {
            if (projectRegistrationNode == null) {
                projectRegistrationNode = new ArrayList<AttachmentType>();
            }
            return this.projectRegistrationNode;
        }

        /**
         * Gets the value of the certificate property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the certificate property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getCertificate().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link AttachmentType }
         * 
         * 
         */
        public List<AttachmentType> getCertificate() {
            if (certificate == null) {
                certificate = new ArrayList<AttachmentType>();
            }
            return this.certificate;
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
     *         &lt;element name="LivingRoomGUID" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType" maxOccurs="unbounded"/>
     *         &lt;element name="AccountGUID" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType" maxOccurs="unbounded"/>
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
        "livingRoomGUID",
        "accountGUID"
    })
    public static class LivingRoomDevice {

        @XmlElement(name = "LivingRoomGUID", required = true)
        protected List<String> livingRoomGUID;
        @XmlElement(name = "AccountGUID", required = true)
        protected List<String> accountGUID;

        /**
         * Gets the value of the livingRoomGUID property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the livingRoomGUID property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getLivingRoomGUID().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link String }
         * 
         * 
         */
        public List<String> getLivingRoomGUID() {
            if (livingRoomGUID == null) {
                livingRoomGUID = new ArrayList<String>();
            }
            return this.livingRoomGUID;
        }

        /**
         * Gets the value of the accountGUID property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the accountGUID property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getAccountGUID().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link String }
         * 
         * 
         */
        public List<String> getAccountGUID() {
            if (accountGUID == null) {
                accountGUID = new ArrayList<String>();
            }
            return this.accountGUID;
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
     *         &lt;element name="PremiseGUID" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType"/>
     *         &lt;element name="AccountGUID" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType" maxOccurs="unbounded"/>
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
        "premiseGUID",
        "accountGUID"
    })
    public static class NonResidentialPremiseDevice {

        @XmlElement(name = "PremiseGUID", required = true)
        protected String premiseGUID;
        @XmlElement(name = "AccountGUID", required = true)
        protected List<String> accountGUID;

        /**
         * Gets the value of the premiseGUID property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getPremiseGUID() {
            return premiseGUID;
        }

        /**
         * Sets the value of the premiseGUID property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setPremiseGUID(String value) {
            this.premiseGUID = value;
        }

        /**
         * Gets the value of the accountGUID property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the accountGUID property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getAccountGUID().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link String }
         * 
         * 
         */
        public List<String> getAccountGUID() {
            if (accountGUID == null) {
                accountGUID = new ArrayList<String>();
            }
            return this.accountGUID;
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
     *         &lt;element name="PremiseGUID" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType"/>
     *         &lt;element name="AccountGUID" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType" maxOccurs="unbounded"/>
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
        "premiseGUID",
        "accountGUID"
    })
    public static class ResidentialPremiseDevice {

        @XmlElement(name = "PremiseGUID", required = true)
        protected String premiseGUID;
        @XmlElement(name = "AccountGUID", required = true)
        protected List<String> accountGUID;

        /**
         * Gets the value of the premiseGUID property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getPremiseGUID() {
            return premiseGUID;
        }

        /**
         * Sets the value of the premiseGUID property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setPremiseGUID(String value) {
            this.premiseGUID = value;
        }

        /**
         * Gets the value of the accountGUID property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the accountGUID property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getAccountGUID().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link String }
         * 
         * 
         */
        public List<String> getAccountGUID() {
            if (accountGUID == null) {
                accountGUID = new ArrayList<String>();
            }
            return this.accountGUID;
        }

    }

}
