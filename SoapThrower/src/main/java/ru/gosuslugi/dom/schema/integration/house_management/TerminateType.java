
package ru.gosuslugi.dom.schema.integration.house_management;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for TerminateType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="TerminateType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Terminate" type="{http://www.w3.org/2001/XMLSchema}date"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TerminateType", propOrder = {
    "terminate"
})
@XmlSeeAlso({
    ru.gosuslugi.dom.schema.integration.house_management.ExportCAChResultType.Contract.Terminate.class,
    ru.gosuslugi.dom.schema.integration.house_management.ExportCAChResultType.Charter.Terminate.class,
    ru.gosuslugi.dom.schema.integration.house_management.ExportSupplyResourceContractResultType.TerminateContract.class,
    ru.gosuslugi.dom.schema.integration.house_management.ImportCharterRequest.TerminateCharter.class,
    ru.gosuslugi.dom.schema.integration.house_management.ImportSupplyResourceContractRequest.Contract.TerminateContract.class,
    ru.gosuslugi.dom.schema.integration.house_management.ImportContractRequest.Contract.TerminateContract.class
})
public class TerminateType {

    @XmlElement(name = "Terminate", required = true)
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar terminate;

    /**
     * Gets the value of the terminate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getTerminate() {
        return terminate;
    }

    /**
     * Sets the value of the terminate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setTerminate(XMLGregorianCalendar value) {
        this.terminate = value;
    }

}
