
package ru.gosuslugi.dom.schema.integration.house_management;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for exportCAChRequestCriteriaType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="exportCAChRequestCriteriaType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;choice>
 *         &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/house-management/}CharterGUID"/>
 *         &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/house-management/}ContractGUID"/>
 *         &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/house-management/}ContractVersionGUID"/>
 *         &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/house-management/}CharterVersionGUID"/>
 *         &lt;sequence>
 *           &lt;element name="UOGUID" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType"/>
 *           &lt;element name="FIASHouseGuid" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType"/>
 *           &lt;element name="SigningDate" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
 *           &lt;element name="LastVersionOnly" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
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
@XmlType(name = "exportCAChRequestCriteriaType", propOrder = {
    "charterGUID",
    "contractGUID",
    "contractVersionGUID",
    "charterVersionGUID",
    "uoguid",
    "fiasHouseGuid",
    "signingDate",
    "lastVersionOnly"
})
public class ExportCAChRequestCriteriaType {

    @XmlElement(name = "CharterGUID")
    protected String charterGUID;
    @XmlElement(name = "ContractGUID")
    protected String contractGUID;
    @XmlElement(name = "ContractVersionGUID")
    protected String contractVersionGUID;
    @XmlElement(name = "CharterVersionGUID")
    protected String charterVersionGUID;
    @XmlElement(name = "UOGUID")
    protected String uoguid;
    @XmlElement(name = "FIASHouseGuid")
    protected String fiasHouseGuid;
    @XmlElement(name = "SigningDate")
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar signingDate;
    @XmlElement(name = "LastVersionOnly")
    protected Boolean lastVersionOnly;

    /**
     * Gets the value of the charterGUID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCharterGUID() {
        return charterGUID;
    }

    /**
     * Sets the value of the charterGUID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCharterGUID(String value) {
        this.charterGUID = value;
    }

    /**
     * Gets the value of the contractGUID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getContractGUID() {
        return contractGUID;
    }

    /**
     * Sets the value of the contractGUID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setContractGUID(String value) {
        this.contractGUID = value;
    }

    /**
     * Gets the value of the contractVersionGUID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getContractVersionGUID() {
        return contractVersionGUID;
    }

    /**
     * Sets the value of the contractVersionGUID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setContractVersionGUID(String value) {
        this.contractVersionGUID = value;
    }

    /**
     * Gets the value of the charterVersionGUID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCharterVersionGUID() {
        return charterVersionGUID;
    }

    /**
     * Sets the value of the charterVersionGUID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCharterVersionGUID(String value) {
        this.charterVersionGUID = value;
    }

    /**
     * Gets the value of the uoguid property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUOGUID() {
        return uoguid;
    }

    /**
     * Sets the value of the uoguid property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUOGUID(String value) {
        this.uoguid = value;
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
     * Gets the value of the signingDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getSigningDate() {
        return signingDate;
    }

    /**
     * Sets the value of the signingDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setSigningDate(XMLGregorianCalendar value) {
        this.signingDate = value;
    }

    /**
     * Gets the value of the lastVersionOnly property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isLastVersionOnly() {
        return lastVersionOnly;
    }

    /**
     * Sets the value of the lastVersionOnly property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setLastVersionOnly(Boolean value) {
        this.lastVersionOnly = value;
    }

}
