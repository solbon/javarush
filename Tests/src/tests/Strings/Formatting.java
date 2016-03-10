package tests.Strings;

/**
 * Created by solbon on 12.12.2014.
 */
public class Formatting {
    public static void main(String[] args) {
        System.out.printf("Hello world, %,d,!%n", 97413412);
        System.out.printf("%-15s%-10s%n", "hello world", "this is text");
        System.out.printf("%,-5d %-,1d", 12341234, 9939134);
    }
}
