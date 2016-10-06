package ru.gosuslugi.dom.signature.demo;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.ParameterException;
import ru.gosuslugi.dom.signature.demo.args.*;
import ru.gosuslugi.dom.signature.demo.commands.Command;

/**
 * Главный класс приложения
 */
public class Start {
    private static final int EXIT_CODE_OK = 0;
    private static final int EXIT_CODE_FAILURE = 1;

    public static void main(String[] argv) {
        // настраиваем команды
        MainParameters main = new MainParameters();
        JCommander jc = new JCommander(main);
        jc.setProgramName("signature-demo");
        jc.addCommand(new SignParameters());
        jc.addCommand(new VerifyParameters());
        jc.addCommand(new ListParameters());

        // парсим параметры командной строки
        try {
            jc.parse(argv);
        } catch (ParameterException e) {
            // командная строка не соответствует формату
            System.err.println(e.getMessage());
            System.exit(EXIT_CODE_FAILURE);
            return;
        }

        // какая команды была вызвана?
        String parsedCommand = jc.getParsedCommand();

        System.err.println("FOUND next command:"+parsedCommand);
        
        if (main.isHelp() || parsedCommand == null) {
            // была запрошена справка
            jc.usage();
            System.exit(EXIT_CODE_OK);
        }

        // берем вызванную команду
        JCommander childCommander = jc.getCommands().get(parsedCommand);
        AbstractParameters parameters = (AbstractParameters) childCommander.getObjects().get(0);

        if (parameters.isHelp()) {
            // была запрошена справка по команде
            jc.usage(parsedCommand);
            System.exit(EXIT_CODE_OK);
        }

        // выполним команду
        try {
            Command cmd = parameters.createCommand();
            cmd.execute();
        } catch (Exception e) {
            // при выполнении команды произошла ошибка
            e.printStackTrace();
            System.exit(EXIT_CODE_FAILURE);
        }
    }
}
