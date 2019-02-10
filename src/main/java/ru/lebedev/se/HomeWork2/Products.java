package ru.lebedev.se.HomeWork2;

/*
Сформировать таблицу товаров (id, prodid, title, cost) запросом из Java-приложения:
id – порядковый номер записи, первичный ключ;
prodid – уникальный номер товара;
title – название товара;
cost – стоимость.

При запуске приложения очистить таблицу и заполнить 10000 товаров вида:
id_товара 1 товар1 10
id_товара 2 товар2 20
id_товара 3 товар3 30
id_товара 10000 товар10000 100000


CREATE TABLE IF NOT EXISTS Products
(
  id INTEGER PRIMARY KEY AUTOINCREMENT UNIQUE NOT NULL,
  prodid INTEGER UNIQUE NOT NULL,
  title TEXT NOT NULL,
  cost INTEGER NOT NULL
);

 */

import java.sql.*;


public class Products {
    private static Connection connection;
    private static Statement stmt;
    private static PreparedStatement pstmt;
    private static ResultSet rs = null;

    public static void connect() throws ClassNotFoundException, SQLException {
        Class.forName("org.sqlite.JDBC");
        connection = DriverManager.getConnection("jdbc:sqlite:hw2.db");
        stmt = connection.createStatement();
    }

    public static void disconnect() throws ClassNotFoundException, SQLException {

        connection.close();
    }

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        try {
            connect();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        // Создаем таблицу, если ее нет

        String sql = String.format("CREATE TABLE IF NOT EXISTS Products\n"
                + "(\n"
                + "  id INTEGER PRIMARY KEY AUTOINCREMENT UNIQUE NOT NULL,\n"
                + "  prodid INTEGER UNIQUE NOT NULL,\n"
                + "  title TEXT NOT NULL,\n"
                + "  cost INTEGER NOT NULL\n"
                + ")");
        stmt.execute(sql);

        // Очищаем таблицу

        sql = String.format("DELETE FROM Products");
        stmt.executeUpdate(sql);

        // Сбрасываем счетчик

        sql = String.format("UPDATE SQLITE_SEQUENCE SET SEQ=0 WHERE NAME='Products'");
        stmt.execute(sql);

        // Добавляем 10000 товаров

        connection.setAutoCommit(false);

        pstmt = connection.prepareStatement("INSERT INTO Products (prodid, title, cost)\n"
                + "VALUES (?, ?, ?)");


        for (int i = 1; i <= 10000; i++) {
            pstmt.setInt(1, i);
            pstmt.setString(2, "товар" + i);
            pstmt.setInt(3, (i * 10));
            pstmt.addBatch();
        }

        pstmt.executeBatch();

        connection.setAutoCommit(true);

        disconnect();

    }
}

