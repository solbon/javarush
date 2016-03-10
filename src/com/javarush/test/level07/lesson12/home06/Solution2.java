package com.javarush.test.level07.lesson12.home06;

/* Семья
Создай класс Human с полями имя(String), пол(boolean),возраст(int), отец(Human), мать(Human).
Создай объекты и заполни их так, чтобы получилось: Два дедушки, две бабушки, отец, мать, трое детей. Вывести объекты на экран.
Примечание:
Если написать свой метод String toString() в классе Human, то именно он будет использоваться при выводе объекта на экран.
Пример вывода:
Имя: Аня, пол: женский, возраст: 21, отец: Павел, мать: Катя
Имя: Катя, пол: женский, возраст: 55
Имя: Игорь, пол: мужской, возраст: 2, отец: Михаил, мать: Аня
…
*/

public class Solution2
{
    public static void main(String[] args)
    {
        //Написать тут ваш код
        Human Gena = new Human("Gena", true, 55);
        Human Oleg = new Human("Oleg", true, 53);
        Human Sveta = new Human("Sveta", false, 54);
        Human Luda = new Human("Luda", false, 52);
        Human Sol = new Human("Sol", true, 32, Gena, Sveta);
        Human Ala = new Human("Ala", false, 29, Oleg, Luda);
        Human Aldar = new Human("Aldar", true, 2, Sol, Ala);
        Human Maria = new Human("Maria", false, 1, Sol, Ala);
        Human Maria2 = new Human("Maria2", false, 1, Sol, Ala);

        System.out.println(Gena);
        System.out.println(Oleg);
        System.out.println(Sveta);
        System.out.println(Luda);
        System.out.println(Sol);
        System.out.println(Ala);
        System.out.println(Aldar);
        System.out.println(Maria);
        System.out.println(Maria2);


    }

    public static class Human
    {
        //Написать тут ваш код
        private String name;
        private boolean sex;
        private int age;
        private Human father;
        private Human mother;

        public Human(String name, boolean sex, int age, Human father, Human mother) {
            this.name = name;
            this.sex = sex;
            this.age = age;
            this.father = father;
            this.mother = mother;
        }

        public Human(String name, boolean sex, int age) {
            this.name = name;
            this.sex = sex;
            this.age = age;
        }

        public String toString()
        {
            String text = "";
            text += "Имя: " + this.name;
            text += ", пол: " + (this.sex ? "мужской" : "женский");
            text += ", возраст: " + this.age;

            if (this.father != null)
                text += ", отец: " + this.father.name;

            if (this.mother != null)
                text += ", мать: " + this.mother.name;

            return text;
        }
    }

}
