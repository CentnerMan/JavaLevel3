package ru.lebedev.se.NetworkChatWithDB.Server;


import java.sql.*;
import java.util.ArrayList;

public class AuthService {

    private static Connection connection;
    private static Statement stmt;

    public static void connect() throws SQLException {
        try {
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection("jdbc:sqlite:mainDB.db");
            stmt = connection.createStatement();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }


    public static String getNickByLoginAndPass(String login, String pass) {
        String sql = String.format("SELECT nickname, password FROM main\n" +
                "WHERE login = '%s'", login);

        int myhash = pass.hashCode();

        ResultSet rs = null;
        try {
            rs = stmt.executeQuery(sql);
            if (rs.next()) {
                String nick = rs.getString(1);
                int dbHash = rs.getInt(2);

                if (myhash == dbHash) {
                    return nick;
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static synchronized void addUser(String login, String pass, String nick) {
        String sql = String.format("INSERT INTO main (login, password, nickname)" +
                "VALUES ('%s', '%s', '%s')", login, pass.hashCode(), nick);
        try {
            stmt.execute(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public static void disconnect() {
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /*
    blacklist
    CREATE TABLE blacklist (
    id    INTEGER PRIMARY KEY
                  NOT NULL
                  UNIQUE,
    user  TEXT    NOT NULL,
    black TEXT    NOT NULL
);
     */

    public static synchronized ArrayList<String> getBlackList(String user) {
        ArrayList<String> list = new ArrayList<String>();
        ResultSet rs = null;
        try {
            String sql = String.format("SELECT black FROM blacklist\n" +
                    "WHERE user = '%s'", user);
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                String black = rs.getString("black");
                list.add(black);
            }
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        list.clear();
        return list;
    }

    public static synchronized void addToBlackList(String user, String black) {
        String sql = String.format("INSERT INTO blacklist (user, black)" +
                "VALUES ('%s', '%s')", user, black);
        try {
            stmt.execute(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

}
