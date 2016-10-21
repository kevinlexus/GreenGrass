
package ru.gosuslugi.dom.schema.integration.device_metering;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;
import ru.gosuslugi.dom.schema.integration.metering_device_base.ElectricMeteringValueType;
import ru.gosuslugi.dom.schema.integration.nsi_base.NsiRef;


/**
 * Виды показаний ПУ (электрическая энергия) (используется при экспорте показаний)
 * 
 * <p>Java class for ElectricMeteringValueKindType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ElectricMeteringValueKindType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="CurrentValue" maxOccurs="unbounded" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/metering-device-base/}ElectricMeteringValueType">
 *                 &lt;sequence>
 *                   &lt;element name="DateValue" type="{http://www.w3.org/2001/XMLSchema}date"/>
 *                 &lt;/sequence>
 *               &lt;/extension>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="ControlValue" maxOccurs="unbounded" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/metering-device-base/}ElectricMeteringValueType">
 *                 &lt;sequence>
 *                   &lt;element name="DateValue" type="{http://www.w3.org/2001/XMLSchema}date"/>
 *                 &lt;/sequence>
 *               &lt;/extension>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="VerificationValue" maxOccurs="unbounded" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="StartDateValue" type="{http://www.w3.org/2001/XMLSchema}date"/>
 *                   &lt;element name="EndDateValue" type="{http://www.w3.org/2001/XMLSchema}date"/>
 *                   &lt;element name="SealDate" type="{http://www.w3.org/2001/XMLSchema}date"/>
 *                   &lt;element name="StartValue" type="{http://dom.gosuslugi.ru/schema/integration/metering-device-base/}ElectricMeteringValueType"/>
 *                   &lt;element name="EndValue" type="{http://dom.gosuslugi.ru/schema/integration/metering-device-base/}ElectricMeteringValueType"/>
 *                   &lt;choice>
 *                     &lt;element name="PlannedVerification" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *                     &lt;element name="VerificationReason" type="{http://dom.gosuslugi.ru/schema/integration/nsi-base/}nsiRef"/>
 *                   &lt;/choice>
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
@XmlType(name = "ElectricMeteringValueKindType", propOrder = {
    "currentValue",
    "controlValue",
    "verificationValue"
})
@XmlSeeAlso({
    ru.gosuslugi.dom.schema.integration.device_metering.ExportMeteringDeviceHistoryResultType.ElectricDeviceValue.Values.class
})
public class ElectricMeteringValueKindType {

    @XmlElement(name = "CurrentValue")
    protected List<ElectricMeteringValueKindType.CurrentValue> currentValue;
    @XmlElement(name = "ControlValue")
    protected List<ElectricMeteringValueKindType.ControlValue> controlValue;
    @XmlElement(name = "VerificationValue")
    protected List<ElectricMeteringValueKindType.VerificationValue> verificationValue;

    /**
     * Gets the value of the currentValue property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the currentValue property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCurrentValue().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ElectricMeteringValueKindType.CurrentValue }
     * 
     * 
     */
    public List<ElectricMeteringValueKindType.CurrentValue> getCurrentValue() {
        if (currentValue == null) {
            currentValue = new ArrayList<ElectricMeteringValueKindType.CurrentValue>();
        }
        return this.currentValue;
    }

    /**
     * Gets the value of the controlValue property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the controlValue property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getControlValue().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ElectricMeteringValueKindType.ControlValue }
     * 
     * 
     */
    public List<ElectricMeteringValueKindType.ControlValue> getControlValue() {
        if (controlValue == null) {
            controlValue = new ArrayList<ElectricMeteringValueKindType.ControlValue>();
        }
        return this.controlValue;
    }

    /**
     * Gets the value of the verificationValue property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the verificationValue property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getVerificationValue().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ElectricMeteringValueKindType.VerificationValue }
     * 
     * 
     */
    public List<ElectricMeteringValueKindType.VerificationValue> getVerificationValue() {
        if (verificationValue == null) {
            verificationValue = new ArrayList<ElectricMeteringValueKindType.VerificationValue>();
        }
        return this.verificationValue;
    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/metering-device-base/}ElectricMeteringValueType">
     *       &lt;sequence>
     *         &lt;element name="DateValue" type="{http://www.w3.org/2001/XMLSchema}date"/>
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
        "dateValue"
    })
    public static class ControlValue
        extends ElectricMeteringValueType
    {

        @XmlElement(name = "DateValue", required = true)
        @XmlSchemaType(name = "date")
        protected XMLGregorianCalendar dateValue;

        /**
         * Gets the value of the dateValue property.
         * 
         * @return
         *     possible object is
         *     {@link XMLGregorianCalendar }
         *     
         */
        public XMLGregorianCalendar getDateValue() {
            return dateValue;
        }

        /**
         * Sets the value of the dateValue property.
         * 
         * @param value
         *     allowed object is
         *     {@link XMLGregorianCalendar }
         *     
         */
        public void setDateValue(XMLGregorianCalendar value) {
            this.dateValue = value;
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
     *     &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/metering-device-base/}ElectricMeteringValueType">
     *       &lt;sequence>
     *         &lt;element name="DateValue" type="{http://www.w3.org/2001/XMLSchema}date"/>
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
        "dateValue"
    })
    public static class CurrentValue
        extends ElectricMeteringValueType
    {

        @XmlElement(name = "DateValue", required = true)
        @XmlSchemaType(name = "date")
        protected XMLGregorianCalendar dateValue;

        /**
         * Gets the value of the dateValue property.
         * 
         * @return
         *     possible object is
         *     {@link XMLGregorianCalendar }
         *     
         */
        public XMLGregorianCalendar getDateValue() {
            return dateValue;
        }

        /**
         * Sets the value of the dateValue property.
         * 
         * @param value
         *     allowed object is
         *     {@link XMLGregorianCalendar }
         *     
         */
        public void setDateValue(XMLGregorianCalendar value) {
            this.dateValue = value;
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
     *       &lt;sequence>
     *         &lt;element name="StartDateValue" type="{http://www.w3.org/2001/XMLSchema}date"/>
     *         &lt;element name="EndDateValue" type="{http://www.w3.org/2001/XMLSchema}date"/>
     *         &lt;element name="SealDate" type="{http://www.w3.org/2001/XMLSchema}date"/>
     *         &lt;element name="StartValue" type="{http://dom.gosuslugi.ru/schema/integration/metering-device-base/}ElectricMeteringValueType"/>
     *         &lt;element name="EndValue" type="{http://dom.gosuslugi.ru/schema/integration/metering-device-base/}ElectricMeteringValueType"/>
     *         &lt;choice>
     *           &lt;element name="PlannedVerification" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
     *           &lt;element name="VerificationReason" type="{http://dom.gosuslugi.ru/schema/integration/nsi-base/}nsiRef"/>
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
    @XmlType(name = "", propOrder = {
        "startDateValue",
        "endDateValue",
        "sealDate",
        "startValue",
        "endValue",
        "plannedVerification",
        "verificationReason"
    })
    public static class VerificationValue {

        @XmlElement(name = "StartDateValue", required = true)
        @XmlSchemaType(name = "date")
        protected XMLGregorianCalendar startDateValue;
        @XmlElement(name = "EndDateValue", required = true)
        @XmlSchemaType(name = "date")
        protected XMLGregorianCalendar endDateValue;
        @XmlElement(name = "SealDate", required = true)
        @XmlSchemaType(name = "date")
        protected XMLGregorianCalendar sealDate;
        @XmlElement(name = "StartValue", required = true)
        protected ElectricMeteringValueType startValue;
        @XmlElement(name = "EndValue", required = true)
        protected ElectricMeteringValueType endValue;
        @XmlElement(name = "PlannedVerification")
        protected Boolean plannedVerification;
        @XmlElement(name = "VerificationReason")
        protected NsiRef verificationReason;

        /**
         * Gets the value of the startDateValue property.
         * 
         * @return
         *     possible object is
         *     {@link XMLGregorianCalendar }
         *     
         */
        public XMLGregorianCalendar getStartDateValue() {
            return startDateValue;
        }

        /**
         * Sets the value of the startDateValue property.
         * 
         * @param value
         *     allowed object is
         *     {@link XMLGregorianCalendar }
         *     
         */
        public void setStartDateValue(XMLGregorianCalendar value) {
            this.startDateValue = value;
        }

        /**
         * Gets the value of the endDateValue property.
         * 
         * @return
         *     possible object is
         *     {@link XMLGregorianCalendar }
         *     
         */
        public XMLGregorianCalendar getEndDateValue() {
            return endDateValue;
        }

        /**
         * Sets the value of the endDateValue property.
         * 
         * @param value
         *     allowed object is
         *     {@link XMLGregorianCalendar }
         *     
         */
        public void setEndDateValue(XMLGregorianCalendar value) {
            this.endDateValue = value;
        }

        /**
         * Gets the value of the sealDate property.
         * 
         * @return
         *     possible object is
         *     {@link XMLGregorianCalendar }
         *     
         */
        public XMLGregorianCalendar getSealDate() {
            return sealDate;
        }

        /**
         * Sets the value of the sealDate property.
         * 
         * @param value
         *     allowed object is
         *     {@link XMLGregorianCalendar }
         *     
         */
        public void setSealDate(XMLGregorianCalendar value) {
            this.sealDate = value;
        }

        /**
         * Gets the value of the startValue property.
         * 
         * @return
         *     possible object is
         *     {@link ElectricMeteringValueType }
         *     
         */
        public ElectricMeteringValueType getStartValue() {
            return startValue;
        }

        /**
         * Sets the value of the startValue property.
         * 
         * @param value
         *     allowed object is
         *     {@link ElectricMeteringValueType }
         *     
         */
        public void setStartValue(ElectricMeteringValueType value) {
            this.startValue = value;
        }

        /**
         * Gets the value of the endValue property.
         * 
         * @return
         *     possible object is
         *     {@link ElectricMeteringValueType }
         *     
         */
        public ElectricMeteringValueType getEndValue() {
            return endValue;
        }

        /**
         * Sets the value of the endValue property.
         * 
         * @param value
         *     allowed object is
         *     {@link ElectricMeteringValueType }
         *     
         */
        public void setEndValue(ElectricMeteringValueType value) {
            this.endValue = value;
        }

        /**
         * Gets the value of the plannedVerification property.
         * 
         * @return
         *     possible object is
         *     {@link Boolean }
         *     
         */
        public Boolean isPlannedVerification() {
            return plannedVerification;
        }

        /**
         * Sets the value of the plannedVerification property.
         * 
         * @param value
         *     allowed object is
         *     {@link Boolean }
         *     
         */
        public void setPlannedVerification(Boolean value) {
            this.plannedVerification = value;
        }

        /**
         * Gets the value of the verificationReason property.
         * 
         * @return
         *     possible object is
         *     {@link NsiRef }
         *     
         */
        public NsiRef getVerificationReason() {
            return verificationReason;
        }

        /**
         * Sets the value of the verificationReason property.
         * 
         * @param value
         *     allowed object is
         *     {@link NsiRef }
         *     
         */
        public void setVerificationReason(NsiRef value) {
            this.verificationReason = value;
        }

    }

}
