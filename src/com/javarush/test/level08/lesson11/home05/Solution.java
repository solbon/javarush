package com.javarush.test.level08.lesson11.home05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/* Мама Мыла Раму. Теперь с большой буквы
Написать программу, которая вводит с клавиатуры строку текста.
Программа заменяет в тексте первые буквы всех слов на заглавные.
Пример ввода:
мама     мыла раму.
Пример вывода:
Мама     Мыла Раму.
*/

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s = reader.readLine();

        //Напишите тут ваш код
        int count = 0;
        String result = "";
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if ((count == 0)&&(!Character.isWhitespace(ch))) {
                ch = Character.toUpperCase(ch);
                count = 1;
            }

            if (Character.isWhitespace(ch)) {
                count = 0;
            }

            result = result + ch;
        }

        System.out.println(result);

    }
}
