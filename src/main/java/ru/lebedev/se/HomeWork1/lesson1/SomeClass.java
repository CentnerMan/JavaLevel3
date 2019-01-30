package ru.lebedev.se.HomeWork1.lesson1;

import javax.swing.*;

public class SomeClass {

    interface Callback {
        void callingBack(String str);
    }

    Callback callback;

    public SomeClass(Callback callback) {
        this.callback = callback;
    }

    void doSomething() {
        JOptionPane.showMessageDialog(null, "work");
        callback.callingBack("str");
    }

}

class MyClass implements SomeClass.Callback {

    public void callingBack(String str) {

        System.out.println("Удаление из базы " + str);

    }

}

class Main {
    public static void main(String[] args) {
        MyClass myClass = new MyClass();
        SomeClass someClass = new SomeClass(myClass);

        someClass.doSomething();

    }
}
