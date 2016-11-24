
package ru.gosuslugi.dom.schema.integration.nsi;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import ru.gosuslugi.dom.schema.integration.nsi_base.NsiRef;


/**
 * Элемент справочника работ и услуг организации.
 * 
 * <p>Java class for ImportOrganizationWorkType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ImportOrganizationWorkType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;sequence>
 *           &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/base/}TransportGUID"/>
 *           &lt;element name="ElementGuid" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType" minOccurs="0"/>
 *         &lt;/sequence>
 *         &lt;element name="WorkName" type="{http://dom.gosuslugi.ru/schema/integration/base/}String500Type"/>
 *         &lt;element name="ServiceTypeRef" type="{http://dom.gosuslugi.ru/schema/integration/nsi-base/}nsiRef"/>
 *         &lt;element name="RequiredServiceRef" type="{http://dom.gosuslugi.ru/schema/integration/nsi-base/}nsiRef" maxOccurs="unbounded"/>
 *         &lt;choice>
 *           &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/base/}OKEI"/>
 *           &lt;element name="StringDimensionUnit" type="{http://dom.gosuslugi.ru/schema/integration/base/}String100Type"/>
 *         &lt;/choice>
 *         &lt;element name="ImportOrganizationWork" type="{http://dom.gosuslugi.ru/schema/integration/nsi/}ImportOrganizationWorkType" maxOccurs="1000" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ImportOrganizationWorkType", propOrder = {
    "transportGUID",
    "elementGuid",
    "workName",
    "serviceTypeRef",
    "requiredServiceRef",
    "okei",
    "stringDimensionUnit",
    "importOrganizationWork"
})
public class ImportOrganizationWorkType {

    @XmlElement(name = "TransportGUID", namespace = "http://dom.gosuslugi.ru/schema/integration/base/", required = true)
    protected String transportGUID;
    @XmlElement(name = "ElementGuid")
    protected String elementGuid;
    @XmlElement(name = "WorkName", required = true)
    protected String workName;
    @XmlElement(name = "ServiceTypeRef", required = true)
    protected NsiRef serviceTypeRef;
    @XmlElement(name = "RequiredServiceRef", required = true)
    protected List<NsiRef> requiredServiceRef;
    @XmlElement(name = "OKEI", namespace = "http://dom.gosuslugi.ru/schema/integration/base/")
    protected String okei;
    @XmlElement(name = "StringDimensionUnit")
    protected String stringDimensionUnit;
    @XmlElement(name = "ImportOrganizationWork")
    protected List<ImportOrganizationWorkType> importOrganizationWork;

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
     * Gets the value of the elementGuid property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getElementGuid() {
        return elementGuid;
    }

    /**
     * Sets the value of the elementGuid property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setElementGuid(String value) {
        this.elementGuid = value;
    }

    /**
     * Gets the value of the workName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getWorkName() {
        return workName;
    }

    /**
     * Sets the value of the workName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setWorkName(String value) {
        this.workName = value;
    }

    /**
     * Gets the value of the serviceTypeRef property.
     * 
     * @return
     *     possible object is
     *     {@link NsiRef }
     *     
     */
    public NsiRef getServiceTypeRef() {
        return serviceTypeRef;
    }

    /**
     * Sets the value of the serviceTypeRef property.
     * 
     * @param value
     *     allowed object is
     *     {@link NsiRef }
     *     
     */
    public void setServiceTypeRef(NsiRef value) {
        this.serviceTypeRef = value;
    }

    /**
     * Gets the value of the requiredServiceRef property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the requiredServiceRef property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getRequiredServiceRef().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link NsiRef }
     * 
     * 
     */
    public List<NsiRef> getRequiredServiceRef() {
        if (requiredServiceRef == null) {
            requiredServiceRef = new ArrayList<NsiRef>();
        }
        return this.requiredServiceRef;
    }

    /**
     * Единница измерения из справочника ОКЕИ.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOKEI() {
        return okei;
    }

    /**
     * Sets the value of the okei property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOKEI(String value) {
        this.okei = value;
    }

    /**
     * Gets the value of the stringDimensionUnit property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStringDimensionUnit() {
        return stringDimensionUnit;
    }

    /**
     * Sets the value of the stringDimensionUnit property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStringDimensionUnit(String value) {
        this.stringDimensionUnit = value;
    }

    /**
     * Gets the value of the importOrganizationWork property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the importOrganizationWork property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getImportOrganizationWork().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ImportOrganizationWorkType }
     * 
     * 
     */
    public List<ImportOrganizationWorkType> getImportOrganizationWork() {
        if (importOrganizationWork == null) {
            importOrganizationWork = new ArrayList<ImportOrganizationWorkType>();
        }
        return this.importOrganizationWork;
    }

}
