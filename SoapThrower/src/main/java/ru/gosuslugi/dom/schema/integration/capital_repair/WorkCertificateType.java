
package ru.gosuslugi.dom.schema.integration.capital_repair;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * Работа в акте выполненных работ (оказанных услуг)
 * 
 * <p>Java class for WorkCertificateType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="WorkCertificateType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="WorkInContract" type="{http://dom.gosuslugi.ru/schema/integration/capital-repair/}WorkContractIdentityType"/>
 *         &lt;element name="WorkCost" type="{http://dom.gosuslugi.ru/schema/integration/bills-base/}MoneyPositiveType"/>
 *         &lt;element name="WorkValue">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}decimal">
 *               &lt;fractionDigits value="3"/>
 *               &lt;minInclusive value="0"/>
 *               &lt;totalDigits value="20"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;choice>
 *           &lt;element name="AppForUse">
 *             &lt;complexType>
 *               &lt;complexContent>
 *                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                   &lt;sequence>
 *                     &lt;element name="StartDateGuarantee" type="{http://www.w3.org/2001/XMLSchema}date"/>
 *                     &lt;element name="EndDateGuarantee" type="{http://www.w3.org/2001/XMLSchema}date"/>
 *                   &lt;/sequence>
 *                 &lt;/restriction>
 *               &lt;/complexContent>
 *             &lt;/complexType>
 *           &lt;/element>
 *           &lt;element name="NotAppForUse" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
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
@XmlType(name = "WorkCertificateType", propOrder = {
    "workInContract",
    "workCost",
    "workValue",
    "appForUse",
    "notAppForUse"
})
@XmlSeeAlso({
    ru.gosuslugi.dom.schema.integration.capital_repair.ExportCertificateType.Work.class,
    ru.gosuslugi.dom.schema.integration.capital_repair.CertificateType.Work.class
})
public class WorkCertificateType {

    @XmlElement(name = "WorkInContract", required = true)
    protected WorkContractIdentityType workInContract;
    @XmlElement(name = "WorkCost", required = true)
    protected BigDecimal workCost;
    @XmlElement(name = "WorkValue", required = true)
    protected BigDecimal workValue;
    @XmlElement(name = "AppForUse")
    protected WorkCertificateType.AppForUse appForUse;
    @XmlElement(name = "NotAppForUse")
    protected Boolean notAppForUse;

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
     * Gets the value of the workCost property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getWorkCost() {
        return workCost;
    }

    /**
     * Sets the value of the workCost property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setWorkCost(BigDecimal value) {
        this.workCost = value;
    }

    /**
     * Gets the value of the workValue property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getWorkValue() {
        return workValue;
    }

    /**
     * Sets the value of the workValue property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setWorkValue(BigDecimal value) {
        this.workValue = value;
    }

    /**
     * Gets the value of the appForUse property.
     * 
     * @return
     *     possible object is
     *     {@link WorkCertificateType.AppForUse }
     *     
     */
    public WorkCertificateType.AppForUse getAppForUse() {
        return appForUse;
    }

    /**
     * Sets the value of the appForUse property.
     * 
     * @param value
     *     allowed object is
     *     {@link WorkCertificateType.AppForUse }
     *     
     */
    public void setAppForUse(WorkCertificateType.AppForUse value) {
        this.appForUse = value;
    }

    /**
     * Gets the value of the notAppForUse property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isNotAppForUse() {
        return notAppForUse;
    }

    /**
     * Sets the value of the notAppForUse property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setNotAppForUse(Boolean value) {
        this.notAppForUse = value;
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
     *         &lt;element name="StartDateGuarantee" type="{http://www.w3.org/2001/XMLSchema}date"/>
     *         &lt;element name="EndDateGuarantee" type="{http://www.w3.org/2001/XMLSchema}date"/>
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
        "startDateGuarantee",
        "endDateGuarantee"
    })
    public static class AppForUse {

        @XmlElement(name = "StartDateGuarantee", required = true)
        @XmlSchemaType(name = "date")
        protected XMLGregorianCalendar startDateGuarantee;
        @XmlElement(name = "EndDateGuarantee", required = true)
        @XmlSchemaType(name = "date")
        protected XMLGregorianCalendar endDateGuarantee;

        /**
         * Gets the value of the startDateGuarantee property.
         * 
         * @return
         *     possible object is
         *     {@link XMLGregorianCalendar }
         *     
         */
        public XMLGregorianCalendar getStartDateGuarantee() {
            return startDateGuarantee;
        }

        /**
         * Sets the value of the startDateGuarantee property.
         * 
         * @param value
         *     allowed object is
         *     {@link XMLGregorianCalendar }
         *     
         */
        public void setStartDateGuarantee(XMLGregorianCalendar value) {
            this.startDateGuarantee = value;
        }

        /**
         * Gets the value of the endDateGuarantee property.
         * 
         * @return
         *     possible object is
         *     {@link XMLGregorianCalendar }
         *     
         */
        public XMLGregorianCalendar getEndDateGuarantee() {
            return endDateGuarantee;
        }

        /**
         * Sets the value of the endDateGuarantee property.
         * 
         * @param value
         *     allowed object is
         *     {@link XMLGregorianCalendar }
         *     
         */
        public void setEndDateGuarantee(XMLGregorianCalendar value) {
            this.endDateGuarantee = value;
        }

    }

}
