
package ru.gosuslugi.dom.schema.integration.capital_repair;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import ru.gosuslugi.dom.schema.integration.base.CommonResultType;


/**
 * Расширенный тип ответа на результат импорта
 * 
 * <p>Java class for CapRemCommonResultType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="CapRemCommonResultType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/base/}CommonResultType">
 *       &lt;sequence minOccurs="0">
 *         &lt;element name="AccountSpecialGuid" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CapRemCommonResultType", propOrder = {
    "accountSpecialGuid"
})
public class CapRemCommonResultType
    extends CommonResultType
{

    @XmlElement(name = "AccountSpecialGuid")
    protected String accountSpecialGuid;

    /**
     * Gets the value of the accountSpecialGuid property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAccountSpecialGuid() {
        return accountSpecialGuid;
    }

    /**
     * Sets the value of the accountSpecialGuid property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAccountSpecialGuid(String value) {
        this.accountSpecialGuid = value;
    }

}
