package tests.Pattern;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by sdaribazaron on 2016-04-13.
 */
public class RegexTestHarness {

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            System.out.print("Enter your regex: ");
            Pattern pattern = Pattern.compile(reader.readLine());
            System.out.print("Enter input string to search: ");
            Matcher matcher = pattern.matcher(reader.readLine());

            boolean found = false;
            while (matcher.find()) {
                System.out.format("I found the text \"%s\" starting at index %d and ending at index %d.%n",
                        matcher.group(),
                        matcher.start(),
                        matcher.end());
                found = true;
            }
            if(!found){
                System.out.format("No match found.%n");
            }
        }
    }
}