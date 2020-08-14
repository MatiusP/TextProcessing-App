package by.epamtc.protsko.textprocessing.server.dao.impl;

import by.epamtc.protsko.textprocessing.common.bean.Text;
import by.epamtc.protsko.textprocessing.server.dao.TextDAO;
import by.epamtc.protsko.textprocessing.server.dao.parser.SourceTextParser;
import by.epamtc.protsko.textprocessing.server.dao.reader.DataReader;

public class TextDAOImpl implements TextDAO {
    private static final String fileName = "source.txt";

    @Override
    public Text getText() {

        DataReader dataReader = new DataReader();
        String sourceText = dataReader.readSourceFile(fileName);
        SourceTextParser sourceTextParser = SourceTextParser.getInstance();

        return sourceTextParser.parse(sourceText);
    }
}
