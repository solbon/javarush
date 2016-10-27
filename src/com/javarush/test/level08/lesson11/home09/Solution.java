package com.javarush.test.level08.lesson11.home09;

import com.sun.org.apache.xpath.internal.SourceTree;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/* Работа с датой
1. Реализовать метод isDateOdd(String date) так, чтобы он возвращал true, если количество дней с начала года - нечетное число, иначе false
2. String date передается в формате MAY 1 2013
*/

public class Solution {
    public static void main(String[] args) throws ParseException {
        if (isDateOdd("Mar 15 2014"))
            System.out.println("Odd number of days");
        else
            System.out.println("Even number of days");

    }

    public static boolean isDateOdd(String date) throws ParseException {
        //String to Date преобразование
        SimpleDateFormat format = new SimpleDateFormat("MMM d yyyy", Locale.US);
        Date givenDate = format.parse(date);

        //устанавливаем startDate на начало года
        Date startDate = new Date(givenDate.getYear(), 0, 0);

        //получаем разницу между переданным днем и началом года в милисекундах
        long diff = givenDate.getTime() - startDate.getTime();

        int days = (int) (diff / (1000 * 60 * 60 * 24));
        System.out.println(days + " days.");
        if (days % 2 == 1)
            return true;
        else return false;

    }
}
