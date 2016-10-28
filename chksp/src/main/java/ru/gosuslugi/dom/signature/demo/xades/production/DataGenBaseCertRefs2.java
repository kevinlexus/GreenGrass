package ru.gosuslugi.dom.signature.demo.xades.production;

import org.bouncycastle.asn1.x500.style.RFC4519Style;
import org.bouncycastle.cert.jcajce.JcaX500NameUtil;
import xades4j.UnsupportedAlgorithmException;
import xades4j.production.PropertyDataGenerationException;
import xades4j.properties.QualifyingProperty;
import xades4j.properties.data.BaseCertRefsData;
import xades4j.properties.data.CertRef;
import xades4j.properties.data.PropertyDataObject;
import xades4j.providers.AlgorithmsProviderEx;
import xades4j.providers.MessageDigestEngineProvider;

import java.security.MessageDigest;
import java.security.cert.CertificateEncodingException;
import java.security.cert.X509Certificate;
import java.util.Collection;

/**
 * Версия DataGenBaseCertRefs из xades4j 1.3.2.
 * Корректно определяет значение поля Issuer Name для сертификатов, содержащих в этом поле символы не из таблицы ASCII.
 */
public class DataGenBaseCertRefs2 {
    private final AlgorithmsProviderEx algorithmsProvider;
    private final MessageDigestEngineProvider messageDigestProvider;

    protected  DataGenBaseCertRefs2(MessageDigestEngineProvider messageDigestProvider, AlgorithmsProviderEx algorithmsProvider) {
        this.messageDigestProvider = messageDigestProvider;
        this.algorithmsProvider = algorithmsProvider;
    }

    protected PropertyDataObject generate(
            Collection<X509Certificate> certs,
            BaseCertRefsData certRefsData,
            QualifyingProperty prop) throws PropertyDataGenerationException {
        if (null == certs) {
            throw new PropertyDataGenerationException(prop, "certificates not provided");
        }

        try {
            String digestAlgUri = this.algorithmsProvider.getDigestAlgorithmForReferenceProperties();
            MessageDigest messageDigest = this.messageDigestProvider.getEngine(digestAlgUri);

            for (X509Certificate cert : certs) {
                // "DigestValue contains the base-64 encoded value of the digest
                // computed on the DER-encoded certificate."
                // The base-64 encoding is done by JAXB with the configured
                // adapter (Base64XmlAdapter).
                // For X509 certificates the encoded form return by getEncoded is DER.
                byte[] digestValue = messageDigest.digest(cert.getEncoded());

                // отличие от xades4j - в этой строке:
                String issuerDN = JcaX500NameUtil.getIssuer(RFC4519Style.INSTANCE, cert).toString();

                certRefsData.addCertRef(new CertRef(
                        issuerDN,
                        cert.getSerialNumber(),
                        digestAlgUri,
                        digestValue));
            }
            return certRefsData;

        } catch (UnsupportedAlgorithmException ex) {
            throw new PropertyDataGenerationException(prop, ex.getMessage(), ex);
        } catch (CertificateEncodingException ex) {
            throw new PropertyDataGenerationException(prop, "cannot get encoded certificate", ex);
        }
    }
}