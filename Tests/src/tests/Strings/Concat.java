package tests.Strings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by solina on 21.03.16.
 */
public class Concat {
    protected int x;
    public static void main(String[] args) {
        String s1 = "ab";
        String s2 = "a";
        String s4 = "a" + s2;
        s2 += "b";
        String s3 = "a" + "b";

        int[] array = new int[3];
        int[][] arr2 = new int[9][];
        int[] java = new int[3];

        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("a");
        String[] stringArray = list.toArray(new String[10]);
        System.out.println(stringArray.length);
        System.out.println(stringArray[3]);

        List<String> list2 = Arrays.asList(stringArray);
//        list2.add("x");
        List<String> list3 = Arrays.asList("a", "b");
//        list3.add("x");
        List<String> list4 = Arrays.asList(new String[]{"a", "b"});
        list.add("x");
        System.out.println(long2());
    }

    static Long long2() {
        Object a = 9;
        return Long.valueOf((int) a);
    }
}

class Concat2 {
    public static void main(String[] args) {
        System.out.println(new Concat().x);
    }
}
