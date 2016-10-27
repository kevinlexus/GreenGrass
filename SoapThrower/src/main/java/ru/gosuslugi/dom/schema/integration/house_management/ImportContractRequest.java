
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
import ru.gosuslugi.dom.schema.integration.base.AttachmentType;
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
 *       &lt;sequence>
 *         &lt;element name="Contract" maxOccurs="100">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;sequence>
 *                     &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/base/}TransportGUID"/>
 *                   &lt;/sequence>
 *                   &lt;choice>
 *                     &lt;element name="PlacingContract">
 *                       &lt;complexType>
 *                         &lt;complexContent>
 *                           &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/house-management/}ContractType">
 *                             &lt;sequence>
 *                               &lt;element name="LicenseRequest" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *                               &lt;element name="ContractObject" maxOccurs="unbounded">
 *                                 &lt;complexType>
 *                                   &lt;complexContent>
 *                                     &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/house-management/}ManageObjectType">
 *                                       &lt;sequence>
 *                                         &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/base/}TransportGUID"/>
 *                                         &lt;element name="BaseMService" type="{http://dom.gosuslugi.ru/schema/integration/house-management/}BaseServiceType"/>
 *                                         &lt;element name="HouseService" maxOccurs="unbounded" minOccurs="0">
 *                                           &lt;complexType>
 *                                             &lt;complexContent>
 *                                               &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/house-management/}ContractServiceType">
 *                                                 &lt;sequence>
 *                                                   &lt;element name="BaseService" type="{http://dom.gosuslugi.ru/schema/integration/house-management/}BaseServiceType"/>
 *                                                 &lt;/sequence>
 *                                               &lt;/extension>
 *                                             &lt;/complexContent>
 *                                           &lt;/complexType>
 *                                         &lt;/element>
 *                                         &lt;element name="AddService" maxOccurs="unbounded" minOccurs="0">
 *                                           &lt;complexType>
 *                                             &lt;complexContent>
 *                                               &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/house-management/}ContractServiceType">
 *                                                 &lt;sequence>
 *                                                   &lt;element name="BaseService" type="{http://dom.gosuslugi.ru/schema/integration/house-management/}BaseServiceType"/>
 *                                                 &lt;/sequence>
 *                                               &lt;/extension>
 *                                             &lt;/complexContent>
 *                                           &lt;/complexType>
 *                                         &lt;/element>
 *                                       &lt;/sequence>
 *                                     &lt;/extension>
 *                                   &lt;/complexContent>
 *                                 &lt;/complexType>
 *                               &lt;/element>
 *                             &lt;/sequence>
 *                           &lt;/extension>
 *                         &lt;/complexContent>
 *                       &lt;/complexType>
 *                     &lt;/element>
 *                     &lt;element name="EditContract">
 *                       &lt;complexType>
 *                         &lt;complexContent>
 *                           &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/house-management/}ContractType">
 *                             &lt;sequence>
 *                               &lt;element name="LicenseRequest" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *                               &lt;element name="ContractObject" maxOccurs="unbounded" minOccurs="0">
 *                                 &lt;complexType>
 *                                   &lt;complexContent>
 *                                     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                       &lt;sequence>
 *                                         &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/base/}TransportGUID"/>
 *                                         &lt;choice>
 *                                           &lt;element name="Add">
 *                                             &lt;complexType>
 *                                               &lt;complexContent>
 *                                                 &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/house-management/}ManageObjectType">
 *                                                   &lt;sequence>
 *                                                     &lt;element name="BaseMService" type="{http://dom.gosuslugi.ru/schema/integration/house-management/}BaseServiceType"/>
 *                                                     &lt;element name="HouseService" maxOccurs="unbounded" minOccurs="0">
 *                                                       &lt;complexType>
 *                                                         &lt;complexContent>
 *                                                           &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/house-management/}ContractServiceType">
 *                                                             &lt;sequence>
 *                                                               &lt;element name="BaseService" type="{http://dom.gosuslugi.ru/schema/integration/house-management/}BaseServiceType"/>
 *                                                             &lt;/sequence>
 *                                                           &lt;/extension>
 *                                                         &lt;/complexContent>
 *                                                       &lt;/complexType>
 *                                                     &lt;/element>
 *                                                     &lt;element name="AddService" maxOccurs="unbounded" minOccurs="0">
 *                                                       &lt;complexType>
 *                                                         &lt;complexContent>
 *                                                           &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/house-management/}ContractServiceType">
 *                                                             &lt;sequence>
 *                                                               &lt;element name="BaseService" type="{http://dom.gosuslugi.ru/schema/integration/house-management/}BaseServiceType"/>
 *                                                             &lt;/sequence>
 *                                                           &lt;/extension>
 *                                                         &lt;/complexContent>
 *                                                       &lt;/complexType>
 *                                                     &lt;/element>
 *                                                   &lt;/sequence>
 *                                                 &lt;/extension>
 *                                               &lt;/complexContent>
 *                                             &lt;/complexType>
 *                                           &lt;/element>
 *                                           &lt;element name="Edit">
 *                                             &lt;complexType>
 *                                               &lt;complexContent>
 *                                                 &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/house-management/}ManageObjectType">
 *                                                   &lt;sequence>
 *                                                     &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/house-management/}ContractObjectVersionGUID"/>
 *                                                     &lt;element name="BaseMService" type="{http://dom.gosuslugi.ru/schema/integration/house-management/}BaseServiceType" minOccurs="0"/>
 *                                                     &lt;element name="HouseService" maxOccurs="unbounded" minOccurs="0">
 *                                                       &lt;complexType>
 *                                                         &lt;complexContent>
 *                                                           &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/house-management/}ContractServiceType">
 *                                                             &lt;sequence>
 *                                                               &lt;element name="BaseService" type="{http://dom.gosuslugi.ru/schema/integration/house-management/}BaseServiceType"/>
 *                                                             &lt;/sequence>
 *                                                           &lt;/extension>
 *                                                         &lt;/complexContent>
 *                                                       &lt;/complexType>
 *                                                     &lt;/element>
 *                                                     &lt;element name="AddService" maxOccurs="unbounded" minOccurs="0">
 *                                                       &lt;complexType>
 *                                                         &lt;complexContent>
 *                                                           &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/house-management/}ContractServiceType">
 *                                                             &lt;sequence>
 *                                                               &lt;element name="BaseService" type="{http://dom.gosuslugi.ru/schema/integration/house-management/}BaseServiceType"/>
 *                                                             &lt;/sequence>
 *                                                           &lt;/extension>
 *                                                         &lt;/complexContent>
 *                                                       &lt;/complexType>
 *                                                     &lt;/element>
 *                                                   &lt;/sequence>
 *                                                 &lt;/extension>
 *                                               &lt;/complexContent>
 *                                             &lt;/complexType>
 *                                           &lt;/element>
 *                                           &lt;element name="Exclusion">
 *                                             &lt;complexType>
 *                                               &lt;complexContent>
 *                                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                                   &lt;sequence>
 *                                                     &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/house-management/}ContractObjectVersionGUID"/>
 *                                                     &lt;element name="BaseExclusion" type="{http://dom.gosuslugi.ru/schema/integration/house-management/}BaseServiceType"/>
 *                                                     &lt;element name="DateExclusion" type="{http://www.w3.org/2001/XMLSchema}date"/>
 *                                                   &lt;/sequence>
 *                                                 &lt;/restriction>
 *                                               &lt;/complexContent>
 *                                             &lt;/complexType>
 *                                           &lt;/element>
 *                                           &lt;element name="Annulment">
 *                                             &lt;complexType>
 *                                               &lt;complexContent>
 *                                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                                   &lt;sequence>
 *                                                     &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/house-management/}ContractObjectVersionGUID"/>
 *                                                   &lt;/sequence>
 *                                                 &lt;/restriction>
 *                                               &lt;/complexContent>
 *                                             &lt;/complexType>
 *                                           &lt;/element>
 *                                         &lt;/choice>
 *                                       &lt;/sequence>
 *                                     &lt;/restriction>
 *                                   &lt;/complexContent>
 *                                 &lt;/complexType>
 *                               &lt;/element>
 *                               &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/house-management/}ContractVersionGUID"/>
 *                             &lt;/sequence>
 *                           &lt;/extension>
 *                         &lt;/complexContent>
 *                       &lt;/complexType>
 *                     &lt;/element>
 *                     &lt;element name="ApprovalContract">
 *                       &lt;complexType>
 *                         &lt;complexContent>
 *                           &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/house-management/}ApprovalType">
 *                             &lt;sequence>
 *                               &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/house-management/}ContractVersionGUID"/>
 *                             &lt;/sequence>
 *                           &lt;/extension>
 *                         &lt;/complexContent>
 *                       &lt;/complexType>
 *                     &lt;/element>
 *                     &lt;element name="RollOverContract">
 *                       &lt;complexType>
 *                         &lt;complexContent>
 *                           &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/house-management/}RollOverType">
 *                             &lt;sequence>
 *                               &lt;element name="LicenseRequest" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *                               &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/house-management/}ContractVersionGUID"/>
 *                             &lt;/sequence>
 *                           &lt;/extension>
 *                         &lt;/complexContent>
 *                       &lt;/complexType>
 *                     &lt;/element>
 *                     &lt;element name="TerminateContract">
 *                       &lt;complexType>
 *                         &lt;complexContent>
 *                           &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/house-management/}TerminateType">
 *                             &lt;sequence>
 *                               &lt;element name="ReasonRef" type="{http://dom.gosuslugi.ru/schema/integration/nsi-base/}nsiRef"/>
 *                               &lt;element name="TerminateAttachment" type="{http://dom.gosuslugi.ru/schema/integration/base/}AttachmentType" maxOccurs="unbounded"/>
 *                               &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/house-management/}ContractVersionGUID"/>
 *                             &lt;/sequence>
 *                           &lt;/extension>
 *                         &lt;/complexContent>
 *                       &lt;/complexType>
 *                     &lt;/element>
 *                     &lt;element name="AnnulmentContract">
 *                       &lt;complexType>
 *                         &lt;complexContent>
 *                           &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/house-management/}AnnulmentType">
 *                             &lt;sequence>
 *                               &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/house-management/}ContractVersionGUID"/>
 *                             &lt;/sequence>
 *                           &lt;/extension>
 *                         &lt;/complexContent>
 *                       &lt;/complexType>
 *                     &lt;/element>
 *                     &lt;element name="PlaceContractPaymentsInfo">
 *                       &lt;complexType>
 *                         &lt;complexContent>
 *                           &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/house-management/}ContractPaymentsInfoType">
 *                             &lt;sequence>
 *                               &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/house-management/}ContractVersionGUID"/>
 *                             &lt;/sequence>
 *                           &lt;/extension>
 *                         &lt;/complexContent>
 *                       &lt;/complexType>
 *                     &lt;/element>
 *                     &lt;element name="AnnulmentContractPaymentsInfo">
 *                       &lt;complexType>
 *                         &lt;complexContent>
 *                           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                             &lt;sequence>
 *                               &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/house-management/}ContractPaymentsInfoVersionGUID"/>
 *                               &lt;element name="Reason">
 *                                 &lt;simpleType>
 *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                                     &lt;minLength value="1"/>
 *                                     &lt;maxLength value="1024"/>
 *                                   &lt;/restriction>
 *                                 &lt;/simpleType>
 *                               &lt;/element>
 *                             &lt;/sequence>
 *                           &lt;/restriction>
 *                         &lt;/complexContent>
 *                       &lt;/complexType>
 *                     &lt;/element>
 *                   &lt;/choice>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *       &lt;/sequence>
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
    "contract"
})
@XmlRootElement(name = "importContractRequest")
public class ImportContractRequest
    extends BaseType
{

    @XmlElement(name = "Contract", required = true)
    protected List<ImportContractRequest.Contract> contract;
    @XmlAttribute(name = "version", namespace = "http://dom.gosuslugi.ru/schema/integration/base/", required = true)
    protected String version;

    /**
     * Gets the value of the contract property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the contract property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getContract().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ImportContractRequest.Contract }
     * 
     * 
     */
    public List<ImportContractRequest.Contract> getContract() {
        if (contract == null) {
            contract = new ArrayList<ImportContractRequest.Contract>();
        }
        return this.contract;
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
     *         &lt;sequence>
     *           &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/base/}TransportGUID"/>
     *         &lt;/sequence>
     *         &lt;choice>
     *           &lt;element name="PlacingContract">
     *             &lt;complexType>
     *               &lt;complexContent>
     *                 &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/house-management/}ContractType">
     *                   &lt;sequence>
     *                     &lt;element name="LicenseRequest" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
     *                     &lt;element name="ContractObject" maxOccurs="unbounded">
     *                       &lt;complexType>
     *                         &lt;complexContent>
     *                           &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/house-management/}ManageObjectType">
     *                             &lt;sequence>
     *                               &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/base/}TransportGUID"/>
     *                               &lt;element name="BaseMService" type="{http://dom.gosuslugi.ru/schema/integration/house-management/}BaseServiceType"/>
     *                               &lt;element name="HouseService" maxOccurs="unbounded" minOccurs="0">
     *                                 &lt;complexType>
     *                                   &lt;complexContent>
     *                                     &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/house-management/}ContractServiceType">
     *                                       &lt;sequence>
     *                                         &lt;element name="BaseService" type="{http://dom.gosuslugi.ru/schema/integration/house-management/}BaseServiceType"/>
     *                                       &lt;/sequence>
     *                                     &lt;/extension>
     *                                   &lt;/complexContent>
     *                                 &lt;/complexType>
     *                               &lt;/element>
     *                               &lt;element name="AddService" maxOccurs="unbounded" minOccurs="0">
     *                                 &lt;complexType>
     *                                   &lt;complexContent>
     *                                     &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/house-management/}ContractServiceType">
     *                                       &lt;sequence>
     *                                         &lt;element name="BaseService" type="{http://dom.gosuslugi.ru/schema/integration/house-management/}BaseServiceType"/>
     *                                       &lt;/sequence>
     *                                     &lt;/extension>
     *                                   &lt;/complexContent>
     *                                 &lt;/complexType>
     *                               &lt;/element>
     *                             &lt;/sequence>
     *                           &lt;/extension>
     *                         &lt;/complexContent>
     *                       &lt;/complexType>
     *                     &lt;/element>
     *                   &lt;/sequence>
     *                 &lt;/extension>
     *               &lt;/complexContent>
     *             &lt;/complexType>
     *           &lt;/element>
     *           &lt;element name="EditContract">
     *             &lt;complexType>
     *               &lt;complexContent>
     *                 &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/house-management/}ContractType">
     *                   &lt;sequence>
     *                     &lt;element name="LicenseRequest" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
     *                     &lt;element name="ContractObject" maxOccurs="unbounded" minOccurs="0">
     *                       &lt;complexType>
     *                         &lt;complexContent>
     *                           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                             &lt;sequence>
     *                               &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/base/}TransportGUID"/>
     *                               &lt;choice>
     *                                 &lt;element name="Add">
     *                                   &lt;complexType>
     *                                     &lt;complexContent>
     *                                       &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/house-management/}ManageObjectType">
     *                                         &lt;sequence>
     *                                           &lt;element name="BaseMService" type="{http://dom.gosuslugi.ru/schema/integration/house-management/}BaseServiceType"/>
     *                                           &lt;element name="HouseService" maxOccurs="unbounded" minOccurs="0">
     *                                             &lt;complexType>
     *                                               &lt;complexContent>
     *                                                 &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/house-management/}ContractServiceType">
     *                                                   &lt;sequence>
     *                                                     &lt;element name="BaseService" type="{http://dom.gosuslugi.ru/schema/integration/house-management/}BaseServiceType"/>
     *                                                   &lt;/sequence>
     *                                                 &lt;/extension>
     *                                               &lt;/complexContent>
     *                                             &lt;/complexType>
     *                                           &lt;/element>
     *                                           &lt;element name="AddService" maxOccurs="unbounded" minOccurs="0">
     *                                             &lt;complexType>
     *                                               &lt;complexContent>
     *                                                 &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/house-management/}ContractServiceType">
     *                                                   &lt;sequence>
     *                                                     &lt;element name="BaseService" type="{http://dom.gosuslugi.ru/schema/integration/house-management/}BaseServiceType"/>
     *                                                   &lt;/sequence>
     *                                                 &lt;/extension>
     *                                               &lt;/complexContent>
     *                                             &lt;/complexType>
     *                                           &lt;/element>
     *                                         &lt;/sequence>
     *                                       &lt;/extension>
     *                                     &lt;/complexContent>
     *                                   &lt;/complexType>
     *                                 &lt;/element>
     *                                 &lt;element name="Edit">
     *                                   &lt;complexType>
     *                                     &lt;complexContent>
     *                                       &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/house-management/}ManageObjectType">
     *                                         &lt;sequence>
     *                                           &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/house-management/}ContractObjectVersionGUID"/>
     *                                           &lt;element name="BaseMService" type="{http://dom.gosuslugi.ru/schema/integration/house-management/}BaseServiceType" minOccurs="0"/>
     *                                           &lt;element name="HouseService" maxOccurs="unbounded" minOccurs="0">
     *                                             &lt;complexType>
     *                                               &lt;complexContent>
     *                                                 &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/house-management/}ContractServiceType">
     *                                                   &lt;sequence>
     *                                                     &lt;element name="BaseService" type="{http://dom.gosuslugi.ru/schema/integration/house-management/}BaseServiceType"/>
     *                                                   &lt;/sequence>
     *                                                 &lt;/extension>
     *                                               &lt;/complexContent>
     *                                             &lt;/complexType>
     *                                           &lt;/element>
     *                                           &lt;element name="AddService" maxOccurs="unbounded" minOccurs="0">
     *                                             &lt;complexType>
     *                                               &lt;complexContent>
     *                                                 &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/house-management/}ContractServiceType">
     *                                                   &lt;sequence>
     *                                                     &lt;element name="BaseService" type="{http://dom.gosuslugi.ru/schema/integration/house-management/}BaseServiceType"/>
     *                                                   &lt;/sequence>
     *                                                 &lt;/extension>
     *                                               &lt;/complexContent>
     *                                             &lt;/complexType>
     *                                           &lt;/element>
     *                                         &lt;/sequence>
     *                                       &lt;/extension>
     *                                     &lt;/complexContent>
     *                                   &lt;/complexType>
     *                                 &lt;/element>
     *                                 &lt;element name="Exclusion">
     *                                   &lt;complexType>
     *                                     &lt;complexContent>
     *                                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                                         &lt;sequence>
     *                                           &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/house-management/}ContractObjectVersionGUID"/>
     *                                           &lt;element name="BaseExclusion" type="{http://dom.gosuslugi.ru/schema/integration/house-management/}BaseServiceType"/>
     *                                           &lt;element name="DateExclusion" type="{http://www.w3.org/2001/XMLSchema}date"/>
     *                                         &lt;/sequence>
     *                                       &lt;/restriction>
     *                                     &lt;/complexContent>
     *                                   &lt;/complexType>
     *                                 &lt;/element>
     *                                 &lt;element name="Annulment">
     *                                   &lt;complexType>
     *                                     &lt;complexContent>
     *                                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                                         &lt;sequence>
     *                                           &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/house-management/}ContractObjectVersionGUID"/>
     *                                         &lt;/sequence>
     *                                       &lt;/restriction>
     *                                     &lt;/complexContent>
     *                                   &lt;/complexType>
     *                                 &lt;/element>
     *                               &lt;/choice>
     *                             &lt;/sequence>
     *                           &lt;/restriction>
     *                         &lt;/complexContent>
     *                       &lt;/complexType>
     *                     &lt;/element>
     *                     &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/house-management/}ContractVersionGUID"/>
     *                   &lt;/sequence>
     *                 &lt;/extension>
     *               &lt;/complexContent>
     *             &lt;/complexType>
     *           &lt;/element>
     *           &lt;element name="ApprovalContract">
     *             &lt;complexType>
     *               &lt;complexContent>
     *                 &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/house-management/}ApprovalType">
     *                   &lt;sequence>
     *                     &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/house-management/}ContractVersionGUID"/>
     *                   &lt;/sequence>
     *                 &lt;/extension>
     *               &lt;/complexContent>
     *             &lt;/complexType>
     *           &lt;/element>
     *           &lt;element name="RollOverContract">
     *             &lt;complexType>
     *               &lt;complexContent>
     *                 &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/house-management/}RollOverType">
     *                   &lt;sequence>
     *                     &lt;element name="LicenseRequest" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
     *                     &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/house-management/}ContractVersionGUID"/>
     *                   &lt;/sequence>
     *                 &lt;/extension>
     *               &lt;/complexContent>
     *             &lt;/complexType>
     *           &lt;/element>
     *           &lt;element name="TerminateContract">
     *             &lt;complexType>
     *               &lt;complexContent>
     *                 &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/house-management/}TerminateType">
     *                   &lt;sequence>
     *                     &lt;element name="ReasonRef" type="{http://dom.gosuslugi.ru/schema/integration/nsi-base/}nsiRef"/>
     *                     &lt;element name="TerminateAttachment" type="{http://dom.gosuslugi.ru/schema/integration/base/}AttachmentType" maxOccurs="unbounded"/>
     *                     &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/house-management/}ContractVersionGUID"/>
     *                   &lt;/sequence>
     *                 &lt;/extension>
     *               &lt;/complexContent>
     *             &lt;/complexType>
     *           &lt;/element>
     *           &lt;element name="AnnulmentContract">
     *             &lt;complexType>
     *               &lt;complexContent>
     *                 &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/house-management/}AnnulmentType">
     *                   &lt;sequence>
     *                     &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/house-management/}ContractVersionGUID"/>
     *                   &lt;/sequence>
     *                 &lt;/extension>
     *               &lt;/complexContent>
     *             &lt;/complexType>
     *           &lt;/element>
     *           &lt;element name="PlaceContractPaymentsInfo">
     *             &lt;complexType>
     *               &lt;complexContent>
     *                 &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/house-management/}ContractPaymentsInfoType">
     *                   &lt;sequence>
     *                     &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/house-management/}ContractVersionGUID"/>
     *                   &lt;/sequence>
     *                 &lt;/extension>
     *               &lt;/complexContent>
     *             &lt;/complexType>
     *           &lt;/element>
     *           &lt;element name="AnnulmentContractPaymentsInfo">
     *             &lt;complexType>
     *               &lt;complexContent>
     *                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                   &lt;sequence>
     *                     &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/house-management/}ContractPaymentsInfoVersionGUID"/>
     *                     &lt;element name="Reason">
     *                       &lt;simpleType>
     *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *                           &lt;minLength value="1"/>
     *                           &lt;maxLength value="1024"/>
     *                         &lt;/restriction>
     *                       &lt;/simpleType>
     *                     &lt;/element>
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
    @XmlType(name = "", propOrder = {
        "transportGUID",
        "placingContract",
        "editContract",
        "approvalContract",
        "rollOverContract",
        "terminateContract",
        "annulmentContract",
        "placeContractPaymentsInfo",
        "annulmentContractPaymentsInfo"
    })
    public static class Contract {

        @XmlElement(name = "TransportGUID", namespace = "http://dom.gosuslugi.ru/schema/integration/base/", required = true)
        protected String transportGUID;
        @XmlElement(name = "PlacingContract")
        protected ImportContractRequest.Contract.PlacingContract placingContract;
        @XmlElement(name = "EditContract")
        protected ImportContractRequest.Contract.EditContract editContract;
        @XmlElement(name = "ApprovalContract")
        protected ImportContractRequest.Contract.ApprovalContract approvalContract;
        @XmlElement(name = "RollOverContract")
        protected ImportContractRequest.Contract.RollOverContract rollOverContract;
        @XmlElement(name = "TerminateContract")
        protected ImportContractRequest.Contract.TerminateContract terminateContract;
        @XmlElement(name = "AnnulmentContract")
        protected ImportContractRequest.Contract.AnnulmentContract annulmentContract;
        @XmlElement(name = "PlaceContractPaymentsInfo")
        protected ImportContractRequest.Contract.PlaceContractPaymentsInfo placeContractPaymentsInfo;
        @XmlElement(name = "AnnulmentContractPaymentsInfo")
        protected ImportContractRequest.Contract.AnnulmentContractPaymentsInfo annulmentContractPaymentsInfo;

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
         * Gets the value of the placingContract property.
         * 
         * @return
         *     possible object is
         *     {@link ImportContractRequest.Contract.PlacingContract }
         *     
         */
        public ImportContractRequest.Contract.PlacingContract getPlacingContract() {
            return placingContract;
        }

        /**
         * Sets the value of the placingContract property.
         * 
         * @param value
         *     allowed object is
         *     {@link ImportContractRequest.Contract.PlacingContract }
         *     
         */
        public void setPlacingContract(ImportContractRequest.Contract.PlacingContract value) {
            this.placingContract = value;
        }

        /**
         * Gets the value of the editContract property.
         * 
         * @return
         *     possible object is
         *     {@link ImportContractRequest.Contract.EditContract }
         *     
         */
        public ImportContractRequest.Contract.EditContract getEditContract() {
            return editContract;
        }

        /**
         * Sets the value of the editContract property.
         * 
         * @param value
         *     allowed object is
         *     {@link ImportContractRequest.Contract.EditContract }
         *     
         */
        public void setEditContract(ImportContractRequest.Contract.EditContract value) {
            this.editContract = value;
        }

        /**
         * Gets the value of the approvalContract property.
         * 
         * @return
         *     possible object is
         *     {@link ImportContractRequest.Contract.ApprovalContract }
         *     
         */
        public ImportContractRequest.Contract.ApprovalContract getApprovalContract() {
            return approvalContract;
        }

        /**
         * Sets the value of the approvalContract property.
         * 
         * @param value
         *     allowed object is
         *     {@link ImportContractRequest.Contract.ApprovalContract }
         *     
         */
        public void setApprovalContract(ImportContractRequest.Contract.ApprovalContract value) {
            this.approvalContract = value;
        }

        /**
         * Gets the value of the rollOverContract property.
         * 
         * @return
         *     possible object is
         *     {@link ImportContractRequest.Contract.RollOverContract }
         *     
         */
        public ImportContractRequest.Contract.RollOverContract getRollOverContract() {
            return rollOverContract;
        }

        /**
         * Sets the value of the rollOverContract property.
         * 
         * @param value
         *     allowed object is
         *     {@link ImportContractRequest.Contract.RollOverContract }
         *     
         */
        public void setRollOverContract(ImportContractRequest.Contract.RollOverContract value) {
            this.rollOverContract = value;
        }

        /**
         * Gets the value of the terminateContract property.
         * 
         * @return
         *     possible object is
         *     {@link ImportContractRequest.Contract.TerminateContract }
         *     
         */
        public ImportContractRequest.Contract.TerminateContract getTerminateContract() {
            return terminateContract;
        }

        /**
         * Sets the value of the terminateContract property.
         * 
         * @param value
         *     allowed object is
         *     {@link ImportContractRequest.Contract.TerminateContract }
         *     
         */
        public void setTerminateContract(ImportContractRequest.Contract.TerminateContract value) {
            this.terminateContract = value;
        }

        /**
         * Gets the value of the annulmentContract property.
         * 
         * @return
         *     possible object is
         *     {@link ImportContractRequest.Contract.AnnulmentContract }
         *     
         */
        public ImportContractRequest.Contract.AnnulmentContract getAnnulmentContract() {
            return annulmentContract;
        }

        /**
         * Sets the value of the annulmentContract property.
         * 
         * @param value
         *     allowed object is
         *     {@link ImportContractRequest.Contract.AnnulmentContract }
         *     
         */
        public void setAnnulmentContract(ImportContractRequest.Contract.AnnulmentContract value) {
            this.annulmentContract = value;
        }

        /**
         * Gets the value of the placeContractPaymentsInfo property.
         * 
         * @return
         *     possible object is
         *     {@link ImportContractRequest.Contract.PlaceContractPaymentsInfo }
         *     
         */
        public ImportContractRequest.Contract.PlaceContractPaymentsInfo getPlaceContractPaymentsInfo() {
            return placeContractPaymentsInfo;
        }

        /**
         * Sets the value of the placeContractPaymentsInfo property.
         * 
         * @param value
         *     allowed object is
         *     {@link ImportContractRequest.Contract.PlaceContractPaymentsInfo }
         *     
         */
        public void setPlaceContractPaymentsInfo(ImportContractRequest.Contract.PlaceContractPaymentsInfo value) {
            this.placeContractPaymentsInfo = value;
        }

        /**
         * Gets the value of the annulmentContractPaymentsInfo property.
         * 
         * @return
         *     possible object is
         *     {@link ImportContractRequest.Contract.AnnulmentContractPaymentsInfo }
         *     
         */
        public ImportContractRequest.Contract.AnnulmentContractPaymentsInfo getAnnulmentContractPaymentsInfo() {
            return annulmentContractPaymentsInfo;
        }

        /**
         * Sets the value of the annulmentContractPaymentsInfo property.
         * 
         * @param value
         *     allowed object is
         *     {@link ImportContractRequest.Contract.AnnulmentContractPaymentsInfo }
         *     
         */
        public void setAnnulmentContractPaymentsInfo(ImportContractRequest.Contract.AnnulmentContractPaymentsInfo value) {
            this.annulmentContractPaymentsInfo = value;
        }


        /**
         * <p>Java class for anonymous complex type.
         * 
         * <p>The following schema fragment specifies the expected content contained within this class.
         * 
         * <pre>
         * &lt;complexType>
         *   &lt;complexContent>
         *     &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/house-management/}AnnulmentType">
         *       &lt;sequence>
         *         &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/house-management/}ContractVersionGUID"/>
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
            "contractVersionGUID"
        })
        public static class AnnulmentContract
            extends AnnulmentType
        {

            @XmlElement(name = "ContractVersionGUID", required = true)
            protected String contractVersionGUID;

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
         *         &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/house-management/}ContractPaymentsInfoVersionGUID"/>
         *         &lt;element name="Reason">
         *           &lt;simpleType>
         *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
         *               &lt;minLength value="1"/>
         *               &lt;maxLength value="1024"/>
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
            "contractPaymentsInfoVersionGUID",
            "reason"
        })
        public static class AnnulmentContractPaymentsInfo {

            @XmlElement(name = "ContractPaymentsInfoVersionGUID", required = true)
            protected String contractPaymentsInfoVersionGUID;
            @XmlElement(name = "Reason", required = true)
            protected String reason;

            /**
             * Gets the value of the contractPaymentsInfoVersionGUID property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getContractPaymentsInfoVersionGUID() {
                return contractPaymentsInfoVersionGUID;
            }

            /**
             * Sets the value of the contractPaymentsInfoVersionGUID property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setContractPaymentsInfoVersionGUID(String value) {
                this.contractPaymentsInfoVersionGUID = value;
            }

            /**
             * Gets the value of the reason property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getReason() {
                return reason;
            }

            /**
             * Sets the value of the reason property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setReason(String value) {
                this.reason = value;
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
         *     &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/house-management/}ApprovalType">
         *       &lt;sequence>
         *         &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/house-management/}ContractVersionGUID"/>
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
            "contractVersionGUID"
        })
        public static class ApprovalContract
            extends ApprovalType
        {

            @XmlElement(name = "ContractVersionGUID", required = true)
            protected String contractVersionGUID;

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

        }


        /**
         * <p>Java class for anonymous complex type.
         * 
         * <p>The following schema fragment specifies the expected content contained within this class.
         * 
         * <pre>
         * &lt;complexType>
         *   &lt;complexContent>
         *     &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/house-management/}ContractType">
         *       &lt;sequence>
         *         &lt;element name="LicenseRequest" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
         *         &lt;element name="ContractObject" maxOccurs="unbounded" minOccurs="0">
         *           &lt;complexType>
         *             &lt;complexContent>
         *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *                 &lt;sequence>
         *                   &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/base/}TransportGUID"/>
         *                   &lt;choice>
         *                     &lt;element name="Add">
         *                       &lt;complexType>
         *                         &lt;complexContent>
         *                           &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/house-management/}ManageObjectType">
         *                             &lt;sequence>
         *                               &lt;element name="BaseMService" type="{http://dom.gosuslugi.ru/schema/integration/house-management/}BaseServiceType"/>
         *                               &lt;element name="HouseService" maxOccurs="unbounded" minOccurs="0">
         *                                 &lt;complexType>
         *                                   &lt;complexContent>
         *                                     &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/house-management/}ContractServiceType">
         *                                       &lt;sequence>
         *                                         &lt;element name="BaseService" type="{http://dom.gosuslugi.ru/schema/integration/house-management/}BaseServiceType"/>
         *                                       &lt;/sequence>
         *                                     &lt;/extension>
         *                                   &lt;/complexContent>
         *                                 &lt;/complexType>
         *                               &lt;/element>
         *                               &lt;element name="AddService" maxOccurs="unbounded" minOccurs="0">
         *                                 &lt;complexType>
         *                                   &lt;complexContent>
         *                                     &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/house-management/}ContractServiceType">
         *                                       &lt;sequence>
         *                                         &lt;element name="BaseService" type="{http://dom.gosuslugi.ru/schema/integration/house-management/}BaseServiceType"/>
         *                                       &lt;/sequence>
         *                                     &lt;/extension>
         *                                   &lt;/complexContent>
         *                                 &lt;/complexType>
         *                               &lt;/element>
         *                             &lt;/sequence>
         *                           &lt;/extension>
         *                         &lt;/complexContent>
         *                       &lt;/complexType>
         *                     &lt;/element>
         *                     &lt;element name="Edit">
         *                       &lt;complexType>
         *                         &lt;complexContent>
         *                           &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/house-management/}ManageObjectType">
         *                             &lt;sequence>
         *                               &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/house-management/}ContractObjectVersionGUID"/>
         *                               &lt;element name="BaseMService" type="{http://dom.gosuslugi.ru/schema/integration/house-management/}BaseServiceType" minOccurs="0"/>
         *                               &lt;element name="HouseService" maxOccurs="unbounded" minOccurs="0">
         *                                 &lt;complexType>
         *                                   &lt;complexContent>
         *                                     &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/house-management/}ContractServiceType">
         *                                       &lt;sequence>
         *                                         &lt;element name="BaseService" type="{http://dom.gosuslugi.ru/schema/integration/house-management/}BaseServiceType"/>
         *                                       &lt;/sequence>
         *                                     &lt;/extension>
         *                                   &lt;/complexContent>
         *                                 &lt;/complexType>
         *                               &lt;/element>
         *                               &lt;element name="AddService" maxOccurs="unbounded" minOccurs="0">
         *                                 &lt;complexType>
         *                                   &lt;complexContent>
         *                                     &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/house-management/}ContractServiceType">
         *                                       &lt;sequence>
         *                                         &lt;element name="BaseService" type="{http://dom.gosuslugi.ru/schema/integration/house-management/}BaseServiceType"/>
         *                                       &lt;/sequence>
         *                                     &lt;/extension>
         *                                   &lt;/complexContent>
         *                                 &lt;/complexType>
         *                               &lt;/element>
         *                             &lt;/sequence>
         *                           &lt;/extension>
         *                         &lt;/complexContent>
         *                       &lt;/complexType>
         *                     &lt;/element>
         *                     &lt;element name="Exclusion">
         *                       &lt;complexType>
         *                         &lt;complexContent>
         *                           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *                             &lt;sequence>
         *                               &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/house-management/}ContractObjectVersionGUID"/>
         *                               &lt;element name="BaseExclusion" type="{http://dom.gosuslugi.ru/schema/integration/house-management/}BaseServiceType"/>
         *                               &lt;element name="DateExclusion" type="{http://www.w3.org/2001/XMLSchema}date"/>
         *                             &lt;/sequence>
         *                           &lt;/restriction>
         *                         &lt;/complexContent>
         *                       &lt;/complexType>
         *                     &lt;/element>
         *                     &lt;element name="Annulment">
         *                       &lt;complexType>
         *                         &lt;complexContent>
         *                           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *                             &lt;sequence>
         *                               &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/house-management/}ContractObjectVersionGUID"/>
         *                             &lt;/sequence>
         *                           &lt;/restriction>
         *                         &lt;/complexContent>
         *                       &lt;/complexType>
         *                     &lt;/element>
         *                   &lt;/choice>
         *                 &lt;/sequence>
         *               &lt;/restriction>
         *             &lt;/complexContent>
         *           &lt;/complexType>
         *         &lt;/element>
         *         &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/house-management/}ContractVersionGUID"/>
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
            "licenseRequest",
            "contractObject",
            "contractVersionGUID"
        })
        public static class EditContract
            extends ContractType
        {

            @XmlElement(name = "LicenseRequest")
            protected Boolean licenseRequest;
            @XmlElement(name = "ContractObject")
            protected List<ImportContractRequest.Contract.EditContract.ContractObject> contractObject;
            @XmlElement(name = "ContractVersionGUID", required = true)
            protected String contractVersionGUID;

            /**
             * Gets the value of the licenseRequest property.
             * 
             * @return
             *     possible object is
             *     {@link Boolean }
             *     
             */
            public Boolean isLicenseRequest() {
                return licenseRequest;
            }

            /**
             * Sets the value of the licenseRequest property.
             * 
             * @param value
             *     allowed object is
             *     {@link Boolean }
             *     
             */
            public void setLicenseRequest(Boolean value) {
                this.licenseRequest = value;
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
             * {@link ImportContractRequest.Contract.EditContract.ContractObject }
             * 
             * 
             */
            public List<ImportContractRequest.Contract.EditContract.ContractObject> getContractObject() {
                if (contractObject == null) {
                    contractObject = new ArrayList<ImportContractRequest.Contract.EditContract.ContractObject>();
                }
                return this.contractObject;
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
             * <p>Java class for anonymous complex type.
             * 
             * <p>The following schema fragment specifies the expected content contained within this class.
             * 
             * <pre>
             * &lt;complexType>
             *   &lt;complexContent>
             *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
             *       &lt;sequence>
             *         &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/base/}TransportGUID"/>
             *         &lt;choice>
             *           &lt;element name="Add">
             *             &lt;complexType>
             *               &lt;complexContent>
             *                 &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/house-management/}ManageObjectType">
             *                   &lt;sequence>
             *                     &lt;element name="BaseMService" type="{http://dom.gosuslugi.ru/schema/integration/house-management/}BaseServiceType"/>
             *                     &lt;element name="HouseService" maxOccurs="unbounded" minOccurs="0">
             *                       &lt;complexType>
             *                         &lt;complexContent>
             *                           &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/house-management/}ContractServiceType">
             *                             &lt;sequence>
             *                               &lt;element name="BaseService" type="{http://dom.gosuslugi.ru/schema/integration/house-management/}BaseServiceType"/>
             *                             &lt;/sequence>
             *                           &lt;/extension>
             *                         &lt;/complexContent>
             *                       &lt;/complexType>
             *                     &lt;/element>
             *                     &lt;element name="AddService" maxOccurs="unbounded" minOccurs="0">
             *                       &lt;complexType>
             *                         &lt;complexContent>
             *                           &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/house-management/}ContractServiceType">
             *                             &lt;sequence>
             *                               &lt;element name="BaseService" type="{http://dom.gosuslugi.ru/schema/integration/house-management/}BaseServiceType"/>
             *                             &lt;/sequence>
             *                           &lt;/extension>
             *                         &lt;/complexContent>
             *                       &lt;/complexType>
             *                     &lt;/element>
             *                   &lt;/sequence>
             *                 &lt;/extension>
             *               &lt;/complexContent>
             *             &lt;/complexType>
             *           &lt;/element>
             *           &lt;element name="Edit">
             *             &lt;complexType>
             *               &lt;complexContent>
             *                 &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/house-management/}ManageObjectType">
             *                   &lt;sequence>
             *                     &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/house-management/}ContractObjectVersionGUID"/>
             *                     &lt;element name="BaseMService" type="{http://dom.gosuslugi.ru/schema/integration/house-management/}BaseServiceType" minOccurs="0"/>
             *                     &lt;element name="HouseService" maxOccurs="unbounded" minOccurs="0">
             *                       &lt;complexType>
             *                         &lt;complexContent>
             *                           &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/house-management/}ContractServiceType">
             *                             &lt;sequence>
             *                               &lt;element name="BaseService" type="{http://dom.gosuslugi.ru/schema/integration/house-management/}BaseServiceType"/>
             *                             &lt;/sequence>
             *                           &lt;/extension>
             *                         &lt;/complexContent>
             *                       &lt;/complexType>
             *                     &lt;/element>
             *                     &lt;element name="AddService" maxOccurs="unbounded" minOccurs="0">
             *                       &lt;complexType>
             *                         &lt;complexContent>
             *                           &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/house-management/}ContractServiceType">
             *                             &lt;sequence>
             *                               &lt;element name="BaseService" type="{http://dom.gosuslugi.ru/schema/integration/house-management/}BaseServiceType"/>
             *                             &lt;/sequence>
             *                           &lt;/extension>
             *                         &lt;/complexContent>
             *                       &lt;/complexType>
             *                     &lt;/element>
             *                   &lt;/sequence>
             *                 &lt;/extension>
             *               &lt;/complexContent>
             *             &lt;/complexType>
             *           &lt;/element>
             *           &lt;element name="Exclusion">
             *             &lt;complexType>
             *               &lt;complexContent>
             *                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
             *                   &lt;sequence>
             *                     &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/house-management/}ContractObjectVersionGUID"/>
             *                     &lt;element name="BaseExclusion" type="{http://dom.gosuslugi.ru/schema/integration/house-management/}BaseServiceType"/>
             *                     &lt;element name="DateExclusion" type="{http://www.w3.org/2001/XMLSchema}date"/>
             *                   &lt;/sequence>
             *                 &lt;/restriction>
             *               &lt;/complexContent>
             *             &lt;/complexType>
             *           &lt;/element>
             *           &lt;element name="Annulment">
             *             &lt;complexType>
             *               &lt;complexContent>
             *                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
             *                   &lt;sequence>
             *                     &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/house-management/}ContractObjectVersionGUID"/>
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
            @XmlType(name = "", propOrder = {
                "transportGUID",
                "add",
                "edit",
                "exclusion",
                "annulment"
            })
            public static class ContractObject {

                @XmlElement(name = "TransportGUID", namespace = "http://dom.gosuslugi.ru/schema/integration/base/", required = true)
                protected String transportGUID;
                @XmlElement(name = "Add")
                protected ImportContractRequest.Contract.EditContract.ContractObject.Add add;
                @XmlElement(name = "Edit")
                protected ImportContractRequest.Contract.EditContract.ContractObject.Edit edit;
                @XmlElement(name = "Exclusion")
                protected ImportContractRequest.Contract.EditContract.ContractObject.Exclusion exclusion;
                @XmlElement(name = "Annulment")
                protected ImportContractRequest.Contract.EditContract.ContractObject.Annulment annulment;

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
                 * Gets the value of the add property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link ImportContractRequest.Contract.EditContract.ContractObject.Add }
                 *     
                 */
                public ImportContractRequest.Contract.EditContract.ContractObject.Add getAdd() {
                    return add;
                }

                /**
                 * Sets the value of the add property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link ImportContractRequest.Contract.EditContract.ContractObject.Add }
                 *     
                 */
                public void setAdd(ImportContractRequest.Contract.EditContract.ContractObject.Add value) {
                    this.add = value;
                }

                /**
                 * Gets the value of the edit property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link ImportContractRequest.Contract.EditContract.ContractObject.Edit }
                 *     
                 */
                public ImportContractRequest.Contract.EditContract.ContractObject.Edit getEdit() {
                    return edit;
                }

                /**
                 * Sets the value of the edit property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link ImportContractRequest.Contract.EditContract.ContractObject.Edit }
                 *     
                 */
                public void setEdit(ImportContractRequest.Contract.EditContract.ContractObject.Edit value) {
                    this.edit = value;
                }

                /**
                 * Gets the value of the exclusion property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link ImportContractRequest.Contract.EditContract.ContractObject.Exclusion }
                 *     
                 */
                public ImportContractRequest.Contract.EditContract.ContractObject.Exclusion getExclusion() {
                    return exclusion;
                }

                /**
                 * Sets the value of the exclusion property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link ImportContractRequest.Contract.EditContract.ContractObject.Exclusion }
                 *     
                 */
                public void setExclusion(ImportContractRequest.Contract.EditContract.ContractObject.Exclusion value) {
                    this.exclusion = value;
                }

                /**
                 * Gets the value of the annulment property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link ImportContractRequest.Contract.EditContract.ContractObject.Annulment }
                 *     
                 */
                public ImportContractRequest.Contract.EditContract.ContractObject.Annulment getAnnulment() {
                    return annulment;
                }

                /**
                 * Sets the value of the annulment property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link ImportContractRequest.Contract.EditContract.ContractObject.Annulment }
                 *     
                 */
                public void setAnnulment(ImportContractRequest.Contract.EditContract.ContractObject.Annulment value) {
                    this.annulment = value;
                }


                /**
                 * <p>Java class for anonymous complex type.
                 * 
                 * <p>The following schema fragment specifies the expected content contained within this class.
                 * 
                 * <pre>
                 * &lt;complexType>
                 *   &lt;complexContent>
                 *     &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/house-management/}ManageObjectType">
                 *       &lt;sequence>
                 *         &lt;element name="BaseMService" type="{http://dom.gosuslugi.ru/schema/integration/house-management/}BaseServiceType"/>
                 *         &lt;element name="HouseService" maxOccurs="unbounded" minOccurs="0">
                 *           &lt;complexType>
                 *             &lt;complexContent>
                 *               &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/house-management/}ContractServiceType">
                 *                 &lt;sequence>
                 *                   &lt;element name="BaseService" type="{http://dom.gosuslugi.ru/schema/integration/house-management/}BaseServiceType"/>
                 *                 &lt;/sequence>
                 *               &lt;/extension>
                 *             &lt;/complexContent>
                 *           &lt;/complexType>
                 *         &lt;/element>
                 *         &lt;element name="AddService" maxOccurs="unbounded" minOccurs="0">
                 *           &lt;complexType>
                 *             &lt;complexContent>
                 *               &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/house-management/}ContractServiceType">
                 *                 &lt;sequence>
                 *                   &lt;element name="BaseService" type="{http://dom.gosuslugi.ru/schema/integration/house-management/}BaseServiceType"/>
                 *                 &lt;/sequence>
                 *               &lt;/extension>
                 *             &lt;/complexContent>
                 *           &lt;/complexType>
                 *         &lt;/element>
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
                    "baseMService",
                    "houseService",
                    "addService"
                })
                public static class Add
                    extends ManageObjectType
                {

                    @XmlElement(name = "BaseMService", required = true)
                    protected BaseServiceType baseMService;
                    @XmlElement(name = "HouseService")
                    protected List<ImportContractRequest.Contract.EditContract.ContractObject.Add.HouseService> houseService;
                    @XmlElement(name = "AddService")
                    protected List<ImportContractRequest.Contract.EditContract.ContractObject.Add.AddService> addService;

                    /**
                     * Gets the value of the baseMService property.
                     * 
                     * @return
                     *     possible object is
                     *     {@link BaseServiceType }
                     *     
                     */
                    public BaseServiceType getBaseMService() {
                        return baseMService;
                    }

                    /**
                     * Sets the value of the baseMService property.
                     * 
                     * @param value
                     *     allowed object is
                     *     {@link BaseServiceType }
                     *     
                     */
                    public void setBaseMService(BaseServiceType value) {
                        this.baseMService = value;
                    }

                    /**
                     * Gets the value of the houseService property.
                     * 
                     * <p>
                     * This accessor method returns a reference to the live list,
                     * not a snapshot. Therefore any modification you make to the
                     * returned list will be present inside the JAXB object.
                     * This is why there is not a <CODE>set</CODE> method for the houseService property.
                     * 
                     * <p>
                     * For example, to add a new item, do as follows:
                     * <pre>
                     *    getHouseService().add(newItem);
                     * </pre>
                     * 
                     * 
                     * <p>
                     * Objects of the following type(s) are allowed in the list
                     * {@link ImportContractRequest.Contract.EditContract.ContractObject.Add.HouseService }
                     * 
                     * 
                     */
                    public List<ImportContractRequest.Contract.EditContract.ContractObject.Add.HouseService> getHouseService() {
                        if (houseService == null) {
                            houseService = new ArrayList<ImportContractRequest.Contract.EditContract.ContractObject.Add.HouseService>();
                        }
                        return this.houseService;
                    }

                    /**
                     * Gets the value of the addService property.
                     * 
                     * <p>
                     * This accessor method returns a reference to the live list,
                     * not a snapshot. Therefore any modification you make to the
                     * returned list will be present inside the JAXB object.
                     * This is why there is not a <CODE>set</CODE> method for the addService property.
                     * 
                     * <p>
                     * For example, to add a new item, do as follows:
                     * <pre>
                     *    getAddService().add(newItem);
                     * </pre>
                     * 
                     * 
                     * <p>
                     * Objects of the following type(s) are allowed in the list
                     * {@link ImportContractRequest.Contract.EditContract.ContractObject.Add.AddService }
                     * 
                     * 
                     */
                    public List<ImportContractRequest.Contract.EditContract.ContractObject.Add.AddService> getAddService() {
                        if (addService == null) {
                            addService = new ArrayList<ImportContractRequest.Contract.EditContract.ContractObject.Add.AddService>();
                        }
                        return this.addService;
                    }


                    /**
                     * <p>Java class for anonymous complex type.
                     * 
                     * <p>The following schema fragment specifies the expected content contained within this class.
                     * 
                     * <pre>
                     * &lt;complexType>
                     *   &lt;complexContent>
                     *     &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/house-management/}ContractServiceType">
                     *       &lt;sequence>
                     *         &lt;element name="BaseService" type="{http://dom.gosuslugi.ru/schema/integration/house-management/}BaseServiceType"/>
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
                        "baseService"
                    })
                    public static class AddService
                        extends ContractServiceType
                    {

                        @XmlElement(name = "BaseService", required = true)
                        protected BaseServiceType baseService;

                        /**
                         * Gets the value of the baseService property.
                         * 
                         * @return
                         *     possible object is
                         *     {@link BaseServiceType }
                         *     
                         */
                        public BaseServiceType getBaseService() {
                            return baseService;
                        }

                        /**
                         * Sets the value of the baseService property.
                         * 
                         * @param value
                         *     allowed object is
                         *     {@link BaseServiceType }
                         *     
                         */
                        public void setBaseService(BaseServiceType value) {
                            this.baseService = value;
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
                     *     &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/house-management/}ContractServiceType">
                     *       &lt;sequence>
                     *         &lt;element name="BaseService" type="{http://dom.gosuslugi.ru/schema/integration/house-management/}BaseServiceType"/>
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
                        "baseService"
                    })
                    public static class HouseService
                        extends ContractServiceType
                    {

                        @XmlElement(name = "BaseService", required = true)
                        protected BaseServiceType baseService;

                        /**
                         * Gets the value of the baseService property.
                         * 
                         * @return
                         *     possible object is
                         *     {@link BaseServiceType }
                         *     
                         */
                        public BaseServiceType getBaseService() {
                            return baseService;
                        }

                        /**
                         * Sets the value of the baseService property.
                         * 
                         * @param value
                         *     allowed object is
                         *     {@link BaseServiceType }
                         *     
                         */
                        public void setBaseService(BaseServiceType value) {
                            this.baseService = value;
                        }

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
                 *         &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/house-management/}ContractObjectVersionGUID"/>
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
                    "contractObjectVersionGUID"
                })
                public static class Annulment {

                    @XmlElement(name = "ContractObjectVersionGUID", required = true)
                    protected String contractObjectVersionGUID;

                    /**
                     * Gets the value of the contractObjectVersionGUID property.
                     * 
                     * @return
                     *     possible object is
                     *     {@link String }
                     *     
                     */
                    public String getContractObjectVersionGUID() {
                        return contractObjectVersionGUID;
                    }

                    /**
                     * Sets the value of the contractObjectVersionGUID property.
                     * 
                     * @param value
                     *     allowed object is
                     *     {@link String }
                     *     
                     */
                    public void setContractObjectVersionGUID(String value) {
                        this.contractObjectVersionGUID = value;
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
                 *     &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/house-management/}ManageObjectType">
                 *       &lt;sequence>
                 *         &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/house-management/}ContractObjectVersionGUID"/>
                 *         &lt;element name="BaseMService" type="{http://dom.gosuslugi.ru/schema/integration/house-management/}BaseServiceType" minOccurs="0"/>
                 *         &lt;element name="HouseService" maxOccurs="unbounded" minOccurs="0">
                 *           &lt;complexType>
                 *             &lt;complexContent>
                 *               &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/house-management/}ContractServiceType">
                 *                 &lt;sequence>
                 *                   &lt;element name="BaseService" type="{http://dom.gosuslugi.ru/schema/integration/house-management/}BaseServiceType"/>
                 *                 &lt;/sequence>
                 *               &lt;/extension>
                 *             &lt;/complexContent>
                 *           &lt;/complexType>
                 *         &lt;/element>
                 *         &lt;element name="AddService" maxOccurs="unbounded" minOccurs="0">
                 *           &lt;complexType>
                 *             &lt;complexContent>
                 *               &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/house-management/}ContractServiceType">
                 *                 &lt;sequence>
                 *                   &lt;element name="BaseService" type="{http://dom.gosuslugi.ru/schema/integration/house-management/}BaseServiceType"/>
                 *                 &lt;/sequence>
                 *               &lt;/extension>
                 *             &lt;/complexContent>
                 *           &lt;/complexType>
                 *         &lt;/element>
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
                    "contractObjectVersionGUID",
                    "baseMService",
                    "houseService",
                    "addService"
                })
                public static class Edit
                    extends ManageObjectType
                {

                    @XmlElement(name = "ContractObjectVersionGUID", required = true)
                    protected String contractObjectVersionGUID;
                    @XmlElement(name = "BaseMService")
                    protected BaseServiceType baseMService;
                    @XmlElement(name = "HouseService")
                    protected List<ImportContractRequest.Contract.EditContract.ContractObject.Edit.HouseService> houseService;
                    @XmlElement(name = "AddService")
                    protected List<ImportContractRequest.Contract.EditContract.ContractObject.Edit.AddService> addService;

                    /**
                     * Gets the value of the contractObjectVersionGUID property.
                     * 
                     * @return
                     *     possible object is
                     *     {@link String }
                     *     
                     */
                    public String getContractObjectVersionGUID() {
                        return contractObjectVersionGUID;
                    }

                    /**
                     * Sets the value of the contractObjectVersionGUID property.
                     * 
                     * @param value
                     *     allowed object is
                     *     {@link String }
                     *     
                     */
                    public void setContractObjectVersionGUID(String value) {
                        this.contractObjectVersionGUID = value;
                    }

                    /**
                     * Gets the value of the baseMService property.
                     * 
                     * @return
                     *     possible object is
                     *     {@link BaseServiceType }
                     *     
                     */
                    public BaseServiceType getBaseMService() {
                        return baseMService;
                    }

                    /**
                     * Sets the value of the baseMService property.
                     * 
                     * @param value
                     *     allowed object is
                     *     {@link BaseServiceType }
                     *     
                     */
                    public void setBaseMService(BaseServiceType value) {
                        this.baseMService = value;
                    }

                    /**
                     * Gets the value of the houseService property.
                     * 
                     * <p>
                     * This accessor method returns a reference to the live list,
                     * not a snapshot. Therefore any modification you make to the
                     * returned list will be present inside the JAXB object.
                     * This is why there is not a <CODE>set</CODE> method for the houseService property.
                     * 
                     * <p>
                     * For example, to add a new item, do as follows:
                     * <pre>
                     *    getHouseService().add(newItem);
                     * </pre>
                     * 
                     * 
                     * <p>
                     * Objects of the following type(s) are allowed in the list
                     * {@link ImportContractRequest.Contract.EditContract.ContractObject.Edit.HouseService }
                     * 
                     * 
                     */
                    public List<ImportContractRequest.Contract.EditContract.ContractObject.Edit.HouseService> getHouseService() {
                        if (houseService == null) {
                            houseService = new ArrayList<ImportContractRequest.Contract.EditContract.ContractObject.Edit.HouseService>();
                        }
                        return this.houseService;
                    }

                    /**
                     * Gets the value of the addService property.
                     * 
                     * <p>
                     * This accessor method returns a reference to the live list,
                     * not a snapshot. Therefore any modification you make to the
                     * returned list will be present inside the JAXB object.
                     * This is why there is not a <CODE>set</CODE> method for the addService property.
                     * 
                     * <p>
                     * For example, to add a new item, do as follows:
                     * <pre>
                     *    getAddService().add(newItem);
                     * </pre>
                     * 
                     * 
                     * <p>
                     * Objects of the following type(s) are allowed in the list
                     * {@link ImportContractRequest.Contract.EditContract.ContractObject.Edit.AddService }
                     * 
                     * 
                     */
                    public List<ImportContractRequest.Contract.EditContract.ContractObject.Edit.AddService> getAddService() {
                        if (addService == null) {
                            addService = new ArrayList<ImportContractRequest.Contract.EditContract.ContractObject.Edit.AddService>();
                        }
                        return this.addService;
                    }


                    /**
                     * <p>Java class for anonymous complex type.
                     * 
                     * <p>The following schema fragment specifies the expected content contained within this class.
                     * 
                     * <pre>
                     * &lt;complexType>
                     *   &lt;complexContent>
                     *     &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/house-management/}ContractServiceType">
                     *       &lt;sequence>
                     *         &lt;element name="BaseService" type="{http://dom.gosuslugi.ru/schema/integration/house-management/}BaseServiceType"/>
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
                        "baseService"
                    })
                    public static class AddService
                        extends ContractServiceType
                    {

                        @XmlElement(name = "BaseService", required = true)
                        protected BaseServiceType baseService;

                        /**
                         * Gets the value of the baseService property.
                         * 
                         * @return
                         *     possible object is
                         *     {@link BaseServiceType }
                         *     
                         */
                        public BaseServiceType getBaseService() {
                            return baseService;
                        }

                        /**
                         * Sets the value of the baseService property.
                         * 
                         * @param value
                         *     allowed object is
                         *     {@link BaseServiceType }
                         *     
                         */
                        public void setBaseService(BaseServiceType value) {
                            this.baseService = value;
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
                     *     &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/house-management/}ContractServiceType">
                     *       &lt;sequence>
                     *         &lt;element name="BaseService" type="{http://dom.gosuslugi.ru/schema/integration/house-management/}BaseServiceType"/>
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
                        "baseService"
                    })
                    public static class HouseService
                        extends ContractServiceType
                    {

                        @XmlElement(name = "BaseService", required = true)
                        protected BaseServiceType baseService;

                        /**
                         * Gets the value of the baseService property.
                         * 
                         * @return
                         *     possible object is
                         *     {@link BaseServiceType }
                         *     
                         */
                        public BaseServiceType getBaseService() {
                            return baseService;
                        }

                        /**
                         * Sets the value of the baseService property.
                         * 
                         * @param value
                         *     allowed object is
                         *     {@link BaseServiceType }
                         *     
                         */
                        public void setBaseService(BaseServiceType value) {
                            this.baseService = value;
                        }

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
                 *         &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/house-management/}ContractObjectVersionGUID"/>
                 *         &lt;element name="BaseExclusion" type="{http://dom.gosuslugi.ru/schema/integration/house-management/}BaseServiceType"/>
                 *         &lt;element name="DateExclusion" type="{http://www.w3.org/2001/XMLSchema}date"/>
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
                    "contractObjectVersionGUID",
                    "baseExclusion",
                    "dateExclusion"
                })
                public static class Exclusion {

                    @XmlElement(name = "ContractObjectVersionGUID", required = true)
                    protected String contractObjectVersionGUID;
                    @XmlElement(name = "BaseExclusion", required = true)
                    protected BaseServiceType baseExclusion;
                    @XmlElement(name = "DateExclusion", required = true)
                    @XmlSchemaType(name = "date")
                    protected XMLGregorianCalendar dateExclusion;

                    /**
                     * Gets the value of the contractObjectVersionGUID property.
                     * 
                     * @return
                     *     possible object is
                     *     {@link String }
                     *     
                     */
                    public String getContractObjectVersionGUID() {
                        return contractObjectVersionGUID;
                    }

                    /**
                     * Sets the value of the contractObjectVersionGUID property.
                     * 
                     * @param value
                     *     allowed object is
                     *     {@link String }
                     *     
                     */
                    public void setContractObjectVersionGUID(String value) {
                        this.contractObjectVersionGUID = value;
                    }

                    /**
                     * Gets the value of the baseExclusion property.
                     * 
                     * @return
                     *     possible object is
                     *     {@link BaseServiceType }
                     *     
                     */
                    public BaseServiceType getBaseExclusion() {
                        return baseExclusion;
                    }

                    /**
                     * Sets the value of the baseExclusion property.
                     * 
                     * @param value
                     *     allowed object is
                     *     {@link BaseServiceType }
                     *     
                     */
                    public void setBaseExclusion(BaseServiceType value) {
                        this.baseExclusion = value;
                    }

                    /**
                     * Gets the value of the dateExclusion property.
                     * 
                     * @return
                     *     possible object is
                     *     {@link XMLGregorianCalendar }
                     *     
                     */
                    public XMLGregorianCalendar getDateExclusion() {
                        return dateExclusion;
                    }

                    /**
                     * Sets the value of the dateExclusion property.
                     * 
                     * @param value
                     *     allowed object is
                     *     {@link XMLGregorianCalendar }
                     *     
                     */
                    public void setDateExclusion(XMLGregorianCalendar value) {
                        this.dateExclusion = value;
                    }

                }

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
         *     &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/house-management/}ContractPaymentsInfoType">
         *       &lt;sequence>
         *         &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/house-management/}ContractVersionGUID"/>
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
            "contractVersionGUID"
        })
        public static class PlaceContractPaymentsInfo
            extends ContractPaymentsInfoType
        {

            @XmlElement(name = "ContractVersionGUID", required = true)
            protected String contractVersionGUID;

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

        }


        /**
         * <p>Java class for anonymous complex type.
         * 
         * <p>The following schema fragment specifies the expected content contained within this class.
         * 
         * <pre>
         * &lt;complexType>
         *   &lt;complexContent>
         *     &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/house-management/}ContractType">
         *       &lt;sequence>
         *         &lt;element name="LicenseRequest" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
         *         &lt;element name="ContractObject" maxOccurs="unbounded">
         *           &lt;complexType>
         *             &lt;complexContent>
         *               &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/house-management/}ManageObjectType">
         *                 &lt;sequence>
         *                   &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/base/}TransportGUID"/>
         *                   &lt;element name="BaseMService" type="{http://dom.gosuslugi.ru/schema/integration/house-management/}BaseServiceType"/>
         *                   &lt;element name="HouseService" maxOccurs="unbounded" minOccurs="0">
         *                     &lt;complexType>
         *                       &lt;complexContent>
         *                         &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/house-management/}ContractServiceType">
         *                           &lt;sequence>
         *                             &lt;element name="BaseService" type="{http://dom.gosuslugi.ru/schema/integration/house-management/}BaseServiceType"/>
         *                           &lt;/sequence>
         *                         &lt;/extension>
         *                       &lt;/complexContent>
         *                     &lt;/complexType>
         *                   &lt;/element>
         *                   &lt;element name="AddService" maxOccurs="unbounded" minOccurs="0">
         *                     &lt;complexType>
         *                       &lt;complexContent>
         *                         &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/house-management/}ContractServiceType">
         *                           &lt;sequence>
         *                             &lt;element name="BaseService" type="{http://dom.gosuslugi.ru/schema/integration/house-management/}BaseServiceType"/>
         *                           &lt;/sequence>
         *                         &lt;/extension>
         *                       &lt;/complexContent>
         *                     &lt;/complexType>
         *                   &lt;/element>
         *                 &lt;/sequence>
         *               &lt;/extension>
         *             &lt;/complexContent>
         *           &lt;/complexType>
         *         &lt;/element>
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
            "licenseRequest",
            "contractObject"
        })
        public static class PlacingContract
            extends ContractType
        {

            @XmlElement(name = "LicenseRequest")
            protected Boolean licenseRequest;
            @XmlElement(name = "ContractObject", required = true)
            protected List<ImportContractRequest.Contract.PlacingContract.ContractObject> contractObject;

            /**
             * Gets the value of the licenseRequest property.
             * 
             * @return
             *     possible object is
             *     {@link Boolean }
             *     
             */
            public Boolean isLicenseRequest() {
                return licenseRequest;
            }

            /**
             * Sets the value of the licenseRequest property.
             * 
             * @param value
             *     allowed object is
             *     {@link Boolean }
             *     
             */
            public void setLicenseRequest(Boolean value) {
                this.licenseRequest = value;
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
             * {@link ImportContractRequest.Contract.PlacingContract.ContractObject }
             * 
             * 
             */
            public List<ImportContractRequest.Contract.PlacingContract.ContractObject> getContractObject() {
                if (contractObject == null) {
                    contractObject = new ArrayList<ImportContractRequest.Contract.PlacingContract.ContractObject>();
                }
                return this.contractObject;
            }


            /**
             * <p>Java class for anonymous complex type.
             * 
             * <p>The following schema fragment specifies the expected content contained within this class.
             * 
             * <pre>
             * &lt;complexType>
             *   &lt;complexContent>
             *     &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/house-management/}ManageObjectType">
             *       &lt;sequence>
             *         &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/base/}TransportGUID"/>
             *         &lt;element name="BaseMService" type="{http://dom.gosuslugi.ru/schema/integration/house-management/}BaseServiceType"/>
             *         &lt;element name="HouseService" maxOccurs="unbounded" minOccurs="0">
             *           &lt;complexType>
             *             &lt;complexContent>
             *               &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/house-management/}ContractServiceType">
             *                 &lt;sequence>
             *                   &lt;element name="BaseService" type="{http://dom.gosuslugi.ru/schema/integration/house-management/}BaseServiceType"/>
             *                 &lt;/sequence>
             *               &lt;/extension>
             *             &lt;/complexContent>
             *           &lt;/complexType>
             *         &lt;/element>
             *         &lt;element name="AddService" maxOccurs="unbounded" minOccurs="0">
             *           &lt;complexType>
             *             &lt;complexContent>
             *               &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/house-management/}ContractServiceType">
             *                 &lt;sequence>
             *                   &lt;element name="BaseService" type="{http://dom.gosuslugi.ru/schema/integration/house-management/}BaseServiceType"/>
             *                 &lt;/sequence>
             *               &lt;/extension>
             *             &lt;/complexContent>
             *           &lt;/complexType>
             *         &lt;/element>
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
                "transportGUID",
                "baseMService",
                "houseService",
                "addService"
            })
            public static class ContractObject
                extends ManageObjectType
            {

                @XmlElement(name = "TransportGUID", namespace = "http://dom.gosuslugi.ru/schema/integration/base/", required = true)
                protected String transportGUID;
                @XmlElement(name = "BaseMService", required = true)
                protected BaseServiceType baseMService;
                @XmlElement(name = "HouseService")
                protected List<ImportContractRequest.Contract.PlacingContract.ContractObject.HouseService> houseService;
                @XmlElement(name = "AddService")
                protected List<ImportContractRequest.Contract.PlacingContract.ContractObject.AddService> addService;

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
                 * Gets the value of the baseMService property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link BaseServiceType }
                 *     
                 */
                public BaseServiceType getBaseMService() {
                    return baseMService;
                }

                /**
                 * Sets the value of the baseMService property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link BaseServiceType }
                 *     
                 */
                public void setBaseMService(BaseServiceType value) {
                    this.baseMService = value;
                }

                /**
                 * Gets the value of the houseService property.
                 * 
                 * <p>
                 * This accessor method returns a reference to the live list,
                 * not a snapshot. Therefore any modification you make to the
                 * returned list will be present inside the JAXB object.
                 * This is why there is not a <CODE>set</CODE> method for the houseService property.
                 * 
                 * <p>
                 * For example, to add a new item, do as follows:
                 * <pre>
                 *    getHouseService().add(newItem);
                 * </pre>
                 * 
                 * 
                 * <p>
                 * Objects of the following type(s) are allowed in the list
                 * {@link ImportContractRequest.Contract.PlacingContract.ContractObject.HouseService }
                 * 
                 * 
                 */
                public List<ImportContractRequest.Contract.PlacingContract.ContractObject.HouseService> getHouseService() {
                    if (houseService == null) {
                        houseService = new ArrayList<ImportContractRequest.Contract.PlacingContract.ContractObject.HouseService>();
                    }
                    return this.houseService;
                }

                /**
                 * Gets the value of the addService property.
                 * 
                 * <p>
                 * This accessor method returns a reference to the live list,
                 * not a snapshot. Therefore any modification you make to the
                 * returned list will be present inside the JAXB object.
                 * This is why there is not a <CODE>set</CODE> method for the addService property.
                 * 
                 * <p>
                 * For example, to add a new item, do as follows:
                 * <pre>
                 *    getAddService().add(newItem);
                 * </pre>
                 * 
                 * 
                 * <p>
                 * Objects of the following type(s) are allowed in the list
                 * {@link ImportContractRequest.Contract.PlacingContract.ContractObject.AddService }
                 * 
                 * 
                 */
                public List<ImportContractRequest.Contract.PlacingContract.ContractObject.AddService> getAddService() {
                    if (addService == null) {
                        addService = new ArrayList<ImportContractRequest.Contract.PlacingContract.ContractObject.AddService>();
                    }
                    return this.addService;
                }


                /**
                 * <p>Java class for anonymous complex type.
                 * 
                 * <p>The following schema fragment specifies the expected content contained within this class.
                 * 
                 * <pre>
                 * &lt;complexType>
                 *   &lt;complexContent>
                 *     &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/house-management/}ContractServiceType">
                 *       &lt;sequence>
                 *         &lt;element name="BaseService" type="{http://dom.gosuslugi.ru/schema/integration/house-management/}BaseServiceType"/>
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
                    "baseService"
                })
                public static class AddService
                    extends ContractServiceType
                {

                    @XmlElement(name = "BaseService", required = true)
                    protected BaseServiceType baseService;

                    /**
                     * Gets the value of the baseService property.
                     * 
                     * @return
                     *     possible object is
                     *     {@link BaseServiceType }
                     *     
                     */
                    public BaseServiceType getBaseService() {
                        return baseService;
                    }

                    /**
                     * Sets the value of the baseService property.
                     * 
                     * @param value
                     *     allowed object is
                     *     {@link BaseServiceType }
                     *     
                     */
                    public void setBaseService(BaseServiceType value) {
                        this.baseService = value;
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
                 *     &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/house-management/}ContractServiceType">
                 *       &lt;sequence>
                 *         &lt;element name="BaseService" type="{http://dom.gosuslugi.ru/schema/integration/house-management/}BaseServiceType"/>
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
                    "baseService"
                })
                public static class HouseService
                    extends ContractServiceType
                {

                    @XmlElement(name = "BaseService", required = true)
                    protected BaseServiceType baseService;

                    /**
                     * Gets the value of the baseService property.
                     * 
                     * @return
                     *     possible object is
                     *     {@link BaseServiceType }
                     *     
                     */
                    public BaseServiceType getBaseService() {
                        return baseService;
                    }

                    /**
                     * Sets the value of the baseService property.
                     * 
                     * @param value
                     *     allowed object is
                     *     {@link BaseServiceType }
                     *     
                     */
                    public void setBaseService(BaseServiceType value) {
                        this.baseService = value;
                    }

                }

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
         *     &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/house-management/}RollOverType">
         *       &lt;sequence>
         *         &lt;element name="LicenseRequest" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
         *         &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/house-management/}ContractVersionGUID"/>
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
            "licenseRequest",
            "contractVersionGUID"
        })
        public static class RollOverContract
            extends RollOverType
        {

            @XmlElement(name = "LicenseRequest")
            protected Boolean licenseRequest;
            @XmlElement(name = "ContractVersionGUID", required = true)
            protected String contractVersionGUID;

            /**
             * Gets the value of the licenseRequest property.
             * 
             * @return
             *     possible object is
             *     {@link Boolean }
             *     
             */
            public Boolean isLicenseRequest() {
                return licenseRequest;
            }

            /**
             * Sets the value of the licenseRequest property.
             * 
             * @param value
             *     allowed object is
             *     {@link Boolean }
             *     
             */
            public void setLicenseRequest(Boolean value) {
                this.licenseRequest = value;
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

        }


        /**
         * <p>Java class for anonymous complex type.
         * 
         * <p>The following schema fragment specifies the expected content contained within this class.
         * 
         * <pre>
         * &lt;complexType>
         *   &lt;complexContent>
         *     &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/house-management/}TerminateType">
         *       &lt;sequence>
         *         &lt;element name="ReasonRef" type="{http://dom.gosuslugi.ru/schema/integration/nsi-base/}nsiRef"/>
         *         &lt;element name="TerminateAttachment" type="{http://dom.gosuslugi.ru/schema/integration/base/}AttachmentType" maxOccurs="unbounded"/>
         *         &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/house-management/}ContractVersionGUID"/>
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
            "reasonRef",
            "terminateAttachment",
            "contractVersionGUID"
        })
        public static class TerminateContract
            extends TerminateType
        {

            @XmlElement(name = "ReasonRef", required = true)
            protected NsiRef reasonRef;
            @XmlElement(name = "TerminateAttachment", required = true)
            protected List<AttachmentType> terminateAttachment;
            @XmlElement(name = "ContractVersionGUID", required = true)
            protected String contractVersionGUID;

            /**
             * Gets the value of the reasonRef property.
             * 
             * @return
             *     possible object is
             *     {@link NsiRef }
             *     
             */
            public NsiRef getReasonRef() {
                return reasonRef;
            }

            /**
             * Sets the value of the reasonRef property.
             * 
             * @param value
             *     allowed object is
             *     {@link NsiRef }
             *     
             */
            public void setReasonRef(NsiRef value) {
                this.reasonRef = value;
            }

            /**
             * Gets the value of the terminateAttachment property.
             * 
             * <p>
             * This accessor method returns a reference to the live list,
             * not a snapshot. Therefore any modification you make to the
             * returned list will be present inside the JAXB object.
             * This is why there is not a <CODE>set</CODE> method for the terminateAttachment property.
             * 
             * <p>
             * For example, to add a new item, do as follows:
             * <pre>
             *    getTerminateAttachment().add(newItem);
             * </pre>
             * 
             * 
             * <p>
             * Objects of the following type(s) are allowed in the list
             * {@link AttachmentType }
             * 
             * 
             */
            public List<AttachmentType> getTerminateAttachment() {
                if (terminateAttachment == null) {
                    terminateAttachment = new ArrayList<AttachmentType>();
                }
                return this.terminateAttachment;
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

        }

    }

}
