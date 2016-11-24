
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
import ru.gosuslugi.dom.schema.integration.nsi_base.NsiRef;


/**
 *  Экспортируемые счета регионального оператора/специальные счета
 * 
 * <p>Java class for ExportAccountType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ExportAccountType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="AccountGuid" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType"/>
 *         &lt;element name="AccountKind" type="{http://dom.gosuslugi.ru/schema/integration/nsi-base/}nsiRef"/>
 *         &lt;element name="OpenDate" type="{http://www.w3.org/2001/XMLSchema}date"/>
 *         &lt;element name="Details" maxOccurs="100">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/capital-repair/}AccountType">
 *                 &lt;sequence>
 *                   &lt;element name="ChangeDate" type="{http://www.w3.org/2001/XMLSchema}date"/>
 *                   &lt;element name="Current" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *                 &lt;/sequence>
 *               &lt;/extension>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="FIASHouseGuid" type="{http://dom.gosuslugi.ru/schema/integration/premises-base/}FIASHouseGUIDType" minOccurs="0"/>
 *         &lt;element name="DocForAccountOpening" type="{http://dom.gosuslugi.ru/schema/integration/base/}AttachmentType" maxOccurs="100" minOccurs="0"/>
 *         &lt;element name="CloseDate" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
 *         &lt;element name="Status">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;enumeration value="Published"/>
 *               &lt;enumeration value="Canceled"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;choice minOccurs="0">
 *           &lt;element name="OperationAndBalance" type="{http://dom.gosuslugi.ru/schema/integration/capital-repair/}ExportOperationAndBalanceType" maxOccurs="unbounded"/>
 *           &lt;element name="OperationAndBalanceIsAbsent" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
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
@XmlType(name = "ExportAccountType", propOrder = {
    "accountGuid",
    "accountKind",
    "openDate",
    "details",
    "fiasHouseGuid",
    "docForAccountOpening",
    "closeDate",
    "status",
    "operationAndBalance",
    "operationAndBalanceIsAbsent"
})
@XmlSeeAlso({
    ru.gosuslugi.dom.schema.integration.capital_repair.ExportAccountResult.Account.class
})
public class ExportAccountType {

    @XmlElement(name = "AccountGuid", required = true)
    protected String accountGuid;
    @XmlElement(name = "AccountKind", required = true)
    protected NsiRef accountKind;
    @XmlElement(name = "OpenDate", required = true)
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar openDate;
    @XmlElement(name = "Details", required = true)
    protected List<ExportAccountType.Details> details;
    @XmlElement(name = "FIASHouseGuid")
    protected String fiasHouseGuid;
    @XmlElement(name = "DocForAccountOpening")
    protected List<AttachmentType> docForAccountOpening;
    @XmlElement(name = "CloseDate")
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar closeDate;
    @XmlElement(name = "Status", required = true)
    protected String status;
    @XmlElement(name = "OperationAndBalance")
    protected List<ExportOperationAndBalanceType> operationAndBalance;
    @XmlElement(name = "OperationAndBalanceIsAbsent")
    protected Boolean operationAndBalanceIsAbsent;

    /**
     * Gets the value of the accountGuid property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAccountGuid() {
        return accountGuid;
    }

    /**
     * Sets the value of the accountGuid property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAccountGuid(String value) {
        this.accountGuid = value;
    }

    /**
     * Gets the value of the accountKind property.
     * 
     * @return
     *     possible object is
     *     {@link NsiRef }
     *     
     */
    public NsiRef getAccountKind() {
        return accountKind;
    }

    /**
     * Sets the value of the accountKind property.
     * 
     * @param value
     *     allowed object is
     *     {@link NsiRef }
     *     
     */
    public void setAccountKind(NsiRef value) {
        this.accountKind = value;
    }

    /**
     * Gets the value of the openDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getOpenDate() {
        return openDate;
    }

    /**
     * Sets the value of the openDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setOpenDate(XMLGregorianCalendar value) {
        this.openDate = value;
    }

    /**
     * Gets the value of the details property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the details property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDetails().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ExportAccountType.Details }
     * 
     * 
     */
    public List<ExportAccountType.Details> getDetails() {
        if (details == null) {
            details = new ArrayList<ExportAccountType.Details>();
        }
        return this.details;
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
     * Gets the value of the docForAccountOpening property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the docForAccountOpening property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDocForAccountOpening().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link AttachmentType }
     * 
     * 
     */
    public List<AttachmentType> getDocForAccountOpening() {
        if (docForAccountOpening == null) {
            docForAccountOpening = new ArrayList<AttachmentType>();
        }
        return this.docForAccountOpening;
    }

    /**
     * Gets the value of the closeDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getCloseDate() {
        return closeDate;
    }

    /**
     * Sets the value of the closeDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setCloseDate(XMLGregorianCalendar value) {
        this.closeDate = value;
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
     * Gets the value of the operationAndBalance property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the operationAndBalance property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getOperationAndBalance().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ExportOperationAndBalanceType }
     * 
     * 
     */
    public List<ExportOperationAndBalanceType> getOperationAndBalance() {
        if (operationAndBalance == null) {
            operationAndBalance = new ArrayList<ExportOperationAndBalanceType>();
        }
        return this.operationAndBalance;
    }

    /**
     * Gets the value of the operationAndBalanceIsAbsent property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isOperationAndBalanceIsAbsent() {
        return operationAndBalanceIsAbsent;
    }

    /**
     * Sets the value of the operationAndBalanceIsAbsent property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setOperationAndBalanceIsAbsent(Boolean value) {
        this.operationAndBalanceIsAbsent = value;
    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/capital-repair/}AccountType">
     *       &lt;sequence>
     *         &lt;element name="ChangeDate" type="{http://www.w3.org/2001/XMLSchema}date"/>
     *         &lt;element name="Current" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
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
        "changeDate",
        "current"
    })
    public static class Details
        extends AccountType
    {

        @XmlElement(name = "ChangeDate", required = true)
        @XmlSchemaType(name = "date")
        protected XMLGregorianCalendar changeDate;
        @XmlElement(name = "Current")
        protected boolean current;

        /**
         * Gets the value of the changeDate property.
         * 
         * @return
         *     possible object is
         *     {@link XMLGregorianCalendar }
         *     
         */
        public XMLGregorianCalendar getChangeDate() {
            return changeDate;
        }

        /**
         * Sets the value of the changeDate property.
         * 
         * @param value
         *     allowed object is
         *     {@link XMLGregorianCalendar }
         *     
         */
        public void setChangeDate(XMLGregorianCalendar value) {
            this.changeDate = value;
        }

        /**
         * Gets the value of the current property.
         * 
         */
        public boolean isCurrent() {
            return current;
        }

        /**
         * Sets the value of the current property.
         * 
         */
        public void setCurrent(boolean value) {
            this.current = value;
        }

    }

}
