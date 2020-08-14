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


    @Override
    public List<Sentence> sentencesWithSameWords(Text text) {
        return textService.getSentencesWithSameWords(text);
    }

    @Override
    public List<Word> wordsOfGivenLengthInInterrogativeSentence(Text text, int givenLength) {
        return textService.getWordsOfGivenLengthInInterrogativeSentence(text, givenLength);
    }

    @Override
    public List<Sentence> sortedSentencesByCountOfWords(Text text) {
        return textService.getSortedSentencesByCountOfWords(text);
    }
}
