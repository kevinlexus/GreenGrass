
package ru.gosuslugi.dom.schema.integration.msp;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ServiceType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="ServiceType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="ColdWater"/>
 *     &lt;enumeration value="HotWater"/>
 *     &lt;enumeration value="Sewerage"/>
 *     &lt;enumeration value="Electricity"/>
 *     &lt;enumeration value="Gas"/>
 *     &lt;enumeration value="SolidFuel"/>
 *     &lt;enumeration value="LiquidGas"/>
 *     &lt;enumeration value="Heating"/>
 *     &lt;enumeration value="Waste"/>
 *     &lt;enumeration value="Maintenance"/>
 *     &lt;enumeration value="Repairs"/>
 *     &lt;enumeration value="Rent"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "ServiceType")
@XmlEnum
public enum ServiceType {

    @XmlEnumValue("ColdWater")
    COLD_WATER("ColdWater"),
    @XmlEnumValue("HotWater")
    HOT_WATER("HotWater"),
    @XmlEnumValue("Sewerage")
    SEWERAGE("Sewerage"),
    @XmlEnumValue("Electricity")
    ELECTRICITY("Electricity"),
    @XmlEnumValue("Gas")
    GAS("Gas"),
    @XmlEnumValue("SolidFuel")
    SOLID_FUEL("SolidFuel"),
    @XmlEnumValue("LiquidGas")
    LIQUID_GAS("LiquidGas"),
    @XmlEnumValue("Heating")
    HEATING("Heating"),
    @XmlEnumValue("Waste")
    WASTE("Waste"),
    @XmlEnumValue("Maintenance")
    MAINTENANCE("Maintenance"),
    @XmlEnumValue("Repairs")
    REPAIRS("Repairs"),
    @XmlEnumValue("Rent")
    RENT("Rent");
    private final String value;

    ServiceType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static ServiceType fromValue(String v) {
        for (ServiceType c: ServiceType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
