package ru.lebedev.se.HomeWork4.Lesson4;

public class Event {
    static Object chair1 = new Object();
    static Object chair2 = new Object();

    public static void main(String[] args) {
        Thread people1 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("people1 подошел к стулу 1");
                synchronized (chair1) {
                    System.out.println("people1 сел на стул 1");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("people1 встал со стула 1");
                }
            }
        });
        people1.start();

        Thread people2 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("people2 подошел к стулу 1");
                synchronized (chair1) {
                    System.out.println("people2 сел на стула 1");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("people2 встал со стула 1");
                }
            }
        });
        people2.start();

        Thread people3 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("people3 подошел к стулу 2");
                synchronized (chair2) {
                    System.out.println("people3 сел на стула 2");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("people3 встал со стула 2");
                }
            }
        });
        people3.start();
    }

}
