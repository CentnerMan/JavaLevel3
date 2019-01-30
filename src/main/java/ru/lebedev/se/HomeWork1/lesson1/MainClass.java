package ru.lebedev.se.HomeWork1.lesson1;

import java.util.ArrayList;

public class MainClass {
    public static void main(String[] args) {

//        BoxUltimate<Integer> box1 = new BoxUltimate<Integer>(1);
//        BoxUltimate<String> box2 = new BoxUltimate<String>("Test");
//
////        box1.info();
////        box2.info();
//
////        int x = 10;
////        x = x + box1.getObj();
////        System.out.println(x);
////
//        if (box1 instanceof BoxUltimate) {
//            System.out.println("box1 BoxUltimate");
//        }
//
//        if (box2 instanceof BoxUltimate) {
//            System.out.println("box2 BoxUltimate");
//        }

//        BoxUltimate<Integer, String> boxUltimate =
//                new BoxUltimate<Integer, String>(555,"Hello");
//
//        int intValue = boxUltimate.getObj();
//        String strValue = boxUltimate.getObj2();
//
//        System.out.println(intValue + " " + strValue);

        Integer[] inums = {1,2,3,4,5};
        Double[] dnums = {1.0,2.0,3.0,4.0,5.0};

        Stats<Integer> iob = new Stats<Integer>(inums);
        Stats<Double> iod = new Stats<Double>(dnums);

        double res = iob.avg();

        if(iob.sameAvg(iod)) {
            System.out.println("Средние значения равны");
        }

        System.out.println(res);


//        x = x + x + (Integer) box2.getObj();
//        System.out.println(x);

    }
}


class Stats<T> {
    private T[] nums;

    public Stats(T[] nums) {
        this.nums = nums;
    }

    public double avg() {
        double sum = 0.0;
        for (int i = 0; i < nums.length; i++) {
           // sum += nums[i].doubleValue();
        }
        return sum / nums.length;
    }

    public boolean sameAvg(Stats<? super Double> another) {
        return Math.abs(this.avg() - another.avg()) < 0.0001;
    }
}








class BoxUltimate<T, V> {
    private T obj;
    private V obj2;

    public BoxUltimate(T obj, V obj2) {
        this.obj = obj;
        this.obj2 = obj2;
    }

    public T getObj() {
        return obj;
    }

    public void setObj(T obj) {
        this.obj = obj;
    }

    public V getObj2() {
        return obj2;
    }

    public void setObj2(V obj2) {
        this.obj2 = obj2;
    }

    public void info() {
        System.out.println("type T " + obj.getClass().getName());
        System.out.println("type V " + obj.getClass().getName());
    }
}




class BoxInt {
    private Integer obj;

    public BoxInt(Integer obj) {
        this.obj = obj;
    }

    public Object getObj() {
        return obj;
    }

    public void setObj(Integer obj) {
        this.obj = obj;
    }

    public void info() {
        System.out.println("obj " + obj);
        System.out.println("type " + obj.getClass());
    }
}

class Box {
    private Object obj;

    public Box(Object obj) {
        this.obj = obj;
    }

    public Object getObj() {
        return obj;
    }

    public void setObj(Object obj) {
        this.obj = obj;
    }

    public void info() {
        System.out.println("obj " + obj);
        System.out.println("type " + obj.getClass());
    }
}
