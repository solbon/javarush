package com.javarush.test.level05.lesson07.task04;

/* Создать класс Circle
Создать класс (Circle) круг, с тремя инициализаторами:
- centerX, centerY, radius
- centerX, centerY, radius, width
- centerX, centerY, radius, width, color
*/

public class Circle
{
    //Напишите тут ваш код
    private int centerX;
    private int centerY;
    private int radius;
    private int width;
    private String color;

    public int def_width = 10;

    public void initialize(int centerX, int centerY, int radius) {
        this.centerX = centerX;
        this.centerY = centerY;
        this.radius = radius;
        this.width = def_width;
        this.color = null;
    }
    public void initialize(int centerX, int centerY, int radius, int width) {
        this.centerX = centerX;
        this.centerY = centerY;
        this.radius = radius;
        this.width = width;
        this.color = null;
    }
    public void initialize(int centerX, int centerY, int radius, int width, String color) {
        this.centerX = centerX;
        this.centerY = centerY;
        this.radius = radius;
        this.width = width;
        this.color = color;

    }

}
