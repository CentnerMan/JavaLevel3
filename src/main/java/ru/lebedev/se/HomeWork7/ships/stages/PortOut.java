package ru.lebedev.se.HomeWork7.ships.stages;

import ru.lebedev.se.HomeWork7.ships.Chip;

/**
 * Java 3, JavaLevel3.
 *
 * @author Anatoly Lebedev
 * @version 1.0.0 21.02.2019
 * @link https://github.com/Centnerman
 */

public class PortOut extends Stage {

    private int capacity; // Вместимость
    private String type; // тип товара
    private int anyLoad = 100; //загружаем по 100
    private int currentCapacity; // остаток

    public PortOut(int capacity, String type) {
        this.length = 0;
        this.capacity = capacity;
        this.currentCapacity = capacity;
        this.type = type;
        this.description = "Порт отгрузки, тип: " + type;
    }

    public synchronized int getCapacity() {
        return capacity;
    }

    public synchronized int getCurrentCapacity() {
        return currentCapacity;
    }

    public synchronized void setCurrentCapacity(int currentCapacity) {
        this.currentCapacity = currentCapacity;
    }

    public String getType() {
        return type;
    }

    @Override
    public synchronized void go(Chip c) {
        try {
            System.out.println(c.getName() + " начал этап: " + description);
            for (int i = 0; i < c.getCapacity(); ) {
                if (getCurrentCapacity() >= anyLoad) {
                    Thread.sleep(1000);
                    c.setCurrentCapacity(c.getCurrentCapacity() + anyLoad);
                    setCurrentCapacity(getCurrentCapacity() - anyLoad);
                    i = i + anyLoad;
                    System.out.println(c.getName() + " загружается на " + anyLoad + " в " + description);
                } else {
                    c.setNeed(false);
                    System.out.println(c.getName() + " загрузился на " + c.getCurrentCapacity() + " в " + description + ". Остаток в порту: " + getCurrentCapacity());
                    return;
                }
            }
            System.out.println(c.getName() + " загрузился на " + c.getCurrentCapacity() + " в " + description + ". Остаток в порту: " + getCurrentCapacity());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
