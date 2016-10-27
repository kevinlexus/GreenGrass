
package ru.gosuslugi.dom.schema.integration.house_management;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * Тип выбора дня начала/окончания периода ввода показаний по ПУ
 * 
 * <p>Java class for DaySelectionType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="DaySelectionType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;choice>
 *           &lt;element name="Date">
 *             &lt;simpleType>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}byte">
 *                 &lt;maxInclusive value="31"/>
 *                 &lt;minInclusive value="1"/>
 *               &lt;/restriction>
 *             &lt;/simpleType>
 *           &lt;/element>
 *           &lt;element name="LastDay" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;/choice>
 *         &lt;element name="IsNextMonth" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DaySelectionType", propOrder = {
    "date",
    "lastDay",
    "isNextMonth"
})
@XmlSeeAlso({
    DeviceMeteringsDaySelectionType.class
})
public class DaySelectionType {

    @XmlElement(name = "Date")
    protected Byte date;
    @XmlElement(name = "LastDay")
    protected Boolean lastDay;
    @XmlElement(name = "IsNextMonth")
    protected boolean isNextMonth;

    /**
     * Gets the value of the date property.
     * 
     * @return
     *     possible object is
     *     {@link Byte }
     *     
     */
    public Byte getDate() {
        return date;
    }

    /**
     * Sets the value of the date property.
     * 
     * @param value
     *     allowed object is
     *     {@link Byte }
     *     
     */
    public void setDate(Byte value) {
        this.date = value;
    }

    /**
     * Gets the value of the lastDay property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isLastDay() {
        return lastDay;
    }

    /**
     * Sets the value of the lastDay property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setLastDay(Boolean value) {
        this.lastDay = value;
    }

    /**
     * Gets the value of the isNextMonth property.
     * 
     */
    public boolean isIsNextMonth() {
        return isNextMonth;
    }

    /**
     * Sets the value of the isNextMonth property.
     * 
     */
    public void setIsNextMonth(boolean value) {
        this.isNextMonth = value;
    }

}
