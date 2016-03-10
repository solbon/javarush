package tests.OOP;


import java.util.HashSet;

public class App00 {
    public static void main(String[] args) {
//    ChildPoint childPoint = new ChildPoint();
//        X x = new X();
        try {
            X x = new X();
        } catch (Error e) {
        };
        try {
            X x1 = new X();
        } catch (Error e) {
        };
        X x1 = new X();
        new Object();
        new HashSet();

    }
}

class Point {
    int x;
    int y;
}

class ChildPoint extends Point {
    String x;
    String y;
}

class X {
    static  {
        System.err.println("static");
        if (true) throw new Error();
    }
}
