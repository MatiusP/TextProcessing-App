package by.epamtc.protsko.textprocessing.server.controller;

import by.epamtc.protsko.textprocessing.server.controller.exception.ControllerException;
import by.epamtc.protsko.textprocessing.server.controller.handler.UserCommandHandler;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerRunner {

    private void runServerSocket() {
        System.out.println("Сервер запущен!");

        try (ServerSocket server = new ServerSocket(4004);
             Socket clientSocket = server.accept();
             ObjectInputStream in = new ObjectInputStream(clientSocket.getInputStream());
             ObjectOutputStream out = new ObjectOutputStream(clientSocket.getOutputStream())) {

            while (!clientSocket.isClosed()) {
                String userCommand = in.readUTF();

                if (userCommand.equals("exit")) {
                    break;
                }

                out.writeObject(UserCommandHandler.executeCommand(userCommand));
                out.flush();
            }
        } catch (Exception exception) {
            throw new ControllerException(exception);
        }
    }

    public static void main(String[] args) {
        ServerRunner serverRequestDispatcher = new ServerRunner();
        serverRequestDispatcher.runServerSocket();
    }
}
