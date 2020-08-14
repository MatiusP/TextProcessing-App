package by.epamtc.protsko.textprocessing.server.controller.exception;

public class ControllerException extends RuntimeException {

    public ControllerException() {
        super();
    }

    public ControllerException(String message) {
        super(message);
    }

    public ControllerException(Exception exception) {
        super(exception);
    }

    public ControllerException(String message, Exception exception) {
        super(message, exception);
    }
}
