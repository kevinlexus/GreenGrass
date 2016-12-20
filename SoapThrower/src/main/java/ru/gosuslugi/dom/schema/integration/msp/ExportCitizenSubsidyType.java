
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
 * Экспортирумые сведения о гражданине, получающем субсидии
 * 
 * <p>Java class for ExportCitizenSubsidyType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ExportCitizenSubsidyType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Overview">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/msp/}CitizenSubsidyOverviewType">
 *                 &lt;sequence>
 *                   &lt;element name="CitizenSubsidyGuid" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType"/>
 *                   &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/msp/}Status"/>
 *                 &lt;/sequence>
 *               &lt;/extension>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="Calculation" type="{http://dom.gosuslugi.ru/schema/integration/msp/}ExportCitizenSubsidyCalculationType" maxOccurs="1000" minOccurs="0"/>
 *         &lt;element name="Payment" maxOccurs="1000" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/msp/}ExportPaymentType">
 *               &lt;/extension>
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
@XmlType(name = "ExportCitizenSubsidyType", propOrder = {
    "overview",
    "calculation",
    "payment"
})
public class ExportCitizenSubsidyType {

    @XmlElement(name = "Overview", required = true)
    protected ExportCitizenSubsidyType.Overview overview;
    @XmlElement(name = "Calculation")
    protected List<ExportCitizenSubsidyCalculationType> calculation;
    @XmlElement(name = "Payment")
    protected List<ExportCitizenSubsidyType.Payment> payment;

    /**
     * Gets the value of the overview property.
     * 
     * @return
     *     possible object is
     *     {@link ExportCitizenSubsidyType.Overview }
     *     
     */
    public ExportCitizenSubsidyType.Overview getOverview() {
        return overview;
    }

    /**
     * Sets the value of the overview property.
     * 
     * @param value
     *     allowed object is
     *     {@link ExportCitizenSubsidyType.Overview }
     *     
     */
    public void setOverview(ExportCitizenSubsidyType.Overview value) {
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
     * {@link ExportCitizenSubsidyCalculationType }
     * 
     * 
     */
    public List<ExportCitizenSubsidyCalculationType> getCalculation() {
        if (calculation == null) {
            calculation = new ArrayList<ExportCitizenSubsidyCalculationType>();
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
     * {@link ExportCitizenSubsidyType.Payment }
     * 
     * 
     */
    public List<ExportCitizenSubsidyType.Payment> getPayment() {
        if (payment == null) {
            payment = new ArrayList<ExportCitizenSubsidyType.Payment>();
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
     *     &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/msp/}CitizenSubsidyOverviewType">
     *       &lt;sequence>
     *         &lt;element name="CitizenSubsidyGuid" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType"/>
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
        "citizenSubsidyGuid",
        "status"
    })
    public static class Overview
        extends CitizenSubsidyOverviewType
    {

        @XmlElement(name = "CitizenSubsidyGuid", required = true)
        protected String citizenSubsidyGuid;
        @XmlElement(name = "Status", required = true)
        @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
        protected String status;

        /**
         * Gets the value of the citizenSubsidyGuid property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getCitizenSubsidyGuid() {
            return citizenSubsidyGuid;
        }

        /**
         * Sets the value of the citizenSubsidyGuid property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setCitizenSubsidyGuid(String value) {
            this.citizenSubsidyGuid = value;
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


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/msp/}ExportPaymentType">
     *     &lt;/extension>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "")
    public static class Payment
        extends ExportPaymentType
    {


    }

}
