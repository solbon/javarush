package com.javarush.test.level14.lesson08.bonus02;

/* НОД
Наибольший общий делитель (НОД).
Ввести с клавиатуры 2 целых положительных числа.
Вывести в консоль наибольший общий делитель.
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        //вводим 2 числа с клавиатуры
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(reader.readLine());
        int b = Integer.parseInt(reader.readLine());
        int min = (a < b) ? a: b;

//        int min(int a, int b) { return (a < b) ? a : b; }

        int MaxNOD = 1;
        for (int i = 2; i < min; i++) {
            if (((a % i) == 0) && ((b % i) == 0)) MaxNOD = i;
        }

        System.out.println(MaxNOD);

    }
}
