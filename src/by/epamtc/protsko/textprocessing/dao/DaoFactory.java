package by.epamtc.protsko.textprocessing.dao;

import by.epamtc.protsko.textprocessing.dao.impl.TextDAOImpl;

public class DaoFactory {

    private static final DaoFactory instance = new DaoFactory();

    private final TextDAO textDAO = new TextDAOImpl();

    private DaoFactory() {
    }

    public static DaoFactory getInstance() {
        return instance;
    }

    public TextDAO getTextDAO() {
        return textDAO;
    }
}
