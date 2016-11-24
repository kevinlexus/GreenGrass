
package ru.gosuslugi.dom.schema.integration.capital_repair;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * Экспортируемый договор на выполнение работ (оказание услуг) по капитальному ремонту
 * 
 * <p>Java class for exportContractType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="exportContractType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/capital-repair/}ShortExportContractType">
 *       &lt;sequence>
 *         &lt;element name="Status" type="{http://dom.gosuslugi.ru/schema/integration/capital-repair/}StatusType"/>
 *         &lt;element name="ExecutionStatus" type="{http://dom.gosuslugi.ru/schema/integration/capital-repair/}String500Type"/>
 *         &lt;element name="ContractGuid" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType"/>
 *         &lt;element name="PlanGUID" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "exportContractType", propOrder = {
    "status",
    "executionStatus",
    "contractGuid",
    "planGUID"
})
public class ExportContractType
    extends ShortExportContractType
{

    @XmlElement(name = "Status", required = true)
    @XmlSchemaType(name = "token")
    protected StatusType status;
    @XmlElement(name = "ExecutionStatus", required = true)
    protected String executionStatus;
    @XmlElement(name = "ContractGuid", required = true)
    protected String contractGuid;
    @XmlElement(name = "PlanGUID", required = true)
    protected String planGUID;

    /**
     * Gets the value of the status property.
     * 
     * @return
     *     possible object is
     *     {@link StatusType }
     *     
     */
    public StatusType getStatus() {
        return status;
    }

    /**
     * Sets the value of the status property.
     * 
     * @param value
     *     allowed object is
     *     {@link StatusType }
     *     
     */
    public void setStatus(StatusType value) {
        this.status = value;
    }

    /**
     * Gets the value of the executionStatus property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getExecutionStatus() {
        return executionStatus;
    }

    /**
     * Sets the value of the executionStatus property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setExecutionStatus(String value) {
        this.executionStatus = value;
    }

    /**
     * Gets the value of the contractGuid property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getContractGuid() {
        return contractGuid;
    }

    /**
     * Sets the value of the contractGuid property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setContractGuid(String value) {
        this.contractGuid = value;
    }

    /**
     * Gets the value of the planGUID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPlanGUID() {
        return planGUID;
    }

    /**
     * Sets the value of the planGUID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPlanGUID(String value) {
        this.planGUID = value;
    }

}
