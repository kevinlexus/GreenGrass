
package ru.gosuslugi.dom.schema.integration.bills;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;
import ru.gosuslugi.dom.schema.integration.payments_base.AcknowledgmentRequestInfoType;
import ru.gosuslugi.dom.schema.integration.payments_base.NotificationOfOrderExecutionExportType;


/**
 * <p>Java class for exportNotificationsOfOrderExecutionResultType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="exportNotificationsOfOrderExecutionResultType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="NotificationOfOrderExecutionWithStatus" maxOccurs="unbounded" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/payments-base/}NotificationOfOrderExecutionExportType">
 *                 &lt;sequence>
 *                   &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/bills/}AckStatus"/>
 *                   &lt;element name="CreationDate" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *                   &lt;element name="AcknowledgmentRequestsList">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="AcknowledgmentRequest" maxOccurs="unbounded" minOccurs="0">
 *                               &lt;complexType>
 *                                 &lt;complexContent>
 *                                   &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/payments-base/}AcknowledgmentRequestInfoType">
 *                                     &lt;sequence>
 *                                       &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/payments-base/}OrderID"/>
 *                                     &lt;/sequence>
 *                                   &lt;/extension>
 *                                 &lt;/complexContent>
 *                               &lt;/complexType>
 *                             &lt;/element>
 *                           &lt;/sequence>
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                   &lt;element name="AcknowledgmentAmount" type="{http://dom.gosuslugi.ru/schema/integration/bills-base/}AmountType"/>
 *                   &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/payments-base/}NotificationsOfOrderExecutionGUID"/>
 *                   &lt;element name="orgPPAGUID" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType"/>
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
@XmlType(name = "exportNotificationsOfOrderExecutionResultType", propOrder = {
    "notificationOfOrderExecutionWithStatus"
})
public class ExportNotificationsOfOrderExecutionResultType {

    @XmlElement(name = "NotificationOfOrderExecutionWithStatus")
    protected List<ExportNotificationsOfOrderExecutionResultType.NotificationOfOrderExecutionWithStatus> notificationOfOrderExecutionWithStatus;

    /**
     * Gets the value of the notificationOfOrderExecutionWithStatus property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the notificationOfOrderExecutionWithStatus property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getNotificationOfOrderExecutionWithStatus().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ExportNotificationsOfOrderExecutionResultType.NotificationOfOrderExecutionWithStatus }
     * 
     * 
     */
    public List<ExportNotificationsOfOrderExecutionResultType.NotificationOfOrderExecutionWithStatus> getNotificationOfOrderExecutionWithStatus() {
        if (notificationOfOrderExecutionWithStatus == null) {
            notificationOfOrderExecutionWithStatus = new ArrayList<ExportNotificationsOfOrderExecutionResultType.NotificationOfOrderExecutionWithStatus>();
        }
        return this.notificationOfOrderExecutionWithStatus;
    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/payments-base/}NotificationOfOrderExecutionExportType">
     *       &lt;sequence>
     *         &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/bills/}AckStatus"/>
     *         &lt;element name="CreationDate" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
     *         &lt;element name="AcknowledgmentRequestsList">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element name="AcknowledgmentRequest" maxOccurs="unbounded" minOccurs="0">
     *                     &lt;complexType>
     *                       &lt;complexContent>
     *                         &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/payments-base/}AcknowledgmentRequestInfoType">
     *                           &lt;sequence>
     *                             &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/payments-base/}OrderID"/>
     *                           &lt;/sequence>
     *                         &lt;/extension>
     *                       &lt;/complexContent>
     *                     &lt;/complexType>
     *                   &lt;/element>
     *                 &lt;/sequence>
     *               &lt;/restriction>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *         &lt;element name="AcknowledgmentAmount" type="{http://dom.gosuslugi.ru/schema/integration/bills-base/}AmountType"/>
     *         &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/payments-base/}NotificationsOfOrderExecutionGUID"/>
     *         &lt;element name="orgPPAGUID" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType"/>
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
        "ackStatus",
        "creationDate",
        "acknowledgmentRequestsList",
        "acknowledgmentAmount",
        "notificationsOfOrderExecutionGUID",
        "orgPPAGUID"
    })
    public static class NotificationOfOrderExecutionWithStatus
        extends NotificationOfOrderExecutionExportType
    {

        @XmlElement(name = "AckStatus")
        protected byte ackStatus;
        @XmlElement(name = "CreationDate", required = true)
        @XmlSchemaType(name = "dateTime")
        protected XMLGregorianCalendar creationDate;
        @XmlElement(name = "AcknowledgmentRequestsList", required = true)
        protected ExportNotificationsOfOrderExecutionResultType.NotificationOfOrderExecutionWithStatus.AcknowledgmentRequestsList acknowledgmentRequestsList;
        @XmlElement(name = "AcknowledgmentAmount")
        protected long acknowledgmentAmount;
        @XmlElement(name = "NotificationsOfOrderExecutionGUID", namespace = "http://dom.gosuslugi.ru/schema/integration/payments-base/", required = true)
        protected String notificationsOfOrderExecutionGUID;
        @XmlElement(required = true)
        protected String orgPPAGUID;

        /**
         * Gets the value of the ackStatus property.
         * 
         */
        public byte getAckStatus() {
            return ackStatus;
        }

        /**
         * Sets the value of the ackStatus property.
         * 
         */
        public void setAckStatus(byte value) {
            this.ackStatus = value;
        }

        /**
         * Gets the value of the creationDate property.
         * 
         * @return
         *     possible object is
         *     {@link XMLGregorianCalendar }
         *     
         */
        public XMLGregorianCalendar getCreationDate() {
            return creationDate;
        }

        /**
         * Sets the value of the creationDate property.
         * 
         * @param value
         *     allowed object is
         *     {@link XMLGregorianCalendar }
         *     
         */
        public void setCreationDate(XMLGregorianCalendar value) {
            this.creationDate = value;
        }

        /**
         * Gets the value of the acknowledgmentRequestsList property.
         * 
         * @return
         *     possible object is
         *     {@link ExportNotificationsOfOrderExecutionResultType.NotificationOfOrderExecutionWithStatus.AcknowledgmentRequestsList }
         *     
         */
        public ExportNotificationsOfOrderExecutionResultType.NotificationOfOrderExecutionWithStatus.AcknowledgmentRequestsList getAcknowledgmentRequestsList() {
            return acknowledgmentRequestsList;
        }

        /**
         * Sets the value of the acknowledgmentRequestsList property.
         * 
         * @param value
         *     allowed object is
         *     {@link ExportNotificationsOfOrderExecutionResultType.NotificationOfOrderExecutionWithStatus.AcknowledgmentRequestsList }
         *     
         */
        public void setAcknowledgmentRequestsList(ExportNotificationsOfOrderExecutionResultType.NotificationOfOrderExecutionWithStatus.AcknowledgmentRequestsList value) {
            this.acknowledgmentRequestsList = value;
        }

        /**
         * Gets the value of the acknowledgmentAmount property.
         * 
         */
        public long getAcknowledgmentAmount() {
            return acknowledgmentAmount;
        }

        /**
         * Sets the value of the acknowledgmentAmount property.
         * 
         */
        public void setAcknowledgmentAmount(long value) {
            this.acknowledgmentAmount = value;
        }

        /**
         * Gets the value of the notificationsOfOrderExecutionGUID property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getNotificationsOfOrderExecutionGUID() {
            return notificationsOfOrderExecutionGUID;
        }

        /**
         * Sets the value of the notificationsOfOrderExecutionGUID property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setNotificationsOfOrderExecutionGUID(String value) {
            this.notificationsOfOrderExecutionGUID = value;
        }

        /**
         * Gets the value of the orgPPAGUID property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getOrgPPAGUID() {
            return orgPPAGUID;
        }

        /**
         * Sets the value of the orgPPAGUID property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setOrgPPAGUID(String value) {
            this.orgPPAGUID = value;
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
         *         &lt;element name="AcknowledgmentRequest" maxOccurs="unbounded" minOccurs="0">
         *           &lt;complexType>
         *             &lt;complexContent>
         *               &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/payments-base/}AcknowledgmentRequestInfoType">
         *                 &lt;sequence>
         *                   &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/payments-base/}OrderID"/>
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
        @XmlType(name = "", propOrder = {
            "acknowledgmentRequest"
        })
        public static class AcknowledgmentRequestsList {

            @XmlElement(name = "AcknowledgmentRequest")
            protected List<ExportNotificationsOfOrderExecutionResultType.NotificationOfOrderExecutionWithStatus.AcknowledgmentRequestsList.AcknowledgmentRequest> acknowledgmentRequest;

            /**
             * Gets the value of the acknowledgmentRequest property.
             * 
             * <p>
             * This accessor method returns a reference to the live list,
             * not a snapshot. Therefore any modification you make to the
             * returned list will be present inside the JAXB object.
             * This is why there is not a <CODE>set</CODE> method for the acknowledgmentRequest property.
             * 
             * <p>
             * For example, to add a new item, do as follows:
             * <pre>
             *    getAcknowledgmentRequest().add(newItem);
             * </pre>
             * 
             * 
             * <p>
             * Objects of the following type(s) are allowed in the list
             * {@link ExportNotificationsOfOrderExecutionResultType.NotificationOfOrderExecutionWithStatus.AcknowledgmentRequestsList.AcknowledgmentRequest }
             * 
             * 
             */
            public List<ExportNotificationsOfOrderExecutionResultType.NotificationOfOrderExecutionWithStatus.AcknowledgmentRequestsList.AcknowledgmentRequest> getAcknowledgmentRequest() {
                if (acknowledgmentRequest == null) {
                    acknowledgmentRequest = new ArrayList<ExportNotificationsOfOrderExecutionResultType.NotificationOfOrderExecutionWithStatus.AcknowledgmentRequestsList.AcknowledgmentRequest>();
                }
                return this.acknowledgmentRequest;
            }


            /**
             * <p>Java class for anonymous complex type.
             * 
             * <p>The following schema fragment specifies the expected content contained within this class.
             * 
             * <pre>
             * &lt;complexType>
             *   &lt;complexContent>
             *     &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/payments-base/}AcknowledgmentRequestInfoType">
             *       &lt;sequence>
             *         &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/payments-base/}OrderID"/>
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
                "orderID"
            })
            public static class AcknowledgmentRequest
                extends AcknowledgmentRequestInfoType
            {

                @XmlElement(name = "OrderID", namespace = "http://dom.gosuslugi.ru/schema/integration/payments-base/", required = true)
                protected String orderID;

                /**
                 * Уникальный идентификатор извещения
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getOrderID() {
                    return orderID;
                }

                /**
                 * Sets the value of the orderID property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setOrderID(String value) {
                    this.orderID = value;
                }

            }

        }

    }

}
