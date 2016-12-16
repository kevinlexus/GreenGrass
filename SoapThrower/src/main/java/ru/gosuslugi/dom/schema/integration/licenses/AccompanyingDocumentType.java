
package ru.gosuslugi.dom.schema.integration.licenses;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;
import ru.gosuslugi.dom.schema.integration.nsi_base.NsiRef;
import ru.gosuslugi.dom.schema.integration.organizations_registry_base.LegalType;


/**
 * Документы лицензионного дела
 * 
 * <p>Java class for AccompanyingDocumentType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="AccompanyingDocumentType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Document">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="DocType" type="{http://dom.gosuslugi.ru/schema/integration/nsi-base/}nsiRef"/>
 *                   &lt;element name="RegDate" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
 *                   &lt;element name="DecisionOrg">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/organizations-registry-base/}LegalType">
 *                         &lt;/extension>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                   &lt;element name="Name" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="Number" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="DocumentStatus">
 *                     &lt;simpleType>
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                         &lt;enumeration value="A"/>
 *                         &lt;enumeration value="C"/>
 *                       &lt;/restriction>
 *                     &lt;/simpleType>
 *                   &lt;/element>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="BaseDocument">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="BaseDocType" type="{http://dom.gosuslugi.ru/schema/integration/nsi-base/}nsiRef" minOccurs="0"/>
 *                   &lt;element name="BaseDocDecisionOrg" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="BaseDocName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="BaseDocNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="BaseDocDate" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
 *                   &lt;element name="DateFrom" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
 *                   &lt;element name="AdditionalInfo" type="{http://dom.gosuslugi.ru/schema/integration/base/}LongTextType" minOccurs="0"/>
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
@XmlType(name = "AccompanyingDocumentType", propOrder = {
    "document",
    "baseDocument"
})
@XmlSeeAlso({
    ru.gosuslugi.dom.schema.integration.licenses.LicenseType.AccompanyingDocument.class,
    ru.gosuslugi.dom.schema.integration.licenses.CorrectLicenseType.AccompanyingDocument.class
})
public class AccompanyingDocumentType {

    @XmlElement(name = "Document", required = true)
    protected AccompanyingDocumentType.Document document;
    @XmlElement(name = "BaseDocument", required = true)
    protected AccompanyingDocumentType.BaseDocument baseDocument;

    /**
     * Gets the value of the document property.
     * 
     * @return
     *     possible object is
     *     {@link AccompanyingDocumentType.Document }
     *     
     */
    public AccompanyingDocumentType.Document getDocument() {
        return document;
    }

    /**
     * Sets the value of the document property.
     * 
     * @param value
     *     allowed object is
     *     {@link AccompanyingDocumentType.Document }
     *     
     */
    public void setDocument(AccompanyingDocumentType.Document value) {
        this.document = value;
    }

    /**
     * Gets the value of the baseDocument property.
     * 
     * @return
     *     possible object is
     *     {@link AccompanyingDocumentType.BaseDocument }
     *     
     */
    public AccompanyingDocumentType.BaseDocument getBaseDocument() {
        return baseDocument;
    }

    /**
     * Sets the value of the baseDocument property.
     * 
     * @param value
     *     allowed object is
     *     {@link AccompanyingDocumentType.BaseDocument }
     *     
     */
    public void setBaseDocument(AccompanyingDocumentType.BaseDocument value) {
        this.baseDocument = value;
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
     *         &lt;element name="BaseDocType" type="{http://dom.gosuslugi.ru/schema/integration/nsi-base/}nsiRef" minOccurs="0"/>
     *         &lt;element name="BaseDocDecisionOrg" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="BaseDocName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="BaseDocNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="BaseDocDate" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
     *         &lt;element name="DateFrom" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
     *         &lt;element name="AdditionalInfo" type="{http://dom.gosuslugi.ru/schema/integration/base/}LongTextType" minOccurs="0"/>
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
        "baseDocType",
        "baseDocDecisionOrg",
        "baseDocName",
        "baseDocNumber",
        "baseDocDate",
        "dateFrom",
        "additionalInfo"
    })
    public static class BaseDocument {

        @XmlElement(name = "BaseDocType")
        protected NsiRef baseDocType;
        @XmlElement(name = "BaseDocDecisionOrg")
        protected String baseDocDecisionOrg;
        @XmlElement(name = "BaseDocName")
        protected String baseDocName;
        @XmlElement(name = "BaseDocNumber")
        protected String baseDocNumber;
        @XmlElement(name = "BaseDocDate")
        @XmlSchemaType(name = "date")
        protected XMLGregorianCalendar baseDocDate;
        @XmlElement(name = "DateFrom")
        @XmlSchemaType(name = "date")
        protected XMLGregorianCalendar dateFrom;
        @XmlElement(name = "AdditionalInfo")
        protected String additionalInfo;

        /**
         * Gets the value of the baseDocType property.
         * 
         * @return
         *     possible object is
         *     {@link NsiRef }
         *     
         */
        public NsiRef getBaseDocType() {
            return baseDocType;
        }

        /**
         * Sets the value of the baseDocType property.
         * 
         * @param value
         *     allowed object is
         *     {@link NsiRef }
         *     
         */
        public void setBaseDocType(NsiRef value) {
            this.baseDocType = value;
        }

        /**
         * Gets the value of the baseDocDecisionOrg property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getBaseDocDecisionOrg() {
            return baseDocDecisionOrg;
        }

        /**
         * Sets the value of the baseDocDecisionOrg property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setBaseDocDecisionOrg(String value) {
            this.baseDocDecisionOrg = value;
        }

        /**
         * Gets the value of the baseDocName property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getBaseDocName() {
            return baseDocName;
        }

        /**
         * Sets the value of the baseDocName property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setBaseDocName(String value) {
            this.baseDocName = value;
        }

        /**
         * Gets the value of the baseDocNumber property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getBaseDocNumber() {
            return baseDocNumber;
        }

        /**
         * Sets the value of the baseDocNumber property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setBaseDocNumber(String value) {
            this.baseDocNumber = value;
        }

        /**
         * Gets the value of the baseDocDate property.
         * 
         * @return
         *     possible object is
         *     {@link XMLGregorianCalendar }
         *     
         */
        public XMLGregorianCalendar getBaseDocDate() {
            return baseDocDate;
        }

        /**
         * Sets the value of the baseDocDate property.
         * 
         * @param value
         *     allowed object is
         *     {@link XMLGregorianCalendar }
         *     
         */
        public void setBaseDocDate(XMLGregorianCalendar value) {
            this.baseDocDate = value;
        }

        /**
         * Gets the value of the dateFrom property.
         * 
         * @return
         *     possible object is
         *     {@link XMLGregorianCalendar }
         *     
         */
        public XMLGregorianCalendar getDateFrom() {
            return dateFrom;
        }

        /**
         * Sets the value of the dateFrom property.
         * 
         * @param value
         *     allowed object is
         *     {@link XMLGregorianCalendar }
         *     
         */
        public void setDateFrom(XMLGregorianCalendar value) {
            this.dateFrom = value;
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
     *         &lt;element name="DocType" type="{http://dom.gosuslugi.ru/schema/integration/nsi-base/}nsiRef"/>
     *         &lt;element name="RegDate" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
     *         &lt;element name="DecisionOrg">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/organizations-registry-base/}LegalType">
     *               &lt;/extension>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *         &lt;element name="Name" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="Number" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="DocumentStatus">
     *           &lt;simpleType>
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *               &lt;enumeration value="A"/>
     *               &lt;enumeration value="C"/>
     *             &lt;/restriction>
     *           &lt;/simpleType>
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
        "docType",
        "regDate",
        "decisionOrg",
        "name",
        "number",
        "documentStatus"
    })
    public static class Document {

        @XmlElement(name = "DocType", required = true)
        protected NsiRef docType;
        @XmlElement(name = "RegDate")
        @XmlSchemaType(name = "date")
        protected XMLGregorianCalendar regDate;
        @XmlElement(name = "DecisionOrg", required = true)
        protected AccompanyingDocumentType.Document.DecisionOrg decisionOrg;
        @XmlElement(name = "Name", required = true)
        protected String name;
        @XmlElement(name = "Number")
        protected String number;
        @XmlElement(name = "DocumentStatus", required = true)
        protected String documentStatus;

        /**
         * Gets the value of the docType property.
         * 
         * @return
         *     possible object is
         *     {@link NsiRef }
         *     
         */
        public NsiRef getDocType() {
            return docType;
        }

        /**
         * Sets the value of the docType property.
         * 
         * @param value
         *     allowed object is
         *     {@link NsiRef }
         *     
         */
        public void setDocType(NsiRef value) {
            this.docType = value;
        }

        /**
         * Gets the value of the regDate property.
         * 
         * @return
         *     possible object is
         *     {@link XMLGregorianCalendar }
         *     
         */
        public XMLGregorianCalendar getRegDate() {
            return regDate;
        }

        /**
         * Sets the value of the regDate property.
         * 
         * @param value
         *     allowed object is
         *     {@link XMLGregorianCalendar }
         *     
         */
        public void setRegDate(XMLGregorianCalendar value) {
            this.regDate = value;
        }

        /**
         * Gets the value of the decisionOrg property.
         * 
         * @return
         *     possible object is
         *     {@link AccompanyingDocumentType.Document.DecisionOrg }
         *     
         */
        public AccompanyingDocumentType.Document.DecisionOrg getDecisionOrg() {
            return decisionOrg;
        }

        /**
         * Sets the value of the decisionOrg property.
         * 
         * @param value
         *     allowed object is
         *     {@link AccompanyingDocumentType.Document.DecisionOrg }
         *     
         */
        public void setDecisionOrg(AccompanyingDocumentType.Document.DecisionOrg value) {
            this.decisionOrg = value;
        }

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
         * Gets the value of the documentStatus property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getDocumentStatus() {
            return documentStatus;
        }

        /**
         * Sets the value of the documentStatus property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setDocumentStatus(String value) {
            this.documentStatus = value;
        }


        /**
         * <p>Java class for anonymous complex type.
         * 
         * <p>The following schema fragment specifies the expected content contained within this class.
         * 
         * <pre>
         * &lt;complexType>
         *   &lt;complexContent>
         *     &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/organizations-registry-base/}LegalType">
         *     &lt;/extension>
         *   &lt;/complexContent>
         * &lt;/complexType>
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "")
        public static class DecisionOrg
            extends LegalType
        {


        }

    }

}
