package tests.OOP;

/**
 * Created by solbon on 05.12.2014.
 */
public class ReturnTypes {
    static char c;
    static int i;
    static boolean b;
    public static void main(String[] args) {
//        System.out.println(f());
        System.out.println("c=" + c);
        System.out.println(i);
        System.out.println(b);
    }

    static int f() {
        byte b = 10;
        long l = 2_000_000_000;
        return (int) l;
    }
}
