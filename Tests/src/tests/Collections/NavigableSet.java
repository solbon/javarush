package tests.Collections;

import java.util.*;

public class NavigableSet {
    public static void main(String[] args) {
        int i = 5;
        i = ++i + ++i;
        System.out.println(i);

        java.util.NavigableSet<Integer> set = new TreeSet<>();
        set.add(5);
        set.add(3);
        set.add(1);
        set.add(9);
        set.add(7);
        System.out.println(set);
        System.out.println(set.descendingSet());

        Iterator iterator = set.iterator();

        long a = 5;
        a = 5 + 'A' + a;
        System.out.println("a = " + a);

    }
}
