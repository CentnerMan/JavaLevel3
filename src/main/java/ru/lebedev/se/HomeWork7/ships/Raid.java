package ru.lebedev.se.HomeWork7.ships;

/**
 * Java 3, JavaLevel3.
 *
 * @author Anatoly Lebedev
 * @version 1.0.0 23.02.2019
 * @link https://github.com/Centnerman
 */

import ru.lebedev.se.HomeWork7.ships.stages.Stage;

import java.util.ArrayList;
import java.util.Arrays;

public class Raid {

    private ArrayList<Stage> stages;

    public ArrayList<Stage> getStages() { return stages; }

    public Raid(Stage... stages) {
        this.stages = new ArrayList<>(Arrays.asList(stages));
    }
}