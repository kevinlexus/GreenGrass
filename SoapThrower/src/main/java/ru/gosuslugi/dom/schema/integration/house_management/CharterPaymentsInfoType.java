
package ru.gosuslugi.dom.schema.integration.house_management;

import java.math.BigDecimal;
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
import ru.gosuslugi.dom.schema.integration.nsi_base.NsiRef;


/**
 * Тип информации о размере платы за жилое помещение по уставу
 * 
 * <p>Java class for CharterPaymentsInfoType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="CharterPaymentsInfoType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="BeginDate" type="{http://www.w3.org/2001/XMLSchema}date"/>
 *         &lt;element name="EndDate" type="{http://www.w3.org/2001/XMLSchema}date"/>
 *         &lt;element name="MaintenanceAndRepairsForMembers" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="MaintenanceAndRepairsForMembersPaymentSize" type="{http://dom.gosuslugi.ru/schema/integration/bills-base/}SmallMoneyType"/>
 *                   &lt;element name="MaintenanceAndRepairsForMembersProtocol" type="{http://dom.gosuslugi.ru/schema/integration/base/}AttachmentType" maxOccurs="unbounded"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="MaintenanceAndRepairsForNonMembersInfo" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="MaintenanceAndRepairsForNonMembersPaymentSize" type="{http://dom.gosuslugi.ru/schema/integration/bills-base/}SmallMoneyType"/>
 *                   &lt;element name="MaintenanceAndRepairsForNonMembersProtocol" type="{http://dom.gosuslugi.ru/schema/integration/base/}AttachmentType" maxOccurs="unbounded"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="ServicePayment" maxOccurs="unbounded" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="Service" type="{http://dom.gosuslugi.ru/schema/integration/nsi-base/}nsiRef"/>
 *                   &lt;element name="ServicePaymentSize" type="{http://dom.gosuslugi.ru/schema/integration/bills-base/}SmallMoneyType"/>
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
@XmlType(name = "CharterPaymentsInfoType", propOrder = {
    "beginDate",
    "endDate",
    "maintenanceAndRepairsForMembers",
    "maintenanceAndRepairsForNonMembersInfo",
    "servicePayment"
})
@XmlSeeAlso({
    ru.gosuslugi.dom.schema.integration.house_management.ExportCAChResultType.Charter.CharterPaymentsInfo.class,
    ru.gosuslugi.dom.schema.integration.house_management.ImportCharterRequest.PlaceCharterPaymentsInfo.class
})
public class CharterPaymentsInfoType {

    @XmlElement(name = "BeginDate", required = true)
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar beginDate;
    @XmlElement(name = "EndDate", required = true)
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar endDate;
    @XmlElement(name = "MaintenanceAndRepairsForMembers")
    protected CharterPaymentsInfoType.MaintenanceAndRepairsForMembers maintenanceAndRepairsForMembers;
    @XmlElement(name = "MaintenanceAndRepairsForNonMembersInfo")
    protected CharterPaymentsInfoType.MaintenanceAndRepairsForNonMembersInfo maintenanceAndRepairsForNonMembersInfo;
    @XmlElement(name = "ServicePayment")
    protected List<CharterPaymentsInfoType.ServicePayment> servicePayment;

    /**
     * Gets the value of the beginDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getBeginDate() {
        return beginDate;
    }

    /**
     * Sets the value of the beginDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setBeginDate(XMLGregorianCalendar value) {
        this.beginDate = value;
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
     * Gets the value of the maintenanceAndRepairsForMembers property.
     * 
     * @return
     *     possible object is
     *     {@link CharterPaymentsInfoType.MaintenanceAndRepairsForMembers }
     *     
     */
    public CharterPaymentsInfoType.MaintenanceAndRepairsForMembers getMaintenanceAndRepairsForMembers() {
        return maintenanceAndRepairsForMembers;
    }

    /**
     * Sets the value of the maintenanceAndRepairsForMembers property.
     * 
     * @param value
     *     allowed object is
     *     {@link CharterPaymentsInfoType.MaintenanceAndRepairsForMembers }
     *     
     */
    public void setMaintenanceAndRepairsForMembers(CharterPaymentsInfoType.MaintenanceAndRepairsForMembers value) {
        this.maintenanceAndRepairsForMembers = value;
    }

    /**
     * Gets the value of the maintenanceAndRepairsForNonMembersInfo property.
     * 
     * @return
     *     possible object is
     *     {@link CharterPaymentsInfoType.MaintenanceAndRepairsForNonMembersInfo }
     *     
     */
    public CharterPaymentsInfoType.MaintenanceAndRepairsForNonMembersInfo getMaintenanceAndRepairsForNonMembersInfo() {
        return maintenanceAndRepairsForNonMembersInfo;
    }

    /**
     * Sets the value of the maintenanceAndRepairsForNonMembersInfo property.
     * 
     * @param value
     *     allowed object is
     *     {@link CharterPaymentsInfoType.MaintenanceAndRepairsForNonMembersInfo }
     *     
     */
    public void setMaintenanceAndRepairsForNonMembersInfo(CharterPaymentsInfoType.MaintenanceAndRepairsForNonMembersInfo value) {
        this.maintenanceAndRepairsForNonMembersInfo = value;
    }

    /**
     * Gets the value of the servicePayment property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the servicePayment property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getServicePayment().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CharterPaymentsInfoType.ServicePayment }
     * 
     * 
     */
    public List<CharterPaymentsInfoType.ServicePayment> getServicePayment() {
        if (servicePayment == null) {
            servicePayment = new ArrayList<CharterPaymentsInfoType.ServicePayment>();
        }
        return this.servicePayment;
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
     *         &lt;element name="MaintenanceAndRepairsForMembersPaymentSize" type="{http://dom.gosuslugi.ru/schema/integration/bills-base/}SmallMoneyType"/>
     *         &lt;element name="MaintenanceAndRepairsForMembersProtocol" type="{http://dom.gosuslugi.ru/schema/integration/base/}AttachmentType" maxOccurs="unbounded"/>
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
        "maintenanceAndRepairsForMembersPaymentSize",
        "maintenanceAndRepairsForMembersProtocol"
    })
    public static class MaintenanceAndRepairsForMembers {

        @XmlElement(name = "MaintenanceAndRepairsForMembersPaymentSize", required = true)
        protected BigDecimal maintenanceAndRepairsForMembersPaymentSize;
        @XmlElement(name = "MaintenanceAndRepairsForMembersProtocol", required = true)
        protected List<AttachmentType> maintenanceAndRepairsForMembersProtocol;

        /**
         * Gets the value of the maintenanceAndRepairsForMembersPaymentSize property.
         * 
         * @return
         *     possible object is
         *     {@link BigDecimal }
         *     
         */
        public BigDecimal getMaintenanceAndRepairsForMembersPaymentSize() {
            return maintenanceAndRepairsForMembersPaymentSize;
        }

        /**
         * Sets the value of the maintenanceAndRepairsForMembersPaymentSize property.
         * 
         * @param value
         *     allowed object is
         *     {@link BigDecimal }
         *     
         */
        public void setMaintenanceAndRepairsForMembersPaymentSize(BigDecimal value) {
            this.maintenanceAndRepairsForMembersPaymentSize = value;
        }

        /**
         * Gets the value of the maintenanceAndRepairsForMembersProtocol property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the maintenanceAndRepairsForMembersProtocol property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getMaintenanceAndRepairsForMembersProtocol().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link AttachmentType }
         * 
         * 
         */
        public List<AttachmentType> getMaintenanceAndRepairsForMembersProtocol() {
            if (maintenanceAndRepairsForMembersProtocol == null) {
                maintenanceAndRepairsForMembersProtocol = new ArrayList<AttachmentType>();
            }
            return this.maintenanceAndRepairsForMembersProtocol;
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
     *         &lt;element name="MaintenanceAndRepairsForNonMembersPaymentSize" type="{http://dom.gosuslugi.ru/schema/integration/bills-base/}SmallMoneyType"/>
     *         &lt;element name="MaintenanceAndRepairsForNonMembersProtocol" type="{http://dom.gosuslugi.ru/schema/integration/base/}AttachmentType" maxOccurs="unbounded"/>
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
        "maintenanceAndRepairsForNonMembersPaymentSize",
        "maintenanceAndRepairsForNonMembersProtocol"
    })
    public static class MaintenanceAndRepairsForNonMembersInfo {

        @XmlElement(name = "MaintenanceAndRepairsForNonMembersPaymentSize", required = true)
        protected BigDecimal maintenanceAndRepairsForNonMembersPaymentSize;
        @XmlElement(name = "MaintenanceAndRepairsForNonMembersProtocol", required = true)
        protected List<AttachmentType> maintenanceAndRepairsForNonMembersProtocol;

        /**
         * Gets the value of the maintenanceAndRepairsForNonMembersPaymentSize property.
         * 
         * @return
         *     possible object is
         *     {@link BigDecimal }
         *     
         */
        public BigDecimal getMaintenanceAndRepairsForNonMembersPaymentSize() {
            return maintenanceAndRepairsForNonMembersPaymentSize;
        }

        /**
         * Sets the value of the maintenanceAndRepairsForNonMembersPaymentSize property.
         * 
         * @param value
         *     allowed object is
         *     {@link BigDecimal }
         *     
         */
        public void setMaintenanceAndRepairsForNonMembersPaymentSize(BigDecimal value) {
            this.maintenanceAndRepairsForNonMembersPaymentSize = value;
        }

        /**
         * Gets the value of the maintenanceAndRepairsForNonMembersProtocol property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the maintenanceAndRepairsForNonMembersProtocol property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getMaintenanceAndRepairsForNonMembersProtocol().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link AttachmentType }
         * 
         * 
         */
        public List<AttachmentType> getMaintenanceAndRepairsForNonMembersProtocol() {
            if (maintenanceAndRepairsForNonMembersProtocol == null) {
                maintenanceAndRepairsForNonMembersProtocol = new ArrayList<AttachmentType>();
            }
            return this.maintenanceAndRepairsForNonMembersProtocol;
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
     *         &lt;element name="Service" type="{http://dom.gosuslugi.ru/schema/integration/nsi-base/}nsiRef"/>
     *         &lt;element name="ServicePaymentSize" type="{http://dom.gosuslugi.ru/schema/integration/bills-base/}SmallMoneyType"/>
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
        "service",
        "servicePaymentSize"
    })
    public static class ServicePayment {

        @XmlElement(name = "Service", required = true)
        protected NsiRef service;
        @XmlElement(name = "ServicePaymentSize", required = true)
        protected BigDecimal servicePaymentSize;

        /**
         * Gets the value of the service property.
         * 
         * @return
         *     possible object is
         *     {@link NsiRef }
         *     
         */
        public NsiRef getService() {
            return service;
        }

        /**
         * Sets the value of the service property.
         * 
         * @param value
         *     allowed object is
         *     {@link NsiRef }
         *     
         */
        public void setService(NsiRef value) {
            this.service = value;
        }

        /**
         * Gets the value of the servicePaymentSize property.
         * 
         * @return
         *     possible object is
         *     {@link BigDecimal }
         *     
         */
        public BigDecimal getServicePaymentSize() {
            return servicePaymentSize;
        }

        /**
         * Sets the value of the servicePaymentSize property.
         * 
         * @param value
         *     allowed object is
         *     {@link BigDecimal }
         *     
         */
        public void setServicePaymentSize(BigDecimal value) {
            this.servicePaymentSize = value;
        }

    }

}
