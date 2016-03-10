package tests.OOP;

/**
 * Created by solbon on 21.11.2014.
 */
public class App01 {

    public static void main(String[] args) {
        X1 ref = new Y1();
    }
}

class X1 {
    X1() {
        System.out.println("X1()");
        init();
    }
    void init() {
        System.out.println("X1 .init()");
    }
}

class Y1 extends X1 {
    Y1() {
        System.out.println("Y1()");
//        super.init();
    }
    void init(){
        System.out.println("Y1.init()");
    }
}


