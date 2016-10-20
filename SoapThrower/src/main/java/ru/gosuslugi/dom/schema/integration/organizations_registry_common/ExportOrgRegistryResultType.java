
package ru.gosuslugi.dom.schema.integration.organizations_registry_common;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;
import ru.gosuslugi.dom.schema.integration.nsi_base.NsiRef;
import ru.gosuslugi.dom.schema.integration.organizations_registry_base.EntpsType;
import ru.gosuslugi.dom.schema.integration.organizations_registry_base.LegalType;
import ru.gosuslugi.dom.schema.integration.organizations_registry_base.RegOrgVersionType;
import ru.gosuslugi.dom.schema.integration.organizations_registry_base.SubsidiaryType;


/**
 * <p>Java class for exportOrgRegistryResultType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="exportOrgRegistryResultType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/organizations-registry-base/}orgRootEntityGUID"/>
 *         &lt;element name="OrgVersion">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/organizations-registry-base/}orgVersionGUID"/>
 *                   &lt;element name="lastEditingDate" type="{http://www.w3.org/2001/XMLSchema}date"/>
 *                   &lt;element name="IsActual" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *                   &lt;choice>
 *                     &lt;element name="Legal" type="{http://dom.gosuslugi.ru/schema/integration/organizations-registry-base/}LegalType"/>
 *                     &lt;element name="Subsidiary">
 *                       &lt;complexType>
 *                         &lt;complexContent>
 *                           &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/organizations-registry-base/}SubsidiaryType">
 *                             &lt;sequence>
 *                               &lt;element name="StatusVersion">
 *                                 &lt;simpleType>
 *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                                   &lt;/restriction>
 *                                 &lt;/simpleType>
 *                               &lt;/element>
 *                               &lt;element name="ParentOrg">
 *                                 &lt;complexType>
 *                                   &lt;complexContent>
 *                                     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                       &lt;sequence>
 *                                         &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/organizations-registry-base/}RegOrgVersion"/>
 *                                       &lt;/sequence>
 *                                     &lt;/restriction>
 *                                   &lt;/complexContent>
 *                                 &lt;/complexType>
 *                               &lt;/element>
 *                             &lt;/sequence>
 *                           &lt;/extension>
 *                         &lt;/complexContent>
 *                       &lt;/complexType>
 *                     &lt;/element>
 *                     &lt;element name="Entrp" type="{http://dom.gosuslugi.ru/schema/integration/organizations-registry-base/}EntpsType"/>
 *                   &lt;/choice>
 *                   &lt;element name="registryOrganizationStatus" minOccurs="0">
 *                     &lt;simpleType>
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                         &lt;enumeration value="P"/>
 *                       &lt;/restriction>
 *                     &lt;/simpleType>
 *                   &lt;/element>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/base/}orgPPAGUID" minOccurs="0"/>
 *         &lt;element name="organizationRoles" type="{http://dom.gosuslugi.ru/schema/integration/nsi-base/}nsiRef" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="isRegistered" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "exportOrgRegistryResultType", propOrder = {
    "orgRootEntityGUID",
    "orgVersion",
    "orgPPAGUID",
    "organizationRoles",
    "isRegistered"
})
public class ExportOrgRegistryResultType {

    @XmlElement(namespace = "http://dom.gosuslugi.ru/schema/integration/organizations-registry-base/", required = true)
    protected String orgRootEntityGUID;
    @XmlElement(name = "OrgVersion", required = true)
    protected ExportOrgRegistryResultType.OrgVersion orgVersion;
    @XmlElement(namespace = "http://dom.gosuslugi.ru/schema/integration/base/")
    protected String orgPPAGUID;
    protected List<NsiRef> organizationRoles;
    protected Boolean isRegistered;

    /**
     * Gets the value of the orgRootEntityGUID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOrgRootEntityGUID() {
        return orgRootEntityGUID;
    }

    /**
     * Sets the value of the orgRootEntityGUID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOrgRootEntityGUID(String value) {
        this.orgRootEntityGUID = value;
    }

    /**
     * Gets the value of the orgVersion property.
     * 
     * @return
     *     possible object is
     *     {@link ExportOrgRegistryResultType.OrgVersion }
     *     
     */
    public ExportOrgRegistryResultType.OrgVersion getOrgVersion() {
        return orgVersion;
    }

    /**
     * Sets the value of the orgVersion property.
     * 
     * @param value
     *     allowed object is
     *     {@link ExportOrgRegistryResultType.OrgVersion }
     *     
     */
    public void setOrgVersion(ExportOrgRegistryResultType.OrgVersion value) {
        this.orgVersion = value;
    }

    /**
     * Gets the value of the orgPPAGUID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOrgPPAGUID() {
        return orgPPAGUID;
    }

    /**
     * Sets the value of the orgPPAGUID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOrgPPAGUID(String value) {
        this.orgPPAGUID = value;
    }

    /**
     * Gets the value of the organizationRoles property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the organizationRoles property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getOrganizationRoles().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link NsiRef }
     * 
     * 
     */
    public List<NsiRef> getOrganizationRoles() {
        if (organizationRoles == null) {
            organizationRoles = new ArrayList<NsiRef>();
        }
        return this.organizationRoles;
    }

    /**
     * Gets the value of the isRegistered property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isIsRegistered() {
        return isRegistered;
    }

    /**
     * Sets the value of the isRegistered property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setIsRegistered(Boolean value) {
        this.isRegistered = value;
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
     *         &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/organizations-registry-base/}orgVersionGUID"/>
     *         &lt;element name="lastEditingDate" type="{http://www.w3.org/2001/XMLSchema}date"/>
     *         &lt;element name="IsActual" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
     *         &lt;choice>
     *           &lt;element name="Legal" type="{http://dom.gosuslugi.ru/schema/integration/organizations-registry-base/}LegalType"/>
     *           &lt;element name="Subsidiary">
     *             &lt;complexType>
     *               &lt;complexContent>
     *                 &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/organizations-registry-base/}SubsidiaryType">
     *                   &lt;sequence>
     *                     &lt;element name="StatusVersion">
     *                       &lt;simpleType>
     *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *                         &lt;/restriction>
     *                       &lt;/simpleType>
     *                     &lt;/element>
     *                     &lt;element name="ParentOrg">
     *                       &lt;complexType>
     *                         &lt;complexContent>
     *                           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                             &lt;sequence>
     *                               &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/organizations-registry-base/}RegOrgVersion"/>
     *                             &lt;/sequence>
     *                           &lt;/restriction>
     *                         &lt;/complexContent>
     *                       &lt;/complexType>
     *                     &lt;/element>
     *                   &lt;/sequence>
     *                 &lt;/extension>
     *               &lt;/complexContent>
     *             &lt;/complexType>
     *           &lt;/element>
     *           &lt;element name="Entrp" type="{http://dom.gosuslugi.ru/schema/integration/organizations-registry-base/}EntpsType"/>
     *         &lt;/choice>
     *         &lt;element name="registryOrganizationStatus" minOccurs="0">
     *           &lt;simpleType>
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *               &lt;enumeration value="P"/>
     *             &lt;/restriction>
     *           &lt;/simpleType>
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
        "orgVersionGUID",
        "lastEditingDate",
        "isActual",
        "legal",
        "subsidiary",
        "entrp",
        "registryOrganizationStatus"
    })
    public static class OrgVersion {

        @XmlElement(namespace = "http://dom.gosuslugi.ru/schema/integration/organizations-registry-base/", required = true)
        protected String orgVersionGUID;
        @XmlElement(required = true)
        @XmlSchemaType(name = "date")
        protected XMLGregorianCalendar lastEditingDate;
        @XmlElement(name = "IsActual")
        protected boolean isActual;
        @XmlElement(name = "Legal")
        protected LegalType legal;
        @XmlElement(name = "Subsidiary")
        protected ExportOrgRegistryResultType.OrgVersion.Subsidiary subsidiary;
        @XmlElement(name = "Entrp")
        protected EntpsType entrp;
        protected String registryOrganizationStatus;

        /**
         * Gets the value of the orgVersionGUID property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getOrgVersionGUID() {
            return orgVersionGUID;
        }

        /**
         * Sets the value of the orgVersionGUID property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setOrgVersionGUID(String value) {
            this.orgVersionGUID = value;
        }

        /**
         * Gets the value of the lastEditingDate property.
         * 
         * @return
         *     possible object is
         *     {@link XMLGregorianCalendar }
         *     
         */
        public XMLGregorianCalendar getLastEditingDate() {
            return lastEditingDate;
        }

        /**
         * Sets the value of the lastEditingDate property.
         * 
         * @param value
         *     allowed object is
         *     {@link XMLGregorianCalendar }
         *     
         */
        public void setLastEditingDate(XMLGregorianCalendar value) {
            this.lastEditingDate = value;
        }

        /**
         * Gets the value of the isActual property.
         * 
         */
        public boolean isIsActual() {
            return isActual;
        }

        /**
         * Sets the value of the isActual property.
         * 
         */
        public void setIsActual(boolean value) {
            this.isActual = value;
        }

        /**
         * Gets the value of the legal property.
         * 
         * @return
         *     possible object is
         *     {@link LegalType }
         *     
         */
        public LegalType getLegal() {
            return legal;
        }

        /**
         * Sets the value of the legal property.
         * 
         * @param value
         *     allowed object is
         *     {@link LegalType }
         *     
         */
        public void setLegal(LegalType value) {
            this.legal = value;
        }

        /**
         * Gets the value of the subsidiary property.
         * 
         * @return
         *     possible object is
         *     {@link ExportOrgRegistryResultType.OrgVersion.Subsidiary }
         *     
         */
        public ExportOrgRegistryResultType.OrgVersion.Subsidiary getSubsidiary() {
            return subsidiary;
        }

        /**
         * Sets the value of the subsidiary property.
         * 
         * @param value
         *     allowed object is
         *     {@link ExportOrgRegistryResultType.OrgVersion.Subsidiary }
         *     
         */
        public void setSubsidiary(ExportOrgRegistryResultType.OrgVersion.Subsidiary value) {
            this.subsidiary = value;
        }

        /**
         * Gets the value of the entrp property.
         * 
         * @return
         *     possible object is
         *     {@link EntpsType }
         *     
         */
        public EntpsType getEntrp() {
            return entrp;
        }

        /**
         * Sets the value of the entrp property.
         * 
         * @param value
         *     allowed object is
         *     {@link EntpsType }
         *     
         */
        public void setEntrp(EntpsType value) {
            this.entrp = value;
        }

        /**
         * Gets the value of the registryOrganizationStatus property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getRegistryOrganizationStatus() {
            return registryOrganizationStatus;
        }

        /**
         * Sets the value of the registryOrganizationStatus property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setRegistryOrganizationStatus(String value) {
            this.registryOrganizationStatus = value;
        }


        /**
         * <p>Java class for anonymous complex type.
         * 
         * <p>The following schema fragment specifies the expected content contained within this class.
         * 
         * <pre>
         * &lt;complexType>
         *   &lt;complexContent>
         *     &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/organizations-registry-base/}SubsidiaryType">
         *       &lt;sequence>
         *         &lt;element name="StatusVersion">
         *           &lt;simpleType>
         *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
         *             &lt;/restriction>
         *           &lt;/simpleType>
         *         &lt;/element>
         *         &lt;element name="ParentOrg">
         *           &lt;complexType>
         *             &lt;complexContent>
         *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *                 &lt;sequence>
         *                   &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/organizations-registry-base/}RegOrgVersion"/>
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
        @XmlType(name = "", propOrder = {
            "statusVersion",
            "parentOrg"
        })
        public static class Subsidiary
            extends SubsidiaryType
        {

            @XmlElement(name = "StatusVersion", required = true)
            protected String statusVersion;
            @XmlElement(name = "ParentOrg", required = true)
            protected ExportOrgRegistryResultType.OrgVersion.Subsidiary.ParentOrg parentOrg;

            /**
             * Gets the value of the statusVersion property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getStatusVersion() {
                return statusVersion;
            }

            /**
             * Sets the value of the statusVersion property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setStatusVersion(String value) {
                this.statusVersion = value;
            }

            /**
             * Gets the value of the parentOrg property.
             * 
             * @return
             *     possible object is
             *     {@link ExportOrgRegistryResultType.OrgVersion.Subsidiary.ParentOrg }
             *     
             */
            public ExportOrgRegistryResultType.OrgVersion.Subsidiary.ParentOrg getParentOrg() {
                return parentOrg;
            }

            /**
             * Sets the value of the parentOrg property.
             * 
             * @param value
             *     allowed object is
             *     {@link ExportOrgRegistryResultType.OrgVersion.Subsidiary.ParentOrg }
             *     
             */
            public void setParentOrg(ExportOrgRegistryResultType.OrgVersion.Subsidiary.ParentOrg value) {
                this.parentOrg = value;
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
             *         &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/organizations-registry-base/}RegOrgVersion"/>
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
                "regOrgVersion"
            })
            public static class ParentOrg {

                @XmlElement(name = "RegOrgVersion", namespace = "http://dom.gosuslugi.ru/schema/integration/organizations-registry-base/", required = true)
                protected RegOrgVersionType regOrgVersion;

                /**
                 * Gets the value of the regOrgVersion property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link RegOrgVersionType }
                 *     
                 */
                public RegOrgVersionType getRegOrgVersion() {
                    return regOrgVersion;
                }

                /**
                 * Sets the value of the regOrgVersion property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link RegOrgVersionType }
                 *     
                 */
                public void setRegOrgVersion(RegOrgVersionType value) {
                    this.regOrgVersion = value;
                }

            }

        }

    }

}
