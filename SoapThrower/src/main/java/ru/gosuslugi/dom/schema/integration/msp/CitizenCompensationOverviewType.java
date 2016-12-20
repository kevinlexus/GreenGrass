
package ru.gosuslugi.dom.schema.integration.msp;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


/**
 * Общие сведения о гражданине, получающем компенсации расходов
 * 
 * <p>Java class for CitizenCompensationOverviewType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="CitizenCompensationOverviewType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/msp/}MSPIndType">
 *       &lt;sequence>
 *         &lt;element name="Address" type="{http://dom.gosuslugi.ru/schema/integration/premises-base/}FIASHouseGUIDType"/>
 *         &lt;element name="ApartmentNumber" type="{http://dom.gosuslugi.ru/schema/integration/msp/}String36Type" minOccurs="0"/>
 *         &lt;element name="FlatNumber" type="{http://dom.gosuslugi.ru/schema/integration/msp/}String36Type" minOccurs="0"/>
 *         &lt;element name="RegistrationType">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}token">
 *               &lt;enumeration value="Permanent"/>
 *               &lt;enumeration value="Temporary"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="Category" type="{http://dom.gosuslugi.ru/schema/integration/msp/}CitizenCompensationCategoryType" maxOccurs="1000" minOccurs="0"/>
 *         &lt;element name="Decision" type="{http://dom.gosuslugi.ru/schema/integration/msp/}DecisionType" maxOccurs="1000" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CitizenCompensationOverviewType", propOrder = {
    "address",
    "apartmentNumber",
    "flatNumber",
    "registrationType",
    "category",
    "decision"
})
@XmlSeeAlso({
    ru.gosuslugi.dom.schema.integration.msp.ExportCitizenCompensationType.Overview.class
})
public class CitizenCompensationOverviewType
    extends MSPIndType
{

    @XmlElement(name = "Address", required = true)
    protected String address;
    @XmlElement(name = "ApartmentNumber")
    protected String apartmentNumber;
    @XmlElement(name = "FlatNumber")
    protected String flatNumber;
    @XmlElement(name = "RegistrationType", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String registrationType;
    @XmlElement(name = "Category")
    protected List<CitizenCompensationCategoryType> category;
    @XmlElement(name = "Decision")
    protected List<DecisionType> decision;

    /**
     * Gets the value of the address property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAddress() {
        return address;
    }

    /**
     * Sets the value of the address property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAddress(String value) {
        this.address = value;
    }

    /**
     * Gets the value of the apartmentNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getApartmentNumber() {
        return apartmentNumber;
    }

    /**
     * Sets the value of the apartmentNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setApartmentNumber(String value) {
        this.apartmentNumber = value;
    }

    /**
     * Gets the value of the flatNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFlatNumber() {
        return flatNumber;
    }

    /**
     * Sets the value of the flatNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFlatNumber(String value) {
        this.flatNumber = value;
    }

    /**
     * Gets the value of the registrationType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRegistrationType() {
        return registrationType;
    }

    /**
     * Sets the value of the registrationType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRegistrationType(String value) {
        this.registrationType = value;
    }

    /**
     * Gets the value of the category property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the category property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCategory().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CitizenCompensationCategoryType }
     * 
     * 
     */
    public List<CitizenCompensationCategoryType> getCategory() {
        if (category == null) {
            category = new ArrayList<CitizenCompensationCategoryType>();
        }
        return this.category;
    }

    /**
     * Gets the value of the decision property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the decision property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDecision().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link DecisionType }
     * 
     * 
     */
    public List<DecisionType> getDecision() {
        if (decision == null) {
            decision = new ArrayList<DecisionType>();
        }
        return this.decision;
    }

}
