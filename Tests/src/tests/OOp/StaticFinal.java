package tests.oop;

/**
 * Created by solbon on 11.12.2014.
 */
public class StaticFinal {
      int x = 12;
      static void f(final int x) {
        System.out.println(x);
    }

    public static void main(String[] args) {
        System.out.println(Math.round(2.55));
        System.out.println(Math.round(2.50));
        System.out.println(Math.round(2.49));
        System.out.println(Math.min(1, 2.1));

		PackageModifier.printA(100_000);

    }

}
