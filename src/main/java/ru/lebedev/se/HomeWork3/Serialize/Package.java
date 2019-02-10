package ru.lebedev.se.HomeWork3.Serialize;

import java.io.Serializable;

/**
 * Java 3, Serialize.
 *
 * @author Anatoly Lebedev
 * @version 1.0.0 10.02.2019
 * @link https://github.com/Centnerman
 */

public class Package implements Serializable {
    int id;
    String name;
    String contains;

    public Package(int id, String name, String contains) {
        this.id = id;
        this.name = name;
        this.contains = contains;
    }

    public void info() {
        System.out.println("id: " + id + ", name: " + name + ", contains: " + contains);
    }
}
