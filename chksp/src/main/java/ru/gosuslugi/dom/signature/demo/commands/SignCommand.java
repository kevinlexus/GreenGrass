package ru.gosuslugi.dom.signature.demo.commands;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.StringUtils;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import ru.gosuslugi.dom.signature.demo.args.SignParameters;
import ru.gosuslugi.dom.signature.demo.exceptions.ElementNotFoundException;
import ru.gosuslugi.dom.signature.demo.jce.KeyLoader;
import ru.gosuslugi.dom.signature.demo.jce.KeyStoreUtils;
import ru.gosuslugi.dom.signature.demo.jce.ProviderFactory;
import ru.gosuslugi.dom.signature.demo.xades.Consts;
import ru.gosuslugi.dom.signature.demo.xades.production.CustomizableXadesBesSigningProfileFactory;
import ru.gosuslugi.dom.signature.demo.xades.providers.CustomizableAlgorithmProvider;
import ru.gosuslugi.dom.signature.demo.xades.providers.CustomizableMessageDigestEngineProvider;
import ru.gosuslugi.dom.signature.demo.xml.IdResolver;
import ru.gosuslugi.dom.signature.demo.xml.XMLParser;
import ru.gosuslugi.dom.signature.demo.xml.XMLPrinter;
import xades4j.algorithms.EnvelopedSignatureTransform;
import xades4j.algorithms.ExclusiveCanonicalXMLWithoutComments;
import xades4j.production.*;
import xades4j.properties.DataObjectDesc;
import xades4j.providers.KeyingDataProvider;
import xades4j.providers.MessageDigestEngineProvider;
import xades4j.providers.impl.DirectKeyingDataProvider;

import java.security.KeyException;
import java.security.KeyStore;
import java.security.Provider;
import java.security.Security;
import java.security.cert.X509Certificate;

/**
 * Выполняет подписание XML-документа.
 */
public class SignCommand implements Command {
    private SignParameters parameters;

    public SignCommand(SignParameters parameters) {
        this.parameters = parameters;
    }

