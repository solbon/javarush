package com.javarush.test.level19.lesson05.task04;

/* Замена знаков
Считать с консоли 2 имени файла.
Первый Файл содержит текст.
Заменить все точки "." на знак "!", вывести во второй файл.
Закрыть потоки ввода-вывода.
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
                newStr = str.replace(".", "!");
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
