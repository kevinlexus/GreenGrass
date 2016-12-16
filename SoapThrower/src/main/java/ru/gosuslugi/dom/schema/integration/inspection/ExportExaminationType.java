
package ru.gosuslugi.dom.schema.integration.inspection;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;
import ru.gosuslugi.dom.schema.integration.base.AttachmentType;
import ru.gosuslugi.dom.schema.integration.nsi_base.NsiRef;


/**
 * Проверка (экспорт)
 * 
 * <p>Java class for exportExaminationType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="exportExaminationType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ExaminationOverview">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="ShouldNotBeRegistered" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *                   &lt;element name="ExaminationTypeType">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;choice>
 *                             &lt;element name="Scheduled">
 *                               &lt;complexType>
 *                                 &lt;complexContent>
 *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                     &lt;sequence>
 *                                       &lt;element name="Subject" type="{http://dom.gosuslugi.ru/schema/integration/inspection/}ScheduledExaminationSubjectInfoType"/>
 *                                     &lt;/sequence>
 *                                   &lt;/restriction>
 *                                 &lt;/complexContent>
 *                               &lt;/complexType>
 *                             &lt;/element>
 *                             &lt;element name="Unscheduled">
 *                               &lt;complexType>
 *                                 &lt;complexContent>
 *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                     &lt;sequence>
 *                                       &lt;element name="Subject" type="{http://dom.gosuslugi.ru/schema/integration/inspection/}UnscheduledExaminationSubjectInfoType"/>
 *                                     &lt;/sequence>
 *                                   &lt;/restriction>
 *                                 &lt;/complexContent>
 *                               &lt;/complexType>
 *                             &lt;/element>
 *                           &lt;/choice>
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                   &lt;element name="OversightActivitiesRef" type="{http://dom.gosuslugi.ru/schema/integration/nsi-base/}nsiRef"/>
 *                   &lt;element name="ExaminationForm" type="{http://dom.gosuslugi.ru/schema/integration/nsi-base/}nsiRef"/>
 *                   &lt;element name="OrderNumber" type="{http://dom.gosuslugi.ru/schema/integration/inspection/}String255Type" minOccurs="0"/>
 *                   &lt;element name="OrderDate" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="RegulatoryAuthorityInformation" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="FunctionRegistryNumber" type="{http://dom.gosuslugi.ru/schema/integration/inspection/}FunctionRegistryNumberType"/>
 *                   &lt;element name="AuthorizedPersons" type="{http://dom.gosuslugi.ru/schema/integration/inspection/}String2000Type" minOccurs="0"/>
 *                   &lt;element name="InvolvedExperts" type="{http://dom.gosuslugi.ru/schema/integration/inspection/}String2000Type" minOccurs="0"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="NotificationInfo" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;choice>
 *                   &lt;element name="NotRequired" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *                   &lt;element name="RequiredAndNotSent" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *                   &lt;sequence>
 *                     &lt;element name="NotificationDate" type="{http://www.w3.org/2001/XMLSchema}date"/>
 *                     &lt;element name="NotificationMethod" type="{http://dom.gosuslugi.ru/schema/integration/inspection/}String2000Type"/>
 *                   &lt;/sequence>
 *                 &lt;/choice>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="ExaminationInfo">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="Base" type="{http://dom.gosuslugi.ru/schema/integration/nsi-base/}nsiRef" minOccurs="0"/>
 *                   &lt;element name="BasedOnPrecept" minOccurs="0">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="PreceptGuid" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType"/>
 *                           &lt;/sequence>
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                   &lt;element name="Objective" type="{http://dom.gosuslugi.ru/schema/integration/inspection/}String2000Type"/>
 *                   &lt;element name="AdditionalInfoAboutExamBase" type="{http://dom.gosuslugi.ru/schema/integration/inspection/}String2000Type" minOccurs="0"/>
 *                   &lt;element name="Tasks" type="{http://dom.gosuslugi.ru/schema/integration/inspection/}String2000Type" minOccurs="0"/>
 *                   &lt;element name="Object" type="{http://dom.gosuslugi.ru/schema/integration/nsi-base/}nsiRef" maxOccurs="unbounded" minOccurs="0"/>
 *                   &lt;element name="From" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *                   &lt;element name="To" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *                   &lt;element name="Duration">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;choice>
 *                             &lt;element name="WorkDays">
 *                               &lt;simpleType>
 *                                 &lt;restriction base="{http://dom.gosuslugi.ru/schema/integration/inspection/}TimeUnitCountType">
 *                                 &lt;/restriction>
 *                               &lt;/simpleType>
 *                             &lt;/element>
 *                             &lt;element name="WorkHours">
 *                               &lt;simpleType>
 *                                 &lt;restriction base="{http://dom.gosuslugi.ru/schema/integration/inspection/}TimeUnitCountType">
 *                                 &lt;/restriction>
 *                               &lt;/simpleType>
 *                             &lt;/element>
 *                           &lt;/choice>
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                   &lt;element name="CooperationWith" type="{http://dom.gosuslugi.ru/schema/integration/inspection/}String2000Type" minOccurs="0"/>
 *                   &lt;element name="ProsecutorAgreementInformation" type="{http://dom.gosuslugi.ru/schema/integration/inspection/}String2000Type" minOccurs="0"/>
 *                   &lt;element name="AdditionalInfo" type="{http://dom.gosuslugi.ru/schema/integration/inspection/}String2000Type" minOccurs="0"/>
 *                   &lt;element name="InspectionInabilityReason" type="{http://dom.gosuslugi.ru/schema/integration/inspection/}String2000Type" minOccurs="0"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="ExecutingInfo" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="Event" type="{http://dom.gosuslugi.ru/schema/integration/inspection/}ExaminationEventType" maxOccurs="unbounded" minOccurs="0"/>
 *                   &lt;element name="Place" type="{http://dom.gosuslugi.ru/schema/integration/inspection/}ExaminationPlaceType" maxOccurs="unbounded" minOccurs="0"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="ResultsInfo" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/inspection/}ExportResultsInfoType">
 *                 &lt;sequence>
 *                   &lt;element name="CancelExaminationResults" type="{http://dom.gosuslugi.ru/schema/integration/inspection/}CancelledInfoWithAttachmentsType" minOccurs="0"/>
 *                 &lt;/sequence>
 *               &lt;/extension>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="CancelledInfo" type="{http://dom.gosuslugi.ru/schema/integration/inspection/}CancelledInfoWithAttachmentsType" minOccurs="0"/>
 *         &lt;element name="Attachments" type="{http://dom.gosuslugi.ru/schema/integration/base/}AttachmentType" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "exportExaminationType", propOrder = {
    "examinationOverview",
    "regulatoryAuthorityInformation",
    "notificationInfo",
    "examinationInfo",
    "executingInfo",
    "resultsInfo",
    "cancelledInfo",
    "attachments"
})
public class ExportExaminationType {

    @XmlElement(name = "ExaminationOverview", required = true)
    protected ExportExaminationType.ExaminationOverview examinationOverview;
    @XmlElement(name = "RegulatoryAuthorityInformation")
    protected ExportExaminationType.RegulatoryAuthorityInformation regulatoryAuthorityInformation;
    @XmlElement(name = "NotificationInfo")
    protected ExportExaminationType.NotificationInfo notificationInfo;
    @XmlElement(name = "ExaminationInfo", required = true)
    protected ExportExaminationType.ExaminationInfo examinationInfo;
    @XmlElement(name = "ExecutingInfo")
    protected ExportExaminationType.ExecutingInfo executingInfo;
    @XmlElement(name = "ResultsInfo")
    protected ExportExaminationType.ResultsInfo resultsInfo;
    @XmlElement(name = "CancelledInfo")
    protected CancelledInfoWithAttachmentsType cancelledInfo;
    @XmlElement(name = "Attachments")
    protected List<AttachmentType> attachments;

    /**
     * Gets the value of the examinationOverview property.
     * 
     * @return
     *     possible object is
     *     {@link ExportExaminationType.ExaminationOverview }
     *     
     */
    public ExportExaminationType.ExaminationOverview getExaminationOverview() {
        return examinationOverview;
    }

    /**
     * Sets the value of the examinationOverview property.
     * 
     * @param value
     *     allowed object is
     *     {@link ExportExaminationType.ExaminationOverview }
     *     
     */
    public void setExaminationOverview(ExportExaminationType.ExaminationOverview value) {
        this.examinationOverview = value;
    }

    /**
     * Gets the value of the regulatoryAuthorityInformation property.
     * 
     * @return
     *     possible object is
     *     {@link ExportExaminationType.RegulatoryAuthorityInformation }
     *     
     */
    public ExportExaminationType.RegulatoryAuthorityInformation getRegulatoryAuthorityInformation() {
        return regulatoryAuthorityInformation;
    }

    /**
     * Sets the value of the regulatoryAuthorityInformation property.
     * 
     * @param value
     *     allowed object is
     *     {@link ExportExaminationType.RegulatoryAuthorityInformation }
     *     
     */
    public void setRegulatoryAuthorityInformation(ExportExaminationType.RegulatoryAuthorityInformation value) {
        this.regulatoryAuthorityInformation = value;
    }

    /**
     * Gets the value of the notificationInfo property.
     * 
     * @return
     *     possible object is
     *     {@link ExportExaminationType.NotificationInfo }
     *     
     */
    public ExportExaminationType.NotificationInfo getNotificationInfo() {
        return notificationInfo;
    }

    /**
     * Sets the value of the notificationInfo property.
     * 
     * @param value
     *     allowed object is
     *     {@link ExportExaminationType.NotificationInfo }
     *     
     */
    public void setNotificationInfo(ExportExaminationType.NotificationInfo value) {
        this.notificationInfo = value;
    }

    /**
     * Gets the value of the examinationInfo property.
     * 
     * @return
     *     possible object is
     *     {@link ExportExaminationType.ExaminationInfo }
     *     
     */
    public ExportExaminationType.ExaminationInfo getExaminationInfo() {
        return examinationInfo;
    }

    /**
     * Sets the value of the examinationInfo property.
     * 
     * @param value
     *     allowed object is
     *     {@link ExportExaminationType.ExaminationInfo }
     *     
     */
    public void setExaminationInfo(ExportExaminationType.ExaminationInfo value) {
        this.examinationInfo = value;
    }

    /**
     * Gets the value of the executingInfo property.
     * 
     * @return
     *     possible object is
     *     {@link ExportExaminationType.ExecutingInfo }
     *     
     */
    public ExportExaminationType.ExecutingInfo getExecutingInfo() {
        return executingInfo;
    }

    /**
     * Sets the value of the executingInfo property.
     * 
     * @param value
     *     allowed object is
     *     {@link ExportExaminationType.ExecutingInfo }
     *     
     */
    public void setExecutingInfo(ExportExaminationType.ExecutingInfo value) {
        this.executingInfo = value;
    }

    /**
     * Gets the value of the resultsInfo property.
     * 
     * @return
     *     possible object is
     *     {@link ExportExaminationType.ResultsInfo }
     *     
     */
    public ExportExaminationType.ResultsInfo getResultsInfo() {
        return resultsInfo;
    }

    /**
     * Sets the value of the resultsInfo property.
     * 
     * @param value
     *     allowed object is
     *     {@link ExportExaminationType.ResultsInfo }
     *     
     */
    public void setResultsInfo(ExportExaminationType.ResultsInfo value) {
        this.resultsInfo = value;
    }

    /**
     * Gets the value of the cancelledInfo property.
     * 
     * @return
     *     possible object is
     *     {@link CancelledInfoWithAttachmentsType }
     *     
     */
    public CancelledInfoWithAttachmentsType getCancelledInfo() {
        return cancelledInfo;
    }

    /**
     * Sets the value of the cancelledInfo property.
     * 
     * @param value
     *     allowed object is
     *     {@link CancelledInfoWithAttachmentsType }
     *     
     */
    public void setCancelledInfo(CancelledInfoWithAttachmentsType value) {
        this.cancelledInfo = value;
    }

    /**
     * Gets the value of the attachments property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the attachments property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAttachments().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link AttachmentType }
     * 
     * 
     */
    public List<AttachmentType> getAttachments() {
        if (attachments == null) {
            attachments = new ArrayList<AttachmentType>();
        }
        return this.attachments;
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
     *         &lt;element name="Base" type="{http://dom.gosuslugi.ru/schema/integration/nsi-base/}nsiRef" minOccurs="0"/>
     *         &lt;element name="BasedOnPrecept" minOccurs="0">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element name="PreceptGuid" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType"/>
     *                 &lt;/sequence>
     *               &lt;/restriction>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *         &lt;element name="Objective" type="{http://dom.gosuslugi.ru/schema/integration/inspection/}String2000Type"/>
     *         &lt;element name="AdditionalInfoAboutExamBase" type="{http://dom.gosuslugi.ru/schema/integration/inspection/}String2000Type" minOccurs="0"/>
     *         &lt;element name="Tasks" type="{http://dom.gosuslugi.ru/schema/integration/inspection/}String2000Type" minOccurs="0"/>
     *         &lt;element name="Object" type="{http://dom.gosuslugi.ru/schema/integration/nsi-base/}nsiRef" maxOccurs="unbounded" minOccurs="0"/>
     *         &lt;element name="From" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
     *         &lt;element name="To" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
     *         &lt;element name="Duration">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;choice>
     *                   &lt;element name="WorkDays">
     *                     &lt;simpleType>
     *                       &lt;restriction base="{http://dom.gosuslugi.ru/schema/integration/inspection/}TimeUnitCountType">
     *                       &lt;/restriction>
     *                     &lt;/simpleType>
     *                   &lt;/element>
     *                   &lt;element name="WorkHours">
     *                     &lt;simpleType>
     *                       &lt;restriction base="{http://dom.gosuslugi.ru/schema/integration/inspection/}TimeUnitCountType">
     *                       &lt;/restriction>
     *                     &lt;/simpleType>
     *                   &lt;/element>
     *                 &lt;/choice>
     *               &lt;/restriction>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *         &lt;element name="CooperationWith" type="{http://dom.gosuslugi.ru/schema/integration/inspection/}String2000Type" minOccurs="0"/>
     *         &lt;element name="ProsecutorAgreementInformation" type="{http://dom.gosuslugi.ru/schema/integration/inspection/}String2000Type" minOccurs="0"/>
     *         &lt;element name="AdditionalInfo" type="{http://dom.gosuslugi.ru/schema/integration/inspection/}String2000Type" minOccurs="0"/>
     *         &lt;element name="InspectionInabilityReason" type="{http://dom.gosuslugi.ru/schema/integration/inspection/}String2000Type" minOccurs="0"/>
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
        "base",
        "basedOnPrecept",
        "objective",
        "additionalInfoAboutExamBase",
        "tasks",
        "object",
        "from",
        "to",
        "duration",
        "cooperationWith",
        "prosecutorAgreementInformation",
        "additionalInfo",
        "inspectionInabilityReason"
    })
    public static class ExaminationInfo {

        @XmlElement(name = "Base")
        protected NsiRef base;
        @XmlElement(name = "BasedOnPrecept")
        protected ExportExaminationType.ExaminationInfo.BasedOnPrecept basedOnPrecept;
        @XmlElement(name = "Objective", required = true)
        protected String objective;
        @XmlElement(name = "AdditionalInfoAboutExamBase")
        protected String additionalInfoAboutExamBase;
        @XmlElement(name = "Tasks")
        protected String tasks;
        @XmlElement(name = "Object")
        protected List<NsiRef> object;
        @XmlElement(name = "From", required = true)
        @XmlSchemaType(name = "dateTime")
        protected XMLGregorianCalendar from;
        @XmlElement(name = "To", required = true)
        @XmlSchemaType(name = "dateTime")
        protected XMLGregorianCalendar to;
        @XmlElement(name = "Duration", required = true)
        protected ExportExaminationType.ExaminationInfo.Duration duration;
        @XmlElement(name = "CooperationWith")
        protected String cooperationWith;
        @XmlElement(name = "ProsecutorAgreementInformation")
        protected String prosecutorAgreementInformation;
        @XmlElement(name = "AdditionalInfo")
        protected String additionalInfo;
        @XmlElement(name = "InspectionInabilityReason")
        protected String inspectionInabilityReason;

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
         * Gets the value of the basedOnPrecept property.
         * 
         * @return
         *     possible object is
         *     {@link ExportExaminationType.ExaminationInfo.BasedOnPrecept }
         *     
         */
        public ExportExaminationType.ExaminationInfo.BasedOnPrecept getBasedOnPrecept() {
            return basedOnPrecept;
        }

        /**
         * Sets the value of the basedOnPrecept property.
         * 
         * @param value
         *     allowed object is
         *     {@link ExportExaminationType.ExaminationInfo.BasedOnPrecept }
         *     
         */
        public void setBasedOnPrecept(ExportExaminationType.ExaminationInfo.BasedOnPrecept value) {
            this.basedOnPrecept = value;
        }

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
         * Gets the value of the tasks property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getTasks() {
            return tasks;
        }

        /**
         * Sets the value of the tasks property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setTasks(String value) {
            this.tasks = value;
        }

        /**
         * Gets the value of the object property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the object property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getObject().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link NsiRef }
         * 
         * 
         */
        public List<NsiRef> getObject() {
            if (object == null) {
                object = new ArrayList<NsiRef>();
            }
            return this.object;
        }

        /**
         * Gets the value of the from property.
         * 
         * @return
         *     possible object is
         *     {@link XMLGregorianCalendar }
         *     
         */
        public XMLGregorianCalendar getFrom() {
            return from;
        }

        /**
         * Sets the value of the from property.
         * 
         * @param value
         *     allowed object is
         *     {@link XMLGregorianCalendar }
         *     
         */
        public void setFrom(XMLGregorianCalendar value) {
            this.from = value;
        }

        /**
         * Gets the value of the to property.
         * 
         * @return
         *     possible object is
         *     {@link XMLGregorianCalendar }
         *     
         */
        public XMLGregorianCalendar getTo() {
            return to;
        }

        /**
         * Sets the value of the to property.
         * 
         * @param value
         *     allowed object is
         *     {@link XMLGregorianCalendar }
         *     
         */
        public void setTo(XMLGregorianCalendar value) {
            this.to = value;
        }

        /**
         * Gets the value of the duration property.
         * 
         * @return
         *     possible object is
         *     {@link ExportExaminationType.ExaminationInfo.Duration }
         *     
         */
        public ExportExaminationType.ExaminationInfo.Duration getDuration() {
            return duration;
        }

        /**
         * Sets the value of the duration property.
         * 
         * @param value
         *     allowed object is
         *     {@link ExportExaminationType.ExaminationInfo.Duration }
         *     
         */
        public void setDuration(ExportExaminationType.ExaminationInfo.Duration value) {
            this.duration = value;
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
         * Gets the value of the additionalInfo property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getAdditionalInfo() {
            return additionalInfo;
        }

        /**
         * Sets the value of the additionalInfo property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setAdditionalInfo(String value) {
            this.additionalInfo = value;
        }

        /**
         * Gets the value of the inspectionInabilityReason property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getInspectionInabilityReason() {
            return inspectionInabilityReason;
        }

        /**
         * Sets the value of the inspectionInabilityReason property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setInspectionInabilityReason(String value) {
            this.inspectionInabilityReason = value;
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
         *         &lt;element name="PreceptGuid" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType"/>
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
            "preceptGuid"
        })
        public static class BasedOnPrecept {

            @XmlElement(name = "PreceptGuid", required = true)
            protected String preceptGuid;

            /**
             * Gets the value of the preceptGuid property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getPreceptGuid() {
                return preceptGuid;
            }

            /**
             * Sets the value of the preceptGuid property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setPreceptGuid(String value) {
                this.preceptGuid = value;
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
         *       &lt;choice>
         *         &lt;element name="WorkDays">
         *           &lt;simpleType>
         *             &lt;restriction base="{http://dom.gosuslugi.ru/schema/integration/inspection/}TimeUnitCountType">
         *             &lt;/restriction>
         *           &lt;/simpleType>
         *         &lt;/element>
         *         &lt;element name="WorkHours">
         *           &lt;simpleType>
         *             &lt;restriction base="{http://dom.gosuslugi.ru/schema/integration/inspection/}TimeUnitCountType">
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
     *         &lt;element name="ShouldNotBeRegistered" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
     *         &lt;element name="ExaminationTypeType">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;choice>
     *                   &lt;element name="Scheduled">
     *                     &lt;complexType>
     *                       &lt;complexContent>
     *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                           &lt;sequence>
     *                             &lt;element name="Subject" type="{http://dom.gosuslugi.ru/schema/integration/inspection/}ScheduledExaminationSubjectInfoType"/>
     *                           &lt;/sequence>
     *                         &lt;/restriction>
     *                       &lt;/complexContent>
     *                     &lt;/complexType>
     *                   &lt;/element>
     *                   &lt;element name="Unscheduled">
     *                     &lt;complexType>
     *                       &lt;complexContent>
     *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                           &lt;sequence>
     *                             &lt;element name="Subject" type="{http://dom.gosuslugi.ru/schema/integration/inspection/}UnscheduledExaminationSubjectInfoType"/>
     *                           &lt;/sequence>
     *                         &lt;/restriction>
     *                       &lt;/complexContent>
     *                     &lt;/complexType>
     *                   &lt;/element>
     *                 &lt;/choice>
     *               &lt;/restriction>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *         &lt;element name="OversightActivitiesRef" type="{http://dom.gosuslugi.ru/schema/integration/nsi-base/}nsiRef"/>
     *         &lt;element name="ExaminationForm" type="{http://dom.gosuslugi.ru/schema/integration/nsi-base/}nsiRef"/>
     *         &lt;element name="OrderNumber" type="{http://dom.gosuslugi.ru/schema/integration/inspection/}String255Type" minOccurs="0"/>
     *         &lt;element name="OrderDate" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
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
        "shouldNotBeRegistered",
        "examinationTypeType",
        "oversightActivitiesRef",
        "examinationForm",
        "orderNumber",
        "orderDate"
    })
    public static class ExaminationOverview {

        @XmlElement(name = "ShouldNotBeRegistered")
        protected Boolean shouldNotBeRegistered;
        @XmlElement(name = "ExaminationTypeType", required = true)
        protected ExportExaminationType.ExaminationOverview.ExaminationTypeType examinationTypeType;
        @XmlElement(name = "OversightActivitiesRef", required = true)
        protected NsiRef oversightActivitiesRef;
        @XmlElement(name = "ExaminationForm", required = true)
        protected NsiRef examinationForm;
        @XmlElement(name = "OrderNumber")
        protected String orderNumber;
        @XmlElement(name = "OrderDate")
        @XmlSchemaType(name = "date")
        protected XMLGregorianCalendar orderDate;

        /**
         * Gets the value of the shouldNotBeRegistered property.
         * 
         * @return
         *     possible object is
         *     {@link Boolean }
         *     
         */
        public Boolean isShouldNotBeRegistered() {
            return shouldNotBeRegistered;
        }

        /**
         * Sets the value of the shouldNotBeRegistered property.
         * 
         * @param value
         *     allowed object is
         *     {@link Boolean }
         *     
         */
        public void setShouldNotBeRegistered(Boolean value) {
            this.shouldNotBeRegistered = value;
        }

        /**
         * Gets the value of the examinationTypeType property.
         * 
         * @return
         *     possible object is
         *     {@link ExportExaminationType.ExaminationOverview.ExaminationTypeType }
         *     
         */
        public ExportExaminationType.ExaminationOverview.ExaminationTypeType getExaminationTypeType() {
            return examinationTypeType;
        }

        /**
         * Sets the value of the examinationTypeType property.
         * 
         * @param value
         *     allowed object is
         *     {@link ExportExaminationType.ExaminationOverview.ExaminationTypeType }
         *     
         */
        public void setExaminationTypeType(ExportExaminationType.ExaminationOverview.ExaminationTypeType value) {
            this.examinationTypeType = value;
        }

        /**
         * Gets the value of the oversightActivitiesRef property.
         * 
         * @return
         *     possible object is
         *     {@link NsiRef }
         *     
         */
        public NsiRef getOversightActivitiesRef() {
            return oversightActivitiesRef;
        }

        /**
         * Sets the value of the oversightActivitiesRef property.
         * 
         * @param value
         *     allowed object is
         *     {@link NsiRef }
         *     
         */
        public void setOversightActivitiesRef(NsiRef value) {
            this.oversightActivitiesRef = value;
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
         * Gets the value of the orderNumber property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getOrderNumber() {
            return orderNumber;
        }

        /**
         * Sets the value of the orderNumber property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setOrderNumber(String value) {
            this.orderNumber = value;
        }

        /**
         * Gets the value of the orderDate property.
         * 
         * @return
         *     possible object is
         *     {@link XMLGregorianCalendar }
         *     
         */
        public XMLGregorianCalendar getOrderDate() {
            return orderDate;
        }

        /**
         * Sets the value of the orderDate property.
         * 
         * @param value
         *     allowed object is
         *     {@link XMLGregorianCalendar }
         *     
         */
        public void setOrderDate(XMLGregorianCalendar value) {
            this.orderDate = value;
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
         *         &lt;element name="Scheduled">
         *           &lt;complexType>
         *             &lt;complexContent>
         *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *                 &lt;sequence>
         *                   &lt;element name="Subject" type="{http://dom.gosuslugi.ru/schema/integration/inspection/}ScheduledExaminationSubjectInfoType"/>
         *                 &lt;/sequence>
         *               &lt;/restriction>
         *             &lt;/complexContent>
         *           &lt;/complexType>
         *         &lt;/element>
         *         &lt;element name="Unscheduled">
         *           &lt;complexType>
         *             &lt;complexContent>
         *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *                 &lt;sequence>
         *                   &lt;element name="Subject" type="{http://dom.gosuslugi.ru/schema/integration/inspection/}UnscheduledExaminationSubjectInfoType"/>
         *                 &lt;/sequence>
         *               &lt;/restriction>
         *             &lt;/complexContent>
         *           &lt;/complexType>
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
            "scheduled",
            "unscheduled"
        })
        public static class ExaminationTypeType {

            @XmlElement(name = "Scheduled")
            protected ExportExaminationType.ExaminationOverview.ExaminationTypeType.Scheduled scheduled;
            @XmlElement(name = "Unscheduled")
            protected ExportExaminationType.ExaminationOverview.ExaminationTypeType.Unscheduled unscheduled;

            /**
             * Gets the value of the scheduled property.
             * 
             * @return
             *     possible object is
             *     {@link ExportExaminationType.ExaminationOverview.ExaminationTypeType.Scheduled }
             *     
             */
            public ExportExaminationType.ExaminationOverview.ExaminationTypeType.Scheduled getScheduled() {
                return scheduled;
            }

            /**
             * Sets the value of the scheduled property.
             * 
             * @param value
             *     allowed object is
             *     {@link ExportExaminationType.ExaminationOverview.ExaminationTypeType.Scheduled }
             *     
             */
            public void setScheduled(ExportExaminationType.ExaminationOverview.ExaminationTypeType.Scheduled value) {
                this.scheduled = value;
            }

            /**
             * Gets the value of the unscheduled property.
             * 
             * @return
             *     possible object is
             *     {@link ExportExaminationType.ExaminationOverview.ExaminationTypeType.Unscheduled }
             *     
             */
            public ExportExaminationType.ExaminationOverview.ExaminationTypeType.Unscheduled getUnscheduled() {
                return unscheduled;
            }

            /**
             * Sets the value of the unscheduled property.
             * 
             * @param value
             *     allowed object is
             *     {@link ExportExaminationType.ExaminationOverview.ExaminationTypeType.Unscheduled }
             *     
             */
            public void setUnscheduled(ExportExaminationType.ExaminationOverview.ExaminationTypeType.Unscheduled value) {
                this.unscheduled = value;
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
             *         &lt;element name="Subject" type="{http://dom.gosuslugi.ru/schema/integration/inspection/}ScheduledExaminationSubjectInfoType"/>
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
                "subject"
            })
            public static class Scheduled {

                @XmlElement(name = "Subject", required = true)
                protected ScheduledExaminationSubjectInfoType subject;

                /**
                 * Gets the value of the subject property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link ScheduledExaminationSubjectInfoType }
                 *     
                 */
                public ScheduledExaminationSubjectInfoType getSubject() {
                    return subject;
                }

                /**
                 * Sets the value of the subject property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link ScheduledExaminationSubjectInfoType }
                 *     
                 */
                public void setSubject(ScheduledExaminationSubjectInfoType value) {
                    this.subject = value;
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
             *         &lt;element name="Subject" type="{http://dom.gosuslugi.ru/schema/integration/inspection/}UnscheduledExaminationSubjectInfoType"/>
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
                "subject"
            })
            public static class Unscheduled {

                @XmlElement(name = "Subject", required = true)
                protected UnscheduledExaminationSubjectInfoType subject;

                /**
                 * Gets the value of the subject property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link UnscheduledExaminationSubjectInfoType }
                 *     
                 */
                public UnscheduledExaminationSubjectInfoType getSubject() {
                    return subject;
                }

                /**
                 * Sets the value of the subject property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link UnscheduledExaminationSubjectInfoType }
                 *     
                 */
                public void setSubject(UnscheduledExaminationSubjectInfoType value) {
                    this.subject = value;
                }

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
     *         &lt;element name="Event" type="{http://dom.gosuslugi.ru/schema/integration/inspection/}ExaminationEventType" maxOccurs="unbounded" minOccurs="0"/>
     *         &lt;element name="Place" type="{http://dom.gosuslugi.ru/schema/integration/inspection/}ExaminationPlaceType" maxOccurs="unbounded" minOccurs="0"/>
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
        "event",
        "place"
    })
    public static class ExecutingInfo {

        @XmlElement(name = "Event")
        protected List<ExaminationEventType> event;
        @XmlElement(name = "Place")
        protected List<ExaminationPlaceType> place;

        /**
         * Gets the value of the event property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the event property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getEvent().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link ExaminationEventType }
         * 
         * 
         */
        public List<ExaminationEventType> getEvent() {
            if (event == null) {
                event = new ArrayList<ExaminationEventType>();
            }
            return this.event;
        }

        /**
         * Gets the value of the place property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the place property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getPlace().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link ExaminationPlaceType }
         * 
         * 
         */
        public List<ExaminationPlaceType> getPlace() {
            if (place == null) {
                place = new ArrayList<ExaminationPlaceType>();
            }
            return this.place;
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
     *       &lt;choice>
     *         &lt;element name="NotRequired" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
     *         &lt;element name="RequiredAndNotSent" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
     *         &lt;sequence>
     *           &lt;element name="NotificationDate" type="{http://www.w3.org/2001/XMLSchema}date"/>
     *           &lt;element name="NotificationMethod" type="{http://dom.gosuslugi.ru/schema/integration/inspection/}String2000Type"/>
     *         &lt;/sequence>
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
        "notRequired",
        "requiredAndNotSent",
        "notificationDate",
        "notificationMethod"
    })
    public static class NotificationInfo {

        @XmlElement(name = "NotRequired")
        protected Boolean notRequired;
        @XmlElement(name = "RequiredAndNotSent")
        protected Boolean requiredAndNotSent;
        @XmlElement(name = "NotificationDate")
        @XmlSchemaType(name = "date")
        protected XMLGregorianCalendar notificationDate;
        @XmlElement(name = "NotificationMethod")
        protected String notificationMethod;

        /**
         * Gets the value of the notRequired property.
         * 
         * @return
         *     possible object is
         *     {@link Boolean }
         *     
         */
        public Boolean isNotRequired() {
            return notRequired;
        }

        /**
         * Sets the value of the notRequired property.
         * 
         * @param value
         *     allowed object is
         *     {@link Boolean }
         *     
         */
        public void setNotRequired(Boolean value) {
            this.notRequired = value;
        }

        /**
         * Gets the value of the requiredAndNotSent property.
         * 
         * @return
         *     possible object is
         *     {@link Boolean }
         *     
         */
        public Boolean isRequiredAndNotSent() {
            return requiredAndNotSent;
        }

        /**
         * Sets the value of the requiredAndNotSent property.
         * 
         * @param value
         *     allowed object is
         *     {@link Boolean }
         *     
         */
        public void setRequiredAndNotSent(Boolean value) {
            this.requiredAndNotSent = value;
        }

        /**
         * Gets the value of the notificationDate property.
         * 
         * @return
         *     possible object is
         *     {@link XMLGregorianCalendar }
         *     
         */
        public XMLGregorianCalendar getNotificationDate() {
            return notificationDate;
        }

        /**
         * Sets the value of the notificationDate property.
         * 
         * @param value
         *     allowed object is
         *     {@link XMLGregorianCalendar }
         *     
         */
        public void setNotificationDate(XMLGregorianCalendar value) {
            this.notificationDate = value;
        }

        /**
         * Gets the value of the notificationMethod property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getNotificationMethod() {
            return notificationMethod;
        }

        /**
         * Sets the value of the notificationMethod property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setNotificationMethod(String value) {
            this.notificationMethod = value;
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
     *         &lt;element name="FunctionRegistryNumber" type="{http://dom.gosuslugi.ru/schema/integration/inspection/}FunctionRegistryNumberType"/>
     *         &lt;element name="AuthorizedPersons" type="{http://dom.gosuslugi.ru/schema/integration/inspection/}String2000Type" minOccurs="0"/>
     *         &lt;element name="InvolvedExperts" type="{http://dom.gosuslugi.ru/schema/integration/inspection/}String2000Type" minOccurs="0"/>
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
        "functionRegistryNumber",
        "authorizedPersons",
        "involvedExperts"
    })
    public static class RegulatoryAuthorityInformation {

        @XmlElement(name = "FunctionRegistryNumber", required = true)
        protected String functionRegistryNumber;
        @XmlElement(name = "AuthorizedPersons")
        protected String authorizedPersons;
        @XmlElement(name = "InvolvedExperts")
        protected String involvedExperts;

        /**
         * Gets the value of the functionRegistryNumber property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getFunctionRegistryNumber() {
            return functionRegistryNumber;
        }

        /**
         * Sets the value of the functionRegistryNumber property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setFunctionRegistryNumber(String value) {
            this.functionRegistryNumber = value;
        }

        /**
         * Gets the value of the authorizedPersons property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getAuthorizedPersons() {
            return authorizedPersons;
        }

        /**
         * Sets the value of the authorizedPersons property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setAuthorizedPersons(String value) {
            this.authorizedPersons = value;
        }

        /**
         * Gets the value of the involvedExperts property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getInvolvedExperts() {
            return involvedExperts;
        }

        /**
         * Sets the value of the involvedExperts property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setInvolvedExperts(String value) {
            this.involvedExperts = value;
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
     *     &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/inspection/}ExportResultsInfoType">
     *       &lt;sequence>
     *         &lt;element name="CancelExaminationResults" type="{http://dom.gosuslugi.ru/schema/integration/inspection/}CancelledInfoWithAttachmentsType" minOccurs="0"/>
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
        "cancelExaminationResults"
    })
    public static class ResultsInfo
        extends ExportResultsInfoType
    {

        @XmlElement(name = "CancelExaminationResults")
        protected CancelledInfoWithAttachmentsType cancelExaminationResults;

        /**
         * Gets the value of the cancelExaminationResults property.
         * 
         * @return
         *     possible object is
         *     {@link CancelledInfoWithAttachmentsType }
         *     
         */
        public CancelledInfoWithAttachmentsType getCancelExaminationResults() {
            return cancelExaminationResults;
        }

        /**
         * Sets the value of the cancelExaminationResults property.
         * 
         * @param value
         *     allowed object is
         *     {@link CancelledInfoWithAttachmentsType }
         *     
         */
        public void setCancelExaminationResults(CancelledInfoWithAttachmentsType value) {
            this.cancelExaminationResults = value;
        }

    }

}
