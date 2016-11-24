
package ru.gosuslugi.dom.schema.integration.capital_repair;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;
import ru.gosuslugi.dom.schema.integration.base.BaseType;
import ru.gosuslugi.dom.schema.integration.organizations_registry_base.RegOrgType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/base/}BaseType">
 *       &lt;sequence>
 *         &lt;choice>
 *           &lt;element name="AccountGuid" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType" maxOccurs="1000"/>
 *           &lt;element name="CredOrganization" type="{http://dom.gosuslugi.ru/schema/integration/organizations-registry-base/}RegOrgType" maxOccurs="100"/>
 *           &lt;element name="BIKCredOrg" maxOccurs="100">
 *             &lt;simpleType>
 *               &lt;restriction base="{http://dom.gosuslugi.ru/schema/integration/organizations-base/}BIKType">
 *                 &lt;pattern value="\d{9}"/>
 *               &lt;/restriction>
 *             &lt;/simpleType>
 *           &lt;/element>
 *           &lt;sequence>
 *             &lt;element name="OpenDateFrom" type="{http://www.w3.org/2001/XMLSchema}date"/>
 *             &lt;element name="OpenDateTo" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
 *           &lt;/sequence>
 *         &lt;/choice>
 *         &lt;choice>
 *           &lt;element name="WithoutOperationAndBalance" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *           &lt;sequence>
 *             &lt;element name="ReportingPeriodFrom" type="{http://dom.gosuslugi.ru/schema/integration/capital-repair/}ReportingPeriodType"/>
 *             &lt;element name="ReportingPeriodTo" type="{http://dom.gosuslugi.ru/schema/integration/capital-repair/}ReportingPeriodType" minOccurs="0"/>
 *           &lt;/sequence>
 *         &lt;/choice>
 *       &lt;/sequence>
 *       &lt;attribute ref="{http://dom.gosuslugi.ru/schema/integration/base/}version use="required" fixed="12.0.0.1""/>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "accountGuid",
    "credOrganization",
    "bikCredOrg",
    "openDateFrom",
    "openDateTo",
    "withoutOperationAndBalance",
    "reportingPeriodFrom",
    "reportingPeriodTo"
})
@XmlRootElement(name = "exportAccountRequest")
public class ExportAccountRequest
    extends BaseType
{

    @XmlElement(name = "AccountGuid")
    protected List<String> accountGuid;
    @XmlElement(name = "CredOrganization")
    protected List<RegOrgType> credOrganization;
    @XmlElement(name = "BIKCredOrg")
    protected List<String> bikCredOrg;
    @XmlElement(name = "OpenDateFrom")
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar openDateFrom;
    @XmlElement(name = "OpenDateTo")
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar openDateTo;
    @XmlElement(name = "WithoutOperationAndBalance")
    protected Boolean withoutOperationAndBalance;
    @XmlElement(name = "ReportingPeriodFrom")
    protected ReportingPeriodType reportingPeriodFrom;
    @XmlElement(name = "ReportingPeriodTo")
    protected ReportingPeriodType reportingPeriodTo;
    @XmlAttribute(name = "version", namespace = "http://dom.gosuslugi.ru/schema/integration/base/", required = true)
    protected String version;

    /**
     * Gets the value of the accountGuid property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the accountGuid property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAccountGuid().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getAccountGuid() {
        if (accountGuid == null) {
            accountGuid = new ArrayList<String>();
        }
        return this.accountGuid;
    }

    /**
     * Gets the value of the credOrganization property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the credOrganization property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCredOrganization().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link RegOrgType }
     * 
     * 
     */
    public List<RegOrgType> getCredOrganization() {
        if (credOrganization == null) {
            credOrganization = new ArrayList<RegOrgType>();
        }
        return this.credOrganization;
    }

    /**
     * Gets the value of the bikCredOrg property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the bikCredOrg property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getBIKCredOrg().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getBIKCredOrg() {
        if (bikCredOrg == null) {
            bikCredOrg = new ArrayList<String>();
        }
        return this.bikCredOrg;
    }

    /**
     * Gets the value of the openDateFrom property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getOpenDateFrom() {
        return openDateFrom;
    }

    /**
     * Sets the value of the openDateFrom property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setOpenDateFrom(XMLGregorianCalendar value) {
        this.openDateFrom = value;
    }

    /**
     * Gets the value of the openDateTo property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getOpenDateTo() {
        return openDateTo;
    }

    /**
     * Sets the value of the openDateTo property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setOpenDateTo(XMLGregorianCalendar value) {
        this.openDateTo = value;
    }

    /**
     * Gets the value of the withoutOperationAndBalance property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isWithoutOperationAndBalance() {
        return withoutOperationAndBalance;
    }

    /**
     * Sets the value of the withoutOperationAndBalance property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setWithoutOperationAndBalance(Boolean value) {
        this.withoutOperationAndBalance = value;
    }

    /**
     * Gets the value of the reportingPeriodFrom property.
     * 
     * @return
     *     possible object is
     *     {@link ReportingPeriodType }
     *     
     */
    public ReportingPeriodType getReportingPeriodFrom() {
        return reportingPeriodFrom;
    }

    /**
     * Sets the value of the reportingPeriodFrom property.
     * 
     * @param value
     *     allowed object is
     *     {@link ReportingPeriodType }
     *     
     */
    public void setReportingPeriodFrom(ReportingPeriodType value) {
        this.reportingPeriodFrom = value;
    }

    /**
     * Gets the value of the reportingPeriodTo property.
     * 
     * @return
     *     possible object is
     *     {@link ReportingPeriodType }
     *     
     */
    public ReportingPeriodType getReportingPeriodTo() {
        return reportingPeriodTo;
    }

    /**
     * Sets the value of the reportingPeriodTo property.
     * 
     * @param value
     *     allowed object is
     *     {@link ReportingPeriodType }
     *     
     */
    public void setReportingPeriodTo(ReportingPeriodType value) {
        this.reportingPeriodTo = value;
    }

    /**
     * Gets the value of the version property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVersion() {
        if (version == null) {
            return "12.0.0.1";
        } else {
            return version;
        }
    }

    /**
     * Sets the value of the version property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVersion(String value) {
        this.version = value;
    }

}
