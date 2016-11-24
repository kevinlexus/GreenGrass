
package ru.gosuslugi.dom.schema.integration.capital_repair;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;
import ru.gosuslugi.dom.schema.integration.nsi_base.NsiRef;


/**
 * Прикладной идентификатор работы в КПР
 * 
 * <p>Java class for WorkPlanIdentityType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="WorkPlanIdentityType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ApartmentBilding" type="{http://dom.gosuslugi.ru/schema/integration/premises-base/}FIASHouseGUIDType"/>
 *         &lt;element name="WorkKind" type="{http://dom.gosuslugi.ru/schema/integration/nsi-base/}nsiRef"/>
 *         &lt;element name="EndMonthYear" type="{http://www.w3.org/2001/XMLSchema}gYearMonth"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "WorkPlanIdentityType", propOrder = {
    "apartmentBilding",
    "workKind",
    "endMonthYear"
})
@XmlSeeAlso({
    WorkPlanType.class
})
public class WorkPlanIdentityType {

    @XmlElement(name = "ApartmentBilding", required = true)
    protected String apartmentBilding;
    @XmlElement(name = "WorkKind", required = true)
    protected NsiRef workKind;
    @XmlElement(name = "EndMonthYear", required = true)
    @XmlSchemaType(name = "gYearMonth")
    protected XMLGregorianCalendar endMonthYear;

    /**
     * Gets the value of the apartmentBilding property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getApartmentBilding() {
        return apartmentBilding;
    }

    /**
     * Sets the value of the apartmentBilding property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setApartmentBilding(String value) {
        this.apartmentBilding = value;
    }

    /**
     * Gets the value of the workKind property.
     * 
     * @return
     *     possible object is
     *     {@link NsiRef }
     *     
     */
    public NsiRef getWorkKind() {
        return workKind;
    }

    /**
     * Sets the value of the workKind property.
     * 
     * @param value
     *     allowed object is
     *     {@link NsiRef }
     *     
     */
    public void setWorkKind(NsiRef value) {
        this.workKind = value;
    }

    /**
     * Gets the value of the endMonthYear property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getEndMonthYear() {
        return endMonthYear;
    }

    /**
     * Sets the value of the endMonthYear property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setEndMonthYear(XMLGregorianCalendar value) {
        this.endMonthYear = value;
    }

}
