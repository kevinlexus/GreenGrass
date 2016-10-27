
package ru.gosuslugi.dom.schema.integration.house_management;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * Аннулирование сведений
 * 
 * <p>Java class for AnnulmentType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="AnnulmentType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ReasonOfAnnulment">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="1000"/>
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
@XmlType(name = "AnnulmentType", propOrder = {
    "reasonOfAnnulment"
})
@XmlSeeAlso({
    ru.gosuslugi.dom.schema.integration.house_management.ImportCharterRequest.AnnulmentCharter.class,
    ru.gosuslugi.dom.schema.integration.house_management.ImportContractRequest.Contract.AnnulmentContract.class,
    ru.gosuslugi.dom.schema.integration.house_management.PublicPropertyContractType.AgreementPayment.AnnulAgreementPayment.class
})
public class AnnulmentType {

    @XmlElement(name = "ReasonOfAnnulment", required = true)
    protected String reasonOfAnnulment;

    /**
     * Gets the value of the reasonOfAnnulment property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getReasonOfAnnulment() {
        return reasonOfAnnulment;
    }

    /**
     * Sets the value of the reasonOfAnnulment property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setReasonOfAnnulment(String value) {
        this.reasonOfAnnulment = value;
    }

}
