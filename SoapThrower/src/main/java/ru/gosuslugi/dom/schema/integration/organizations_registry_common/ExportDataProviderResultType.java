
package ru.gosuslugi.dom.schema.integration.organizations_registry_common;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import ru.gosuslugi.dom.schema.integration.organizations_registry_base.RegOrgType;


/**
 * <p>Java class for exportDataProviderResultType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="exportDataProviderResultType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="DataProviderGUID" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType"/>
 *         &lt;element name="IsActual" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/organizations-registry-base/}RegOrg"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "exportDataProviderResultType", propOrder = {
    "dataProviderGUID",
    "isActual",
    "regOrg"
})
public class ExportDataProviderResultType {

    @XmlElement(name = "DataProviderGUID", required = true)
    protected String dataProviderGUID;
    @XmlElement(name = "IsActual")
    protected boolean isActual;
    @XmlElement(name = "RegOrg", namespace = "http://dom.gosuslugi.ru/schema/integration/organizations-registry-base/", required = true)
    protected RegOrgType regOrg;

    /**
     * Gets the value of the dataProviderGUID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDataProviderGUID() {
        return dataProviderGUID;
    }

    /**
     * Sets the value of the dataProviderGUID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDataProviderGUID(String value) {
        this.dataProviderGUID = value;
    }

    /**
     * Gets the value of the isActual property.
     * 
     */
    public boolean isIsActual() {
        return isActual;
    }

    /**
     * Sets the value of the isActual property.
     * 
     */
    public void setIsActual(boolean value) {
        this.isActual = value;
    }

    /**
     * Gets the value of the regOrg property.
     * 
     * @return
     *     possible object is
     *     {@link RegOrgType }
     *     
     */
    public RegOrgType getRegOrg() {
        return regOrg;
    }

    /**
     * Sets the value of the regOrg property.
     * 
     * @param value
     *     allowed object is
     *     {@link RegOrgType }
     *     
     */
    public void setRegOrg(RegOrgType value) {
        this.regOrg = value;
    }

}
