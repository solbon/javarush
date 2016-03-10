package tests.Collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by solbon on 25.11.2014.
 */
public class Unmodifiable {
    public static void main(String[] args) {

        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(9);
        list.add(3);
        list.add(7);
//        ArrayList<Integer> list2 = (ArrayList<Integer>) Collections.unmodifiableList(list);
//        list2.get(1);
//        list2.add(10);
        List<Integer> list2 = Collections.unmodifiableList(list);
        System.out.println(list2.get(1));
        list2.add(10);  //throws UnsupportedOperationException
        System.out.println(list);
    }
}