    public String signElem(String doc, String signedElementId, String containerElementId) throws Exception {
        // инициализируем Apache Santuario
        org.apache.xml.security.Init.init();

        // загружаем криптопровайдер
    	Provider provider = ProviderFactory.createProvider("com.digt.trusted.jce.provider.DIGTProvider", null);
        Security.addProvider(provider);

        // загружаем хранилище закрытых ключей
        char[] storePassword = null;
        char[] keyPassword = null;
        KeyStore keyStore = KeyStore.getInstance("CryptoProCSPKeyStore", provider);
        KeyStoreUtils.loadKeyStoreByName(keyStore, "CurrentUser/My", storePassword);

        // загружаем закрытый ключ
        KeyStore.PrivateKeyEntry keyEntry = KeyLoader.loadPrivateKey(keyStore, "SCARD\\rutoken_311550ac\\0A00\\82F9", keyPassword);
        if (keyEntry == null) {
            throw new KeyException("Key not found: " + "SCARD\\rutoken_311550ac\\0A00\\82F9");
        }

        // создаем провайдер для доступа к закрытому ключу
        KeyingDataProvider kp = new DirectKeyingDataProvider((X509Certificate) keyEntry.getCertificate(), keyEntry.getPrivateKey());

        // создаем провайдер, описывающий используемые алгоритмы
        CustomizableAlgorithmProvider algorithmsProvider = new CustomizableAlgorithmProvider();
        algorithmsProvider.setSignatureAlgorithm(Consts.SIGNATURE_ALGORITHM);
        algorithmsProvider.setCanonicalizationAlgorithmForSignature(Consts.CANONICALIZATION_ALGORITHM_FOR_SIGNATURE);
        algorithmsProvider.setCanonicalizationAlgorithmForTimeStampProperties(Consts.CANONICALIZATION_ALGORITHM_FOR_TIMESTAMP_PROPERTIES);
        algorithmsProvider.setDigestAlgorithmForDataObjsReferences(Consts.DIGEST_ALGORITHM_URI);
        algorithmsProvider.setDigestAlgorithmForReferenceProperties(Consts.DIGEST_ALGORITHM_URI);
        algorithmsProvider.setDigestAlgorithmForTimeStampProperties(Consts.DIGEST_ALGORITHM_URI);

        // создаем провайдер, ответственный за расчет хешей
        MessageDigestEngineProvider messageDigestEngineProvider = new CustomizableMessageDigestEngineProvider(Consts.DIGEST_ALGORITHM_NAME, provider);

        // настраиваем профиль подписания
        XadesSigningProfile profile = new CustomizableXadesBesSigningProfileFactory()
                .withKeyingProvider(kp)
                .withAlgorithmsProvider(algorithmsProvider)
                .withMessageDigestEngineProvider(messageDigestEngineProvider)
                .create();

        // создаем объект, ответственный за создание подписи
        XadesSigner signer = profile.newSigner();

        // загружаем проверяемый XML-документ
        //Document document = XMLParser.parseXml(parameters.getInputFile());
        Document document = XMLParser.parseXml(doc);
        
        // выводим результат в stdout
        //System.out.println("BEFORE: "+XMLPrinter.toString(document));
        

        // объявляем атрибут Id в качестве идентифицирующего
        IdResolver.resolveIds(document.getDocumentElement());

        
        // ищем подписываемый элемент
        Element signedElement = document.getElementById(signedElementId);
        if (signedElement == null) {
            throw new ElementNotFoundException("Element to be signed not found: " + signedElementId);
        }

        // ищем элемент, в который нужно поместить подпись; если не указан, помещаем подпись в подписываемый элемент
        Element signatureContainer = document.getElementById(containerElementId);
        if (signatureContainer == null) {
            throw new ElementNotFoundException("Container element not found: " + containerElementId);
        }

        // настраиваем подписываемые данные
        DataObjectDesc obj = new DataObjectReference('#' + signedElementId);

        if (containerElementId.equals(signedElementId)) {
            // если подпись помещается в подписываемый элемент, применяем трансформацию enveloped signature transform
            // если этого не сделать, подпись нельзя будет проверить
            obj.withTransform(new EnvelopedSignatureTransform());
        }

        // применяем трансформацию Exclusive XML Canonicalization 1.0 without comments (комментарии исключаются из подписываемых данных)
        obj.withTransform(new ExclusiveCanonicalXMLWithoutComments());

        // создаем подпись
        SignedDataObjects dataObjs = new SignedDataObjects(obj);
        signer.sign(dataObjs, signatureContainer, SignatureAppendingStrategies.AsFirstChild);

        // выводим результат в stdout
        //System.out.println("AFTER: "+XMLPrinter.toString(document));

        // выводим результат в файл
/*        byte[] xmlBytes = XMLPrinter.toBytes(document);
        FileUtils.writeByteArrayToFile(parameters.getOutputFile(), xmlBytes);
*/        
        return XMLPrinter.toString(document);
    }

