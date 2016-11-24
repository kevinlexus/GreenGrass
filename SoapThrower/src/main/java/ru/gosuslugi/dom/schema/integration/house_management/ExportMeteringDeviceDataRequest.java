
package ru.gosuslugi.dom.schema.integration.house_management;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;
import ru.gosuslugi.dom.schema.integration.base.BaseType;
import ru.gosuslugi.dom.schema.integration.nsi_base.NsiRef;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/base/}BaseType">
 *       &lt;choice>
 *         &lt;element name="MeteringDeviceRootGUID" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType"/>
 *         &lt;element name="MeteringDeviceVersionGUID" type="{http://dom.gosuslugi.ru/schema/integration/metering-device-base/}MeteringDeviceGUIDType"/>
 *         &lt;sequence>
 *           &lt;choice>
 *             &lt;element name="CurrentOrganization" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *             &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/organizations-registry-base/}orgRootEntityGUID" maxOccurs="100"/>
 *           &lt;/choice>
 *           &lt;element name="FIASHouseGuid" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType"/>
 *           &lt;element name="UpdateDateTime" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *           &lt;choice minOccurs="0">
 *             &lt;element name="MeteringDeviceType" type="{http://dom.gosuslugi.ru/schema/integration/nsi-base/}nsiRef"/>
 *             &lt;element name="MunicipalResource" type="{http://dom.gosuslugi.ru/schema/integration/nsi-base/}nsiRef"/>
 *           &lt;/choice>
 *           &lt;element name="ArchiveDateTo" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
 *           &lt;element name="ArchiveDateFrom" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
 *           &lt;element name="SearchArchived" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *           &lt;element name="CommissioningDateTo" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
 *           &lt;element name="CommissioningDateFrom" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
 *         &lt;/sequence>
 *       &lt;/choice>
 *       &lt;attribute ref="{http://dom.gosuslugi.ru/schema/integration/base/}version use="required" fixed="11.0.0.1""/>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "meteringDeviceRootGUID",
    "meteringDeviceVersionGUID",
    "currentOrganization",
    "orgRootEntityGUID",
    "fiasHouseGuid",
    "updateDateTime",
    "meteringDeviceType",
    "municipalResource",
    "archiveDateTo",
    "archiveDateFrom",
    "searchArchived",
    "commissioningDateTo",
    "commissioningDateFrom"
})
@XmlRootElement(name = "exportMeteringDeviceDataRequest")
public class ExportMeteringDeviceDataRequest
    extends BaseType
{

    @XmlElement(name = "MeteringDeviceRootGUID")
    protected String meteringDeviceRootGUID;
    @XmlElement(name = "MeteringDeviceVersionGUID")
    protected String meteringDeviceVersionGUID;
    @XmlElement(name = "CurrentOrganization")
    protected Boolean currentOrganization;
    @XmlElement(namespace = "http://dom.gosuslugi.ru/schema/integration/organizations-registry-base/")
    protected List<String> orgRootEntityGUID;
    @XmlElement(name = "FIASHouseGuid")
    protected String fiasHouseGuid;
    @XmlElement(name = "UpdateDateTime")
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar updateDateTime;
    @XmlElement(name = "MeteringDeviceType")
    protected NsiRef meteringDeviceType;
    @XmlElement(name = "MunicipalResource")
    protected NsiRef municipalResource;
    @XmlElement(name = "ArchiveDateTo")
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar archiveDateTo;
    @XmlElement(name = "ArchiveDateFrom")
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar archiveDateFrom;
    @XmlElement(name = "SearchArchived")
    protected Boolean searchArchived;
    @XmlElement(name = "CommissioningDateTo")
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar commissioningDateTo;
    @XmlElement(name = "CommissioningDateFrom")
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar commissioningDateFrom;
    @XmlAttribute(name = "version", namespace = "http://dom.gosuslugi.ru/schema/integration/base/", required = true)
    protected String version;

    /**
     * Gets the value of the meteringDeviceRootGUID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMeteringDeviceRootGUID() {
        return meteringDeviceRootGUID;
    }

    /**
     * Sets the value of the meteringDeviceRootGUID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMeteringDeviceRootGUID(String value) {
        this.meteringDeviceRootGUID = value;
    }

    /**
     * Gets the value of the meteringDeviceVersionGUID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMeteringDeviceVersionGUID() {
        return meteringDeviceVersionGUID;
    }

    /**
     * Sets the value of the meteringDeviceVersionGUID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMeteringDeviceVersionGUID(String value) {
        this.meteringDeviceVersionGUID = value;
    }

    /**
     * Gets the value of the currentOrganization property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isCurrentOrganization() {
        return currentOrganization;
    }

    /**
     * Sets the value of the currentOrganization property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setCurrentOrganization(Boolean value) {
        this.currentOrganization = value;
    }

    /**
     * Gets the value of the orgRootEntityGUID property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the orgRootEntityGUID property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getOrgRootEntityGUID().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getOrgRootEntityGUID() {
        if (orgRootEntityGUID == null) {
            orgRootEntityGUID = new ArrayList<String>();
        }
        return this.orgRootEntityGUID;
    }

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
     * Gets the value of the updateDateTime property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getUpdateDateTime() {
        return updateDateTime;
    }

    /**
     * Sets the value of the updateDateTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setUpdateDateTime(XMLGregorianCalendar value) {
        this.updateDateTime = value;
    }

    /**
     * Gets the value of the meteringDeviceType property.
     * 
     * @return
     *     possible object is
     *     {@link NsiRef }
     *     
     */
    public NsiRef getMeteringDeviceType() {
        return meteringDeviceType;
    }

    /**
     * Sets the value of the meteringDeviceType property.
     * 
     * @param value
     *     allowed object is
     *     {@link NsiRef }
     *     
     */
    public void setMeteringDeviceType(NsiRef value) {
        this.meteringDeviceType = value;
    }

    /**
     * Gets the value of the municipalResource property.
     * 
     * @return
     *     possible object is
     *     {@link NsiRef }
     *     
     */
    public NsiRef getMunicipalResource() {
        return municipalResource;
    }

    /**
     * Sets the value of the municipalResource property.
     * 
     * @param value
     *     allowed object is
     *     {@link NsiRef }
     *     
     */
    public void setMunicipalResource(NsiRef value) {
        this.municipalResource = value;
    }

    /**
     * Gets the value of the archiveDateTo property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getArchiveDateTo() {
        return archiveDateTo;
    }

    /**
     * Sets the value of the archiveDateTo property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setArchiveDateTo(XMLGregorianCalendar value) {
        this.archiveDateTo = value;
    }

    /**
     * Gets the value of the archiveDateFrom property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getArchiveDateFrom() {
        return archiveDateFrom;
    }

    /**
     * Sets the value of the archiveDateFrom property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setArchiveDateFrom(XMLGregorianCalendar value) {
        this.archiveDateFrom = value;
    }

    /**
     * Gets the value of the searchArchived property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isSearchArchived() {
        return searchArchived;
    }

    /**
     * Sets the value of the searchArchived property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setSearchArchived(Boolean value) {
        this.searchArchived = value;
    }

    /**
     * Gets the value of the commissioningDateTo property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getCommissioningDateTo() {
        return commissioningDateTo;
    }

    /**
     * Sets the value of the commissioningDateTo property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setCommissioningDateTo(XMLGregorianCalendar value) {
        this.commissioningDateTo = value;
    }

    /**
     * Gets the value of the commissioningDateFrom property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getCommissioningDateFrom() {
        return commissioningDateFrom;
    }

    /**
     * Sets the value of the commissioningDateFrom property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setCommissioningDateFrom(XMLGregorianCalendar value) {
        this.commissioningDateFrom = value;
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
            return "11.0.0.1";
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

}
