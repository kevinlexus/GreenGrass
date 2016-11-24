
package ru.gosuslugi.dom.schema.integration.capital_repair;

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
 * Тип данных для решения о выборе способа формирования фонда капитального ремонта
 * 
 * <p>Java class for DecisionType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="DecisionType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="FIASHouseGuid" type="{http://dom.gosuslugi.ru/schema/integration/premises-base/}FIASHouseGUIDType"/>
 *         &lt;choice>
 *           &lt;element name="Protocol">
 *             &lt;complexType>
 *               &lt;complexContent>
 *                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                   &lt;choice>
 *                     &lt;element name="VotingProtocolGUID" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType"/>
 *                     &lt;sequence>
 *                       &lt;element name="Number" type="{http://dom.gosuslugi.ru/schema/integration/capital-repair/}String50Type"/>
 *                       &lt;element name="Date" type="{http://www.w3.org/2001/XMLSchema}date"/>
 *                       &lt;element name="Attachment" type="{http://dom.gosuslugi.ru/schema/integration/base/}AttachmentType" maxOccurs="100"/>
 *                     &lt;/sequence>
 *                   &lt;/choice>
 *                 &lt;/restriction>
 *               &lt;/complexContent>
 *             &lt;/complexType>
 *           &lt;/element>
 *           &lt;element name="DecisionDocument" type="{http://dom.gosuslugi.ru/schema/integration/capital-repair/}DocumentDecisionType"/>
 *         &lt;/choice>
 *         &lt;element name="DateEffective" type="{http://www.w3.org/2001/XMLSchema}date"/>
 *         &lt;choice>
 *           &lt;element name="FormationFundInSpecialAccount">
 *             &lt;complexType>
 *               &lt;complexContent>
 *                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                   &lt;sequence>
 *                     &lt;element name="AccountCreationDate" type="{http://www.w3.org/2001/XMLSchema}date"/>
 *                     &lt;element name="CreditOrganization" type="{http://dom.gosuslugi.ru/schema/integration/organizations-registry-base/}RegOrgType"/>
 *                     &lt;element name="BIKCredOrg" type="{http://dom.gosuslugi.ru/schema/integration/organizations-base/}BIKType"/>
 *                     &lt;element name="AccountNumber" type="{http://dom.gosuslugi.ru/schema/integration/capital-repair/}AccountNumberType"/>
 *                     &lt;element name="AccountOpeningDocument" type="{http://dom.gosuslugi.ru/schema/integration/base/}AttachmentType" maxOccurs="100"/>
 *                   &lt;/sequence>
 *                 &lt;/restriction>
 *               &lt;/complexContent>
 *             &lt;/complexType>
 *           &lt;/element>
 *           &lt;element name="FormationFundInRegOperatorAccount" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;/choice>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DecisionType", propOrder = {
    "fiasHouseGuid",
    "protocol",
    "decisionDocument",
    "dateEffective",
    "formationFundInSpecialAccount",
    "formationFundInRegOperatorAccount"
})
@XmlSeeAlso({
    ExportDecisionType.class,
    ru.gosuslugi.dom.schema.integration.capital_repair.ImportDecisionsFormingFundRequest.ImportDecision.LoadDecision.class
})
public class DecisionType {

    @XmlElement(name = "FIASHouseGuid", required = true)
    protected String fiasHouseGuid;
    @XmlElement(name = "Protocol")
    protected DecisionType.Protocol protocol;
    @XmlElement(name = "DecisionDocument")
    protected DocumentDecisionType decisionDocument;
    @XmlElement(name = "DateEffective", required = true)
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar dateEffective;
    @XmlElement(name = "FormationFundInSpecialAccount")
    protected DecisionType.FormationFundInSpecialAccount formationFundInSpecialAccount;
    @XmlElement(name = "FormationFundInRegOperatorAccount")
    protected Boolean formationFundInRegOperatorAccount;

    /**
     * Gets the value of the fiasHouseGuid property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFIASHouseGuid() {
        return fiasHouseGuid;
    }

    /**
     * Sets the value of the fiasHouseGuid property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFIASHouseGuid(String value) {
        this.fiasHouseGuid = value;
    }

    /**
     * Gets the value of the protocol property.
     * 
     * @return
     *     possible object is
     *     {@link DecisionType.Protocol }
     *     
     */
    public DecisionType.Protocol getProtocol() {
        return protocol;
    }

    /**
     * Sets the value of the protocol property.
     * 
     * @param value
     *     allowed object is
     *     {@link DecisionType.Protocol }
     *     
     */
    public void setProtocol(DecisionType.Protocol value) {
        this.protocol = value;
    }

    /**
     * Gets the value of the decisionDocument property.
     * 
     * @return
     *     possible object is
     *     {@link DocumentDecisionType }
     *     
     */
    public DocumentDecisionType getDecisionDocument() {
        return decisionDocument;
    }

    /**
     * Sets the value of the decisionDocument property.
     * 
     * @param value
     *     allowed object is
     *     {@link DocumentDecisionType }
     *     
     */
    public void setDecisionDocument(DocumentDecisionType value) {
        this.decisionDocument = value;
    }

    /**
     * Gets the value of the dateEffective property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDateEffective() {
        return dateEffective;
    }

    /**
     * Sets the value of the dateEffective property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDateEffective(XMLGregorianCalendar value) {
        this.dateEffective = value;
    }

    /**
     * Gets the value of the formationFundInSpecialAccount property.
     * 
     * @return
     *     possible object is
     *     {@link DecisionType.FormationFundInSpecialAccount }
     *     
     */
    public DecisionType.FormationFundInSpecialAccount getFormationFundInSpecialAccount() {
        return formationFundInSpecialAccount;
    }

