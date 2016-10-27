package tests.oop.inheritance.b;

import tests.oop.inheritance.a.A;

/**
 * Created by sdaribazaron on 2016-04-07.
 */
public class B extends A {
    B(){ }
    public void  print(){ System.out.println("B"); }
    public static void main(String[] args){
        new B();
    }
}
