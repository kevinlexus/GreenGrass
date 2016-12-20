
package ru.gosuslugi.dom.schema.integration.inspection;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import ru.gosuslugi.dom.schema.integration.organizations_registry_base.RegOrgType;


/**
 * Сведения о субъекте проверки для внеплановой проверки в реестре (экспорт)
 * 
 * <p>Java class for ExportUnscheduledExaminationSubjectInfoType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ExportUnscheduledExaminationSubjectInfoType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;choice>
 *         &lt;element name="Organization">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/organizations-registry-base/}RegOrgType">
 *                 &lt;sequence>
 *                   &lt;element name="ActualActivityPlace" type="{http://dom.gosuslugi.ru/schema/integration/inspection/}String2000Type"/>
 *                   &lt;element name="OtherPersons" type="{http://dom.gosuslugi.ru/schema/integration/inspection/}String2000Type" minOccurs="0"/>
 *                 &lt;/sequence>
 *               &lt;/extension>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="Individual">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/organizations-registry-base/}RegOrgType">
 *                 &lt;sequence>
 *                   &lt;element name="ActualActivityPlace" type="{http://dom.gosuslugi.ru/schema/integration/inspection/}String2000Type"/>
 *                   &lt;element name="OtherPersons" type="{http://dom.gosuslugi.ru/schema/integration/inspection/}String2000Type" minOccurs="0"/>
 *                 &lt;/sequence>
 *               &lt;/extension>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="Citizen" type="{http://dom.gosuslugi.ru/schema/integration/inspection/}ExportCitizenInfoType"/>
 *       &lt;/choice>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ExportUnscheduledExaminationSubjectInfoType", propOrder = {
    "organization",
    "individual",
    "citizen"
})
public class ExportUnscheduledExaminationSubjectInfoType {

    @XmlElement(name = "Organization")
    protected ExportUnscheduledExaminationSubjectInfoType.Organization organization;
    @XmlElement(name = "Individual")
    protected ExportUnscheduledExaminationSubjectInfoType.Individual individual;
    @XmlElement(name = "Citizen")
    protected ExportCitizenInfoType citizen;

    /**
     * Gets the value of the organization property.
     * 
     * @return
     *     possible object is
     *     {@link ExportUnscheduledExaminationSubjectInfoType.Organization }
     *     
     */
    public ExportUnscheduledExaminationSubjectInfoType.Organization getOrganization() {
        return organization;
    }

    /**
     * Sets the value of the organization property.
     * 
     * @param value
     *     allowed object is
     *     {@link ExportUnscheduledExaminationSubjectInfoType.Organization }
     *     
     */
    public void setOrganization(ExportUnscheduledExaminationSubjectInfoType.Organization value) {
        this.organization = value;
    }

    /**
     * Gets the value of the individual property.
     * 
     * @return
     *     possible object is
     *     {@link ExportUnscheduledExaminationSubjectInfoType.Individual }
     *     
     */
    public ExportUnscheduledExaminationSubjectInfoType.Individual getIndividual() {
        return individual;
    }

    /**
     * Sets the value of the individual property.
     * 
     * @param value
     *     allowed object is
     *     {@link ExportUnscheduledExaminationSubjectInfoType.Individual }
     *     
     */
    public void setIndividual(ExportUnscheduledExaminationSubjectInfoType.Individual value) {
        this.individual = value;
    }

    /**
     * Gets the value of the citizen property.
     * 
     * @return
     *     possible object is
     *     {@link ExportCitizenInfoType }
     *     
     */
    public ExportCitizenInfoType getCitizen() {
        return citizen;
    }

    /**
     * Sets the value of the citizen property.
     * 
     * @param value
     *     allowed object is
     *     {@link ExportCitizenInfoType }
     *     
     */
    public void setCitizen(ExportCitizenInfoType value) {
        this.citizen = value;
    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/organizations-registry-base/}RegOrgType">
     *       &lt;sequence>
     *         &lt;element name="ActualActivityPlace" type="{http://dom.gosuslugi.ru/schema/integration/inspection/}String2000Type"/>
     *         &lt;element name="OtherPersons" type="{http://dom.gosuslugi.ru/schema/integration/inspection/}String2000Type" minOccurs="0"/>
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
        "actualActivityPlace",
        "otherPersons"
    })
    public static class Individual
        extends RegOrgType
    {

        @XmlElement(name = "ActualActivityPlace", required = true)
        protected String actualActivityPlace;
        @XmlElement(name = "OtherPersons")
        protected String otherPersons;

        /**
         * Gets the value of the actualActivityPlace property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getActualActivityPlace() {
            return actualActivityPlace;
        }

        /**
         * Sets the value of the actualActivityPlace property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setActualActivityPlace(String value) {
            this.actualActivityPlace = value;
        }

        /**
         * Gets the value of the otherPersons property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getOtherPersons() {
            return otherPersons;
        }

        /**
         * Sets the value of the otherPersons property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setOtherPersons(String value) {
            this.otherPersons = value;
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
     *     &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/organizations-registry-base/}RegOrgType">
     *       &lt;sequence>
     *         &lt;element name="ActualActivityPlace" type="{http://dom.gosuslugi.ru/schema/integration/inspection/}String2000Type"/>
     *         &lt;element name="OtherPersons" type="{http://dom.gosuslugi.ru/schema/integration/inspection/}String2000Type" minOccurs="0"/>
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
        "actualActivityPlace",
        "otherPersons"
    })
    public static class Organization
        extends RegOrgType
    {

        @XmlElement(name = "ActualActivityPlace", required = true)
        protected String actualActivityPlace;
        @XmlElement(name = "OtherPersons")
        protected String otherPersons;

        /**
         * Gets the value of the actualActivityPlace property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getActualActivityPlace() {
            return actualActivityPlace;
        }

        /**
         * Sets the value of the actualActivityPlace property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setActualActivityPlace(String value) {
            this.actualActivityPlace = value;
        }

        /**
         * Gets the value of the otherPersons property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getOtherPersons() {
            return otherPersons;
        }

        /**
         * Sets the value of the otherPersons property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setOtherPersons(String value) {
            this.otherPersons = value;
        }

    }

}
