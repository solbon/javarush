package tests.OOP;

/**
 * Created by solbon on 25.11.2014.
 */
public class DynamicBinding {
    public static void main(String[] args) {
        A x = new C();
        x.doIt();
    }
}
class A {
    void doIt() {
        System.out.println("A");
    }


}
class B extends A {
    void doIt() {
        System.out.println("B");
    }
}
class C extends B{
    void doIt() {
        System.out.println("C");
    }
}
