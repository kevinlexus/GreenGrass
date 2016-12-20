
package ru.gosuslugi.dom.schema.integration.inspection;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import ru.gosuslugi.dom.schema.integration.base.BaseType;


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
 *         &lt;element name="ImportExamination" maxOccurs="1000">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;sequence>
 *                     &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/base/}TransportGUID"/>
 *                     &lt;element name="ExaminationGuid" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType" minOccurs="0"/>
 *                   &lt;/sequence>
 *                   &lt;element name="Examination" type="{http://dom.gosuslugi.ru/schema/integration/inspection/}ExaminationType" minOccurs="0"/>
 *                   &lt;element name="CancelExamination" type="{http://dom.gosuslugi.ru/schema/integration/inspection/}CancelledInfoWithAttachmentsType" minOccurs="0"/>
 *                   &lt;element name="AnnulExamination" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *                   &lt;element name="Results" minOccurs="0">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;choice>
 *                             &lt;element name="ResultsInfo" type="{http://dom.gosuslugi.ru/schema/integration/inspection/}ResultsInfoType"/>
 *                             &lt;element name="CancelExaminationResults" type="{http://dom.gosuslugi.ru/schema/integration/inspection/}CancelledInfoWithAttachmentsType"/>
 *                             &lt;element name="AnnulExaminationResults" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *                           &lt;/choice>
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                   &lt;element name="ImportPrecept" maxOccurs="unbounded" minOccurs="0">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;sequence>
 *                               &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/base/}TransportGUID"/>
 *                               &lt;element name="PreceptGuid" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType" minOccurs="0"/>
 *                             &lt;/sequence>
 *                             &lt;choice>
 *                               &lt;element name="Precept" type="{http://dom.gosuslugi.ru/schema/integration/inspection/}PreceptType"/>
 *                               &lt;element name="CancelPrecept" type="{http://dom.gosuslugi.ru/schema/integration/inspection/}CancelledInfoWithAttachmentsType"/>
 *                               &lt;element name="IsFulfiledPrecept" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *                               &lt;element name="DeletePrecept" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *                             &lt;/choice>
 *                           &lt;/sequence>
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                   &lt;element name="ImportOffence" maxOccurs="unbounded" minOccurs="0">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;sequence>
 *                               &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/base/}TransportGUID"/>
 *                               &lt;element name="OffenceGuid" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType" minOccurs="0"/>
 *                             &lt;/sequence>
 *                             &lt;choice>
 *                               &lt;element name="Offence" type="{http://dom.gosuslugi.ru/schema/integration/inspection/}OffenceType"/>
 *                               &lt;element name="CancelOffence" type="{http://dom.gosuslugi.ru/schema/integration/inspection/}CancelledInfoWithAttachmentsType"/>
 *                               &lt;element name="IsFulfiledOffence" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *                               &lt;element name="DeleteOffence" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *                             &lt;/choice>
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
 *       &lt;/sequence>
 *       &lt;attribute ref="{http://dom.gosuslugi.ru/schema/integration/base/}version use="required" fixed="11.0.0.5""/>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "importExamination"
})
@XmlRootElement(name = "importExaminationsRequest")
public class ImportExaminationsRequest
    extends BaseType
{

    @XmlElement(name = "ImportExamination", required = true)
    protected List<ImportExaminationsRequest.ImportExamination> importExamination;
    @XmlAttribute(name = "version", namespace = "http://dom.gosuslugi.ru/schema/integration/base/", required = true)
    protected String version;

    /**
     * Gets the value of the importExamination property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the importExamination property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getImportExamination().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ImportExaminationsRequest.ImportExamination }
     * 
     * 
     */
    public List<ImportExaminationsRequest.ImportExamination> getImportExamination() {
        if (importExamination == null) {
            importExamination = new ArrayList<ImportExaminationsRequest.ImportExamination>();
        }
        return this.importExamination;
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
            return "11.0.0.5";
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
     *           &lt;element name="ExaminationGuid" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType" minOccurs="0"/>
     *         &lt;/sequence>
     *         &lt;element name="Examination" type="{http://dom.gosuslugi.ru/schema/integration/inspection/}ExaminationType" minOccurs="0"/>
     *         &lt;element name="CancelExamination" type="{http://dom.gosuslugi.ru/schema/integration/inspection/}CancelledInfoWithAttachmentsType" minOccurs="0"/>
     *         &lt;element name="AnnulExamination" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
     *         &lt;element name="Results" minOccurs="0">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;choice>
     *                   &lt;element name="ResultsInfo" type="{http://dom.gosuslugi.ru/schema/integration/inspection/}ResultsInfoType"/>
     *                   &lt;element name="CancelExaminationResults" type="{http://dom.gosuslugi.ru/schema/integration/inspection/}CancelledInfoWithAttachmentsType"/>
     *                   &lt;element name="AnnulExaminationResults" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
     *                 &lt;/choice>
     *               &lt;/restriction>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *         &lt;element name="ImportPrecept" maxOccurs="unbounded" minOccurs="0">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;sequence>
     *                     &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/base/}TransportGUID"/>
     *                     &lt;element name="PreceptGuid" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType" minOccurs="0"/>
     *                   &lt;/sequence>
     *                   &lt;choice>
     *                     &lt;element name="Precept" type="{http://dom.gosuslugi.ru/schema/integration/inspection/}PreceptType"/>
     *                     &lt;element name="CancelPrecept" type="{http://dom.gosuslugi.ru/schema/integration/inspection/}CancelledInfoWithAttachmentsType"/>
     *                     &lt;element name="IsFulfiledPrecept" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
     *                     &lt;element name="DeletePrecept" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
     *                   &lt;/choice>
     *                 &lt;/sequence>
     *               &lt;/restriction>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *         &lt;element name="ImportOffence" maxOccurs="unbounded" minOccurs="0">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;sequence>
     *                     &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/base/}TransportGUID"/>
     *                     &lt;element name="OffenceGuid" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType" minOccurs="0"/>
     *                   &lt;/sequence>
     *                   &lt;choice>
     *                     &lt;element name="Offence" type="{http://dom.gosuslugi.ru/schema/integration/inspection/}OffenceType"/>
     *                     &lt;element name="CancelOffence" type="{http://dom.gosuslugi.ru/schema/integration/inspection/}CancelledInfoWithAttachmentsType"/>
     *                     &lt;element name="IsFulfiledOffence" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
     *                     &lt;element name="DeleteOffence" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
     *                   &lt;/choice>
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
        "transportGUID",
        "examinationGuid",
        "examination",
        "cancelExamination",
        "annulExamination",
        "results",
        "importPrecept",
        "importOffence"
    })
    public static class ImportExamination {

        @XmlElement(name = "TransportGUID", namespace = "http://dom.gosuslugi.ru/schema/integration/base/", required = true)
        protected String transportGUID;
        @XmlElement(name = "ExaminationGuid")
        protected String examinationGuid;
        @XmlElement(name = "Examination")
        protected ExaminationType examination;
        @XmlElement(name = "CancelExamination")
        protected CancelledInfoWithAttachmentsType cancelExamination;
        @XmlElement(name = "AnnulExamination")
        protected Boolean annulExamination;
        @XmlElement(name = "Results")
        protected ImportExaminationsRequest.ImportExamination.Results results;
        @XmlElement(name = "ImportPrecept")
        protected List<ImportExaminationsRequest.ImportExamination.ImportPrecept> importPrecept;
        @XmlElement(name = "ImportOffence")
        protected List<ImportExaminationsRequest.ImportExamination.ImportOffence> importOffence;

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
         * Gets the value of the examinationGuid property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getExaminationGuid() {
            return examinationGuid;
        }

        /**
         * Sets the value of the examinationGuid property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setExaminationGuid(String value) {
            this.examinationGuid = value;
        }

        /**
         * Gets the value of the examination property.
         * 
         * @return
         *     possible object is
         *     {@link ExaminationType }
         *     
         */
        public ExaminationType getExamination() {
            return examination;
        }

        /**
         * Sets the value of the examination property.
         * 
         * @param value
         *     allowed object is
         *     {@link ExaminationType }
         *     
         */
        public void setExamination(ExaminationType value) {
            this.examination = value;
        }

        /**
         * Gets the value of the cancelExamination property.
         * 
         * @return
         *     possible object is
         *     {@link CancelledInfoWithAttachmentsType }
         *     
         */
        public CancelledInfoWithAttachmentsType getCancelExamination() {
            return cancelExamination;
        }

        /**
         * Sets the value of the cancelExamination property.
         * 
         * @param value
         *     allowed object is
         *     {@link CancelledInfoWithAttachmentsType }
         *     
         */
        public void setCancelExamination(CancelledInfoWithAttachmentsType value) {
            this.cancelExamination = value;
        }

        /**
         * Gets the value of the annulExamination property.
         * 
         * @return
         *     possible object is
         *     {@link Boolean }
         *     
         */
        public Boolean isAnnulExamination() {
            return annulExamination;
        }

        /**
         * Sets the value of the annulExamination property.
         * 
         * @param value
         *     allowed object is
         *     {@link Boolean }
         *     
         */
        public void setAnnulExamination(Boolean value) {
            this.annulExamination = value;
        }

        /**
         * Gets the value of the results property.
         * 
         * @return
         *     possible object is
         *     {@link ImportExaminationsRequest.ImportExamination.Results }
         *     
         */
        public ImportExaminationsRequest.ImportExamination.Results getResults() {
            return results;
        }

        /**
         * Sets the value of the results property.
         * 
         * @param value
         *     allowed object is
         *     {@link ImportExaminationsRequest.ImportExamination.Results }
         *     
         */
        public void setResults(ImportExaminationsRequest.ImportExamination.Results value) {
            this.results = value;
        }

        /**
         * Gets the value of the importPrecept property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the importPrecept property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getImportPrecept().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link ImportExaminationsRequest.ImportExamination.ImportPrecept }
         * 
         * 
         */
        public List<ImportExaminationsRequest.ImportExamination.ImportPrecept> getImportPrecept() {
            if (importPrecept == null) {
                importPrecept = new ArrayList<ImportExaminationsRequest.ImportExamination.ImportPrecept>();
            }
            return this.importPrecept;
        }

        /**
         * Gets the value of the importOffence property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the importOffence property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getImportOffence().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link ImportExaminationsRequest.ImportExamination.ImportOffence }
         * 
         * 
         */
        public List<ImportExaminationsRequest.ImportExamination.ImportOffence> getImportOffence() {
            if (importOffence == null) {
                importOffence = new ArrayList<ImportExaminationsRequest.ImportExamination.ImportOffence>();
            }
            return this.importOffence;
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
         *           &lt;element name="OffenceGuid" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType" minOccurs="0"/>
         *         &lt;/sequence>
         *         &lt;choice>
         *           &lt;element name="Offence" type="{http://dom.gosuslugi.ru/schema/integration/inspection/}OffenceType"/>
         *           &lt;element name="CancelOffence" type="{http://dom.gosuslugi.ru/schema/integration/inspection/}CancelledInfoWithAttachmentsType"/>
         *           &lt;element name="IsFulfiledOffence" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
         *           &lt;element name="DeleteOffence" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
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
            "offenceGuid",
            "offence",
            "cancelOffence",
            "isFulfiledOffence",
            "deleteOffence"
        })
        public static class ImportOffence {

            @XmlElement(name = "TransportGUID", namespace = "http://dom.gosuslugi.ru/schema/integration/base/", required = true)
            protected String transportGUID;
            @XmlElement(name = "OffenceGuid")
            protected String offenceGuid;
            @XmlElement(name = "Offence")
            protected OffenceType offence;
            @XmlElement(name = "CancelOffence")
            protected CancelledInfoWithAttachmentsType cancelOffence;
            @XmlElement(name = "IsFulfiledOffence")
            protected Boolean isFulfiledOffence;
            @XmlElement(name = "DeleteOffence")
            protected Boolean deleteOffence;

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
             * Gets the value of the offenceGuid property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getOffenceGuid() {
                return offenceGuid;
            }

            /**
             * Sets the value of the offenceGuid property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setOffenceGuid(String value) {
                this.offenceGuid = value;
            }

            /**
             * Gets the value of the offence property.
             * 
             * @return
             *     possible object is
             *     {@link OffenceType }
             *     
             */
            public OffenceType getOffence() {
                return offence;
            }

            /**
             * Sets the value of the offence property.
             * 
             * @param value
             *     allowed object is
             *     {@link OffenceType }
             *     
             */
            public void setOffence(OffenceType value) {
                this.offence = value;
            }

            /**
             * Gets the value of the cancelOffence property.
             * 
             * @return
             *     possible object is
             *     {@link CancelledInfoWithAttachmentsType }
             *     
             */
            public CancelledInfoWithAttachmentsType getCancelOffence() {
                return cancelOffence;
            }

            /**
             * Sets the value of the cancelOffence property.
             * 
             * @param value
             *     allowed object is
             *     {@link CancelledInfoWithAttachmentsType }
             *     
             */
            public void setCancelOffence(CancelledInfoWithAttachmentsType value) {
                this.cancelOffence = value;
            }

            /**
             * Gets the value of the isFulfiledOffence property.
             * 
             * @return
             *     possible object is
             *     {@link Boolean }
             *     
             */
            public Boolean isIsFulfiledOffence() {
                return isFulfiledOffence;
            }

            /**
             * Sets the value of the isFulfiledOffence property.
             * 
             * @param value
             *     allowed object is
             *     {@link Boolean }
             *     
             */
            public void setIsFulfiledOffence(Boolean value) {
                this.isFulfiledOffence = value;
            }

            /**
             * Gets the value of the deleteOffence property.
             * 
             * @return
             *     possible object is
             *     {@link Boolean }
             *     
             */
            public Boolean isDeleteOffence() {
                return deleteOffence;
            }

            /**
             * Sets the value of the deleteOffence property.
             * 
             * @param value
             *     allowed object is
             *     {@link Boolean }
             *     
             */
            public void setDeleteOffence(Boolean value) {
                this.deleteOffence = value;
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
         *         &lt;sequence>
         *           &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/base/}TransportGUID"/>
         *           &lt;element name="PreceptGuid" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType" minOccurs="0"/>
         *         &lt;/sequence>
         *         &lt;choice>
         *           &lt;element name="Precept" type="{http://dom.gosuslugi.ru/schema/integration/inspection/}PreceptType"/>
         *           &lt;element name="CancelPrecept" type="{http://dom.gosuslugi.ru/schema/integration/inspection/}CancelledInfoWithAttachmentsType"/>
         *           &lt;element name="IsFulfiledPrecept" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
         *           &lt;element name="DeletePrecept" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
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
            "preceptGuid",
            "precept",
            "cancelPrecept",
            "isFulfiledPrecept",
            "deletePrecept"
        })
        public static class ImportPrecept {

            @XmlElement(name = "TransportGUID", namespace = "http://dom.gosuslugi.ru/schema/integration/base/", required = true)
            protected String transportGUID;
            @XmlElement(name = "PreceptGuid")
            protected String preceptGuid;
            @XmlElement(name = "Precept")
            protected PreceptType precept;
            @XmlElement(name = "CancelPrecept")
            protected CancelledInfoWithAttachmentsType cancelPrecept;
            @XmlElement(name = "IsFulfiledPrecept")
            protected Boolean isFulfiledPrecept;
            @XmlElement(name = "DeletePrecept")
            protected Boolean deletePrecept;

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
             * Gets the value of the preceptGuid property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getPreceptGuid() {
                return preceptGuid;
            }

            /**
             * Sets the value of the preceptGuid property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setPreceptGuid(String value) {
                this.preceptGuid = value;
            }

            /**
             * Gets the value of the precept property.
             * 
             * @return
             *     possible object is
             *     {@link PreceptType }
             *     
             */
            public PreceptType getPrecept() {
                return precept;
            }

            /**
             * Sets the value of the precept property.
             * 
             * @param value
             *     allowed object is
             *     {@link PreceptType }
             *     
             */
            public void setPrecept(PreceptType value) {
                this.precept = value;
            }

            /**
             * Gets the value of the cancelPrecept property.
             * 
             * @return
             *     possible object is
             *     {@link CancelledInfoWithAttachmentsType }
             *     
             */
            public CancelledInfoWithAttachmentsType getCancelPrecept() {
                return cancelPrecept;
            }

            /**
             * Sets the value of the cancelPrecept property.
             * 
             * @param value
             *     allowed object is
             *     {@link CancelledInfoWithAttachmentsType }
             *     
             */
            public void setCancelPrecept(CancelledInfoWithAttachmentsType value) {
                this.cancelPrecept = value;
            }

            /**
             * Gets the value of the isFulfiledPrecept property.
             * 
             * @return
             *     possible object is
             *     {@link Boolean }
             *     
             */
            public Boolean isIsFulfiledPrecept() {
                return isFulfiledPrecept;
            }

            /**
             * Sets the value of the isFulfiledPrecept property.
             * 
             * @param value
             *     allowed object is
             *     {@link Boolean }
             *     
             */
            public void setIsFulfiledPrecept(Boolean value) {
                this.isFulfiledPrecept = value;
            }

            /**
             * Gets the value of the deletePrecept property.
             * 
             * @return
             *     possible object is
             *     {@link Boolean }
             *     
             */
            public Boolean isDeletePrecept() {
                return deletePrecept;
            }

            /**
             * Sets the value of the deletePrecept property.
             * 
             * @param value
             *     allowed object is
             *     {@link Boolean }
             *     
             */
            public void setDeletePrecept(Boolean value) {
                this.deletePrecept = value;
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
         *       &lt;choice>
         *         &lt;element name="ResultsInfo" type="{http://dom.gosuslugi.ru/schema/integration/inspection/}ResultsInfoType"/>
         *         &lt;element name="CancelExaminationResults" type="{http://dom.gosuslugi.ru/schema/integration/inspection/}CancelledInfoWithAttachmentsType"/>
         *         &lt;element name="AnnulExaminationResults" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
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
            "resultsInfo",
            "cancelExaminationResults",
            "annulExaminationResults"
        })
        public static class Results {

            @XmlElement(name = "ResultsInfo")
            protected ResultsInfoType resultsInfo;
            @XmlElement(name = "CancelExaminationResults")
            protected CancelledInfoWithAttachmentsType cancelExaminationResults;
            @XmlElement(name = "AnnulExaminationResults")
            protected Boolean annulExaminationResults;

            /**
             * Gets the value of the resultsInfo property.
             * 
             * @return
             *     possible object is
             *     {@link ResultsInfoType }
             *     
             */
            public ResultsInfoType getResultsInfo() {
                return resultsInfo;
            }

            /**
             * Sets the value of the resultsInfo property.
             * 
             * @param value
             *     allowed object is
             *     {@link ResultsInfoType }
             *     
             */
            public void setResultsInfo(ResultsInfoType value) {
                this.resultsInfo = value;
            }

            /**
             * Gets the value of the cancelExaminationResults property.
             * 
             * @return
             *     possible object is
             *     {@link CancelledInfoWithAttachmentsType }
             *     
             */
            public CancelledInfoWithAttachmentsType getCancelExaminationResults() {
                return cancelExaminationResults;
            }

            /**
             * Sets the value of the cancelExaminationResults property.
             * 
             * @param value
             *     allowed object is
             *     {@link CancelledInfoWithAttachmentsType }
             *     
             */
            public void setCancelExaminationResults(CancelledInfoWithAttachmentsType value) {
                this.cancelExaminationResults = value;
            }

            /**
             * Gets the value of the annulExaminationResults property.
             * 
             * @return
             *     possible object is
             *     {@link Boolean }
             *     
             */
            public Boolean isAnnulExaminationResults() {
                return annulExaminationResults;
            }

            /**
             * Sets the value of the annulExaminationResults property.
             * 
             * @param value
             *     allowed object is
             *     {@link Boolean }
             *     
             */
            public void setAnnulExaminationResults(Boolean value) {
                this.annulExaminationResults = value;
            }

        }

    }

}
