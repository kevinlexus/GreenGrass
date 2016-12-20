
package ru.gosuslugi.dom.schema.integration.capital_repair;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import ru.gosuslugi.dom.schema.integration.base.BaseAsyncResponseType;
import ru.gosuslugi.dom.schema.integration.base.ErrorMessageType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/base/}BaseAsyncResponseType">
 *       &lt;choice>
 *         &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/base/}ErrorMessage"/>
 *         &lt;element name="ImportResult" type="{http://dom.gosuslugi.ru/schema/integration/capital-repair/}CapRemCommonResultType" maxOccurs="unbounded"/>
 *         &lt;element name="Contract" type="{http://dom.gosuslugi.ru/schema/integration/capital-repair/}exportFullContractType" maxOccurs="1000"/>
 *         &lt;element name="Plan" type="{http://dom.gosuslugi.ru/schema/integration/capital-repair/}exportPlanType" maxOccurs="1000"/>
 *         &lt;element name="Account" type="{http://dom.gosuslugi.ru/schema/integration/capital-repair/}ExportAccountType" maxOccurs="1000"/>
 *         &lt;element name="Decision" type="{http://dom.gosuslugi.ru/schema/integration/capital-repair/}exportDecisionType" maxOccurs="1000"/>
 *         &lt;element name="CreditContract" type="{http://dom.gosuslugi.ru/schema/integration/capital-repair/}ExportCreditContractType" maxOccurs="unbounded"/>
 *         &lt;element name="FundSizeInfo" type="{http://dom.gosuslugi.ru/schema/integration/capital-repair/}exportFundSizeInfoType" maxOccurs="unbounded"/>
 *       &lt;/choice>
 *       &lt;attribute ref="{http://dom.gosuslugi.ru/schema/integration/base/}version use="required" fixed="11.0.0.1""/>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "errorMessage",
    "importResult",
    "contract",
    "plan",
    "account",
    "decision",
    "creditContract",
    "fundSizeInfo"
})
@XmlRootElement(name = "getStateResult")
public class GetStateResult
    extends BaseAsyncResponseType
{

    @XmlElement(name = "ErrorMessage", namespace = "http://dom.gosuslugi.ru/schema/integration/base/")
    protected ErrorMessageType errorMessage;
    @XmlElement(name = "ImportResult")
    protected List<CapRemCommonResultType> importResult;
    @XmlElement(name = "Contract")
    protected List<ExportFullContractType> contract;
    @XmlElement(name = "Plan")
    protected List<ExportPlanType> plan;
    @XmlElement(name = "Account")
    protected List<ExportAccountType> account;
    @XmlElement(name = "Decision")
    protected List<ExportDecisionType> decision;
    @XmlElement(name = "CreditContract")
    protected List<ExportCreditContractType> creditContract;
    @XmlElement(name = "FundSizeInfo")
    protected List<ExportFundSizeInfoType> fundSizeInfo;
    @XmlAttribute(name = "version", namespace = "http://dom.gosuslugi.ru/schema/integration/base/", required = true)
    protected String version;

    /**
     * Gets the value of the errorMessage property.
     * 
     * @return
     *     possible object is
     *     {@link ErrorMessageType }
     *     
     */
    public ErrorMessageType getErrorMessage() {
        return errorMessage;
    }

    /**
     * Sets the value of the errorMessage property.
     * 
     * @param value
     *     allowed object is
     *     {@link ErrorMessageType }
     *     
     */
    public void setErrorMessage(ErrorMessageType value) {
        this.errorMessage = value;
    }

    /**
     * Gets the value of the importResult property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the importResult property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getImportResult().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CapRemCommonResultType }
     * 
     * 
     */
    public List<CapRemCommonResultType> getImportResult() {
        if (importResult == null) {
            importResult = new ArrayList<CapRemCommonResultType>();
        }
        return this.importResult;
    }

    /**
     * Gets the value of the contract property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the contract property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getContract().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ExportFullContractType }
     * 
     * 
     */
    public List<ExportFullContractType> getContract() {
        if (contract == null) {
            contract = new ArrayList<ExportFullContractType>();
        }
        return this.contract;
    }

    /**
     * Gets the value of the plan property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the plan property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPlan().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ExportPlanType }
     * 
     * 
     */
    public List<ExportPlanType> getPlan() {
        if (plan == null) {
            plan = new ArrayList<ExportPlanType>();
        }
        return this.plan;
    }

    /**
     * Gets the value of the account property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the account property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAccount().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ExportAccountType }
     * 
     * 
     */
    public List<ExportAccountType> getAccount() {
        if (account == null) {
            account = new ArrayList<ExportAccountType>();
        }
        return this.account;
    }

    /**
     * Gets the value of the decision property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the decision property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDecision().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ExportDecisionType }
     * 
     * 
     */
    public List<ExportDecisionType> getDecision() {
        if (decision == null) {
            decision = new ArrayList<ExportDecisionType>();
        }
        return this.decision;
    }

    /**
     * Gets the value of the creditContract property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the creditContract property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCreditContract().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ExportCreditContractType }
     * 
     * 
     */
    public List<ExportCreditContractType> getCreditContract() {
        if (creditContract == null) {
            creditContract = new ArrayList<ExportCreditContractType>();
        }
        return this.creditContract;
    }

    /**
     * Gets the value of the fundSizeInfo property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the fundSizeInfo property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getFundSizeInfo().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ExportFundSizeInfoType }
     * 
     * 
     */
    public List<ExportFundSizeInfoType> getFundSizeInfo() {
        if (fundSizeInfo == null) {
            fundSizeInfo = new ArrayList<ExportFundSizeInfoType>();
        }
        return this.fundSizeInfo;
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
            return "11.0.0.1";
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
