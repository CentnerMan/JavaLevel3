package ru.lebedev.se.HomeWork7.ships.stages;

import ru.lebedev.se.HomeWork7.ships.Chip;

/**
 * Java 3, JavaLevel3.
 *
 * @author Anatoly Lebedev
 * @version 1.0.0 23.02.2019
 * @link https://github.com/Centnerman
 */

public class PortIn extends Stage {
    private int capacity; // Вместимость
    private String type; // тип товара
    private int anyLoad = 100; //загружаем по 100
    private int currentCapacity; // остаток

    public PortIn(int capacity, String type) {
        this.length = 0;
        this.capacity = capacity;
        this.currentCapacity = 0;
        this.type = type;
        this.description = "Порт приема, тип: " + type;
    }

    public synchronized void setCurrentCapacity(int currentCapacity) {
        this.currentCapacity = this.currentCapacity + currentCapacity; //не проверяем на вместимость
    }

    public synchronized int getCurrentCapacity() {
        return currentCapacity;
    }

    public synchronized int getCapacity() {
        return capacity;
    }

    public String getType() {
        return type;
    }

    @Override
    public void go(Chip c) {

        System.out.println(c.getName() + " начал этап: " + description);
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        currentCapacity = currentCapacity + c.getCurrentCapacity();
        System.out.println(c.getName() + " выгрузился на " + c.getCurrentCapacity() + " в " + description + " в порту " + currentCapacity);
        c.setCurrentCapacity(0);
    }


}

