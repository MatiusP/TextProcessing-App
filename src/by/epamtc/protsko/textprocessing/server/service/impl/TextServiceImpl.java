package by.epamtc.protsko.textprocessing.server.service.impl;

import by.epamtc.protsko.textprocessing.common.bean.*;
import by.epamtc.protsko.textprocessing.server.dao.DaoFactory;
import by.epamtc.protsko.textprocessing.server.dao.TextDAO;
import by.epamtc.protsko.textprocessing.server.service.TextService;
import by.epamtc.protsko.textprocessing.server.service.util.TextUtils;

import java.util.*;

public class TextServiceImpl implements TextService {
    private TextUtils textUtils = TextUtils.getInstance();


    @Override
    public Text getSourceText() {
        DaoFactory daoFactory = DaoFactory.getInstance();
        TextDAO textDAO = daoFactory.getTextDAO();
        return textDAO.getText();
    }

    @Override
    public List<Sentence> getSentencesWithSameWords(Text text) {
        List<Sentence> resultList = new ArrayList<>();
        Set<Word> words = new HashSet<>();

        List<Sentence> sentencesList = textUtils.getTextSentences(text);
        for (Sentence sentence : sentencesList) {
            List<Word> sentenceWords = textUtils.getSentenceWords(sentence);

            words.addAll(sentenceWords);
            if (words.size() != sentenceWords.size()) {
                resultList.add(sentence);
            }
        }
        return resultList;
    }


    @Override
    public List<Word> getWordsOfGivenLengthInInterrogativeSentence(Text text, int givenLength) {
        List<Word> resultList = new ArrayList<>();
        Set<Word> wordLinkedHashSet = new LinkedHashSet<>();

        List<Sentence> sentencesList = textUtils.getTextSentences(text);
        for (Sentence sentence : sentencesList) {
            List<PunctuationMark> sentencePunctuationMarks = textUtils.getSentencePunctuationMarks(sentence);

            for (PunctuationMark sentencePunctuationMark : sentencePunctuationMarks) {
                if (sentencePunctuationMark.getData().equals("?")) {
                    continue;
                }
            }

            List<Word> sentenceWords = textUtils.getSentenceWords(sentence);
            for (Word sentenceWord : sentenceWords) {
                if (sentenceWord.getData().length() == givenLength) {
                    wordLinkedHashSet.add(sentenceWord);
                }
            }
            sentence.setSentenceComponents(new ArrayList<>(wordLinkedHashSet));
        }
        return resultList;
    }


    @Override
    public List<Sentence> getSortedSentencesByCountOfWords(Text text) {
        List<Sentence> sentencesList = textUtils.getTextSentences(text);

        sentencesList.sort((o1, o2) -> textUtils.getSentenceWords(o1).size() - textUtils.getSentenceWords(o2).size());
        return sentencesList;
    }
}
