package tests.generics;

import java.util.Arrays;
import java.util.List;

/**
 * Created by sdaribazaron on 2016-06-10.
 */
public class GenericMethod {
    public static <T> void getFirst(List<T> list) {
        list.get(0);
        System.out.println(list.get(1));
    }

    public static void main(String[] args) {
        List<String> strings = Arrays.asList("a", "b", "c");
        getFirst(strings);
    }
}
