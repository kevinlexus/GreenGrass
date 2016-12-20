
package ru.gosuslugi.dom.schema.integration.payments_base;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Запрос на квитирование
 * 
 * <p>Java class for AcknowledgmentRequestInfoType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="AcknowledgmentRequestInfoType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/payments-base/}NotificationsOfOrderExecutionGUID"/>
 *         &lt;choice>
 *           &lt;element name="PaymentDocumentAck">
 *             &lt;complexType>
 *               &lt;complexContent>
 *                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                   &lt;sequence>
 *                     &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/bills-base/}PaymentDocumentID"/>
 *                     &lt;choice>
 *                       &lt;element name="HSType" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType"/>
 *                       &lt;element name="MSType" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType"/>
 *                       &lt;element name="ASType" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType"/>
 *                     &lt;/choice>
 *                     &lt;element name="Amount">
 *                       &lt;simpleType>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}decimal">
 *                           &lt;minInclusive value="1"/>
 *                           &lt;totalDigits value="13"/>
 *                           &lt;fractionDigits value="2"/>
 *                         &lt;/restriction>
 *                       &lt;/simpleType>
 *                     &lt;/element>
 *                     &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/bills-base/}PaymentDocumentNumber" minOccurs="0"/>
 *                   &lt;/sequence>
 *                 &lt;/restriction>
 *               &lt;/complexContent>
 *             &lt;/complexType>
 *           &lt;/element>
 *           &lt;element name="AckImpossible">
 *             &lt;complexType>
 *               &lt;complexContent>
 *                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                   &lt;sequence>
 *                     &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/bills-base/}PaymentDocumentID" minOccurs="0"/>
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
@XmlType(name = "AcknowledgmentRequestInfoType", propOrder = {
    "notificationsOfOrderExecutionGUID",
    "paymentDocumentAck",
    "ackImpossible"
})
public class AcknowledgmentRequestInfoType {

    @XmlElement(name = "NotificationsOfOrderExecutionGUID", required = true)
    protected String notificationsOfOrderExecutionGUID;
    @XmlElement(name = "PaymentDocumentAck")
    protected AcknowledgmentRequestInfoType.PaymentDocumentAck paymentDocumentAck;
    @XmlElement(name = "AckImpossible")
    protected AcknowledgmentRequestInfoType.AckImpossible ackImpossible;

    /**
     * Gets the value of the notificationsOfOrderExecutionGUID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNotificationsOfOrderExecutionGUID() {
        return notificationsOfOrderExecutionGUID;
    }

    /**
     * Sets the value of the notificationsOfOrderExecutionGUID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNotificationsOfOrderExecutionGUID(String value) {
        this.notificationsOfOrderExecutionGUID = value;
    }

    /**
     * Gets the value of the paymentDocumentAck property.
     * 
     * @return
     *     possible object is
     *     {@link AcknowledgmentRequestInfoType.PaymentDocumentAck }
     *     
     */
    public AcknowledgmentRequestInfoType.PaymentDocumentAck getPaymentDocumentAck() {
        return paymentDocumentAck;
    }

    /**
     * Sets the value of the paymentDocumentAck property.
     * 
     * @param value
     *     allowed object is
     *     {@link AcknowledgmentRequestInfoType.PaymentDocumentAck }
     *     
     */
    public void setPaymentDocumentAck(AcknowledgmentRequestInfoType.PaymentDocumentAck value) {
        this.paymentDocumentAck = value;
    }

    /**
     * Gets the value of the ackImpossible property.
     * 
     * @return
     *     possible object is
     *     {@link AcknowledgmentRequestInfoType.AckImpossible }
     *     
     */
    public AcknowledgmentRequestInfoType.AckImpossible getAckImpossible() {
        return ackImpossible;
    }

