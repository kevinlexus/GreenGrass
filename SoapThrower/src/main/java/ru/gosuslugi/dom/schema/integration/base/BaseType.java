
package ru.gosuslugi.dom.schema.integration.base;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;
import org.w3._2000._09.xmldsig_.SignatureType;
import ru.gosuslugi.dom.schema.integration.house_management.ExportAccountRequest;
import ru.gosuslugi.dom.schema.integration.house_management.ExportAccountResult;
import ru.gosuslugi.dom.schema.integration.house_management.ExportCAChAsyncRequest;
import ru.gosuslugi.dom.schema.integration.house_management.ExportCAChRequest;
import ru.gosuslugi.dom.schema.integration.house_management.ExportCAChResult;
import ru.gosuslugi.dom.schema.integration.house_management.ExportHouseRequest;
import ru.gosuslugi.dom.schema.integration.house_management.ExportHouseResult;
import ru.gosuslugi.dom.schema.integration.house_management.ExportMeteringDeviceDataRequest;
import ru.gosuslugi.dom.schema.integration.house_management.ExportMeteringDeviceDataResult;
import ru.gosuslugi.dom.schema.integration.house_management.ExportStatusCAChRequest;
import ru.gosuslugi.dom.schema.integration.house_management.ExportStatusCAChResult;
import ru.gosuslugi.dom.schema.integration.house_management.ExportStatusPublicPropertyContractRequest;
import ru.gosuslugi.dom.schema.integration.house_management.ExportStatusPublicPropertyContractResult;
import ru.gosuslugi.dom.schema.integration.house_management.ExportSupplyResourceContractRequest;
import ru.gosuslugi.dom.schema.integration.house_management.ExportSupplyResourceContractResult;
import ru.gosuslugi.dom.schema.integration.house_management.ExportVotingProtocolRequest;
import ru.gosuslugi.dom.schema.integration.house_management.ExportVotingProtocolResult;
import ru.gosuslugi.dom.schema.integration.house_management.ImportAccountRequest;
import ru.gosuslugi.dom.schema.integration.house_management.ImportCharterRequest;
import ru.gosuslugi.dom.schema.integration.house_management.ImportContractRequest;
import ru.gosuslugi.dom.schema.integration.house_management.ImportHouseOMSRequest;
import ru.gosuslugi.dom.schema.integration.house_management.ImportHouseRSORequest;
import ru.gosuslugi.dom.schema.integration.house_management.ImportHouseUORequest;
import ru.gosuslugi.dom.schema.integration.house_management.ImportMeteringDeviceDataRequest;
import ru.gosuslugi.dom.schema.integration.house_management.ImportNotificationRequest;
import ru.gosuslugi.dom.schema.integration.house_management.ImportPublicPropertyContractRequest;
import ru.gosuslugi.dom.schema.integration.house_management.ImportSupplyResourceContractRequest;
import ru.gosuslugi.dom.schema.integration.house_management.ImportVotingProtocolRequest;


/**
 * Базовый тип бизнес-сообщения с подписью
 * 
 * <p>Java class for BaseType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="BaseType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{http://www.w3.org/2000/09/xmldsig#}Signature" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="Id" type="{http://www.w3.org/2001/XMLSchema}anySimpleType" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "BaseType", propOrder = {
    "signature"
})
@XmlSeeAlso({
    ru.gosuslugi.dom.schema.integration.base.ImportResult.class,
    ImportContractRequest.class,
    ExportAccountResult.class,
    ImportVotingProtocolRequest.class,
    ImportSupplyResourceContractRequest.class,
    ExportMeteringDeviceDataRequest.class,
    ExportCAChAsyncRequest.class,
    ExportMeteringDeviceDataResult.class,
    ImportHouseUORequest.class,
    ExportVotingProtocolRequest.class,
    ExportVotingProtocolResult.class,
    ExportStatusCAChResult.class,
    ImportCharterRequest.class,
    ExportHouseRequest.class,
    ExportStatusPublicPropertyContractResult.class,
    ExportCAChResult.class,
    ExportSupplyResourceContractResult.class,
    ExportStatusPublicPropertyContractRequest.class,
    ExportCAChRequest.class,
    ImportPublicPropertyContractRequest.class,
    ExportStatusCAChRequest.class,
    ImportNotificationRequest.class,
    ImportMeteringDeviceDataRequest.class,
    ImportHouseOMSRequest.class,
    ImportAccountRequest.class,
    ImportHouseRSORequest.class,
    ExportHouseResult.class,
    ExportSupplyResourceContractRequest.class,
    ExportAccountRequest.class,
    ru.gosuslugi.dom.schema.integration.house_management.ImportResult.class,
    BaseAsyncResponseType.class
})
public class BaseType {

    @XmlElement(name = "Signature", namespace = "http://www.w3.org/2000/09/xmldsig#")
    protected SignatureType signature;
    @XmlAttribute(name = "Id")
    @XmlSchemaType(name = "anySimpleType")
    protected String id;

    /**
     * Gets the value of the signature property.
     * 
     * @return
     *     possible object is
     *     {@link SignatureType }
     *     
     */
    public SignatureType getSignature() {
        return signature;
    }

    /**
     * Sets the value of the signature property.
     * 
     * @param value
     *     allowed object is
     *     {@link SignatureType }
     *     
     */
    public void setSignature(SignatureType value) {
        this.signature = value;
    }

    /**
     * Gets the value of the id property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getId() {
        return id;
    }

    /**
     * Sets the value of the id property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setId(String value) {
        this.id = value;
    }

}
