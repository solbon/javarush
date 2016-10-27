package com.javarush.test.level18.lesson10.home04;

/* Объединение файлов
Считать с консоли 2 имени файла
В начало первого файла записать содержимое второго файла так, чтобы получилось объединение файлов
Закрыть потоки
Темповые файлы создавать нельзя, т.к. на сервере заблокирована возможность создания каких любо файлов
*/

import sun.misc.IOUtils;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws IOException {
        Scanner console = new Scanner(System.in);
        String file1str = console.nextLine();
        String file2str = console.nextLine();

//        String file1 = "D:/1.txt";
//        String file2 = "D:/2.txt";
        Path file1 = Paths.get(file1str);
        Path file2 = Paths.get(file2str);

        byte[] bytesFile2 = Files.readAllBytes(file2);
        byte[] bytesFile1 = Files.readAllBytes(file1);

        byte[] result = new byte[bytesFile1.length + bytesFile2.length];
        System.arraycopy(bytesFile2, 0, result, 0, bytesFile2.length);
        System.arraycopy(bytesFile1, 0, result, bytesFile2.length, bytesFile1.length);

        FileOutputStream fos = new FileOutputStream(file1str);
        fos.write(result);

//        RandomAccessFile writeFile1 = new RandomAccessFile(file1, "rw");
//        writeFile1.write(bytesFile2);
        console.close();
//        readFile2.close();
//        writeFile1.close();
        fos.close();
    }
}
