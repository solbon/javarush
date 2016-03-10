package com.javarush.test.level09.lesson11.home04;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/* Конвертер дат
Ввести с клавиатуры дату в формате «08/18/2013»
Вывести на экран эту дату в виде «AUG 18, 2013».
Воспользоваться объектом Date и SimpleDateFormat.
*/

public class Solution {

    public static void main(String[] args) throws Exception {
        //Напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String sdate = reader.readLine();
        SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy");
        Date date = format.parse(sdate);
        convertToDate(date);
//        SimpleDateFormat formatWeNeed = new SimpleDateFormat("MMM dd, YYYY", Locale.ENGLISH);
//        System.out.println(formatWeNeed.format(date).toUpperCase());


    }
    public static void convertToDate(Date date) throws ParseException {
        SimpleDateFormat formatWeNeed = new SimpleDateFormat("MMM dd, YYYY", Locale.ENGLISH);
        System.out.println(formatWeNeed.format(date).toUpperCase());
    }



}
