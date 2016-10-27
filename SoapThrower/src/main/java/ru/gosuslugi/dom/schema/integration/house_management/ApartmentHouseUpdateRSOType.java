
package ru.gosuslugi.dom.schema.integration.house_management;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * Многоквартирный дом (обновление данных для РСО)
 * 
 * <p>Java class for ApartmentHouseUpdateRSOType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ApartmentHouseUpdateRSOType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="BasicCharacteristicts" type="{http://dom.gosuslugi.ru/schema/integration/house-management/}HouseBasicUpdateRSOType"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ApartmentHouseUpdateRSOType", propOrder = {
    "basicCharacteristicts"
})
@XmlSeeAlso({
    ru.gosuslugi.dom.schema.integration.house_management.ImportHouseRSORequest.ApartmentHouse.ApartmentHouseToUpdate.class
})
public class ApartmentHouseUpdateRSOType {

    @XmlElement(name = "BasicCharacteristicts", required = true)
    protected HouseBasicUpdateRSOType basicCharacteristicts;

    /**
     * Gets the value of the basicCharacteristicts property.
     * 
     * @return
     *     possible object is
     *     {@link HouseBasicUpdateRSOType }
     *     
     */
    public HouseBasicUpdateRSOType getBasicCharacteristicts() {
        return basicCharacteristicts;
    }

    /**
     * Sets the value of the basicCharacteristicts property.
     * 
     * @param value
     *     allowed object is
     *     {@link HouseBasicUpdateRSOType }
     *     
     */
    public void setBasicCharacteristicts(HouseBasicUpdateRSOType value) {
        this.basicCharacteristicts = value;
    }

}
