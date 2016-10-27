package tests.ClassLoader;

import java.util.MissingResourceException;
import java.util.ResourceBundle;
import java.util.Set;

/**
 * Created by sdaribazaron on 2016-03-08.
 */
public class ResBundle {
    public static void main(String[] args) {
        ResourceBundle bundle = ResourceBundle.getBundle("errors");
        Set<String> keys = bundle.keySet();
//        for (String key : keys) {
//            if (keys.contains(key)) {
//                System.out.println(key + (key.length() == 2 ? "\t\t" : "\t") + bundle.getString(key));
//            }
//        }


        try {
            System.out.println("01: " + bundle.getString("ZZ"));
        } catch (MissingResourceException e) {
            System.out.println(e.getMessage());
        }
    }
}
