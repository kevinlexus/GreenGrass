
package ru.gosuslugi.dom.schema.integration.house_management;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import ru.gosuslugi.dom.schema.integration.base.AttachmentType;


/**
 * <p>Java class for BaseServiceType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="BaseServiceType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;choice>
 *         &lt;element name="CurrentDoc" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="Agreement" type="{http://dom.gosuslugi.ru/schema/integration/base/}AttachmentType"/>
 *       &lt;/choice>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "BaseServiceType", propOrder = {
    "currentDoc",
    "agreement"
})
public class BaseServiceType {

    @XmlElement(name = "CurrentDoc")
    protected Boolean currentDoc;
    @XmlElement(name = "Agreement")
    protected AttachmentType agreement;

    /**
     * Gets the value of the currentDoc property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isCurrentDoc() {
        return currentDoc;
    }

    /**
     * Sets the value of the currentDoc property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setCurrentDoc(Boolean value) {
        this.currentDoc = value;
    }

    /**
     * Gets the value of the agreement property.
     * 
     * @return
     *     possible object is
     *     {@link AttachmentType }
     *     
     */
    public AttachmentType getAgreement() {
        return agreement;
    }

    /**
     * Sets the value of the agreement property.
     * 
     * @param value
     *     allowed object is
     *     {@link AttachmentType }
     *     
     */
    public void setAgreement(AttachmentType value) {
        this.agreement = value;
    }

}
