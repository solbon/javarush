package com.javarush.test.level06.lesson11.bonus03;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* Задача по алгоритмам
Задача: Написать программу, которая вводит с клавиатуры 5 чисел и выводит их в возрастающем порядке.
Пример ввода:
3
2
15
6
17
Пример вывода:
2
3
6
15
17
*/

public class Solution
{
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        //Напишите тут ваш код
        int n = 5;
        int mas[] = new int[n];
        for (int i = 0; i < n; i++)
            mas[i] = Integer.parseInt(reader.readLine());
        //bubble sort - Здесь я реализую сортировку пузырьком
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (mas[j + 1] < mas[j]) {
                    int T = mas[j];
                    mas[j] = mas[j + 1];
                    mas[j + 1] = T;
                }
            }
        }

        //selection sort
/*
        for (int i = 0; i < n - 1; i++) {
            int min = i;

            for (int j = i + 1; j < n; j++) {
                if (mas[j] < mas[min]) {
                    min = j; //находим минимальный элемент в массиве и записываем его индекс
                }
            }

            //меняем местами минимальный элемент и текущий элемент mas[i]
            int T = mas[i];
            mas[i] = mas[min];
            mas[min] = T;

        }
*/

     //output
    for(int i = 0; i < 5 ;i++)
        System.out.println(mas[i]);

    }

}
