
package ru.gosuslugi.dom.schema.integration.licenses;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;
import ru.gosuslugi.dom.schema.integration.base.BaseType;
import ru.gosuslugi.dom.schema.integration.individual_registry_base.FIOType;


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
 *         &lt;element name="DisqualifiedPerson" maxOccurs="10">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="FIO" type="{http://dom.gosuslugi.ru/schema/integration/individual-registry-base/}FIOType"/>
 *                   &lt;element name="DateOfBirth" type="{http://www.w3.org/2001/XMLSchema}date"/>
 *                   &lt;element name="BirthPlace" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="LicenseNumber" minOccurs="0">
 *                     &lt;simpleType>
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                         &lt;pattern value="\d{9}"/>
 *                       &lt;/restriction>
 *                     &lt;/simpleType>
 *                   &lt;/element>
 *                   &lt;element name="LicenseOrganization" minOccurs="0">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;choice>
 *                             &lt;element name="OGRN" type="{http://dom.gosuslugi.ru/schema/integration/organizations-base/}OGRNType"/>
 *                             &lt;element name="OGRNIP" type="{http://dom.gosuslugi.ru/schema/integration/organizations-base/}OGRNIPType"/>
 *                           &lt;/choice>
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
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
    "disqualifiedPerson"
})
@XmlRootElement(name = "exportDisqualifiedPersonRequest")
public class ExportDisqualifiedPersonRequest
    extends BaseType
{

    @XmlElement(name = "DisqualifiedPerson", required = true)
    protected List<ExportDisqualifiedPersonRequest.DisqualifiedPerson> disqualifiedPerson;
    @XmlAttribute(name = "version", namespace = "http://dom.gosuslugi.ru/schema/integration/base/", required = true)
    protected String version;

    /**
     * Gets the value of the disqualifiedPerson property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the disqualifiedPerson property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDisqualifiedPerson().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ExportDisqualifiedPersonRequest.DisqualifiedPerson }
     * 
     * 
     */
    public List<ExportDisqualifiedPersonRequest.DisqualifiedPerson> getDisqualifiedPerson() {
        if (disqualifiedPerson == null) {
            disqualifiedPerson = new ArrayList<ExportDisqualifiedPersonRequest.DisqualifiedPerson>();
        }
        return this.disqualifiedPerson;
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
     *         &lt;element name="FIO" type="{http://dom.gosuslugi.ru/schema/integration/individual-registry-base/}FIOType"/>
     *         &lt;element name="DateOfBirth" type="{http://www.w3.org/2001/XMLSchema}date"/>
     *         &lt;element name="BirthPlace" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="LicenseNumber" minOccurs="0">
     *           &lt;simpleType>
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *               &lt;pattern value="\d{9}"/>
     *             &lt;/restriction>
     *           &lt;/simpleType>
     *         &lt;/element>
     *         &lt;element name="LicenseOrganization" minOccurs="0">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;choice>
     *                   &lt;element name="OGRN" type="{http://dom.gosuslugi.ru/schema/integration/organizations-base/}OGRNType"/>
     *                   &lt;element name="OGRNIP" type="{http://dom.gosuslugi.ru/schema/integration/organizations-base/}OGRNIPType"/>
     *                 &lt;/choice>
     *               &lt;/restriction>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
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
        "fio",
        "dateOfBirth",
        "birthPlace",
        "licenseNumber",
        "licenseOrganization"
    })
    public static class DisqualifiedPerson {

        @XmlElement(name = "FIO", required = true)
        protected FIOType fio;
        @XmlElement(name = "DateOfBirth", required = true)
        @XmlSchemaType(name = "date")
        protected XMLGregorianCalendar dateOfBirth;
        @XmlElement(name = "BirthPlace")
        protected String birthPlace;
        @XmlElement(name = "LicenseNumber")
        protected String licenseNumber;
        @XmlElement(name = "LicenseOrganization")
        protected ExportDisqualifiedPersonRequest.DisqualifiedPerson.LicenseOrganization licenseOrganization;

        /**
         * Gets the value of the fio property.
         * 
         * @return
         *     possible object is
         *     {@link FIOType }
         *     
         */
        public FIOType getFIO() {
            return fio;
        }

        /**
         * Sets the value of the fio property.
         * 
         * @param value
         *     allowed object is
         *     {@link FIOType }
         *     
         */
        public void setFIO(FIOType value) {
            this.fio = value;
        }

        /**
         * Gets the value of the dateOfBirth property.
         * 
         * @return
         *     possible object is
         *     {@link XMLGregorianCalendar }
         *     
         */
        public XMLGregorianCalendar getDateOfBirth() {
            return dateOfBirth;
        }

        /**
         * Sets the value of the dateOfBirth property.
         * 
         * @param value
         *     allowed object is
         *     {@link XMLGregorianCalendar }
         *     
         */
        public void setDateOfBirth(XMLGregorianCalendar value) {
            this.dateOfBirth = value;
        }

        /**
         * Gets the value of the birthPlace property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getBirthPlace() {
            return birthPlace;
        }

        /**
         * Sets the value of the birthPlace property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setBirthPlace(String value) {
            this.birthPlace = value;
        }

        /**
         * Gets the value of the licenseNumber property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getLicenseNumber() {
            return licenseNumber;
        }

        /**
         * Sets the value of the licenseNumber property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setLicenseNumber(String value) {
            this.licenseNumber = value;
        }

        /**
         * Gets the value of the licenseOrganization property.
         * 
         * @return
         *     possible object is
         *     {@link ExportDisqualifiedPersonRequest.DisqualifiedPerson.LicenseOrganization }
         *     
         */
        public ExportDisqualifiedPersonRequest.DisqualifiedPerson.LicenseOrganization getLicenseOrganization() {
            return licenseOrganization;
        }

        /**
         * Sets the value of the licenseOrganization property.
         * 
         * @param value
         *     allowed object is
         *     {@link ExportDisqualifiedPersonRequest.DisqualifiedPerson.LicenseOrganization }
         *     
         */
        public void setLicenseOrganization(ExportDisqualifiedPersonRequest.DisqualifiedPerson.LicenseOrganization value) {
            this.licenseOrganization = value;
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
         *       &lt;choice>
         *         &lt;element name="OGRN" type="{http://dom.gosuslugi.ru/schema/integration/organizations-base/}OGRNType"/>
         *         &lt;element name="OGRNIP" type="{http://dom.gosuslugi.ru/schema/integration/organizations-base/}OGRNIPType"/>
         *       &lt;/choice>
         *     &lt;/restriction>
         *   &lt;/complexContent>
         * &lt;/complexType>
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
            "ogrn",
            "ogrnip"
        })
        public static class LicenseOrganization {

            @XmlElement(name = "OGRN")
            protected String ogrn;
            @XmlElement(name = "OGRNIP")
            protected String ogrnip;

            /**
             * Gets the value of the ogrn property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getOGRN() {
                return ogrn;
            }

            /**
             * Sets the value of the ogrn property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setOGRN(String value) {
                this.ogrn = value;
            }

            /**
             * Gets the value of the ogrnip property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getOGRNIP() {
                return ogrnip;
            }

            /**
             * Sets the value of the ogrnip property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setOGRNIP(String value) {
                this.ogrnip = value;
            }

        }

    }

}
