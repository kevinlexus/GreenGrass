package ru.gosuslugi.dom.signature.demo.xades.providers;

import xades4j.UnsupportedAlgorithmException;
import xades4j.algorithms.Algorithm;
import xades4j.algorithms.GenericAlgorithm;
import xades4j.providers.AlgorithmsProviderEx;

/**
 * Провайдер, описывающий используемые алгоритмы.
 */
public class CustomizableAlgorithmProvider implements AlgorithmsProviderEx {
    private Algorithm signatureAlgorithm;
    private Algorithm canonicalizationAlgorithmForSignature;
    private Algorithm canonicalizationAlgorithmForTimeStampProperties;
    private String digestAlgorithmForDataObjsReferences;
    private String digestAlgorithmForReferenceProperties;
    private String digestAlgorithmForTimeStampProperties;

    public void setSignatureAlgorithm(String signatureAlgorithm) {
        this.signatureAlgorithm = new GenericAlgorithm(signatureAlgorithm);
    }

    public void setCanonicalizationAlgorithmForSignature(String canonicalizationAlgorithmForSignature) {
        this.canonicalizationAlgorithmForSignature = new GenericAlgorithm(canonicalizationAlgorithmForSignature);
    }

    public void setCanonicalizationAlgorithmForTimeStampProperties(String canonicalizationAlgorithmForTimeStampProperties) {
        this.canonicalizationAlgorithmForTimeStampProperties = new GenericAlgorithm(canonicalizationAlgorithmForTimeStampProperties);
    }

    public void setDigestAlgorithmForDataObjsReferences(String digestAlgorithmForDataObjsReferences) {
        this.digestAlgorithmForDataObjsReferences = digestAlgorithmForDataObjsReferences;
    }

    public void setDigestAlgorithmForReferenceProperties(String digestAlgorithmForReferenceProperties) {
        this.digestAlgorithmForReferenceProperties = digestAlgorithmForReferenceProperties;
    }

    public void setDigestAlgorithmForTimeStampProperties(String digestAlgorithmForTimeStampProperties) {
        this.digestAlgorithmForTimeStampProperties = digestAlgorithmForTimeStampProperties;
    }

    @Override
    public Algorithm getSignatureAlgorithm(String keyAlgorithmName) throws UnsupportedAlgorithmException {
        return signatureAlgorithm;
    }

    @Override
    public Algorithm getCanonicalizationAlgorithmForSignature() {
        return canonicalizationAlgorithmForSignature;
    }

    @Override
    public Algorithm getCanonicalizationAlgorithmForTimeStampProperties() {
        return canonicalizationAlgorithmForTimeStampProperties;
    }

    @Override
    public String getDigestAlgorithmForDataObjsReferences() {
        return digestAlgorithmForDataObjsReferences;
    }

    @Override
    public String getDigestAlgorithmForReferenceProperties() {
        return digestAlgorithmForReferenceProperties;
    }

    @Override
    public String getDigestAlgorithmForTimeStampProperties() {
        return digestAlgorithmForTimeStampProperties;
    }
}
