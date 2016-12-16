
package ru.gosuslugi.dom.schema.integration.msp;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * Расчеты и перерасчеты для гражданина, получающего компенсации расходов
 * 
 * <p>Java class for CitizenCompensationCalculationType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="CitizenCompensationCalculationType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="PeriodFrom" type="{http://www.w3.org/2001/XMLSchema}date"/>
 *         &lt;element name="PeriodTo" type="{http://www.w3.org/2001/XMLSchema}date"/>
 *         &lt;element name="CalculationDate" type="{http://www.w3.org/2001/XMLSchema}date"/>
 *         &lt;element name="ServiceCompensation" type="{http://dom.gosuslugi.ru/schema/integration/msp/}ServiceCompensationType" maxOccurs="12"/>
 *         &lt;element name="CompensationSum" type="{http://dom.gosuslugi.ru/schema/integration/msp/}MoneyType"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CitizenCompensationCalculationType", propOrder = {
    "periodFrom",
    "periodTo",
    "calculationDate",
    "serviceCompensation",
    "compensationSum"
})
public class CitizenCompensationCalculationType {

    @XmlElement(name = "PeriodFrom", required = true)
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar periodFrom;
    @XmlElement(name = "PeriodTo", required = true)
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar periodTo;
    @XmlElement(name = "CalculationDate", required = true)
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar calculationDate;
    @XmlElement(name = "ServiceCompensation", required = true)
    protected List<ServiceCompensationType> serviceCompensation;
    @XmlElement(name = "CompensationSum", required = true)
    protected BigDecimal compensationSum;

    /**
     * Gets the value of the periodFrom property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getPeriodFrom() {
        return periodFrom;
    }

    /**
     * Sets the value of the periodFrom property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setPeriodFrom(XMLGregorianCalendar value) {
        this.periodFrom = value;
    }

    /**
     * Gets the value of the periodTo property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getPeriodTo() {
        return periodTo;
    }

    /**
     * Sets the value of the periodTo property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setPeriodTo(XMLGregorianCalendar value) {
        this.periodTo = value;
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
     * Gets the value of the serviceCompensation property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the serviceCompensation property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getServiceCompensation().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ServiceCompensationType }
     * 
     * 
     */
    public List<ServiceCompensationType> getServiceCompensation() {
        if (serviceCompensation == null) {
            serviceCompensation = new ArrayList<ServiceCompensationType>();
        }
        return this.serviceCompensation;
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

}
