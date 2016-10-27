package com.javarush.test.level10.lesson11.home06;

/* Конструкторы класса Human
Напиши класс Human с 6 полями. Придумай и реализуй 10 различных конструкторов для него. Каждый конструктор должен иметь смысл.
*/

public class Solution
{
    public static void main(String[] args)
    {

    }

    public static class Human
    {
        //напишите тут ваши переменные и конструкторы
        private String name;
        private String surname;
        private String nickname;
        private int age;
        private boolean sex;
        private boolean married;

        public Human(String name) {
            this.name = name;
        }

        public Human(String name, String surname) {
            this.name = name;
            this.surname = surname;
        }

        public Human(String name, String surname, String nickname) {
            this.name = name;
            this.surname = surname;
            this.nickname = nickname;
        }

        public Human(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public Human(int age, boolean sex, String name) {
            this.age = age;
            this.sex = sex;
            this.name = name;
        }

        public Human(String name, String nickname, boolean sex, boolean married) {
            this.name = name;
            this.nickname = nickname;
            this.sex = sex;
            this.married = married;
        }

        public Human(boolean married, boolean sex, int age) {
            this.married = married;
            this.sex = sex;
            this.age = age;
        }

        public Human(String name, String surname, String nickname, int age, boolean sex, boolean married) {
            this.name = name;
            this.surname = surname;
            this.nickname = nickname;
            this.age = age;
            this.sex = sex;
            this.married = married;
        }

        public Human(String name, String surname, String nickname, int age, boolean sex) {
            this.name = name;
            this.surname = surname;
            this.nickname = nickname;
            this.age = age;
            this.sex = sex;
        }

        public Human(String name, String surname, String nickname, boolean sex, boolean married) {
            this.name = name;
            this.surname = surname;
            this.nickname = nickname;
            this.sex = sex;
            this.married = married;
        }
    }
}
