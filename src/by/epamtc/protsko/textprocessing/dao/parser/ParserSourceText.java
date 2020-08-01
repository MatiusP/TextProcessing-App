package by.epamtc.protsko.textprocessing.dao.parser;

import by.epamtc.protsko.textprocessing.bean.CodeBlock;
import by.epamtc.protsko.textprocessing.bean.Text;
import by.epamtc.protsko.textprocessing.bean.TextBlock;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ParserSourceText {

    private final static String parserTextByBlockRegex =
            ("(?<TextBlock>[^{}]+\\n)|(?<CodeBlock>.*\\{\\n(.*\\n)+?\\n*}\\n([}]?\\n)+)");
    private final Pattern pattern = Pattern.compile(parserTextByBlockRegex);

    private static ParserBySentences parserBySentences = ParserBySentences.getInstance();
    private static final ParserSourceText instance = new ParserSourceText();

    private ParserSourceText() {
    }

    public static ParserSourceText getInstance() {
        return instance;
    }

    public Text parseSourceText(String sourceText) {
        Matcher matcher = pattern.matcher(sourceText);

        Text text = new Text();

        while (matcher.find()) {
            String textBlock = matcher.group("TextBlock");
            String codeBlock = matcher.group("CodeBlock");

            if (textBlock != null) {
                TextBlock block = new TextBlock(matcher.group());
                block.setSentences(parserBySentences.parseBySentence(matcher.group()));
                text.addDataComponent(block);
            }

            if (codeBlock != null) {
                text.addDataComponent(new CodeBlock(matcher.group()));
            }
        }
        return text;
    }
}
//
//class Runner2 {
//
//    public static void main(String[] args) throws DAOException {
//        ReaderFromFile readerFromFile = new ReaderFromFile();
//        String sourceText = readerFromFile.readSourceFile("source.txt");
//        ParserSourceText parserSourceText = ParserSourceText.getInstance();
//
//        Text text = parserSourceText.parseSourceText(sourceText);
//        for (DataComponent dataComponent : text.getText()) {
//            System.out.println(dataComponent);
//        }
//    }
//}