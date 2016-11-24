
package ru.gosuslugi.dom.schema.integration.house_management;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import ru.gosuslugi.dom.schema.integration.base.BaseAsyncResponseType;
import ru.gosuslugi.dom.schema.integration.base.ErrorMessageType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/base/}BaseAsyncResponseType">
 *       &lt;choice minOccurs="0">
 *         &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/base/}ErrorMessage"/>
 *         &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/house-management/}ImportResult" maxOccurs="unbounded"/>
 *         &lt;element name="exportHouseResult" type="{http://dom.gosuslugi.ru/schema/integration/house-management/}exportHouseResultType"/>
 *         &lt;element name="exportMeteringDeviceDataResult" type="{http://dom.gosuslugi.ru/schema/integration/house-management/}exportMeteringDeviceDataResultType" maxOccurs="unbounded"/>
 *         &lt;element name="exportStatusCAChResult" type="{http://dom.gosuslugi.ru/schema/integration/house-management/}exportStatusCAChResultType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="exportCAChResult" type="{http://dom.gosuslugi.ru/schema/integration/house-management/}exportCAChResultType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="exportStatusPublicPropertyContractResult" type="{http://dom.gosuslugi.ru/schema/integration/house-management/}exportStatusPublicPropertyContractResultType" maxOccurs="unbounded"/>
 *         &lt;element name="exportAccountResult" type="{http://dom.gosuslugi.ru/schema/integration/house-management/}exportAccountResultType" maxOccurs="unbounded"/>
 *         &lt;element name="exportVotingProtocolResult" type="{http://dom.gosuslugi.ru/schema/integration/house-management/}exportVotingProtocolResultType" maxOccurs="unbounded"/>
 *         &lt;element name="exportSupplyResourceContractResult" type="{http://dom.gosuslugi.ru/schema/integration/house-management/}exportSupplyResourceContractResultType" maxOccurs="unbounded"/>
 *         &lt;element name="exportAccountIndividualServicesResult" type="{http://dom.gosuslugi.ru/schema/integration/house-management/}exportAccountIndividualServicesResultType" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/choice>
 *       &lt;attribute ref="{http://dom.gosuslugi.ru/schema/integration/base/}version use="required" fixed="11.0.0.1""/>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "errorMessage",
    "importResult",
    "exportHouseResult",
    "exportMeteringDeviceDataResult",
    "exportStatusCAChResult",
    "exportCAChResult",
    "exportStatusPublicPropertyContractResult",
    "exportAccountResult",
    "exportVotingProtocolResult",
    "exportSupplyResourceContractResult",
    "exportAccountIndividualServicesResult"
})
@XmlRootElement(name = "getStateResult")
public class GetStateResult
    extends BaseAsyncResponseType
{

    @XmlElement(name = "ErrorMessage", namespace = "http://dom.gosuslugi.ru/schema/integration/base/")
    protected ErrorMessageType errorMessage;
    @XmlElement(name = "ImportResult")
    protected List<ImportResult> importResult;
    protected ExportHouseResultType exportHouseResult;
    protected List<ExportMeteringDeviceDataResultType> exportMeteringDeviceDataResult;
    protected List<ExportStatusCAChResultType> exportStatusCAChResult;
    protected List<ExportCAChResultType> exportCAChResult;
    protected List<ExportStatusPublicPropertyContractResultType> exportStatusPublicPropertyContractResult;
    protected List<ExportAccountResultType> exportAccountResult;
    protected List<ExportVotingProtocolResultType> exportVotingProtocolResult;
    protected List<ExportSupplyResourceContractResultType> exportSupplyResourceContractResult;
    protected List<ExportAccountIndividualServicesResultType> exportAccountIndividualServicesResult;
    @XmlAttribute(name = "version", namespace = "http://dom.gosuslugi.ru/schema/integration/base/", required = true)
    protected String version;

    /**
     * Gets the value of the errorMessage property.
     * 
     * @return
     *     possible object is
     *     {@link ErrorMessageType }
     *     
     */
    public ErrorMessageType getErrorMessage() {
        return errorMessage;
    }

    /**
     * Sets the value of the errorMessage property.
     * 
     * @param value
     *     allowed object is
     *     {@link ErrorMessageType }
     *     
     */
    public void setErrorMessage(ErrorMessageType value) {
        this.errorMessage = value;
    }

    /**
     * Gets the value of the importResult property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the importResult property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getImportResult().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ImportResult }
     * 
     * 
     */
    public List<ImportResult> getImportResult() {
        if (importResult == null) {
            importResult = new ArrayList<ImportResult>();
        }
        return this.importResult;
    }

    /**
     * Gets the value of the exportHouseResult property.
     * 
     * @return
     *     possible object is
     *     {@link ExportHouseResultType }
     *     
     */
    public ExportHouseResultType getExportHouseResult() {
        return exportHouseResult;
    }

    /**
     * Sets the value of the exportHouseResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link ExportHouseResultType }
     *     
     */
    public void setExportHouseResult(ExportHouseResultType value) {
        this.exportHouseResult = value;
    }

    /**
     * Gets the value of the exportMeteringDeviceDataResult property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the exportMeteringDeviceDataResult property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getExportMeteringDeviceDataResult().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ExportMeteringDeviceDataResultType }
     * 
     * 
     */
    public List<ExportMeteringDeviceDataResultType> getExportMeteringDeviceDataResult() {
        if (exportMeteringDeviceDataResult == null) {
            exportMeteringDeviceDataResult = new ArrayList<ExportMeteringDeviceDataResultType>();
        }
        return this.exportMeteringDeviceDataResult;
    }

    /**
     * Gets the value of the exportStatusCAChResult property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the exportStatusCAChResult property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getExportStatusCAChResult().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ExportStatusCAChResultType }
     * 
     * 
     */
    public List<ExportStatusCAChResultType> getExportStatusCAChResult() {
        if (exportStatusCAChResult == null) {
            exportStatusCAChResult = new ArrayList<ExportStatusCAChResultType>();
        }
        return this.exportStatusCAChResult;
    }

    /**
     * Gets the value of the exportCAChResult property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the exportCAChResult property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getExportCAChResult().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ExportCAChResultType }
     * 
     * 
     */
    public List<ExportCAChResultType> getExportCAChResult() {
        if (exportCAChResult == null) {
            exportCAChResult = new ArrayList<ExportCAChResultType>();
        }
        return this.exportCAChResult;
    }

    /**
     * Gets the value of the exportStatusPublicPropertyContractResult property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the exportStatusPublicPropertyContractResult property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getExportStatusPublicPropertyContractResult().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ExportStatusPublicPropertyContractResultType }
     * 
     * 
     */
    public List<ExportStatusPublicPropertyContractResultType> getExportStatusPublicPropertyContractResult() {
        if (exportStatusPublicPropertyContractResult == null) {
            exportStatusPublicPropertyContractResult = new ArrayList<ExportStatusPublicPropertyContractResultType>();
        }
        return this.exportStatusPublicPropertyContractResult;
    }

    /**
     * Gets the value of the exportAccountResult property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the exportAccountResult property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getExportAccountResult().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ExportAccountResultType }
     * 
     * 
     */
    public List<ExportAccountResultType> getExportAccountResult() {
        if (exportAccountResult == null) {
            exportAccountResult = new ArrayList<ExportAccountResultType>();
        }
        return this.exportAccountResult;
    }

    /**
     * Gets the value of the exportVotingProtocolResult property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the exportVotingProtocolResult property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getExportVotingProtocolResult().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ExportVotingProtocolResultType }
     * 
     * 
     */
    public List<ExportVotingProtocolResultType> getExportVotingProtocolResult() {
        if (exportVotingProtocolResult == null) {
            exportVotingProtocolResult = new ArrayList<ExportVotingProtocolResultType>();
        }
        return this.exportVotingProtocolResult;
    }

    /**
     * Gets the value of the exportSupplyResourceContractResult property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the exportSupplyResourceContractResult property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getExportSupplyResourceContractResult().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ExportSupplyResourceContractResultType }
     * 
     * 
     */
    public List<ExportSupplyResourceContractResultType> getExportSupplyResourceContractResult() {
        if (exportSupplyResourceContractResult == null) {
            exportSupplyResourceContractResult = new ArrayList<ExportSupplyResourceContractResultType>();
        }
        return this.exportSupplyResourceContractResult;
    }

    /**
     * Gets the value of the exportAccountIndividualServicesResult property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the exportAccountIndividualServicesResult property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getExportAccountIndividualServicesResult().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ExportAccountIndividualServicesResultType }
     * 
     * 
     */
    public List<ExportAccountIndividualServicesResultType> getExportAccountIndividualServicesResult() {
        if (exportAccountIndividualServicesResult == null) {
            exportAccountIndividualServicesResult = new ArrayList<ExportAccountIndividualServicesResultType>();
        }
        return this.exportAccountIndividualServicesResult;
    }

    /**
     * Gets the value of the version property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVersion() {
        if (version == null) {
            return "11.0.0.1";
        } else {
            return version;
        }
    }

    /**
     * Sets the value of the version property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVersion(String value) {
        this.version = value;
    }

}
