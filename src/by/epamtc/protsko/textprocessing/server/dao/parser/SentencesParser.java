package by.epamtc.protsko.textprocessing.server.dao.parser;

import by.epamtc.protsko.textprocessing.common.bean.PunctuationMark;
import by.epamtc.protsko.textprocessing.common.bean.SentenceComponent;
import by.epamtc.protsko.textprocessing.common.bean.Word;
import by.epamtc.protsko.textprocessing.server.dao.reader.PropertyReader;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SentencesParser {

    private static final String parserByWordsRegex = PropertyReader.getInstance().parseSentenceByWordsRegex();
    private static final String parserByPunctuationMarkRegex = PropertyReader.getInstance().parseSentenceByPunctuationMarksRegex();
    private static final String parserBySentenceElementsRegex = (parserByWordsRegex + "|" + parserByPunctuationMarkRegex);
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

//class Main4 {
//
//    public static void main(String[] args) {
//
//        SentencesParser obj = SentencesParser.getInstance();
//        List<SentenceComponent> parse = obj.parse("1.The if-then and if-then-else Statements");
//
//        for (SentenceComponent sentenceComponent : parse) {
//            System.out.println(sentenceComponent);
//        }
//    }
//}
