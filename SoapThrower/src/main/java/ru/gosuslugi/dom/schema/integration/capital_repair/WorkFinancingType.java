
package ru.gosuslugi.dom.schema.integration.capital_repair;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Финансирование работы в КПР
 * 
 * <p>Java class for WorkFinancingType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="WorkFinancingType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Fund" type="{http://dom.gosuslugi.ru/schema/integration/bills-base/}MoneyPositiveType"/>
 *         &lt;element name="RegionBudget" type="{http://dom.gosuslugi.ru/schema/integration/bills-base/}MoneyPositiveType"/>
 *         &lt;element name="MunicipalBudget" type="{http://dom.gosuslugi.ru/schema/integration/bills-base/}MoneyPositiveType"/>
 *         &lt;element name="Owners" type="{http://dom.gosuslugi.ru/schema/integration/bills-base/}MoneyPositiveType"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "WorkFinancingType", propOrder = {
    "fund",
    "regionBudget",
    "municipalBudget",
    "owners"
})
public class WorkFinancingType {

    @XmlElement(name = "Fund", required = true)
    protected BigDecimal fund;
    @XmlElement(name = "RegionBudget", required = true)
    protected BigDecimal regionBudget;
    @XmlElement(name = "MunicipalBudget", required = true)
    protected BigDecimal municipalBudget;
    @XmlElement(name = "Owners", required = true)
    protected BigDecimal owners;

    /**
     * Gets the value of the fund property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getFund() {
        return fund;
    }

    /**
     * Sets the value of the fund property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setFund(BigDecimal value) {
        this.fund = value;
    }

    /**
     * Gets the value of the regionBudget property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getRegionBudget() {
        return regionBudget;
    }

    /**
     * Sets the value of the regionBudget property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setRegionBudget(BigDecimal value) {
        this.regionBudget = value;
    }

    /**
     * Gets the value of the municipalBudget property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getMunicipalBudget() {
        return municipalBudget;
    }

    /**
     * Sets the value of the municipalBudget property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setMunicipalBudget(BigDecimal value) {
        this.municipalBudget = value;
    }

    /**
     * Gets the value of the owners property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getOwners() {
        return owners;
    }

    /**
     * Sets the value of the owners property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setOwners(BigDecimal value) {
        this.owners = value;
    }

}
