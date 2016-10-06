package ru.gosuslugi.dom.signature.demo.xades.verification;

import org.bouncycastle.asn1.x500.X500Name;
import org.bouncycastle.asn1.x500.style.RFC4519Style;
import org.bouncycastle.cert.jcajce.JcaX500NameUtil;
import xades4j.UnsupportedAlgorithmException;
import xades4j.XAdES4jException;
import xades4j.properties.data.CertRef;
import xades4j.providers.MessageDigestEngineProvider;
import xades4j.verification.SigningCertificateVerificationException;

import java.security.MessageDigest;
import java.security.cert.CertificateEncodingException;
import java.security.cert.X509Certificate;
import java.util.Arrays;
import java.util.Collection;

/**
 * Исправленная версия CertRefUtils из xades4j 1.3.2. Корректно сравнивает сертификат с элементом {@code <xades:Cert>}
 */
public class CertRefUtils2 {
    static CertRef findCertRef(
            X509Certificate cert,
            Collection<CertRef> certRefs) throws SigningCertificateVerificationException {
        for (final CertRef certRef : certRefs) {
            if (isMatch(cert, certRef)) return certRef;
        }
        return null;
    }

    static boolean isMatch(X509Certificate cert, final CertRef certRef) throws SigningCertificateVerificationException {
        X500Name certRefIssuerPrincipal;
        try {
            // преобразуем строку с именем издателя в объект X500Name
            certRefIssuerPrincipal = new X500Name(RFC4519Style.INSTANCE, certRef.issuerDN);
        } catch (IllegalArgumentException ex) {
            throw new SigningCertificateVerificationException(ex) {
                @Override
                protected String getVerificationMessage() {
                    return String.format("Invalid issuer name: %s", certRef.issuerDN);
                }
            };
        }

        // преобразуем строку имя издателя из сертификата в объект X500Name

        // сравниваем объекты X500Name и серийные номера сертификатов
        X500Name certIssuerName = JcaX500NameUtil.getIssuer(RFC4519Style.INSTANCE, cert);
        boolean result = RFC4519Style.INSTANCE.areEqual(certIssuerName, certRefIssuerPrincipal)
                && cert.getSerialNumber().compareTo(certRef.serialNumber) == 0;
        return result;
    }

    static class InvalidCertRefException extends XAdES4jException {
        public InvalidCertRefException(String msg) {
            super(msg);
        }
    }

    static void checkCertRef(
            CertRef certRef,
            X509Certificate cert,
            MessageDigestEngineProvider messageDigestProvider) throws InvalidCertRefException {
        MessageDigest messageDigest;
        Throwable t = null;
        try {
            messageDigest = messageDigestProvider.getEngine(certRef.digestAlgUri);
            byte[] actualDigest = messageDigest.digest(cert.getEncoded());
            if (!Arrays.equals(certRef.digestValue, actualDigest))
                throw new InvalidCertRefException("digests mismatch");
            return;
        } catch (UnsupportedAlgorithmException ex) {
            t = ex;
        } catch (CertificateEncodingException ex) {
            t = ex;
        }
        throw new InvalidCertRefException(t.getMessage());
    }
}
