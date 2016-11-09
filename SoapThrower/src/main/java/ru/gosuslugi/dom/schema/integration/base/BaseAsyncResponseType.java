
package ru.gosuslugi.dom.schema.integration.base;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;
import ru.gosuslugi.dom.schema.integration.house_management.GetStateResult;


/**
 * Базовый тип ответа на запрос статуса
 * 
 * <p>Java class for BaseAsyncResponseType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="BaseAsyncResponseType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/base/}BaseType">
 *       &lt;sequence>
 *         &lt;element name="RequestState" type="{http://dom.gosuslugi.ru/schema/integration/base/}AsyncRequestStateType"/>
 *         &lt;element name="MessageGUID" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "BaseAsyncResponseType", propOrder = {
    "requestState",
    "messageGUID"
})
@XmlSeeAlso({
    GetStateResult.class
})
public class BaseAsyncResponseType
    extends BaseType
{

    @XmlElement(name = "RequestState")
    protected byte requestState;
    @XmlElement(name = "MessageGUID", required = true)
    protected String messageGUID;

    /**
     * Gets the value of the requestState property.
     * 
     */
    public byte getRequestState() {
        return requestState;
    }

    /**
     * Sets the value of the requestState property.
     * 
     */
    public void setRequestState(byte value) {
        this.requestState = value;
    }

    /**
     * Gets the value of the messageGUID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMessageGUID() {
        return messageGUID;
    }

    /**
     * Sets the value of the messageGUID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMessageGUID(String value) {
        this.messageGUID = value;
    }

}
