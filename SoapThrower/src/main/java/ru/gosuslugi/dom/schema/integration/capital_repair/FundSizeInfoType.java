
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
import ru.gosuslugi.dom.schema.integration.base.OKTMORefType;


/**
 * Тип информации о размере фонда капитального ремонта
 * 
 * <p>Java class for FundSizeInfoType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="FundSizeInfoType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="FIASHouseGuid" type="{http://dom.gosuslugi.ru/schema/integration/premises-base/}FIASHouseGUIDType"/>
 *         &lt;element name="OKTMO" type="{http://dom.gosuslugi.ru/schema/integration/base/}OKTMORefType"/>
 *         &lt;element name="QuarterPeriod" type="{http://www.w3.org/2001/XMLSchema}gYearMonth"/>
 *         &lt;element name="StartBalance" type="{http://dom.gosuslugi.ru/schema/integration/bills-base/}MoneyPositiveType"/>
 *         &lt;element name="EndBalance" type="{http://dom.gosuslugi.ru/schema/integration/bills-base/}MoneyPositiveType"/>
 *         &lt;element name="SentOnCapitalRepair" type="{http://dom.gosuslugi.ru/schema/integration/bills-base/}MoneyPositiveType"/>
 *         &lt;element name="DebtForPerformedWork" type="{http://dom.gosuslugi.ru/schema/integration/bills-base/}MoneyPositiveType"/>
 *         &lt;element name="PremisesInfo" maxOccurs="1000" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="AccountGuid" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType"/>
 *                   &lt;element name="StartBalance" type="{http://dom.gosuslugi.ru/schema/integration/capital-repair/}MoneyType"/>
 *                   &lt;element name="AccruedContribution" type="{http://dom.gosuslugi.ru/schema/integration/bills-base/}MoneyPositiveType"/>
 *                   &lt;element name="AccruedPenalty" type="{http://dom.gosuslugi.ru/schema/integration/bills-base/}MoneyPositiveType"/>
 *                   &lt;element name="PaidContribution" type="{http://dom.gosuslugi.ru/schema/integration/bills-base/}MoneyPositiveType"/>
 *                   &lt;element name="PaidPenalty" type="{http://dom.gosuslugi.ru/schema/integration/bills-base/}MoneyPositiveType"/>
 *                   &lt;element name="EndBalance" type="{http://dom.gosuslugi.ru/schema/integration/capital-repair/}MoneyType"/>
 *                 &lt;/sequence>
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
@XmlType(name = "FundSizeInfoType", propOrder = {
    "fiasHouseGuid",
    "oktmo",
    "quarterPeriod",
    "startBalance",
    "endBalance",
    "sentOnCapitalRepair",
    "debtForPerformedWork",
    "premisesInfo"
})
@XmlSeeAlso({
    ExportFundSizeInfoType.class
})
public class FundSizeInfoType {

    @XmlElement(name = "FIASHouseGuid", required = true)
    protected String fiasHouseGuid;
    @XmlElement(name = "OKTMO", required = true)
    protected OKTMORefType oktmo;
    @XmlElement(name = "QuarterPeriod", required = true)
    @XmlSchemaType(name = "gYearMonth")
    protected XMLGregorianCalendar quarterPeriod;
    @XmlElement(name = "StartBalance", required = true)
    protected BigDecimal startBalance;
    @XmlElement(name = "EndBalance", required = true)
    protected BigDecimal endBalance;
    @XmlElement(name = "SentOnCapitalRepair", required = true)
    protected BigDecimal sentOnCapitalRepair;
    @XmlElement(name = "DebtForPerformedWork", required = true)
    protected BigDecimal debtForPerformedWork;
    @XmlElement(name = "PremisesInfo")
    protected List<FundSizeInfoType.PremisesInfo> premisesInfo;

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
     * Gets the value of the oktmo property.
     * 
     * @return
     *     possible object is
     *     {@link OKTMORefType }
     *     
     */
    public OKTMORefType getOKTMO() {
        return oktmo;
    }

    /**
     * Sets the value of the oktmo property.
     * 
     * @param value
     *     allowed object is
     *     {@link OKTMORefType }
     *     
     */
    public void setOKTMO(OKTMORefType value) {
        this.oktmo = value;
    }

    /**
     * Gets the value of the quarterPeriod property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getQuarterPeriod() {
        return quarterPeriod;
    }

    /**
     * Sets the value of the quarterPeriod property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setQuarterPeriod(XMLGregorianCalendar value) {
        this.quarterPeriod = value;
    }

    /**
     * Gets the value of the startBalance property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getStartBalance() {
        return startBalance;
    }

    /**
     * Sets the value of the startBalance property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setStartBalance(BigDecimal value) {
        this.startBalance = value;
    }

    /**
     * Gets the value of the endBalance property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getEndBalance() {
        return endBalance;
    }

    /**
     * Sets the value of the endBalance property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setEndBalance(BigDecimal value) {
        this.endBalance = value;
    }

    /**
     * Gets the value of the sentOnCapitalRepair property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getSentOnCapitalRepair() {
        return sentOnCapitalRepair;
    }

    /**
     * Sets the value of the sentOnCapitalRepair property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setSentOnCapitalRepair(BigDecimal value) {
        this.sentOnCapitalRepair = value;
    }

    /**
     * Gets the value of the debtForPerformedWork property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getDebtForPerformedWork() {
        return debtForPerformedWork;
    }

    /**
     * Sets the value of the debtForPerformedWork property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setDebtForPerformedWork(BigDecimal value) {
        this.debtForPerformedWork = value;
    }

    /**
     * Gets the value of the premisesInfo property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the premisesInfo property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPremisesInfo().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link FundSizeInfoType.PremisesInfo }
     * 
     * 
     */
    public List<FundSizeInfoType.PremisesInfo> getPremisesInfo() {
        if (premisesInfo == null) {
            premisesInfo = new ArrayList<FundSizeInfoType.PremisesInfo>();
        }
        return this.premisesInfo;
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
     *         &lt;element name="AccountGuid" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType"/>
     *         &lt;element name="StartBalance" type="{http://dom.gosuslugi.ru/schema/integration/capital-repair/}MoneyType"/>
     *         &lt;element name="AccruedContribution" type="{http://dom.gosuslugi.ru/schema/integration/bills-base/}MoneyPositiveType"/>
     *         &lt;element name="AccruedPenalty" type="{http://dom.gosuslugi.ru/schema/integration/bills-base/}MoneyPositiveType"/>
     *         &lt;element name="PaidContribution" type="{http://dom.gosuslugi.ru/schema/integration/bills-base/}MoneyPositiveType"/>
     *         &lt;element name="PaidPenalty" type="{http://dom.gosuslugi.ru/schema/integration/bills-base/}MoneyPositiveType"/>
     *         &lt;element name="EndBalance" type="{http://dom.gosuslugi.ru/schema/integration/capital-repair/}MoneyType"/>
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
        "accountGuid",
        "startBalance",
        "accruedContribution",
        "accruedPenalty",
        "paidContribution",
        "paidPenalty",
        "endBalance"
    })
    public static class PremisesInfo {

        @XmlElement(name = "AccountGuid", required = true)
        protected String accountGuid;
        @XmlElement(name = "StartBalance", required = true)
        protected BigDecimal startBalance;
        @XmlElement(name = "AccruedContribution", required = true)
        protected BigDecimal accruedContribution;
        @XmlElement(name = "AccruedPenalty", required = true)
        protected BigDecimal accruedPenalty;
        @XmlElement(name = "PaidContribution", required = true)
        protected BigDecimal paidContribution;
        @XmlElement(name = "PaidPenalty", required = true)
        protected BigDecimal paidPenalty;
        @XmlElement(name = "EndBalance", required = true)
        protected BigDecimal endBalance;

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
         * Gets the value of the startBalance property.
         * 
         * @return
         *     possible object is
         *     {@link BigDecimal }
         *     
         */
        public BigDecimal getStartBalance() {
            return startBalance;
        }

        /**
         * Sets the value of the startBalance property.
         * 
         * @param value
         *     allowed object is
         *     {@link BigDecimal }
         *     
         */
        public void setStartBalance(BigDecimal value) {
            this.startBalance = value;
        }

        /**
         * Gets the value of the accruedContribution property.
         * 
         * @return
         *     possible object is
         *     {@link BigDecimal }
         *     
         */
        public BigDecimal getAccruedContribution() {
            return accruedContribution;
        }

        /**
         * Sets the value of the accruedContribution property.
         * 
         * @param value
         *     allowed object is
         *     {@link BigDecimal }
         *     
         */
        public void setAccruedContribution(BigDecimal value) {
            this.accruedContribution = value;
        }

        /**
         * Gets the value of the accruedPenalty property.
         * 
         * @return
         *     possible object is
         *     {@link BigDecimal }
         *     
         */
        public BigDecimal getAccruedPenalty() {
            return accruedPenalty;
        }

        /**
         * Sets the value of the accruedPenalty property.
         * 
         * @param value
         *     allowed object is
         *     {@link BigDecimal }
         *     
         */
        public void setAccruedPenalty(BigDecimal value) {
            this.accruedPenalty = value;
        }

        /**
         * Gets the value of the paidContribution property.
         * 
         * @return
         *     possible object is
         *     {@link BigDecimal }
         *     
         */
        public BigDecimal getPaidContribution() {
            return paidContribution;
        }

        /**
         * Sets the value of the paidContribution property.
         * 
         * @param value
         *     allowed object is
         *     {@link BigDecimal }
         *     
         */
        public void setPaidContribution(BigDecimal value) {
            this.paidContribution = value;
        }

        /**
         * Gets the value of the paidPenalty property.
         * 
         * @return
         *     possible object is
         *     {@link BigDecimal }
         *     
         */
        public BigDecimal getPaidPenalty() {
            return paidPenalty;
        }

        /**
         * Sets the value of the paidPenalty property.
         * 
         * @param value
         *     allowed object is
         *     {@link BigDecimal }
         *     
         */
        public void setPaidPenalty(BigDecimal value) {
            this.paidPenalty = value;
        }

        /**
         * Gets the value of the endBalance property.
         * 
         * @return
         *     possible object is
         *     {@link BigDecimal }
         *     
         */
        public BigDecimal getEndBalance() {
            return endBalance;
        }

        /**
         * Sets the value of the endBalance property.
         * 
         * @param value
         *     allowed object is
         *     {@link BigDecimal }
         *     
         */
        public void setEndBalance(BigDecimal value) {
            this.endBalance = value;
        }

    }

}
