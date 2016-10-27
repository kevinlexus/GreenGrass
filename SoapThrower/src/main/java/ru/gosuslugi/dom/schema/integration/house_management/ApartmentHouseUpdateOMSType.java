
package ru.gosuslugi.dom.schema.integration.house_management;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * Многоквартирный дом (обновление данных для ОМС)
 * 
 * <p>Java class for ApartmentHouseUpdateOMSType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ApartmentHouseUpdateOMSType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="BasicCharacteristicts" type="{http://dom.gosuslugi.ru/schema/integration/house-management/}HouseBasicUpdateOMSType"/>
 *         &lt;element name="UndergroundFloorCount" type="{http://dom.gosuslugi.ru/schema/integration/house-management/}FloorType" minOccurs="0"/>
 *         &lt;element name="MinFloorCount" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}byte">
 *               &lt;maxInclusive value="99"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
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
@XmlType(name = "ApartmentHouseUpdateOMSType", propOrder = {
    "basicCharacteristicts",
    "undergroundFloorCount",
    "minFloorCount"
})
@XmlSeeAlso({
    ru.gosuslugi.dom.schema.integration.house_management.ImportHouseOMSRequest.ApartmentHouse.ApartmentHouseToUpdate.class
})
public class ApartmentHouseUpdateOMSType {

    @XmlElement(name = "BasicCharacteristicts", required = true)
    protected HouseBasicUpdateOMSType basicCharacteristicts;
    @XmlElement(name = "UndergroundFloorCount")
    protected String undergroundFloorCount;
    @XmlElement(name = "MinFloorCount")
    protected Byte minFloorCount;

    /**
     * Gets the value of the basicCharacteristicts property.
     * 
     * @return
     *     possible object is
     *     {@link HouseBasicUpdateOMSType }
     *     
     */
    public HouseBasicUpdateOMSType getBasicCharacteristicts() {
        return basicCharacteristicts;
    }

    /**
     * Sets the value of the basicCharacteristicts property.
     * 
     * @param value
     *     allowed object is
     *     {@link HouseBasicUpdateOMSType }
     *     
     */
    public void setBasicCharacteristicts(HouseBasicUpdateOMSType value) {
        this.basicCharacteristicts = value;
    }

    /**
     * Gets the value of the undergroundFloorCount property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUndergroundFloorCount() {
        return undergroundFloorCount;
    }

    /**
     * Sets the value of the undergroundFloorCount property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUndergroundFloorCount(String value) {
        this.undergroundFloorCount = value;
    }

    /**
     * Gets the value of the minFloorCount property.
     * 
     * @return
     *     possible object is
     *     {@link Byte }
     *     
     */
    public Byte getMinFloorCount() {
        return minFloorCount;
    }

    /**
     * Sets the value of the minFloorCount property.
     * 
     * @param value
     *     allowed object is
     *     {@link Byte }
     *     
     */
    public void setMinFloorCount(Byte value) {
        this.minFloorCount = value;
    }

}
