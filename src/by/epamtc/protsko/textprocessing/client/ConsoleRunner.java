package by.epamtc.protsko.textprocessing.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConsoleRunner {

    private static void showMenu() {
        System.out.println("----- Программа для работы с текстовым файлом -----\n");
        System.out.println("Выберите действие, которое необходимо выполнить с текстовым файлом:");
        System.out.println("1 - Поиск предложений в тексте, в которых есть одинаковые слова.");
        System.out.println("2 - Поиск и печать (без повторений, во всех вопросительных предложениях текста) слов заданной длины.");
        System.out.println("3 - Сортировка предложений текста по количеству слов в них.");
        System.out.println("4 - Выход из приложения\n");
    }

    private static void executeUserAction() throws IOException {
        ClientDispatcher.runClientSocket();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        boolean isPressExit = false;

        do {
            showMenu();
            System.out.print("Выберите действие над текстом: ");
            String userCommand = reader.readLine();

            switch (userCommand) {
                case "1":
                    ClientDispatcher.getResult("sentencesWithSameWords");
                    break;
                case "2":
                    ClientDispatcher.getResult("wordsOfGivenLengthInInterrogativeSentence");
                    break;
                case "3":
                    ClientDispatcher.getResult("sortedSentencesByCountOfWords");
                    break;
                case "4":
                    ClientDispatcher.getResult("exit");
                    isPressExit = true;
                    break;
                default:
                    System.out.print("Некорректный ввод. Попробуйте еще раз: ");
            }
        } while (!isPressExit);
    }

    public void startProgram() throws IOException {
//        showMenu();
        ConsoleRunner.executeUserAction();
    }
}
