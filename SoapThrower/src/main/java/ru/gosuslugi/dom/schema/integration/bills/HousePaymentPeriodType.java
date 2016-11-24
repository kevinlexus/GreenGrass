
package ru.gosuslugi.dom.schema.integration.bills;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * Характеристика расчетного периода дома
 * 
 * <p>Java class for HousePaymentPeriodType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="HousePaymentPeriodType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="HouseGuid" type="{http://dom.gosuslugi.ru/schema/integration/premises-base/}FIASHouseGUIDType"/>
 *         &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/bills/}PaymentPeriodStatus"/>
 *         &lt;element name="OpeningDate" type="{http://www.w3.org/2001/XMLSchema}date"/>
 *         &lt;element name="ClosingDate" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "HousePaymentPeriodType", propOrder = {
    "houseGuid",
    "paymentPeriodStatus",
    "openingDate",
    "closingDate"
})
public class HousePaymentPeriodType {

    @XmlElement(name = "HouseGuid", required = true)
    protected String houseGuid;
    @XmlElement(name = "PaymentPeriodStatus", required = true)
    protected String paymentPeriodStatus;
    @XmlElement(name = "OpeningDate", required = true)
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar openingDate;
    @XmlElement(name = "ClosingDate")
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar closingDate;

    /**
     * Gets the value of the houseGuid property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getHouseGuid() {
        return houseGuid;
    }

    /**
     * Sets the value of the houseGuid property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setHouseGuid(String value) {
        this.houseGuid = value;
    }

    /**
     * Gets the value of the paymentPeriodStatus property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPaymentPeriodStatus() {
        return paymentPeriodStatus;
    }

    /**
     * Sets the value of the paymentPeriodStatus property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPaymentPeriodStatus(String value) {
        this.paymentPeriodStatus = value;
    }

    /**
     * Gets the value of the openingDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getOpeningDate() {
        return openingDate;
    }

    /**
     * Sets the value of the openingDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setOpeningDate(XMLGregorianCalendar value) {
        this.openingDate = value;
    }

    /**
     * Gets the value of the closingDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getClosingDate() {
        return closingDate;
    }

    /**
     * Sets the value of the closingDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setClosingDate(XMLGregorianCalendar value) {
        this.closingDate = value;
    }

}
