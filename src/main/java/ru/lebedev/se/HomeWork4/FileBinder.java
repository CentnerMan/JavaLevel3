package ru.lebedev.se.HomeWork4;

import java.io.*;

/**
 * Java 3, JavaLevel3.
 *
 * @author Anatoly Lebedev
 * @version 1.0.0 11.02.2019
 * @link https://github.com/Centnerman
 */

/*
3. Последовательно сшить 5 файлов в один (файлы примерно 100 байт).
 Может пригодиться следующая конструкция:
ArrayList<InputStream> al = new ArrayList<>();
...
Enumeration<InputStream> e = Collections.enumeration(al);
 */

public class FileBinder {

    public static final String FILE_OUT_NAME = "result.txt"; // файл для вывода

    public static final String[] FILE_NAMES = {"file1.txt", "file2.txt", "file3.txt", "file4.txt", "file5.txt"};  // файлы для сшивания

    public static File fileOut = new File(FILE_OUT_NAME);

    public static File[] files = {new File(FILE_NAMES[0]), new File(FILE_NAMES[1]), new File(FILE_NAMES[2]), new File(FILE_NAMES[3]), new File(FILE_NAMES[4])};


    public static void main(String[] args){

        Binder(fileOut, files);
        System.out.println("Process is done...");
    }

    public static void Binder(File fileOut, File... filesIn) {

        fileOut.delete(); // удаляем файл перед записью в него
        BufferedOutputStream bos = null;
        try {
            bos = new BufferedOutputStream(new FileOutputStream(fileOut, true));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        for (File file : filesIn) {
            if (file.exists()) {
                BufferedInputStream bis = null;
                try {
                    bis = new BufferedInputStream(new FileInputStream(file));
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
                int n = 0;

                while (true) {
                    try {
                        if (!((n = bis.read()) != -1)) break;
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    try {
                        bos.write(n);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                try {
                    bis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        try {
            bos.flush();
            bos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
