package ru.lebedev.se.Homework6.lesson6.gb.ru;

import java.util.logging.Logger;

public class Test {
    private static final Logger logger = Logger.getLogger(ru.lebedev.se.Homework6.lesson6.gb.ru.Test.class.getName());

    public static void main(String[] args) {
        System.out.println(logger.getName() + " + ");
        System.out.println(logger.getParent().getName() + " - ");
    }
}
