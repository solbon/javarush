package com.javarush.test.level14.lesson06.home01;

/**
 * Created by solbon on 15.08.2014.
 */
class BelarusianHen extends Hen {
    public int getCountOfEggsPerMonth(){
        return 10000;
    }
    public String getDescription() {
        return super.getDescription() + " Моя страна - "+Country.BELARUS+". Я несу " + getCountOfEggsPerMonth() +" яиц в месяц.";

    }
}
