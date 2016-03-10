package tests.OOP;

/**
 * Created by solbon on 08.12.2014.
 */
public class App02 {
    public static void main(String[] args) {
        A01 ref = new B01();
        ref.f(5);
    }
}

class A01 {
    int f(int a){
        System.out.println("A01");
        return 1;
    }
}

class B01 extends A01 {
    int f(int a) {
        System.out.println("B01");
        return 1;
    }
}