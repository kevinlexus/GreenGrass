
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
 * Перечень справочников с датой последнего изменения каждого из них.
 * 
 * <p>Java class for NsiListType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="NsiListType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Created" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="NsiItemInfo" type="{http://dom.gosuslugi.ru/schema/integration/nsi-base/}NsiItemInfoType" maxOccurs="unbounded"/>
 *         &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/nsi-base/}ListGroup"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "NsiListType", propOrder = {
    "created",
    "nsiItemInfo",
    "listGroup"
})
public class NsiListType {

    @XmlElement(name = "Created", required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar created;
    @XmlElement(name = "NsiItemInfo", required = true)
    protected List<NsiItemInfoType> nsiItemInfo;
    @XmlElement(name = "ListGroup", required = true)
    protected String listGroup;

    /**
     * Gets the value of the created property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getCreated() {
        return created;
    }

    /**
     * Sets the value of the created property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setCreated(XMLGregorianCalendar value) {
        this.created = value;
    }

    /**
     * Gets the value of the nsiItemInfo property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the nsiItemInfo property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getNsiItemInfo().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link NsiItemInfoType }
     * 
     * 
     */
    public List<NsiItemInfoType> getNsiItemInfo() {
        if (nsiItemInfo == null) {
            nsiItemInfo = new ArrayList<NsiItemInfoType>();
        }
        return this.nsiItemInfo;
    }

    /**
     * Gets the value of the listGroup property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getListGroup() {
        return listGroup;
    }

    /**
     * Sets the value of the listGroup property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setListGroup(String value) {
        this.listGroup = value;
    }

}
