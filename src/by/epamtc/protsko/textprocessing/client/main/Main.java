package by.epamtc.protsko.textprocessing.client.main;

import by.epamtc.protsko.textprocessing.client.util.ConsoleRunner;
import by.epamtc.protsko.textprocessing.client.util.Menu;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        Menu.showMenu();
        ConsoleRunner consoleRunner = new ConsoleRunner();
        consoleRunner.startProgram();
    }
}
