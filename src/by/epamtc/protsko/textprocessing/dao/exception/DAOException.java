package by.epamtc.protsko.textprocessing.dao.exception;

public class DAOException extends RuntimeException {

    public DAOException() {
    }

    public DAOException(String message) {
        super(message);
    }

    public DAOException(Exception exception) {
        super(exception);
    }

    public DAOException(String message, Exception exception) {
        super(message, exception);
    }
}
