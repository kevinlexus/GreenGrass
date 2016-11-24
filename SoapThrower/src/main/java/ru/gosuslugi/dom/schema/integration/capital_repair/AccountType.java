
package ru.gosuslugi.dom.schema.integration.capital_repair;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;
import ru.gosuslugi.dom.schema.integration.organizations_registry_base.RegOrgType;


/**
 * Общий тип счета регионального оператора/специального счета
 * 
 * <p>Java class for AccountType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="AccountType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="CredOrganization" type="{http://dom.gosuslugi.ru/schema/integration/organizations-registry-base/}RegOrgType"/>
 *         &lt;element name="BIKCredOrg">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://dom.gosuslugi.ru/schema/integration/organizations-base/}BIKType">
 *               &lt;pattern value="\d{9}"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="Number" type="{http://dom.gosuslugi.ru/schema/integration/capital-repair/}AccountNumberType"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AccountType", propOrder = {
    "credOrganization",
    "bikCredOrg",
    "number"
})
@XmlSeeAlso({
    ru.gosuslugi.dom.schema.integration.capital_repair.ImportAccountSpecialRequest.ImportAccountSpecial.LoadChangeAccountSpecial.class,
    ru.gosuslugi.dom.schema.integration.capital_repair.ImportAccountRegionalOperatorRequest.ImportAccountRegOperator.LoadAccountRegOperator.class,
    ru.gosuslugi.dom.schema.integration.capital_repair.ExportAccountType.Details.class
})
public class AccountType {

    @XmlElement(name = "CredOrganization", required = true)
    protected RegOrgType credOrganization;
    @XmlElement(name = "BIKCredOrg", required = true)
    protected String bikCredOrg;
    @XmlElement(name = "Number", required = true)
    protected String number;

    /**
     * Gets the value of the credOrganization property.
     * 
     * @return
     *     possible object is
     *     {@link RegOrgType }
     *     
     */
    public RegOrgType getCredOrganization() {
        return credOrganization;
    }

    /**
     * Sets the value of the credOrganization property.
     * 
     * @param value
     *     allowed object is
     *     {@link RegOrgType }
     *     
     */
    public void setCredOrganization(RegOrgType value) {
        this.credOrganization = value;
    }

    /**
     * Gets the value of the bikCredOrg property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBIKCredOrg() {
        return bikCredOrg;
    }

    /**
     * Sets the value of the bikCredOrg property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBIKCredOrg(String value) {
        this.bikCredOrg = value;
    }

    /**
     * Gets the value of the number property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNumber() {
        return number;
    }

    /**
     * Sets the value of the number property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNumber(String value) {
        this.number = value;
    }

}
