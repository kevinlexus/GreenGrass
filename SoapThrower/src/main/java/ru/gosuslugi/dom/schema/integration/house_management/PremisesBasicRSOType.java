
package ru.gosuslugi.dom.schema.integration.house_management;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * Базовый тип помещения (для импорта от РСО)
 * 
 * <p>Java class for PremisesBasicRSOType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="PremisesBasicRSOType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/house-management/}GKN_EGRP_KeyRSOType">
 *       &lt;sequence>
 *         &lt;element name="PremisesNum" type="{http://dom.gosuslugi.ru/schema/integration/house-management/}PremisesNumType"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PremisesBasicRSOType", propOrder = {
    "premisesNum"
})
@XmlSeeAlso({
    ResidentialPremisesRSOType.class,
    NonResidentialPremisesRSOType.class
})
public class PremisesBasicRSOType
    extends GKNEGRPKeyRSOType
{

    @XmlElement(name = "PremisesNum", required = true)
    protected String premisesNum;

    /**
     * Gets the value of the premisesNum property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPremisesNum() {
        return premisesNum;
    }

    /**
     * Sets the value of the premisesNum property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPremisesNum(String value) {
        this.premisesNum = value;
    }

}
