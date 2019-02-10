package ru.lebedev.se.HomeWork3.Lesson3;

import java.io.IOException;
import java.io.RandomAccessFile;

public class MainClass {
    public static void main(String[] args) throws IOException {
//        File file = new File("123");
//
//        String[] str = file.list(new FilenameFilter() {
//            @Override
//            public boolean accept(File dir, String name) {
//                return name.startsWith("1");
//            }
//        });
//
//         for (String o: str) {
//            System.out.println(o);
//        }

//        File file = new File("123/text.txt");
//
////        try {
////            file.createNewFile();
////        } catch (IOException e) {
////            e.printStackTrace();
////        }
//
//        System.out.println(file.getPath());
        //        String[] str = file.list();
//
//        for (String o: str) {
//            System.out.println(o);
//        }

//        File file1 = new File("123/text.txt");
//        File file2 = new File("123/text2.txt");
//
//        if(file2.exists()) {
//            throw new IOException("file exists");
//        }
//
//        boolean flag = file1.renameTo(file2);
//        System.out.println(flag);

//        long t = System.currentTimeMillis();
//        try (FileInputStream in = new FileInputStream("123/text2.txt")) {
//            int x;
//
//            while ((x = in.read()) != -1) {
//               // System.out.print((char)x);
//            }
//        }
//        System.out.println(System.currentTimeMillis() - t);

//        long t = System.currentTimeMillis();
//        try (FileInputStream in = new FileInputStream("123/text2.txt")) {
//            byte[] arr = new byte[512];
//            int x;
//
//            while ((x = in.read(arr)) != -1) {
//              //  System.out.print(new String(arr, 0, x));
//            }
//        }
//        System.out.println(System.currentTimeMillis() - t);

//        BufferedReader br = null;
//        FileReader fr = null;
//
//        fr = new FileReader("123/text2.txt");
//        br = new BufferedReader(fr);
//
//        String currentStr;
//
//        while ((currentStr = br.readLine()) != null) {
//            System.out.println(currentStr);
//        }
//
//        br.close();
//        fr.close();


//        PipedInputStream in = null;
//        PipedOutputStream out = null;
//
//        in = new PipedInputStream();
//        out = new PipedOutputStream();
//
//        out.connect(in);
//
//        // записываем в исходящий поток
//        for (int i = 0; i < 100; i++) {
//            out.write(i);
//        }
//
//        int x;
//        // считываем из входящего
//        while ((x = in.read()) != -1) {
//            System.out.print(x + " ");
//        }
//
//        in.close();
//        out.close();


//        ArrayList<InputStream> ali = new ArrayList<>();
//        ali.add(new FileInputStream("123/test1.txt"));
//        ali.add(new FileInputStream("123/test2.txt"));
//
//        SequenceInputStream in = new SequenceInputStream(Collections.enumeration(ali));
//
//        int x;
//        while ((x = in.read()) != -1) {
//            System.out.print((char)x + " ");
//        }
//
//        in.close();

        try (RandomAccessFile raf = new RandomAccessFile("123/test1.txt", "r")) {
            raf.seek(2);
            System.out.println((char) raf.read());
            raf.seek(1);
            System.out.println((char) raf.read());
        }

    }
}
