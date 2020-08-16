package by.epamtc.protsko.textprocessing.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConsoleRunner {

    private static void showMenu() {
        System.out.println("----- Это программа для работы с текстовым файлом -----\n");
        System.out.println("Выберите действие, которое необходимо выполнить с текстовым файлом:");
        System.out.println("1 - Поиск предложений в тексте, в которых есть одинаковые слова.");
        System.out.println("2 - Поиск и печать (без повторений, во всех вопросительных предложениях текста) слов заданной длины.");
        System.out.println("3 - Сортировка предложений текста по количеству слов в них.");
        System.out.println("4 - Выход из приложения\n");
    }

    private static void executeUserAction() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Выберите действие над текстом: ");
        boolean isCorrectAction;

        do {
            isCorrectAction = true;
            String userCommand = reader.readLine();

            switch (userCommand) {
                case "1":
                    ClientSocketConnection.getSentencesWithSameWords();
                    break;
                case "2":
                    ClientSocketConnection.getWordsOfGivenLengthInInterrogativeSentence();
                    break;
                case "3":
                    ClientSocketConnection.getSortedSentencesByCountOfWords();
                    break;
                case "4":
                    ClientSocketConnection.exitProgram();
                    break;
                default:
                    System.out.print("Некорректный ввод. Попробуйте еще раз: ");
                    isCorrectAction = false;
            }
        } while (!isCorrectAction);
    }

    public void startProgram() throws IOException {
        showMenu();
        ConsoleRunner.executeUserAction();
    }
}
