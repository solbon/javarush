package com.javarush.test.level09.lesson11.bonus01;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

/* Нужно исправить программу, чтобы компилировалась и работала
Задача: Программа вводит два имени файла. И копирует первый файл на место заданное вторым именем.
*/

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String sourceFileName = reader.readLine();
        String destinationFileName = reader.readLine();

        java.io.FileInputStream fileInputStream = new java.io.FileInputStream(sourceFileName);
//        System.out.println(sourceFileName);
        java.io.FileOutputStream fileOutputStream = new java.io.FileOutputStream(destinationFileName);
//        System.out.println(destinationFileName);

        int count = 0;
//        System.out.println("Start while loop");
        while (fileInputStream.available() > 0)
        {
//            System.out.println("Inside while loop");
            int data = fileInputStream.read();
            fileOutputStream.write(data);
            count++;
        }

        System.out.println("Скопировано байт " + count);

        fileInputStream.close();
        fileOutputStream.close();
    }
}
