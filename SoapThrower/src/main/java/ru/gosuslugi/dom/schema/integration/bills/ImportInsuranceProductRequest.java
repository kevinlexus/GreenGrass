
package ru.gosuslugi.dom.schema.integration.bills;

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
 *         &lt;element name="InsuranceProduct" maxOccurs="1000">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/base/}TransportGUID"/>
 *                   &lt;choice>
 *                     &lt;element name="CreateOrUpdate">
 *                       &lt;complexType>
 *                         &lt;complexContent>
 *                           &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/bills/}InsuranceProductType">
 *                             &lt;sequence>
 *                               &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/bills/}InsuranceProductGUID" minOccurs="0"/>
 *                             &lt;/sequence>
 *                           &lt;/extension>
 *                         &lt;/complexContent>
 *                       &lt;/complexType>
 *                     &lt;/element>
 *                     &lt;element name="Remove">
 *                       &lt;complexType>
 *                         &lt;complexContent>
 *                           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                             &lt;sequence>
 *                               &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/bills/}InsuranceProductGUID"/>
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
 *       &lt;attribute ref="{http://dom.gosuslugi.ru/schema/integration/base/}version use="required" fixed="10.0.2.1""/>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "insuranceProduct"
})
@XmlRootElement(name = "importInsuranceProductRequest")
public class ImportInsuranceProductRequest
    extends BaseType
{

    @XmlElement(name = "InsuranceProduct", required = true)
    protected List<ImportInsuranceProductRequest.InsuranceProduct> insuranceProduct;
    @XmlAttribute(name = "version", namespace = "http://dom.gosuslugi.ru/schema/integration/base/", required = true)
    protected String version;

    /**
     * Gets the value of the insuranceProduct property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the insuranceProduct property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getInsuranceProduct().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ImportInsuranceProductRequest.InsuranceProduct }
     * 
     * 
     */
    public List<ImportInsuranceProductRequest.InsuranceProduct> getInsuranceProduct() {
        if (insuranceProduct == null) {
            insuranceProduct = new ArrayList<ImportInsuranceProductRequest.InsuranceProduct>();
        }
        return this.insuranceProduct;
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
            return "10.0.2.1";
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
     *           &lt;element name="CreateOrUpdate">
     *             &lt;complexType>
     *               &lt;complexContent>
     *                 &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/bills/}InsuranceProductType">
     *                   &lt;sequence>
     *                     &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/bills/}InsuranceProductGUID" minOccurs="0"/>
     *                   &lt;/sequence>
     *                 &lt;/extension>
     *               &lt;/complexContent>
     *             &lt;/complexType>
     *           &lt;/element>
     *           &lt;element name="Remove">
     *             &lt;complexType>
     *               &lt;complexContent>
     *                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                   &lt;sequence>
     *                     &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/bills/}InsuranceProductGUID"/>
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
        "transportGUID",
        "createOrUpdate",
        "remove"
    })
    public static class InsuranceProduct {

        @XmlElement(name = "TransportGUID", namespace = "http://dom.gosuslugi.ru/schema/integration/base/", required = true)
        protected String transportGUID;
        @XmlElement(name = "CreateOrUpdate")
        protected ImportInsuranceProductRequest.InsuranceProduct.CreateOrUpdate createOrUpdate;
        @XmlElement(name = "Remove")
        protected ImportInsuranceProductRequest.InsuranceProduct.Remove remove;

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
         * Gets the value of the createOrUpdate property.
         * 
         * @return
         *     possible object is
         *     {@link ImportInsuranceProductRequest.InsuranceProduct.CreateOrUpdate }
         *     
         */
        public ImportInsuranceProductRequest.InsuranceProduct.CreateOrUpdate getCreateOrUpdate() {
            return createOrUpdate;
        }

        /**
         * Sets the value of the createOrUpdate property.
         * 
         * @param value
         *     allowed object is
         *     {@link ImportInsuranceProductRequest.InsuranceProduct.CreateOrUpdate }
         *     
         */
        public void setCreateOrUpdate(ImportInsuranceProductRequest.InsuranceProduct.CreateOrUpdate value) {
            this.createOrUpdate = value;
        }

        /**
         * Gets the value of the remove property.
         * 
         * @return
         *     possible object is
         *     {@link ImportInsuranceProductRequest.InsuranceProduct.Remove }
         *     
         */
        public ImportInsuranceProductRequest.InsuranceProduct.Remove getRemove() {
            return remove;
        }

        /**
         * Sets the value of the remove property.
         * 
         * @param value
         *     allowed object is
         *     {@link ImportInsuranceProductRequest.InsuranceProduct.Remove }
         *     
         */
        public void setRemove(ImportInsuranceProductRequest.InsuranceProduct.Remove value) {
            this.remove = value;
        }


        /**
         * <p>Java class for anonymous complex type.
         * 
         * <p>The following schema fragment specifies the expected content contained within this class.
         * 
         * <pre>
         * &lt;complexType>
         *   &lt;complexContent>
         *     &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/bills/}InsuranceProductType">
         *       &lt;sequence>
         *         &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/bills/}InsuranceProductGUID" minOccurs="0"/>
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
            "insuranceProductGUID"
        })
        public static class CreateOrUpdate
            extends InsuranceProductType
        {

            @XmlElement(name = "InsuranceProductGUID")
            protected String insuranceProductGUID;

            /**
             * Gets the value of the insuranceProductGUID property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getInsuranceProductGUID() {
                return insuranceProductGUID;
            }

            /**
             * Sets the value of the insuranceProductGUID property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setInsuranceProductGUID(String value) {
                this.insuranceProductGUID = value;
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
         *         &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/bills/}InsuranceProductGUID"/>
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
            "insuranceProductGUID",
            "closeDate"
        })
        public static class Remove {

            @XmlElement(name = "InsuranceProductGUID", required = true)
            protected String insuranceProductGUID;
            @XmlElement(name = "CloseDate", required = true)
            @XmlSchemaType(name = "date")
            protected XMLGregorianCalendar closeDate;

            /**
             * Gets the value of the insuranceProductGUID property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getInsuranceProductGUID() {
                return insuranceProductGUID;
            }

            /**
             * Sets the value of the insuranceProductGUID property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setInsuranceProductGUID(String value) {
                this.insuranceProductGUID = value;
            }

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

    }

}
