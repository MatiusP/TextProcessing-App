package by.epamtc.protsko.textprocessing.client.util;

import java.io.*;
import java.net.Socket;

public class ClientSocketConnection {


    private static void runClientSocket(String action) {
        try (Socket clientSocket = new Socket("localhost", 4004);
             BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
             BufferedWriter out = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()))
        ) {

            String userAction = action;
            out.write(userAction + "\n"); // отправляем сообщение на сервер
            out.flush();

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
