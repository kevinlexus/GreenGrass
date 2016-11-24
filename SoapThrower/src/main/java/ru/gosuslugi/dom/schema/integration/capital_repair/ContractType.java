
package ru.gosuslugi.dom.schema.integration.capital_repair;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;
import ru.gosuslugi.dom.schema.integration.base.AttachmentType;
import ru.gosuslugi.dom.schema.integration.organizations_registry_base.RegOrgType;


/**
 * Договор на выполнение работ (оказание услуг) по капитальному ремонту
 * 
 * <p>Java class for ContractType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ContractType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Number" type="{http://dom.gosuslugi.ru/schema/integration/capital-repair/}String512Type"/>
 *         &lt;element name="Date" type="{http://www.w3.org/2001/XMLSchema}date"/>
 *         &lt;element name="StartDate" type="{http://www.w3.org/2001/XMLSchema}date"/>
 *         &lt;element name="EndDate" type="{http://www.w3.org/2001/XMLSchema}date"/>
 *         &lt;element name="Sum" type="{http://dom.gosuslugi.ru/schema/integration/bills-base/}MoneyPositiveType"/>
 *         &lt;element name="Customer" type="{http://dom.gosuslugi.ru/schema/integration/organizations-registry-base/}RegOrgType"/>
 *         &lt;element name="Performer" type="{http://dom.gosuslugi.ru/schema/integration/organizations-registry-base/}RegOrgType"/>
 *         &lt;element name="Work" type="{http://dom.gosuslugi.ru/schema/integration/capital-repair/}WorkContractType" maxOccurs="10000"/>
 *         &lt;element name="AttachContract" type="{http://dom.gosuslugi.ru/schema/integration/base/}AttachmentType" maxOccurs="1000"/>
 *         &lt;choice>
 *           &lt;element name="WarrantyMonthCount" type="{http://www.w3.org/2001/XMLSchema}nonNegativeInteger"/>
 *           &lt;element name="WarrantyNotSet" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;/choice>
 *         &lt;choice>
 *           &lt;element name="AttachOutlay" type="{http://dom.gosuslugi.ru/schema/integration/base/}AttachmentType" maxOccurs="1000"/>
 *           &lt;element name="OutlayMissing" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;/choice>
 *         &lt;choice>
 *           &lt;element name="TenderInetAddress" type="{http://dom.gosuslugi.ru/schema/integration/capital-repair/}String512Type"/>
 *           &lt;element name="TenderNotProvided" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;/choice>
 *         &lt;element name="Dissolve" type="{http://dom.gosuslugi.ru/schema/integration/capital-repair/}DissolveContractType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ContractType", propOrder = {
    "number",
    "date",
    "startDate",
    "endDate",
    "sum",
    "customer",
    "performer",
    "work",
    "attachContract",
    "warrantyMonthCount",
    "warrantyNotSet",
    "attachOutlay",
    "outlayMissing",
    "tenderInetAddress",
    "tenderNotProvided",
    "dissolve"
})
public class ContractType {

    @XmlElement(name = "Number", required = true)
    protected String number;
    @XmlElement(name = "Date", required = true)
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar date;
    @XmlElement(name = "StartDate", required = true)
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar startDate;
    @XmlElement(name = "EndDate", required = true)
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar endDate;
    @XmlElement(name = "Sum", required = true)
    protected BigDecimal sum;
    @XmlElement(name = "Customer", required = true)
    protected RegOrgType customer;
    @XmlElement(name = "Performer", required = true)
    protected RegOrgType performer;
    @XmlElement(name = "Work", required = true)
    protected List<WorkContractType> work;
    @XmlElement(name = "AttachContract", required = true)
    protected List<AttachmentType> attachContract;
    @XmlElement(name = "WarrantyMonthCount")
    @XmlSchemaType(name = "nonNegativeInteger")
    protected BigInteger warrantyMonthCount;
    @XmlElement(name = "WarrantyNotSet")
    protected Boolean warrantyNotSet;
    @XmlElement(name = "AttachOutlay")
    protected List<AttachmentType> attachOutlay;
    @XmlElement(name = "OutlayMissing")
    protected Boolean outlayMissing;
    @XmlElement(name = "TenderInetAddress")
    protected String tenderInetAddress;
    @XmlElement(name = "TenderNotProvided")
    protected Boolean tenderNotProvided;
    @XmlElement(name = "Dissolve")
    protected DissolveContractType dissolve;

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
     * Gets the value of the sum property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getSum() {
        return sum;
    }

    /**
     * Sets the value of the sum property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setSum(BigDecimal value) {
        this.sum = value;
    }

    /**
     * Gets the value of the customer property.
     * 
     * @return
     *     possible object is
     *     {@link RegOrgType }
     *     
     */
    public RegOrgType getCustomer() {
        return customer;
    }

    /**
     * Sets the value of the customer property.
     * 
     * @param value
     *     allowed object is
     *     {@link RegOrgType }
     *     
     */
    public void setCustomer(RegOrgType value) {
        this.customer = value;
    }

    /**
     * Gets the value of the performer property.
     * 
     * @return
     *     possible object is
     *     {@link RegOrgType }
     *     
     */
    public RegOrgType getPerformer() {
        return performer;
    }

    /**
     * Sets the value of the performer property.
     * 
     * @param value
     *     allowed object is
     *     {@link RegOrgType }
     *     
     */
    public void setPerformer(RegOrgType value) {
        this.performer = value;
    }

    /**
     * Gets the value of the work property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the work property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getWork().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link WorkContractType }
     * 
     * 
     */
    public List<WorkContractType> getWork() {
        if (work == null) {
            work = new ArrayList<WorkContractType>();
        }
        return this.work;
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

    /**
     * Gets the value of the warrantyMonthCount property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getWarrantyMonthCount() {
        return warrantyMonthCount;
    }

    /**
     * Sets the value of the warrantyMonthCount property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setWarrantyMonthCount(BigInteger value) {
        this.warrantyMonthCount = value;
    }

    /**
     * Gets the value of the warrantyNotSet property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isWarrantyNotSet() {
        return warrantyNotSet;
    }

    /**
     * Sets the value of the warrantyNotSet property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setWarrantyNotSet(Boolean value) {
        this.warrantyNotSet = value;
    }

    /**
     * Gets the value of the attachOutlay property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the attachOutlay property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAttachOutlay().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link AttachmentType }
     * 
     * 
     */
    public List<AttachmentType> getAttachOutlay() {
        if (attachOutlay == null) {
            attachOutlay = new ArrayList<AttachmentType>();
        }
        return this.attachOutlay;
    }

    /**
     * Gets the value of the outlayMissing property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isOutlayMissing() {
        return outlayMissing;
    }

    /**
     * Sets the value of the outlayMissing property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setOutlayMissing(Boolean value) {
        this.outlayMissing = value;
    }

    /**
     * Gets the value of the tenderInetAddress property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTenderInetAddress() {
        return tenderInetAddress;
    }

    /**
     * Sets the value of the tenderInetAddress property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTenderInetAddress(String value) {
        this.tenderInetAddress = value;
    }

    /**
     * Gets the value of the tenderNotProvided property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isTenderNotProvided() {
        return tenderNotProvided;
    }

    /**
     * Sets the value of the tenderNotProvided property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setTenderNotProvided(Boolean value) {
        this.tenderNotProvided = value;
    }

    /**
     * Gets the value of the dissolve property.
     * 
     * @return
     *     possible object is
     *     {@link DissolveContractType }
     *     
     */
    public DissolveContractType getDissolve() {
        return dissolve;
    }

    /**
     * Sets the value of the dissolve property.
     * 
     * @param value
     *     allowed object is
     *     {@link DissolveContractType }
     *     
     */
    public void setDissolve(DissolveContractType value) {
        this.dissolve = value;
    }

}
