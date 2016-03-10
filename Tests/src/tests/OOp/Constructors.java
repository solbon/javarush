package tests.OOP;

/**
 * Created by solbon on 10.12.2014.
 */
public class Constructors {
    public static void main(String[] args) {
        new A(1);
        new B(2);
    }

    static class A {
        int a;
        A() {
            super();    //this super() will call constructor of Object
            System.out.println("A()");
        }
        A(int a) {
            this();
            this.a = a;
            System.out.println("A(int):" + this.a);
        }
    }
    static class B extends A{
        int b;
        B(int b) {
//            super();
            super(b);
            this.b = b;
            System.out.println("B(int):" + this.b);
        }
    }
}
