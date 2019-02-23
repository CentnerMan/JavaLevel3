package ru.lebedev.se.HomeWork7.ships;

import static ru.lebedev.se.HomeWork7.ships.ChipsMain.cdl;

/**
 * Java 3, JavaLevel3.
 *
 * @author Anatoly Lebedev
 * @version 1.0.0 21.02.2019
 * @link https://github.com/Centnerman
 */

public class Chip implements Runnable {

    private String name; // Наименование
    private String type; // Тип товара
    private Raid raid;
    private int speed;
    private int capacity; // вместимость
    private int currentCapacity = 0;
    private boolean isNeed = true;

    private static int CHIPS_COUNT;

    static {
        CHIPS_COUNT = 0;
    }

    public String getName() {
        return name;
    }

    public int getSpeed() {
        return speed;
    }

    public boolean isNeed() {
        return isNeed;
    }

    public void setNeed(boolean need) {
        isNeed = need;
    }

    public Chip(Raid raid, int speed, int capacity, String type) {
        this.raid = raid;
        this.speed = speed;
        this.capacity = capacity;
        this.type = type;
        CHIPS_COUNT++;
        this.name = "Корабль #" + CHIPS_COUNT + " груз: " + type;
    }

    public int getCapacity() {
        return capacity;
    }

    public int getCurrentCapacity() {
        return currentCapacity;
    }

    public void setCurrentCapacity(int currentCapacity) {
        this.currentCapacity = currentCapacity;
    }

    @Override
    public void run() {
        do {
            try {
                System.out.println(this.name + " отправляется за товаром");
            } catch (Exception e) {
                e.printStackTrace();
            }

            for (int i = 0; i < raid.getStages().size(); i++) {
                raid.getStages().get(i).go(this);
            }
        } while (isNeed);
        System.out.println(this.name + " закончил работу");
        cdl.countDown();
    }
}