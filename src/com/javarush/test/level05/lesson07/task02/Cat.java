package com.javarush.test.level05.lesson07.task02;

/* Создать класс Cat
Создать класс Cat (кот) с пятью инициализаторами:
- Имя,
- Имя, вес, возраст
- Имя, возраст (вес стандартный)
- вес, цвет, (имя, адрес и возраст неизвестны, это бездомный кот)
- вес, цвет, адрес ( чужой домашний кот)
Задача инициализатора – сделать объект валидным. Например, если вес неизвестен, то нужно указать какой-нибудь средний вес.
Кот не может ничего не весить. То же касательно возраста. А вот имени может и не быть (null). То же касается адреса: null.
*/

public class Cat
{
    //Напишите тут ваш код
    private String name;
    private int weight;
    private int age;
    private String color;
    private String address;

    public int default_weight = 5;
    public int default_age = 3;

    public void initialize(String name) {
        this.name = name;
        this.weight = default_weight;
        this.age = default_age;
        this.color = null;
        this.address = null;
    }

    public void initialize(String name, int age, int weight) {
        this.name = name;
        this.weight = weight;
        this.age = age;
        this.color = null;
        this.address = null;
    }

    public void initialize(String name, int age) {
        this.name = name;
        this.weight = default_weight;
        this.age = age;
        this.color = null;
        this.address = null;
    }

    public void initialize(int weight, String color) {
        this.name = null;
        this.weight = weight;
        this.age = default_age;
        this.color = color;
        this.address = null;
    }

    public void initialize(int weight, String color, String address) {
        this.name = null;
        this.weight = weight;
        this.age = default_age;
        this.color = color;
        this.address = address;
    }

}
