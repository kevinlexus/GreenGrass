
package ru.gosuslugi.dom.schema.integration.bills;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;
import ru.gosuslugi.dom.schema.integration.base.AttachmentType;


/**
 * Страховой продукт
 * 
 * <p>Java class for InsuranceProductType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="InsuranceProductType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Description" type="{http://dom.gosuslugi.ru/schema/integration/base/}AttachmentType"/>
 *         &lt;element name="InsuranceOrg">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="50"/>
 *               &lt;minLength value="1"/>
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
@XmlType(name = "InsuranceProductType", propOrder = {
    "description",
    "insuranceOrg"
})
@XmlSeeAlso({
    ru.gosuslugi.dom.schema.integration.bills.ImportInsuranceProductRequest.InsuranceProduct.CreateOrUpdate.class
})
public class InsuranceProductType {

    @XmlElement(name = "Description", required = true)
    protected AttachmentType description;
    @XmlElement(name = "InsuranceOrg", required = true)
    protected String insuranceOrg;

    /**
     * Gets the value of the description property.
     * 
     * @return
     *     possible object is
     *     {@link AttachmentType }
     *     
     */
    public AttachmentType getDescription() {
        return description;
    }

    /**
     * Sets the value of the description property.
     * 
     * @param value
     *     allowed object is
     *     {@link AttachmentType }
     *     
     */
    public void setDescription(AttachmentType value) {
        this.description = value;
    }

    /**
     * Gets the value of the insuranceOrg property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getInsuranceOrg() {
        return insuranceOrg;
    }

    /**
     * Sets the value of the insuranceOrg property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setInsuranceOrg(String value) {
        this.insuranceOrg = value;
    }

}
