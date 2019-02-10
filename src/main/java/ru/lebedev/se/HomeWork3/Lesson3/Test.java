package ru.lebedev.se.HomeWork3.Lesson3;

public class Test {
    public static void main(String[] args) {


//        Test e2 = new Test();
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                e2.method2();
//            }
//        }).start();
//
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                e2.method2();
//            }
//        }).start();
//
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                e2.method2();
//            }
//        }).start();




//        Test e2 = new Test();
//
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                methodStatic1();
//            }
//        }).start();
//
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                e2.methodStatic3();
//            }
//        }).start();

    }

    public synchronized static void methodStatic1() {
        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName());
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    public synchronized void methodStatic3() {
        System.out.println(Thread.currentThread().getName());
    }

    public synchronized static void methodStatic2() {
        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName());
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    Object lock = new Object();
    public void method2() {
        try {
            System.out.println("NonSync-Begin " + Thread.currentThread().getName());
            for (int i = 0; i < 3; i++) {
                System.out.println(".");
                Thread.sleep(200);
            }
            System.out.println("NonSync-End " + Thread.currentThread().getName());
            synchronized (lock) {
                System.out.println("Sync-Begin " + Thread.currentThread().getName());
                for (int i = 0; i < 5; i++) {
                    System.out.println(".");
                    Thread.sleep(200);
                }
                System.out.println("Sync-End " + Thread.currentThread().getName());
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}



















//interface I2 {
//    void copy() throws FileNotFoundException;
//}
//
//
//class A implements I2 {
//
//    // вопрос: какие исключения нужно использовать и нужно ли?
//    @Override
//    public void copy() {
//
//    }
//}















//////////// 2

class Main {
    public static void main(String[] args) {
        System.out.print(Values.A);
    }
}

enum Values {
    A(1), B(2), C(3);

    Values(int i) {
        System.out.print(i);
    }

    static  {
        System.out.print("static");
    }
}
