
package ru.gosuslugi.dom.schema.integration.msp;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * Расчеты и перерасчеты для гражданина, получающего субсидии
 * 
 * <p>Java class for CitizenSubsidyCalculationType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="CitizenSubsidyCalculationType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="PeriodDate" type="{http://www.w3.org/2001/XMLSchema}gYearMonth"/>
 *         &lt;element name="CalculationDate" type="{http://www.w3.org/2001/XMLSchema}date"/>
 *         &lt;element name="FamilySize">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}int">
 *               &lt;minInclusive value="0"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="ActualExpensesSum" type="{http://dom.gosuslugi.ru/schema/integration/msp/}MoneyType"/>
 *         &lt;element name="SubsidySum" type="{http://dom.gosuslugi.ru/schema/integration/msp/}MoneyType" minOccurs="0"/>
 *         &lt;element name="RecalculationSum" type="{http://dom.gosuslugi.ru/schema/integration/msp/}MoneyType" minOccurs="0"/>
 *         &lt;element name="TotalSum" type="{http://dom.gosuslugi.ru/schema/integration/msp/}MoneyType"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CitizenSubsidyCalculationType", propOrder = {
    "periodDate",
    "calculationDate",
    "familySize",
    "actualExpensesSum",
    "subsidySum",
    "recalculationSum",
    "totalSum"
})
public class CitizenSubsidyCalculationType {

    @XmlElement(name = "PeriodDate", required = true)
    @XmlSchemaType(name = "gYearMonth")
    protected XMLGregorianCalendar periodDate;
    @XmlElement(name = "CalculationDate", required = true)
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar calculationDate;
    @XmlElement(name = "FamilySize")
    protected int familySize;
    @XmlElement(name = "ActualExpensesSum", required = true)
    protected BigDecimal actualExpensesSum;
    @XmlElement(name = "SubsidySum")
    protected BigDecimal subsidySum;
    @XmlElement(name = "RecalculationSum")
    protected BigDecimal recalculationSum;
    @XmlElement(name = "TotalSum", required = true)
    protected BigDecimal totalSum;

    /**
     * Gets the value of the periodDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getPeriodDate() {
        return periodDate;
    }

    /**
     * Sets the value of the periodDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setPeriodDate(XMLGregorianCalendar value) {
        this.periodDate = value;
    }

    /**
     * Gets the value of the calculationDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getCalculationDate() {
        return calculationDate;
    }

    /**
     * Sets the value of the calculationDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setCalculationDate(XMLGregorianCalendar value) {
        this.calculationDate = value;
    }

    /**
     * Gets the value of the familySize property.
     * 
     */
    public int getFamilySize() {
        return familySize;
    }

    /**
     * Sets the value of the familySize property.
     * 
     */
    public void setFamilySize(int value) {
        this.familySize = value;
    }

    /**
     * Gets the value of the actualExpensesSum property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getActualExpensesSum() {
        return actualExpensesSum;
    }

    /**
     * Sets the value of the actualExpensesSum property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setActualExpensesSum(BigDecimal value) {
        this.actualExpensesSum = value;
    }

    /**
     * Gets the value of the subsidySum property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getSubsidySum() {
        return subsidySum;
    }

    /**
     * Sets the value of the subsidySum property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setSubsidySum(BigDecimal value) {
        this.subsidySum = value;
    }

    /**
     * Gets the value of the recalculationSum property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getRecalculationSum() {
        return recalculationSum;
    }

    /**
     * Sets the value of the recalculationSum property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setRecalculationSum(BigDecimal value) {
        this.recalculationSum = value;
    }

    /**
     * Gets the value of the totalSum property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getTotalSum() {
        return totalSum;
    }

    /**
     * Sets the value of the totalSum property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setTotalSum(BigDecimal value) {
        this.totalSum = value;
    }

}
