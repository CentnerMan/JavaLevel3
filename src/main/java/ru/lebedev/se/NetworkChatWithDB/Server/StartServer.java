package ru.lebedev.se.NetworkChatWithDB.Server;

import java.sql.SQLException;

public class StartServer {
    public static void main(String[] args) throws SQLException {
        new Server();
    }
}
