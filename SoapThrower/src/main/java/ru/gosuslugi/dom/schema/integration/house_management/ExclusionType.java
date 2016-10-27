
package ru.gosuslugi.dom.schema.integration.house_management;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * Сведения об исключении объекта управления из ДУ/Устава
 * 
 * <p>Java class for ExclusionType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ExclusionType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="BaseExclusion" type="{http://dom.gosuslugi.ru/schema/integration/house-management/}BaseServiceType"/>
 *         &lt;element name="DateExclusion" type="{http://www.w3.org/2001/XMLSchema}date"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ExclusionType", propOrder = {
    "baseExclusion",
    "dateExclusion"
})
public class ExclusionType {

    @XmlElement(name = "BaseExclusion", required = true)
    protected BaseServiceType baseExclusion;
    @XmlElement(name = "DateExclusion", required = true)
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar dateExclusion;

    /**
     * Gets the value of the baseExclusion property.
     * 
     * @return
     *     possible object is
     *     {@link BaseServiceType }
     *     
     */
    public BaseServiceType getBaseExclusion() {
        return baseExclusion;
    }

    /**
     * Sets the value of the baseExclusion property.
     * 
     * @param value
     *     allowed object is
     *     {@link BaseServiceType }
     *     
     */
    public void setBaseExclusion(BaseServiceType value) {
        this.baseExclusion = value;
    }

    /**
     * Gets the value of the dateExclusion property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDateExclusion() {
        return dateExclusion;
    }

    /**
     * Sets the value of the dateExclusion property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDateExclusion(XMLGregorianCalendar value) {
        this.dateExclusion = value;
    }

}
