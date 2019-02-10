package ru.lebedev.se.HomeWork4.Experiments;

/**
 * Java 3, JavaLevel3.
 *
 * @author Anatoly Lebedev
 * @version 1.0.0 10.02.2019
 * @link https://github.com/Centnerman
 */

public class AlphabetThread {
    public static void main(String[] args) {
        AlphaThread aThread = new AlphaThread("A");
        AlphaThread bThread = new AlphaThread("B");
        AlphaThread cThread = new AlphaThread("C");

        aThread.start();
        bThread.start();
        cThread.start();
    }
}

class AlphaThread extends Thread {
    String str = "";

    public AlphaThread(String string) {
        str = string;
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println(str);
            try {
                sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
