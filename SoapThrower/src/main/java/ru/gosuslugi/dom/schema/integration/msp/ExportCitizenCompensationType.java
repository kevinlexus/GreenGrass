
package ru.gosuslugi.dom.schema.integration.msp;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


/**
 * Экспортируемые сведения о гражданине, получающем компансации расходов
 * 
 * <p>Java class for ExportCitizenCompensationType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ExportCitizenCompensationType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Overview">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/msp/}CitizenCompensationOverviewType">
 *                 &lt;sequence>
 *                   &lt;element name="CitizenCompensationGuid" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType"/>
 *                   &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/msp/}Status"/>
 *                 &lt;/sequence>
 *               &lt;/extension>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="Calculation" type="{http://dom.gosuslugi.ru/schema/integration/msp/}ExportCitizenCompensationCalculationType" maxOccurs="1000" minOccurs="0"/>
 *         &lt;element name="Payment" type="{http://dom.gosuslugi.ru/schema/integration/msp/}ExportPaymentType" maxOccurs="1000" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ExportCitizenCompensationType", propOrder = {
    "overview",
    "calculation",
    "payment"
})
public class ExportCitizenCompensationType {

    @XmlElement(name = "Overview", required = true)
    protected ExportCitizenCompensationType.Overview overview;
    @XmlElement(name = "Calculation")
    protected List<ExportCitizenCompensationCalculationType> calculation;
    @XmlElement(name = "Payment")
    protected List<ExportPaymentType> payment;

    /**
     * Gets the value of the overview property.
     * 
     * @return
     *     possible object is
     *     {@link ExportCitizenCompensationType.Overview }
     *     
     */
    public ExportCitizenCompensationType.Overview getOverview() {
        return overview;
    }

    /**
     * Sets the value of the overview property.
     * 
     * @param value
     *     allowed object is
     *     {@link ExportCitizenCompensationType.Overview }
     *     
     */
    public void setOverview(ExportCitizenCompensationType.Overview value) {
        this.overview = value;
    }

    /**
     * Gets the value of the calculation property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the calculation property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCalculation().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ExportCitizenCompensationCalculationType }
     * 
     * 
     */
    public List<ExportCitizenCompensationCalculationType> getCalculation() {
        if (calculation == null) {
            calculation = new ArrayList<ExportCitizenCompensationCalculationType>();
        }
        return this.calculation;
    }

    /**
     * Gets the value of the payment property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the payment property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPayment().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ExportPaymentType }
     * 
     * 
     */
    public List<ExportPaymentType> getPayment() {
        if (payment == null) {
            payment = new ArrayList<ExportPaymentType>();
        }
        return this.payment;
    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/msp/}CitizenCompensationOverviewType">
     *       &lt;sequence>
     *         &lt;element name="CitizenCompensationGuid" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType"/>
     *         &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/msp/}Status"/>
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
        "citizenCompensationGuid",
        "status"
    })
    public static class Overview
        extends CitizenCompensationOverviewType
    {

        @XmlElement(name = "CitizenCompensationGuid", required = true)
        protected String citizenCompensationGuid;
        @XmlElement(name = "Status", required = true)
        @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
        protected String status;

        /**
         * Gets the value of the citizenCompensationGuid property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getCitizenCompensationGuid() {
            return citizenCompensationGuid;
        }

        /**
         * Sets the value of the citizenCompensationGuid property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setCitizenCompensationGuid(String value) {
            this.citizenCompensationGuid = value;
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

    }

}
