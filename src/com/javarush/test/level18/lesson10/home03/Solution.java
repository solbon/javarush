package com.javarush.test.level18.lesson10.home03;

/* Два в одном
Считать с консоли 3 имени файла
Записать в первый файл содержимого второго файла, а потом дописать содержимое третьего файла
Закрыть потоки
Темповые файлы создавать нельзя, т.к. на сервере заблокирована возможность создания каких любо файлов
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader readerConsole = new BufferedReader(new InputStreamReader(System.in));
        String file1 = readerConsole.readLine();
        String file2 = readerConsole.readLine();
        String file3 = readerConsole.readLine();
//        String file1 = "D:/1.txt";
//        String file2 = "D:/2.txt";
//        String file3 = "D:/3.txt";
        BufferedReader readerFile2 = new BufferedReader(new FileReader(file2));
        BufferedReader readerFile3 = new BufferedReader(new FileReader(file3));
        FileWriter writer = new FileWriter(file1);

        String s;
        while ((s = readerFile2.readLine()) != null) {
            writer.write(s);
        }
        int i;
        while ((i = readerFile3.read()) != -1) {
            char c = (char) i;
            writer.append(c);
        }
        readerConsole.close();
        readerFile2.close();
        readerFile3.close();
        writer.close();

    }
}
