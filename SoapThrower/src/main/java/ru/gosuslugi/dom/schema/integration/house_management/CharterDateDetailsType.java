
package ru.gosuslugi.dom.schema.integration.house_management;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for CharterDateDetailsType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="CharterDateDetailsType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="PeriodMetering" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="StartDate" type="{http://dom.gosuslugi.ru/schema/integration/house-management/}DeviceMeteringsDaySelectionType"/>
 *                   &lt;element name="EndDate" type="{http://dom.gosuslugi.ru/schema/integration/house-management/}DeviceMeteringsDaySelectionType"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="PaymentDocumentInterval" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;choice>
 *                     &lt;element name="StartDate">
 *                       &lt;simpleType>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}byte">
 *                           &lt;maxInclusive value="30"/>
 *                           &lt;minInclusive value="1"/>
 *                         &lt;/restriction>
 *                       &lt;/simpleType>
 *                     &lt;/element>
 *                     &lt;element name="LastDay" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *                   &lt;/choice>
 *                   &lt;choice>
 *                     &lt;element name="CurrentMounth" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *                     &lt;element name="NextMounth" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *                   &lt;/choice>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="PaymentInterval" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;choice>
 *                     &lt;element name="StartDate">
 *                       &lt;simpleType>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}byte">
 *                           &lt;maxInclusive value="30"/>
 *                           &lt;minInclusive value="1"/>
 *                         &lt;/restriction>
 *                       &lt;/simpleType>
 *                     &lt;/element>
 *                     &lt;element name="LastDay" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *                   &lt;/choice>
 *                   &lt;choice>
 *                     &lt;element name="CurrentMounth" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *                     &lt;element name="NextMounth" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
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
@XmlType(name = "CharterDateDetailsType", propOrder = {
    "periodMetering",
    "paymentDocumentInterval",
    "paymentInterval"
})
public class CharterDateDetailsType {

    @XmlElement(name = "PeriodMetering")
    protected CharterDateDetailsType.PeriodMetering periodMetering;
    @XmlElement(name = "PaymentDocumentInterval")
    protected CharterDateDetailsType.PaymentDocumentInterval paymentDocumentInterval;
    @XmlElement(name = "PaymentInterval")
    protected CharterDateDetailsType.PaymentInterval paymentInterval;

    /**
     * Gets the value of the periodMetering property.
     * 
     * @return
     *     possible object is
     *     {@link CharterDateDetailsType.PeriodMetering }
     *     
     */
    public CharterDateDetailsType.PeriodMetering getPeriodMetering() {
        return periodMetering;
    }

    /**
     * Sets the value of the periodMetering property.
     * 
     * @param value
     *     allowed object is
     *     {@link CharterDateDetailsType.PeriodMetering }
     *     
     */
    public void setPeriodMetering(CharterDateDetailsType.PeriodMetering value) {
        this.periodMetering = value;
    }

    /**
     * Gets the value of the paymentDocumentInterval property.
     * 
     * @return
     *     possible object is
     *     {@link CharterDateDetailsType.PaymentDocumentInterval }
     *     
     */
    public CharterDateDetailsType.PaymentDocumentInterval getPaymentDocumentInterval() {
        return paymentDocumentInterval;
    }

    /**
     * Sets the value of the paymentDocumentInterval property.
     * 
     * @param value
     *     allowed object is
     *     {@link CharterDateDetailsType.PaymentDocumentInterval }
     *     
     */
    public void setPaymentDocumentInterval(CharterDateDetailsType.PaymentDocumentInterval value) {
        this.paymentDocumentInterval = value;
    }

    /**
     * Gets the value of the paymentInterval property.
     * 
     * @return
     *     possible object is
     *     {@link CharterDateDetailsType.PaymentInterval }
     *     
     */
    public CharterDateDetailsType.PaymentInterval getPaymentInterval() {
        return paymentInterval;
    }

