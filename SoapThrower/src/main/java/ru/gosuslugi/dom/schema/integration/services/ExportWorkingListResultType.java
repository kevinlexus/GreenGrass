
package ru.gosuslugi.dom.schema.integration.services;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for exportWorkingListResultType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="exportWorkingListResultType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="WorkingList">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/services/}WorkingListBaseType">
 *                 &lt;sequence>
 *                   &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/base/}ModificationDate"/>
 *                   &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/services/}WorkListStatus"/>
 *                   &lt;element name="WorkListItem" maxOccurs="unbounded">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/services/}WorkingListItemType">
 *                           &lt;sequence>
 *                             &lt;element name="WorkListItemGUID" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType"/>
 *                           &lt;/sequence>
 *                         &lt;/extension>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                 &lt;/sequence>
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
@XmlType(name = "exportWorkingListResultType", propOrder = {
    "workingList"
})
public class ExportWorkingListResultType {

    @XmlElement(name = "WorkingList", required = true)
    protected ExportWorkingListResultType.WorkingList workingList;

    /**
     * Gets the value of the workingList property.
     * 
     * @return
     *     possible object is
     *     {@link ExportWorkingListResultType.WorkingList }
     *     
     */
    public ExportWorkingListResultType.WorkingList getWorkingList() {
        return workingList;
    }

    /**
     * Sets the value of the workingList property.
     * 
     * @param value
     *     allowed object is
     *     {@link ExportWorkingListResultType.WorkingList }
     *     
     */
    public void setWorkingList(ExportWorkingListResultType.WorkingList value) {
        this.workingList = value;
    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/services/}WorkingListBaseType">
     *       &lt;sequence>
     *         &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/base/}ModificationDate"/>
     *         &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/services/}WorkListStatus"/>
     *         &lt;element name="WorkListItem" maxOccurs="unbounded">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/services/}WorkingListItemType">
     *                 &lt;sequence>
     *                   &lt;element name="WorkListItemGUID" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType"/>
     *                 &lt;/sequence>
     *               &lt;/extension>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
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
        "modificationDate",
        "workListStatus",
        "workListItem"
    })
    public static class WorkingList
        extends WorkingListBaseType
    {

        @XmlElement(name = "ModificationDate", namespace = "http://dom.gosuslugi.ru/schema/integration/base/", required = true)
        @XmlSchemaType(name = "dateTime")
        protected XMLGregorianCalendar modificationDate;
        @XmlElement(name = "WorkListStatus", required = true)
        protected String workListStatus;
        @XmlElement(name = "WorkListItem", required = true)
        protected List<ExportWorkingListResultType.WorkingList.WorkListItem> workListItem;

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
         * Gets the value of the workListStatus property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getWorkListStatus() {
            return workListStatus;
        }

        /**
         * Sets the value of the workListStatus property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setWorkListStatus(String value) {
            this.workListStatus = value;
        }

        /**
         * Gets the value of the workListItem property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the workListItem property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getWorkListItem().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link ExportWorkingListResultType.WorkingList.WorkListItem }
         * 
         * 
         */
        public List<ExportWorkingListResultType.WorkingList.WorkListItem> getWorkListItem() {
            if (workListItem == null) {
                workListItem = new ArrayList<ExportWorkingListResultType.WorkingList.WorkListItem>();
            }
            return this.workListItem;
        }


        /**
         * <p>Java class for anonymous complex type.
         * 
         * <p>The following schema fragment specifies the expected content contained within this class.
         * 
         * <pre>
         * &lt;complexType>
         *   &lt;complexContent>
         *     &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/services/}WorkingListItemType">
         *       &lt;sequence>
         *         &lt;element name="WorkListItemGUID" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType"/>
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
            "workListItemGUID"
        })
        public static class WorkListItem
            extends WorkingListItemType
        {

            @XmlElement(name = "WorkListItemGUID", required = true)
            protected String workListItemGUID;

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

        }

    }

}
