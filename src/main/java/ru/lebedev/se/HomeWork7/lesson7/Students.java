package ru.lebedev.se.HomeWork7.lesson7;

@XTable(name = "students")
public class Students {
    @XField
    int id;

    @XField
    String name;

    @XField
    int score;

    public Students(int id, String name, int score) {
        this.id = id;
        this.name = name;
        this.score = score;
    }

   // try catch finally throw throws
}
