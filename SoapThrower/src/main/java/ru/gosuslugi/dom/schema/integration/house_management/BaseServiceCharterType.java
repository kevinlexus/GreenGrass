
package ru.gosuslugi.dom.schema.integration.house_management;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import ru.gosuslugi.dom.schema.integration.base.AttachmentType;


/**
 * <p>Java class for BaseServiceCharterType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="BaseServiceCharterType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;choice>
 *         &lt;element name="CurrentCharter" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="ProtocolMeetingOwners" type="{http://dom.gosuslugi.ru/schema/integration/base/}AttachmentType"/>
 *       &lt;/choice>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "BaseServiceCharterType", propOrder = {
    "currentCharter",
    "protocolMeetingOwners"
})
public class BaseServiceCharterType {

    @XmlElement(name = "CurrentCharter")
    protected Boolean currentCharter;
    @XmlElement(name = "ProtocolMeetingOwners")
    protected AttachmentType protocolMeetingOwners;

    /**
     * Gets the value of the currentCharter property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isCurrentCharter() {
        return currentCharter;
    }

    /**
     * Sets the value of the currentCharter property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setCurrentCharter(Boolean value) {
        this.currentCharter = value;
    }

    /**
     * Gets the value of the protocolMeetingOwners property.
     * 
     * @return
     *     possible object is
     *     {@link AttachmentType }
     *     
     */
    public AttachmentType getProtocolMeetingOwners() {
        return protocolMeetingOwners;
    }

    /**
     * Sets the value of the protocolMeetingOwners property.
     * 
     * @param value
     *     allowed object is
     *     {@link AttachmentType }
     *     
     */
    public void setProtocolMeetingOwners(AttachmentType value) {
        this.protocolMeetingOwners = value;
    }

}
