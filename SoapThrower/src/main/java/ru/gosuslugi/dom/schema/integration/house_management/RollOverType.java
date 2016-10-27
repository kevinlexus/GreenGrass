
package ru.gosuslugi.dom.schema.integration.house_management;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for RollOverType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="RollOverType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="RollOver" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RollOverType", propOrder = {
    "rollOver"
})
@XmlSeeAlso({
    ru.gosuslugi.dom.schema.integration.house_management.ImportCharterRequest.RollOverCharter.class,
    ru.gosuslugi.dom.schema.integration.house_management.ImportContractRequest.Contract.RollOverContract.class
})
public class RollOverType {

    @XmlElement(name = "RollOver")
    protected boolean rollOver;

    /**
     * Gets the value of the rollOver property.
     * 
     */
    public boolean isRollOver() {
        return rollOver;
    }

    /**
     * Sets the value of the rollOver property.
     * 
     */
    public void setRollOver(boolean value) {
        this.rollOver = value;
    }

}
