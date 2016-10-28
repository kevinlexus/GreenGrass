package ru.gosuslugi.dom.signature.demo.args;

import com.beust.jcommander.Parameter;
import com.beust.jcommander.Parameters;
import com.beust.jcommander.converters.FileConverter;
import ru.gosuslugi.dom.signature.demo.commands.Command;
import ru.gosuslugi.dom.signature.demo.commands.VerifyCommand;

import java.io.File;

/**
 * Параметры командной строки для команды проверки подписи в XML-документе.
 */
@Parameters(commandNames = "-verify")
public class VerifyParameters extends AbstractParameters {
    @Parameter(names = {"-in"}, description = "input file", required = true, converter = FileConverter.class)
    private File inputFile;

    @Parameter(names = {"-signature"}, description = "ID of signature to check, when not specified all signatures in document are verified")
    private String signatureId;

    //region provider arguments
    @Parameter(names = {"-providername"}, description = "provider name")
    private String providerName;

    @Parameter(names = {"-providerclass"}, description = "provider class name")
    private String providerClass = "com.digt.trusted.jce.provider.DIGTProvider";

    @Parameter(names = {"-providerarg"}, description = "provider argument")
    private String providerArg;
    //endregion

    //region trusted store
    @Parameter(names = {"-storetype"}, description = "trusted store type")
    private String storeType = "CryptoProCSPKeyStore";

    @Parameter(names = {"-storefile"}, description = "trusted store file name", converter = FileConverter.class)
    private File storeFile;

    @Parameter(names = {"-storename"}, description = "trusted store name (e.g. CurrentUser/Root, LocalComputer/Root, etc)")
    private String storeName = "CurrentUser/Root";

    @Parameter(names = {"-storepass"}, description = "trusted store password")
    private String storePassword;
    //endregion

    //region intermediate store
    @Parameter(names = {"-noistore"}, description = "when specified intermediate store is not used")
    private boolean noIntermediateStore;

    @Parameter(names = {"-istoretype"}, description = "intermediate certificates store type")
    private String intermediateStoreType = "CryptoProCSPKeyStore";

    @Parameter(names = {"-istorefile"}, description = "intermediate certificates store file name", converter = FileConverter.class)
    private File intermediateStoreFile;

    @Parameter(names = {"-istorename"}, description = "intermediate certificates store name (e.g. CurrentUser/CA, etc)")
    private String intermediateStoreName = "CurrentUser/CA";

    @Parameter(names = {"-istorepass"}, description = "intermediate certificates store password")
    private String intermediateStorePassword;
    //endregion

    @Parameter(names = "-no-check-certificate", description = "don't check signer's certificate against certificate authorities")
    private boolean noCheckCertificate = false;

    public File getInputFile() {
        return inputFile;
    }

    public String getSignatureId() {
        return signatureId;
    }

    public String getProviderName() {
        return providerName;
    }

    public String getProviderClass() {
        return providerClass;
    }

    public String getProviderArg() {
        return providerArg;
    }

    public String getStoreType() {
        return storeType;
    }

    public File getStoreFile() {
        return storeFile;
    }

    public String getStoreName() {
        return storeName;
    }

    public String getStorePassword() {
        return storePassword;
    }

    public boolean isNoIntermediateStore() {
        return noIntermediateStore;
    }

    public String getIntermediateStoreType() {
        return intermediateStoreType;
    }

    public void setIntermediateStoreType(String intermediateStoreType) {
        this.intermediateStoreType = intermediateStoreType;
    }

    public File getIntermediateStoreFile() {
        return intermediateStoreFile;
    }

    public void setIntermediateStoreFile(File intermediateStoreFile) {
        this.intermediateStoreFile = intermediateStoreFile;
    }

    public String getIntermediateStoreName() {
        return intermediateStoreName;
    }

    public void setIntermediateStoreName(String intermediateStoreName) {
        this.intermediateStoreName = intermediateStoreName;
    }

    public String getIntermediateStorePassword() {
        return intermediateStorePassword;
    }

    public void setIntermediateStorePassword(String intermediateStorePassword) {
        this.intermediateStorePassword = intermediateStorePassword;
    }

    public boolean isNoCheckCertificate() {
        return noCheckCertificate;
    }

    @Override
    public Command createCommand() {
        return new VerifyCommand(this);
    }
}
