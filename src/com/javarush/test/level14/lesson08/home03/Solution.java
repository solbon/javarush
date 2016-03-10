package com.javarush.test.level14.lesson08.home03;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* User, Looser, Coder and Proger
1. Ввести [в цикле] с клавиатуры несколько строк (ключей).
Строки(ключи) могут быть такими: "user", "looser", "coder", "proger".
Ввод окончен, когда строка не совпадает ни с одной из выше указанных.

2. Для каждой введенной строки нужно:
2.1. Создать соответствующий объект [см Person.java], например, для строки "user" нужно создать объект класса User.
2.2. Передать этот объект в метод doWork.

3. Написать реализацию метода doWork, который:
3.1. Вызывает метод live() у переданного обекта, если этот объект (person) имеет тип User.
3.2. Вызывает метод doNothing(), если person имеет тип Looser.
3.3. Вызывает метод coding(), если person имеет тип Coder.
3.4. Вызывает метод enjoy(), если person имеет тип Proger.
*/

public class Solution implements Person
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Person person = null;
        String key = null;

        //тут цикл по чтению ключей, пункт 1
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("user");
        arrayList.add("looser");
        arrayList.add("coder");
        arrayList.add("proger");

        while (arrayList.contains(key = reader.readLine()))
        {
        //создаем объект, пункт 2
            if (key.equals("user"))
               person = new User();
            else if (key.equals("looser"))
                person = new Looser();
            else if (key.equals("coder"))
                person = new Coder();
            else if (key.equals("proger"))
                person = new Proger();

        doWork(person); //вызываем doWork

        }
    }

    public static void doWork(Person person)
    {
        // пункт 3
        if (person instanceof User)
            ((User) person).live();
        else if (person instanceof Looser)
            ((Looser) person).doNothing();
        else if (person instanceof Coder)
            ((Coder) person).coding();
        else if (person instanceof Proger)
            ((Proger) person).enjoy();
    }
}
