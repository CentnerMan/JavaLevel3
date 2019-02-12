package ru.lebedev.se.HomeWork4.Lesson4;

public class MainThread {

    public static void main(String[] args) throws InterruptedException {
//        MyThread t1 = new MyThread();
//        t1.start();
//
//        //t1.join();
//
//        while (true) {
//            if (!t1.isAlive()) {
//                break;
//            }
//        }
//
//        System.out.println("END");

        TestThread t1 = new TestThread();
//        TestThread t2 = new TestThread();

        new Thread(new Runnable() {
            @Override
            public void run() {
                t1.method2();
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                TestThread.method3();
            }
        }).start();

    }

}

class TestThread {
    public synchronized void method1() {
        System.out.println("M1");
        for (int i = 0; i < 10; i++) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("M2");
    }

    public synchronized static void method2() {
        System.out.println("method2 start");
        for (int i = 0; i < 10; i++) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("method2 end");
    }

    public synchronized static void method3() {
        System.out.println("method3 start");
        for (int i = 0; i < 10; i++) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("method3 end");
    }
}


class MyRunnableClass implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("new thread: " + i);
        }
    }
}

class MyThread extends Thread {

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("new thread: " + i);
        }
    }
}

