
package ru.gosuslugi.dom.schema.integration.bills;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;
import ru.gosuslugi.dom.schema.integration.organizations_registry_base.RegOrgType;


/**
 * Тип для экспорта информации о состоянии расчетов
 * 
 * <p>Java class for ExportSettlementResultType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ExportSettlementResultType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="SettlementGUID" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType"/>
 *         &lt;element name="Contract">
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
 *         &lt;element name="ReportingPeriod" maxOccurs="unbounded">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/bills/}ReportPeriodType">
 *                 &lt;sequence>
 *                   &lt;choice>
 *                     &lt;element name="ReportPeriodRSOInfo" type="{http://dom.gosuslugi.ru/schema/integration/bills/}ReportPeriodRSOInfoType"/>
 *                     &lt;element name="ReportPeriodIKUInfo" type="{http://dom.gosuslugi.ru/schema/integration/bills/}ReportPeriodIKUInfoType"/>
 *                   &lt;/choice>
 *                   &lt;element name="ReportPeriodStatus">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="Status">
 *                               &lt;simpleType>
 *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                                   &lt;enumeration value="Posted"/>
 *                                   &lt;enumeration value="Draft"/>
 *                                   &lt;enumeration value="Annul"/>
 *                                 &lt;/restriction>
 *                               &lt;/simpleType>
 *                             &lt;/element>
 *                             &lt;element name="ReasonOfAnnulment" minOccurs="0">
 *                               &lt;simpleType>
 *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                                   &lt;maxLength value="1000"/>
 *                                 &lt;/restriction>
 *                               &lt;/simpleType>
 *                             &lt;/element>
 *                           &lt;/sequence>
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                 &lt;/sequence>
 *               &lt;/extension>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="Annuled" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="ReasonOfAnnulment">
 *                     &lt;simpleType>
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                         &lt;maxLength value="1000"/>
 *                       &lt;/restriction>
 *                     &lt;/simpleType>
 *                   &lt;/element>
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
@XmlType(name = "ExportSettlementResultType", propOrder = {
    "settlementGUID",
    "contract",
    "reportingPeriod",
    "annuled"
})
public class ExportSettlementResultType {

    @XmlElement(name = "SettlementGUID", required = true)
    protected String settlementGUID;
    @XmlElement(name = "Contract", required = true)
    protected ExportSettlementResultType.Contract contract;
    @XmlElement(name = "ReportingPeriod", required = true)
    protected List<ExportSettlementResultType.ReportingPeriod> reportingPeriod;
    @XmlElement(name = "Annuled")
    protected ExportSettlementResultType.Annuled annuled;

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
     * Gets the value of the contract property.
     * 
     * @return
     *     possible object is
     *     {@link ExportSettlementResultType.Contract }
     *     
     */
    public ExportSettlementResultType.Contract getContract() {
        return contract;
    }

    /**
     * Sets the value of the contract property.
     * 
     * @param value
     *     allowed object is
     *     {@link ExportSettlementResultType.Contract }
     *     
     */
    public void setContract(ExportSettlementResultType.Contract value) {
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
     * {@link ExportSettlementResultType.ReportingPeriod }
     * 
     * 
     */
    public List<ExportSettlementResultType.ReportingPeriod> getReportingPeriod() {
        if (reportingPeriod == null) {
            reportingPeriod = new ArrayList<ExportSettlementResultType.ReportingPeriod>();
        }
        return this.reportingPeriod;
    }

    /**
     * Gets the value of the annuled property.
     * 
     * @return
     *     possible object is
     *     {@link ExportSettlementResultType.Annuled }
     *     
     */
    public ExportSettlementResultType.Annuled getAnnuled() {
        return annuled;
    }

    /**
     * Sets the value of the annuled property.
     * 
     * @param value
     *     allowed object is
     *     {@link ExportSettlementResultType.Annuled }
     *     
     */
    public void setAnnuled(ExportSettlementResultType.Annuled value) {
        this.annuled = value;
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
     *         &lt;element name="ReasonOfAnnulment">
     *           &lt;simpleType>
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *               &lt;maxLength value="1000"/>
     *             &lt;/restriction>
     *           &lt;/simpleType>
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
        "reasonOfAnnulment"
    })
    public static class Annuled {

        @XmlElement(name = "ReasonOfAnnulment", required = true)
        protected String reasonOfAnnulment;

        /**
         * Gets the value of the reasonOfAnnulment property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getReasonOfAnnulment() {
            return reasonOfAnnulment;
        }

        /**
         * Sets the value of the reasonOfAnnulment property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setReasonOfAnnulment(String value) {
            this.reasonOfAnnulment = value;
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
        protected ExportSettlementResultType.Contract.NoContract noContract;

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
         *     {@link ExportSettlementResultType.Contract.NoContract }
         *     
         */
        public ExportSettlementResultType.Contract.NoContract getNoContract() {
            return noContract;
        }

        /**
         * Sets the value of the noContract property.
         * 
         * @param value
         *     allowed object is
         *     {@link ExportSettlementResultType.Contract.NoContract }
         *     
         */
        public void setNoContract(ExportSettlementResultType.Contract.NoContract value) {
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
     *       &lt;sequence>
     *         &lt;choice>
     *           &lt;element name="ReportPeriodRSOInfo" type="{http://dom.gosuslugi.ru/schema/integration/bills/}ReportPeriodRSOInfoType"/>
     *           &lt;element name="ReportPeriodIKUInfo" type="{http://dom.gosuslugi.ru/schema/integration/bills/}ReportPeriodIKUInfoType"/>
     *         &lt;/choice>
     *         &lt;element name="ReportPeriodStatus">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element name="Status">
     *                     &lt;simpleType>
     *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *                         &lt;enumeration value="Posted"/>
     *                         &lt;enumeration value="Draft"/>
     *                         &lt;enumeration value="Annul"/>
     *                       &lt;/restriction>
     *                     &lt;/simpleType>
     *                   &lt;/element>
     *                   &lt;element name="ReasonOfAnnulment" minOccurs="0">
     *                     &lt;simpleType>
     *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *                         &lt;maxLength value="1000"/>
     *                       &lt;/restriction>
     *                     &lt;/simpleType>
     *                   &lt;/element>
     *                 &lt;/sequence>
     *               &lt;/restriction>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
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
        "reportPeriodRSOInfo",
        "reportPeriodIKUInfo",
        "reportPeriodStatus"
    })
    public static class ReportingPeriod
        extends ReportPeriodType
    {

        @XmlElement(name = "ReportPeriodRSOInfo")
        protected ReportPeriodRSOInfoType reportPeriodRSOInfo;
        @XmlElement(name = "ReportPeriodIKUInfo")
        protected ReportPeriodIKUInfoType reportPeriodIKUInfo;
        @XmlElement(name = "ReportPeriodStatus", required = true)
        protected ExportSettlementResultType.ReportingPeriod.ReportPeriodStatus reportPeriodStatus;

        /**
         * Gets the value of the reportPeriodRSOInfo property.
         * 
         * @return
         *     possible object is
         *     {@link ReportPeriodRSOInfoType }
         *     
         */
        public ReportPeriodRSOInfoType getReportPeriodRSOInfo() {
            return reportPeriodRSOInfo;
        }

        /**
         * Sets the value of the reportPeriodRSOInfo property.
         * 
         * @param value
         *     allowed object is
         *     {@link ReportPeriodRSOInfoType }
         *     
         */
        public void setReportPeriodRSOInfo(ReportPeriodRSOInfoType value) {
            this.reportPeriodRSOInfo = value;
        }

        /**
         * Gets the value of the reportPeriodIKUInfo property.
         * 
         * @return
         *     possible object is
         *     {@link ReportPeriodIKUInfoType }
         *     
         */
        public ReportPeriodIKUInfoType getReportPeriodIKUInfo() {
            return reportPeriodIKUInfo;
        }

        /**
         * Sets the value of the reportPeriodIKUInfo property.
         * 
         * @param value
         *     allowed object is
         *     {@link ReportPeriodIKUInfoType }
         *     
         */
        public void setReportPeriodIKUInfo(ReportPeriodIKUInfoType value) {
            this.reportPeriodIKUInfo = value;
        }

        /**
         * Gets the value of the reportPeriodStatus property.
         * 
         * @return
         *     possible object is
         *     {@link ExportSettlementResultType.ReportingPeriod.ReportPeriodStatus }
         *     
         */
        public ExportSettlementResultType.ReportingPeriod.ReportPeriodStatus getReportPeriodStatus() {
            return reportPeriodStatus;
        }

        /**
         * Sets the value of the reportPeriodStatus property.
         * 
         * @param value
         *     allowed object is
         *     {@link ExportSettlementResultType.ReportingPeriod.ReportPeriodStatus }
         *     
         */
        public void setReportPeriodStatus(ExportSettlementResultType.ReportingPeriod.ReportPeriodStatus value) {
            this.reportPeriodStatus = value;
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
         *         &lt;element name="Status">
         *           &lt;simpleType>
         *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
         *               &lt;enumeration value="Posted"/>
         *               &lt;enumeration value="Draft"/>
         *               &lt;enumeration value="Annul"/>
         *             &lt;/restriction>
         *           &lt;/simpleType>
         *         &lt;/element>
         *         &lt;element name="ReasonOfAnnulment" minOccurs="0">
         *           &lt;simpleType>
         *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
         *               &lt;maxLength value="1000"/>
         *             &lt;/restriction>
         *           &lt;/simpleType>
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
            "status",
            "reasonOfAnnulment"
        })
        public static class ReportPeriodStatus {

            @XmlElement(name = "Status", required = true)
            protected String status;
            @XmlElement(name = "ReasonOfAnnulment")
            protected String reasonOfAnnulment;

            /**
             * Gets the value of the status property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getStatus() {
                return status;
            }

            /**
             * Sets the value of the status property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setStatus(String value) {
                this.status = value;
            }

            /**
             * Gets the value of the reasonOfAnnulment property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getReasonOfAnnulment() {
                return reasonOfAnnulment;
            }

            /**
             * Sets the value of the reasonOfAnnulment property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setReasonOfAnnulment(String value) {
                this.reasonOfAnnulment = value;
            }

        }

    }

}
