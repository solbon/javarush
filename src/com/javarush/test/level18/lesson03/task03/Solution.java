package com.javarush.test.level18.lesson03.task03;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* Самые частые байты
Ввести с консоли имя файла
Найти байты, которые чаше всех встречаются в файле
Вывести их на экран через пробел.
Закрыть поток ввода-вывода
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream inputStream = new FileInputStream(reader.readLine());
        Map<Integer, Integer> map = new HashMap<>();

        while (inputStream.available() > 0) {
            int currentByte = inputStream.read();
            if (map.containsKey(currentByte))
                map.put(currentByte, map.get(currentByte) + 1);
            else
                map.put(currentByte, 1);
        }
//        System.out.println(map);
        inputStream.close();

        int maxValue = Collections.max(map.values()); //находим макс сколько раз байт встретился в файле

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == maxValue)
                System.out.println(entry.getKey());
        }

    }
}
