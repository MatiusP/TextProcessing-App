package by.epamtc.protsko.textprocessing.server.controller.strategy;

public class WordOfGivenLengthInInterrogativeSentence implements Strategy {

    @Override
    public Object executeUserCommand() {
        return textController.wordsOfGivenLengthInInterrogativeSentence(5);
    }
}
