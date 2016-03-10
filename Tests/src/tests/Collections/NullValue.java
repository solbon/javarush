package tests.Collections;

import java.util.HashMap;
import java.util.HashSet;
import java.util.TreeSet;

/**
 * Created by solbon on 25.11.2014.
 */
public class NullValue {
    public static void main(String[] args) {
        HashSet<Integer> hashSet = new HashSet<>();
        TreeSet<Integer> treeSet = new TreeSet<>();
        hashSet.add(null);
        hashSet.add(null);
        treeSet.add(1);
        treeSet.add(5);
        treeSet.add(2);

        System.out.println(hashSet);
        System.out.println(treeSet);
        HashMap<String , Integer> map = new HashMap<>();

    }
}
