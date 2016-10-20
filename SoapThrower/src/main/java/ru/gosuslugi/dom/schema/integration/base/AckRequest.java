
package ru.gosuslugi.dom.schema.integration.base;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


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
 *         &lt;element name="Ack">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="MessageGUID" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType"/>
 *                   &lt;element name="RequesterMessageGUID" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType"/>
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
    "ack"
})
@XmlRootElement(name = "AckRequest")
public class AckRequest {

    @XmlElement(name = "Ack", required = true)
    protected AckRequest.Ack ack;

    /**
     * Gets the value of the ack property.
     * 
     * @return
     *     possible object is
     *     {@link AckRequest.Ack }
     *     
     */
    public AckRequest.Ack getAck() {
        return ack;
    }

    /**
     * Sets the value of the ack property.
     * 
     * @param value
     *     allowed object is
     *     {@link AckRequest.Ack }
     *     
     */
    public void setAck(AckRequest.Ack value) {
        this.ack = value;
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
     *         &lt;element name="MessageGUID" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType"/>
     *         &lt;element name="RequesterMessageGUID" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType"/>
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
        "messageGUID",
        "requesterMessageGUID"
    })
    public static class Ack {

        @XmlElement(name = "MessageGUID", required = true)
        protected String messageGUID;
        @XmlElement(name = "RequesterMessageGUID", required = true)
        protected String requesterMessageGUID;

        /**
         * Gets the value of the messageGUID property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getMessageGUID() {
            return messageGUID;
        }

        /**
         * Sets the value of the messageGUID property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setMessageGUID(String value) {
            this.messageGUID = value;
        }

        /**
         * Gets the value of the requesterMessageGUID property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getRequesterMessageGUID() {
            return requesterMessageGUID;
        }

        /**
         * Sets the value of the requesterMessageGUID property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setRequesterMessageGUID(String value) {
            this.requesterMessageGUID = value;
        }

    }

}
