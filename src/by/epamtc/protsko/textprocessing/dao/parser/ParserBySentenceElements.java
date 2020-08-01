package by.epamtc.protsko.textprocessing.dao.parser;

import by.epamtc.protsko.textprocessing.bean.PunctuationMark;
import by.epamtc.protsko.textprocessing.bean.SentenceComponent;
import by.epamtc.protsko.textprocessing.bean.Word;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ParserBySentenceElements {

    private final static String parserBySentenceElementsRegex = "(?<Word>[\\d\\w-%]+)|(?<PunctuationMark>([\\W]))";
    private final Pattern pattern = Pattern.compile(parserBySentenceElementsRegex);
    private static final ParserBySentenceElements instance = new ParserBySentenceElements();

    private ParserBySentenceElements() {
    }

    public static ParserBySentenceElements getInstance() {
        return instance;
    }

    List<SentenceComponent> parseBySentenceElements(String sentence) {
        int componentOrder = 0;
        List<SentenceComponent> sentenceComponents = new ArrayList<>();

        Matcher matcher = pattern.matcher(sentence);

        while (matcher.find()) {

            String word = matcher.group("Word");
            String punctuationMark = matcher.group("PunctuationMark");

            if (word != null) {
                sentenceComponents.add(new Word(matcher.group(), ++componentOrder));
            }

            if (punctuationMark != null) {

                sentenceComponents.add(new PunctuationMark(matcher.group(), ++componentOrder));
            }
        }
        return sentenceComponents;
    }
}

//class Runner {
//    public static void main(String[] args) {
//        String text = "Hello world, Hello world, Hello world, Hello!!!?";
//        ParserBySentenceElements parserBySentenceElements = ParserBySentenceElements.getInstance();
//        List<SentenceComponent> list = parserBySentenceElements.parseBySentenceElements(text);
//
//        for (SentenceComponent sentenceComponent : list) {
//            System.out.println(sentenceComponent + " component order= " + sentenceComponent.getSentenceComponentOrder());
//        }
//    }
//}
