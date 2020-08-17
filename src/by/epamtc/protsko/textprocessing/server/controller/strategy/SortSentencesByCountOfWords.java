package by.epamtc.protsko.textprocessing.server.controller.strategy;

public class SortSentencesByCountOfWords implements Strategy {

    @Override
    public Object executeUserCommand() {
        return textController.sortedSentencesByCountOfWords();
    }
}
