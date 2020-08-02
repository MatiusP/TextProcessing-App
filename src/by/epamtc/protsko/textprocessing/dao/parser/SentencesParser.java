package by.epamtc.protsko.textprocessing.dao.parser;

import by.epamtc.protsko.textprocessing.bean.PunctuationMark;
import by.epamtc.protsko.textprocessing.bean.SentenceComponent;
import by.epamtc.protsko.textprocessing.bean.Word;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SentencesParser {

    private static final String parserBySentenceElementsRegex = "(?<Word>[\\d\\w-%]+)|(?<PunctuationMark>([\\W]))";
    private static final Pattern pattern = Pattern.compile(parserBySentenceElementsRegex);

    private static final SentencesParser instance = new SentencesParser();

    private SentencesParser() {
    }

    public static SentencesParser getInstance() {
        return instance;
    }

    public List<SentenceComponent> parse(String sentence) {
        int componentOrder = 1;
        List<SentenceComponent> sentenceComponents = new ArrayList<>();

        Matcher matcher = pattern.matcher(sentence);

        while (matcher.find()) {

            String word = matcher.group("Word");
            String punctuationMark = matcher.group("PunctuationMark");

            if (word != null) {
                sentenceComponents.add(new Word(matcher.group(), componentOrder++));
            }

            if ((punctuationMark != null) && (!punctuationMark.equals(" "))) {
                sentenceComponents.add(new PunctuationMark(matcher.group(), componentOrder++));
            }
        }
        return sentenceComponents;
    }
}
