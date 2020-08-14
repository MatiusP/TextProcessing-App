package by.epamtc.protsko.textprocessing.server.dao.reader;

import by.epamtc.protsko.textprocessing.server.dao.exception.DAOException;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyReader {

    private static final PropertyReader instance = new PropertyReader();
    private static Properties property = new Properties();

    private PropertyReader() {
    }

    public static PropertyReader getInstance() {
        return instance;
    }

    private static Properties readPropertiesFile() {
        try (FileInputStream propertyReader = new FileInputStream("./resources/regex.properties")) {
            property.load(propertyReader);
        } catch (IOException e) {
            throw new DAOException(e);
        }
        return property;
    }

    public String parseByTextBlockRegex() {
        return readPropertiesFile().getProperty("parserByTextBlockRegex");
    }

    public String parseByCodeBlockRegex() {
        return readPropertiesFile().getProperty("parserByCodeBlockRegex");
    }

    public String parseSentenceByWordsRegex() {
        return readPropertiesFile().getProperty("parserSentenceByWordsRegex");
    }

    public String parseSentenceByPunctuationMarksRegex() {
        return readPropertiesFile().getProperty("parserSentenceByPunctuationMarksRegex");
    }

    public String parseBySentenceRegex() {
        return readPropertiesFile().getProperty("parserBySentenceRegex");
    }
}
