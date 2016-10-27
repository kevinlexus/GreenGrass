
package ru.gosuslugi.dom.schema.integration.metering_device_base;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;
import ru.gosuslugi.dom.schema.integration.house_management.MunicipalResourceNotElectricType;
import ru.gosuslugi.dom.schema.integration.nsi_base.NsiRef;


/**
 * Показания по ПУ тепловой энергии, газа, горячей воды, холодной воды, сточных бытовых вод
 * 
 * <p>Java class for OneRateMeteringValueType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="OneRateMeteringValueType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="MunicipalResource" type="{http://dom.gosuslugi.ru/schema/integration/nsi-base/}nsiRef"/>
 *         &lt;element name="MeteringValue" type="{http://dom.gosuslugi.ru/schema/integration/metering-device-base/}MeteringValueType"/>
 *         &lt;element name="ReadingsSource" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "OneRateMeteringValueType", propOrder = {
    "municipalResource",
    "meteringValue",
    "readingsSource"
})
@XmlSeeAlso({
    MunicipalResourceNotElectricType.class
})
public class OneRateMeteringValueType {

    @XmlElement(name = "MunicipalResource", required = true)
    protected NsiRef municipalResource;
    @XmlElement(name = "MeteringValue", required = true)
    protected BigDecimal meteringValue;
    @XmlElement(name = "ReadingsSource")
    protected String readingsSource;

    /**
     * Gets the value of the municipalResource property.
     * 
     * @return
     *     possible object is
     *     {@link NsiRef }
     *     
     */
    public NsiRef getMunicipalResource() {
        return municipalResource;
    }

    /**
     * Sets the value of the municipalResource property.
     * 
     * @param value
     *     allowed object is
     *     {@link NsiRef }
     *     
     */
    public void setMunicipalResource(NsiRef value) {
        this.municipalResource = value;
    }

    /**
     * Gets the value of the meteringValue property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getMeteringValue() {
        return meteringValue;
    }

    /**
     * Sets the value of the meteringValue property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setMeteringValue(BigDecimal value) {
        this.meteringValue = value;
    }

    /**
     * Gets the value of the readingsSource property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getReadingsSource() {
        return readingsSource;
    }

    /**
     * Sets the value of the readingsSource property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setReadingsSource(String value) {
        this.readingsSource = value;
    }

}
