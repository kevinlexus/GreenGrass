
package ru.gosuslugi.dom.schema.integration.house_management;

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
 *         &lt;element name="MeteringDevice" maxOccurs="100">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/base/}TransportGUID"/>
 *                   &lt;choice>
 *                     &lt;element name="DeviceDataToCreate" type="{http://dom.gosuslugi.ru/schema/integration/house-management/}MeteringDeviceFullInformationType"/>
 *                     &lt;element name="DeviceDataToUpdate">
 *                       &lt;complexType>
 *                         &lt;complexContent>
 *                           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                             &lt;sequence>
 *                               &lt;element name="MeteringDeviceVersionGUID" type="{http://dom.gosuslugi.ru/schema/integration/metering-device-base/}MeteringDeviceGUIDType"/>
 *                               &lt;choice>
 *                                 &lt;element name="UpdateBeforeDevicesValues" type="{http://dom.gosuslugi.ru/schema/integration/house-management/}MeteringDeviceFullInformationType"/>
 *                                 &lt;element name="UpdateAfterDevicesValues" type="{http://dom.gosuslugi.ru/schema/integration/house-management/}MeteringDeviceToUpdateAfterDevicesValuesType"/>
 *                                 &lt;element name="LinkedWithMetering">
 *                                   &lt;complexType>
 *                                     &lt;complexContent>
 *                                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                         &lt;sequence>
 *                                           &lt;element name="LinkedMeteringDeviceVersionGUID" type="{http://dom.gosuslugi.ru/schema/integration/metering-device-base/}MeteringDeviceGUIDType" maxOccurs="10"/>
 *                                         &lt;/sequence>
 *                                       &lt;/restriction>
 *                                     &lt;/complexContent>
 *                                   &lt;/complexType>
 *                                 &lt;/element>
 *                                 &lt;element name="ArchiveDevice">
 *                                   &lt;complexType>
 *                                     &lt;complexContent>
 *                                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                         &lt;sequence>
 *                                           &lt;element name="ArchivingReason" type="{http://dom.gosuslugi.ru/schema/integration/nsi-base/}nsiRef"/>
 *                                         &lt;/sequence>
 *                                       &lt;/restriction>
 *                                     &lt;/complexContent>
 *                                   &lt;/complexType>
 *                                 &lt;/element>
 *                                 &lt;element name="ReplaceDevice">
 *                                   &lt;complexType>
 *                                     &lt;complexContent>
 *                                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                         &lt;sequence>
 *                                           &lt;element name="VerificationDate" type="{http://www.w3.org/2001/XMLSchema}date"/>
 *                                           &lt;choice>
 *                                             &lt;element name="PlannedVerification" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *                                             &lt;element name="ReasonVerification" type="{http://dom.gosuslugi.ru/schema/integration/nsi-base/}nsiRef"/>
 *                                           &lt;/choice>
 *                                           &lt;choice>
 *                                             &lt;element name="DeviceValueMunicipalResourceNotElectric" type="{http://dom.gosuslugi.ru/schema/integration/metering-device-base/}OneRateMeteringValueType" maxOccurs="3"/>
 *                                             &lt;element name="DeviceValueMunicipalResourceElectric" type="{http://dom.gosuslugi.ru/schema/integration/metering-device-base/}ElectricMeteringValueType"/>
 *                                           &lt;/choice>
 *                                           &lt;element name="ReplacingMeteringDeviceVersionGUID" type="{http://dom.gosuslugi.ru/schema/integration/metering-device-base/}MeteringDeviceGUIDType"/>
 *                                         &lt;/sequence>
 *                                       &lt;/restriction>
 *                                     &lt;/complexContent>
 *                                   &lt;/complexType>
 *                                 &lt;/element>
 *                               &lt;/choice>
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
 *       &lt;attribute ref="{http://dom.gosuslugi.ru/schema/integration/base/}version use="required" fixed="11.0.0.1""/>
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
    "meteringDevice"
})
@XmlRootElement(name = "importMeteringDeviceDataRequest")
public class ImportMeteringDeviceDataRequest
    extends BaseType
{

    @XmlElement(name = "FIASHouseGuid", required = true)
    protected String fiasHouseGuid;
    @XmlElement(name = "MeteringDevice", required = true)
    protected List<ImportMeteringDeviceDataRequest.MeteringDevice> meteringDevice;
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
     * Gets the value of the meteringDevice property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the meteringDevice property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getMeteringDevice().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ImportMeteringDeviceDataRequest.MeteringDevice }
     * 
     * 
     */
    public List<ImportMeteringDeviceDataRequest.MeteringDevice> getMeteringDevice() {
        if (meteringDevice == null) {
            meteringDevice = new ArrayList<ImportMeteringDeviceDataRequest.MeteringDevice>();
        }
        return this.meteringDevice;
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
            return "11.0.0.1";
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
     *         &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/base/}TransportGUID"/>
     *         &lt;choice>
     *           &lt;element name="DeviceDataToCreate" type="{http://dom.gosuslugi.ru/schema/integration/house-management/}MeteringDeviceFullInformationType"/>
     *           &lt;element name="DeviceDataToUpdate">
     *             &lt;complexType>
     *               &lt;complexContent>
     *                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                   &lt;sequence>
     *                     &lt;element name="MeteringDeviceVersionGUID" type="{http://dom.gosuslugi.ru/schema/integration/metering-device-base/}MeteringDeviceGUIDType"/>
     *                     &lt;choice>
     *                       &lt;element name="UpdateBeforeDevicesValues" type="{http://dom.gosuslugi.ru/schema/integration/house-management/}MeteringDeviceFullInformationType"/>
     *                       &lt;element name="UpdateAfterDevicesValues" type="{http://dom.gosuslugi.ru/schema/integration/house-management/}MeteringDeviceToUpdateAfterDevicesValuesType"/>
     *                       &lt;element name="LinkedWithMetering">
     *                         &lt;complexType>
     *                           &lt;complexContent>
     *                             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                               &lt;sequence>
     *                                 &lt;element name="LinkedMeteringDeviceVersionGUID" type="{http://dom.gosuslugi.ru/schema/integration/metering-device-base/}MeteringDeviceGUIDType" maxOccurs="10"/>
     *                               &lt;/sequence>
     *                             &lt;/restriction>
     *                           &lt;/complexContent>
     *                         &lt;/complexType>
     *                       &lt;/element>
     *                       &lt;element name="ArchiveDevice">
     *                         &lt;complexType>
     *                           &lt;complexContent>
     *                             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                               &lt;sequence>
     *                                 &lt;element name="ArchivingReason" type="{http://dom.gosuslugi.ru/schema/integration/nsi-base/}nsiRef"/>
     *                               &lt;/sequence>
     *                             &lt;/restriction>
     *                           &lt;/complexContent>
     *                         &lt;/complexType>
     *                       &lt;/element>
     *                       &lt;element name="ReplaceDevice">
     *                         &lt;complexType>
     *                           &lt;complexContent>
     *                             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                               &lt;sequence>
     *                                 &lt;element name="VerificationDate" type="{http://www.w3.org/2001/XMLSchema}date"/>
     *                                 &lt;choice>
     *                                   &lt;element name="PlannedVerification" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
     *                                   &lt;element name="ReasonVerification" type="{http://dom.gosuslugi.ru/schema/integration/nsi-base/}nsiRef"/>
     *                                 &lt;/choice>
     *                                 &lt;choice>
     *                                   &lt;element name="DeviceValueMunicipalResourceNotElectric" type="{http://dom.gosuslugi.ru/schema/integration/metering-device-base/}OneRateMeteringValueType" maxOccurs="3"/>
     *                                   &lt;element name="DeviceValueMunicipalResourceElectric" type="{http://dom.gosuslugi.ru/schema/integration/metering-device-base/}ElectricMeteringValueType"/>
     *                                 &lt;/choice>
     *                                 &lt;element name="ReplacingMeteringDeviceVersionGUID" type="{http://dom.gosuslugi.ru/schema/integration/metering-device-base/}MeteringDeviceGUIDType"/>
     *                               &lt;/sequence>
     *                             &lt;/restriction>
     *                           &lt;/complexContent>
     *                         &lt;/complexType>
     *                       &lt;/element>
     *                     &lt;/choice>
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
        "transportGUID",
        "deviceDataToCreate",
        "deviceDataToUpdate"
    })
    public static class MeteringDevice {

        @XmlElement(name = "TransportGUID", namespace = "http://dom.gosuslugi.ru/schema/integration/base/", required = true)
        protected String transportGUID;
        @XmlElement(name = "DeviceDataToCreate")
        protected MeteringDeviceFullInformationType deviceDataToCreate;
        @XmlElement(name = "DeviceDataToUpdate")
        protected ImportMeteringDeviceDataRequest.MeteringDevice.DeviceDataToUpdate deviceDataToUpdate;

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

        /**
         * Gets the value of the deviceDataToCreate property.
         * 
         * @return
         *     possible object is
         *     {@link MeteringDeviceFullInformationType }
         *     
         */
        public MeteringDeviceFullInformationType getDeviceDataToCreate() {
            return deviceDataToCreate;
        }

        /**
         * Sets the value of the deviceDataToCreate property.
         * 
         * @param value
         *     allowed object is
         *     {@link MeteringDeviceFullInformationType }
         *     
         */
        public void setDeviceDataToCreate(MeteringDeviceFullInformationType value) {
            this.deviceDataToCreate = value;
        }

        /**
         * Gets the value of the deviceDataToUpdate property.
         * 
         * @return
         *     possible object is
         *     {@link ImportMeteringDeviceDataRequest.MeteringDevice.DeviceDataToUpdate }
         *     
         */
        public ImportMeteringDeviceDataRequest.MeteringDevice.DeviceDataToUpdate getDeviceDataToUpdate() {
            return deviceDataToUpdate;
        }

        /**
         * Sets the value of the deviceDataToUpdate property.
         * 
         * @param value
         *     allowed object is
         *     {@link ImportMeteringDeviceDataRequest.MeteringDevice.DeviceDataToUpdate }
         *     
         */
        public void setDeviceDataToUpdate(ImportMeteringDeviceDataRequest.MeteringDevice.DeviceDataToUpdate value) {
            this.deviceDataToUpdate = value;
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
         *         &lt;element name="MeteringDeviceVersionGUID" type="{http://dom.gosuslugi.ru/schema/integration/metering-device-base/}MeteringDeviceGUIDType"/>
         *         &lt;choice>
         *           &lt;element name="UpdateBeforeDevicesValues" type="{http://dom.gosuslugi.ru/schema/integration/house-management/}MeteringDeviceFullInformationType"/>
         *           &lt;element name="UpdateAfterDevicesValues" type="{http://dom.gosuslugi.ru/schema/integration/house-management/}MeteringDeviceToUpdateAfterDevicesValuesType"/>
         *           &lt;element name="LinkedWithMetering">
         *             &lt;complexType>
         *               &lt;complexContent>
         *                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *                   &lt;sequence>
         *                     &lt;element name="LinkedMeteringDeviceVersionGUID" type="{http://dom.gosuslugi.ru/schema/integration/metering-device-base/}MeteringDeviceGUIDType" maxOccurs="10"/>
         *                   &lt;/sequence>
         *                 &lt;/restriction>
         *               &lt;/complexContent>
         *             &lt;/complexType>
         *           &lt;/element>
         *           &lt;element name="ArchiveDevice">
         *             &lt;complexType>
         *               &lt;complexContent>
         *                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *                   &lt;sequence>
         *                     &lt;element name="ArchivingReason" type="{http://dom.gosuslugi.ru/schema/integration/nsi-base/}nsiRef"/>
         *                   &lt;/sequence>
         *                 &lt;/restriction>
         *               &lt;/complexContent>
         *             &lt;/complexType>
         *           &lt;/element>
         *           &lt;element name="ReplaceDevice">
         *             &lt;complexType>
         *               &lt;complexContent>
         *                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *                   &lt;sequence>
         *                     &lt;element name="VerificationDate" type="{http://www.w3.org/2001/XMLSchema}date"/>
         *                     &lt;choice>
         *                       &lt;element name="PlannedVerification" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
         *                       &lt;element name="ReasonVerification" type="{http://dom.gosuslugi.ru/schema/integration/nsi-base/}nsiRef"/>
         *                     &lt;/choice>
         *                     &lt;choice>
         *                       &lt;element name="DeviceValueMunicipalResourceNotElectric" type="{http://dom.gosuslugi.ru/schema/integration/metering-device-base/}OneRateMeteringValueType" maxOccurs="3"/>
         *                       &lt;element name="DeviceValueMunicipalResourceElectric" type="{http://dom.gosuslugi.ru/schema/integration/metering-device-base/}ElectricMeteringValueType"/>
         *                     &lt;/choice>
         *                     &lt;element name="ReplacingMeteringDeviceVersionGUID" type="{http://dom.gosuslugi.ru/schema/integration/metering-device-base/}MeteringDeviceGUIDType"/>
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
            "meteringDeviceVersionGUID",
            "updateBeforeDevicesValues",
            "updateAfterDevicesValues",
            "linkedWithMetering",
            "archiveDevice",
            "replaceDevice"
        })
        public static class DeviceDataToUpdate {

            @XmlElement(name = "MeteringDeviceVersionGUID", required = true)
            protected String meteringDeviceVersionGUID;
            @XmlElement(name = "UpdateBeforeDevicesValues")
            protected MeteringDeviceFullInformationType updateBeforeDevicesValues;
            @XmlElement(name = "UpdateAfterDevicesValues")
            protected MeteringDeviceToUpdateAfterDevicesValuesType updateAfterDevicesValues;
            @XmlElement(name = "LinkedWithMetering")
            protected ImportMeteringDeviceDataRequest.MeteringDevice.DeviceDataToUpdate.LinkedWithMetering linkedWithMetering;
            @XmlElement(name = "ArchiveDevice")
            protected ImportMeteringDeviceDataRequest.MeteringDevice.DeviceDataToUpdate.ArchiveDevice archiveDevice;
            @XmlElement(name = "ReplaceDevice")
            protected ImportMeteringDeviceDataRequest.MeteringDevice.DeviceDataToUpdate.ReplaceDevice replaceDevice;

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
             * Gets the value of the updateBeforeDevicesValues property.
             * 
             * @return
             *     possible object is
             *     {@link MeteringDeviceFullInformationType }
             *     
             */
            public MeteringDeviceFullInformationType getUpdateBeforeDevicesValues() {
                return updateBeforeDevicesValues;
            }

            /**
             * Sets the value of the updateBeforeDevicesValues property.
             * 
             * @param value
             *     allowed object is
             *     {@link MeteringDeviceFullInformationType }
             *     
             */
            public void setUpdateBeforeDevicesValues(MeteringDeviceFullInformationType value) {
                this.updateBeforeDevicesValues = value;
            }

            /**
             * Gets the value of the updateAfterDevicesValues property.
             * 
             * @return
             *     possible object is
             *     {@link MeteringDeviceToUpdateAfterDevicesValuesType }
             *     
             */
            public MeteringDeviceToUpdateAfterDevicesValuesType getUpdateAfterDevicesValues() {
                return updateAfterDevicesValues;
            }

            /**
             * Sets the value of the updateAfterDevicesValues property.
             * 
             * @param value
             *     allowed object is
             *     {@link MeteringDeviceToUpdateAfterDevicesValuesType }
             *     
             */
            public void setUpdateAfterDevicesValues(MeteringDeviceToUpdateAfterDevicesValuesType value) {
                this.updateAfterDevicesValues = value;
            }

            /**
             * Gets the value of the linkedWithMetering property.
             * 
             * @return
             *     possible object is
             *     {@link ImportMeteringDeviceDataRequest.MeteringDevice.DeviceDataToUpdate.LinkedWithMetering }
             *     
             */
            public ImportMeteringDeviceDataRequest.MeteringDevice.DeviceDataToUpdate.LinkedWithMetering getLinkedWithMetering() {
                return linkedWithMetering;
            }

            /**
             * Sets the value of the linkedWithMetering property.
             * 
             * @param value
             *     allowed object is
             *     {@link ImportMeteringDeviceDataRequest.MeteringDevice.DeviceDataToUpdate.LinkedWithMetering }
             *     
             */
            public void setLinkedWithMetering(ImportMeteringDeviceDataRequest.MeteringDevice.DeviceDataToUpdate.LinkedWithMetering value) {
                this.linkedWithMetering = value;
            }

            /**
             * Gets the value of the archiveDevice property.
             * 
             * @return
             *     possible object is
             *     {@link ImportMeteringDeviceDataRequest.MeteringDevice.DeviceDataToUpdate.ArchiveDevice }
             *     
             */
            public ImportMeteringDeviceDataRequest.MeteringDevice.DeviceDataToUpdate.ArchiveDevice getArchiveDevice() {
                return archiveDevice;
            }

            /**
             * Sets the value of the archiveDevice property.
             * 
             * @param value
             *     allowed object is
             *     {@link ImportMeteringDeviceDataRequest.MeteringDevice.DeviceDataToUpdate.ArchiveDevice }
             *     
             */
            public void setArchiveDevice(ImportMeteringDeviceDataRequest.MeteringDevice.DeviceDataToUpdate.ArchiveDevice value) {
                this.archiveDevice = value;
            }

            /**
             * Gets the value of the replaceDevice property.
             * 
             * @return
             *     possible object is
             *     {@link ImportMeteringDeviceDataRequest.MeteringDevice.DeviceDataToUpdate.ReplaceDevice }
             *     
             */
            public ImportMeteringDeviceDataRequest.MeteringDevice.DeviceDataToUpdate.ReplaceDevice getReplaceDevice() {
                return replaceDevice;
            }

            /**
             * Sets the value of the replaceDevice property.
             * 
             * @param value
             *     allowed object is
             *     {@link ImportMeteringDeviceDataRequest.MeteringDevice.DeviceDataToUpdate.ReplaceDevice }
             *     
             */
            public void setReplaceDevice(ImportMeteringDeviceDataRequest.MeteringDevice.DeviceDataToUpdate.ReplaceDevice value) {
                this.replaceDevice = value;
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
             *         &lt;element name="ArchivingReason" type="{http://dom.gosuslugi.ru/schema/integration/nsi-base/}nsiRef"/>
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
                "archivingReason"
            })
            public static class ArchiveDevice {

                @XmlElement(name = "ArchivingReason", required = true)
                protected NsiRef archivingReason;

                /**
                 * Gets the value of the archivingReason property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link NsiRef }
                 *     
                 */
                public NsiRef getArchivingReason() {
                    return archivingReason;
                }

                /**
                 * Sets the value of the archivingReason property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link NsiRef }
                 *     
                 */
                public void setArchivingReason(NsiRef value) {
                    this.archivingReason = value;
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
             *         &lt;element name="LinkedMeteringDeviceVersionGUID" type="{http://dom.gosuslugi.ru/schema/integration/metering-device-base/}MeteringDeviceGUIDType" maxOccurs="10"/>
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
                "linkedMeteringDeviceVersionGUID"
            })
            public static class LinkedWithMetering {

                @XmlElement(name = "LinkedMeteringDeviceVersionGUID", required = true)
                protected List<String> linkedMeteringDeviceVersionGUID;

                /**
                 * Gets the value of the linkedMeteringDeviceVersionGUID property.
                 * 
                 * <p>
                 * This accessor method returns a reference to the live list,
                 * not a snapshot. Therefore any modification you make to the
                 * returned list will be present inside the JAXB object.
                 * This is why there is not a <CODE>set</CODE> method for the linkedMeteringDeviceVersionGUID property.
                 * 
                 * <p>
                 * For example, to add a new item, do as follows:
                 * <pre>
                 *    getLinkedMeteringDeviceVersionGUID().add(newItem);
                 * </pre>
                 * 
                 * 
                 * <p>
                 * Objects of the following type(s) are allowed in the list
                 * {@link String }
                 * 
                 * 
                 */
                public List<String> getLinkedMeteringDeviceVersionGUID() {
                    if (linkedMeteringDeviceVersionGUID == null) {
                        linkedMeteringDeviceVersionGUID = new ArrayList<String>();
                    }
                    return this.linkedMeteringDeviceVersionGUID;
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
             *         &lt;element name="VerificationDate" type="{http://www.w3.org/2001/XMLSchema}date"/>
             *         &lt;choice>
             *           &lt;element name="PlannedVerification" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
             *           &lt;element name="ReasonVerification" type="{http://dom.gosuslugi.ru/schema/integration/nsi-base/}nsiRef"/>
             *         &lt;/choice>
             *         &lt;choice>
             *           &lt;element name="DeviceValueMunicipalResourceNotElectric" type="{http://dom.gosuslugi.ru/schema/integration/metering-device-base/}OneRateMeteringValueType" maxOccurs="3"/>
             *           &lt;element name="DeviceValueMunicipalResourceElectric" type="{http://dom.gosuslugi.ru/schema/integration/metering-device-base/}ElectricMeteringValueType"/>
             *         &lt;/choice>
             *         &lt;element name="ReplacingMeteringDeviceVersionGUID" type="{http://dom.gosuslugi.ru/schema/integration/metering-device-base/}MeteringDeviceGUIDType"/>
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
                "verificationDate",
                "plannedVerification",
                "reasonVerification",
                "deviceValueMunicipalResourceNotElectric",
                "deviceValueMunicipalResourceElectric",
                "replacingMeteringDeviceVersionGUID"
            })
            public static class ReplaceDevice {

                @XmlElement(name = "VerificationDate", required = true)
                @XmlSchemaType(name = "date")
                protected XMLGregorianCalendar verificationDate;
                @XmlElement(name = "PlannedVerification")
                protected Boolean plannedVerification;
                @XmlElement(name = "ReasonVerification")
                protected NsiRef reasonVerification;
                @XmlElement(name = "DeviceValueMunicipalResourceNotElectric")
                protected List<OneRateMeteringValueType> deviceValueMunicipalResourceNotElectric;
                @XmlElement(name = "DeviceValueMunicipalResourceElectric")
                protected ElectricMeteringValueType deviceValueMunicipalResourceElectric;
                @XmlElement(name = "ReplacingMeteringDeviceVersionGUID", required = true)
                protected String replacingMeteringDeviceVersionGUID;

                /**
                 * Gets the value of the verificationDate property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link XMLGregorianCalendar }
                 *     
                 */
                public XMLGregorianCalendar getVerificationDate() {
                    return verificationDate;
                }

                /**
                 * Sets the value of the verificationDate property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link XMLGregorianCalendar }
                 *     
                 */
                public void setVerificationDate(XMLGregorianCalendar value) {
                    this.verificationDate = value;
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
                 * Gets the value of the reasonVerification property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link NsiRef }
                 *     
                 */
                public NsiRef getReasonVerification() {
                    return reasonVerification;
                }

                /**
                 * Sets the value of the reasonVerification property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link NsiRef }
                 *     
                 */
                public void setReasonVerification(NsiRef value) {
                    this.reasonVerification = value;
                }

                /**
                 * Gets the value of the deviceValueMunicipalResourceNotElectric property.
                 * 
                 * <p>
                 * This accessor method returns a reference to the live list,
                 * not a snapshot. Therefore any modification you make to the
                 * returned list will be present inside the JAXB object.
                 * This is why there is not a <CODE>set</CODE> method for the deviceValueMunicipalResourceNotElectric property.
                 * 
                 * <p>
                 * For example, to add a new item, do as follows:
                 * <pre>
                 *    getDeviceValueMunicipalResourceNotElectric().add(newItem);
                 * </pre>
                 * 
                 * 
                 * <p>
                 * Objects of the following type(s) are allowed in the list
                 * {@link OneRateMeteringValueType }
                 * 
                 * 
                 */
                public List<OneRateMeteringValueType> getDeviceValueMunicipalResourceNotElectric() {
                    if (deviceValueMunicipalResourceNotElectric == null) {
                        deviceValueMunicipalResourceNotElectric = new ArrayList<OneRateMeteringValueType>();
                    }
                    return this.deviceValueMunicipalResourceNotElectric;
                }

                /**
                 * Gets the value of the deviceValueMunicipalResourceElectric property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link ElectricMeteringValueType }
                 *     
                 */
                public ElectricMeteringValueType getDeviceValueMunicipalResourceElectric() {
                    return deviceValueMunicipalResourceElectric;
                }

                /**
                 * Sets the value of the deviceValueMunicipalResourceElectric property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link ElectricMeteringValueType }
                 *     
                 */
                public void setDeviceValueMunicipalResourceElectric(ElectricMeteringValueType value) {
                    this.deviceValueMunicipalResourceElectric = value;
                }

                /**
                 * Gets the value of the replacingMeteringDeviceVersionGUID property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getReplacingMeteringDeviceVersionGUID() {
                    return replacingMeteringDeviceVersionGUID;
                }

                /**
                 * Sets the value of the replacingMeteringDeviceVersionGUID property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setReplacingMeteringDeviceVersionGUID(String value) {
                    this.replacingMeteringDeviceVersionGUID = value;
                }

            }

        }

    }

}
