package by.epamtc.protsko.textprocessing.server.controller;

import by.epamtc.protsko.textprocessing.common.bean.Sentence;
import by.epamtc.protsko.textprocessing.common.bean.Text;
import by.epamtc.protsko.textprocessing.common.bean.Word;

import java.util.List;

public interface TextController {

    List<Sentence> sentencesWithSameWords(Text text);

    List<Word> wordsOfGivenLengthInInterrogativeSentence(Text text, int givenLength);

    List<Sentence> sortedSentencesByCountOfWords(Text text);
}
