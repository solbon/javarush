package com.javarush.test.level15.lesson09.task01;

import java.util.HashMap;
import java.util.Map;

/* Статики 1
В статическом блоке инициализировать labels 5 различными парами.
*/

public class Solution {
    public static Map<Double, String> labels = new HashMap<Double, String>();

    static {
        labels.put(1d, "hello");
        labels.put(2d, "hello");
        labels.put(3d, "hello");
        labels.put(4d, "hello");
        labels.put(5d, "hello");

    }

    public static void main(String[] args) {
        System.out.println(labels);
    }
}
