package ru.lebedev.se.HomeWork1.Fruits;

import java.util.ArrayList;

public class Box<T extends Fruit> {
    ArrayList<T> box; // массив фруктов

    public Box(T fruit) {
        box = new ArrayList();
    }

    public float getWeight() {
        float totalWeight = 0.0f;
        for (int i = 0; i < box.size(); i++) {
            totalWeight = totalWeight + box.get(i).getWeight();
        }
        return totalWeight;

    }

    public int getCountFruits() {
        return box.size();
    }

    public boolean compare(Box<? extends Fruit> compareBox) {
        return Math.abs(getWeight() - compareBox.getWeight()) < 0.0001f;
    }

    public void addToBox(T fruit) {
        box.add(fruit);
    }

    void clearBox() {
        box.clear();
    }

    public void moveFruitsToAnotherBox(Box<T> anotherBox) {
        anotherBox.box.addAll(this.box);
        this.clearBox();
    }
}
