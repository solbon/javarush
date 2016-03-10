package com.javarush.test.level17.lesson10.home02;

/* Comparable
Реализуйте интерфейс Comparable<Beach> в классе Beach, который будет использоваться нитями.
*/


import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Beach implements Comparable<Beach> {
    private String name;      //название
    private float distance;   //расстояние
    private int quality;    //качество

//    private static List<Beach> list = new ArrayList<>();
//
//    public static void main(String[] args) {
//        Beach beach1 = new Beach("beach1", 123.6f, 7);
//        Beach beach2 = new Beach("beach2", 124.6f, 8);
//
//        Beach beach3 = new Beach("beach3", 124.6f, 8);
//
//        System.out.println(beach1.compareTo(beach2));
//        System.out.println(beach2.compareTo(beach3));
//        System.out.println(beach1.compareTo(beach3));

//        Beach beach1 = new Beach("beach1", 5.3f, 5);
//        Beach beach2 = new Beach("beach2", 1.5f, 2);
//        Beach beach3 = new Beach("beach3", 2.0f, 3);
//        Beach beach4 = new Beach("beach4", 1.5f, 3);
//        Beach beach5 = new Beach("beach5", 1.5f, 3);
//        System.out.println(beach1.compareTo(beach2));
//        System.out.println(beach2.compareTo(beach3));
//        System.out.println(beach4.compareTo(beach5));

//        list.add(beach5);
//        list.add(beach1);
//        list.add(beach2);
//        list.add(beach3);
//        list.add(beach4);
//
//
//        System.out.println(list);
//        Collections.sort(list);
//
//        System.out.println(list);
//    }
//
//    public String toString(){
//        return String.valueOf((int)(this.distance * 100) + quality);
//    }

    public synchronized int compareTo(Beach beach) {
        int xlevel = 10 * this.quality + (int)(100 * this.distance);
        int ylevel = 10 * beach.quality + (int)(100 * beach.distance);
        return 10000 * this.name.compareTo(beach.getName()) + (xlevel - ylevel);
    }

    public Beach(String name, float distance, int quality) {
        this.name = name;
        this.distance = distance;
        this.quality = quality;
    }

    public String getName() {
        return name;
    }

    public synchronized void setName(String name) {
        this.name = name;
    }

    public float getDistance() {
        return distance;
    }

    public synchronized void setDistance(float distance) {
        this.distance = distance;
    }

    public int getQuality() {
        return quality;
    }

    public synchronized void setQuality(int quality) {
        this.quality = quality;
    }
}
