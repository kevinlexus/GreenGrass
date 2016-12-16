
package ru.gosuslugi.dom.schema.integration.msp;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
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
 *         &lt;element name="importCitizenSubsidy" maxOccurs="1000">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="CitizenSubsidyGuid" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType" minOccurs="0"/>
 *                   &lt;sequence minOccurs="0">
 *                     &lt;element name="TransportGuid" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType"/>
 *                     &lt;choice>
 *                       &lt;element name="LoadOverview" type="{http://dom.gosuslugi.ru/schema/integration/msp/}CitizenSubsidyOverviewType"/>
 *                       &lt;element name="Cancel" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *                     &lt;/choice>
 *                   &lt;/sequence>
 *                   &lt;element name="Calculation" maxOccurs="1000" minOccurs="0">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="TransportGuid" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType"/>
 *                             &lt;element name="CalculationGuid" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType" minOccurs="0"/>
 *                             &lt;choice>
 *                               &lt;element name="LoadCalculation" type="{http://dom.gosuslugi.ru/schema/integration/msp/}CitizenSubsidyCalculationType"/>
 *                               &lt;element name="Cancel" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *                             &lt;/choice>
 *                           &lt;/sequence>
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                   &lt;element name="Payment" maxOccurs="1000" minOccurs="0">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="TransportGuid" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType"/>
 *                             &lt;element name="PaymentGuid" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType" minOccurs="0"/>
 *                             &lt;choice>
 *                               &lt;element name="LoadPayment" type="{http://dom.gosuslugi.ru/schema/integration/msp/}PaymentType"/>
 *                               &lt;element name="Cancel" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *                             &lt;/choice>
 *                           &lt;/sequence>
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
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
    "importCitizenSubsidy"
})
@XmlRootElement(name = "importCitizenSubsidyRequest")
public class ImportCitizenSubsidyRequest
    extends BaseType
{

    @XmlElement(required = true)
    protected List<ImportCitizenSubsidyRequest.ImportCitizenSubsidy> importCitizenSubsidy;
    @XmlAttribute(name = "version", namespace = "http://dom.gosuslugi.ru/schema/integration/base/", required = true)
    protected String version;

    /**
     * Gets the value of the importCitizenSubsidy property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the importCitizenSubsidy property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getImportCitizenSubsidy().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ImportCitizenSubsidyRequest.ImportCitizenSubsidy }
     * 
     * 
     */
    public List<ImportCitizenSubsidyRequest.ImportCitizenSubsidy> getImportCitizenSubsidy() {
        if (importCitizenSubsidy == null) {
            importCitizenSubsidy = new ArrayList<ImportCitizenSubsidyRequest.ImportCitizenSubsidy>();
        }
        return this.importCitizenSubsidy;
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
     *         &lt;element name="CitizenSubsidyGuid" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType" minOccurs="0"/>
     *         &lt;sequence minOccurs="0">
     *           &lt;element name="TransportGuid" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType"/>
     *           &lt;choice>
     *             &lt;element name="LoadOverview" type="{http://dom.gosuslugi.ru/schema/integration/msp/}CitizenSubsidyOverviewType"/>
     *             &lt;element name="Cancel" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
     *           &lt;/choice>
     *         &lt;/sequence>
     *         &lt;element name="Calculation" maxOccurs="1000" minOccurs="0">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element name="TransportGuid" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType"/>
     *                   &lt;element name="CalculationGuid" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType" minOccurs="0"/>
     *                   &lt;choice>
     *                     &lt;element name="LoadCalculation" type="{http://dom.gosuslugi.ru/schema/integration/msp/}CitizenSubsidyCalculationType"/>
     *                     &lt;element name="Cancel" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
     *                   &lt;/choice>
     *                 &lt;/sequence>
     *               &lt;/restriction>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *         &lt;element name="Payment" maxOccurs="1000" minOccurs="0">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element name="TransportGuid" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType"/>
     *                   &lt;element name="PaymentGuid" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType" minOccurs="0"/>
     *                   &lt;choice>
     *                     &lt;element name="LoadPayment" type="{http://dom.gosuslugi.ru/schema/integration/msp/}PaymentType"/>
     *                     &lt;element name="Cancel" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
     *                   &lt;/choice>
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
        "citizenSubsidyGuid",
        "transportGuid",
        "loadOverview",
        "cancel",
        "calculation",
        "payment"
    })
    public static class ImportCitizenSubsidy {

        @XmlElement(name = "CitizenSubsidyGuid")
        protected String citizenSubsidyGuid;
        @XmlElement(name = "TransportGuid")
        protected String transportGuid;
        @XmlElement(name = "LoadOverview")
        protected CitizenSubsidyOverviewType loadOverview;
        @XmlElement(name = "Cancel")
        protected Boolean cancel;
        @XmlElement(name = "Calculation")
        protected List<ImportCitizenSubsidyRequest.ImportCitizenSubsidy.Calculation> calculation;
        @XmlElement(name = "Payment")
        protected List<ImportCitizenSubsidyRequest.ImportCitizenSubsidy.Payment> payment;

        /**
         * Gets the value of the citizenSubsidyGuid property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getCitizenSubsidyGuid() {
            return citizenSubsidyGuid;
        }

        /**
         * Sets the value of the citizenSubsidyGuid property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setCitizenSubsidyGuid(String value) {
            this.citizenSubsidyGuid = value;
        }

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
         * Gets the value of the loadOverview property.
         * 
         * @return
         *     possible object is
         *     {@link CitizenSubsidyOverviewType }
         *     
         */
        public CitizenSubsidyOverviewType getLoadOverview() {
            return loadOverview;
        }

        /**
         * Sets the value of the loadOverview property.
         * 
         * @param value
         *     allowed object is
         *     {@link CitizenSubsidyOverviewType }
         *     
         */
        public void setLoadOverview(CitizenSubsidyOverviewType value) {
            this.loadOverview = value;
        }

        /**
         * Gets the value of the cancel property.
         * 
         * @return
         *     possible object is
         *     {@link Boolean }
         *     
         */
        public Boolean isCancel() {
            return cancel;
        }

        /**
         * Sets the value of the cancel property.
         * 
         * @param value
         *     allowed object is
         *     {@link Boolean }
         *     
         */
        public void setCancel(Boolean value) {
            this.cancel = value;
        }

        /**
         * Gets the value of the calculation property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the calculation property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getCalculation().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link ImportCitizenSubsidyRequest.ImportCitizenSubsidy.Calculation }
         * 
         * 
         */
        public List<ImportCitizenSubsidyRequest.ImportCitizenSubsidy.Calculation> getCalculation() {
            if (calculation == null) {
                calculation = new ArrayList<ImportCitizenSubsidyRequest.ImportCitizenSubsidy.Calculation>();
            }
            return this.calculation;
        }

        /**
         * Gets the value of the payment property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the payment property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getPayment().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link ImportCitizenSubsidyRequest.ImportCitizenSubsidy.Payment }
         * 
         * 
         */
        public List<ImportCitizenSubsidyRequest.ImportCitizenSubsidy.Payment> getPayment() {
            if (payment == null) {
                payment = new ArrayList<ImportCitizenSubsidyRequest.ImportCitizenSubsidy.Payment>();
            }
            return this.payment;
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
         *         &lt;element name="CalculationGuid" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType" minOccurs="0"/>
         *         &lt;choice>
         *           &lt;element name="LoadCalculation" type="{http://dom.gosuslugi.ru/schema/integration/msp/}CitizenSubsidyCalculationType"/>
         *           &lt;element name="Cancel" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
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
            "calculationGuid",
            "loadCalculation",
            "cancel"
        })
        public static class Calculation {

            @XmlElement(name = "TransportGuid", required = true)
            protected String transportGuid;
            @XmlElement(name = "CalculationGuid")
            protected String calculationGuid;
            @XmlElement(name = "LoadCalculation")
            protected CitizenSubsidyCalculationType loadCalculation;
            @XmlElement(name = "Cancel")
            protected Boolean cancel;

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
             * Gets the value of the calculationGuid property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getCalculationGuid() {
                return calculationGuid;
            }

            /**
             * Sets the value of the calculationGuid property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setCalculationGuid(String value) {
                this.calculationGuid = value;
            }

            /**
             * Gets the value of the loadCalculation property.
             * 
             * @return
             *     possible object is
             *     {@link CitizenSubsidyCalculationType }
             *     
             */
            public CitizenSubsidyCalculationType getLoadCalculation() {
                return loadCalculation;
            }

            /**
             * Sets the value of the loadCalculation property.
             * 
             * @param value
             *     allowed object is
             *     {@link CitizenSubsidyCalculationType }
             *     
             */
            public void setLoadCalculation(CitizenSubsidyCalculationType value) {
                this.loadCalculation = value;
            }

            /**
             * Gets the value of the cancel property.
             * 
             * @return
             *     possible object is
             *     {@link Boolean }
             *     
             */
            public Boolean isCancel() {
                return cancel;
            }

            /**
             * Sets the value of the cancel property.
             * 
             * @param value
             *     allowed object is
             *     {@link Boolean }
             *     
             */
            public void setCancel(Boolean value) {
                this.cancel = value;
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
         *         &lt;element name="TransportGuid" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType"/>
         *         &lt;element name="PaymentGuid" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType" minOccurs="0"/>
         *         &lt;choice>
         *           &lt;element name="LoadPayment" type="{http://dom.gosuslugi.ru/schema/integration/msp/}PaymentType"/>
         *           &lt;element name="Cancel" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
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
            "paymentGuid",
            "loadPayment",
            "cancel"
        })
        public static class Payment {

            @XmlElement(name = "TransportGuid", required = true)
            protected String transportGuid;
            @XmlElement(name = "PaymentGuid")
            protected String paymentGuid;
            @XmlElement(name = "LoadPayment")
            protected PaymentType loadPayment;
            @XmlElement(name = "Cancel")
            protected Boolean cancel;

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
             * Gets the value of the paymentGuid property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getPaymentGuid() {
                return paymentGuid;
            }

            /**
             * Sets the value of the paymentGuid property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setPaymentGuid(String value) {
                this.paymentGuid = value;
            }

            /**
             * Gets the value of the loadPayment property.
             * 
             * @return
             *     possible object is
             *     {@link PaymentType }
             *     
             */
            public PaymentType getLoadPayment() {
                return loadPayment;
            }

            /**
             * Sets the value of the loadPayment property.
             * 
             * @param value
             *     allowed object is
             *     {@link PaymentType }
             *     
             */
            public void setLoadPayment(PaymentType value) {
                this.loadPayment = value;
            }

            /**
             * Gets the value of the cancel property.
             * 
             * @return
             *     possible object is
             *     {@link Boolean }
             *     
             */
            public Boolean isCancel() {
                return cancel;
            }

            /**
             * Sets the value of the cancel property.
             * 
             * @param value
             *     allowed object is
             *     {@link Boolean }
             *     
             */
            public void setCancel(Boolean value) {
                this.cancel = value;
            }

        }

    }

}
