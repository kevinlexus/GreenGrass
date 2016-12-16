
package ru.gosuslugi.dom.schema.integration.inspection;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for OffenceStateType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="OffenceStateType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}token">
 *     &lt;enumeration value="Active"/>
 *     &lt;enumeration value="Cancelled"/>
 *     &lt;enumeration value="Fulfiled"/>
 *     &lt;enumeration value="NotFilled"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "OffenceStateType")
@XmlEnum
public enum OffenceStateType {


    /**
     * Не отменен.
     * 
     */
    @XmlEnumValue("Active")
    ACTIVE("Active"),

    /**
     * Отменен.
     * 
     */
    @XmlEnumValue("Cancelled")
    CANCELLED("Cancelled"),
    @XmlEnumValue("Fulfiled")
    FULFILED("Fulfiled"),
    @XmlEnumValue("NotFilled")
    NOT_FILLED("NotFilled");
    private final String value;

    OffenceStateType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static OffenceStateType fromValue(String v) {
        for (OffenceStateType c: OffenceStateType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
