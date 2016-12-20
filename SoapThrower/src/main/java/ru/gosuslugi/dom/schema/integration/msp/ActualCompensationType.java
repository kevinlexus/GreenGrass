
package ru.gosuslugi.dom.schema.integration.msp;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * Расходы на оплату жилого помещения и коммунальных услуг и их компенсация
 * 
 * <p>Java class for ActualCompensationType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ActualCompensationType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Service" type="{http://dom.gosuslugi.ru/schema/integration/msp/}ServiceType"/>
 *         &lt;element name="FamilySize">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}int">
 *               &lt;minInclusive value="0"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="ServicePaymentSum" type="{http://dom.gosuslugi.ru/schema/integration/msp/}MoneyType"/>
 *         &lt;element name="CompensationSum" type="{http://dom.gosuslugi.ru/schema/integration/msp/}MoneyType" minOccurs="0"/>
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
@XmlType(name = "ActualCompensationType", propOrder = {
    "service",
    "familySize",
    "servicePaymentSum",
    "compensationSum",
    "recalculationSum"
})
public class ActualCompensationType {

    @XmlElement(name = "Service", required = true)
    @XmlSchemaType(name = "string")
    protected ServiceType service;
    @XmlElement(name = "FamilySize")
    protected int familySize;
    @XmlElement(name = "ServicePaymentSum", required = true)
    protected BigDecimal servicePaymentSum;
    @XmlElement(name = "CompensationSum")
    protected BigDecimal compensationSum;
    @XmlElement(name = "RecalculationSum")
    protected BigDecimal recalculationSum;

    /**
     * Gets the value of the service property.
     * 
     * @return
     *     possible object is
     *     {@link ServiceType }
     *     
     */
    public ServiceType getService() {
        return service;
    }

    /**
     * Sets the value of the service property.
     * 
     * @param value
     *     allowed object is
     *     {@link ServiceType }
     *     
     */
    public void setService(ServiceType value) {
        this.service = value;
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
     * Gets the value of the servicePaymentSum property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getServicePaymentSum() {
        return servicePaymentSum;
    }

    /**
     * Sets the value of the servicePaymentSum property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setServicePaymentSum(BigDecimal value) {
        this.servicePaymentSum = value;
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
