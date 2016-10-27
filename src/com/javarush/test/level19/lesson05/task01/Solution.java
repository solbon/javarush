package com.javarush.test.level19.lesson05.task01;

/* Четные байты
Считать с консоли 2 имени файла.
Вывести во второй файл все байты с четным индексом.
Пример: второй байт, четвертый байт, шестой байт и т.д.
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file1  = reader.readLine();
        String file2  = reader.readLine();
        InputStream is = new FileInputStream(file1);
        OutputStream os = new FileOutputStream(file2);
        String s;
        int i = 1;
        int b;
        while (is.available() != 0) {
            b = is.read();
            if (i == 1) {
                i++;
                continue;
            }
            if (i++ % 2 == 0) {
                os.write(b);
            }
        }
    }
}
