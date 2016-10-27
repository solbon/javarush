package tests.test2;

import tests.test1.Test1;

/**
 * Created by solbon on 05.12.2014.
 */
//if I declare class Test1 as non public(package visibility), then I can't create Test1 object here in test2 package
public class Test2 {
    public static void main(String[] args) {
        int x = 256;
        byte b = (byte) x;
        System.out.println(b);

        Test1 ref = null;
//        ref.name = "Hello";
//        ref = new Test1();
        System.out.println(ref);
    }
}
