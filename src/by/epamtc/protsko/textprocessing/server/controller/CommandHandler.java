package by.epamtc.protsko.textprocessing.server.controller;

import by.epamtc.protsko.textprocessing.server.controller.strategy.StrategyHandler;

public class CommandHandler {
    private static StrategyHandler strategyHandler = new StrategyHandler();

    private CommandHandler() {
    }

    public static Object executeCommand(String userCommand) {
        return strategyHandler.getMethod(userCommand).executeUserCommand();
    }
}
