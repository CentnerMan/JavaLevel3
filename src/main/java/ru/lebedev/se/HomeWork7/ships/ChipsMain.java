package ru.lebedev.se.HomeWork7.ships;

import ru.lebedev.se.HomeWork7.ships.stages.Gateway;
import ru.lebedev.se.HomeWork7.ships.stages.PortIn;
import ru.lebedev.se.HomeWork7.ships.stages.PortOut;
import ru.lebedev.se.HomeWork7.ships.stages.WaterCourse;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;

/**
 * Java 3, JavaLevel3.
 *
 * @author Anatoly Lebedev
 * @version 1.0.0 21.02.2019
 * @link https://github.com/Centnerman
 */

/*
1 Есть транспортные корабли, которые подплывают к проливу и далее
  плывут к причалам для погрузки разного рода товара.

2 Они проходят через узкий пролив где одновременно могут находиться
  только 2 корабля.

3 Вид кораблей и их вместительность могут быть разными в зависимости от типа товаров,
  которые нужно загрузить на корабль. (Представим что корабли везут Одежду, Еду, Топливо)

4 Есть 3 вида причалов для погрузки кораблей в соотвествие с товарами,
  за одну секунду причал загружает на корабль 100 ед. товара, вместимость кораблей 500.

5 После загрузки нужно пройти обратно через пролив и перевезти товар.

6 Нужно перевезти 2700 ед. одежды, 5900 еды, 8500 топлива.

Перевести груз.
Правильно разбить задачу на параллельность.
Синхронизировать потоки, сохранить целостность данных.
 */
public class ChipsMain {

    public static final int CHIPS_COUNT_CLOTHES = 2;
    public static final int CHIPS_COUNT_FOOD = 3;
    public static final int CHIPS_COUNT_GASOLINE = 4;
    public static final int CHIPS_COUNT = CHIPS_COUNT_CLOTHES + CHIPS_COUNT_FOOD + CHIPS_COUNT_GASOLINE;
    public static final int CHIPS_CAPACITY = 500; // грузоподъемность корабля
    public static Semaphore gateway_count;
    public static final CountDownLatch cdl = new CountDownLatch(CHIPS_COUNT);

    public static void main(String[] args) {

        gateway_count = new Semaphore(2); // 2 chips same in the tunnel

        System.out.println("Погрузочно-разгрузочные работы начинаются! ");

        // Формируем этапы
        WaterCourse downCourse = new WaterCourse(100); // от базы до пролива
        Gateway gateway = new Gateway(gateway_count); // пролив
        WaterCourse upCourse = new WaterCourse(50); // от пролива до порта

        PortOut portOutClothes = new PortOut(2700, "одежда"); // порт с одеждой
        PortOut portOutFood = new PortOut(5900, "еда"); // порт с едой
        PortOut portOutGasoline = new PortOut(8500, "топливо"); // порт с топливом

        PortIn portInClothes = new PortIn(100000, "одежда"); // порт с одеждой
        PortIn portInFood = new PortIn(100000, "еда"); // порт с едой
        PortIn portInGasoline = new PortIn(100000, "топливо"); // порт с топливом

        Raid raidClothes = new Raid(downCourse, gateway, upCourse, portOutClothes, upCourse, gateway, downCourse, portInClothes); // рейс за одеждой
        Raid raidFood = new Raid(downCourse, gateway, upCourse, portOutFood, upCourse, gateway, downCourse, portInFood); // рейс за едой
        Raid raidGasoline = new Raid(downCourse, gateway, upCourse, portOutGasoline, upCourse, gateway, downCourse, portInGasoline); // рейс за топливом


        // Создаем кораблики
        Chip[] chips = new Chip[CHIPS_COUNT];
        int currentChipsCount = 0;
        int currentCount = currentChipsCount;


        for (int i = currentCount; i < (CHIPS_COUNT_CLOTHES + currentCount); i++) {
            chips[i] = new Chip(raidClothes, 20 + (int) (Math.random() * 10), CHIPS_CAPACITY, "одежда");
            currentChipsCount++;
        }
        currentCount = currentChipsCount;

        for (int i = currentCount; i < (CHIPS_COUNT_FOOD + currentCount); i++) {
            chips[i] = new Chip(raidFood, 20 + (int) (Math.random() * 10), CHIPS_CAPACITY, "еда");
            currentChipsCount++;
        }
        currentCount = currentChipsCount;

        for (int i = currentCount; i < (CHIPS_COUNT_GASOLINE + currentCount); i++) {
            chips[i] = new Chip(raidGasoline, 20 + (int) (Math.random() * 10), CHIPS_CAPACITY, "топливо");
            currentChipsCount++;
        }

        // многопоточим

        for (int i = 0; i < chips.length; i++) {
            new Thread(chips[i]).start();
        }

        try {
            cdl.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("-----------------------------------------------------------");
        System.out.println("Одежда в порту выдачи: "+portOutClothes.getCurrentCapacity());
        System.out.println("Одежда в порту приема: "+portInClothes.getCurrentCapacity());
        System.out.println("-----------------------------------------------------------");
        System.out.println("Еда в порту выдачи: "+portOutFood.getCurrentCapacity());
        System.out.println("Еда в порту приема: "+portInFood.getCurrentCapacity());
        System.out.println("-----------------------------------------------------------");
        System.out.println("Топливо в порту выдачи: "+portOutGasoline.getCurrentCapacity());
        System.out.println("Топливо в порту приема: "+portInGasoline.getCurrentCapacity());
        System.out.println("-----------------------------------------------------------");
    }
}

