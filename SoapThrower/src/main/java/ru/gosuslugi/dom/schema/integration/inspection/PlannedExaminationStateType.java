
package ru.gosuslugi.dom.schema.integration.inspection;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for PlannedExaminationStateType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="PlannedExaminationStateType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}token">
 *     &lt;enumeration value="Planned"/>
 *     &lt;enumeration value="Cancelled"/>
 *     &lt;enumeration value="Finished"/>
 *     &lt;enumeration value="Annulled"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "PlannedExaminationStateType")
@XmlEnum
public enum PlannedExaminationStateType {


    /**
     * Запланирована.
     * 
     */
    @XmlEnumValue("Planned")
    PLANNED("Planned"),

    /**
     * Отменена.
     * 
     */
    @XmlEnumValue("Cancelled")
    CANCELLED("Cancelled"),
    @XmlEnumValue("Finished")
    FINISHED("Finished"),
    @XmlEnumValue("Annulled")
    ANNULLED("Annulled");
    private final String value;

    PlannedExaminationStateType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static PlannedExaminationStateType fromValue(String v) {
        for (PlannedExaminationStateType c: PlannedExaminationStateType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
