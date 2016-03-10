package com.javarush.test.level18.lesson10.home06;

/* Встречаемость символов
Программа запускается с одним параметром - именем файла, который содержит английский текст.
Посчитать частоту встречания каждого символа.
Отсортировать результат по возрастанию кода ASCII (почитать в инете). Пример: ','=44, 's'=115, 't'=116
Вывести на консоль отсортированный результат:
[символ1]  частота1
[символ2]  частота2
Закрыть потоки

Пример вывода:
, 19
- 7
f 361
*/

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Solution {
    static Map<Integer, Integer> map = new TreeMap<>();

    public static void main(String[] args) throws FileNotFoundException {
        String filename = args[0];
        countFreq(filename);
        for (Map.Entry<Integer, Integer> pair : map.entrySet()) {
            System.out.println(String.valueOf(Character.toChars(pair.getKey())) + " " + pair.getValue());
        }
    }

    public static void countFreq(String filename) throws FileNotFoundException {
        Scanner fileReader = new Scanner(new File(filename));
        int carriageReturnCount = 0;
        while (fileReader.hasNextLine()) {
            String tmp = fileReader.nextLine();

            for (int i = 0; i < tmp.length(); i++) {
                char c = tmp.charAt(i);
                Integer count;
                if (( count = map.get((int)c)) == null) {
                    map.put((int)c, 1);
                }
                else
                    map.put((int)c, ++count);
            }
            map.put(13,carriageReturnCount++);
        }
        fileReader.close();

    }

}
