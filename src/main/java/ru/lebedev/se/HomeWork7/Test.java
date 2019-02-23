package ru.lebedev.se.HomeWork7;

/**
 * Java 3, JavaLevel3.
 *
 * @author Anatoly Lebedev
 * @version 1.0.0 20.02.2019
 * @link https://github.com/Centnerman
 */

public class Test {

    public static void main(String[] args) {
        int a = 2;
        int b = 10;


        int c = 1 >> a++ + ++b - --a - b << 1;

        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
    }

}
