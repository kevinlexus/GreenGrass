
package ru.gosuslugi.dom.schema.integration.nsi_base;

import java.math.BigInteger;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * Составной тип. Наименование и значение поля типа "Ссылка на справочник" для элемента справочника.
 * 
 * <p>Java class for NsiElementNsiFieldType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="NsiElementNsiFieldType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/nsi-base/}NsiElementFieldType">
 *       &lt;sequence>
 *         &lt;element name="NsiRef" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="NsiItemRegistryNumber" type="{http://dom.gosuslugi.ru/schema/integration/nsi-base/}NsiItemRegistryNumberType"/>
 *                   &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/nsi-base/}ListGroup"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "NsiElementNsiFieldType", propOrder = {
    "nsiRef"
})
public class NsiElementNsiFieldType
    extends NsiElementFieldType
{

    @XmlElement(name = "NsiRef")
    protected NsiElementNsiFieldType.NsiRef nsiRef;

    /**
     * Gets the value of the nsiRef property.
     * 
     * @return
     *     possible object is
     *     {@link NsiElementNsiFieldType.NsiRef }
     *     
     */
    public NsiElementNsiFieldType.NsiRef getNsiRef() {
        return nsiRef;
    }

    /**
     * Sets the value of the nsiRef property.
     * 
     * @param value
     *     allowed object is
     *     {@link NsiElementNsiFieldType.NsiRef }
     *     
     */
    public void setNsiRef(NsiElementNsiFieldType.NsiRef value) {
        this.nsiRef = value;
    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="NsiItemRegistryNumber" type="{http://dom.gosuslugi.ru/schema/integration/nsi-base/}NsiItemRegistryNumberType"/>
     *         &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/nsi-base/}ListGroup"/>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "nsiItemRegistryNumber",
        "listGroup"
    })
    public static class NsiRef {

        @XmlElement(name = "NsiItemRegistryNumber", required = true)
        @XmlSchemaType(name = "positiveInteger")
        protected BigInteger nsiItemRegistryNumber;
        @XmlElement(name = "ListGroup", required = true)
        protected String listGroup;

        /**
         * Gets the value of the nsiItemRegistryNumber property.
         * 
         * @return
         *     possible object is
         *     {@link BigInteger }
         *     
         */
        public BigInteger getNsiItemRegistryNumber() {
            return nsiItemRegistryNumber;
        }

        /**
         * Sets the value of the nsiItemRegistryNumber property.
         * 
         * @param value
         *     allowed object is
         *     {@link BigInteger }
         *     
         */
        public void setNsiItemRegistryNumber(BigInteger value) {
            this.nsiItemRegistryNumber = value;
        }

        /**
         * Gets the value of the listGroup property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getListGroup() {
            return listGroup;
        }

        /**
         * Sets the value of the listGroup property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setListGroup(String value) {
            this.listGroup = value;
        }

    }

}
