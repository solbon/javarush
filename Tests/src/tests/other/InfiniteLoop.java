package tests.other;

import java.util.Date;

/**
 * Created by solbon on 27.08.2014.
 */
public class InfiniteLoop {
    public static void main(String[] args) {
        System.out.println("Start");
        Date start = new Date();
        for (int i = 0; i < Integer.MAX_VALUE; i++) {
            int a = 0, b = 1;
            int c = a / b;
        }
        System.out.println("Stop");
        Date stop = new Date();
        long time = (long)(stop.getTime() - start.getTime());
        System.out.println(time);


    }
}
