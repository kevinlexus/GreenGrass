
package ru.gosuslugi.dom.schema.integration.capital_repair;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;
import ru.gosuslugi.dom.schema.integration.base.AttachmentType;
import ru.gosuslugi.dom.schema.integration.organizations_registry_base.RegOrgType;


/**
 * Кредитный договор/договор займа
 * 
 * <p>Java class for CreditContractType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="CreditContractType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;choice>
 *           &lt;element name="CreditAgreement" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *           &lt;element name="LoanAgreement" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;/choice>
 *         &lt;element name="Creditor" type="{http://dom.gosuslugi.ru/schema/integration/organizations-registry-base/}RegOrgType" minOccurs="0"/>
 *         &lt;element name="BIKCredOrg" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://dom.gosuslugi.ru/schema/integration/organizations-base/}BIKType">
 *               &lt;pattern value="\d{9}"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="Lender" type="{http://dom.gosuslugi.ru/schema/integration/organizations-registry-base/}RegOrgType" minOccurs="0"/>
 *         &lt;element name="Number" type="{http://dom.gosuslugi.ru/schema/integration/base/}String255Type"/>
 *         &lt;element name="Date" type="{http://www.w3.org/2001/XMLSchema}date"/>
 *         &lt;choice>
 *           &lt;element name="Term">
 *             &lt;simpleType>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}int">
 *                 &lt;minExclusive value="0"/>
 *               &lt;/restriction>
 *             &lt;/simpleType>
 *           &lt;/element>
 *           &lt;element name="Termless" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;/choice>
 *         &lt;choice>
 *           &lt;element name="InterestRate">
 *             &lt;simpleType>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}decimal">
 *                 &lt;minExclusive value="0"/>
 *                 &lt;fractionDigits value="2"/>
 *               &lt;/restriction>
 *             &lt;/simpleType>
 *           &lt;/element>
 *           &lt;element name="InterestFree" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;/choice>
 *         &lt;element name="InterestRateNote" type="{http://dom.gosuslugi.ru/schema/integration/capital-repair/}String1024Type" minOccurs="0"/>
 *         &lt;element name="Amount">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://dom.gosuslugi.ru/schema/integration/bills-base/}MoneyType">
 *               &lt;minExclusive value="0"/>
 *               &lt;fractionDigits value="2"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="AmountNote" type="{http://dom.gosuslugi.ru/schema/integration/capital-repair/}String1024Type" minOccurs="0"/>
 *         &lt;element name="AttachContract" type="{http://dom.gosuslugi.ru/schema/integration/base/}AttachmentType" maxOccurs="1000"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CreditContractType", propOrder = {
    "creditAgreement",
    "loanAgreement",
    "creditor",
    "bikCredOrg",
    "lender",
    "number",
    "date",
    "term",
    "termless",
    "interestRate",
    "interestFree",
    "interestRateNote",
    "amount",
    "amountNote",
    "attachContract"
})
@XmlSeeAlso({
    ExportCreditContractType.class
})
public class CreditContractType {

    @XmlElement(name = "CreditAgreement")
    protected Boolean creditAgreement;
    @XmlElement(name = "LoanAgreement")
    protected Boolean loanAgreement;
    @XmlElement(name = "Creditor")
    protected RegOrgType creditor;
    @XmlElement(name = "BIKCredOrg")
    protected String bikCredOrg;
    @XmlElement(name = "Lender")
    protected RegOrgType lender;
    @XmlElement(name = "Number", required = true)
    protected String number;
    @XmlElement(name = "Date", required = true)
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar date;
    @XmlElement(name = "Term")
    protected Integer term;
    @XmlElement(name = "Termless")
    protected Boolean termless;
    @XmlElement(name = "InterestRate")
    protected BigDecimal interestRate;
    @XmlElement(name = "InterestFree")
    protected Boolean interestFree;
    @XmlElement(name = "InterestRateNote")
    protected String interestRateNote;
    @XmlElement(name = "Amount", required = true)
    protected BigDecimal amount;
    @XmlElement(name = "AmountNote")
    protected String amountNote;
    @XmlElement(name = "AttachContract", required = true)
    protected List<AttachmentType> attachContract;

    /**
     * Gets the value of the creditAgreement property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isCreditAgreement() {
        return creditAgreement;
    }

    /**
     * Sets the value of the creditAgreement property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setCreditAgreement(Boolean value) {
        this.creditAgreement = value;
    }

    /**
     * Gets the value of the loanAgreement property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isLoanAgreement() {
        return loanAgreement;
    }

    /**
     * Sets the value of the loanAgreement property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setLoanAgreement(Boolean value) {
        this.loanAgreement = value;
    }

    /**
     * Gets the value of the creditor property.
     * 
     * @return
     *     possible object is
     *     {@link RegOrgType }
     *     
     */
    public RegOrgType getCreditor() {
        return creditor;
    }

    /**
     * Sets the value of the creditor property.
     * 
     * @param value
     *     allowed object is
     *     {@link RegOrgType }
     *     
     */
    public void setCreditor(RegOrgType value) {
        this.creditor = value;
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
     * Gets the value of the lender property.
     * 
     * @return
     *     possible object is
     *     {@link RegOrgType }
     *     
     */
    public RegOrgType getLender() {
        return lender;
    }

    /**
     * Sets the value of the lender property.
     * 
     * @param value
     *     allowed object is
     *     {@link RegOrgType }
     *     
     */
    public void setLender(RegOrgType value) {
        this.lender = value;
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

    /**
     * Gets the value of the date property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDate() {
        return date;
    }

    /**
     * Sets the value of the date property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDate(XMLGregorianCalendar value) {
        this.date = value;
    }

    /**
     * Gets the value of the term property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getTerm() {
        return term;
    }

    /**
     * Sets the value of the term property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setTerm(Integer value) {
        this.term = value;
    }

    /**
     * Gets the value of the termless property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isTermless() {
        return termless;
    }

    /**
     * Sets the value of the termless property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setTermless(Boolean value) {
        this.termless = value;
    }

    /**
     * Gets the value of the interestRate property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getInterestRate() {
        return interestRate;
    }

    /**
     * Sets the value of the interestRate property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setInterestRate(BigDecimal value) {
        this.interestRate = value;
    }

    /**
     * Gets the value of the interestFree property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isInterestFree() {
        return interestFree;
    }

    /**
     * Sets the value of the interestFree property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setInterestFree(Boolean value) {
        this.interestFree = value;
    }

    /**
     * Gets the value of the interestRateNote property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getInterestRateNote() {
        return interestRateNote;
    }

    /**
     * Sets the value of the interestRateNote property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setInterestRateNote(String value) {
        this.interestRateNote = value;
    }

    /**
     * Gets the value of the amount property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getAmount() {
        return amount;
    }

    /**
     * Sets the value of the amount property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setAmount(BigDecimal value) {
        this.amount = value;
    }

    /**
     * Gets the value of the amountNote property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAmountNote() {
        return amountNote;
    }

    /**
     * Sets the value of the amountNote property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAmountNote(String value) {
        this.amountNote = value;
    }

    /**
     * Gets the value of the attachContract property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the attachContract property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAttachContract().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link AttachmentType }
     * 
     * 
     */
    public List<AttachmentType> getAttachContract() {
        if (attachContract == null) {
            attachContract = new ArrayList<AttachmentType>();
        }
        return this.attachContract;
    }

}
