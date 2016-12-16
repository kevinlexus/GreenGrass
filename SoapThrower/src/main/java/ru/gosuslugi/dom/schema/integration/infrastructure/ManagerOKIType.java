
package ru.gosuslugi.dom.schema.integration.infrastructure;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ManagerOKIType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ManagerOKIType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;choice>
 *         &lt;element name="RSO">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="RSOOrganizationGUID" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType"/>
 *                   &lt;element name="Name" type="{http://dom.gosuslugi.ru/schema/integration/infrastructure/}eTextType" minOccurs="0"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="Municipalities" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *       &lt;/choice>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ManagerOKIType", propOrder = {
    "rso",
    "municipalities"
})
public class ManagerOKIType {

    @XmlElement(name = "RSO")
    protected ManagerOKIType.RSO rso;
    @XmlElement(name = "Municipalities")
    protected Boolean municipalities;

    /**
     * Gets the value of the rso property.
     * 
     * @return
     *     possible object is
     *     {@link ManagerOKIType.RSO }
     *     
     */
    public ManagerOKIType.RSO getRSO() {
        return rso;
    }

    /**
     * Sets the value of the rso property.
     * 
     * @param value
     *     allowed object is
     *     {@link ManagerOKIType.RSO }
     *     
     */
    public void setRSO(ManagerOKIType.RSO value) {
        this.rso = value;
    }

    /**
     * Gets the value of the municipalities property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isMunicipalities() {
        return municipalities;
    }

    /**
     * Sets the value of the municipalities property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setMunicipalities(Boolean value) {
        this.municipalities = value;
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
     *         &lt;element name="RSOOrganizationGUID" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType"/>
     *         &lt;element name="Name" type="{http://dom.gosuslugi.ru/schema/integration/infrastructure/}eTextType" minOccurs="0"/>
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
        "rsoOrganizationGUID",
        "name"
    })
    public static class RSO {

        @XmlElement(name = "RSOOrganizationGUID", required = true)
        protected String rsoOrganizationGUID;
        @XmlElement(name = "Name")
        protected String name;

        /**
         * Gets the value of the rsoOrganizationGUID property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getRSOOrganizationGUID() {
            return rsoOrganizationGUID;
        }

        /**
         * Sets the value of the rsoOrganizationGUID property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setRSOOrganizationGUID(String value) {
            this.rsoOrganizationGUID = value;
        }

        /**
         * Gets the value of the name property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getName() {
            return name;
        }

        /**
         * Sets the value of the name property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setName(String value) {
            this.name = value;
        }

    }

}
