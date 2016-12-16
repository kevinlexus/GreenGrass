
package ru.gosuslugi.dom.schema.integration.infrastructure;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for exportOKIResultType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="exportOKIResultType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="OKIGuid" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType"/>
 *         &lt;element name="CodeOKI" type="{http://dom.gosuslugi.ru/schema/integration/infrastructure/}CodeOKIType"/>
 *         &lt;element name="OKI">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/infrastructure/}InfrastructureType">
 *               &lt;/extension>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "exportOKIResultType", propOrder = {
    "okiGuid",
    "codeOKI",
    "oki"
})
public class ExportOKIResultType {

    @XmlElement(name = "OKIGuid", required = true)
    protected String okiGuid;
    @XmlElement(name = "CodeOKI", required = true)
    protected String codeOKI;
    @XmlElement(name = "OKI", required = true)
    protected ExportOKIResultType.OKI oki;

    /**
     * Gets the value of the okiGuid property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOKIGuid() {
        return okiGuid;
    }

    /**
     * Sets the value of the okiGuid property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOKIGuid(String value) {
        this.okiGuid = value;
    }

    /**
     * Gets the value of the codeOKI property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodeOKI() {
        return codeOKI;
    }

    /**
     * Sets the value of the codeOKI property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodeOKI(String value) {
        this.codeOKI = value;
    }

    /**
     * Gets the value of the oki property.
     * 
     * @return
     *     possible object is
     *     {@link ExportOKIResultType.OKI }
     *     
     */
    public ExportOKIResultType.OKI getOKI() {
        return oki;
    }

    /**
     * Sets the value of the oki property.
     * 
     * @param value
     *     allowed object is
     *     {@link ExportOKIResultType.OKI }
     *     
     */
    public void setOKI(ExportOKIResultType.OKI value) {
        this.oki = value;
    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/infrastructure/}InfrastructureType">
     *     &lt;/extension>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "")
    public static class OKI
        extends InfrastructureType
    {


    }

}
