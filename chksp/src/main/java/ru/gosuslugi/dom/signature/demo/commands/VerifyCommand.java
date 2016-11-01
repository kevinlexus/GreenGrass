package ru.gosuslugi.dom.signature.demo.commands;

import org.apache.commons.lang.StringUtils;
import org.apache.xml.security.exceptions.XMLSecurityException;
import org.apache.xml.security.signature.Reference;
import org.apache.xml.security.signature.SignedInfo;
import org.apache.xml.security.utils.Constants;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import ru.gosuslugi.dom.signature.demo.args.VerifyParameters;
import ru.gosuslugi.dom.signature.demo.exceptions.SignatureVerificationException;
import ru.gosuslugi.dom.signature.demo.jce.KeyStoreUtils;
import ru.gosuslugi.dom.signature.demo.jce.ProviderFactory;
import ru.gosuslugi.dom.signature.demo.xades.Consts;
import ru.gosuslugi.dom.signature.demo.xades.providers.CustomizableMessageDigestEngineProvider;
import ru.gosuslugi.dom.signature.demo.xades.providers.NoCheckCertificateProvider;
import ru.gosuslugi.dom.signature.demo.xades.verification.SigningCertificateVerifier2;
import ru.gosuslugi.dom.signature.demo.xml.IdResolver;
import ru.gosuslugi.dom.signature.demo.xml.SimpleNamespaceContext;
import ru.gosuslugi.dom.signature.demo.xml.XMLParser;
import xades4j.XAdES4jException;
import xades4j.properties.data.SigningCertificateData;
import xades4j.providers.CertificateValidationProvider;
import xades4j.providers.MessageDigestEngineProvider;
import xades4j.providers.impl.PKIXCertificateValidationProvider;
import xades4j.verification.SignatureSpecificVerificationOptions;
import xades4j.verification.XAdESVerificationResult;
import xades4j.verification.XadesVerificationProfile;
import xades4j.verification.XadesVerifier;
import xades4j.xml.unmarshalling.QualifyingPropertiesUnmarshaller;
import xades4j.xml.unmarshalling.QualifyingPropertiesUnmarshaller2;

import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathFactory;

import java.security.GeneralSecurityException;
import java.security.KeyStore;
import java.security.Provider;
import java.security.Security;
import java.security.cert.CertStore;
import java.security.cert.CollectionCertStoreParameters;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Выполняет проверку подписи в XML-документе.
 */
public class VerifyCommand implements Command {
    private VerifyParameters parameters;

    public VerifyCommand(VerifyParameters parameters) {
        this.parameters = parameters;
    }

