package ru.lebedev.se.Homework6;

/**
 * Java 3, JavaLevel3.
 *
 * @author Anatoly Lebedev
 * @version 1.0.0 20.02.2019
 * @link https://github.com/Centnerman
 */

/*
2. Написать метод, которому в качестве аргумента передается не пустой одномерный целочисленный массив.
Метод должен вернуть новый массив, который получен путем вытаскивания из исходного массива элементов,
идущих после последней четверки. Входной массив должен содержать хотя бы одну четверку,
иначе в методе необходимо выбросить RuntimeException. Написать набор тестов для этого метода
(по 3-4 варианта входных данных). Вх: [ 1 2 4 4 2 3 4 1 7 ] -> вых: [ 1 7 ].

3. Написать метод, который проверяет состав массива из чисел 1 и 4.
Если в нем нет хоть одной четверки или единицы, то метод вернет false;
Написать набор тестов для этого метода (по 3-4 варианта входных данных).

? { 1, 4, 1, 4, 1, 4 } - true
? { 4, 1, 4, 1, 4, 1 } - true
? { 1, 4, 1, 4, 4 } - false
 */

public class TestMain {

    /**
     * Create new array with digits after last 4.
     *
     * @param sourceArr - is a source array
     * @return array
     */

    public static int[] AfterFour(int[] sourceArr) {

        int[] destArr;

        int placeLastFour = -1; // place last 4

        for (int i = 0; i < sourceArr.length; i++) {
            if (sourceArr[i] == 4) placeLastFour = i;
        }

        if (placeLastFour == -1) {
            throw new RuntimeException("Source array not contain 4");
        }

        if (placeLastFour >= 0 && placeLastFour < sourceArr.length - 1) {

            int newArrLength = sourceArr.length - placeLastFour - 1; // destination array length
            destArr = new int[newArrLength];
            for (int i = 0; i < newArrLength; i++) {
                destArr[i] = sourceArr[i + placeLastFour + 1];
            }
        } else {
            destArr = new int[0]; // create empty array
        }

        return destArr;
    }

    //-------------------------------------------------------------------------------------------------

    public static boolean checkOneAndFour(int[] arr) {
        boolean result = true;
        int previos = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (!((arr[i] == 1 && previos == 4) || (arr[i] == 4 && previos == 1))) {
                result = false;
                break;
            }
            previos = arr[i];
        }
        return result;
    }

    //-------------------------------------------------------------------------------------------------

    public static void main(String[] args) {
        int[] arr = AfterFour(new int[]{1, 2, 4, 4, 2, 3, 4, 1, 7});
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println("---------------");
        System.out.println(checkOneAndFour(new int[]{1, 4, 1, 4, 1, 4}));
        System.out.println(checkOneAndFour(new int[]{4, 1, 4, 1, 4}));
        System.out.println(checkOneAndFour(new int[]{4, 4, 1, 4, 1, 4}));
    }

}
