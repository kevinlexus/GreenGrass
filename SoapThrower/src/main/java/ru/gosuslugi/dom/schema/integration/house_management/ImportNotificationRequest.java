
package ru.gosuslugi.dom.schema.integration.house_management;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;
import ru.gosuslugi.dom.schema.integration.base.AttachmentType;
import ru.gosuslugi.dom.schema.integration.base.BaseType;
import ru.gosuslugi.dom.schema.integration.organizations_registry_base.RegOrgType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/base/}BaseType">
 *       &lt;sequence>
 *         &lt;element name="notification" maxOccurs="100">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;sequence>
 *                     &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/base/}TransportGUID"/>
 *                     &lt;element name="NotificationGUID" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType" minOccurs="0"/>
 *                   &lt;/sequence>
 *                   &lt;choice>
 *                     &lt;element name="Create">
 *                       &lt;complexType>
 *                         &lt;complexContent>
 *                           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                             &lt;sequence>
 *                               &lt;element name="Topic">
 *                                 &lt;simpleType>
 *                                   &lt;restriction base="{http://dom.gosuslugi.ru/schema/integration/base/}LongTextType">
 *                                     &lt;maxLength value="200"/>
 *                                     &lt;minLength value="1"/>
 *                                   &lt;/restriction>
 *                                 &lt;/simpleType>
 *                               &lt;/element>
 *                               &lt;element name="IsImportant" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *                               &lt;element name="content" minOccurs="0">
 *                                 &lt;simpleType>
 *                                   &lt;restriction base="{http://dom.gosuslugi.ru/schema/integration/base/}LongTextType">
 *                                     &lt;minLength value="1"/>
 *                                   &lt;/restriction>
 *                                 &lt;/simpleType>
 *                               &lt;/element>
 *                               &lt;choice>
 *                                 &lt;element name="IsAll" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *                                 &lt;element name="FIASHouseGuid" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType" maxOccurs="unbounded"/>
 *                                 &lt;element name="RoomOwners">
 *                                   &lt;complexType>
 *                                     &lt;complexContent>
 *                                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                         &lt;choice>
 *                                           &lt;element name="DeptsInforming">
 *                                             &lt;complexType>
 *                                               &lt;complexContent>
 *                                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                                   &lt;sequence>
 *                                                     &lt;element name="Account" maxOccurs="unbounded">
 *                                                       &lt;complexType>
 *                                                         &lt;complexContent>
 *                                                           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                                             &lt;sequence>
 *                                                               &lt;element name="TotalDebt" type="{http://dom.gosuslugi.ru/schema/integration/bills-base/}MoneyPositiveType"/>
 *                                                               &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/account-base/}UnifiedAccountNumber"/>
 *                                                             &lt;/sequence>
 *                                                           &lt;/restriction>
 *                                                         &lt;/complexContent>
 *                                                       &lt;/complexType>
 *                                                     &lt;/element>
 *                                                   &lt;/sequence>
 *                                                 &lt;/restriction>
 *                                               &lt;/complexContent>
 *                                             &lt;/complexType>
 *                                           &lt;/element>
 *                                           &lt;element name="OtherOrganizationSelection">
 *                                             &lt;complexType>
 *                                               &lt;complexContent>
 *                                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                                   &lt;sequence>
 *                                                     &lt;element name="FIASHouseGuid" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType" maxOccurs="unbounded"/>
 *                                                   &lt;/sequence>
 *                                                 &lt;/restriction>
 *                                               &lt;/complexContent>
 *                                             &lt;/complexType>
 *                                           &lt;/element>
 *                                           &lt;element name="AccountOpening">
 *                                             &lt;complexType>
 *                                               &lt;complexContent>
 *                                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                                   &lt;sequence>
 *                                                     &lt;element name="FIASHouseGuid" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType" maxOccurs="unbounded"/>
 *                                                   &lt;/sequence>
 *                                                 &lt;/restriction>
 *                                               &lt;/complexContent>
 *                                             &lt;/complexType>
 *                                           &lt;/element>
 *                                         &lt;/choice>
 *                                       &lt;/restriction>
 *                                     &lt;/complexContent>
 *                                   &lt;/complexType>
 *                                 &lt;/element>
 *                                 &lt;element name="SpecialAccountOwner" type="{http://dom.gosuslugi.ru/schema/integration/organizations-registry-base/}RegOrgType" maxOccurs="unbounded"/>
 *                                 &lt;element name="InspectionAuthority" type="{http://dom.gosuslugi.ru/schema/integration/organizations-registry-base/}RegOrgType" maxOccurs="unbounded"/>
 *                               &lt;/choice>
 *                               &lt;choice>
 *                                 &lt;element name="IsNotLimit" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *                                 &lt;sequence>
 *                                   &lt;element name="StartDate" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *                                   &lt;element name="EndDate" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *                                 &lt;/sequence>
 *                               &lt;/choice>
 *                               &lt;element name="Attachment" type="{http://dom.gosuslugi.ru/schema/integration/base/}AttachmentType" maxOccurs="unbounded" minOccurs="0"/>
 *                               &lt;element name="IsShipOff" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *                             &lt;/sequence>
 *                           &lt;/restriction>
 *                         &lt;/complexContent>
 *                       &lt;/complexType>
 *                     &lt;/element>
 *                     &lt;element name="IsShipOff" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *                     &lt;element name="DeleteNotification" type="{http://dom.gosuslugi.ru/schema/integration/house-management/}DeleteDocType"/>
 *                   &lt;/choice>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *       &lt;/sequence>
 *       &lt;attribute ref="{http://dom.gosuslugi.ru/schema/integration/base/}version use="required" fixed="10.0.1.1""/>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "notification"
})
@XmlRootElement(name = "importNotificationRequest")
public class ImportNotificationRequest
    extends BaseType
{

    @XmlElement(required = true)
    protected List<ImportNotificationRequest.Notification> notification;
    @XmlAttribute(name = "version", namespace = "http://dom.gosuslugi.ru/schema/integration/base/", required = true)
    protected String version;

    /**
     * Gets the value of the notification property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the notification property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getNotification().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ImportNotificationRequest.Notification }
     * 
     * 
     */
    public List<ImportNotificationRequest.Notification> getNotification() {
        if (notification == null) {
            notification = new ArrayList<ImportNotificationRequest.Notification>();
        }
        return this.notification;
    }

    /**
     * Gets the value of the version property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVersion() {
        if (version == null) {
            return "10.0.1.1";
        } else {
            return version;
        }
    }

    /**
     * Sets the value of the version property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVersion(String value) {
        this.version = value;
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
     *         &lt;sequence>
     *           &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/base/}TransportGUID"/>
     *           &lt;element name="NotificationGUID" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType" minOccurs="0"/>
     *         &lt;/sequence>
     *         &lt;choice>
     *           &lt;element name="Create">
     *             &lt;complexType>
     *               &lt;complexContent>
     *                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                   &lt;sequence>
     *                     &lt;element name="Topic">
     *                       &lt;simpleType>
     *                         &lt;restriction base="{http://dom.gosuslugi.ru/schema/integration/base/}LongTextType">
     *                           &lt;maxLength value="200"/>
     *                           &lt;minLength value="1"/>
     *                         &lt;/restriction>
     *                       &lt;/simpleType>
     *                     &lt;/element>
     *                     &lt;element name="IsImportant" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
     *                     &lt;element name="content" minOccurs="0">
     *                       &lt;simpleType>
     *                         &lt;restriction base="{http://dom.gosuslugi.ru/schema/integration/base/}LongTextType">
     *                           &lt;minLength value="1"/>
     *                         &lt;/restriction>
     *                       &lt;/simpleType>
     *                     &lt;/element>
     *                     &lt;choice>
     *                       &lt;element name="IsAll" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
     *                       &lt;element name="FIASHouseGuid" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType" maxOccurs="unbounded"/>
     *                       &lt;element name="RoomOwners">
     *                         &lt;complexType>
     *                           &lt;complexContent>
     *                             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                               &lt;choice>
     *                                 &lt;element name="DeptsInforming">
     *                                   &lt;complexType>
     *                                     &lt;complexContent>
     *                                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                                         &lt;sequence>
     *                                           &lt;element name="Account" maxOccurs="unbounded">
     *                                             &lt;complexType>
     *                                               &lt;complexContent>
     *                                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                                                   &lt;sequence>
     *                                                     &lt;element name="TotalDebt" type="{http://dom.gosuslugi.ru/schema/integration/bills-base/}MoneyPositiveType"/>
     *                                                     &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/account-base/}UnifiedAccountNumber"/>
     *                                                   &lt;/sequence>
     *                                                 &lt;/restriction>
     *                                               &lt;/complexContent>
     *                                             &lt;/complexType>
     *                                           &lt;/element>
     *                                         &lt;/sequence>
     *                                       &lt;/restriction>
     *                                     &lt;/complexContent>
     *                                   &lt;/complexType>
     *                                 &lt;/element>
     *                                 &lt;element name="OtherOrganizationSelection">
     *                                   &lt;complexType>
     *                                     &lt;complexContent>
     *                                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                                         &lt;sequence>
     *                                           &lt;element name="FIASHouseGuid" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType" maxOccurs="unbounded"/>
     *                                         &lt;/sequence>
     *                                       &lt;/restriction>
     *                                     &lt;/complexContent>
     *                                   &lt;/complexType>
     *                                 &lt;/element>
     *                                 &lt;element name="AccountOpening">
     *                                   &lt;complexType>
     *                                     &lt;complexContent>
     *                                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                                         &lt;sequence>
     *                                           &lt;element name="FIASHouseGuid" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType" maxOccurs="unbounded"/>
     *                                         &lt;/sequence>
     *                                       &lt;/restriction>
     *                                     &lt;/complexContent>
     *                                   &lt;/complexType>
     *                                 &lt;/element>
     *                               &lt;/choice>
     *                             &lt;/restriction>
     *                           &lt;/complexContent>
     *                         &lt;/complexType>
     *                       &lt;/element>
     *                       &lt;element name="SpecialAccountOwner" type="{http://dom.gosuslugi.ru/schema/integration/organizations-registry-base/}RegOrgType" maxOccurs="unbounded"/>
     *                       &lt;element name="InspectionAuthority" type="{http://dom.gosuslugi.ru/schema/integration/organizations-registry-base/}RegOrgType" maxOccurs="unbounded"/>
     *                     &lt;/choice>
     *                     &lt;choice>
     *                       &lt;element name="IsNotLimit" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
     *                       &lt;sequence>
     *                         &lt;element name="StartDate" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
     *                         &lt;element name="EndDate" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
     *                       &lt;/sequence>
     *                     &lt;/choice>
     *                     &lt;element name="Attachment" type="{http://dom.gosuslugi.ru/schema/integration/base/}AttachmentType" maxOccurs="unbounded" minOccurs="0"/>
     *                     &lt;element name="IsShipOff" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
     *                   &lt;/sequence>
     *                 &lt;/restriction>
     *               &lt;/complexContent>
     *             &lt;/complexType>
     *           &lt;/element>
     *           &lt;element name="IsShipOff" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
     *           &lt;element name="DeleteNotification" type="{http://dom.gosuslugi.ru/schema/integration/house-management/}DeleteDocType"/>
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
        "transportGUID",
        "notificationGUID",
        "create",
        "isShipOff",
        "deleteNotification"
    })
    public static class Notification {

        @XmlElement(name = "TransportGUID", namespace = "http://dom.gosuslugi.ru/schema/integration/base/", required = true)
        protected String transportGUID;
        @XmlElement(name = "NotificationGUID")
        protected String notificationGUID;
        @XmlElement(name = "Create")
        protected ImportNotificationRequest.Notification.Create create;
        @XmlElement(name = "IsShipOff")
        protected Boolean isShipOff;
        @XmlElement(name = "DeleteNotification")
        protected DeleteDocType deleteNotification;

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
         * Gets the value of the notificationGUID property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getNotificationGUID() {
            return notificationGUID;
        }

        /**
         * Sets the value of the notificationGUID property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setNotificationGUID(String value) {
            this.notificationGUID = value;
        }

        /**
         * Gets the value of the create property.
         * 
         * @return
         *     possible object is
         *     {@link ImportNotificationRequest.Notification.Create }
         *     
         */
        public ImportNotificationRequest.Notification.Create getCreate() {
            return create;
        }

        /**
         * Sets the value of the create property.
         * 
         * @param value
         *     allowed object is
         *     {@link ImportNotificationRequest.Notification.Create }
         *     
         */
        public void setCreate(ImportNotificationRequest.Notification.Create value) {
            this.create = value;
        }

        /**
         * Gets the value of the isShipOff property.
         * 
         * @return
         *     possible object is
         *     {@link Boolean }
         *     
         */
        public Boolean isIsShipOff() {
            return isShipOff;
        }

        /**
         * Sets the value of the isShipOff property.
         * 
         * @param value
         *     allowed object is
         *     {@link Boolean }
         *     
         */
        public void setIsShipOff(Boolean value) {
            this.isShipOff = value;
        }

        /**
         * Gets the value of the deleteNotification property.
         * 
         * @return
         *     possible object is
         *     {@link DeleteDocType }
         *     
         */
        public DeleteDocType getDeleteNotification() {
            return deleteNotification;
        }

        /**
         * Sets the value of the deleteNotification property.
         * 
         * @param value
         *     allowed object is
         *     {@link DeleteDocType }
         *     
         */
        public void setDeleteNotification(DeleteDocType value) {
            this.deleteNotification = value;
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
         *         &lt;element name="Topic">
         *           &lt;simpleType>
         *             &lt;restriction base="{http://dom.gosuslugi.ru/schema/integration/base/}LongTextType">
         *               &lt;maxLength value="200"/>
         *               &lt;minLength value="1"/>
         *             &lt;/restriction>
         *           &lt;/simpleType>
         *         &lt;/element>
         *         &lt;element name="IsImportant" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
         *         &lt;element name="content" minOccurs="0">
         *           &lt;simpleType>
         *             &lt;restriction base="{http://dom.gosuslugi.ru/schema/integration/base/}LongTextType">
         *               &lt;minLength value="1"/>
         *             &lt;/restriction>
         *           &lt;/simpleType>
         *         &lt;/element>
         *         &lt;choice>
         *           &lt;element name="IsAll" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
         *           &lt;element name="FIASHouseGuid" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType" maxOccurs="unbounded"/>
         *           &lt;element name="RoomOwners">
         *             &lt;complexType>
         *               &lt;complexContent>
         *                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *                   &lt;choice>
         *                     &lt;element name="DeptsInforming">
         *                       &lt;complexType>
         *                         &lt;complexContent>
         *                           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *                             &lt;sequence>
         *                               &lt;element name="Account" maxOccurs="unbounded">
         *                                 &lt;complexType>
         *                                   &lt;complexContent>
         *                                     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *                                       &lt;sequence>
         *                                         &lt;element name="TotalDebt" type="{http://dom.gosuslugi.ru/schema/integration/bills-base/}MoneyPositiveType"/>
         *                                         &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/account-base/}UnifiedAccountNumber"/>
         *                                       &lt;/sequence>
         *                                     &lt;/restriction>
         *                                   &lt;/complexContent>
         *                                 &lt;/complexType>
         *                               &lt;/element>
         *                             &lt;/sequence>
         *                           &lt;/restriction>
         *                         &lt;/complexContent>
         *                       &lt;/complexType>
         *                     &lt;/element>
         *                     &lt;element name="OtherOrganizationSelection">
         *                       &lt;complexType>
         *                         &lt;complexContent>
         *                           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *                             &lt;sequence>
         *                               &lt;element name="FIASHouseGuid" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType" maxOccurs="unbounded"/>
         *                             &lt;/sequence>
         *                           &lt;/restriction>
         *                         &lt;/complexContent>
         *                       &lt;/complexType>
         *                     &lt;/element>
         *                     &lt;element name="AccountOpening">
         *                       &lt;complexType>
         *                         &lt;complexContent>
         *                           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *                             &lt;sequence>
         *                               &lt;element name="FIASHouseGuid" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType" maxOccurs="unbounded"/>
         *                             &lt;/sequence>
         *                           &lt;/restriction>
         *                         &lt;/complexContent>
         *                       &lt;/complexType>
         *                     &lt;/element>
         *                   &lt;/choice>
         *                 &lt;/restriction>
         *               &lt;/complexContent>
         *             &lt;/complexType>
         *           &lt;/element>
         *           &lt;element name="SpecialAccountOwner" type="{http://dom.gosuslugi.ru/schema/integration/organizations-registry-base/}RegOrgType" maxOccurs="unbounded"/>
         *           &lt;element name="InspectionAuthority" type="{http://dom.gosuslugi.ru/schema/integration/organizations-registry-base/}RegOrgType" maxOccurs="unbounded"/>
         *         &lt;/choice>
         *         &lt;choice>
         *           &lt;element name="IsNotLimit" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
         *           &lt;sequence>
         *             &lt;element name="StartDate" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
         *             &lt;element name="EndDate" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
         *           &lt;/sequence>
         *         &lt;/choice>
         *         &lt;element name="Attachment" type="{http://dom.gosuslugi.ru/schema/integration/base/}AttachmentType" maxOccurs="unbounded" minOccurs="0"/>
         *         &lt;element name="IsShipOff" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
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
            "topic",
            "isImportant",
            "content",
            "isAll",
            "fiasHouseGuid",
            "roomOwners",
            "specialAccountOwner",
            "inspectionAuthority",
            "isNotLimit",
            "startDate",
            "endDate",
            "attachment",
            "isShipOff"
        })
        public static class Create {

            @XmlElement(name = "Topic", required = true)
            protected String topic;
            @XmlElement(name = "IsImportant")
            protected Boolean isImportant;
            protected String content;
            @XmlElement(name = "IsAll")
            protected Boolean isAll;
            @XmlElement(name = "FIASHouseGuid")
            protected List<String> fiasHouseGuid;
            @XmlElement(name = "RoomOwners")
            protected ImportNotificationRequest.Notification.Create.RoomOwners roomOwners;
            @XmlElement(name = "SpecialAccountOwner")
            protected List<RegOrgType> specialAccountOwner;
            @XmlElement(name = "InspectionAuthority")
            protected List<RegOrgType> inspectionAuthority;
            @XmlElement(name = "IsNotLimit")
            protected Boolean isNotLimit;
            @XmlElement(name = "StartDate")
            @XmlSchemaType(name = "dateTime")
            protected XMLGregorianCalendar startDate;
            @XmlElement(name = "EndDate")
            @XmlSchemaType(name = "dateTime")
            protected XMLGregorianCalendar endDate;
            @XmlElement(name = "Attachment")
            protected List<AttachmentType> attachment;
            @XmlElement(name = "IsShipOff")
            protected Boolean isShipOff;

            /**
             * Gets the value of the topic property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getTopic() {
                return topic;
            }

            /**
             * Sets the value of the topic property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setTopic(String value) {
                this.topic = value;
            }

            /**
             * Gets the value of the isImportant property.
             * 
             * @return
             *     possible object is
             *     {@link Boolean }
             *     
             */
            public Boolean isIsImportant() {
                return isImportant;
            }

            /**
             * Sets the value of the isImportant property.
             * 
             * @param value
             *     allowed object is
             *     {@link Boolean }
             *     
             */
            public void setIsImportant(Boolean value) {
                this.isImportant = value;
            }

            /**
             * Gets the value of the content property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getContent() {
                return content;
            }

            /**
             * Sets the value of the content property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setContent(String value) {
                this.content = value;
            }

            /**
             * Gets the value of the isAll property.
             * 
             * @return
             *     possible object is
             *     {@link Boolean }
             *     
             */
            public Boolean isIsAll() {
                return isAll;
            }

            /**
             * Sets the value of the isAll property.
             * 
             * @param value
             *     allowed object is
             *     {@link Boolean }
             *     
             */
            public void setIsAll(Boolean value) {
                this.isAll = value;
            }

            /**
             * Gets the value of the fiasHouseGuid property.
             * 
             * <p>
             * This accessor method returns a reference to the live list,
             * not a snapshot. Therefore any modification you make to the
             * returned list will be present inside the JAXB object.
             * This is why there is not a <CODE>set</CODE> method for the fiasHouseGuid property.
             * 
             * <p>
             * For example, to add a new item, do as follows:
             * <pre>
             *    getFIASHouseGuid().add(newItem);
             * </pre>
             * 
             * 
             * <p>
             * Objects of the following type(s) are allowed in the list
             * {@link String }
             * 
             * 
             */
            public List<String> getFIASHouseGuid() {
                if (fiasHouseGuid == null) {
                    fiasHouseGuid = new ArrayList<String>();
                }
                return this.fiasHouseGuid;
            }

            /**
             * Gets the value of the roomOwners property.
             * 
             * @return
             *     possible object is
             *     {@link ImportNotificationRequest.Notification.Create.RoomOwners }
             *     
             */
            public ImportNotificationRequest.Notification.Create.RoomOwners getRoomOwners() {
                return roomOwners;
            }

            /**
             * Sets the value of the roomOwners property.
             * 
             * @param value
             *     allowed object is
             *     {@link ImportNotificationRequest.Notification.Create.RoomOwners }
             *     
             */
            public void setRoomOwners(ImportNotificationRequest.Notification.Create.RoomOwners value) {
                this.roomOwners = value;
            }

            /**
             * Gets the value of the specialAccountOwner property.
             * 
             * <p>
             * This accessor method returns a reference to the live list,
             * not a snapshot. Therefore any modification you make to the
             * returned list will be present inside the JAXB object.
             * This is why there is not a <CODE>set</CODE> method for the specialAccountOwner property.
             * 
             * <p>
             * For example, to add a new item, do as follows:
             * <pre>
             *    getSpecialAccountOwner().add(newItem);
             * </pre>
             * 
             * 
             * <p>
             * Objects of the following type(s) are allowed in the list
             * {@link RegOrgType }
             * 
             * 
             */
            public List<RegOrgType> getSpecialAccountOwner() {
                if (specialAccountOwner == null) {
                    specialAccountOwner = new ArrayList<RegOrgType>();
                }
                return this.specialAccountOwner;
            }

            /**
             * Gets the value of the inspectionAuthority property.
             * 
             * <p>
             * This accessor method returns a reference to the live list,
             * not a snapshot. Therefore any modification you make to the
             * returned list will be present inside the JAXB object.
             * This is why there is not a <CODE>set</CODE> method for the inspectionAuthority property.
             * 
             * <p>
             * For example, to add a new item, do as follows:
             * <pre>
             *    getInspectionAuthority().add(newItem);
             * </pre>
             * 
             * 
             * <p>
             * Objects of the following type(s) are allowed in the list
             * {@link RegOrgType }
             * 
             * 
             */
            public List<RegOrgType> getInspectionAuthority() {
                if (inspectionAuthority == null) {
                    inspectionAuthority = new ArrayList<RegOrgType>();
                }
                return this.inspectionAuthority;
            }

            /**
             * Gets the value of the isNotLimit property.
             * 
             * @return
             *     possible object is
             *     {@link Boolean }
             *     
             */
            public Boolean isIsNotLimit() {
                return isNotLimit;
            }

            /**
             * Sets the value of the isNotLimit property.
             * 
             * @param value
             *     allowed object is
             *     {@link Boolean }
             *     
             */
            public void setIsNotLimit(Boolean value) {
                this.isNotLimit = value;
            }

            /**
             * Gets the value of the startDate property.
             * 
             * @return
             *     possible object is
             *     {@link XMLGregorianCalendar }
             *     
             */
            public XMLGregorianCalendar getStartDate() {
                return startDate;
            }

            /**
             * Sets the value of the startDate property.
             * 
             * @param value
             *     allowed object is
             *     {@link XMLGregorianCalendar }
             *     
             */
            public void setStartDate(XMLGregorianCalendar value) {
                this.startDate = value;
            }

            /**
             * Gets the value of the endDate property.
             * 
             * @return
             *     possible object is
             *     {@link XMLGregorianCalendar }
             *     
             */
            public XMLGregorianCalendar getEndDate() {
                return endDate;
            }

            /**
             * Sets the value of the endDate property.
             * 
             * @param value
             *     allowed object is
             *     {@link XMLGregorianCalendar }
             *     
             */
            public void setEndDate(XMLGregorianCalendar value) {
                this.endDate = value;
            }

            /**
             * Gets the value of the attachment property.
             * 
             * <p>
             * This accessor method returns a reference to the live list,
             * not a snapshot. Therefore any modification you make to the
             * returned list will be present inside the JAXB object.
             * This is why there is not a <CODE>set</CODE> method for the attachment property.
             * 
             * <p>
             * For example, to add a new item, do as follows:
             * <pre>
             *    getAttachment().add(newItem);
             * </pre>
             * 
             * 
             * <p>
             * Objects of the following type(s) are allowed in the list
             * {@link AttachmentType }
             * 
             * 
             */
            public List<AttachmentType> getAttachment() {
                if (attachment == null) {
                    attachment = new ArrayList<AttachmentType>();
                }
                return this.attachment;
            }

            /**
             * Gets the value of the isShipOff property.
             * 
             * @return
             *     possible object is
             *     {@link Boolean }
             *     
             */
            public Boolean isIsShipOff() {
                return isShipOff;
            }

            /**
             * Sets the value of the isShipOff property.
             * 
             * @param value
             *     allowed object is
             *     {@link Boolean }
             *     
             */
            public void setIsShipOff(Boolean value) {
                this.isShipOff = value;
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
             *         &lt;element name="DeptsInforming">
             *           &lt;complexType>
             *             &lt;complexContent>
             *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
             *                 &lt;sequence>
             *                   &lt;element name="Account" maxOccurs="unbounded">
             *                     &lt;complexType>
             *                       &lt;complexContent>
             *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
             *                           &lt;sequence>
             *                             &lt;element name="TotalDebt" type="{http://dom.gosuslugi.ru/schema/integration/bills-base/}MoneyPositiveType"/>
             *                             &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/account-base/}UnifiedAccountNumber"/>
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
             *         &lt;element name="OtherOrganizationSelection">
             *           &lt;complexType>
             *             &lt;complexContent>
             *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
             *                 &lt;sequence>
             *                   &lt;element name="FIASHouseGuid" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType" maxOccurs="unbounded"/>
             *                 &lt;/sequence>
             *               &lt;/restriction>
             *             &lt;/complexContent>
             *           &lt;/complexType>
             *         &lt;/element>
             *         &lt;element name="AccountOpening">
             *           &lt;complexType>
             *             &lt;complexContent>
             *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
             *                 &lt;sequence>
             *                   &lt;element name="FIASHouseGuid" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType" maxOccurs="unbounded"/>
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
                "deptsInforming",
                "otherOrganizationSelection",
                "accountOpening"
            })
            public static class RoomOwners {

                @XmlElement(name = "DeptsInforming")
                protected ImportNotificationRequest.Notification.Create.RoomOwners.DeptsInforming deptsInforming;
                @XmlElement(name = "OtherOrganizationSelection")
                protected ImportNotificationRequest.Notification.Create.RoomOwners.OtherOrganizationSelection otherOrganizationSelection;
                @XmlElement(name = "AccountOpening")
                protected ImportNotificationRequest.Notification.Create.RoomOwners.AccountOpening accountOpening;

                /**
                 * Gets the value of the deptsInforming property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link ImportNotificationRequest.Notification.Create.RoomOwners.DeptsInforming }
                 *     
                 */
                public ImportNotificationRequest.Notification.Create.RoomOwners.DeptsInforming getDeptsInforming() {
                    return deptsInforming;
                }

                /**
                 * Sets the value of the deptsInforming property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link ImportNotificationRequest.Notification.Create.RoomOwners.DeptsInforming }
                 *     
                 */
                public void setDeptsInforming(ImportNotificationRequest.Notification.Create.RoomOwners.DeptsInforming value) {
                    this.deptsInforming = value;
                }

                /**
                 * Gets the value of the otherOrganizationSelection property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link ImportNotificationRequest.Notification.Create.RoomOwners.OtherOrganizationSelection }
                 *     
                 */
                public ImportNotificationRequest.Notification.Create.RoomOwners.OtherOrganizationSelection getOtherOrganizationSelection() {
                    return otherOrganizationSelection;
                }

                /**
                 * Sets the value of the otherOrganizationSelection property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link ImportNotificationRequest.Notification.Create.RoomOwners.OtherOrganizationSelection }
                 *     
                 */
                public void setOtherOrganizationSelection(ImportNotificationRequest.Notification.Create.RoomOwners.OtherOrganizationSelection value) {
                    this.otherOrganizationSelection = value;
                }

                /**
                 * Gets the value of the accountOpening property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link ImportNotificationRequest.Notification.Create.RoomOwners.AccountOpening }
                 *     
                 */
                public ImportNotificationRequest.Notification.Create.RoomOwners.AccountOpening getAccountOpening() {
                    return accountOpening;
                }

                /**
                 * Sets the value of the accountOpening property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link ImportNotificationRequest.Notification.Create.RoomOwners.AccountOpening }
                 *     
                 */
                public void setAccountOpening(ImportNotificationRequest.Notification.Create.RoomOwners.AccountOpening value) {
                    this.accountOpening = value;
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
                 *         &lt;element name="FIASHouseGuid" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType" maxOccurs="unbounded"/>
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
                    "fiasHouseGuid"
                })
                public static class AccountOpening {

                    @XmlElement(name = "FIASHouseGuid", required = true)
                    protected List<String> fiasHouseGuid;

                    /**
                     * Gets the value of the fiasHouseGuid property.
                     * 
                     * <p>
                     * This accessor method returns a reference to the live list,
                     * not a snapshot. Therefore any modification you make to the
                     * returned list will be present inside the JAXB object.
                     * This is why there is not a <CODE>set</CODE> method for the fiasHouseGuid property.
                     * 
                     * <p>
                     * For example, to add a new item, do as follows:
                     * <pre>
                     *    getFIASHouseGuid().add(newItem);
                     * </pre>
                     * 
                     * 
                     * <p>
                     * Objects of the following type(s) are allowed in the list
                     * {@link String }
                     * 
                     * 
                     */
                    public List<String> getFIASHouseGuid() {
                        if (fiasHouseGuid == null) {
                            fiasHouseGuid = new ArrayList<String>();
                        }
                        return this.fiasHouseGuid;
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
                 *         &lt;element name="Account" maxOccurs="unbounded">
                 *           &lt;complexType>
                 *             &lt;complexContent>
                 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
                 *                 &lt;sequence>
                 *                   &lt;element name="TotalDebt" type="{http://dom.gosuslugi.ru/schema/integration/bills-base/}MoneyPositiveType"/>
                 *                   &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/account-base/}UnifiedAccountNumber"/>
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
                    "account"
                })
                public static class DeptsInforming {

                    @XmlElement(name = "Account", required = true)
                    protected List<ImportNotificationRequest.Notification.Create.RoomOwners.DeptsInforming.Account> account;

                    /**
                     * Gets the value of the account property.
                     * 
                     * <p>
                     * This accessor method returns a reference to the live list,
                     * not a snapshot. Therefore any modification you make to the
                     * returned list will be present inside the JAXB object.
                     * This is why there is not a <CODE>set</CODE> method for the account property.
                     * 
                     * <p>
                     * For example, to add a new item, do as follows:
                     * <pre>
                     *    getAccount().add(newItem);
                     * </pre>
                     * 
                     * 
                     * <p>
                     * Objects of the following type(s) are allowed in the list
                     * {@link ImportNotificationRequest.Notification.Create.RoomOwners.DeptsInforming.Account }
                     * 
                     * 
                     */
                    public List<ImportNotificationRequest.Notification.Create.RoomOwners.DeptsInforming.Account> getAccount() {
                        if (account == null) {
                            account = new ArrayList<ImportNotificationRequest.Notification.Create.RoomOwners.DeptsInforming.Account>();
                        }
                        return this.account;
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
                     *         &lt;element name="TotalDebt" type="{http://dom.gosuslugi.ru/schema/integration/bills-base/}MoneyPositiveType"/>
                     *         &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/account-base/}UnifiedAccountNumber"/>
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
                        "totalDebt",
                        "unifiedAccountNumber"
                    })
                    public static class Account {

                        @XmlElement(name = "TotalDebt", required = true)
                        protected BigDecimal totalDebt;
                        @XmlElement(name = "UnifiedAccountNumber", namespace = "http://dom.gosuslugi.ru/schema/integration/account-base/", required = true)
                        protected String unifiedAccountNumber;

                        /**
                         * Gets the value of the totalDebt property.
                         * 
                         * @return
                         *     possible object is
                         *     {@link BigDecimal }
                         *     
                         */
                        public BigDecimal getTotalDebt() {
                            return totalDebt;
                        }

                        /**
                         * Sets the value of the totalDebt property.
                         * 
                         * @param value
                         *     allowed object is
                         *     {@link BigDecimal }
                         *     
                         */
                        public void setTotalDebt(BigDecimal value) {
                            this.totalDebt = value;
                        }

                        /**
                         * Gets the value of the unifiedAccountNumber property.
                         * 
                         * @return
                         *     possible object is
                         *     {@link String }
                         *     
                         */
                        public String getUnifiedAccountNumber() {
                            return unifiedAccountNumber;
                        }

                        /**
                         * Sets the value of the unifiedAccountNumber property.
                         * 
                         * @param value
                         *     allowed object is
                         *     {@link String }
                         *     
                         */
                        public void setUnifiedAccountNumber(String value) {
                            this.unifiedAccountNumber = value;
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
                 *         &lt;element name="FIASHouseGuid" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType" maxOccurs="unbounded"/>
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
                    "fiasHouseGuid"
                })
                public static class OtherOrganizationSelection {

                    @XmlElement(name = "FIASHouseGuid", required = true)
                    protected List<String> fiasHouseGuid;

                    /**
                     * Gets the value of the fiasHouseGuid property.
                     * 
                     * <p>
                     * This accessor method returns a reference to the live list,
                     * not a snapshot. Therefore any modification you make to the
                     * returned list will be present inside the JAXB object.
                     * This is why there is not a <CODE>set</CODE> method for the fiasHouseGuid property.
                     * 
                     * <p>
                     * For example, to add a new item, do as follows:
                     * <pre>
                     *    getFIASHouseGuid().add(newItem);
                     * </pre>
                     * 
                     * 
                     * <p>
                     * Objects of the following type(s) are allowed in the list
                     * {@link String }
                     * 
                     * 
                     */
                    public List<String> getFIASHouseGuid() {
                        if (fiasHouseGuid == null) {
                            fiasHouseGuid = new ArrayList<String>();
                        }
                        return this.fiasHouseGuid;
                    }

                }

            }

        }

    }

}