    /**
     * Sets the value of the formationFundInSpecialAccount property.
     * 
     * @param value
     *     allowed object is
     *     {@link DecisionType.FormationFundInSpecialAccount }
     *     
     */
    public void setFormationFundInSpecialAccount(DecisionType.FormationFundInSpecialAccount value) {
        this.formationFundInSpecialAccount = value;
    }

    /**
     * Gets the value of the formationFundInRegOperatorAccount property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isFormationFundInRegOperatorAccount() {
        return formationFundInRegOperatorAccount;
    }

    /**
     * Sets the value of the formationFundInRegOperatorAccount property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setFormationFundInRegOperatorAccount(Boolean value) {
        this.formationFundInRegOperatorAccount = value;
    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="AccountCreationDate" type="{http://www.w3.org/2001/XMLSchema}date"/>
     *         &lt;element name="CreditOrganization" type="{http://dom.gosuslugi.ru/schema/integration/organizations-registry-base/}RegOrgType"/>
     *         &lt;element name="BIKCredOrg" type="{http://dom.gosuslugi.ru/schema/integration/organizations-base/}BIKType"/>
     *         &lt;element name="AccountNumber" type="{http://dom.gosuslugi.ru/schema/integration/capital-repair/}AccountNumberType"/>
     *         &lt;element name="AccountOpeningDocument" type="{http://dom.gosuslugi.ru/schema/integration/base/}AttachmentType" maxOccurs="100"/>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "accountCreationDate",
        "creditOrganization",
        "bikCredOrg",
        "accountNumber",
        "accountOpeningDocument"
    })
    public static class FormationFundInSpecialAccount {

        @XmlElement(name = "AccountCreationDate", required = true)
        @XmlSchemaType(name = "date")
        protected XMLGregorianCalendar accountCreationDate;
        @XmlElement(name = "CreditOrganization", required = true)
        protected RegOrgType creditOrganization;
        @XmlElement(name = "BIKCredOrg", required = true)
        protected String bikCredOrg;
        @XmlElement(name = "AccountNumber", required = true)
        protected String accountNumber;
        @XmlElement(name = "AccountOpeningDocument", required = true)
        protected List<AttachmentType> accountOpeningDocument;

        /**
         * Gets the value of the accountCreationDate property.
         * 
         * @return
         *     possible object is
         *     {@link XMLGregorianCalendar }
         *     
         */
        public XMLGregorianCalendar getAccountCreationDate() {
            return accountCreationDate;
        }

        /**
         * Sets the value of the accountCreationDate property.
         * 
         * @param value
         *     allowed object is
         *     {@link XMLGregorianCalendar }
         *     
         */
        public void setAccountCreationDate(XMLGregorianCalendar value) {
            this.accountCreationDate = value;
        }

        /**
         * Gets the value of the creditOrganization property.
         * 
         * @return
         *     possible object is
         *     {@link RegOrgType }
         *     
         */
        public RegOrgType getCreditOrganization() {
            return creditOrganization;
        }

        /**
         * Sets the value of the creditOrganization property.
         * 
         * @param value
         *     allowed object is
         *     {@link RegOrgType }
         *     
         */
        public void setCreditOrganization(RegOrgType value) {
            this.creditOrganization = value;
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
         * Gets the value of the accountNumber property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getAccountNumber() {
            return accountNumber;
        }

        /**
         * Sets the value of the accountNumber property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setAccountNumber(String value) {
            this.accountNumber = value;
        }

        /**
         * Gets the value of the accountOpeningDocument property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the accountOpeningDocument property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getAccountOpeningDocument().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link AttachmentType }
         * 
         * 
         */
        public List<AttachmentType> getAccountOpeningDocument() {
            if (accountOpeningDocument == null) {
                accountOpeningDocument = new ArrayList<AttachmentType>();
            }
            return this.accountOpeningDocument;
        }

    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;choice>
     *         &lt;element name="VotingProtocolGUID" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType"/>
     *         &lt;sequence>
     *           &lt;element name="Number" type="{http://dom.gosuslugi.ru/schema/integration/capital-repair/}String50Type"/>
     *           &lt;element name="Date" type="{http://www.w3.org/2001/XMLSchema}date"/>
     *           &lt;element name="Attachment" type="{http://dom.gosuslugi.ru/schema/integration/base/}AttachmentType" maxOccurs="100"/>
     *         &lt;/sequence>
     *       &lt;/choice>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "votingProtocolGUID",
        "number",
        "date",
        "attachment"
    })
    public static class Protocol {

        @XmlElement(name = "VotingProtocolGUID")
        protected String votingProtocolGUID;
        @XmlElement(name = "Number")
        protected String number;
        @XmlElement(name = "Date")
        @XmlSchemaType(name = "date")
        protected XMLGregorianCalendar date;
        @XmlElement(name = "Attachment")
        protected List<AttachmentType> attachment;

        /**
         * Gets the value of the votingProtocolGUID property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getVotingProtocolGUID() {
            return votingProtocolGUID;
        }

        /**
         * Sets the value of the votingProtocolGUID property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setVotingProtocolGUID(String value) {
            this.votingProtocolGUID = value;
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
         * Gets the value of the attachment property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the attachment property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getAttachment().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link AttachmentType }
         * 
         * 
         */
        public List<AttachmentType> getAttachment() {
            if (attachment == null) {
                attachment = new ArrayList<AttachmentType>();
            }
            return this.attachment;
        }

    }

}
