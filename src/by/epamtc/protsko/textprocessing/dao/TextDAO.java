package by.epamtc.protsko.textprocessing.dao;

import by.epamtc.protsko.textprocessing.bean.Text;
import by.epamtc.protsko.textprocessing.dao.exception.DAOException;

public interface TextDAO {
    Text getText() throws DAOException;
}
