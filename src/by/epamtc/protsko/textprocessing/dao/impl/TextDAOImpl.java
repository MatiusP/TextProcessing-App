package by.epamtc.protsko.textprocessing.dao.impl;

import by.epamtc.protsko.textprocessing.bean.Text;
import by.epamtc.protsko.textprocessing.dao.TextDAO;
import by.epamtc.protsko.textprocessing.dao.parser.SourceTextParser;
import by.epamtc.protsko.textprocessing.dao.reader.DataReader;

public class TextDAOImpl implements TextDAO {
    private final String fileName = "source.txt";

    @Override
    public Text getText() {

        DataReader dataReader = new DataReader();
        String sourceText = dataReader.readSourceFile(fileName);
        SourceTextParser sourceTextParser = SourceTextParser.getInstance();

        return sourceTextParser.parse(sourceText);
    }
}
