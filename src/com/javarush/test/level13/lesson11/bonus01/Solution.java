package com.javarush.test.level13.lesson11.bonus01;

/* Сортировка четных чисел из файла
1. Ввести имя файла с консоли.
2. Прочитать из него набор чисел.
3. Вывести на консоль только четные, отсортированные по возрастанию.
Пример ввода:
5
8
11
3
2
10
Пример вывода:
2
8
10
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Solution
{
    public static void main(String[] args) throws IOException {
        // напишите тут ваш код
        //read filename from InputStream
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String filename = reader.readLine();

        //Read numbers from file
        BufferedReader filereader = new BufferedReader(new FileReader(filename));
        String s;
//        int i = 0;
        ArrayList<Integer> array = new ArrayList<>();

        while ((s = filereader.readLine())!= null) {
            int n = Integer.parseInt(s);
            if ((n % 2) == 0)
                array.add(n);

        }

        Collections.sort(array);
        for (int i : array)
            System.out.println(i);


    }
}
