package com.javarush.test.level09.lesson02.task05;

/* Метод должен возвращать результат – глубину её стек-трейса
Написать метод, который возвращает результат – глубину его стек трейса – количество методов в нем (количество элементов в списке). Это же число метод должен выводить на экран.
*/

public class Solution
{
//    public static void main(String[] args) {
//        int i = getStackTraceDeep();
//    }
    public static int getStackTraceDeep()
    {
        //Напишите тут ваш код
        StackTraceElement[] elements = Thread.currentThread().getStackTrace();
        int length = elements.length;
        System.out.println(length);
        return length;

    }
}
