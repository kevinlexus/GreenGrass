
package ru.gosuslugi.dom.schema.integration.nsi_common;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import ru.gosuslugi.dom.schema.integration.base.BaseType;
import ru.gosuslugi.dom.schema.integration.base.ErrorMessageType;
import ru.gosuslugi.dom.schema.integration.nsi_base.NsiItemType;


/**
 * Составной тип. Данные справочника.
 * 
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/base/}BaseType">
 *       &lt;choice>
 *         &lt;element name="NsiItem" type="{http://dom.gosuslugi.ru/schema/integration/nsi-base/}NsiItemType"/>
 *         &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/base/}ErrorMessage"/>
 *       &lt;/choice>
 *       &lt;attribute ref="{http://dom.gosuslugi.ru/schema/integration/base/}version use="required" fixed="10.0.1.2""/>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "nsiItem",
    "errorMessage"
})
@XmlRootElement(name = "exportNsiItemResult")
public class ExportNsiItemResult
    extends BaseType
{

    @XmlElement(name = "NsiItem")
    protected NsiItemType nsiItem;
    @XmlElement(name = "ErrorMessage", namespace = "http://dom.gosuslugi.ru/schema/integration/base/")
    protected ErrorMessageType errorMessage;
    @XmlAttribute(name = "version", namespace = "http://dom.gosuslugi.ru/schema/integration/base/", required = true)
    protected String version;

    /**
     * Gets the value of the nsiItem property.
     * 
     * @return
     *     possible object is
     *     {@link NsiItemType }
     *     
     */
    public NsiItemType getNsiItem() {
        return nsiItem;
    }

    /**
     * Sets the value of the nsiItem property.
     * 
     * @param value
     *     allowed object is
     *     {@link NsiItemType }
     *     
     */
    public void setNsiItem(NsiItemType value) {
        this.nsiItem = value;
    }

    /**
     * Gets the value of the errorMessage property.
     * 
     * @return
     *     possible object is
     *     {@link ErrorMessageType }
     *     
     */
    public ErrorMessageType getErrorMessage() {
        return errorMessage;
    }

    /**
     * Sets the value of the errorMessage property.
     * 
     * @param value
     *     allowed object is
     *     {@link ErrorMessageType }
     *     
     */
    public void setErrorMessage(ErrorMessageType value) {
        this.errorMessage = value;
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
            return "10.0.1.2";
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
