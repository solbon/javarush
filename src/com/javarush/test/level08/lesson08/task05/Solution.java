package com.javarush.test.level08.lesson08.task05;

import java.util.*;

/* Удалить людей, имеющих одинаковые имена
Создать словарь (Map<String, String>) занести в него десять записей по принципу «фамилия» - «имя».
Удалить людей, имеющих одинаковые имена.
*/

public class Solution
{
    public static void main(String[] args) {
        HashMap<String,String> map = createMap();
        removeTheFirstNameDuplicates(map);
        System.out.println(map);
        System.out.println(map.size());
    }

    public static HashMap<String, String> createMap()
    {
        //Напишите тут ваш код
        HashMap<String, String> map = new HashMap<String, String>();
        map.put("Ivanov", "Vanya");
        map.put("Ivanova", "Manya");
        map.put("Kuznetsov", "Vanya");
        map.put("Ilin", "Vanya");
        map.put("Petrov", "Ivan");
        map.put("Sidorov", "Oleg");
        map.put("Nikitin", "Oleg");
        map.put("Kopov", "Petya");
        map.put("Kotov", "Dima");
        map.put("Putin", "Vova");

        return map;
    }

    public static void removeTheFirstNameDuplicates(HashMap<String, String> map)
    {
        //Напишите тут ваш код
        Set<String> set = new HashSet<String>();
        Set<String> duplicated = new HashSet<String>();

        for (Map.Entry<String, String> pair: map.entrySet()) {
            String name = pair.getValue();
            if (set.contains(name)) {
                duplicated.add(name);
            } else {
                set.add(name);
            }
        }

        for (String s : duplicated) {
            removeItemFromMapByValue(map, s);
        }

    }

    public static void removeItemFromMapByValue(HashMap<String, String> map, String value)
    {
        HashMap<String, String> copy = new HashMap<String, String>(map);
        for (Map.Entry<String, String> pair: copy.entrySet())
        {
            if (pair.getValue().equals(value))
                map.remove(pair.getKey());
        }
    }
}

