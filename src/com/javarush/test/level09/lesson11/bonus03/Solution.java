package com.javarush.test.level09.lesson11.bonus03;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

/* Задача по алгоритмам
Задача: Пользователь вводит с клавиатуры список слов (и чисел). Слова вывести в возрастающем порядке, числа - в убывающем.
Пример ввода:
Вишня
1
Боб
3
Яблоко
2
0
Арбуз
Пример вывода:
Арбуз
3
Боб
2
Вишня
1
0
Яблоко
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> list = new ArrayList<String>();
        while (true)
        {
            String s = reader.readLine();
            if (s.isEmpty()) break;
            list.add(s);
        }

        String[] array = list.toArray(new String[list.size()]);
        sort(array);

        for (String x : array)
        {
            System.out.println(x);
        }
    }

    public static void sort(String[] array)
    {
        //Напишите тут ваш код

        //Создаю 2 ArrayList для хранения отдельно чисел и строк
        ArrayList<Integer> arrayInt = new ArrayList<Integer>();
        ArrayList<String> arrayStr = new ArrayList<String>();

        //Сделаем копию array[]
        String[] arrayCopy = array;


        //Пробегаем по введенным данным и отделяем числа от строк
        //числа в ArrayInt, строки в ArrayStr
        for (int i = 0; i < array.length; i++) {
            if (isNumber(array[i]))
                arrayInt.add(Integer.parseInt(array[i]));
            else
                arrayStr.add(array[i]);
        }



//        System.out.println(arrayInt);
//        System.out.println(arrayStr);

        //Сортировка чисел
/*        for (int i = 0; i < arrayInt.size() - 1; i++) {
            for (int j = 0; j < arrayInt.size() - i - 1; j++) {
                if (arrayInt.get(j) < arrayInt.get(j + 1)) {
                    int smaller = arrayInt.get(j);
                    int bigger = arrayInt.get(j + 1);
                    arrayInt.remove(j);
                    arrayInt.remove(j+1);
                    arrayInt.add(j, bigger);
                    arrayInt.add(j + 1, smaller);

                }
            }

        }
*/
        Collections.sort(arrayInt, Collections.reverseOrder());
//        System.out.println(arrayInt);

        //Сортирока строк
        Collections.sort(arrayStr);
//        System.out.println(arrayStr);


        //Вывод отсортированных данных в порядке следования
        int countInt = 0;
        int countStr = 0;
        for (int i = 0; i < array.length; i++) {
            if (isNumber(array[i])) {
                array[i] = "" + arrayInt.get(countInt++);
            }
            else
                array[i] = arrayStr.get(countStr++);
        }



    }

    //Метод для сравнения строк: 'а' больше чем 'b'
    public static boolean isGreaterThen(String a, String b)
    {
        return a.compareTo(b) > 0;
    }


    //строка - это на самом деле число?
    public static boolean isNumber(String s)
    {
        if (s.length() == 0) return false;

        for (char c : s.toCharArray())
        {
            if (!Character.isDigit(c) && c != '-') return false;
        }
        return true;
    }
}