    @Override
    public void execute() throws Exception {
        // инициализируем Apache Santuario
        org.apache.xml.security.Init.init();

        // загружаем криптопровайдер для проверки подписи и работы с сертификатами
        String providerName = parameters.getProviderName();
        Provider provider = providerName == null ? null : Security.getProvider(providerName);
        if (provider == null) {
            provider = ProviderFactory.createProvider(parameters.getProviderClass(), parameters.getProviderArg());
            Security.addProvider(provider);
        }

        // подключаем криптопровайдер Bouncy Castle (нужен для построения цепочки сертификатов)
        if (Security.getProvider(BouncyCastleProvider.PROVIDER_NAME) == null) {
            Security.addProvider(new BouncyCastleProvider());
        }

        // создаем провайдер, ответственный за построение цепочки сертификации
        CertificateValidationProvider certValidator = createCertificateValidationProvider(provider);

        // создаем провайдер, ответственный за расчет хешей
        MessageDigestEngineProvider messageDigestEngineProvider = new CustomizableMessageDigestEngineProvider(Consts.DIGEST_ALGORITHM_NAME, provider);

        // настраиваем профиль проверки
        XadesVerificationProfile vp = new XadesVerificationProfile(certValidator);
        vp.withBinding(MessageDigestEngineProvider.class, messageDigestEngineProvider);
        vp.withBinding(QualifyingPropertiesUnmarshaller.class, QualifyingPropertiesUnmarshaller2.class);
        vp.withQualifyingPropertyVerifier(SigningCertificateData.class, SigningCertificateVerifier2.class);

        // создаем объект, ответственный за проверку подписи
        XadesVerifier verifier = vp.newVerifier();

        // настраиваем параметры проверки подписи
        SignatureSpecificVerificationOptions verificationOptions = new SignatureSpecificVerificationOptions();

        // загружаем проверяемый XML-документ
        Document document = XMLParser.parseXml(parameters.getInputFile());

        // объявляем атрибут Id в качестве идентифицирующего
        IdResolver.resolveIds(document.getDocumentElement());

        String signatureId = parameters.getSignatureId();
        if (signatureId != null) { // проверка одной подписи
            Element signatureElement = document.getElementById(signatureId);

            // проверяем подпись
            XAdESVerificationResult vr = verifySignature(verifier, verificationOptions, signatureElement);

            // выводим информацию про подпись
            System.out.println("Signature is valid");
            printSignatureInfo(vr);
        } else { // проверка всех подписей в документе
            // создаем XPath-выражение для поиска всех подписей в документе
            XPath xpath = XPathFactory.newInstance().newXPath();
            xpath.setNamespaceContext(new SimpleNamespaceContext(new HashMap<String, String>() {{
                put("ds", Constants.SignatureSpecNS);
            }}));

            // ищем все подписи в документе
            NodeList nodes = (NodeList) xpath.evaluate("//ds:Signature", document, XPathConstants.NODESET);

            // выводим количество подписей
            System.out.println("The document contains " + nodes.getLength() + " signature(s).");

            // проверяем все подписи и выводим информацию про каждую подпись
            for (int i = 0, count = nodes.getLength(); i < count; i++) {
                Element signatureElement = (Element) nodes.item(i);

                // проверяем подпись
                XAdESVerificationResult vr = verifySignature(verifier, verificationOptions, signatureElement);

                // выводим информацию про подпись
                System.out.println();
                System.out.println("Signature # " + (i + 1) + " is valid:");
                printSignatureInfo(vr);
            }
        }
    }

    /**
     * Создать провайдер, ответственный за построение цепочки сертификации
     *
     * @param provider криптопровайдер для проверки подписи и работы с сертификатами
     * @return провайдер, ответственный за построение цепочки сертификации
     * @throws GeneralSecurityException в случае ошибок при работе с хранилищем сертификатов
     */
    private CertificateValidationProvider createCertificateValidationProvider(Provider provider) throws GeneralSecurityException {
        boolean noCheckCertificate = parameters.isNoCheckCertificate();

        if (noCheckCertificate) {
            // пользователь дал команду не проверять цепочку сертификатов
            return new NoCheckCertificateProvider();
        }

        char[] storePassword = parameters.getStorePassword() == null ? null : StringUtils.defaultString(parameters.getStorePassword()).toCharArray();
        KeyStore keyStore = KeyStore.getInstance(parameters.getStoreType(), provider);
        if (parameters.getStoreFile() != null) {
            KeyStoreUtils.loadKeyStoreFromFile(keyStore, parameters.getStoreFile(), storePassword);
        } else if (parameters.getStoreName() != null) {
            KeyStoreUtils.loadKeyStoreByName(keyStore, parameters.getStoreName(), storePassword);
        }

        if (parameters.isNoIntermediateStore()) {
            // пользователь дал команду не использовать хранилище промежуточных сертификатов
            return new PKIXCertificateValidationProvider(
                    keyStore,                           // хранилище доверенных сертификатов
                    false                               // не проверять, что сертификат был отозван
            );
        }

        // загружаем хранилище промежуточных сертификатов
        char[] intermediateStorePassword = parameters.getIntermediateStorePassword() == null ? null : StringUtils.defaultString(parameters.getIntermediateStorePassword()).toCharArray();
        KeyStore intermediateKeyStore = KeyStore.getInstance(parameters.getIntermediateStoreType(), provider);
        if (parameters.getIntermediateStoreFile() != null) {
            KeyStoreUtils.loadKeyStoreFromFile(intermediateKeyStore, parameters.getIntermediateStoreFile(), intermediateStorePassword);
        } else if (parameters.getIntermediateStoreName() != null) {
            KeyStoreUtils.loadKeyStoreByName(intermediateKeyStore, parameters.getIntermediateStoreName(), intermediateStorePassword);
        }

        // загружаем промежуточные сертификаты
        List<X509Certificate> intermediateCerts = KeyStoreUtils.listCertificates(intermediateKeyStore);

        // конвертируем список промежуточных сертификатов
        CertStore intermediateCertStore = CertStore.getInstance("Collection", new CollectionCertStoreParameters(intermediateCerts), provider);

        return new PKIXCertificateValidationProvider(
                keyStore,                           // хранилище доверенных сертификатов
                false,                              // не проверять, что сертификат был отозван
                BouncyCastleProvider.PROVIDER_NAME, // провайдер для построения цепочки сертификатов
                provider.getName(),                 // провайдер для проверки подписи сертификата
                intermediateCertStore               // хранилище промежуточных сертификатов
        );
    }

