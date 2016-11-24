
package ru.gosuslugi.dom.schema.integration.capital_repair;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Экспортируемый договор, сведения об оплате, акт на выполнение работ (оказание услуг) по капитальному ремонту
 * 
 * <p>Java class for exportFullContractType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="exportFullContractType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Contract" type="{http://dom.gosuslugi.ru/schema/integration/capital-repair/}exportContractType"/>
 *         &lt;element name="Certificate" type="{http://dom.gosuslugi.ru/schema/integration/capital-repair/}exportCertificateType" maxOccurs="1000" minOccurs="0"/>
 *         &lt;element name="PaymentInfo" type="{http://dom.gosuslugi.ru/schema/integration/capital-repair/}exportPaymentInfoType" maxOccurs="1000" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "exportFullContractType", propOrder = {
    "contract",
    "certificate",
    "paymentInfo"
})
public class ExportFullContractType {

    @XmlElement(name = "Contract", required = true)
    protected ExportContractType contract;
    @XmlElement(name = "Certificate")
    protected List<ExportCertificateType> certificate;
    @XmlElement(name = "PaymentInfo")
    protected List<ExportPaymentInfoType> paymentInfo;

    /**
     * Gets the value of the contract property.
     * 
     * @return
     *     possible object is
     *     {@link ExportContractType }
     *     
     */
    public ExportContractType getContract() {
        return contract;
    }

    /**
     * Sets the value of the contract property.
     * 
     * @param value
     *     allowed object is
     *     {@link ExportContractType }
     *     
     */
    public void setContract(ExportContractType value) {
        this.contract = value;
    }

    /**
     * Gets the value of the certificate property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the certificate property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCertificate().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ExportCertificateType }
     * 
     * 
     */
    public List<ExportCertificateType> getCertificate() {
        if (certificate == null) {
            certificate = new ArrayList<ExportCertificateType>();
        }
        return this.certificate;
    }

    /**
     * Gets the value of the paymentInfo property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the paymentInfo property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPaymentInfo().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ExportPaymentInfoType }
     * 
     * 
     */
    public List<ExportPaymentInfoType> getPaymentInfo() {
        if (paymentInfo == null) {
            paymentInfo = new ArrayList<ExportPaymentInfoType>();
        }
        return this.paymentInfo;
    }

}
