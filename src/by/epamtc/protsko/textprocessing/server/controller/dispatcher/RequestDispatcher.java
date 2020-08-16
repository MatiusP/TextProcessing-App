package by.epamtc.protsko.textprocessing.server.controller.dispatcher;

import by.epamtc.protsko.textprocessing.server.controller.ControllerFactory;
import by.epamtc.protsko.textprocessing.server.controller.TextController;

import java.util.ArrayList;
import java.util.List;

public class RequestDispatcher {
    private static TextController textController = ControllerFactory.getTextController();

    public static Object executeCommand(String userCommand) {
        Object commandResult = new ArrayList<>();

        if ("sentencesWithSameWords".equals(userCommand)) {
            commandResult = textController.sentencesWithSameWords();

        } else if ("wordsOfGivenLengthInInterrogativeSentence".equals(userCommand)) {
//            commandResult = textController.wordsOfGivenLengthInInterrogativeSentence();

        } else if ("sortedSentencesByCountOfWords".equals(userCommand)) {
            commandResult = textController.sortedSentencesByCountOfWords();
        }
        return commandResult;
    }
}
