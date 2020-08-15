package by.epamtc.protsko.textprocessing.client.util;

import java.io.*;
import java.net.Socket;

public class ClientSocketConnection {

    private static Socket clientSocket; //сокет для общения
    private static BufferedReader in; // поток чтения из сокета
    private static BufferedWriter out; // поток записи в сокет

    private static void runClientSocket(String command) {
        try {
            try {
                clientSocket = new Socket("localhost", 4004); // этой строкой мы запрашиваем у сервера доступ на соединение
                in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));  // читать соообщения с сервера
                out = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()));  // писать туда же

                String word = command;
                out.write(word + "\n"); // отправляем сообщение на сервер
                out.flush();

                String serverWord = in.readLine(); // ждём, что скажет сервер
                System.out.println(serverWord); // получив - выводим на экран

            } finally { // в любом случае необходимо закрыть сокет и потоки
                System.out.println("Клиент был закрыт...");
                clientSocket.close();
                in.close();
                out.close();
            }
        } catch (IOException e) {
            System.err.println(e);
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
