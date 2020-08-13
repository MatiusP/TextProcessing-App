package by.epamtc.protsko.textprocessing.dao.parser;

import by.epamtc.protsko.textprocessing.bean.Sentence;
import by.epamtc.protsko.textprocessing.dao.reader.PropertyReader;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TextBlockParser {

    private static final String parserBySentenceRegex = PropertyReader.getInstance().parseBySentenceRegex();
    private static final Pattern pattern = Pattern.compile(parserBySentenceRegex);

    private static final TextBlockParser instance = new TextBlockParser();
    private static SentencesParser sentencesParser = SentencesParser.getInstance();

    private TextBlockParser() {
    }

    public static TextBlockParser getInstance() {
        return instance;
    }

    public List<Sentence> parse(String textBlock) {
        List<Sentence> sentences = new ArrayList<>();
        Matcher matcher = pattern.matcher(textBlock);
        Sentence sentence;

        while (matcher.find()) {
            sentence = new Sentence(matcher.group());
            sentence.setSentenceComponents(sentencesParser.parse(matcher.group()));
            sentences.add(sentence);
        }
        return sentences;
    }
}

//class Main {
//    public static void main(String[] args) {
//        TextBlockParser obj = TextBlockParser.getInstance();
//        List<Sentence> parse = obj.parse("1.The if-then and if-then-else Statements\n" +
//                "1.1.The if-then Statement\n" +
//                "The if-then statement is the most basic of all the control flow statements. It tells your program to execute a certain section of code only if a particular test evaluates to true. For example, the Bicycle class could allow the brakes to decrease the bicycle's speed only if the bicycle is already in motion. One possible implementation of the applyBrakes method could be as follows. ");
//
//        for (Sentence sentence : parse) {
//            System.out.println(sentence);
//        }
//
//
//    }
//}
