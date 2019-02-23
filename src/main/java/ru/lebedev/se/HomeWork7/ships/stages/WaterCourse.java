package ru.lebedev.se.HomeWork7.ships.stages;

import ru.lebedev.se.HomeWork7.ships.Chip;

/**
 * Java 3, JavaLevel3.
 *
 * @author Anatoly Lebedev
 * @version 1.0.0 23.02.2019
 * @link https://github.com/Centnerman
 */

public class WaterCourse extends Stage {

    public WaterCourse(int length) {
        this.length = length;
        this.description = "Пролив " + length + " метров";
    }
    @Override
    public void go(Chip c) {
        try {
            System.out.println(c.getName() + " начал этап: " + description);
            Thread.sleep(length / c.getSpeed() * 1000);
            System.out.println(c.getName() + " закончил этап: " + description);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
