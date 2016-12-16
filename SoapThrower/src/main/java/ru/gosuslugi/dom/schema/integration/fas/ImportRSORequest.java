
package ru.gosuslugi.dom.schema.integration.fas;

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
import ru.gosuslugi.dom.schema.integration.base.OKTMORefType;


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
 *         &lt;element name="RSO" maxOccurs="100">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/base/}TransportGUID"/>
 *                   &lt;element name="ActualDate" type="{http://www.w3.org/2001/XMLSchema}date"/>
 *                   &lt;choice>
 *                     &lt;element name="RSOActualDATA">
 *                       &lt;complexType>
 *                         &lt;complexContent>
 *                           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                             &lt;sequence>
 *                               &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/organizations-base/}INN"/>
 *                               &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/organizations-base/}KPP" minOccurs="0"/>
 *                               &lt;element name="Name">
 *                                 &lt;simpleType>
 *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                                     &lt;minLength value="1"/>
 *                                     &lt;maxLength value="255"/>
 *                                   &lt;/restriction>
 *                                 &lt;/simpleType>
 *                               &lt;/element>
 *                               &lt;element name="IsEntpr" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *                               &lt;choice minOccurs="0">
 *                                 &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/organizations-base/}OGRN"/>
 *                                 &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/organizations-base/}OGRNIP"/>
 *                               &lt;/choice>
 *                               &lt;element name="Resource" maxOccurs="unbounded">
 *                                 &lt;complexType>
 *                                   &lt;complexContent>
 *                                     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                       &lt;sequence>
 *                                         &lt;element name="ResourseType" type="{http://dom.gosuslugi.ru/schema/integration/fas/}ResourseType"/>
 *                                         &lt;element name="OKTMO" type="{http://dom.gosuslugi.ru/schema/integration/base/}OKTMORefType" maxOccurs="unbounded"/>
 *                                       &lt;/sequence>
 *                                     &lt;/restriction>
 *                                   &lt;/complexContent>
 *                                 &lt;/complexType>
 *                               &lt;/element>
 *                               &lt;element name="RegistryOfNaturalMonopolies" minOccurs="0">
 *                                 &lt;complexType>
 *                                   &lt;complexContent>
 *                                     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                       &lt;sequence>
 *                                         &lt;element name="Number">
 *                                           &lt;simpleType>
 *                                             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                                               &lt;minLength value="1"/>
 *                                               &lt;maxLength value="50"/>
 *                                             &lt;/restriction>
 *                                           &lt;/simpleType>
 *                                         &lt;/element>
 *                                         &lt;element name="Date" type="{http://www.w3.org/2001/XMLSchema}date"/>
 *                                       &lt;/sequence>
 *                                     &lt;/restriction>
 *                                   &lt;/complexContent>
 *                                 &lt;/complexType>
 *                               &lt;/element>
 *                               &lt;element name="RegistryGuaranteeingSuppliers" minOccurs="0">
 *                                 &lt;complexType>
 *                                   &lt;complexContent>
 *                                     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                       &lt;sequence>
 *                                         &lt;element name="Number">
 *                                           &lt;simpleType>
 *                                             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                                               &lt;minLength value="1"/>
 *                                               &lt;maxLength value="50"/>
 *                                             &lt;/restriction>
 *                                           &lt;/simpleType>
 *                                         &lt;/element>
 *                                         &lt;element name="Date" type="{http://www.w3.org/2001/XMLSchema}date"/>
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
 *                     &lt;element name="RemoveRSO">
 *                       &lt;complexType>
 *                         &lt;complexContent>
 *                           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                             &lt;sequence>
 *                               &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/organizations-base/}INN"/>
 *                               &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/organizations-base/}KPP"/>
 *                               &lt;choice minOccurs="0">
 *                                 &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/organizations-base/}OGRN"/>
 *                                 &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/organizations-base/}OGRNIP"/>
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
    "rso"
})
@XmlRootElement(name = "importRSORequest")
public class ImportRSORequest
    extends BaseType
{

    @XmlElement(name = "RSO", required = true)
    protected List<ImportRSORequest.RSO> rso;
    @XmlAttribute(name = "version", namespace = "http://dom.gosuslugi.ru/schema/integration/base/", required = true)
    protected String version;

    /**
     * Gets the value of the rso property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the rso property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getRSO().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ImportRSORequest.RSO }
     * 
     * 
     */
    public List<ImportRSORequest.RSO> getRSO() {
        if (rso == null) {
            rso = new ArrayList<ImportRSORequest.RSO>();
        }
        return this.rso;
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
     *         &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/base/}TransportGUID"/>
     *         &lt;element name="ActualDate" type="{http://www.w3.org/2001/XMLSchema}date"/>
     *         &lt;choice>
     *           &lt;element name="RSOActualDATA">
     *             &lt;complexType>
     *               &lt;complexContent>
     *                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                   &lt;sequence>
     *                     &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/organizations-base/}INN"/>
     *                     &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/organizations-base/}KPP" minOccurs="0"/>
     *                     &lt;element name="Name">
     *                       &lt;simpleType>
     *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *                           &lt;minLength value="1"/>
     *                           &lt;maxLength value="255"/>
     *                         &lt;/restriction>
     *                       &lt;/simpleType>
     *                     &lt;/element>
     *                     &lt;element name="IsEntpr" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
     *                     &lt;choice minOccurs="0">
     *                       &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/organizations-base/}OGRN"/>
     *                       &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/organizations-base/}OGRNIP"/>
     *                     &lt;/choice>
     *                     &lt;element name="Resource" maxOccurs="unbounded">
     *                       &lt;complexType>
     *                         &lt;complexContent>
     *                           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                             &lt;sequence>
     *                               &lt;element name="ResourseType" type="{http://dom.gosuslugi.ru/schema/integration/fas/}ResourseType"/>
     *                               &lt;element name="OKTMO" type="{http://dom.gosuslugi.ru/schema/integration/base/}OKTMORefType" maxOccurs="unbounded"/>
     *                             &lt;/sequence>
     *                           &lt;/restriction>
     *                         &lt;/complexContent>
     *                       &lt;/complexType>
     *                     &lt;/element>
     *                     &lt;element name="RegistryOfNaturalMonopolies" minOccurs="0">
     *                       &lt;complexType>
     *                         &lt;complexContent>
     *                           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                             &lt;sequence>
     *                               &lt;element name="Number">
     *                                 &lt;simpleType>
     *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *                                     &lt;minLength value="1"/>
     *                                     &lt;maxLength value="50"/>
     *                                   &lt;/restriction>
     *                                 &lt;/simpleType>
     *                               &lt;/element>
     *                               &lt;element name="Date" type="{http://www.w3.org/2001/XMLSchema}date"/>
     *                             &lt;/sequence>
     *                           &lt;/restriction>
     *                         &lt;/complexContent>
     *                       &lt;/complexType>
     *                     &lt;/element>
     *                     &lt;element name="RegistryGuaranteeingSuppliers" minOccurs="0">
     *                       &lt;complexType>
     *                         &lt;complexContent>
     *                           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                             &lt;sequence>
     *                               &lt;element name="Number">
     *                                 &lt;simpleType>
     *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *                                     &lt;minLength value="1"/>
     *                                     &lt;maxLength value="50"/>
     *                                   &lt;/restriction>
     *                                 &lt;/simpleType>
     *                               &lt;/element>
     *                               &lt;element name="Date" type="{http://www.w3.org/2001/XMLSchema}date"/>
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
     *           &lt;element name="RemoveRSO">
     *             &lt;complexType>
     *               &lt;complexContent>
     *                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                   &lt;sequence>
     *                     &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/organizations-base/}INN"/>
     *                     &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/organizations-base/}KPP"/>
     *                     &lt;choice minOccurs="0">
     *                       &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/organizations-base/}OGRN"/>
     *                       &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/organizations-base/}OGRNIP"/>
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
        "actualDate",
        "rsoActualDATA",
        "removeRSO"
    })
    public static class RSO {

        @XmlElement(name = "TransportGUID", namespace = "http://dom.gosuslugi.ru/schema/integration/base/", required = true)
        protected String transportGUID;
        @XmlElement(name = "ActualDate", required = true)
        @XmlSchemaType(name = "date")
        protected XMLGregorianCalendar actualDate;
        @XmlElement(name = "RSOActualDATA")
        protected ImportRSORequest.RSO.RSOActualDATA rsoActualDATA;
        @XmlElement(name = "RemoveRSO")
        protected ImportRSORequest.RSO.RemoveRSO removeRSO;

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
         * Gets the value of the actualDate property.
         * 
         * @return
         *     possible object is
         *     {@link XMLGregorianCalendar }
         *     
         */
        public XMLGregorianCalendar getActualDate() {
            return actualDate;
        }

        /**
         * Sets the value of the actualDate property.
         * 
         * @param value
         *     allowed object is
         *     {@link XMLGregorianCalendar }
         *     
         */
        public void setActualDate(XMLGregorianCalendar value) {
            this.actualDate = value;
        }

        /**
         * Gets the value of the rsoActualDATA property.
         * 
         * @return
         *     possible object is
         *     {@link ImportRSORequest.RSO.RSOActualDATA }
         *     
         */
        public ImportRSORequest.RSO.RSOActualDATA getRSOActualDATA() {
            return rsoActualDATA;
        }

        /**
         * Sets the value of the rsoActualDATA property.
         * 
         * @param value
         *     allowed object is
         *     {@link ImportRSORequest.RSO.RSOActualDATA }
         *     
         */
        public void setRSOActualDATA(ImportRSORequest.RSO.RSOActualDATA value) {
            this.rsoActualDATA = value;
        }

        /**
         * Gets the value of the removeRSO property.
         * 
         * @return
         *     possible object is
         *     {@link ImportRSORequest.RSO.RemoveRSO }
         *     
         */
        public ImportRSORequest.RSO.RemoveRSO getRemoveRSO() {
            return removeRSO;
        }

        /**
         * Sets the value of the removeRSO property.
         * 
         * @param value
         *     allowed object is
         *     {@link ImportRSORequest.RSO.RemoveRSO }
         *     
         */
        public void setRemoveRSO(ImportRSORequest.RSO.RemoveRSO value) {
            this.removeRSO = value;
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
         *         &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/organizations-base/}INN"/>
         *         &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/organizations-base/}KPP" minOccurs="0"/>
         *         &lt;element name="Name">
         *           &lt;simpleType>
         *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
         *               &lt;minLength value="1"/>
         *               &lt;maxLength value="255"/>
         *             &lt;/restriction>
         *           &lt;/simpleType>
         *         &lt;/element>
         *         &lt;element name="IsEntpr" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
         *         &lt;choice minOccurs="0">
         *           &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/organizations-base/}OGRN"/>
         *           &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/organizations-base/}OGRNIP"/>
         *         &lt;/choice>
         *         &lt;element name="Resource" maxOccurs="unbounded">
         *           &lt;complexType>
         *             &lt;complexContent>
         *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *                 &lt;sequence>
         *                   &lt;element name="ResourseType" type="{http://dom.gosuslugi.ru/schema/integration/fas/}ResourseType"/>
         *                   &lt;element name="OKTMO" type="{http://dom.gosuslugi.ru/schema/integration/base/}OKTMORefType" maxOccurs="unbounded"/>
         *                 &lt;/sequence>
         *               &lt;/restriction>
         *             &lt;/complexContent>
         *           &lt;/complexType>
         *         &lt;/element>
         *         &lt;element name="RegistryOfNaturalMonopolies" minOccurs="0">
         *           &lt;complexType>
         *             &lt;complexContent>
         *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *                 &lt;sequence>
         *                   &lt;element name="Number">
         *                     &lt;simpleType>
         *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
         *                         &lt;minLength value="1"/>
         *                         &lt;maxLength value="50"/>
         *                       &lt;/restriction>
         *                     &lt;/simpleType>
         *                   &lt;/element>
         *                   &lt;element name="Date" type="{http://www.w3.org/2001/XMLSchema}date"/>
         *                 &lt;/sequence>
         *               &lt;/restriction>
         *             &lt;/complexContent>
         *           &lt;/complexType>
         *         &lt;/element>
         *         &lt;element name="RegistryGuaranteeingSuppliers" minOccurs="0">
         *           &lt;complexType>
         *             &lt;complexContent>
         *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *                 &lt;sequence>
         *                   &lt;element name="Number">
         *                     &lt;simpleType>
         *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
         *                         &lt;minLength value="1"/>
         *                         &lt;maxLength value="50"/>
         *                       &lt;/restriction>
         *                     &lt;/simpleType>
         *                   &lt;/element>
         *                   &lt;element name="Date" type="{http://www.w3.org/2001/XMLSchema}date"/>
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
            "inn",
            "kpp",
            "name",
            "isEntpr",
            "ogrn",
            "ogrnip",
            "resource",
            "registryOfNaturalMonopolies",
            "registryGuaranteeingSuppliers"
        })
        public static class RSOActualDATA {

            @XmlElement(name = "INN", namespace = "http://dom.gosuslugi.ru/schema/integration/organizations-base/", required = true)
            protected String inn;
            @XmlElement(name = "KPP", namespace = "http://dom.gosuslugi.ru/schema/integration/organizations-base/")
            protected String kpp;
            @XmlElement(name = "Name", required = true)
            protected String name;
            @XmlElement(name = "IsEntpr")
            protected boolean isEntpr;
            @XmlElement(name = "OGRN", namespace = "http://dom.gosuslugi.ru/schema/integration/organizations-base/")
            protected String ogrn;
            @XmlElement(name = "OGRNIP", namespace = "http://dom.gosuslugi.ru/schema/integration/organizations-base/")
            protected String ogrnip;
            @XmlElement(name = "Resource", required = true)
            protected List<ImportRSORequest.RSO.RSOActualDATA.Resource> resource;
            @XmlElement(name = "RegistryOfNaturalMonopolies")
            protected ImportRSORequest.RSO.RSOActualDATA.RegistryOfNaturalMonopolies registryOfNaturalMonopolies;
            @XmlElement(name = "RegistryGuaranteeingSuppliers")
            protected ImportRSORequest.RSO.RSOActualDATA.RegistryGuaranteeingSuppliers registryGuaranteeingSuppliers;

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

            /**
             * Gets the value of the isEntpr property.
             * 
             */
            public boolean isIsEntpr() {
                return isEntpr;
            }

            /**
             * Sets the value of the isEntpr property.
             * 
             */
            public void setIsEntpr(boolean value) {
                this.isEntpr = value;
            }

            /**
             * Gets the value of the ogrn property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getOGRN() {
                return ogrn;
            }

            /**
             * Sets the value of the ogrn property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setOGRN(String value) {
                this.ogrn = value;
            }

            /**
             * Gets the value of the ogrnip property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getOGRNIP() {
                return ogrnip;
            }

            /**
             * Sets the value of the ogrnip property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setOGRNIP(String value) {
                this.ogrnip = value;
            }

            /**
             * Gets the value of the resource property.
             * 
             * <p>
             * This accessor method returns a reference to the live list,
             * not a snapshot. Therefore any modification you make to the
             * returned list will be present inside the JAXB object.
             * This is why there is not a <CODE>set</CODE> method for the resource property.
             * 
             * <p>
             * For example, to add a new item, do as follows:
             * <pre>
             *    getResource().add(newItem);
             * </pre>
             * 
             * 
             * <p>
             * Objects of the following type(s) are allowed in the list
             * {@link ImportRSORequest.RSO.RSOActualDATA.Resource }
             * 
             * 
             */
            public List<ImportRSORequest.RSO.RSOActualDATA.Resource> getResource() {
                if (resource == null) {
                    resource = new ArrayList<ImportRSORequest.RSO.RSOActualDATA.Resource>();
                }
                return this.resource;
            }

            /**
             * Gets the value of the registryOfNaturalMonopolies property.
             * 
             * @return
             *     possible object is
             *     {@link ImportRSORequest.RSO.RSOActualDATA.RegistryOfNaturalMonopolies }
             *     
             */
            public ImportRSORequest.RSO.RSOActualDATA.RegistryOfNaturalMonopolies getRegistryOfNaturalMonopolies() {
                return registryOfNaturalMonopolies;
            }

            /**
             * Sets the value of the registryOfNaturalMonopolies property.
             * 
             * @param value
             *     allowed object is
             *     {@link ImportRSORequest.RSO.RSOActualDATA.RegistryOfNaturalMonopolies }
             *     
             */
            public void setRegistryOfNaturalMonopolies(ImportRSORequest.RSO.RSOActualDATA.RegistryOfNaturalMonopolies value) {
                this.registryOfNaturalMonopolies = value;
            }

            /**
             * Gets the value of the registryGuaranteeingSuppliers property.
             * 
             * @return
             *     possible object is
             *     {@link ImportRSORequest.RSO.RSOActualDATA.RegistryGuaranteeingSuppliers }
             *     
             */
            public ImportRSORequest.RSO.RSOActualDATA.RegistryGuaranteeingSuppliers getRegistryGuaranteeingSuppliers() {
                return registryGuaranteeingSuppliers;
            }

            /**
             * Sets the value of the registryGuaranteeingSuppliers property.
             * 
             * @param value
             *     allowed object is
             *     {@link ImportRSORequest.RSO.RSOActualDATA.RegistryGuaranteeingSuppliers }
             *     
             */
            public void setRegistryGuaranteeingSuppliers(ImportRSORequest.RSO.RSOActualDATA.RegistryGuaranteeingSuppliers value) {
                this.registryGuaranteeingSuppliers = value;
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
             *         &lt;element name="Number">
             *           &lt;simpleType>
             *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
             *               &lt;minLength value="1"/>
             *               &lt;maxLength value="50"/>
             *             &lt;/restriction>
             *           &lt;/simpleType>
             *         &lt;/element>
             *         &lt;element name="Date" type="{http://www.w3.org/2001/XMLSchema}date"/>
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
                "number",
                "date"
            })
            public static class RegistryGuaranteeingSuppliers {

                @XmlElement(name = "Number", required = true)
                protected String number;
                @XmlElement(name = "Date", required = true)
                @XmlSchemaType(name = "date")
                protected XMLGregorianCalendar date;

                /**
                 * Gets the value of the number property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getNumber() {
                    return number;
                }

                /**
                 * Sets the value of the number property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setNumber(String value) {
                    this.number = value;
                }

                /**
                 * Gets the value of the date property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link XMLGregorianCalendar }
                 *     
                 */
                public XMLGregorianCalendar getDate() {
                    return date;
                }

                /**
                 * Sets the value of the date property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link XMLGregorianCalendar }
                 *     
                 */
                public void setDate(XMLGregorianCalendar value) {
                    this.date = value;
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
             *         &lt;element name="Number">
             *           &lt;simpleType>
             *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
             *               &lt;minLength value="1"/>
             *               &lt;maxLength value="50"/>
             *             &lt;/restriction>
             *           &lt;/simpleType>
             *         &lt;/element>
             *         &lt;element name="Date" type="{http://www.w3.org/2001/XMLSchema}date"/>
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
                "number",
                "date"
            })
            public static class RegistryOfNaturalMonopolies {

                @XmlElement(name = "Number", required = true)
                protected String number;
                @XmlElement(name = "Date", required = true)
                @XmlSchemaType(name = "date")
                protected XMLGregorianCalendar date;

                /**
                 * Gets the value of the number property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getNumber() {
                    return number;
                }

                /**
                 * Sets the value of the number property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setNumber(String value) {
                    this.number = value;
                }

                /**
                 * Gets the value of the date property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link XMLGregorianCalendar }
                 *     
                 */
                public XMLGregorianCalendar getDate() {
                    return date;
                }

                /**
                 * Sets the value of the date property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link XMLGregorianCalendar }
                 *     
                 */
                public void setDate(XMLGregorianCalendar value) {
                    this.date = value;
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
             *         &lt;element name="ResourseType" type="{http://dom.gosuslugi.ru/schema/integration/fas/}ResourseType"/>
             *         &lt;element name="OKTMO" type="{http://dom.gosuslugi.ru/schema/integration/base/}OKTMORefType" maxOccurs="unbounded"/>
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
                "resourseType",
                "oktmo"
            })
            public static class Resource {

                @XmlElement(name = "ResourseType", required = true)
                protected String resourseType;
                @XmlElement(name = "OKTMO", required = true)
                protected List<OKTMORefType> oktmo;

                /**
                 * Gets the value of the resourseType property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getResourseType() {
                    return resourseType;
                }

                /**
                 * Sets the value of the resourseType property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setResourseType(String value) {
                    this.resourseType = value;
                }

                /**
                 * Gets the value of the oktmo property.
                 * 
                 * <p>
                 * This accessor method returns a reference to the live list,
                 * not a snapshot. Therefore any modification you make to the
                 * returned list will be present inside the JAXB object.
                 * This is why there is not a <CODE>set</CODE> method for the oktmo property.
                 * 
                 * <p>
                 * For example, to add a new item, do as follows:
                 * <pre>
                 *    getOKTMO().add(newItem);
                 * </pre>
                 * 
                 * 
                 * <p>
                 * Objects of the following type(s) are allowed in the list
                 * {@link OKTMORefType }
                 * 
                 * 
                 */
                public List<OKTMORefType> getOKTMO() {
                    if (oktmo == null) {
                        oktmo = new ArrayList<OKTMORefType>();
                    }
                    return this.oktmo;
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
         *         &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/organizations-base/}INN"/>
         *         &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/organizations-base/}KPP"/>
         *         &lt;choice minOccurs="0">
         *           &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/organizations-base/}OGRN"/>
         *           &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/organizations-base/}OGRNIP"/>
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
            "inn",
            "kpp",
            "ogrn",
            "ogrnip"
        })
        public static class RemoveRSO {

            @XmlElement(name = "INN", namespace = "http://dom.gosuslugi.ru/schema/integration/organizations-base/", required = true)
            protected String inn;
            @XmlElement(name = "KPP", namespace = "http://dom.gosuslugi.ru/schema/integration/organizations-base/", required = true)
            protected String kpp;
            @XmlElement(name = "OGRN", namespace = "http://dom.gosuslugi.ru/schema/integration/organizations-base/")
            protected String ogrn;
            @XmlElement(name = "OGRNIP", namespace = "http://dom.gosuslugi.ru/schema/integration/organizations-base/")
            protected String ogrnip;

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
             * Gets the value of the ogrn property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getOGRN() {
                return ogrn;
            }

            /**
             * Sets the value of the ogrn property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setOGRN(String value) {
                this.ogrn = value;
            }

            /**
             * Gets the value of the ogrnip property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getOGRNIP() {
                return ogrnip;
            }

            /**
             * Sets the value of the ogrnip property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setOGRNIP(String value) {
                this.ogrnip = value;
            }

        }

    }

}
