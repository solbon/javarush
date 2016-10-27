package com.javarush.test.level19.lesson05.task02;

/* Считаем слово
Считать с консоли имя файла.
Вывести в консоль количество слов "world", которые встречаются в файле.
Закрыть поток ввода.
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        reader = new BufferedReader(new FileReader(fileName));
        String s;
        int count = 0;
//        while ((s = reader.readLine()) != null) {
//            int length = s.length();
//            char[] chars = new char[length];
//            chars = s.toCharArray();
//            for (int i = 0; i < length; i++) {
//                if (chars[i] == 'w') {
//                    if ((i + 4) < length) {
//                        char[] world = new char[]{chars[i], chars[i + 1], chars[i + 2], chars[i + 3], chars[i + 4]};
//                        char[] myWorld = new char[]{'w', 'o', 'r', 'l', 'd'};
//                        if (Arrays.equals(world, myWorld))
//                            count ++;
//                    }
//                }
//            }
//        }
        while ((s = reader.readLine()) != null) {
            s = s.replaceAll("\\p{Punct}", " ");
            String[] words = s.split(" ");
            for (String myString : words) {
                if (myString.equals("world"))
                    count++;
            }
        }
        System.out.println(count);
        reader.close();

    }
}
