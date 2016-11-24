
package ru.gosuslugi.dom.schema.integration.capital_repair;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;
import ru.gosuslugi.dom.schema.integration.base.OKTMORefType;


/**
 * Информация о совершенных операциях и остатках по счету
 * 
 * <p>Java class for OperationAndBalanceInfoType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="OperationAndBalanceInfoType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="OKTMO" type="{http://dom.gosuslugi.ru/schema/integration/base/}OKTMORefType"/>
 *         &lt;element name="ReportingPeriod" type="{http://dom.gosuslugi.ru/schema/integration/capital-repair/}ReportingPeriodType"/>
 *         &lt;element name="PeriodBeginningBalance" type="{http://dom.gosuslugi.ru/schema/integration/bills-base/}MoneyPositiveType"/>
 *         &lt;element name="PeriodEndBalance" type="{http://dom.gosuslugi.ru/schema/integration/bills-base/}MoneyPositiveType"/>
 *         &lt;element name="Operation" type="{http://dom.gosuslugi.ru/schema/integration/capital-repair/}OperationType" maxOccurs="1000" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "OperationAndBalanceInfoType", propOrder = {
    "oktmo",
    "reportingPeriod",
    "periodBeginningBalance",
    "periodEndBalance",
    "operation"
})
@XmlSeeAlso({
    ru.gosuslugi.dom.schema.integration.capital_repair.ImportOperationAndBalanceRequest.ImportOperationAndBalance.OperationAndBalanceInfo.class,
    ExportOperationAndBalanceType.class
})
public class OperationAndBalanceInfoType {

    @XmlElement(name = "OKTMO", required = true)
    protected OKTMORefType oktmo;
    @XmlElement(name = "ReportingPeriod", required = true)
    protected ReportingPeriodType reportingPeriod;
    @XmlElement(name = "PeriodBeginningBalance", required = true)
    protected BigDecimal periodBeginningBalance;
    @XmlElement(name = "PeriodEndBalance", required = true)
    protected BigDecimal periodEndBalance;
    @XmlElement(name = "Operation")
    protected List<OperationType> operation;

    /**
     * Gets the value of the oktmo property.
     * 
     * @return
     *     possible object is
     *     {@link OKTMORefType }
     *     
     */
    public OKTMORefType getOKTMO() {
        return oktmo;
    }

    /**
     * Sets the value of the oktmo property.
     * 
     * @param value
     *     allowed object is
     *     {@link OKTMORefType }
     *     
     */
    public void setOKTMO(OKTMORefType value) {
        this.oktmo = value;
    }

    /**
     * Gets the value of the reportingPeriod property.
     * 
     * @return
     *     possible object is
     *     {@link ReportingPeriodType }
     *     
     */
    public ReportingPeriodType getReportingPeriod() {
        return reportingPeriod;
    }

    /**
     * Sets the value of the reportingPeriod property.
     * 
     * @param value
     *     allowed object is
     *     {@link ReportingPeriodType }
     *     
     */
    public void setReportingPeriod(ReportingPeriodType value) {
        this.reportingPeriod = value;
    }

    /**
     * Gets the value of the periodBeginningBalance property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getPeriodBeginningBalance() {
        return periodBeginningBalance;
    }

    /**
     * Sets the value of the periodBeginningBalance property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setPeriodBeginningBalance(BigDecimal value) {
        this.periodBeginningBalance = value;
    }

    /**
     * Gets the value of the periodEndBalance property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getPeriodEndBalance() {
        return periodEndBalance;
    }

    /**
     * Sets the value of the periodEndBalance property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setPeriodEndBalance(BigDecimal value) {
        this.periodEndBalance = value;
    }

    /**
     * Gets the value of the operation property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the operation property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getOperation().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link OperationType }
     * 
     * 
     */
    public List<OperationType> getOperation() {
        if (operation == null) {
            operation = new ArrayList<OperationType>();
        }
        return this.operation;
    }

}
