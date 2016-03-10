package com.javarush.test.level14.lesson08.bonus01;

import java.awt.*;
import java.io.*;
import java.util.ArrayList;
import java.util.IllegalFormatCodePointException;
import java.util.IllegalFormatException;
import java.util.List;

import static java.lang.Math.sin;

/* Нашествие эксепшенов
Заполни массив exceptions 10 различными эксепшенами.
Первое исключение уже реализовано в методе initExceptions.
*/

public class Solution
{
    public static List<Exception> exceptions = new ArrayList<Exception>();

    public static void main(String[] args)
    {
        initExceptions();

        for (Exception exception : exceptions)
        {
            System.out.println(exception);
        }
    }

    private static void initExceptions()  {   //it's first exception

        //1. ArithmeticException
        try
        {
            float i = 1 / 0;

        } catch (Exception e)
        {
            exceptions.add(e);
        }

        //Add your code here

        //2. ArrayIndexOutOfBoundException
        try {
            int[] array = new int[2];
            int n = array[3];
        } catch (Exception e2) {
            exceptions.add(e2);
        }

        //3. NullPointerException
        try {
            int[] nNulArray = new int[5];
            nNulArray = null;
            int i = nNulArray.length;

        } catch (Exception e3) {
            exceptions.add(e3);
        }
        try {
            throw new IOException();
        } catch (Exception e2) {
            exceptions.add(e2);
        }
        try {
            throw new EOFException();
        } catch (Exception e2) {
            exceptions.add(e2);
        }
        try {
            throw new InterruptedIOException();
        } catch (Exception e2) {
            exceptions.add(e2);
        }
        try {
            throw new AWTException("h");
        } catch (Exception e2) {
            exceptions.add(e2);
        }
        try {
            throw new FileNotFoundException();
        } catch (Exception e2) {
            exceptions.add(e2);
        }
        try {
            throw new CharConversionException();
        } catch (Exception e2) {
            exceptions.add(e2);
        }
        try {
            throw new ClassNotFoundException();
        } catch (Exception e2) {
            exceptions.add(e2);
        }


    }
}
