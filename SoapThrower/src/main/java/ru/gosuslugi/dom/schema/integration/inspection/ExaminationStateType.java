
package ru.gosuslugi.dom.schema.integration.inspection;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ExaminationStateType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="ExaminationStateType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}token">
 *     &lt;enumeration value="Planned"/>
 *     &lt;enumeration value="Finished"/>
 *     &lt;enumeration value="Cancelled"/>
 *     &lt;enumeration value="Annulled"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "ExaminationStateType")
@XmlEnum
public enum ExaminationStateType {


    /**
     * Выполняется.
     * 
     */
    @XmlEnumValue("Planned")
    PLANNED("Planned"),

    /**
     * Завершена.
     * 
     */
    @XmlEnumValue("Finished")
    FINISHED("Finished"),

    /**
     * Отменена.
     * 
     */
    @XmlEnumValue("Cancelled")
    CANCELLED("Cancelled"),
    @XmlEnumValue("Annulled")
    ANNULLED("Annulled");
    private final String value;

    ExaminationStateType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static ExaminationStateType fromValue(String v) {
        for (ExaminationStateType c: ExaminationStateType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
