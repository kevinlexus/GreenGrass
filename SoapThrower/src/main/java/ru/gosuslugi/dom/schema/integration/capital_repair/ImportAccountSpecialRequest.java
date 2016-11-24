
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
 *         &lt;element name="importAccountSpecial" maxOccurs="1000">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="TransportGuid" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType"/>
 *                   &lt;element name="AccountSpecialGuid" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType"/>
 *                   &lt;choice>
 *                     &lt;element name="LoadChangeAccountSpecial">
 *                       &lt;complexType>
 *                         &lt;complexContent>
 *                           &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/capital-repair/}AccountType">
 *                             &lt;sequence>
 *                               &lt;element name="ChangeDate" type="{http://www.w3.org/2001/XMLSchema}date"/>
 *                             &lt;/sequence>
 *                           &lt;/extension>
 *                         &lt;/complexContent>
 *                       &lt;/complexType>
 *                     &lt;/element>
 *                     &lt;element name="CloseAccountSpecial">
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
    "importAccountSpecial"
})
@XmlRootElement(name = "importAccountSpecialRequest")
public class ImportAccountSpecialRequest
    extends BaseType
{

    @XmlElement(required = true)
    protected List<ImportAccountSpecialRequest.ImportAccountSpecial> importAccountSpecial;
    @XmlAttribute(name = "version", namespace = "http://dom.gosuslugi.ru/schema/integration/base/", required = true)
    protected String version;

    /**
     * Gets the value of the importAccountSpecial property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the importAccountSpecial property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getImportAccountSpecial().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ImportAccountSpecialRequest.ImportAccountSpecial }
     * 
     * 
     */
    public List<ImportAccountSpecialRequest.ImportAccountSpecial> getImportAccountSpecial() {
        if (importAccountSpecial == null) {
            importAccountSpecial = new ArrayList<ImportAccountSpecialRequest.ImportAccountSpecial>();
        }
        return this.importAccountSpecial;
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
     *         &lt;element name="AccountSpecialGuid" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType"/>
     *         &lt;choice>
     *           &lt;element name="LoadChangeAccountSpecial">
     *             &lt;complexType>
     *               &lt;complexContent>
     *                 &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/capital-repair/}AccountType">
     *                   &lt;sequence>
     *                     &lt;element name="ChangeDate" type="{http://www.w3.org/2001/XMLSchema}date"/>
     *                   &lt;/sequence>
     *                 &lt;/extension>
     *               &lt;/complexContent>
     *             &lt;/complexType>
     *           &lt;/element>
     *           &lt;element name="CloseAccountSpecial">
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
        "accountSpecialGuid",
        "loadChangeAccountSpecial",
        "closeAccountSpecial"
    })
    public static class ImportAccountSpecial {

        @XmlElement(name = "TransportGuid", required = true)
        protected String transportGuid;
        @XmlElement(name = "AccountSpecialGuid", required = true)
        protected String accountSpecialGuid;
        @XmlElement(name = "LoadChangeAccountSpecial")
        protected ImportAccountSpecialRequest.ImportAccountSpecial.LoadChangeAccountSpecial loadChangeAccountSpecial;
        @XmlElement(name = "CloseAccountSpecial")
        protected ImportAccountSpecialRequest.ImportAccountSpecial.CloseAccountSpecial closeAccountSpecial;

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
         * Gets the value of the accountSpecialGuid property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getAccountSpecialGuid() {
            return accountSpecialGuid;
        }

        /**
         * Sets the value of the accountSpecialGuid property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setAccountSpecialGuid(String value) {
            this.accountSpecialGuid = value;
        }

        /**
         * Gets the value of the loadChangeAccountSpecial property.
         * 
         * @return
         *     possible object is
         *     {@link ImportAccountSpecialRequest.ImportAccountSpecial.LoadChangeAccountSpecial }
         *     
         */
        public ImportAccountSpecialRequest.ImportAccountSpecial.LoadChangeAccountSpecial getLoadChangeAccountSpecial() {
            return loadChangeAccountSpecial;
        }

        /**
         * Sets the value of the loadChangeAccountSpecial property.
         * 
         * @param value
         *     allowed object is
         *     {@link ImportAccountSpecialRequest.ImportAccountSpecial.LoadChangeAccountSpecial }
         *     
         */
        public void setLoadChangeAccountSpecial(ImportAccountSpecialRequest.ImportAccountSpecial.LoadChangeAccountSpecial value) {
            this.loadChangeAccountSpecial = value;
        }

        /**
         * Gets the value of the closeAccountSpecial property.
         * 
         * @return
         *     possible object is
         *     {@link ImportAccountSpecialRequest.ImportAccountSpecial.CloseAccountSpecial }
         *     
         */
        public ImportAccountSpecialRequest.ImportAccountSpecial.CloseAccountSpecial getCloseAccountSpecial() {
            return closeAccountSpecial;
        }

        /**
         * Sets the value of the closeAccountSpecial property.
         * 
         * @param value
         *     allowed object is
         *     {@link ImportAccountSpecialRequest.ImportAccountSpecial.CloseAccountSpecial }
         *     
         */
        public void setCloseAccountSpecial(ImportAccountSpecialRequest.ImportAccountSpecial.CloseAccountSpecial value) {
            this.closeAccountSpecial = value;
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
        public static class CloseAccountSpecial {

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
         *         &lt;element name="ChangeDate" type="{http://www.w3.org/2001/XMLSchema}date"/>
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
            "changeDate"
        })
        public static class LoadChangeAccountSpecial
            extends AccountType
        {

            @XmlElement(name = "ChangeDate", required = true)
            @XmlSchemaType(name = "date")
            protected XMLGregorianCalendar changeDate;

            /**
             * Gets the value of the changeDate property.
             * 
             * @return
             *     possible object is
             *     {@link XMLGregorianCalendar }
             *     
             */
            public XMLGregorianCalendar getChangeDate() {
                return changeDate;
            }

            /**
             * Sets the value of the changeDate property.
             * 
             * @param value
             *     allowed object is
             *     {@link XMLGregorianCalendar }
             *     
             */
            public void setChangeDate(XMLGregorianCalendar value) {
                this.changeDate = value;
            }

        }

    }

}
