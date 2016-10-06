package ru.gosuslugi.dom.signature.demo.xades.production;

import xades4j.production.*;
import xades4j.properties.SigningCertificateProperty;
import xades4j.providers.AlgorithmsProviderEx;
import xades4j.providers.KeyingDataProvider;
import xades4j.providers.MessageDigestEngineProvider;

/**
 * Настраиваемая фабрика для создания профиля подписания.
 */
public class CustomizableXadesBesSigningProfileFactory {
    private KeyingDataProvider keyingProvider;
    private AlgorithmsProviderEx algorithmsProvider;
    private MessageDigestEngineProvider messageDigestEngineProvider;

    /**
     * Установить провайдер для доступа к закрытому ключу
     *
     * @param keyingProvider провайдер для доступа к закрытому ключу
     * @return this
     */
    public CustomizableXadesBesSigningProfileFactory withKeyingProvider(KeyingDataProvider keyingProvider) {
        this.keyingProvider = keyingProvider;
        return this;
    }

    /**
     * Установить провайдер, описывающий используемые алгоритмы
     *
     * @param algorithmsProvider провайдер, описывающий используемые алгоритмы
     * @return this
     */
    public CustomizableXadesBesSigningProfileFactory withAlgorithmsProvider(AlgorithmsProviderEx algorithmsProvider) {
        this.algorithmsProvider = algorithmsProvider;
        return this;
    }

    /**
     * Установить провайдер, ответственный за расчет хешей
     *
     * @param messageDigestEngineProvider провайдер, ответственный за расчет хешей
     * @return this
     */
    public CustomizableXadesBesSigningProfileFactory withMessageDigestEngineProvider(MessageDigestEngineProvider messageDigestEngineProvider) {
        this.messageDigestEngineProvider = messageDigestEngineProvider;
        return this;
    }

    /**
     * Создать профиль подписания
     *
     * @return профиль подписания
     */
    public XadesSigningProfile create() {
        if (keyingProvider == null) {
            throw new NullPointerException("keyingProvider");
        }
        XadesBesSigningProfile profile = new XadesBesSigningProfile(keyingProvider);
        init(profile);
        return profile;
    }

    private void init(XadesSigningProfile profile) {
        if (algorithmsProvider != null) {
            profile.withAlgorithmsProviderEx(algorithmsProvider);
        }

        if (messageDigestEngineProvider != null) {
            profile.withBinding(MessageDigestEngineProvider.class, messageDigestEngineProvider);
        }

        profile.withPropertyDataObjectGenerator(SigningCertificateProperty.class, DataGenSigningCertificate2.class);
    }
}
