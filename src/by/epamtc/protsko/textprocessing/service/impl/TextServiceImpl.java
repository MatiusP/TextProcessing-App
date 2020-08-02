package by.epamtc.protsko.textprocessing.service.impl;

import by.epamtc.protsko.textprocessing.bean.*;
import by.epamtc.protsko.textprocessing.service.TextService;
import by.epamtc.protsko.textprocessing.service.component.TextComponentsGetter;

import java.util.*;

public class TextServiceImpl implements TextService {
    TextComponentsGetter textComponentsGetter = TextComponentsGetter.getInstance();


    @Override
    public List<Sentence> searchSentencesWithSameWords(Text text) {
        List<Sentence> resultList = new ArrayList<>();
        Set<Word> words = new HashSet<>();

        List<Sentence> sentencesList = textComponentsGetter.getTextSentences(text);
        for (Sentence sentence : sentencesList) {
            List<Word> sentenceWords = textComponentsGetter.getSentenceWords(sentence);

            words.addAll(sentenceWords);
            if (words.size() != sentenceWords.size()) {
                resultList.add(sentence);
            }
        }
        return resultList;
    }


    @Override
    public List<Sentence> searchWordsOfGivenLength(Text text, int givenLength) {
        List<Sentence> resultList = new ArrayList<>();
        Set<Word> set = new LinkedHashSet<>();

        List<Sentence> sentencesList = textComponentsGetter.getTextSentences(text);
        for (Sentence sentence : sentencesList) {
            List<PunctuationMark> sentencePunctuationMarks = textComponentsGetter.getSentencePunctuationMarks(sentence);

            if (sentencePunctuationMarks.contains('?')) {
                resultList.add(sentence);

                List<Word> sentenceWords = textComponentsGetter.getSentenceWords(sentence);
                for (Word sentenceWord : sentenceWords) {
                    if (sentenceWord.getData().length() == givenLength) {
                        set.add(sentenceWord);
                    }
                }
                sentence.setSentenceComponents(new ArrayList<>(set));
            }
        }
        return resultList;
    }


    @Override
    public List<Word> sortWordsByCountOfGivenLetter(Text text, Character letter) {
        List<Word> resultList = new ArrayList<>();


        return resultList;
    }
}
