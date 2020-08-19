package by.epamtc.protsko.textprocessing.server.dao.parser;

import by.epamtc.protsko.textprocessing.common.bean.CodeBlock;
import by.epamtc.protsko.textprocessing.common.bean.Text;
import by.epamtc.protsko.textprocessing.common.bean.TextBlock;
import by.epamtc.protsko.textprocessing.server.dao.reader.PropertyReader;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SourceTextParser {

    private static final String textBlockRegex = PropertyReader.getInstance().parseByTextBlockRegex();
    private static final String codeBlockRegex = PropertyReader.getInstance().parseByCodeBlockRegex();
    private static final String parserTextByBlocksRegex = (textBlockRegex + "|" + codeBlockRegex);

    private static final Pattern pattern = Pattern.compile(parserTextByBlocksRegex);

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
