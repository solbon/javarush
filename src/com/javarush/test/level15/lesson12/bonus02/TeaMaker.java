package com.javarush.test.level15.lesson12.bonus02;

/**
 * Created by solbon on 22.08.2014.
 */
public class TeaMaker extends DrinkMaker {
    public void getRightCup() {
        System.out.println("Берем чашку для чая");
    }
    public void putIngredient() {
        System.out.println("Насыпаем чай");
    }
    public void pour() {
        System.out.println("Заливаем водой");
    }
}