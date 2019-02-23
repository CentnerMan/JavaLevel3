package ru.lebedev.se.HomeWork7.CheckDZ;

import ru.lebedev.se.HomeWork7.CheckDZ.annotations.AfterSuite;
import ru.lebedev.se.HomeWork7.CheckDZ.annotations.BeforeSuite;
import ru.lebedev.se.HomeWork7.CheckDZ.annotations.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.TreeMap;

/**
 * Java 3, JavaLevel3.
 *
 * @author Anatoly Lebedev
 * @version 1.0.0 21.02.2019
 * @link https://github.com/Centnerman
 */

/*
Создать класс, который может выполнять «тесты».
В качестве тестов выступают классы с наборами методов с аннотациями @Test.
Для этого у него должен быть статический метод start(), которому в качестве параметра
передается или объект типа Class, или имя класса.
Из «класса-теста» вначале должен быть запущен метод с аннотацией @BeforeSuite, если такой имеется.
Далее запущены методы с аннотациями @Test, а по завершении всех тестов – метод с аннотацией @AfterSuite.
К каждому тесту необходимо добавить приоритеты (int числа от 1 до 10),
в соответствии с которыми будет выбираться порядок их выполнения.
Если приоритет одинаковый, то порядок не имеет значения.
Методы с аннотациями @BeforeSuite и @AfterSuite должны присутствовать в единственном экземпляре,
иначе необходимо бросить RuntimeException при запуске «тестирования».
Это домашнее задание никак не связано с темой тестирования через JUnit
и использованием этой библиотеки: проект пишется с нуля.
 */

public class CheckDZMain {

    public static void main(String[] args) {
        try {
            start(SimpleTests.class);
        } catch (InvocationTargetException | IllegalAccessException | InstantiationException e) {
            e.printStackTrace();
        }
    }

    private static void start(Class<?> testingClass) throws InvocationTargetException, IllegalAccessException, InstantiationException {
        check(testingClass);

        Method[] methods = testingClass.getDeclaredMethods();

        Map<Integer, Method> sortedMethods = new TreeMap<>();

        for (Method method : methods) {
            if (method.isAnnotationPresent(BeforeSuite.class)) {
                sortedMethods.put(method.getAnnotation(BeforeSuite.class).priority(), method);
            }
            if (method.isAnnotationPresent(Test.class)) {
                sortedMethods.put(method.getAnnotation(Test.class).priority(), method);
            }
            if (method.isAnnotationPresent(AfterSuite.class)) {
                sortedMethods.put(method.getAnnotation(AfterSuite.class).priority(), method);
            }
        }

        Object testClass = testingClass.newInstance();
        for (Integer i : sortedMethods.keySet()) {
            sortedMethods.get(i).invoke(testClass);
        }
    }

    private static void check(Class<?> testingClass) {
        int beforeCount = 0;
        int afterCount = 0;

        Method[] methods = testingClass.getDeclaredMethods();
        for (Method method : methods) {
            if (method.isAnnotationPresent(BeforeSuite.class)) {
                beforeCount++;
                if (beforeCount > 1) throw new RuntimeException("В классе не может быть двух аннотаций @BeforeSuite");
            }
            if (method.isAnnotationPresent(AfterSuite.class)) {
                afterCount++;
                if (afterCount > 1) throw new RuntimeException("В классе не может быть двух аннотаций @AfterSuite");
            }
        }
    }
}
