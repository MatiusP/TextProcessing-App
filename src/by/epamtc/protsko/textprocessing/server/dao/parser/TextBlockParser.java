package by.epamtc.protsko.textprocessing.server.dao.parser;

import by.epamtc.protsko.textprocessing.common.bean.Sentence;
import by.epamtc.protsko.textprocessing.server.dao.reader.PropertyReader;

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
