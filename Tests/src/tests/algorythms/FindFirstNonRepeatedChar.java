package tests.algorythms;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

/**
 * Created by solbon on 25.11.2014.
 */
public class FindFirstNonRepeatedChar {
    public static void main(String[] args) throws IOException {
        String s = "D:/1.txt";
        System.out.println(findFirstNonRepeatedChar(s));
    }

    static Character findFirstNonRepeatedChar(String filename) throws IOException {

        HashMap<Character, Boolean> table = new HashMap<>();    //HashMap with char and boolean: true - one time, false - more than one time occurence
        BufferedReader reader = new BufferedReader(new FileReader(filename));
        String line;


        /*Block of adding a-zA-Z chars into HashMap*/
        while ((line = reader.readLine()) != null) {
            char[] charsArray = line.toCharArray();
            for (char c : charsArray) {     //fill out hashmap table with chars and boolean flags: true if char happens ONLY one time, false - more than one time
                if ((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z')) {

                    if (table.get(c) == null) {
                        table.put(c, true);
                    } else
                        table.put(c, false);
                }
                else break;
            }
        }
        System.out.println(table);

        BufferedReader reader2 = new BufferedReader(new FileReader(filename));
        while ((line = reader2.readLine()) != null) {
            char[] charsArray = line.toCharArray();
            for (char c : charsArray) {
                if (table.get(c))
                    return c;
            }
        }

//        for (char c : charsArray) {
//            if (table.get(c))      //table.get(c) returns boolean value: true - if one time, false - if more than one time
//                return c;           //if we meet key (char c) with value 'true', we return this key (char c)
//        }

        return null;
    }
}
