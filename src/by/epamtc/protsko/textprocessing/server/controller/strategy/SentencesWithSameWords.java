package by.epamtc.protsko.textprocessing.server.controller.strategy;

public class SentencesWithSameWords implements Strategy {

    @Override
    public Object executeUserCommand() {
        return textController.sentencesWithSameWords();
    }
}
