
package ru.gosuslugi.dom.schema.integration.house_management;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for VoitingType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="VoitingType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="VotingPlace">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="200"/>
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
@XmlType(name = "VoitingType", propOrder = {
    "votingPlace"
})
@XmlSeeAlso({
    ru.gosuslugi.dom.schema.integration.house_management.ProtocolType.Meeting.class
})
public class VoitingType {

    @XmlElement(name = "VotingPlace", required = true)
    protected String votingPlace;

    /**
     * Gets the value of the votingPlace property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVotingPlace() {
        return votingPlace;
    }

    /**
     * Sets the value of the votingPlace property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVotingPlace(String value) {
        this.votingPlace = value;
    }

}
