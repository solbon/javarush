package com.javarush.test.level04.lesson06.task02;

/* Максимум четырех чисел
Ввести с клавиатуры четыре числа, и вывести максимальное из них.
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        //Напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s1 = reader.readLine();
        String s2 = reader.readLine();
        String s3 = reader.readLine();
        String s4 = reader.readLine();
        int i1 = Integer.parseInt(s1);
        int i2 = Integer.parseInt(s2);
        int i3 = Integer.parseInt(s3);
        int i4 = Integer.parseInt(s4);

        int max;
        if (i1 > i2 && i1 > i3 && i1 > i4) max = i1;
        else if (i2 > i3 && i2 > i4) max = i2;
        else if (i3 > i4) max = i3;
        else max = i4;
        System.out.println(max);

    }
}
