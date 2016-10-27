
package ru.gosuslugi.dom.schema.integration.house_management;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;
import ru.gosuslugi.dom.schema.integration.nsi_base.NsiRef;


/**
 * <p>Java class for ContractServiceType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ContractServiceType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ServiceType" type="{http://dom.gosuslugi.ru/schema/integration/nsi-base/}nsiRef"/>
 *         &lt;element name="StartDate" type="{http://www.w3.org/2001/XMLSchema}date"/>
 *         &lt;element name="EndDate" type="{http://www.w3.org/2001/XMLSchema}date"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ContractServiceType", propOrder = {
    "serviceType",
    "startDate",
    "endDate"
})
@XmlSeeAlso({
    ru.gosuslugi.dom.schema.integration.house_management.ExportCAChResultType.Contract.ContractObject.HouseService.class,
    ru.gosuslugi.dom.schema.integration.house_management.ExportCAChResultType.Contract.ContractObject.AddService.class,
    ru.gosuslugi.dom.schema.integration.house_management.ExportCAChResultType.Charter.ContractObject.HouseService.class,
    ru.gosuslugi.dom.schema.integration.house_management.ExportCAChResultType.Charter.ContractObject.AddService.class,
    ru.gosuslugi.dom.schema.integration.house_management.ImportCharterRequest.PlacingCharter.ContractObject.HouseService.class,
    ru.gosuslugi.dom.schema.integration.house_management.ImportCharterRequest.PlacingCharter.ContractObject.AddService.class,
    ru.gosuslugi.dom.schema.integration.house_management.ImportCharterRequest.EditCharter.ContractObject.Add.HouseService.class,
    ru.gosuslugi.dom.schema.integration.house_management.ImportCharterRequest.EditCharter.ContractObject.Add.AddService.class,
    ru.gosuslugi.dom.schema.integration.house_management.ImportCharterRequest.EditCharter.ContractObject.Edit.HouseService.class,
    ru.gosuslugi.dom.schema.integration.house_management.ImportCharterRequest.EditCharter.ContractObject.Edit.AddService.class,
    ru.gosuslugi.dom.schema.integration.house_management.ImportContractRequest.Contract.PlacingContract.ContractObject.HouseService.class,
    ru.gosuslugi.dom.schema.integration.house_management.ImportContractRequest.Contract.PlacingContract.ContractObject.AddService.class,
    ru.gosuslugi.dom.schema.integration.house_management.ImportContractRequest.Contract.EditContract.ContractObject.Add.HouseService.class,
    ru.gosuslugi.dom.schema.integration.house_management.ImportContractRequest.Contract.EditContract.ContractObject.Add.AddService.class,
    ru.gosuslugi.dom.schema.integration.house_management.ImportContractRequest.Contract.EditContract.ContractObject.Edit.HouseService.class,
    ru.gosuslugi.dom.schema.integration.house_management.ImportContractRequest.Contract.EditContract.ContractObject.Edit.AddService.class
})
public class ContractServiceType {

    @XmlElement(name = "ServiceType", required = true)
    protected NsiRef serviceType;
    @XmlElement(name = "StartDate", required = true)
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar startDate;
    @XmlElement(name = "EndDate", required = true)
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar endDate;

    /**
     * Gets the value of the serviceType property.
     * 
     * @return
     *     possible object is
     *     {@link NsiRef }
     *     
     */
    public NsiRef getServiceType() {
        return serviceType;
    }

    /**
     * Sets the value of the serviceType property.
     * 
     * @param value
     *     allowed object is
     *     {@link NsiRef }
     *     
     */
    public void setServiceType(NsiRef value) {
        this.serviceType = value;
    }

    /**
     * Gets the value of the startDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getStartDate() {
        return startDate;
    }

    /**
     * Sets the value of the startDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setStartDate(XMLGregorianCalendar value) {
        this.startDate = value;
    }

    /**
     * Gets the value of the endDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getEndDate() {
        return endDate;
    }

    /**
     * Sets the value of the endDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setEndDate(XMLGregorianCalendar value) {
        this.endDate = value;
    }

}
