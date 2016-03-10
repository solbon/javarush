package com.javarush.test.level15.lesson12.bonus02;

/**
 * Created by solbon on 22.08.2014.
 */
public abstract class DrinkMaker {
    public abstract void getRightCup();
    public abstract void putIngredient();
    public abstract void pour();

    public void makeDrink() {
        getRightCup();
        putIngredient();
        pour();
    }
}
