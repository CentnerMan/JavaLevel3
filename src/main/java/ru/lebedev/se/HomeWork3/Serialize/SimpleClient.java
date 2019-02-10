package ru.lebedev.se.HomeWork3.Serialize;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;

/**
 * Java 3, Serialize.
 *
 * @author Anatoly Lebedev
 * @version 1.0.0 10.02.2019
 * @link https://github.com/Centnerman
 */

public class SimpleClient {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Socket clientSocket = null;
        try {
            clientSocket = new Socket("localhost",9191);
        } catch (IOException e) {
            e.printStackTrace();
        }
        ObjectOutputStream serializer = new ObjectOutputStream(clientSocket.getOutputStream());

        Package pack = new Package(10, "Anything", "All to you need");
        serializer.writeObject(pack);
        serializer.flush();
    }
}
