package tests.OOP;

/**
 * Created by solbon on 26.11.2014.
 */
public class InnerClassPrivateAccess {
    private static int i = 10;
    private static int getI() {
        return i;
    }

    public static void main(String[] args) {
        int a = InnerClass.x;
        System.out.println(a);
    }

    static class InnerClass {
        static int x = i;
    }
}
