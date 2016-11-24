
package ru.gosuslugi.dom.schema.integration.bills;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


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
 *         &lt;element name="paymentPeriodPiecemealPaymentSum" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}decimal">
 *               &lt;fractionDigits value="2"/>
 *               &lt;minInclusive value="0"/>
 *               &lt;maxInclusive value="9999999999.99"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="pastPaymentPeriodPiecemealPaymentSum" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}decimal">
 *               &lt;fractionDigits value="2"/>
 *               &lt;minInclusive value="0"/>
 *               &lt;maxInclusive value="9999999999.99"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="piecemealPaymentPercentRub">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}decimal">
 *               &lt;fractionDigits value="2"/>
 *               &lt;minInclusive value="0"/>
 *               &lt;maxInclusive value="9999999999.99"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="piecemealPaymentPercent">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}decimal">
 *               &lt;minInclusive value="0"/>
 *               &lt;maxInclusive value="100"/>
 *               &lt;fractionDigits value="2"/>
 *               &lt;totalDigits value="5"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="piecemealPaymentSum">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}decimal">
 *               &lt;fractionDigits value="2"/>
 *               &lt;minInclusive value="0"/>
 *               &lt;maxInclusive value="9999999999.99"/>
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
    "paymentPeriodPiecemealPaymentSum",
    "pastPaymentPeriodPiecemealPaymentSum",
    "piecemealPaymentPercentRub",
    "piecemealPaymentPercent",
    "piecemealPaymentSum"
})
@XmlRootElement(name = "PiecemealPayment")
public class PiecemealPayment {

    protected BigDecimal paymentPeriodPiecemealPaymentSum;
    protected BigDecimal pastPaymentPeriodPiecemealPaymentSum;
    @XmlElement(required = true)
    protected BigDecimal piecemealPaymentPercentRub;
    @XmlElement(required = true)
    protected BigDecimal piecemealPaymentPercent;
    @XmlElement(required = true)
    protected BigDecimal piecemealPaymentSum;

    /**
     * Gets the value of the paymentPeriodPiecemealPaymentSum property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getPaymentPeriodPiecemealPaymentSum() {
        return paymentPeriodPiecemealPaymentSum;
    }

    /**
     * Sets the value of the paymentPeriodPiecemealPaymentSum property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setPaymentPeriodPiecemealPaymentSum(BigDecimal value) {
        this.paymentPeriodPiecemealPaymentSum = value;
    }

    /**
     * Gets the value of the pastPaymentPeriodPiecemealPaymentSum property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getPastPaymentPeriodPiecemealPaymentSum() {
        return pastPaymentPeriodPiecemealPaymentSum;
    }

    /**
     * Sets the value of the pastPaymentPeriodPiecemealPaymentSum property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setPastPaymentPeriodPiecemealPaymentSum(BigDecimal value) {
        this.pastPaymentPeriodPiecemealPaymentSum = value;
    }

    /**
     * Gets the value of the piecemealPaymentPercentRub property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getPiecemealPaymentPercentRub() {
        return piecemealPaymentPercentRub;
    }

    /**
     * Sets the value of the piecemealPaymentPercentRub property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setPiecemealPaymentPercentRub(BigDecimal value) {
        this.piecemealPaymentPercentRub = value;
    }

    /**
     * Gets the value of the piecemealPaymentPercent property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getPiecemealPaymentPercent() {
        return piecemealPaymentPercent;
    }

    /**
     * Sets the value of the piecemealPaymentPercent property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setPiecemealPaymentPercent(BigDecimal value) {
        this.piecemealPaymentPercent = value;
    }

    /**
     * Gets the value of the piecemealPaymentSum property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getPiecemealPaymentSum() {
        return piecemealPaymentSum;
    }

    /**
     * Sets the value of the piecemealPaymentSum property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setPiecemealPaymentSum(BigDecimal value) {
        this.piecemealPaymentSum = value;
    }

}
