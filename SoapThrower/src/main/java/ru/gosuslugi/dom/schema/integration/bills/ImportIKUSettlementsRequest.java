
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
import ru.gosuslugi.dom.schema.integration.organizations_registry_base.RegOrgType;


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
 *         &lt;element name="importSettlement" maxOccurs="unbounded">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;sequence>
 *                     &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/base/}TransportGUID"/>
 *                     &lt;element name="SettlementGUID" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType" minOccurs="0"/>
 *                   &lt;/sequence>
 *                   &lt;choice>
 *                     &lt;element name="Settlement">
 *                       &lt;complexType>
 *                         &lt;complexContent>
 *                           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                             &lt;sequence>
 *                               &lt;element name="Contract" minOccurs="0">
 *                                 &lt;complexType>
 *                                   &lt;complexContent>
 *                                     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                       &lt;choice>
 *                                         &lt;element name="ContractRootGUID" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType"/>
 *                                         &lt;element name="NoContract">
 *                                           &lt;complexType>
 *                                             &lt;complexContent>
 *                                               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                                 &lt;sequence>
 *                                                   &lt;element name="FirstContractParty" type="{http://dom.gosuslugi.ru/schema/integration/organizations-registry-base/}RegOrgType"/>
 *                                                   &lt;element name="DocNum" minOccurs="0">
 *                                                     &lt;simpleType>
 *                                                       &lt;restriction base="{http://dom.gosuslugi.ru/schema/integration/base/}LongTextType">
 *                                                         &lt;maxLength value="30"/>
 *                                                         &lt;minLength value="1"/>
 *                                                       &lt;/restriction>
 *                                                     &lt;/simpleType>
 *                                                   &lt;/element>
 *                                                   &lt;element name="SigningDate" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
 *                                                 &lt;/sequence>
 *                                               &lt;/restriction>
 *                                             &lt;/complexContent>
 *                                           &lt;/complexType>
 *                                         &lt;/element>
 *                                       &lt;/choice>
 *                                     &lt;/restriction>
 *                                   &lt;/complexContent>
 *                                 &lt;/complexType>
 *                               &lt;/element>
 *                               &lt;element name="ReportingPeriod" maxOccurs="unbounded" minOccurs="0">
 *                                 &lt;complexType>
 *                                   &lt;complexContent>
 *                                     &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/bills/}ReportPeriodType">
 *                                       &lt;choice>
 *                                         &lt;element name="ReportingPeriodInfo" type="{http://dom.gosuslugi.ru/schema/integration/bills/}ReportPeriodIKUInfoType"/>
 *                                         &lt;element name="AnnulmentReportingPeriod">
 *                                           &lt;complexType>
 *                                             &lt;complexContent>
 *                                               &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/bills/}AnnulmentType">
 *                                               &lt;/extension>
 *                                             &lt;/complexContent>
 *                                           &lt;/complexType>
 *                                         &lt;/element>
 *                                       &lt;/choice>
 *                                     &lt;/extension>
 *                                   &lt;/complexContent>
 *                                 &lt;/complexType>
 *                               &lt;/element>
 *                             &lt;/sequence>
 *                           &lt;/restriction>
 *                         &lt;/complexContent>
 *                       &lt;/complexType>
 *                     &lt;/element>
 *                     &lt;element name="AnnulmentSettlement" type="{http://dom.gosuslugi.ru/schema/integration/bills/}AnnulmentType"/>
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
    "importSettlement"
})
@XmlRootElement(name = "importIKUSettlementsRequest")
public class ImportIKUSettlementsRequest
    extends BaseType
{

    @XmlElement(required = true)
    protected List<ImportIKUSettlementsRequest.ImportSettlement> importSettlement;
    @XmlAttribute(name = "version", namespace = "http://dom.gosuslugi.ru/schema/integration/base/", required = true)
    protected String version;

    /**
     * Gets the value of the importSettlement property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the importSettlement property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getImportSettlement().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ImportIKUSettlementsRequest.ImportSettlement }
     * 
     * 
     */
    public List<ImportIKUSettlementsRequest.ImportSettlement> getImportSettlement() {
        if (importSettlement == null) {
            importSettlement = new ArrayList<ImportIKUSettlementsRequest.ImportSettlement>();
        }
        return this.importSettlement;
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
     *           &lt;element name="SettlementGUID" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType" minOccurs="0"/>
     *         &lt;/sequence>
     *         &lt;choice>
     *           &lt;element name="Settlement">
     *             &lt;complexType>
     *               &lt;complexContent>
     *                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                   &lt;sequence>
     *                     &lt;element name="Contract" minOccurs="0">
     *                       &lt;complexType>
     *                         &lt;complexContent>
     *                           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                             &lt;choice>
     *                               &lt;element name="ContractRootGUID" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType"/>
     *                               &lt;element name="NoContract">
     *                                 &lt;complexType>
     *                                   &lt;complexContent>
     *                                     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                                       &lt;sequence>
     *                                         &lt;element name="FirstContractParty" type="{http://dom.gosuslugi.ru/schema/integration/organizations-registry-base/}RegOrgType"/>
     *                                         &lt;element name="DocNum" minOccurs="0">
     *                                           &lt;simpleType>
     *                                             &lt;restriction base="{http://dom.gosuslugi.ru/schema/integration/base/}LongTextType">
     *                                               &lt;maxLength value="30"/>
     *                                               &lt;minLength value="1"/>
     *                                             &lt;/restriction>
     *                                           &lt;/simpleType>
     *                                         &lt;/element>
     *                                         &lt;element name="SigningDate" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
     *                                       &lt;/sequence>
     *                                     &lt;/restriction>
     *                                   &lt;/complexContent>
     *                                 &lt;/complexType>
     *                               &lt;/element>
     *                             &lt;/choice>
     *                           &lt;/restriction>
     *                         &lt;/complexContent>
     *                       &lt;/complexType>
     *                     &lt;/element>
     *                     &lt;element name="ReportingPeriod" maxOccurs="unbounded" minOccurs="0">
     *                       &lt;complexType>
     *                         &lt;complexContent>
     *                           &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/bills/}ReportPeriodType">
     *                             &lt;choice>
     *                               &lt;element name="ReportingPeriodInfo" type="{http://dom.gosuslugi.ru/schema/integration/bills/}ReportPeriodIKUInfoType"/>
     *                               &lt;element name="AnnulmentReportingPeriod">
     *                                 &lt;complexType>
     *                                   &lt;complexContent>
     *                                     &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/bills/}AnnulmentType">
     *                                     &lt;/extension>
     *                                   &lt;/complexContent>
     *                                 &lt;/complexType>
     *                               &lt;/element>
     *                             &lt;/choice>
     *                           &lt;/extension>
     *                         &lt;/complexContent>
     *                       &lt;/complexType>
     *                     &lt;/element>
     *                   &lt;/sequence>
     *                 &lt;/restriction>
     *               &lt;/complexContent>
     *             &lt;/complexType>
     *           &lt;/element>
     *           &lt;element name="AnnulmentSettlement" type="{http://dom.gosuslugi.ru/schema/integration/bills/}AnnulmentType"/>
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
        "settlementGUID",
        "settlement",
        "annulmentSettlement"
    })
    public static class ImportSettlement {

        @XmlElement(name = "TransportGUID", namespace = "http://dom.gosuslugi.ru/schema/integration/base/", required = true)
        protected String transportGUID;
        @XmlElement(name = "SettlementGUID")
        protected String settlementGUID;
        @XmlElement(name = "Settlement")
        protected ImportIKUSettlementsRequest.ImportSettlement.Settlement settlement;
        @XmlElement(name = "AnnulmentSettlement")
        protected AnnulmentType annulmentSettlement;

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
         * Gets the value of the settlementGUID property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getSettlementGUID() {
            return settlementGUID;
        }

        /**
         * Sets the value of the settlementGUID property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setSettlementGUID(String value) {
            this.settlementGUID = value;
        }

        /**
         * Gets the value of the settlement property.
         * 
         * @return
         *     possible object is
         *     {@link ImportIKUSettlementsRequest.ImportSettlement.Settlement }
         *     
         */
        public ImportIKUSettlementsRequest.ImportSettlement.Settlement getSettlement() {
            return settlement;
        }

        /**
         * Sets the value of the settlement property.
         * 
         * @param value
         *     allowed object is
         *     {@link ImportIKUSettlementsRequest.ImportSettlement.Settlement }
         *     
         */
        public void setSettlement(ImportIKUSettlementsRequest.ImportSettlement.Settlement value) {
            this.settlement = value;
        }

        /**
         * Gets the value of the annulmentSettlement property.
         * 
         * @return
         *     possible object is
         *     {@link AnnulmentType }
         *     
         */
        public AnnulmentType getAnnulmentSettlement() {
            return annulmentSettlement;
        }

        /**
         * Sets the value of the annulmentSettlement property.
         * 
         * @param value
         *     allowed object is
         *     {@link AnnulmentType }
         *     
         */
        public void setAnnulmentSettlement(AnnulmentType value) {
            this.annulmentSettlement = value;
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
         *         &lt;element name="Contract" minOccurs="0">
         *           &lt;complexType>
         *             &lt;complexContent>
         *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *                 &lt;choice>
         *                   &lt;element name="ContractRootGUID" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType"/>
         *                   &lt;element name="NoContract">
         *                     &lt;complexType>
         *                       &lt;complexContent>
         *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *                           &lt;sequence>
         *                             &lt;element name="FirstContractParty" type="{http://dom.gosuslugi.ru/schema/integration/organizations-registry-base/}RegOrgType"/>
         *                             &lt;element name="DocNum" minOccurs="0">
         *                               &lt;simpleType>
         *                                 &lt;restriction base="{http://dom.gosuslugi.ru/schema/integration/base/}LongTextType">
         *                                   &lt;maxLength value="30"/>
         *                                   &lt;minLength value="1"/>
         *                                 &lt;/restriction>
         *                               &lt;/simpleType>
         *                             &lt;/element>
         *                             &lt;element name="SigningDate" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
         *                           &lt;/sequence>
         *                         &lt;/restriction>
         *                       &lt;/complexContent>
         *                     &lt;/complexType>
         *                   &lt;/element>
         *                 &lt;/choice>
         *               &lt;/restriction>
         *             &lt;/complexContent>
         *           &lt;/complexType>
         *         &lt;/element>
         *         &lt;element name="ReportingPeriod" maxOccurs="unbounded" minOccurs="0">
         *           &lt;complexType>
         *             &lt;complexContent>
         *               &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/bills/}ReportPeriodType">
         *                 &lt;choice>
         *                   &lt;element name="ReportingPeriodInfo" type="{http://dom.gosuslugi.ru/schema/integration/bills/}ReportPeriodIKUInfoType"/>
         *                   &lt;element name="AnnulmentReportingPeriod">
         *                     &lt;complexType>
         *                       &lt;complexContent>
         *                         &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/bills/}AnnulmentType">
         *                         &lt;/extension>
         *                       &lt;/complexContent>
         *                     &lt;/complexType>
         *                   &lt;/element>
         *                 &lt;/choice>
         *               &lt;/extension>
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
            "contract",
            "reportingPeriod"
        })
        public static class Settlement {

            @XmlElement(name = "Contract")
            protected ImportIKUSettlementsRequest.ImportSettlement.Settlement.Contract contract;
            @XmlElement(name = "ReportingPeriod")
            protected List<ImportIKUSettlementsRequest.ImportSettlement.Settlement.ReportingPeriod> reportingPeriod;

            /**
             * Gets the value of the contract property.
             * 
             * @return
             *     possible object is
             *     {@link ImportIKUSettlementsRequest.ImportSettlement.Settlement.Contract }
             *     
             */
            public ImportIKUSettlementsRequest.ImportSettlement.Settlement.Contract getContract() {
                return contract;
            }

            /**
             * Sets the value of the contract property.
             * 
             * @param value
             *     allowed object is
             *     {@link ImportIKUSettlementsRequest.ImportSettlement.Settlement.Contract }
             *     
             */
            public void setContract(ImportIKUSettlementsRequest.ImportSettlement.Settlement.Contract value) {
                this.contract = value;
            }

            /**
             * Gets the value of the reportingPeriod property.
             * 
             * <p>
             * This accessor method returns a reference to the live list,
             * not a snapshot. Therefore any modification you make to the
             * returned list will be present inside the JAXB object.
             * This is why there is not a <CODE>set</CODE> method for the reportingPeriod property.
             * 
             * <p>
             * For example, to add a new item, do as follows:
             * <pre>
             *    getReportingPeriod().add(newItem);
             * </pre>
             * 
             * 
             * <p>
             * Objects of the following type(s) are allowed in the list
             * {@link ImportIKUSettlementsRequest.ImportSettlement.Settlement.ReportingPeriod }
             * 
             * 
             */
            public List<ImportIKUSettlementsRequest.ImportSettlement.Settlement.ReportingPeriod> getReportingPeriod() {
                if (reportingPeriod == null) {
                    reportingPeriod = new ArrayList<ImportIKUSettlementsRequest.ImportSettlement.Settlement.ReportingPeriod>();
                }
                return this.reportingPeriod;
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
             *       &lt;choice>
             *         &lt;element name="ContractRootGUID" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType"/>
             *         &lt;element name="NoContract">
             *           &lt;complexType>
             *             &lt;complexContent>
             *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
             *                 &lt;sequence>
             *                   &lt;element name="FirstContractParty" type="{http://dom.gosuslugi.ru/schema/integration/organizations-registry-base/}RegOrgType"/>
             *                   &lt;element name="DocNum" minOccurs="0">
             *                     &lt;simpleType>
             *                       &lt;restriction base="{http://dom.gosuslugi.ru/schema/integration/base/}LongTextType">
             *                         &lt;maxLength value="30"/>
             *                         &lt;minLength value="1"/>
             *                       &lt;/restriction>
             *                     &lt;/simpleType>
             *                   &lt;/element>
             *                   &lt;element name="SigningDate" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
             *                 &lt;/sequence>
             *               &lt;/restriction>
             *             &lt;/complexContent>
             *           &lt;/complexType>
             *         &lt;/element>
             *       &lt;/choice>
             *     &lt;/restriction>
             *   &lt;/complexContent>
             * &lt;/complexType>
             * </pre>
             * 
             * 
             */
            @XmlAccessorType(XmlAccessType.FIELD)
            @XmlType(name = "", propOrder = {
                "contractRootGUID",
                "noContract"
            })
            public static class Contract {

                @XmlElement(name = "ContractRootGUID")
                protected String contractRootGUID;
                @XmlElement(name = "NoContract")
                protected ImportIKUSettlementsRequest.ImportSettlement.Settlement.Contract.NoContract noContract;

                /**
                 * Gets the value of the contractRootGUID property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getContractRootGUID() {
                    return contractRootGUID;
                }

                /**
                 * Sets the value of the contractRootGUID property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setContractRootGUID(String value) {
                    this.contractRootGUID = value;
                }

                /**
                 * Gets the value of the noContract property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link ImportIKUSettlementsRequest.ImportSettlement.Settlement.Contract.NoContract }
                 *     
                 */
                public ImportIKUSettlementsRequest.ImportSettlement.Settlement.Contract.NoContract getNoContract() {
                    return noContract;
                }

                /**
                 * Sets the value of the noContract property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link ImportIKUSettlementsRequest.ImportSettlement.Settlement.Contract.NoContract }
                 *     
                 */
                public void setNoContract(ImportIKUSettlementsRequest.ImportSettlement.Settlement.Contract.NoContract value) {
                    this.noContract = value;
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
                 *         &lt;element name="FirstContractParty" type="{http://dom.gosuslugi.ru/schema/integration/organizations-registry-base/}RegOrgType"/>
                 *         &lt;element name="DocNum" minOccurs="0">
                 *           &lt;simpleType>
                 *             &lt;restriction base="{http://dom.gosuslugi.ru/schema/integration/base/}LongTextType">
                 *               &lt;maxLength value="30"/>
                 *               &lt;minLength value="1"/>
                 *             &lt;/restriction>
                 *           &lt;/simpleType>
                 *         &lt;/element>
                 *         &lt;element name="SigningDate" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
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
                    "firstContractParty",
                    "docNum",
                    "signingDate"
                })
                public static class NoContract {

                    @XmlElement(name = "FirstContractParty", required = true)
                    protected RegOrgType firstContractParty;
                    @XmlElement(name = "DocNum")
                    protected String docNum;
                    @XmlElement(name = "SigningDate")
                    @XmlSchemaType(name = "date")
                    protected XMLGregorianCalendar signingDate;

                    /**
                     * Gets the value of the firstContractParty property.
                     * 
                     * @return
                     *     possible object is
                     *     {@link RegOrgType }
                     *     
                     */
                    public RegOrgType getFirstContractParty() {
                        return firstContractParty;
                    }

                    /**
                     * Sets the value of the firstContractParty property.
                     * 
                     * @param value
                     *     allowed object is
                     *     {@link RegOrgType }
                     *     
                     */
                    public void setFirstContractParty(RegOrgType value) {
                        this.firstContractParty = value;
                    }

                    /**
                     * Gets the value of the docNum property.
                     * 
                     * @return
                     *     possible object is
                     *     {@link String }
                     *     
                     */
                    public String getDocNum() {
                        return docNum;
                    }

                    /**
                     * Sets the value of the docNum property.
                     * 
                     * @param value
                     *     allowed object is
                     *     {@link String }
                     *     
                     */
                    public void setDocNum(String value) {
                        this.docNum = value;
                    }

                    /**
                     * Gets the value of the signingDate property.
                     * 
                     * @return
                     *     possible object is
                     *     {@link XMLGregorianCalendar }
                     *     
                     */
                    public XMLGregorianCalendar getSigningDate() {
                        return signingDate;
                    }

                    /**
                     * Sets the value of the signingDate property.
                     * 
                     * @param value
                     *     allowed object is
                     *     {@link XMLGregorianCalendar }
                     *     
                     */
                    public void setSigningDate(XMLGregorianCalendar value) {
                        this.signingDate = value;
                    }

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
             *     &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/bills/}ReportPeriodType">
             *       &lt;choice>
             *         &lt;element name="ReportingPeriodInfo" type="{http://dom.gosuslugi.ru/schema/integration/bills/}ReportPeriodIKUInfoType"/>
             *         &lt;element name="AnnulmentReportingPeriod">
             *           &lt;complexType>
             *             &lt;complexContent>
             *               &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/bills/}AnnulmentType">
             *               &lt;/extension>
             *             &lt;/complexContent>
             *           &lt;/complexType>
             *         &lt;/element>
             *       &lt;/choice>
             *     &lt;/extension>
             *   &lt;/complexContent>
             * &lt;/complexType>
             * </pre>
             * 
             * 
             */
            @XmlAccessorType(XmlAccessType.FIELD)
            @XmlType(name = "", propOrder = {
                "reportingPeriodInfo",
                "annulmentReportingPeriod"
            })
            public static class ReportingPeriod
                extends ReportPeriodType
            {

                @XmlElement(name = "ReportingPeriodInfo")
                protected ReportPeriodIKUInfoType reportingPeriodInfo;
                @XmlElement(name = "AnnulmentReportingPeriod")
                protected ImportIKUSettlementsRequest.ImportSettlement.Settlement.ReportingPeriod.AnnulmentReportingPeriod annulmentReportingPeriod;

                /**
                 * Gets the value of the reportingPeriodInfo property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link ReportPeriodIKUInfoType }
                 *     
                 */
                public ReportPeriodIKUInfoType getReportingPeriodInfo() {
                    return reportingPeriodInfo;
                }

                /**
                 * Sets the value of the reportingPeriodInfo property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link ReportPeriodIKUInfoType }
                 *     
                 */
                public void setReportingPeriodInfo(ReportPeriodIKUInfoType value) {
                    this.reportingPeriodInfo = value;
                }

                /**
                 * Gets the value of the annulmentReportingPeriod property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link ImportIKUSettlementsRequest.ImportSettlement.Settlement.ReportingPeriod.AnnulmentReportingPeriod }
                 *     
                 */
                public ImportIKUSettlementsRequest.ImportSettlement.Settlement.ReportingPeriod.AnnulmentReportingPeriod getAnnulmentReportingPeriod() {
                    return annulmentReportingPeriod;
                }

                /**
                 * Sets the value of the annulmentReportingPeriod property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link ImportIKUSettlementsRequest.ImportSettlement.Settlement.ReportingPeriod.AnnulmentReportingPeriod }
                 *     
                 */
                public void setAnnulmentReportingPeriod(ImportIKUSettlementsRequest.ImportSettlement.Settlement.ReportingPeriod.AnnulmentReportingPeriod value) {
                    this.annulmentReportingPeriod = value;
                }


                /**
                 * <p>Java class for anonymous complex type.
                 * 
                 * <p>The following schema fragment specifies the expected content contained within this class.
                 * 
                 * <pre>
                 * &lt;complexType>
                 *   &lt;complexContent>
                 *     &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/bills/}AnnulmentType">
                 *     &lt;/extension>
                 *   &lt;/complexContent>
                 * &lt;/complexType>
                 * </pre>
                 * 
                 * 
                 */
                @XmlAccessorType(XmlAccessType.FIELD)
                @XmlType(name = "")
                public static class AnnulmentReportingPeriod
                    extends AnnulmentType
                {


                }

            }

        }

    }

}
