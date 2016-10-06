package ru.gosuslugi.dom.signature.demo.xades.verification;

import com.google.inject.Inject;
import xades4j.properties.QualifyingProperty;
import xades4j.properties.SigningCertificateProperty;
import xades4j.properties.data.CertRef;
import xades4j.properties.data.SigningCertificateData;
import xades4j.providers.MessageDigestEngineProvider;
import xades4j.verification.*;

import javax.security.auth.x500.X500Principal;
import java.security.cert.X509Certificate;
import java.util.Collection;
import java.util.Iterator;

/**
 * Скопированная версия SigningCertificateVerifier из xades4j 1.3.2. Использует CertRefUtils2 вместо CertRefUtils.
 */
public class SigningCertificateVerifier2 implements QualifyingPropertyVerifier<SigningCertificateData> {
    private final MessageDigestEngineProvider messageDigestProvider;

    @Inject
    public SigningCertificateVerifier2(
            MessageDigestEngineProvider messageDigestProvider) {
        this.messageDigestProvider = messageDigestProvider;
    }

    @Override
    public QualifyingProperty verify(
            SigningCertificateData propData,
            QualifyingPropertyVerificationContext ctx) throws SigningCertificateVerificationException {
        Collection<CertRef> certRefs = propData.getCertRefs();
        QualifyingPropertyVerificationContext.CertificationChainData certChainData = ctx.getCertChainData();

        Iterator<X509Certificate> certPathIter = certChainData.getCertificateChain().iterator();

        /* Check the signing certificate */

        // "If the verifier does not find any reference matching the signing certificate,
        // the validation of this property should be taken as failed."
        X509Certificate signingCert = certPathIter.next();
        CertRef signingCertRef = CertRefUtils2.findCertRef(signingCert, certRefs);
        if (null == signingCertRef)
            throw new SigningCertificateReferenceNotFoundException(signingCert);

        // "If the ds:KeyInfo contains the ds:X509IssuerSerial element, check that
        // the issuer and the serial number indicated in both, that one and IssuerSerial
        // from SigningCertificate, are the same."
        X500Principal keyInfoIssuer = certChainData.getValidationCertIssuer();
        if (keyInfoIssuer != null &&
                (!new X500Principal(signingCertRef.issuerDN).equals(keyInfoIssuer) ||
                        !signingCertRef.serialNumber.equals(certChainData.getValidationCertSerialNumber())))
            throw new SigningCertificateIssuerSerialMismatchException(
                    signingCertRef.issuerDN,
                    signingCertRef.serialNumber,
                    keyInfoIssuer.getName(),
                    certChainData.getValidationCertSerialNumber());

        try {
            CertRefUtils2.checkCertRef(signingCertRef, signingCert, messageDigestProvider);
        } catch (CertRefUtils2.InvalidCertRefException ex) {
            throw new SigningCertificateReferenceException(signingCert, signingCertRef, ex);
        }

        /* Check the other certificates in the certification path */

        int nMatchedRefs = 1;

        while (certPathIter.hasNext()) {
            X509Certificate cert = certPathIter.next();
            CertRef certRef = CertRefUtils2.findCertRef(cert, certRefs);
            // "Should one or more certificates in the certification path not be
            // referenced by this property, the verifier should assume that the
            // verification is successful (...)"
            if (null == certRef)
                continue;
            nMatchedRefs++;
            try {
                CertRefUtils2.checkCertRef(certRef, cert, messageDigestProvider);
            } catch (CertRefUtils2.InvalidCertRefException ex) {
                throw new SigningCertificateReferenceException(cert, certRef, ex);
            }
        }

        // "Should this property contain one or more references to certificates
        // other than those present in the certification path, the verifier should
        // assume that a failure has occurred during the verification."
        if (nMatchedRefs < certRefs.size())
            throw new SigningCertificateCertsNotInCertPathException();

        return new SigningCertificateProperty(certChainData.getCertificateChain());
    }
}
