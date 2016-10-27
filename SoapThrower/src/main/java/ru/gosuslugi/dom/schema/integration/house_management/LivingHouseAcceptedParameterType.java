
package ru.gosuslugi.dom.schema.integration.house_management;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for LivingHouseAcceptedParameterType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="LivingHouseAcceptedParameterType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="FiasHouseGuid"/>
 *     &lt;enumeration value="TotalSquare"/>
 *     &lt;enumeration value="State"/>
 *     &lt;enumeration value="InnerWallMaterial"/>
 *     &lt;enumeration value="ProjectSeries"/>
 *     &lt;enumeration value="ProjectType"/>
 *     &lt;enumeration value="BuildingYear"/>
 *     &lt;enumeration value="UsedYear"/>
 *     &lt;enumeration value="TotalWear"/>
 *     &lt;enumeration value="FloorCount"/>
 *     &lt;enumeration value="Energy"/>
 *     &lt;enumeration value="OKTMO"/>
 *     &lt;enumeration value="OlsonTZ"/>
 *     &lt;enumeration value="ResidentialSquare"/>
 *     &lt;enumeration value="CulturalHeritage"/>
 *     &lt;enumeration value="ResidentialHouseType"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "LivingHouseAcceptedParameterType")
@XmlEnum
public enum LivingHouseAcceptedParameterType {

    @XmlEnumValue("FiasHouseGuid")
    FIAS_HOUSE_GUID("FiasHouseGuid"),
    @XmlEnumValue("TotalSquare")
    TOTAL_SQUARE("TotalSquare"),
    @XmlEnumValue("State")
    STATE("State"),
    @XmlEnumValue("InnerWallMaterial")
    INNER_WALL_MATERIAL("InnerWallMaterial"),
    @XmlEnumValue("ProjectSeries")
    PROJECT_SERIES("ProjectSeries"),
    @XmlEnumValue("ProjectType")
    PROJECT_TYPE("ProjectType"),
    @XmlEnumValue("BuildingYear")
    BUILDING_YEAR("BuildingYear"),
    @XmlEnumValue("UsedYear")
    USED_YEAR("UsedYear"),
    @XmlEnumValue("TotalWear")
    TOTAL_WEAR("TotalWear"),
    @XmlEnumValue("FloorCount")
    FLOOR_COUNT("FloorCount"),
    @XmlEnumValue("Energy")
    ENERGY("Energy"),
    OKTMO("OKTMO"),
    @XmlEnumValue("OlsonTZ")
    OLSON_TZ("OlsonTZ"),
    @XmlEnumValue("ResidentialSquare")
    RESIDENTIAL_SQUARE("ResidentialSquare"),
    @XmlEnumValue("CulturalHeritage")
    CULTURAL_HERITAGE("CulturalHeritage"),
    @XmlEnumValue("ResidentialHouseType")
    RESIDENTIAL_HOUSE_TYPE("ResidentialHouseType");
    private final String value;

    LivingHouseAcceptedParameterType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static LivingHouseAcceptedParameterType fromValue(String v) {
        for (LivingHouseAcceptedParameterType c: LivingHouseAcceptedParameterType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