    /**
     * Проверить XAdES-подпись
     *
     * @param verifier            объект, ответственный за проверку подписи
     * @param verificationOptions параметры проверки подписи
     * @param signatureElement    подпись
     * @return описание проверенной подписи, в случае если проверка прошла успешно
     * @throws SignatureVerificationException в случае если подпись не прошла проверку
     */
    private XAdESVerificationResult verifySignature(XadesVerifier verifier, SignatureSpecificVerificationOptions verificationOptions, Element signatureElement) throws SignatureVerificationException {
        String signatureId = signatureElement.getAttributeNS(null, Constants._ATT_ID);
        try {
            XAdESVerificationResult vr = verifier.verify(signatureElement, verificationOptions);
            return vr;
        } catch (XAdES4jException e) {
            throw new SignatureVerificationException("Signature '" + signatureId + "' verification failed.", e);
        }
    }

    /**
     * Вывести информацию о проверенной подписи
     *
     * @param vr описание проверенной подписи
     */
    private void printSignatureInfo(XAdESVerificationResult vr) {
        List<String> signedURIs = collectSignedURIs(vr);
        System.out.println("Signature id: " + vr.getXmlSignature().getId());
        System.out.println("Signed URIs: " + StringUtils.join(signedURIs, ", "));
        System.out.println("Signature form: " + vr.getSignatureForm());
        System.out.println("Validation certificate: " + vr.getValidationCertificate().getSubjectX500Principal());
        System.out.println("Issued by: " + vr.getValidationCertificate().getIssuerX500Principal());
    }

    /**
     * Собрать список подписанных элементов документа
     *
     * @param vr описание проверенной подписи
     * @return список подписанных элементов документа
     */
    private List<String> collectSignedURIs(XAdESVerificationResult vr) {
        List<String> signedURIs = new ArrayList<>();
        SignedInfo signedInfo = vr.getXmlSignature().getSignedInfo();
        for (int i = 0, count = signedInfo.getLength(); i < count; i++) {
            Reference ref;
            try {
                ref = signedInfo.item(i);
            } catch (XMLSecurityException e) {
                // не должно случиться, т.к. подпись была проверена успешно
                throw new IllegalStateException(e);
            }
            String refTypeUri = ref.getType();

            // исключаем ссылку на <xades:SignedProperties>
            if (!Consts.SIGNED_PROPS_TYPE_URI.equals(refTypeUri)) {
                signedURIs.add(ref.getURI());
            }
        }
        return signedURIs;
    }

	@Override
	public String signElem(String doc, String signedElementId, String containerElementId) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
