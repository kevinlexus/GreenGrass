
package ru.gosuslugi.dom.schema.integration.inspection;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * Экспортируемая проверка.
 * 
 * <p>Java class for exportExaminationResultType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="exportExaminationResultType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ExaminationGuid" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType"/>
 *         &lt;element name="RegistryNumber" type="{http://dom.gosuslugi.ru/schema/integration/inspection/}String255Type" minOccurs="0"/>
 *         &lt;element name="URIRegistrationNumber" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}integer">
 *               &lt;minInclusive value="0"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="ExaminationState" type="{http://dom.gosuslugi.ru/schema/integration/inspection/}ExaminationStateType"/>
 *         &lt;element name="ExaminationVersionState" type="{http://dom.gosuslugi.ru/schema/integration/inspection/}ExaminationVersionStateType"/>
 *         &lt;element name="Examination" type="{http://dom.gosuslugi.ru/schema/integration/inspection/}exportExaminationType"/>
 *         &lt;element name="ExportPrecept" maxOccurs="unbounded" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="PreceptGuid" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType"/>
 *                   &lt;element name="PreceptState" type="{http://dom.gosuslugi.ru/schema/integration/inspection/}PreceptStateType"/>
 *                   &lt;element name="Precept" type="{http://dom.gosuslugi.ru/schema/integration/inspection/}PreceptType"/>
 *                   &lt;element name="CancelledInfo" type="{http://dom.gosuslugi.ru/schema/integration/inspection/}CancelledInfoWithAttachmentsType" minOccurs="0"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="ExportOffence" maxOccurs="unbounded" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="OffenceGuid" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType"/>
 *                   &lt;element name="OffenceState" type="{http://dom.gosuslugi.ru/schema/integration/inspection/}OffenceStateType"/>
 *                   &lt;element name="Offence" type="{http://dom.gosuslugi.ru/schema/integration/inspection/}OffenceType"/>
 *                   &lt;element name="CancelledInfo" type="{http://dom.gosuslugi.ru/schema/integration/inspection/}CancelledInfoWithAttachmentsType" minOccurs="0"/>
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
@XmlType(name = "exportExaminationResultType", propOrder = {
    "examinationGuid",
    "registryNumber",
    "uriRegistrationNumber",
    "examinationState",
    "examinationVersionState",
    "examination",
    "exportPrecept",
    "exportOffence"
})
public class ExportExaminationResultType {

    @XmlElement(name = "ExaminationGuid", required = true)
    protected String examinationGuid;
    @XmlElement(name = "RegistryNumber")
    protected String registryNumber;
    @XmlElement(name = "URIRegistrationNumber")
    protected BigInteger uriRegistrationNumber;
    @XmlElement(name = "ExaminationState", required = true)
    @XmlSchemaType(name = "token")
    protected ExaminationStateType examinationState;
    @XmlElement(name = "ExaminationVersionState", required = true)
    @XmlSchemaType(name = "token")
    protected ExaminationVersionStateType examinationVersionState;
    @XmlElement(name = "Examination", required = true)
    protected ExportExaminationType examination;
    @XmlElement(name = "ExportPrecept")
    protected List<ExportExaminationResultType.ExportPrecept> exportPrecept;
    @XmlElement(name = "ExportOffence")
    protected List<ExportExaminationResultType.ExportOffence> exportOffence;

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
     * Gets the value of the registryNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRegistryNumber() {
        return registryNumber;
    }

    /**
     * Sets the value of the registryNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRegistryNumber(String value) {
        this.registryNumber = value;
    }

    /**
     * Gets the value of the uriRegistrationNumber property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getURIRegistrationNumber() {
        return uriRegistrationNumber;
    }

    /**
     * Sets the value of the uriRegistrationNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setURIRegistrationNumber(BigInteger value) {
        this.uriRegistrationNumber = value;
    }

    /**
     * Gets the value of the examinationState property.
     * 
     * @return
     *     possible object is
     *     {@link ExaminationStateType }
     *     
     */
    public ExaminationStateType getExaminationState() {
        return examinationState;
    }

    /**
     * Sets the value of the examinationState property.
     * 
     * @param value
     *     allowed object is
     *     {@link ExaminationStateType }
     *     
     */
    public void setExaminationState(ExaminationStateType value) {
        this.examinationState = value;
    }

    /**
     * Gets the value of the examinationVersionState property.
     * 
     * @return
     *     possible object is
     *     {@link ExaminationVersionStateType }
     *     
     */
    public ExaminationVersionStateType getExaminationVersionState() {
        return examinationVersionState;
    }

    /**
     * Sets the value of the examinationVersionState property.
     * 
     * @param value
     *     allowed object is
     *     {@link ExaminationVersionStateType }
     *     
     */
    public void setExaminationVersionState(ExaminationVersionStateType value) {
        this.examinationVersionState = value;
    }

    /**
     * Gets the value of the examination property.
     * 
     * @return
     *     possible object is
     *     {@link ExportExaminationType }
     *     
     */
    public ExportExaminationType getExamination() {
        return examination;
    }

    /**
     * Sets the value of the examination property.
     * 
     * @param value
     *     allowed object is
     *     {@link ExportExaminationType }
     *     
     */
    public void setExamination(ExportExaminationType value) {
        this.examination = value;
    }

