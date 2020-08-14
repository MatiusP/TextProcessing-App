package by.epamtc.protsko.textprocessing.client.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConsoleRunner {

    private static String userCommand;


    private static String getUserCommand() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Выберите действие над текстом: ");

        mark:
        while (true) {
            userCommand = reader.readLine();

            switch (userCommand) {
                case "1":
                    userCommand = "sentencesWithSameWords";
                    break mark;
                case "2":
                    userCommand = "wordsOfGivenLengthInInterrogativeSentence";
                    break mark;
                case "3":
                    userCommand = "sortedSentencesByCountOfWords";
                    break mark;
                case "4":
                    break mark;
                default:
                    System.out.print("Некорректный ввод. Попробуйте еще раз: ");
            }
        }
        return userCommand;
    }


    public void startProgram() throws IOException {
        Menu.showMenu();
        String userCommand = ConsoleRunner.getUserCommand();
        SocketConnection.sendCommandToServer(userCommand);
    }
}
