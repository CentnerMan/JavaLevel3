package ru.lebedev.se.HomeWork1.lesson1;

public class Test {

}


class Test20 {
}
// --------------- 1
class TT {
    private static int count = 0;
    private final int id = ++count;

    private void methodA () {
        System.out.println("TT.methodA " + id);
    }

    public void methodTT(TT t) {
        t.methodA();
    }
}


class Test1 {
    public static void main(String[] args) {
        TT t1 = new TT();
        TT t2 = new TT();
        t2.methodTT(t1);
    }
}

// ---------------







// --------------- 2

//class TestClazz {
//    public static void main(String[] args) {
//        final long Byte = 0;            // 1
//        if ( Byte.equals(0) ) {        // 2
//            System.out.print("==");
//        } else {
//            System.out.print("!=");
//        }
//    }
//}

//        Возникнет ошибка компиляции в строке 1
//        Возникнет ошибка компиляции в строке 2
//        Код напечатает "=="
//        Код напечатает "!="
//        Код успешно скомпилируется

// ---------------












// --------------- 3

//class B {
//    public static void main(String[] args) {
//        big_loop:
//        for (int i = 0; i < 3 ; i++) {
//            try {
//                for (int j = 0; j < 3 ; j++) {
//                    if (i == j) continue;
//                    else if (i > j) continue big_loop;
//                    System.out.print("A");
//                }
//            } finally {
//                System.out.print("B");
//            }
//            System.out.print("C");
//        }
//    }
//}
//        1. AABCAABCBC
//        2. AAABCAAABCAAABC
//        3. AABCBB
//        4. ABCABCABC
//        5. AABBCACA

// ---------------










// --------------- 4

class Main123 {
    public static void main(String[] args) {
        double d = Math.sqrt(-1);
        System.out.println(Double.NaN == d);
        d = d / 0;
        System.out.println(Double.isNaN(d));
    }
}
//
//        1 true false
//        2 false true
//        3 true true
//        4 false false

// ---------------











// --------------- 5
//
class Test10 {
    public static void main(String[] args) {
        Integer i1 = 1000;
        Integer i2 = 1000;

        Double d1 = 10d;
        Double d2 = 10d;

        System.out.println(i1 == i2);
        System.out.println(d1 == d2);
    }
}
// ---------------
