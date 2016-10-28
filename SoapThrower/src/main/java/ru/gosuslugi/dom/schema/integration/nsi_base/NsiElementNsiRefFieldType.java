
package ru.gosuslugi.dom.schema.integration.nsi_base;

import java.math.BigInteger;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * Составной тип. Наименование и значение поля типа "Ссылка на элемент внутреннего справочника" для элемента справочника.
 * 
 * <p>Java class for NsiElementNsiRefFieldType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="NsiElementNsiRefFieldType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/nsi-base/}NsiElementFieldType">
 *       &lt;sequence>
 *         &lt;element name="NsiRef" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="NsiItemRegistryNumber" type="{http://dom.gosuslugi.ru/schema/integration/nsi-base/}NsiItemRegistryNumberType"/>
 *                   &lt;element name="Ref" type="{http://dom.gosuslugi.ru/schema/integration/nsi-base/}nsiRef"/>
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
@XmlType(name = "NsiElementNsiRefFieldType", propOrder = {
    "nsiRef"
})
public class NsiElementNsiRefFieldType
    extends NsiElementFieldType
{

    @XmlElement(name = "NsiRef")
    protected NsiElementNsiRefFieldType.NsiRef nsiRef;

    /**
     * Gets the value of the nsiRef property.
     * 
     * @return
     *     possible object is
     *     {@link NsiElementNsiRefFieldType.NsiRef }
     *     
     */
    public NsiElementNsiRefFieldType.NsiRef getNsiRef() {
        return nsiRef;
    }

    /**
     * Sets the value of the nsiRef property.
     * 
     * @param value
     *     allowed object is
     *     {@link NsiElementNsiRefFieldType.NsiRef }
     *     
     */
    public void setNsiRef(NsiElementNsiRefFieldType.NsiRef value) {
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
     *         &lt;element name="Ref" type="{http://dom.gosuslugi.ru/schema/integration/nsi-base/}nsiRef"/>
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
        "ref"
    })
    public static class NsiRef {

        @XmlElement(name = "NsiItemRegistryNumber", required = true)
        @XmlSchemaType(name = "positiveInteger")
        protected BigInteger nsiItemRegistryNumber;
        @XmlElement(name = "Ref", required = true)
        protected ru.gosuslugi.dom.schema.integration.nsi_base.NsiRef ref;

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
         * Gets the value of the ref property.
         * 
         * @return
         *     possible object is
         *     {@link ru.gosuslugi.dom.schema.integration.nsi_base.NsiRef }
         *     
         */
        public ru.gosuslugi.dom.schema.integration.nsi_base.NsiRef getRef() {
            return ref;
        }

        /**
         * Sets the value of the ref property.
         * 
         * @param value
         *     allowed object is
         *     {@link ru.gosuslugi.dom.schema.integration.nsi_base.NsiRef }
         *     
         */
        public void setRef(ru.gosuslugi.dom.schema.integration.nsi_base.NsiRef value) {
            this.ref = value;
        }

    }

}
