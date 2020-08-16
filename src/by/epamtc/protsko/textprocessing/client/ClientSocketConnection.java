package by.epamtc.protsko.textprocessing.client;

import java.io.*;
import java.net.Socket;
import java.util.List;

public class ClientSocketConnection {

    private static void runClientSocket(String userAction) {
        try (Socket clientSocket = new Socket("localhost", 4004);
             BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
             BufferedWriter out = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()))
        ) {

            out.write(userAction + "\n"); // отправляем сообщение на сервер
            out.flush();

//            String serverWord = in.readLine(); // ждём, что скажет сервер

            //            System.out.println(serverWord); // получив - выводим на экран

        } catch (Exception e) {
            System.err.println(e);
        } finally {
            System.out.println("Клиент закрыт...");
        }
    }

    private static List<Object> deserializeResult(byte[] array) throws IOException, ClassNotFoundException {
        ObjectInputStream objectInputStream = new ObjectInputStream(
                new ByteArrayInputStream(array));
        List<Object> result = (List<Object>) objectInputStream.readObject();
//        objectInputStream.close();

        return result;
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
