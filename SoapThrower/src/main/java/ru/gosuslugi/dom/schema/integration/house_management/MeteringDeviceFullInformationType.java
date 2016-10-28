
package ru.gosuslugi.dom.schema.integration.house_management;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * Тип для создания ПУ, редактирования ПУ до начала внесения показаний, а также для экспорта сведений о ПУ
 * 
 * <p>Java class for MeteringDeviceFullInformationType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="MeteringDeviceFullInformationType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="BasicChatacteristicts" type="{http://dom.gosuslugi.ru/schema/integration/house-management/}MeteringDeviceBasicCharacteristicsType"/>
 *         &lt;choice>
 *           &lt;element name="MunicipalResourceNotEnergy" type="{http://dom.gosuslugi.ru/schema/integration/house-management/}MunicipalResourceNotElectricType" maxOccurs="3"/>
 *           &lt;element name="MunicipalResourceEnergy" type="{http://dom.gosuslugi.ru/schema/integration/house-management/}MunicipalResourceElectricType"/>
 *         &lt;/choice>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "MeteringDeviceFullInformationType", propOrder = {
    "basicChatacteristicts",
    "municipalResourceNotEnergy",
    "municipalResourceEnergy"
})
@XmlSeeAlso({
    ExportMeteringDeviceDataResultType.class
})
public class MeteringDeviceFullInformationType {

    @XmlElement(name = "BasicChatacteristicts", required = true)
    protected MeteringDeviceBasicCharacteristicsType basicChatacteristicts;
    @XmlElement(name = "MunicipalResourceNotEnergy")
    protected List<MunicipalResourceNotElectricType> municipalResourceNotEnergy;
    @XmlElement(name = "MunicipalResourceEnergy")
    protected MunicipalResourceElectricType municipalResourceEnergy;

    /**
     * Gets the value of the basicChatacteristicts property.
     * 
     * @return
     *     possible object is
     *     {@link MeteringDeviceBasicCharacteristicsType }
     *     
     */
    public MeteringDeviceBasicCharacteristicsType getBasicChatacteristicts() {
        return basicChatacteristicts;
    }

    /**
     * Sets the value of the basicChatacteristicts property.
     * 
     * @param value
     *     allowed object is
     *     {@link MeteringDeviceBasicCharacteristicsType }
     *     
     */
    public void setBasicChatacteristicts(MeteringDeviceBasicCharacteristicsType value) {
        this.basicChatacteristicts = value;
    }

    /**
     * Gets the value of the municipalResourceNotEnergy property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the municipalResourceNotEnergy property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getMunicipalResourceNotEnergy().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link MunicipalResourceNotElectricType }
     * 
     * 
     */
    public List<MunicipalResourceNotElectricType> getMunicipalResourceNotEnergy() {
        if (municipalResourceNotEnergy == null) {
            municipalResourceNotEnergy = new ArrayList<MunicipalResourceNotElectricType>();
        }
        return this.municipalResourceNotEnergy;
    }

    /**
     * Gets the value of the municipalResourceEnergy property.
     * 
     * @return
     *     possible object is
     *     {@link MunicipalResourceElectricType }
     *     
     */
    public MunicipalResourceElectricType getMunicipalResourceEnergy() {
        return municipalResourceEnergy;
    }

    /**
     * Sets the value of the municipalResourceEnergy property.
     * 
     * @param value
     *     allowed object is
     *     {@link MunicipalResourceElectricType }
     *     
     */
    public void setMunicipalResourceEnergy(MunicipalResourceElectricType value) {
        this.municipalResourceEnergy = value;
    }

}
