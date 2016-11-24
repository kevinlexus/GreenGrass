
package ru.gosuslugi.dom.schema.integration.capital_repair;

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
 *         &lt;element name="importAccountRegOperator" maxOccurs="1000">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="TransportGuid" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType"/>
 *                   &lt;element name="AccountRegOperatorGuid" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType" minOccurs="0"/>
 *                   &lt;choice>
 *                     &lt;element name="LoadAccountRegOperator">
 *                       &lt;complexType>
 *                         &lt;complexContent>
 *                           &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/capital-repair/}AccountType">
 *                             &lt;sequence>
 *                               &lt;element name="OpenDate" type="{http://www.w3.org/2001/XMLSchema}date"/>
 *                             &lt;/sequence>
 *                           &lt;/extension>
 *                         &lt;/complexContent>
 *                       &lt;/complexType>
 *                     &lt;/element>
 *                     &lt;element name="CloseAccountRegOperator">
 *                       &lt;complexType>
 *                         &lt;complexContent>
 *                           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                             &lt;sequence>
 *                               &lt;element name="CloseDate" type="{http://www.w3.org/2001/XMLSchema}date"/>
 *                             &lt;/sequence>
 *                           &lt;/restriction>
 *                         &lt;/complexContent>
 *                       &lt;/complexType>
 *                     &lt;/element>
 *                     &lt;element name="CancelAccountRegOperator" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
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
    "importAccountRegOperator"
})
@XmlRootElement(name = "importAccountRegionalOperatorRequest")
public class ImportAccountRegionalOperatorRequest
    extends BaseType
{

    @XmlElement(required = true)
    protected List<ImportAccountRegionalOperatorRequest.ImportAccountRegOperator> importAccountRegOperator;
    @XmlAttribute(name = "version", namespace = "http://dom.gosuslugi.ru/schema/integration/base/", required = true)
    protected String version;

    /**
     * Gets the value of the importAccountRegOperator property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the importAccountRegOperator property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getImportAccountRegOperator().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ImportAccountRegionalOperatorRequest.ImportAccountRegOperator }
     * 
     * 
     */
    public List<ImportAccountRegionalOperatorRequest.ImportAccountRegOperator> getImportAccountRegOperator() {
        if (importAccountRegOperator == null) {
            importAccountRegOperator = new ArrayList<ImportAccountRegionalOperatorRequest.ImportAccountRegOperator>();
        }
        return this.importAccountRegOperator;
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
     *         &lt;element name="TransportGuid" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType"/>
     *         &lt;element name="AccountRegOperatorGuid" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType" minOccurs="0"/>
     *         &lt;choice>
     *           &lt;element name="LoadAccountRegOperator">
     *             &lt;complexType>
     *               &lt;complexContent>
     *                 &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/capital-repair/}AccountType">
     *                   &lt;sequence>
     *                     &lt;element name="OpenDate" type="{http://www.w3.org/2001/XMLSchema}date"/>
     *                   &lt;/sequence>
     *                 &lt;/extension>
     *               &lt;/complexContent>
     *             &lt;/complexType>
     *           &lt;/element>
     *           &lt;element name="CloseAccountRegOperator">
     *             &lt;complexType>
     *               &lt;complexContent>
     *                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                   &lt;sequence>
     *                     &lt;element name="CloseDate" type="{http://www.w3.org/2001/XMLSchema}date"/>
     *                   &lt;/sequence>
     *                 &lt;/restriction>
     *               &lt;/complexContent>
     *             &lt;/complexType>
     *           &lt;/element>
     *           &lt;element name="CancelAccountRegOperator" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
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
        "transportGuid",
        "accountRegOperatorGuid",
        "loadAccountRegOperator",
        "closeAccountRegOperator",
        "cancelAccountRegOperator"
    })
    public static class ImportAccountRegOperator {

        @XmlElement(name = "TransportGuid", required = true)
        protected String transportGuid;
        @XmlElement(name = "AccountRegOperatorGuid")
        protected String accountRegOperatorGuid;
        @XmlElement(name = "LoadAccountRegOperator")
        protected ImportAccountRegionalOperatorRequest.ImportAccountRegOperator.LoadAccountRegOperator loadAccountRegOperator;
        @XmlElement(name = "CloseAccountRegOperator")
        protected ImportAccountRegionalOperatorRequest.ImportAccountRegOperator.CloseAccountRegOperator closeAccountRegOperator;
        @XmlElement(name = "CancelAccountRegOperator")
        protected Boolean cancelAccountRegOperator;

        /**
         * Gets the value of the transportGuid property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getTransportGuid() {
            return transportGuid;
        }

        /**
         * Sets the value of the transportGuid property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setTransportGuid(String value) {
            this.transportGuid = value;
        }

        /**
         * Gets the value of the accountRegOperatorGuid property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getAccountRegOperatorGuid() {
            return accountRegOperatorGuid;
        }

        /**
         * Sets the value of the accountRegOperatorGuid property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setAccountRegOperatorGuid(String value) {
            this.accountRegOperatorGuid = value;
        }

        /**
         * Gets the value of the loadAccountRegOperator property.
         * 
         * @return
         *     possible object is
         *     {@link ImportAccountRegionalOperatorRequest.ImportAccountRegOperator.LoadAccountRegOperator }
         *     
         */
        public ImportAccountRegionalOperatorRequest.ImportAccountRegOperator.LoadAccountRegOperator getLoadAccountRegOperator() {
            return loadAccountRegOperator;
        }

        /**
         * Sets the value of the loadAccountRegOperator property.
         * 
         * @param value
         *     allowed object is
         *     {@link ImportAccountRegionalOperatorRequest.ImportAccountRegOperator.LoadAccountRegOperator }
         *     
         */
        public void setLoadAccountRegOperator(ImportAccountRegionalOperatorRequest.ImportAccountRegOperator.LoadAccountRegOperator value) {
            this.loadAccountRegOperator = value;
        }

        /**
         * Gets the value of the closeAccountRegOperator property.
         * 
         * @return
         *     possible object is
         *     {@link ImportAccountRegionalOperatorRequest.ImportAccountRegOperator.CloseAccountRegOperator }
         *     
         */
        public ImportAccountRegionalOperatorRequest.ImportAccountRegOperator.CloseAccountRegOperator getCloseAccountRegOperator() {
            return closeAccountRegOperator;
        }

        /**
         * Sets the value of the closeAccountRegOperator property.
         * 
         * @param value
         *     allowed object is
         *     {@link ImportAccountRegionalOperatorRequest.ImportAccountRegOperator.CloseAccountRegOperator }
         *     
         */
        public void setCloseAccountRegOperator(ImportAccountRegionalOperatorRequest.ImportAccountRegOperator.CloseAccountRegOperator value) {
            this.closeAccountRegOperator = value;
        }

        /**
         * Gets the value of the cancelAccountRegOperator property.
         * 
         * @return
         *     possible object is
         *     {@link Boolean }
         *     
         */
        public Boolean isCancelAccountRegOperator() {
            return cancelAccountRegOperator;
        }

        /**
         * Sets the value of the cancelAccountRegOperator property.
         * 
         * @param value
         *     allowed object is
         *     {@link Boolean }
         *     
         */
        public void setCancelAccountRegOperator(Boolean value) {
            this.cancelAccountRegOperator = value;
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
         *         &lt;element name="CloseDate" type="{http://www.w3.org/2001/XMLSchema}date"/>
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
            "closeDate"
        })
        public static class CloseAccountRegOperator {

            @XmlElement(name = "CloseDate", required = true)
            @XmlSchemaType(name = "date")
            protected XMLGregorianCalendar closeDate;

            /**
             * Gets the value of the closeDate property.
             * 
             * @return
             *     possible object is
             *     {@link XMLGregorianCalendar }
             *     
             */
            public XMLGregorianCalendar getCloseDate() {
                return closeDate;
            }

            /**
             * Sets the value of the closeDate property.
             * 
             * @param value
             *     allowed object is
             *     {@link XMLGregorianCalendar }
             *     
             */
            public void setCloseDate(XMLGregorianCalendar value) {
                this.closeDate = value;
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
         *     &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/capital-repair/}AccountType">
         *       &lt;sequence>
         *         &lt;element name="OpenDate" type="{http://www.w3.org/2001/XMLSchema}date"/>
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
            "openDate"
        })
        public static class LoadAccountRegOperator
            extends AccountType
        {

            @XmlElement(name = "OpenDate", required = true)
            @XmlSchemaType(name = "date")
            protected XMLGregorianCalendar openDate;

            /**
             * Gets the value of the openDate property.
             * 
             * @return
             *     possible object is
             *     {@link XMLGregorianCalendar }
             *     
             */
            public XMLGregorianCalendar getOpenDate() {
                return openDate;
            }

            /**
             * Sets the value of the openDate property.
             * 
             * @param value
             *     allowed object is
             *     {@link XMLGregorianCalendar }
             *     
             */
            public void setOpenDate(XMLGregorianCalendar value) {
                this.openDate = value;
            }

        }

    }

}
