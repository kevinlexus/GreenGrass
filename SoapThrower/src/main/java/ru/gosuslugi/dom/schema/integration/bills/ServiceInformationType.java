
package ru.gosuslugi.dom.schema.integration.bills;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * Справочная информация платежного документа по коммунальным услугам
 * 
 * <p>Java class for ServiceInformationType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ServiceInformationType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="individualConsumptionCurrentValue" type="{http://dom.gosuslugi.ru/schema/integration/bills/}VolumePDType" minOccurs="0"/>
 *         &lt;element name="houseOverallNeedsCurrentValue" type="{http://dom.gosuslugi.ru/schema/integration/bills/}VolumePDType" minOccurs="0"/>
 *         &lt;element name="houseTotalIndividualConsumption" type="{http://dom.gosuslugi.ru/schema/integration/bills/}VolumePDType" minOccurs="0"/>
 *         &lt;element name="houseTotalHouseOverallNeeds" type="{http://dom.gosuslugi.ru/schema/integration/bills/}VolumePDType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ServiceInformationType", propOrder = {
    "individualConsumptionCurrentValue",
    "houseOverallNeedsCurrentValue",
    "houseTotalIndividualConsumption",
    "houseTotalHouseOverallNeeds"
})
@XmlSeeAlso({
    ServiceInformation.class
})
public class ServiceInformationType {

    protected BigDecimal individualConsumptionCurrentValue;
    protected BigDecimal houseOverallNeedsCurrentValue;
    protected BigDecimal houseTotalIndividualConsumption;
    protected BigDecimal houseTotalHouseOverallNeeds;

    /**
     * Gets the value of the individualConsumptionCurrentValue property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getIndividualConsumptionCurrentValue() {
        return individualConsumptionCurrentValue;
    }

    /**
     * Sets the value of the individualConsumptionCurrentValue property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setIndividualConsumptionCurrentValue(BigDecimal value) {
        this.individualConsumptionCurrentValue = value;
    }

    /**
     * Gets the value of the houseOverallNeedsCurrentValue property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getHouseOverallNeedsCurrentValue() {
        return houseOverallNeedsCurrentValue;
    }

    /**
     * Sets the value of the houseOverallNeedsCurrentValue property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setHouseOverallNeedsCurrentValue(BigDecimal value) {
        this.houseOverallNeedsCurrentValue = value;
    }

    /**
     * Gets the value of the houseTotalIndividualConsumption property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getHouseTotalIndividualConsumption() {
        return houseTotalIndividualConsumption;
    }

    /**
     * Sets the value of the houseTotalIndividualConsumption property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setHouseTotalIndividualConsumption(BigDecimal value) {
        this.houseTotalIndividualConsumption = value;
    }

    /**
     * Gets the value of the houseTotalHouseOverallNeeds property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getHouseTotalHouseOverallNeeds() {
        return houseTotalHouseOverallNeeds;
    }

    /**
     * Sets the value of the houseTotalHouseOverallNeeds property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setHouseTotalHouseOverallNeeds(BigDecimal value) {
        this.houseTotalHouseOverallNeeds = value;
    }

}
