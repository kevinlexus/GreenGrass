
package ru.gosuslugi.dom.schema.integration.capital_repair;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * Экспортируемая информация о размере фондов капитального ремонта
 * 
 * <p>Java class for exportFundSizeInfoType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="exportFundSizeInfoType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/capital-repair/}FundSizeInfoType">
 *       &lt;sequence>
 *         &lt;element name="FundSizeInfoGuid" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType"/>
 *         &lt;element name="Status" type="{http://dom.gosuslugi.ru/schema/integration/capital-repair/}StatusType"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "exportFundSizeInfoType", propOrder = {
    "fundSizeInfoGuid",
    "status"
})
public class ExportFundSizeInfoType
    extends FundSizeInfoType
{

    @XmlElement(name = "FundSizeInfoGuid", required = true)
    protected String fundSizeInfoGuid;
    @XmlElement(name = "Status", required = true)
    @XmlSchemaType(name = "token")
    protected StatusType status;

    /**
     * Gets the value of the fundSizeInfoGuid property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFundSizeInfoGuid() {
        return fundSizeInfoGuid;
    }

    /**
     * Sets the value of the fundSizeInfoGuid property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFundSizeInfoGuid(String value) {
        this.fundSizeInfoGuid = value;
    }

    /**
     * Gets the value of the status property.
     * 
     * @return
     *     possible object is
     *     {@link StatusType }
     *     
     */
    public StatusType getStatus() {
        return status;
    }

    /**
     * Sets the value of the status property.
     * 
     * @param value
     *     allowed object is
     *     {@link StatusType }
     *     
     */
    public void setStatus(StatusType value) {
        this.status = value;
    }

}
