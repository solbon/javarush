package com.javarush.test.level18.lesson10.home05;

/* Округление чисел
Считать с консоли 2 имени файла
Первый файл содержит вещественные(дробные) числа, разделенные пробелом. Например, 3.1415
Округлить числа до целых и записать во второй файл
Закрыть потоки
Принцип округления:
3.49 - 3
3.50 - 4
3.51 - 4
*/

import java.io.*;
import java.util.Locale;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws IOException {
        Scanner console = new Scanner(System.in);
        String filename1 = console.nextLine();
        String filename2 = console.nextLine();
//        String filename1 = "D:/1.txt";
//        String filename2 = "D:/2.txt";

        Scanner scanFile1 = new Scanner(new File(filename1));
        scanFile1.useLocale(Locale.ENGLISH);
        BufferedWriter writerFile2 = new BufferedWriter(new FileWriter(filename2));

        while (scanFile1.hasNextLine()) {
            long roundedNumber = Math.round(scanFile1.nextDouble());
//            System.out.println(roundedNumber);
            writerFile2.write(String.valueOf(roundedNumber) + "\n");
        }

        console.close();
        scanFile1.close();
        writerFile2.close();
    }
}
