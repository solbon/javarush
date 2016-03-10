package com.javarush.test.level18.lesson10.bonus01;

/* Шифровка
Придумать механизм шифровки/дешифровки

Программа запускается с одним из следующих наборов параметров:
-e fileName fileOutputName
-d fileName fileOutputName
где
fileName - имя файла, который необходимо зашифровать/расшифровать
fileOutputName - имя файла, куда необходимо записать результат шифрования/дешифрования
-e - ключ указывает, что необходимо зашифровать данные
-d - ключ указывает, что необходимо расшифровать данные
*/

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) throws IOException {
        String option = args[0];
        String src = args[1];
        String dst = args[2];

        if (option.equals("-e"))
            encrypt(src, dst);
        else if (option.equals("-d"))
            decrypt(src, dst);

    }

    private static void encrypt(String src, String dst) throws IOException {
        FileInputStream reader = new FileInputStream(src);
        FileOutputStream writer = new FileOutputStream(dst);
        while (reader.available() > 0) {
            int b = reader.read();
            writer.write(b + 100);
        }

    }
    private static void decrypt(String src, String dst) throws IOException {
        FileInputStream reader = new FileInputStream(src);
        FileOutputStream writer = new FileOutputStream(dst);
        while (reader.available() > 0) {
            int b = reader.read();
            writer.write(b - 100);
        }

    }

}
