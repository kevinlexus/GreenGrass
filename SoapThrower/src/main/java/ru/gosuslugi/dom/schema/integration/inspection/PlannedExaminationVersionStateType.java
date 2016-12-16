
package ru.gosuslugi.dom.schema.integration.inspection;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for PlannedExaminationVersionStateType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="PlannedExaminationVersionStateType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}token">
 *     &lt;enumeration value="Draft"/>
 *     &lt;enumeration value="Active"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "PlannedExaminationVersionStateType")
@XmlEnum
public enum PlannedExaminationVersionStateType {


    /**
     * Черновик.
     * 
     */
    @XmlEnumValue("Draft")
    DRAFT("Draft"),

    /**
     * Опубликована.
     * 
     */
    @XmlEnumValue("Active")
    ACTIVE("Active");
    private final String value;

    PlannedExaminationVersionStateType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static PlannedExaminationVersionStateType fromValue(String v) {
        for (PlannedExaminationVersionStateType c: PlannedExaminationVersionStateType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
