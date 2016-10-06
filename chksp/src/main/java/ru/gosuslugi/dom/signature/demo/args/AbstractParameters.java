package ru.gosuslugi.dom.signature.demo.args;

import com.beust.jcommander.Parameter;
import ru.gosuslugi.dom.signature.demo.commands.Command;

/**
 * Параметры командной строки, общие для всех команд.
 */
public class AbstractParameters {
    @Parameter(names = {"-h", "-help"}, help = true)
    private boolean help;

    public boolean isHelp() {
        return help;
    }

    public Command createCommand() {
        return null;
    }
}
