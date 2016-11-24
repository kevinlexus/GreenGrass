
package ru.gosuslugi.dom.schema.integration.house_management;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for exportAccountIndividualServicesResultType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="exportAccountIndividualServicesResultType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/house-management/}AccountIndividualServiceType">
 *       &lt;sequence>
 *         &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/house-management/}AccountIndividualServiceGUID"/>
 *         &lt;element name="AccountGUID" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType"/>
 *         &lt;element name="IsActual" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "exportAccountIndividualServicesResultType", propOrder = {
    "accountIndividualServiceGUID",
    "accountGUID",
    "isActual"
})
public class ExportAccountIndividualServicesResultType
    extends AccountIndividualServiceType
{

    @XmlElement(name = "AccountIndividualServiceGUID", required = true)
    protected String accountIndividualServiceGUID;
    @XmlElement(name = "AccountGUID", required = true)
    protected String accountGUID;
    @XmlElement(name = "IsActual")
    protected boolean isActual;

    /**
     * Gets the value of the accountIndividualServiceGUID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAccountIndividualServiceGUID() {
        return accountIndividualServiceGUID;
    }

    /**
     * Sets the value of the accountIndividualServiceGUID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAccountIndividualServiceGUID(String value) {
        this.accountIndividualServiceGUID = value;
    }

    /**
     * Gets the value of the accountGUID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAccountGUID() {
        return accountGUID;
    }

    /**
     * Sets the value of the accountGUID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAccountGUID(String value) {
        this.accountGUID = value;
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

}
