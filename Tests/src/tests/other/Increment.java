package tests.other;

/**
 * Created by sdaribazaron on 2016-04-29.
 */
public class Increment {
    public static void main(String[] args) {
        int value = 0;
        int result = ++value + value++;
        System.out.println(result);
        System.out.println(calculate(3));
    }

    public static int calculate(int param) {
        return param % 2 == 1 ? param % 3 > 1 ? param + 1 : param - 1 : param;
    }
}
