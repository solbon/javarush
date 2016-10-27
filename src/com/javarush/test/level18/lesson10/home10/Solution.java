package com.javarush.test.level18.lesson10.home10;

/* Собираем файл
Собираем файл из кусочков
Считывать с консоли имена файлов
Каждый файл имеет имя: [someName].partN. Например, Lion.avi.part1, Lion.avi.part2, ..., Lion.avi.part37.
Имена файлов подаются в произвольном порядке. Ввод заканчивается словом "end"
В папке, где находятся все прочтенные файлы, создать файл без приставки [.partN]. Например, Lion.avi
В него переписать все байты из файлов-частей используя буфер.
Файлы переписывать в строгой последовательности, сначала первую часть, потом вторую, ..., в конце - последнюю.
Закрыть все потоки ввода-вывода
Темповые файлы создавать нельзя, т.к. на сервере заблокирована возможность создания каких любо файлов
*/

import java.io.*;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class Solution {
    public static void main(String[] args) throws IOException {
        Set<String> set = new TreeSet<>();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String s;
        while (!(s = bufferedReader.readLine()).equals("end")) {
            set.add(s);
        }
        Iterator iterator = set.iterator();
        String partFileName = (String) iterator.next();
//        System.out.println(partFileName);
        String myFileName = partFileName.substring(0, partFileName.length() - 6 );
//        System.out.println(myFileName);

//        Writer writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(myFileName)));
        FileOutputStream fos = new FileOutputStream(myFileName);

        for (String str : set) {
            BufferedInputStream bis = new BufferedInputStream(new FileInputStream(str));
            while (bis.available() > 0) {
                int b = bis.read();
                System.out.println("b:" + b);
                fos.write(b);
            }
        }
    }
}
