package com.javarush.test.level18.lesson10.home09;

/* Файлы и исключения
Читайте с консоли имена файлов
Если файла не существует (передано неправильное имя файла), то
перехватить исключение, вывести в консоль переданное неправильное имя файла и завершить работу программы
Не забудьте закрыть все потоки
*/

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scannerConsole = new Scanner(System.in);
        String s = null;
        try {
            while (!((s = scannerConsole.nextLine()).isEmpty())) {
                Scanner scannerFile = new Scanner(new File(s = scannerConsole.nextLine()));
            }
        }
        catch (FileNotFoundException e) {
            System.out.println(s);
        }
    }
}
