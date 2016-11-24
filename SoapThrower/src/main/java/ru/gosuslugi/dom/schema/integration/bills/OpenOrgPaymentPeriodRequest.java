
package ru.gosuslugi.dom.schema.integration.bills;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import ru.gosuslugi.dom.schema.integration.base.BaseType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/base/}BaseType">
 *       &lt;sequence>
 *         &lt;choice>
 *           &lt;element name="createFirstPeriod" type="{http://dom.gosuslugi.ru/schema/integration/bills/}PaymentPeriodType"/>
 *           &lt;element name="createNextPeriodUO" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *           &lt;element name="createNextPeriodRSO" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;/choice>
 *         &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/base/}TransportGUID"/>
 *       &lt;/sequence>
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
    "createFirstPeriod",
    "createNextPeriodUO",
    "createNextPeriodRSO",
    "transportGUID"
})
@XmlRootElement(name = "openOrgPaymentPeriodRequest")
public class OpenOrgPaymentPeriodRequest
    extends BaseType
{

    protected PaymentPeriodType createFirstPeriod;
    protected Boolean createNextPeriodUO;
    protected Boolean createNextPeriodRSO;
    @XmlElement(name = "TransportGUID", namespace = "http://dom.gosuslugi.ru/schema/integration/base/", required = true)
    protected String transportGUID;
    @XmlAttribute(name = "version", namespace = "http://dom.gosuslugi.ru/schema/integration/base/", required = true)
    protected String version;

    /**
     * Gets the value of the createFirstPeriod property.
     * 
     * @return
     *     possible object is
     *     {@link PaymentPeriodType }
     *     
     */
    public PaymentPeriodType getCreateFirstPeriod() {
        return createFirstPeriod;
    }

    /**
     * Sets the value of the createFirstPeriod property.
     * 
     * @param value
     *     allowed object is
     *     {@link PaymentPeriodType }
     *     
     */
    public void setCreateFirstPeriod(PaymentPeriodType value) {
        this.createFirstPeriod = value;
    }

    /**
     * Gets the value of the createNextPeriodUO property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isCreateNextPeriodUO() {
        return createNextPeriodUO;
    }

    /**
     * Sets the value of the createNextPeriodUO property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setCreateNextPeriodUO(Boolean value) {
        this.createNextPeriodUO = value;
    }

    /**
     * Gets the value of the createNextPeriodRSO property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isCreateNextPeriodRSO() {
        return createNextPeriodRSO;
    }

    /**
     * Sets the value of the createNextPeriodRSO property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setCreateNextPeriodRSO(Boolean value) {
        this.createNextPeriodRSO = value;
    }

    /**
     * Gets the value of the transportGUID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTransportGUID() {
        return transportGUID;
    }

    /**
     * Sets the value of the transportGUID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTransportGUID(String value) {
        this.transportGUID = value;
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
