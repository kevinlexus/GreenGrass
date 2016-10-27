
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
 *         &lt;sequence>
 *           &lt;element name="ContractRootGUID" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType" maxOccurs="1000"/>
 *         &lt;/sequence>
 *         &lt;sequence>
 *           &lt;element name="ContractGUID" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType" maxOccurs="1000"/>
 *         &lt;/sequence>
 *         &lt;sequence>
 *           &lt;element name="ContractNumber" minOccurs="0">
 *             &lt;simpleType>
 *               &lt;restriction base="{http://dom.gosuslugi.ru/schema/integration/base/}LongTextType">
 *                 &lt;maxLength value="20"/>
 *                 &lt;minLength value="1"/>
 *               &lt;/restriction>
 *             &lt;/simpleType>
 *           &lt;/element>
 *           &lt;element name="SigningDateStart" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
 *           &lt;element name="SigningDateEnd" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
 *           &lt;element name="FIASHouseGuid" type="{http://dom.gosuslugi.ru/schema/integration/premises-base/}FIASHouseGUIDType" minOccurs="0"/>
 *           &lt;element name="ContractSubject" maxOccurs="100" minOccurs="0">
 *             &lt;complexType>
 *               &lt;complexContent>
 *                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                   &lt;sequence>
 *                     &lt;element name="ServiceType">
 *                       &lt;complexType>
 *                         &lt;complexContent>
 *                           &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/nsi-base/}nsiRef">
 *                           &lt;/extension>
 *                         &lt;/complexContent>
 *                       &lt;/complexType>
 *                     &lt;/element>
 *                     &lt;element name="MunicipalResource" type="{http://dom.gosuslugi.ru/schema/integration/nsi-base/}nsiRef"/>
 *                   &lt;/sequence>
 *                 &lt;/restriction>
 *               &lt;/complexContent>
 *             &lt;/complexType>
 *           &lt;/element>
 *         &lt;/sequence>
 *       &lt;/choice>
 *       &lt;attribute ref="{http://dom.gosuslugi.ru/schema/integration/base/}version use="required" fixed="10.0.1.1""/>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "contractRootGUID",
    "contractGUID",
    "contractNumber",
    "signingDateStart",
    "signingDateEnd",
    "fiasHouseGuid",
    "contractSubject"
})
@XmlRootElement(name = "exportSupplyResourceContractRequest")
public class ExportSupplyResourceContractRequest
    extends BaseType
{

    @XmlElement(name = "ContractRootGUID")
    protected List<String> contractRootGUID;
    @XmlElement(name = "ContractGUID")
    protected List<String> contractGUID;
    @XmlElement(name = "ContractNumber")
    protected String contractNumber;
    @XmlElement(name = "SigningDateStart")
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar signingDateStart;
    @XmlElement(name = "SigningDateEnd")
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar signingDateEnd;
    @XmlElement(name = "FIASHouseGuid")
    protected String fiasHouseGuid;
    @XmlElement(name = "ContractSubject")
    protected List<ExportSupplyResourceContractRequest.ContractSubject> contractSubject;
    @XmlAttribute(name = "version", namespace = "http://dom.gosuslugi.ru/schema/integration/base/", required = true)
    protected String version;

    /**
     * Gets the value of the contractRootGUID property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the contractRootGUID property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getContractRootGUID().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getContractRootGUID() {
        if (contractRootGUID == null) {
            contractRootGUID = new ArrayList<String>();
        }
        return this.contractRootGUID;
    }

    /**
     * Gets the value of the contractGUID property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the contractGUID property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getContractGUID().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getContractGUID() {
        if (contractGUID == null) {
            contractGUID = new ArrayList<String>();
        }
        return this.contractGUID;
    }

    /**
     * Gets the value of the contractNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getContractNumber() {
        return contractNumber;
    }

    /**
     * Sets the value of the contractNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setContractNumber(String value) {
        this.contractNumber = value;
    }

    /**
     * Gets the value of the signingDateStart property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getSigningDateStart() {
        return signingDateStart;
    }

    /**
     * Sets the value of the signingDateStart property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setSigningDateStart(XMLGregorianCalendar value) {
        this.signingDateStart = value;
    }

    /**
     * Gets the value of the signingDateEnd property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getSigningDateEnd() {
        return signingDateEnd;
    }

    /**
     * Sets the value of the signingDateEnd property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setSigningDateEnd(XMLGregorianCalendar value) {
        this.signingDateEnd = value;
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
     * Gets the value of the contractSubject property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the contractSubject property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getContractSubject().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ExportSupplyResourceContractRequest.ContractSubject }
     * 
     * 
     */
    public List<ExportSupplyResourceContractRequest.ContractSubject> getContractSubject() {
        if (contractSubject == null) {
            contractSubject = new ArrayList<ExportSupplyResourceContractRequest.ContractSubject>();
        }
        return this.contractSubject;
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
            return "10.0.1.1";
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
     *         &lt;element name="ServiceType">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/nsi-base/}nsiRef">
     *               &lt;/extension>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *         &lt;element name="MunicipalResource" type="{http://dom.gosuslugi.ru/schema/integration/nsi-base/}nsiRef"/>
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
        "serviceType",
        "municipalResource"
    })
    public static class ContractSubject {

        @XmlElement(name = "ServiceType", required = true)
        protected ExportSupplyResourceContractRequest.ContractSubject.ServiceType serviceType;
        @XmlElement(name = "MunicipalResource", required = true)
        protected NsiRef municipalResource;

        /**
         * Gets the value of the serviceType property.
         * 
         * @return
         *     possible object is
         *     {@link ExportSupplyResourceContractRequest.ContractSubject.ServiceType }
         *     
         */
        public ExportSupplyResourceContractRequest.ContractSubject.ServiceType getServiceType() {
            return serviceType;
        }

        /**
         * Sets the value of the serviceType property.
         * 
         * @param value
         *     allowed object is
         *     {@link ExportSupplyResourceContractRequest.ContractSubject.ServiceType }
         *     
         */
        public void setServiceType(ExportSupplyResourceContractRequest.ContractSubject.ServiceType value) {
            this.serviceType = value;
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
         * <p>Java class for anonymous complex type.
         * 
         * <p>The following schema fragment specifies the expected content contained within this class.
         * 
         * <pre>
         * &lt;complexType>
         *   &lt;complexContent>
         *     &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/nsi-base/}nsiRef">
         *     &lt;/extension>
         *   &lt;/complexContent>
         * &lt;/complexType>
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "")
        public static class ServiceType
            extends NsiRef
        {


        }

    }

}
