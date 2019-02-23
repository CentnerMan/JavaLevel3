package ru.lebedev.se.Homework6.lesson6.Anon;

public class prepareTable {

//    public static void prepareTable(Class c) {
//        if (!c.isAnnotationPresent(XTable.class)) throw new RuntimeException("XTable missed");
//
//        // если у нас есть поле int то напишем его как "INTEGER" и т.д.
//        HashMap<Class, String> hm = new HashMap<>();
//        hm.put(int.class, "INTEGER");
//        hm.put(String.class, "TEXT");
//
//        try {
//            connect();
//            // узнаем имя таблицы
//            String tableName = ((XTable) c.getAnnotation(XTable.class)).name();
//            // если такая таблица есть то ее дропнем
//            stmt.executeUpdate("DROP TABLE IF EXISTS " + tableName + ";");
//
//            // создадим таблицу  (но мы не можем сразу собрать запрос, соберем по кускам)
//// 'CREATE TABLE IF NOT EXISTS students (id INTEGER, name TEXT, score INTEGER, email TEXT);'
//
//            String query = "CREATE TABLE IF NOT EXISTS " + tableName + " (";
//            // 'CREATE TABLE IF NOT EXISTS students ('
//            // получаем все поля из класса
//            Field[] fields = c.getDeclaredFields();
//            for (Field o : fields) {
//                // если есть анотация то добавляем ее в таблицу
//                if (o.isAnnotationPresent(XField.class)) {
//                    // если написать o.getName() + o.getType()
//                    // будет проблема так как у нас String а нужен Text
//                    // создадим HM которая преобразует класс к строке
//                    query += o.getName() + " " + hm.get(o.getType()) + ", ";
//                }
//            }
//            // 'CREATE TABLE IF NOT EXISTS students (id INTEGER, name TEXT, score INTEGER, email TEXT, ' // обрежем строку
//            query = query.substring(0, query.length() - 2);
//            // 'CREATE TABLE IF NOT EXISTS students (id INTEGER, name TEXT, score INTEGER, email TEXT'
//            query += ");";
//            // 'CREATE TABLE IF NOT EXISTS students (id INTEGER, name TEXT, score INTEGER);'
//            stmt.executeUpdate(query);
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally {
//            disconnect();
//        }
//    }
//
//    public static void addObject(Object obj) throws SQLException {
//        Class c = obj.getClass();
//        if (!c.isAnnotationPresent(XTable.class)) throw new RuntimeException("XTable missed");
//        try {
//            connect();
//// проверка на анотация (есть ли у класса анотация)
//            String tableName = ((XTable) c.getAnnotation(XTable.class)).name();
//            // 'INSERT INTO students (id, name, score, email, salary) VALUES (...);'
//            String query = "INSERT INTO " + tableName + " (";
//            // 'INSERT INTO students ('
//            Field[] fields = c.getDeclaredFields();
//// первый цикл для подготовки INSERT и названия столбцов
//            for (Field o : fields) {
//                if (o.isAnnotationPresent(XField.class)) {
//                    query += o.getName() + ", ";
//                }
//            }
//            // 'INSERT INTO students (id, name, score, email, '
//            query = query.substring(0, query.length() - 2);
//            // 'INSERT INTO students (id, name, score, email'
//            query += ") VALUES (";
//            // 'INSERT INTO students (id, name, score, email, salary) VALUES ('
//// а теперь добавим  PreparedStatement (и вместо значений подставим вопросы)
//            for (Field o : fields) {
//                if (o.isAnnotationPresent(XField.class)) {
//                    query += "?, ";
//                }
//            }
//            // 'INSERT INTO students (id, name, score, email) VALUES (?, ?, ?, ?, '
//            query = query.substring(0, query.length() - 2);
//            // 'INSERT INTO students (id, name, score, email) VALUES (?, ?, ?, ?'
//            query += ");";
//            // 'INSERT INTO students (id, name, score, email) VALUES (?, ?, ?, ?);'
//            PreparedStatement ps = connection.prepareStatement(query);
//            int counter = 1;
//// вместо вопросов подставим значений и счетчик чтобы понимать куда нужно поставить значение
//            for (Field o : fields) {
//                if (o.isAnnotationPresent(XField.class)) {
//                    ps.setObject(counter, o.get(obj));
//                    counter++;
//                }
//            }
//            ps.executeUpdate();
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally {
//            disconnect();
//        }
//    }
//
//    public static void main(String[] args) throws SQLException {
//        prepareTable(Student.class);
//    }
}
