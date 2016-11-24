
package ru.gosuslugi.dom.schema.integration.bills;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import ru.gosuslugi.dom.schema.integration.base.BaseAsyncResponseType;
import ru.gosuslugi.dom.schema.integration.base.CommonResultType;
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
 *         &lt;element name="ImportResult" type="{http://dom.gosuslugi.ru/schema/integration/base/}CommonResultType" maxOccurs="unbounded"/>
 *         &lt;element name="exportOrgPeriodResult" type="{http://dom.gosuslugi.ru/schema/integration/bills/}exportOrgPeriodResultType" maxOccurs="unbounded"/>
 *         &lt;element name="exportPaymentDocResult" type="{http://dom.gosuslugi.ru/schema/integration/bills/}exportPaymentDocumentResultType" maxOccurs="unbounded"/>
 *         &lt;element name="exportNotificationsOfOrderExecutionResult" type="{http://dom.gosuslugi.ru/schema/integration/bills/}exportNotificationsOfOrderExecutionResultType" maxOccurs="unbounded"/>
 *         &lt;element name="InsuranceProduct" type="{http://dom.gosuslugi.ru/schema/integration/bills/}InsuranceProductType" maxOccurs="unbounded"/>
 *         &lt;element name="Settlement" type="{http://dom.gosuslugi.ru/schema/integration/bills/}ExportSettlementResultType" maxOccurs="unbounded"/>
 *       &lt;/choice>
 *       &lt;attribute ref="{http://dom.gosuslugi.ru/schema/integration/base/}version use="required" fixed="10.0.1.1""/>
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
    "exportOrgPeriodResult",
    "exportPaymentDocResult",
    "exportNotificationsOfOrderExecutionResult",
    "insuranceProduct",
    "settlement"
})
@XmlRootElement(name = "getStateResult")
public class GetStateResult
    extends BaseAsyncResponseType
{

    @XmlElement(name = "ErrorMessage", namespace = "http://dom.gosuslugi.ru/schema/integration/base/")
    protected ErrorMessageType errorMessage;
    @XmlElement(name = "ImportResult")
    protected List<CommonResultType> importResult;
    protected List<ExportOrgPeriodResultType> exportOrgPeriodResult;
    protected List<ExportPaymentDocumentResultType> exportPaymentDocResult;
    protected List<ExportNotificationsOfOrderExecutionResultType> exportNotificationsOfOrderExecutionResult;
    @XmlElement(name = "InsuranceProduct")
    protected List<InsuranceProductType> insuranceProduct;
    @XmlElement(name = "Settlement")
    protected List<ExportSettlementResultType> settlement;
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
     * {@link CommonResultType }
     * 
     * 
     */
    public List<CommonResultType> getImportResult() {
        if (importResult == null) {
            importResult = new ArrayList<CommonResultType>();
        }
        return this.importResult;
    }

    /**
     * Gets the value of the exportOrgPeriodResult property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the exportOrgPeriodResult property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getExportOrgPeriodResult().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ExportOrgPeriodResultType }
     * 
     * 
     */
    public List<ExportOrgPeriodResultType> getExportOrgPeriodResult() {
        if (exportOrgPeriodResult == null) {
            exportOrgPeriodResult = new ArrayList<ExportOrgPeriodResultType>();
        }
        return this.exportOrgPeriodResult;
    }

    /**
     * Gets the value of the exportPaymentDocResult property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the exportPaymentDocResult property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getExportPaymentDocResult().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ExportPaymentDocumentResultType }
     * 
     * 
     */
    public List<ExportPaymentDocumentResultType> getExportPaymentDocResult() {
        if (exportPaymentDocResult == null) {
            exportPaymentDocResult = new ArrayList<ExportPaymentDocumentResultType>();
        }
        return this.exportPaymentDocResult;
    }

    /**
     * Gets the value of the exportNotificationsOfOrderExecutionResult property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the exportNotificationsOfOrderExecutionResult property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getExportNotificationsOfOrderExecutionResult().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ExportNotificationsOfOrderExecutionResultType }
     * 
     * 
     */
    public List<ExportNotificationsOfOrderExecutionResultType> getExportNotificationsOfOrderExecutionResult() {
        if (exportNotificationsOfOrderExecutionResult == null) {
            exportNotificationsOfOrderExecutionResult = new ArrayList<ExportNotificationsOfOrderExecutionResultType>();
        }
        return this.exportNotificationsOfOrderExecutionResult;
    }

    /**
     * Gets the value of the insuranceProduct property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the insuranceProduct property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getInsuranceProduct().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link InsuranceProductType }
     * 
     * 
     */
    public List<InsuranceProductType> getInsuranceProduct() {
        if (insuranceProduct == null) {
            insuranceProduct = new ArrayList<InsuranceProductType>();
        }
        return this.insuranceProduct;
    }

    /**
     * Gets the value of the settlement property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the settlement property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSettlement().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ExportSettlementResultType }
     * 
     * 
     */
    public List<ExportSettlementResultType> getSettlement() {
        if (settlement == null) {
            settlement = new ArrayList<ExportSettlementResultType>();
        }
        return this.settlement;
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
            return "10.0.1.1";
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
