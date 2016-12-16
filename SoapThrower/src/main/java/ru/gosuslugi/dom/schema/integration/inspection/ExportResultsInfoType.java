
package ru.gosuslugi.dom.schema.integration.inspection;

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
 * Сведения о результатах проверки для экспорта
 * 
 * <p>Java class for ExportResultsInfoType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ExportResultsInfoType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="FinishedInfo">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="Result" type="{http://dom.gosuslugi.ru/schema/integration/inspection/}ExportExaminationResultsType"/>
 *                   &lt;element name="OtherDocument" type="{http://dom.gosuslugi.ru/schema/integration/base/}AttachmentType" maxOccurs="unbounded"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="FamiliarizationInfo" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;choice>
 *                   &lt;element name="NotFamiliarize" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *                   &lt;sequence>
 *                     &lt;element name="PersonRefused" type="{http://dom.gosuslugi.ru/schema/integration/inspection/}String2000Type"/>
 *                   &lt;/sequence>
 *                   &lt;sequence>
 *                     &lt;element name="FamiliarizationDate" type="{http://www.w3.org/2001/XMLSchema}date"/>
 *                     &lt;element name="IsSigned" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *                     &lt;element name="FamiliarizedPerson" type="{http://dom.gosuslugi.ru/schema/integration/inspection/}String2000Type"/>
 *                   &lt;/sequence>
 *                 &lt;/choice>
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
@XmlType(name = "ExportResultsInfoType", propOrder = {
    "finishedInfo",
    "familiarizationInfo"
})
@XmlSeeAlso({
    ru.gosuslugi.dom.schema.integration.inspection.ExportExaminationType.ResultsInfo.class
})
public class ExportResultsInfoType {

    @XmlElement(name = "FinishedInfo", required = true)
    protected ExportResultsInfoType.FinishedInfo finishedInfo;
    @XmlElement(name = "FamiliarizationInfo")
    protected ExportResultsInfoType.FamiliarizationInfo familiarizationInfo;

    /**
     * Gets the value of the finishedInfo property.
     * 
     * @return
     *     possible object is
     *     {@link ExportResultsInfoType.FinishedInfo }
     *     
     */
    public ExportResultsInfoType.FinishedInfo getFinishedInfo() {
        return finishedInfo;
    }

    /**
     * Sets the value of the finishedInfo property.
     * 
     * @param value
     *     allowed object is
     *     {@link ExportResultsInfoType.FinishedInfo }
     *     
     */
    public void setFinishedInfo(ExportResultsInfoType.FinishedInfo value) {
        this.finishedInfo = value;
    }

    /**
     * Gets the value of the familiarizationInfo property.
     * 
     * @return
     *     possible object is
     *     {@link ExportResultsInfoType.FamiliarizationInfo }
     *     
     */
    public ExportResultsInfoType.FamiliarizationInfo getFamiliarizationInfo() {
        return familiarizationInfo;
    }

