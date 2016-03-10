package com.javarush.test.level13.lesson11.home04;

/* Запись в файл
1. Прочесть с консоли имя файла.
2. Считывать строки с консоли, пока пользователь не введет строку "exit".
3. Вывести все строки в файл.
*/

import java.io.*;
import java.util.ArrayList;

public class Solution
{
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String filename = reader.readLine();

        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(filename)));

        String s;
        ArrayList<String> arrayList = new ArrayList<String>();
        while (!((s = reader.readLine()).equals("exit"))) {
               arrayList.add(s);
//            out.println(s);
        }
        arrayList.add("exit");
        for (String str : arrayList)
            out.println(str);
        reader.close();
        out.close();

    }
}
