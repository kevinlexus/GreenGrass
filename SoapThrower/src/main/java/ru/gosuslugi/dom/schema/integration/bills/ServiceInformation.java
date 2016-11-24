
package ru.gosuslugi.dom.schema.integration.bills;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/bills/}ServiceInformationType">
 *       &lt;sequence>
 *         &lt;element name="houseOverallNeedsNorm" type="{http://dom.gosuslugi.ru/schema/integration/bills/}VolumePDType" minOccurs="0"/>
 *         &lt;element name="individualConsumptionNorm" type="{http://dom.gosuslugi.ru/schema/integration/bills/}VolumePDType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "houseOverallNeedsNorm",
    "individualConsumptionNorm"
})
@XmlRootElement(name = "ServiceInformation")
public class ServiceInformation
    extends ServiceInformationType
{

    protected BigDecimal houseOverallNeedsNorm;
    protected BigDecimal individualConsumptionNorm;

    /**
     * Gets the value of the houseOverallNeedsNorm property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getHouseOverallNeedsNorm() {
        return houseOverallNeedsNorm;
    }

    /**
     * Sets the value of the houseOverallNeedsNorm property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setHouseOverallNeedsNorm(BigDecimal value) {
        this.houseOverallNeedsNorm = value;
    }

    /**
     * Gets the value of the individualConsumptionNorm property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getIndividualConsumptionNorm() {
        return individualConsumptionNorm;
    }

    /**
     * Sets the value of the individualConsumptionNorm property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setIndividualConsumptionNorm(BigDecimal value) {
        this.individualConsumptionNorm = value;
    }

}
