package ru.lebedev.se.HomeWork1.Fruits;

/*
3. Большая задача:
Есть классы Fruit -> Apple, Orange (больше фруктов не надо);
Класс Box, в который можно складывать фрукты. Коробки условно сортируются по типу фрукта,
поэтому в одну коробку нельзя сложить и яблоки, и апельсины;
Для хранения фруктов внутри коробки можно использовать ArrayList;
Сделать метод getWeight(), который высчитывает вес коробки, зная количество фруктов и вес одного фрукта
(вес яблока – 1.0f, апельсина – 1.5f. Не важно, в каких это единицах);
Внутри класса Коробка сделать метод compare, который позволяет сравнить текущую коробку с той,
которую подадут в compare в качестве параметра, true – если она равны по весу, false – в противном случае
(коробки с яблоками мы можем сравнивать с коробками с апельсинами);
Написать метод, который позволяет пересыпать фрукты из текущей коробки в другую
(помним про сортировку фруктов: нельзя яблоки высыпать в коробку с апельсинами).
Соответственно, в текущей коробке фруктов не остается, а в другую перекидываются объекты, которые были в этой коробке;
Не забываем про метод добавления фрукта в коробку.
 */

public class Fruits {
    public static void main(String[] args) {

        Box<Orange> boxWithOranges = new Box<>(new Orange());
        Box<Apple> boxWithApples = new Box<>(new Apple());
        Box<Apple> anotherBoxWithApples = new Box<>(new Apple());

        boxWithOranges.addToBox(new Orange());
        boxWithOranges.addToBox(new Orange());
        boxWithApples.addToBox(new Apple());
        boxWithApples.addToBox(new Apple());
        boxWithApples.addToBox(new Apple());

        System.out.println("В коробке с апельсинами " + boxWithOranges.getCountFruits() + " апельсинов, весом "
                + boxWithOranges.getWeight());
        System.out.println("В коробке с яблоками " + boxWithApples.getCountFruits() + " яблок, весом "
                + boxWithApples.getWeight());
        System.out.println("В другой коробке с яблоками " + anotherBoxWithApples.getCountFruits() + " яблок, весом "
                + anotherBoxWithApples.getWeight());

        System.out.println("----------------------------------------------");
        // Сравним вес коробок
        if (boxWithApples.compare(boxWithOranges)) {
            System.out.println("Вес коробок одинаковый");
        } else System.out.println("Вес коробок разный");
        System.out.println("----------------------------------------------");

        // перенесем яблоки в другую коробку
        boxWithApples.moveFruitsToAnotherBox(anotherBoxWithApples);

        System.out.println("В коробке с яблоками " + boxWithApples.getCountFruits() + " яблок, весом "
                + boxWithApples.getWeight());
        System.out.println("В другой коробке с яблоками " + anotherBoxWithApples.getCountFruits() + " яблок, весом "
                + anotherBoxWithApples.getWeight());
    }
}



