package by.epamtc.protsko.textprocessing.server.controller.impl;

import by.epamtc.protsko.textprocessing.common.bean.Sentence;
import by.epamtc.protsko.textprocessing.common.bean.Text;
import by.epamtc.protsko.textprocessing.common.bean.Word;
import by.epamtc.protsko.textprocessing.server.controller.TextController;
import by.epamtc.protsko.textprocessing.server.service.ServiceFactory;
import by.epamtc.protsko.textprocessing.server.service.TextService;

import java.util.List;

public class TextControllerImpl implements TextController {

    private ServiceFactory serviceFactory = ServiceFactory.getInstance();
    private TextService textService = serviceFactory.getTextService();
    private final Text sourceText =  textService.getSourceText();


    @Override
    public List<Sentence> sentencesWithSameWords() {
        return textService.getSentencesWithSameWords(sourceText);
    }

    @Override
    public List<Word> wordsOfGivenLengthInInterrogativeSentence(int givenLength) {
        return textService.getWordsOfGivenLengthInInterrogativeSentence(sourceText, givenLength);
    }

    @Override
    public List<Sentence> sortedSentencesByCountOfWords() {
        return textService.getSortedSentencesByCountOfWords(sourceText);
    }
}

class Main{

    public static void main(String[] args) {
        TextControllerImpl textController = new TextControllerImpl();

        List<Sentence> sentences = textController.sentencesWithSameWords();

        for (Sentence sentence : sentences) {
            System.out.println(sentence);
        }

    }
}

