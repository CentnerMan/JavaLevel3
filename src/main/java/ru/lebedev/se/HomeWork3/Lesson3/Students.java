package ru.lebedev.se.HomeWork3.Lesson3;

import java.io.*;

class Human {

    public Human() {
        System.out.println("Я объект и я использую конструктор!!");
    }
}

class Book {
    String title;

    public Book(String title) {
        this.title = title;
    }
}

public class Students extends Human implements Serializable{
    int id;
    String name;
    transient Book book;

    public Students(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public void info() {
        System.out.println(id + " " + name + " " + book);
    }
}

class MainSerializable {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Students students = new Students(1, "Bob");
        Book book = new Book("Book");
        students.book = book;
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("stud.ser"));
        oos.writeObject(students);
        oos.close();


        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("stud.ser"));
        Students s2 = (Students) ois.readObject();
        ois.close();
        s2.info();
    }
}


