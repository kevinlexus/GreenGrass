
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
 *         &lt;element name="importCitizenCompensation" maxOccurs="1000">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="CitizenCompensationGuid" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType" minOccurs="0"/>
 *                   &lt;sequence minOccurs="0">
 *                     &lt;element name="TransportGuid" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType"/>
 *                     &lt;choice>
 *                       &lt;element name="LoadOverview" type="{http://dom.gosuslugi.ru/schema/integration/msp/}CitizenCompensationOverviewType"/>
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
 *                               &lt;element name="LoadCalculations" type="{http://dom.gosuslugi.ru/schema/integration/msp/}CitizenCompensationCalculationType"/>
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
 *                               &lt;element name="LoadPayments" type="{http://dom.gosuslugi.ru/schema/integration/msp/}PaymentType"/>
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
    "importCitizenCompensation"
})
@XmlRootElement(name = "importCitizenCompensationRequest")
public class ImportCitizenCompensationRequest
    extends BaseType
{

    @XmlElement(required = true)
    protected List<ImportCitizenCompensationRequest.ImportCitizenCompensation> importCitizenCompensation;
    @XmlAttribute(name = "version", namespace = "http://dom.gosuslugi.ru/schema/integration/base/", required = true)
    protected String version;

    /**
     * Gets the value of the importCitizenCompensation property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the importCitizenCompensation property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getImportCitizenCompensation().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ImportCitizenCompensationRequest.ImportCitizenCompensation }
     * 
     * 
     */
    public List<ImportCitizenCompensationRequest.ImportCitizenCompensation> getImportCitizenCompensation() {
        if (importCitizenCompensation == null) {
            importCitizenCompensation = new ArrayList<ImportCitizenCompensationRequest.ImportCitizenCompensation>();
        }
        return this.importCitizenCompensation;
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
     *         &lt;element name="CitizenCompensationGuid" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType" minOccurs="0"/>
     *         &lt;sequence minOccurs="0">
     *           &lt;element name="TransportGuid" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType"/>
     *           &lt;choice>
     *             &lt;element name="LoadOverview" type="{http://dom.gosuslugi.ru/schema/integration/msp/}CitizenCompensationOverviewType"/>
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
     *                     &lt;element name="LoadCalculations" type="{http://dom.gosuslugi.ru/schema/integration/msp/}CitizenCompensationCalculationType"/>
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
     *                     &lt;element name="LoadPayments" type="{http://dom.gosuslugi.ru/schema/integration/msp/}PaymentType"/>
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
        "citizenCompensationGuid",
        "transportGuid",
        "loadOverview",
        "cancel",
        "calculation",
        "payment"
    })
    public static class ImportCitizenCompensation {

        @XmlElement(name = "CitizenCompensationGuid")
        protected String citizenCompensationGuid;
        @XmlElement(name = "TransportGuid")
        protected String transportGuid;
        @XmlElement(name = "LoadOverview")
        protected CitizenCompensationOverviewType loadOverview;
        @XmlElement(name = "Cancel")
        protected Boolean cancel;
        @XmlElement(name = "Calculation")
        protected List<ImportCitizenCompensationRequest.ImportCitizenCompensation.Calculation> calculation;
        @XmlElement(name = "Payment")
        protected List<ImportCitizenCompensationRequest.ImportCitizenCompensation.Payment> payment;

        /**
         * Gets the value of the citizenCompensationGuid property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getCitizenCompensationGuid() {
            return citizenCompensationGuid;
        }

        /**
         * Sets the value of the citizenCompensationGuid property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setCitizenCompensationGuid(String value) {
            this.citizenCompensationGuid = value;
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
         *     {@link CitizenCompensationOverviewType }
         *     
         */
        public CitizenCompensationOverviewType getLoadOverview() {
            return loadOverview;
        }

        /**
         * Sets the value of the loadOverview property.
         * 
         * @param value
         *     allowed object is
         *     {@link CitizenCompensationOverviewType }
         *     
         */
        public void setLoadOverview(CitizenCompensationOverviewType value) {
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
         * {@link ImportCitizenCompensationRequest.ImportCitizenCompensation.Calculation }
         * 
         * 
         */
        public List<ImportCitizenCompensationRequest.ImportCitizenCompensation.Calculation> getCalculation() {
            if (calculation == null) {
                calculation = new ArrayList<ImportCitizenCompensationRequest.ImportCitizenCompensation.Calculation>();
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
         * {@link ImportCitizenCompensationRequest.ImportCitizenCompensation.Payment }
         * 
         * 
         */
        public List<ImportCitizenCompensationRequest.ImportCitizenCompensation.Payment> getPayment() {
            if (payment == null) {
                payment = new ArrayList<ImportCitizenCompensationRequest.ImportCitizenCompensation.Payment>();
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
         *           &lt;element name="LoadCalculations" type="{http://dom.gosuslugi.ru/schema/integration/msp/}CitizenCompensationCalculationType"/>
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
            "loadCalculations",
            "cancel"
        })
        public static class Calculation {

            @XmlElement(name = "TransportGuid", required = true)
            protected String transportGuid;
            @XmlElement(name = "CalculationGuid")
            protected String calculationGuid;
            @XmlElement(name = "LoadCalculations")
            protected CitizenCompensationCalculationType loadCalculations;
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
             * Gets the value of the loadCalculations property.
             * 
             * @return
             *     possible object is
             *     {@link CitizenCompensationCalculationType }
             *     
             */
            public CitizenCompensationCalculationType getLoadCalculations() {
                return loadCalculations;
            }

            /**
             * Sets the value of the loadCalculations property.
             * 
             * @param value
             *     allowed object is
             *     {@link CitizenCompensationCalculationType }
             *     
             */
            public void setLoadCalculations(CitizenCompensationCalculationType value) {
                this.loadCalculations = value;
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
         *           &lt;element name="LoadPayments" type="{http://dom.gosuslugi.ru/schema/integration/msp/}PaymentType"/>
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
            "loadPayments",
            "cancel"
        })
        public static class Payment {

            @XmlElement(name = "TransportGuid", required = true)
            protected String transportGuid;
            @XmlElement(name = "PaymentGuid")
            protected String paymentGuid;
            @XmlElement(name = "LoadPayments")
            protected PaymentType loadPayments;
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
             * Gets the value of the loadPayments property.
             * 
             * @return
             *     possible object is
             *     {@link PaymentType }
             *     
             */
            public PaymentType getLoadPayments() {
                return loadPayments;
            }

            /**
             * Sets the value of the loadPayments property.
             * 
             * @param value
             *     allowed object is
             *     {@link PaymentType }
             *     
             */
            public void setLoadPayments(PaymentType value) {
                this.loadPayments = value;
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
