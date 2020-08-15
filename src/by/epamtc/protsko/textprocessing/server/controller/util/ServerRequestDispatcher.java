package by.epamtc.protsko.textprocessing.server.controller.util;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerRequestDispatcher {

    private static String userCommand;
    private static Socket clientSocket; //сокет для общения
    private static BufferedReader in; // поток чтения из сокета
    private static BufferedWriter out; // поток записи в сокет

    private void runServerSocket() {
        try (ServerSocket server = new ServerSocket(4004)) {
            try {

                System.out.println("Сервер запущен!");
                clientSocket = server.accept(); // accept() будет ждать пока кто-нибудь не захочет подключиться
                System.out.println("Server waiting connection...");
                try {
                    in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                    out = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()));

                    userCommand = in.readLine(); // ждём пока клиент что-нибудь нам напишет

                    out.write("На сервер было передано : " + userCommand + "\n");
                    out.flush(); // выталкиваем все из буфера

                } finally { // в любом случае сокет будет закрыт
                    clientSocket.close();
                    in.close();
                    out.close();
                }
            } finally {
                System.out.println("Сервер закрыт!");
            }
        } catch (IOException e) {
            System.err.println(e);
        }
    }

    public static String getUserCommand() throws IOException {
        return userCommand;
    }


    public static void main(String[] args) {
        ServerRequestDispatcher obj = new ServerRequestDispatcher();
        obj.runServerSocket();
    }
}
