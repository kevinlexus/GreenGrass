
package ru.gosuslugi.dom.schema.integration.bills;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Статус текущего расчетного периода организации, включая расчетный период дома
 * 
 * <p>Java class for exportOrgPeriodResultType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="exportOrgPeriodResultType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/bills/}PaymentPeriodType">
 *       &lt;sequence>
 *         &lt;element name="HousePeriod" type="{http://dom.gosuslugi.ru/schema/integration/bills/}HousePaymentPeriodType" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "exportOrgPeriodResultType", propOrder = {
    "housePeriod"
})
public class ExportOrgPeriodResultType
    extends PaymentPeriodType
{

    @XmlElement(name = "HousePeriod")
    protected List<HousePaymentPeriodType> housePeriod;

    /**
     * Gets the value of the housePeriod property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the housePeriod property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getHousePeriod().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link HousePaymentPeriodType }
     * 
     * 
     */
    public List<HousePaymentPeriodType> getHousePeriod() {
        if (housePeriod == null) {
            housePeriod = new ArrayList<HousePaymentPeriodType>();
        }
        return this.housePeriod;
    }

}
