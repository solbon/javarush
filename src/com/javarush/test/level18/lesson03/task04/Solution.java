package com.javarush.test.level18.lesson03.task04;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* Самые редкие байты
Ввести с консоли имя файла
Найти байты, которые встречаются в файле меньше всего раз.
Вывести их на экран через пробел
Закрыть поток ввода-вывода
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream inputStream = new FileInputStream(reader.readLine());
        Map<Integer, Integer> map = new HashMap<>();
        int minValue = Integer.MAX_VALUE;

        while (inputStream.available() > 0) {
            int currentByte = inputStream.read();
            if (map.containsKey(currentByte))
                map.put(currentByte, map.get(currentByte) + 1);
            else
                map.put(currentByte, 1);
        }
        inputStream.close();
        reader.close();

        minValue = Collections.min(map.values());
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == minValue)
                System.out.print(entry.getKey() + " ");
        }
    }
}
