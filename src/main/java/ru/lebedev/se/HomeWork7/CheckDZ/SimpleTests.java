package ru.lebedev.se.HomeWork7.CheckDZ;

import ru.lebedev.se.HomeWork7.CheckDZ.annotations.AfterSuite;
import ru.lebedev.se.HomeWork7.CheckDZ.annotations.BeforeSuite;
import ru.lebedev.se.HomeWork7.CheckDZ.annotations.Test;

/**
 * Java 3, JavaLevel3.
 *
 * @author Anatoly Lebedev
 * @version 1.0.0 22.02.2019
 * @link https://github.com/Centnerman
 */

public class SimpleTests {


    @BeforeSuite
    public void before() {
        System.out.println("BeforeSuite");
    }

    @Test(priority = 8)
    public void test1() {
        System.out.println("test1");
    }

    @Test(priority = 7)
    public void test2() {
        System.out.println("test2");
    }

    @Test(priority = 6)
    public void test3() {
        System.out.println("test3");
    }

    @Test(priority = 5)
    public void test4() {
        System.out.println("test4");
    }

    @Test(priority = 4)
    public void test5() {
        System.out.println("test5");
    }

    @AfterSuite
    public void after() {
        System.out.println("AfterSuite");
    }
}
