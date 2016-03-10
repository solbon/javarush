package com.javarush.test.level10.lesson11.home04;

/* Большая зарплата
Вывести на экран надпись «Я не хочу изучать Java, я хочу большую зарплату» 40 раз по образцу.
Образец:
Я не хочу изучать Java, я хочу большую зарплату
 не хочу изучать Java, я хочу большую зарплату
не хочу изучать Java, я хочу большую зарплату
е хочу изучать Java, я хочу большую зарплату
 хочу изучать Java, я хочу большую зарплату
хочу изучать Java, я хочу большую зарплату
…
*/

import java.io.CharConversionException;
import java.util.ArrayList;

public class Solution
{
    public static void main(String[] args)
    {
        String s = "Я не хочу изучать Java, я хочу большую зарплату";

        //Напишите тут ваш код
//        ArrayList<String> strings = new ArrayList<String>();
//        for (int i = 0; i < 6; i++) {
//            strings.add(s.substring(i));
//        }

//        for (int j = 0; j < 40; j++) {
////            System.out.println(j+1);
////            System.out.println("");
//            for (int i = 0; i < strings.size(); i++) {
//                System.out.println(strings.get(i));
//            }
//        }
        for (int i = 0; i < 40; i++) {
            String str = s.substring(i);
            System.out.println(str);
        }

    }

}
