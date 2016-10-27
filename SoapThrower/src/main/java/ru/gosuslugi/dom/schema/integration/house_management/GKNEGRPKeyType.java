
package ru.gosuslugi.dom.schema.integration.house_management;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * —‚Â‰ÂÌËˇ ËÁ √ Õ ‰Îˇ ”Œ Ë ŒÃ—
 * 
 * <p>Java class for GKN_EGRP_KeyType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="GKN_EGRP_KeyType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;choice>
 *         &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/house-management/}CadastralNumber"/>
 *         &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/house-management/}No_RSO_GKN_EGRP_Registered"/>
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
@XmlType(name = "GKN_EGRP_KeyType", propOrder = {
    "cadastralNumber",
    "noRSOGKNEGRPRegistered",
    "conditionalNumber",
    "rightOrEncumbrance"
})
@XmlSeeAlso({
    BlockUpdateUOType.class,
    PremisesBasicUpdateOMSType.class,
    RoomUpdateOMSType.class,
    RoomOMSType.class,
    PremisesBasicOMSType.class,
    RoomUpdateUOType.class,
    HouseBasicUpdateUOType.class,
    PremisesBasicUpdateUOType.class,
    PremisesBasicUOType.class,
    BlockUpdateOMSType.class,
    RoomUOType.class,
    ru.gosuslugi.dom.schema.integration.house_management.ApartmentHouseOMSType.BasicCharacteristicts.class,
    HouseBasicUpdateOMSType.class,
    BlockUOType.class,
    BlockOMSType.class,
    RoomExportType.class,
    ru.gosuslugi.dom.schema.integration.house_management.LivingHouseOMSType.BasicCharacteristicts.class,
    HouseBasicUOType.class
})
public class GKNEGRPKeyType {

    @XmlElement(name = "CadastralNumber")
    protected String cadastralNumber;
    @XmlElement(name = "No_RSO_GKN_EGRP_Registered")
    protected Boolean noRSOGKNEGRPRegistered;
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
