
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
 *         &lt;element name="PlanGUID" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType"/>
 *         &lt;element name="importContract" maxOccurs="1000">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="TransportGuid" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType"/>
 *                   &lt;element name="ContractGuid" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType" minOccurs="0"/>
 *                   &lt;choice>
 *                     &lt;element name="LoadContract" type="{http://dom.gosuslugi.ru/schema/integration/capital-repair/}ContractType"/>
 *                     &lt;element name="DissolveContract" type="{http://dom.gosuslugi.ru/schema/integration/capital-repair/}DissolveContractType"/>
 *                     &lt;element name="CancelContract" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
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
    "planGUID",
    "importContract"
})
@XmlRootElement(name = "importContractsRequest")
public class ImportContractsRequest
    extends BaseType
{

    @XmlElement(name = "PlanGUID", required = true)
    protected String planGUID;
    @XmlElement(required = true)
    protected List<ImportContractsRequest.ImportContract> importContract;
    @XmlAttribute(name = "version", namespace = "http://dom.gosuslugi.ru/schema/integration/base/", required = true)
    protected String version;

    /**
     * Gets the value of the planGUID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPlanGUID() {
        return planGUID;
    }

    /**
     * Sets the value of the planGUID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPlanGUID(String value) {
        this.planGUID = value;
    }

    /**
     * Gets the value of the importContract property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the importContract property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getImportContract().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ImportContractsRequest.ImportContract }
     * 
     * 
     */
    public List<ImportContractsRequest.ImportContract> getImportContract() {
        if (importContract == null) {
            importContract = new ArrayList<ImportContractsRequest.ImportContract>();
        }
        return this.importContract;
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
     *         &lt;element name="ContractGuid" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType" minOccurs="0"/>
     *         &lt;choice>
     *           &lt;element name="LoadContract" type="{http://dom.gosuslugi.ru/schema/integration/capital-repair/}ContractType"/>
     *           &lt;element name="DissolveContract" type="{http://dom.gosuslugi.ru/schema/integration/capital-repair/}DissolveContractType"/>
     *           &lt;element name="CancelContract" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
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
        "contractGuid",
        "loadContract",
        "dissolveContract",
        "cancelContract"
    })
    public static class ImportContract {

        @XmlElement(name = "TransportGuid", required = true)
        protected String transportGuid;
        @XmlElement(name = "ContractGuid")
        protected String contractGuid;
        @XmlElement(name = "LoadContract")
        protected ContractType loadContract;
        @XmlElement(name = "DissolveContract")
        protected DissolveContractType dissolveContract;
        @XmlElement(name = "CancelContract")
        protected Boolean cancelContract;

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
         * Gets the value of the loadContract property.
         * 
         * @return
         *     possible object is
         *     {@link ContractType }
         *     
         */
        public ContractType getLoadContract() {
            return loadContract;
        }

        /**
         * Sets the value of the loadContract property.
         * 
         * @param value
         *     allowed object is
         *     {@link ContractType }
         *     
         */
        public void setLoadContract(ContractType value) {
            this.loadContract = value;
        }

        /**
         * Gets the value of the dissolveContract property.
         * 
         * @return
         *     possible object is
         *     {@link DissolveContractType }
         *     
         */
        public DissolveContractType getDissolveContract() {
            return dissolveContract;
        }

        /**
         * Sets the value of the dissolveContract property.
         * 
         * @param value
         *     allowed object is
         *     {@link DissolveContractType }
         *     
         */
        public void setDissolveContract(DissolveContractType value) {
            this.dissolveContract = value;
        }

        /**
         * Gets the value of the cancelContract property.
         * 
         * @return
         *     possible object is
         *     {@link Boolean }
         *     
         */
        public Boolean isCancelContract() {
            return cancelContract;
        }

        /**
         * Sets the value of the cancelContract property.
         * 
         * @param value
         *     allowed object is
         *     {@link Boolean }
         *     
         */
        public void setCancelContract(Boolean value) {
            this.cancelContract = value;
        }

    }

}
