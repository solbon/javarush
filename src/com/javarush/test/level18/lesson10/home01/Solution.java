package com.javarush.test.level18.lesson10.home01;

/* Английские буквы
В метод main первым параметром приходит имя файла.
Посчитать количество букв английского алфавита, которое есть в этом файле.
Вывести на экран число (количество букв)
Закрыть потоки
*/

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Solution {
    static int count = 0;
    public static void main(String[] args) throws IOException {
        FileReader fileReader = new FileReader(args[0]);
        int i;
        while ((i =  fileReader.read()) != -1) {
            char c = (char) i;
            if ((c >= 'A' && c <= 'Z') || (c >= 'a' && c <= 'z'))
                count++;
        }
        fileReader.close();

        System.out.println(count);
    }
}
