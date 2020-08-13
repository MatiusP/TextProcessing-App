package by.epamtc.protsko.textprocessing.dao.parser;

import by.epamtc.protsko.textprocessing.bean.CodeBlock;
import by.epamtc.protsko.textprocessing.bean.Text;
import by.epamtc.protsko.textprocessing.bean.TextBlock;
import by.epamtc.protsko.textprocessing.dao.reader.PropertyReader;

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

//class Main2 {
//
//    public static void main(String[] args) {
//        SourceTextParser obj = SourceTextParser.getInstance();
//        Text parse = obj.parse("1.The if-then and if-then-else Statements\n" +
//                "1.1.The if-then Statement\n" +
//                "The if-then statement is the most basic of all the control flow statements. It tells your program to execute a certain section of code only if a particular test evaluates to true. For example, the Bicycle class could allow the brakes to decrease the bicycle's speed only if the bicycle is already in motion. One possible implementation of the applyBrakes method could be as follows.\n" +
//                "\n" +
//                "void applyBrakes() {\n" +
//                "// the \"if\" clause: bicycle must be moving\n" +
//                "if (isMoving){\n" +
//                "// the \"then\" clause: decrease current speed\n" +
//                "currentSpeed--;\n" +
//                "}\n" +
//                "}\n");
//
//        System.out.println(parse);
//    }
//}
