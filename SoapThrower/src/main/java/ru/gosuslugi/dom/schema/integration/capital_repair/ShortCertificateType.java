
package ru.gosuslugi.dom.schema.integration.capital_repair;

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


/**
 * Акт выполненных работ (оказанных услуг)
 * 
 * <p>Java class for ShortCertificateType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ShortCertificateType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Name" type="{http://dom.gosuslugi.ru/schema/integration/capital-repair/}String512Type"/>
 *         &lt;element name="Number" type="{http://dom.gosuslugi.ru/schema/integration/capital-repair/}String512Type"/>
 *         &lt;element name="Date" type="{http://www.w3.org/2001/XMLSchema}date"/>
 *         &lt;element name="SumAcceptedWorks" type="{http://dom.gosuslugi.ru/schema/integration/bills-base/}MoneyPositiveType"/>
 *         &lt;element name="PerformerPenalties" type="{http://dom.gosuslugi.ru/schema/integration/bills-base/}MoneyPositiveType"/>
 *         &lt;element name="CustomerPenalties" type="{http://dom.gosuslugi.ru/schema/integration/bills-base/}MoneyPositiveType"/>
 *         &lt;element name="AttachCertificate" type="{http://dom.gosuslugi.ru/schema/integration/base/}AttachmentType" maxOccurs="unbounded"/>
 *         &lt;element name="AttachPhotoBefore" type="{http://dom.gosuslugi.ru/schema/integration/base/}AttachmentType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="AttachPhotoAfter" type="{http://dom.gosuslugi.ru/schema/integration/base/}AttachmentType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;choice>
 *           &lt;element name="ActSignedRepresentativeOfOwners">
 *             &lt;complexType>
 *               &lt;complexContent>
 *                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                   &lt;sequence>
 *                     &lt;element name="SurnameRepresentativeOwners" type="{http://dom.gosuslugi.ru/schema/integration/base/}String100Type"/>
 *                     &lt;element name="NameRepresentativeOwners" type="{http://dom.gosuslugi.ru/schema/integration/base/}String100Type"/>
 *                     &lt;element name="PatronymicRepresentativeOwners" type="{http://dom.gosuslugi.ru/schema/integration/base/}String100Type" minOccurs="0"/>
 *                   &lt;/sequence>
 *                 &lt;/restriction>
 *               &lt;/complexContent>
 *             &lt;/complexType>
 *           &lt;/element>
 *           &lt;element name="ActNotSignedRepresentativeOfOwners" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;/choice>
 *         &lt;choice>
 *           &lt;element name="InstallmentInfo" type="{http://dom.gosuslugi.ru/schema/integration/capital-repair/}InstallmentInfoType" maxOccurs="unbounded"/>
 *           &lt;element name="InstallmenNotGiven" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
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
@XmlType(name = "ShortCertificateType", propOrder = {
    "name",
    "number",
    "date",
    "sumAcceptedWorks",
    "performerPenalties",
    "customerPenalties",
    "attachCertificate",
    "attachPhotoBefore",
    "attachPhotoAfter",
    "actSignedRepresentativeOfOwners",
    "actNotSignedRepresentativeOfOwners",
    "installmentInfo",
    "installmenNotGiven"
})
@XmlSeeAlso({
    ExportCertificateType.class,
    CertificateType.class
})
public class ShortCertificateType {

    @XmlElement(name = "Name", required = true)
    protected String name;
    @XmlElement(name = "Number", required = true)
    protected String number;
    @XmlElement(name = "Date", required = true)
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar date;
    @XmlElement(name = "SumAcceptedWorks", required = true)
    protected BigDecimal sumAcceptedWorks;
    @XmlElement(name = "PerformerPenalties", required = true)
    protected BigDecimal performerPenalties;
    @XmlElement(name = "CustomerPenalties", required = true)
    protected BigDecimal customerPenalties;
    @XmlElement(name = "AttachCertificate", required = true)
    protected List<AttachmentType> attachCertificate;
    @XmlElement(name = "AttachPhotoBefore")
    protected List<AttachmentType> attachPhotoBefore;
    @XmlElement(name = "AttachPhotoAfter")
    protected List<AttachmentType> attachPhotoAfter;
    @XmlElement(name = "ActSignedRepresentativeOfOwners")
    protected ShortCertificateType.ActSignedRepresentativeOfOwners actSignedRepresentativeOfOwners;
    @XmlElement(name = "ActNotSignedRepresentativeOfOwners")
    protected Boolean actNotSignedRepresentativeOfOwners;
    @XmlElement(name = "InstallmentInfo")
    protected List<InstallmentInfoType> installmentInfo;
    @XmlElement(name = "InstallmenNotGiven")
    protected Boolean installmenNotGiven;

    /**
     * Gets the value of the name property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the value of the name property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setName(String value) {
        this.name = value;
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
     * Gets the value of the sumAcceptedWorks property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getSumAcceptedWorks() {
        return sumAcceptedWorks;
    }

    /**
     * Sets the value of the sumAcceptedWorks property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setSumAcceptedWorks(BigDecimal value) {
        this.sumAcceptedWorks = value;
    }

    /**
     * Gets the value of the performerPenalties property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getPerformerPenalties() {
        return performerPenalties;
    }

    /**
     * Sets the value of the performerPenalties property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setPerformerPenalties(BigDecimal value) {
        this.performerPenalties = value;
    }

    /**
     * Gets the value of the customerPenalties property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getCustomerPenalties() {
        return customerPenalties;
    }

    /**
     * Sets the value of the customerPenalties property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setCustomerPenalties(BigDecimal value) {
        this.customerPenalties = value;
    }

    /**
     * Gets the value of the attachCertificate property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the attachCertificate property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAttachCertificate().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link AttachmentType }
     * 
     * 
     */
    public List<AttachmentType> getAttachCertificate() {
        if (attachCertificate == null) {
            attachCertificate = new ArrayList<AttachmentType>();
        }
        return this.attachCertificate;
    }

    /**
     * Gets the value of the attachPhotoBefore property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the attachPhotoBefore property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAttachPhotoBefore().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link AttachmentType }
     * 
     * 
     */
    public List<AttachmentType> getAttachPhotoBefore() {
        if (attachPhotoBefore == null) {
            attachPhotoBefore = new ArrayList<AttachmentType>();
        }
        return this.attachPhotoBefore;
    }

    /**
     * Gets the value of the attachPhotoAfter property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the attachPhotoAfter property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAttachPhotoAfter().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link AttachmentType }
     * 
     * 
     */
    public List<AttachmentType> getAttachPhotoAfter() {
        if (attachPhotoAfter == null) {
            attachPhotoAfter = new ArrayList<AttachmentType>();
        }
        return this.attachPhotoAfter;
    }

    /**
     * Gets the value of the actSignedRepresentativeOfOwners property.
     * 
     * @return
     *     possible object is
     *     {@link ShortCertificateType.ActSignedRepresentativeOfOwners }
     *     
     */
    public ShortCertificateType.ActSignedRepresentativeOfOwners getActSignedRepresentativeOfOwners() {
        return actSignedRepresentativeOfOwners;
    }

    /**
     * Sets the value of the actSignedRepresentativeOfOwners property.
     * 
     * @param value
     *     allowed object is
     *     {@link ShortCertificateType.ActSignedRepresentativeOfOwners }
     *     
     */
    public void setActSignedRepresentativeOfOwners(ShortCertificateType.ActSignedRepresentativeOfOwners value) {
        this.actSignedRepresentativeOfOwners = value;
    }

    /**
     * Gets the value of the actNotSignedRepresentativeOfOwners property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isActNotSignedRepresentativeOfOwners() {
        return actNotSignedRepresentativeOfOwners;
    }

    /**
     * Sets the value of the actNotSignedRepresentativeOfOwners property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setActNotSignedRepresentativeOfOwners(Boolean value) {
        this.actNotSignedRepresentativeOfOwners = value;
    }

    /**
     * Gets the value of the installmentInfo property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the installmentInfo property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getInstallmentInfo().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link InstallmentInfoType }
     * 
     * 
     */
    public List<InstallmentInfoType> getInstallmentInfo() {
        if (installmentInfo == null) {
            installmentInfo = new ArrayList<InstallmentInfoType>();
        }
        return this.installmentInfo;
    }

    /**
     * Gets the value of the installmenNotGiven property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isInstallmenNotGiven() {
        return installmenNotGiven;
    }

    /**
     * Sets the value of the installmenNotGiven property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setInstallmenNotGiven(Boolean value) {
        this.installmenNotGiven = value;
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
     *         &lt;element name="SurnameRepresentativeOwners" type="{http://dom.gosuslugi.ru/schema/integration/base/}String100Type"/>
     *         &lt;element name="NameRepresentativeOwners" type="{http://dom.gosuslugi.ru/schema/integration/base/}String100Type"/>
     *         &lt;element name="PatronymicRepresentativeOwners" type="{http://dom.gosuslugi.ru/schema/integration/base/}String100Type" minOccurs="0"/>
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
        "surnameRepresentativeOwners",
        "nameRepresentativeOwners",
        "patronymicRepresentativeOwners"
    })
    public static class ActSignedRepresentativeOfOwners {

        @XmlElement(name = "SurnameRepresentativeOwners", required = true)
        protected String surnameRepresentativeOwners;
        @XmlElement(name = "NameRepresentativeOwners", required = true)
        protected String nameRepresentativeOwners;
        @XmlElement(name = "PatronymicRepresentativeOwners")
        protected String patronymicRepresentativeOwners;

        /**
         * Gets the value of the surnameRepresentativeOwners property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getSurnameRepresentativeOwners() {
            return surnameRepresentativeOwners;
        }

        /**
         * Sets the value of the surnameRepresentativeOwners property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setSurnameRepresentativeOwners(String value) {
            this.surnameRepresentativeOwners = value;
        }

        /**
         * Gets the value of the nameRepresentativeOwners property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getNameRepresentativeOwners() {
            return nameRepresentativeOwners;
        }

        /**
         * Sets the value of the nameRepresentativeOwners property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setNameRepresentativeOwners(String value) {
            this.nameRepresentativeOwners = value;
        }

        /**
         * Gets the value of the patronymicRepresentativeOwners property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getPatronymicRepresentativeOwners() {
            return patronymicRepresentativeOwners;
        }

        /**
         * Sets the value of the patronymicRepresentativeOwners property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setPatronymicRepresentativeOwners(String value) {
            this.patronymicRepresentativeOwners = value;
        }

    }

}
