package tests.polymorphism;

/**
 * Created by solbon on 28.07.2014.
 */
public class Circle extends Shape{
    public void draw() {
        System.out.println("Circle.draw()");
    }
    public void erase() {System.out.println("Circle.erase()");}
}
