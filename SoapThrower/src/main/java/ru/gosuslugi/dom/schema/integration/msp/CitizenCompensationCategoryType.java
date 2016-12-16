
package ru.gosuslugi.dom.schema.integration.msp;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * Категория гражданина, получающего компенсации расходов
 * 
 * <p>Java class for CitizenCompensationCategoryType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="CitizenCompensationCategoryType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="CategoryGuid" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType"/>
 *         &lt;element name="PeriodFrom" type="{http://www.w3.org/2001/XMLSchema}date"/>
 *         &lt;element name="PeriodTo" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
 *         &lt;element name="Service" type="{http://dom.gosuslugi.ru/schema/integration/msp/}ServiceType" maxOccurs="12"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CitizenCompensationCategoryType", propOrder = {
    "categoryGuid",
    "periodFrom",
    "periodTo",
    "service"
})
public class CitizenCompensationCategoryType {

    @XmlElement(name = "CategoryGuid", required = true)
    protected String categoryGuid;
    @XmlElement(name = "PeriodFrom", required = true)
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar periodFrom;
    @XmlElement(name = "PeriodTo")
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar periodTo;
    @XmlElement(name = "Service", required = true)
    @XmlSchemaType(name = "string")
    protected List<ServiceType> service;

    /**
     * Gets the value of the categoryGuid property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCategoryGuid() {
        return categoryGuid;
    }

    /**
     * Sets the value of the categoryGuid property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCategoryGuid(String value) {
        this.categoryGuid = value;
    }

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
     * Gets the value of the service property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the service property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getService().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ServiceType }
     * 
     * 
     */
    public List<ServiceType> getService() {
        if (service == null) {
            service = new ArrayList<ServiceType>();
        }
        return this.service;
    }

}
