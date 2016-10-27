package com.javarush.test.level08.lesson08.task04;

import java.util.*;

/* Удалить всех людей, родившихся летом
Создать словарь (Map<String, Date>) и занести в него десять записей по принципу: «фамилия» - «дата рождения».
Удалить из словаря всех людей, родившихся летом.
*/

public class Solution
{
    public static void main(String[] args) {
        HashMap map = createMap();
        removeAllSummerPeople(map);

        System.out.println(map);
    }

    public static HashMap<String, Date> createMap()
    {
        HashMap<String, Date> map = new HashMap<String, Date>();
        map.put("Сталлоне", new Date("JUNE 1 1980"));

        //Напишите тут ваш код
        map.put("Иванов", new Date("JUNE 5 1980"));
        map.put("Петров", new Date("MAY 1 1986"));
        map.put("Сидоров", new Date("APRIL 13 1960"));
        map.put("Кузнецов", new Date("AUGUST 13 1982"));
        map.put("Путин", new Date("JUNE 11 1980"));
        map.put("Медведев", new Date("JUNE 16 1980"));
        map.put("Обама", new Date("JULY 1 1990"));
        map.put("Шандыбин", new Date("MAY 13 1980"));
        map.put("Жириновский", new Date("SEPTEMBER 1 1980"));

        return map;
    }

    public static void removeAllSummerPeople(HashMap<String, Date> map)
    {
        //Напишите тут ваш код
        Set set = map.entrySet();
        Iterator <Map.Entry<String, Date>> iterator = set.iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, Date> entry = iterator.next();
            int month = entry.getValue().getMonth();

            if (month == 5 || month == 6 || month == 7)
                iterator.remove();
        }

    }
}
