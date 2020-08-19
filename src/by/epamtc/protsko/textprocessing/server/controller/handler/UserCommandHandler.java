package by.epamtc.protsko.textprocessing.server.controller.handler;

import by.epamtc.protsko.textprocessing.server.controller.ControllerFactory;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public class UserCommandHandler {
    private static Map<String, Supplier<Object>> commands = new HashMap<>();

    private UserCommandHandler() {
    }

    static {
        commands.put("sentencesWithSameWords",
                () -> ControllerFactory.getTextController().sentencesWithSameWords());
        commands.put("wordsOfGivenLengthInInterrogativeSentence",
                () -> ControllerFactory.getTextController().wordsOfGivenLengthInInterrogativeSentence(5));
        commands.put("sortedSentencesByCountOfWords",
                () -> ControllerFactory.getTextController().sortedSentencesByCountOfWords());
    }

    public static Object executeCommand(String userCommand) {
        return commands.get(userCommand).get();
    }
}
