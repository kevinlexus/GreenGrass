
package ru.gosuslugi.dom.schema.integration.capital_repair;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Экспортируемая работа в КПР
 * 
 * <p>Java class for exportWorkPlanType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="exportWorkPlanType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/capital-repair/}WorkPlanType">
 *       &lt;sequence>
 *         &lt;element name="WorkGUID" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "exportWorkPlanType", propOrder = {
    "workGUID"
})
public class ExportWorkPlanType
    extends WorkPlanType
{

    @XmlElement(name = "WorkGUID", required = true)
    protected String workGUID;

    /**
     * Gets the value of the workGUID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getWorkGUID() {
        return workGUID;
    }

    /**
     * Sets the value of the workGUID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setWorkGUID(String value) {
        this.workGUID = value;
    }

}
