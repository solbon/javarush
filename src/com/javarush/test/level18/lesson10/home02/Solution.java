package com.javarush.test.level18.lesson10.home02;

/* Пробелы
В метод main первым параметром приходит имя файла.
Вывести на экран частоту встречания пробела. Например, 10.45
1. Посчитать количество всех символов.
2. Посчитать количество пробелов.
3. Вывести на экран п2/п1*100, округлив до 2 знаков после запятой
Закрыть потоки
*/

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) throws IOException {
        FileReader reader = new FileReader(args[0]);
        int countSymbols = 0;
        int countSpaces = 0;
        int i;
        double d;
        while (true) {
            if ((i = reader.read()) != -1) {
                char c = (char) i;
                countSymbols++;
                if (c == ' ')
                    countSpaces++;
            }
            else
                break;
        }
        reader.close();
        d = ((double) countSpaces / (double) countSymbols) * 100;
        System.out.println(((double) Math.round(d*100))/100);
//        System.out.println(d);
    }
}
