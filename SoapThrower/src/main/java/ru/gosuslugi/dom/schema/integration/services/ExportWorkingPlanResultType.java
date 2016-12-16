
package ru.gosuslugi.dom.schema.integration.services;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;
import ru.gosuslugi.dom.schema.integration.nsi_base.NsiRef;


/**
 * <p>Java class for exportWorkingPlanResultType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="exportWorkingPlanResultType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="WorkingPlan">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="WorkListGUID" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType"/>
 *                   &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/base/}Year"/>
 *                   &lt;element name="FIASHouseGuid" type="{http://dom.gosuslugi.ru/schema/integration/premises-base/}FIASHouseGUIDType"/>
 *                   &lt;element name="ReportingPeriod" maxOccurs="12">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="reportingPeriodGuid" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType"/>
 *                             &lt;element name="MonthYear">
 *                               &lt;complexType>
 *                                 &lt;complexContent>
 *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                     &lt;sequence>
 *                                       &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/base/}Month"/>
 *                                       &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/base/}Year"/>
 *                                     &lt;/sequence>
 *                                   &lt;/restriction>
 *                                 &lt;/complexContent>
 *                               &lt;/complexType>
 *                             &lt;/element>
 *                             &lt;element name="WorkPlanItem" maxOccurs="unbounded" minOccurs="0">
 *                               &lt;complexType>
 *                                 &lt;complexContent>
 *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                     &lt;sequence>
 *                                       &lt;element name="WorkPlanItemGUID" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType"/>
 *                                       &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/base/}ModificationDate"/>
 *                                       &lt;element name="WorkGUID" type="{http://dom.gosuslugi.ru/schema/integration/nsi-base/}nsiRef"/>
 *                                       &lt;element name="workTypeGUID" type="{http://dom.gosuslugi.ru/schema/integration/nsi-base/}nsiRef" minOccurs="0"/>
 *                                       &lt;element name="sortIndex" type="{http://www.w3.org/2001/XMLSchema}nonNegativeInteger" minOccurs="0"/>
 *                                       &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/base/}OKEI" minOccurs="0"/>
 *                                       &lt;choice>
 *                                         &lt;element name="WorkDate" type="{http://www.w3.org/2001/XMLSchema}date" maxOccurs="unbounded" minOccurs="0"/>
 *                                         &lt;element name="WorkCount" type="{http://www.w3.org/2001/XMLSchema}nonNegativeInteger"/>
 *                                       &lt;/choice>
 *                                     &lt;/sequence>
 *                                   &lt;/restriction>
 *                                 &lt;/complexContent>
 *                               &lt;/complexType>
 *                             &lt;/element>
 *                           &lt;/sequence>
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
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
@XmlType(name = "exportWorkingPlanResultType", propOrder = {
    "workingPlan"
})
public class ExportWorkingPlanResultType {

    @XmlElement(name = "WorkingPlan", required = true)
    protected ExportWorkingPlanResultType.WorkingPlan workingPlan;

    /**
     * Gets the value of the workingPlan property.
     * 
     * @return
     *     possible object is
     *     {@link ExportWorkingPlanResultType.WorkingPlan }
     *     
     */
    public ExportWorkingPlanResultType.WorkingPlan getWorkingPlan() {
        return workingPlan;
    }

    /**
     * Sets the value of the workingPlan property.
     * 
     * @param value
     *     allowed object is
     *     {@link ExportWorkingPlanResultType.WorkingPlan }
     *     
     */
    public void setWorkingPlan(ExportWorkingPlanResultType.WorkingPlan value) {
        this.workingPlan = value;
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
     *         &lt;element name="WorkListGUID" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType"/>
     *         &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/base/}Year"/>
     *         &lt;element name="FIASHouseGuid" type="{http://dom.gosuslugi.ru/schema/integration/premises-base/}FIASHouseGUIDType"/>
     *         &lt;element name="ReportingPeriod" maxOccurs="12">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element name="reportingPeriodGuid" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType"/>
     *                   &lt;element name="MonthYear">
     *                     &lt;complexType>
     *                       &lt;complexContent>
     *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                           &lt;sequence>
     *                             &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/base/}Month"/>
     *                             &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/base/}Year"/>
     *                           &lt;/sequence>
     *                         &lt;/restriction>
     *                       &lt;/complexContent>
     *                     &lt;/complexType>
     *                   &lt;/element>
     *                   &lt;element name="WorkPlanItem" maxOccurs="unbounded" minOccurs="0">
     *                     &lt;complexType>
     *                       &lt;complexContent>
     *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                           &lt;sequence>
     *                             &lt;element name="WorkPlanItemGUID" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType"/>
     *                             &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/base/}ModificationDate"/>
     *                             &lt;element name="WorkGUID" type="{http://dom.gosuslugi.ru/schema/integration/nsi-base/}nsiRef"/>
     *                             &lt;element name="workTypeGUID" type="{http://dom.gosuslugi.ru/schema/integration/nsi-base/}nsiRef" minOccurs="0"/>
     *                             &lt;element name="sortIndex" type="{http://www.w3.org/2001/XMLSchema}nonNegativeInteger" minOccurs="0"/>
     *                             &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/base/}OKEI" minOccurs="0"/>
     *                             &lt;choice>
     *                               &lt;element name="WorkDate" type="{http://www.w3.org/2001/XMLSchema}date" maxOccurs="unbounded" minOccurs="0"/>
     *                               &lt;element name="WorkCount" type="{http://www.w3.org/2001/XMLSchema}nonNegativeInteger"/>
     *                             &lt;/choice>
     *                           &lt;/sequence>
     *                         &lt;/restriction>
     *                       &lt;/complexContent>
     *                     &lt;/complexType>
     *                   &lt;/element>
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
    @XmlType(name = "", propOrder = {
        "workListGUID",
        "year",
        "fiasHouseGuid",
        "reportingPeriod"
    })
    public static class WorkingPlan {

        @XmlElement(name = "WorkListGUID", required = true)
        protected String workListGUID;
        @XmlElement(name = "Year", namespace = "http://dom.gosuslugi.ru/schema/integration/base/")
        protected short year;
        @XmlElement(name = "FIASHouseGuid", required = true)
        protected String fiasHouseGuid;
        @XmlElement(name = "ReportingPeriod", required = true)
        protected List<ExportWorkingPlanResultType.WorkingPlan.ReportingPeriod> reportingPeriod;

        /**
         * Gets the value of the workListGUID property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getWorkListGUID() {
            return workListGUID;
        }

        /**
         * Sets the value of the workListGUID property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setWorkListGUID(String value) {
            this.workListGUID = value;
        }

        /**
         * Год в рамках периода перечня
         * 
         */
        public short getYear() {
            return year;
        }

        /**
         * Sets the value of the year property.
         * 
         */
        public void setYear(short value) {
            this.year = value;
        }

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
         * Gets the value of the reportingPeriod property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the reportingPeriod property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getReportingPeriod().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link ExportWorkingPlanResultType.WorkingPlan.ReportingPeriod }
         * 
         * 
         */
        public List<ExportWorkingPlanResultType.WorkingPlan.ReportingPeriod> getReportingPeriod() {
            if (reportingPeriod == null) {
                reportingPeriod = new ArrayList<ExportWorkingPlanResultType.WorkingPlan.ReportingPeriod>();
            }
            return this.reportingPeriod;
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
         *         &lt;element name="reportingPeriodGuid" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType"/>
         *         &lt;element name="MonthYear">
         *           &lt;complexType>
         *             &lt;complexContent>
         *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *                 &lt;sequence>
         *                   &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/base/}Month"/>
         *                   &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/base/}Year"/>
         *                 &lt;/sequence>
         *               &lt;/restriction>
         *             &lt;/complexContent>
         *           &lt;/complexType>
         *         &lt;/element>
         *         &lt;element name="WorkPlanItem" maxOccurs="unbounded" minOccurs="0">
         *           &lt;complexType>
         *             &lt;complexContent>
         *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *                 &lt;sequence>
         *                   &lt;element name="WorkPlanItemGUID" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType"/>
         *                   &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/base/}ModificationDate"/>
         *                   &lt;element name="WorkGUID" type="{http://dom.gosuslugi.ru/schema/integration/nsi-base/}nsiRef"/>
         *                   &lt;element name="workTypeGUID" type="{http://dom.gosuslugi.ru/schema/integration/nsi-base/}nsiRef" minOccurs="0"/>
         *                   &lt;element name="sortIndex" type="{http://www.w3.org/2001/XMLSchema}nonNegativeInteger" minOccurs="0"/>
         *                   &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/base/}OKEI" minOccurs="0"/>
         *                   &lt;choice>
         *                     &lt;element name="WorkDate" type="{http://www.w3.org/2001/XMLSchema}date" maxOccurs="unbounded" minOccurs="0"/>
         *                     &lt;element name="WorkCount" type="{http://www.w3.org/2001/XMLSchema}nonNegativeInteger"/>
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
        @XmlType(name = "", propOrder = {
            "reportingPeriodGuid",
            "monthYear",
            "workPlanItem"
        })
        public static class ReportingPeriod {

            @XmlElement(required = true)
            protected String reportingPeriodGuid;
            @XmlElement(name = "MonthYear", required = true)
            protected ExportWorkingPlanResultType.WorkingPlan.ReportingPeriod.MonthYear monthYear;
            @XmlElement(name = "WorkPlanItem")
            protected List<ExportWorkingPlanResultType.WorkingPlan.ReportingPeriod.WorkPlanItem> workPlanItem;

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
             * Gets the value of the monthYear property.
             * 
             * @return
             *     possible object is
             *     {@link ExportWorkingPlanResultType.WorkingPlan.ReportingPeriod.MonthYear }
             *     
             */
            public ExportWorkingPlanResultType.WorkingPlan.ReportingPeriod.MonthYear getMonthYear() {
                return monthYear;
            }

            /**
             * Sets the value of the monthYear property.
             * 
             * @param value
             *     allowed object is
             *     {@link ExportWorkingPlanResultType.WorkingPlan.ReportingPeriod.MonthYear }
             *     
             */
            public void setMonthYear(ExportWorkingPlanResultType.WorkingPlan.ReportingPeriod.MonthYear value) {
                this.monthYear = value;
            }

            /**
             * Gets the value of the workPlanItem property.
             * 
             * <p>
             * This accessor method returns a reference to the live list,
             * not a snapshot. Therefore any modification you make to the
             * returned list will be present inside the JAXB object.
             * This is why there is not a <CODE>set</CODE> method for the workPlanItem property.
             * 
             * <p>
             * For example, to add a new item, do as follows:
             * <pre>
             *    getWorkPlanItem().add(newItem);
             * </pre>
             * 
             * 
             * <p>
             * Objects of the following type(s) are allowed in the list
             * {@link ExportWorkingPlanResultType.WorkingPlan.ReportingPeriod.WorkPlanItem }
             * 
             * 
             */
            public List<ExportWorkingPlanResultType.WorkingPlan.ReportingPeriod.WorkPlanItem> getWorkPlanItem() {
                if (workPlanItem == null) {
                    workPlanItem = new ArrayList<ExportWorkingPlanResultType.WorkingPlan.ReportingPeriod.WorkPlanItem>();
                }
                return this.workPlanItem;
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
             *         &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/base/}Month"/>
             *         &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/base/}Year"/>
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
                "month",
                "year"
            })
            public static class MonthYear {

                @XmlElement(name = "Month", namespace = "http://dom.gosuslugi.ru/schema/integration/base/")
                protected int month;
                @XmlElement(name = "Year", namespace = "http://dom.gosuslugi.ru/schema/integration/base/")
                protected short year;

                /**
                 * Gets the value of the month property.
                 * 
                 */
                public int getMonth() {
                    return month;
                }

                /**
                 * Sets the value of the month property.
                 * 
                 */
                public void setMonth(int value) {
                    this.month = value;
                }

                /**
                 * Gets the value of the year property.
                 * 
                 */
                public short getYear() {
                    return year;
                }

                /**
                 * Sets the value of the year property.
                 * 
                 */
                public void setYear(short value) {
                    this.year = value;
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
             *         &lt;element name="WorkPlanItemGUID" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType"/>
             *         &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/base/}ModificationDate"/>
             *         &lt;element name="WorkGUID" type="{http://dom.gosuslugi.ru/schema/integration/nsi-base/}nsiRef"/>
             *         &lt;element name="workTypeGUID" type="{http://dom.gosuslugi.ru/schema/integration/nsi-base/}nsiRef" minOccurs="0"/>
             *         &lt;element name="sortIndex" type="{http://www.w3.org/2001/XMLSchema}nonNegativeInteger" minOccurs="0"/>
             *         &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/base/}OKEI" minOccurs="0"/>
             *         &lt;choice>
             *           &lt;element name="WorkDate" type="{http://www.w3.org/2001/XMLSchema}date" maxOccurs="unbounded" minOccurs="0"/>
             *           &lt;element name="WorkCount" type="{http://www.w3.org/2001/XMLSchema}nonNegativeInteger"/>
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
                "workPlanItemGUID",
                "modificationDate",
                "workGUID",
                "workTypeGUID",
                "sortIndex",
                "okei",
                "workDate",
                "workCount"
            })
            public static class WorkPlanItem {

                @XmlElement(name = "WorkPlanItemGUID", required = true)
                protected String workPlanItemGUID;
                @XmlElement(name = "ModificationDate", namespace = "http://dom.gosuslugi.ru/schema/integration/base/", required = true)
                @XmlSchemaType(name = "dateTime")
                protected XMLGregorianCalendar modificationDate;
                @XmlElement(name = "WorkGUID", required = true)
                protected NsiRef workGUID;
                protected NsiRef workTypeGUID;
                @XmlSchemaType(name = "nonNegativeInteger")
                protected BigInteger sortIndex;
                @XmlElement(name = "OKEI", namespace = "http://dom.gosuslugi.ru/schema/integration/base/")
                protected String okei;
                @XmlElement(name = "WorkDate")
                @XmlSchemaType(name = "date")
                protected List<XMLGregorianCalendar> workDate;
                @XmlElement(name = "WorkCount")
                @XmlSchemaType(name = "nonNegativeInteger")
                protected BigInteger workCount;

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
                 * Gets the value of the modificationDate property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link XMLGregorianCalendar }
                 *     
                 */
                public XMLGregorianCalendar getModificationDate() {
                    return modificationDate;
                }

                /**
                 * Sets the value of the modificationDate property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link XMLGregorianCalendar }
                 *     
                 */
                public void setModificationDate(XMLGregorianCalendar value) {
                    this.modificationDate = value;
                }

                /**
                 * Gets the value of the workGUID property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link NsiRef }
                 *     
                 */
                public NsiRef getWorkGUID() {
                    return workGUID;
                }

                /**
                 * Sets the value of the workGUID property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link NsiRef }
                 *     
                 */
                public void setWorkGUID(NsiRef value) {
                    this.workGUID = value;
                }

                /**
                 * Gets the value of the workTypeGUID property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link NsiRef }
                 *     
                 */
                public NsiRef getWorkTypeGUID() {
                    return workTypeGUID;
                }

                /**
                 * Sets the value of the workTypeGUID property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link NsiRef }
                 *     
                 */
                public void setWorkTypeGUID(NsiRef value) {
                    this.workTypeGUID = value;
                }

                /**
                 * Gets the value of the sortIndex property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link BigInteger }
                 *     
                 */
                public BigInteger getSortIndex() {
                    return sortIndex;
                }

                /**
                 * Sets the value of the sortIndex property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link BigInteger }
                 *     
                 */
                public void setSortIndex(BigInteger value) {
                    this.sortIndex = value;
                }

                /**
                 * Gets the value of the okei property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getOKEI() {
                    return okei;
                }

                /**
                 * Sets the value of the okei property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setOKEI(String value) {
                    this.okei = value;
                }

                /**
                 * Gets the value of the workDate property.
                 * 
                 * <p>
                 * This accessor method returns a reference to the live list,
                 * not a snapshot. Therefore any modification you make to the
                 * returned list will be present inside the JAXB object.
                 * This is why there is not a <CODE>set</CODE> method for the workDate property.
                 * 
                 * <p>
                 * For example, to add a new item, do as follows:
                 * <pre>
                 *    getWorkDate().add(newItem);
                 * </pre>
                 * 
                 * 
                 * <p>
                 * Objects of the following type(s) are allowed in the list
                 * {@link XMLGregorianCalendar }
                 * 
                 * 
                 */
                public List<XMLGregorianCalendar> getWorkDate() {
                    if (workDate == null) {
                        workDate = new ArrayList<XMLGregorianCalendar>();
                    }
                    return this.workDate;
                }

                /**
                 * Gets the value of the workCount property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link BigInteger }
                 *     
                 */
                public BigInteger getWorkCount() {
                    return workCount;
                }

                /**
                 * Sets the value of the workCount property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link BigInteger }
                 *     
                 */
                public void setWorkCount(BigInteger value) {
                    this.workCount = value;
                }

            }

        }

    }

}
