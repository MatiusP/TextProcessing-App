package by.epamtc.protsko.textprocessing.client;

import by.epamtc.protsko.textprocessing.server.controller.exception.ControllerException;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class ClientDispatcher {
    private static Socket clientSocket;
    private static ObjectInputStream in;
    private static ObjectOutputStream out;

    public static void runClientSocket() {
        try {
            clientSocket = new Socket("localhost", 4004);
            out = new ObjectOutputStream(clientSocket.getOutputStream());
            in = new ObjectInputStream(clientSocket.getInputStream());
        } catch (IOException exception) {
            throw new ControllerException(exception);
        }
    }

    public static void getResult(String userAction) {
        try {

            if (!userAction.equals("exit")) {
                out.writeUTF(userAction);
                out.flush();

                Object object = in.readObject();
                System.out.println("result" + object);
            } else {
                closeClientSocket();
            }
        } catch (Exception exception) {
            throw new ControllerException(exception);
        }
    }

    private static void closeClientSocket() {
        try {
            in.close();
            out.close();
            clientSocket.close();
        } catch (IOException exception) {
            throw new ControllerException(exception);
        }
    }
}
