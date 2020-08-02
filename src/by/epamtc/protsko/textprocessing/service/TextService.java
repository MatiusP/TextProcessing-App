package by.epamtc.protsko.textprocessing.service;

import by.epamtc.protsko.textprocessing.bean.Sentence;
import by.epamtc.protsko.textprocessing.bean.Text;
import by.epamtc.protsko.textprocessing.bean.Word;

import java.util.List;

public interface TextService {

    List<Sentence> searchSentencesWithSameWords(Text text);

    List<Sentence> searchWordsOfGivenLength(Text text, int givenLength);

    List<Word> sortWordsByCountOfGivenLetter(Text text, Character letter);

}
