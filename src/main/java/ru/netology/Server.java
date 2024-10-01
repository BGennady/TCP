package ru.netology;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Main {
    public static void main(String[] args) throws IOException {
        System.out.println("Server started");
        int port = 8010;

        // создаем новый сервер
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            while (true) {
                try
                    // создаем новый клиентский сокет и подключаем его
                        (Socket clientScoket = serverSocket.accept();
                         // создаем исходящий поток
                         PrintWriter out = new PrintWriter(clientScoket.getOutputStream(), true);
                         // создаем входящий поток
                         BufferedReader in = new BufferedReader(new InputStreamReader(clientScoket.getInputStream()));
                        ) {
                    System.out.printf("New connection accepted. Port: %d%n", clientScoket.getPort());

                    // получаем от клиента строку (условно имя)
                    final String name = in.readLine();
                    // и возвращаем ему приветсвие
                    out.println(String.format("Hello %s, you port N%d", name, clientScoket));
                }
            }
        }
    }
}