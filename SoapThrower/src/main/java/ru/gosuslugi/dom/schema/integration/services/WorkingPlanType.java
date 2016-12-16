
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


/**
 * План по перечню работ/услуг
 * 
 * <p>Java class for WorkingPlanType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="WorkingPlanType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="WorkListGUID" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType"/>
 *         &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/base/}Year"/>
 *         &lt;element name="WorkPlanItem" maxOccurs="unbounded">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="WorkListItemGUID" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType"/>
 *                   &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/base/}Month"/>
 *                   &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/base/}Year"/>
 *                   &lt;choice>
 *                     &lt;element name="WorkDate" type="{http://www.w3.org/2001/XMLSchema}date" maxOccurs="unbounded"/>
 *                     &lt;sequence>
 *                       &lt;element name="WorkCount" type="{http://www.w3.org/2001/XMLSchema}nonNegativeInteger"/>
 *                     &lt;/sequence>
 *                   &lt;/choice>
 *                   &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/base/}TransportGUID"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
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
@XmlType(name = "WorkingPlanType", propOrder = {
    "workListGUID",
    "year",
    "workPlanItem",
    "transportGUID"
})
public class WorkingPlanType {

    @XmlElement(name = "WorkListGUID", required = true)
    protected String workListGUID;
    @XmlElement(name = "Year", namespace = "http://dom.gosuslugi.ru/schema/integration/base/")
    protected short year;
    @XmlElement(name = "WorkPlanItem", required = true)
    protected List<WorkingPlanType.WorkPlanItem> workPlanItem;
    @XmlElement(name = "TransportGUID", namespace = "http://dom.gosuslugi.ru/schema/integration/base/", required = true)
    protected String transportGUID;

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
     * {@link WorkingPlanType.WorkPlanItem }
     * 
     * 
     */
    public List<WorkingPlanType.WorkPlanItem> getWorkPlanItem() {
        if (workPlanItem == null) {
            workPlanItem = new ArrayList<WorkingPlanType.WorkPlanItem>();
        }
        return this.workPlanItem;
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
     *         &lt;element name="WorkListItemGUID" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType"/>
     *         &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/base/}Month"/>
     *         &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/base/}Year"/>
     *         &lt;choice>
     *           &lt;element name="WorkDate" type="{http://www.w3.org/2001/XMLSchema}date" maxOccurs="unbounded"/>
     *           &lt;sequence>
     *             &lt;element name="WorkCount" type="{http://www.w3.org/2001/XMLSchema}nonNegativeInteger"/>
     *           &lt;/sequence>
     *         &lt;/choice>
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
        "workListItemGUID",
        "month",
        "year",
        "workDate",
        "workCount",
        "transportGUID"
    })
    public static class WorkPlanItem {

        @XmlElement(name = "WorkListItemGUID", required = true)
        protected String workListItemGUID;
        @XmlElement(name = "Month", namespace = "http://dom.gosuslugi.ru/schema/integration/base/")
        protected int month;
        @XmlElement(name = "Year", namespace = "http://dom.gosuslugi.ru/schema/integration/base/")
        protected short year;
        @XmlElement(name = "WorkDate")
        @XmlSchemaType(name = "date")
        protected List<XMLGregorianCalendar> workDate;
        @XmlElement(name = "WorkCount")
        @XmlSchemaType(name = "nonNegativeInteger")
        protected BigInteger workCount;
        @XmlElement(name = "TransportGUID", namespace = "http://dom.gosuslugi.ru/schema/integration/base/", required = true)
        protected String transportGUID;

        /**
         * Gets the value of the workListItemGUID property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getWorkListItemGUID() {
            return workListItemGUID;
        }

        /**
         * Sets the value of the workListItemGUID property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setWorkListItemGUID(String value) {
            this.workListItemGUID = value;
        }

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

}
