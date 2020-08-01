package by.epamtc.protsko.textprocessing.dao.impl;

import by.epamtc.protsko.textprocessing.bean.Text;
import by.epamtc.protsko.textprocessing.dao.TextDAO;
import by.epamtc.protsko.textprocessing.dao.exception.DAOException;
import by.epamtc.protsko.textprocessing.dao.parser.ParserSourceText;
import by.epamtc.protsko.textprocessing.dao.reader.ReaderFromFile;

public class TextDAOImpl implements TextDAO {

    @Override
    public Text getText() throws DAOException {

        ReaderFromFile readerFromFile = new ReaderFromFile();
        String sourceText = readerFromFile.readSourceFile("source.txt");
        ParserSourceText parserSourceText = ParserSourceText.getInstance();

        return parserSourceText.parseSourceText(sourceText);
    }
}
