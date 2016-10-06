package ru.gosuslugi.dom.signature.demo.xades.providers;

import xades4j.providers.CertificateValidationException;
import xades4j.providers.CertificateValidationProvider;
import xades4j.providers.ValidationData;
import xades4j.verification.UnexpectedJCAException;

import java.security.cert.X509CertSelector;
import java.security.cert.X509Certificate;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;

/**
 * Провайдер, который доверят сертификату, которым подписан документ, без его проверки, и без построения цепочки сертификатов.
 */
public class NoCheckCertificateProvider implements CertificateValidationProvider {
    @Override
    public ValidationData validate(X509CertSelector certSelector, Date validationDate, Collection<X509Certificate> otherCerts) throws CertificateValidationException, UnexpectedJCAException {
        if (certSelector.getCertificate() == null) {
            throw new CertificateValidationException(certSelector, "Signer certificate not found");
        }
        return new ValidationData(Collections.singletonList(certSelector.getCertificate()));
    }
}
