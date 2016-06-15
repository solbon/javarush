package tests.oop.inheritance;

/**
 * Created by sdaribazaron on 2016-04-05.
 */
public class TestClass{
    public static void main(String args[ ] ){
        A o1 = new C( );
        B o2 = (B) o1;
        C o3 = (C) o1;
        System.out.println(o1.m1( ) );
        System.out.println(o2.m1( ) );
        System.out.println(o3.m1( ) );
        System.out.println(o1.i );
        System.out.println(o2.i );
        System.out.println(o3.i );
    }
}
class A { int i = 10;  int m1( ) { return i; } }
class B extends A { int i = 20;  int m1() { return i; } }
class C extends B { int i = 30;  int m1() { return i; } }
