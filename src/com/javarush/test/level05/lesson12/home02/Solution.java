package com.javarush.test.level05.lesson12.home02;

/* Man and Woman
1. Внутри класса Solution создай public static классы Man и Woman.
2. У классов должны быть поля: name(String), age(int), address(String).
3. Создай конструкторы, в которые передаются все возможные параметры.
4. Создай по два объекта каждого класса со всеми данными используя конструктор.
5. Объекты выведи на экран в таком формате [name + " " + age + " " + address].
*/

public class Solution
{
    public static void main(String[] args)
    {
        // Создай по два объекта каждого класса тут
        Man man1 = new Man("Max", 22, "London, Traffalgar sqr 1");
        Man man2 = new Man("Peter", 33, "Prague, Lublanska 10");
        Woman woman1 = new Woman("Lily", 18, "Paris, le Rua 8");
        Woman woman2 = new Woman("Masha", 21, "Moscow, ul. Obrucheva 8/1 kv 51");


        // Выведи их на экран тут
//        man1.print();
//        man2.print();
//        woman1.print();
//        woman2.print();
        System.out.println(man1);
        System.out.println(man2);
        System.out.println(woman1);
        System.out.println(woman2);
    }

    // Напиши тут свои классы
    public static class Man {
        private String name;
        private int age;
        private String address;

//        public int def_age = 30;


        public Man() {
            this.name = null;
//            this.age = def_age;
            this.address = null;
        }
        public Man(String name) {
            this.name = name;
//            this.age = def_age;
            this.address = null;
        }
        public Man(String name, int age) {
            this.name = name;
            this.age = age;
            this.address = null;
        }
        public Man(String name, int age, String address) {
            this.name = name;
            this.age = age;
            this.address = address;
        }

        public Man(int age) {
            this.age = age;
        }

        public Man(int age, String address) {

            this.age = age;
            this.address = address;
        }

        public Man(String name, String address) {

            this.name = name;
            this.address = address;
        }
        //        public void print() {
//            System.out.println(name + " " + age + " " + address);
//        }

        public String toString() {
            return name + " " + age + " " + address;
        }
    }
    public static class Woman {
        private String name;
        private int age;
        private String address;

//        public int def_age = 30;


        public Woman() {
            this.name = null;
//            this.age = def_age;
            this.address = null;
        }
        public Woman(String name) {
            this.name = name;
//            this.age = def_age;
            this.address = null;
        }
        public Woman(String name, int age) {
            this.name = name;
            this.age = age;
            this.address = null;
        }
        public Woman(String name, int age, String address) {
            this.name = name;
            this.age = age;
            this.address = address;
        }

        public Woman(int age) {
            this.age = age;
        }

        public Woman(int age, String address) {

            this.age = age;
            this.address = address;
        }

        public Woman(String name, String address) {

            this.name = name;
            this.address = address;
        }
        //        public void print() {
//            System.out.println(name + " " + age + " " + address);
//        }

        public String toString() {
            return name + " " + age + " " + address;
        }
    }

}
