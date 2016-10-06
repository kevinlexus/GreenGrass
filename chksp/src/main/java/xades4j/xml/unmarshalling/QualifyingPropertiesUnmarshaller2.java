package xades4j.xml.unmarshalling;

import org.w3c.dom.Element;
import xades4j.xml.bind.xades.XmlQualifyingPropertiesType;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

/**
 * Версия DefaultQualifyingPropertiesUnmarshaller из xades4j 1.3.2, которая игнорирует элемент {@code <xades:UnsignedProperties>}
 */
public class QualifyingPropertiesUnmarshaller2 implements QualifyingPropertiesUnmarshaller
{
    private static final JAXBContext jaxbContext;
    static
    {
        try
        {
            jaxbContext = JAXBContext.newInstance(XmlQualifyingPropertiesType.class);
        }
        catch(JAXBException e)
        {
            throw new UnsupportedOperationException(e);
        }
    }

    private final UnmarshallerModule[] modules;

    public QualifyingPropertiesUnmarshaller2()
    {
        this.modules = new UnmarshallerModule[2];
        this.modules[0] = new SignedSigPropsModule();
        this.modules[1] = new SignedDataObjPropsModule();
    }

    @Override
    public void unmarshalProperties(
            Element qualifyingProps,
            QualifyingPropertiesDataCollector propertyDataCollector) throws UnmarshalException
    {
        XmlQualifyingPropertiesType xmlQualifyingProps = null;
        try
        {
            // Create the JAXB unmarshaller and unmarshalProperties the root JAXB element
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            JAXBElement<XmlQualifyingPropertiesType> qualifPropsElem = (JAXBElement<XmlQualifyingPropertiesType>)unmarshaller.unmarshal(qualifyingProps);
            xmlQualifyingProps = qualifPropsElem.getValue();
        } catch (javax.xml.bind.UnmarshalException ex)
        {
            throw new UnmarshalException("Cannot bind XML elements to Java classes", ex);
        } catch (JAXBException ex)
        {
            throw new UnmarshalException("Cannot unmarshall properties. Error on JAXB unmarshalling.", ex);
        }

        // Iterate the modules to convert the different types of properties.
        for (UnmarshallerModule module : modules)
        {
            module.convertProperties(xmlQualifyingProps, qualifyingProps, propertyDataCollector);
        }
    }

    @Override
    public void setAcceptUnknownProperties(boolean accept)
    {
        for (UnmarshallerModule module : modules)
        {
            module.setAcceptUnknownProperties(accept);
        }
    }
}
