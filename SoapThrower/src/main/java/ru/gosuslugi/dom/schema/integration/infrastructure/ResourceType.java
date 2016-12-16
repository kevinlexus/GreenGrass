
package ru.gosuslugi.dom.schema.integration.infrastructure;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;
import ru.gosuslugi.dom.schema.integration.nsi_base.NsiRef;


/**
 * Ресурс 
 * 
 * <p>Java class for ResourceType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ResourceType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="MunicipalResource" type="{http://dom.gosuslugi.ru/schema/integration/nsi-base/}nsiRef"/>
 *         &lt;element name="TotalLoad" type="{http://dom.gosuslugi.ru/schema/integration/infrastructure/}PowerType" minOccurs="0"/>
 *         &lt;element name="IndustrialLoad" type="{http://dom.gosuslugi.ru/schema/integration/infrastructure/}PowerType" minOccurs="0"/>
 *         &lt;element name="SocialLoad" type="{http://dom.gosuslugi.ru/schema/integration/infrastructure/}PowerType" minOccurs="0"/>
 *         &lt;element name="PopulationLoad" type="{http://dom.gosuslugi.ru/schema/integration/infrastructure/}PowerType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ResourceType", propOrder = {
    "municipalResource",
    "totalLoad",
    "industrialLoad",
    "socialLoad",
    "populationLoad"
})
@XmlSeeAlso({
    ru.gosuslugi.dom.schema.integration.infrastructure.InfrastructureType.ObjectProperty.Resources.class,
    ru.gosuslugi.dom.schema.integration.infrastructure.InfrastructureType.ObjectProperty.TransportationResources.class
})
public class ResourceType {

    @XmlElement(name = "MunicipalResource", required = true)
    protected NsiRef municipalResource;
    @XmlElement(name = "TotalLoad")
    protected BigDecimal totalLoad;
    @XmlElement(name = "IndustrialLoad")
    protected BigDecimal industrialLoad;
    @XmlElement(name = "SocialLoad")
    protected BigDecimal socialLoad;
    @XmlElement(name = "PopulationLoad")
    protected BigDecimal populationLoad;

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
     * Gets the value of the totalLoad property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getTotalLoad() {
        return totalLoad;
    }

    /**
     * Sets the value of the totalLoad property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setTotalLoad(BigDecimal value) {
        this.totalLoad = value;
    }

    /**
     * Gets the value of the industrialLoad property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getIndustrialLoad() {
        return industrialLoad;
    }

    /**
     * Sets the value of the industrialLoad property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setIndustrialLoad(BigDecimal value) {
        this.industrialLoad = value;
    }

    /**
     * Gets the value of the socialLoad property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getSocialLoad() {
        return socialLoad;
    }

    /**
     * Sets the value of the socialLoad property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setSocialLoad(BigDecimal value) {
        this.socialLoad = value;
    }

    /**
     * Gets the value of the populationLoad property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getPopulationLoad() {
        return populationLoad;
    }

    /**
     * Sets the value of the populationLoad property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setPopulationLoad(BigDecimal value) {
        this.populationLoad = value;
    }

}
