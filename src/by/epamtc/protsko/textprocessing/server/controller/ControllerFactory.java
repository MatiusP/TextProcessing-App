package by.epamtc.protsko.textprocessing.server.controller;

import by.epamtc.protsko.textprocessing.server.controller.impl.TextControllerImpl;

public class ControllerFactory {

    private static final ControllerFactory instance = new ControllerFactory();
    private static TextController textController = new TextControllerImpl();

    private ControllerFactory() {
    }

    public static ControllerFactory getInstance() {
        return instance;
    }

    public static TextController getTextController() {
        return textController;
    }
}
