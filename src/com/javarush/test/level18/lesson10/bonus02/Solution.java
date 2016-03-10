package com.javarush.test.level18.lesson10.bonus02;

/* Прайсы
CrUD для таблицы внутри файла
Считать с консоли имя файла для операций CrUD
Программа запускается со следующим набором параметров:
-c productName price quantity
Значения параметров:
где id - 8 символов
productName - название товара, 30 chars (60 bytes)
price - цена, 8 символов
quantity - количество, 4 символа
-c  - добавляет товар с заданными параметрами в конец файла, генерирует id самостоятельно, инкрементируя максимальный id

В файле данные хранятся в следующей последовательности (без разделяющих пробелов):
id productName price quantity
Данные дополнены пробелами до их длины

Пример:
19846   Шорты пляжные синие           159.00  12
198478  Шорты пляжные черные с рисунко173.00  17
19847983Куртка для сноубордистов, разм10173.991234
*/

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws Exception {
        String option = args[0];                    //get option "-c" from args
        String productName = "";                    //create String productName
        for (int i = 1; i < args.length -2; i++)  //create string productName as args[1] + ... + args[args.length - 2]
            productName += args[i] + " ";           //form productName string consisting of few words
        String price = args[args.length - 2];       //get price as (last-1) param
        String quantity = args[args.length - 1];    //get quantity as last param from args[]
        if (productName.length() > 30)              //trim productName
            productName = productName.substring(0,30);  //if length of productName is greater than 30, trim it
        if (price.length() > 8)              //trim price
            price = price.substring(0,8);  //if length of price is greater than 8, trim it
        if (quantity.length() > 4)              //trim quantity
            quantity = quantity.substring(0,4);  //if length of quantity is greater than 4, trim it


        Scanner scannerConsole = new Scanner(System.in);
        String fileName = scannerConsole.nextLine();    //read fileName from console input using Scanner's nextLine()

        if (option.equals("-c")) {
            BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true));     //open file writer with append option FW(filename, true)
            int id = findMaxId(fileName);                                                   //find maxId in given filename
            String toFile = String.format("%-8s%-30s%-8s%-4s\n", ++id, productName, price, quantity);   //format given string (from args) and prepare to append to file
            writer.write(toFile);   //write formatted string to file

            scannerConsole.close(); //close resources
            writer.close();
        }
    }

    public static int findMaxId(String fileName) {  //findMaxId function finds max ID as first entry in the string
        List<Integer> list = new ArrayList<>();     //ArrayList will contain all IDs found in the file
        try  {   //try-with-resources - 1 resource: file Scanner
            Scanner scannerFile = new Scanner(new File(fileName));
            while (scannerFile.hasNextLine()) {     //while file has next line
                int nextId = 0;
                String nextIdStr = scannerFile.nextLine().substring(0,8); //read whole line and trim to first 8 symbols
                Scanner scannerStr = new Scanner(nextIdStr);              //open new Scanner to read int from 8 chars string
                nextId = scannerStr.nextInt();                              //read int from this new string
                list.add(nextId);                                       //add found int to ArrayList
                scannerStr.close();                                     //close scannerStr
            }

        } catch (Exception e) {
            System.out.println("wrong id");
        } finally {
        }

        if (list.isEmpty())                 //if ArrayList doesn't contain any id's, then maxId = 0, so next insert will start from id = 1 (++maxId)
            return 0;
        int maxId = Collections.max(list);  //find max int from ArrayList
        return maxId;

    }
}
