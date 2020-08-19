package by.epamtc.protsko.textprocessing.client;

import java.io.*;
import java.net.Socket;

public class ClientDispatcher {
    private static Socket clientSocket;

    private static void runClientSocket(String userAction) {
        try (ObjectOutputStream out = new ObjectOutputStream(clientSocket.getOutputStream());
             ObjectInputStream in = new ObjectInputStream(clientSocket.getInputStream())) {

            clientSocket = new Socket("localhost", 4004);

            int i = 0;
            do {
                if (i == 1) {
                    new ConsoleRunner().startProgram();
                }
                if (!userAction.equals("exit")) {

                    out.writeUTF(userAction);
                    out.flush();

                    Object object = in.readObject();
                    System.out.println("result" + object);
                    i = 1;
                }
                clientSocket.close();
            } while (!clientSocket.isClosed());

            Object object = in.readObject();
            System.out.println("result" + object);

        } catch (
                Exception e) {
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
