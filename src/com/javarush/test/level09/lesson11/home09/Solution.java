package com.javarush.test.level09.lesson11.home09;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* Десять котов
Создать класс кот – Cat, с полем «имя» (String).
Создать словарь Map(<String, Cat>) и добавить туда 10 котов в виде «Имя»-«Кот».
Получить из Map множество(Set) всех имен и вывести его на экран.
*/

public class Solution
{
    public static void main(String[] args)
    {
        Map<String, Cat> map = createMap();
        Set<Cat> set = convertMapToSet(map);
        printCatSet(set);
    }

    public static Map<String, Cat> createMap()
    {
        //Напишите тут ваш код
        Map<String, Cat> map = new HashMap<String, Cat>();
        Cat vaska = new Cat("Vaska");
        Cat murzik = new Cat("Murzik");
        Cat kisa = new Cat("KisaWow");
        Cat kisa1 = new Cat("Kisa1");
        Cat kisa2 = new Cat("Kisa2");
        Cat kisa3 = new Cat("KisaWow3");
        Cat kisa4 = new Cat("KisaWow4");
        Cat kisa5 = new Cat("KisaWow5");
        Cat kisa6 = new Cat("KisaWow6");
        Cat kisa7 = new Cat("KisaWow7");
        map.put(vaska.name, vaska);
        map.put(murzik.name, murzik);
        map.put(kisa.name, kisa);
        map.put(kisa1.name, kisa1);
        map.put(kisa2.name, kisa2);
        map.put(kisa3.name, kisa3);
        map.put(kisa4.name, kisa4);
        map.put(kisa5.name, kisa5);
        map.put(kisa6.name, kisa6);
        map.put(kisa7.name, kisa7);
        return map;
    }

    public static Set<Cat> convertMapToSet(Map<String, Cat> map)
    {
        //Напишите тут ваш код
        Set<Cat> set = new HashSet<Cat>();
        for (Map.Entry<String, Cat> pair : map.entrySet()) {
            set.add(pair.getValue());
        }

        return set;
    }

    public static void printCatSet(Set<Cat> set)
    {
        for (Cat cat:set)
        {
            System.out.println(cat);
        }
    }

    public static class Cat
    {
        private String name;

        public Cat(String name)
        {
            this.name = name;
        }

        public String toString()
        {
            return "Cat "+this.name;
        }
    }


}
