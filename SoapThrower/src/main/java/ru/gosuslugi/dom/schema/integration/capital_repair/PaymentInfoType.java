
package ru.gosuslugi.dom.schema.integration.capital_repair;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Оплата по договорам на выполнение работ (оказание услуг) по капитальному ремонту
 * 
 * <p>Java class for PaymentInfoType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="PaymentInfoType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/capital-repair/}ShortPaymentInfoType">
 *       &lt;sequence>
 *         &lt;element name="WorkInPayment" maxOccurs="1000">
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
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PaymentInfoType", propOrder = {
    "workInPayment"
})
public class PaymentInfoType
    extends ShortPaymentInfoType
{

    @XmlElement(name = "WorkInPayment", required = true)
    protected List<PaymentInfoType.WorkInPayment> workInPayment;

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
     * {@link PaymentInfoType.WorkInPayment }
     * 
     * 
     */
    public List<PaymentInfoType.WorkInPayment> getWorkInPayment() {
        if (workInPayment == null) {
            workInPayment = new ArrayList<PaymentInfoType.WorkInPayment>();
        }
        return this.workInPayment;
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
