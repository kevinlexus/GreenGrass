
package ru.gosuslugi.dom.schema.integration.bills;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for CapitalRepairType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="CapitalRepairType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Contribution" type="{http://dom.gosuslugi.ru/schema/integration/bills-base/}MoneyType"/>
 *         &lt;element name="AccountingPeriodTotal" type="{http://dom.gosuslugi.ru/schema/integration/bills-base/}MoneyType"/>
 *         &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/bills/}MoneyRecalculation"/>
 *         &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/bills/}MoneyDiscount"/>
 *         &lt;element name="TotalPayable" type="{http://dom.gosuslugi.ru/schema/integration/bills-base/}MoneyType"/>
 *         &lt;element name="orgPPAGUID" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CapitalRepairType", propOrder = {
    "contribution",
    "accountingPeriodTotal",
    "moneyRecalculation",
    "moneyDiscount",
    "totalPayable",
    "orgPPAGUID"
})
public class CapitalRepairType {

    @XmlElement(name = "Contribution", required = true)
    protected BigDecimal contribution;
    @XmlElement(name = "AccountingPeriodTotal", required = true)
    protected BigDecimal accountingPeriodTotal;
    @XmlElement(name = "MoneyRecalculation", required = true)
    protected BigDecimal moneyRecalculation;
    @XmlElement(name = "MoneyDiscount", required = true)
    protected BigDecimal moneyDiscount;
    @XmlElement(name = "TotalPayable", required = true)
    protected BigDecimal totalPayable;
    protected String orgPPAGUID;

    /**
     * Gets the value of the contribution property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getContribution() {
        return contribution;
    }

    /**
     * Sets the value of the contribution property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setContribution(BigDecimal value) {
        this.contribution = value;
    }

    /**
     * Gets the value of the accountingPeriodTotal property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getAccountingPeriodTotal() {
        return accountingPeriodTotal;
    }

    /**
     * Sets the value of the accountingPeriodTotal property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setAccountingPeriodTotal(BigDecimal value) {
        this.accountingPeriodTotal = value;
    }

    /**
     * Gets the value of the moneyRecalculation property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getMoneyRecalculation() {
        return moneyRecalculation;
    }

    /**
     * Sets the value of the moneyRecalculation property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setMoneyRecalculation(BigDecimal value) {
        this.moneyRecalculation = value;
    }

    /**
     * Gets the value of the moneyDiscount property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getMoneyDiscount() {
        return moneyDiscount;
    }

    /**
     * Sets the value of the moneyDiscount property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setMoneyDiscount(BigDecimal value) {
        this.moneyDiscount = value;
    }

    /**
     * Gets the value of the totalPayable property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getTotalPayable() {
        return totalPayable;
    }

    /**
     * Sets the value of the totalPayable property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setTotalPayable(BigDecimal value) {
        this.totalPayable = value;
    }

    /**
     * Gets the value of the orgPPAGUID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOrgPPAGUID() {
        return orgPPAGUID;
    }

    /**
     * Sets the value of the orgPPAGUID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOrgPPAGUID(String value) {
        this.orgPPAGUID = value;
    }

}