    /**
     * Sets the value of the ackImpossible property.
     * 
     * @param value
     *     allowed object is
     *     {@link AcknowledgmentRequestInfoType.AckImpossible }
     *     
     */
    public void setAckImpossible(AcknowledgmentRequestInfoType.AckImpossible value) {
        this.ackImpossible = value;
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
     *         &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/bills-base/}PaymentDocumentID" minOccurs="0"/>
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
        "paymentDocumentID"
    })
    public static class AckImpossible {

        @XmlElement(name = "PaymentDocumentID", namespace = "http://dom.gosuslugi.ru/schema/integration/bills-base/")
        protected String paymentDocumentID;

        /**
         * Gets the value of the paymentDocumentID property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getPaymentDocumentID() {
            return paymentDocumentID;
        }

        /**
         * Sets the value of the paymentDocumentID property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setPaymentDocumentID(String value) {
            this.paymentDocumentID = value;
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
     *         &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/bills-base/}PaymentDocumentID"/>
     *         &lt;choice>
     *           &lt;element name="HSType" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType"/>
     *           &lt;element name="MSType" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType"/>
     *           &lt;element name="ASType" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType"/>
     *         &lt;/choice>
     *         &lt;element name="Amount">
     *           &lt;simpleType>
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}decimal">
     *               &lt;minInclusive value="1"/>
     *               &lt;totalDigits value="13"/>
     *               &lt;fractionDigits value="2"/>
     *             &lt;/restriction>
     *           &lt;/simpleType>
     *         &lt;/element>
     *         &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/bills-base/}PaymentDocumentNumber" minOccurs="0"/>
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
        "paymentDocumentID",
        "hsType",
        "msType",
        "asType",
        "amount",
        "paymentDocumentNumber"
    })
    public static class PaymentDocumentAck {

        @XmlElement(name = "PaymentDocumentID", namespace = "http://dom.gosuslugi.ru/schema/integration/bills-base/", required = true)
        protected String paymentDocumentID;
        @XmlElement(name = "HSType")
        protected String hsType;
        @XmlElement(name = "MSType")
        protected String msType;
        @XmlElement(name = "ASType")
        protected String asType;
        @XmlElement(name = "Amount", required = true)
        protected BigDecimal amount;
        @XmlElement(name = "PaymentDocumentNumber", namespace = "http://dom.gosuslugi.ru/schema/integration/bills-base/")
        protected String paymentDocumentNumber;

        /**
         * Gets the value of the paymentDocumentID property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getPaymentDocumentID() {
            return paymentDocumentID;
        }

        /**
         * Sets the value of the paymentDocumentID property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setPaymentDocumentID(String value) {
            this.paymentDocumentID = value;
        }

        /**
         * Gets the value of the hsType property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getHSType() {
            return hsType;
        }

        /**
         * Sets the value of the hsType property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setHSType(String value) {
            this.hsType = value;
        }

        /**
         * Gets the value of the msType property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getMSType() {
            return msType;
        }

        /**
         * Sets the value of the msType property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setMSType(String value) {
            this.msType = value;
        }

        /**
         * Gets the value of the asType property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getASType() {
            return asType;
        }

        /**
         * Sets the value of the asType property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setASType(String value) {
            this.asType = value;
        }

        /**
         * Gets the value of the amount property.
         * 
         * @return
         *     possible object is
         *     {@link BigDecimal }
         *     
         */
        public BigDecimal getAmount() {
            return amount;
        }

        /**
         * Sets the value of the amount property.
         * 
         * @param value
         *     allowed object is
         *     {@link BigDecimal }
         *     
         */
        public void setAmount(BigDecimal value) {
            this.amount = value;
        }

        /**
         * Gets the value of the paymentDocumentNumber property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getPaymentDocumentNumber() {
            return paymentDocumentNumber;
        }

        /**
         * Sets the value of the paymentDocumentNumber property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setPaymentDocumentNumber(String value) {
            this.paymentDocumentNumber = value;
        }

    }

}
