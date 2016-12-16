
package ru.gosuslugi.dom.schema.integration.licenses;

import java.math.BigInteger;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for exportLicenseResultType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="exportLicenseResultType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/licenses/}LicenseType">
 *       &lt;sequence>
 *         &lt;element name="LicenseGUID" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType"/>
 *         &lt;element name="LicenseVersion" type="{http://www.w3.org/2001/XMLSchema}nonNegativeInteger"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "exportLicenseResultType", propOrder = {
    "licenseGUID",
    "licenseVersion"
})
@XmlSeeAlso({
    ru.gosuslugi.dom.schema.integration.licenses.ExportLicenseResult.License.class
})
public class ExportLicenseResultType
    extends LicenseType
{

    @XmlElement(name = "LicenseGUID", required = true)
    protected String licenseGUID;
    @XmlElement(name = "LicenseVersion", required = true)
    @XmlSchemaType(name = "nonNegativeInteger")
    protected BigInteger licenseVersion;

    /**
     * Gets the value of the licenseGUID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLicenseGUID() {
        return licenseGUID;
    }

    /**
     * Sets the value of the licenseGUID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLicenseGUID(String value) {
        this.licenseGUID = value;
    }

    /**
     * Gets the value of the licenseVersion property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getLicenseVersion() {
        return licenseVersion;
    }

    /**
     * Sets the value of the licenseVersion property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setLicenseVersion(BigInteger value) {
        this.licenseVersion = value;
    }

}
