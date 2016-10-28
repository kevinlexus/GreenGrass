
package ru.gosuslugi.dom.schema.integration.nsi_base;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * Данные справочника.
 * 
 * <p>Java class for NsiItemType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="NsiItemType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="NsiItemRegistryNumber" type="{http://dom.gosuslugi.ru/schema/integration/nsi-base/}NsiItemRegistryNumberType"/>
 *         &lt;element name="Created" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="NsiElement" type="{http://dom.gosuslugi.ru/schema/integration/nsi-base/}NsiElementType" maxOccurs="unbounded"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "NsiItemType", propOrder = {
    "nsiItemRegistryNumber",
    "created",
    "nsiElement"
})
public class NsiItemType {

    @XmlElement(name = "NsiItemRegistryNumber", required = true)
    @XmlSchemaType(name = "positiveInteger")
    protected BigInteger nsiItemRegistryNumber;
    @XmlElement(name = "Created", required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar created;
    @XmlElement(name = "NsiElement", required = true)
    protected List<NsiElementType> nsiElement;

    /**
     * Gets the value of the nsiItemRegistryNumber property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getNsiItemRegistryNumber() {
        return nsiItemRegistryNumber;
    }

    /**
     * Sets the value of the nsiItemRegistryNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setNsiItemRegistryNumber(BigInteger value) {
        this.nsiItemRegistryNumber = value;
    }

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
     * Gets the value of the nsiElement property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the nsiElement property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getNsiElement().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link NsiElementType }
     * 
     * 
     */
    public List<NsiElementType> getNsiElement() {
        if (nsiElement == null) {
            nsiElement = new ArrayList<NsiElementType>();
        }
        return this.nsiElement;
    }

}
