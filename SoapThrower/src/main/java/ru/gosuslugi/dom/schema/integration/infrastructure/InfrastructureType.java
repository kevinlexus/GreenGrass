
package ru.gosuslugi.dom.schema.integration.infrastructure;

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
import ru.gosuslugi.dom.schema.integration.base.OKTMORefType;
import ru.gosuslugi.dom.schema.integration.nsi_base.NsiRef;


/**
 * <p>Java class for InfrastructureType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="InfrastructureType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Name">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://dom.gosuslugi.ru/schema/integration/infrastructure/}ShortTextType">
 *               &lt;minLength value="1"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="Base" type="{http://dom.gosuslugi.ru/schema/integration/nsi-base/}nsiRef"/>
 *         &lt;element name="AttachmentList" type="{http://dom.gosuslugi.ru/schema/integration/base/}AttachmentType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;choice>
 *           &lt;element name="EndManagmentDate" type="{http://www.w3.org/2001/XMLSchema}date"/>
 *           &lt;element name="IndefiniteManagement" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;/choice>
 *         &lt;element name="ManagerOKI" type="{http://dom.gosuslugi.ru/schema/integration/infrastructure/}ManagerOKIType" minOccurs="0"/>
 *         &lt;element name="OKIType">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/nsi-base/}nsiRef">
 *                 &lt;choice minOccurs="0">
 *                   &lt;choice minOccurs="0">
 *                     &lt;element name="WaterIntakeType" type="{http://dom.gosuslugi.ru/schema/integration/nsi-base/}nsiRef" minOccurs="0"/>
 *                     &lt;element name="ESubstationType" type="{http://dom.gosuslugi.ru/schema/integration/nsi-base/}nsiRef" minOccurs="0"/>
 *                     &lt;element name="PowerPlantType" type="{http://dom.gosuslugi.ru/schema/integration/nsi-base/}nsiRef" minOccurs="0"/>
 *                   &lt;/choice>
 *                   &lt;element name="FuelType" type="{http://dom.gosuslugi.ru/schema/integration/nsi-base/}nsiRef" minOccurs="0"/>
 *                   &lt;element name="GasNetworkType" type="{http://dom.gosuslugi.ru/schema/integration/nsi-base/}nsiRef" minOccurs="0"/>
 *                 &lt;/choice>
 *               &lt;/extension>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="Services" type="{http://dom.gosuslugi.ru/schema/integration/nsi-base/}nsiRef" maxOccurs="unbounded"/>
 *         &lt;element name="OKTMO" type="{http://dom.gosuslugi.ru/schema/integration/base/}OKTMORefType"/>
 *         &lt;element name="Adress" type="{http://dom.gosuslugi.ru/schema/integration/infrastructure/}ShortTextType" minOccurs="0"/>
 *         &lt;element name="CommissioningYear">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://dom.gosuslugi.ru/schema/integration/base/}YearType">
 *               &lt;minInclusive value="1850"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="IndependentSource" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="Deterioration">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://dom.gosuslugi.ru/schema/integration/infrastructure/}CentesimalType">
 *               &lt;totalDigits value="3"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="ObjectProperty" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;choice>
 *                   &lt;element name="Resources" maxOccurs="unbounded">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/infrastructure/}ResourceType">
 *                           &lt;sequence>
 *                             &lt;element name="SetPower" type="{http://dom.gosuslugi.ru/schema/integration/infrastructure/}PowerType" minOccurs="0"/>
 *                             &lt;element name="SitingPower" type="{http://dom.gosuslugi.ru/schema/integration/infrastructure/}PowerType" minOccurs="0"/>
 *                           &lt;/sequence>
 *                         &lt;/extension>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                   &lt;sequence>
 *                     &lt;element name="TransportationResources" maxOccurs="unbounded">
 *                       &lt;complexType>
 *                         &lt;complexContent>
 *                           &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/infrastructure/}ResourceType">
 *                             &lt;sequence>
 *                               &lt;element name="VolumeLosses">
 *                                 &lt;simpleType>
 *                                   &lt;restriction base="{http://dom.gosuslugi.ru/schema/integration/infrastructure/}PowerType">
 *                                     &lt;totalDigits value="8"/>
 *                                   &lt;/restriction>
 *                                 &lt;/simpleType>
 *                               &lt;/element>
 *                               &lt;element name="CoolantType" type="{http://dom.gosuslugi.ru/schema/integration/nsi-base/}nsiRef" minOccurs="0"/>
 *                             &lt;/sequence>
 *                           &lt;/extension>
 *                         &lt;/complexContent>
 *                       &lt;/complexType>
 *                     &lt;/element>
 *                     &lt;element name="NetPieces" maxOccurs="unbounded">
 *                       &lt;complexType>
 *                         &lt;complexContent>
 *                           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                             &lt;sequence>
 *                               &lt;element name="Name" minOccurs="0">
 *                                 &lt;simpleType>
 *                                   &lt;restriction base="{http://dom.gosuslugi.ru/schema/integration/infrastructure/}ShortTextType">
 *                                     &lt;maxLength value="100"/>
 *                                   &lt;/restriction>
 *                                 &lt;/simpleType>
 *                               &lt;/element>
 *                               &lt;element name="Diameter">
 *                                 &lt;simpleType>
 *                                   &lt;restriction base="{http://dom.gosuslugi.ru/schema/integration/infrastructure/}PowerType">
 *                                     &lt;totalDigits value="8"/>
 *                                     &lt;fractionDigits value="3"/>
 *                                   &lt;/restriction>
 *                                 &lt;/simpleType>
 *                               &lt;/element>
 *                               &lt;element name="Length">
 *                                 &lt;simpleType>
 *                                   &lt;restriction base="{http://dom.gosuslugi.ru/schema/integration/infrastructure/}PowerType">
 *                                     &lt;totalDigits value="8"/>
 *                                     &lt;fractionDigits value="3"/>
 *                                   &lt;/restriction>
 *                                 &lt;/simpleType>
 *                               &lt;/element>
 *                               &lt;element name="NeedReplaced" minOccurs="0">
 *                                 &lt;simpleType>
 *                                   &lt;restriction base="{http://dom.gosuslugi.ru/schema/integration/infrastructure/}PowerType">
 *                                     &lt;totalDigits value="8"/>
 *                                     &lt;fractionDigits value="3"/>
 *                                   &lt;/restriction>
 *                                 &lt;/simpleType>
 *                               &lt;/element>
 *                               &lt;element name="Wearout" type="{http://dom.gosuslugi.ru/schema/integration/infrastructure/}CentesimalType" minOccurs="0"/>
 *                               &lt;element name="PressureType" type="{http://dom.gosuslugi.ru/schema/integration/nsi-base/}nsiRef" minOccurs="0"/>
 *                               &lt;element name="VoltageType" type="{http://dom.gosuslugi.ru/schema/integration/nsi-base/}nsiRef" minOccurs="0"/>
 *                             &lt;/sequence>
 *                           &lt;/restriction>
 *                         &lt;/complexContent>
 *                       &lt;/complexType>
 *                     &lt;/element>
 *                     &lt;element name="CountAccidents" minOccurs="0">
 *                       &lt;simpleType>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}nonNegativeInteger">
 *                           &lt;maxInclusive value="100"/>
 *                         &lt;/restriction>
 *                       &lt;/simpleType>
 *                     &lt;/element>
 *                     &lt;element name="OKILinks" minOccurs="0">
 *                       &lt;complexType>
 *                         &lt;complexContent>
 *                           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                             &lt;sequence>
 *                               &lt;element name="SourceOKI" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType" maxOccurs="unbounded"/>
 *                               &lt;element name="ReceiverOKI" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType" maxOccurs="unbounded" minOccurs="0"/>
 *                             &lt;/sequence>
 *                           &lt;/restriction>
 *                         &lt;/complexContent>
 *                       &lt;/complexType>
 *                     &lt;/element>
 *                   &lt;/sequence>
 *                 &lt;/choice>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="AddInfo" type="{http://dom.gosuslugi.ru/schema/integration/base/}LongTextType" minOccurs="0"/>
 *         &lt;element name="AttachmentsEnergyEfficiency" type="{http://dom.gosuslugi.ru/schema/integration/base/}AttachmentType" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "InfrastructureType", propOrder = {
    "name",
    "base",
    "attachmentList",
    "endManagmentDate",
    "indefiniteManagement",
    "managerOKI",
    "okiType",
    "services",
    "oktmo",
    "adress",
    "commissioningYear",
    "independentSource",
    "deterioration",
    "objectProperty",
    "addInfo",
    "attachmentsEnergyEfficiency"
})
@XmlSeeAlso({
    ru.gosuslugi.dom.schema.integration.infrastructure.ExportOKIResultType.OKI.class,
    ru.gosuslugi.dom.schema.integration.infrastructure.ImportOKIRequest.RKIItem.OKI.class
})
public class InfrastructureType {

    @XmlElement(name = "Name", required = true)
    protected String name;
    @XmlElement(name = "Base", required = true)
    protected NsiRef base;
    @XmlElement(name = "AttachmentList")
    protected List<AttachmentType> attachmentList;
    @XmlElement(name = "EndManagmentDate")
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar endManagmentDate;
    @XmlElement(name = "IndefiniteManagement")
    protected Boolean indefiniteManagement;
    @XmlElement(name = "ManagerOKI")
    protected ManagerOKIType managerOKI;
    @XmlElement(name = "OKIType", required = true)
    protected InfrastructureType.OKIType okiType;
    @XmlElement(name = "Services", required = true)
    protected List<NsiRef> services;
    @XmlElement(name = "OKTMO", required = true)
    protected OKTMORefType oktmo;
    @XmlElement(name = "Adress")
    protected String adress;
    @XmlElement(name = "CommissioningYear")
    protected short commissioningYear;
    @XmlElement(name = "IndependentSource")
    protected Boolean independentSource;
    @XmlElement(name = "Deterioration", required = true)
    protected BigDecimal deterioration;
    @XmlElement(name = "ObjectProperty")
    protected InfrastructureType.ObjectProperty objectProperty;
    @XmlElement(name = "AddInfo")
    protected String addInfo;
    @XmlElement(name = "AttachmentsEnergyEfficiency")
    protected List<AttachmentType> attachmentsEnergyEfficiency;

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
     * Gets the value of the base property.
     * 
     * @return
     *     possible object is
     *     {@link NsiRef }
     *     
     */
    public NsiRef getBase() {
        return base;
    }

    /**
     * Sets the value of the base property.
     * 
     * @param value
     *     allowed object is
     *     {@link NsiRef }
     *     
     */
    public void setBase(NsiRef value) {
        this.base = value;
    }

    /**
     * Gets the value of the attachmentList property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the attachmentList property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAttachmentList().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link AttachmentType }
     * 
     * 
     */
    public List<AttachmentType> getAttachmentList() {
        if (attachmentList == null) {
            attachmentList = new ArrayList<AttachmentType>();
        }
        return this.attachmentList;
    }

    /**
     * Gets the value of the endManagmentDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getEndManagmentDate() {
        return endManagmentDate;
    }

    /**
     * Sets the value of the endManagmentDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setEndManagmentDate(XMLGregorianCalendar value) {
        this.endManagmentDate = value;
    }

    /**
     * Gets the value of the indefiniteManagement property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isIndefiniteManagement() {
        return indefiniteManagement;
    }

    /**
     * Sets the value of the indefiniteManagement property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setIndefiniteManagement(Boolean value) {
        this.indefiniteManagement = value;
    }

    /**
     * Gets the value of the managerOKI property.
     * 
     * @return
     *     possible object is
     *     {@link ManagerOKIType }
     *     
     */
    public ManagerOKIType getManagerOKI() {
        return managerOKI;
    }

    /**
     * Sets the value of the managerOKI property.
     * 
     * @param value
     *     allowed object is
     *     {@link ManagerOKIType }
     *     
     */
    public void setManagerOKI(ManagerOKIType value) {
        this.managerOKI = value;
    }

    /**
     * Gets the value of the okiType property.
     * 
     * @return
     *     possible object is
     *     {@link InfrastructureType.OKIType }
     *     
     */
    public InfrastructureType.OKIType getOKIType() {
        return okiType;
    }

    /**
     * Sets the value of the okiType property.
     * 
     * @param value
     *     allowed object is
     *     {@link InfrastructureType.OKIType }
     *     
     */
    public void setOKIType(InfrastructureType.OKIType value) {
        this.okiType = value;
    }

    /**
     * Gets the value of the services property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the services property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getServices().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link NsiRef }
     * 
     * 
     */
    public List<NsiRef> getServices() {
        if (services == null) {
            services = new ArrayList<NsiRef>();
        }
        return this.services;
    }

    /**
     * Gets the value of the oktmo property.
     * 
     * @return
     *     possible object is
     *     {@link OKTMORefType }
     *     
     */
    public OKTMORefType getOKTMO() {
        return oktmo;
    }

    /**
     * Sets the value of the oktmo property.
     * 
     * @param value
     *     allowed object is
     *     {@link OKTMORefType }
     *     
     */
    public void setOKTMO(OKTMORefType value) {
        this.oktmo = value;
    }

    /**
     * Gets the value of the adress property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAdress() {
        return adress;
    }

    /**
     * Sets the value of the adress property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAdress(String value) {
        this.adress = value;
    }

    /**
     * Gets the value of the commissioningYear property.
     * 
     */
    public short getCommissioningYear() {
        return commissioningYear;
    }

    /**
     * Sets the value of the commissioningYear property.
     * 
     */
    public void setCommissioningYear(short value) {
        this.commissioningYear = value;
    }

    /**
     * Gets the value of the independentSource property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isIndependentSource() {
        return independentSource;
    }

    /**
     * Sets the value of the independentSource property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setIndependentSource(Boolean value) {
        this.independentSource = value;
    }

    /**
     * Gets the value of the deterioration property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getDeterioration() {
        return deterioration;
    }

    /**
     * Sets the value of the deterioration property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setDeterioration(BigDecimal value) {
        this.deterioration = value;
    }

    /**
     * Gets the value of the objectProperty property.
     * 
     * @return
     *     possible object is
     *     {@link InfrastructureType.ObjectProperty }
     *     
     */
    public InfrastructureType.ObjectProperty getObjectProperty() {
        return objectProperty;
    }

    /**
     * Sets the value of the objectProperty property.
     * 
     * @param value
     *     allowed object is
     *     {@link InfrastructureType.ObjectProperty }
     *     
     */
    public void setObjectProperty(InfrastructureType.ObjectProperty value) {
        this.objectProperty = value;
    }

    /**
     * Gets the value of the addInfo property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAddInfo() {
        return addInfo;
    }

    /**
     * Sets the value of the addInfo property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAddInfo(String value) {
        this.addInfo = value;
    }

    /**
     * Gets the value of the attachmentsEnergyEfficiency property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the attachmentsEnergyEfficiency property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAttachmentsEnergyEfficiency().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link AttachmentType }
     * 
     * 
     */
    public List<AttachmentType> getAttachmentsEnergyEfficiency() {
        if (attachmentsEnergyEfficiency == null) {
            attachmentsEnergyEfficiency = new ArrayList<AttachmentType>();
        }
        return this.attachmentsEnergyEfficiency;
    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/nsi-base/}nsiRef">
     *       &lt;choice minOccurs="0">
     *         &lt;choice minOccurs="0">
     *           &lt;element name="WaterIntakeType" type="{http://dom.gosuslugi.ru/schema/integration/nsi-base/}nsiRef" minOccurs="0"/>
     *           &lt;element name="ESubstationType" type="{http://dom.gosuslugi.ru/schema/integration/nsi-base/}nsiRef" minOccurs="0"/>
     *           &lt;element name="PowerPlantType" type="{http://dom.gosuslugi.ru/schema/integration/nsi-base/}nsiRef" minOccurs="0"/>
     *         &lt;/choice>
     *         &lt;element name="FuelType" type="{http://dom.gosuslugi.ru/schema/integration/nsi-base/}nsiRef" minOccurs="0"/>
     *         &lt;element name="GasNetworkType" type="{http://dom.gosuslugi.ru/schema/integration/nsi-base/}nsiRef" minOccurs="0"/>
     *       &lt;/choice>
     *     &lt;/extension>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "waterIntakeType",
        "eSubstationType",
        "powerPlantType",
        "fuelType",
        "gasNetworkType"
    })
    public static class OKIType
        extends NsiRef
    {

        @XmlElement(name = "WaterIntakeType")
        protected NsiRef waterIntakeType;
        @XmlElement(name = "ESubstationType")
        protected NsiRef eSubstationType;
        @XmlElement(name = "PowerPlantType")
        protected NsiRef powerPlantType;
        @XmlElement(name = "FuelType")
        protected NsiRef fuelType;
        @XmlElement(name = "GasNetworkType")
        protected NsiRef gasNetworkType;

        /**
         * Gets the value of the waterIntakeType property.
         * 
         * @return
         *     possible object is
         *     {@link NsiRef }
         *     
         */
        public NsiRef getWaterIntakeType() {
            return waterIntakeType;
        }

        /**
         * Sets the value of the waterIntakeType property.
         * 
         * @param value
         *     allowed object is
         *     {@link NsiRef }
         *     
         */
        public void setWaterIntakeType(NsiRef value) {
            this.waterIntakeType = value;
        }

        /**
         * Gets the value of the eSubstationType property.
         * 
         * @return
         *     possible object is
         *     {@link NsiRef }
         *     
         */
        public NsiRef getESubstationType() {
            return eSubstationType;
        }

        /**
         * Sets the value of the eSubstationType property.
         * 
         * @param value
         *     allowed object is
         *     {@link NsiRef }
         *     
         */
        public void setESubstationType(NsiRef value) {
            this.eSubstationType = value;
        }

        /**
         * Gets the value of the powerPlantType property.
         * 
         * @return
         *     possible object is
         *     {@link NsiRef }
         *     
         */
        public NsiRef getPowerPlantType() {
            return powerPlantType;
        }

        /**
         * Sets the value of the powerPlantType property.
         * 
         * @param value
         *     allowed object is
         *     {@link NsiRef }
         *     
         */
        public void setPowerPlantType(NsiRef value) {
            this.powerPlantType = value;
        }

        /**
         * Gets the value of the fuelType property.
         * 
         * @return
         *     possible object is
         *     {@link NsiRef }
         *     
         */
        public NsiRef getFuelType() {
            return fuelType;
        }

        /**
         * Sets the value of the fuelType property.
         * 
         * @param value
         *     allowed object is
         *     {@link NsiRef }
         *     
         */
        public void setFuelType(NsiRef value) {
            this.fuelType = value;
        }

        /**
         * Gets the value of the gasNetworkType property.
         * 
         * @return
         *     possible object is
         *     {@link NsiRef }
         *     
         */
        public NsiRef getGasNetworkType() {
            return gasNetworkType;
        }

        /**
         * Sets the value of the gasNetworkType property.
         * 
         * @param value
         *     allowed object is
         *     {@link NsiRef }
         *     
         */
        public void setGasNetworkType(NsiRef value) {
            this.gasNetworkType = value;
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
     *         &lt;element name="Resources" maxOccurs="unbounded">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/infrastructure/}ResourceType">
     *                 &lt;sequence>
     *                   &lt;element name="SetPower" type="{http://dom.gosuslugi.ru/schema/integration/infrastructure/}PowerType" minOccurs="0"/>
     *                   &lt;element name="SitingPower" type="{http://dom.gosuslugi.ru/schema/integration/infrastructure/}PowerType" minOccurs="0"/>
     *                 &lt;/sequence>
     *               &lt;/extension>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *         &lt;sequence>
     *           &lt;element name="TransportationResources" maxOccurs="unbounded">
     *             &lt;complexType>
     *               &lt;complexContent>
     *                 &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/infrastructure/}ResourceType">
     *                   &lt;sequence>
     *                     &lt;element name="VolumeLosses">
     *                       &lt;simpleType>
     *                         &lt;restriction base="{http://dom.gosuslugi.ru/schema/integration/infrastructure/}PowerType">
     *                           &lt;totalDigits value="8"/>
     *                         &lt;/restriction>
     *                       &lt;/simpleType>
     *                     &lt;/element>
     *                     &lt;element name="CoolantType" type="{http://dom.gosuslugi.ru/schema/integration/nsi-base/}nsiRef" minOccurs="0"/>
     *                   &lt;/sequence>
     *                 &lt;/extension>
     *               &lt;/complexContent>
     *             &lt;/complexType>
     *           &lt;/element>
     *           &lt;element name="NetPieces" maxOccurs="unbounded">
     *             &lt;complexType>
     *               &lt;complexContent>
     *                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                   &lt;sequence>
     *                     &lt;element name="Name" minOccurs="0">
     *                       &lt;simpleType>
     *                         &lt;restriction base="{http://dom.gosuslugi.ru/schema/integration/infrastructure/}ShortTextType">
     *                           &lt;maxLength value="100"/>
     *                         &lt;/restriction>
     *                       &lt;/simpleType>
     *                     &lt;/element>
     *                     &lt;element name="Diameter">
     *                       &lt;simpleType>
     *                         &lt;restriction base="{http://dom.gosuslugi.ru/schema/integration/infrastructure/}PowerType">
     *                           &lt;totalDigits value="8"/>
     *                           &lt;fractionDigits value="3"/>
     *                         &lt;/restriction>
     *                       &lt;/simpleType>
     *                     &lt;/element>
     *                     &lt;element name="Length">
     *                       &lt;simpleType>
     *                         &lt;restriction base="{http://dom.gosuslugi.ru/schema/integration/infrastructure/}PowerType">
     *                           &lt;totalDigits value="8"/>
     *                           &lt;fractionDigits value="3"/>
     *                         &lt;/restriction>
     *                       &lt;/simpleType>
     *                     &lt;/element>
     *                     &lt;element name="NeedReplaced" minOccurs="0">
     *                       &lt;simpleType>
     *                         &lt;restriction base="{http://dom.gosuslugi.ru/schema/integration/infrastructure/}PowerType">
     *                           &lt;totalDigits value="8"/>
     *                           &lt;fractionDigits value="3"/>
     *                         &lt;/restriction>
     *                       &lt;/simpleType>
     *                     &lt;/element>
     *                     &lt;element name="Wearout" type="{http://dom.gosuslugi.ru/schema/integration/infrastructure/}CentesimalType" minOccurs="0"/>
     *                     &lt;element name="PressureType" type="{http://dom.gosuslugi.ru/schema/integration/nsi-base/}nsiRef" minOccurs="0"/>
     *                     &lt;element name="VoltageType" type="{http://dom.gosuslugi.ru/schema/integration/nsi-base/}nsiRef" minOccurs="0"/>
     *                   &lt;/sequence>
     *                 &lt;/restriction>
     *               &lt;/complexContent>
     *             &lt;/complexType>
     *           &lt;/element>
     *           &lt;element name="CountAccidents" minOccurs="0">
     *             &lt;simpleType>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}nonNegativeInteger">
     *                 &lt;maxInclusive value="100"/>
     *               &lt;/restriction>
     *             &lt;/simpleType>
     *           &lt;/element>
     *           &lt;element name="OKILinks" minOccurs="0">
     *             &lt;complexType>
     *               &lt;complexContent>
     *                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                   &lt;sequence>
     *                     &lt;element name="SourceOKI" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType" maxOccurs="unbounded"/>
     *                     &lt;element name="ReceiverOKI" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType" maxOccurs="unbounded" minOccurs="0"/>
     *                   &lt;/sequence>
     *                 &lt;/restriction>
     *               &lt;/complexContent>
     *             &lt;/complexType>
     *           &lt;/element>
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
        "resources",
        "transportationResources",
        "netPieces",
        "countAccidents",
        "okiLinks"
    })
    public static class ObjectProperty {

        @XmlElement(name = "Resources")
        protected List<InfrastructureType.ObjectProperty.Resources> resources;
        @XmlElement(name = "TransportationResources")
        protected List<InfrastructureType.ObjectProperty.TransportationResources> transportationResources;
        @XmlElement(name = "NetPieces")
        protected List<InfrastructureType.ObjectProperty.NetPieces> netPieces;
        @XmlElement(name = "CountAccidents")
        protected Integer countAccidents;
        @XmlElement(name = "OKILinks")
        protected InfrastructureType.ObjectProperty.OKILinks okiLinks;

        /**
         * Gets the value of the resources property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the resources property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getResources().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link InfrastructureType.ObjectProperty.Resources }
         * 
         * 
         */
        public List<InfrastructureType.ObjectProperty.Resources> getResources() {
            if (resources == null) {
                resources = new ArrayList<InfrastructureType.ObjectProperty.Resources>();
            }
            return this.resources;
        }

        /**
         * Gets the value of the transportationResources property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the transportationResources property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getTransportationResources().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link InfrastructureType.ObjectProperty.TransportationResources }
         * 
         * 
         */
        public List<InfrastructureType.ObjectProperty.TransportationResources> getTransportationResources() {
            if (transportationResources == null) {
                transportationResources = new ArrayList<InfrastructureType.ObjectProperty.TransportationResources>();
            }
            return this.transportationResources;
        }

        /**
         * Gets the value of the netPieces property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the netPieces property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getNetPieces().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link InfrastructureType.ObjectProperty.NetPieces }
         * 
         * 
         */
        public List<InfrastructureType.ObjectProperty.NetPieces> getNetPieces() {
            if (netPieces == null) {
                netPieces = new ArrayList<InfrastructureType.ObjectProperty.NetPieces>();
            }
            return this.netPieces;
        }

        /**
         * Gets the value of the countAccidents property.
         * 
         * @return
         *     possible object is
         *     {@link Integer }
         *     
         */
        public Integer getCountAccidents() {
            return countAccidents;
        }

        /**
         * Sets the value of the countAccidents property.
         * 
         * @param value
         *     allowed object is
         *     {@link Integer }
         *     
         */
        public void setCountAccidents(Integer value) {
            this.countAccidents = value;
        }

        /**
         * Gets the value of the okiLinks property.
         * 
         * @return
         *     possible object is
         *     {@link InfrastructureType.ObjectProperty.OKILinks }
         *     
         */
        public InfrastructureType.ObjectProperty.OKILinks getOKILinks() {
            return okiLinks;
        }

        /**
         * Sets the value of the okiLinks property.
         * 
         * @param value
         *     allowed object is
         *     {@link InfrastructureType.ObjectProperty.OKILinks }
         *     
         */
        public void setOKILinks(InfrastructureType.ObjectProperty.OKILinks value) {
            this.okiLinks = value;
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
         *         &lt;element name="Name" minOccurs="0">
         *           &lt;simpleType>
         *             &lt;restriction base="{http://dom.gosuslugi.ru/schema/integration/infrastructure/}ShortTextType">
         *               &lt;maxLength value="100"/>
         *             &lt;/restriction>
         *           &lt;/simpleType>
         *         &lt;/element>
         *         &lt;element name="Diameter">
         *           &lt;simpleType>
         *             &lt;restriction base="{http://dom.gosuslugi.ru/schema/integration/infrastructure/}PowerType">
         *               &lt;totalDigits value="8"/>
         *               &lt;fractionDigits value="3"/>
         *             &lt;/restriction>
         *           &lt;/simpleType>
         *         &lt;/element>
         *         &lt;element name="Length">
         *           &lt;simpleType>
         *             &lt;restriction base="{http://dom.gosuslugi.ru/schema/integration/infrastructure/}PowerType">
         *               &lt;totalDigits value="8"/>
         *               &lt;fractionDigits value="3"/>
         *             &lt;/restriction>
         *           &lt;/simpleType>
         *         &lt;/element>
         *         &lt;element name="NeedReplaced" minOccurs="0">
         *           &lt;simpleType>
         *             &lt;restriction base="{http://dom.gosuslugi.ru/schema/integration/infrastructure/}PowerType">
         *               &lt;totalDigits value="8"/>
         *               &lt;fractionDigits value="3"/>
         *             &lt;/restriction>
         *           &lt;/simpleType>
         *         &lt;/element>
         *         &lt;element name="Wearout" type="{http://dom.gosuslugi.ru/schema/integration/infrastructure/}CentesimalType" minOccurs="0"/>
         *         &lt;element name="PressureType" type="{http://dom.gosuslugi.ru/schema/integration/nsi-base/}nsiRef" minOccurs="0"/>
         *         &lt;element name="VoltageType" type="{http://dom.gosuslugi.ru/schema/integration/nsi-base/}nsiRef" minOccurs="0"/>
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
            "name",
            "diameter",
            "length",
            "needReplaced",
            "wearout",
            "pressureType",
            "voltageType"
        })
        public static class NetPieces {

            @XmlElement(name = "Name")
            protected String name;
            @XmlElement(name = "Diameter", required = true)
            protected BigDecimal diameter;
            @XmlElement(name = "Length", required = true)
            protected BigDecimal length;
            @XmlElement(name = "NeedReplaced")
            protected BigDecimal needReplaced;
            @XmlElement(name = "Wearout")
            protected BigDecimal wearout;
            @XmlElement(name = "PressureType")
            protected NsiRef pressureType;
            @XmlElement(name = "VoltageType")
            protected NsiRef voltageType;

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
             * Gets the value of the diameter property.
             * 
             * @return
             *     possible object is
             *     {@link BigDecimal }
             *     
             */
            public BigDecimal getDiameter() {
                return diameter;
            }

            /**
             * Sets the value of the diameter property.
             * 
             * @param value
             *     allowed object is
             *     {@link BigDecimal }
             *     
             */
            public void setDiameter(BigDecimal value) {
                this.diameter = value;
            }

            /**
             * Gets the value of the length property.
             * 
             * @return
             *     possible object is
             *     {@link BigDecimal }
             *     
             */
            public BigDecimal getLength() {
                return length;
            }

            /**
             * Sets the value of the length property.
             * 
             * @param value
             *     allowed object is
             *     {@link BigDecimal }
             *     
             */
            public void setLength(BigDecimal value) {
                this.length = value;
            }

            /**
             * Gets the value of the needReplaced property.
             * 
             * @return
             *     possible object is
             *     {@link BigDecimal }
             *     
             */
            public BigDecimal getNeedReplaced() {
                return needReplaced;
            }

            /**
             * Sets the value of the needReplaced property.
             * 
             * @param value
             *     allowed object is
             *     {@link BigDecimal }
             *     
             */
            public void setNeedReplaced(BigDecimal value) {
                this.needReplaced = value;
            }

            /**
             * Gets the value of the wearout property.
             * 
             * @return
             *     possible object is
             *     {@link BigDecimal }
             *     
             */
            public BigDecimal getWearout() {
                return wearout;
            }

            /**
             * Sets the value of the wearout property.
             * 
             * @param value
             *     allowed object is
             *     {@link BigDecimal }
             *     
             */
            public void setWearout(BigDecimal value) {
                this.wearout = value;
            }

            /**
             * Gets the value of the pressureType property.
             * 
             * @return
             *     possible object is
             *     {@link NsiRef }
             *     
             */
            public NsiRef getPressureType() {
                return pressureType;
            }

            /**
             * Sets the value of the pressureType property.
             * 
             * @param value
             *     allowed object is
             *     {@link NsiRef }
             *     
             */
            public void setPressureType(NsiRef value) {
                this.pressureType = value;
            }

            /**
             * Gets the value of the voltageType property.
             * 
             * @return
             *     possible object is
             *     {@link NsiRef }
             *     
             */
            public NsiRef getVoltageType() {
                return voltageType;
            }

            /**
             * Sets the value of the voltageType property.
             * 
             * @param value
             *     allowed object is
             *     {@link NsiRef }
             *     
             */
            public void setVoltageType(NsiRef value) {
                this.voltageType = value;
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
         *         &lt;element name="SourceOKI" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType" maxOccurs="unbounded"/>
         *         &lt;element name="ReceiverOKI" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType" maxOccurs="unbounded" minOccurs="0"/>
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
            "sourceOKI",
            "receiverOKI"
        })
        public static class OKILinks {

            @XmlElement(name = "SourceOKI", required = true)
            protected List<String> sourceOKI;
            @XmlElement(name = "ReceiverOKI")
            protected List<String> receiverOKI;

            /**
             * Gets the value of the sourceOKI property.
             * 
             * <p>
             * This accessor method returns a reference to the live list,
             * not a snapshot. Therefore any modification you make to the
             * returned list will be present inside the JAXB object.
             * This is why there is not a <CODE>set</CODE> method for the sourceOKI property.
             * 
             * <p>
             * For example, to add a new item, do as follows:
             * <pre>
             *    getSourceOKI().add(newItem);
             * </pre>
             * 
             * 
             * <p>
             * Objects of the following type(s) are allowed in the list
             * {@link String }
             * 
             * 
             */
            public List<String> getSourceOKI() {
                if (sourceOKI == null) {
                    sourceOKI = new ArrayList<String>();
                }
                return this.sourceOKI;
            }

            /**
             * Gets the value of the receiverOKI property.
             * 
             * <p>
             * This accessor method returns a reference to the live list,
             * not a snapshot. Therefore any modification you make to the
             * returned list will be present inside the JAXB object.
             * This is why there is not a <CODE>set</CODE> method for the receiverOKI property.
             * 
             * <p>
             * For example, to add a new item, do as follows:
             * <pre>
             *    getReceiverOKI().add(newItem);
             * </pre>
             * 
             * 
             * <p>
             * Objects of the following type(s) are allowed in the list
             * {@link String }
             * 
             * 
             */
            public List<String> getReceiverOKI() {
                if (receiverOKI == null) {
                    receiverOKI = new ArrayList<String>();
                }
                return this.receiverOKI;
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
         *     &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/infrastructure/}ResourceType">
         *       &lt;sequence>
         *         &lt;element name="SetPower" type="{http://dom.gosuslugi.ru/schema/integration/infrastructure/}PowerType" minOccurs="0"/>
         *         &lt;element name="SitingPower" type="{http://dom.gosuslugi.ru/schema/integration/infrastructure/}PowerType" minOccurs="0"/>
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
            "setPower",
            "sitingPower"
        })
        public static class Resources
            extends ResourceType
        {

            @XmlElement(name = "SetPower")
            protected BigDecimal setPower;
            @XmlElement(name = "SitingPower")
            protected BigDecimal sitingPower;

            /**
             * Gets the value of the setPower property.
             * 
             * @return
             *     possible object is
             *     {@link BigDecimal }
             *     
             */
            public BigDecimal getSetPower() {
                return setPower;
            }

            /**
             * Sets the value of the setPower property.
             * 
             * @param value
             *     allowed object is
             *     {@link BigDecimal }
             *     
             */
            public void setSetPower(BigDecimal value) {
                this.setPower = value;
            }

            /**
             * Gets the value of the sitingPower property.
             * 
             * @return
             *     possible object is
             *     {@link BigDecimal }
             *     
             */
            public BigDecimal getSitingPower() {
                return sitingPower;
            }

            /**
             * Sets the value of the sitingPower property.
             * 
             * @param value
             *     allowed object is
             *     {@link BigDecimal }
             *     
             */
            public void setSitingPower(BigDecimal value) {
                this.sitingPower = value;
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
         *     &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/infrastructure/}ResourceType">
         *       &lt;sequence>
         *         &lt;element name="VolumeLosses">
         *           &lt;simpleType>
         *             &lt;restriction base="{http://dom.gosuslugi.ru/schema/integration/infrastructure/}PowerType">
         *               &lt;totalDigits value="8"/>
         *             &lt;/restriction>
         *           &lt;/simpleType>
         *         &lt;/element>
         *         &lt;element name="CoolantType" type="{http://dom.gosuslugi.ru/schema/integration/nsi-base/}nsiRef" minOccurs="0"/>
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
            "volumeLosses",
            "coolantType"
        })
        public static class TransportationResources
            extends ResourceType
        {

            @XmlElement(name = "VolumeLosses", required = true)
            protected BigDecimal volumeLosses;
            @XmlElement(name = "CoolantType")
            protected NsiRef coolantType;

            /**
             * Gets the value of the volumeLosses property.
             * 
             * @return
             *     possible object is
             *     {@link BigDecimal }
             *     
             */
            public BigDecimal getVolumeLosses() {
                return volumeLosses;
            }

            /**
             * Sets the value of the volumeLosses property.
             * 
             * @param value
             *     allowed object is
             *     {@link BigDecimal }
             *     
             */
            public void setVolumeLosses(BigDecimal value) {
                this.volumeLosses = value;
            }

            /**
             * Gets the value of the coolantType property.
             * 
             * @return
             *     possible object is
             *     {@link NsiRef }
             *     
             */
            public NsiRef getCoolantType() {
                return coolantType;
            }

            /**
             * Sets the value of the coolantType property.
             * 
             * @param value
             *     allowed object is
             *     {@link NsiRef }
             *     
             */
            public void setCoolantType(NsiRef value) {
                this.coolantType = value;
            }

        }

    }

}
