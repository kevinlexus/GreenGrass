
package ru.gosuslugi.dom.schema.integration.house_management;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;
import ru.gosuslugi.dom.schema.integration.nsi_base.NsiRef;


/**
 * Лифт (для импорта от УО)
 * 
 * <p>Java class for LiftUOType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="LiftUOType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/house-management/}EntranceNum"/>
 *         &lt;element name="FactoryNum" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Type" type="{http://dom.gosuslugi.ru/schema/integration/nsi-base/}nsiRef"/>
 *         &lt;element name="OperatingLimit" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}integer">
 *               &lt;minInclusive value="0"/>
 *               &lt;maxInclusive value="9999"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="OGFData" type="{http://dom.gosuslugi.ru/schema/integration/house-management/}OGFData" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "LiftUOType", propOrder = {
    "entranceNum",
    "factoryNum",
    "type",
    "operatingLimit",
    "ogfData"
})
@XmlSeeAlso({
    ru.gosuslugi.dom.schema.integration.house_management.ImportHouseUORequest.ApartmentHouse.LiftToCreate.class
})
public class LiftUOType {

    @XmlElement(name = "EntranceNum", required = true)
    protected String entranceNum;
    @XmlElement(name = "FactoryNum", required = true)
    protected String factoryNum;
    @XmlElement(name = "Type", required = true)
    protected NsiRef type;
    @XmlElement(name = "OperatingLimit")
    protected Integer operatingLimit;
    @XmlElement(name = "OGFData")
    protected List<OGFData> ogfData;

    /**
     * Gets the value of the entranceNum property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEntranceNum() {
        return entranceNum;
    }

    /**
     * Sets the value of the entranceNum property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEntranceNum(String value) {
        this.entranceNum = value;
    }

    /**
     * Gets the value of the factoryNum property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFactoryNum() {
        return factoryNum;
    }

    /**
     * Sets the value of the factoryNum property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFactoryNum(String value) {
        this.factoryNum = value;
    }

    /**
     * Gets the value of the type property.
     * 
     * @return
     *     possible object is
     *     {@link NsiRef }
     *     
     */
    public NsiRef getType() {
        return type;
    }

    /**
     * Sets the value of the type property.
     * 
     * @param value
     *     allowed object is
     *     {@link NsiRef }
     *     
     */
    public void setType(NsiRef value) {
        this.type = value;
    }

    /**
     * Gets the value of the operatingLimit property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getOperatingLimit() {
        return operatingLimit;
    }

    /**
     * Sets the value of the operatingLimit property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setOperatingLimit(Integer value) {
        this.operatingLimit = value;
    }

    /**
     * Gets the value of the ogfData property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the ogfData property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getOGFData().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link OGFData }
     * 
     * 
     */
    public List<OGFData> getOGFData() {
        if (ogfData == null) {
            ogfData = new ArrayList<OGFData>();
        }
        return this.ogfData;
    }

}
