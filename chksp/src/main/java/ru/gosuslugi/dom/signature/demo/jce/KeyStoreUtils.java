package ru.gosuslugi.dom.signature.demo.jce;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.Charset;
import java.security.GeneralSecurityException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

/**
 * Вспомогательный класс для работы с хранилищем ключей/сертификатов.
 */
public class KeyStoreUtils {
    private KeyStoreUtils() {
    }

    /**
     * Загрузить хранилище из файла
     *
     * @param keyStore      хранилище ключей
     * @param file          имя файла
     * @param storePassword пароль на доступ к хранилищу
     * @throws GeneralSecurityException в случае если при загрузке хранилища произошла ошибка
     */
    public static void loadKeyStoreFromFile(KeyStore keyStore, File file, char[] storePassword) throws GeneralSecurityException {
        try {
            try (FileInputStream fs = new FileInputStream(file)) {
                keyStore.load(fs, storePassword);
            }
        } catch (IOException e) {
            throw new KeyStoreException("Cannot load keystore from file: " + file, e);
        }
    }

    /**
     * Загрузить хранилище из строки
     *
     * @param keyStore      хранилище ключей
     * @param storeName     строка
     * @param storePassword пароль на доступ к хранилищу
     * @throws GeneralSecurityException в случае если при загрузке хранилища произошла ошибка
     */
    public static void loadKeyStoreByName(KeyStore keyStore, String storeName, char[] storePassword) throws GeneralSecurityException {
        try {
            keyStore.load(new ByteArrayInputStream(storeName.getBytes(Charset.forName("UTF-8"))), storePassword);
        } catch (IOException e) {
            throw new KeyStoreException("Cannot load keystore by name: " + storeName, e);
        }
    }

    /**
     * Вернуть список сертификатов, содержащихся в хранилище
     *
     * @param keyStore хранилище сертификатов
     * @return список сертификатов X.509
     * @throws KeyStoreException в случае если при работе с хранилищем произошла ошибка
     */
    public static List<X509Certificate> listCertificates(KeyStore keyStore) throws KeyStoreException {
        // получаем имена ключей/сертификатов, содержащихся в хранилище
        Enumeration<String> aliases = keyStore.aliases();
        List<X509Certificate> result = new ArrayList<>();
        while (aliases.hasMoreElements()) {
            String alias = aliases.nextElement();
            Certificate certificate = keyStore.getCertificate(alias);
            if (certificate instanceof X509Certificate) {
                // возвращаем только сертификаты X.509
                X509Certificate x509 = (X509Certificate) certificate;
                result.add(x509);
            }
        }
        return result;
    }
}
