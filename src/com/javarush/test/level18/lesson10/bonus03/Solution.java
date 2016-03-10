package com.javarush.test.level18.lesson10.bonus03;

/* Прайсы 2
CrUD для таблицы внутри файла
Считать с консоли имя файла для операций CrUD
Программа запускается с одним из следующих наборов параметров:
-u id productName price quantity
-d id
Значения параметров:
где id - 8 символов
productName - название товара, 30 chars (60 bytes)
price - цена, 8 символов
quantity - количество, 4 символа
-u  - обновляет данные товара с заданным id
-d  - производит физическое удаление товара с заданным id (все данные, которые относятся к переданному id)

В файле данные хранятся в следующей последовательности (без разделяющих пробелов):
id productName price quantity
Данные дополнены пробелами до их длины

Пример:
19846   Шорты пляжные синие           159.00  12
198478  Шорты пляжные черные с рисунко173.00  17
19847983Куртка для сноубордистов, разм10173.991234
*/

import java.io.*;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws IOException {

        String[] myParams = getParams(args);

        Scanner scannerConsole = new Scanner(System.in);
        String fileName = scannerConsole.nextLine();    //read fileName from console input using Scanner's nextLine()


        if (myParams[0].equals("-u")) {
            updateLine(Integer.valueOf(myParams[1]), fileName, myParams);
        }

        if (args[0].equals("-d")) {
            removeLine(Integer.valueOf(myParams[1]), fileName);
        }
    }

    static String[] getParams(String[] args) {
        String[] myParams;
        if (args.length > 2) {
            myParams = new String[5];
        }
        else {
            myParams = new String[2];
        }
        String option;
        int id = 1;
        String productName = "";
        String price = "";
        String quantity = "";
        option = args[0];                   //get option "-u" or "-d" from args
        if (args[1].length() > 8)
            id = Integer.parseInt(args[1].substring(0, 8));        //the second one is "id"
        else id = Integer.parseInt(args[1]);

        if (args.length > 2) {
            for (int i = 2; i < args.length - 2; i++)  //create string productName as args[2] + ... + args[args.length - 2]
                productName += args[i] + " ";           //form productName string consisting of few words
            price = args[args.length - 2];       //get price as (last-1) param
            quantity = args[args.length - 1];    //get quantity as last param from args[]
            if (productName.length() > 30)              //trim productName
                productName = productName.substring(0, 30);  //if length of productName is greater than 30, trim it
            if (price.length() > 8)              //trim price
                price = price.substring(0, 8);  //if length of price is greater than 8, trim it
            if (quantity.length() > 4)              //trim quantity
                quantity = quantity.substring(0, 4);  //if length of quantity is greater than 4, trim it
        }
        myParams[0] = option;
        myParams[1] = String.valueOf(id);
        if (args.length > 2) {
            myParams[2] = productName;
            myParams[3] = price;
            myParams[4] = quantity;
        }
        return myParams;
    }

    static void removeLine(int id, String fileName) throws IOException {
        File myFile = new File(fileName);                               //original file
        File tempFile = new File(myFile.getAbsolutePath() + ".tmp");    //create .tmp file where we will write read lines

        try (
                BufferedReader br = new BufferedReader(new FileReader(fileName));  //try-with-resources automatically close br and pw
                PrintWriter pw = new PrintWriter(new FileWriter(tempFile))
        ) {
            String line;
            while ((line = br.readLine()) != null) {    //read line from a file
                String idStr = line.substring(0, 8);    //trim first 8 chars
                Scanner sc = new Scanner(idStr);
                int idInt = sc.nextInt();               //read from 8 chars line first int
                if (id == idInt)                        //if we find the id, we don't write it to file
                    continue;
                pw.println(line);                       //PrintWriter has println function
                pw.flush();                             //flushes the stream
            }
        }

        if (!myFile.delete())                            //delete original file
            System.out.println("Couldn't delete the file");
        if (!tempFile.renameTo(myFile))                 //remane .tmp file to the original
            System.out.println("Couldn't rename the file");

    }

    static void updateLine(int id, String fileName, String[] myParams) throws IOException {
        File myFile = new File(fileName);                               //original file
        File tempFile = new File(myFile.getAbsolutePath() + ".tmp");    //create .tmp file where we will write read lines

        try (
                BufferedReader br = new BufferedReader(new FileReader(fileName));  //try-with-resources automatically close br and pw
                PrintWriter pw = new PrintWriter(new FileWriter(tempFile))
        ) {
            String line;
            while ((line = br.readLine()) != null) {    //read line from a file
                String idStr = line.substring(0, 8);    //trim first 8 chars
                Scanner sc = new Scanner(idStr);
                int idInt = sc.nextInt();               //read from 8 chars line first int
                if (id == idInt) {                        //if we find the id, we don't write it to file
                    String toFile = String.format("%-8s%-30s%-8s%-4s", myParams[1], myParams[2], myParams[3], myParams[4]);
                    pw.println(toFile);
                    continue;
                }
                pw.println(line);                       //PrintWriter has println function
                pw.flush();                             //flushes the stream
            }
        }

        if (!myFile.delete())                            //delete original file
            System.out.println("Couldn't delete the file");
        if (!tempFile.renameTo(myFile))                 //remane .tmp file to the original
            System.out.println("Couldn't rename the file");


    }
}
