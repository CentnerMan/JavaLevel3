package ru.lebedev.se.HomeWork7.ships.stages;

import ru.lebedev.se.HomeWork7.ships.Chip;

import java.util.concurrent.Semaphore;

/**
 * Java 3, JavaLevel3.
 *
 * @author Anatoly Lebedev
 * @version 1.0.0 23.02.2019
 * @link https://github.com/Centnerman
 */

public class Gateway extends Stage {
    Semaphore semaphore;

    public Gateway(Semaphore semaphore) {
        this.length = 80;
        this.description = "Шлюз " + length + " метров";
        this.semaphore = semaphore;
    }

    @Override
    public void go(Chip c) {
        try {
            try {
                System.out.println(c.getName() + " готовится к прохождению шлюза: " + description);
                semaphore.acquire();
                System.out.println(c.getName() + " проходит шлюз: " + description);
                Thread.sleep(length / c.getSpeed() * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                semaphore.release();
                System.out.println(c.getName() + " вышел из шлюза: " + description);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}