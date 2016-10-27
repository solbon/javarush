package tests.Collections;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by solbon on 25.11.2014.
 */
public class MyIterator {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
//        list.remove(1); //throws IndexOutOfBoundsException
        System.out.println(list);
        Iterator<Integer> iterator = list.iterator();
//        iterator.remove();  //throws IllegalStateException
        iterator.next();
        iterator.remove();
//        iterator.remove(); //throws IllegalStateException
        System.out.println(list);
    }
}
