
package ru.gosuslugi.dom.schema.integration.capital_repair;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import ru.gosuslugi.dom.schema.integration.organizations_registry_base.RegOrgType;


/**
 * Экспортируемый кредитный договор/договор займа
 * 
 * <p>Java class for ExportCreditContractType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ExportCreditContractType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/capital-repair/}CreditContractType">
 *       &lt;sequence>
 *         &lt;element name="Holder" type="{http://dom.gosuslugi.ru/schema/integration/organizations-registry-base/}RegOrgType"/>
 *         &lt;element name="RepaymentStatus" type="{http://dom.gosuslugi.ru/schema/integration/capital-repair/}String50Type"/>
 *         &lt;element name="TerminationInfo" type="{http://dom.gosuslugi.ru/schema/integration/capital-repair/}TerminationInfoType" minOccurs="0"/>
 *         &lt;element name="Status">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;enumeration value="Published"/>
 *               &lt;enumeration value="Canceled"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="CreditContractGUID" type="{http://www.w3.org/2001/XMLSchema}anyType"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ExportCreditContractType", propOrder = {
    "holder",
    "repaymentStatus",
    "terminationInfo",
    "status",
    "creditContractGUID"
})
public class ExportCreditContractType
    extends CreditContractType
{

    @XmlElement(name = "Holder", required = true)
    protected RegOrgType holder;
    @XmlElement(name = "RepaymentStatus", required = true)
    protected String repaymentStatus;
    @XmlElement(name = "TerminationInfo")
    protected TerminationInfoType terminationInfo;
    @XmlElement(name = "Status", required = true)
    protected String status;
    @XmlElement(name = "CreditContractGUID", required = true)
    protected Object creditContractGUID;

    /**
     * Gets the value of the holder property.
     * 
     * @return
     *     possible object is
     *     {@link RegOrgType }
     *     
     */
    public RegOrgType getHolder() {
        return holder;
    }

    /**
     * Sets the value of the holder property.
     * 
     * @param value
     *     allowed object is
     *     {@link RegOrgType }
     *     
     */
    public void setHolder(RegOrgType value) {
        this.holder = value;
    }

    /**
     * Gets the value of the repaymentStatus property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRepaymentStatus() {
        return repaymentStatus;
    }

    /**
     * Sets the value of the repaymentStatus property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRepaymentStatus(String value) {
        this.repaymentStatus = value;
    }

    /**
     * Gets the value of the terminationInfo property.
     * 
     * @return
     *     possible object is
     *     {@link TerminationInfoType }
     *     
     */
    public TerminationInfoType getTerminationInfo() {
        return terminationInfo;
    }

    /**
     * Sets the value of the terminationInfo property.
     * 
     * @param value
     *     allowed object is
     *     {@link TerminationInfoType }
     *     
     */
    public void setTerminationInfo(TerminationInfoType value) {
        this.terminationInfo = value;
    }

    /**
     * Gets the value of the status property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStatus() {
        return status;
    }

    /**
     * Sets the value of the status property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStatus(String value) {
        this.status = value;
    }

    /**
     * Gets the value of the creditContractGUID property.
     * 
     * @return
     *     possible object is
     *     {@link Object }
     *     
     */
    public Object getCreditContractGUID() {
        return creditContractGUID;
    }

    /**
     * Sets the value of the creditContractGUID property.
     * 
     * @param value
     *     allowed object is
     *     {@link Object }
     *     
     */
    public void setCreditContractGUID(Object value) {
        this.creditContractGUID = value;
    }

}
