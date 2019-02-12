package ru.lebedev.se.HomeWork4;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Java 3, JavaLevel3.
 *
 * @author Anatoly Lebedev
 * @version 1.0.0 11.02.2019
 * @link https://github.com/Centnerman
 */

/*
2. Прочитать файл (около 50 байт) в байтовый массив и вывести этот массив в консоль;
 */

public class ReadFileWriteToCon {

    /**
     * Name reading file.
     */
    private static final String FILE_NAME = "texttoread.txt";

    /**
     * Array bytes from file.
     */
    public static byte[] bytes;

    /**
     * Simple text for writing into file.
     */
    public static final String TEXT = "In vino veritas!"; // строка для записи


    public static void main(String[] args) {

        // Запись
        try (FileOutputStream fos = new FileOutputStream(FILE_NAME)) {

            // перевод строки в байты
            byte[] buffer = TEXT.getBytes();
            fos.write(buffer, 0, buffer.length);

        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

        System.out.println("Файл " + FILE_NAME + " записан");

        // Чтение
        try (FileInputStream fin = new FileInputStream(FILE_NAME)) {

            System.out.printf("Файл весит: %d байт \n", fin.available());
            bytes = new byte[fin.available()]; // массив длиной в файл

            int readBite = -1;
            int countArr = 0; // переходим на начало массива

            // Читаем до конца файла
            while ((readBite = fin.read()) != -1) {
                bytes[countArr++] = (byte) readBite;
            }

        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

        // Выводим в виде символов
        for (int i = 0; i < bytes.length; i++) {

            System.out.print((char) bytes[i]);
        }
        System.out.println("");

        // Выводим в цифровом виде до пустой ячейки
        for (int i = 0; i < bytes.length; i++) {

            if (bytes[i] != 0) System.out.print(bytes[i] + " ");
            else return;
        }
    }
}
