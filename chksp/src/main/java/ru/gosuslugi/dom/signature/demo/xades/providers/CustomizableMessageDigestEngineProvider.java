package ru.gosuslugi.dom.signature.demo.xades.providers;

import xades4j.UnsupportedAlgorithmException;
import xades4j.providers.MessageDigestEngineProvider;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.Provider;

/**
 * Провайдер, ответственный за расчет хешей.
 */
public class CustomizableMessageDigestEngineProvider implements MessageDigestEngineProvider {
    private String algorithm;
    private Provider provider;

    public CustomizableMessageDigestEngineProvider(String algorithm, Provider provider) {
        this.algorithm = algorithm;
        this.provider = provider;
    }

    @Override
    public MessageDigest getEngine(String digestAlgorithmURI) throws UnsupportedAlgorithmException {
        try {
            return MessageDigest.getInstance(algorithm, provider);
        } catch (NoSuchAlgorithmException e) {
            throw new UnsupportedAlgorithmException(e.getMessage(), digestAlgorithmURI, e);
        }
    }
}
