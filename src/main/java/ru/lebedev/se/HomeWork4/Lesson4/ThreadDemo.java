package ru.lebedev.se.HomeWork4.Lesson4;

public class ThreadDemo extends Thread {

    @Override
    public void run() {
        System.out.println("method " + getName());
    }

    public static void main(String[] args) {
        ThreadDemo t1 = new ThreadDemo();
        ThreadDemo t2 = new ThreadDemo();

        System.out.println("t1 thread " + t1.getPriority());
        System.out.println("t2 thread " + t2.getPriority());

        t1.setPriority(8);
        t2.setPriority(1);

        System.out.println("t1 thread " + t1.getPriority());
        System.out.println("t2 thread " + t2.getPriority());

        t1.start();
        t2.start();

    }

}
