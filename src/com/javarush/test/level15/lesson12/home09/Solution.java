package com.javarush.test.level15.lesson12.home09;

/* Парсер реквестов
Считать с консоли URl ссылку.
Вывести на экран через пробел список всех параметров (Параметры идут после ? и разделяются &, например, lvl=15).
URL содержит минимум 1 параметр.
Если присутствует параметр obj, то передать его значение в нужный метод alert.
alert(double value) - для чисел (дробные числа разделяются точкой)
alert(String value) - для строк

Пример 1
Ввод:
http://javarush.ru/alpha/index.html?lvl=15&view&name=Amigo
Вывод:
lvl view name

Пример 2
Ввод:
http://javarush.ru/alpha/index.html?obj=3.14&name=Amigo
Вывод:
obj name
double 3.14

Тестовая строка:
javarush.ru/alpha/index.html?lvl=15&??view&&&name=Aobjmigo&obj=3.14&name=&obj=djsdcd&&?oobj=3.0

javarush.ru/index.php?op=none&obj=3.5test&obj=10
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    public static void main(String[] args) throws IOException {
        //add your code here
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s = reader.readLine();


        //Следующий параметр
        int indexStart = 0;
        int indexEnd = 0;
        int indexA, indexQ;
        boolean isParameter = false;
        boolean toPrint = false;
        List<String> listObj = new ArrayList<>();

        for (int i = 0; i < s.length(); i++) {
            //находим первый параметр (i = 0 начало строки URL)
            if (i == 0) {
                indexStart = s.indexOf('?') + 1;
                indexEnd = s.indexOf('&');
                i = indexEnd;
                isParameter = false;
                toPrint = true;
            }

            if ((!isParameter)&&(!((s.charAt(i) == '&') || (s.charAt(i) == '?'))))
                isParameter = true;

            if (isParameter) {
                indexStart = i;
                indexA = s.indexOf('&', indexStart);
                indexQ = s.indexOf('?', indexStart);
                if ((indexA == -1)&&(indexQ == -1))
                    indexEnd = s.length();
                else if (indexA == -1)
                    indexEnd = indexQ;
                else if (indexQ == -1)
                    indexEnd = indexA;
                else indexEnd = (indexA < indexQ) ? indexA : indexQ;
                i = indexEnd;
                isParameter = false;
                toPrint = true;
            }

            //keyAndValue - вся строка: параметр со значением
            if (toPrint) {
                String keyAndValue = s.substring(indexStart, indexEnd);
                String key = keyAndValue;
                String value = null;
                if (keyAndValue.contains("=")) {
                    //key - параметры, value - значения параметров
                    key = keyAndValue.substring(0, keyAndValue.indexOf('='));
                    value = keyAndValue.substring(keyAndValue.indexOf('=') + 1);
                    if (key.equals("obj")) {
                        listObj.add(value);
                    }
                }
                //вывод всех параметров через пробел
                System.out.print(key + " ");
                toPrint = false;
            }



        }
    System.out.println("");
    //вывод obj
//        System.out.println(listObj);
    for (String str : listObj) {
        try {

                alert(Double.valueOf(str));
            }
            catch (Exception e) {
                alert(str);
            }

    }

}


    public static void alert(double value) {
        System.out.println("double " + value);
    }

    public static void alert(String value) {
        System.out.println("String " + value);
    }
}
