package com.javarush.test.level19.lesson03.task04;

import java.io.File;
import java.io.IOException;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;

/* И еще один адаптер
Адаптировать Scanner к PersonScanner.
Классом-адаптером является PersonScannerAdapter.
Данные в файле хранятся в следующем виде:
Иванов Иван Иванович 31 12 1978

Подсказка: воспользуйтесь классом Calendar
*/

public class Solution {
    public static class PersonScannerAdapter implements PersonScanner {
        private Scanner scanner;
        public PersonScannerAdapter(Scanner scanner) {
            this.scanner = scanner;
        }

        public Person read() throws IOException {
            String[] tokens = new String[6];
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                System.out.println("this is my line: " + line);
                tokens = line.split(" ");
                break;
            }

//            for (String str : tokens) {
//                System.out.println(str);
//            }
            String firstName = tokens[1];
            String middleName = tokens[2];
            String lastName = tokens[0];
            int day = Integer.parseInt(tokens[3]);
            int month = Integer.parseInt(tokens[4]);
            int year = Integer.parseInt(tokens[5]);

            Calendar cal = new GregorianCalendar(year, month - 1, day);
            Person person = new Person(firstName, middleName, lastName, cal.getTime());
            return person;

        }

        public void close() throws IOException {
            scanner.close();
        }
    }

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(new File("D:/tmp/scanner.txt"));

//        System.out.println("1");
        PersonScanner personScanner = new PersonScannerAdapter(sc);
//        System.out.println("2");
        System.out.println(personScanner.read());
//        System.out.println("3");
        personScanner.close();
//        System.out.println("4");

    }

}
