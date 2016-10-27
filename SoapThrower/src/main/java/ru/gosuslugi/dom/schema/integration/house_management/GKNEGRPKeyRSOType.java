
package ru.gosuslugi.dom.schema.integration.house_management;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * Сведения из ГКН для РСО
 * 
 * <p>Java class for GKN_EGRP_KeyRSOType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="GKN_EGRP_KeyRSOType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;choice>
 *         &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/house-management/}CadastralNumber"/>
 *         &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/house-management/}No_RSO_GKN_EGRP_Registered"/>
 *         &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/house-management/}No_RSO_GKN_EGRP_Data"/>
 *         &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/house-management/}ConditionalNumber"/>
 *         &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/house-management/}RightOrEncumbrance" maxOccurs="unbounded"/>
 *       &lt;/choice>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GKN_EGRP_KeyRSOType", propOrder = {
    "cadastralNumber",
    "noRSOGKNEGRPRegistered",
    "noRSOGKNEGRPData",
    "conditionalNumber",
    "rightOrEncumbrance"
})
@XmlSeeAlso({
    BlockUpdateRSOType.class,
    HouseBasicUpdateRSOType.class,
    RoomUpdateRSOType.class,
    HouseBasicRSOType.class,
    RoomRSOType.class,
    PremisesBasicRSOType.class,
    BlockRSOType.class,
    PremisesBasicUpdateRSOType.class
})
public class GKNEGRPKeyRSOType {

    @XmlElement(name = "CadastralNumber")
    protected String cadastralNumber;
    @XmlElement(name = "No_RSO_GKN_EGRP_Registered")
    protected Boolean noRSOGKNEGRPRegistered;
    @XmlElement(name = "No_RSO_GKN_EGRP_Data")
    protected Boolean noRSOGKNEGRPData;
    @XmlElement(name = "ConditionalNumber")
    protected String conditionalNumber;
    @XmlElement(name = "RightOrEncumbrance")
    protected List<RightOrEncumbrance> rightOrEncumbrance;

    /**
     * Gets the value of the cadastralNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCadastralNumber() {
        return cadastralNumber;
    }

    /**
     * Sets the value of the cadastralNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCadastralNumber(String value) {
        this.cadastralNumber = value;
    }

    /**
     * Gets the value of the noRSOGKNEGRPRegistered property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isNoRSOGKNEGRPRegistered() {
        return noRSOGKNEGRPRegistered;
    }

    /**
     * Sets the value of the noRSOGKNEGRPRegistered property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setNoRSOGKNEGRPRegistered(Boolean value) {
        this.noRSOGKNEGRPRegistered = value;
    }

    /**
     * Gets the value of the noRSOGKNEGRPData property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isNoRSOGKNEGRPData() {
        return noRSOGKNEGRPData;
    }

    /**
     * Sets the value of the noRSOGKNEGRPData property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setNoRSOGKNEGRPData(Boolean value) {
        this.noRSOGKNEGRPData = value;
    }

    /**
     * Gets the value of the conditionalNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getConditionalNumber() {
        return conditionalNumber;
    }

    /**
     * Sets the value of the conditionalNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setConditionalNumber(String value) {
        this.conditionalNumber = value;
    }

    /**
     * Gets the value of the rightOrEncumbrance property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the rightOrEncumbrance property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getRightOrEncumbrance().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link RightOrEncumbrance }
     * 
     * 
     */
    public List<RightOrEncumbrance> getRightOrEncumbrance() {
        if (rightOrEncumbrance == null) {
            rightOrEncumbrance = new ArrayList<RightOrEncumbrance>();
        }
        return this.rightOrEncumbrance;
    }

}
