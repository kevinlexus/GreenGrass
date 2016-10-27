
package ru.gosuslugi.dom.schema.integration.house_management;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for exportVotingProtocolResultType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="exportVotingProtocolResultType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/house-management/}ProtocolType">
 *       &lt;sequence>
 *         &lt;element name="StatusProtocol">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;enumeration value="Created"/>
 *               &lt;enumeration value="Posted"/>
 *               &lt;enumeration value="Edited"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="VotingProtocolGUID" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType" maxOccurs="100"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "exportVotingProtocolResultType", propOrder = {
    "statusProtocol",
    "votingProtocolGUID"
})
@XmlSeeAlso({
    ru.gosuslugi.dom.schema.integration.house_management.ExportVotingProtocolResult.VotingProtocol.class
})
public class ExportVotingProtocolResultType
    extends ProtocolType
{

    @XmlElement(name = "StatusProtocol", required = true)
    protected String statusProtocol;
    @XmlElement(name = "VotingProtocolGUID", required = true)
    protected List<String> votingProtocolGUID;

    /**
     * Gets the value of the statusProtocol property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStatusProtocol() {
        return statusProtocol;
    }

    /**
     * Sets the value of the statusProtocol property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStatusProtocol(String value) {
        this.statusProtocol = value;
    }

    /**
     * Gets the value of the votingProtocolGUID property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the votingProtocolGUID property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getVotingProtocolGUID().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getVotingProtocolGUID() {
        if (votingProtocolGUID == null) {
            votingProtocolGUID = new ArrayList<String>();
        }
        return this.votingProtocolGUID;
    }

}
