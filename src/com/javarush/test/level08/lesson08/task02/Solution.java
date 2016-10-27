package com.javarush.test.level08.lesson08.task02;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* Удалить все числа больше 10
Создать множество чисел(Set<Integer>), занести туда 20 различных чисел.
Удалить из множества все числа больше 10.
*/

public class Solution
{
    public static HashSet<Integer> createSet()
    {
        //Напишите тут ваш код
        HashSet<Integer> list = new HashSet<Integer>();
        list.add(1);
        list.add(10);
        list.add(100);
        list.add(300);
        list.add(130);
        list.add(3);
        list.add(34);
        list.add(56);
        list.add(65);
        list.add(5);
        list.add(9);
        list.add(2);
        list.add(12);
        list.add(21);
        list.add(102);
        list.add(190);
        list.add(4);
        list.add(41);
        list.add(14);
        list.add(104);
        return list;

    }

    public static HashSet<Integer> removeAllNumbersMoreThen10(HashSet<Integer> set)
    {
        //Напишите тут ваш код
        for (Iterator<Integer> i = set.iterator(); i.hasNext();){
            Integer element = i.next();
            if (element > 10) i.remove();
        }
        return set;



    }

    public static void main(String[] args)
    {
        System.out.println(removeAllNumbersMoreThen10(createSet()));
    }
}
