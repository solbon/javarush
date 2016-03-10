package com.javarush.test.level18.lesson10.home08;

import java.io.*;
import java.util.*;

/* Нити и байты
Читайте с консоли имена файлов, пока не будет введено слово "exit"
Передайте имя файла в нить ReadThread
Нить ReadThread должна найти байт, который встречается в файле максимальное число раз, и добавить его в словарь resultMap,
где параметр String - это имя файла, параметр Integer - это искомый байт.
Не забудьте закрыть все потоки
*/

public class Solution {
    public static Map<String, Integer> resultMap = new HashMap<String, Integer>();

    public static void main(String[] args)  {
        Scanner scannerConsole = new Scanner(System.in);
        String fileName;
        while (!((fileName = scannerConsole.nextLine()).equals("exit"))) {
            try {
                new ReadThread(fileName).start();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
        scannerConsole.close();

//        System.out.println(resultMap);
    }

    public static class ReadThread extends Thread {
        String s;
        Map<Integer, Integer> map = new HashMap<>(); //Map<int Byte, int countOfBytes>
        InputStream is;
        public ReadThread(String fileName) throws FileNotFoundException {
            //implement constructor body
            s = fileName;
            is = new FileInputStream(s);
        }
        // implement file reading here - реализуйте чтение из файла тут
        public void run() {
            int count;
            try {
                while (is.available() > 0) {
                    int b = is.read();
                    if (map.containsKey(b)) {
                        count = map.get(b);
                        map.put(b, ++count);
                    } else {
                        map.put(b, 1);
                    }
//                    System.out.println(map);
                }
            } catch (IOException e) {
                /*NOP*/
            }
            System.out.println(map);
            int max = Integer.MIN_VALUE;
            int b = 0;
            for (Map.Entry<Integer, Integer> pair : map.entrySet()) {
                if (max < pair.getValue()) {
                    max = pair.getValue();
                    b = pair.getKey();
                }
            }
            resultMap.put(s, b);
            try {
                is.close();
            } catch (IOException e) {

            }
        }

    }
}
