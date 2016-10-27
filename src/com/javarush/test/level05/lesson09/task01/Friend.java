package com.javarush.test.level05.lesson09.task01;

/* Создать класс Friend
Создать класс Friend (друг) с тремя конструкторами:
- Имя
- Имя, возраст
- Имя, возраст, пол
*/

public class Friend
{
    //Напишите тут ваш код
    private String name;
    private int age;
    private char sex;

//    public Friend(String sname){
//        name = sname;
//    }
    public Friend(String sname, int sage){
        name = sname;
        age = sage;
    }
    public Friend(String sname, int sage, char ssex){
        name = sname;
        age = sage;
        sex = ssex;
    }

    public Friend(String name) {
        this.name = name;
    }
}