    public void execute() throws Exception {
        // инициализируем Apache Santuario
        org.apache.xml.security.Init.init();

        // загружаем криптопровайдер
        String providerName = parameters.getProviderName();
        Provider provider = providerName == null ? null : Security.getProvider(providerName);
        if (provider == null) {
            provider = ProviderFactory.createProvider(parameters.getProviderClass(), parameters.getProviderArg());
            Security.addProvider(provider);
        }

        // загружаем хранилище закрытых ключей
        char[] storePassword = parameters.getStorePassword() == null ? null : StringUtils.defaultString(parameters.getStorePassword()).toCharArray();
        char[] keyPassword = parameters.getKeyPassword() == null ? null : StringUtils.defaultString(parameters.getKeyPassword()).toCharArray();
        KeyStore keyStore = KeyStore.getInstance(parameters.getStoreType(), provider);
        if (parameters.getStoreFile() != null) {
            KeyStoreUtils.loadKeyStoreFromFile(keyStore, parameters.getStoreFile(), storePassword);
        } else if (parameters.getStoreName() != null) {
            KeyStoreUtils.loadKeyStoreByName(keyStore, parameters.getStoreName(), storePassword);
        }

        // загружаем закрытый ключ
        KeyStore.PrivateKeyEntry keyEntry = KeyLoader.loadPrivateKey(keyStore, parameters.getAlias(), keyPassword);
        if (keyEntry == null) {
            throw new KeyException("Key not found: " + parameters.getAlias());
        }

        // создаем провайдер для доступа к закрытому ключу
        KeyingDataProvider kp = new DirectKeyingDataProvider((X509Certificate) keyEntry.getCertificate(), keyEntry.getPrivateKey());

        // создаем провайдер, описывающий используемые алгоритмы
        CustomizableAlgorithmProvider algorithmsProvider = new CustomizableAlgorithmProvider();
        algorithmsProvider.setSignatureAlgorithm(Consts.SIGNATURE_ALGORITHM);
        algorithmsProvider.setCanonicalizationAlgorithmForSignature(Consts.CANONICALIZATION_ALGORITHM_FOR_SIGNATURE);
        algorithmsProvider.setCanonicalizationAlgorithmForTimeStampProperties(Consts.CANONICALIZATION_ALGORITHM_FOR_TIMESTAMP_PROPERTIES);
        algorithmsProvider.setDigestAlgorithmForDataObjsReferences(Consts.DIGEST_ALGORITHM_URI);
        algorithmsProvider.setDigestAlgorithmForReferenceProperties(Consts.DIGEST_ALGORITHM_URI);
        algorithmsProvider.setDigestAlgorithmForTimeStampProperties(Consts.DIGEST_ALGORITHM_URI);

        // создаем провайдер, ответственный за расчет хешей
        MessageDigestEngineProvider messageDigestEngineProvider = new CustomizableMessageDigestEngineProvider(Consts.DIGEST_ALGORITHM_NAME, provider);

        // настраиваем профиль подписания
        XadesSigningProfile profile = new CustomizableXadesBesSigningProfileFactory()
                .withKeyingProvider(kp)
                .withAlgorithmsProvider(algorithmsProvider)
                .withMessageDigestEngineProvider(messageDigestEngineProvider)
                .create();

        // создаем объект, ответственный за создание подписи
        XadesSigner signer = profile.newSigner();

        // загружаем проверяемый XML-документ
        Document document = XMLParser.parseXml(parameters.getInputFile());

        // объявляем атрибут Id в качестве идентифицирующего
        IdResolver.resolveIds(document.getDocumentElement());

        // ищем подписываемый элемент
        String signedElementId = parameters.getSignedElementId();
        Element signedElement = document.getElementById(signedElementId);
        if (signedElement == null) {
            throw new ElementNotFoundException("Element to be signed not found: " + signedElementId);
        }

        // ищем элемент, в который нужно поместить подпись; если не указан, помещаем подпись в подписываемый элемент
        String containerElementId = parameters.getContainerElementId() == null ? signedElementId : parameters.getContainerElementId();
        Element signatureContainer = document.getElementById(containerElementId);
        if (signatureContainer == null) {
            throw new ElementNotFoundException("Container element not found: " + containerElementId);
        }

        // настраиваем подписываемые данные
        DataObjectDesc obj = new DataObjectReference('#' + signedElementId);

        if (containerElementId.equals(signedElementId)) {
            // если подпись помещается в подписываемый элемент, применяем трансформацию enveloped signature transform
            // если этого не сделать, подпись нельзя будет проверить
            obj.withTransform(new EnvelopedSignatureTransform());
        }

        // применяем трансформацию Exclusive XML Canonicalization 1.0 without comments (комментарии исключаются из подписываемых данных)
        obj.withTransform(new ExclusiveCanonicalXMLWithoutComments());

        // создаем подпись
        SignedDataObjects dataObjs = new SignedDataObjects(obj);
        signer.sign(dataObjs, signatureContainer, SignatureAppendingStrategies.AsFirstChild);

        if (parameters.getOutputFile() == null) {
            // выводим результат в stdout
            System.out.println(XMLPrinter.toString(document));
        } else {
            // выводим результат в файл
            byte[] xmlBytes = XMLPrinter.toBytes(document);
            FileUtils.writeByteArrayToFile(parameters.getOutputFile(), xmlBytes);
        }
    }
}
