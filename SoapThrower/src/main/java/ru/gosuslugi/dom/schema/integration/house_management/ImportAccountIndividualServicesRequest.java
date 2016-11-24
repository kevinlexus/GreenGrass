
package ru.gosuslugi.dom.schema.integration.house_management;

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
 *       &lt;choice>
 *         &lt;element name="IndividualService">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/house-management/}AccountIndividualServiceType">
 *                 &lt;sequence>
 *                   &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/base/}TransportGUID"/>
 *                   &lt;choice>
 *                     &lt;element name="AccountGUID" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType"/>
 *                     &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/house-management/}AccountIndividualServiceGUID"/>
 *                   &lt;/choice>
 *                 &lt;/sequence>
 *               &lt;/extension>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="DeleteIndividualService">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/base/}TransportGUID"/>
 *                   &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/house-management/}AccountIndividualServiceGUID"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
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
    "individualService",
    "deleteIndividualService"
})
@XmlRootElement(name = "importAccountIndividualServicesRequest")
public class ImportAccountIndividualServicesRequest
    extends BaseType
{

    @XmlElement(name = "IndividualService")
    protected ImportAccountIndividualServicesRequest.IndividualService individualService;
    @XmlElement(name = "DeleteIndividualService")
    protected ImportAccountIndividualServicesRequest.DeleteIndividualService deleteIndividualService;
    @XmlAttribute(name = "version", namespace = "http://dom.gosuslugi.ru/schema/integration/base/", required = true)
    protected String version;

    /**
     * Gets the value of the individualService property.
     * 
     * @return
     *     possible object is
     *     {@link ImportAccountIndividualServicesRequest.IndividualService }
     *     
     */
    public ImportAccountIndividualServicesRequest.IndividualService getIndividualService() {
        return individualService;
    }

    /**
     * Sets the value of the individualService property.
     * 
     * @param value
     *     allowed object is
     *     {@link ImportAccountIndividualServicesRequest.IndividualService }
     *     
     */
    public void setIndividualService(ImportAccountIndividualServicesRequest.IndividualService value) {
        this.individualService = value;
    }

    /**
     * Gets the value of the deleteIndividualService property.
     * 
     * @return
     *     possible object is
     *     {@link ImportAccountIndividualServicesRequest.DeleteIndividualService }
     *     
     */
    public ImportAccountIndividualServicesRequest.DeleteIndividualService getDeleteIndividualService() {
        return deleteIndividualService;
    }

    /**
     * Sets the value of the deleteIndividualService property.
     * 
     * @param value
     *     allowed object is
     *     {@link ImportAccountIndividualServicesRequest.DeleteIndividualService }
     *     
     */
    public void setDeleteIndividualService(ImportAccountIndividualServicesRequest.DeleteIndividualService value) {
        this.deleteIndividualService = value;
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
     *         &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/base/}TransportGUID"/>
     *         &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/house-management/}AccountIndividualServiceGUID"/>
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
        "transportGUID",
        "accountIndividualServiceGUID"
    })
    public static class DeleteIndividualService {

        @XmlElement(name = "TransportGUID", namespace = "http://dom.gosuslugi.ru/schema/integration/base/", required = true)
        protected String transportGUID;
        @XmlElement(name = "AccountIndividualServiceGUID", required = true)
        protected String accountIndividualServiceGUID;

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
         * Gets the value of the accountIndividualServiceGUID property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getAccountIndividualServiceGUID() {
            return accountIndividualServiceGUID;
        }

        /**
         * Sets the value of the accountIndividualServiceGUID property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setAccountIndividualServiceGUID(String value) {
            this.accountIndividualServiceGUID = value;
        }

    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/house-management/}AccountIndividualServiceType">
     *       &lt;sequence>
     *         &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/base/}TransportGUID"/>
     *         &lt;choice>
     *           &lt;element name="AccountGUID" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType"/>
     *           &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/house-management/}AccountIndividualServiceGUID"/>
     *         &lt;/choice>
     *       &lt;/sequence>
     *     &lt;/extension>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "transportGUID",
        "accountGUID",
        "accountIndividualServiceGUID"
    })
    public static class IndividualService
        extends AccountIndividualServiceType
    {

        @XmlElement(name = "TransportGUID", namespace = "http://dom.gosuslugi.ru/schema/integration/base/", required = true)
        protected String transportGUID;
        @XmlElement(name = "AccountGUID")
        protected String accountGUID;
        @XmlElement(name = "AccountIndividualServiceGUID")
        protected String accountIndividualServiceGUID;

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
         * Gets the value of the accountGUID property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getAccountGUID() {
            return accountGUID;
        }

        /**
         * Sets the value of the accountGUID property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setAccountGUID(String value) {
            this.accountGUID = value;
        }

        /**
         * Gets the value of the accountIndividualServiceGUID property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getAccountIndividualServiceGUID() {
            return accountIndividualServiceGUID;
        }

        /**
         * Sets the value of the accountIndividualServiceGUID property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setAccountIndividualServiceGUID(String value) {
            this.accountIndividualServiceGUID = value;
        }

    }

}
