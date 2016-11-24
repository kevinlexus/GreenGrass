
package ru.gosuslugi.dom.schema.integration.capital_repair;

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
 *         &lt;element name="ContractGuid" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType"/>
 *         &lt;element name="importPaymentInfo" maxOccurs="1000">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="TransportGuid" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType"/>
 *                   &lt;element name="PaymentInfoGuid" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType" minOccurs="0"/>
 *                   &lt;choice>
 *                     &lt;element name="LoadPaymentInfo" type="{http://dom.gosuslugi.ru/schema/integration/capital-repair/}PaymentInfoType"/>
 *                     &lt;element name="CancelPaymentInfo" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
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
    "contractGuid",
    "importPaymentInfo"
})
@XmlRootElement(name = "importPaymentsInfoRequest")
public class ImportPaymentsInfoRequest
    extends BaseType
{

    @XmlElement(name = "ContractGuid", required = true)
    protected String contractGuid;
    @XmlElement(required = true)
    protected List<ImportPaymentsInfoRequest.ImportPaymentInfo> importPaymentInfo;
    @XmlAttribute(name = "version", namespace = "http://dom.gosuslugi.ru/schema/integration/base/", required = true)
    protected String version;

    /**
     * Gets the value of the contractGuid property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getContractGuid() {
        return contractGuid;
    }

    /**
     * Sets the value of the contractGuid property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setContractGuid(String value) {
        this.contractGuid = value;
    }

    /**
     * Gets the value of the importPaymentInfo property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the importPaymentInfo property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getImportPaymentInfo().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ImportPaymentsInfoRequest.ImportPaymentInfo }
     * 
     * 
     */
    public List<ImportPaymentsInfoRequest.ImportPaymentInfo> getImportPaymentInfo() {
        if (importPaymentInfo == null) {
            importPaymentInfo = new ArrayList<ImportPaymentsInfoRequest.ImportPaymentInfo>();
        }
        return this.importPaymentInfo;
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
     *         &lt;element name="PaymentInfoGuid" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType" minOccurs="0"/>
     *         &lt;choice>
     *           &lt;element name="LoadPaymentInfo" type="{http://dom.gosuslugi.ru/schema/integration/capital-repair/}PaymentInfoType"/>
     *           &lt;element name="CancelPaymentInfo" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
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
        "paymentInfoGuid",
        "loadPaymentInfo",
        "cancelPaymentInfo"
    })
    public static class ImportPaymentInfo {

        @XmlElement(name = "TransportGuid", required = true)
        protected String transportGuid;
        @XmlElement(name = "PaymentInfoGuid")
        protected String paymentInfoGuid;
        @XmlElement(name = "LoadPaymentInfo")
        protected PaymentInfoType loadPaymentInfo;
        @XmlElement(name = "CancelPaymentInfo")
        protected Boolean cancelPaymentInfo;

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
         * Gets the value of the paymentInfoGuid property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getPaymentInfoGuid() {
            return paymentInfoGuid;
        }

        /**
         * Sets the value of the paymentInfoGuid property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setPaymentInfoGuid(String value) {
            this.paymentInfoGuid = value;
        }

        /**
         * Gets the value of the loadPaymentInfo property.
         * 
         * @return
         *     possible object is
         *     {@link PaymentInfoType }
         *     
         */
        public PaymentInfoType getLoadPaymentInfo() {
            return loadPaymentInfo;
        }

        /**
         * Sets the value of the loadPaymentInfo property.
         * 
         * @param value
         *     allowed object is
         *     {@link PaymentInfoType }
         *     
         */
        public void setLoadPaymentInfo(PaymentInfoType value) {
            this.loadPaymentInfo = value;
        }

        /**
         * Gets the value of the cancelPaymentInfo property.
         * 
         * @return
         *     possible object is
         *     {@link Boolean }
         *     
         */
        public Boolean isCancelPaymentInfo() {
            return cancelPaymentInfo;
        }

        /**
         * Sets the value of the cancelPaymentInfo property.
         * 
         * @param value
         *     allowed object is
         *     {@link Boolean }
         *     
         */
        public void setCancelPaymentInfo(Boolean value) {
            this.cancelPaymentInfo = value;
        }

    }

}
