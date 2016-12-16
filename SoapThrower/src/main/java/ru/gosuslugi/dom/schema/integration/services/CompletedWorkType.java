
package ru.gosuslugi.dom.schema.integration.services;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;
import ru.gosuslugi.dom.schema.integration.base.AttachmentType;


/**
 * Базовый тип выполненной работы
 * 
 * <p>Java class for CompletedWorkType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="CompletedWorkType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="photos" type="{http://dom.gosuslugi.ru/schema/integration/base/}AttachmentType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="MonthlyWork">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="count" type="{http://www.w3.org/2001/XMLSchema}nonNegativeInteger"/>
 *                   &lt;element name="WorkDate" type="{http://www.w3.org/2001/XMLSchema}date" maxOccurs="unbounded" minOccurs="0"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;choice>
 *           &lt;element name="ActTransportGUID" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType" minOccurs="0"/>
 *           &lt;element name="ActGUID" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType" minOccurs="0"/>
 *         &lt;/choice>
 *         &lt;element name="TotalCost" type="{http://dom.gosuslugi.ru/schema/integration/services/}WorkCostType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CompletedWorkType", propOrder = {
    "photos",
    "monthlyWork",
    "actTransportGUID",
    "actGUID",
    "totalCost"
})
@XmlSeeAlso({
    ru.gosuslugi.dom.schema.integration.services.CompletedWorksByPeriodType.PlannedWork.class,
    ru.gosuslugi.dom.schema.integration.services.CompletedWorksByPeriodType.UnplannedWork.class,
    ru.gosuslugi.dom.schema.integration.services.CompletedWorksByPeriodExportType.UnplannedWork.class
})
public class CompletedWorkType {

    protected List<AttachmentType> photos;
    @XmlElement(name = "MonthlyWork", required = true)
    protected CompletedWorkType.MonthlyWork monthlyWork;
    @XmlElement(name = "ActTransportGUID")
    protected String actTransportGUID;
    @XmlElement(name = "ActGUID")
    protected String actGUID;
    @XmlElement(name = "TotalCost")
    protected BigDecimal totalCost;

    /**
     * Gets the value of the photos property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the photos property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPhotos().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link AttachmentType }
     * 
     * 
     */
    public List<AttachmentType> getPhotos() {
        if (photos == null) {
            photos = new ArrayList<AttachmentType>();
        }
        return this.photos;
    }

    /**
     * Gets the value of the monthlyWork property.
     * 
     * @return
     *     possible object is
     *     {@link CompletedWorkType.MonthlyWork }
     *     
     */
    public CompletedWorkType.MonthlyWork getMonthlyWork() {
        return monthlyWork;
    }

    /**
     * Sets the value of the monthlyWork property.
     * 
     * @param value
     *     allowed object is
     *     {@link CompletedWorkType.MonthlyWork }
     *     
     */
    public void setMonthlyWork(CompletedWorkType.MonthlyWork value) {
        this.monthlyWork = value;
    }

    /**
     * Gets the value of the actTransportGUID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getActTransportGUID() {
        return actTransportGUID;
    }

    /**
     * Sets the value of the actTransportGUID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setActTransportGUID(String value) {
        this.actTransportGUID = value;
    }

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
     * Gets the value of the totalCost property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getTotalCost() {
        return totalCost;
    }

    /**
     * Sets the value of the totalCost property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setTotalCost(BigDecimal value) {
        this.totalCost = value;
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
     *         &lt;element name="count" type="{http://www.w3.org/2001/XMLSchema}nonNegativeInteger"/>
     *         &lt;element name="WorkDate" type="{http://www.w3.org/2001/XMLSchema}date" maxOccurs="unbounded" minOccurs="0"/>
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
        "count",
        "workDate"
    })
    public static class MonthlyWork {

        @XmlElement(required = true)
        @XmlSchemaType(name = "nonNegativeInteger")
        protected BigInteger count;
        @XmlElement(name = "WorkDate")
        @XmlSchemaType(name = "date")
        protected List<XMLGregorianCalendar> workDate;

        /**
         * Gets the value of the count property.
         * 
         * @return
         *     possible object is
         *     {@link BigInteger }
         *     
         */
        public BigInteger getCount() {
            return count;
        }

        /**
         * Sets the value of the count property.
         * 
         * @param value
         *     allowed object is
         *     {@link BigInteger }
         *     
         */
        public void setCount(BigInteger value) {
            this.count = value;
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

    }

}
