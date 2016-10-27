package tests.init;

/**
 * @author Solbon Daribazaron <s.daribazaron@visiona.pl>
 */
public class YetMoreInitializationOrder {
    public static void main(String[] args) { }

    static void add(int num) { System.out.print(num + " "); }

    YetMoreInitializationOrder() { add(5); }

    { add(6); }

    { add(8); }

    static { new YetMoreInitializationOrder(); }

    static { add(2); }

    static { add(4); }
}