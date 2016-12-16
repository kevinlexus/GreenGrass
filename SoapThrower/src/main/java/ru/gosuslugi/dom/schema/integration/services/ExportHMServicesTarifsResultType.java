
package ru.gosuslugi.dom.schema.integration.services;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for exportHMServicesTarifsResultType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="exportHMServicesTarifsResultType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/services/}HMServicesTarifsDocType">
 *       &lt;sequence>
 *         &lt;element name="ServicesTarifDocGUID" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType"/>
 *         &lt;element name="CreationDate" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "exportHMServicesTarifsResultType", propOrder = {
    "servicesTarifDocGUID",
    "creationDate"
})
public class ExportHMServicesTarifsResultType
    extends HMServicesTarifsDocType
{

    @XmlElement(name = "ServicesTarifDocGUID", required = true)
    protected String servicesTarifDocGUID;
    @XmlElement(name = "CreationDate", required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar creationDate;

    /**
     * Gets the value of the servicesTarifDocGUID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getServicesTarifDocGUID() {
        return servicesTarifDocGUID;
    }

    /**
     * Sets the value of the servicesTarifDocGUID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setServicesTarifDocGUID(String value) {
        this.servicesTarifDocGUID = value;
    }

    /**
     * Gets the value of the creationDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getCreationDate() {
        return creationDate;
    }

    /**
     * Sets the value of the creationDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setCreationDate(XMLGregorianCalendar value) {
        this.creationDate = value;
    }

}
