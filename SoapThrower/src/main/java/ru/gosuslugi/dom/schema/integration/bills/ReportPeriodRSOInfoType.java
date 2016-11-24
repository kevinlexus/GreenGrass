
package ru.gosuslugi.dom.schema.integration.bills;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import ru.gosuslugi.dom.schema.integration.base.AttachmentType;


/**
 * Данные отчетного периода (РСО)
 * 
 * <p>Java class for ReportPeriodRSOInfoType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ReportPeriodRSOInfoType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Credted" type="{http://dom.gosuslugi.ru/schema/integration/bills-base/}MoneyType"/>
 *         &lt;element name="Receipt" type="{http://dom.gosuslugi.ru/schema/integration/bills-base/}MoneyType"/>
 *         &lt;element name="Debts" type="{http://dom.gosuslugi.ru/schema/integration/bills-base/}MoneyType"/>
 *         &lt;element name="Overpayment" type="{http://dom.gosuslugi.ru/schema/integration/bills-base/}MoneyType"/>
 *         &lt;element name="SupportingDocuments" type="{http://dom.gosuslugi.ru/schema/integration/base/}AttachmentType" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ReportPeriodRSOInfoType", propOrder = {
    "credted",
    "receipt",
    "debts",
    "overpayment",
    "supportingDocuments"
})
public class ReportPeriodRSOInfoType {

    @XmlElement(name = "Credted", required = true)
    protected BigDecimal credted;
    @XmlElement(name = "Receipt", required = true)
    protected BigDecimal receipt;
    @XmlElement(name = "Debts", required = true)
    protected BigDecimal debts;
    @XmlElement(name = "Overpayment", required = true)
    protected BigDecimal overpayment;
    @XmlElement(name = "SupportingDocuments")
    protected List<AttachmentType> supportingDocuments;

    /**
     * Gets the value of the credted property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getCredted() {
        return credted;
    }

    /**
     * Sets the value of the credted property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setCredted(BigDecimal value) {
        this.credted = value;
    }

    /**
     * Gets the value of the receipt property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getReceipt() {
        return receipt;
    }

    /**
     * Sets the value of the receipt property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setReceipt(BigDecimal value) {
        this.receipt = value;
    }

    /**
     * Gets the value of the debts property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getDebts() {
        return debts;
    }

    /**
     * Sets the value of the debts property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setDebts(BigDecimal value) {
        this.debts = value;
    }

    /**
     * Gets the value of the overpayment property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getOverpayment() {
        return overpayment;
    }

    /**
     * Sets the value of the overpayment property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setOverpayment(BigDecimal value) {
        this.overpayment = value;
    }

    /**
     * Gets the value of the supportingDocuments property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the supportingDocuments property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSupportingDocuments().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link AttachmentType }
     * 
     * 
     */
    public List<AttachmentType> getSupportingDocuments() {
        if (supportingDocuments == null) {
            supportingDocuments = new ArrayList<AttachmentType>();
        }
        return this.supportingDocuments;
    }

}
