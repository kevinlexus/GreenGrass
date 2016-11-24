
package ru.gosuslugi.dom.schema.integration.capital_repair;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * Экспортируемый набор сведений об оплате по договору
 * 
 * <p>Java class for exportPaymentInfoType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="exportPaymentInfoType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/capital-repair/}ShortPaymentInfoType">
 *       &lt;sequence>
 *         &lt;element name="WorkInPayment" maxOccurs="1000" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="WorkInContract" type="{http://dom.gosuslugi.ru/schema/integration/capital-repair/}WorkContractIdentityType"/>
 *                   &lt;element name="ExpenseofOwners" type="{http://dom.gosuslugi.ru/schema/integration/bills-base/}MoneyPositiveType" minOccurs="0"/>
 *                   &lt;element name="MeansofSupport" type="{http://dom.gosuslugi.ru/schema/integration/bills-base/}MoneyPositiveType" minOccurs="0"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="Status" type="{http://dom.gosuslugi.ru/schema/integration/capital-repair/}StatusType"/>
 *         &lt;element name="DistrByWork" type="{http://dom.gosuslugi.ru/schema/integration/bills-base/}MoneyPositiveType"/>
 *         &lt;element name="PaymentInfoGuid" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "exportPaymentInfoType", propOrder = {
    "workInPayment",
    "status",
    "distrByWork",
    "paymentInfoGuid"
})
public class ExportPaymentInfoType
    extends ShortPaymentInfoType
{

    @XmlElement(name = "WorkInPayment")
    protected List<ExportPaymentInfoType.WorkInPayment> workInPayment;
    @XmlElement(name = "Status", required = true)
    @XmlSchemaType(name = "token")
    protected StatusType status;
    @XmlElement(name = "DistrByWork", required = true)
    protected BigDecimal distrByWork;
    @XmlElement(name = "PaymentInfoGuid", required = true)
    protected String paymentInfoGuid;

    /**
     * Gets the value of the workInPayment property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the workInPayment property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getWorkInPayment().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ExportPaymentInfoType.WorkInPayment }
     * 
     * 
     */
    public List<ExportPaymentInfoType.WorkInPayment> getWorkInPayment() {
        if (workInPayment == null) {
            workInPayment = new ArrayList<ExportPaymentInfoType.WorkInPayment>();
        }
        return this.workInPayment;
    }

    /**
     * Gets the value of the status property.
     * 
     * @return
     *     possible object is
     *     {@link StatusType }
     *     
     */
    public StatusType getStatus() {
        return status;
    }

    /**
     * Sets the value of the status property.
     * 
     * @param value
     *     allowed object is
     *     {@link StatusType }
     *     
     */
    public void setStatus(StatusType value) {
        this.status = value;
    }

    /**
     * Gets the value of the distrByWork property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getDistrByWork() {
        return distrByWork;
    }

    /**
     * Sets the value of the distrByWork property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setDistrByWork(BigDecimal value) {
        this.distrByWork = value;
    }

    /**
     * Gets the value of the paymentInfoGuid property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPaymentInfoGuid() {
        return paymentInfoGuid;
    }

    /**
     * Sets the value of the paymentInfoGuid property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPaymentInfoGuid(String value) {
        this.paymentInfoGuid = value;
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
     *         &lt;element name="WorkInContract" type="{http://dom.gosuslugi.ru/schema/integration/capital-repair/}WorkContractIdentityType"/>
     *         &lt;element name="ExpenseofOwners" type="{http://dom.gosuslugi.ru/schema/integration/bills-base/}MoneyPositiveType" minOccurs="0"/>
     *         &lt;element name="MeansofSupport" type="{http://dom.gosuslugi.ru/schema/integration/bills-base/}MoneyPositiveType" minOccurs="0"/>
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
        "workInContract",
        "expenseofOwners",
        "meansofSupport"
    })
    public static class WorkInPayment {

        @XmlElement(name = "WorkInContract", required = true)
        protected WorkContractIdentityType workInContract;
        @XmlElement(name = "ExpenseofOwners")
        protected BigDecimal expenseofOwners;
        @XmlElement(name = "MeansofSupport")
        protected BigDecimal meansofSupport;

        /**
         * Gets the value of the workInContract property.
         * 
         * @return
         *     possible object is
         *     {@link WorkContractIdentityType }
         *     
         */
        public WorkContractIdentityType getWorkInContract() {
            return workInContract;
        }

        /**
         * Sets the value of the workInContract property.
         * 
         * @param value
         *     allowed object is
         *     {@link WorkContractIdentityType }
         *     
         */
        public void setWorkInContract(WorkContractIdentityType value) {
            this.workInContract = value;
        }

        /**
         * Gets the value of the expenseofOwners property.
         * 
         * @return
         *     possible object is
         *     {@link BigDecimal }
         *     
         */
        public BigDecimal getExpenseofOwners() {
            return expenseofOwners;
        }

        /**
         * Sets the value of the expenseofOwners property.
         * 
         * @param value
         *     allowed object is
         *     {@link BigDecimal }
         *     
         */
        public void setExpenseofOwners(BigDecimal value) {
            this.expenseofOwners = value;
        }

        /**
         * Gets the value of the meansofSupport property.
         * 
         * @return
         *     possible object is
         *     {@link BigDecimal }
         *     
         */
        public BigDecimal getMeansofSupport() {
            return meansofSupport;
        }

        /**
         * Sets the value of the meansofSupport property.
         * 
         * @param value
         *     allowed object is
         *     {@link BigDecimal }
         *     
         */
        public void setMeansofSupport(BigDecimal value) {
            this.meansofSupport = value;
        }

    }

}
