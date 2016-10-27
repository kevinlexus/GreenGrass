
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
 *         &lt;sequence>
 *           &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/base/}TransportGUID"/>
 *         &lt;/sequence>
 *         &lt;choice>
 *           &lt;element name="PlacingCharter">
 *             &lt;complexType>
 *               &lt;complexContent>
 *                 &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/house-management/}CharterType">
 *                   &lt;sequence>
 *                     &lt;element name="ContractObject" maxOccurs="unbounded">
 *                       &lt;complexType>
 *                         &lt;complexContent>
 *                           &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/house-management/}ManageObjectType">
 *                             &lt;sequence>
 *                               &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/base/}TransportGUID"/>
 *                               &lt;element name="BaseMService" type="{http://dom.gosuslugi.ru/schema/integration/house-management/}BaseServiceCharterType"/>
 *                               &lt;element name="HouseService" maxOccurs="unbounded" minOccurs="0">
 *                                 &lt;complexType>
 *                                   &lt;complexContent>
 *                                     &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/house-management/}ContractServiceType">
 *                                       &lt;sequence>
 *                                         &lt;element name="BaseServiceCharter" type="{http://dom.gosuslugi.ru/schema/integration/house-management/}BaseServiceCharterType"/>
 *                                       &lt;/sequence>
 *                                     &lt;/extension>
 *                                   &lt;/complexContent>
 *                                 &lt;/complexType>
 *                               &lt;/element>
 *                               &lt;element name="AddService" maxOccurs="unbounded" minOccurs="0">
 *                                 &lt;complexType>
 *                                   &lt;complexContent>
 *                                     &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/house-management/}ContractServiceType">
 *                                       &lt;sequence>
 *                                         &lt;element name="BaseServiceCharter" type="{http://dom.gosuslugi.ru/schema/integration/house-management/}BaseServiceCharterType"/>
 *                                       &lt;/sequence>
 *                                     &lt;/extension>
 *                                   &lt;/complexContent>
 *                                 &lt;/complexType>
 *                               &lt;/element>
 *                               &lt;element name="IsManagedByContract" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *                             &lt;/sequence>
 *                           &lt;/extension>
 *                         &lt;/complexContent>
 *                       &lt;/complexType>
 *                     &lt;/element>
 *                   &lt;/sequence>
 *                 &lt;/extension>
 *               &lt;/complexContent>
 *             &lt;/complexType>
 *           &lt;/element>
 *           &lt;element name="EditCharter">
 *             &lt;complexType>
 *               &lt;complexContent>
 *                 &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/house-management/}CharterType">
 *                   &lt;sequence>
 *                     &lt;element name="ContractObject" maxOccurs="unbounded" minOccurs="0">
 *                       &lt;complexType>
 *                         &lt;complexContent>
 *                           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                             &lt;sequence>
 *                               &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/base/}TransportGUID"/>
 *                               &lt;choice>
 *                                 &lt;element name="Add">
 *                                   &lt;complexType>
 *                                     &lt;complexContent>
 *                                       &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/house-management/}ManageObjectType">
 *                                         &lt;sequence>
 *                                           &lt;element name="BaseMService" type="{http://dom.gosuslugi.ru/schema/integration/house-management/}BaseServiceCharterType"/>
 *                                           &lt;element name="HouseService" maxOccurs="unbounded" minOccurs="0">
 *                                             &lt;complexType>
 *                                               &lt;complexContent>
 *                                                 &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/house-management/}ContractServiceType">
 *                                                   &lt;sequence>
 *                                                     &lt;element name="BaseServiceCharter" type="{http://dom.gosuslugi.ru/schema/integration/house-management/}BaseServiceCharterType"/>
 *                                                   &lt;/sequence>
 *                                                 &lt;/extension>
 *                                               &lt;/complexContent>
 *                                             &lt;/complexType>
 *                                           &lt;/element>
 *                                           &lt;element name="AddService" maxOccurs="unbounded" minOccurs="0">
 *                                             &lt;complexType>
 *                                               &lt;complexContent>
 *                                                 &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/house-management/}ContractServiceType">
 *                                                   &lt;sequence>
 *                                                     &lt;element name="BaseServiceCharter" type="{http://dom.gosuslugi.ru/schema/integration/house-management/}BaseServiceCharterType"/>
 *                                                   &lt;/sequence>
 *                                                 &lt;/extension>
 *                                               &lt;/complexContent>
 *                                             &lt;/complexType>
 *                                           &lt;/element>
 *                                         &lt;/sequence>
 *                                       &lt;/extension>
 *                                     &lt;/complexContent>
 *                                   &lt;/complexType>
 *                                 &lt;/element>
 *                                 &lt;element name="Edit">
 *                                   &lt;complexType>
 *                                     &lt;complexContent>
 *                                       &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/house-management/}ManageObjectType">
 *                                         &lt;sequence>
 *                                           &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/house-management/}ContractObjectVersionGUID"/>
 *                                           &lt;element name="BaseMService" type="{http://dom.gosuslugi.ru/schema/integration/house-management/}BaseServiceCharterType" minOccurs="0"/>
 *                                           &lt;element name="HouseService" maxOccurs="unbounded" minOccurs="0">
 *                                             &lt;complexType>
 *                                               &lt;complexContent>
 *                                                 &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/house-management/}ContractServiceType">
 *                                                   &lt;sequence>
 *                                                     &lt;element name="BaseServiceCharter" type="{http://dom.gosuslugi.ru/schema/integration/house-management/}BaseServiceCharterType"/>
 *                                                   &lt;/sequence>
 *                                                 &lt;/extension>
 *                                               &lt;/complexContent>
 *                                             &lt;/complexType>
 *                                           &lt;/element>
 *                                           &lt;element name="AddService" maxOccurs="unbounded" minOccurs="0">
 *                                             &lt;complexType>
 *                                               &lt;complexContent>
 *                                                 &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/house-management/}ContractServiceType">
 *                                                   &lt;sequence>
 *                                                     &lt;element name="BaseServiceCharter" type="{http://dom.gosuslugi.ru/schema/integration/house-management/}BaseServiceCharterType"/>
 *                                                   &lt;/sequence>
 *                                                 &lt;/extension>
 *                                               &lt;/complexContent>
 *                                             &lt;/complexType>
 *                                           &lt;/element>
 *                                         &lt;/sequence>
 *                                       &lt;/extension>
 *                                     &lt;/complexContent>
 *                                   &lt;/complexType>
 *                                 &lt;/element>
 *                                 &lt;element name="Exclusion">
 *                                   &lt;complexType>
 *                                     &lt;complexContent>
 *                                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                         &lt;sequence>
 *                                           &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/house-management/}ContractObjectVersionGUID"/>
 *                                           &lt;element name="BaseExclusion" type="{http://dom.gosuslugi.ru/schema/integration/house-management/}BaseServiceCharterType"/>
 *                                           &lt;element name="DateExclusion" type="{http://www.w3.org/2001/XMLSchema}date"/>
 *                                         &lt;/sequence>
 *                                       &lt;/restriction>
 *                                     &lt;/complexContent>
 *                                   &lt;/complexType>
 *                                 &lt;/element>
 *                                 &lt;element name="Annulment">
 *                                   &lt;complexType>
 *                                     &lt;complexContent>
 *                                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                         &lt;sequence>
 *                                           &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/house-management/}ContractObjectVersionGUID"/>
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
 *                     &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/house-management/}CharterVersionGUID"/>
 *                   &lt;/sequence>
 *                 &lt;/extension>
 *               &lt;/complexContent>
 *             &lt;/complexType>
 *           &lt;/element>
 *           &lt;element name="RollOverCharter">
 *             &lt;complexType>
 *               &lt;complexContent>
 *                 &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/house-management/}RollOverType">
 *                   &lt;sequence>
 *                     &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/house-management/}CharterVersionGUID"/>
 *                   &lt;/sequence>
 *                 &lt;/extension>
 *               &lt;/complexContent>
 *             &lt;/complexType>
 *           &lt;/element>
 *           &lt;element name="TerminateCharter">
 *             &lt;complexType>
 *               &lt;complexContent>
 *                 &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/house-management/}TerminateType">
 *                   &lt;sequence>
 *                     &lt;element name="Reason">
 *                       &lt;simpleType>
 *                         &lt;restriction base="{http://dom.gosuslugi.ru/schema/integration/base/}LongTextType">
 *                           &lt;maxLength value="255"/>
 *                         &lt;/restriction>
 *                       &lt;/simpleType>
 *                     &lt;/element>
 *                     &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/house-management/}CharterVersionGUID"/>
 *                   &lt;/sequence>
 *                 &lt;/extension>
 *               &lt;/complexContent>
 *             &lt;/complexType>
 *           &lt;/element>
 *           &lt;element name="AnnulmentCharter">
 *             &lt;complexType>
 *               &lt;complexContent>
 *                 &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/house-management/}AnnulmentType">
 *                   &lt;sequence>
 *                     &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/house-management/}CharterVersionGUID"/>
 *                   &lt;/sequence>
 *                 &lt;/extension>
 *               &lt;/complexContent>
 *             &lt;/complexType>
 *           &lt;/element>
 *           &lt;element name="PlaceCharterPaymentsInfo">
 *             &lt;complexType>
 *               &lt;complexContent>
 *                 &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/house-management/}CharterPaymentsInfoType">
 *                   &lt;sequence>
 *                     &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/house-management/}CharterVersionGUID"/>
 *                   &lt;/sequence>
 *                 &lt;/extension>
 *               &lt;/complexContent>
 *             &lt;/complexType>
 *           &lt;/element>
 *           &lt;element name="AnnulmentCharterPaymentsInfo">
 *             &lt;complexType>
 *               &lt;complexContent>
 *                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                   &lt;sequence>
 *                     &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/house-management/}CharterPaymentsInfoVersionGUID"/>
 *                   &lt;/sequence>
 *                 &lt;/restriction>
 *               &lt;/complexContent>
 *             &lt;/complexType>
 *           &lt;/element>
 *         &lt;/choice>
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
    "transportGUID",
    "placingCharter",
    "editCharter",
    "rollOverCharter",
    "terminateCharter",
    "annulmentCharter",
    "placeCharterPaymentsInfo",
    "annulmentCharterPaymentsInfo"
})
@XmlRootElement(name = "importCharterRequest")
public class ImportCharterRequest
    extends BaseType
{

    @XmlElement(name = "TransportGUID", namespace = "http://dom.gosuslugi.ru/schema/integration/base/", required = true)
    protected String transportGUID;
    @XmlElement(name = "PlacingCharter")
    protected ImportCharterRequest.PlacingCharter placingCharter;
    @XmlElement(name = "EditCharter")
    protected ImportCharterRequest.EditCharter editCharter;
    @XmlElement(name = "RollOverCharter")
    protected ImportCharterRequest.RollOverCharter rollOverCharter;
    @XmlElement(name = "TerminateCharter")
    protected ImportCharterRequest.TerminateCharter terminateCharter;
    @XmlElement(name = "AnnulmentCharter")
    protected ImportCharterRequest.AnnulmentCharter annulmentCharter;
    @XmlElement(name = "PlaceCharterPaymentsInfo")
    protected ImportCharterRequest.PlaceCharterPaymentsInfo placeCharterPaymentsInfo;
    @XmlElement(name = "AnnulmentCharterPaymentsInfo")
    protected ImportCharterRequest.AnnulmentCharterPaymentsInfo annulmentCharterPaymentsInfo;
    @XmlAttribute(name = "version", namespace = "http://dom.gosuslugi.ru/schema/integration/base/", required = true)
    protected String version;

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
     * Gets the value of the placingCharter property.
     * 
     * @return
     *     possible object is
     *     {@link ImportCharterRequest.PlacingCharter }
     *     
     */
    public ImportCharterRequest.PlacingCharter getPlacingCharter() {
        return placingCharter;
    }

    /**
     * Sets the value of the placingCharter property.
     * 
     * @param value
     *     allowed object is
     *     {@link ImportCharterRequest.PlacingCharter }
     *     
     */
    public void setPlacingCharter(ImportCharterRequest.PlacingCharter value) {
        this.placingCharter = value;
    }

    /**
     * Gets the value of the editCharter property.
     * 
     * @return
     *     possible object is
     *     {@link ImportCharterRequest.EditCharter }
     *     
     */
    public ImportCharterRequest.EditCharter getEditCharter() {
        return editCharter;
    }

    /**
     * Sets the value of the editCharter property.
     * 
     * @param value
     *     allowed object is
     *     {@link ImportCharterRequest.EditCharter }
     *     
     */
    public void setEditCharter(ImportCharterRequest.EditCharter value) {
        this.editCharter = value;
    }

    /**
     * Gets the value of the rollOverCharter property.
     * 
     * @return
     *     possible object is
     *     {@link ImportCharterRequest.RollOverCharter }
     *     
     */
    public ImportCharterRequest.RollOverCharter getRollOverCharter() {
        return rollOverCharter;
    }

    /**
     * Sets the value of the rollOverCharter property.
     * 
     * @param value
     *     allowed object is
     *     {@link ImportCharterRequest.RollOverCharter }
     *     
     */
    public void setRollOverCharter(ImportCharterRequest.RollOverCharter value) {
        this.rollOverCharter = value;
    }

    /**
     * Gets the value of the terminateCharter property.
     * 
     * @return
     *     possible object is
     *     {@link ImportCharterRequest.TerminateCharter }
     *     
     */
    public ImportCharterRequest.TerminateCharter getTerminateCharter() {
        return terminateCharter;
    }

    /**
     * Sets the value of the terminateCharter property.
     * 
     * @param value
     *     allowed object is
     *     {@link ImportCharterRequest.TerminateCharter }
     *     
     */
    public void setTerminateCharter(ImportCharterRequest.TerminateCharter value) {
        this.terminateCharter = value;
    }

    /**
     * Gets the value of the annulmentCharter property.
     * 
     * @return
     *     possible object is
     *     {@link ImportCharterRequest.AnnulmentCharter }
     *     
     */
    public ImportCharterRequest.AnnulmentCharter getAnnulmentCharter() {
        return annulmentCharter;
    }

    /**
     * Sets the value of the annulmentCharter property.
     * 
     * @param value
     *     allowed object is
     *     {@link ImportCharterRequest.AnnulmentCharter }
     *     
     */
    public void setAnnulmentCharter(ImportCharterRequest.AnnulmentCharter value) {
        this.annulmentCharter = value;
    }

    /**
     * Gets the value of the placeCharterPaymentsInfo property.
     * 
     * @return
     *     possible object is
     *     {@link ImportCharterRequest.PlaceCharterPaymentsInfo }
     *     
     */
    public ImportCharterRequest.PlaceCharterPaymentsInfo getPlaceCharterPaymentsInfo() {
        return placeCharterPaymentsInfo;
    }

    /**
     * Sets the value of the placeCharterPaymentsInfo property.
     * 
     * @param value
     *     allowed object is
     *     {@link ImportCharterRequest.PlaceCharterPaymentsInfo }
     *     
     */
    public void setPlaceCharterPaymentsInfo(ImportCharterRequest.PlaceCharterPaymentsInfo value) {
        this.placeCharterPaymentsInfo = value;
    }

    /**
     * Gets the value of the annulmentCharterPaymentsInfo property.
     * 
     * @return
     *     possible object is
     *     {@link ImportCharterRequest.AnnulmentCharterPaymentsInfo }
     *     
     */
    public ImportCharterRequest.AnnulmentCharterPaymentsInfo getAnnulmentCharterPaymentsInfo() {
        return annulmentCharterPaymentsInfo;
    }

    /**
     * Sets the value of the annulmentCharterPaymentsInfo property.
     * 
     * @param value
     *     allowed object is
     *     {@link ImportCharterRequest.AnnulmentCharterPaymentsInfo }
     *     
     */
    public void setAnnulmentCharterPaymentsInfo(ImportCharterRequest.AnnulmentCharterPaymentsInfo value) {
        this.annulmentCharterPaymentsInfo = value;
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
     *     &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/house-management/}AnnulmentType">
     *       &lt;sequence>
     *         &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/house-management/}CharterVersionGUID"/>
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
        "charterVersionGUID"
    })
    public static class AnnulmentCharter
        extends AnnulmentType
    {

        @XmlElement(name = "CharterVersionGUID", required = true)
        protected String charterVersionGUID;

        /**
         * Gets the value of the charterVersionGUID property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getCharterVersionGUID() {
            return charterVersionGUID;
        }

        /**
         * Sets the value of the charterVersionGUID property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setCharterVersionGUID(String value) {
            this.charterVersionGUID = value;
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
     *         &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/house-management/}CharterPaymentsInfoVersionGUID"/>
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
        "charterPaymentsInfoVersionGUID"
    })
    public static class AnnulmentCharterPaymentsInfo {

        @XmlElement(name = "CharterPaymentsInfoVersionGUID", required = true)
        protected String charterPaymentsInfoVersionGUID;

        /**
         * Gets the value of the charterPaymentsInfoVersionGUID property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getCharterPaymentsInfoVersionGUID() {
            return charterPaymentsInfoVersionGUID;
        }

        /**
         * Sets the value of the charterPaymentsInfoVersionGUID property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setCharterPaymentsInfoVersionGUID(String value) {
            this.charterPaymentsInfoVersionGUID = value;
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
     *     &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/house-management/}CharterType">
     *       &lt;sequence>
     *         &lt;element name="ContractObject" maxOccurs="unbounded" minOccurs="0">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/base/}TransportGUID"/>
     *                   &lt;choice>
     *                     &lt;element name="Add">
     *                       &lt;complexType>
     *                         &lt;complexContent>
     *                           &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/house-management/}ManageObjectType">
     *                             &lt;sequence>
     *                               &lt;element name="BaseMService" type="{http://dom.gosuslugi.ru/schema/integration/house-management/}BaseServiceCharterType"/>
     *                               &lt;element name="HouseService" maxOccurs="unbounded" minOccurs="0">
     *                                 &lt;complexType>
     *                                   &lt;complexContent>
     *                                     &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/house-management/}ContractServiceType">
     *                                       &lt;sequence>
     *                                         &lt;element name="BaseServiceCharter" type="{http://dom.gosuslugi.ru/schema/integration/house-management/}BaseServiceCharterType"/>
     *                                       &lt;/sequence>
     *                                     &lt;/extension>
     *                                   &lt;/complexContent>
     *                                 &lt;/complexType>
     *                               &lt;/element>
     *                               &lt;element name="AddService" maxOccurs="unbounded" minOccurs="0">
     *                                 &lt;complexType>
     *                                   &lt;complexContent>
     *                                     &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/house-management/}ContractServiceType">
     *                                       &lt;sequence>
     *                                         &lt;element name="BaseServiceCharter" type="{http://dom.gosuslugi.ru/schema/integration/house-management/}BaseServiceCharterType"/>
     *                                       &lt;/sequence>
     *                                     &lt;/extension>
     *                                   &lt;/complexContent>
     *                                 &lt;/complexType>
     *                               &lt;/element>
     *                             &lt;/sequence>
     *                           &lt;/extension>
     *                         &lt;/complexContent>
     *                       &lt;/complexType>
     *                     &lt;/element>
     *                     &lt;element name="Edit">
     *                       &lt;complexType>
     *                         &lt;complexContent>
     *                           &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/house-management/}ManageObjectType">
     *                             &lt;sequence>
     *                               &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/house-management/}ContractObjectVersionGUID"/>
     *                               &lt;element name="BaseMService" type="{http://dom.gosuslugi.ru/schema/integration/house-management/}BaseServiceCharterType" minOccurs="0"/>
     *                               &lt;element name="HouseService" maxOccurs="unbounded" minOccurs="0">
     *                                 &lt;complexType>
     *                                   &lt;complexContent>
     *                                     &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/house-management/}ContractServiceType">
     *                                       &lt;sequence>
     *                                         &lt;element name="BaseServiceCharter" type="{http://dom.gosuslugi.ru/schema/integration/house-management/}BaseServiceCharterType"/>
     *                                       &lt;/sequence>
     *                                     &lt;/extension>
     *                                   &lt;/complexContent>
     *                                 &lt;/complexType>
     *                               &lt;/element>
     *                               &lt;element name="AddService" maxOccurs="unbounded" minOccurs="0">
     *                                 &lt;complexType>
     *                                   &lt;complexContent>
     *                                     &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/house-management/}ContractServiceType">
     *                                       &lt;sequence>
     *                                         &lt;element name="BaseServiceCharter" type="{http://dom.gosuslugi.ru/schema/integration/house-management/}BaseServiceCharterType"/>
     *                                       &lt;/sequence>
     *                                     &lt;/extension>
     *                                   &lt;/complexContent>
     *                                 &lt;/complexType>
     *                               &lt;/element>
     *                             &lt;/sequence>
     *                           &lt;/extension>
     *                         &lt;/complexContent>
     *                       &lt;/complexType>
     *                     &lt;/element>
     *                     &lt;element name="Exclusion">
     *                       &lt;complexType>
     *                         &lt;complexContent>
     *                           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                             &lt;sequence>
     *                               &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/house-management/}ContractObjectVersionGUID"/>
     *                               &lt;element name="BaseExclusion" type="{http://dom.gosuslugi.ru/schema/integration/house-management/}BaseServiceCharterType"/>
     *                               &lt;element name="DateExclusion" type="{http://www.w3.org/2001/XMLSchema}date"/>
     *                             &lt;/sequence>
     *                           &lt;/restriction>
     *                         &lt;/complexContent>
     *                       &lt;/complexType>
     *                     &lt;/element>
     *                     &lt;element name="Annulment">
     *                       &lt;complexType>
     *                         &lt;complexContent>
     *                           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                             &lt;sequence>
     *                               &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/house-management/}ContractObjectVersionGUID"/>
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
     *         &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/house-management/}CharterVersionGUID"/>
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
        "contractObject",
        "charterVersionGUID"
    })
    public static class EditCharter
        extends CharterType
    {

        @XmlElement(name = "ContractObject")
        protected List<ImportCharterRequest.EditCharter.ContractObject> contractObject;
        @XmlElement(name = "CharterVersionGUID", required = true)
        protected String charterVersionGUID;

        /**
         * Gets the value of the contractObject property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the contractObject property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getContractObject().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link ImportCharterRequest.EditCharter.ContractObject }
         * 
         * 
         */
        public List<ImportCharterRequest.EditCharter.ContractObject> getContractObject() {
            if (contractObject == null) {
                contractObject = new ArrayList<ImportCharterRequest.EditCharter.ContractObject>();
            }
            return this.contractObject;
        }

        /**
         * Gets the value of the charterVersionGUID property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getCharterVersionGUID() {
            return charterVersionGUID;
        }

        /**
         * Sets the value of the charterVersionGUID property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setCharterVersionGUID(String value) {
            this.charterVersionGUID = value;
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
         *           &lt;element name="Add">
         *             &lt;complexType>
         *               &lt;complexContent>
         *                 &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/house-management/}ManageObjectType">
         *                   &lt;sequence>
         *                     &lt;element name="BaseMService" type="{http://dom.gosuslugi.ru/schema/integration/house-management/}BaseServiceCharterType"/>
         *                     &lt;element name="HouseService" maxOccurs="unbounded" minOccurs="0">
         *                       &lt;complexType>
         *                         &lt;complexContent>
         *                           &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/house-management/}ContractServiceType">
         *                             &lt;sequence>
         *                               &lt;element name="BaseServiceCharter" type="{http://dom.gosuslugi.ru/schema/integration/house-management/}BaseServiceCharterType"/>
         *                             &lt;/sequence>
         *                           &lt;/extension>
         *                         &lt;/complexContent>
         *                       &lt;/complexType>
         *                     &lt;/element>
         *                     &lt;element name="AddService" maxOccurs="unbounded" minOccurs="0">
         *                       &lt;complexType>
         *                         &lt;complexContent>
         *                           &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/house-management/}ContractServiceType">
         *                             &lt;sequence>
         *                               &lt;element name="BaseServiceCharter" type="{http://dom.gosuslugi.ru/schema/integration/house-management/}BaseServiceCharterType"/>
         *                             &lt;/sequence>
         *                           &lt;/extension>
         *                         &lt;/complexContent>
         *                       &lt;/complexType>
         *                     &lt;/element>
         *                   &lt;/sequence>
         *                 &lt;/extension>
         *               &lt;/complexContent>
         *             &lt;/complexType>
         *           &lt;/element>
         *           &lt;element name="Edit">
         *             &lt;complexType>
         *               &lt;complexContent>
         *                 &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/house-management/}ManageObjectType">
         *                   &lt;sequence>
         *                     &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/house-management/}ContractObjectVersionGUID"/>
         *                     &lt;element name="BaseMService" type="{http://dom.gosuslugi.ru/schema/integration/house-management/}BaseServiceCharterType" minOccurs="0"/>
         *                     &lt;element name="HouseService" maxOccurs="unbounded" minOccurs="0">
         *                       &lt;complexType>
         *                         &lt;complexContent>
         *                           &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/house-management/}ContractServiceType">
         *                             &lt;sequence>
         *                               &lt;element name="BaseServiceCharter" type="{http://dom.gosuslugi.ru/schema/integration/house-management/}BaseServiceCharterType"/>
         *                             &lt;/sequence>
         *                           &lt;/extension>
         *                         &lt;/complexContent>
         *                       &lt;/complexType>
         *                     &lt;/element>
         *                     &lt;element name="AddService" maxOccurs="unbounded" minOccurs="0">
         *                       &lt;complexType>
         *                         &lt;complexContent>
         *                           &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/house-management/}ContractServiceType">
         *                             &lt;sequence>
         *                               &lt;element name="BaseServiceCharter" type="{http://dom.gosuslugi.ru/schema/integration/house-management/}BaseServiceCharterType"/>
         *                             &lt;/sequence>
         *                           &lt;/extension>
         *                         &lt;/complexContent>
         *                       &lt;/complexType>
         *                     &lt;/element>
         *                   &lt;/sequence>
         *                 &lt;/extension>
         *               &lt;/complexContent>
         *             &lt;/complexType>
         *           &lt;/element>
         *           &lt;element name="Exclusion">
         *             &lt;complexType>
         *               &lt;complexContent>
         *                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *                   &lt;sequence>
         *                     &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/house-management/}ContractObjectVersionGUID"/>
         *                     &lt;element name="BaseExclusion" type="{http://dom.gosuslugi.ru/schema/integration/house-management/}BaseServiceCharterType"/>
         *                     &lt;element name="DateExclusion" type="{http://www.w3.org/2001/XMLSchema}date"/>
         *                   &lt;/sequence>
         *                 &lt;/restriction>
         *               &lt;/complexContent>
         *             &lt;/complexType>
         *           &lt;/element>
         *           &lt;element name="Annulment">
         *             &lt;complexType>
         *               &lt;complexContent>
         *                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *                   &lt;sequence>
         *                     &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/house-management/}ContractObjectVersionGUID"/>
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
            "add",
            "edit",
            "exclusion",
            "annulment"
        })
        public static class ContractObject {

            @XmlElement(name = "TransportGUID", namespace = "http://dom.gosuslugi.ru/schema/integration/base/", required = true)
            protected String transportGUID;
            @XmlElement(name = "Add")
            protected ImportCharterRequest.EditCharter.ContractObject.Add add;
            @XmlElement(name = "Edit")
            protected ImportCharterRequest.EditCharter.ContractObject.Edit edit;
            @XmlElement(name = "Exclusion")
            protected ImportCharterRequest.EditCharter.ContractObject.Exclusion exclusion;
            @XmlElement(name = "Annulment")
            protected ImportCharterRequest.EditCharter.ContractObject.Annulment annulment;

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
             * Gets the value of the add property.
             * 
             * @return
             *     possible object is
             *     {@link ImportCharterRequest.EditCharter.ContractObject.Add }
             *     
             */
            public ImportCharterRequest.EditCharter.ContractObject.Add getAdd() {
                return add;
            }

            /**
             * Sets the value of the add property.
             * 
             * @param value
             *     allowed object is
             *     {@link ImportCharterRequest.EditCharter.ContractObject.Add }
             *     
             */
            public void setAdd(ImportCharterRequest.EditCharter.ContractObject.Add value) {
                this.add = value;
            }

            /**
             * Gets the value of the edit property.
             * 
             * @return
             *     possible object is
             *     {@link ImportCharterRequest.EditCharter.ContractObject.Edit }
             *     
             */
            public ImportCharterRequest.EditCharter.ContractObject.Edit getEdit() {
                return edit;
            }

            /**
             * Sets the value of the edit property.
             * 
             * @param value
             *     allowed object is
             *     {@link ImportCharterRequest.EditCharter.ContractObject.Edit }
             *     
             */
            public void setEdit(ImportCharterRequest.EditCharter.ContractObject.Edit value) {
                this.edit = value;
            }

            /**
             * Gets the value of the exclusion property.
             * 
             * @return
             *     possible object is
             *     {@link ImportCharterRequest.EditCharter.ContractObject.Exclusion }
             *     
             */
            public ImportCharterRequest.EditCharter.ContractObject.Exclusion getExclusion() {
                return exclusion;
            }

            /**
             * Sets the value of the exclusion property.
             * 
             * @param value
             *     allowed object is
             *     {@link ImportCharterRequest.EditCharter.ContractObject.Exclusion }
             *     
             */
            public void setExclusion(ImportCharterRequest.EditCharter.ContractObject.Exclusion value) {
                this.exclusion = value;
            }

            /**
             * Gets the value of the annulment property.
             * 
             * @return
             *     possible object is
             *     {@link ImportCharterRequest.EditCharter.ContractObject.Annulment }
             *     
             */
            public ImportCharterRequest.EditCharter.ContractObject.Annulment getAnnulment() {
                return annulment;
            }

            /**
             * Sets the value of the annulment property.
             * 
             * @param value
             *     allowed object is
             *     {@link ImportCharterRequest.EditCharter.ContractObject.Annulment }
             *     
             */
            public void setAnnulment(ImportCharterRequest.EditCharter.ContractObject.Annulment value) {
                this.annulment = value;
            }


            /**
             * <p>Java class for anonymous complex type.
             * 
             * <p>The following schema fragment specifies the expected content contained within this class.
             * 
             * <pre>
             * &lt;complexType>
             *   &lt;complexContent>
             *     &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/house-management/}ManageObjectType">
             *       &lt;sequence>
             *         &lt;element name="BaseMService" type="{http://dom.gosuslugi.ru/schema/integration/house-management/}BaseServiceCharterType"/>
             *         &lt;element name="HouseService" maxOccurs="unbounded" minOccurs="0">
             *           &lt;complexType>
             *             &lt;complexContent>
             *               &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/house-management/}ContractServiceType">
             *                 &lt;sequence>
             *                   &lt;element name="BaseServiceCharter" type="{http://dom.gosuslugi.ru/schema/integration/house-management/}BaseServiceCharterType"/>
             *                 &lt;/sequence>
             *               &lt;/extension>
             *             &lt;/complexContent>
             *           &lt;/complexType>
             *         &lt;/element>
             *         &lt;element name="AddService" maxOccurs="unbounded" minOccurs="0">
             *           &lt;complexType>
             *             &lt;complexContent>
             *               &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/house-management/}ContractServiceType">
             *                 &lt;sequence>
             *                   &lt;element name="BaseServiceCharter" type="{http://dom.gosuslugi.ru/schema/integration/house-management/}BaseServiceCharterType"/>
             *                 &lt;/sequence>
             *               &lt;/extension>
             *             &lt;/complexContent>
             *           &lt;/complexType>
             *         &lt;/element>
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
                "baseMService",
                "houseService",
                "addService"
            })
            public static class Add
                extends ManageObjectType
            {

                @XmlElement(name = "BaseMService", required = true)
                protected BaseServiceCharterType baseMService;
                @XmlElement(name = "HouseService")
                protected List<ImportCharterRequest.EditCharter.ContractObject.Add.HouseService> houseService;
                @XmlElement(name = "AddService")
                protected List<ImportCharterRequest.EditCharter.ContractObject.Add.AddService> addService;

                /**
                 * Gets the value of the baseMService property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link BaseServiceCharterType }
                 *     
                 */
                public BaseServiceCharterType getBaseMService() {
                    return baseMService;
                }

                /**
                 * Sets the value of the baseMService property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link BaseServiceCharterType }
                 *     
                 */
                public void setBaseMService(BaseServiceCharterType value) {
                    this.baseMService = value;
                }

                /**
                 * Gets the value of the houseService property.
                 * 
                 * <p>
                 * This accessor method returns a reference to the live list,
                 * not a snapshot. Therefore any modification you make to the
                 * returned list will be present inside the JAXB object.
                 * This is why there is not a <CODE>set</CODE> method for the houseService property.
                 * 
                 * <p>
                 * For example, to add a new item, do as follows:
                 * <pre>
                 *    getHouseService().add(newItem);
                 * </pre>
                 * 
                 * 
                 * <p>
                 * Objects of the following type(s) are allowed in the list
                 * {@link ImportCharterRequest.EditCharter.ContractObject.Add.HouseService }
                 * 
                 * 
                 */
                public List<ImportCharterRequest.EditCharter.ContractObject.Add.HouseService> getHouseService() {
                    if (houseService == null) {
                        houseService = new ArrayList<ImportCharterRequest.EditCharter.ContractObject.Add.HouseService>();
                    }
                    return this.houseService;
                }

                /**
                 * Gets the value of the addService property.
                 * 
                 * <p>
                 * This accessor method returns a reference to the live list,
                 * not a snapshot. Therefore any modification you make to the
                 * returned list will be present inside the JAXB object.
                 * This is why there is not a <CODE>set</CODE> method for the addService property.
                 * 
                 * <p>
                 * For example, to add a new item, do as follows:
                 * <pre>
                 *    getAddService().add(newItem);
                 * </pre>
                 * 
                 * 
                 * <p>
                 * Objects of the following type(s) are allowed in the list
                 * {@link ImportCharterRequest.EditCharter.ContractObject.Add.AddService }
                 * 
                 * 
                 */
                public List<ImportCharterRequest.EditCharter.ContractObject.Add.AddService> getAddService() {
                    if (addService == null) {
                        addService = new ArrayList<ImportCharterRequest.EditCharter.ContractObject.Add.AddService>();
                    }
                    return this.addService;
                }


                /**
                 * <p>Java class for anonymous complex type.
                 * 
                 * <p>The following schema fragment specifies the expected content contained within this class.
                 * 
                 * <pre>
                 * &lt;complexType>
                 *   &lt;complexContent>
                 *     &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/house-management/}ContractServiceType">
                 *       &lt;sequence>
                 *         &lt;element name="BaseServiceCharter" type="{http://dom.gosuslugi.ru/schema/integration/house-management/}BaseServiceCharterType"/>
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
                    "baseServiceCharter"
                })
                public static class AddService
                    extends ContractServiceType
                {

                    @XmlElement(name = "BaseServiceCharter", required = true)
                    protected BaseServiceCharterType baseServiceCharter;

                    /**
                     * Gets the value of the baseServiceCharter property.
                     * 
                     * @return
                     *     possible object is
                     *     {@link BaseServiceCharterType }
                     *     
                     */
                    public BaseServiceCharterType getBaseServiceCharter() {
                        return baseServiceCharter;
                    }

                    /**
                     * Sets the value of the baseServiceCharter property.
                     * 
                     * @param value
                     *     allowed object is
                     *     {@link BaseServiceCharterType }
                     *     
                     */
                    public void setBaseServiceCharter(BaseServiceCharterType value) {
                        this.baseServiceCharter = value;
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
                 *     &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/house-management/}ContractServiceType">
                 *       &lt;sequence>
                 *         &lt;element name="BaseServiceCharter" type="{http://dom.gosuslugi.ru/schema/integration/house-management/}BaseServiceCharterType"/>
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
                    "baseServiceCharter"
                })
                public static class HouseService
                    extends ContractServiceType
                {

                    @XmlElement(name = "BaseServiceCharter", required = true)
                    protected BaseServiceCharterType baseServiceCharter;

                    /**
                     * Gets the value of the baseServiceCharter property.
                     * 
                     * @return
                     *     possible object is
                     *     {@link BaseServiceCharterType }
                     *     
                     */
                    public BaseServiceCharterType getBaseServiceCharter() {
                        return baseServiceCharter;
                    }

                    /**
                     * Sets the value of the baseServiceCharter property.
                     * 
                     * @param value
                     *     allowed object is
                     *     {@link BaseServiceCharterType }
                     *     
                     */
                    public void setBaseServiceCharter(BaseServiceCharterType value) {
                        this.baseServiceCharter = value;
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
             *         &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/house-management/}ContractObjectVersionGUID"/>
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
                "contractObjectVersionGUID"
            })
            public static class Annulment {

                @XmlElement(name = "ContractObjectVersionGUID", required = true)
                protected String contractObjectVersionGUID;

                /**
                 * Gets the value of the contractObjectVersionGUID property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getContractObjectVersionGUID() {
                    return contractObjectVersionGUID;
                }

                /**
                 * Sets the value of the contractObjectVersionGUID property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setContractObjectVersionGUID(String value) {
                    this.contractObjectVersionGUID = value;
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
             *     &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/house-management/}ManageObjectType">
             *       &lt;sequence>
             *         &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/house-management/}ContractObjectVersionGUID"/>
             *         &lt;element name="BaseMService" type="{http://dom.gosuslugi.ru/schema/integration/house-management/}BaseServiceCharterType" minOccurs="0"/>
             *         &lt;element name="HouseService" maxOccurs="unbounded" minOccurs="0">
             *           &lt;complexType>
             *             &lt;complexContent>
             *               &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/house-management/}ContractServiceType">
             *                 &lt;sequence>
             *                   &lt;element name="BaseServiceCharter" type="{http://dom.gosuslugi.ru/schema/integration/house-management/}BaseServiceCharterType"/>
             *                 &lt;/sequence>
             *               &lt;/extension>
             *             &lt;/complexContent>
             *           &lt;/complexType>
             *         &lt;/element>
             *         &lt;element name="AddService" maxOccurs="unbounded" minOccurs="0">
             *           &lt;complexType>
             *             &lt;complexContent>
             *               &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/house-management/}ContractServiceType">
             *                 &lt;sequence>
             *                   &lt;element name="BaseServiceCharter" type="{http://dom.gosuslugi.ru/schema/integration/house-management/}BaseServiceCharterType"/>
             *                 &lt;/sequence>
             *               &lt;/extension>
             *             &lt;/complexContent>
             *           &lt;/complexType>
             *         &lt;/element>
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
                "contractObjectVersionGUID",
                "baseMService",
                "houseService",
                "addService"
            })
            public static class Edit
                extends ManageObjectType
            {

                @XmlElement(name = "ContractObjectVersionGUID", required = true)
                protected String contractObjectVersionGUID;
                @XmlElement(name = "BaseMService")
                protected BaseServiceCharterType baseMService;
                @XmlElement(name = "HouseService")
                protected List<ImportCharterRequest.EditCharter.ContractObject.Edit.HouseService> houseService;
                @XmlElement(name = "AddService")
                protected List<ImportCharterRequest.EditCharter.ContractObject.Edit.AddService> addService;

                /**
                 * Gets the value of the contractObjectVersionGUID property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getContractObjectVersionGUID() {
                    return contractObjectVersionGUID;
                }

                /**
                 * Sets the value of the contractObjectVersionGUID property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setContractObjectVersionGUID(String value) {
                    this.contractObjectVersionGUID = value;
                }

                /**
                 * Gets the value of the baseMService property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link BaseServiceCharterType }
                 *     
                 */
                public BaseServiceCharterType getBaseMService() {
                    return baseMService;
                }

                /**
                 * Sets the value of the baseMService property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link BaseServiceCharterType }
                 *     
                 */
                public void setBaseMService(BaseServiceCharterType value) {
                    this.baseMService = value;
                }

                /**
                 * Gets the value of the houseService property.
                 * 
                 * <p>
                 * This accessor method returns a reference to the live list,
                 * not a snapshot. Therefore any modification you make to the
                 * returned list will be present inside the JAXB object.
                 * This is why there is not a <CODE>set</CODE> method for the houseService property.
                 * 
                 * <p>
                 * For example, to add a new item, do as follows:
                 * <pre>
                 *    getHouseService().add(newItem);
                 * </pre>
                 * 
                 * 
                 * <p>
                 * Objects of the following type(s) are allowed in the list
                 * {@link ImportCharterRequest.EditCharter.ContractObject.Edit.HouseService }
                 * 
                 * 
                 */
                public List<ImportCharterRequest.EditCharter.ContractObject.Edit.HouseService> getHouseService() {
                    if (houseService == null) {
                        houseService = new ArrayList<ImportCharterRequest.EditCharter.ContractObject.Edit.HouseService>();
                    }
                    return this.houseService;
                }

                /**
                 * Gets the value of the addService property.
                 * 
                 * <p>
                 * This accessor method returns a reference to the live list,
                 * not a snapshot. Therefore any modification you make to the
                 * returned list will be present inside the JAXB object.
                 * This is why there is not a <CODE>set</CODE> method for the addService property.
                 * 
                 * <p>
                 * For example, to add a new item, do as follows:
                 * <pre>
                 *    getAddService().add(newItem);
                 * </pre>
                 * 
                 * 
                 * <p>
                 * Objects of the following type(s) are allowed in the list
                 * {@link ImportCharterRequest.EditCharter.ContractObject.Edit.AddService }
                 * 
                 * 
                 */
                public List<ImportCharterRequest.EditCharter.ContractObject.Edit.AddService> getAddService() {
                    if (addService == null) {
                        addService = new ArrayList<ImportCharterRequest.EditCharter.ContractObject.Edit.AddService>();
                    }
                    return this.addService;
                }


                /**
                 * <p>Java class for anonymous complex type.
                 * 
                 * <p>The following schema fragment specifies the expected content contained within this class.
                 * 
                 * <pre>
                 * &lt;complexType>
                 *   &lt;complexContent>
                 *     &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/house-management/}ContractServiceType">
                 *       &lt;sequence>
                 *         &lt;element name="BaseServiceCharter" type="{http://dom.gosuslugi.ru/schema/integration/house-management/}BaseServiceCharterType"/>
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
                    "baseServiceCharter"
                })
                public static class AddService
                    extends ContractServiceType
                {

                    @XmlElement(name = "BaseServiceCharter", required = true)
                    protected BaseServiceCharterType baseServiceCharter;

                    /**
                     * Gets the value of the baseServiceCharter property.
                     * 
                     * @return
                     *     possible object is
                     *     {@link BaseServiceCharterType }
                     *     
                     */
                    public BaseServiceCharterType getBaseServiceCharter() {
                        return baseServiceCharter;
                    }

                    /**
                     * Sets the value of the baseServiceCharter property.
                     * 
                     * @param value
                     *     allowed object is
                     *     {@link BaseServiceCharterType }
                     *     
                     */
                    public void setBaseServiceCharter(BaseServiceCharterType value) {
                        this.baseServiceCharter = value;
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
                 *     &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/house-management/}ContractServiceType">
                 *       &lt;sequence>
                 *         &lt;element name="BaseServiceCharter" type="{http://dom.gosuslugi.ru/schema/integration/house-management/}BaseServiceCharterType"/>
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
                    "baseServiceCharter"
                })
                public static class HouseService
                    extends ContractServiceType
                {

                    @XmlElement(name = "BaseServiceCharter", required = true)
                    protected BaseServiceCharterType baseServiceCharter;

                    /**
                     * Gets the value of the baseServiceCharter property.
                     * 
                     * @return
                     *     possible object is
                     *     {@link BaseServiceCharterType }
                     *     
                     */
                    public BaseServiceCharterType getBaseServiceCharter() {
                        return baseServiceCharter;
                    }

                    /**
                     * Sets the value of the baseServiceCharter property.
                     * 
                     * @param value
                     *     allowed object is
                     *     {@link BaseServiceCharterType }
                     *     
                     */
                    public void setBaseServiceCharter(BaseServiceCharterType value) {
                        this.baseServiceCharter = value;
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
             *         &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/house-management/}ContractObjectVersionGUID"/>
             *         &lt;element name="BaseExclusion" type="{http://dom.gosuslugi.ru/schema/integration/house-management/}BaseServiceCharterType"/>
             *         &lt;element name="DateExclusion" type="{http://www.w3.org/2001/XMLSchema}date"/>
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
                "contractObjectVersionGUID",
                "baseExclusion",
                "dateExclusion"
            })
            public static class Exclusion {

                @XmlElement(name = "ContractObjectVersionGUID", required = true)
                protected String contractObjectVersionGUID;
                @XmlElement(name = "BaseExclusion", required = true)
                protected BaseServiceCharterType baseExclusion;
                @XmlElement(name = "DateExclusion", required = true)
                @XmlSchemaType(name = "date")
                protected XMLGregorianCalendar dateExclusion;

                /**
                 * Gets the value of the contractObjectVersionGUID property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getContractObjectVersionGUID() {
                    return contractObjectVersionGUID;
                }

                /**
                 * Sets the value of the contractObjectVersionGUID property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setContractObjectVersionGUID(String value) {
                    this.contractObjectVersionGUID = value;
                }

                /**
                 * Gets the value of the baseExclusion property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link BaseServiceCharterType }
                 *     
                 */
                public BaseServiceCharterType getBaseExclusion() {
                    return baseExclusion;
                }

                /**
                 * Sets the value of the baseExclusion property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link BaseServiceCharterType }
                 *     
                 */
                public void setBaseExclusion(BaseServiceCharterType value) {
                    this.baseExclusion = value;
                }

                /**
                 * Gets the value of the dateExclusion property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link XMLGregorianCalendar }
                 *     
                 */
                public XMLGregorianCalendar getDateExclusion() {
                    return dateExclusion;
                }

                /**
                 * Sets the value of the dateExclusion property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link XMLGregorianCalendar }
                 *     
                 */
                public void setDateExclusion(XMLGregorianCalendar value) {
                    this.dateExclusion = value;
                }

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
     *     &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/house-management/}CharterPaymentsInfoType">
     *       &lt;sequence>
     *         &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/house-management/}CharterVersionGUID"/>
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
        "charterVersionGUID"
    })
    public static class PlaceCharterPaymentsInfo
        extends CharterPaymentsInfoType
    {

        @XmlElement(name = "CharterVersionGUID", required = true)
        protected String charterVersionGUID;

        /**
         * Gets the value of the charterVersionGUID property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getCharterVersionGUID() {
            return charterVersionGUID;
        }

        /**
         * Sets the value of the charterVersionGUID property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setCharterVersionGUID(String value) {
            this.charterVersionGUID = value;
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
     *     &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/house-management/}CharterType">
     *       &lt;sequence>
     *         &lt;element name="ContractObject" maxOccurs="unbounded">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/house-management/}ManageObjectType">
     *                 &lt;sequence>
     *                   &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/base/}TransportGUID"/>
     *                   &lt;element name="BaseMService" type="{http://dom.gosuslugi.ru/schema/integration/house-management/}BaseServiceCharterType"/>
     *                   &lt;element name="HouseService" maxOccurs="unbounded" minOccurs="0">
     *                     &lt;complexType>
     *                       &lt;complexContent>
     *                         &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/house-management/}ContractServiceType">
     *                           &lt;sequence>
     *                             &lt;element name="BaseServiceCharter" type="{http://dom.gosuslugi.ru/schema/integration/house-management/}BaseServiceCharterType"/>
     *                           &lt;/sequence>
     *                         &lt;/extension>
     *                       &lt;/complexContent>
     *                     &lt;/complexType>
     *                   &lt;/element>
     *                   &lt;element name="AddService" maxOccurs="unbounded" minOccurs="0">
     *                     &lt;complexType>
     *                       &lt;complexContent>
     *                         &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/house-management/}ContractServiceType">
     *                           &lt;sequence>
     *                             &lt;element name="BaseServiceCharter" type="{http://dom.gosuslugi.ru/schema/integration/house-management/}BaseServiceCharterType"/>
     *                           &lt;/sequence>
     *                         &lt;/extension>
     *                       &lt;/complexContent>
     *                     &lt;/complexType>
     *                   &lt;/element>
     *                   &lt;element name="IsManagedByContract" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
     *                 &lt;/sequence>
     *               &lt;/extension>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
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
        "contractObject"
    })
    public static class PlacingCharter
        extends CharterType
    {

        @XmlElement(name = "ContractObject", required = true)
        protected List<ImportCharterRequest.PlacingCharter.ContractObject> contractObject;

        /**
         * Gets the value of the contractObject property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the contractObject property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getContractObject().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link ImportCharterRequest.PlacingCharter.ContractObject }
         * 
         * 
         */
        public List<ImportCharterRequest.PlacingCharter.ContractObject> getContractObject() {
            if (contractObject == null) {
                contractObject = new ArrayList<ImportCharterRequest.PlacingCharter.ContractObject>();
            }
            return this.contractObject;
        }


        /**
         * <p>Java class for anonymous complex type.
         * 
         * <p>The following schema fragment specifies the expected content contained within this class.
         * 
         * <pre>
         * &lt;complexType>
         *   &lt;complexContent>
         *     &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/house-management/}ManageObjectType">
         *       &lt;sequence>
         *         &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/base/}TransportGUID"/>
         *         &lt;element name="BaseMService" type="{http://dom.gosuslugi.ru/schema/integration/house-management/}BaseServiceCharterType"/>
         *         &lt;element name="HouseService" maxOccurs="unbounded" minOccurs="0">
         *           &lt;complexType>
         *             &lt;complexContent>
         *               &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/house-management/}ContractServiceType">
         *                 &lt;sequence>
         *                   &lt;element name="BaseServiceCharter" type="{http://dom.gosuslugi.ru/schema/integration/house-management/}BaseServiceCharterType"/>
         *                 &lt;/sequence>
         *               &lt;/extension>
         *             &lt;/complexContent>
         *           &lt;/complexType>
         *         &lt;/element>
         *         &lt;element name="AddService" maxOccurs="unbounded" minOccurs="0">
         *           &lt;complexType>
         *             &lt;complexContent>
         *               &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/house-management/}ContractServiceType">
         *                 &lt;sequence>
         *                   &lt;element name="BaseServiceCharter" type="{http://dom.gosuslugi.ru/schema/integration/house-management/}BaseServiceCharterType"/>
         *                 &lt;/sequence>
         *               &lt;/extension>
         *             &lt;/complexContent>
         *           &lt;/complexType>
         *         &lt;/element>
         *         &lt;element name="IsManagedByContract" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
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
            "transportGUID",
            "baseMService",
            "houseService",
            "addService",
            "isManagedByContract"
        })
        public static class ContractObject
            extends ManageObjectType
        {

            @XmlElement(name = "TransportGUID", namespace = "http://dom.gosuslugi.ru/schema/integration/base/", required = true)
            protected String transportGUID;
            @XmlElement(name = "BaseMService", required = true)
            protected BaseServiceCharterType baseMService;
            @XmlElement(name = "HouseService")
            protected List<ImportCharterRequest.PlacingCharter.ContractObject.HouseService> houseService;
            @XmlElement(name = "AddService")
            protected List<ImportCharterRequest.PlacingCharter.ContractObject.AddService> addService;
            @XmlElement(name = "IsManagedByContract")
            protected Boolean isManagedByContract;

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
             * Gets the value of the baseMService property.
             * 
             * @return
             *     possible object is
             *     {@link BaseServiceCharterType }
             *     
             */
            public BaseServiceCharterType getBaseMService() {
                return baseMService;
            }

            /**
             * Sets the value of the baseMService property.
             * 
             * @param value
             *     allowed object is
             *     {@link BaseServiceCharterType }
             *     
             */
            public void setBaseMService(BaseServiceCharterType value) {
                this.baseMService = value;
            }

            /**
             * Gets the value of the houseService property.
             * 
             * <p>
             * This accessor method returns a reference to the live list,
             * not a snapshot. Therefore any modification you make to the
             * returned list will be present inside the JAXB object.
             * This is why there is not a <CODE>set</CODE> method for the houseService property.
             * 
             * <p>
             * For example, to add a new item, do as follows:
             * <pre>
             *    getHouseService().add(newItem);
             * </pre>
             * 
             * 
             * <p>
             * Objects of the following type(s) are allowed in the list
             * {@link ImportCharterRequest.PlacingCharter.ContractObject.HouseService }
             * 
             * 
             */
            public List<ImportCharterRequest.PlacingCharter.ContractObject.HouseService> getHouseService() {
                if (houseService == null) {
                    houseService = new ArrayList<ImportCharterRequest.PlacingCharter.ContractObject.HouseService>();
                }
                return this.houseService;
            }

            /**
             * Gets the value of the addService property.
             * 
             * <p>
             * This accessor method returns a reference to the live list,
             * not a snapshot. Therefore any modification you make to the
             * returned list will be present inside the JAXB object.
             * This is why there is not a <CODE>set</CODE> method for the addService property.
             * 
             * <p>
             * For example, to add a new item, do as follows:
             * <pre>
             *    getAddService().add(newItem);
             * </pre>
             * 
             * 
             * <p>
             * Objects of the following type(s) are allowed in the list
             * {@link ImportCharterRequest.PlacingCharter.ContractObject.AddService }
             * 
             * 
             */
            public List<ImportCharterRequest.PlacingCharter.ContractObject.AddService> getAddService() {
                if (addService == null) {
                    addService = new ArrayList<ImportCharterRequest.PlacingCharter.ContractObject.AddService>();
                }
                return this.addService;
            }

            /**
             * Gets the value of the isManagedByContract property.
             * 
             * @return
             *     possible object is
             *     {@link Boolean }
             *     
             */
            public Boolean isIsManagedByContract() {
                return isManagedByContract;
            }

            /**
             * Sets the value of the isManagedByContract property.
             * 
             * @param value
             *     allowed object is
             *     {@link Boolean }
             *     
             */
            public void setIsManagedByContract(Boolean value) {
                this.isManagedByContract = value;
            }


            /**
             * <p>Java class for anonymous complex type.
             * 
             * <p>The following schema fragment specifies the expected content contained within this class.
             * 
             * <pre>
             * &lt;complexType>
             *   &lt;complexContent>
             *     &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/house-management/}ContractServiceType">
             *       &lt;sequence>
             *         &lt;element name="BaseServiceCharter" type="{http://dom.gosuslugi.ru/schema/integration/house-management/}BaseServiceCharterType"/>
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
                "baseServiceCharter"
            })
            public static class AddService
                extends ContractServiceType
            {

                @XmlElement(name = "BaseServiceCharter", required = true)
                protected BaseServiceCharterType baseServiceCharter;

                /**
                 * Gets the value of the baseServiceCharter property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link BaseServiceCharterType }
                 *     
                 */
                public BaseServiceCharterType getBaseServiceCharter() {
                    return baseServiceCharter;
                }

                /**
                 * Sets the value of the baseServiceCharter property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link BaseServiceCharterType }
                 *     
                 */
                public void setBaseServiceCharter(BaseServiceCharterType value) {
                    this.baseServiceCharter = value;
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
             *     &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/house-management/}ContractServiceType">
             *       &lt;sequence>
             *         &lt;element name="BaseServiceCharter" type="{http://dom.gosuslugi.ru/schema/integration/house-management/}BaseServiceCharterType"/>
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
                "baseServiceCharter"
            })
            public static class HouseService
                extends ContractServiceType
            {

                @XmlElement(name = "BaseServiceCharter", required = true)
                protected BaseServiceCharterType baseServiceCharter;

                /**
                 * Gets the value of the baseServiceCharter property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link BaseServiceCharterType }
                 *     
                 */
                public BaseServiceCharterType getBaseServiceCharter() {
                    return baseServiceCharter;
                }

                /**
                 * Sets the value of the baseServiceCharter property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link BaseServiceCharterType }
                 *     
                 */
                public void setBaseServiceCharter(BaseServiceCharterType value) {
                    this.baseServiceCharter = value;
                }

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
     *     &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/house-management/}RollOverType">
     *       &lt;sequence>
     *         &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/house-management/}CharterVersionGUID"/>
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
        "charterVersionGUID"
    })
    public static class RollOverCharter
        extends RollOverType
    {

        @XmlElement(name = "CharterVersionGUID", required = true)
        protected String charterVersionGUID;

        /**
         * Gets the value of the charterVersionGUID property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getCharterVersionGUID() {
            return charterVersionGUID;
        }

        /**
         * Sets the value of the charterVersionGUID property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setCharterVersionGUID(String value) {
            this.charterVersionGUID = value;
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
     *     &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/house-management/}TerminateType">
     *       &lt;sequence>
     *         &lt;element name="Reason">
     *           &lt;simpleType>
     *             &lt;restriction base="{http://dom.gosuslugi.ru/schema/integration/base/}LongTextType">
     *               &lt;maxLength value="255"/>
     *             &lt;/restriction>
     *           &lt;/simpleType>
     *         &lt;/element>
     *         &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/house-management/}CharterVersionGUID"/>
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
        "reason",
        "charterVersionGUID"
    })
    public static class TerminateCharter
        extends TerminateType
    {

        @XmlElement(name = "Reason", required = true)
        protected String reason;
        @XmlElement(name = "CharterVersionGUID", required = true)
        protected String charterVersionGUID;

        /**
         * Gets the value of the reason property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getReason() {
            return reason;
        }

        /**
         * Sets the value of the reason property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setReason(String value) {
            this.reason = value;
        }

        /**
         * Gets the value of the charterVersionGUID property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getCharterVersionGUID() {
            return charterVersionGUID;
        }

        /**
         * Sets the value of the charterVersionGUID property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setCharterVersionGUID(String value) {
            this.charterVersionGUID = value;
        }

    }

}
