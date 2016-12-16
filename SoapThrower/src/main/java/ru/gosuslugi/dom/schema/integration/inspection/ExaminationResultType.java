
package ru.gosuslugi.dom.schema.integration.inspection;

import java.math.BigInteger;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;
import ru.gosuslugi.dom.schema.integration.nsi_base.NsiRef;


/**
 * Результат проверки.
 * 
 * <p>Java class for ExaminationResultType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ExaminationResultType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="DocumentType" type="{http://dom.gosuslugi.ru/schema/integration/nsi-base/}nsiRef"/>
 *         &lt;element name="Number" type="{http://dom.gosuslugi.ru/schema/integration/inspection/}String255Type"/>
 *         &lt;element name="Date" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;choice>
 *           &lt;element name="HasNoOffence" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *           &lt;sequence>
 *             &lt;element name="HasOffence" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *             &lt;element name="IdentifiedOffencesInfo" minOccurs="0">
 *               &lt;complexType>
 *                 &lt;complexContent>
 *                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                     &lt;sequence>
 *                       &lt;element name="IdentifiedOffences" type="{http://dom.gosuslugi.ru/schema/integration/inspection/}String2000Type" minOccurs="0"/>
 *                       &lt;element name="DetailsMismatch" type="{http://dom.gosuslugi.ru/schema/integration/inspection/}String2000Type" minOccurs="0"/>
 *                       &lt;element name="MaterialsDirectionAgency" type="{http://dom.gosuslugi.ru/schema/integration/inspection/}String2000Type" minOccurs="0"/>
 *                       &lt;element name="MaterialsDirectionDate" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
 *                       &lt;element name="ApplyingMeasures" type="{http://dom.gosuslugi.ru/schema/integration/inspection/}String2000Type" minOccurs="0"/>
 *                       &lt;element name="PersonsAdministrativeResponsibilityInfo" type="{http://dom.gosuslugi.ru/schema/integration/inspection/}String2000Type" minOccurs="0"/>
 *                       &lt;element name="PermittingDocumensAnnulmentInfo" type="{http://dom.gosuslugi.ru/schema/integration/inspection/}String2000Type" minOccurs="0"/>
 *                       &lt;element name="AppealInfo" type="{http://dom.gosuslugi.ru/schema/integration/inspection/}String2000Type" minOccurs="0"/>
 *                     &lt;/sequence>
 *                   &lt;/restriction>
 *                 &lt;/complexContent>
 *               &lt;/complexType>
 *             &lt;/element>
 *           &lt;/sequence>
 *         &lt;/choice>
 *         &lt;element name="From" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="To" type="{http://www.w3.org/2001/XMLSchema}date"/>
 *         &lt;element name="Duration">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}integer">
 *               &lt;minInclusive value="1"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="Place" type="{http://dom.gosuslugi.ru/schema/integration/inspection/}String2000Type"/>
 *         &lt;element name="InspectionPersons" type="{http://dom.gosuslugi.ru/schema/integration/inspection/}String2000Type"/>
 *         &lt;element name="RepresentativesRegionPersons" type="{http://dom.gosuslugi.ru/schema/integration/inspection/}String2000Type"/>
 *         &lt;element name="SettlingDocumentPlace" type="{http://dom.gosuslugi.ru/schema/integration/inspection/}String2000Type"/>
 *         &lt;element name="AdditionalInfo" type="{http://dom.gosuslugi.ru/schema/integration/inspection/}String2000Type" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ExaminationResultType", propOrder = {
    "documentType",
    "number",
    "date",
    "hasNoOffence",
    "hasOffence",
    "identifiedOffencesInfo",
    "from",
    "to",
    "duration",
    "place",
    "inspectionPersons",
    "representativesRegionPersons",
    "settlingDocumentPlace",
    "additionalInfo"
})
public class ExaminationResultType {

    @XmlElement(name = "DocumentType", required = true)
    protected NsiRef documentType;
    @XmlElement(name = "Number", required = true)
    protected String number;
    @XmlElement(name = "Date", required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar date;
    @XmlElement(name = "HasNoOffence")
    protected Boolean hasNoOffence;
    @XmlElement(name = "HasOffence")
    protected Boolean hasOffence;
    @XmlElement(name = "IdentifiedOffencesInfo")
    protected ExaminationResultType.IdentifiedOffencesInfo identifiedOffencesInfo;
    @XmlElement(name = "From", required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar from;
    @XmlElement(name = "To", required = true)
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar to;
    @XmlElement(name = "Duration", required = true)
    protected BigInteger duration;
    @XmlElement(name = "Place", required = true)
    protected String place;
    @XmlElement(name = "InspectionPersons", required = true)
    protected String inspectionPersons;
    @XmlElement(name = "RepresentativesRegionPersons", required = true)
    protected String representativesRegionPersons;
    @XmlElement(name = "SettlingDocumentPlace", required = true)
    protected String settlingDocumentPlace;
    @XmlElement(name = "AdditionalInfo")
    protected String additionalInfo;

    /**
     * Gets the value of the documentType property.
     * 
     * @return
     *     possible object is
     *     {@link NsiRef }
     *     
     */
    public NsiRef getDocumentType() {
        return documentType;
    }

    /**
     * Sets the value of the documentType property.
     * 
     * @param value
     *     allowed object is
     *     {@link NsiRef }
     *     
     */
    public void setDocumentType(NsiRef value) {
        this.documentType = value;
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
     * Gets the value of the hasNoOffence property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isHasNoOffence() {
        return hasNoOffence;
    }

    /**
     * Sets the value of the hasNoOffence property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setHasNoOffence(Boolean value) {
        this.hasNoOffence = value;
    }

    /**
     * Gets the value of the hasOffence property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isHasOffence() {
        return hasOffence;
    }

    /**
     * Sets the value of the hasOffence property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setHasOffence(Boolean value) {
        this.hasOffence = value;
    }

    /**
     * Gets the value of the identifiedOffencesInfo property.
     * 
     * @return
     *     possible object is
     *     {@link ExaminationResultType.IdentifiedOffencesInfo }
     *     
     */
    public ExaminationResultType.IdentifiedOffencesInfo getIdentifiedOffencesInfo() {
        return identifiedOffencesInfo;
    }

    /**
     * Sets the value of the identifiedOffencesInfo property.
     * 
     * @param value
     *     allowed object is
     *     {@link ExaminationResultType.IdentifiedOffencesInfo }
     *     
     */
    public void setIdentifiedOffencesInfo(ExaminationResultType.IdentifiedOffencesInfo value) {
        this.identifiedOffencesInfo = value;
    }

    /**
     * Gets the value of the from property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getFrom() {
        return from;
    }

    /**
     * Sets the value of the from property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setFrom(XMLGregorianCalendar value) {
        this.from = value;
    }

    /**
     * Gets the value of the to property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getTo() {
        return to;
    }

    /**
     * Sets the value of the to property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setTo(XMLGregorianCalendar value) {
        this.to = value;
    }

    /**
     * Gets the value of the duration property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getDuration() {
        return duration;
    }

    /**
     * Sets the value of the duration property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setDuration(BigInteger value) {
        this.duration = value;
    }

    /**
     * Gets the value of the place property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPlace() {
        return place;
    }

    /**
     * Sets the value of the place property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPlace(String value) {
        this.place = value;
    }

    /**
     * Gets the value of the inspectionPersons property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getInspectionPersons() {
        return inspectionPersons;
    }

    /**
     * Sets the value of the inspectionPersons property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setInspectionPersons(String value) {
        this.inspectionPersons = value;
    }

    /**
     * Gets the value of the representativesRegionPersons property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRepresentativesRegionPersons() {
        return representativesRegionPersons;
    }

    /**
     * Sets the value of the representativesRegionPersons property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRepresentativesRegionPersons(String value) {
        this.representativesRegionPersons = value;
    }

    /**
     * Gets the value of the settlingDocumentPlace property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSettlingDocumentPlace() {
        return settlingDocumentPlace;
    }

    /**
     * Sets the value of the settlingDocumentPlace property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSettlingDocumentPlace(String value) {
        this.settlingDocumentPlace = value;
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
     *         &lt;element name="IdentifiedOffences" type="{http://dom.gosuslugi.ru/schema/integration/inspection/}String2000Type" minOccurs="0"/>
     *         &lt;element name="DetailsMismatch" type="{http://dom.gosuslugi.ru/schema/integration/inspection/}String2000Type" minOccurs="0"/>
     *         &lt;element name="MaterialsDirectionAgency" type="{http://dom.gosuslugi.ru/schema/integration/inspection/}String2000Type" minOccurs="0"/>
     *         &lt;element name="MaterialsDirectionDate" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
     *         &lt;element name="ApplyingMeasures" type="{http://dom.gosuslugi.ru/schema/integration/inspection/}String2000Type" minOccurs="0"/>
     *         &lt;element name="PersonsAdministrativeResponsibilityInfo" type="{http://dom.gosuslugi.ru/schema/integration/inspection/}String2000Type" minOccurs="0"/>
     *         &lt;element name="PermittingDocumensAnnulmentInfo" type="{http://dom.gosuslugi.ru/schema/integration/inspection/}String2000Type" minOccurs="0"/>
     *         &lt;element name="AppealInfo" type="{http://dom.gosuslugi.ru/schema/integration/inspection/}String2000Type" minOccurs="0"/>
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
        "identifiedOffences",
        "detailsMismatch",
        "materialsDirectionAgency",
        "materialsDirectionDate",
        "applyingMeasures",
        "personsAdministrativeResponsibilityInfo",
        "permittingDocumensAnnulmentInfo",
        "appealInfo"
    })
    public static class IdentifiedOffencesInfo {

        @XmlElement(name = "IdentifiedOffences")
        protected String identifiedOffences;
        @XmlElement(name = "DetailsMismatch")
        protected String detailsMismatch;
        @XmlElement(name = "MaterialsDirectionAgency")
        protected String materialsDirectionAgency;
        @XmlElement(name = "MaterialsDirectionDate")
        @XmlSchemaType(name = "date")
        protected XMLGregorianCalendar materialsDirectionDate;
        @XmlElement(name = "ApplyingMeasures")
        protected String applyingMeasures;
        @XmlElement(name = "PersonsAdministrativeResponsibilityInfo")
        protected String personsAdministrativeResponsibilityInfo;
        @XmlElement(name = "PermittingDocumensAnnulmentInfo")
        protected String permittingDocumensAnnulmentInfo;
        @XmlElement(name = "AppealInfo")
        protected String appealInfo;

        /**
         * Gets the value of the identifiedOffences property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getIdentifiedOffences() {
            return identifiedOffences;
        }

        /**
         * Sets the value of the identifiedOffences property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setIdentifiedOffences(String value) {
            this.identifiedOffences = value;
        }

        /**
         * Gets the value of the detailsMismatch property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getDetailsMismatch() {
            return detailsMismatch;
        }

        /**
         * Sets the value of the detailsMismatch property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setDetailsMismatch(String value) {
            this.detailsMismatch = value;
        }

        /**
         * Gets the value of the materialsDirectionAgency property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getMaterialsDirectionAgency() {
            return materialsDirectionAgency;
        }

        /**
         * Sets the value of the materialsDirectionAgency property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setMaterialsDirectionAgency(String value) {
            this.materialsDirectionAgency = value;
        }

        /**
         * Gets the value of the materialsDirectionDate property.
         * 
         * @return
         *     possible object is
         *     {@link XMLGregorianCalendar }
         *     
         */
        public XMLGregorianCalendar getMaterialsDirectionDate() {
            return materialsDirectionDate;
        }

        /**
         * Sets the value of the materialsDirectionDate property.
         * 
         * @param value
         *     allowed object is
         *     {@link XMLGregorianCalendar }
         *     
         */
        public void setMaterialsDirectionDate(XMLGregorianCalendar value) {
            this.materialsDirectionDate = value;
        }

        /**
         * Gets the value of the applyingMeasures property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getApplyingMeasures() {
            return applyingMeasures;
        }

        /**
         * Sets the value of the applyingMeasures property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setApplyingMeasures(String value) {
            this.applyingMeasures = value;
        }

        /**
         * Gets the value of the personsAdministrativeResponsibilityInfo property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getPersonsAdministrativeResponsibilityInfo() {
            return personsAdministrativeResponsibilityInfo;
        }

        /**
         * Sets the value of the personsAdministrativeResponsibilityInfo property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setPersonsAdministrativeResponsibilityInfo(String value) {
            this.personsAdministrativeResponsibilityInfo = value;
        }

        /**
         * Gets the value of the permittingDocumensAnnulmentInfo property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getPermittingDocumensAnnulmentInfo() {
            return permittingDocumensAnnulmentInfo;
        }

        /**
         * Sets the value of the permittingDocumensAnnulmentInfo property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setPermittingDocumensAnnulmentInfo(String value) {
            this.permittingDocumensAnnulmentInfo = value;
        }

        /**
         * Gets the value of the appealInfo property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getAppealInfo() {
            return appealInfo;
        }

        /**
         * Sets the value of the appealInfo property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setAppealInfo(String value) {
            this.appealInfo = value;
        }

    }

}
