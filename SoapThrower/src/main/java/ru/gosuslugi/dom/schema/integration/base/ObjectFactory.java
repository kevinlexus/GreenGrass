
package ru.gosuslugi.dom.schema.integration.base;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the ru.gosuslugi.dom.schema.integration.base package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _ErrorMessage_QNAME = new QName("http://dom.gosuslugi.ru/schema/integration/base/", "ErrorMessage");
    private final static QName _OrgPPAGUID_QNAME = new QName("http://dom.gosuslugi.ru/schema/integration/base/", "orgPPAGUID");
    private final static QName _Year_QNAME = new QName("http://dom.gosuslugi.ru/schema/integration/base/", "Year");
    private final static QName _ISRequestHeader_QNAME = new QName("http://dom.gosuslugi.ru/schema/integration/base/", "ISRequestHeader");
    private final static QName _TransportGUID_QNAME = new QName("http://dom.gosuslugi.ru/schema/integration/base/", "TransportGUID");
    private final static QName _ModificationDate_QNAME = new QName("http://dom.gosuslugi.ru/schema/integration/base/", "ModificationDate");
    private final static QName _OKEI_QNAME = new QName("http://dom.gosuslugi.ru/schema/integration/base/", "OKEI");
    private final static QName _Month_QNAME = new QName("http://dom.gosuslugi.ru/schema/integration/base/", "Month");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: ru.gosuslugi.dom.schema.integration.base
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link AckRequest }
     * 
     */
    public AckRequest createAckRequest() {
        return new AckRequest();
    }

    /**
     * Create an instance of {@link CommonResultType }
     * 
     */
    public CommonResultType createCommonResultType() {
        return new CommonResultType();
    }

    /**
     * Create an instance of {@link BaseAsyncResponseType }
     * 
     */
    public BaseAsyncResponseType createBaseAsyncResponseType() {
        return new BaseAsyncResponseType();
    }

    /**
     * Create an instance of {@link BaseType }
     * 
     */
    public BaseType createBaseType() {
        return new BaseType();
    }

    /**
     * Create an instance of {@link ErrorMessageType }
     * 
     */
    public ErrorMessageType createErrorMessageType() {
        return new ErrorMessageType();
    }

    /**
     * Create an instance of {@link AttachmentType }
     * 
     */
    public AttachmentType createAttachmentType() {
        return new AttachmentType();
    }

    /**
     * Create an instance of {@link Attachment }
     * 
     */
    public Attachment createAttachment() {
        return new Attachment();
    }

    /**
     * Create an instance of {@link GetStateRequest }
     * 
     */
    public GetStateRequest createGetStateRequest() {
        return new GetStateRequest();
    }

    /**
     * Create an instance of {@link ImportResult }
     * 
     */
    public ImportResult createImportResult() {
        return new ImportResult();
    }

    /**
     * Create an instance of {@link AckRequest.Ack }
     * 
     */
    public AckRequest.Ack createAckRequestAck() {
        return new AckRequest.Ack();
    }

    /**
     * Create an instance of {@link Fault }
     * 
     */
    public Fault createFault() {
        return new Fault();
    }

    /**
     * Create an instance of {@link HeaderType }
     * 
     */
    public HeaderType createHeaderType() {
        return new HeaderType();
    }

    /**
     * Create an instance of {@link RequestHeader }
     * 
     */
    public RequestHeader createRequestHeader() {
        return new RequestHeader();
    }

    /**
     * Create an instance of {@link ResultHeader }
     * 
     */
    public ResultHeader createResultHeader() {
        return new ResultHeader();
    }

    /**
     * Create an instance of {@link RegionType }
     * 
     */
    public RegionType createRegionType() {
        return new RegionType();
    }

    /**
     * Create an instance of {@link DocumentPortalType }
     * 
     */
    public DocumentPortalType createDocumentPortalType() {
        return new DocumentPortalType();
    }

    /**
     * Create an instance of {@link OKTMORefType }
     * 
     */
    public OKTMORefType createOKTMORefType() {
        return new OKTMORefType();
    }

    /**
     * Create an instance of {@link ResultType }
     * 
     */
    public ResultType createResultType() {
        return new ResultType();
    }

    /**
     * Create an instance of {@link CommonResultType.Error }
     * 
     */
    public CommonResultType.Error createCommonResultTypeError() {
        return new CommonResultType.Error();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ErrorMessageType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://dom.gosuslugi.ru/schema/integration/base/", name = "ErrorMessage")
    public JAXBElement<ErrorMessageType> createErrorMessage(ErrorMessageType value) {
        return new JAXBElement<ErrorMessageType>(_ErrorMessage_QNAME, ErrorMessageType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://dom.gosuslugi.ru/schema/integration/base/", name = "orgPPAGUID")
    public JAXBElement<String> createOrgPPAGUID(String value) {
        return new JAXBElement<String>(_OrgPPAGUID_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Short }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://dom.gosuslugi.ru/schema/integration/base/", name = "Year")
    public JAXBElement<Short> createYear(Short value) {
        return new JAXBElement<Short>(_Year_QNAME, Short.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link HeaderType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://dom.gosuslugi.ru/schema/integration/base/", name = "ISRequestHeader")
    public JAXBElement<HeaderType> createISRequestHeader(HeaderType value) {
        return new JAXBElement<HeaderType>(_ISRequestHeader_QNAME, HeaderType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://dom.gosuslugi.ru/schema/integration/base/", name = "TransportGUID")
    public JAXBElement<String> createTransportGUID(String value) {
        return new JAXBElement<String>(_TransportGUID_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://dom.gosuslugi.ru/schema/integration/base/", name = "ModificationDate")
    public JAXBElement<XMLGregorianCalendar> createModificationDate(XMLGregorianCalendar value) {
        return new JAXBElement<XMLGregorianCalendar>(_ModificationDate_QNAME, XMLGregorianCalendar.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://dom.gosuslugi.ru/schema/integration/base/", name = "OKEI")
    public JAXBElement<String> createOKEI(String value) {
        return new JAXBElement<String>(_OKEI_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Integer }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://dom.gosuslugi.ru/schema/integration/base/", name = "Month")
    public JAXBElement<Integer> createMonth(Integer value) {
        return new JAXBElement<Integer>(_Month_QNAME, Integer.class, null, value);
    }

}