    /**
     * Gets the value of the exportPrecept property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the exportPrecept property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getExportPrecept().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ExportExaminationResultType.ExportPrecept }
     * 
     * 
     */
    public List<ExportExaminationResultType.ExportPrecept> getExportPrecept() {
        if (exportPrecept == null) {
            exportPrecept = new ArrayList<ExportExaminationResultType.ExportPrecept>();
        }
        return this.exportPrecept;
    }

    /**
     * Gets the value of the exportOffence property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the exportOffence property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getExportOffence().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ExportExaminationResultType.ExportOffence }
     * 
     * 
     */
    public List<ExportExaminationResultType.ExportOffence> getExportOffence() {
        if (exportOffence == null) {
            exportOffence = new ArrayList<ExportExaminationResultType.ExportOffence>();
        }
        return this.exportOffence;
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
     *         &lt;element name="OffenceGuid" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType"/>
     *         &lt;element name="OffenceState" type="{http://dom.gosuslugi.ru/schema/integration/inspection/}OffenceStateType"/>
     *         &lt;element name="Offence" type="{http://dom.gosuslugi.ru/schema/integration/inspection/}OffenceType"/>
     *         &lt;element name="CancelledInfo" type="{http://dom.gosuslugi.ru/schema/integration/inspection/}CancelledInfoWithAttachmentsType" minOccurs="0"/>
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
        "offenceGuid",
        "offenceState",
        "offence",
        "cancelledInfo"
    })
    public static class ExportOffence {

        @XmlElement(name = "OffenceGuid", required = true)
        protected String offenceGuid;
        @XmlElement(name = "OffenceState", required = true)
        @XmlSchemaType(name = "token")
        protected OffenceStateType offenceState;
        @XmlElement(name = "Offence", required = true)
        protected OffenceType offence;
        @XmlElement(name = "CancelledInfo")
        protected CancelledInfoWithAttachmentsType cancelledInfo;

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
         * Gets the value of the offenceState property.
         * 
         * @return
         *     possible object is
         *     {@link OffenceStateType }
         *     
         */
        public OffenceStateType getOffenceState() {
            return offenceState;
        }

        /**
         * Sets the value of the offenceState property.
         * 
         * @param value
         *     allowed object is
         *     {@link OffenceStateType }
         *     
         */
        public void setOffenceState(OffenceStateType value) {
            this.offenceState = value;
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
         * Gets the value of the cancelledInfo property.
         * 
         * @return
         *     possible object is
         *     {@link CancelledInfoWithAttachmentsType }
         *     
         */
        public CancelledInfoWithAttachmentsType getCancelledInfo() {
            return cancelledInfo;
        }

        /**
         * Sets the value of the cancelledInfo property.
         * 
         * @param value
         *     allowed object is
         *     {@link CancelledInfoWithAttachmentsType }
         *     
         */
        public void setCancelledInfo(CancelledInfoWithAttachmentsType value) {
            this.cancelledInfo = value;
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
     *         &lt;element name="PreceptGuid" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType"/>
     *         &lt;element name="PreceptState" type="{http://dom.gosuslugi.ru/schema/integration/inspection/}PreceptStateType"/>
     *         &lt;element name="Precept" type="{http://dom.gosuslugi.ru/schema/integration/inspection/}PreceptType"/>
     *         &lt;element name="CancelledInfo" type="{http://dom.gosuslugi.ru/schema/integration/inspection/}CancelledInfoWithAttachmentsType" minOccurs="0"/>
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
        "preceptGuid",
        "preceptState",
        "precept",
        "cancelledInfo"
    })
    public static class ExportPrecept {

        @XmlElement(name = "PreceptGuid", required = true)
        protected String preceptGuid;
        @XmlElement(name = "PreceptState", required = true)
        @XmlSchemaType(name = "token")
        protected PreceptStateType preceptState;
        @XmlElement(name = "Precept", required = true)
        protected PreceptType precept;
        @XmlElement(name = "CancelledInfo")
        protected CancelledInfoWithAttachmentsType cancelledInfo;

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
         * Gets the value of the preceptState property.
         * 
         * @return
         *     possible object is
         *     {@link PreceptStateType }
         *     
         */
        public PreceptStateType getPreceptState() {
            return preceptState;
        }

        /**
         * Sets the value of the preceptState property.
         * 
         * @param value
         *     allowed object is
         *     {@link PreceptStateType }
         *     
         */
        public void setPreceptState(PreceptStateType value) {
            this.preceptState = value;
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
         * Gets the value of the cancelledInfo property.
         * 
         * @return
         *     possible object is
         *     {@link CancelledInfoWithAttachmentsType }
         *     
         */
        public CancelledInfoWithAttachmentsType getCancelledInfo() {
            return cancelledInfo;
        }

        /**
         * Sets the value of the cancelledInfo property.
         * 
         * @param value
         *     allowed object is
         *     {@link CancelledInfoWithAttachmentsType }
         *     
         */
        public void setCancelledInfo(CancelledInfoWithAttachmentsType value) {
            this.cancelledInfo = value;
        }

    }

}
