
package ru.gosuslugi.dom.schema.integration.house_management;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
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
 *         &lt;element name="ApartmentHouse">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;choice>
 *                     &lt;element name="ApartmentHouseToCreate">
 *                       &lt;complexType>
 *                         &lt;complexContent>
 *                           &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/house-management/}ApartmentHouseOMSType">
 *                             &lt;sequence>
 *                               &lt;element name="HouseManagementType" type="{http://dom.gosuslugi.ru/schema/integration/nsi-base/}nsiRef" minOccurs="0"/>
 *                               &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/base/}TransportGUID"/>
 *                             &lt;/sequence>
 *                           &lt;/extension>
 *                         &lt;/complexContent>
 *                       &lt;/complexType>
 *                     &lt;/element>
 *                     &lt;element name="ApartmentHouseToUpdate">
 *                       &lt;complexType>
 *                         &lt;complexContent>
 *                           &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/house-management/}ApartmentHouseUpdateOMSType">
 *                             &lt;sequence>
 *                               &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/base/}TransportGUID"/>
 *                               &lt;element name="HouseManagementType" type="{http://dom.gosuslugi.ru/schema/integration/nsi-base/}nsiRef" minOccurs="0"/>
 *                             &lt;/sequence>
 *                           &lt;/extension>
 *                         &lt;/complexContent>
 *                       &lt;/complexType>
 *                     &lt;/element>
 *                   &lt;/choice>
 *                   &lt;sequence>
 *                     &lt;element name="NonResidentialPremiseToCreate" maxOccurs="unbounded" minOccurs="0">
 *                       &lt;complexType>
 *                         &lt;complexContent>
 *                           &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/house-management/}NonResidentialPremisesOMSType">
 *                             &lt;sequence>
 *                               &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/base/}TransportGUID"/>
 *                             &lt;/sequence>
 *                           &lt;/extension>
 *                         &lt;/complexContent>
 *                       &lt;/complexType>
 *                     &lt;/element>
 *                     &lt;element name="NonResidentialPremiseToUpdate" maxOccurs="unbounded" minOccurs="0">
 *                       &lt;complexType>
 *                         &lt;complexContent>
 *                           &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/house-management/}NonResidentialPremisesUpdateOMSType">
 *                             &lt;sequence>
 *                               &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/base/}TransportGUID"/>
 *                               &lt;element name="PremisesGUID" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType"/>
 *                             &lt;/sequence>
 *                           &lt;/extension>
 *                         &lt;/complexContent>
 *                       &lt;/complexType>
 *                     &lt;/element>
 *                   &lt;/sequence>
 *                   &lt;sequence>
 *                     &lt;sequence>
 *                       &lt;element name="EntranceToCreate" maxOccurs="unbounded" minOccurs="0">
 *                         &lt;complexType>
 *                           &lt;complexContent>
 *                             &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/house-management/}EntranceOMSType">
 *                               &lt;sequence>
 *                                 &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/base/}TransportGUID"/>
 *                               &lt;/sequence>
 *                             &lt;/extension>
 *                           &lt;/complexContent>
 *                         &lt;/complexType>
 *                       &lt;/element>
 *                       &lt;element name="EntranceToUpdate" maxOccurs="unbounded" minOccurs="0">
 *                         &lt;complexType>
 *                           &lt;complexContent>
 *                             &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/house-management/}EntranceUpdateOMSType">
 *                               &lt;sequence>
 *                                 &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/base/}TransportGUID"/>
 *                                 &lt;element name="EntranceGUID" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType"/>
 *                               &lt;/sequence>
 *                             &lt;/extension>
 *                           &lt;/complexContent>
 *                         &lt;/complexType>
 *                       &lt;/element>
 *                     &lt;/sequence>
 *                     &lt;element name="ResidentialPremises" maxOccurs="unbounded" minOccurs="0">
 *                       &lt;complexType>
 *                         &lt;complexContent>
 *                           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                             &lt;sequence>
 *                               &lt;choice>
 *                                 &lt;element name="ResidentialPremisesToCreate">
 *                                   &lt;complexType>
 *                                     &lt;complexContent>
 *                                       &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/house-management/}ResidentialPremisesOMSType">
 *                                         &lt;sequence>
 *                                           &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/base/}TransportGUID"/>
 *                                         &lt;/sequence>
 *                                       &lt;/extension>
 *                                     &lt;/complexContent>
 *                                   &lt;/complexType>
 *                                 &lt;/element>
 *                                 &lt;element name="ResidentialPremisesToUpdate">
 *                                   &lt;complexType>
 *                                     &lt;complexContent>
 *                                       &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/house-management/}ResidentialPremisesUpdateOMSType">
 *                                         &lt;sequence>
 *                                           &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/base/}TransportGUID"/>
 *                                           &lt;element name="PremisesGUID" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType"/>
 *                                         &lt;/sequence>
 *                                       &lt;/extension>
 *                                     &lt;/complexContent>
 *                                   &lt;/complexType>
 *                                 &lt;/element>
 *                               &lt;/choice>
 *                               &lt;sequence>
 *                                 &lt;element name="LivingRoomToCreate" maxOccurs="unbounded" minOccurs="0">
 *                                   &lt;complexType>
 *                                     &lt;complexContent>
 *                                       &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/house-management/}RoomOMSType">
 *                                         &lt;sequence>
 *                                           &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/base/}TransportGUID"/>
 *                                         &lt;/sequence>
 *                                       &lt;/extension>
 *                                     &lt;/complexContent>
 *                                   &lt;/complexType>
 *                                 &lt;/element>
 *                                 &lt;element name="LivingRoomToUpdate" maxOccurs="unbounded" minOccurs="0">
 *                                   &lt;complexType>
 *                                     &lt;complexContent>
 *                                       &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/house-management/}RoomUpdateOMSType">
 *                                         &lt;sequence>
 *                                           &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/base/}TransportGUID"/>
 *                                           &lt;element name="LivingRoomGUID" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType"/>
 *                                         &lt;/sequence>
 *                                       &lt;/extension>
 *                                     &lt;/complexContent>
 *                                   &lt;/complexType>
 *                                 &lt;/element>
 *                               &lt;/sequence>
 *                             &lt;/sequence>
 *                           &lt;/restriction>
 *                         &lt;/complexContent>
 *                       &lt;/complexType>
 *                     &lt;/element>
 *                     &lt;sequence>
 *                       &lt;element name="LiftToCreate" maxOccurs="unbounded" minOccurs="0">
 *                         &lt;complexType>
 *                           &lt;complexContent>
 *                             &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/house-management/}LiftOMSType">
 *                               &lt;sequence>
 *                                 &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/base/}TransportGUID"/>
 *                               &lt;/sequence>
 *                             &lt;/extension>
 *                           &lt;/complexContent>
 *                         &lt;/complexType>
 *                       &lt;/element>
 *                       &lt;element name="LiftToUpdate" maxOccurs="unbounded" minOccurs="0">
 *                         &lt;complexType>
 *                           &lt;complexContent>
 *                             &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/house-management/}LiftUpdateOMSType">
 *                               &lt;sequence>
 *                                 &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/base/}TransportGUID"/>
 *                                 &lt;element name="LiftGUID" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType"/>
 *                               &lt;/sequence>
 *                             &lt;/extension>
 *                           &lt;/complexContent>
 *                         &lt;/complexType>
 *                       &lt;/element>
 *                     &lt;/sequence>
 *                   &lt;/sequence>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="LivingHouse">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;choice>
 *                     &lt;element name="LivingHouseToCreate">
 *                       &lt;complexType>
 *                         &lt;complexContent>
 *                           &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/house-management/}LivingHouseOMSType">
 *                             &lt;sequence>
 *                               &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/base/}TransportGUID"/>
 *                               &lt;element name="HouseManagementType" type="{http://dom.gosuslugi.ru/schema/integration/nsi-base/}nsiRef" minOccurs="0"/>
 *                             &lt;/sequence>
 *                           &lt;/extension>
 *                         &lt;/complexContent>
 *                       &lt;/complexType>
 *                     &lt;/element>
 *                     &lt;element name="LivingHouseToUpdate">
 *                       &lt;complexType>
 *                         &lt;complexContent>
 *                           &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/house-management/}LivingHouseUpdateOMSType">
 *                             &lt;sequence>
 *                               &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/base/}TransportGUID"/>
 *                               &lt;element name="HouseManagementType" type="{http://dom.gosuslugi.ru/schema/integration/nsi-base/}nsiRef" minOccurs="0"/>
 *                             &lt;/sequence>
 *                           &lt;/extension>
 *                         &lt;/complexContent>
 *                       &lt;/complexType>
 *                     &lt;/element>
 *                   &lt;/choice>
 *                   &lt;choice>
 *                     &lt;sequence>
 *                       &lt;element name="LivingRoomToCreate" maxOccurs="unbounded" minOccurs="0">
 *                         &lt;complexType>
 *                           &lt;complexContent>
 *                             &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/house-management/}RoomOMSType">
 *                               &lt;sequence>
 *                                 &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/base/}TransportGUID"/>
 *                               &lt;/sequence>
 *                             &lt;/extension>
 *                           &lt;/complexContent>
 *                         &lt;/complexType>
 *                       &lt;/element>
 *                       &lt;element name="LivingRoomToUpdate" maxOccurs="unbounded" minOccurs="0">
 *                         &lt;complexType>
 *                           &lt;complexContent>
 *                             &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/house-management/}RoomUpdateOMSType">
 *                               &lt;sequence>
 *                                 &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/base/}TransportGUID"/>
 *                                 &lt;element name="LivingRoomGUID" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType"/>
 *                               &lt;/sequence>
 *                             &lt;/extension>
 *                           &lt;/complexContent>
 *                         &lt;/complexType>
 *                       &lt;/element>
 *                     &lt;/sequence>
 *                     &lt;element name="Blocks" maxOccurs="unbounded" minOccurs="0">
 *                       &lt;complexType>
 *                         &lt;complexContent>
 *                           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                             &lt;sequence>
 *                               &lt;choice>
 *                                 &lt;element name="BlockToCreate">
 *                                   &lt;complexType>
 *                                     &lt;complexContent>
 *                                       &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/house-management/}BlockOMSType">
 *                                         &lt;sequence>
 *                                           &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/base/}TransportGUID"/>
 *                                         &lt;/sequence>
 *                                       &lt;/extension>
 *                                     &lt;/complexContent>
 *                                   &lt;/complexType>
 *                                 &lt;/element>
 *                                 &lt;element name="BlockToUpdate">
 *                                   &lt;complexType>
 *                                     &lt;complexContent>
 *                                       &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/house-management/}BlockUpdateOMSType">
 *                                         &lt;sequence>
 *                                           &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/base/}TransportGUID"/>
 *                                           &lt;element name="BlockGUID" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType"/>
 *                                         &lt;/sequence>
 *                                       &lt;/extension>
 *                                     &lt;/complexContent>
 *                                   &lt;/complexType>
 *                                 &lt;/element>
 *                               &lt;/choice>
 *                               &lt;sequence>
 *                                 &lt;element name="LivingRoomToCreate" maxOccurs="unbounded" minOccurs="0">
 *                                   &lt;complexType>
 *                                     &lt;complexContent>
 *                                       &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/house-management/}RoomOMSType">
 *                                         &lt;sequence>
 *                                           &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/base/}TransportGUID"/>
 *                                         &lt;/sequence>
 *                                       &lt;/extension>
 *                                     &lt;/complexContent>
 *                                   &lt;/complexType>
 *                                 &lt;/element>
 *                                 &lt;element name="LivingRoomToUpdate" maxOccurs="unbounded" minOccurs="0">
 *                                   &lt;complexType>
 *                                     &lt;complexContent>
 *                                       &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/house-management/}RoomUpdateOMSType">
 *                                         &lt;sequence>
 *                                           &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/base/}TransportGUID"/>
 *                                           &lt;element name="LivingRoomGUID" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType"/>
 *                                         &lt;/sequence>
 *                                       &lt;/extension>
 *                                     &lt;/complexContent>
 *                                   &lt;/complexType>
 *                                 &lt;/element>
 *                               &lt;/sequence>
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
    "apartmentHouse",
    "livingHouse"
})
@XmlRootElement(name = "importHouseOMSRequest")
public class ImportHouseOMSRequest
    extends BaseType
{

    @XmlElement(name = "ApartmentHouse")
    protected ImportHouseOMSRequest.ApartmentHouse apartmentHouse;
    @XmlElement(name = "LivingHouse")
    protected ImportHouseOMSRequest.LivingHouse livingHouse;
    @XmlAttribute(name = "version", namespace = "http://dom.gosuslugi.ru/schema/integration/base/", required = true)
    protected String version;

    /**
     * Gets the value of the apartmentHouse property.
     * 
     * @return
     *     possible object is
     *     {@link ImportHouseOMSRequest.ApartmentHouse }
     *     
     */
    public ImportHouseOMSRequest.ApartmentHouse getApartmentHouse() {
        return apartmentHouse;
    }

    /**
     * Sets the value of the apartmentHouse property.
     * 
     * @param value
     *     allowed object is
     *     {@link ImportHouseOMSRequest.ApartmentHouse }
     *     
     */
    public void setApartmentHouse(ImportHouseOMSRequest.ApartmentHouse value) {
        this.apartmentHouse = value;
    }

    /**
     * Gets the value of the livingHouse property.
     * 
     * @return
     *     possible object is
     *     {@link ImportHouseOMSRequest.LivingHouse }
     *     
     */
    public ImportHouseOMSRequest.LivingHouse getLivingHouse() {
        return livingHouse;
    }

    /**
     * Sets the value of the livingHouse property.
     * 
     * @param value
     *     allowed object is
     *     {@link ImportHouseOMSRequest.LivingHouse }
     *     
     */
    public void setLivingHouse(ImportHouseOMSRequest.LivingHouse value) {
        this.livingHouse = value;
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
     *         &lt;choice>
     *           &lt;element name="ApartmentHouseToCreate">
     *             &lt;complexType>
     *               &lt;complexContent>
     *                 &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/house-management/}ApartmentHouseOMSType">
     *                   &lt;sequence>
     *                     &lt;element name="HouseManagementType" type="{http://dom.gosuslugi.ru/schema/integration/nsi-base/}nsiRef" minOccurs="0"/>
     *                     &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/base/}TransportGUID"/>
     *                   &lt;/sequence>
     *                 &lt;/extension>
     *               &lt;/complexContent>
     *             &lt;/complexType>
     *           &lt;/element>
     *           &lt;element name="ApartmentHouseToUpdate">
     *             &lt;complexType>
     *               &lt;complexContent>
     *                 &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/house-management/}ApartmentHouseUpdateOMSType">
     *                   &lt;sequence>
     *                     &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/base/}TransportGUID"/>
     *                     &lt;element name="HouseManagementType" type="{http://dom.gosuslugi.ru/schema/integration/nsi-base/}nsiRef" minOccurs="0"/>
     *                   &lt;/sequence>
     *                 &lt;/extension>
     *               &lt;/complexContent>
     *             &lt;/complexType>
     *           &lt;/element>
     *         &lt;/choice>
     *         &lt;sequence>
     *           &lt;element name="NonResidentialPremiseToCreate" maxOccurs="unbounded" minOccurs="0">
     *             &lt;complexType>
     *               &lt;complexContent>
     *                 &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/house-management/}NonResidentialPremisesOMSType">
     *                   &lt;sequence>
     *                     &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/base/}TransportGUID"/>
     *                   &lt;/sequence>
     *                 &lt;/extension>
     *               &lt;/complexContent>
     *             &lt;/complexType>
     *           &lt;/element>
     *           &lt;element name="NonResidentialPremiseToUpdate" maxOccurs="unbounded" minOccurs="0">
     *             &lt;complexType>
     *               &lt;complexContent>
     *                 &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/house-management/}NonResidentialPremisesUpdateOMSType">
     *                   &lt;sequence>
     *                     &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/base/}TransportGUID"/>
     *                     &lt;element name="PremisesGUID" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType"/>
     *                   &lt;/sequence>
     *                 &lt;/extension>
     *               &lt;/complexContent>
     *             &lt;/complexType>
     *           &lt;/element>
     *         &lt;/sequence>
     *         &lt;sequence>
     *           &lt;sequence>
     *             &lt;element name="EntranceToCreate" maxOccurs="unbounded" minOccurs="0">
     *               &lt;complexType>
     *                 &lt;complexContent>
     *                   &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/house-management/}EntranceOMSType">
     *                     &lt;sequence>
     *                       &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/base/}TransportGUID"/>
     *                     &lt;/sequence>
     *                   &lt;/extension>
     *                 &lt;/complexContent>
     *               &lt;/complexType>
     *             &lt;/element>
     *             &lt;element name="EntranceToUpdate" maxOccurs="unbounded" minOccurs="0">
     *               &lt;complexType>
     *                 &lt;complexContent>
     *                   &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/house-management/}EntranceUpdateOMSType">
     *                     &lt;sequence>
     *                       &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/base/}TransportGUID"/>
     *                       &lt;element name="EntranceGUID" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType"/>
     *                     &lt;/sequence>
     *                   &lt;/extension>
     *                 &lt;/complexContent>
     *               &lt;/complexType>
     *             &lt;/element>
     *           &lt;/sequence>
     *           &lt;element name="ResidentialPremises" maxOccurs="unbounded" minOccurs="0">
     *             &lt;complexType>
     *               &lt;complexContent>
     *                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                   &lt;sequence>
     *                     &lt;choice>
     *                       &lt;element name="ResidentialPremisesToCreate">
     *                         &lt;complexType>
     *                           &lt;complexContent>
     *                             &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/house-management/}ResidentialPremisesOMSType">
     *                               &lt;sequence>
     *                                 &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/base/}TransportGUID"/>
     *                               &lt;/sequence>
     *                             &lt;/extension>
     *                           &lt;/complexContent>
     *                         &lt;/complexType>
     *                       &lt;/element>
     *                       &lt;element name="ResidentialPremisesToUpdate">
     *                         &lt;complexType>
     *                           &lt;complexContent>
     *                             &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/house-management/}ResidentialPremisesUpdateOMSType">
     *                               &lt;sequence>
     *                                 &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/base/}TransportGUID"/>
     *                                 &lt;element name="PremisesGUID" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType"/>
     *                               &lt;/sequence>
     *                             &lt;/extension>
     *                           &lt;/complexContent>
     *                         &lt;/complexType>
     *                       &lt;/element>
     *                     &lt;/choice>
     *                     &lt;sequence>
     *                       &lt;element name="LivingRoomToCreate" maxOccurs="unbounded" minOccurs="0">
     *                         &lt;complexType>
     *                           &lt;complexContent>
     *                             &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/house-management/}RoomOMSType">
     *                               &lt;sequence>
     *                                 &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/base/}TransportGUID"/>
     *                               &lt;/sequence>
     *                             &lt;/extension>
     *                           &lt;/complexContent>
     *                         &lt;/complexType>
     *                       &lt;/element>
     *                       &lt;element name="LivingRoomToUpdate" maxOccurs="unbounded" minOccurs="0">
     *                         &lt;complexType>
     *                           &lt;complexContent>
     *                             &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/house-management/}RoomUpdateOMSType">
     *                               &lt;sequence>
     *                                 &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/base/}TransportGUID"/>
     *                                 &lt;element name="LivingRoomGUID" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType"/>
     *                               &lt;/sequence>
     *                             &lt;/extension>
     *                           &lt;/complexContent>
     *                         &lt;/complexType>
     *                       &lt;/element>
     *                     &lt;/sequence>
     *                   &lt;/sequence>
     *                 &lt;/restriction>
     *               &lt;/complexContent>
     *             &lt;/complexType>
     *           &lt;/element>
     *           &lt;sequence>
     *             &lt;element name="LiftToCreate" maxOccurs="unbounded" minOccurs="0">
     *               &lt;complexType>
     *                 &lt;complexContent>
     *                   &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/house-management/}LiftOMSType">
     *                     &lt;sequence>
     *                       &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/base/}TransportGUID"/>
     *                     &lt;/sequence>
     *                   &lt;/extension>
     *                 &lt;/complexContent>
     *               &lt;/complexType>
     *             &lt;/element>
     *             &lt;element name="LiftToUpdate" maxOccurs="unbounded" minOccurs="0">
     *               &lt;complexType>
     *                 &lt;complexContent>
     *                   &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/house-management/}LiftUpdateOMSType">
     *                     &lt;sequence>
     *                       &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/base/}TransportGUID"/>
     *                       &lt;element name="LiftGUID" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType"/>
     *                     &lt;/sequence>
     *                   &lt;/extension>
     *                 &lt;/complexContent>
     *               &lt;/complexType>
     *             &lt;/element>
     *           &lt;/sequence>
     *         &lt;/sequence>
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
        "apartmentHouseToCreate",
        "apartmentHouseToUpdate",
        "nonResidentialPremiseToCreate",
        "nonResidentialPremiseToUpdate",
        "entranceToCreate",
        "entranceToUpdate",
        "residentialPremises",
        "liftToCreate",
        "liftToUpdate"
    })
    public static class ApartmentHouse {

        @XmlElement(name = "ApartmentHouseToCreate")
        protected ImportHouseOMSRequest.ApartmentHouse.ApartmentHouseToCreate apartmentHouseToCreate;
        @XmlElement(name = "ApartmentHouseToUpdate")
        protected ImportHouseOMSRequest.ApartmentHouse.ApartmentHouseToUpdate apartmentHouseToUpdate;
        @XmlElement(name = "NonResidentialPremiseToCreate")
        protected List<ImportHouseOMSRequest.ApartmentHouse.NonResidentialPremiseToCreate> nonResidentialPremiseToCreate;
        @XmlElement(name = "NonResidentialPremiseToUpdate")
        protected List<ImportHouseOMSRequest.ApartmentHouse.NonResidentialPremiseToUpdate> nonResidentialPremiseToUpdate;
        @XmlElement(name = "EntranceToCreate")
        protected List<ImportHouseOMSRequest.ApartmentHouse.EntranceToCreate> entranceToCreate;
        @XmlElement(name = "EntranceToUpdate")
        protected List<ImportHouseOMSRequest.ApartmentHouse.EntranceToUpdate> entranceToUpdate;
        @XmlElement(name = "ResidentialPremises")
        protected List<ImportHouseOMSRequest.ApartmentHouse.ResidentialPremises> residentialPremises;
        @XmlElement(name = "LiftToCreate")
        protected List<ImportHouseOMSRequest.ApartmentHouse.LiftToCreate> liftToCreate;
        @XmlElement(name = "LiftToUpdate")
        protected List<ImportHouseOMSRequest.ApartmentHouse.LiftToUpdate> liftToUpdate;

        /**
         * Gets the value of the apartmentHouseToCreate property.
         * 
         * @return
         *     possible object is
         *     {@link ImportHouseOMSRequest.ApartmentHouse.ApartmentHouseToCreate }
         *     
         */
        public ImportHouseOMSRequest.ApartmentHouse.ApartmentHouseToCreate getApartmentHouseToCreate() {
            return apartmentHouseToCreate;
        }

        /**
         * Sets the value of the apartmentHouseToCreate property.
         * 
         * @param value
         *     allowed object is
         *     {@link ImportHouseOMSRequest.ApartmentHouse.ApartmentHouseToCreate }
         *     
         */
        public void setApartmentHouseToCreate(ImportHouseOMSRequest.ApartmentHouse.ApartmentHouseToCreate value) {
            this.apartmentHouseToCreate = value;
        }

        /**
         * Gets the value of the apartmentHouseToUpdate property.
         * 
         * @return
         *     possible object is
         *     {@link ImportHouseOMSRequest.ApartmentHouse.ApartmentHouseToUpdate }
         *     
         */
        public ImportHouseOMSRequest.ApartmentHouse.ApartmentHouseToUpdate getApartmentHouseToUpdate() {
            return apartmentHouseToUpdate;
        }

        /**
         * Sets the value of the apartmentHouseToUpdate property.
         * 
         * @param value
         *     allowed object is
         *     {@link ImportHouseOMSRequest.ApartmentHouse.ApartmentHouseToUpdate }
         *     
         */
        public void setApartmentHouseToUpdate(ImportHouseOMSRequest.ApartmentHouse.ApartmentHouseToUpdate value) {
            this.apartmentHouseToUpdate = value;
        }

        /**
         * Gets the value of the nonResidentialPremiseToCreate property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the nonResidentialPremiseToCreate property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getNonResidentialPremiseToCreate().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link ImportHouseOMSRequest.ApartmentHouse.NonResidentialPremiseToCreate }
         * 
         * 
         */
        public List<ImportHouseOMSRequest.ApartmentHouse.NonResidentialPremiseToCreate> getNonResidentialPremiseToCreate() {
            if (nonResidentialPremiseToCreate == null) {
                nonResidentialPremiseToCreate = new ArrayList<ImportHouseOMSRequest.ApartmentHouse.NonResidentialPremiseToCreate>();
            }
            return this.nonResidentialPremiseToCreate;
        }

        /**
         * Gets the value of the nonResidentialPremiseToUpdate property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the nonResidentialPremiseToUpdate property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getNonResidentialPremiseToUpdate().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link ImportHouseOMSRequest.ApartmentHouse.NonResidentialPremiseToUpdate }
         * 
         * 
         */
        public List<ImportHouseOMSRequest.ApartmentHouse.NonResidentialPremiseToUpdate> getNonResidentialPremiseToUpdate() {
            if (nonResidentialPremiseToUpdate == null) {
                nonResidentialPremiseToUpdate = new ArrayList<ImportHouseOMSRequest.ApartmentHouse.NonResidentialPremiseToUpdate>();
            }
            return this.nonResidentialPremiseToUpdate;
        }

        /**
         * Gets the value of the entranceToCreate property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the entranceToCreate property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getEntranceToCreate().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link ImportHouseOMSRequest.ApartmentHouse.EntranceToCreate }
         * 
         * 
         */
        public List<ImportHouseOMSRequest.ApartmentHouse.EntranceToCreate> getEntranceToCreate() {
            if (entranceToCreate == null) {
                entranceToCreate = new ArrayList<ImportHouseOMSRequest.ApartmentHouse.EntranceToCreate>();
            }
            return this.entranceToCreate;
        }

        /**
         * Gets the value of the entranceToUpdate property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the entranceToUpdate property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getEntranceToUpdate().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link ImportHouseOMSRequest.ApartmentHouse.EntranceToUpdate }
         * 
         * 
         */
        public List<ImportHouseOMSRequest.ApartmentHouse.EntranceToUpdate> getEntranceToUpdate() {
            if (entranceToUpdate == null) {
                entranceToUpdate = new ArrayList<ImportHouseOMSRequest.ApartmentHouse.EntranceToUpdate>();
            }
            return this.entranceToUpdate;
        }

        /**
         * Gets the value of the residentialPremises property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the residentialPremises property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getResidentialPremises().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link ImportHouseOMSRequest.ApartmentHouse.ResidentialPremises }
         * 
         * 
         */
        public List<ImportHouseOMSRequest.ApartmentHouse.ResidentialPremises> getResidentialPremises() {
            if (residentialPremises == null) {
                residentialPremises = new ArrayList<ImportHouseOMSRequest.ApartmentHouse.ResidentialPremises>();
            }
            return this.residentialPremises;
        }

        /**
         * Gets the value of the liftToCreate property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the liftToCreate property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getLiftToCreate().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link ImportHouseOMSRequest.ApartmentHouse.LiftToCreate }
         * 
         * 
         */
        public List<ImportHouseOMSRequest.ApartmentHouse.LiftToCreate> getLiftToCreate() {
            if (liftToCreate == null) {
                liftToCreate = new ArrayList<ImportHouseOMSRequest.ApartmentHouse.LiftToCreate>();
            }
            return this.liftToCreate;
        }

        /**
         * Gets the value of the liftToUpdate property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the liftToUpdate property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getLiftToUpdate().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link ImportHouseOMSRequest.ApartmentHouse.LiftToUpdate }
         * 
         * 
         */
        public List<ImportHouseOMSRequest.ApartmentHouse.LiftToUpdate> getLiftToUpdate() {
            if (liftToUpdate == null) {
                liftToUpdate = new ArrayList<ImportHouseOMSRequest.ApartmentHouse.LiftToUpdate>();
            }
            return this.liftToUpdate;
        }


        /**
         * <p>Java class for anonymous complex type.
         * 
         * <p>The following schema fragment specifies the expected content contained within this class.
         * 
         * <pre>
         * &lt;complexType>
         *   &lt;complexContent>
         *     &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/house-management/}ApartmentHouseOMSType">
         *       &lt;sequence>
         *         &lt;element name="HouseManagementType" type="{http://dom.gosuslugi.ru/schema/integration/nsi-base/}nsiRef" minOccurs="0"/>
         *         &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/base/}TransportGUID"/>
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
            "houseManagementType",
            "transportGUID"
        })
        public static class ApartmentHouseToCreate
            extends ApartmentHouseOMSType
        {

            @XmlElement(name = "HouseManagementType")
            protected NsiRef houseManagementType;
            @XmlElement(name = "TransportGUID", namespace = "http://dom.gosuslugi.ru/schema/integration/base/", required = true)
            protected String transportGUID;

            /**
             * Gets the value of the houseManagementType property.
             * 
             * @return
             *     possible object is
             *     {@link NsiRef }
             *     
             */
            public NsiRef getHouseManagementType() {
                return houseManagementType;
            }

            /**
             * Sets the value of the houseManagementType property.
             * 
             * @param value
             *     allowed object is
             *     {@link NsiRef }
             *     
             */
            public void setHouseManagementType(NsiRef value) {
                this.houseManagementType = value;
            }

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

        }


        /**
         * <p>Java class for anonymous complex type.
         * 
         * <p>The following schema fragment specifies the expected content contained within this class.
         * 
         * <pre>
         * &lt;complexType>
         *   &lt;complexContent>
         *     &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/house-management/}ApartmentHouseUpdateOMSType">
         *       &lt;sequence>
         *         &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/base/}TransportGUID"/>
         *         &lt;element name="HouseManagementType" type="{http://dom.gosuslugi.ru/schema/integration/nsi-base/}nsiRef" minOccurs="0"/>
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
            "houseManagementType"
        })
        public static class ApartmentHouseToUpdate
            extends ApartmentHouseUpdateOMSType
        {

            @XmlElement(name = "TransportGUID", namespace = "http://dom.gosuslugi.ru/schema/integration/base/", required = true)
            protected String transportGUID;
            @XmlElement(name = "HouseManagementType")
            protected NsiRef houseManagementType;

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
             * Gets the value of the houseManagementType property.
             * 
             * @return
             *     possible object is
             *     {@link NsiRef }
             *     
             */
            public NsiRef getHouseManagementType() {
                return houseManagementType;
            }

            /**
             * Sets the value of the houseManagementType property.
             * 
             * @param value
             *     allowed object is
             *     {@link NsiRef }
             *     
             */
            public void setHouseManagementType(NsiRef value) {
                this.houseManagementType = value;
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
         *     &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/house-management/}EntranceOMSType">
         *       &lt;sequence>
         *         &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/base/}TransportGUID"/>
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
            "transportGUID"
        })
        public static class EntranceToCreate
            extends EntranceOMSType
        {

            @XmlElement(name = "TransportGUID", namespace = "http://dom.gosuslugi.ru/schema/integration/base/", required = true)
            protected String transportGUID;

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

        }


        /**
         * <p>Java class for anonymous complex type.
         * 
         * <p>The following schema fragment specifies the expected content contained within this class.
         * 
         * <pre>
         * &lt;complexType>
         *   &lt;complexContent>
         *     &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/house-management/}EntranceUpdateOMSType">
         *       &lt;sequence>
         *         &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/base/}TransportGUID"/>
         *         &lt;element name="EntranceGUID" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType"/>
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
            "entranceGUID"
        })
        public static class EntranceToUpdate
            extends EntranceUpdateOMSType
        {

            @XmlElement(name = "TransportGUID", namespace = "http://dom.gosuslugi.ru/schema/integration/base/", required = true)
            protected String transportGUID;
            @XmlElement(name = "EntranceGUID", required = true)
            protected String entranceGUID;

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
             * Gets the value of the entranceGUID property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getEntranceGUID() {
                return entranceGUID;
            }

            /**
             * Sets the value of the entranceGUID property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setEntranceGUID(String value) {
                this.entranceGUID = value;
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
         *     &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/house-management/}LiftOMSType">
         *       &lt;sequence>
         *         &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/base/}TransportGUID"/>
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
            "transportGUID"
        })
        public static class LiftToCreate
            extends LiftOMSType
        {

            @XmlElement(name = "TransportGUID", namespace = "http://dom.gosuslugi.ru/schema/integration/base/", required = true)
            protected String transportGUID;

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

        }


        /**
         * <p>Java class for anonymous complex type.
         * 
         * <p>The following schema fragment specifies the expected content contained within this class.
         * 
         * <pre>
         * &lt;complexType>
         *   &lt;complexContent>
         *     &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/house-management/}LiftUpdateOMSType">
         *       &lt;sequence>
         *         &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/base/}TransportGUID"/>
         *         &lt;element name="LiftGUID" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType"/>
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
            "liftGUID"
        })
        public static class LiftToUpdate
            extends LiftUpdateOMSType
        {

            @XmlElement(name = "TransportGUID", namespace = "http://dom.gosuslugi.ru/schema/integration/base/", required = true)
            protected String transportGUID;
            @XmlElement(name = "LiftGUID", required = true)
            protected String liftGUID;

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
             * Gets the value of the liftGUID property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getLiftGUID() {
                return liftGUID;
            }

            /**
             * Sets the value of the liftGUID property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setLiftGUID(String value) {
                this.liftGUID = value;
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
         *     &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/house-management/}NonResidentialPremisesOMSType">
         *       &lt;sequence>
         *         &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/base/}TransportGUID"/>
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
            "transportGUID"
        })
        public static class NonResidentialPremiseToCreate
            extends NonResidentialPremisesOMSType
        {

            @XmlElement(name = "TransportGUID", namespace = "http://dom.gosuslugi.ru/schema/integration/base/", required = true)
            protected String transportGUID;

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

        }


        /**
         * <p>Java class for anonymous complex type.
         * 
         * <p>The following schema fragment specifies the expected content contained within this class.
         * 
         * <pre>
         * &lt;complexType>
         *   &lt;complexContent>
         *     &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/house-management/}NonResidentialPremisesUpdateOMSType">
         *       &lt;sequence>
         *         &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/base/}TransportGUID"/>
         *         &lt;element name="PremisesGUID" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType"/>
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
            "premisesGUID"
        })
        public static class NonResidentialPremiseToUpdate
            extends NonResidentialPremisesUpdateOMSType
        {

            @XmlElement(name = "TransportGUID", namespace = "http://dom.gosuslugi.ru/schema/integration/base/", required = true)
            protected String transportGUID;
            @XmlElement(name = "PremisesGUID", required = true)
            protected String premisesGUID;

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
             * Gets the value of the premisesGUID property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getPremisesGUID() {
                return premisesGUID;
            }

            /**
             * Sets the value of the premisesGUID property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setPremisesGUID(String value) {
                this.premisesGUID = value;
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
         *         &lt;choice>
         *           &lt;element name="ResidentialPremisesToCreate">
         *             &lt;complexType>
         *               &lt;complexContent>
         *                 &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/house-management/}ResidentialPremisesOMSType">
         *                   &lt;sequence>
         *                     &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/base/}TransportGUID"/>
         *                   &lt;/sequence>
         *                 &lt;/extension>
         *               &lt;/complexContent>
         *             &lt;/complexType>
         *           &lt;/element>
         *           &lt;element name="ResidentialPremisesToUpdate">
         *             &lt;complexType>
         *               &lt;complexContent>
         *                 &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/house-management/}ResidentialPremisesUpdateOMSType">
         *                   &lt;sequence>
         *                     &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/base/}TransportGUID"/>
         *                     &lt;element name="PremisesGUID" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType"/>
         *                   &lt;/sequence>
         *                 &lt;/extension>
         *               &lt;/complexContent>
         *             &lt;/complexType>
         *           &lt;/element>
         *         &lt;/choice>
         *         &lt;sequence>
         *           &lt;element name="LivingRoomToCreate" maxOccurs="unbounded" minOccurs="0">
         *             &lt;complexType>
         *               &lt;complexContent>
         *                 &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/house-management/}RoomOMSType">
         *                   &lt;sequence>
         *                     &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/base/}TransportGUID"/>
         *                   &lt;/sequence>
         *                 &lt;/extension>
         *               &lt;/complexContent>
         *             &lt;/complexType>
         *           &lt;/element>
         *           &lt;element name="LivingRoomToUpdate" maxOccurs="unbounded" minOccurs="0">
         *             &lt;complexType>
         *               &lt;complexContent>
         *                 &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/house-management/}RoomUpdateOMSType">
         *                   &lt;sequence>
         *                     &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/base/}TransportGUID"/>
         *                     &lt;element name="LivingRoomGUID" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType"/>
         *                   &lt;/sequence>
         *                 &lt;/extension>
         *               &lt;/complexContent>
         *             &lt;/complexType>
         *           &lt;/element>
         *         &lt;/sequence>
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
            "residentialPremisesToCreate",
            "residentialPremisesToUpdate",
            "livingRoomToCreate",
            "livingRoomToUpdate"
        })
        public static class ResidentialPremises {

            @XmlElement(name = "ResidentialPremisesToCreate")
            protected ImportHouseOMSRequest.ApartmentHouse.ResidentialPremises.ResidentialPremisesToCreate residentialPremisesToCreate;
            @XmlElement(name = "ResidentialPremisesToUpdate")
            protected ImportHouseOMSRequest.ApartmentHouse.ResidentialPremises.ResidentialPremisesToUpdate residentialPremisesToUpdate;
            @XmlElement(name = "LivingRoomToCreate")
            protected List<ImportHouseOMSRequest.ApartmentHouse.ResidentialPremises.LivingRoomToCreate> livingRoomToCreate;
            @XmlElement(name = "LivingRoomToUpdate")
            protected List<ImportHouseOMSRequest.ApartmentHouse.ResidentialPremises.LivingRoomToUpdate> livingRoomToUpdate;

            /**
             * Gets the value of the residentialPremisesToCreate property.
             * 
             * @return
             *     possible object is
             *     {@link ImportHouseOMSRequest.ApartmentHouse.ResidentialPremises.ResidentialPremisesToCreate }
             *     
             */
            public ImportHouseOMSRequest.ApartmentHouse.ResidentialPremises.ResidentialPremisesToCreate getResidentialPremisesToCreate() {
                return residentialPremisesToCreate;
            }

            /**
             * Sets the value of the residentialPremisesToCreate property.
             * 
             * @param value
             *     allowed object is
             *     {@link ImportHouseOMSRequest.ApartmentHouse.ResidentialPremises.ResidentialPremisesToCreate }
             *     
             */
            public void setResidentialPremisesToCreate(ImportHouseOMSRequest.ApartmentHouse.ResidentialPremises.ResidentialPremisesToCreate value) {
                this.residentialPremisesToCreate = value;
            }

            /**
             * Gets the value of the residentialPremisesToUpdate property.
             * 
             * @return
             *     possible object is
             *     {@link ImportHouseOMSRequest.ApartmentHouse.ResidentialPremises.ResidentialPremisesToUpdate }
             *     
             */
            public ImportHouseOMSRequest.ApartmentHouse.ResidentialPremises.ResidentialPremisesToUpdate getResidentialPremisesToUpdate() {
                return residentialPremisesToUpdate;
            }

            /**
             * Sets the value of the residentialPremisesToUpdate property.
             * 
             * @param value
             *     allowed object is
             *     {@link ImportHouseOMSRequest.ApartmentHouse.ResidentialPremises.ResidentialPremisesToUpdate }
             *     
             */
            public void setResidentialPremisesToUpdate(ImportHouseOMSRequest.ApartmentHouse.ResidentialPremises.ResidentialPremisesToUpdate value) {
                this.residentialPremisesToUpdate = value;
            }

            /**
             * Gets the value of the livingRoomToCreate property.
             * 
             * <p>
             * This accessor method returns a reference to the live list,
             * not a snapshot. Therefore any modification you make to the
             * returned list will be present inside the JAXB object.
             * This is why there is not a <CODE>set</CODE> method for the livingRoomToCreate property.
             * 
             * <p>
             * For example, to add a new item, do as follows:
             * <pre>
             *    getLivingRoomToCreate().add(newItem);
             * </pre>
             * 
             * 
             * <p>
             * Objects of the following type(s) are allowed in the list
             * {@link ImportHouseOMSRequest.ApartmentHouse.ResidentialPremises.LivingRoomToCreate }
             * 
             * 
             */
            public List<ImportHouseOMSRequest.ApartmentHouse.ResidentialPremises.LivingRoomToCreate> getLivingRoomToCreate() {
                if (livingRoomToCreate == null) {
                    livingRoomToCreate = new ArrayList<ImportHouseOMSRequest.ApartmentHouse.ResidentialPremises.LivingRoomToCreate>();
                }
                return this.livingRoomToCreate;
            }

            /**
             * Gets the value of the livingRoomToUpdate property.
             * 
             * <p>
             * This accessor method returns a reference to the live list,
             * not a snapshot. Therefore any modification you make to the
             * returned list will be present inside the JAXB object.
             * This is why there is not a <CODE>set</CODE> method for the livingRoomToUpdate property.
             * 
             * <p>
             * For example, to add a new item, do as follows:
             * <pre>
             *    getLivingRoomToUpdate().add(newItem);
             * </pre>
             * 
             * 
             * <p>
             * Objects of the following type(s) are allowed in the list
             * {@link ImportHouseOMSRequest.ApartmentHouse.ResidentialPremises.LivingRoomToUpdate }
             * 
             * 
             */
            public List<ImportHouseOMSRequest.ApartmentHouse.ResidentialPremises.LivingRoomToUpdate> getLivingRoomToUpdate() {
                if (livingRoomToUpdate == null) {
                    livingRoomToUpdate = new ArrayList<ImportHouseOMSRequest.ApartmentHouse.ResidentialPremises.LivingRoomToUpdate>();
                }
                return this.livingRoomToUpdate;
            }


            /**
             * <p>Java class for anonymous complex type.
             * 
             * <p>The following schema fragment specifies the expected content contained within this class.
             * 
             * <pre>
             * &lt;complexType>
             *   &lt;complexContent>
             *     &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/house-management/}RoomOMSType">
             *       &lt;sequence>
             *         &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/base/}TransportGUID"/>
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
                "transportGUID"
            })
            public static class LivingRoomToCreate
                extends RoomOMSType
            {

                @XmlElement(name = "TransportGUID", namespace = "http://dom.gosuslugi.ru/schema/integration/base/", required = true)
                protected String transportGUID;

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

            }


            /**
             * <p>Java class for anonymous complex type.
             * 
             * <p>The following schema fragment specifies the expected content contained within this class.
             * 
             * <pre>
             * &lt;complexType>
             *   &lt;complexContent>
             *     &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/house-management/}RoomUpdateOMSType">
             *       &lt;sequence>
             *         &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/base/}TransportGUID"/>
             *         &lt;element name="LivingRoomGUID" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType"/>
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
                "livingRoomGUID"
            })
            public static class LivingRoomToUpdate
                extends RoomUpdateOMSType
            {

                @XmlElement(name = "TransportGUID", namespace = "http://dom.gosuslugi.ru/schema/integration/base/", required = true)
                protected String transportGUID;
                @XmlElement(name = "LivingRoomGUID", required = true)
                protected String livingRoomGUID;

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
                 * Gets the value of the livingRoomGUID property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getLivingRoomGUID() {
                    return livingRoomGUID;
                }

                /**
                 * Sets the value of the livingRoomGUID property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setLivingRoomGUID(String value) {
                    this.livingRoomGUID = value;
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
             *     &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/house-management/}ResidentialPremisesOMSType">
             *       &lt;sequence>
             *         &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/base/}TransportGUID"/>
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
                "transportGUID"
            })
            public static class ResidentialPremisesToCreate
                extends ResidentialPremisesOMSType
            {

                @XmlElement(name = "TransportGUID", namespace = "http://dom.gosuslugi.ru/schema/integration/base/", required = true)
                protected String transportGUID;

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

            }


            /**
             * <p>Java class for anonymous complex type.
             * 
             * <p>The following schema fragment specifies the expected content contained within this class.
             * 
             * <pre>
             * &lt;complexType>
             *   &lt;complexContent>
             *     &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/house-management/}ResidentialPremisesUpdateOMSType">
             *       &lt;sequence>
             *         &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/base/}TransportGUID"/>
             *         &lt;element name="PremisesGUID" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType"/>
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
                "premisesGUID"
            })
            public static class ResidentialPremisesToUpdate
                extends ResidentialPremisesUpdateOMSType
            {

                @XmlElement(name = "TransportGUID", namespace = "http://dom.gosuslugi.ru/schema/integration/base/", required = true)
                protected String transportGUID;
                @XmlElement(name = "PremisesGUID", required = true)
                protected String premisesGUID;

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
                 * Gets the value of the premisesGUID property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getPremisesGUID() {
                    return premisesGUID;
                }

                /**
                 * Sets the value of the premisesGUID property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setPremisesGUID(String value) {
                    this.premisesGUID = value;
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
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;choice>
     *           &lt;element name="LivingHouseToCreate">
     *             &lt;complexType>
     *               &lt;complexContent>
     *                 &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/house-management/}LivingHouseOMSType">
     *                   &lt;sequence>
     *                     &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/base/}TransportGUID"/>
     *                     &lt;element name="HouseManagementType" type="{http://dom.gosuslugi.ru/schema/integration/nsi-base/}nsiRef" minOccurs="0"/>
     *                   &lt;/sequence>
     *                 &lt;/extension>
     *               &lt;/complexContent>
     *             &lt;/complexType>
     *           &lt;/element>
     *           &lt;element name="LivingHouseToUpdate">
     *             &lt;complexType>
     *               &lt;complexContent>
     *                 &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/house-management/}LivingHouseUpdateOMSType">
     *                   &lt;sequence>
     *                     &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/base/}TransportGUID"/>
     *                     &lt;element name="HouseManagementType" type="{http://dom.gosuslugi.ru/schema/integration/nsi-base/}nsiRef" minOccurs="0"/>
     *                   &lt;/sequence>
     *                 &lt;/extension>
     *               &lt;/complexContent>
     *             &lt;/complexType>
     *           &lt;/element>
     *         &lt;/choice>
     *         &lt;choice>
     *           &lt;sequence>
     *             &lt;element name="LivingRoomToCreate" maxOccurs="unbounded" minOccurs="0">
     *               &lt;complexType>
     *                 &lt;complexContent>
     *                   &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/house-management/}RoomOMSType">
     *                     &lt;sequence>
     *                       &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/base/}TransportGUID"/>
     *                     &lt;/sequence>
     *                   &lt;/extension>
     *                 &lt;/complexContent>
     *               &lt;/complexType>
     *             &lt;/element>
     *             &lt;element name="LivingRoomToUpdate" maxOccurs="unbounded" minOccurs="0">
     *               &lt;complexType>
     *                 &lt;complexContent>
     *                   &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/house-management/}RoomUpdateOMSType">
     *                     &lt;sequence>
     *                       &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/base/}TransportGUID"/>
     *                       &lt;element name="LivingRoomGUID" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType"/>
     *                     &lt;/sequence>
     *                   &lt;/extension>
     *                 &lt;/complexContent>
     *               &lt;/complexType>
     *             &lt;/element>
     *           &lt;/sequence>
     *           &lt;element name="Blocks" maxOccurs="unbounded" minOccurs="0">
     *             &lt;complexType>
     *               &lt;complexContent>
     *                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                   &lt;sequence>
     *                     &lt;choice>
     *                       &lt;element name="BlockToCreate">
     *                         &lt;complexType>
     *                           &lt;complexContent>
     *                             &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/house-management/}BlockOMSType">
     *                               &lt;sequence>
     *                                 &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/base/}TransportGUID"/>
     *                               &lt;/sequence>
     *                             &lt;/extension>
     *                           &lt;/complexContent>
     *                         &lt;/complexType>
     *                       &lt;/element>
     *                       &lt;element name="BlockToUpdate">
     *                         &lt;complexType>
     *                           &lt;complexContent>
     *                             &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/house-management/}BlockUpdateOMSType">
     *                               &lt;sequence>
     *                                 &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/base/}TransportGUID"/>
     *                                 &lt;element name="BlockGUID" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType"/>
     *                               &lt;/sequence>
     *                             &lt;/extension>
     *                           &lt;/complexContent>
     *                         &lt;/complexType>
     *                       &lt;/element>
     *                     &lt;/choice>
     *                     &lt;sequence>
     *                       &lt;element name="LivingRoomToCreate" maxOccurs="unbounded" minOccurs="0">
     *                         &lt;complexType>
     *                           &lt;complexContent>
     *                             &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/house-management/}RoomOMSType">
     *                               &lt;sequence>
     *                                 &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/base/}TransportGUID"/>
     *                               &lt;/sequence>
     *                             &lt;/extension>
     *                           &lt;/complexContent>
     *                         &lt;/complexType>
     *                       &lt;/element>
     *                       &lt;element name="LivingRoomToUpdate" maxOccurs="unbounded" minOccurs="0">
     *                         &lt;complexType>
     *                           &lt;complexContent>
     *                             &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/house-management/}RoomUpdateOMSType">
     *                               &lt;sequence>
     *                                 &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/base/}TransportGUID"/>
     *                                 &lt;element name="LivingRoomGUID" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType"/>
     *                               &lt;/sequence>
     *                             &lt;/extension>
     *                           &lt;/complexContent>
     *                         &lt;/complexType>
     *                       &lt;/element>
     *                     &lt;/sequence>
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
        "livingHouseToCreate",
        "livingHouseToUpdate",
        "livingRoomToCreate",
        "livingRoomToUpdate",
        "blocks"
    })
    public static class LivingHouse {

        @XmlElement(name = "LivingHouseToCreate")
        protected ImportHouseOMSRequest.LivingHouse.LivingHouseToCreate livingHouseToCreate;
        @XmlElement(name = "LivingHouseToUpdate")
        protected ImportHouseOMSRequest.LivingHouse.LivingHouseToUpdate livingHouseToUpdate;
        @XmlElement(name = "LivingRoomToCreate")
        protected List<ImportHouseOMSRequest.LivingHouse.LivingRoomToCreate> livingRoomToCreate;
        @XmlElement(name = "LivingRoomToUpdate")
        protected List<ImportHouseOMSRequest.LivingHouse.LivingRoomToUpdate> livingRoomToUpdate;
        @XmlElement(name = "Blocks")
        protected List<ImportHouseOMSRequest.LivingHouse.Blocks> blocks;

        /**
         * Gets the value of the livingHouseToCreate property.
         * 
         * @return
         *     possible object is
         *     {@link ImportHouseOMSRequest.LivingHouse.LivingHouseToCreate }
         *     
         */
        public ImportHouseOMSRequest.LivingHouse.LivingHouseToCreate getLivingHouseToCreate() {
            return livingHouseToCreate;
        }

        /**
         * Sets the value of the livingHouseToCreate property.
         * 
         * @param value
         *     allowed object is
         *     {@link ImportHouseOMSRequest.LivingHouse.LivingHouseToCreate }
         *     
         */
        public void setLivingHouseToCreate(ImportHouseOMSRequest.LivingHouse.LivingHouseToCreate value) {
            this.livingHouseToCreate = value;
        }

        /**
         * Gets the value of the livingHouseToUpdate property.
         * 
         * @return
         *     possible object is
         *     {@link ImportHouseOMSRequest.LivingHouse.LivingHouseToUpdate }
         *     
         */
        public ImportHouseOMSRequest.LivingHouse.LivingHouseToUpdate getLivingHouseToUpdate() {
            return livingHouseToUpdate;
        }

        /**
         * Sets the value of the livingHouseToUpdate property.
         * 
         * @param value
         *     allowed object is
         *     {@link ImportHouseOMSRequest.LivingHouse.LivingHouseToUpdate }
         *     
         */
        public void setLivingHouseToUpdate(ImportHouseOMSRequest.LivingHouse.LivingHouseToUpdate value) {
            this.livingHouseToUpdate = value;
        }

        /**
         * Gets the value of the livingRoomToCreate property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the livingRoomToCreate property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getLivingRoomToCreate().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link ImportHouseOMSRequest.LivingHouse.LivingRoomToCreate }
         * 
         * 
         */
        public List<ImportHouseOMSRequest.LivingHouse.LivingRoomToCreate> getLivingRoomToCreate() {
            if (livingRoomToCreate == null) {
                livingRoomToCreate = new ArrayList<ImportHouseOMSRequest.LivingHouse.LivingRoomToCreate>();
            }
            return this.livingRoomToCreate;
        }

        /**
         * Gets the value of the livingRoomToUpdate property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the livingRoomToUpdate property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getLivingRoomToUpdate().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link ImportHouseOMSRequest.LivingHouse.LivingRoomToUpdate }
         * 
         * 
         */
        public List<ImportHouseOMSRequest.LivingHouse.LivingRoomToUpdate> getLivingRoomToUpdate() {
            if (livingRoomToUpdate == null) {
                livingRoomToUpdate = new ArrayList<ImportHouseOMSRequest.LivingHouse.LivingRoomToUpdate>();
            }
            return this.livingRoomToUpdate;
        }

        /**
         * Gets the value of the blocks property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the blocks property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getBlocks().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link ImportHouseOMSRequest.LivingHouse.Blocks }
         * 
         * 
         */
        public List<ImportHouseOMSRequest.LivingHouse.Blocks> getBlocks() {
            if (blocks == null) {
                blocks = new ArrayList<ImportHouseOMSRequest.LivingHouse.Blocks>();
            }
            return this.blocks;
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
         *         &lt;choice>
         *           &lt;element name="BlockToCreate">
         *             &lt;complexType>
         *               &lt;complexContent>
         *                 &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/house-management/}BlockOMSType">
         *                   &lt;sequence>
         *                     &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/base/}TransportGUID"/>
         *                   &lt;/sequence>
         *                 &lt;/extension>
         *               &lt;/complexContent>
         *             &lt;/complexType>
         *           &lt;/element>
         *           &lt;element name="BlockToUpdate">
         *             &lt;complexType>
         *               &lt;complexContent>
         *                 &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/house-management/}BlockUpdateOMSType">
         *                   &lt;sequence>
         *                     &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/base/}TransportGUID"/>
         *                     &lt;element name="BlockGUID" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType"/>
         *                   &lt;/sequence>
         *                 &lt;/extension>
         *               &lt;/complexContent>
         *             &lt;/complexType>
         *           &lt;/element>
         *         &lt;/choice>
         *         &lt;sequence>
         *           &lt;element name="LivingRoomToCreate" maxOccurs="unbounded" minOccurs="0">
         *             &lt;complexType>
         *               &lt;complexContent>
         *                 &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/house-management/}RoomOMSType">
         *                   &lt;sequence>
         *                     &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/base/}TransportGUID"/>
         *                   &lt;/sequence>
         *                 &lt;/extension>
         *               &lt;/complexContent>
         *             &lt;/complexType>
         *           &lt;/element>
         *           &lt;element name="LivingRoomToUpdate" maxOccurs="unbounded" minOccurs="0">
         *             &lt;complexType>
         *               &lt;complexContent>
         *                 &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/house-management/}RoomUpdateOMSType">
         *                   &lt;sequence>
         *                     &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/base/}TransportGUID"/>
         *                     &lt;element name="LivingRoomGUID" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType"/>
         *                   &lt;/sequence>
         *                 &lt;/extension>
         *               &lt;/complexContent>
         *             &lt;/complexType>
         *           &lt;/element>
         *         &lt;/sequence>
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
            "blockToCreate",
            "blockToUpdate",
            "livingRoomToCreate",
            "livingRoomToUpdate"
        })
        public static class Blocks {

            @XmlElement(name = "BlockToCreate")
            protected ImportHouseOMSRequest.LivingHouse.Blocks.BlockToCreate blockToCreate;
            @XmlElement(name = "BlockToUpdate")
            protected ImportHouseOMSRequest.LivingHouse.Blocks.BlockToUpdate blockToUpdate;
            @XmlElement(name = "LivingRoomToCreate")
            protected List<ImportHouseOMSRequest.LivingHouse.Blocks.LivingRoomToCreate> livingRoomToCreate;
            @XmlElement(name = "LivingRoomToUpdate")
            protected List<ImportHouseOMSRequest.LivingHouse.Blocks.LivingRoomToUpdate> livingRoomToUpdate;

            /**
             * Gets the value of the blockToCreate property.
             * 
             * @return
             *     possible object is
             *     {@link ImportHouseOMSRequest.LivingHouse.Blocks.BlockToCreate }
             *     
             */
            public ImportHouseOMSRequest.LivingHouse.Blocks.BlockToCreate getBlockToCreate() {
                return blockToCreate;
            }

            /**
             * Sets the value of the blockToCreate property.
             * 
             * @param value
             *     allowed object is
             *     {@link ImportHouseOMSRequest.LivingHouse.Blocks.BlockToCreate }
             *     
             */
            public void setBlockToCreate(ImportHouseOMSRequest.LivingHouse.Blocks.BlockToCreate value) {
                this.blockToCreate = value;
            }

            /**
             * Gets the value of the blockToUpdate property.
             * 
             * @return
             *     possible object is
             *     {@link ImportHouseOMSRequest.LivingHouse.Blocks.BlockToUpdate }
             *     
             */
            public ImportHouseOMSRequest.LivingHouse.Blocks.BlockToUpdate getBlockToUpdate() {
                return blockToUpdate;
            }

            /**
             * Sets the value of the blockToUpdate property.
             * 
             * @param value
             *     allowed object is
             *     {@link ImportHouseOMSRequest.LivingHouse.Blocks.BlockToUpdate }
             *     
             */
            public void setBlockToUpdate(ImportHouseOMSRequest.LivingHouse.Blocks.BlockToUpdate value) {
                this.blockToUpdate = value;
            }

            /**
             * Gets the value of the livingRoomToCreate property.
             * 
             * <p>
             * This accessor method returns a reference to the live list,
             * not a snapshot. Therefore any modification you make to the
             * returned list will be present inside the JAXB object.
             * This is why there is not a <CODE>set</CODE> method for the livingRoomToCreate property.
             * 
             * <p>
             * For example, to add a new item, do as follows:
             * <pre>
             *    getLivingRoomToCreate().add(newItem);
             * </pre>
             * 
             * 
             * <p>
             * Objects of the following type(s) are allowed in the list
             * {@link ImportHouseOMSRequest.LivingHouse.Blocks.LivingRoomToCreate }
             * 
             * 
             */
            public List<ImportHouseOMSRequest.LivingHouse.Blocks.LivingRoomToCreate> getLivingRoomToCreate() {
                if (livingRoomToCreate == null) {
                    livingRoomToCreate = new ArrayList<ImportHouseOMSRequest.LivingHouse.Blocks.LivingRoomToCreate>();
                }
                return this.livingRoomToCreate;
            }

            /**
             * Gets the value of the livingRoomToUpdate property.
             * 
             * <p>
             * This accessor method returns a reference to the live list,
             * not a snapshot. Therefore any modification you make to the
             * returned list will be present inside the JAXB object.
             * This is why there is not a <CODE>set</CODE> method for the livingRoomToUpdate property.
             * 
             * <p>
             * For example, to add a new item, do as follows:
             * <pre>
             *    getLivingRoomToUpdate().add(newItem);
             * </pre>
             * 
             * 
             * <p>
             * Objects of the following type(s) are allowed in the list
             * {@link ImportHouseOMSRequest.LivingHouse.Blocks.LivingRoomToUpdate }
             * 
             * 
             */
            public List<ImportHouseOMSRequest.LivingHouse.Blocks.LivingRoomToUpdate> getLivingRoomToUpdate() {
                if (livingRoomToUpdate == null) {
                    livingRoomToUpdate = new ArrayList<ImportHouseOMSRequest.LivingHouse.Blocks.LivingRoomToUpdate>();
                }
                return this.livingRoomToUpdate;
            }


            /**
             * <p>Java class for anonymous complex type.
             * 
             * <p>The following schema fragment specifies the expected content contained within this class.
             * 
             * <pre>
             * &lt;complexType>
             *   &lt;complexContent>
             *     &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/house-management/}BlockOMSType">
             *       &lt;sequence>
             *         &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/base/}TransportGUID"/>
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
                "transportGUID"
            })
            public static class BlockToCreate
                extends BlockOMSType
            {

                @XmlElement(name = "TransportGUID", namespace = "http://dom.gosuslugi.ru/schema/integration/base/", required = true)
                protected String transportGUID;

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

            }


            /**
             * <p>Java class for anonymous complex type.
             * 
             * <p>The following schema fragment specifies the expected content contained within this class.
             * 
             * <pre>
             * &lt;complexType>
             *   &lt;complexContent>
             *     &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/house-management/}BlockUpdateOMSType">
             *       &lt;sequence>
             *         &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/base/}TransportGUID"/>
             *         &lt;element name="BlockGUID" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType"/>
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
                "blockGUID"
            })
            public static class BlockToUpdate
                extends BlockUpdateOMSType
            {

                @XmlElement(name = "TransportGUID", namespace = "http://dom.gosuslugi.ru/schema/integration/base/", required = true)
                protected String transportGUID;
                @XmlElement(name = "BlockGUID", required = true)
                protected String blockGUID;

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
                 * Gets the value of the blockGUID property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getBlockGUID() {
                    return blockGUID;
                }

                /**
                 * Sets the value of the blockGUID property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setBlockGUID(String value) {
                    this.blockGUID = value;
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
             *     &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/house-management/}RoomOMSType">
             *       &lt;sequence>
             *         &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/base/}TransportGUID"/>
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
                "transportGUID"
            })
            public static class LivingRoomToCreate
                extends RoomOMSType
            {

                @XmlElement(name = "TransportGUID", namespace = "http://dom.gosuslugi.ru/schema/integration/base/", required = true)
                protected String transportGUID;

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

            }


            /**
             * <p>Java class for anonymous complex type.
             * 
             * <p>The following schema fragment specifies the expected content contained within this class.
             * 
             * <pre>
             * &lt;complexType>
             *   &lt;complexContent>
             *     &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/house-management/}RoomUpdateOMSType">
             *       &lt;sequence>
             *         &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/base/}TransportGUID"/>
             *         &lt;element name="LivingRoomGUID" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType"/>
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
                "livingRoomGUID"
            })
            public static class LivingRoomToUpdate
                extends RoomUpdateOMSType
            {

                @XmlElement(name = "TransportGUID", namespace = "http://dom.gosuslugi.ru/schema/integration/base/", required = true)
                protected String transportGUID;
                @XmlElement(name = "LivingRoomGUID", required = true)
                protected String livingRoomGUID;

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
                 * Gets the value of the livingRoomGUID property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getLivingRoomGUID() {
                    return livingRoomGUID;
                }

                /**
                 * Sets the value of the livingRoomGUID property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setLivingRoomGUID(String value) {
                    this.livingRoomGUID = value;
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
         *     &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/house-management/}LivingHouseOMSType">
         *       &lt;sequence>
         *         &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/base/}TransportGUID"/>
         *         &lt;element name="HouseManagementType" type="{http://dom.gosuslugi.ru/schema/integration/nsi-base/}nsiRef" minOccurs="0"/>
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
            "houseManagementType"
        })
        public static class LivingHouseToCreate
            extends LivingHouseOMSType
        {

            @XmlElement(name = "TransportGUID", namespace = "http://dom.gosuslugi.ru/schema/integration/base/", required = true)
            protected String transportGUID;
            @XmlElement(name = "HouseManagementType")
            protected NsiRef houseManagementType;

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
             * Gets the value of the houseManagementType property.
             * 
             * @return
             *     possible object is
             *     {@link NsiRef }
             *     
             */
            public NsiRef getHouseManagementType() {
                return houseManagementType;
            }

            /**
             * Sets the value of the houseManagementType property.
             * 
             * @param value
             *     allowed object is
             *     {@link NsiRef }
             *     
             */
            public void setHouseManagementType(NsiRef value) {
                this.houseManagementType = value;
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
         *     &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/house-management/}LivingHouseUpdateOMSType">
         *       &lt;sequence>
         *         &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/base/}TransportGUID"/>
         *         &lt;element name="HouseManagementType" type="{http://dom.gosuslugi.ru/schema/integration/nsi-base/}nsiRef" minOccurs="0"/>
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
            "houseManagementType"
        })
        public static class LivingHouseToUpdate
            extends LivingHouseUpdateOMSType
        {

            @XmlElement(name = "TransportGUID", namespace = "http://dom.gosuslugi.ru/schema/integration/base/", required = true)
            protected String transportGUID;
            @XmlElement(name = "HouseManagementType")
            protected NsiRef houseManagementType;

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
             * Gets the value of the houseManagementType property.
             * 
             * @return
             *     possible object is
             *     {@link NsiRef }
             *     
             */
            public NsiRef getHouseManagementType() {
                return houseManagementType;
            }

            /**
             * Sets the value of the houseManagementType property.
             * 
             * @param value
             *     allowed object is
             *     {@link NsiRef }
             *     
             */
            public void setHouseManagementType(NsiRef value) {
                this.houseManagementType = value;
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
         *     &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/house-management/}RoomOMSType">
         *       &lt;sequence>
         *         &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/base/}TransportGUID"/>
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
            "transportGUID"
        })
        public static class LivingRoomToCreate
            extends RoomOMSType
        {

            @XmlElement(name = "TransportGUID", namespace = "http://dom.gosuslugi.ru/schema/integration/base/", required = true)
            protected String transportGUID;

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

        }


        /**
         * <p>Java class for anonymous complex type.
         * 
         * <p>The following schema fragment specifies the expected content contained within this class.
         * 
         * <pre>
         * &lt;complexType>
         *   &lt;complexContent>
         *     &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/house-management/}RoomUpdateOMSType">
         *       &lt;sequence>
         *         &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/base/}TransportGUID"/>
         *         &lt;element name="LivingRoomGUID" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType"/>
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
            "livingRoomGUID"
        })
        public static class LivingRoomToUpdate
            extends RoomUpdateOMSType
        {

            @XmlElement(name = "TransportGUID", namespace = "http://dom.gosuslugi.ru/schema/integration/base/", required = true)
            protected String transportGUID;
            @XmlElement(name = "LivingRoomGUID", required = true)
            protected String livingRoomGUID;

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
             * Gets the value of the livingRoomGUID property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getLivingRoomGUID() {
                return livingRoomGUID;
            }

            /**
             * Sets the value of the livingRoomGUID property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setLivingRoomGUID(String value) {
                this.livingRoomGUID = value;
            }

        }

    }

}
