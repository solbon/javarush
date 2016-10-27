package tests.oop;

/**
 * Created by solbon on 28.11.2014.
 */
public class StaticMethods {
    public static void main(String[] args) {
        B1 ref = new B1();
        ref.f();
    }
}

class AA1 {
    public int y = 10;
    public  int x(){
        return 10;
    }
    public void f() {
        System.out.println("AA1:" + x());
    }
}
class A1 extends AA1{
//    public static
//    public void f() {
//        System.out.println("A1:" + x());
//        System.out.println(y);
//    }
}
class B1 extends A1 {
    public  int x(){
        return 1;
    }

}
