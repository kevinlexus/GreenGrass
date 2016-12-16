
package ru.gosuslugi.dom.schema.integration.msp;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;
import ru.gosuslugi.dom.schema.integration.base.OKTMORefType;
import ru.gosuslugi.dom.schema.integration.base.RegionType;
import ru.gosuslugi.dom.schema.integration.nsi_base.NsiRef;


/**
 * Экспортируемые сведения об отдельной категории граждан
 * 
 * <p>Java class for ExportCategoryType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ExportCategoryType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="CategoryGuid" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType"/>
 *         &lt;element name="FromDate" type="{http://www.w3.org/2001/XMLSchema}date"/>
 *         &lt;element name="ToDate" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
 *         &lt;element name="Territory">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;choice>
 *                   &lt;element name="Region" type="{http://dom.gosuslugi.ru/schema/integration/base/}RegionType"/>
 *                   &lt;element name="Municipality" type="{http://dom.gosuslugi.ru/schema/integration/base/}OKTMORefType"/>
 *                 &lt;/choice>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="CategoryName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="NsiCategory" type="{http://dom.gosuslugi.ru/schema/integration/nsi-base/}nsiRef" minOccurs="0"/>
 *         &lt;element name="BudgetLevel">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;enumeration value="Federal"/>
 *               &lt;enumeration value="Regional"/>
 *               &lt;enumeration value="Municipal"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="PayoutTerm" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ProvisionDocuments" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="DenialReasons" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="SuspensionReasons" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="TerminationReasons" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="ResumptionReasons" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="RecalculationReasons" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="RefundReasons" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Act" type="{http://dom.gosuslugi.ru/schema/integration/msp/}ActType" maxOccurs="1000"/>
 *         &lt;choice>
 *           &lt;sequence>
 *             &lt;element name="FixedCompensationSum" type="{http://dom.gosuslugi.ru/schema/integration/bills-base/}MoneyPositiveType"/>
 *             &lt;element name="FixedSumEstablishmentDate" type="{http://www.w3.org/2001/XMLSchema}date"/>
 *             &lt;element name="Comment" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *           &lt;/sequence>
 *           &lt;sequence>
 *             &lt;element name="Description" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *           &lt;/sequence>
 *           &lt;element name="Actual" maxOccurs="12">
 *             &lt;complexType>
 *               &lt;complexContent>
 *                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                   &lt;sequence>
 *                     &lt;element name="Service" type="{http://dom.gosuslugi.ru/schema/integration/msp/}ServiceType"/>
 *                     &lt;element name="Housing" maxOccurs="3">
 *                       &lt;simpleType>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                           &lt;enumeration value="PrivateHousing"/>
 *                           &lt;enumeration value="MunicipalHousing"/>
 *                           &lt;enumeration value="StateHousing"/>
 *                         &lt;/restriction>
 *                       &lt;/simpleType>
 *                     &lt;/element>
 *                     &lt;element name="NsiDiscountAmountLimitationCode" type="{http://dom.gosuslugi.ru/schema/integration/nsi-base/}nsiRef"/>
 *                     &lt;element name="AppliesToAllFamilyMembers" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *                     &lt;element name="DiscountSize">
 *                       &lt;simpleType>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}decimal">
 *                           &lt;minInclusive value="0"/>
 *                           &lt;maxInclusive value="100"/>
 *                           &lt;fractionDigits value="2"/>
 *                           &lt;totalDigits value="5"/>
 *                         &lt;/restriction>
 *                       &lt;/simpleType>
 *                     &lt;/element>
 *                     &lt;element name="ValidFrom" type="{http://www.w3.org/2001/XMLSchema}date"/>
 *                     &lt;element name="ValidTo" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
 *                     &lt;element name="Comment" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;/sequence>
 *                 &lt;/restriction>
 *               &lt;/complexContent>
 *             &lt;/complexType>
 *           &lt;/element>
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
@XmlType(name = "ExportCategoryType", propOrder = {
    "categoryGuid",
    "fromDate",
    "toDate",
    "territory",
    "categoryName",
    "nsiCategory",
    "budgetLevel",
    "payoutTerm",
    "provisionDocuments",
    "denialReasons",
    "suspensionReasons",
    "terminationReasons",
    "resumptionReasons",
    "recalculationReasons",
    "refundReasons",
    "act",
    "fixedCompensationSum",
    "fixedSumEstablishmentDate",
    "comment",
    "description",
    "actual"
})
public class ExportCategoryType {

    @XmlElement(name = "CategoryGuid", required = true)
    protected String categoryGuid;
    @XmlElement(name = "FromDate", required = true)
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar fromDate;
    @XmlElement(name = "ToDate")
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar toDate;
    @XmlElement(name = "Territory", required = true)
    protected ExportCategoryType.Territory territory;
    @XmlElement(name = "CategoryName", required = true)
    protected String categoryName;
    @XmlElement(name = "NsiCategory")
    protected NsiRef nsiCategory;
    @XmlElement(name = "BudgetLevel", required = true)
    protected String budgetLevel;
    @XmlElement(name = "PayoutTerm")
    protected String payoutTerm;
    @XmlElement(name = "ProvisionDocuments", required = true)
    protected String provisionDocuments;
    @XmlElement(name = "DenialReasons")
    protected String denialReasons;
    @XmlElement(name = "SuspensionReasons", required = true)
    protected String suspensionReasons;
    @XmlElement(name = "TerminationReasons", required = true)
    protected String terminationReasons;
    @XmlElement(name = "ResumptionReasons")
    protected String resumptionReasons;
    @XmlElement(name = "RecalculationReasons")
    protected String recalculationReasons;
    @XmlElement(name = "RefundReasons")
    protected String refundReasons;
    @XmlElement(name = "Act", required = true)
    protected List<ActType> act;
    @XmlElement(name = "FixedCompensationSum")
    protected BigDecimal fixedCompensationSum;
    @XmlElement(name = "FixedSumEstablishmentDate")
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar fixedSumEstablishmentDate;
    @XmlElement(name = "Comment")
    protected String comment;
    @XmlElement(name = "Description")
    protected String description;
    @XmlElement(name = "Actual")
    protected List<ExportCategoryType.Actual> actual;

    /**
     * Gets the value of the categoryGuid property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCategoryGuid() {
        return categoryGuid;
    }

    /**
     * Sets the value of the categoryGuid property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCategoryGuid(String value) {
        this.categoryGuid = value;
    }

    /**
     * Gets the value of the fromDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getFromDate() {
        return fromDate;
    }

    /**
     * Sets the value of the fromDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setFromDate(XMLGregorianCalendar value) {
        this.fromDate = value;
    }

    /**
     * Gets the value of the toDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getToDate() {
        return toDate;
    }

    /**
     * Sets the value of the toDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setToDate(XMLGregorianCalendar value) {
        this.toDate = value;
    }

    /**
     * Gets the value of the territory property.
     * 
     * @return
     *     possible object is
     *     {@link ExportCategoryType.Territory }
     *     
     */
    public ExportCategoryType.Territory getTerritory() {
        return territory;
    }

    /**
     * Sets the value of the territory property.
     * 
     * @param value
     *     allowed object is
     *     {@link ExportCategoryType.Territory }
     *     
     */
    public void setTerritory(ExportCategoryType.Territory value) {
        this.territory = value;
    }

    /**
     * Gets the value of the categoryName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCategoryName() {
        return categoryName;
    }

    /**
     * Sets the value of the categoryName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCategoryName(String value) {
        this.categoryName = value;
    }

    /**
     * Gets the value of the nsiCategory property.
     * 
     * @return
     *     possible object is
     *     {@link NsiRef }
     *     
     */
    public NsiRef getNsiCategory() {
        return nsiCategory;
    }

    /**
     * Sets the value of the nsiCategory property.
     * 
     * @param value
     *     allowed object is
     *     {@link NsiRef }
     *     
     */
    public void setNsiCategory(NsiRef value) {
        this.nsiCategory = value;
    }

    /**
     * Gets the value of the budgetLevel property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBudgetLevel() {
        return budgetLevel;
    }

    /**
     * Sets the value of the budgetLevel property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBudgetLevel(String value) {
        this.budgetLevel = value;
    }

    /**
     * Gets the value of the payoutTerm property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPayoutTerm() {
        return payoutTerm;
    }

    /**
     * Sets the value of the payoutTerm property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPayoutTerm(String value) {
        this.payoutTerm = value;
    }

    /**
     * Gets the value of the provisionDocuments property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProvisionDocuments() {
        return provisionDocuments;
    }

    /**
     * Sets the value of the provisionDocuments property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProvisionDocuments(String value) {
        this.provisionDocuments = value;
    }

    /**
     * Gets the value of the denialReasons property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDenialReasons() {
        return denialReasons;
    }

    /**
     * Sets the value of the denialReasons property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDenialReasons(String value) {
        this.denialReasons = value;
    }

    /**
     * Gets the value of the suspensionReasons property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSuspensionReasons() {
        return suspensionReasons;
    }

    /**
     * Sets the value of the suspensionReasons property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSuspensionReasons(String value) {
        this.suspensionReasons = value;
    }

    /**
     * Gets the value of the terminationReasons property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTerminationReasons() {
        return terminationReasons;
    }

    /**
     * Sets the value of the terminationReasons property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTerminationReasons(String value) {
        this.terminationReasons = value;
    }

    /**
     * Gets the value of the resumptionReasons property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getResumptionReasons() {
        return resumptionReasons;
    }

    /**
     * Sets the value of the resumptionReasons property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setResumptionReasons(String value) {
        this.resumptionReasons = value;
    }

    /**
     * Gets the value of the recalculationReasons property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRecalculationReasons() {
        return recalculationReasons;
    }

    /**
     * Sets the value of the recalculationReasons property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRecalculationReasons(String value) {
        this.recalculationReasons = value;
    }

    /**
     * Gets the value of the refundReasons property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRefundReasons() {
        return refundReasons;
    }

    /**
     * Sets the value of the refundReasons property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRefundReasons(String value) {
        this.refundReasons = value;
    }

    /**
     * Gets the value of the act property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the act property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAct().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ActType }
     * 
     * 
     */
    public List<ActType> getAct() {
        if (act == null) {
            act = new ArrayList<ActType>();
        }
        return this.act;
    }

    /**
     * Gets the value of the fixedCompensationSum property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getFixedCompensationSum() {
        return fixedCompensationSum;
    }

    /**
     * Sets the value of the fixedCompensationSum property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setFixedCompensationSum(BigDecimal value) {
        this.fixedCompensationSum = value;
    }

    /**
     * Gets the value of the fixedSumEstablishmentDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getFixedSumEstablishmentDate() {
        return fixedSumEstablishmentDate;
    }

    /**
     * Sets the value of the fixedSumEstablishmentDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setFixedSumEstablishmentDate(XMLGregorianCalendar value) {
        this.fixedSumEstablishmentDate = value;
    }

    /**
     * Gets the value of the comment property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getComment() {
        return comment;
    }

    /**
     * Sets the value of the comment property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setComment(String value) {
        this.comment = value;
    }

    /**
     * Gets the value of the description property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets the value of the description property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescription(String value) {
        this.description = value;
    }

    /**
     * Gets the value of the actual property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the actual property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getActual().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ExportCategoryType.Actual }
     * 
     * 
     */
    public List<ExportCategoryType.Actual> getActual() {
        if (actual == null) {
            actual = new ArrayList<ExportCategoryType.Actual>();
        }
        return this.actual;
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
     *         &lt;element name="Service" type="{http://dom.gosuslugi.ru/schema/integration/msp/}ServiceType"/>
     *         &lt;element name="Housing" maxOccurs="3">
     *           &lt;simpleType>
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *               &lt;enumeration value="PrivateHousing"/>
     *               &lt;enumeration value="MunicipalHousing"/>
     *               &lt;enumeration value="StateHousing"/>
     *             &lt;/restriction>
     *           &lt;/simpleType>
     *         &lt;/element>
     *         &lt;element name="NsiDiscountAmountLimitationCode" type="{http://dom.gosuslugi.ru/schema/integration/nsi-base/}nsiRef"/>
     *         &lt;element name="AppliesToAllFamilyMembers" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
     *         &lt;element name="DiscountSize">
     *           &lt;simpleType>
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}decimal">
     *               &lt;minInclusive value="0"/>
     *               &lt;maxInclusive value="100"/>
     *               &lt;fractionDigits value="2"/>
     *               &lt;totalDigits value="5"/>
     *             &lt;/restriction>
     *           &lt;/simpleType>
     *         &lt;/element>
     *         &lt;element name="ValidFrom" type="{http://www.w3.org/2001/XMLSchema}date"/>
     *         &lt;element name="ValidTo" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
     *         &lt;element name="Comment" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
        "housing",
        "nsiDiscountAmountLimitationCode",
        "appliesToAllFamilyMembers",
        "discountSize",
        "validFrom",
        "validTo",
        "comment"
    })
    public static class Actual {

        @XmlElement(name = "Service", required = true)
        @XmlSchemaType(name = "string")
        protected ServiceType service;
        @XmlElement(name = "Housing", required = true)
        protected List<String> housing;
        @XmlElement(name = "NsiDiscountAmountLimitationCode", required = true)
        protected NsiRef nsiDiscountAmountLimitationCode;
        @XmlElement(name = "AppliesToAllFamilyMembers")
        protected boolean appliesToAllFamilyMembers;
        @XmlElement(name = "DiscountSize", required = true)
        protected BigDecimal discountSize;
        @XmlElement(name = "ValidFrom", required = true)
        @XmlSchemaType(name = "date")
        protected XMLGregorianCalendar validFrom;
        @XmlElement(name = "ValidTo")
        @XmlSchemaType(name = "date")
        protected XMLGregorianCalendar validTo;
        @XmlElement(name = "Comment")
        protected String comment;

        /**
         * Gets the value of the service property.
         * 
         * @return
         *     possible object is
         *     {@link ServiceType }
         *     
         */
        public ServiceType getService() {
            return service;
        }

        /**
         * Sets the value of the service property.
         * 
         * @param value
         *     allowed object is
         *     {@link ServiceType }
         *     
         */
        public void setService(ServiceType value) {
            this.service = value;
        }

        /**
         * Gets the value of the housing property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the housing property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getHousing().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link String }
         * 
         * 
         */
        public List<String> getHousing() {
            if (housing == null) {
                housing = new ArrayList<String>();
            }
            return this.housing;
        }

        /**
         * Gets the value of the nsiDiscountAmountLimitationCode property.
         * 
         * @return
         *     possible object is
         *     {@link NsiRef }
         *     
         */
        public NsiRef getNsiDiscountAmountLimitationCode() {
            return nsiDiscountAmountLimitationCode;
        }

        /**
         * Sets the value of the nsiDiscountAmountLimitationCode property.
         * 
         * @param value
         *     allowed object is
         *     {@link NsiRef }
         *     
         */
        public void setNsiDiscountAmountLimitationCode(NsiRef value) {
            this.nsiDiscountAmountLimitationCode = value;
        }

        /**
         * Gets the value of the appliesToAllFamilyMembers property.
         * 
         */
        public boolean isAppliesToAllFamilyMembers() {
            return appliesToAllFamilyMembers;
        }

        /**
         * Sets the value of the appliesToAllFamilyMembers property.
         * 
         */
        public void setAppliesToAllFamilyMembers(boolean value) {
            this.appliesToAllFamilyMembers = value;
        }

        /**
         * Gets the value of the discountSize property.
         * 
         * @return
         *     possible object is
         *     {@link BigDecimal }
         *     
         */
        public BigDecimal getDiscountSize() {
            return discountSize;
        }

        /**
         * Sets the value of the discountSize property.
         * 
         * @param value
         *     allowed object is
         *     {@link BigDecimal }
         *     
         */
        public void setDiscountSize(BigDecimal value) {
            this.discountSize = value;
        }

        /**
         * Gets the value of the validFrom property.
         * 
         * @return
         *     possible object is
         *     {@link XMLGregorianCalendar }
         *     
         */
        public XMLGregorianCalendar getValidFrom() {
            return validFrom;
        }

        /**
         * Sets the value of the validFrom property.
         * 
         * @param value
         *     allowed object is
         *     {@link XMLGregorianCalendar }
         *     
         */
        public void setValidFrom(XMLGregorianCalendar value) {
            this.validFrom = value;
        }

        /**
         * Gets the value of the validTo property.
         * 
         * @return
         *     possible object is
         *     {@link XMLGregorianCalendar }
         *     
         */
        public XMLGregorianCalendar getValidTo() {
            return validTo;
        }

        /**
         * Sets the value of the validTo property.
         * 
         * @param value
         *     allowed object is
         *     {@link XMLGregorianCalendar }
         *     
         */
        public void setValidTo(XMLGregorianCalendar value) {
            this.validTo = value;
        }

        /**
         * Gets the value of the comment property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getComment() {
            return comment;
        }

        /**
         * Sets the value of the comment property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setComment(String value) {
            this.comment = value;
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
     *         &lt;element name="Region" type="{http://dom.gosuslugi.ru/schema/integration/base/}RegionType"/>
     *         &lt;element name="Municipality" type="{http://dom.gosuslugi.ru/schema/integration/base/}OKTMORefType"/>
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
        "region",
        "municipality"
    })
    public static class Territory {

        @XmlElement(name = "Region")
        protected RegionType region;
        @XmlElement(name = "Municipality")
        protected OKTMORefType municipality;

        /**
         * Gets the value of the region property.
         * 
         * @return
         *     possible object is
         *     {@link RegionType }
         *     
         */
        public RegionType getRegion() {
            return region;
        }

        /**
         * Sets the value of the region property.
         * 
         * @param value
         *     allowed object is
         *     {@link RegionType }
         *     
         */
        public void setRegion(RegionType value) {
            this.region = value;
        }

        /**
         * Gets the value of the municipality property.
         * 
         * @return
         *     possible object is
         *     {@link OKTMORefType }
         *     
         */
        public OKTMORefType getMunicipality() {
            return municipality;
        }

        /**
         * Sets the value of the municipality property.
         * 
         * @param value
         *     allowed object is
         *     {@link OKTMORefType }
         *     
         */
        public void setMunicipality(OKTMORefType value) {
            this.municipality = value;
        }

    }

}
