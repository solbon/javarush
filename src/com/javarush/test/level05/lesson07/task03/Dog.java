package com.javarush.test.level05.lesson07.task03;

/* Создать класс Dog
Создать класс Dog (собака) с тремя инициализаторами:
- Имя
- Имя, рост
- Имя, рост, цвет
*/

public class Dog
{
    //Напишите тут ваш код
    private String name;
    private int height;
    private String color;

    public int def_height = 50;

    public void initialize(String name) {
        this.name = name;
        this.height = def_height;
        this.color = null;
    }
    public void initialize(String name, int height) {
        this.name = name;
        this.height = height;
        this.color = null;
    }
    public void initialize(String name, int height, String color) {
        this.name = name;
        this.height = height;
        this.color = color;
    }

}
