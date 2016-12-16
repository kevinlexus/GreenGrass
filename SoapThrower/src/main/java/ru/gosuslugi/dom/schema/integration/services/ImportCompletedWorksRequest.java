
package ru.gosuslugi.dom.schema.integration.services;

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
 *         &lt;element name="CompletedWorksByPeriod" type="{http://dom.gosuslugi.ru/schema/integration/services/}CompletedWorksByPeriodType"/>
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
    "completedWorksByPeriod"
})
@XmlRootElement(name = "importCompletedWorksRequest")
public class ImportCompletedWorksRequest
    extends BaseType
{

    @XmlElement(name = "CompletedWorksByPeriod", required = true)
    protected CompletedWorksByPeriodType completedWorksByPeriod;
    @XmlAttribute(name = "version", namespace = "http://dom.gosuslugi.ru/schema/integration/base/", required = true)
    protected String version;

    /**
     * Gets the value of the completedWorksByPeriod property.
     * 
     * @return
     *     possible object is
     *     {@link CompletedWorksByPeriodType }
     *     
     */
    public CompletedWorksByPeriodType getCompletedWorksByPeriod() {
        return completedWorksByPeriod;
    }

    /**
     * Sets the value of the completedWorksByPeriod property.
     * 
     * @param value
     *     allowed object is
     *     {@link CompletedWorksByPeriodType }
     *     
     */
    public void setCompletedWorksByPeriod(CompletedWorksByPeriodType value) {
        this.completedWorksByPeriod = value;
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
