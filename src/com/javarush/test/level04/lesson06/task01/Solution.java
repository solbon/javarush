package com.javarush.test.level04.lesson06.task01;

/* Минимум двух чисел
Ввести с клавиатуры два числа, и вывести на экран минимальное из них.
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        //Напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//        System.out.print("Input 1st number: ");
        String  a1 = reader.readLine();
        int a = Integer.parseInt(a1);
//        System.out.print("Input 2st number: ");
        String  b1 = reader.readLine();
        int b = Integer.parseInt(b1);

        if (a < b) System.out.println(a);
        else System.out.println(b);


    }
}