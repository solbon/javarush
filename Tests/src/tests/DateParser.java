package tests;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by solbon on 04.09.2014.
 */
public class DateParser {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.y");

        String dateString;
        while ((dateString = reader.readLine()) != null) {
            if (dateString.equals("q"))
                    break;
            try {
                Date date = new Date();
                date = dateFormat.parse(dateString);
                System.out.println(date);
            } catch (ParseException e) {
                System.out.println("ParseException. Try again...");
            }
        }
    }
}
