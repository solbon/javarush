package com.javarush.test.level18.lesson05.task03;

/* Разделение файла
Считать с консоли три имени файла: файл1, файл2, файл3.
Разделить файл1 по следующему критерию:
Первую половину байт записать в файл2, вторую половину байт записать в файл3.
Если в файл1 количество байт нечетное, то файл2 должен содержать бОльшую половину.
Закрыть потоки ввода-вывода
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file1 = reader.readLine();
        String file2 = reader.readLine();
        String file3 = reader.readLine();

        FileInputStream inputStream = new FileInputStream(file1);
        FileOutputStream outputStream1 = new FileOutputStream(file2);
        FileOutputStream outputStream2 = new FileOutputStream(file3);

        while (inputStream.available() > 0) {
            if ((inputStream.available() % 2) == 0) {
                int count = inputStream.available() / 2;
                byte[] buff = new byte[count];
                inputStream.read(buff);
                outputStream1.write(buff);
                inputStream.read(buff);
                outputStream2.write(buff);
            }
            else {
                int count = inputStream.available() / 2;
                byte[] buff1 = new byte[count + 1];
                byte[] buff2 = new byte[count];
                inputStream.read(buff1);
                outputStream1.write(buff1);
                inputStream.read(buff2);
                outputStream2.write(buff2);
            }
        }

        inputStream.close();
        outputStream1.close();
        outputStream2.close();

    }
}
