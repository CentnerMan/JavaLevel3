package ru.lebedev.se.HomeWork7.lesson7;

public class Test {
    public static void main(String[] args) {

        int a = 2;
        int b = 10;
        int c = 1 >> a++ + ++b - --a - b << 1;
        System.out.println(a);
        System.out.println(b);
        System.out.println(c);

    }
}


//1 какой результат ?


//
//


















//        2 какой резульат?
//
//class Test123 {
//    List<Integer> list;
//
//    Test123() {
//        list = new ArrayList<>();
//        someTest(list);
//    }
//
//    void someTest(List<Integer> al) {
//        al.add(0);
//        al = null;
//    }
//
//    public static void main(String[] args) {
//        Test123 test = new Test123();
//        System.out.println(test.list.size());
//    }
//}
//












//
//3 Есть таблица employees нужно написать запрос чтобы получить все записи из
// таблицы в колонке last_name,
// значения которые начинаются с JDBC
//
//















//
//        4 Напишите 1 запрос для обновления сразу двух колонок в таблице employees (столбцы name, surname)