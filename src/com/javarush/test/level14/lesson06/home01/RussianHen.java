package com.javarush.test.level14.lesson06.home01;

/**
 * Created by solbon on 15.08.2014.
 */
public class RussianHen extends Hen {

    public int getCountOfEggsPerMonth(){
        return 1000;
    }
    public String getDescription() {
        return super.getDescription() + " Моя страна - "+Country.RUSSIA+". Я несу " + getCountOfEggsPerMonth() +" яиц в месяц.";
    }
}
