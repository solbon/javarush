package com.javarush.test.level19.lesson03.task03;

/**
 * Created by solbon on 09.12.2014.
 */
public class SplitTest {
    public static void main(String[] args) {
        String phoneNum = "+38(950)321-22";
        String[] array = phoneNum.split("[()]");
        String[] array2 = array[2].split("-");
        for (String str : array)
            System.out.println(str);
        for (String str : array2)
            System.out.println(str);
        String result = array[1];
        for (int i = 0; i < array2.length; i++) {
            result = result + array2[i];
        }
        System.out.println(result);
        if (result.length() < 10) {
            int count = result.length();
            while (10 - count > 0) {
                result = "0" + result;
                count++;
            }
        }

        System.out.println(result);
    }
}