    /**
     * Sets the value of the familiarizationInfo property.
     * 
     * @param value
     *     allowed object is
     *     {@link ExportResultsInfoType.FamiliarizationInfo }
     *     
     */
    public void setFamiliarizationInfo(ExportResultsInfoType.FamiliarizationInfo value) {
        this.familiarizationInfo = value;
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
     *         &lt;element name="NotFamiliarize" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
     *         &lt;sequence>
     *           &lt;element name="PersonRefused" type="{http://dom.gosuslugi.ru/schema/integration/inspection/}String2000Type"/>
     *         &lt;/sequence>
     *         &lt;sequence>
     *           &lt;element name="FamiliarizationDate" type="{http://www.w3.org/2001/XMLSchema}date"/>
     *           &lt;element name="IsSigned" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
     *           &lt;element name="FamiliarizedPerson" type="{http://dom.gosuslugi.ru/schema/integration/inspection/}String2000Type"/>
     *         &lt;/sequence>
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
        "notFamiliarize",
        "personRefused",
        "familiarizationDate",
        "isSigned",
        "familiarizedPerson"
    })
    public static class FamiliarizationInfo {

        @XmlElement(name = "NotFamiliarize")
        protected Boolean notFamiliarize;
        @XmlElement(name = "PersonRefused")
        protected String personRefused;
        @XmlElement(name = "FamiliarizationDate")
        @XmlSchemaType(name = "date")
        protected XMLGregorianCalendar familiarizationDate;
        @XmlElement(name = "IsSigned")
        protected Boolean isSigned;
        @XmlElement(name = "FamiliarizedPerson")
        protected String familiarizedPerson;

        /**
         * Gets the value of the notFamiliarize property.
         * 
         * @return
         *     possible object is
         *     {@link Boolean }
         *     
         */
        public Boolean isNotFamiliarize() {
            return notFamiliarize;
        }

        /**
         * Sets the value of the notFamiliarize property.
         * 
         * @param value
         *     allowed object is
         *     {@link Boolean }
         *     
         */
        public void setNotFamiliarize(Boolean value) {
            this.notFamiliarize = value;
        }

        /**
         * Gets the value of the personRefused property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getPersonRefused() {
            return personRefused;
        }

        /**
         * Sets the value of the personRefused property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setPersonRefused(String value) {
            this.personRefused = value;
        }

        /**
         * Gets the value of the familiarizationDate property.
         * 
         * @return
         *     possible object is
         *     {@link XMLGregorianCalendar }
         *     
         */
        public XMLGregorianCalendar getFamiliarizationDate() {
            return familiarizationDate;
        }

        /**
         * Sets the value of the familiarizationDate property.
         * 
         * @param value
         *     allowed object is
         *     {@link XMLGregorianCalendar }
         *     
         */
        public void setFamiliarizationDate(XMLGregorianCalendar value) {
            this.familiarizationDate = value;
        }

        /**
         * Gets the value of the isSigned property.
         * 
         * @return
         *     possible object is
         *     {@link Boolean }
         *     
         */
        public Boolean isIsSigned() {
            return isSigned;
        }

        /**
         * Sets the value of the isSigned property.
         * 
         * @param value
         *     allowed object is
         *     {@link Boolean }
         *     
         */
        public void setIsSigned(Boolean value) {
            this.isSigned = value;
        }

        /**
         * Gets the value of the familiarizedPerson property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getFamiliarizedPerson() {
            return familiarizedPerson;
        }

        /**
         * Sets the value of the familiarizedPerson property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setFamiliarizedPerson(String value) {
            this.familiarizedPerson = value;
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
     *         &lt;element name="Result" type="{http://dom.gosuslugi.ru/schema/integration/inspection/}ExportExaminationResultsType"/>
     *         &lt;element name="OtherDocument" type="{http://dom.gosuslugi.ru/schema/integration/base/}AttachmentType" maxOccurs="unbounded"/>
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
        "result",
        "otherDocument"
    })
    public static class FinishedInfo {

        @XmlElement(name = "Result", required = true)
        protected ExportExaminationResultsType result;
        @XmlElement(name = "OtherDocument", required = true)
        protected List<AttachmentType> otherDocument;

        /**
         * Gets the value of the result property.
         * 
         * @return
         *     possible object is
         *     {@link ExportExaminationResultsType }
         *     
         */
        public ExportExaminationResultsType getResult() {
            return result;
        }

        /**
         * Sets the value of the result property.
         * 
         * @param value
         *     allowed object is
         *     {@link ExportExaminationResultsType }
         *     
         */
        public void setResult(ExportExaminationResultsType value) {
            this.result = value;
        }

        /**
         * Gets the value of the otherDocument property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the otherDocument property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getOtherDocument().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link AttachmentType }
         * 
         * 
         */
        public List<AttachmentType> getOtherDocument() {
            if (otherDocument == null) {
                otherDocument = new ArrayList<AttachmentType>();
            }
            return this.otherDocument;
        }

    }

}
