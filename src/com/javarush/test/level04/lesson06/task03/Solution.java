package com.javarush.test.level04.lesson06.task03;

/* Сортировка трех чисел
Ввести с клавиатуры три числа, и вывести их в порядке убывания.
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
        int i1 = Integer.parseInt(s1);
        int i2 = Integer.parseInt(s2);
        int i3 = Integer.parseInt(s3);

        int a,b,c;
        if (i1 > i2 && i1 > i3) {
            a = i1;
            if (i2 > i3) {
                b = i2;
                c = i3;
            } else {
                b = i3;
                c = i2;
            }
        }

        else if (i2 > i1 && i2 > i3) {
            a = i2;
            if (i1 > i3) {
                b = i1;
                c = i3;
            } else {
                b = i3;
                c = i1;
            }

        }
        else {
            a = i3;
            if (i1 > i2) {
                b = i1;
                c = i2;
            } else {
                b = i2;
                c = i1;
            }

        }


        System.out.println(a);
        System.out.println(b);
        System.out.println(c);

    }
}
