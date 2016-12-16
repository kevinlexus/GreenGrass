
package ru.gosuslugi.dom.schema.integration.services;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlList;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;
import ru.gosuslugi.dom.schema.integration.base.BaseType;
import ru.gosuslugi.dom.schema.integration.base.OKTMORefType;
import ru.gosuslugi.dom.schema.integration.base.RegionType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/base/}BaseType">
 *       &lt;sequence>
 *         &lt;element name="ServiceType">
 *           &lt;simpleType>
 *             &lt;restriction>
 *               &lt;simpleType>
 *                 &lt;list>
 *                   &lt;simpleType>
 *                     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}token">
 *                       &lt;enumeration value="M"/>
 *                       &lt;enumeration value="O"/>
 *                       &lt;enumeration value="S"/>
 *                       &lt;enumeration value="R"/>
 *                       &lt;enumeration value="C"/>
 *                     &lt;/restriction>
 *                   &lt;/simpleType>
 *                 &lt;/list>
 *               &lt;/simpleType>
 *               &lt;minLength value="1"/>
 *               &lt;maxLength value="2"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;choice>
 *           &lt;element name="Municipalities" type="{http://dom.gosuslugi.ru/schema/integration/base/}OKTMORefType" maxOccurs="unbounded" minOccurs="0"/>
 *           &lt;element name="Region" type="{http://dom.gosuslugi.ru/schema/integration/base/}RegionType"/>
 *         &lt;/choice>
 *         &lt;sequence minOccurs="0">
 *           &lt;element name="EffectivePeriodTo" type="{http://www.w3.org/2001/XMLSchema}date"/>
 *           &lt;element name="EffectivePeriodFrom" type="{http://www.w3.org/2001/XMLSchema}date"/>
 *         &lt;/sequence>
 *         &lt;element name="IsPublished" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *       &lt;/sequence>
 *       &lt;attribute ref="{http://dom.gosuslugi.ru/schema/integration/base/}version use="required" fixed="10.0.1.1""/>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "serviceType",
    "municipalities",
    "region",
    "effectivePeriodTo",
    "effectivePeriodFrom",
    "isPublished"
})
@XmlRootElement(name = "exportHMServicesTarifsRequest")
public class ExportHMServicesTarifsRequest
    extends BaseType
{

    @XmlList
    @XmlElement(name = "ServiceType", required = true)
    protected List<String> serviceType;
    @XmlElement(name = "Municipalities")
    protected List<OKTMORefType> municipalities;
    @XmlElement(name = "Region")
    protected RegionType region;
    @XmlElement(name = "EffectivePeriodTo")
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar effectivePeriodTo;
    @XmlElement(name = "EffectivePeriodFrom")
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar effectivePeriodFrom;
    @XmlElement(name = "IsPublished")
    protected boolean isPublished;
    @XmlAttribute(name = "version", namespace = "http://dom.gosuslugi.ru/schema/integration/base/", required = true)
    protected String version;

    /**
     * Gets the value of the serviceType property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the serviceType property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getServiceType().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getServiceType() {
        if (serviceType == null) {
            serviceType = new ArrayList<String>();
        }
        return this.serviceType;
    }

    /**
     * Gets the value of the municipalities property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the municipalities property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getMunicipalities().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link OKTMORefType }
     * 
     * 
     */
    public List<OKTMORefType> getMunicipalities() {
        if (municipalities == null) {
            municipalities = new ArrayList<OKTMORefType>();
        }
        return this.municipalities;
    }

    /**
     * Gets the value of the region property.
     * 
     * @return
     *     possible object is
     *     {@link RegionType }
     *     
     */
    public RegionType getRegion() {
        return region;
    }

    /**
     * Sets the value of the region property.
     * 
     * @param value
     *     allowed object is
     *     {@link RegionType }
     *     
     */
    public void setRegion(RegionType value) {
        this.region = value;
    }

    /**
     * Gets the value of the effectivePeriodTo property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getEffectivePeriodTo() {
        return effectivePeriodTo;
    }

    /**
     * Sets the value of the effectivePeriodTo property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setEffectivePeriodTo(XMLGregorianCalendar value) {
        this.effectivePeriodTo = value;
    }

    /**
     * Gets the value of the effectivePeriodFrom property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getEffectivePeriodFrom() {
        return effectivePeriodFrom;
    }

    /**
     * Sets the value of the effectivePeriodFrom property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setEffectivePeriodFrom(XMLGregorianCalendar value) {
        this.effectivePeriodFrom = value;
    }

    /**
     * Gets the value of the isPublished property.
     * 
     */
    public boolean isIsPublished() {
        return isPublished;
    }

    /**
     * Sets the value of the isPublished property.
     * 
     */
    public void setIsPublished(boolean value) {
        this.isPublished = value;
    }

    /**
     * Gets the value of the version property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVersion() {
        if (version == null) {
            return "10.0.1.1";
        } else {
            return version;
        }
    }

    /**
     * Sets the value of the version property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVersion(String value) {
        this.version = value;
    }

}
