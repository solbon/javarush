package com.javarush.test.level04.lesson13.task02;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* Рисуем прямоугольник
Ввести с клавиатуры два числа m и n.
Используя цикл for вывести на экран прямоугольник размером m на n из восьмёрок.
Пример: m=2, n=4
8888
8888
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        //Напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String m = reader.readLine();
        String n = reader.readLine();
        int mm = Integer.parseInt(m);
        int nn = Integer.parseInt(n);

        for (int i = 0; i < mm; i++) {
            for (int j = 0; j < nn; j++) {
                System.out.print(8);
            }
            System.out.println();
        }


    }
}
