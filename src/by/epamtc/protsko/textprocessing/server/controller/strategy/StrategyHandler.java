package by.epamtc.protsko.textprocessing.server.controller.strategy;

import java.util.HashMap;
import java.util.Map;

public class StrategyHandler {
    private static final Map<String, Strategy> programCommands = new HashMap<>();

    static {
        programCommands.put("sentencesWithSameWords", new SentencesWithSameWords());
        programCommands.put("wordsOfGivenLengthInInterrogativeSentence", new WordOfGivenLengthInInterrogativeSentence());
        programCommands.put("sortedSentencesByCountOfWords", new SortSentencesByCountOfWords());
    }

    public Strategy getMethod(String userCommand) {
        return programCommands.get(userCommand);
    }
}
