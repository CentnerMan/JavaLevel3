package ru.lebedev.se.HomeWork3.Serialize;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Java 3, Serialize.
 *
 * @author Anatoly Lebedev
 * @version 1.0.0 10.02.2019
 * @link https://github.com/Centnerman
 */

public class SimpleServer {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(9191);
        } catch (IOException e) {
            e.printStackTrace();
        }
        serverSocket.setSoTimeout(8000); //waiting client
        Socket client = serverSocket.accept();
        ObjectInputStream deserializer = new ObjectInputStream(client.getInputStream());

        Package pack = (Package)deserializer.readObject();
        pack.info();
    }
}
