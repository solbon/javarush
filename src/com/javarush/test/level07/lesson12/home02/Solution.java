package com.javarush.test.level07.lesson12.home02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* Переставить M первых строк в конец списка
Ввести с клавиатуры 2 числа N  и M.
Ввести N строк и заполнить ими список.
Переставить M первых строк в конец списка.
Вывести список на экран, каждое значение с новой строки.
*/

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        //Напишите тут ваш код
        int N = Integer.parseInt(reader.readLine());
        int M = Integer.parseInt(reader.readLine());

        ArrayList<String> list = new ArrayList<String>();

        for (int i = 0; i < N; i++) {
//            if (M > 0) list.add(list.size(), reader.readLine());
//            else list.add(reader.readLine());
            list.add(reader.readLine());
        }

        for (int i = 0; i < M; i++) {
            String s = list.get(0);
            list.remove(0);
            list.add(list.size(), s);
        }

        for (String s: list) {
            System.out.println(s);
        }
    }
}
