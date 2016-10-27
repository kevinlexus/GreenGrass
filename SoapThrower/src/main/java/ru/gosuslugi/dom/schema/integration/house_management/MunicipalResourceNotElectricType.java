
package ru.gosuslugi.dom.schema.integration.house_management;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;
import ru.gosuslugi.dom.schema.integration.metering_device_base.OneRateMeteringValueType;


/**
 * Сведения о коммунальном ресурсе и базовые показания ПУ (тепловая энергия, газ, горячая вода, холодная вода, сточные бытовые воды)
 * 
 * <p>Java class for MunicipalResourceNotElectricType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="MunicipalResourceNotElectricType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/metering-device-base/}OneRateMeteringValueType">
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "MunicipalResourceNotElectricType")
public class MunicipalResourceNotElectricType
    extends OneRateMeteringValueType
{


}
