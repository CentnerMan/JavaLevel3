package ru.lebedev.se.HomeWork1;
/*
Написать метод, который меняет два элемента массива местами (массив может быть любого ссылочного типа);
 */

public class RotateArrayElements {

    public static void RotateElements(Object arr[], int a, int b) {
        if (a >= 0 && b >= 0 && a < arr.length && b < arr.length && arr.length > 0) {
            Object temp = arr[a];
            arr[a] = arr[b];
            arr[b] = temp;
        }
    }

    public static void PrintAllElements(Object arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i].toString() + " ");
        }
    }

    public static void main(String[] args) {
        Integer nums[] = {1, 2, 3, 4, 5};
        String strings[] = {"one", "2", "3", "4", "5"};
        RotateElements(nums, 2, 0);
        RotateElements(strings, 1, 4);
        PrintAllElements(nums);
        PrintAllElements(strings);
    }
}

