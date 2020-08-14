package by.epamtc.protsko.textprocessing.server.service;

import by.epamtc.protsko.textprocessing.common.bean.Sentence;
import by.epamtc.protsko.textprocessing.common.bean.Text;
import by.epamtc.protsko.textprocessing.common.bean.Word;

import java.util.List;

public interface TextService {

    Text getSourceText();

    List<Sentence> getSentencesWithSameWords(Text text);

    List<Word> getWordsOfGivenLengthInInterrogativeSentence(Text text, int givenLength);

    List<Sentence> getSortedSentencesByCountOfWords(Text text);

}
