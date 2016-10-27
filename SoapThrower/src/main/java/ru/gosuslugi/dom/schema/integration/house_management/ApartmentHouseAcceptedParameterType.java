
package ru.gosuslugi.dom.schema.integration.house_management;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ApartmentHouseAcceptedParameterType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="ApartmentHouseAcceptedParameterType">
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
 *     &lt;enumeration value="BuiltUpArea"/>
 *     &lt;enumeration value="UndergroundFloorCount"/>
 *     &lt;enumeration value="MinFloorCount"/>
 *     &lt;enumeration value="OverhaulYear"/>
 *     &lt;enumeration value="OverhaulFormingKind"/>
 *     &lt;enumeration value="NonResidentialSquare"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "ApartmentHouseAcceptedParameterType")
@XmlEnum
public enum ApartmentHouseAcceptedParameterType {

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
    @XmlEnumValue("BuiltUpArea")
    BUILT_UP_AREA("BuiltUpArea"),
    @XmlEnumValue("UndergroundFloorCount")
    UNDERGROUND_FLOOR_COUNT("UndergroundFloorCount"),
    @XmlEnumValue("MinFloorCount")
    MIN_FLOOR_COUNT("MinFloorCount"),
    @XmlEnumValue("OverhaulYear")
    OVERHAUL_YEAR("OverhaulYear"),
    @XmlEnumValue("OverhaulFormingKind")
    OVERHAUL_FORMING_KIND("OverhaulFormingKind"),
    @XmlEnumValue("NonResidentialSquare")
    NON_RESIDENTIAL_SQUARE("NonResidentialSquare");
    private final String value;

    ApartmentHouseAcceptedParameterType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static ApartmentHouseAcceptedParameterType fromValue(String v) {
        for (ApartmentHouseAcceptedParameterType c: ApartmentHouseAcceptedParameterType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
