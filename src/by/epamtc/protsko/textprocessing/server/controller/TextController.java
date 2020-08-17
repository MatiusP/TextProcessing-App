package by.epamtc.protsko.textprocessing.server.controller;

import by.epamtc.protsko.textprocessing.common.bean.Sentence;
import by.epamtc.protsko.textprocessing.common.bean.Word;

import java.util.List;

public interface TextController {

    List<Sentence> sentencesWithSameWords();

    List<Word> wordsOfGivenLengthInInterrogativeSentence(int givenLength);

    List<Sentence> sortedSentencesByCountOfWords();
}
