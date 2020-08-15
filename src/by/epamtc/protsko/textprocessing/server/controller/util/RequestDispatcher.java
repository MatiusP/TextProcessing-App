package by.epamtc.protsko.textprocessing.server.controller.util;

import by.epamtc.protsko.textprocessing.common.bean.Sentence;
import by.epamtc.protsko.textprocessing.server.controller.ControllerFactory;
import by.epamtc.protsko.textprocessing.server.controller.TextController;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RequestDispatcher {

    private static TextController textController = ControllerFactory.getTextController();


    private static List<Sentence> getCommand(String userCommand) {
        String command = userCommand;

        List<Sentence> commandResult = new ArrayList<>();

        if (userCommand.equals("sentencesWithSameWords")) {
            commandResult = textController.sentencesWithSameWords();

        } else if (userCommand.equals("wordsOfGivenLengthInInterrogativeSentence")) {

        } else if (userCommand.equals("sortedSentencesByCountOfWords")) {
            commandResult = textController.sortedSentencesByCountOfWords();
        }
        return commandResult;
    }


    private static ByteArrayOutputStream serializableResult(String userCommand) throws IOException {
        List<Sentence> sentenceList = getCommand(userCommand);

        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(byteArrayOutputStream);
        oos.writeObject(sentenceList);
        oos.flush();

        return byteArrayOutputStream;
    }

    public static ByteArrayOutputStream getCommandResult(String userCommand) throws IOException {
        return serializableResult(userCommand);
    }


}
