package ru.gosuslugi.dom.signature.demo.args;

import com.beust.jcommander.Parameter;
import com.beust.jcommander.Parameters;
import com.beust.jcommander.converters.FileConverter;
import ru.gosuslugi.dom.signature.demo.commands.Command;
import ru.gosuslugi.dom.signature.demo.commands.ListCommand;

import java.io.File;

/**
 * Параметры командной строки для команды отображения списка ключей, сертификатов.
 */
@Parameters(commandNames = "-list")
public class ListParameters extends AbstractParameters {
    //region provider
    @Parameter(names = {"-providername"}, description = "provider name")
    private String providerName;

    @Parameter(names = {"-providerclass"}, description = "provider class name")
    private String providerClass = "com.digt.trusted.jce.provider.DIGTProvider";

    @Parameter(names = {"-providerarg"}, description = "provider argument")
    private String providerArg;
    //endregion

    //region store arguments
    @Parameter(names = {"-storetype"}, description = "store type")
    private String storeType = "CryptoProCSPKeyStore";

    @Parameter(names = {"-storefile"}, description = "keystore file name", converter = FileConverter.class)
    private File storeFile;

    @Parameter(names = {"-storename"}, description = "keystore name")
    private String storeName = "CurrentUser/My";

    @Parameter(names = {"-storepass"}, description = "store password")
    private String storePassword;
    //endregion

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

    @Override
    public Command createCommand() {
        return new ListCommand(this);
    }
}
