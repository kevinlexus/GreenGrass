package ru.gosuslugi.dom.signature.demo.jce;

import org.apache.commons.lang.StringUtils;

import java.security.Provider;
import java.security.ProviderException;

/**
 * Вспомогательный класс для работы с криптопровайдерами.
 */
public class ProviderFactory {
    private ProviderFactory() {
    }

    /**
     * Создать криптопровайдер
     *
     * @param providerClass класс криптопровайдера
     * @param providerArg   необязательный аргумент для создаваемого криптопровайдера
     * @return созданный криптопровайдер
     * @throws ProviderException в случае если криптопровайдер не может быть создан
     */
    public static Provider createProvider(String providerClass, String providerArg) {
        // получаем класс криптопровайдера
        Class<?> providerClazz;
        try {
            providerClazz = Class.forName(providerClass);
        } catch (ClassNotFoundException e) {
            throw new ProviderException("Provider class not found: " + providerClass);
        }

        if (!Provider.class.isAssignableFrom(providerClazz)) {
            // это не криптопровайдер
            throw new ProviderException("Class " + providerClazz.getName() + " is not a provider");
        }

        try {
            if (providerArg != null) {
                // вызываем конструктор с одним аргументом-строкой
                return (Provider) providerClazz.getConstructor(String.class).newInstance(providerArg);
            } else {
                // вызываем конструктор по умолчанию
                return (Provider) providerClazz.newInstance();
            }
        } catch (ReflectiveOperationException e) {
            // конструктор не найден или ошибка при вызове конструктора
            throw new ProviderException("Provider initialization failed: new " + providerClass + "(" + StringUtils.defaultString(providerArg) + ")", e);
        }
    }
}
