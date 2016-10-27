package com.javarush.test.level19.lesson05.task03;

/* Выделяем числа
Считать с консоли 2 имени файла.
Вывести во второй файл все числа, которые есть в первом файле.
Числа выводить через пробел.
Закрыть потоки ввода-вывода.

Пример тела файла:
12 text var2 14 8v 1

Результат:
12 14 1
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file1 = reader.readLine();
        String file2 = reader.readLine();
        reader = new BufferedReader(new FileReader(file1));
        FileWriter fw = new FileWriter(file2);
        String line;
        while ((line = reader.readLine()) != null) {
            String[] words = line.split(" ");
            for (String word : words) {
                try {
                    Integer number = Integer.parseInt(word);
                    fw.write(word + " ");
                } catch (NumberFormatException e) {
                    continue;
                }
            }
        }
        reader.close();
        fw.close();

    }
}
