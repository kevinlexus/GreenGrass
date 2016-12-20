
package ru.gosuslugi.dom.schema.integration.services;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlList;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;
import ru.gosuslugi.dom.schema.integration.base.DocumentPortalType;
import ru.gosuslugi.dom.schema.integration.base.OKTMORefType;
import ru.gosuslugi.dom.schema.integration.base.RegionType;
import ru.gosuslugi.dom.schema.integration.nsi_base.NsiRef;
import ru.gosuslugi.dom.schema.integration.organizations_registry_base.RegOrgVersionType;


/**
 * Документ. Тарифы ЖКУ
 * 
 * <p>Java class for HMServicesTarifsDocType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="HMServicesTarifsDocType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/base/}DocumentPortalType">
 *       &lt;sequence>
 *         &lt;element name="EffectivePeriodFrom" type="{http://www.w3.org/2001/XMLSchema}date"/>
 *         &lt;element name="EffectivePeriodTo" type="{http://www.w3.org/2001/XMLSchema}date"/>
 *         &lt;element name="CancelServicesTarifDocGUID" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType" minOccurs="0"/>
 *         &lt;element name="IsPublished" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="Region" type="{http://dom.gosuslugi.ru/schema/integration/base/}RegionType"/>
 *         &lt;choice>
 *           &lt;element name="GKU">
 *             &lt;complexType>
 *               &lt;complexContent>
 *                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                   &lt;sequence>
 *                     &lt;element name="MServiceType" type="{http://dom.gosuslugi.ru/schema/integration/nsi-base/}nsiRef" maxOccurs="unbounded"/>
 *                     &lt;element name="Municipalities" type="{http://dom.gosuslugi.ru/schema/integration/base/}OKTMORefType" minOccurs="0"/>
 *                     &lt;element name="RSOOrganizationGUID" type="{http://dom.gosuslugi.ru/schema/integration/organizations-registry-base/}RegOrgVersionType" maxOccurs="unbounded"/>
 *                     &lt;element name="SKI" maxOccurs="unbounded" minOccurs="0">
 *                       &lt;complexType>
 *                         &lt;complexContent>
 *                           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                             &lt;sequence>
 *                               &lt;element name="Name">
 *                                 &lt;simpleType>
 *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                                     &lt;maxLength value="140"/>
 *                                     &lt;minLength value="1"/>
 *                                   &lt;/restriction>
 *                                 &lt;/simpleType>
 *                               &lt;/element>
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
 *           &lt;element name="KU">
 *             &lt;complexType>
 *               &lt;complexContent>
 *                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                   &lt;sequence>
 *                     &lt;element name="MServiceType" maxOccurs="unbounded">
 *                       &lt;complexType>
 *                         &lt;complexContent>
 *                           &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/nsi-base/}nsiRef">
 *                             &lt;sequence>
 *                               &lt;element name="Name" minOccurs="0">
 *                                 &lt;simpleType>
 *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                                     &lt;minLength value="1"/>
 *                                     &lt;maxLength value="100"/>
 *                                   &lt;/restriction>
 *                                 &lt;/simpleType>
 *                               &lt;/element>
 *                             &lt;/sequence>
 *                           &lt;/extension>
 *                         &lt;/complexContent>
 *                       &lt;/complexType>
 *                     &lt;/element>
 *                   &lt;/sequence>
 *                 &lt;/restriction>
 *               &lt;/complexContent>
 *             &lt;/complexType>
 *           &lt;/element>
 *           &lt;element name="IsOverhaul" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *           &lt;sequence>
 *             &lt;element name="OKTMOs" type="{http://dom.gosuslugi.ru/schema/integration/base/}OKTMORefType" maxOccurs="unbounded"/>
 *             &lt;element name="ServiceType">
 *               &lt;simpleType>
 *                 &lt;restriction>
 *                   &lt;simpleType>
 *                     &lt;list>
 *                       &lt;simpleType>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}token">
 *                           &lt;enumeration value="S"/>
 *                           &lt;enumeration value="R"/>
 *                         &lt;/restriction>
 *                       &lt;/simpleType>
 *                     &lt;/list>
 *                   &lt;/simpleType>
 *                   &lt;minLength value="1"/>
 *                   &lt;maxLength value="2"/>
 *                   &lt;enumeration value="S"/>
 *                   &lt;enumeration value="R"/>
 *                 &lt;/restriction>
 *               &lt;/simpleType>
 *             &lt;/element>
 *           &lt;/sequence>
 *         &lt;/choice>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "HMServicesTarifsDocType", propOrder = {
    "effectivePeriodFrom",
    "effectivePeriodTo",
    "cancelServicesTarifDocGUID",
    "isPublished",
    "region",
    "gku",
    "ku",
    "isOverhaul",
    "oktmOs",
    "serviceType"
})
@XmlSeeAlso({
    ExportHMServicesTarifsResultType.class
})
public class HMServicesTarifsDocType
    extends DocumentPortalType
{

    @XmlElement(name = "EffectivePeriodFrom", required = true)
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar effectivePeriodFrom;
    @XmlElement(name = "EffectivePeriodTo", required = true)
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar effectivePeriodTo;
    @XmlElement(name = "CancelServicesTarifDocGUID")
    protected String cancelServicesTarifDocGUID;
    @XmlElement(name = "IsPublished")
    protected boolean isPublished;
    @XmlElement(name = "Region", required = true)
    protected RegionType region;
    @XmlElement(name = "GKU")
    protected HMServicesTarifsDocType.GKU gku;
    @XmlElement(name = "KU")
    protected HMServicesTarifsDocType.KU ku;
    @XmlElement(name = "IsOverhaul")
    protected Boolean isOverhaul;
    @XmlElement(name = "OKTMOs")
    protected List<OKTMORefType> oktmOs;
    @XmlList
    @XmlElement(name = "ServiceType")
    protected List<String> serviceType;

    /**
     * Gets the value of the effectivePeriodFrom property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getEffectivePeriodFrom() {
        return effectivePeriodFrom;
    }

    /**
     * Sets the value of the effectivePeriodFrom property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setEffectivePeriodFrom(XMLGregorianCalendar value) {
        this.effectivePeriodFrom = value;
    }

    /**
     * Gets the value of the effectivePeriodTo property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getEffectivePeriodTo() {
        return effectivePeriodTo;
    }

    /**
     * Sets the value of the effectivePeriodTo property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setEffectivePeriodTo(XMLGregorianCalendar value) {
        this.effectivePeriodTo = value;
    }

    /**
     * Gets the value of the cancelServicesTarifDocGUID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCancelServicesTarifDocGUID() {
        return cancelServicesTarifDocGUID;
    }

    /**
     * Sets the value of the cancelServicesTarifDocGUID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCancelServicesTarifDocGUID(String value) {
        this.cancelServicesTarifDocGUID = value;
    }

    /**
     * Gets the value of the isPublished property.
     * 
     */
    public boolean isIsPublished() {
        return isPublished;
    }

    /**
     * Sets the value of the isPublished property.
     * 
     */
    public void setIsPublished(boolean value) {
        this.isPublished = value;
    }

    /**
     * Gets the value of the region property.
     * 
     * @return
     *     possible object is
     *     {@link RegionType }
     *     
     */
    public RegionType getRegion() {
        return region;
    }

    /**
     * Sets the value of the region property.
     * 
     * @param value
     *     allowed object is
     *     {@link RegionType }
     *     
     */
    public void setRegion(RegionType value) {
        this.region = value;
    }

    /**
     * Gets the value of the gku property.
     * 
     * @return
     *     possible object is
     *     {@link HMServicesTarifsDocType.GKU }
     *     
     */
    public HMServicesTarifsDocType.GKU getGKU() {
        return gku;
    }

    /**
     * Sets the value of the gku property.
     * 
     * @param value
     *     allowed object is
     *     {@link HMServicesTarifsDocType.GKU }
     *     
     */
    public void setGKU(HMServicesTarifsDocType.GKU value) {
        this.gku = value;
    }

    /**
     * Gets the value of the ku property.
     * 
     * @return
     *     possible object is
     *     {@link HMServicesTarifsDocType.KU }
     *     
     */
    public HMServicesTarifsDocType.KU getKU() {
        return ku;
    }

    /**
     * Sets the value of the ku property.
     * 
     * @param value
     *     allowed object is
     *     {@link HMServicesTarifsDocType.KU }
     *     
     */
    public void setKU(HMServicesTarifsDocType.KU value) {
        this.ku = value;
    }

    /**
     * Gets the value of the isOverhaul property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isIsOverhaul() {
        return isOverhaul;
    }

    /**
     * Sets the value of the isOverhaul property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setIsOverhaul(Boolean value) {
        this.isOverhaul = value;
    }

    /**
     * Gets the value of the oktmOs property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the oktmOs property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getOKTMOs().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link OKTMORefType }
     * 
     * 
     */
    public List<OKTMORefType> getOKTMOs() {
        if (oktmOs == null) {
            oktmOs = new ArrayList<OKTMORefType>();
        }
        return this.oktmOs;
    }

    /**
     * Gets the value of the serviceType property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the serviceType property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getServiceType().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getServiceType() {
        if (serviceType == null) {
            serviceType = new ArrayList<String>();
        }
        return this.serviceType;
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
     *         &lt;element name="MServiceType" type="{http://dom.gosuslugi.ru/schema/integration/nsi-base/}nsiRef" maxOccurs="unbounded"/>
     *         &lt;element name="Municipalities" type="{http://dom.gosuslugi.ru/schema/integration/base/}OKTMORefType" minOccurs="0"/>
     *         &lt;element name="RSOOrganizationGUID" type="{http://dom.gosuslugi.ru/schema/integration/organizations-registry-base/}RegOrgVersionType" maxOccurs="unbounded"/>
     *         &lt;element name="SKI" maxOccurs="unbounded" minOccurs="0">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element name="Name">
     *                     &lt;simpleType>
     *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *                         &lt;maxLength value="140"/>
     *                         &lt;minLength value="1"/>
     *                       &lt;/restriction>
     *                     &lt;/simpleType>
     *                   &lt;/element>
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
        "mServiceType",
        "municipalities",
        "rsoOrganizationGUID",
        "ski"
    })
    public static class GKU {

        @XmlElement(name = "MServiceType", required = true)
        protected List<NsiRef> mServiceType;
        @XmlElement(name = "Municipalities")
        protected OKTMORefType municipalities;
        @XmlElement(name = "RSOOrganizationGUID", required = true)
        protected List<RegOrgVersionType> rsoOrganizationGUID;
        @XmlElement(name = "SKI")
        protected List<HMServicesTarifsDocType.GKU.SKI> ski;

        /**
         * Gets the value of the mServiceType property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the mServiceType property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getMServiceType().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link NsiRef }
         * 
         * 
         */
        public List<NsiRef> getMServiceType() {
            if (mServiceType == null) {
                mServiceType = new ArrayList<NsiRef>();
            }
            return this.mServiceType;
        }

        /**
         * Gets the value of the municipalities property.
         * 
         * @return
         *     possible object is
         *     {@link OKTMORefType }
         *     
         */
        public OKTMORefType getMunicipalities() {
            return municipalities;
        }

        /**
         * Sets the value of the municipalities property.
         * 
         * @param value
         *     allowed object is
         *     {@link OKTMORefType }
         *     
         */
        public void setMunicipalities(OKTMORefType value) {
            this.municipalities = value;
        }

        /**
         * Gets the value of the rsoOrganizationGUID property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the rsoOrganizationGUID property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getRSOOrganizationGUID().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link RegOrgVersionType }
         * 
         * 
         */
        public List<RegOrgVersionType> getRSOOrganizationGUID() {
            if (rsoOrganizationGUID == null) {
                rsoOrganizationGUID = new ArrayList<RegOrgVersionType>();
            }
            return this.rsoOrganizationGUID;
        }

        /**
         * Gets the value of the ski property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the ski property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getSKI().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link HMServicesTarifsDocType.GKU.SKI }
         * 
         * 
         */
        public List<HMServicesTarifsDocType.GKU.SKI> getSKI() {
            if (ski == null) {
                ski = new ArrayList<HMServicesTarifsDocType.GKU.SKI>();
            }
            return this.ski;
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
         *         &lt;element name="Name">
         *           &lt;simpleType>
         *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
         *               &lt;maxLength value="140"/>
         *               &lt;minLength value="1"/>
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
            "name"
        })
        public static class SKI {

            @XmlElement(name = "Name", required = true)
            protected String name;

            /**
             * Gets the value of the name property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getName() {
                return name;
            }

            /**
             * Sets the value of the name property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setName(String value) {
                this.name = value;
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
     *         &lt;element name="MServiceType" maxOccurs="unbounded">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/nsi-base/}nsiRef">
     *                 &lt;sequence>
     *                   &lt;element name="Name" minOccurs="0">
     *                     &lt;simpleType>
     *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *                         &lt;minLength value="1"/>
     *                         &lt;maxLength value="100"/>
     *                       &lt;/restriction>
     *                     &lt;/simpleType>
     *                   &lt;/element>
     *                 &lt;/sequence>
     *               &lt;/extension>
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
        "mServiceType"
    })
    public static class KU {

        @XmlElement(name = "MServiceType", required = true)
        protected List<HMServicesTarifsDocType.KU.MServiceType> mServiceType;

        /**
         * Gets the value of the mServiceType property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the mServiceType property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getMServiceType().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link HMServicesTarifsDocType.KU.MServiceType }
         * 
         * 
         */
        public List<HMServicesTarifsDocType.KU.MServiceType> getMServiceType() {
            if (mServiceType == null) {
                mServiceType = new ArrayList<HMServicesTarifsDocType.KU.MServiceType>();
            }
            return this.mServiceType;
        }


        /**
         * <p>Java class for anonymous complex type.
         * 
         * <p>The following schema fragment specifies the expected content contained within this class.
         * 
         * <pre>
         * &lt;complexType>
         *   &lt;complexContent>
         *     &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/nsi-base/}nsiRef">
         *       &lt;sequence>
         *         &lt;element name="Name" minOccurs="0">
         *           &lt;simpleType>
         *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
         *               &lt;minLength value="1"/>
         *               &lt;maxLength value="100"/>
         *             &lt;/restriction>
         *           &lt;/simpleType>
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
            "rest"
        })
        public static class MServiceType
            extends NsiRef
        {

            @XmlElementRef(name = "Name", namespace = "http://dom.gosuslugi.ru/schema/integration/services/", type = JAXBElement.class, required = false)
            protected List<JAXBElement<String>> rest;

            /**
             * Gets the rest of the content model. 
             * 
             * <p>
             * You are getting this "catch-all" property because of the following reason: 
             * The field name "Name" is used by two different parts of a schema. See: 
             * line 1314 of file:/C:/work/GIS_MUP/GIS11_5/hcs_wsdl_xsd_v.11.0.0.5/services/hcs-services-types.xsd
             * line 27 of file:/C:/work/GIS_MUP/GIS11_5/hcs_wsdl_xsd_v.11.0.0.5/lib/hcs-nsi-base.xsd
             * <p>
             * To get rid of this property, apply a property customization to one 
             * of both of the following declarations to change their names: 
             * Gets the value of the rest property.
             * 
             * <p>
             * This accessor method returns a reference to the live list,
             * not a snapshot. Therefore any modification you make to the
             * returned list will be present inside the JAXB object.
             * This is why there is not a <CODE>set</CODE> method for the rest property.
             * 
             * <p>
             * For example, to add a new item, do as follows:
             * <pre>
             *    getRest().add(newItem);
             * </pre>
             * 
             * 
             * <p>
             * Objects of the following type(s) are allowed in the list
             * {@link JAXBElement }{@code <}{@link String }{@code >}
             * 
             * 
             */
            public List<JAXBElement<String>> getRest() {
                if (rest == null) {
                    rest = new ArrayList<JAXBElement<String>>();
                }
                return this.rest;
            }

        }

    }

}
