
package ru.gosuslugi.dom.schema.integration.house_management;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for GKNRelationshipStatusType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="GKNRelationshipStatusType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Status">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;length value="1"/>
 *               &lt;enumeration value="C"/>
 *               &lt;enumeration value="D"/>
 *               &lt;enumeration value="N"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;choice>
 *           &lt;element name="AppartmentHouseAcceptedParameter" type="{http://dom.gosuslugi.ru/schema/integration/house-management/}ApartmentHouseAcceptedParameterType" maxOccurs="unbounded" minOccurs="0"/>
 *           &lt;element name="LivingHouseAcceptedParameter" type="{http://dom.gosuslugi.ru/schema/integration/house-management/}LivingHouseAcceptedParameterType" maxOccurs="unbounded" minOccurs="0"/>
 *           &lt;element name="NonResidentialPremiseAcceptedParameter" type="{http://dom.gosuslugi.ru/schema/integration/house-management/}NonResidentialPremiseAcceptedParameterType" maxOccurs="unbounded" minOccurs="0"/>
 *           &lt;element name="ResidentialPremiseAcceptedParameter" type="{http://dom.gosuslugi.ru/schema/integration/house-management/}ResidentialPremiseAcceptedParameterType" maxOccurs="unbounded" minOccurs="0"/>
 *           &lt;element name="RoomAcceptedParameter" type="{http://dom.gosuslugi.ru/schema/integration/house-management/}RoomAcceptedParameterType" maxOccurs="unbounded" minOccurs="0"/>
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
@XmlType(name = "GKNRelationshipStatusType", propOrder = {
    "status",
    "appartmentHouseAcceptedParameter",
    "livingHouseAcceptedParameter",
    "nonResidentialPremiseAcceptedParameter",
    "residentialPremiseAcceptedParameter",
    "roomAcceptedParameter"
})
@XmlSeeAlso({
    ru.gosuslugi.dom.schema.integration.house_management.OGFImportStatusType.GKNRelationshipStatus.class
})
public class GKNRelationshipStatusType {

    @XmlElement(name = "Status", required = true)
    protected String status;
    @XmlElement(name = "AppartmentHouseAcceptedParameter")
    @XmlSchemaType(name = "string")
    protected List<ApartmentHouseAcceptedParameterType> appartmentHouseAcceptedParameter;
    @XmlElement(name = "LivingHouseAcceptedParameter")
    @XmlSchemaType(name = "string")
    protected List<LivingHouseAcceptedParameterType> livingHouseAcceptedParameter;
    @XmlElement(name = "NonResidentialPremiseAcceptedParameter")
    @XmlSchemaType(name = "string")
    protected List<NonResidentialPremiseAcceptedParameterType> nonResidentialPremiseAcceptedParameter;
    @XmlElement(name = "ResidentialPremiseAcceptedParameter")
    @XmlSchemaType(name = "string")
    protected List<ResidentialPremiseAcceptedParameterType> residentialPremiseAcceptedParameter;
    @XmlElement(name = "RoomAcceptedParameter")
    @XmlSchemaType(name = "string")
    protected List<RoomAcceptedParameterType> roomAcceptedParameter;

    /**
     * Gets the value of the status property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStatus() {
        return status;
    }

    /**
     * Sets the value of the status property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStatus(String value) {
        this.status = value;
    }

    /**
     * Gets the value of the appartmentHouseAcceptedParameter property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the appartmentHouseAcceptedParameter property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAppartmentHouseAcceptedParameter().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ApartmentHouseAcceptedParameterType }
     * 
     * 
     */
    public List<ApartmentHouseAcceptedParameterType> getAppartmentHouseAcceptedParameter() {
        if (appartmentHouseAcceptedParameter == null) {
            appartmentHouseAcceptedParameter = new ArrayList<ApartmentHouseAcceptedParameterType>();
        }
        return this.appartmentHouseAcceptedParameter;
    }

    /**
     * Gets the value of the livingHouseAcceptedParameter property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the livingHouseAcceptedParameter property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getLivingHouseAcceptedParameter().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link LivingHouseAcceptedParameterType }
     * 
     * 
     */
    public List<LivingHouseAcceptedParameterType> getLivingHouseAcceptedParameter() {
        if (livingHouseAcceptedParameter == null) {
            livingHouseAcceptedParameter = new ArrayList<LivingHouseAcceptedParameterType>();
        }
        return this.livingHouseAcceptedParameter;
    }

    /**
     * Gets the value of the nonResidentialPremiseAcceptedParameter property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the nonResidentialPremiseAcceptedParameter property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getNonResidentialPremiseAcceptedParameter().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link NonResidentialPremiseAcceptedParameterType }
     * 
     * 
     */
    public List<NonResidentialPremiseAcceptedParameterType> getNonResidentialPremiseAcceptedParameter() {
        if (nonResidentialPremiseAcceptedParameter == null) {
            nonResidentialPremiseAcceptedParameter = new ArrayList<NonResidentialPremiseAcceptedParameterType>();
        }
        return this.nonResidentialPremiseAcceptedParameter;
    }

    /**
     * Gets the value of the residentialPremiseAcceptedParameter property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the residentialPremiseAcceptedParameter property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getResidentialPremiseAcceptedParameter().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ResidentialPremiseAcceptedParameterType }
     * 
     * 
     */
    public List<ResidentialPremiseAcceptedParameterType> getResidentialPremiseAcceptedParameter() {
        if (residentialPremiseAcceptedParameter == null) {
            residentialPremiseAcceptedParameter = new ArrayList<ResidentialPremiseAcceptedParameterType>();
        }
        return this.residentialPremiseAcceptedParameter;
    }

    /**
     * Gets the value of the roomAcceptedParameter property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the roomAcceptedParameter property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getRoomAcceptedParameter().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link RoomAcceptedParameterType }
     * 
     * 
     */
    public List<RoomAcceptedParameterType> getRoomAcceptedParameter() {
        if (roomAcceptedParameter == null) {
            roomAcceptedParameter = new ArrayList<RoomAcceptedParameterType>();
        }
        return this.roomAcceptedParameter;
    }

}
