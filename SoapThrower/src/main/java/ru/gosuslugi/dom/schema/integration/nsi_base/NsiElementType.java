
package ru.gosuslugi.dom.schema.integration.nsi_base;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * Составной тип. Элемент справочника.
 * 
 * <p>Java class for NsiElementType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="NsiElementType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Code" type="{http://dom.gosuslugi.ru/schema/integration/nsi-base/}nsiCodeType"/>
 *         &lt;element name="GUID" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType"/>
 *         &lt;choice>
 *           &lt;element name="Modified" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *           &lt;sequence>
 *             &lt;element name="StartDate" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *             &lt;element name="EndDate" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *           &lt;/sequence>
 *         &lt;/choice>
 *         &lt;element name="IsActual" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="NsiElementField" type="{http://dom.gosuslugi.ru/schema/integration/nsi-base/}NsiElementFieldType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="ChildElement" type="{http://dom.gosuslugi.ru/schema/integration/nsi-base/}NsiElementType" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "NsiElementType", propOrder = {
    "code",
    "guid",
    "modified",
    "startDate",
    "endDate",
    "isActual",
    "nsiElementField",
    "childElement"
})
public class NsiElementType {

    @XmlElement(name = "Code", required = true)
    protected String code;
    @XmlElement(name = "GUID", required = true)
    protected String guid;
    @XmlElement(name = "Modified")
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar modified;
    @XmlElement(name = "StartDate")
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar startDate;
    @XmlElement(name = "EndDate")
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar endDate;
    @XmlElement(name = "IsActual")
    protected boolean isActual;
    @XmlElement(name = "NsiElementField")
    protected List<NsiElementFieldType> nsiElementField;
    @XmlElement(name = "ChildElement")
    protected List<NsiElementType> childElement;

    /**
     * Gets the value of the code property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCode() {
        return code;
    }

    /**
     * Sets the value of the code property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCode(String value) {
        this.code = value;
    }

    /**
     * Gets the value of the guid property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGUID() {
        return guid;
    }

    /**
     * Sets the value of the guid property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGUID(String value) {
        this.guid = value;
    }

    /**
     * Gets the value of the modified property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getModified() {
        return modified;
    }

    /**
     * Sets the value of the modified property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setModified(XMLGregorianCalendar value) {
        this.modified = value;
    }

    /**
     * Gets the value of the startDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getStartDate() {
        return startDate;
    }

    /**
     * Sets the value of the startDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setStartDate(XMLGregorianCalendar value) {
        this.startDate = value;
    }

    /**
     * Gets the value of the endDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getEndDate() {
        return endDate;
    }

    /**
     * Sets the value of the endDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setEndDate(XMLGregorianCalendar value) {
        this.endDate = value;
    }

    /**
     * Gets the value of the isActual property.
     * 
     */
    public boolean isIsActual() {
        return isActual;
    }

    /**
     * Sets the value of the isActual property.
     * 
     */
    public void setIsActual(boolean value) {
        this.isActual = value;
    }

    /**
     * Gets the value of the nsiElementField property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the nsiElementField property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getNsiElementField().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link NsiElementFieldType }
     * 
     * 
     */
    public List<NsiElementFieldType> getNsiElementField() {
        if (nsiElementField == null) {
            nsiElementField = new ArrayList<NsiElementFieldType>();
        }
        return this.nsiElementField;
    }

    /**
     * Gets the value of the childElement property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the childElement property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getChildElement().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link NsiElementType }
     * 
     * 
     */
    public List<NsiElementType> getChildElement() {
        if (childElement == null) {
            childElement = new ArrayList<NsiElementType>();
        }
        return this.childElement;
    }

}
