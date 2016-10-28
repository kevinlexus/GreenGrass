package ru.gosuslugi.dom.signature.demo.args;

import com.beust.jcommander.Parameter;
import com.beust.jcommander.Parameters;
import com.beust.jcommander.converters.FileConverter;
import ru.gosuslugi.dom.signature.demo.commands.Command;
import ru.gosuslugi.dom.signature.demo.commands.SignCommand;

import java.io.File;

/**
 * Параметры командной строки для команды подписания XML-документа.
 */
@Parameters(commandNames = "-sign")
public class SignParameters extends AbstractParameters {
    @Parameter(names = {"-in"}, description = "input file", required = true, converter = FileConverter.class)
    private File inputFile;

    @Parameter(names = {"-out"}, description = "output file", converter = FileConverter.class)
    private File outputFile;

    @Parameter(names = {"-element"}, required = true, description = "ID of element to be signed")
    private String signedElementId;

    @Parameter(names = {"-container"}, description = "ID of element where to put signature")
    private String containerElementId;

    //region provider
    @Parameter(names = {"-providername"}, description = "provider name")
    private String providerName;

    @Parameter(names = {"-providerclass"}, description = "provider class name")
    private String providerClass = "com.digt.trusted.jce.provider.DIGTProvider";

    @Parameter(names = {"-providerarg"}, description = "provider argument")
    private String providerArg;
    //endregion

    //region store
    @Parameter(names = {"-storetype"}, description = "keystore type")
    private String storeType = "CryptoProCSPKeyStore";

    @Parameter(names = {"-storefile"}, description = "keystore file name", converter = FileConverter.class)
    private File storeFile;

    @Parameter(names = {"-storename"}, description = "keystore name")
    private String storeName = "CurrentUser/My";

    @Parameter(names = {"-storepass"}, description = "keystore password")
    private String storePassword;
    //endregion

    @Parameter(names = {"-alias"}, required = true, description = "key alias")
    private String alias;

    @Parameter(names = {"-keypass"}, description = "key password")
    private String keyPassword;

    public File getInputFile() {
        return inputFile;
    }

    public File getOutputFile() {
        return outputFile;
    }

    public String getSignedElementId() {
        return signedElementId;
    }

    public String getContainerElementId() {
        return containerElementId;
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

    public String getAlias() {
        return alias;
    }

    public String getKeyPassword() {
        return keyPassword;
    }

    @Override
    public Command createCommand() {
        return new SignCommand(this);
    }
}
