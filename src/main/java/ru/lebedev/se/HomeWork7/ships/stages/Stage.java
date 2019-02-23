package ru.lebedev.se.HomeWork7.ships.stages;

import ru.lebedev.se.HomeWork7.ships.Chip;

/**
 * Java 3, JavaLevel3.
 *
 * @author Anatoly Lebedev
 * @version 1.0.0 23.02.2019
 * @link https://github.com/Centnerman
 */

public abstract class Stage {
    protected int length;
    protected String description;
    public String getDescription() {
        return description;
    }
    public abstract void go(Chip c);
}