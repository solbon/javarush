package tests.oop;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by solbon on 10.12.2014.
 */
public class Inheritance {
    public static void main(String[] args) {
        A a = new A();
        B b  = new B();
        A a2 = new B();
        Object o1 = new A();
        Object o2 = new B();
//        o1.f(); //Object o1 doesn't know about f() method, although object A() knows
        A a3 = (A) o1;
        a3.g();
        A a4 = (B) o2;
        a4.g();
        List<A> list = new ArrayList<>();
        list.add(new A());
        list.add(b);
        list.get(0).g();
        list.get(1).g();
        System.out.println(list.get(0).getClass());
        System.out.println(list.get(1).getClass());


//        a.f();  //A:f()
//        a.g();  //A:g()
//        b.f();  //A:f()
//        b.g();  //B:g()
//        a2.f(); //A:f()
//        a2.g(); //B:g() - if A wouldn't have g() , then this line would be compiled(we can't call function which is not defined in A, as a2 has type of A.
                // if B wouldn't have g(), then it would choose A:g()
//        System.out.println(new Object()); //it is possible to create new Object(), and it is used in synchro purposes
    }

    static class A {
        void f() {
            System.out.println("A:f()");
        }
        void g() {
            System.out.println("A:g()");
        }

    }

    static class B extends A {
        void g() {
            System.out.println("B:g()");
        }
    }
}

