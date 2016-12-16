
package ru.gosuslugi.dom.schema.integration.inspection;

import java.math.BigInteger;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;
import ru.gosuslugi.dom.schema.integration.nsi_base.NsiRef;


/**
 * Плановая проверка (пункт плана проверок)
 * 
 * <p>Java class for PlannedExaminationType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="PlannedExaminationType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="PlannedExaminationOverview">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="NumberInPlan">
 *                     &lt;simpleType>
 *                       &lt;restriction base="{http://dom.gosuslugi.ru/schema/integration/inspection/}NumberType">
 *                         &lt;totalDigits value="3"/>
 *                       &lt;/restriction>
 *                     &lt;/simpleType>
 *                   &lt;/element>
 *                   &lt;element name="URIRegistrationNumber" minOccurs="0">
 *                     &lt;simpleType>
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}integer">
 *                         &lt;minInclusive value="0"/>
 *                       &lt;/restriction>
 *                     &lt;/simpleType>
 *                   &lt;/element>
 *                   &lt;element name="URIRegistrationDate" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="Subject" type="{http://dom.gosuslugi.ru/schema/integration/inspection/}ScheduledExaminationSubjectInPlanInfoType"/>
 *         &lt;element name="PlannedExaminationInfo">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="Objective" type="{http://dom.gosuslugi.ru/schema/integration/inspection/}String2000Type"/>
 *                   &lt;element name="Base" type="{http://dom.gosuslugi.ru/schema/integration/nsi-base/}nsiRef" minOccurs="0"/>
 *                   &lt;element name="AdditionalInfoAboutExamBase" type="{http://dom.gosuslugi.ru/schema/integration/inspection/}String2000Type" minOccurs="0"/>
 *                   &lt;element name="LastExaminationEndDate" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
 *                   &lt;element name="MonthFrom" type="{http://dom.gosuslugi.ru/schema/integration/base/}MonthType"/>
 *                   &lt;element name="YearFrom" type="{http://dom.gosuslugi.ru/schema/integration/base/}YearType"/>
 *                   &lt;element name="Duration">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;choice>
 *                             &lt;element name="WorkDays">
 *                               &lt;simpleType>
 *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}double">
 *                                   &lt;minInclusive value="0"/>
 *                                 &lt;/restriction>
 *                               &lt;/simpleType>
 *                             &lt;/element>
 *                             &lt;element name="WorkHours">
 *                               &lt;simpleType>
 *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}double">
 *                                   &lt;minInclusive value="0"/>
 *                                 &lt;/restriction>
 *                               &lt;/simpleType>
 *                             &lt;/element>
 *                           &lt;/choice>
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                   &lt;element name="ExaminationForm" type="{http://dom.gosuslugi.ru/schema/integration/nsi-base/}nsiRef"/>
 *                   &lt;element name="CooperationWith" type="{http://dom.gosuslugi.ru/schema/integration/inspection/}String2000Type" minOccurs="0"/>
 *                   &lt;element name="ProsecutorAgreementInformation" type="{http://dom.gosuslugi.ru/schema/integration/inspection/}String2000Type" minOccurs="0"/>
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
@XmlType(name = "PlannedExaminationType", propOrder = {
    "plannedExaminationOverview",
    "subject",
    "plannedExaminationInfo"
})
@XmlSeeAlso({
    ru.gosuslugi.dom.schema.integration.inspection.ExportInspectionPlanResultType.PlannedExamination.PlannedExaminationInfo.class
})
public class PlannedExaminationType {

    @XmlElement(name = "PlannedExaminationOverview", required = true)
    protected PlannedExaminationType.PlannedExaminationOverview plannedExaminationOverview;
    @XmlElement(name = "Subject", required = true)
    protected ScheduledExaminationSubjectInPlanInfoType subject;
    @XmlElement(name = "PlannedExaminationInfo", required = true)
    protected PlannedExaminationType.PlannedExaminationInfo plannedExaminationInfo;

    /**
     * Gets the value of the plannedExaminationOverview property.
     * 
     * @return
     *     possible object is
     *     {@link PlannedExaminationType.PlannedExaminationOverview }
     *     
     */
    public PlannedExaminationType.PlannedExaminationOverview getPlannedExaminationOverview() {
        return plannedExaminationOverview;
    }

    /**
     * Sets the value of the plannedExaminationOverview property.
     * 
     * @param value
     *     allowed object is
     *     {@link PlannedExaminationType.PlannedExaminationOverview }
     *     
     */
    public void setPlannedExaminationOverview(PlannedExaminationType.PlannedExaminationOverview value) {
        this.plannedExaminationOverview = value;
    }

    /**
     * Gets the value of the subject property.
     * 
     * @return
     *     possible object is
     *     {@link ScheduledExaminationSubjectInPlanInfoType }
     *     
     */
    public ScheduledExaminationSubjectInPlanInfoType getSubject() {
        return subject;
    }

    /**
     * Sets the value of the subject property.
     * 
     * @param value
     *     allowed object is
     *     {@link ScheduledExaminationSubjectInPlanInfoType }
     *     
     */
    public void setSubject(ScheduledExaminationSubjectInPlanInfoType value) {
        this.subject = value;
    }

    /**
     * Gets the value of the plannedExaminationInfo property.
     * 
     * @return
     *     possible object is
     *     {@link PlannedExaminationType.PlannedExaminationInfo }
     *     
     */
    public PlannedExaminationType.PlannedExaminationInfo getPlannedExaminationInfo() {
        return plannedExaminationInfo;
    }

    /**
     * Sets the value of the plannedExaminationInfo property.
     * 
     * @param value
     *     allowed object is
     *     {@link PlannedExaminationType.PlannedExaminationInfo }
     *     
     */
    public void setPlannedExaminationInfo(PlannedExaminationType.PlannedExaminationInfo value) {
        this.plannedExaminationInfo = value;
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
     *         &lt;element name="Objective" type="{http://dom.gosuslugi.ru/schema/integration/inspection/}String2000Type"/>
     *         &lt;element name="Base" type="{http://dom.gosuslugi.ru/schema/integration/nsi-base/}nsiRef" minOccurs="0"/>
     *         &lt;element name="AdditionalInfoAboutExamBase" type="{http://dom.gosuslugi.ru/schema/integration/inspection/}String2000Type" minOccurs="0"/>
     *         &lt;element name="LastExaminationEndDate" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
     *         &lt;element name="MonthFrom" type="{http://dom.gosuslugi.ru/schema/integration/base/}MonthType"/>
     *         &lt;element name="YearFrom" type="{http://dom.gosuslugi.ru/schema/integration/base/}YearType"/>
     *         &lt;element name="Duration">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;choice>
     *                   &lt;element name="WorkDays">
     *                     &lt;simpleType>
     *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}double">
     *                         &lt;minInclusive value="0"/>
     *                       &lt;/restriction>
     *                     &lt;/simpleType>
     *                   &lt;/element>
     *                   &lt;element name="WorkHours">
     *                     &lt;simpleType>
     *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}double">
     *                         &lt;minInclusive value="0"/>
     *                       &lt;/restriction>
     *                     &lt;/simpleType>
     *                   &lt;/element>
     *                 &lt;/choice>
     *               &lt;/restriction>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *         &lt;element name="ExaminationForm" type="{http://dom.gosuslugi.ru/schema/integration/nsi-base/}nsiRef"/>
     *         &lt;element name="CooperationWith" type="{http://dom.gosuslugi.ru/schema/integration/inspection/}String2000Type" minOccurs="0"/>
     *         &lt;element name="ProsecutorAgreementInformation" type="{http://dom.gosuslugi.ru/schema/integration/inspection/}String2000Type" minOccurs="0"/>
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
        "objective",
        "base",
        "additionalInfoAboutExamBase",
        "lastExaminationEndDate",
        "monthFrom",
        "yearFrom",
        "duration",
        "examinationForm",
        "cooperationWith",
        "prosecutorAgreementInformation"
    })
    public static class PlannedExaminationInfo {

        @XmlElement(name = "Objective", required = true)
        protected String objective;
        @XmlElement(name = "Base")
        protected NsiRef base;
        @XmlElement(name = "AdditionalInfoAboutExamBase")
        protected String additionalInfoAboutExamBase;
        @XmlElement(name = "LastExaminationEndDate")
        @XmlSchemaType(name = "date")
        protected XMLGregorianCalendar lastExaminationEndDate;
        @XmlElement(name = "MonthFrom")
        protected int monthFrom;
        @XmlElement(name = "YearFrom")
        protected short yearFrom;
        @XmlElement(name = "Duration", required = true)
        protected PlannedExaminationType.PlannedExaminationInfo.Duration duration;
        @XmlElement(name = "ExaminationForm", required = true)
        protected NsiRef examinationForm;
        @XmlElement(name = "CooperationWith")
        protected String cooperationWith;
        @XmlElement(name = "ProsecutorAgreementInformation")
        protected String prosecutorAgreementInformation;

        /**
         * Gets the value of the objective property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getObjective() {
            return objective;
        }

        /**
         * Sets the value of the objective property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setObjective(String value) {
            this.objective = value;
        }

        /**
         * Gets the value of the base property.
         * 
         * @return
         *     possible object is
         *     {@link NsiRef }
         *     
         */
        public NsiRef getBase() {
            return base;
        }

        /**
         * Sets the value of the base property.
         * 
         * @param value
         *     allowed object is
         *     {@link NsiRef }
         *     
         */
        public void setBase(NsiRef value) {
            this.base = value;
        }

        /**
         * Gets the value of the additionalInfoAboutExamBase property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getAdditionalInfoAboutExamBase() {
            return additionalInfoAboutExamBase;
        }

        /**
         * Sets the value of the additionalInfoAboutExamBase property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setAdditionalInfoAboutExamBase(String value) {
            this.additionalInfoAboutExamBase = value;
        }

        /**
         * Gets the value of the lastExaminationEndDate property.
         * 
         * @return
         *     possible object is
         *     {@link XMLGregorianCalendar }
         *     
         */
        public XMLGregorianCalendar getLastExaminationEndDate() {
            return lastExaminationEndDate;
        }

        /**
         * Sets the value of the lastExaminationEndDate property.
         * 
         * @param value
         *     allowed object is
         *     {@link XMLGregorianCalendar }
         *     
         */
        public void setLastExaminationEndDate(XMLGregorianCalendar value) {
            this.lastExaminationEndDate = value;
        }

        /**
         * Gets the value of the monthFrom property.
         * 
         */
        public int getMonthFrom() {
            return monthFrom;
        }

        /**
         * Sets the value of the monthFrom property.
         * 
         */
        public void setMonthFrom(int value) {
            this.monthFrom = value;
        }

        /**
         * Gets the value of the yearFrom property.
         * 
         */
        public short getYearFrom() {
            return yearFrom;
        }

        /**
         * Sets the value of the yearFrom property.
         * 
         */
        public void setYearFrom(short value) {
            this.yearFrom = value;
        }

        /**
         * Gets the value of the duration property.
         * 
         * @return
         *     possible object is
         *     {@link PlannedExaminationType.PlannedExaminationInfo.Duration }
         *     
         */
        public PlannedExaminationType.PlannedExaminationInfo.Duration getDuration() {
            return duration;
        }

        /**
         * Sets the value of the duration property.
         * 
         * @param value
         *     allowed object is
         *     {@link PlannedExaminationType.PlannedExaminationInfo.Duration }
         *     
         */
        public void setDuration(PlannedExaminationType.PlannedExaminationInfo.Duration value) {
            this.duration = value;
        }

        /**
         * Gets the value of the examinationForm property.
         * 
         * @return
         *     possible object is
         *     {@link NsiRef }
         *     
         */
        public NsiRef getExaminationForm() {
            return examinationForm;
        }

        /**
         * Sets the value of the examinationForm property.
         * 
         * @param value
         *     allowed object is
         *     {@link NsiRef }
         *     
         */
        public void setExaminationForm(NsiRef value) {
            this.examinationForm = value;
        }

        /**
         * Gets the value of the cooperationWith property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getCooperationWith() {
            return cooperationWith;
        }

        /**
         * Sets the value of the cooperationWith property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setCooperationWith(String value) {
            this.cooperationWith = value;
        }

        /**
         * Gets the value of the prosecutorAgreementInformation property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getProsecutorAgreementInformation() {
            return prosecutorAgreementInformation;
        }

        /**
         * Sets the value of the prosecutorAgreementInformation property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setProsecutorAgreementInformation(String value) {
            this.prosecutorAgreementInformation = value;
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
         *       &lt;choice>
         *         &lt;element name="WorkDays">
         *           &lt;simpleType>
         *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}double">
         *               &lt;minInclusive value="0"/>
         *             &lt;/restriction>
         *           &lt;/simpleType>
         *         &lt;/element>
         *         &lt;element name="WorkHours">
         *           &lt;simpleType>
         *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}double">
         *               &lt;minInclusive value="0"/>
         *             &lt;/restriction>
         *           &lt;/simpleType>
         *         &lt;/element>
         *       &lt;/choice>
         *     &lt;/restriction>
         *   &lt;/complexContent>
         * &lt;/complexType>
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
            "workDays",
            "workHours"
        })
        public static class Duration {

            @XmlElement(name = "WorkDays")
            protected Double workDays;
            @XmlElement(name = "WorkHours")
            protected Double workHours;

            /**
             * Gets the value of the workDays property.
             * 
             * @return
             *     possible object is
             *     {@link Double }
             *     
             */
            public Double getWorkDays() {
                return workDays;
            }

            /**
             * Sets the value of the workDays property.
             * 
             * @param value
             *     allowed object is
             *     {@link Double }
             *     
             */
            public void setWorkDays(Double value) {
                this.workDays = value;
            }

            /**
             * Gets the value of the workHours property.
             * 
             * @return
             *     possible object is
             *     {@link Double }
             *     
             */
            public Double getWorkHours() {
                return workHours;
            }

            /**
             * Sets the value of the workHours property.
             * 
             * @param value
             *     allowed object is
             *     {@link Double }
             *     
             */
            public void setWorkHours(Double value) {
                this.workHours = value;
            }

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
     *         &lt;element name="NumberInPlan">
     *           &lt;simpleType>
     *             &lt;restriction base="{http://dom.gosuslugi.ru/schema/integration/inspection/}NumberType">
     *               &lt;totalDigits value="3"/>
     *             &lt;/restriction>
     *           &lt;/simpleType>
     *         &lt;/element>
     *         &lt;element name="URIRegistrationNumber" minOccurs="0">
     *           &lt;simpleType>
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}integer">
     *               &lt;minInclusive value="0"/>
     *             &lt;/restriction>
     *           &lt;/simpleType>
     *         &lt;/element>
     *         &lt;element name="URIRegistrationDate" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
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
        "numberInPlan",
        "uriRegistrationNumber",
        "uriRegistrationDate"
    })
    public static class PlannedExaminationOverview {

        @XmlElement(name = "NumberInPlan")
        protected int numberInPlan;
        @XmlElement(name = "URIRegistrationNumber")
        protected BigInteger uriRegistrationNumber;
        @XmlElement(name = "URIRegistrationDate")
        @XmlSchemaType(name = "date")
        protected XMLGregorianCalendar uriRegistrationDate;

        /**
         * Gets the value of the numberInPlan property.
         * 
         */
        public int getNumberInPlan() {
            return numberInPlan;
        }

        /**
         * Sets the value of the numberInPlan property.
         * 
         */
        public void setNumberInPlan(int value) {
            this.numberInPlan = value;
        }

        /**
         * Gets the value of the uriRegistrationNumber property.
         * 
         * @return
         *     possible object is
         *     {@link BigInteger }
         *     
         */
        public BigInteger getURIRegistrationNumber() {
            return uriRegistrationNumber;
        }

        /**
         * Sets the value of the uriRegistrationNumber property.
         * 
         * @param value
         *     allowed object is
         *     {@link BigInteger }
         *     
         */
        public void setURIRegistrationNumber(BigInteger value) {
            this.uriRegistrationNumber = value;
        }

        /**
         * Gets the value of the uriRegistrationDate property.
         * 
         * @return
         *     possible object is
         *     {@link XMLGregorianCalendar }
         *     
         */
        public XMLGregorianCalendar getURIRegistrationDate() {
            return uriRegistrationDate;
        }

        /**
         * Sets the value of the uriRegistrationDate property.
         * 
         * @param value
         *     allowed object is
         *     {@link XMLGregorianCalendar }
         *     
         */
        public void setURIRegistrationDate(XMLGregorianCalendar value) {
            this.uriRegistrationDate = value;
        }

    }

}
