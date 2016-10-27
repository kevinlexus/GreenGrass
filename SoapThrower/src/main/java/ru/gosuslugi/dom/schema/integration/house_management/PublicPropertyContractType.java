
package ru.gosuslugi.dom.schema.integration.house_management;

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
import ru.gosuslugi.dom.schema.integration.individual_registry_base.IndType;
import ru.gosuslugi.dom.schema.integration.organizations_registry_base.RegOrgType;


/**
 * <p>Java class for PublicPropertyContractType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="PublicPropertyContractType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;choice>
 *           &lt;element name="Organization" type="{http://dom.gosuslugi.ru/schema/integration/organizations-registry-base/}RegOrgType"/>
 *           &lt;element name="Entrepreneur" type="{http://dom.gosuslugi.ru/schema/integration/individual-registry-base/}IndType"/>
 *         &lt;/choice>
 *         &lt;element name="FIASHouseGuid" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType"/>
 *         &lt;element name="ContractNumber" type="{http://dom.gosuslugi.ru/schema/integration/house-management/}ContractNumberType"/>
 *         &lt;element name="Date" type="{http://www.w3.org/2001/XMLSchema}date"/>
 *         &lt;element name="StartDate" type="{http://www.w3.org/2001/XMLSchema}date"/>
 *         &lt;element name="EndDate" type="{http://www.w3.org/2001/XMLSchema}date"/>
 *         &lt;element name="ContractObject" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://dom.gosuslugi.ru/schema/integration/base/}LongTextType">
 *               &lt;maxLength value="255"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="Comments" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://dom.gosuslugi.ru/schema/integration/base/}LongTextType">
 *               &lt;maxLength value="255"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="Payment" type="{http://dom.gosuslugi.ru/schema/integration/bills-base/}SmallMoneyPositiveType" minOccurs="0"/>
 *         &lt;element name="MoneySpentDirection" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://dom.gosuslugi.ru/schema/integration/base/}LongTextType">
 *               &lt;maxLength value="255"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="ContractAttachment" type="{http://dom.gosuslugi.ru/schema/integration/base/}AttachmentType" maxOccurs="unbounded"/>
 *         &lt;element name="RentAgrConfirmationDocument" maxOccurs="unbounded">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;choice>
 *                   &lt;element name="ProtocolMeetingOwners" maxOccurs="unbounded">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="ProtocolNum">
 *                               &lt;simpleType>
 *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                                   &lt;maxLength value="30"/>
 *                                 &lt;/restriction>
 *                               &lt;/simpleType>
 *                             &lt;/element>
 *                             &lt;element name="ProtocolDate" type="{http://www.w3.org/2001/XMLSchema}date"/>
 *                             &lt;element name="TrustDocAttachment" type="{http://dom.gosuslugi.ru/schema/integration/base/}AttachmentType" maxOccurs="unbounded"/>
 *                           &lt;/sequence>
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                   &lt;element name="ProtocolGUID" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType" maxOccurs="unbounded"/>
 *                 &lt;/choice>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="AgreementPayment" maxOccurs="unbounded" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;choice>
 *                   &lt;element name="AddAgreementPayment">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="AgreementPaymentVersionGUID" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType" minOccurs="0"/>
 *                             &lt;element name="DatePeriod">
 *                               &lt;complexType>
 *                                 &lt;complexContent>
 *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                     &lt;sequence>
 *                                       &lt;element name="DateFrom" type="{http://www.w3.org/2001/XMLSchema}date"/>
 *                                       &lt;element name="DateTo" type="{http://www.w3.org/2001/XMLSchema}date"/>
 *                                     &lt;/sequence>
 *                                   &lt;/restriction>
 *                                 &lt;/complexContent>
 *                               &lt;/complexType>
 *                             &lt;/element>
 *                             &lt;element name="Bill" type="{http://dom.gosuslugi.ru/schema/integration/bills-base/}SmallMoneyPositiveType"/>
 *                             &lt;element name="Debt" type="{http://dom.gosuslugi.ru/schema/integration/bills-base/}SmallMoneyType"/>
 *                             &lt;element name="Paid" type="{http://dom.gosuslugi.ru/schema/integration/bills-base/}SmallMoneyPositiveType"/>
 *                           &lt;/sequence>
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                   &lt;element name="AnnulAgreementPayment">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/house-management/}AnnulmentType">
 *                           &lt;sequence>
 *                             &lt;element name="AgreementPaymentVersionGUID" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType"/>
 *                           &lt;/sequence>
 *                         &lt;/extension>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                 &lt;/choice>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PublicPropertyContractType", propOrder = {
    "organization",
    "entrepreneur",
    "fiasHouseGuid",
    "contractNumber",
    "date",
    "startDate",
    "endDate",
    "contractObject",
    "comments",
    "payment",
    "moneySpentDirection",
    "contractAttachment",
    "rentAgrConfirmationDocument",
    "agreementPayment"
})
@XmlSeeAlso({
    ru.gosuslugi.dom.schema.integration.house_management.ExportStatusPublicPropertyContractResultType.PublicPropertyContract.class,
    ru.gosuslugi.dom.schema.integration.house_management.ImportPublicPropertyContractRequest.Contract.PublicPropertyContract.class
})
public class PublicPropertyContractType {

    @XmlElement(name = "Organization")
    protected RegOrgType organization;
    @XmlElement(name = "Entrepreneur")
    protected IndType entrepreneur;
    @XmlElement(name = "FIASHouseGuid", required = true)
    protected String fiasHouseGuid;
    @XmlElement(name = "ContractNumber", required = true)
    protected String contractNumber;
    @XmlElement(name = "Date", required = true)
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar date;
    @XmlElement(name = "StartDate", required = true)
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar startDate;
    @XmlElement(name = "EndDate", required = true)
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar endDate;
    @XmlElement(name = "ContractObject")
    protected String contractObject;
    @XmlElement(name = "Comments")
    protected String comments;
    @XmlElement(name = "Payment")
    protected BigDecimal payment;
    @XmlElement(name = "MoneySpentDirection")
    protected String moneySpentDirection;
    @XmlElement(name = "ContractAttachment", required = true)
    protected List<AttachmentType> contractAttachment;
    @XmlElement(name = "RentAgrConfirmationDocument", required = true)
    protected List<PublicPropertyContractType.RentAgrConfirmationDocument> rentAgrConfirmationDocument;
    @XmlElement(name = "AgreementPayment")
    protected List<PublicPropertyContractType.AgreementPayment> agreementPayment;

    /**
     * Gets the value of the organization property.
     * 
     * @return
     *     possible object is
     *     {@link RegOrgType }
     *     
     */
    public RegOrgType getOrganization() {
        return organization;
    }

    /**
     * Sets the value of the organization property.
     * 
     * @param value
     *     allowed object is
     *     {@link RegOrgType }
     *     
     */
    public void setOrganization(RegOrgType value) {
        this.organization = value;
    }

    /**
     * Gets the value of the entrepreneur property.
     * 
     * @return
     *     possible object is
     *     {@link IndType }
     *     
     */
    public IndType getEntrepreneur() {
        return entrepreneur;
    }

    /**
     * Sets the value of the entrepreneur property.
     * 
     * @param value
     *     allowed object is
     *     {@link IndType }
     *     
     */
    public void setEntrepreneur(IndType value) {
        this.entrepreneur = value;
    }

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
     * Gets the value of the contractNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getContractNumber() {
        return contractNumber;
    }

    /**
     * Sets the value of the contractNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setContractNumber(String value) {
        this.contractNumber = value;
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
     * Gets the value of the startDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getStartDate() {
        return startDate;
    }

    /**
     * Sets the value of the startDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setStartDate(XMLGregorianCalendar value) {
        this.startDate = value;
    }

    /**
     * Gets the value of the endDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getEndDate() {
        return endDate;
    }

    /**
     * Sets the value of the endDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setEndDate(XMLGregorianCalendar value) {
        this.endDate = value;
    }

    /**
     * Gets the value of the contractObject property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getContractObject() {
        return contractObject;
    }

    /**
     * Sets the value of the contractObject property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setContractObject(String value) {
        this.contractObject = value;
    }

    /**
     * Gets the value of the comments property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getComments() {
        return comments;
    }

    /**
     * Sets the value of the comments property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setComments(String value) {
        this.comments = value;
    }

    /**
     * Gets the value of the payment property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getPayment() {
        return payment;
    }

    /**
     * Sets the value of the payment property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setPayment(BigDecimal value) {
        this.payment = value;
    }

    /**
     * Gets the value of the moneySpentDirection property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMoneySpentDirection() {
        return moneySpentDirection;
    }

    /**
     * Sets the value of the moneySpentDirection property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMoneySpentDirection(String value) {
        this.moneySpentDirection = value;
    }

    /**
     * Gets the value of the contractAttachment property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the contractAttachment property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getContractAttachment().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link AttachmentType }
     * 
     * 
     */
    public List<AttachmentType> getContractAttachment() {
        if (contractAttachment == null) {
            contractAttachment = new ArrayList<AttachmentType>();
        }
        return this.contractAttachment;
    }

    /**
     * Gets the value of the rentAgrConfirmationDocument property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the rentAgrConfirmationDocument property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getRentAgrConfirmationDocument().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link PublicPropertyContractType.RentAgrConfirmationDocument }
     * 
     * 
     */
    public List<PublicPropertyContractType.RentAgrConfirmationDocument> getRentAgrConfirmationDocument() {
        if (rentAgrConfirmationDocument == null) {
            rentAgrConfirmationDocument = new ArrayList<PublicPropertyContractType.RentAgrConfirmationDocument>();
        }
        return this.rentAgrConfirmationDocument;
    }

    /**
     * Gets the value of the agreementPayment property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the agreementPayment property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAgreementPayment().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link PublicPropertyContractType.AgreementPayment }
     * 
     * 
     */
    public List<PublicPropertyContractType.AgreementPayment> getAgreementPayment() {
        if (agreementPayment == null) {
            agreementPayment = new ArrayList<PublicPropertyContractType.AgreementPayment>();
        }
        return this.agreementPayment;
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
     *         &lt;element name="AddAgreementPayment">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element name="AgreementPaymentVersionGUID" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType" minOccurs="0"/>
     *                   &lt;element name="DatePeriod">
     *                     &lt;complexType>
     *                       &lt;complexContent>
     *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                           &lt;sequence>
     *                             &lt;element name="DateFrom" type="{http://www.w3.org/2001/XMLSchema}date"/>
     *                             &lt;element name="DateTo" type="{http://www.w3.org/2001/XMLSchema}date"/>
     *                           &lt;/sequence>
     *                         &lt;/restriction>
     *                       &lt;/complexContent>
     *                     &lt;/complexType>
     *                   &lt;/element>
     *                   &lt;element name="Bill" type="{http://dom.gosuslugi.ru/schema/integration/bills-base/}SmallMoneyPositiveType"/>
     *                   &lt;element name="Debt" type="{http://dom.gosuslugi.ru/schema/integration/bills-base/}SmallMoneyType"/>
     *                   &lt;element name="Paid" type="{http://dom.gosuslugi.ru/schema/integration/bills-base/}SmallMoneyPositiveType"/>
     *                 &lt;/sequence>
     *               &lt;/restriction>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *         &lt;element name="AnnulAgreementPayment">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/house-management/}AnnulmentType">
     *                 &lt;sequence>
     *                   &lt;element name="AgreementPaymentVersionGUID" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType"/>
     *                 &lt;/sequence>
     *               &lt;/extension>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
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
        "addAgreementPayment",
        "annulAgreementPayment"
    })
    public static class AgreementPayment {

        @XmlElement(name = "AddAgreementPayment")
        protected PublicPropertyContractType.AgreementPayment.AddAgreementPayment addAgreementPayment;
        @XmlElement(name = "AnnulAgreementPayment")
        protected PublicPropertyContractType.AgreementPayment.AnnulAgreementPayment annulAgreementPayment;

        /**
         * Gets the value of the addAgreementPayment property.
         * 
         * @return
         *     possible object is
         *     {@link PublicPropertyContractType.AgreementPayment.AddAgreementPayment }
         *     
         */
        public PublicPropertyContractType.AgreementPayment.AddAgreementPayment getAddAgreementPayment() {
            return addAgreementPayment;
        }

        /**
         * Sets the value of the addAgreementPayment property.
         * 
         * @param value
         *     allowed object is
         *     {@link PublicPropertyContractType.AgreementPayment.AddAgreementPayment }
         *     
         */
        public void setAddAgreementPayment(PublicPropertyContractType.AgreementPayment.AddAgreementPayment value) {
            this.addAgreementPayment = value;
        }

        /**
         * Gets the value of the annulAgreementPayment property.
         * 
         * @return
         *     possible object is
         *     {@link PublicPropertyContractType.AgreementPayment.AnnulAgreementPayment }
         *     
         */
        public PublicPropertyContractType.AgreementPayment.AnnulAgreementPayment getAnnulAgreementPayment() {
            return annulAgreementPayment;
        }

        /**
         * Sets the value of the annulAgreementPayment property.
         * 
         * @param value
         *     allowed object is
         *     {@link PublicPropertyContractType.AgreementPayment.AnnulAgreementPayment }
         *     
         */
        public void setAnnulAgreementPayment(PublicPropertyContractType.AgreementPayment.AnnulAgreementPayment value) {
            this.annulAgreementPayment = value;
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
         *         &lt;element name="AgreementPaymentVersionGUID" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType" minOccurs="0"/>
         *         &lt;element name="DatePeriod">
         *           &lt;complexType>
         *             &lt;complexContent>
         *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *                 &lt;sequence>
         *                   &lt;element name="DateFrom" type="{http://www.w3.org/2001/XMLSchema}date"/>
         *                   &lt;element name="DateTo" type="{http://www.w3.org/2001/XMLSchema}date"/>
         *                 &lt;/sequence>
         *               &lt;/restriction>
         *             &lt;/complexContent>
         *           &lt;/complexType>
         *         &lt;/element>
         *         &lt;element name="Bill" type="{http://dom.gosuslugi.ru/schema/integration/bills-base/}SmallMoneyPositiveType"/>
         *         &lt;element name="Debt" type="{http://dom.gosuslugi.ru/schema/integration/bills-base/}SmallMoneyType"/>
         *         &lt;element name="Paid" type="{http://dom.gosuslugi.ru/schema/integration/bills-base/}SmallMoneyPositiveType"/>
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
            "agreementPaymentVersionGUID",
            "datePeriod",
            "bill",
            "debt",
            "paid"
        })
        public static class AddAgreementPayment {

            @XmlElement(name = "AgreementPaymentVersionGUID")
            protected String agreementPaymentVersionGUID;
            @XmlElement(name = "DatePeriod", required = true)
            protected PublicPropertyContractType.AgreementPayment.AddAgreementPayment.DatePeriod datePeriod;
            @XmlElement(name = "Bill", required = true)
            protected BigDecimal bill;
            @XmlElement(name = "Debt", required = true)
            protected BigDecimal debt;
            @XmlElement(name = "Paid", required = true)
            protected BigDecimal paid;

            /**
             * Gets the value of the agreementPaymentVersionGUID property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getAgreementPaymentVersionGUID() {
                return agreementPaymentVersionGUID;
            }

            /**
             * Sets the value of the agreementPaymentVersionGUID property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setAgreementPaymentVersionGUID(String value) {
                this.agreementPaymentVersionGUID = value;
            }

            /**
             * Gets the value of the datePeriod property.
             * 
             * @return
             *     possible object is
             *     {@link PublicPropertyContractType.AgreementPayment.AddAgreementPayment.DatePeriod }
             *     
             */
            public PublicPropertyContractType.AgreementPayment.AddAgreementPayment.DatePeriod getDatePeriod() {
                return datePeriod;
            }

            /**
             * Sets the value of the datePeriod property.
             * 
             * @param value
             *     allowed object is
             *     {@link PublicPropertyContractType.AgreementPayment.AddAgreementPayment.DatePeriod }
             *     
             */
            public void setDatePeriod(PublicPropertyContractType.AgreementPayment.AddAgreementPayment.DatePeriod value) {
                this.datePeriod = value;
            }

            /**
             * Gets the value of the bill property.
             * 
             * @return
             *     possible object is
             *     {@link BigDecimal }
             *     
             */
            public BigDecimal getBill() {
                return bill;
            }

            /**
             * Sets the value of the bill property.
             * 
             * @param value
             *     allowed object is
             *     {@link BigDecimal }
             *     
             */
            public void setBill(BigDecimal value) {
                this.bill = value;
            }

            /**
             * Gets the value of the debt property.
             * 
             * @return
             *     possible object is
             *     {@link BigDecimal }
             *     
             */
            public BigDecimal getDebt() {
                return debt;
            }

            /**
             * Sets the value of the debt property.
             * 
             * @param value
             *     allowed object is
             *     {@link BigDecimal }
             *     
             */
            public void setDebt(BigDecimal value) {
                this.debt = value;
            }

            /**
             * Gets the value of the paid property.
             * 
             * @return
             *     possible object is
             *     {@link BigDecimal }
             *     
             */
            public BigDecimal getPaid() {
                return paid;
            }

            /**
             * Sets the value of the paid property.
             * 
             * @param value
             *     allowed object is
             *     {@link BigDecimal }
             *     
             */
            public void setPaid(BigDecimal value) {
                this.paid = value;
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
             *         &lt;element name="DateFrom" type="{http://www.w3.org/2001/XMLSchema}date"/>
             *         &lt;element name="DateTo" type="{http://www.w3.org/2001/XMLSchema}date"/>
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
                "dateFrom",
                "dateTo"
            })
            public static class DatePeriod {

                @XmlElement(name = "DateFrom", required = true)
                @XmlSchemaType(name = "date")
                protected XMLGregorianCalendar dateFrom;
                @XmlElement(name = "DateTo", required = true)
                @XmlSchemaType(name = "date")
                protected XMLGregorianCalendar dateTo;

                /**
                 * Gets the value of the dateFrom property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link XMLGregorianCalendar }
                 *     
                 */
                public XMLGregorianCalendar getDateFrom() {
                    return dateFrom;
                }

                /**
                 * Sets the value of the dateFrom property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link XMLGregorianCalendar }
                 *     
                 */
                public void setDateFrom(XMLGregorianCalendar value) {
                    this.dateFrom = value;
                }

                /**
                 * Gets the value of the dateTo property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link XMLGregorianCalendar }
                 *     
                 */
                public XMLGregorianCalendar getDateTo() {
                    return dateTo;
                }

                /**
                 * Sets the value of the dateTo property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link XMLGregorianCalendar }
                 *     
                 */
                public void setDateTo(XMLGregorianCalendar value) {
                    this.dateTo = value;
                }

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
         *     &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/house-management/}AnnulmentType">
         *       &lt;sequence>
         *         &lt;element name="AgreementPaymentVersionGUID" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType"/>
         *       &lt;/sequence>
         *     &lt;/extension>
         *   &lt;/complexContent>
         * &lt;/complexType>
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
            "agreementPaymentVersionGUID"
        })
        public static class AnnulAgreementPayment
            extends AnnulmentType
        {

            @XmlElement(name = "AgreementPaymentVersionGUID", required = true)
            protected String agreementPaymentVersionGUID;

            /**
             * Gets the value of the agreementPaymentVersionGUID property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getAgreementPaymentVersionGUID() {
                return agreementPaymentVersionGUID;
            }

            /**
             * Sets the value of the agreementPaymentVersionGUID property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setAgreementPaymentVersionGUID(String value) {
                this.agreementPaymentVersionGUID = value;
            }

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
     *         &lt;element name="ProtocolMeetingOwners" maxOccurs="unbounded">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element name="ProtocolNum">
     *                     &lt;simpleType>
     *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *                         &lt;maxLength value="30"/>
     *                       &lt;/restriction>
     *                     &lt;/simpleType>
     *                   &lt;/element>
     *                   &lt;element name="ProtocolDate" type="{http://www.w3.org/2001/XMLSchema}date"/>
     *                   &lt;element name="TrustDocAttachment" type="{http://dom.gosuslugi.ru/schema/integration/base/}AttachmentType" maxOccurs="unbounded"/>
     *                 &lt;/sequence>
     *               &lt;/restriction>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *         &lt;element name="ProtocolGUID" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType" maxOccurs="unbounded"/>
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
        "protocolMeetingOwners",
        "protocolGUID"
    })
    public static class RentAgrConfirmationDocument {

        @XmlElement(name = "ProtocolMeetingOwners")
        protected List<PublicPropertyContractType.RentAgrConfirmationDocument.ProtocolMeetingOwners> protocolMeetingOwners;
        @XmlElement(name = "ProtocolGUID")
        protected List<String> protocolGUID;

        /**
         * Gets the value of the protocolMeetingOwners property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the protocolMeetingOwners property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getProtocolMeetingOwners().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link PublicPropertyContractType.RentAgrConfirmationDocument.ProtocolMeetingOwners }
         * 
         * 
         */
        public List<PublicPropertyContractType.RentAgrConfirmationDocument.ProtocolMeetingOwners> getProtocolMeetingOwners() {
            if (protocolMeetingOwners == null) {
                protocolMeetingOwners = new ArrayList<PublicPropertyContractType.RentAgrConfirmationDocument.ProtocolMeetingOwners>();
            }
            return this.protocolMeetingOwners;
        }

        /**
         * Gets the value of the protocolGUID property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the protocolGUID property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getProtocolGUID().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link String }
         * 
         * 
         */
        public List<String> getProtocolGUID() {
            if (protocolGUID == null) {
                protocolGUID = new ArrayList<String>();
            }
            return this.protocolGUID;
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
         *         &lt;element name="ProtocolNum">
         *           &lt;simpleType>
         *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
         *               &lt;maxLength value="30"/>
         *             &lt;/restriction>
         *           &lt;/simpleType>
         *         &lt;/element>
         *         &lt;element name="ProtocolDate" type="{http://www.w3.org/2001/XMLSchema}date"/>
         *         &lt;element name="TrustDocAttachment" type="{http://dom.gosuslugi.ru/schema/integration/base/}AttachmentType" maxOccurs="unbounded"/>
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
            "protocolNum",
            "protocolDate",
            "trustDocAttachment"
        })
        public static class ProtocolMeetingOwners {

            @XmlElement(name = "ProtocolNum", required = true)
            protected String protocolNum;
            @XmlElement(name = "ProtocolDate", required = true)
            @XmlSchemaType(name = "date")
            protected XMLGregorianCalendar protocolDate;
            @XmlElement(name = "TrustDocAttachment", required = true)
            protected List<AttachmentType> trustDocAttachment;

            /**
             * Gets the value of the protocolNum property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getProtocolNum() {
                return protocolNum;
            }

            /**
             * Sets the value of the protocolNum property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setProtocolNum(String value) {
                this.protocolNum = value;
            }

            /**
             * Gets the value of the protocolDate property.
             * 
             * @return
             *     possible object is
             *     {@link XMLGregorianCalendar }
             *     
             */
            public XMLGregorianCalendar getProtocolDate() {
                return protocolDate;
            }

            /**
             * Sets the value of the protocolDate property.
             * 
             * @param value
             *     allowed object is
             *     {@link XMLGregorianCalendar }
             *     
             */
            public void setProtocolDate(XMLGregorianCalendar value) {
                this.protocolDate = value;
            }

            /**
             * Gets the value of the trustDocAttachment property.
             * 
             * <p>
             * This accessor method returns a reference to the live list,
             * not a snapshot. Therefore any modification you make to the
             * returned list will be present inside the JAXB object.
             * This is why there is not a <CODE>set</CODE> method for the trustDocAttachment property.
             * 
             * <p>
             * For example, to add a new item, do as follows:
             * <pre>
             *    getTrustDocAttachment().add(newItem);
             * </pre>
             * 
             * 
             * <p>
             * Objects of the following type(s) are allowed in the list
             * {@link AttachmentType }
             * 
             * 
             */
            public List<AttachmentType> getTrustDocAttachment() {
                if (trustDocAttachment == null) {
                    trustDocAttachment = new ArrayList<AttachmentType>();
                }
                return this.trustDocAttachment;
            }

        }

    }

}
