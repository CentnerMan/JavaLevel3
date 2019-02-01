package ru.lebedev.se.HomeWork1;
/*
Написать метод, который преобразует массив в ArrayList;
 */

import java.util.ArrayList;

public class ArrayToArrayList<T> {

    ArrayList<T> arrayList = new ArrayList<>();

    public ArrayList<T> getArrayList() {
        return arrayList;
    }

    public void setArrayList(T[] arr) {
        for (int i = 0; i < arr.length; i++) {
            this.arrayList.add(arr[i]);
        }
    }

    public void printAll() {
        for (int i = 0; i < arrayList.size(); i++) {
            System.out.println(arrayList.get(i).toString());
        }
    }
}

class Main {
    public static void main(String[] args) {
        String strings[] = {"one", "2", "3", "4", "5"};
        ArrayToArrayList tArrayList = new ArrayToArrayList();
        tArrayList.setArrayList(strings);
        tArrayList.printAll();
        System.out.println("-----------------");

        Double doubles[]={2.4, 3.45, 5.34, 34.24};
        ArrayToArrayList tArrayListD = new ArrayToArrayList();
        tArrayListD.setArrayList(doubles);
        tArrayListD.printAll();
    }
}