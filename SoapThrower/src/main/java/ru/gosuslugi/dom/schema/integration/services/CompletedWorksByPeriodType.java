
package ru.gosuslugi.dom.schema.integration.services;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElements;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;
import ru.gosuslugi.dom.schema.integration.base.AttachmentType;
import ru.gosuslugi.dom.schema.integration.nsi_base.NsiRef;
import ru.gosuslugi.dom.schema.integration.organizations_registry_base.RegOrgType;


/**
 * Выполненная работа за период
 * 
 * <p>Java class for CompletedWorksByPeriodType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="CompletedWorksByPeriodType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="reportingPeriodGuid" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType"/>
 *         &lt;element name="PlannedWork" maxOccurs="unbounded" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/services/}CompletedWorkType">
 *                 &lt;sequence>
 *                   &lt;element name="WorkPlanItemGUID" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType"/>
 *                   &lt;element name="plannedCount" type="{http://www.w3.org/2001/XMLSchema}nonNegativeInteger"/>
 *                 &lt;/sequence>
 *               &lt;/extension>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="UnplannedWork" maxOccurs="unbounded" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/services/}CompletedWorkType">
 *                 &lt;sequence>
 *                   &lt;choice minOccurs="0">
 *                     &lt;element name="Accident">
 *                       &lt;complexType>
 *                         &lt;complexContent>
 *                           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                             &lt;sequence>
 *                               &lt;element name="accidentObjectKind" type="{http://dom.gosuslugi.ru/schema/integration/nsi-base/}nsiRef" minOccurs="0"/>
 *                               &lt;element name="accidentReason" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                               &lt;element name="MSType" type="{http://dom.gosuslugi.ru/schema/integration/nsi-base/}nsiRef" minOccurs="0"/>
 *                             &lt;/sequence>
 *                             &lt;attribute name="workType">
 *                               &lt;simpleType>
 *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                                   &lt;enumeration value="3"/>
 *                                 &lt;/restriction>
 *                               &lt;/simpleType>
 *                             &lt;/attribute>
 *                           &lt;/restriction>
 *                         &lt;/complexContent>
 *                       &lt;/complexType>
 *                     &lt;/element>
 *                     &lt;element name="DeliveryRestriction">
 *                       &lt;complexType>
 *                         &lt;complexContent>
 *                           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                             &lt;sequence>
 *                               &lt;element name="MSType" type="{http://dom.gosuslugi.ru/schema/integration/nsi-base/}nsiRef" minOccurs="0"/>
 *                               &lt;element name="OrganizationGUID" type="{http://dom.gosuslugi.ru/schema/integration/organizations-registry-base/}RegOrgType" minOccurs="0"/>
 *                             &lt;/sequence>
 *                             &lt;attribute name="workType">
 *                               &lt;simpleType>
 *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                                   &lt;enumeration value="5"/>
 *                                 &lt;/restriction>
 *                               &lt;/simpleType>
 *                             &lt;/attribute>
 *                           &lt;/restriction>
 *                         &lt;/complexContent>
 *                       &lt;/complexType>
 *                     &lt;/element>
 *                   &lt;/choice>
 *                   &lt;element name="Comment" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="Work" type="{http://dom.gosuslugi.ru/schema/integration/nsi-base/}nsiRef"/>
 *                   &lt;element name="workType" type="{http://dom.gosuslugi.ru/schema/integration/nsi-base/}nsiRef"/>
 *                 &lt;/sequence>
 *               &lt;/extension>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;choice maxOccurs="unbounded" minOccurs="0">
 *           &lt;element name="NewAct">
 *             &lt;complexType>
 *               &lt;complexContent>
 *                 &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/base/}AttachmentType">
 *                   &lt;sequence>
 *                     &lt;element name="Date" type="{http://www.w3.org/2001/XMLSchema}date"/>
 *                     &lt;element name="Number">
 *                       &lt;simpleType>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                           &lt;minLength value="1"/>
 *                           &lt;maxLength value="60"/>
 *                         &lt;/restriction>
 *                       &lt;/simpleType>
 *                     &lt;/element>
 *                     &lt;element name="ContractNumber">
 *                       &lt;simpleType>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                           &lt;minLength value="1"/>
 *                           &lt;maxLength value="60"/>
 *                         &lt;/restriction>
 *                       &lt;/simpleType>
 *                     &lt;/element>
 *                     &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/base/}TransportGUID"/>
 *                   &lt;/sequence>
 *                 &lt;/extension>
 *               &lt;/complexContent>
 *             &lt;/complexType>
 *           &lt;/element>
 *           &lt;element name="ExistedAct">
 *             &lt;complexType>
 *               &lt;complexContent>
 *                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                   &lt;sequence>
 *                     &lt;element name="ActGUID" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType"/>
 *                     &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/base/}TransportGUID"/>
 *                   &lt;/sequence>
 *                 &lt;/restriction>
 *               &lt;/complexContent>
 *             &lt;/complexType>
 *           &lt;/element>
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
@XmlType(name = "CompletedWorksByPeriodType", propOrder = {
    "reportingPeriodGuid",
    "plannedWork",
    "unplannedWork",
    "newActOrExistedAct"
})
public class CompletedWorksByPeriodType {

    @XmlElement(required = true)
    protected String reportingPeriodGuid;
    @XmlElement(name = "PlannedWork")
    protected List<CompletedWorksByPeriodType.PlannedWork> plannedWork;
    @XmlElement(name = "UnplannedWork")
    protected List<CompletedWorksByPeriodType.UnplannedWork> unplannedWork;
    @XmlElements({
        @XmlElement(name = "NewAct", type = CompletedWorksByPeriodType.NewAct.class),
        @XmlElement(name = "ExistedAct", type = CompletedWorksByPeriodType.ExistedAct.class)
    })
    protected List<Object> newActOrExistedAct;

    /**
     * Gets the value of the reportingPeriodGuid property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getReportingPeriodGuid() {
        return reportingPeriodGuid;
    }

    /**
     * Sets the value of the reportingPeriodGuid property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setReportingPeriodGuid(String value) {
        this.reportingPeriodGuid = value;
    }

    /**
     * Gets the value of the plannedWork property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the plannedWork property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPlannedWork().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CompletedWorksByPeriodType.PlannedWork }
     * 
     * 
     */
    public List<CompletedWorksByPeriodType.PlannedWork> getPlannedWork() {
        if (plannedWork == null) {
            plannedWork = new ArrayList<CompletedWorksByPeriodType.PlannedWork>();
        }
        return this.plannedWork;
    }

    /**
     * Gets the value of the unplannedWork property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the unplannedWork property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getUnplannedWork().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CompletedWorksByPeriodType.UnplannedWork }
     * 
     * 
     */
    public List<CompletedWorksByPeriodType.UnplannedWork> getUnplannedWork() {
        if (unplannedWork == null) {
            unplannedWork = new ArrayList<CompletedWorksByPeriodType.UnplannedWork>();
        }
        return this.unplannedWork;
    }

    /**
     * Gets the value of the newActOrExistedAct property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the newActOrExistedAct property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getNewActOrExistedAct().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CompletedWorksByPeriodType.NewAct }
     * {@link CompletedWorksByPeriodType.ExistedAct }
     * 
     * 
     */
    public List<Object> getNewActOrExistedAct() {
        if (newActOrExistedAct == null) {
            newActOrExistedAct = new ArrayList<Object>();
        }
        return this.newActOrExistedAct;
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
     *         &lt;element name="ActGUID" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType"/>
     *         &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/base/}TransportGUID"/>
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
        "actGUID",
        "transportGUID"
    })
    public static class ExistedAct {

        @XmlElement(name = "ActGUID", required = true)
        protected String actGUID;
        @XmlElement(name = "TransportGUID", namespace = "http://dom.gosuslugi.ru/schema/integration/base/", required = true)
        protected String transportGUID;

        /**
         * Gets the value of the actGUID property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getActGUID() {
            return actGUID;
        }

        /**
         * Sets the value of the actGUID property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setActGUID(String value) {
            this.actGUID = value;
        }

        /**
         * Gets the value of the transportGUID property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getTransportGUID() {
            return transportGUID;
        }

        /**
         * Sets the value of the transportGUID property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setTransportGUID(String value) {
            this.transportGUID = value;
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
     *     &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/base/}AttachmentType">
     *       &lt;sequence>
     *         &lt;element name="Date" type="{http://www.w3.org/2001/XMLSchema}date"/>
     *         &lt;element name="Number">
     *           &lt;simpleType>
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *               &lt;minLength value="1"/>
     *               &lt;maxLength value="60"/>
     *             &lt;/restriction>
     *           &lt;/simpleType>
     *         &lt;/element>
     *         &lt;element name="ContractNumber">
     *           &lt;simpleType>
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *               &lt;minLength value="1"/>
     *               &lt;maxLength value="60"/>
     *             &lt;/restriction>
     *           &lt;/simpleType>
     *         &lt;/element>
     *         &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/base/}TransportGUID"/>
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
        "date",
        "number",
        "contractNumber",
        "transportGUID"
    })
    public static class NewAct
        extends AttachmentType
    {

        @XmlElement(name = "Date", required = true)
        @XmlSchemaType(name = "date")
        protected XMLGregorianCalendar date;
        @XmlElement(name = "Number", required = true)
        protected String number;
        @XmlElement(name = "ContractNumber", required = true)
        protected String contractNumber;
        @XmlElement(name = "TransportGUID", namespace = "http://dom.gosuslugi.ru/schema/integration/base/", required = true)
        protected String transportGUID;

        /**
         * Gets the value of the date property.
         * 
         * @return
         *     possible object is
         *     {@link XMLGregorianCalendar }
         *     
         */
        public XMLGregorianCalendar getDate() {
            return date;
        }

        /**
         * Sets the value of the date property.
         * 
         * @param value
         *     allowed object is
         *     {@link XMLGregorianCalendar }
         *     
         */
        public void setDate(XMLGregorianCalendar value) {
            this.date = value;
        }

        /**
         * Gets the value of the number property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getNumber() {
            return number;
        }

        /**
         * Sets the value of the number property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setNumber(String value) {
            this.number = value;
        }

        /**
         * Gets the value of the contractNumber property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getContractNumber() {
            return contractNumber;
        }

        /**
         * Sets the value of the contractNumber property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setContractNumber(String value) {
            this.contractNumber = value;
        }

        /**
         * Gets the value of the transportGUID property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getTransportGUID() {
            return transportGUID;
        }

        /**
         * Sets the value of the transportGUID property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setTransportGUID(String value) {
            this.transportGUID = value;
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
     *     &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/services/}CompletedWorkType">
     *       &lt;sequence>
     *         &lt;element name="WorkPlanItemGUID" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType"/>
     *         &lt;element name="plannedCount" type="{http://www.w3.org/2001/XMLSchema}nonNegativeInteger"/>
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
        "workPlanItemGUID",
        "plannedCount"
    })
    public static class PlannedWork
        extends CompletedWorkType
    {

        @XmlElement(name = "WorkPlanItemGUID", required = true)
        protected String workPlanItemGUID;
        @XmlElement(required = true)
        @XmlSchemaType(name = "nonNegativeInteger")
        protected BigInteger plannedCount;

        /**
         * Gets the value of the workPlanItemGUID property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getWorkPlanItemGUID() {
            return workPlanItemGUID;
        }

        /**
         * Sets the value of the workPlanItemGUID property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setWorkPlanItemGUID(String value) {
            this.workPlanItemGUID = value;
        }

        /**
         * Gets the value of the plannedCount property.
         * 
         * @return
         *     possible object is
         *     {@link BigInteger }
         *     
         */
        public BigInteger getPlannedCount() {
            return plannedCount;
        }

        /**
         * Sets the value of the plannedCount property.
         * 
         * @param value
         *     allowed object is
         *     {@link BigInteger }
         *     
         */
        public void setPlannedCount(BigInteger value) {
            this.plannedCount = value;
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
     *     &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/services/}CompletedWorkType">
     *       &lt;sequence>
     *         &lt;choice minOccurs="0">
     *           &lt;element name="Accident">
     *             &lt;complexType>
     *               &lt;complexContent>
     *                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                   &lt;sequence>
     *                     &lt;element name="accidentObjectKind" type="{http://dom.gosuslugi.ru/schema/integration/nsi-base/}nsiRef" minOccurs="0"/>
     *                     &lt;element name="accidentReason" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                     &lt;element name="MSType" type="{http://dom.gosuslugi.ru/schema/integration/nsi-base/}nsiRef" minOccurs="0"/>
     *                   &lt;/sequence>
     *                   &lt;attribute name="workType">
     *                     &lt;simpleType>
     *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *                         &lt;enumeration value="3"/>
     *                       &lt;/restriction>
     *                     &lt;/simpleType>
     *                   &lt;/attribute>
     *                 &lt;/restriction>
     *               &lt;/complexContent>
     *             &lt;/complexType>
     *           &lt;/element>
     *           &lt;element name="DeliveryRestriction">
     *             &lt;complexType>
     *               &lt;complexContent>
     *                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                   &lt;sequence>
     *                     &lt;element name="MSType" type="{http://dom.gosuslugi.ru/schema/integration/nsi-base/}nsiRef" minOccurs="0"/>
     *                     &lt;element name="OrganizationGUID" type="{http://dom.gosuslugi.ru/schema/integration/organizations-registry-base/}RegOrgType" minOccurs="0"/>
     *                   &lt;/sequence>
     *                   &lt;attribute name="workType">
     *                     &lt;simpleType>
     *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *                         &lt;enumeration value="5"/>
     *                       &lt;/restriction>
     *                     &lt;/simpleType>
     *                   &lt;/attribute>
     *                 &lt;/restriction>
     *               &lt;/complexContent>
     *             &lt;/complexType>
     *           &lt;/element>
     *         &lt;/choice>
     *         &lt;element name="Comment" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="Work" type="{http://dom.gosuslugi.ru/schema/integration/nsi-base/}nsiRef"/>
     *         &lt;element name="workType" type="{http://dom.gosuslugi.ru/schema/integration/nsi-base/}nsiRef"/>
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
        "accident",
        "deliveryRestriction",
        "comment",
        "work",
        "workType"
    })
    public static class UnplannedWork
        extends CompletedWorkType
    {

        @XmlElement(name = "Accident")
        protected CompletedWorksByPeriodType.UnplannedWork.Accident accident;
        @XmlElement(name = "DeliveryRestriction")
        protected CompletedWorksByPeriodType.UnplannedWork.DeliveryRestriction deliveryRestriction;
        @XmlElement(name = "Comment")
        protected String comment;
        @XmlElement(name = "Work", required = true)
        protected NsiRef work;
        @XmlElement(required = true)
        protected NsiRef workType;

        /**
         * Gets the value of the accident property.
         * 
         * @return
         *     possible object is
         *     {@link CompletedWorksByPeriodType.UnplannedWork.Accident }
         *     
         */
        public CompletedWorksByPeriodType.UnplannedWork.Accident getAccident() {
            return accident;
        }

        /**
         * Sets the value of the accident property.
         * 
         * @param value
         *     allowed object is
         *     {@link CompletedWorksByPeriodType.UnplannedWork.Accident }
         *     
         */
        public void setAccident(CompletedWorksByPeriodType.UnplannedWork.Accident value) {
            this.accident = value;
        }

        /**
         * Gets the value of the deliveryRestriction property.
         * 
         * @return
         *     possible object is
         *     {@link CompletedWorksByPeriodType.UnplannedWork.DeliveryRestriction }
         *     
         */
        public CompletedWorksByPeriodType.UnplannedWork.DeliveryRestriction getDeliveryRestriction() {
            return deliveryRestriction;
        }

        /**
         * Sets the value of the deliveryRestriction property.
         * 
         * @param value
         *     allowed object is
         *     {@link CompletedWorksByPeriodType.UnplannedWork.DeliveryRestriction }
         *     
         */
        public void setDeliveryRestriction(CompletedWorksByPeriodType.UnplannedWork.DeliveryRestriction value) {
            this.deliveryRestriction = value;
        }

        /**
         * Gets the value of the comment property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getComment() {
            return comment;
        }

        /**
         * Sets the value of the comment property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setComment(String value) {
            this.comment = value;
        }

        /**
         * Gets the value of the work property.
         * 
         * @return
         *     possible object is
         *     {@link NsiRef }
         *     
         */
        public NsiRef getWork() {
            return work;
        }

        /**
         * Sets the value of the work property.
         * 
         * @param value
         *     allowed object is
         *     {@link NsiRef }
         *     
         */
        public void setWork(NsiRef value) {
            this.work = value;
        }

        /**
         * Gets the value of the workType property.
         * 
         * @return
         *     possible object is
         *     {@link NsiRef }
         *     
         */
        public NsiRef getWorkType() {
            return workType;
        }

        /**
         * Sets the value of the workType property.
         * 
         * @param value
         *     allowed object is
         *     {@link NsiRef }
         *     
         */
        public void setWorkType(NsiRef value) {
            this.workType = value;
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
         *         &lt;element name="accidentObjectKind" type="{http://dom.gosuslugi.ru/schema/integration/nsi-base/}nsiRef" minOccurs="0"/>
         *         &lt;element name="accidentReason" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="MSType" type="{http://dom.gosuslugi.ru/schema/integration/nsi-base/}nsiRef" minOccurs="0"/>
         *       &lt;/sequence>
         *       &lt;attribute name="workType">
         *         &lt;simpleType>
         *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
         *             &lt;enumeration value="3"/>
         *           &lt;/restriction>
         *         &lt;/simpleType>
         *       &lt;/attribute>
         *     &lt;/restriction>
         *   &lt;/complexContent>
         * &lt;/complexType>
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
            "accidentObjectKind",
            "accidentReason",
            "msType"
        })
        public static class Accident {

            protected NsiRef accidentObjectKind;
            protected String accidentReason;
            @XmlElement(name = "MSType")
            protected NsiRef msType;
            @XmlAttribute(name = "workType")
            protected String workType;

            /**
             * Gets the value of the accidentObjectKind property.
             * 
             * @return
             *     possible object is
             *     {@link NsiRef }
             *     
             */
            public NsiRef getAccidentObjectKind() {
                return accidentObjectKind;
            }

            /**
             * Sets the value of the accidentObjectKind property.
             * 
             * @param value
             *     allowed object is
             *     {@link NsiRef }
             *     
             */
            public void setAccidentObjectKind(NsiRef value) {
                this.accidentObjectKind = value;
            }

            /**
             * Gets the value of the accidentReason property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getAccidentReason() {
                return accidentReason;
            }

            /**
             * Sets the value of the accidentReason property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setAccidentReason(String value) {
                this.accidentReason = value;
            }

            /**
             * Gets the value of the msType property.
             * 
             * @return
             *     possible object is
             *     {@link NsiRef }
             *     
             */
            public NsiRef getMSType() {
                return msType;
            }

            /**
             * Sets the value of the msType property.
             * 
             * @param value
             *     allowed object is
             *     {@link NsiRef }
             *     
             */
            public void setMSType(NsiRef value) {
                this.msType = value;
            }

            /**
             * Gets the value of the workType property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getWorkType() {
                return workType;
            }

            /**
             * Sets the value of the workType property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setWorkType(String value) {
                this.workType = value;
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
         *         &lt;element name="MSType" type="{http://dom.gosuslugi.ru/schema/integration/nsi-base/}nsiRef" minOccurs="0"/>
         *         &lt;element name="OrganizationGUID" type="{http://dom.gosuslugi.ru/schema/integration/organizations-registry-base/}RegOrgType" minOccurs="0"/>
         *       &lt;/sequence>
         *       &lt;attribute name="workType">
         *         &lt;simpleType>
         *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
         *             &lt;enumeration value="5"/>
         *           &lt;/restriction>
         *         &lt;/simpleType>
         *       &lt;/attribute>
         *     &lt;/restriction>
         *   &lt;/complexContent>
         * &lt;/complexType>
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
            "msType",
            "organizationGUID"
        })
        public static class DeliveryRestriction {

            @XmlElement(name = "MSType")
            protected NsiRef msType;
            @XmlElement(name = "OrganizationGUID")
            protected RegOrgType organizationGUID;
            @XmlAttribute(name = "workType")
            protected String workType;

            /**
             * Gets the value of the msType property.
             * 
             * @return
             *     possible object is
             *     {@link NsiRef }
             *     
             */
            public NsiRef getMSType() {
                return msType;
            }

            /**
             * Sets the value of the msType property.
             * 
             * @param value
             *     allowed object is
             *     {@link NsiRef }
             *     
             */
            public void setMSType(NsiRef value) {
                this.msType = value;
            }

            /**
             * Gets the value of the organizationGUID property.
             * 
             * @return
             *     possible object is
             *     {@link RegOrgType }
             *     
             */
            public RegOrgType getOrganizationGUID() {
                return organizationGUID;
            }

            /**
             * Sets the value of the organizationGUID property.
             * 
             * @param value
             *     allowed object is
             *     {@link RegOrgType }
             *     
             */
            public void setOrganizationGUID(RegOrgType value) {
                this.organizationGUID = value;
            }

            /**
             * Gets the value of the workType property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getWorkType() {
                return workType;
            }

            /**
             * Sets the value of the workType property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setWorkType(String value) {
                this.workType = value;
            }

        }

    }

}
