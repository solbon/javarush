package tests.oop;

/**
 * Created by solbon on 25.11.2014.
 */
public class DynamicBinding {
    public static void main(String[] args) {
        tests.oop.A x = new tests.oop.C();
        x.doIt();
    }
}
class A {
    void doIt() {
        System.out.println("A");
    }


}
class B extends tests.oop.A {
    void doIt() {
        System.out.println("B");
    }
}
class C extends tests.oop.B {
    void doIt() {
        System.out.println("C");
    }
}
