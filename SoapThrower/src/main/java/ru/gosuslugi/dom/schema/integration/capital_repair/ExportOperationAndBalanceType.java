
package ru.gosuslugi.dom.schema.integration.capital_repair;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Экспортируемая информация о совершенных операциях и остатках по счету
 * 
 * <p>Java class for ExportOperationAndBalanceType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ExportOperationAndBalanceType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/capital-repair/}OperationAndBalanceInfoType">
 *       &lt;sequence>
 *         &lt;element name="FIASHouseGuid" type="{http://dom.gosuslugi.ru/schema/integration/premises-base/}FIASHouseGUIDType" minOccurs="0"/>
 *         &lt;element name="PeriodEnrollment" type="{http://dom.gosuslugi.ru/schema/integration/bills-base/}MoneyPositiveType"/>
 *         &lt;element name="PeriodWritingDown" type="{http://dom.gosuslugi.ru/schema/integration/bills-base/}MoneyPositiveType"/>
 *         &lt;element name="Status">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;enumeration value="Published"/>
 *               &lt;enumeration value="Canceled"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="OperationAndBalanceGuid" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ExportOperationAndBalanceType", propOrder = {
    "fiasHouseGuid",
    "periodEnrollment",
    "periodWritingDown",
    "status",
    "operationAndBalanceGuid"
})
public class ExportOperationAndBalanceType
    extends OperationAndBalanceInfoType
{

    @XmlElement(name = "FIASHouseGuid")
    protected String fiasHouseGuid;
    @XmlElement(name = "PeriodEnrollment", required = true)
    protected BigDecimal periodEnrollment;
    @XmlElement(name = "PeriodWritingDown", required = true)
    protected BigDecimal periodWritingDown;
    @XmlElement(name = "Status", required = true)
    protected String status;
    @XmlElement(name = "OperationAndBalanceGuid", required = true)
    protected String operationAndBalanceGuid;

    /**
     * Gets the value of the fiasHouseGuid property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFIASHouseGuid() {
        return fiasHouseGuid;
    }

    /**
     * Sets the value of the fiasHouseGuid property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFIASHouseGuid(String value) {
        this.fiasHouseGuid = value;
    }

    /**
     * Gets the value of the periodEnrollment property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getPeriodEnrollment() {
        return periodEnrollment;
    }

    /**
     * Sets the value of the periodEnrollment property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setPeriodEnrollment(BigDecimal value) {
        this.periodEnrollment = value;
    }

    /**
     * Gets the value of the periodWritingDown property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getPeriodWritingDown() {
        return periodWritingDown;
    }

    /**
     * Sets the value of the periodWritingDown property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setPeriodWritingDown(BigDecimal value) {
        this.periodWritingDown = value;
    }

    /**
     * Gets the value of the status property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStatus() {
        return status;
    }

    /**
     * Sets the value of the status property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStatus(String value) {
        this.status = value;
    }

    /**
     * Gets the value of the operationAndBalanceGuid property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOperationAndBalanceGuid() {
        return operationAndBalanceGuid;
    }

    /**
     * Sets the value of the operationAndBalanceGuid property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOperationAndBalanceGuid(String value) {
        this.operationAndBalanceGuid = value;
    }

}
