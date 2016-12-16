
package ru.gosuslugi.dom.schema.integration.inspection;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import ru.gosuslugi.dom.schema.integration.organizations_registry_base.RegOrgType;


/**
 * Сведения о субъекте проверки для внеплановой проверки в плане
 * 
 * <p>Java class for UnscheduledExaminationSubjectInPlanInfoType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="UnscheduledExaminationSubjectInPlanInfoType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;choice>
 *         &lt;element name="Organization">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/organizations-registry-base/}RegOrgType">
 *                 &lt;sequence>
 *                   &lt;element name="ActualActivityPlace" type="{http://dom.gosuslugi.ru/schema/integration/inspection/}String2000Type"/>
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
 *                 &lt;/sequence>
 *               &lt;/extension>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="Citizen" type="{http://dom.gosuslugi.ru/schema/integration/inspection/}CitizenInfoType"/>
 *       &lt;/choice>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "UnscheduledExaminationSubjectInPlanInfoType", propOrder = {
    "organization",
    "individual",
    "citizen"
})
public class UnscheduledExaminationSubjectInPlanInfoType {

    @XmlElement(name = "Organization")
    protected UnscheduledExaminationSubjectInPlanInfoType.Organization organization;
    @XmlElement(name = "Individual")
    protected UnscheduledExaminationSubjectInPlanInfoType.Individual individual;
    @XmlElement(name = "Citizen")
    protected CitizenInfoType citizen;

    /**
     * Gets the value of the organization property.
     * 
     * @return
     *     possible object is
     *     {@link UnscheduledExaminationSubjectInPlanInfoType.Organization }
     *     
     */
    public UnscheduledExaminationSubjectInPlanInfoType.Organization getOrganization() {
        return organization;
    }

    /**
     * Sets the value of the organization property.
     * 
     * @param value
     *     allowed object is
     *     {@link UnscheduledExaminationSubjectInPlanInfoType.Organization }
     *     
     */
    public void setOrganization(UnscheduledExaminationSubjectInPlanInfoType.Organization value) {
        this.organization = value;
    }

    /**
     * Gets the value of the individual property.
     * 
     * @return
     *     possible object is
     *     {@link UnscheduledExaminationSubjectInPlanInfoType.Individual }
     *     
     */
    public UnscheduledExaminationSubjectInPlanInfoType.Individual getIndividual() {
        return individual;
    }

    /**
     * Sets the value of the individual property.
     * 
     * @param value
     *     allowed object is
     *     {@link UnscheduledExaminationSubjectInPlanInfoType.Individual }
     *     
     */
    public void setIndividual(UnscheduledExaminationSubjectInPlanInfoType.Individual value) {
        this.individual = value;
    }

    /**
     * Gets the value of the citizen property.
     * 
     * @return
     *     possible object is
     *     {@link CitizenInfoType }
     *     
     */
    public CitizenInfoType getCitizen() {
        return citizen;
    }

    /**
     * Sets the value of the citizen property.
     * 
     * @param value
     *     allowed object is
     *     {@link CitizenInfoType }
     *     
     */
    public void setCitizen(CitizenInfoType value) {
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
        "actualActivityPlace"
    })
    public static class Individual
        extends RegOrgType
    {

        @XmlElement(name = "ActualActivityPlace", required = true)
        protected String actualActivityPlace;

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
        "actualActivityPlace"
    })
    public static class Organization
        extends RegOrgType
    {

        @XmlElement(name = "ActualActivityPlace", required = true)
        protected String actualActivityPlace;

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

    }

}
