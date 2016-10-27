package tests.generics;

import java.util.List;
import java.util.Objects;

/**
 * Created by sdaribazaron on 2016-06-10.
 */
public class Box<T> {
    private T t;

    public T get() {
        return t;
    }

    public void set(T t) {
        this.t = t;
    }

    public <U extends Box> void inspect(U u) {
        System.out.println(t.getClass().getName());
        System.out.println(u.getClass().getName());
    }

//    public <? extends Number> void addNumber() {
//        return null;
//    }

    public static void main(String[] args) {
        Box<String> b = new Box<>();
        b.set("Hello world");
        System.out.println(b.get());

        Box<Integer> integerBox = new Box<>();
        integerBox.set(new Integer(5));
        integerBox.inspect(new Box());
    }
}


