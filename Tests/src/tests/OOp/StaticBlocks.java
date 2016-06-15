package tests.oop;

/**
 * Created by solbon on 17.12.2014.
 */
public class StaticBlocks {
    static {
        System.out.println("parent static block");
    }
    StaticBlocks() {
        System.out.println("constructor StaticBlocks");
    }
}

class StaticChild extends StaticBlocks {
    static int rand;
    static {
        rand = (int) (Math.random() * 5);
        System.out.println("child static block: rand = " + rand);
    }
    StaticChild() {
        System.out.println("constructor StaticChild");
    }

    static void printHello() {
        System.out.println("Hello!");
    }

    public static void main(String[] args) {
        System.out.println("inside main()");
        new StaticChild().printHello();
    }


}
