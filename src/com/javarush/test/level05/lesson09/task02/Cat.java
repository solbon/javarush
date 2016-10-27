package com.javarush.test.level05.lesson09.task02;

/* Создать класс Cat
Создать класс Cat (кот) с пятью конструкторами:
- Имя,
- Имя, вес, возраст
- Имя, возраст (вес стандартный)
- вес, цвет, (имя, адрес и возраст – неизвестные. Кот - бездомный)
- вес, цвет, адрес ( чужой домашний кот)
Задача инициализатора – сделать объект валидным. Например, если вес не известен, то нужно указать какой-нибудь средний вес.
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

    private int def_weight = 10;
    private int def_age = 5;


    public Cat(String name) {
        this.name = name;
        this.age = def_age;
        this.weight = def_weight;
        this.color = null;
        this.address = null;
    }
    public Cat(String name, int age, int weight) {
        this.name = name;
        this.age = age;
        this.weight = weight;
        this.color = null;
        this.address = null;
    }
    public Cat(int weight, String color) {
        this.name = null;
        this.age = def_age;
        this.weight = weight;
        this.color = color;
        this.address = null;
    }
    public Cat(String name, int age) {
        this.name = name;
        this.age = age;
        this.weight = def_weight;
        this.color = null;
        this.address = null;
    }
    public Cat(int weight, String color, String address) {
        this.name = null;
        this.age = def_age;
        this.weight = weight;
        this.color = color;
        this.address = address;
    }


}
