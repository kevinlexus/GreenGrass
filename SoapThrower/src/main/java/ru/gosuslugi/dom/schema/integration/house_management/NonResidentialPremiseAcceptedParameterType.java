
package ru.gosuslugi.dom.schema.integration.house_management;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for NonResidentialPremiseAcceptedParameterType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="NonResidentialPremiseAcceptedParameterType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="PremisesNum"/>
 *     &lt;enumeration value="Purpose"/>
 *     &lt;enumeration value="Position"/>
 *     &lt;enumeration value="TotalArea"/>
 *     &lt;enumeration value="IsCommonProperty"/>
 *     &lt;enumeration value="TerminationDate"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "NonResidentialPremiseAcceptedParameterType")
@XmlEnum
public enum NonResidentialPremiseAcceptedParameterType {

    @XmlEnumValue("PremisesNum")
    PREMISES_NUM("PremisesNum"),
    @XmlEnumValue("Purpose")
    PURPOSE("Purpose"),
    @XmlEnumValue("Position")
    POSITION("Position"),
    @XmlEnumValue("TotalArea")
    TOTAL_AREA("TotalArea"),
    @XmlEnumValue("IsCommonProperty")
    IS_COMMON_PROPERTY("IsCommonProperty"),
    @XmlEnumValue("TerminationDate")
    TERMINATION_DATE("TerminationDate");
    private final String value;

    NonResidentialPremiseAcceptedParameterType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static NonResidentialPremiseAcceptedParameterType fromValue(String v) {
        for (NonResidentialPremiseAcceptedParameterType c: NonResidentialPremiseAcceptedParameterType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
