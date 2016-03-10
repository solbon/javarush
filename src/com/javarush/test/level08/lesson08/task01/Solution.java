package com.javarush.test.level08.lesson08.task01;

import com.javarush.test.level06.lesson08.task05.StringHelper;

import java.util.*;


/* 20 слов на букву «Л»
Создать множество строк (list<String>), занести в него 20 слов на букву «Л».
*/

public class Solution
{
    public static HashSet<String> createSet() {
        //Напишите тут ваш код
        HashSet<String> list = new HashSet<String>();
        list.add("лопата");
        list.add("лилия");
        list.add("лом");
        list.add("лев");
        list.add("лаки");
        list.add("леший");
        list.add("любовь");
        list.add("лира");
        list.add("лего");
        list.add("лай");
        list.add("лось");
        list.add("лосось");
        list.add("липа");
        list.add("лупа");
        list.add("лапа");
        list.add("левша");
        list.add("левый");
        list.add("лево");
        list.add("луг");
        list.add("лук");

        return list;

    }
}
