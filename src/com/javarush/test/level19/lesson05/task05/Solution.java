package com.javarush.test.level19.lesson05.task05;

/* Пунктуация
Считать с консоли 2 имени файла.
Первый Файл содержит текст.
Удалить все знаки пунктуации, вывести во второй файл.
http://ru.wikipedia.org/wiki/%D0%9F%D1%83%D0%BD%D0%BA%D1%82%D1%83%D0%B0%D1%86%D0%B8%D1%8F
Закрыть потоки ввода-вывода.
Темповые файлы создавать нельзя, т.к. на сервере заблокирована возможность создания каких любо файлов.
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String input = reader.readLine();   //input filename
            String output = reader.readLine();  //output filename
            BufferedReader freader = new BufferedReader(new FileReader(input));     //read from file
            BufferedWriter writer = new BufferedWriter(new FileWriter(output));     //write to file
            String str, newStr;
            while ((str = freader.readLine()) != null) {        //while input file has lines -> replace and write it to output file
                newStr = str.replaceAll("\\p{Punct}+", "");
                writer.write(newStr);
                writer.write("\n");                             //need to add new line after each line
            }
            reader.close();
            freader.close();
            writer.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
