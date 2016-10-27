
package ru.gosuslugi.dom.schema.integration.house_management;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ResidentialPremiseAcceptedParameterType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="ResidentialPremiseAcceptedParameterType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="PremisesNum"/>
 *     &lt;enumeration value="EntranceNum"/>
 *     &lt;enumeration value="PremisesCharacteristic"/>
 *     &lt;enumeration value="RoomsNum"/>
 *     &lt;enumeration value="TotalArea"/>
 *     &lt;enumeration value="GrossArea"/>
 *     &lt;enumeration value="ResidentialHouseType"/>
 *     &lt;enumeration value="TerminationDate"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "ResidentialPremiseAcceptedParameterType")
@XmlEnum
public enum ResidentialPremiseAcceptedParameterType {

    @XmlEnumValue("PremisesNum")
    PREMISES_NUM("PremisesNum"),
    @XmlEnumValue("EntranceNum")
    ENTRANCE_NUM("EntranceNum"),
    @XmlEnumValue("PremisesCharacteristic")
    PREMISES_CHARACTERISTIC("PremisesCharacteristic"),
    @XmlEnumValue("RoomsNum")
    ROOMS_NUM("RoomsNum"),
    @XmlEnumValue("TotalArea")
    TOTAL_AREA("TotalArea"),
    @XmlEnumValue("GrossArea")
    GROSS_AREA("GrossArea"),
    @XmlEnumValue("ResidentialHouseType")
    RESIDENTIAL_HOUSE_TYPE("ResidentialHouseType"),
    @XmlEnumValue("TerminationDate")
    TERMINATION_DATE("TerminationDate");
    private final String value;

    ResidentialPremiseAcceptedParameterType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static ResidentialPremiseAcceptedParameterType fromValue(String v) {
        for (ResidentialPremiseAcceptedParameterType c: ResidentialPremiseAcceptedParameterType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
