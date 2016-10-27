
package ru.gosuslugi.dom.schema.integration.house_management;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * Значение строки данных для объекта ЖФ
 * 
 * <p>Java class for OGFDataValue complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="OGFDataValue">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;choice>
 *         &lt;element name="StringValue" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="FloatValue" type="{http://www.w3.org/2001/XMLSchema}float"/>
 *         &lt;element name="DateTimeValue" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="IntegerValue" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="BooleanValue" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="NsiCode" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="File" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/choice>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "OGFDataValue", propOrder = {
    "stringValue",
    "floatValue",
    "dateTimeValue",
    "integerValue",
    "booleanValue",
    "nsiCode",
    "file"
})
public class OGFDataValue {

    @XmlElement(name = "StringValue")
    protected String stringValue;
    @XmlElement(name = "FloatValue")
    protected Float floatValue;
    @XmlElement(name = "DateTimeValue")
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar dateTimeValue;
    @XmlElement(name = "IntegerValue")
    protected Integer integerValue;
    @XmlElement(name = "BooleanValue")
    protected Boolean booleanValue;
    @XmlElement(name = "NsiCode")
    protected String nsiCode;
    @XmlElement(name = "File")
    protected String file;

    /**
     * Gets the value of the stringValue property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStringValue() {
        return stringValue;
    }

    /**
     * Sets the value of the stringValue property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStringValue(String value) {
        this.stringValue = value;
    }

    /**
     * Gets the value of the floatValue property.
     * 
     * @return
     *     possible object is
     *     {@link Float }
     *     
     */
    public Float getFloatValue() {
        return floatValue;
    }

    /**
     * Sets the value of the floatValue property.
     * 
     * @param value
     *     allowed object is
     *     {@link Float }
     *     
     */
    public void setFloatValue(Float value) {
        this.floatValue = value;
    }

    /**
     * Gets the value of the dateTimeValue property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDateTimeValue() {
        return dateTimeValue;
    }

    /**
     * Sets the value of the dateTimeValue property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDateTimeValue(XMLGregorianCalendar value) {
        this.dateTimeValue = value;
    }

    /**
     * Gets the value of the integerValue property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getIntegerValue() {
        return integerValue;
    }

    /**
     * Sets the value of the integerValue property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setIntegerValue(Integer value) {
        this.integerValue = value;
    }

    /**
     * Gets the value of the booleanValue property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isBooleanValue() {
        return booleanValue;
    }

    /**
     * Sets the value of the booleanValue property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setBooleanValue(Boolean value) {
        this.booleanValue = value;
    }

    /**
     * Gets the value of the nsiCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNsiCode() {
        return nsiCode;
    }

    /**
     * Sets the value of the nsiCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNsiCode(String value) {
        this.nsiCode = value;
    }

    /**
     * Gets the value of the file property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFile() {
        return file;
    }

    /**
     * Sets the value of the file property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFile(String value) {
        this.file = value;
    }

}
