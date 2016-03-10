package com.javarush.test.level15.lesson12.home05;

/**
 * Created by solbon on 21.08.2014.
 */
public class SubSolution extends Solution {
    private SubSolution(int f) {
        super(f);
    }

    private SubSolution(double d) {
        super(d);
    }

    private SubSolution(float f) {
        super(f);
    }

    protected SubSolution(Integer i) {
        super(i);
    }

    protected SubSolution(Double d) {
        super(d);
    }

    protected SubSolution(Float f) {
        super(f);
    }

    SubSolution(int i, int j) {
        super(i, j);
    }

     SubSolution(int i, double j) {
        super(i, j);
    }

     SubSolution(int i, float j) {
        super(i, j);
    }

    public SubSolution(String s) {
        super(s);
    }

    public SubSolution(Object o) {
        super(o);
    }

    public SubSolution(Short s) {
        super(s);
    }
}
