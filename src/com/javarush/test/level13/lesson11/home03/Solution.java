package com.javarush.test.level13.lesson11.home03;

/* Чтение файла
1. Считать с консоли имя файла.
2. Вывести в консоль(на экран) содержимое файла.
3. Не забыть закрыть файл и поток.
*/

import java.io.*;

public class Solution
{
    public static void main(String[] args) throws IOException {
        //add your code here
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String filename = reader.readLine();

//        System.out.println(filename);

        BufferedReader filereader = new BufferedReader(new FileReader(filename));
        System.out.println(filereader.readLine());
//        FileOutputStream fileOutputStream = new FileOutputStream(filename);
//        System.out.println(fileOutputStream.toString());
        String s;
        while ((s = filereader.readLine()) != null)
            System.out.println(s);

        filereader.close();
    }
}
