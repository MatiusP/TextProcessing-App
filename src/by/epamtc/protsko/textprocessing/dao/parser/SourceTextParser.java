package by.epamtc.protsko.textprocessing.dao.parser;

import by.epamtc.protsko.textprocessing.bean.CodeBlock;
import by.epamtc.protsko.textprocessing.bean.Text;
import by.epamtc.protsko.textprocessing.bean.TextBlock;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SourceTextParser {

    private static final String parserTextByBlockRegex =
            ("(?<textBlock>[^{}]+\\n)|(?<codeBlock>.*\\{\\n(.*\\n)+?\\n*}\\n([}]?\\n)+)");
    private static final Pattern pattern = Pattern.compile(parserTextByBlockRegex);

    private static final SourceTextParser instance = new SourceTextParser();
    private static TextBlockParser textBlockParser = TextBlockParser.getInstance();


    private SourceTextParser() {
    }

    public static SourceTextParser getInstance() {
        return instance;
    }

    public Text parse(String sourceText) {
        Matcher matcher = pattern.matcher(sourceText);

        Text text = new Text();

        while (matcher.find()) {
            String textBlock = matcher.group("textBlock");
            String codeBlock = matcher.group("codeBlock");

            if (textBlock != null) {
                String tmp = matcher.group();
                TextBlock block = new TextBlock(tmp);
                block.setSentences(textBlockParser.parse(tmp));
                text.addDataComponent(block);
            }

            if (codeBlock != null) {
                text.addDataComponent(new CodeBlock(matcher.group()));
            }
        }
        return text;
    }
}
