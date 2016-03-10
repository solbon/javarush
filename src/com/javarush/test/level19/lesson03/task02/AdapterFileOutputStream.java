package com.javarush.test.level19.lesson03.task02;

/* Адаптер
Используйте класс AdapterFileOutputStream, чтобы адаптировать FileOutputStream к новому интерфейсу AmigoStringWriter
*/

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class AdapterFileOutputStream implements AmigoStringWriter {
    private FileOutputStream fos;
    AdapterFileOutputStream(FileOutputStream fos) {
        this.fos = fos;
    }
    @Override
    public void flush() throws IOException {
        fos.flush();
    }

    @Override
    public void writeString(String s) throws IOException {
        byte[] b = s.getBytes();
        fos.write(b);
    }

    @Override
    public void close() throws IOException {
        fos.close();
    }
}

