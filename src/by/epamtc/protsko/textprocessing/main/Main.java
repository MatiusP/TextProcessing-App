package by.epamtc.protsko.textprocessing.main;

import by.epamtc.protsko.textprocessing.bean.Text;
import by.epamtc.protsko.textprocessing.dao.DaoFactory;
import by.epamtc.protsko.textprocessing.dao.TextDAO;
import by.epamtc.protsko.textprocessing.service.ServiceFactory;
import by.epamtc.protsko.textprocessing.service.TextService;

public class Main {

    public static void main(String[] args) {

        DaoFactory daoFactory = DaoFactory.getInstance();
        TextDAO textDAO = daoFactory.getTextDAO();
        Text sourceText = textDAO.getText();

        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        TextService textService = serviceFactory.getTextService();


        textService.searchSentencesWithSameWords(sourceText);

        textService.searchWordsOfGivenLength(sourceText, 4);

        textService.sortWordsByCountOfGivenLetter(sourceText, 'b');


    }
}
