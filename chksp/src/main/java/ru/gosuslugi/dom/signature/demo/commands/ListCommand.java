package ru.gosuslugi.dom.signature.demo.commands;

import org.apache.commons.lang.StringUtils;
import org.bouncycastle.asn1.x500.X500Name;
import org.bouncycastle.asn1.x500.style.RFC4519Style;
import org.bouncycastle.cert.jcajce.JcaX500NameUtil;
import ru.gosuslugi.dom.signature.demo.args.ListParameters;
import ru.gosuslugi.dom.signature.demo.jce.KeyStoreUtils;
import ru.gosuslugi.dom.signature.demo.jce.ProviderFactory;

import java.security.KeyStore;
import java.security.Provider;
import java.security.Security;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.Enumeration;

/**
 * Выводит список содержащихся в хранилище ключей, сертификатов.
 */
public class ListCommand implements Command {
    private ListParameters parameters;

    public ListCommand(ListParameters parameters) {
        this.parameters = parameters;
    }

    public void execute() throws Exception {
        // загружаем криптопровайдер
        String providerName = parameters.getProviderName();
        Provider provider = providerName == null ? null : Security.getProvider(providerName);
        if (provider == null) {
            provider = ProviderFactory.createProvider(parameters.getProviderClass(), parameters.getProviderArg());
            Security.addProvider(provider);
        }

        // загружаем хранилище ключей/сертификатов
        char[] storePassword = parameters.getStorePassword() == null ? null : StringUtils.defaultString(parameters.getStorePassword()).toCharArray();
        KeyStore keyStore = KeyStore.getInstance(parameters.getStoreType(), provider);
        if (parameters.getStoreFile() != null) {
            KeyStoreUtils.loadKeyStoreFromFile(keyStore, parameters.getStoreFile(), storePassword);
        } else if (parameters.getStoreName() != null) {
            KeyStoreUtils.loadKeyStoreByName(keyStore, parameters.getStoreName(), storePassword);
        }

        // выводим информацию о хранилище
        System.out.println("Keystore type: " + keyStore.getType());
        System.out.println("Keystore provider: " + provider.getName());
        System.out.println();

        // выводим список ключей/сертификатов
        Enumeration<String> aliases = keyStore.aliases();
        while (aliases.hasMoreElements()) {
            String alias = aliases.nextElement();

            String entryType = "?";
            String entryInfo = null;
            if (keyStore.entryInstanceOf(alias, KeyStore.SecretKeyEntry.class)) { // симметричный ключ шифрования
                entryType = "SecretKeyEntry";
            } else if (keyStore.entryInstanceOf(alias, KeyStore.PrivateKeyEntry.class)) { // закрытый ключ
                entryType = "PrivateKeyEntry";
            } else if (keyStore.entryInstanceOf(alias, KeyStore.TrustedCertificateEntry.class)) { // сертификат
                entryType = "TrustedCertificateEntry";
                Certificate certificate = keyStore.getCertificate(alias);
                // не-X.509 сертификаты игнорируем
                if (certificate instanceof X509Certificate) {
                    X509Certificate x509 = (X509Certificate) certificate;
                    // берем поле Subject из сертификата
                    X500Name subject = JcaX500NameUtil.getSubject(RFC4519Style.INSTANCE, x509);
                    entryInfo = subject.toString();
                }
            }

            System.out.println(alias + ", " + entryType);
            if (entryInfo != null) {
                System.out.println(entryInfo);
            }
        }
    }
}
