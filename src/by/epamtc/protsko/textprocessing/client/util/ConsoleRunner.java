package by.epamtc.protsko.textprocessing.client.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConsoleRunner {

    private static void getUserCommand() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Выберите действие над текстом: ");

        mark:
        while (true) {
            String userCommand = reader.readLine();

            switch (userCommand) {
                case "1":
                    SocketConnection.getSentencesWithSameWords();
                    break mark;
                case "2":
                    SocketConnection.getWordsOfGivenLengthInInterrogativeSentence();
                    break mark;
                case "3":
                    SocketConnection.getSortedSentencesByCountOfWords();
                    break mark;
                case "4":
                    break mark;
                default:
                    System.out.print("Некорректный ввод. Попробуйте еще раз: ");
            }
        }
    }

    public void startProgram() throws IOException {
        Menu.showMenu();
        ConsoleRunner.getUserCommand();
    }
}
