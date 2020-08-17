package by.epamtc.protsko.textprocessing.client;

import java.io.*;
import java.net.Socket;

public class ClientDispatcher {

    private static void runClientSocket(String userAction) {
        try {

            Socket clientSocket = new Socket("localhost", 4004);
            ObjectOutputStream out = new ObjectOutputStream(clientSocket.getOutputStream());
            ObjectInputStream in = new ObjectInputStream(clientSocket.getInputStream());

            if (!userAction.equals("exit")) {
                out.writeUTF(userAction); // отправляем сообщение на сервер
                out.flush();

                Object object = in.readObject();
                System.out.println("result" + object);
            }

        } catch (Exception e) {
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

    static void exitProgram() {
        runClientSocket("exit");
    }
}
