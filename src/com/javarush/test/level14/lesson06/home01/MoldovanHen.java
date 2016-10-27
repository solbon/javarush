package com.javarush.test.level14.lesson06.home01;

/**
 * Created by solbon on 15.08.2014.
 */
class MoldovanHen extends Hen {
    public int getCountOfEggsPerMonth(){
        return 10;
    }
    public String getDescription() {
        return super.getDescription() + " Моя страна - "+Country.MOLDOVA+". Я несу " + getCountOfEggsPerMonth() +" яиц в месяц.";

    }
}