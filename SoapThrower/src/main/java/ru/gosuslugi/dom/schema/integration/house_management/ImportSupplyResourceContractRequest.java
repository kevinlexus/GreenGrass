
package ru.gosuslugi.dom.schema.integration.house_management;

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
import ru.gosuslugi.dom.schema.integration.nsi_base.NsiRef;


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
 *         &lt;element name="Contract" maxOccurs="1000">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;sequence>
 *                     &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/base/}TransportGUID"/>
 *                     &lt;element name="ContractGUID" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType" minOccurs="0"/>
 *                   &lt;/sequence>
 *                   &lt;choice>
 *                     &lt;element name="SupplyResourceContract" type="{http://dom.gosuslugi.ru/schema/integration/house-management/}SupplyResourceContractType"/>
 *                     &lt;element name="TerminateContract">
 *                       &lt;complexType>
 *                         &lt;complexContent>
 *                           &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/house-management/}TerminateType">
 *                             &lt;sequence>
 *                               &lt;element name="ReasonRef" type="{http://dom.gosuslugi.ru/schema/integration/nsi-base/}nsiRef"/>
 *                             &lt;/sequence>
 *                           &lt;/extension>
 *                         &lt;/complexContent>
 *                       &lt;/complexType>
 *                     &lt;/element>
 *                     &lt;element name="RollOverContract">
 *                       &lt;complexType>
 *                         &lt;complexContent>
 *                           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                             &lt;sequence>
 *                               &lt;element name="RollOverDate" type="{http://www.w3.org/2001/XMLSchema}date"/>
 *                             &lt;/sequence>
 *                           &lt;/restriction>
 *                         &lt;/complexContent>
 *                       &lt;/complexType>
 *                     &lt;/element>
 *                     &lt;element name="AnnulmentContract" type="{http://dom.gosuslugi.ru/schema/integration/house-management/}AnnulmentType"/>
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
    "contract"
})
@XmlRootElement(name = "importSupplyResourceContractRequest")
public class ImportSupplyResourceContractRequest
    extends BaseType
{

    @XmlElement(name = "Contract", required = true)
    protected List<ImportSupplyResourceContractRequest.Contract> contract;
    @XmlAttribute(name = "version", namespace = "http://dom.gosuslugi.ru/schema/integration/base/", required = true)
    protected String version;

    /**
     * Gets the value of the contract property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the contract property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getContract().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ImportSupplyResourceContractRequest.Contract }
     * 
     * 
     */
    public List<ImportSupplyResourceContractRequest.Contract> getContract() {
        if (contract == null) {
            contract = new ArrayList<ImportSupplyResourceContractRequest.Contract>();
        }
        return this.contract;
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
     *         &lt;sequence>
     *           &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/base/}TransportGUID"/>
     *           &lt;element name="ContractGUID" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType" minOccurs="0"/>
     *         &lt;/sequence>
     *         &lt;choice>
     *           &lt;element name="SupplyResourceContract" type="{http://dom.gosuslugi.ru/schema/integration/house-management/}SupplyResourceContractType"/>
     *           &lt;element name="TerminateContract">
     *             &lt;complexType>
     *               &lt;complexContent>
     *                 &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/house-management/}TerminateType">
     *                   &lt;sequence>
     *                     &lt;element name="ReasonRef" type="{http://dom.gosuslugi.ru/schema/integration/nsi-base/}nsiRef"/>
     *                   &lt;/sequence>
     *                 &lt;/extension>
     *               &lt;/complexContent>
     *             &lt;/complexType>
     *           &lt;/element>
     *           &lt;element name="RollOverContract">
     *             &lt;complexType>
     *               &lt;complexContent>
     *                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                   &lt;sequence>
     *                     &lt;element name="RollOverDate" type="{http://www.w3.org/2001/XMLSchema}date"/>
     *                   &lt;/sequence>
     *                 &lt;/restriction>
     *               &lt;/complexContent>
     *             &lt;/complexType>
     *           &lt;/element>
     *           &lt;element name="AnnulmentContract" type="{http://dom.gosuslugi.ru/schema/integration/house-management/}AnnulmentType"/>
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
        "contractGUID",
        "supplyResourceContract",
        "terminateContract",
        "rollOverContract",
        "annulmentContract"
    })
    public static class Contract {

        @XmlElement(name = "TransportGUID", namespace = "http://dom.gosuslugi.ru/schema/integration/base/", required = true)
        protected String transportGUID;
        @XmlElement(name = "ContractGUID")
        protected String contractGUID;
        @XmlElement(name = "SupplyResourceContract")
        protected SupplyResourceContractType supplyResourceContract;
        @XmlElement(name = "TerminateContract")
        protected ImportSupplyResourceContractRequest.Contract.TerminateContract terminateContract;
        @XmlElement(name = "RollOverContract")
        protected ImportSupplyResourceContractRequest.Contract.RollOverContract rollOverContract;
        @XmlElement(name = "AnnulmentContract")
        protected AnnulmentType annulmentContract;

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
         * Gets the value of the contractGUID property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getContractGUID() {
            return contractGUID;
        }

        /**
         * Sets the value of the contractGUID property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setContractGUID(String value) {
            this.contractGUID = value;
        }

        /**
         * Gets the value of the supplyResourceContract property.
         * 
         * @return
         *     possible object is
         *     {@link SupplyResourceContractType }
         *     
         */
        public SupplyResourceContractType getSupplyResourceContract() {
            return supplyResourceContract;
        }

        /**
         * Sets the value of the supplyResourceContract property.
         * 
         * @param value
         *     allowed object is
         *     {@link SupplyResourceContractType }
         *     
         */
        public void setSupplyResourceContract(SupplyResourceContractType value) {
            this.supplyResourceContract = value;
        }

        /**
         * Gets the value of the terminateContract property.
         * 
         * @return
         *     possible object is
         *     {@link ImportSupplyResourceContractRequest.Contract.TerminateContract }
         *     
         */
        public ImportSupplyResourceContractRequest.Contract.TerminateContract getTerminateContract() {
            return terminateContract;
        }

        /**
         * Sets the value of the terminateContract property.
         * 
         * @param value
         *     allowed object is
         *     {@link ImportSupplyResourceContractRequest.Contract.TerminateContract }
         *     
         */
        public void setTerminateContract(ImportSupplyResourceContractRequest.Contract.TerminateContract value) {
            this.terminateContract = value;
        }

        /**
         * Gets the value of the rollOverContract property.
         * 
         * @return
         *     possible object is
         *     {@link ImportSupplyResourceContractRequest.Contract.RollOverContract }
         *     
         */
        public ImportSupplyResourceContractRequest.Contract.RollOverContract getRollOverContract() {
            return rollOverContract;
        }

        /**
         * Sets the value of the rollOverContract property.
         * 
         * @param value
         *     allowed object is
         *     {@link ImportSupplyResourceContractRequest.Contract.RollOverContract }
         *     
         */
        public void setRollOverContract(ImportSupplyResourceContractRequest.Contract.RollOverContract value) {
            this.rollOverContract = value;
        }

        /**
         * Gets the value of the annulmentContract property.
         * 
         * @return
         *     possible object is
         *     {@link AnnulmentType }
         *     
         */
        public AnnulmentType getAnnulmentContract() {
            return annulmentContract;
        }

        /**
         * Sets the value of the annulmentContract property.
         * 
         * @param value
         *     allowed object is
         *     {@link AnnulmentType }
         *     
         */
        public void setAnnulmentContract(AnnulmentType value) {
            this.annulmentContract = value;
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
         *         &lt;element name="RollOverDate" type="{http://www.w3.org/2001/XMLSchema}date"/>
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
            "rollOverDate"
        })
        public static class RollOverContract {

            @XmlElement(name = "RollOverDate", required = true)
            @XmlSchemaType(name = "date")
            protected XMLGregorianCalendar rollOverDate;

            /**
             * Gets the value of the rollOverDate property.
             * 
             * @return
             *     possible object is
             *     {@link XMLGregorianCalendar }
             *     
             */
            public XMLGregorianCalendar getRollOverDate() {
                return rollOverDate;
            }

            /**
             * Sets the value of the rollOverDate property.
             * 
             * @param value
             *     allowed object is
             *     {@link XMLGregorianCalendar }
             *     
             */
            public void setRollOverDate(XMLGregorianCalendar value) {
                this.rollOverDate = value;
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
         *     &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/house-management/}TerminateType">
         *       &lt;sequence>
         *         &lt;element name="ReasonRef" type="{http://dom.gosuslugi.ru/schema/integration/nsi-base/}nsiRef"/>
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
            "reasonRef"
        })
        public static class TerminateContract
            extends TerminateType
        {

            @XmlElement(name = "ReasonRef", required = true)
            protected NsiRef reasonRef;

            /**
             * Gets the value of the reasonRef property.
             * 
             * @return
             *     possible object is
             *     {@link NsiRef }
             *     
             */
            public NsiRef getReasonRef() {
                return reasonRef;
            }

            /**
             * Sets the value of the reasonRef property.
             * 
             * @param value
             *     allowed object is
             *     {@link NsiRef }
             *     
             */
            public void setReasonRef(NsiRef value) {
                this.reasonRef = value;
            }

        }

    }

}
