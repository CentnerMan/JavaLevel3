package ru.lebedev.se.HomeWork7.lesson7;

public class Cat {

    String name;
    public String color;
    protected int age;

    public Cat(String name, String color, int age) {
        this.name = name;
        this.color = color;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getAge() {
        return age;
    }


    @MyAnon(priotity = 7)
    public void info() {
        System.out.println(name + " " + color + " " + age + " MyAnon method");
    }

    @MyAnon(priotity = 3)
    public void info2() {
        System.out.println(name + " " + color + " " + age );
    }
}
