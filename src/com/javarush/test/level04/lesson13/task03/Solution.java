package com.javarush.test.level04.lesson13.task03;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* Рисуем треугольник
Используя цикл for вывести на экран прямоугольный треугольник из восьмёрок со сторонами 10 и 10.
Пример:
8
88
888
...
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        //Напишите тут ваш код
        int n = 1;
        for (int i = 1; i < 12; i++) {
            for (int j = 1; j < n; j++) {
                System.out.print(8);
            }
            System.out.println();
            n++;
            if (n > 11) break;

        }

    }
}
