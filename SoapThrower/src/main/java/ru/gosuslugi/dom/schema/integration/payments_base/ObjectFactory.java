
package ru.gosuslugi.dom.schema.integration.payments_base;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the ru.gosuslugi.dom.schema.integration.payments_base package. 
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

    private final static QName _PaymentInformation_QNAME = new QName("http://dom.gosuslugi.ru/schema/integration/payments-base/", "PaymentInformation");
    private final static QName _BillingInfoGUID_QNAME = new QName("http://dom.gosuslugi.ru/schema/integration/payments-base/", "BillingInfoGUID");
    private final static QName _OrderID_QNAME = new QName("http://dom.gosuslugi.ru/schema/integration/payments-base/", "OrderID");
    private final static QName _AccountID_QNAME = new QName("http://dom.gosuslugi.ru/schema/integration/payments-base/", "AccountID");
    private final static QName _NotificationsOfOrderExecutionGUID_QNAME = new QName("http://dom.gosuslugi.ru/schema/integration/payments-base/", "NotificationsOfOrderExecutionGUID");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: ru.gosuslugi.dom.schema.integration.payments_base
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link NotificationOfOrderExecutionType }
     * 
     */
    public NotificationOfOrderExecutionType createNotificationOfOrderExecutionType() {
        return new NotificationOfOrderExecutionType();
    }

    /**
     * Create an instance of {@link NotificationOfOrderExecutionType.OrderInfo }
     * 
     */
    public NotificationOfOrderExecutionType.OrderInfo createNotificationOfOrderExecutionTypeOrderInfo() {
        return new NotificationOfOrderExecutionType.OrderInfo();
    }

    /**
     * Create an instance of {@link NotificationOfOrderExecutionType.RecipientInfo }
     * 
     */
    public NotificationOfOrderExecutionType.RecipientInfo createNotificationOfOrderExecutionTypeRecipientInfo() {
        return new NotificationOfOrderExecutionType.RecipientInfo();
    }

    /**
     * Create an instance of {@link NotificationOfOrderExecutionExportType }
     * 
     */
    public NotificationOfOrderExecutionExportType createNotificationOfOrderExecutionExportType() {
        return new NotificationOfOrderExecutionExportType();
    }

    /**
     * Create an instance of {@link NotificationOfOrderExecutionExportType.OrderInfo }
     * 
     */
    public NotificationOfOrderExecutionExportType.OrderInfo createNotificationOfOrderExecutionExportTypeOrderInfo() {
        return new NotificationOfOrderExecutionExportType.OrderInfo();
    }

    /**
     * Create an instance of {@link NotificationOfOrderExecutionExportType.RecipientInfo }
     * 
     */
    public NotificationOfOrderExecutionExportType.RecipientInfo createNotificationOfOrderExecutionExportTypeRecipientInfo() {
        return new NotificationOfOrderExecutionExportType.RecipientInfo();
    }

    /**
     * Create an instance of {@link AcknowledgmentRequestInfoType }
     * 
     */
    public AcknowledgmentRequestInfoType createAcknowledgmentRequestInfoType() {
        return new AcknowledgmentRequestInfoType();
    }

    /**
     * Create an instance of {@link PaymentInformationType }
     * 
     */
    public PaymentInformationType createPaymentInformationType() {
        return new PaymentInformationType();
    }

    /**
     * Create an instance of {@link NotificationOfOrderExecutionCancellationType }
     * 
     */
    public NotificationOfOrderExecutionCancellationType createNotificationOfOrderExecutionCancellationType() {
        return new NotificationOfOrderExecutionCancellationType();
    }

    /**
     * Create an instance of {@link PaymentInformationKeyType }
     * 
     */
    public PaymentInformationKeyType createPaymentInformationKeyType() {
        return new PaymentInformationKeyType();
    }

    /**
     * Create an instance of {@link PaymentInformationExportType }
     * 
     */
    public PaymentInformationExportType createPaymentInformationExportType() {
        return new PaymentInformationExportType();
    }

    /**
     * Create an instance of {@link NotificationOfOrderExecutionType.SupplierInfo }
     * 
     */
    public NotificationOfOrderExecutionType.SupplierInfo createNotificationOfOrderExecutionTypeSupplierInfo() {
        return new NotificationOfOrderExecutionType.SupplierInfo();
    }

    /**
     * Create an instance of {@link NotificationOfOrderExecutionType.OrderInfo.AddressAndConsumer }
     * 
     */
    public NotificationOfOrderExecutionType.OrderInfo.AddressAndConsumer createNotificationOfOrderExecutionTypeOrderInfoAddressAndConsumer() {
        return new NotificationOfOrderExecutionType.OrderInfo.AddressAndConsumer();
    }

    /**
     * Create an instance of {@link NotificationOfOrderExecutionType.OrderInfo.Service }
     * 
     */
    public NotificationOfOrderExecutionType.OrderInfo.Service createNotificationOfOrderExecutionTypeOrderInfoService() {
        return new NotificationOfOrderExecutionType.OrderInfo.Service();
    }

    /**
     * Create an instance of {@link NotificationOfOrderExecutionType.RecipientInfo.Legal }
     * 
     */
    public NotificationOfOrderExecutionType.RecipientInfo.Legal createNotificationOfOrderExecutionTypeRecipientInfoLegal() {
        return new NotificationOfOrderExecutionType.RecipientInfo.Legal();
    }

    /**
     * Create an instance of {@link NotificationOfOrderExecutionExportType.SupplierInfo }
     * 
     */
    public NotificationOfOrderExecutionExportType.SupplierInfo createNotificationOfOrderExecutionExportTypeSupplierInfo() {
        return new NotificationOfOrderExecutionExportType.SupplierInfo();
    }

    /**
     * Create an instance of {@link NotificationOfOrderExecutionExportType.OrderInfo.AddressAndConsumer }
     * 
     */
    public NotificationOfOrderExecutionExportType.OrderInfo.AddressAndConsumer createNotificationOfOrderExecutionExportTypeOrderInfoAddressAndConsumer() {
        return new NotificationOfOrderExecutionExportType.OrderInfo.AddressAndConsumer();
    }

    /**
     * Create an instance of {@link NotificationOfOrderExecutionExportType.OrderInfo.Service }
     * 
     */
    public NotificationOfOrderExecutionExportType.OrderInfo.Service createNotificationOfOrderExecutionExportTypeOrderInfoService() {
        return new NotificationOfOrderExecutionExportType.OrderInfo.Service();
    }

    /**
     * Create an instance of {@link NotificationOfOrderExecutionExportType.RecipientInfo.Legal }
     * 
     */
    public NotificationOfOrderExecutionExportType.RecipientInfo.Legal createNotificationOfOrderExecutionExportTypeRecipientInfoLegal() {
        return new NotificationOfOrderExecutionExportType.RecipientInfo.Legal();
    }

    /**
     * Create an instance of {@link AcknowledgmentRequestInfoType.PaymentDocumentAck }
     * 
     */
    public AcknowledgmentRequestInfoType.PaymentDocumentAck createAcknowledgmentRequestInfoTypePaymentDocumentAck() {
        return new AcknowledgmentRequestInfoType.PaymentDocumentAck();
    }

    /**
     * Create an instance of {@link AcknowledgmentRequestInfoType.AckImpossible }
     * 
     */
    public AcknowledgmentRequestInfoType.AckImpossible createAcknowledgmentRequestInfoTypeAckImpossible() {
        return new AcknowledgmentRequestInfoType.AckImpossible();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PaymentInformationType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://dom.gosuslugi.ru/schema/integration/payments-base/", name = "PaymentInformation")
    public JAXBElement<PaymentInformationType> createPaymentInformation(PaymentInformationType value) {
        return new JAXBElement<PaymentInformationType>(_PaymentInformation_QNAME, PaymentInformationType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://dom.gosuslugi.ru/schema/integration/payments-base/", name = "BillingInfoGUID")
    public JAXBElement<String> createBillingInfoGUID(String value) {
        return new JAXBElement<String>(_BillingInfoGUID_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://dom.gosuslugi.ru/schema/integration/payments-base/", name = "OrderID")
    public JAXBElement<String> createOrderID(String value) {
        return new JAXBElement<String>(_OrderID_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://dom.gosuslugi.ru/schema/integration/payments-base/", name = "AccountID")
    public JAXBElement<String> createAccountID(String value) {
        return new JAXBElement<String>(_AccountID_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://dom.gosuslugi.ru/schema/integration/payments-base/", name = "NotificationsOfOrderExecutionGUID")
    public JAXBElement<String> createNotificationsOfOrderExecutionGUID(String value) {
        return new JAXBElement<String>(_NotificationsOfOrderExecutionGUID_QNAME, String.class, null, value);
    }

}
