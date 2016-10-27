
package ru.gosuslugi.dom.schema.integration.house_management;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;
import ru.gosuslugi.dom.schema.integration.nsi_base.NsiRef;


/**
 * Протокол ОСС
 * 
 * <p>Java class for ProtocolType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ProtocolType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="FIASHouseGuid" type="{http://dom.gosuslugi.ru/schema/integration/premises-base/}FIASHouseGUIDType"/>
 *         &lt;element name="ProtocolNum" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="30"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="ProtocolDate" type="{http://www.w3.org/2001/XMLSchema}date"/>
 *         &lt;choice>
 *           &lt;element name="AVoting">
 *             &lt;complexType>
 *               &lt;complexContent>
 *                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                   &lt;sequence>
 *                     &lt;element name="AVotingDate" type="{http://www.w3.org/2001/XMLSchema}date"/>
 *                     &lt;element name="ResolutionPlace">
 *                       &lt;simpleType>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                           &lt;maxLength value="200"/>
 *                           &lt;minLength value="1"/>
 *                         &lt;/restriction>
 *                       &lt;/simpleType>
 *                     &lt;/element>
 *                     &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/house-management/}Attachments" maxOccurs="unbounded"/>
 *                   &lt;/sequence>
 *                 &lt;/restriction>
 *               &lt;/complexContent>
 *             &lt;/complexType>
 *           &lt;/element>
 *           &lt;element name="Meeting">
 *             &lt;complexType>
 *               &lt;complexContent>
 *                 &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/house-management/}VoitingType">
 *                   &lt;sequence>
 *                     &lt;element name="MeetingDate" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *                     &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/house-management/}Attachments" maxOccurs="unbounded"/>
 *                   &lt;/sequence>
 *                 &lt;/extension>
 *               &lt;/complexContent>
 *             &lt;/complexType>
 *           &lt;/element>
 *           &lt;element name="EVoting">
 *             &lt;complexType>
 *               &lt;complexContent>
 *                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                   &lt;sequence>
 *                     &lt;element name="EVotingDateBegin" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *                     &lt;element name="EVotingDateEnd" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *                     &lt;element name="Discipline">
 *                       &lt;simpleType>
 *                         &lt;restriction base="{http://dom.gosuslugi.ru/schema/integration/base/}LongTextType">
 *                           &lt;minLength value="1"/>
 *                         &lt;/restriction>
 *                       &lt;/simpleType>
 *                     &lt;/element>
 *                     &lt;element name="InfoReview">
 *                       &lt;simpleType>
 *                         &lt;restriction base="{http://dom.gosuslugi.ru/schema/integration/base/}LongTextType">
 *                           &lt;minLength value="1"/>
 *                         &lt;/restriction>
 *                       &lt;/simpleType>
 *                     &lt;/element>
 *                     &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/house-management/}Attachments" maxOccurs="unbounded" minOccurs="0"/>
 *                   &lt;/sequence>
 *                 &lt;/restriction>
 *               &lt;/complexContent>
 *             &lt;/complexType>
 *           &lt;/element>
 *           &lt;element name="MeetingAVoting">
 *             &lt;complexType>
 *               &lt;complexContent>
 *                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                   &lt;sequence>
 *                     &lt;element name="MeetingDate" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *                     &lt;element name="VotingPlace">
 *                       &lt;simpleType>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                           &lt;maxLength value="200"/>
 *                           &lt;minLength value="1"/>
 *                         &lt;/restriction>
 *                       &lt;/simpleType>
 *                     &lt;/element>
 *                     &lt;element name="AVotingDate" type="{http://www.w3.org/2001/XMLSchema}date"/>
 *                     &lt;element name="ResolutionPlace">
 *                       &lt;simpleType>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                           &lt;maxLength value="200"/>
 *                           &lt;minLength value="1"/>
 *                         &lt;/restriction>
 *                       &lt;/simpleType>
 *                     &lt;/element>
 *                     &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/house-management/}Attachments" maxOccurs="unbounded"/>
 *                   &lt;/sequence>
 *                 &lt;/restriction>
 *               &lt;/complexContent>
 *             &lt;/complexType>
 *           &lt;/element>
 *         &lt;/choice>
 *         &lt;choice>
 *           &lt;element name="ExtraVoting">
 *             &lt;complexType>
 *               &lt;complexContent>
 *                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                   &lt;sequence>
 *                     &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/house-management/}VoteInitiators" maxOccurs="unbounded"/>
 *                   &lt;/sequence>
 *                 &lt;/restriction>
 *               &lt;/complexContent>
 *             &lt;/complexType>
 *           &lt;/element>
 *           &lt;element name="AnnualVoting" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;/choice>
 *         &lt;element name="MeetingEligibility">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;enumeration value="C"/>
 *               &lt;enumeration value="N"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="DecisionList" maxOccurs="unbounded">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;sequence>
 *                     &lt;element name="QuestionNumber" type="{http://www.w3.org/2001/XMLSchema}nonNegativeInteger" minOccurs="0"/>
 *                     &lt;element name="QuestionName">
 *                       &lt;simpleType>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                           &lt;minLength value="1"/>
 *                           &lt;maxLength value="2000"/>
 *                         &lt;/restriction>
 *                       &lt;/simpleType>
 *                     &lt;/element>
 *                     &lt;element name="DecisionsType" type="{http://dom.gosuslugi.ru/schema/integration/nsi-base/}nsiRef"/>
 *                     &lt;sequence>
 *                       &lt;element name="Agree" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *                       &lt;element name="Against" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *                       &lt;element name="Abstent" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *                     &lt;/sequence>
 *                     &lt;element name="FormingFund" type="{http://dom.gosuslugi.ru/schema/integration/nsi-base/}nsiRef" minOccurs="0"/>
 *                   &lt;/sequence>
 *                   &lt;element name="votingResume">
 *                     &lt;simpleType>
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                         &lt;enumeration value="M"/>
 *                         &lt;enumeration value="N"/>
 *                       &lt;/restriction>
 *                     &lt;/simpleType>
 *                   &lt;/element>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="Modification" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://dom.gosuslugi.ru/schema/integration/base/}LongTextType">
 *               &lt;minLength value="1"/>
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
@XmlType(name = "ProtocolType", propOrder = {
    "fiasHouseGuid",
    "protocolNum",
    "protocolDate",
    "aVoting",
    "meeting",
    "eVoting",
    "meetingAVoting",
    "extraVoting",
    "annualVoting",
    "meetingEligibility",
    "decisionList",
    "modification"
})
@XmlSeeAlso({
    ExportVotingProtocolResultType.class,
    ru.gosuslugi.dom.schema.integration.house_management.ImportVotingProtocolRequest.Protocol.class
})
public class ProtocolType {

    @XmlElement(name = "FIASHouseGuid", required = true)
    protected String fiasHouseGuid;
    @XmlElement(name = "ProtocolNum")
    protected String protocolNum;
    @XmlElement(name = "ProtocolDate", required = true)
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar protocolDate;
    @XmlElement(name = "AVoting")
    protected ProtocolType.AVoting aVoting;
    @XmlElement(name = "Meeting")
    protected ProtocolType.Meeting meeting;
    @XmlElement(name = "EVoting")
    protected ProtocolType.EVoting eVoting;
    @XmlElement(name = "MeetingAVoting")
    protected ProtocolType.MeetingAVoting meetingAVoting;
    @XmlElement(name = "ExtraVoting")
    protected ProtocolType.ExtraVoting extraVoting;
    @XmlElement(name = "AnnualVoting")
    protected Boolean annualVoting;
    @XmlElement(name = "MeetingEligibility", required = true)
    protected String meetingEligibility;
    @XmlElement(name = "DecisionList", required = true)
    protected List<ProtocolType.DecisionList> decisionList;
    @XmlElement(name = "Modification")
    protected String modification;

    /**
     * Gets the value of the fiasHouseGuid property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFIASHouseGuid() {
        return fiasHouseGuid;
    }

    /**
     * Sets the value of the fiasHouseGuid property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFIASHouseGuid(String value) {
        this.fiasHouseGuid = value;
    }

    /**
     * Gets the value of the protocolNum property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProtocolNum() {
        return protocolNum;
    }

    /**
     * Sets the value of the protocolNum property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProtocolNum(String value) {
        this.protocolNum = value;
    }

    /**
     * Gets the value of the protocolDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getProtocolDate() {
        return protocolDate;
    }

    /**
     * Sets the value of the protocolDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setProtocolDate(XMLGregorianCalendar value) {
        this.protocolDate = value;
    }

    /**
     * Gets the value of the aVoting property.
     * 
     * @return
     *     possible object is
     *     {@link ProtocolType.AVoting }
     *     
     */
    public ProtocolType.AVoting getAVoting() {
        return aVoting;
    }

    /**
     * Sets the value of the aVoting property.
     * 
     * @param value
     *     allowed object is
     *     {@link ProtocolType.AVoting }
     *     
     */
    public void setAVoting(ProtocolType.AVoting value) {
        this.aVoting = value;
    }

    /**
     * Gets the value of the meeting property.
     * 
     * @return
     *     possible object is
     *     {@link ProtocolType.Meeting }
     *     
     */
    public ProtocolType.Meeting getMeeting() {
        return meeting;
    }

    /**
     * Sets the value of the meeting property.
     * 
     * @param value
     *     allowed object is
     *     {@link ProtocolType.Meeting }
     *     
     */
    public void setMeeting(ProtocolType.Meeting value) {
        this.meeting = value;
    }

    /**
     * Gets the value of the eVoting property.
     * 
     * @return
     *     possible object is
     *     {@link ProtocolType.EVoting }
     *     
     */
    public ProtocolType.EVoting getEVoting() {
        return eVoting;
    }

    /**
     * Sets the value of the eVoting property.
     * 
     * @param value
     *     allowed object is
     *     {@link ProtocolType.EVoting }
     *     
     */
    public void setEVoting(ProtocolType.EVoting value) {
        this.eVoting = value;
    }

    /**
     * Gets the value of the meetingAVoting property.
     * 
     * @return
     *     possible object is
     *     {@link ProtocolType.MeetingAVoting }
     *     
     */
    public ProtocolType.MeetingAVoting getMeetingAVoting() {
        return meetingAVoting;
    }

    /**
     * Sets the value of the meetingAVoting property.
     * 
     * @param value
     *     allowed object is
     *     {@link ProtocolType.MeetingAVoting }
     *     
     */
    public void setMeetingAVoting(ProtocolType.MeetingAVoting value) {
        this.meetingAVoting = value;
    }

    /**
     * Gets the value of the extraVoting property.
     * 
     * @return
     *     possible object is
     *     {@link ProtocolType.ExtraVoting }
     *     
     */
    public ProtocolType.ExtraVoting getExtraVoting() {
        return extraVoting;
    }

    /**
     * Sets the value of the extraVoting property.
     * 
     * @param value
     *     allowed object is
     *     {@link ProtocolType.ExtraVoting }
     *     
     */
    public void setExtraVoting(ProtocolType.ExtraVoting value) {
        this.extraVoting = value;
    }

    /**
     * Gets the value of the annualVoting property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isAnnualVoting() {
        return annualVoting;
    }

    /**
     * Sets the value of the annualVoting property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setAnnualVoting(Boolean value) {
        this.annualVoting = value;
    }

    /**
     * Gets the value of the meetingEligibility property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMeetingEligibility() {
        return meetingEligibility;
    }

    /**
     * Sets the value of the meetingEligibility property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMeetingEligibility(String value) {
        this.meetingEligibility = value;
    }

    /**
     * Gets the value of the decisionList property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the decisionList property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDecisionList().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ProtocolType.DecisionList }
     * 
     * 
     */
    public List<ProtocolType.DecisionList> getDecisionList() {
        if (decisionList == null) {
            decisionList = new ArrayList<ProtocolType.DecisionList>();
        }
        return this.decisionList;
    }

    /**
     * Gets the value of the modification property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getModification() {
        return modification;
    }

    /**
     * Sets the value of the modification property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setModification(String value) {
        this.modification = value;
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
     *         &lt;element name="AVotingDate" type="{http://www.w3.org/2001/XMLSchema}date"/>
     *         &lt;element name="ResolutionPlace">
     *           &lt;simpleType>
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *               &lt;maxLength value="200"/>
     *               &lt;minLength value="1"/>
     *             &lt;/restriction>
     *           &lt;/simpleType>
     *         &lt;/element>
     *         &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/house-management/}Attachments" maxOccurs="unbounded"/>
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
        "aVotingDate",
        "resolutionPlace",
        "attachments"
    })
    public static class AVoting {

        @XmlElement(name = "AVotingDate", required = true)
        @XmlSchemaType(name = "date")
        protected XMLGregorianCalendar aVotingDate;
        @XmlElement(name = "ResolutionPlace", required = true)
        protected String resolutionPlace;
        @XmlElement(name = "Attachments", required = true)
        protected List<Attachments> attachments;

        /**
         * Gets the value of the aVotingDate property.
         * 
         * @return
         *     possible object is
         *     {@link XMLGregorianCalendar }
         *     
         */
        public XMLGregorianCalendar getAVotingDate() {
            return aVotingDate;
        }

        /**
         * Sets the value of the aVotingDate property.
         * 
         * @param value
         *     allowed object is
         *     {@link XMLGregorianCalendar }
         *     
         */
        public void setAVotingDate(XMLGregorianCalendar value) {
            this.aVotingDate = value;
        }

        /**
         * Gets the value of the resolutionPlace property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getResolutionPlace() {
            return resolutionPlace;
        }

        /**
         * Sets the value of the resolutionPlace property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setResolutionPlace(String value) {
            this.resolutionPlace = value;
        }

        /**
         * Gets the value of the attachments property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the attachments property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getAttachments().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link Attachments }
         * 
         * 
         */
        public List<Attachments> getAttachments() {
            if (attachments == null) {
                attachments = new ArrayList<Attachments>();
            }
            return this.attachments;
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
     *           &lt;element name="QuestionNumber" type="{http://www.w3.org/2001/XMLSchema}nonNegativeInteger" minOccurs="0"/>
     *           &lt;element name="QuestionName">
     *             &lt;simpleType>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *                 &lt;minLength value="1"/>
     *                 &lt;maxLength value="2000"/>
     *               &lt;/restriction>
     *             &lt;/simpleType>
     *           &lt;/element>
     *           &lt;element name="DecisionsType" type="{http://dom.gosuslugi.ru/schema/integration/nsi-base/}nsiRef"/>
     *           &lt;sequence>
     *             &lt;element name="Agree" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
     *             &lt;element name="Against" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
     *             &lt;element name="Abstent" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
     *           &lt;/sequence>
     *           &lt;element name="FormingFund" type="{http://dom.gosuslugi.ru/schema/integration/nsi-base/}nsiRef" minOccurs="0"/>
     *         &lt;/sequence>
     *         &lt;element name="votingResume">
     *           &lt;simpleType>
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *               &lt;enumeration value="M"/>
     *               &lt;enumeration value="N"/>
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
        "questionNumber",
        "questionName",
        "decisionsType",
        "agree",
        "against",
        "abstent",
        "formingFund",
        "votingResume"
    })
    public static class DecisionList {

        @XmlElement(name = "QuestionNumber")
        @XmlSchemaType(name = "nonNegativeInteger")
        protected BigInteger questionNumber;
        @XmlElement(name = "QuestionName", required = true)
        protected String questionName;
        @XmlElement(name = "DecisionsType", required = true)
        protected NsiRef decisionsType;
        @XmlElement(name = "Agree")
        protected BigDecimal agree;
        @XmlElement(name = "Against")
        protected BigDecimal against;
        @XmlElement(name = "Abstent")
        protected BigDecimal abstent;
        @XmlElement(name = "FormingFund")
        protected NsiRef formingFund;
        @XmlElement(required = true)
        protected String votingResume;

        /**
         * Gets the value of the questionNumber property.
         * 
         * @return
         *     possible object is
         *     {@link BigInteger }
         *     
         */
        public BigInteger getQuestionNumber() {
            return questionNumber;
        }

        /**
         * Sets the value of the questionNumber property.
         * 
         * @param value
         *     allowed object is
         *     {@link BigInteger }
         *     
         */
        public void setQuestionNumber(BigInteger value) {
            this.questionNumber = value;
        }

        /**
         * Gets the value of the questionName property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getQuestionName() {
            return questionName;
        }

        /**
         * Sets the value of the questionName property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setQuestionName(String value) {
            this.questionName = value;
        }

        /**
         * Gets the value of the decisionsType property.
         * 
         * @return
         *     possible object is
         *     {@link NsiRef }
         *     
         */
        public NsiRef getDecisionsType() {
            return decisionsType;
        }

        /**
         * Sets the value of the decisionsType property.
         * 
         * @param value
         *     allowed object is
         *     {@link NsiRef }
         *     
         */
        public void setDecisionsType(NsiRef value) {
            this.decisionsType = value;
        }

        /**
         * Gets the value of the agree property.
         * 
         * @return
         *     possible object is
         *     {@link BigDecimal }
         *     
         */
        public BigDecimal getAgree() {
            return agree;
        }

        /**
         * Sets the value of the agree property.
         * 
         * @param value
         *     allowed object is
         *     {@link BigDecimal }
         *     
         */
        public void setAgree(BigDecimal value) {
            this.agree = value;
        }

        /**
         * Gets the value of the against property.
         * 
         * @return
         *     possible object is
         *     {@link BigDecimal }
         *     
         */
        public BigDecimal getAgainst() {
            return against;
        }

        /**
         * Sets the value of the against property.
         * 
         * @param value
         *     allowed object is
         *     {@link BigDecimal }
         *     
         */
        public void setAgainst(BigDecimal value) {
            this.against = value;
        }

        /**
         * Gets the value of the abstent property.
         * 
         * @return
         *     possible object is
         *     {@link BigDecimal }
         *     
         */
        public BigDecimal getAbstent() {
            return abstent;
        }

        /**
         * Sets the value of the abstent property.
         * 
         * @param value
         *     allowed object is
         *     {@link BigDecimal }
         *     
         */
        public void setAbstent(BigDecimal value) {
            this.abstent = value;
        }

        /**
         * Gets the value of the formingFund property.
         * 
         * @return
         *     possible object is
         *     {@link NsiRef }
         *     
         */
        public NsiRef getFormingFund() {
            return formingFund;
        }

        /**
         * Sets the value of the formingFund property.
         * 
         * @param value
         *     allowed object is
         *     {@link NsiRef }
         *     
         */
        public void setFormingFund(NsiRef value) {
            this.formingFund = value;
        }

        /**
         * Gets the value of the votingResume property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getVotingResume() {
            return votingResume;
        }

        /**
         * Sets the value of the votingResume property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setVotingResume(String value) {
            this.votingResume = value;
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
     *         &lt;element name="EVotingDateBegin" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
     *         &lt;element name="EVotingDateEnd" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
     *         &lt;element name="Discipline">
     *           &lt;simpleType>
     *             &lt;restriction base="{http://dom.gosuslugi.ru/schema/integration/base/}LongTextType">
     *               &lt;minLength value="1"/>
     *             &lt;/restriction>
     *           &lt;/simpleType>
     *         &lt;/element>
     *         &lt;element name="InfoReview">
     *           &lt;simpleType>
     *             &lt;restriction base="{http://dom.gosuslugi.ru/schema/integration/base/}LongTextType">
     *               &lt;minLength value="1"/>
     *             &lt;/restriction>
     *           &lt;/simpleType>
     *         &lt;/element>
     *         &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/house-management/}Attachments" maxOccurs="unbounded" minOccurs="0"/>
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
        "eVotingDateBegin",
        "eVotingDateEnd",
        "discipline",
        "infoReview",
        "attachments"
    })
    public static class EVoting {

        @XmlElement(name = "EVotingDateBegin", required = true)
        @XmlSchemaType(name = "dateTime")
        protected XMLGregorianCalendar eVotingDateBegin;
        @XmlElement(name = "EVotingDateEnd", required = true)
        @XmlSchemaType(name = "dateTime")
        protected XMLGregorianCalendar eVotingDateEnd;
        @XmlElement(name = "Discipline", required = true)
        protected String discipline;
        @XmlElement(name = "InfoReview", required = true)
        protected String infoReview;
        @XmlElement(name = "Attachments")
        protected List<Attachments> attachments;

        /**
         * Gets the value of the eVotingDateBegin property.
         * 
         * @return
         *     possible object is
         *     {@link XMLGregorianCalendar }
         *     
         */
        public XMLGregorianCalendar getEVotingDateBegin() {
            return eVotingDateBegin;
        }

        /**
         * Sets the value of the eVotingDateBegin property.
         * 
         * @param value
         *     allowed object is
         *     {@link XMLGregorianCalendar }
         *     
         */
        public void setEVotingDateBegin(XMLGregorianCalendar value) {
            this.eVotingDateBegin = value;
        }

        /**
         * Gets the value of the eVotingDateEnd property.
         * 
         * @return
         *     possible object is
         *     {@link XMLGregorianCalendar }
         *     
         */
        public XMLGregorianCalendar getEVotingDateEnd() {
            return eVotingDateEnd;
        }

        /**
         * Sets the value of the eVotingDateEnd property.
         * 
         * @param value
         *     allowed object is
         *     {@link XMLGregorianCalendar }
         *     
         */
        public void setEVotingDateEnd(XMLGregorianCalendar value) {
            this.eVotingDateEnd = value;
        }

        /**
         * Gets the value of the discipline property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getDiscipline() {
            return discipline;
        }

        /**
         * Sets the value of the discipline property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setDiscipline(String value) {
            this.discipline = value;
        }

        /**
         * Gets the value of the infoReview property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getInfoReview() {
            return infoReview;
        }

        /**
         * Sets the value of the infoReview property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setInfoReview(String value) {
            this.infoReview = value;
        }

        /**
         * Gets the value of the attachments property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the attachments property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getAttachments().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link Attachments }
         * 
         * 
         */
        public List<Attachments> getAttachments() {
            if (attachments == null) {
                attachments = new ArrayList<Attachments>();
            }
            return this.attachments;
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
     *         &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/house-management/}VoteInitiators" maxOccurs="unbounded"/>
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
        "voteInitiators"
    })
    public static class ExtraVoting {

        @XmlElement(name = "VoteInitiators", required = true)
        protected List<VoteInitiators> voteInitiators;

        /**
         * Gets the value of the voteInitiators property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the voteInitiators property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getVoteInitiators().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link VoteInitiators }
         * 
         * 
         */
        public List<VoteInitiators> getVoteInitiators() {
            if (voteInitiators == null) {
                voteInitiators = new ArrayList<VoteInitiators>();
            }
            return this.voteInitiators;
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
     *     &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/house-management/}VoitingType">
     *       &lt;sequence>
     *         &lt;element name="MeetingDate" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
     *         &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/house-management/}Attachments" maxOccurs="unbounded"/>
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
        "meetingDate",
        "attachments"
    })
    public static class Meeting
        extends VoitingType
    {

        @XmlElement(name = "MeetingDate", required = true)
        @XmlSchemaType(name = "dateTime")
        protected XMLGregorianCalendar meetingDate;
        @XmlElement(name = "Attachments", required = true)
        protected List<Attachments> attachments;

        /**
         * Gets the value of the meetingDate property.
         * 
         * @return
         *     possible object is
         *     {@link XMLGregorianCalendar }
         *     
         */
        public XMLGregorianCalendar getMeetingDate() {
            return meetingDate;
        }

        /**
         * Sets the value of the meetingDate property.
         * 
         * @param value
         *     allowed object is
         *     {@link XMLGregorianCalendar }
         *     
         */
        public void setMeetingDate(XMLGregorianCalendar value) {
            this.meetingDate = value;
        }

        /**
         * Gets the value of the attachments property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the attachments property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getAttachments().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link Attachments }
         * 
         * 
         */
        public List<Attachments> getAttachments() {
            if (attachments == null) {
                attachments = new ArrayList<Attachments>();
            }
            return this.attachments;
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
     *         &lt;element name="MeetingDate" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
     *         &lt;element name="VotingPlace">
     *           &lt;simpleType>
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *               &lt;maxLength value="200"/>
     *               &lt;minLength value="1"/>
     *             &lt;/restriction>
     *           &lt;/simpleType>
     *         &lt;/element>
     *         &lt;element name="AVotingDate" type="{http://www.w3.org/2001/XMLSchema}date"/>
     *         &lt;element name="ResolutionPlace">
     *           &lt;simpleType>
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *               &lt;maxLength value="200"/>
     *               &lt;minLength value="1"/>
     *             &lt;/restriction>
     *           &lt;/simpleType>
     *         &lt;/element>
     *         &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/house-management/}Attachments" maxOccurs="unbounded"/>
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
        "meetingDate",
        "votingPlace",
        "aVotingDate",
        "resolutionPlace",
        "attachments"
    })
    public static class MeetingAVoting {

        @XmlElement(name = "MeetingDate", required = true)
        @XmlSchemaType(name = "dateTime")
        protected XMLGregorianCalendar meetingDate;
        @XmlElement(name = "VotingPlace", required = true)
        protected String votingPlace;
        @XmlElement(name = "AVotingDate", required = true)
        @XmlSchemaType(name = "date")
        protected XMLGregorianCalendar aVotingDate;
        @XmlElement(name = "ResolutionPlace", required = true)
        protected String resolutionPlace;
        @XmlElement(name = "Attachments", required = true)
        protected List<Attachments> attachments;

        /**
         * Gets the value of the meetingDate property.
         * 
         * @return
         *     possible object is
         *     {@link XMLGregorianCalendar }
         *     
         */
        public XMLGregorianCalendar getMeetingDate() {
            return meetingDate;
        }

        /**
         * Sets the value of the meetingDate property.
         * 
         * @param value
         *     allowed object is
         *     {@link XMLGregorianCalendar }
         *     
         */
        public void setMeetingDate(XMLGregorianCalendar value) {
            this.meetingDate = value;
        }

        /**
         * Gets the value of the votingPlace property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getVotingPlace() {
            return votingPlace;
        }

        /**
         * Sets the value of the votingPlace property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setVotingPlace(String value) {
            this.votingPlace = value;
        }

        /**
         * Gets the value of the aVotingDate property.
         * 
         * @return
         *     possible object is
         *     {@link XMLGregorianCalendar }
         *     
         */
        public XMLGregorianCalendar getAVotingDate() {
            return aVotingDate;
        }

        /**
         * Sets the value of the aVotingDate property.
         * 
         * @param value
         *     allowed object is
         *     {@link XMLGregorianCalendar }
         *     
         */
        public void setAVotingDate(XMLGregorianCalendar value) {
            this.aVotingDate = value;
        }

        /**
         * Gets the value of the resolutionPlace property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getResolutionPlace() {
            return resolutionPlace;
        }

        /**
         * Sets the value of the resolutionPlace property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setResolutionPlace(String value) {
            this.resolutionPlace = value;
        }

        /**
         * Gets the value of the attachments property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the attachments property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getAttachments().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link Attachments }
         * 
         * 
         */
        public List<Attachments> getAttachments() {
            if (attachments == null) {
                attachments = new ArrayList<Attachments>();
            }
            return this.attachments;
        }

    }

}
