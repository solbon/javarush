package tests.oop.inheritance;

import java.util.Random;

/**
 * Created by sdaribazaron on 2016-04-12.
 */
class TestClass2 implements I1, I2{
    public void m1() { System.out.println("Hello"); }
    public static void main(String[] args){
        TestClass2 tc = new TestClass2();
        tc.m1();
//        System.out.println(I2.VALUE); // can't call System.out.println(VALUE); as it is ambiguous, both I1.VALUE and I2.VALUE match
        for (int i = 0; i < 10; i++) {
            System.out.println(randInt(5, 10));
        }
    }

    static int randInt(int min, int max) {
        return min + new Random().nextInt(max - min + 1);
    }

}
interface I1{
    int VALUE = 1;
    void m1();
}
interface I2{
    int VALUE = 2;
    void m1();
}