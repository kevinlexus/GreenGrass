
package ru.gosuslugi.dom.schema.integration.house_management;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;
import ru.gosuslugi.dom.schema.integration.nsi_base.NsiRef;


/**
 * <p>Java class for exportCAChResultType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="exportCAChResultType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;choice>
 *         &lt;element name="Contract">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/house-management/}ContractType">
 *                 &lt;sequence>
 *                   &lt;element name="Terminate" minOccurs="0">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/house-management/}TerminateType">
 *                           &lt;sequence>
 *                             &lt;element name="ReasonRef" type="{http://dom.gosuslugi.ru/schema/integration/nsi-base/}nsiRef"/>
 *                           &lt;/sequence>
 *                         &lt;/extension>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                   &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/house-management/}ContractStatus"/>
 *                   &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/house-management/}ContractGUID"/>
 *                   &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/house-management/}ContractVersionGUID"/>
 *                   &lt;element name="ContractObject" maxOccurs="unbounded">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/house-management/}ManageObjectType">
 *                           &lt;sequence>
 *                             &lt;element name="ContractObjectVersionGUID" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType"/>
 *                             &lt;element name="BaseMService" type="{http://dom.gosuslugi.ru/schema/integration/house-management/}BaseServiceType"/>
 *                             &lt;element name="HouseService" maxOccurs="unbounded" minOccurs="0">
 *                               &lt;complexType>
 *                                 &lt;complexContent>
 *                                   &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/house-management/}ContractServiceType">
 *                                     &lt;sequence>
 *                                       &lt;element name="BaseService" type="{http://dom.gosuslugi.ru/schema/integration/house-management/}BaseServiceType"/>
 *                                     &lt;/sequence>
 *                                   &lt;/extension>
 *                                 &lt;/complexContent>
 *                               &lt;/complexType>
 *                             &lt;/element>
 *                             &lt;element name="AddService" maxOccurs="unbounded" minOccurs="0">
 *                               &lt;complexType>
 *                                 &lt;complexContent>
 *                                   &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/house-management/}ContractServiceType">
 *                                     &lt;sequence>
 *                                       &lt;element name="BaseService" type="{http://dom.gosuslugi.ru/schema/integration/house-management/}BaseServiceType"/>
 *                                     &lt;/sequence>
 *                                   &lt;/extension>
 *                                 &lt;/complexContent>
 *                               &lt;/complexType>
 *                             &lt;/element>
 *                             &lt;element name="Exclusion" minOccurs="0">
 *                               &lt;complexType>
 *                                 &lt;complexContent>
 *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                     &lt;sequence>
 *                                       &lt;element name="BaseExclusion" type="{http://dom.gosuslugi.ru/schema/integration/house-management/}BaseServiceType"/>
 *                                       &lt;element name="DateExclusion" type="{http://www.w3.org/2001/XMLSchema}date"/>
 *                                     &lt;/sequence>
 *                                   &lt;/restriction>
 *                                 &lt;/complexContent>
 *                               &lt;/complexType>
 *                             &lt;/element>
 *                             &lt;element name="StatusObject" type="{http://dom.gosuslugi.ru/schema/integration/house-management/}StatusMKDType" minOccurs="0"/>
 *                           &lt;/sequence>
 *                         &lt;/extension>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                   &lt;element name="ContractPaymentsInfo" maxOccurs="unbounded" minOccurs="0">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/house-management/}ContractPaymentsInfoType">
 *                           &lt;sequence>
 *                             &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/house-management/}ContractPaymentsInfoVersionGUID"/>
 *                             &lt;element name="Status">
 *                               &lt;simpleType>
 *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                                   &lt;enumeration value="P"/>
 *                                   &lt;enumeration value="A"/>
 *                                 &lt;/restriction>
 *                               &lt;/simpleType>
 *                             &lt;/element>
 *                           &lt;/sequence>
 *                         &lt;/extension>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                 &lt;/sequence>
 *               &lt;/extension>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="Charter">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/house-management/}CharterType">
 *                 &lt;sequence>
 *                   &lt;element name="Terminate" minOccurs="0">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/house-management/}TerminateType">
 *                           &lt;sequence>
 *                             &lt;element name="Reason">
 *                               &lt;simpleType>
 *                                 &lt;restriction base="{http://dom.gosuslugi.ru/schema/integration/base/}LongTextType">
 *                                   &lt;maxLength value="255"/>
 *                                 &lt;/restriction>
 *                               &lt;/simpleType>
 *                             &lt;/element>
 *                           &lt;/sequence>
 *                         &lt;/extension>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                   &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/house-management/}CharterStatus"/>
 *                   &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/house-management/}CharterGUID"/>
 *                   &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/house-management/}CharterVersionGUID"/>
 *                   &lt;element name="ContractObject" maxOccurs="unbounded">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/house-management/}ManageObjectType">
 *                           &lt;sequence>
 *                             &lt;element name="ContractObjectVersionGUID" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType"/>
 *                             &lt;element name="BaseMService" type="{http://dom.gosuslugi.ru/schema/integration/house-management/}BaseServiceType"/>
 *                             &lt;element name="HouseService" maxOccurs="unbounded" minOccurs="0">
 *                               &lt;complexType>
 *                                 &lt;complexContent>
 *                                   &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/house-management/}ContractServiceType">
 *                                     &lt;sequence>
 *                                       &lt;element name="BaseService" type="{http://dom.gosuslugi.ru/schema/integration/house-management/}BaseServiceType"/>
 *                                     &lt;/sequence>
 *                                   &lt;/extension>
 *                                 &lt;/complexContent>
 *                               &lt;/complexType>
 *                             &lt;/element>
 *                             &lt;element name="AddService" maxOccurs="unbounded" minOccurs="0">
 *                               &lt;complexType>
 *                                 &lt;complexContent>
 *                                   &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/house-management/}ContractServiceType">
 *                                     &lt;sequence>
 *                                       &lt;element name="BaseService" type="{http://dom.gosuslugi.ru/schema/integration/house-management/}BaseServiceType"/>
 *                                     &lt;/sequence>
 *                                   &lt;/extension>
 *                                 &lt;/complexContent>
 *                               &lt;/complexType>
 *                             &lt;/element>
 *                             &lt;element name="Exclusion" minOccurs="0">
 *                               &lt;complexType>
 *                                 &lt;complexContent>
 *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                     &lt;sequence>
 *                                       &lt;element name="BaseExclusion" type="{http://dom.gosuslugi.ru/schema/integration/house-management/}BaseServiceType"/>
 *                                       &lt;element name="DateExclusion" type="{http://www.w3.org/2001/XMLSchema}date"/>
 *                                     &lt;/sequence>
 *                                   &lt;/restriction>
 *                                 &lt;/complexContent>
 *                               &lt;/complexType>
 *                             &lt;/element>
 *                             &lt;element name="StatusObject" type="{http://dom.gosuslugi.ru/schema/integration/house-management/}StatusMKDType" minOccurs="0"/>
 *                             &lt;element name="IsManagedByContract" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *                           &lt;/sequence>
 *                         &lt;/extension>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                   &lt;element name="CharterPaymentsInfo" maxOccurs="unbounded" minOccurs="0">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/house-management/}CharterPaymentsInfoType">
 *                           &lt;sequence>
 *                             &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/house-management/}CharterPaymentsInfoVersionGUID"/>
 *                             &lt;element name="Status">
 *                               &lt;simpleType>
 *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                                   &lt;enumeration value="P"/>
 *                                   &lt;enumeration value="A"/>
 *                                 &lt;/restriction>
 *                               &lt;/simpleType>
 *                             &lt;/element>
 *                           &lt;/sequence>
 *                         &lt;/extension>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                 &lt;/sequence>
 *               &lt;/extension>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *       &lt;/choice>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "exportCAChResultType", propOrder = {
    "contract",
    "charter"
})
public class ExportCAChResultType {

    @XmlElement(name = "Contract")
    protected ExportCAChResultType.Contract contract;
    @XmlElement(name = "Charter")
    protected ExportCAChResultType.Charter charter;

    /**
     * Gets the value of the contract property.
     * 
     * @return
     *     possible object is
     *     {@link ExportCAChResultType.Contract }
     *     
     */
    public ExportCAChResultType.Contract getContract() {
        return contract;
    }

    /**
     * Sets the value of the contract property.
     * 
     * @param value
     *     allowed object is
     *     {@link ExportCAChResultType.Contract }
     *     
     */
    public void setContract(ExportCAChResultType.Contract value) {
        this.contract = value;
    }

    /**
     * Gets the value of the charter property.
     * 
     * @return
     *     possible object is
     *     {@link ExportCAChResultType.Charter }
     *     
     */
    public ExportCAChResultType.Charter getCharter() {
        return charter;
    }

    /**
     * Sets the value of the charter property.
     * 
     * @param value
     *     allowed object is
     *     {@link ExportCAChResultType.Charter }
     *     
     */
    public void setCharter(ExportCAChResultType.Charter value) {
        this.charter = value;
    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/house-management/}CharterType">
     *       &lt;sequence>
     *         &lt;element name="Terminate" minOccurs="0">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/house-management/}TerminateType">
     *                 &lt;sequence>
     *                   &lt;element name="Reason">
     *                     &lt;simpleType>
     *                       &lt;restriction base="{http://dom.gosuslugi.ru/schema/integration/base/}LongTextType">
     *                         &lt;maxLength value="255"/>
     *                       &lt;/restriction>
     *                     &lt;/simpleType>
     *                   &lt;/element>
     *                 &lt;/sequence>
     *               &lt;/extension>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *         &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/house-management/}CharterStatus"/>
     *         &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/house-management/}CharterGUID"/>
     *         &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/house-management/}CharterVersionGUID"/>
     *         &lt;element name="ContractObject" maxOccurs="unbounded">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/house-management/}ManageObjectType">
     *                 &lt;sequence>
     *                   &lt;element name="ContractObjectVersionGUID" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType"/>
     *                   &lt;element name="BaseMService" type="{http://dom.gosuslugi.ru/schema/integration/house-management/}BaseServiceType"/>
     *                   &lt;element name="HouseService" maxOccurs="unbounded" minOccurs="0">
     *                     &lt;complexType>
     *                       &lt;complexContent>
     *                         &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/house-management/}ContractServiceType">
     *                           &lt;sequence>
     *                             &lt;element name="BaseService" type="{http://dom.gosuslugi.ru/schema/integration/house-management/}BaseServiceType"/>
     *                           &lt;/sequence>
     *                         &lt;/extension>
     *                       &lt;/complexContent>
     *                     &lt;/complexType>
     *                   &lt;/element>
     *                   &lt;element name="AddService" maxOccurs="unbounded" minOccurs="0">
     *                     &lt;complexType>
     *                       &lt;complexContent>
     *                         &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/house-management/}ContractServiceType">
     *                           &lt;sequence>
     *                             &lt;element name="BaseService" type="{http://dom.gosuslugi.ru/schema/integration/house-management/}BaseServiceType"/>
     *                           &lt;/sequence>
     *                         &lt;/extension>
     *                       &lt;/complexContent>
     *                     &lt;/complexType>
     *                   &lt;/element>
     *                   &lt;element name="Exclusion" minOccurs="0">
     *                     &lt;complexType>
     *                       &lt;complexContent>
     *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                           &lt;sequence>
     *                             &lt;element name="BaseExclusion" type="{http://dom.gosuslugi.ru/schema/integration/house-management/}BaseServiceType"/>
     *                             &lt;element name="DateExclusion" type="{http://www.w3.org/2001/XMLSchema}date"/>
     *                           &lt;/sequence>
     *                         &lt;/restriction>
     *                       &lt;/complexContent>
     *                     &lt;/complexType>
     *                   &lt;/element>
     *                   &lt;element name="StatusObject" type="{http://dom.gosuslugi.ru/schema/integration/house-management/}StatusMKDType" minOccurs="0"/>
     *                   &lt;element name="IsManagedByContract" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
     *                 &lt;/sequence>
     *               &lt;/extension>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *         &lt;element name="CharterPaymentsInfo" maxOccurs="unbounded" minOccurs="0">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/house-management/}CharterPaymentsInfoType">
     *                 &lt;sequence>
     *                   &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/house-management/}CharterPaymentsInfoVersionGUID"/>
     *                   &lt;element name="Status">
     *                     &lt;simpleType>
     *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *                         &lt;enumeration value="P"/>
     *                         &lt;enumeration value="A"/>
     *                       &lt;/restriction>
     *                     &lt;/simpleType>
     *                   &lt;/element>
     *                 &lt;/sequence>
     *               &lt;/extension>
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
        "terminate",
        "charterStatus",
        "charterGUID",
        "charterVersionGUID",
        "contractObject",
        "charterPaymentsInfo"
    })
    public static class Charter
        extends CharterType
    {

        @XmlElement(name = "Terminate")
        protected ExportCAChResultType.Charter.Terminate terminate;
        @XmlElement(name = "CharterStatus", required = true)
        protected String charterStatus;
        @XmlElement(name = "CharterGUID", required = true)
        protected String charterGUID;
        @XmlElement(name = "CharterVersionGUID", required = true)
        protected String charterVersionGUID;
        @XmlElement(name = "ContractObject", required = true)
        protected List<ExportCAChResultType.Charter.ContractObject> contractObject;
        @XmlElement(name = "CharterPaymentsInfo")
        protected List<ExportCAChResultType.Charter.CharterPaymentsInfo> charterPaymentsInfo;

        /**
         * Gets the value of the terminate property.
         * 
         * @return
         *     possible object is
         *     {@link ExportCAChResultType.Charter.Terminate }
         *     
         */
        public ExportCAChResultType.Charter.Terminate getTerminate() {
            return terminate;
        }

        /**
         * Sets the value of the terminate property.
         * 
         * @param value
         *     allowed object is
         *     {@link ExportCAChResultType.Charter.Terminate }
         *     
         */
        public void setTerminate(ExportCAChResultType.Charter.Terminate value) {
            this.terminate = value;
        }

        /**
         * Gets the value of the charterStatus property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getCharterStatus() {
            return charterStatus;
        }

        /**
         * Sets the value of the charterStatus property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setCharterStatus(String value) {
            this.charterStatus = value;
        }

        /**
         * Gets the value of the charterGUID property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getCharterGUID() {
            return charterGUID;
        }

        /**
         * Sets the value of the charterGUID property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setCharterGUID(String value) {
            this.charterGUID = value;
        }

        /**
         * Gets the value of the charterVersionGUID property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getCharterVersionGUID() {
            return charterVersionGUID;
        }

        /**
         * Sets the value of the charterVersionGUID property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setCharterVersionGUID(String value) {
            this.charterVersionGUID = value;
        }

        /**
         * Gets the value of the contractObject property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the contractObject property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getContractObject().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link ExportCAChResultType.Charter.ContractObject }
         * 
         * 
         */
        public List<ExportCAChResultType.Charter.ContractObject> getContractObject() {
            if (contractObject == null) {
                contractObject = new ArrayList<ExportCAChResultType.Charter.ContractObject>();
            }
            return this.contractObject;
        }

        /**
         * Gets the value of the charterPaymentsInfo property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the charterPaymentsInfo property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getCharterPaymentsInfo().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link ExportCAChResultType.Charter.CharterPaymentsInfo }
         * 
         * 
         */
        public List<ExportCAChResultType.Charter.CharterPaymentsInfo> getCharterPaymentsInfo() {
            if (charterPaymentsInfo == null) {
                charterPaymentsInfo = new ArrayList<ExportCAChResultType.Charter.CharterPaymentsInfo>();
            }
            return this.charterPaymentsInfo;
        }


        /**
         * <p>Java class for anonymous complex type.
         * 
         * <p>The following schema fragment specifies the expected content contained within this class.
         * 
         * <pre>
         * &lt;complexType>
         *   &lt;complexContent>
         *     &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/house-management/}CharterPaymentsInfoType">
         *       &lt;sequence>
         *         &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/house-management/}CharterPaymentsInfoVersionGUID"/>
         *         &lt;element name="Status">
         *           &lt;simpleType>
         *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
         *               &lt;enumeration value="P"/>
         *               &lt;enumeration value="A"/>
         *             &lt;/restriction>
         *           &lt;/simpleType>
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
            "charterPaymentsInfoVersionGUID",
            "status"
        })
        public static class CharterPaymentsInfo
            extends CharterPaymentsInfoType
        {

            @XmlElement(name = "CharterPaymentsInfoVersionGUID", required = true)
            protected String charterPaymentsInfoVersionGUID;
            @XmlElement(name = "Status", required = true)
            protected String status;

            /**
             * Gets the value of the charterPaymentsInfoVersionGUID property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getCharterPaymentsInfoVersionGUID() {
                return charterPaymentsInfoVersionGUID;
            }

            /**
             * Sets the value of the charterPaymentsInfoVersionGUID property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setCharterPaymentsInfoVersionGUID(String value) {
                this.charterPaymentsInfoVersionGUID = value;
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

        }


        /**
         * <p>Java class for anonymous complex type.
         * 
         * <p>The following schema fragment specifies the expected content contained within this class.
         * 
         * <pre>
         * &lt;complexType>
         *   &lt;complexContent>
         *     &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/house-management/}ManageObjectType">
         *       &lt;sequence>
         *         &lt;element name="ContractObjectVersionGUID" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType"/>
         *         &lt;element name="BaseMService" type="{http://dom.gosuslugi.ru/schema/integration/house-management/}BaseServiceType"/>
         *         &lt;element name="HouseService" maxOccurs="unbounded" minOccurs="0">
         *           &lt;complexType>
         *             &lt;complexContent>
         *               &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/house-management/}ContractServiceType">
         *                 &lt;sequence>
         *                   &lt;element name="BaseService" type="{http://dom.gosuslugi.ru/schema/integration/house-management/}BaseServiceType"/>
         *                 &lt;/sequence>
         *               &lt;/extension>
         *             &lt;/complexContent>
         *           &lt;/complexType>
         *         &lt;/element>
         *         &lt;element name="AddService" maxOccurs="unbounded" minOccurs="0">
         *           &lt;complexType>
         *             &lt;complexContent>
         *               &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/house-management/}ContractServiceType">
         *                 &lt;sequence>
         *                   &lt;element name="BaseService" type="{http://dom.gosuslugi.ru/schema/integration/house-management/}BaseServiceType"/>
         *                 &lt;/sequence>
         *               &lt;/extension>
         *             &lt;/complexContent>
         *           &lt;/complexType>
         *         &lt;/element>
         *         &lt;element name="Exclusion" minOccurs="0">
         *           &lt;complexType>
         *             &lt;complexContent>
         *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *                 &lt;sequence>
         *                   &lt;element name="BaseExclusion" type="{http://dom.gosuslugi.ru/schema/integration/house-management/}BaseServiceType"/>
         *                   &lt;element name="DateExclusion" type="{http://www.w3.org/2001/XMLSchema}date"/>
         *                 &lt;/sequence>
         *               &lt;/restriction>
         *             &lt;/complexContent>
         *           &lt;/complexType>
         *         &lt;/element>
         *         &lt;element name="StatusObject" type="{http://dom.gosuslugi.ru/schema/integration/house-management/}StatusMKDType" minOccurs="0"/>
         *         &lt;element name="IsManagedByContract" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
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
            "contractObjectVersionGUID",
            "baseMService",
            "houseService",
            "addService",
            "exclusion",
            "statusObject",
            "isManagedByContract"
        })
        public static class ContractObject
            extends ManageObjectType
        {

            @XmlElement(name = "ContractObjectVersionGUID", required = true)
            protected String contractObjectVersionGUID;
            @XmlElement(name = "BaseMService", required = true)
            protected BaseServiceType baseMService;
            @XmlElement(name = "HouseService")
            protected List<ExportCAChResultType.Charter.ContractObject.HouseService> houseService;
            @XmlElement(name = "AddService")
            protected List<ExportCAChResultType.Charter.ContractObject.AddService> addService;
            @XmlElement(name = "Exclusion")
            protected ExportCAChResultType.Charter.ContractObject.Exclusion exclusion;
            @XmlElement(name = "StatusObject")
            @XmlSchemaType(name = "string")
            protected StatusMKDType statusObject;
            @XmlElement(name = "IsManagedByContract")
            protected Boolean isManagedByContract;

            /**
             * Gets the value of the contractObjectVersionGUID property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getContractObjectVersionGUID() {
                return contractObjectVersionGUID;
            }

            /**
             * Sets the value of the contractObjectVersionGUID property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setContractObjectVersionGUID(String value) {
                this.contractObjectVersionGUID = value;
            }

            /**
             * Gets the value of the baseMService property.
             * 
             * @return
             *     possible object is
             *     {@link BaseServiceType }
             *     
             */
            public BaseServiceType getBaseMService() {
                return baseMService;
            }

            /**
             * Sets the value of the baseMService property.
             * 
             * @param value
             *     allowed object is
             *     {@link BaseServiceType }
             *     
             */
            public void setBaseMService(BaseServiceType value) {
                this.baseMService = value;
            }

            /**
             * Gets the value of the houseService property.
             * 
             * <p>
             * This accessor method returns a reference to the live list,
             * not a snapshot. Therefore any modification you make to the
             * returned list will be present inside the JAXB object.
             * This is why there is not a <CODE>set</CODE> method for the houseService property.
             * 
             * <p>
             * For example, to add a new item, do as follows:
             * <pre>
             *    getHouseService().add(newItem);
             * </pre>
             * 
             * 
             * <p>
             * Objects of the following type(s) are allowed in the list
             * {@link ExportCAChResultType.Charter.ContractObject.HouseService }
             * 
             * 
             */
            public List<ExportCAChResultType.Charter.ContractObject.HouseService> getHouseService() {
                if (houseService == null) {
                    houseService = new ArrayList<ExportCAChResultType.Charter.ContractObject.HouseService>();
                }
                return this.houseService;
            }

            /**
             * Gets the value of the addService property.
             * 
             * <p>
             * This accessor method returns a reference to the live list,
             * not a snapshot. Therefore any modification you make to the
             * returned list will be present inside the JAXB object.
             * This is why there is not a <CODE>set</CODE> method for the addService property.
             * 
             * <p>
             * For example, to add a new item, do as follows:
             * <pre>
             *    getAddService().add(newItem);
             * </pre>
             * 
             * 
             * <p>
             * Objects of the following type(s) are allowed in the list
             * {@link ExportCAChResultType.Charter.ContractObject.AddService }
             * 
             * 
             */
            public List<ExportCAChResultType.Charter.ContractObject.AddService> getAddService() {
                if (addService == null) {
                    addService = new ArrayList<ExportCAChResultType.Charter.ContractObject.AddService>();
                }
                return this.addService;
            }

            /**
             * Gets the value of the exclusion property.
             * 
             * @return
             *     possible object is
             *     {@link ExportCAChResultType.Charter.ContractObject.Exclusion }
             *     
             */
            public ExportCAChResultType.Charter.ContractObject.Exclusion getExclusion() {
                return exclusion;
            }

            /**
             * Sets the value of the exclusion property.
             * 
             * @param value
             *     allowed object is
             *     {@link ExportCAChResultType.Charter.ContractObject.Exclusion }
             *     
             */
            public void setExclusion(ExportCAChResultType.Charter.ContractObject.Exclusion value) {
                this.exclusion = value;
            }

            /**
             * Gets the value of the statusObject property.
             * 
             * @return
             *     possible object is
             *     {@link StatusMKDType }
             *     
             */
            public StatusMKDType getStatusObject() {
                return statusObject;
            }

            /**
             * Sets the value of the statusObject property.
             * 
             * @param value
             *     allowed object is
             *     {@link StatusMKDType }
             *     
             */
            public void setStatusObject(StatusMKDType value) {
                this.statusObject = value;
            }

            /**
             * Gets the value of the isManagedByContract property.
             * 
             * @return
             *     possible object is
             *     {@link Boolean }
             *     
             */
            public Boolean isIsManagedByContract() {
                return isManagedByContract;
            }

            /**
             * Sets the value of the isManagedByContract property.
             * 
             * @param value
             *     allowed object is
             *     {@link Boolean }
             *     
             */
            public void setIsManagedByContract(Boolean value) {
                this.isManagedByContract = value;
            }


            /**
             * <p>Java class for anonymous complex type.
             * 
             * <p>The following schema fragment specifies the expected content contained within this class.
             * 
             * <pre>
             * &lt;complexType>
             *   &lt;complexContent>
             *     &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/house-management/}ContractServiceType">
             *       &lt;sequence>
             *         &lt;element name="BaseService" type="{http://dom.gosuslugi.ru/schema/integration/house-management/}BaseServiceType"/>
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
                "baseService"
            })
            public static class AddService
                extends ContractServiceType
            {

                @XmlElement(name = "BaseService", required = true)
                protected BaseServiceType baseService;

                /**
                 * Gets the value of the baseService property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link BaseServiceType }
                 *     
                 */
                public BaseServiceType getBaseService() {
                    return baseService;
                }

                /**
                 * Sets the value of the baseService property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link BaseServiceType }
                 *     
                 */
                public void setBaseService(BaseServiceType value) {
                    this.baseService = value;
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
             *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
             *       &lt;sequence>
             *         &lt;element name="BaseExclusion" type="{http://dom.gosuslugi.ru/schema/integration/house-management/}BaseServiceType"/>
             *         &lt;element name="DateExclusion" type="{http://www.w3.org/2001/XMLSchema}date"/>
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
                "baseExclusion",
                "dateExclusion"
            })
            public static class Exclusion {

                @XmlElement(name = "BaseExclusion", required = true)
                protected BaseServiceType baseExclusion;
                @XmlElement(name = "DateExclusion", required = true)
                @XmlSchemaType(name = "date")
                protected XMLGregorianCalendar dateExclusion;

                /**
                 * Gets the value of the baseExclusion property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link BaseServiceType }
                 *     
                 */
                public BaseServiceType getBaseExclusion() {
                    return baseExclusion;
                }

                /**
                 * Sets the value of the baseExclusion property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link BaseServiceType }
                 *     
                 */
                public void setBaseExclusion(BaseServiceType value) {
                    this.baseExclusion = value;
                }

                /**
                 * Gets the value of the dateExclusion property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link XMLGregorianCalendar }
                 *     
                 */
                public XMLGregorianCalendar getDateExclusion() {
                    return dateExclusion;
                }

                /**
                 * Sets the value of the dateExclusion property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link XMLGregorianCalendar }
                 *     
                 */
                public void setDateExclusion(XMLGregorianCalendar value) {
                    this.dateExclusion = value;
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
             *     &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/house-management/}ContractServiceType">
             *       &lt;sequence>
             *         &lt;element name="BaseService" type="{http://dom.gosuslugi.ru/schema/integration/house-management/}BaseServiceType"/>
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
                "baseService"
            })
            public static class HouseService
                extends ContractServiceType
            {

                @XmlElement(name = "BaseService", required = true)
                protected BaseServiceType baseService;

                /**
                 * Gets the value of the baseService property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link BaseServiceType }
                 *     
                 */
                public BaseServiceType getBaseService() {
                    return baseService;
                }

                /**
                 * Sets the value of the baseService property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link BaseServiceType }
                 *     
                 */
                public void setBaseService(BaseServiceType value) {
                    this.baseService = value;
                }

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
         *     &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/house-management/}TerminateType">
         *       &lt;sequence>
         *         &lt;element name="Reason">
         *           &lt;simpleType>
         *             &lt;restriction base="{http://dom.gosuslugi.ru/schema/integration/base/}LongTextType">
         *               &lt;maxLength value="255"/>
         *             &lt;/restriction>
         *           &lt;/simpleType>
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
            "reason"
        })
        public static class Terminate
            extends TerminateType
        {

            @XmlElement(name = "Reason", required = true)
            protected String reason;

            /**
             * Gets the value of the reason property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getReason() {
                return reason;
            }

            /**
             * Sets the value of the reason property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setReason(String value) {
                this.reason = value;
            }

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
     *     &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/house-management/}ContractType">
     *       &lt;sequence>
     *         &lt;element name="Terminate" minOccurs="0">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/house-management/}TerminateType">
     *                 &lt;sequence>
     *                   &lt;element name="ReasonRef" type="{http://dom.gosuslugi.ru/schema/integration/nsi-base/}nsiRef"/>
     *                 &lt;/sequence>
     *               &lt;/extension>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *         &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/house-management/}ContractStatus"/>
     *         &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/house-management/}ContractGUID"/>
     *         &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/house-management/}ContractVersionGUID"/>
     *         &lt;element name="ContractObject" maxOccurs="unbounded">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/house-management/}ManageObjectType">
     *                 &lt;sequence>
     *                   &lt;element name="ContractObjectVersionGUID" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType"/>
     *                   &lt;element name="BaseMService" type="{http://dom.gosuslugi.ru/schema/integration/house-management/}BaseServiceType"/>
     *                   &lt;element name="HouseService" maxOccurs="unbounded" minOccurs="0">
     *                     &lt;complexType>
     *                       &lt;complexContent>
     *                         &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/house-management/}ContractServiceType">
     *                           &lt;sequence>
     *                             &lt;element name="BaseService" type="{http://dom.gosuslugi.ru/schema/integration/house-management/}BaseServiceType"/>
     *                           &lt;/sequence>
     *                         &lt;/extension>
     *                       &lt;/complexContent>
     *                     &lt;/complexType>
     *                   &lt;/element>
     *                   &lt;element name="AddService" maxOccurs="unbounded" minOccurs="0">
     *                     &lt;complexType>
     *                       &lt;complexContent>
     *                         &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/house-management/}ContractServiceType">
     *                           &lt;sequence>
     *                             &lt;element name="BaseService" type="{http://dom.gosuslugi.ru/schema/integration/house-management/}BaseServiceType"/>
     *                           &lt;/sequence>
     *                         &lt;/extension>
     *                       &lt;/complexContent>
     *                     &lt;/complexType>
     *                   &lt;/element>
     *                   &lt;element name="Exclusion" minOccurs="0">
     *                     &lt;complexType>
     *                       &lt;complexContent>
     *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                           &lt;sequence>
     *                             &lt;element name="BaseExclusion" type="{http://dom.gosuslugi.ru/schema/integration/house-management/}BaseServiceType"/>
     *                             &lt;element name="DateExclusion" type="{http://www.w3.org/2001/XMLSchema}date"/>
     *                           &lt;/sequence>
     *                         &lt;/restriction>
     *                       &lt;/complexContent>
     *                     &lt;/complexType>
     *                   &lt;/element>
     *                   &lt;element name="StatusObject" type="{http://dom.gosuslugi.ru/schema/integration/house-management/}StatusMKDType" minOccurs="0"/>
     *                 &lt;/sequence>
     *               &lt;/extension>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *         &lt;element name="ContractPaymentsInfo" maxOccurs="unbounded" minOccurs="0">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/house-management/}ContractPaymentsInfoType">
     *                 &lt;sequence>
     *                   &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/house-management/}ContractPaymentsInfoVersionGUID"/>
     *                   &lt;element name="Status">
     *                     &lt;simpleType>
     *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *                         &lt;enumeration value="P"/>
     *                         &lt;enumeration value="A"/>
     *                       &lt;/restriction>
     *                     &lt;/simpleType>
     *                   &lt;/element>
     *                 &lt;/sequence>
     *               &lt;/extension>
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
        "terminate",
        "contractStatus",
        "contractGUID",
        "contractVersionGUID",
        "contractObject",
        "contractPaymentsInfo"
    })
    public static class Contract
        extends ContractType
    {

        @XmlElement(name = "Terminate")
        protected ExportCAChResultType.Contract.Terminate terminate;
        @XmlElement(name = "ContractStatus", required = true)
        protected String contractStatus;
        @XmlElement(name = "ContractGUID", required = true)
        protected String contractGUID;
        @XmlElement(name = "ContractVersionGUID", required = true)
        protected String contractVersionGUID;
        @XmlElement(name = "ContractObject", required = true)
        protected List<ExportCAChResultType.Contract.ContractObject> contractObject;
        @XmlElement(name = "ContractPaymentsInfo")
        protected List<ExportCAChResultType.Contract.ContractPaymentsInfo> contractPaymentsInfo;

        /**
         * Gets the value of the terminate property.
         * 
         * @return
         *     possible object is
         *     {@link ExportCAChResultType.Contract.Terminate }
         *     
         */
        public ExportCAChResultType.Contract.Terminate getTerminate() {
            return terminate;
        }

        /**
         * Sets the value of the terminate property.
         * 
         * @param value
         *     allowed object is
         *     {@link ExportCAChResultType.Contract.Terminate }
         *     
         */
        public void setTerminate(ExportCAChResultType.Contract.Terminate value) {
            this.terminate = value;
        }

        /**
         * Gets the value of the contractStatus property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getContractStatus() {
            return contractStatus;
        }

        /**
         * Sets the value of the contractStatus property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setContractStatus(String value) {
            this.contractStatus = value;
        }

        /**
         * Gets the value of the contractGUID property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getContractGUID() {
            return contractGUID;
        }

        /**
         * Sets the value of the contractGUID property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setContractGUID(String value) {
            this.contractGUID = value;
        }

        /**
         * Gets the value of the contractVersionGUID property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getContractVersionGUID() {
            return contractVersionGUID;
        }

        /**
         * Sets the value of the contractVersionGUID property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setContractVersionGUID(String value) {
            this.contractVersionGUID = value;
        }

        /**
         * Gets the value of the contractObject property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the contractObject property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getContractObject().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link ExportCAChResultType.Contract.ContractObject }
         * 
         * 
         */
        public List<ExportCAChResultType.Contract.ContractObject> getContractObject() {
            if (contractObject == null) {
                contractObject = new ArrayList<ExportCAChResultType.Contract.ContractObject>();
            }
            return this.contractObject;
        }

        /**
         * Gets the value of the contractPaymentsInfo property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the contractPaymentsInfo property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getContractPaymentsInfo().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link ExportCAChResultType.Contract.ContractPaymentsInfo }
         * 
         * 
         */
        public List<ExportCAChResultType.Contract.ContractPaymentsInfo> getContractPaymentsInfo() {
            if (contractPaymentsInfo == null) {
                contractPaymentsInfo = new ArrayList<ExportCAChResultType.Contract.ContractPaymentsInfo>();
            }
            return this.contractPaymentsInfo;
        }


        /**
         * <p>Java class for anonymous complex type.
         * 
         * <p>The following schema fragment specifies the expected content contained within this class.
         * 
         * <pre>
         * &lt;complexType>
         *   &lt;complexContent>
         *     &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/house-management/}ManageObjectType">
         *       &lt;sequence>
         *         &lt;element name="ContractObjectVersionGUID" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType"/>
         *         &lt;element name="BaseMService" type="{http://dom.gosuslugi.ru/schema/integration/house-management/}BaseServiceType"/>
         *         &lt;element name="HouseService" maxOccurs="unbounded" minOccurs="0">
         *           &lt;complexType>
         *             &lt;complexContent>
         *               &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/house-management/}ContractServiceType">
         *                 &lt;sequence>
         *                   &lt;element name="BaseService" type="{http://dom.gosuslugi.ru/schema/integration/house-management/}BaseServiceType"/>
         *                 &lt;/sequence>
         *               &lt;/extension>
         *             &lt;/complexContent>
         *           &lt;/complexType>
         *         &lt;/element>
         *         &lt;element name="AddService" maxOccurs="unbounded" minOccurs="0">
         *           &lt;complexType>
         *             &lt;complexContent>
         *               &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/house-management/}ContractServiceType">
         *                 &lt;sequence>
         *                   &lt;element name="BaseService" type="{http://dom.gosuslugi.ru/schema/integration/house-management/}BaseServiceType"/>
         *                 &lt;/sequence>
         *               &lt;/extension>
         *             &lt;/complexContent>
         *           &lt;/complexType>
         *         &lt;/element>
         *         &lt;element name="Exclusion" minOccurs="0">
         *           &lt;complexType>
         *             &lt;complexContent>
         *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *                 &lt;sequence>
         *                   &lt;element name="BaseExclusion" type="{http://dom.gosuslugi.ru/schema/integration/house-management/}BaseServiceType"/>
         *                   &lt;element name="DateExclusion" type="{http://www.w3.org/2001/XMLSchema}date"/>
         *                 &lt;/sequence>
         *               &lt;/restriction>
         *             &lt;/complexContent>
         *           &lt;/complexType>
         *         &lt;/element>
         *         &lt;element name="StatusObject" type="{http://dom.gosuslugi.ru/schema/integration/house-management/}StatusMKDType" minOccurs="0"/>
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
            "contractObjectVersionGUID",
            "baseMService",
            "houseService",
            "addService",
            "exclusion",
            "statusObject"
        })
        public static class ContractObject
            extends ManageObjectType
        {

            @XmlElement(name = "ContractObjectVersionGUID", required = true)
            protected String contractObjectVersionGUID;
            @XmlElement(name = "BaseMService", required = true)
            protected BaseServiceType baseMService;
            @XmlElement(name = "HouseService")
            protected List<ExportCAChResultType.Contract.ContractObject.HouseService> houseService;
            @XmlElement(name = "AddService")
            protected List<ExportCAChResultType.Contract.ContractObject.AddService> addService;
            @XmlElement(name = "Exclusion")
            protected ExportCAChResultType.Contract.ContractObject.Exclusion exclusion;
            @XmlElement(name = "StatusObject")
            @XmlSchemaType(name = "string")
            protected StatusMKDType statusObject;

            /**
             * Gets the value of the contractObjectVersionGUID property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getContractObjectVersionGUID() {
                return contractObjectVersionGUID;
            }

            /**
             * Sets the value of the contractObjectVersionGUID property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setContractObjectVersionGUID(String value) {
                this.contractObjectVersionGUID = value;
            }

            /**
             * Gets the value of the baseMService property.
             * 
             * @return
             *     possible object is
             *     {@link BaseServiceType }
             *     
             */
            public BaseServiceType getBaseMService() {
                return baseMService;
            }

            /**
             * Sets the value of the baseMService property.
             * 
             * @param value
             *     allowed object is
             *     {@link BaseServiceType }
             *     
             */
            public void setBaseMService(BaseServiceType value) {
                this.baseMService = value;
            }

            /**
             * Gets the value of the houseService property.
             * 
             * <p>
             * This accessor method returns a reference to the live list,
             * not a snapshot. Therefore any modification you make to the
             * returned list will be present inside the JAXB object.
             * This is why there is not a <CODE>set</CODE> method for the houseService property.
             * 
             * <p>
             * For example, to add a new item, do as follows:
             * <pre>
             *    getHouseService().add(newItem);
             * </pre>
             * 
             * 
             * <p>
             * Objects of the following type(s) are allowed in the list
             * {@link ExportCAChResultType.Contract.ContractObject.HouseService }
             * 
             * 
             */
            public List<ExportCAChResultType.Contract.ContractObject.HouseService> getHouseService() {
                if (houseService == null) {
                    houseService = new ArrayList<ExportCAChResultType.Contract.ContractObject.HouseService>();
                }
                return this.houseService;
            }

            /**
             * Gets the value of the addService property.
             * 
             * <p>
             * This accessor method returns a reference to the live list,
             * not a snapshot. Therefore any modification you make to the
             * returned list will be present inside the JAXB object.
             * This is why there is not a <CODE>set</CODE> method for the addService property.
             * 
             * <p>
             * For example, to add a new item, do as follows:
             * <pre>
             *    getAddService().add(newItem);
             * </pre>
             * 
             * 
             * <p>
             * Objects of the following type(s) are allowed in the list
             * {@link ExportCAChResultType.Contract.ContractObject.AddService }
             * 
             * 
             */
            public List<ExportCAChResultType.Contract.ContractObject.AddService> getAddService() {
                if (addService == null) {
                    addService = new ArrayList<ExportCAChResultType.Contract.ContractObject.AddService>();
                }
                return this.addService;
            }

            /**
             * Gets the value of the exclusion property.
             * 
             * @return
             *     possible object is
             *     {@link ExportCAChResultType.Contract.ContractObject.Exclusion }
             *     
             */
            public ExportCAChResultType.Contract.ContractObject.Exclusion getExclusion() {
                return exclusion;
            }

            /**
             * Sets the value of the exclusion property.
             * 
             * @param value
             *     allowed object is
             *     {@link ExportCAChResultType.Contract.ContractObject.Exclusion }
             *     
             */
            public void setExclusion(ExportCAChResultType.Contract.ContractObject.Exclusion value) {
                this.exclusion = value;
            }

            /**
             * Gets the value of the statusObject property.
             * 
             * @return
             *     possible object is
             *     {@link StatusMKDType }
             *     
             */
            public StatusMKDType getStatusObject() {
                return statusObject;
            }

            /**
             * Sets the value of the statusObject property.
             * 
             * @param value
             *     allowed object is
             *     {@link StatusMKDType }
             *     
             */
            public void setStatusObject(StatusMKDType value) {
                this.statusObject = value;
            }


            /**
             * <p>Java class for anonymous complex type.
             * 
             * <p>The following schema fragment specifies the expected content contained within this class.
             * 
             * <pre>
             * &lt;complexType>
             *   &lt;complexContent>
             *     &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/house-management/}ContractServiceType">
             *       &lt;sequence>
             *         &lt;element name="BaseService" type="{http://dom.gosuslugi.ru/schema/integration/house-management/}BaseServiceType"/>
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
                "baseService"
            })
            public static class AddService
                extends ContractServiceType
            {

                @XmlElement(name = "BaseService", required = true)
                protected BaseServiceType baseService;

                /**
                 * Gets the value of the baseService property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link BaseServiceType }
                 *     
                 */
                public BaseServiceType getBaseService() {
                    return baseService;
                }

                /**
                 * Sets the value of the baseService property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link BaseServiceType }
                 *     
                 */
                public void setBaseService(BaseServiceType value) {
                    this.baseService = value;
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
             *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
             *       &lt;sequence>
             *         &lt;element name="BaseExclusion" type="{http://dom.gosuslugi.ru/schema/integration/house-management/}BaseServiceType"/>
             *         &lt;element name="DateExclusion" type="{http://www.w3.org/2001/XMLSchema}date"/>
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
                "baseExclusion",
                "dateExclusion"
            })
            public static class Exclusion {

                @XmlElement(name = "BaseExclusion", required = true)
                protected BaseServiceType baseExclusion;
                @XmlElement(name = "DateExclusion", required = true)
                @XmlSchemaType(name = "date")
                protected XMLGregorianCalendar dateExclusion;

                /**
                 * Gets the value of the baseExclusion property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link BaseServiceType }
                 *     
                 */
                public BaseServiceType getBaseExclusion() {
                    return baseExclusion;
                }

                /**
                 * Sets the value of the baseExclusion property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link BaseServiceType }
                 *     
                 */
                public void setBaseExclusion(BaseServiceType value) {
                    this.baseExclusion = value;
                }

                /**
                 * Gets the value of the dateExclusion property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link XMLGregorianCalendar }
                 *     
                 */
                public XMLGregorianCalendar getDateExclusion() {
                    return dateExclusion;
                }

                /**
                 * Sets the value of the dateExclusion property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link XMLGregorianCalendar }
                 *     
                 */
                public void setDateExclusion(XMLGregorianCalendar value) {
                    this.dateExclusion = value;
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
             *     &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/house-management/}ContractServiceType">
             *       &lt;sequence>
             *         &lt;element name="BaseService" type="{http://dom.gosuslugi.ru/schema/integration/house-management/}BaseServiceType"/>
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
                "baseService"
            })
            public static class HouseService
                extends ContractServiceType
            {

                @XmlElement(name = "BaseService", required = true)
                protected BaseServiceType baseService;

                /**
                 * Gets the value of the baseService property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link BaseServiceType }
                 *     
                 */
                public BaseServiceType getBaseService() {
                    return baseService;
                }

                /**
                 * Sets the value of the baseService property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link BaseServiceType }
                 *     
                 */
                public void setBaseService(BaseServiceType value) {
                    this.baseService = value;
                }

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
         *     &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/house-management/}ContractPaymentsInfoType">
         *       &lt;sequence>
         *         &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/house-management/}ContractPaymentsInfoVersionGUID"/>
         *         &lt;element name="Status">
         *           &lt;simpleType>
         *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
         *               &lt;enumeration value="P"/>
         *               &lt;enumeration value="A"/>
         *             &lt;/restriction>
         *           &lt;/simpleType>
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
            "contractPaymentsInfoVersionGUID",
            "status"
        })
        public static class ContractPaymentsInfo
            extends ContractPaymentsInfoType
        {

            @XmlElement(name = "ContractPaymentsInfoVersionGUID", required = true)
            protected String contractPaymentsInfoVersionGUID;
            @XmlElement(name = "Status", required = true)
            protected String status;

            /**
             * Gets the value of the contractPaymentsInfoVersionGUID property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getContractPaymentsInfoVersionGUID() {
                return contractPaymentsInfoVersionGUID;
            }

            /**
             * Sets the value of the contractPaymentsInfoVersionGUID property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setContractPaymentsInfoVersionGUID(String value) {
                this.contractPaymentsInfoVersionGUID = value;
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

        }


        /**
         * <p>Java class for anonymous complex type.
         * 
         * <p>The following schema fragment specifies the expected content contained within this class.
         * 
         * <pre>
         * &lt;complexType>
         *   &lt;complexContent>
         *     &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/house-management/}TerminateType">
         *       &lt;sequence>
         *         &lt;element name="ReasonRef" type="{http://dom.gosuslugi.ru/schema/integration/nsi-base/}nsiRef"/>
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
            "reasonRef"
        })
        public static class Terminate
            extends TerminateType
        {

            @XmlElement(name = "ReasonRef", required = true)
            protected NsiRef reasonRef;

            /**
             * Gets the value of the reasonRef property.
             * 
             * @return
             *     possible object is
             *     {@link NsiRef }
             *     
             */
            public NsiRef getReasonRef() {
                return reasonRef;
            }

            /**
             * Sets the value of the reasonRef property.
             * 
             * @param value
             *     allowed object is
             *     {@link NsiRef }
             *     
             */
            public void setReasonRef(NsiRef value) {
                this.reasonRef = value;
            }

        }

    }

}
