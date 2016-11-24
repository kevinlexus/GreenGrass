
package ru.gosuslugi.dom.schema.integration.device_metering;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;
import ru.gosuslugi.dom.schema.integration.base.BaseType;
import ru.gosuslugi.dom.schema.integration.metering_device_base.ElectricMeteringValueType;
import ru.gosuslugi.dom.schema.integration.metering_device_base.OneRateMeteringValueType;
import ru.gosuslugi.dom.schema.integration.nsi_base.NsiRef;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/base/}BaseType">
 *       &lt;sequence>
 *         &lt;element name="FIASHouseGuid" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType"/>
 *         &lt;element name="MeteringDevicesValues" maxOccurs="1000">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;choice>
 *                     &lt;element name="MeteringDeviceRootGUID" type="{http://dom.gosuslugi.ru/schema/integration/metering-device-base/}MeteringDeviceGUIDType"/>
 *                     &lt;element name="MeteringDeviceVersionGUID" type="{http://dom.gosuslugi.ru/schema/integration/metering-device-base/}MeteringDeviceGUIDType"/>
 *                   &lt;/choice>
 *                   &lt;choice>
 *                     &lt;element name="OneRateDeviceValue">
 *                       &lt;complexType>
 *                         &lt;complexContent>
 *                           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                             &lt;sequence>
 *                               &lt;element name="CurrentValue" maxOccurs="3" minOccurs="0">
 *                                 &lt;complexType>
 *                                   &lt;complexContent>
 *                                     &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/metering-device-base/}OneRateMeteringValueType">
 *                                       &lt;sequence>
 *                                         &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/base/}TransportGUID"/>
 *                                       &lt;/sequence>
 *                                     &lt;/extension>
 *                                   &lt;/complexContent>
 *                                 &lt;/complexType>
 *                               &lt;/element>
 *                               &lt;element name="ControlValue" maxOccurs="3" minOccurs="0">
 *                                 &lt;complexType>
 *                                   &lt;complexContent>
 *                                     &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/metering-device-base/}OneRateMeteringValueType">
 *                                       &lt;sequence>
 *                                         &lt;element name="DateValue" type="{http://www.w3.org/2001/XMLSchema}date"/>
 *                                         &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/base/}TransportGUID"/>
 *                                       &lt;/sequence>
 *                                     &lt;/extension>
 *                                   &lt;/complexContent>
 *                                 &lt;/complexType>
 *                               &lt;/element>
 *                               &lt;element name="VerificationValue" minOccurs="0">
 *                                 &lt;complexType>
 *                                   &lt;complexContent>
 *                                     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                       &lt;sequence>
 *                                         &lt;element name="StartDateValue" type="{http://www.w3.org/2001/XMLSchema}date"/>
 *                                         &lt;element name="EndDateValue" type="{http://www.w3.org/2001/XMLSchema}date"/>
 *                                         &lt;element name="SealDate" type="{http://www.w3.org/2001/XMLSchema}date"/>
 *                                         &lt;element name="StartValue" type="{http://dom.gosuslugi.ru/schema/integration/metering-device-base/}OneRateMeteringValueType" maxOccurs="3"/>
 *                                         &lt;element name="EndValue" type="{http://dom.gosuslugi.ru/schema/integration/metering-device-base/}OneRateMeteringValueType" maxOccurs="3"/>
 *                                         &lt;choice>
 *                                           &lt;element name="PlannedVerification" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *                                           &lt;element name="VerificationReason" type="{http://dom.gosuslugi.ru/schema/integration/nsi-base/}nsiRef"/>
 *                                         &lt;/choice>
 *                                         &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/base/}TransportGUID"/>
 *                                       &lt;/sequence>
 *                                     &lt;/restriction>
 *                                   &lt;/complexContent>
 *                                 &lt;/complexType>
 *                               &lt;/element>
 *                             &lt;/sequence>
 *                           &lt;/restriction>
 *                         &lt;/complexContent>
 *                       &lt;/complexType>
 *                     &lt;/element>
 *                     &lt;element name="ElectricDeviceValue">
 *                       &lt;complexType>
 *                         &lt;complexContent>
 *                           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                             &lt;sequence>
 *                               &lt;element name="CurrentValue" maxOccurs="unbounded" minOccurs="0">
 *                                 &lt;complexType>
 *                                   &lt;complexContent>
 *                                     &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/metering-device-base/}ElectricMeteringValueType">
 *                                       &lt;sequence>
 *                                         &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/base/}TransportGUID"/>
 *                                       &lt;/sequence>
 *                                     &lt;/extension>
 *                                   &lt;/complexContent>
 *                                 &lt;/complexType>
 *                               &lt;/element>
 *                               &lt;element name="ControlValue" maxOccurs="unbounded" minOccurs="0">
 *                                 &lt;complexType>
 *                                   &lt;complexContent>
 *                                     &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/metering-device-base/}ElectricMeteringValueType">
 *                                       &lt;sequence>
 *                                         &lt;element name="DateValue" type="{http://www.w3.org/2001/XMLSchema}date"/>
 *                                         &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/base/}TransportGUID"/>
 *                                       &lt;/sequence>
 *                                     &lt;/extension>
 *                                   &lt;/complexContent>
 *                                 &lt;/complexType>
 *                               &lt;/element>
 *                               &lt;element name="VerificationValue" maxOccurs="unbounded" minOccurs="0">
 *                                 &lt;complexType>
 *                                   &lt;complexContent>
 *                                     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                       &lt;sequence>
 *                                         &lt;element name="StartDateValue" type="{http://www.w3.org/2001/XMLSchema}date"/>
 *                                         &lt;element name="EndDateValue" type="{http://www.w3.org/2001/XMLSchema}date"/>
 *                                         &lt;element name="SealDate" type="{http://www.w3.org/2001/XMLSchema}date"/>
 *                                         &lt;element name="StartValue" type="{http://dom.gosuslugi.ru/schema/integration/metering-device-base/}ElectricMeteringValueType"/>
 *                                         &lt;element name="EndValue" type="{http://dom.gosuslugi.ru/schema/integration/metering-device-base/}ElectricMeteringValueType"/>
 *                                         &lt;choice>
 *                                           &lt;element name="PlannedVerification" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *                                           &lt;element name="VerificationReason" type="{http://dom.gosuslugi.ru/schema/integration/nsi-base/}nsiRef"/>
 *                                         &lt;/choice>
 *                                         &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/base/}TransportGUID"/>
 *                                       &lt;/sequence>
 *                                     &lt;/restriction>
 *                                   &lt;/complexContent>
 *                                 &lt;/complexType>
 *                               &lt;/element>
 *                             &lt;/sequence>
 *                           &lt;/restriction>
 *                         &lt;/complexContent>
 *                       &lt;/complexType>
 *                     &lt;/element>
 *                   &lt;/choice>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *       &lt;/sequence>
 *       &lt;attribute ref="{http://dom.gosuslugi.ru/schema/integration/base/}version use="required" fixed="10.0.1.1""/>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "fiasHouseGuid",
    "meteringDevicesValues"
})
@XmlRootElement(name = "importMeteringDeviceValuesRequest")
public class ImportMeteringDeviceValuesRequest
    extends BaseType
{

    @XmlElement(name = "FIASHouseGuid", required = true)
    protected String fiasHouseGuid;
    @XmlElement(name = "MeteringDevicesValues", required = true)
    protected List<ImportMeteringDeviceValuesRequest.MeteringDevicesValues> meteringDevicesValues;
    @XmlAttribute(name = "version", namespace = "http://dom.gosuslugi.ru/schema/integration/base/", required = true)
    protected String version;

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
     * Gets the value of the meteringDevicesValues property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the meteringDevicesValues property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getMeteringDevicesValues().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ImportMeteringDeviceValuesRequest.MeteringDevicesValues }
     * 
     * 
     */
    public List<ImportMeteringDeviceValuesRequest.MeteringDevicesValues> getMeteringDevicesValues() {
        if (meteringDevicesValues == null) {
            meteringDevicesValues = new ArrayList<ImportMeteringDeviceValuesRequest.MeteringDevicesValues>();
        }
        return this.meteringDevicesValues;
    }

    /**
     * Gets the value of the version property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVersion() {
        if (version == null) {
            return "10.0.1.1";
        } else {
            return version;
        }
    }

    /**
     * Sets the value of the version property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVersion(String value) {
        this.version = value;
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
     *           &lt;element name="MeteringDeviceRootGUID" type="{http://dom.gosuslugi.ru/schema/integration/metering-device-base/}MeteringDeviceGUIDType"/>
     *           &lt;element name="MeteringDeviceVersionGUID" type="{http://dom.gosuslugi.ru/schema/integration/metering-device-base/}MeteringDeviceGUIDType"/>
     *         &lt;/choice>
     *         &lt;choice>
     *           &lt;element name="OneRateDeviceValue">
     *             &lt;complexType>
     *               &lt;complexContent>
     *                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                   &lt;sequence>
     *                     &lt;element name="CurrentValue" maxOccurs="3" minOccurs="0">
     *                       &lt;complexType>
     *                         &lt;complexContent>
     *                           &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/metering-device-base/}OneRateMeteringValueType">
     *                             &lt;sequence>
     *                               &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/base/}TransportGUID"/>
     *                             &lt;/sequence>
     *                           &lt;/extension>
     *                         &lt;/complexContent>
     *                       &lt;/complexType>
     *                     &lt;/element>
     *                     &lt;element name="ControlValue" maxOccurs="3" minOccurs="0">
     *                       &lt;complexType>
     *                         &lt;complexContent>
     *                           &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/metering-device-base/}OneRateMeteringValueType">
     *                             &lt;sequence>
     *                               &lt;element name="DateValue" type="{http://www.w3.org/2001/XMLSchema}date"/>
     *                               &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/base/}TransportGUID"/>
     *                             &lt;/sequence>
     *                           &lt;/extension>
     *                         &lt;/complexContent>
     *                       &lt;/complexType>
     *                     &lt;/element>
     *                     &lt;element name="VerificationValue" minOccurs="0">
     *                       &lt;complexType>
     *                         &lt;complexContent>
     *                           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                             &lt;sequence>
     *                               &lt;element name="StartDateValue" type="{http://www.w3.org/2001/XMLSchema}date"/>
     *                               &lt;element name="EndDateValue" type="{http://www.w3.org/2001/XMLSchema}date"/>
     *                               &lt;element name="SealDate" type="{http://www.w3.org/2001/XMLSchema}date"/>
     *                               &lt;element name="StartValue" type="{http://dom.gosuslugi.ru/schema/integration/metering-device-base/}OneRateMeteringValueType" maxOccurs="3"/>
     *                               &lt;element name="EndValue" type="{http://dom.gosuslugi.ru/schema/integration/metering-device-base/}OneRateMeteringValueType" maxOccurs="3"/>
     *                               &lt;choice>
     *                                 &lt;element name="PlannedVerification" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
     *                                 &lt;element name="VerificationReason" type="{http://dom.gosuslugi.ru/schema/integration/nsi-base/}nsiRef"/>
     *                               &lt;/choice>
     *                               &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/base/}TransportGUID"/>
     *                             &lt;/sequence>
     *                           &lt;/restriction>
     *                         &lt;/complexContent>
     *                       &lt;/complexType>
     *                     &lt;/element>
     *                   &lt;/sequence>
     *                 &lt;/restriction>
     *               &lt;/complexContent>
     *             &lt;/complexType>
     *           &lt;/element>
     *           &lt;element name="ElectricDeviceValue">
     *             &lt;complexType>
     *               &lt;complexContent>
     *                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                   &lt;sequence>
     *                     &lt;element name="CurrentValue" maxOccurs="unbounded" minOccurs="0">
     *                       &lt;complexType>
     *                         &lt;complexContent>
     *                           &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/metering-device-base/}ElectricMeteringValueType">
     *                             &lt;sequence>
     *                               &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/base/}TransportGUID"/>
     *                             &lt;/sequence>
     *                           &lt;/extension>
     *                         &lt;/complexContent>
     *                       &lt;/complexType>
     *                     &lt;/element>
     *                     &lt;element name="ControlValue" maxOccurs="unbounded" minOccurs="0">
     *                       &lt;complexType>
     *                         &lt;complexContent>
     *                           &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/metering-device-base/}ElectricMeteringValueType">
     *                             &lt;sequence>
     *                               &lt;element name="DateValue" type="{http://www.w3.org/2001/XMLSchema}date"/>
     *                               &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/base/}TransportGUID"/>
     *                             &lt;/sequence>
     *                           &lt;/extension>
     *                         &lt;/complexContent>
     *                       &lt;/complexType>
     *                     &lt;/element>
     *                     &lt;element name="VerificationValue" maxOccurs="unbounded" minOccurs="0">
     *                       &lt;complexType>
     *                         &lt;complexContent>
     *                           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                             &lt;sequence>
     *                               &lt;element name="StartDateValue" type="{http://www.w3.org/2001/XMLSchema}date"/>
     *                               &lt;element name="EndDateValue" type="{http://www.w3.org/2001/XMLSchema}date"/>
     *                               &lt;element name="SealDate" type="{http://www.w3.org/2001/XMLSchema}date"/>
     *                               &lt;element name="StartValue" type="{http://dom.gosuslugi.ru/schema/integration/metering-device-base/}ElectricMeteringValueType"/>
     *                               &lt;element name="EndValue" type="{http://dom.gosuslugi.ru/schema/integration/metering-device-base/}ElectricMeteringValueType"/>
     *                               &lt;choice>
     *                                 &lt;element name="PlannedVerification" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
     *                                 &lt;element name="VerificationReason" type="{http://dom.gosuslugi.ru/schema/integration/nsi-base/}nsiRef"/>
     *                               &lt;/choice>
     *                               &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/base/}TransportGUID"/>
     *                             &lt;/sequence>
     *                           &lt;/restriction>
     *                         &lt;/complexContent>
     *                       &lt;/complexType>
     *                     &lt;/element>
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
    @XmlType(name = "", propOrder = {
        "meteringDeviceRootGUID",
        "meteringDeviceVersionGUID",
        "oneRateDeviceValue",
        "electricDeviceValue"
    })
    public static class MeteringDevicesValues {

        @XmlElement(name = "MeteringDeviceRootGUID")
        protected String meteringDeviceRootGUID;
        @XmlElement(name = "MeteringDeviceVersionGUID")
        protected String meteringDeviceVersionGUID;
        @XmlElement(name = "OneRateDeviceValue")
        protected ImportMeteringDeviceValuesRequest.MeteringDevicesValues.OneRateDeviceValue oneRateDeviceValue;
        @XmlElement(name = "ElectricDeviceValue")
        protected ImportMeteringDeviceValuesRequest.MeteringDevicesValues.ElectricDeviceValue electricDeviceValue;

        /**
         * Gets the value of the meteringDeviceRootGUID property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getMeteringDeviceRootGUID() {
            return meteringDeviceRootGUID;
        }

        /**
         * Sets the value of the meteringDeviceRootGUID property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setMeteringDeviceRootGUID(String value) {
            this.meteringDeviceRootGUID = value;
        }

        /**
         * Gets the value of the meteringDeviceVersionGUID property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getMeteringDeviceVersionGUID() {
            return meteringDeviceVersionGUID;
        }

        /**
         * Sets the value of the meteringDeviceVersionGUID property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setMeteringDeviceVersionGUID(String value) {
            this.meteringDeviceVersionGUID = value;
        }

        /**
         * Gets the value of the oneRateDeviceValue property.
         * 
         * @return
         *     possible object is
         *     {@link ImportMeteringDeviceValuesRequest.MeteringDevicesValues.OneRateDeviceValue }
         *     
         */
        public ImportMeteringDeviceValuesRequest.MeteringDevicesValues.OneRateDeviceValue getOneRateDeviceValue() {
            return oneRateDeviceValue;
        }

        /**
         * Sets the value of the oneRateDeviceValue property.
         * 
         * @param value
         *     allowed object is
         *     {@link ImportMeteringDeviceValuesRequest.MeteringDevicesValues.OneRateDeviceValue }
         *     
         */
        public void setOneRateDeviceValue(ImportMeteringDeviceValuesRequest.MeteringDevicesValues.OneRateDeviceValue value) {
            this.oneRateDeviceValue = value;
        }

        /**
         * Gets the value of the electricDeviceValue property.
         * 
         * @return
         *     possible object is
         *     {@link ImportMeteringDeviceValuesRequest.MeteringDevicesValues.ElectricDeviceValue }
         *     
         */
        public ImportMeteringDeviceValuesRequest.MeteringDevicesValues.ElectricDeviceValue getElectricDeviceValue() {
            return electricDeviceValue;
        }

        /**
         * Sets the value of the electricDeviceValue property.
         * 
         * @param value
         *     allowed object is
         *     {@link ImportMeteringDeviceValuesRequest.MeteringDevicesValues.ElectricDeviceValue }
         *     
         */
        public void setElectricDeviceValue(ImportMeteringDeviceValuesRequest.MeteringDevicesValues.ElectricDeviceValue value) {
            this.electricDeviceValue = value;
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
         *         &lt;element name="CurrentValue" maxOccurs="unbounded" minOccurs="0">
         *           &lt;complexType>
         *             &lt;complexContent>
         *               &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/metering-device-base/}ElectricMeteringValueType">
         *                 &lt;sequence>
         *                   &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/base/}TransportGUID"/>
         *                 &lt;/sequence>
         *               &lt;/extension>
         *             &lt;/complexContent>
         *           &lt;/complexType>
         *         &lt;/element>
         *         &lt;element name="ControlValue" maxOccurs="unbounded" minOccurs="0">
         *           &lt;complexType>
         *             &lt;complexContent>
         *               &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/metering-device-base/}ElectricMeteringValueType">
         *                 &lt;sequence>
         *                   &lt;element name="DateValue" type="{http://www.w3.org/2001/XMLSchema}date"/>
         *                   &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/base/}TransportGUID"/>
         *                 &lt;/sequence>
         *               &lt;/extension>
         *             &lt;/complexContent>
         *           &lt;/complexType>
         *         &lt;/element>
         *         &lt;element name="VerificationValue" maxOccurs="unbounded" minOccurs="0">
         *           &lt;complexType>
         *             &lt;complexContent>
         *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *                 &lt;sequence>
         *                   &lt;element name="StartDateValue" type="{http://www.w3.org/2001/XMLSchema}date"/>
         *                   &lt;element name="EndDateValue" type="{http://www.w3.org/2001/XMLSchema}date"/>
         *                   &lt;element name="SealDate" type="{http://www.w3.org/2001/XMLSchema}date"/>
         *                   &lt;element name="StartValue" type="{http://dom.gosuslugi.ru/schema/integration/metering-device-base/}ElectricMeteringValueType"/>
         *                   &lt;element name="EndValue" type="{http://dom.gosuslugi.ru/schema/integration/metering-device-base/}ElectricMeteringValueType"/>
         *                   &lt;choice>
         *                     &lt;element name="PlannedVerification" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
         *                     &lt;element name="VerificationReason" type="{http://dom.gosuslugi.ru/schema/integration/nsi-base/}nsiRef"/>
         *                   &lt;/choice>
         *                   &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/base/}TransportGUID"/>
         *                 &lt;/sequence>
         *               &lt;/restriction>
         *             &lt;/complexContent>
         *           &lt;/complexType>
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
            "currentValue",
            "controlValue",
            "verificationValue"
        })
        public static class ElectricDeviceValue {

            @XmlElement(name = "CurrentValue")
            protected List<ImportMeteringDeviceValuesRequest.MeteringDevicesValues.ElectricDeviceValue.CurrentValue> currentValue;
            @XmlElement(name = "ControlValue")
            protected List<ImportMeteringDeviceValuesRequest.MeteringDevicesValues.ElectricDeviceValue.ControlValue> controlValue;
            @XmlElement(name = "VerificationValue")
            protected List<ImportMeteringDeviceValuesRequest.MeteringDevicesValues.ElectricDeviceValue.VerificationValue> verificationValue;

            /**
             * Gets the value of the currentValue property.
             * 
             * <p>
             * This accessor method returns a reference to the live list,
             * not a snapshot. Therefore any modification you make to the
             * returned list will be present inside the JAXB object.
             * This is why there is not a <CODE>set</CODE> method for the currentValue property.
             * 
             * <p>
             * For example, to add a new item, do as follows:
             * <pre>
             *    getCurrentValue().add(newItem);
             * </pre>
             * 
             * 
             * <p>
             * Objects of the following type(s) are allowed in the list
             * {@link ImportMeteringDeviceValuesRequest.MeteringDevicesValues.ElectricDeviceValue.CurrentValue }
             * 
             * 
             */
            public List<ImportMeteringDeviceValuesRequest.MeteringDevicesValues.ElectricDeviceValue.CurrentValue> getCurrentValue() {
                if (currentValue == null) {
                    currentValue = new ArrayList<ImportMeteringDeviceValuesRequest.MeteringDevicesValues.ElectricDeviceValue.CurrentValue>();
                }
                return this.currentValue;
            }

            /**
             * Gets the value of the controlValue property.
             * 
             * <p>
             * This accessor method returns a reference to the live list,
             * not a snapshot. Therefore any modification you make to the
             * returned list will be present inside the JAXB object.
             * This is why there is not a <CODE>set</CODE> method for the controlValue property.
             * 
             * <p>
             * For example, to add a new item, do as follows:
             * <pre>
             *    getControlValue().add(newItem);
             * </pre>
             * 
             * 
             * <p>
             * Objects of the following type(s) are allowed in the list
             * {@link ImportMeteringDeviceValuesRequest.MeteringDevicesValues.ElectricDeviceValue.ControlValue }
             * 
             * 
             */
            public List<ImportMeteringDeviceValuesRequest.MeteringDevicesValues.ElectricDeviceValue.ControlValue> getControlValue() {
                if (controlValue == null) {
                    controlValue = new ArrayList<ImportMeteringDeviceValuesRequest.MeteringDevicesValues.ElectricDeviceValue.ControlValue>();
                }
                return this.controlValue;
            }

            /**
             * Gets the value of the verificationValue property.
             * 
             * <p>
             * This accessor method returns a reference to the live list,
             * not a snapshot. Therefore any modification you make to the
             * returned list will be present inside the JAXB object.
             * This is why there is not a <CODE>set</CODE> method for the verificationValue property.
             * 
             * <p>
             * For example, to add a new item, do as follows:
             * <pre>
             *    getVerificationValue().add(newItem);
             * </pre>
             * 
             * 
             * <p>
             * Objects of the following type(s) are allowed in the list
             * {@link ImportMeteringDeviceValuesRequest.MeteringDevicesValues.ElectricDeviceValue.VerificationValue }
             * 
             * 
             */
            public List<ImportMeteringDeviceValuesRequest.MeteringDevicesValues.ElectricDeviceValue.VerificationValue> getVerificationValue() {
                if (verificationValue == null) {
                    verificationValue = new ArrayList<ImportMeteringDeviceValuesRequest.MeteringDevicesValues.ElectricDeviceValue.VerificationValue>();
                }
                return this.verificationValue;
            }


            /**
             * <p>Java class for anonymous complex type.
             * 
             * <p>The following schema fragment specifies the expected content contained within this class.
             * 
             * <pre>
             * &lt;complexType>
             *   &lt;complexContent>
             *     &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/metering-device-base/}ElectricMeteringValueType">
             *       &lt;sequence>
             *         &lt;element name="DateValue" type="{http://www.w3.org/2001/XMLSchema}date"/>
             *         &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/base/}TransportGUID"/>
             *       &lt;/sequence>
             *     &lt;/extension>
             *   &lt;/complexContent>
             * &lt;/complexType>
             * </pre>
             * 
             * 
             */
            @XmlAccessorType(XmlAccessType.FIELD)
            @XmlType(name = "", propOrder = {
                "dateValue",
                "transportGUID"
            })
            public static class ControlValue
                extends ElectricMeteringValueType
            {

                @XmlElement(name = "DateValue", required = true)
                @XmlSchemaType(name = "date")
                protected XMLGregorianCalendar dateValue;
                @XmlElement(name = "TransportGUID", namespace = "http://dom.gosuslugi.ru/schema/integration/base/", required = true)
                protected String transportGUID;

                /**
                 * Gets the value of the dateValue property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link XMLGregorianCalendar }
                 *     
                 */
                public XMLGregorianCalendar getDateValue() {
                    return dateValue;
                }

                /**
                 * Sets the value of the dateValue property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link XMLGregorianCalendar }
                 *     
                 */
                public void setDateValue(XMLGregorianCalendar value) {
                    this.dateValue = value;
                }

                /**
                 * Gets the value of the transportGUID property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getTransportGUID() {
                    return transportGUID;
                }

                /**
                 * Sets the value of the transportGUID property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setTransportGUID(String value) {
                    this.transportGUID = value;
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
             *     &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/metering-device-base/}ElectricMeteringValueType">
             *       &lt;sequence>
             *         &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/base/}TransportGUID"/>
             *       &lt;/sequence>
             *     &lt;/extension>
             *   &lt;/complexContent>
             * &lt;/complexType>
             * </pre>
             * 
             * 
             */
            @XmlAccessorType(XmlAccessType.FIELD)
            @XmlType(name = "", propOrder = {
                "transportGUID"
            })
            public static class CurrentValue
                extends ElectricMeteringValueType
            {

                @XmlElement(name = "TransportGUID", namespace = "http://dom.gosuslugi.ru/schema/integration/base/", required = true)
                protected String transportGUID;

                /**
                 * Gets the value of the transportGUID property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getTransportGUID() {
                    return transportGUID;
                }

                /**
                 * Sets the value of the transportGUID property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setTransportGUID(String value) {
                    this.transportGUID = value;
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
             *         &lt;element name="StartDateValue" type="{http://www.w3.org/2001/XMLSchema}date"/>
             *         &lt;element name="EndDateValue" type="{http://www.w3.org/2001/XMLSchema}date"/>
             *         &lt;element name="SealDate" type="{http://www.w3.org/2001/XMLSchema}date"/>
             *         &lt;element name="StartValue" type="{http://dom.gosuslugi.ru/schema/integration/metering-device-base/}ElectricMeteringValueType"/>
             *         &lt;element name="EndValue" type="{http://dom.gosuslugi.ru/schema/integration/metering-device-base/}ElectricMeteringValueType"/>
             *         &lt;choice>
             *           &lt;element name="PlannedVerification" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
             *           &lt;element name="VerificationReason" type="{http://dom.gosuslugi.ru/schema/integration/nsi-base/}nsiRef"/>
             *         &lt;/choice>
             *         &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/base/}TransportGUID"/>
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
                "startDateValue",
                "endDateValue",
                "sealDate",
                "startValue",
                "endValue",
                "plannedVerification",
                "verificationReason",
                "transportGUID"
            })
            public static class VerificationValue {

                @XmlElement(name = "StartDateValue", required = true)
                @XmlSchemaType(name = "date")
                protected XMLGregorianCalendar startDateValue;
                @XmlElement(name = "EndDateValue", required = true)
                @XmlSchemaType(name = "date")
                protected XMLGregorianCalendar endDateValue;
                @XmlElement(name = "SealDate", required = true)
                @XmlSchemaType(name = "date")
                protected XMLGregorianCalendar sealDate;
                @XmlElement(name = "StartValue", required = true)
                protected ElectricMeteringValueType startValue;
                @XmlElement(name = "EndValue", required = true)
                protected ElectricMeteringValueType endValue;
                @XmlElement(name = "PlannedVerification")
                protected Boolean plannedVerification;
                @XmlElement(name = "VerificationReason")
                protected NsiRef verificationReason;
                @XmlElement(name = "TransportGUID", namespace = "http://dom.gosuslugi.ru/schema/integration/base/", required = true)
                protected String transportGUID;

                /**
                 * Gets the value of the startDateValue property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link XMLGregorianCalendar }
                 *     
                 */
                public XMLGregorianCalendar getStartDateValue() {
                    return startDateValue;
                }

                /**
                 * Sets the value of the startDateValue property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link XMLGregorianCalendar }
                 *     
                 */
                public void setStartDateValue(XMLGregorianCalendar value) {
                    this.startDateValue = value;
                }

                /**
                 * Gets the value of the endDateValue property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link XMLGregorianCalendar }
                 *     
                 */
                public XMLGregorianCalendar getEndDateValue() {
                    return endDateValue;
                }

                /**
                 * Sets the value of the endDateValue property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link XMLGregorianCalendar }
                 *     
                 */
                public void setEndDateValue(XMLGregorianCalendar value) {
                    this.endDateValue = value;
                }

                /**
                 * Gets the value of the sealDate property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link XMLGregorianCalendar }
                 *     
                 */
                public XMLGregorianCalendar getSealDate() {
                    return sealDate;
                }

                /**
                 * Sets the value of the sealDate property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link XMLGregorianCalendar }
                 *     
                 */
                public void setSealDate(XMLGregorianCalendar value) {
                    this.sealDate = value;
                }

                /**
                 * Gets the value of the startValue property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link ElectricMeteringValueType }
                 *     
                 */
                public ElectricMeteringValueType getStartValue() {
                    return startValue;
                }

                /**
                 * Sets the value of the startValue property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link ElectricMeteringValueType }
                 *     
                 */
                public void setStartValue(ElectricMeteringValueType value) {
                    this.startValue = value;
                }

                /**
                 * Gets the value of the endValue property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link ElectricMeteringValueType }
                 *     
                 */
                public ElectricMeteringValueType getEndValue() {
                    return endValue;
                }

                /**
                 * Sets the value of the endValue property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link ElectricMeteringValueType }
                 *     
                 */
                public void setEndValue(ElectricMeteringValueType value) {
                    this.endValue = value;
                }

                /**
                 * Gets the value of the plannedVerification property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link Boolean }
                 *     
                 */
                public Boolean isPlannedVerification() {
                    return plannedVerification;
                }

                /**
                 * Sets the value of the plannedVerification property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link Boolean }
                 *     
                 */
                public void setPlannedVerification(Boolean value) {
                    this.plannedVerification = value;
                }

                /**
                 * Gets the value of the verificationReason property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link NsiRef }
                 *     
                 */
                public NsiRef getVerificationReason() {
                    return verificationReason;
                }

                /**
                 * Sets the value of the verificationReason property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link NsiRef }
                 *     
                 */
                public void setVerificationReason(NsiRef value) {
                    this.verificationReason = value;
                }

                /**
                 * Gets the value of the transportGUID property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getTransportGUID() {
                    return transportGUID;
                }

                /**
                 * Sets the value of the transportGUID property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setTransportGUID(String value) {
                    this.transportGUID = value;
                }

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
         *         &lt;element name="CurrentValue" maxOccurs="3" minOccurs="0">
         *           &lt;complexType>
         *             &lt;complexContent>
         *               &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/metering-device-base/}OneRateMeteringValueType">
         *                 &lt;sequence>
         *                   &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/base/}TransportGUID"/>
         *                 &lt;/sequence>
         *               &lt;/extension>
         *             &lt;/complexContent>
         *           &lt;/complexType>
         *         &lt;/element>
         *         &lt;element name="ControlValue" maxOccurs="3" minOccurs="0">
         *           &lt;complexType>
         *             &lt;complexContent>
         *               &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/metering-device-base/}OneRateMeteringValueType">
         *                 &lt;sequence>
         *                   &lt;element name="DateValue" type="{http://www.w3.org/2001/XMLSchema}date"/>
         *                   &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/base/}TransportGUID"/>
         *                 &lt;/sequence>
         *               &lt;/extension>
         *             &lt;/complexContent>
         *           &lt;/complexType>
         *         &lt;/element>
         *         &lt;element name="VerificationValue" minOccurs="0">
         *           &lt;complexType>
         *             &lt;complexContent>
         *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *                 &lt;sequence>
         *                   &lt;element name="StartDateValue" type="{http://www.w3.org/2001/XMLSchema}date"/>
         *                   &lt;element name="EndDateValue" type="{http://www.w3.org/2001/XMLSchema}date"/>
         *                   &lt;element name="SealDate" type="{http://www.w3.org/2001/XMLSchema}date"/>
         *                   &lt;element name="StartValue" type="{http://dom.gosuslugi.ru/schema/integration/metering-device-base/}OneRateMeteringValueType" maxOccurs="3"/>
         *                   &lt;element name="EndValue" type="{http://dom.gosuslugi.ru/schema/integration/metering-device-base/}OneRateMeteringValueType" maxOccurs="3"/>
         *                   &lt;choice>
         *                     &lt;element name="PlannedVerification" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
         *                     &lt;element name="VerificationReason" type="{http://dom.gosuslugi.ru/schema/integration/nsi-base/}nsiRef"/>
         *                   &lt;/choice>
         *                   &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/base/}TransportGUID"/>
         *                 &lt;/sequence>
         *               &lt;/restriction>
         *             &lt;/complexContent>
         *           &lt;/complexType>
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
            "currentValue",
            "controlValue",
            "verificationValue"
        })
        public static class OneRateDeviceValue {

            @XmlElement(name = "CurrentValue")
            protected List<ImportMeteringDeviceValuesRequest.MeteringDevicesValues.OneRateDeviceValue.CurrentValue> currentValue;
            @XmlElement(name = "ControlValue")
            protected List<ImportMeteringDeviceValuesRequest.MeteringDevicesValues.OneRateDeviceValue.ControlValue> controlValue;
            @XmlElement(name = "VerificationValue")
            protected ImportMeteringDeviceValuesRequest.MeteringDevicesValues.OneRateDeviceValue.VerificationValue verificationValue;

            /**
             * Gets the value of the currentValue property.
             * 
             * <p>
             * This accessor method returns a reference to the live list,
             * not a snapshot. Therefore any modification you make to the
             * returned list will be present inside the JAXB object.
             * This is why there is not a <CODE>set</CODE> method for the currentValue property.
             * 
             * <p>
             * For example, to add a new item, do as follows:
             * <pre>
             *    getCurrentValue().add(newItem);
             * </pre>
             * 
             * 
             * <p>
             * Objects of the following type(s) are allowed in the list
             * {@link ImportMeteringDeviceValuesRequest.MeteringDevicesValues.OneRateDeviceValue.CurrentValue }
             * 
             * 
             */
            public List<ImportMeteringDeviceValuesRequest.MeteringDevicesValues.OneRateDeviceValue.CurrentValue> getCurrentValue() {
                if (currentValue == null) {
                    currentValue = new ArrayList<ImportMeteringDeviceValuesRequest.MeteringDevicesValues.OneRateDeviceValue.CurrentValue>();
                }
                return this.currentValue;
            }

            /**
             * Gets the value of the controlValue property.
             * 
             * <p>
             * This accessor method returns a reference to the live list,
             * not a snapshot. Therefore any modification you make to the
             * returned list will be present inside the JAXB object.
             * This is why there is not a <CODE>set</CODE> method for the controlValue property.
             * 
             * <p>
             * For example, to add a new item, do as follows:
             * <pre>
             *    getControlValue().add(newItem);
             * </pre>
             * 
             * 
             * <p>
             * Objects of the following type(s) are allowed in the list
             * {@link ImportMeteringDeviceValuesRequest.MeteringDevicesValues.OneRateDeviceValue.ControlValue }
             * 
             * 
             */
            public List<ImportMeteringDeviceValuesRequest.MeteringDevicesValues.OneRateDeviceValue.ControlValue> getControlValue() {
                if (controlValue == null) {
                    controlValue = new ArrayList<ImportMeteringDeviceValuesRequest.MeteringDevicesValues.OneRateDeviceValue.ControlValue>();
                }
                return this.controlValue;
            }

            /**
             * Gets the value of the verificationValue property.
             * 
             * @return
             *     possible object is
             *     {@link ImportMeteringDeviceValuesRequest.MeteringDevicesValues.OneRateDeviceValue.VerificationValue }
             *     
             */
            public ImportMeteringDeviceValuesRequest.MeteringDevicesValues.OneRateDeviceValue.VerificationValue getVerificationValue() {
                return verificationValue;
            }

            /**
             * Sets the value of the verificationValue property.
             * 
             * @param value
             *     allowed object is
             *     {@link ImportMeteringDeviceValuesRequest.MeteringDevicesValues.OneRateDeviceValue.VerificationValue }
             *     
             */
            public void setVerificationValue(ImportMeteringDeviceValuesRequest.MeteringDevicesValues.OneRateDeviceValue.VerificationValue value) {
                this.verificationValue = value;
            }


            /**
             * <p>Java class for anonymous complex type.
             * 
             * <p>The following schema fragment specifies the expected content contained within this class.
             * 
             * <pre>
             * &lt;complexType>
             *   &lt;complexContent>
             *     &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/metering-device-base/}OneRateMeteringValueType">
             *       &lt;sequence>
             *         &lt;element name="DateValue" type="{http://www.w3.org/2001/XMLSchema}date"/>
             *         &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/base/}TransportGUID"/>
             *       &lt;/sequence>
             *     &lt;/extension>
             *   &lt;/complexContent>
             * &lt;/complexType>
             * </pre>
             * 
             * 
             */
            @XmlAccessorType(XmlAccessType.FIELD)
            @XmlType(name = "", propOrder = {
                "dateValue",
                "transportGUID"
            })
            public static class ControlValue
                extends OneRateMeteringValueType
            {

                @XmlElement(name = "DateValue", required = true)
                @XmlSchemaType(name = "date")
                protected XMLGregorianCalendar dateValue;
                @XmlElement(name = "TransportGUID", namespace = "http://dom.gosuslugi.ru/schema/integration/base/", required = true)
                protected String transportGUID;

                /**
                 * Gets the value of the dateValue property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link XMLGregorianCalendar }
                 *     
                 */
                public XMLGregorianCalendar getDateValue() {
                    return dateValue;
                }

                /**
                 * Sets the value of the dateValue property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link XMLGregorianCalendar }
                 *     
                 */
                public void setDateValue(XMLGregorianCalendar value) {
                    this.dateValue = value;
                }

                /**
                 * Gets the value of the transportGUID property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getTransportGUID() {
                    return transportGUID;
                }

                /**
                 * Sets the value of the transportGUID property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setTransportGUID(String value) {
                    this.transportGUID = value;
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
             *     &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/metering-device-base/}OneRateMeteringValueType">
             *       &lt;sequence>
             *         &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/base/}TransportGUID"/>
             *       &lt;/sequence>
             *     &lt;/extension>
             *   &lt;/complexContent>
             * &lt;/complexType>
             * </pre>
             * 
             * 
             */
            @XmlAccessorType(XmlAccessType.FIELD)
            @XmlType(name = "", propOrder = {
                "transportGUID"
            })
            public static class CurrentValue
                extends OneRateMeteringValueType
            {

                @XmlElement(name = "TransportGUID", namespace = "http://dom.gosuslugi.ru/schema/integration/base/", required = true)
                protected String transportGUID;

                /**
                 * Gets the value of the transportGUID property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getTransportGUID() {
                    return transportGUID;
                }

                /**
                 * Sets the value of the transportGUID property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setTransportGUID(String value) {
                    this.transportGUID = value;
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
             *         &lt;element name="StartDateValue" type="{http://www.w3.org/2001/XMLSchema}date"/>
             *         &lt;element name="EndDateValue" type="{http://www.w3.org/2001/XMLSchema}date"/>
             *         &lt;element name="SealDate" type="{http://www.w3.org/2001/XMLSchema}date"/>
             *         &lt;element name="StartValue" type="{http://dom.gosuslugi.ru/schema/integration/metering-device-base/}OneRateMeteringValueType" maxOccurs="3"/>
             *         &lt;element name="EndValue" type="{http://dom.gosuslugi.ru/schema/integration/metering-device-base/}OneRateMeteringValueType" maxOccurs="3"/>
             *         &lt;choice>
             *           &lt;element name="PlannedVerification" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
             *           &lt;element name="VerificationReason" type="{http://dom.gosuslugi.ru/schema/integration/nsi-base/}nsiRef"/>
             *         &lt;/choice>
             *         &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/base/}TransportGUID"/>
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
                "startDateValue",
                "endDateValue",
                "sealDate",
                "startValue",
                "endValue",
                "plannedVerification",
                "verificationReason",
                "transportGUID"
            })
            public static class VerificationValue {

                @XmlElement(name = "StartDateValue", required = true)
                @XmlSchemaType(name = "date")
                protected XMLGregorianCalendar startDateValue;
                @XmlElement(name = "EndDateValue", required = true)
                @XmlSchemaType(name = "date")
                protected XMLGregorianCalendar endDateValue;
                @XmlElement(name = "SealDate", required = true)
                @XmlSchemaType(name = "date")
                protected XMLGregorianCalendar sealDate;
                @XmlElement(name = "StartValue", required = true)
                protected List<OneRateMeteringValueType> startValue;
                @XmlElement(name = "EndValue", required = true)
                protected List<OneRateMeteringValueType> endValue;
                @XmlElement(name = "PlannedVerification")
                protected Boolean plannedVerification;
                @XmlElement(name = "VerificationReason")
                protected NsiRef verificationReason;
                @XmlElement(name = "TransportGUID", namespace = "http://dom.gosuslugi.ru/schema/integration/base/", required = true)
                protected String transportGUID;

                /**
                 * Gets the value of the startDateValue property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link XMLGregorianCalendar }
                 *     
                 */
                public XMLGregorianCalendar getStartDateValue() {
                    return startDateValue;
                }

                /**
                 * Sets the value of the startDateValue property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link XMLGregorianCalendar }
                 *     
                 */
                public void setStartDateValue(XMLGregorianCalendar value) {
                    this.startDateValue = value;
                }

                /**
                 * Gets the value of the endDateValue property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link XMLGregorianCalendar }
                 *     
                 */
                public XMLGregorianCalendar getEndDateValue() {
                    return endDateValue;
                }

                /**
                 * Sets the value of the endDateValue property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link XMLGregorianCalendar }
                 *     
                 */
                public void setEndDateValue(XMLGregorianCalendar value) {
                    this.endDateValue = value;
                }

                /**
                 * Gets the value of the sealDate property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link XMLGregorianCalendar }
                 *     
                 */
                public XMLGregorianCalendar getSealDate() {
                    return sealDate;
                }

                /**
                 * Sets the value of the sealDate property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link XMLGregorianCalendar }
                 *     
                 */
                public void setSealDate(XMLGregorianCalendar value) {
                    this.sealDate = value;
                }

                /**
                 * Gets the value of the startValue property.
                 * 
                 * <p>
                 * This accessor method returns a reference to the live list,
                 * not a snapshot. Therefore any modification you make to the
                 * returned list will be present inside the JAXB object.
                 * This is why there is not a <CODE>set</CODE> method for the startValue property.
                 * 
                 * <p>
                 * For example, to add a new item, do as follows:
                 * <pre>
                 *    getStartValue().add(newItem);
                 * </pre>
                 * 
                 * 
                 * <p>
                 * Objects of the following type(s) are allowed in the list
                 * {@link OneRateMeteringValueType }
                 * 
                 * 
                 */
                public List<OneRateMeteringValueType> getStartValue() {
                    if (startValue == null) {
                        startValue = new ArrayList<OneRateMeteringValueType>();
                    }
                    return this.startValue;
                }

                /**
                 * Gets the value of the endValue property.
                 * 
                 * <p>
                 * This accessor method returns a reference to the live list,
                 * not a snapshot. Therefore any modification you make to the
                 * returned list will be present inside the JAXB object.
                 * This is why there is not a <CODE>set</CODE> method for the endValue property.
                 * 
                 * <p>
                 * For example, to add a new item, do as follows:
                 * <pre>
                 *    getEndValue().add(newItem);
                 * </pre>
                 * 
                 * 
                 * <p>
                 * Objects of the following type(s) are allowed in the list
                 * {@link OneRateMeteringValueType }
                 * 
                 * 
                 */
                public List<OneRateMeteringValueType> getEndValue() {
                    if (endValue == null) {
                        endValue = new ArrayList<OneRateMeteringValueType>();
                    }
                    return this.endValue;
                }

                /**
                 * Gets the value of the plannedVerification property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link Boolean }
                 *     
                 */
                public Boolean isPlannedVerification() {
                    return plannedVerification;
                }

                /**
                 * Sets the value of the plannedVerification property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link Boolean }
                 *     
                 */
                public void setPlannedVerification(Boolean value) {
                    this.plannedVerification = value;
                }

                /**
                 * Gets the value of the verificationReason property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link NsiRef }
                 *     
                 */
                public NsiRef getVerificationReason() {
                    return verificationReason;
                }

                /**
                 * Sets the value of the verificationReason property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link NsiRef }
                 *     
                 */
                public void setVerificationReason(NsiRef value) {
                    this.verificationReason = value;
                }

                /**
                 * Gets the value of the transportGUID property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getTransportGUID() {
                    return transportGUID;
                }

                /**
                 * Sets the value of the transportGUID property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setTransportGUID(String value) {
                    this.transportGUID = value;
                }

            }

        }

    }

}
