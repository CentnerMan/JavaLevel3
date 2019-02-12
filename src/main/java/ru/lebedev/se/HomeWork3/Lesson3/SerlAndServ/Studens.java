package ru.lebedev.se.HomeWork3.Lesson3.SerlAndServ;

import java.io.Serializable;

public class Studens implements Serializable {
    int id;
    String name;
    public Studens(int id, String name) {
        this.id = id;
        this.name = name;
    }
    public void info() {
        System.out.println(id + " " + name);
    }
}
