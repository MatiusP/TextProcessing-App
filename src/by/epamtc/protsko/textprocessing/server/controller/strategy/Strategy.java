package by.epamtc.protsko.textprocessing.server.controller.strategy;

import by.epamtc.protsko.textprocessing.server.controller.ControllerFactory;
import by.epamtc.protsko.textprocessing.server.controller.TextController;

public interface Strategy {
    TextController textController = ControllerFactory.getTextController();

    Object executeUserCommand();
}
