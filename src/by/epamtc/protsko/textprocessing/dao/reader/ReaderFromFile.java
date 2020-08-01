package by.epamtc.protsko.textprocessing.dao.reader;

import by.epamtc.protsko.textprocessing.dao.exception.DAOException;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReaderFromFile {
    private static final String FILE_PATH = "./resources/";

    public String readSourceFile(String fileName) throws DAOException {
        String sourceFile = FILE_PATH + fileName;

        StringBuilder textFromDataSource = new StringBuilder();

        try (BufferedReader reader = new BufferedReader(new FileReader(sourceFile))) {
            String line;

            while ((line = reader.readLine()) != null) {
                textFromDataSource.append(line).append("\n");
            }
        } catch (IOException e) {
            throw new DAOException(e);
        }
        return textFromDataSource.toString();
    }
}
