package ru.lebedev.se.HomeWork4.Experiments;

/**
 * Java 3, JavaLevel3.
 *
 * @author Anatoly Lebedev
 * @version 1.0.0 11.02.2019
 * @link https://github.com/Centnerman
 */

public class PausedThread extends Thread {
    private final Object lock = new Object();
    private boolean flag = false;
    private boolean stop = false;

    public PausedThread() {
        super("Paused Thread");
    }

    @Override
    public void run() {
        synchronized(lock) {
            while(!stop) {
                try {

                    if(flag) lock.wait();    // приостанавливает поток если выполняется условие

                    System.out.println("выполняем блок кода");

                    Thread.sleep(100);

                } catch (InterruptedException ex) { }
            }
        }
    }

    public void pauseThread() {
        flag = true;
    }

    public void continueThread() {
        flag = false;
        synchronized(lock) {
            lock.notify();   // пробуждает приостановленый поток на обьекте lock
        }
    }

    public void stopThread() {
        stop = true;   // завершает поток естественно
    }


    public static void main(String[] args)  {
        PausedThread thread = new PausedThread();
        thread.start();
        try {
            Thread.sleep(2000);

            System.out.println("Ставим поток на паузу");
            thread.pauseThread();

            Thread.sleep(2000);

            System.out.println("Продолжаем работу потока");
            thread.continueThread();


            Thread.sleep(2000);

            System.out.println("Останавливаем поток");
            thread.stopThread();

        } catch (InterruptedException ex) { }
    }
}