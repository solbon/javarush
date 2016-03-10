package com.javarush.test.level18.lesson10.home07;

/* Поиск данных внутри файла
Считать с консоли имя файла
Найти в файле информацию, которая относится к заданному id, и вывести ее на экран в виде, в котором она записана в файле.
Программа запускается с одним параметром: id (int)
Закрыть потоки

В файле данные разделены пробелом и хранятся в следующей последовательности:
id productName price quantity

где id - int
productName - название товара, может содержать пробелы, String
price - цена, double
quantity - количество, int

Информация по каждому товару хранится в отдельной строке
*/

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws FileNotFoundException {
        int id = Integer.valueOf(args[0]);
        Scanner scanner = new Scanner(System.in);
        Scanner fileScanner = new Scanner(new File(scanner.nextLine()));
        while (fileScanner.hasNextLine()) {
            int n = fileScanner.nextInt();
            String s = fileScanner.nextLine();
            if (n == id) {
                System.out.println("" + n + s);
                break;
            }
        }
        scanner.close();
        fileScanner.close();
    }
}
