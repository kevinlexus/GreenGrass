
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
 *         &lt;element name="ImportOperationAndBalance" maxOccurs="1000">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="TransportGuid" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType"/>
 *                   &lt;element name="OperationAndBalanceGuid" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType" minOccurs="0"/>
 *                   &lt;choice>
 *                     &lt;sequence>
 *                       &lt;element name="AccountRegOperatorGuid" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType"/>
 *                       &lt;element name="FIASHouseGuid" type="{http://dom.gosuslugi.ru/schema/integration/premises-base/}FIASHouseGUIDType"/>
 *                     &lt;/sequence>
 *                     &lt;sequence>
 *                       &lt;element name="AccountSpecialGuid" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType"/>
 *                     &lt;/sequence>
 *                   &lt;/choice>
 *                   &lt;choice>
 *                     &lt;element name="OperationAndBalanceInfo">
 *                       &lt;complexType>
 *                         &lt;complexContent>
 *                           &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/capital-repair/}OperationAndBalanceInfoType">
 *                           &lt;/extension>
 *                         &lt;/complexContent>
 *                       &lt;/complexType>
 *                     &lt;/element>
 *                     &lt;element name="CancelOperationAndBalance" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *                   &lt;/choice>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *       &lt;/sequence>
 *       &lt;attribute ref="{http://dom.gosuslugi.ru/schema/integration/base/}version use="required" fixed="12.0.0.1""/>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "importOperationAndBalance"
})
@XmlRootElement(name = "importOperationAndBalanceRequest")
public class ImportOperationAndBalanceRequest
    extends BaseType
{

    @XmlElement(name = "ImportOperationAndBalance", required = true)
    protected List<ImportOperationAndBalanceRequest.ImportOperationAndBalance> importOperationAndBalance;
    @XmlAttribute(name = "version", namespace = "http://dom.gosuslugi.ru/schema/integration/base/", required = true)
    protected String version;

    /**
     * Gets the value of the importOperationAndBalance property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the importOperationAndBalance property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getImportOperationAndBalance().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ImportOperationAndBalanceRequest.ImportOperationAndBalance }
     * 
     * 
     */
    public List<ImportOperationAndBalanceRequest.ImportOperationAndBalance> getImportOperationAndBalance() {
        if (importOperationAndBalance == null) {
            importOperationAndBalance = new ArrayList<ImportOperationAndBalanceRequest.ImportOperationAndBalance>();
        }
        return this.importOperationAndBalance;
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
            return "12.0.0.1";
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
     *         &lt;element name="OperationAndBalanceGuid" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType" minOccurs="0"/>
     *         &lt;choice>
     *           &lt;sequence>
     *             &lt;element name="AccountRegOperatorGuid" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType"/>
     *             &lt;element name="FIASHouseGuid" type="{http://dom.gosuslugi.ru/schema/integration/premises-base/}FIASHouseGUIDType"/>
     *           &lt;/sequence>
     *           &lt;sequence>
     *             &lt;element name="AccountSpecialGuid" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType"/>
     *           &lt;/sequence>
     *         &lt;/choice>
     *         &lt;choice>
     *           &lt;element name="OperationAndBalanceInfo">
     *             &lt;complexType>
     *               &lt;complexContent>
     *                 &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/capital-repair/}OperationAndBalanceInfoType">
     *                 &lt;/extension>
     *               &lt;/complexContent>
     *             &lt;/complexType>
     *           &lt;/element>
     *           &lt;element name="CancelOperationAndBalance" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
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
        "operationAndBalanceGuid",
        "accountRegOperatorGuid",
        "fiasHouseGuid",
        "accountSpecialGuid",
        "operationAndBalanceInfo",
        "cancelOperationAndBalance"
    })
    public static class ImportOperationAndBalance {

        @XmlElement(name = "TransportGuid", required = true)
        protected String transportGuid;
        @XmlElement(name = "OperationAndBalanceGuid")
        protected String operationAndBalanceGuid;
        @XmlElement(name = "AccountRegOperatorGuid")
        protected String accountRegOperatorGuid;
        @XmlElement(name = "FIASHouseGuid")
        protected String fiasHouseGuid;
        @XmlElement(name = "AccountSpecialGuid")
        protected String accountSpecialGuid;
        @XmlElement(name = "OperationAndBalanceInfo")
        protected ImportOperationAndBalanceRequest.ImportOperationAndBalance.OperationAndBalanceInfo operationAndBalanceInfo;
        @XmlElement(name = "CancelOperationAndBalance")
        protected Boolean cancelOperationAndBalance;

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
         * Gets the value of the operationAndBalanceGuid property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getOperationAndBalanceGuid() {
            return operationAndBalanceGuid;
        }

        /**
         * Sets the value of the operationAndBalanceGuid property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setOperationAndBalanceGuid(String value) {
            this.operationAndBalanceGuid = value;
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
         * Gets the value of the fiasHouseGuid property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getFIASHouseGuid() {
            return fiasHouseGuid;
        }

        /**
         * Sets the value of the fiasHouseGuid property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setFIASHouseGuid(String value) {
            this.fiasHouseGuid = value;
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
         * Gets the value of the operationAndBalanceInfo property.
         * 
         * @return
         *     possible object is
         *     {@link ImportOperationAndBalanceRequest.ImportOperationAndBalance.OperationAndBalanceInfo }
         *     
         */
        public ImportOperationAndBalanceRequest.ImportOperationAndBalance.OperationAndBalanceInfo getOperationAndBalanceInfo() {
            return operationAndBalanceInfo;
        }

        /**
         * Sets the value of the operationAndBalanceInfo property.
         * 
         * @param value
         *     allowed object is
         *     {@link ImportOperationAndBalanceRequest.ImportOperationAndBalance.OperationAndBalanceInfo }
         *     
         */
        public void setOperationAndBalanceInfo(ImportOperationAndBalanceRequest.ImportOperationAndBalance.OperationAndBalanceInfo value) {
            this.operationAndBalanceInfo = value;
        }

        /**
         * Gets the value of the cancelOperationAndBalance property.
         * 
         * @return
         *     possible object is
         *     {@link Boolean }
         *     
         */
        public Boolean isCancelOperationAndBalance() {
            return cancelOperationAndBalance;
        }

        /**
         * Sets the value of the cancelOperationAndBalance property.
         * 
         * @param value
         *     allowed object is
         *     {@link Boolean }
         *     
         */
        public void setCancelOperationAndBalance(Boolean value) {
            this.cancelOperationAndBalance = value;
        }


        /**
         * <p>Java class for anonymous complex type.
         * 
         * <p>The following schema fragment specifies the expected content contained within this class.
         * 
         * <pre>
         * &lt;complexType>
         *   &lt;complexContent>
         *     &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/capital-repair/}OperationAndBalanceInfoType">
         *     &lt;/extension>
         *   &lt;/complexContent>
         * &lt;/complexType>
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "")
        public static class OperationAndBalanceInfo
            extends OperationAndBalanceInfoType
        {


        }

    }

}
