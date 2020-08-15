package by.epamtc.protsko.textprocessing.client.util;

import by.epamtc.protsko.textprocessing.server.controller.util.ServerRequestDispatcher;

import java.io.*;
import java.net.Socket;

public class ClientSocketConnection {


    private static void runClientSocket(String command) {
        try (Socket clientSocket = new Socket("localhost", 4004);
             BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
             BufferedWriter out = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()))
        ) {

            String word = command;
            out.write(word + "\n"); // отправляем сообщение на сервер
            out.flush();

            System.out.println("User command = " +ServerRequestDispatcher.getUserCommand());




            String serverWord = in.readLine(); // ждём, что скажет сервер
            System.out.println(serverWord); // получив - выводим на экран
        } catch (IOException e) {
            System.err.println(e);
        } finally {
            System.out.println("Клиент закрыт...");
        }
    }

    static void getSentencesWithSameWords() {
        runClientSocket("sentencesWithSameWords");
    }

    static void getWordsOfGivenLengthInInterrogativeSentence() {
        runClientSocket("wordsOfGivenLengthInInterrogativeSentence");
    }

    static void getSortedSentencesByCountOfWords() {
        runClientSocket("sortedSentencesByCountOfWords");
    }
}
