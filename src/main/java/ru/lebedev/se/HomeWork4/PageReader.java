package ru.lebedev.se.HomeWork4;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;

/**
 * Java 3, JavaLevel3.
 *
 * @author Anatoly Lebedev
 * @version 1.0.0 11.02.2019
 * @link https://github.com/Centnerman
 */

/*
4. Написать консольное приложение, которое умеет постранично читать текстовые файлы
(размером > 10 mb). Вводим страницу (за страницу можно принять 1800 символов), программа
выводит ее в консоль. Контролируем время выполнения: программа не должна загружаться
дольше 10 секунд, а чтение – занимать свыше 5 секунд.
 */

public class PageReader {

    public static final String FILE_NAME = "bigtext.txt";

    private static final int PAGE_SIZE = 1800;

    private static Scanner scanner;

    public static void main(String[] args) {

        scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Введите номер страницы: ");
            int pageNumber = scanner.nextInt();
            if (pageNumber == -1) {
                scanner.close();
                break;
            }

            long startTime = System.currentTimeMillis(); // засекаем время

            try (RandomAccessFile raf = new RandomAccessFile(FILE_NAME, "r")) {
                int startPosition = (pageNumber - 1) * PAGE_SIZE;
                raf.seek(startPosition);
                int counter = 0;

                while (raf.getFilePointer() != (startPosition + PAGE_SIZE)) {
                    String line = String.valueOf((char) raf.read()); // Выводим с перекодировкой
                    String decodeLine = new String(line.getBytes("ISO-8859-1"), "windows-1251");
                    System.out.print(decodeLine);
                    raf.seek(startPosition + (++counter));
                }
                System.out.println();
                System.out.println("Время на поиск и чтение страницы: " + (System.currentTimeMillis() - startTime) + "мс");

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
