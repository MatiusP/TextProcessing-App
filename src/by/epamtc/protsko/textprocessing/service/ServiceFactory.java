package by.epamtc.protsko.textprocessing.service;

import by.epamtc.protsko.textprocessing.service.impl.TextServiceImpl;

public class ServiceFactory {

    private static final ServiceFactory instance = new ServiceFactory();
    private final TextService textService = new TextServiceImpl();

    private ServiceFactory() {
    }

    public ServiceFactory getInstance() {
        return instance;
    }

    public TextService getTextService() {
        return textService;
    }
}
