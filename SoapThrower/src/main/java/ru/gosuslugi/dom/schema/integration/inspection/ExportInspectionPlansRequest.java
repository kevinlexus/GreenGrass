
package ru.gosuslugi.dom.schema.integration.inspection;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import ru.gosuslugi.dom.schema.integration.base.BaseType;


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
 *         &lt;element name="YearFrom" type="{http://dom.gosuslugi.ru/schema/integration/base/}YearType" minOccurs="0"/>
 *         &lt;element name="YearTo" type="{http://dom.gosuslugi.ru/schema/integration/base/}YearType" minOccurs="0"/>
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
    "yearFrom",
    "yearTo"
})
@XmlRootElement(name = "exportInspectionPlansRequest")
public class ExportInspectionPlansRequest
    extends BaseType
{

    @XmlElement(name = "YearFrom")
    protected Short yearFrom;
    @XmlElement(name = "YearTo")
    protected Short yearTo;
    @XmlAttribute(name = "version", namespace = "http://dom.gosuslugi.ru/schema/integration/base/", required = true)
    protected String version;

    /**
     * Gets the value of the yearFrom property.
     * 
     * @return
     *     possible object is
     *     {@link Short }
     *     
     */
    public Short getYearFrom() {
        return yearFrom;
    }

    /**
     * Sets the value of the yearFrom property.
     * 
     * @param value
     *     allowed object is
     *     {@link Short }
     *     
     */
    public void setYearFrom(Short value) {
        this.yearFrom = value;
    }

    /**
     * Gets the value of the yearTo property.
     * 
     * @return
     *     possible object is
     *     {@link Short }
     *     
     */
    public Short getYearTo() {
        return yearTo;
    }

    /**
     * Sets the value of the yearTo property.
     * 
     * @param value
     *     allowed object is
     *     {@link Short }
     *     
     */
    public void setYearTo(Short value) {
        this.yearTo = value;
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
