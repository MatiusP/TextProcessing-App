package by.epamtc.protsko.textprocessing.server.service;

import by.epamtc.protsko.textprocessing.server.service.impl.TextServiceImpl;

public class ServiceFactory {

    private static final ServiceFactory instance = new ServiceFactory();
    private final TextService textService = new TextServiceImpl();

    private ServiceFactory() {
    }

    public static ServiceFactory getInstance() {
        return instance;
    }

    public TextService getTextService() {
        return textService;
    }
}
