package com.javarush.test.level08.lesson11.bonus01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/* Номер месяца
Программа вводит с клавиатуры имя месяца и выводит его номер на экран в виде: «May is 5 month».
*/

public class Solution
{
    public static void main(String[] args) throws IOException, ParseException {
        //add your code here - напиши код тут
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String month = reader.readLine();

        HashMap<String, Integer> months = new HashMap<>();
        months = initMap(months);

        for (Map.Entry pair: months.entrySet() ) {
            if (month.equalsIgnoreCase((String)pair.getKey()))
                System.out.println(pair.getKey() + " is " + pair.getValue() + " month");

        }

    }

    static HashMap<String, Integer> initMap(HashMap<String, Integer> map) {
        map.put("January", 1);
        map.put("February", 2);
        map.put("March", 3);
        map.put("April", 4);
        map.put("May", 5);
        map.put("June", 6);
        map.put("July", 7);
        map.put("August", 8);
        map.put("September", 9);
        map.put("October", 10);
        map.put("November", 11);
        map.put("December", 12);
        return map;
        }

}
