package com.javarush.test.level15.lesson12.bonus03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

/* Факториал
Написать метод, который вычисляет факториал - произведение всех чисел от 1 до введенного числа включая его.
Пример: 4! = factorial(4) = 1*2*3*4 = 24
1. Ввести с консоли число меньше либо равно 150.
2. Реализовать функцию  factorial.
3. Если введенное число меньше 0, то вывести 0.
0! = 1
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int input;
        while ((input = Integer.parseInt(reader.readLine())) > 150) ;
        reader.close();

        System.out.println(factorial(input));
    }

    public static BigInteger factorial(int n) {
        //add your code here
        BigInteger sum;
        if (n > 0) {
            sum = BigInteger.valueOf(n).multiply(factorial(n - 1));
            return sum;
        }
        else if (n == 0) return BigInteger.valueOf(1);
        else if (n < 0 ) return BigInteger.valueOf(0);
        return BigInteger.valueOf(0);

    }
}