    /**
     * Sets the value of the paymentInterval property.
     * 
     * @param value
     *     allowed object is
     *     {@link CharterDateDetailsType.PaymentInterval }
     *     
     */
    public void setPaymentInterval(CharterDateDetailsType.PaymentInterval value) {
        this.paymentInterval = value;
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
     *           &lt;element name="StartDate">
     *             &lt;simpleType>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}byte">
     *                 &lt;maxInclusive value="30"/>
     *                 &lt;minInclusive value="1"/>
     *               &lt;/restriction>
     *             &lt;/simpleType>
     *           &lt;/element>
     *           &lt;element name="LastDay" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
     *         &lt;/choice>
     *         &lt;choice>
     *           &lt;element name="CurrentMounth" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
     *           &lt;element name="NextMounth" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
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
        "startDate",
        "lastDay",
        "currentMounth",
        "nextMounth"
    })
    public static class PaymentDocumentInterval {

        @XmlElement(name = "StartDate")
        protected Byte startDate;
        @XmlElement(name = "LastDay")
        protected Boolean lastDay;
        @XmlElement(name = "CurrentMounth")
        protected Boolean currentMounth;
        @XmlElement(name = "NextMounth")
        protected Boolean nextMounth;

        /**
         * Gets the value of the startDate property.
         * 
         * @return
         *     possible object is
         *     {@link Byte }
         *     
         */
        public Byte getStartDate() {
            return startDate;
        }

        /**
         * Sets the value of the startDate property.
         * 
         * @param value
         *     allowed object is
         *     {@link Byte }
         *     
         */
        public void setStartDate(Byte value) {
            this.startDate = value;
        }

        /**
         * Gets the value of the lastDay property.
         * 
         * @return
         *     possible object is
         *     {@link Boolean }
         *     
         */
        public Boolean isLastDay() {
            return lastDay;
        }

        /**
         * Sets the value of the lastDay property.
         * 
         * @param value
         *     allowed object is
         *     {@link Boolean }
         *     
         */
        public void setLastDay(Boolean value) {
            this.lastDay = value;
        }

        /**
         * Gets the value of the currentMounth property.
         * 
         * @return
         *     possible object is
         *     {@link Boolean }
         *     
         */
        public Boolean isCurrentMounth() {
            return currentMounth;
        }

        /**
         * Sets the value of the currentMounth property.
         * 
         * @param value
         *     allowed object is
         *     {@link Boolean }
         *     
         */
        public void setCurrentMounth(Boolean value) {
            this.currentMounth = value;
        }

        /**
         * Gets the value of the nextMounth property.
         * 
         * @return
         *     possible object is
         *     {@link Boolean }
         *     
         */
        public Boolean isNextMounth() {
            return nextMounth;
        }

        /**
         * Sets the value of the nextMounth property.
         * 
         * @param value
         *     allowed object is
         *     {@link Boolean }
         *     
         */
        public void setNextMounth(Boolean value) {
            this.nextMounth = value;
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
     *         &lt;choice>
     *           &lt;element name="StartDate">
     *             &lt;simpleType>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}byte">
     *                 &lt;maxInclusive value="30"/>
     *                 &lt;minInclusive value="1"/>
     *               &lt;/restriction>
     *             &lt;/simpleType>
     *           &lt;/element>
     *           &lt;element name="LastDay" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
     *         &lt;/choice>
     *         &lt;choice>
     *           &lt;element name="CurrentMounth" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
     *           &lt;element name="NextMounth" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
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
        "startDate",
        "lastDay",
        "currentMounth",
        "nextMounth"
    })
    public static class PaymentInterval {

        @XmlElement(name = "StartDate")
        protected Byte startDate;
        @XmlElement(name = "LastDay")
        protected Boolean lastDay;
        @XmlElement(name = "CurrentMounth")
        protected Boolean currentMounth;
        @XmlElement(name = "NextMounth")
        protected Boolean nextMounth;

        /**
         * Gets the value of the startDate property.
         * 
         * @return
         *     possible object is
         *     {@link Byte }
         *     
         */
        public Byte getStartDate() {
            return startDate;
        }

        /**
         * Sets the value of the startDate property.
         * 
         * @param value
         *     allowed object is
         *     {@link Byte }
         *     
         */
        public void setStartDate(Byte value) {
            this.startDate = value;
        }

        /**
         * Gets the value of the lastDay property.
         * 
         * @return
         *     possible object is
         *     {@link Boolean }
         *     
         */
        public Boolean isLastDay() {
            return lastDay;
        }

        /**
         * Sets the value of the lastDay property.
         * 
         * @param value
         *     allowed object is
         *     {@link Boolean }
         *     
         */
        public void setLastDay(Boolean value) {
            this.lastDay = value;
        }

        /**
         * Gets the value of the currentMounth property.
         * 
         * @return
         *     possible object is
         *     {@link Boolean }
         *     
         */
        public Boolean isCurrentMounth() {
            return currentMounth;
        }

        /**
         * Sets the value of the currentMounth property.
         * 
         * @param value
         *     allowed object is
         *     {@link Boolean }
         *     
         */
        public void setCurrentMounth(Boolean value) {
            this.currentMounth = value;
        }

        /**
         * Gets the value of the nextMounth property.
         * 
         * @return
         *     possible object is
         *     {@link Boolean }
         *     
         */
        public Boolean isNextMounth() {
            return nextMounth;
        }

        /**
         * Sets the value of the nextMounth property.
         * 
         * @param value
         *     allowed object is
         *     {@link Boolean }
         *     
         */
        public void setNextMounth(Boolean value) {
            this.nextMounth = value;
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
     *         &lt;element name="StartDate" type="{http://dom.gosuslugi.ru/schema/integration/house-management/}DeviceMeteringsDaySelectionType"/>
     *         &lt;element name="EndDate" type="{http://dom.gosuslugi.ru/schema/integration/house-management/}DeviceMeteringsDaySelectionType"/>
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
        "startDate",
        "endDate"
    })
    public static class PeriodMetering {

        @XmlElement(name = "StartDate", required = true)
        protected DeviceMeteringsDaySelectionType startDate;
        @XmlElement(name = "EndDate", required = true)
        protected DeviceMeteringsDaySelectionType endDate;

        /**
         * Gets the value of the startDate property.
         * 
         * @return
         *     possible object is
         *     {@link DeviceMeteringsDaySelectionType }
         *     
         */
        public DeviceMeteringsDaySelectionType getStartDate() {
            return startDate;
        }

        /**
         * Sets the value of the startDate property.
         * 
         * @param value
         *     allowed object is
         *     {@link DeviceMeteringsDaySelectionType }
         *     
         */
        public void setStartDate(DeviceMeteringsDaySelectionType value) {
            this.startDate = value;
        }

        /**
         * Gets the value of the endDate property.
         * 
         * @return
         *     possible object is
         *     {@link DeviceMeteringsDaySelectionType }
         *     
         */
        public DeviceMeteringsDaySelectionType getEndDate() {
            return endDate;
        }

        /**
         * Sets the value of the endDate property.
         * 
         * @param value
         *     allowed object is
         *     {@link DeviceMeteringsDaySelectionType }
         *     
         */
        public void setEndDate(DeviceMeteringsDaySelectionType value) {
            this.endDate = value;
        }

    }

}
