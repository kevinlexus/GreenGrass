
package ru.gosuslugi.dom.schema.integration.bills;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
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
 *       &lt;choice>
 *         &lt;element name="ContractRootGUID" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType" maxOccurs="unbounded"/>
 *         &lt;element name="SettlementGUID" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType" maxOccurs="unbounded"/>
 *         &lt;sequence>
 *           &lt;element name="ContractNumber" minOccurs="0">
 *             &lt;simpleType>
 *               &lt;restriction base="{http://dom.gosuslugi.ru/schema/integration/base/}LongTextType">
 *                 &lt;maxLength value="20"/>
 *                 &lt;minLength value="1"/>
 *               &lt;/restriction>
 *             &lt;/simpleType>
 *           &lt;/element>
 *           &lt;element name="OtherContractParty" type="{http://dom.gosuslugi.ru/schema/integration/organizations-registry-base/}RegOrgType" minOccurs="0"/>
 *           &lt;element name="Period" minOccurs="0">
 *             &lt;complexType>
 *               &lt;complexContent>
 *                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                   &lt;sequence>
 *                     &lt;element name="PeriodFrom" type="{http://dom.gosuslugi.ru/schema/integration/bills/}ReportPeriodType" minOccurs="0"/>
 *                     &lt;element name="PeriodTo" type="{http://dom.gosuslugi.ru/schema/integration/bills/}ReportPeriodType" minOccurs="0"/>
 *                   &lt;/sequence>
 *                 &lt;/restriction>
 *               &lt;/complexContent>
 *             &lt;/complexType>
 *           &lt;/element>
 *         &lt;/sequence>
 *       &lt;/choice>
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
    "contractRootGUID",
    "settlementGUID",
    "contractNumber",
    "otherContractParty",
    "period"
})
@XmlRootElement(name = "exportSettlementsRequest")
public class ExportSettlementsRequest
    extends BaseType
{

    @XmlElement(name = "ContractRootGUID")
    protected List<String> contractRootGUID;
    @XmlElement(name = "SettlementGUID")
    protected List<String> settlementGUID;
    @XmlElement(name = "ContractNumber")
    protected String contractNumber;
    @XmlElement(name = "OtherContractParty")
    protected RegOrgType otherContractParty;
    @XmlElement(name = "Period")
    protected ExportSettlementsRequest.Period period;
    @XmlAttribute(name = "version", namespace = "http://dom.gosuslugi.ru/schema/integration/base/", required = true)
    protected String version;

    /**
     * Gets the value of the contractRootGUID property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the contractRootGUID property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getContractRootGUID().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getContractRootGUID() {
        if (contractRootGUID == null) {
            contractRootGUID = new ArrayList<String>();
        }
        return this.contractRootGUID;
    }

    /**
     * Gets the value of the settlementGUID property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the settlementGUID property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSettlementGUID().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getSettlementGUID() {
        if (settlementGUID == null) {
            settlementGUID = new ArrayList<String>();
        }
        return this.settlementGUID;
    }

    /**
     * Gets the value of the contractNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getContractNumber() {
        return contractNumber;
    }

    /**
     * Sets the value of the contractNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setContractNumber(String value) {
        this.contractNumber = value;
    }

    /**
     * Gets the value of the otherContractParty property.
     * 
     * @return
     *     possible object is
     *     {@link RegOrgType }
     *     
     */
    public RegOrgType getOtherContractParty() {
        return otherContractParty;
    }

    /**
     * Sets the value of the otherContractParty property.
     * 
     * @param value
     *     allowed object is
     *     {@link RegOrgType }
     *     
     */
    public void setOtherContractParty(RegOrgType value) {
        this.otherContractParty = value;
    }

    /**
     * Gets the value of the period property.
     * 
     * @return
     *     possible object is
     *     {@link ExportSettlementsRequest.Period }
     *     
     */
    public ExportSettlementsRequest.Period getPeriod() {
        return period;
    }

    /**
     * Sets the value of the period property.
     * 
     * @param value
     *     allowed object is
     *     {@link ExportSettlementsRequest.Period }
     *     
     */
    public void setPeriod(ExportSettlementsRequest.Period value) {
        this.period = value;
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
     *         &lt;element name="PeriodFrom" type="{http://dom.gosuslugi.ru/schema/integration/bills/}ReportPeriodType" minOccurs="0"/>
     *         &lt;element name="PeriodTo" type="{http://dom.gosuslugi.ru/schema/integration/bills/}ReportPeriodType" minOccurs="0"/>
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
        "periodFrom",
        "periodTo"
    })
    public static class Period {

        @XmlElement(name = "PeriodFrom")
        protected ReportPeriodType periodFrom;
        @XmlElement(name = "PeriodTo")
        protected ReportPeriodType periodTo;

        /**
         * Gets the value of the periodFrom property.
         * 
         * @return
         *     possible object is
         *     {@link ReportPeriodType }
         *     
         */
        public ReportPeriodType getPeriodFrom() {
            return periodFrom;
        }

        /**
         * Sets the value of the periodFrom property.
         * 
         * @param value
         *     allowed object is
         *     {@link ReportPeriodType }
         *     
         */
        public void setPeriodFrom(ReportPeriodType value) {
            this.periodFrom = value;
        }

        /**
         * Gets the value of the periodTo property.
         * 
         * @return
         *     possible object is
         *     {@link ReportPeriodType }
         *     
         */
        public ReportPeriodType getPeriodTo() {
            return periodTo;
        }

        /**
         * Sets the value of the periodTo property.
         * 
         * @param value
         *     allowed object is
         *     {@link ReportPeriodType }
         *     
         */
        public void setPeriodTo(ReportPeriodType value) {
            this.periodTo = value;
        }

    }

}
