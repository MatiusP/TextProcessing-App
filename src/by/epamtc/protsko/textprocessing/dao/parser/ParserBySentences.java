package by.epamtc.protsko.textprocessing.dao.parser;

import by.epamtc.protsko.textprocessing.bean.Sentence;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ParserBySentences {

    private final static String parserBySentenceRegex =
            ("(\\.+.+[$\\n])|((\\d+\\.)+.+[$\\n])|((.+?\\n*?)+?[.!?:]\\s\\n?)");
    private final Pattern pattern = Pattern.compile(parserBySentenceRegex);

    private static ParserBySentenceElements parserBySentenceElements = ParserBySentenceElements.getInstance();
    private static final ParserBySentences instance = new ParserBySentences();

    private ParserBySentences() {
    }

    public static ParserBySentences getInstance() {
        return instance;
    }

    List<Sentence> parseBySentence(String textBlock) {
        List<Sentence> sentences = new ArrayList<>();
        Matcher matcher = pattern.matcher(textBlock);
        Sentence sentence;

        while (matcher.find()) {
            sentence = new Sentence(matcher.group());
            sentence.setSentenceComponents(parserBySentenceElements.parseBySentenceElements(matcher.group()));
            sentences.add(sentence);
        }
        return sentences;
    }
}

//class RunnerSentence {
//
//    public static void main(String[] args) {
//        String text = "The if-then statement is the most basic of all the control flow statements. " +
//                "It tells your program to execute a certain section of code only if a particular test evaluates to true. " +
//                "For example, the Bicycle class could allow the brakes to decrease the bicycle's speed only if the bicycle is already in motion. " +
//                "One possible implementation of the applyBrakes method could be as follows: ";
//
//
//        ParserBySentences parserBySentences = ParserBySentences.getInstance();
//
//        List<Sentence> sentences = parserBySentences.parseBySentence(text);
//
//        for (Sentence sentence : sentences) {
//            System.out.println(sentence);
//            System.out.println(sentence.getSentenceComponents());
//        }
//    }
//
//}
