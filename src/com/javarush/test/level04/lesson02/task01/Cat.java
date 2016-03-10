package com.javarush.test.level04.lesson02.task01;

/* Реализовать метод setName
Реализовать метод setName, чтобы с его помощью можно было устанавливать значение переменной private String name равное переданному параметру String name.
*/

public class Cat {
    private String name;

    public void setName(String name1) {
        //add your code here
        name = name1;
    }

    public static void main(String[] args) {
        Cat cat1 = new Cat();
        cat1.setName("Vaska");
//        cat1.name = "Vaska";
        System.out.println("Cat's name is " + cat1.name);
    }
}
