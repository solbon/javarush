package com.javarush.test.level18.lesson08.task03;

import java.io.*;

/* AmigoOutputStream
1 Измените класс AmigoOutputStream так, чтобы он стал Wrapper-ом для класса FileOutputStream
2 При вызове метода close() должны выполняться следующая последовательность действий:
2.1 вызвать метод flush()
2.2 дописать следующий текст [JavaRush © 2012-2013 All rights reserved.], используйте метод getBytes()
2.3 закрыть поток методом close()
*/

public class AmigoOutputStream extends FileOutputStream {
    public static String fileName = "D:/result.txt";

    public AmigoOutputStream(FileOutputStream fileOutputStream) throws FileNotFoundException {
        super(fileName);
    }

    public void close() throws IOException {
        super.flush();
        super.write((new String("JavaRush © 2012-2013 All rights reserved.")).getBytes());
        super.close();
    }

    public static void main(String[] args) throws IOException {
        (new AmigoOutputStream(new FileOutputStream(fileName))).close();

    }



}

