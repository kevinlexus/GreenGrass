package ru.gosuslugi.dom.signature.demo.jce;

import java.security.GeneralSecurityException;
import java.security.KeyException;
import java.security.KeyStore;

/**
 * Вспомогательный класс для загрузки ключей.
 */
public class KeyLoader {
    private KeyLoader() {
    }

    /**
     * Загрузить закрытый ключ
     *
     * @param keyStore хранилище ключей
     * @param alias имя ключа
     * @param keyPassword пароль
     * @return загруженный ключ или null
     * @throws GeneralSecurityException
     */
    public static KeyStore.PrivateKeyEntry loadPrivateKey(KeyStore keyStore, String alias, char[] keyPassword) throws GeneralSecurityException {
        try {
            KeyStore.PasswordProtection protection = new KeyStore.PasswordProtection(keyPassword);
            KeyStore.PrivateKeyEntry key = (KeyStore.PrivateKeyEntry) keyStore.getEntry(alias, protection);
            return key;
        } catch (GeneralSecurityException e) {
            throw new KeyException("Cannot load key: " + alias, e);
        }
    }
}
