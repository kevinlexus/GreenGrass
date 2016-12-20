
package ru.gosuslugi.dom.schema.integration.msp;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Расчет компенсации по стандартам стоимости жилищно-коммунальных услуг
 * 
 * <p>Java class for StandardCompensationType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="StandardCompensationType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="FamilySize" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}int">
 *               &lt;minInclusive value="0"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="PaymentSum" type="{http://dom.gosuslugi.ru/schema/integration/msp/}MoneyType" minOccurs="0"/>
 *         &lt;element name="CompensationSum" type="{http://dom.gosuslugi.ru/schema/integration/msp/}MoneyNonNegativeType" minOccurs="0"/>
 *         &lt;element name="RecalculationSum" type="{http://dom.gosuslugi.ru/schema/integration/msp/}MoneyType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "StandardCompensationType", propOrder = {
    "familySize",
    "paymentSum",
    "compensationSum",
    "recalculationSum"
})
public class StandardCompensationType {

    @XmlElement(name = "FamilySize")
    protected Integer familySize;
    @XmlElement(name = "PaymentSum")
    protected BigDecimal paymentSum;
    @XmlElement(name = "CompensationSum")
    protected BigDecimal compensationSum;
    @XmlElement(name = "RecalculationSum")
    protected BigDecimal recalculationSum;

    /**
     * Gets the value of the familySize property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getFamilySize() {
        return familySize;
    }

    /**
     * Sets the value of the familySize property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setFamilySize(Integer value) {
        this.familySize = value;
    }

    /**
     * Gets the value of the paymentSum property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getPaymentSum() {
        return paymentSum;
    }

    /**
     * Sets the value of the paymentSum property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setPaymentSum(BigDecimal value) {
        this.paymentSum = value;
    }

    /**
     * Gets the value of the compensationSum property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getCompensationSum() {
        return compensationSum;
    }

    /**
     * Sets the value of the compensationSum property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setCompensationSum(BigDecimal value) {
        this.compensationSum = value;
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

}
