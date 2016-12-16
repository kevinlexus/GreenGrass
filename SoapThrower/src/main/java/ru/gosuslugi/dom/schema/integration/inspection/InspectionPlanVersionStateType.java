
package ru.gosuslugi.dom.schema.integration.inspection;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for InspectionPlanVersionStateType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="InspectionPlanVersionStateType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}token">
 *     &lt;enumeration value="Draft"/>
 *     &lt;enumeration value="Signed"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "InspectionPlanVersionStateType")
@XmlEnum
public enum InspectionPlanVersionStateType {


    /**
     * Черновик.
     * 
     */
    @XmlEnumValue("Draft")
    DRAFT("Draft"),

    /**
     * Подписан.
     * 
     */
    @XmlEnumValue("Signed")
    SIGNED("Signed");
    private final String value;

    InspectionPlanVersionStateType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static InspectionPlanVersionStateType fromValue(String v) {
        for (InspectionPlanVersionStateType c: InspectionPlanVersionStateType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
