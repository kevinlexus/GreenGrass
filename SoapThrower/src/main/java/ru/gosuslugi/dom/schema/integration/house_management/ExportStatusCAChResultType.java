
package ru.gosuslugi.dom.schema.integration.house_management;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for exportStatusCAChResultType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="exportStatusCAChResultType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;choice>
 *           &lt;sequence>
 *             &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/house-management/}ContractGUID"/>
 *             &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/house-management/}ContractVersionGUID"/>
 *             &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/house-management/}ContractStatus"/>
 *           &lt;/sequence>
 *           &lt;sequence>
 *             &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/house-management/}CharterGUID"/>
 *             &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/house-management/}CharterVersionGUID"/>
 *             &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/house-management/}CharterStatus"/>
 *           &lt;/sequence>
 *         &lt;/choice>
 *         &lt;element name="State" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;enumeration value="Running"/>
 *               &lt;enumeration value="NotRunning"/>
 *               &lt;enumeration value="Expired"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="ContractObject" maxOccurs="unbounded" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="FIASHouseGuid" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType"/>
 *                   &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/house-management/}ManagedObjectStatus"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="VersionNumber" type="{http://www.w3.org/2001/XMLSchema}integer"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "exportStatusCAChResultType", propOrder = {
    "contractGUID",
    "contractVersionGUID",
    "contractStatus",
    "charterGUID",
    "charterVersionGUID",
    "charterStatus",
    "state",
    "contractObject",
    "versionNumber"
})
@XmlSeeAlso({
    ImportCharterResultType.class,
    ImportContractResultType.class
})
public class ExportStatusCAChResultType {

    @XmlElement(name = "ContractGUID")
    protected String contractGUID;
    @XmlElement(name = "ContractVersionGUID")
    protected String contractVersionGUID;
    @XmlElement(name = "ContractStatus")
    protected String contractStatus;
    @XmlElement(name = "CharterGUID")
    protected String charterGUID;
    @XmlElement(name = "CharterVersionGUID")
    protected String charterVersionGUID;
    @XmlElement(name = "CharterStatus")
    protected String charterStatus;
    @XmlElement(name = "State")
    protected String state;
    @XmlElement(name = "ContractObject")
    protected List<ExportStatusCAChResultType.ContractObject> contractObject;
    @XmlElement(name = "VersionNumber", required = true)
    protected BigInteger versionNumber;

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
     * Статус ДУ:
     *  Project - проект
     *  ApprovalProcess - на утверждении
     *  Approved - утвержден
     *  Rejected- отклонен
     *  Terminated - расторгнут/закрыт
     *  Reviewed - рассмотрен
     *  Annul - сведения аннулированы
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getContractStatus() {
        return contractStatus;
    }

    /**
     * Sets the value of the contractStatus property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setContractStatus(String value) {
        this.contractStatus = value;
    }

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
     * Gets the value of the charterStatus property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCharterStatus() {
        return charterStatus;
    }

    /**
     * Sets the value of the charterStatus property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCharterStatus(String value) {
        this.charterStatus = value;
    }

    /**
     * Gets the value of the state property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getState() {
        return state;
    }

    /**
     * Sets the value of the state property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setState(String value) {
        this.state = value;
    }

    /**
     * Gets the value of the contractObject property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the contractObject property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getContractObject().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ExportStatusCAChResultType.ContractObject }
     * 
     * 
     */
    public List<ExportStatusCAChResultType.ContractObject> getContractObject() {
        if (contractObject == null) {
            contractObject = new ArrayList<ExportStatusCAChResultType.ContractObject>();
        }
        return this.contractObject;
    }

    /**
     * Gets the value of the versionNumber property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getVersionNumber() {
        return versionNumber;
    }

    /**
     * Sets the value of the versionNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setVersionNumber(BigInteger value) {
        this.versionNumber = value;
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
     *         &lt;element name="FIASHouseGuid" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType"/>
     *         &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/house-management/}ManagedObjectStatus"/>
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
        "fiasHouseGuid",
        "managedObjectStatus"
    })
    public static class ContractObject {

        @XmlElement(name = "FIASHouseGuid", required = true)
        protected String fiasHouseGuid;
        @XmlElement(name = "ManagedObjectStatus", required = true)
        @XmlSchemaType(name = "string")
        protected StatusMKDType managedObjectStatus;

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
         * Статус управляемого объекта:
         *  Project - проект
         *  ApprovalProcess - на утверждении
         *  Approved - утвержден
         *  Rejected- отклонен
         *  Terminated - расторгнут
         *  Reviewed - рассмотрен
         *  Locked - заблокирован
         * 
         * @return
         *     possible object is
         *     {@link StatusMKDType }
         *     
         */
        public StatusMKDType getManagedObjectStatus() {
            return managedObjectStatus;
        }

        /**
         * Sets the value of the managedObjectStatus property.
         * 
         * @param value
         *     allowed object is
         *     {@link StatusMKDType }
         *     
         */
        public void setManagedObjectStatus(StatusMKDType value) {
            this.managedObjectStatus = value;
        }

    }

}
