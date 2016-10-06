package ru.gosuslugi.dom.signature.demo.xades.production;

import com.google.inject.Inject;
import xades4j.production.PropertiesDataGenerationContext;
import xades4j.production.PropertyDataGenerationException;
import xades4j.production.PropertyDataObjectGenerator;
import xades4j.properties.SigningCertificateProperty;
import xades4j.properties.data.PropertyDataObject;
import xades4j.properties.data.SigningCertificateData;
import xades4j.providers.AlgorithmsProviderEx;
import xades4j.providers.MessageDigestEngineProvider;

/**
 * Версия xades4j.production.DataGenSigningCertificate xades4j 1.3.2.
 * Корректно определяет значение поля Issuer Name для сертификатов, содержащих в этом поле символы не из таблицы ASCII.
 */
public class DataGenSigningCertificate2 extends DataGenBaseCertRefs2 implements PropertyDataObjectGenerator<SigningCertificateProperty> {
    @Inject
    public DataGenSigningCertificate2(MessageDigestEngineProvider messageDigestProvider, AlgorithmsProviderEx algorithmsProvider) {
        super(messageDigestProvider, algorithmsProvider);
    }

    @Override
    public PropertyDataObject generatePropertyData(SigningCertificateProperty prop, PropertiesDataGenerationContext ctx) throws PropertyDataGenerationException {
        return super.generate(
                prop.getsigningCertificateChain(),
                new SigningCertificateData(),
                prop);
    }
}
