package com.javarush.test.level08.lesson11.home06;

/* Вся семья в сборе
1. Создай класс Human с полями имя (String), пол (boolean), возраст (int), дети (ArrayList<Human>).
2. Создай объекты и заполни их так, чтобы получилось: два дедушки, две бабушки, отец, мать, трое детей.
3. Вывести все объекты Human на экран.
*/

import java.util.ArrayList;

public class Solution
{
    public static void main(String[] args)
    {
        //Написать тут ваш код
        ArrayList<Human> childrenMom = new ArrayList<>();
        ArrayList<Human> childrenDad = new ArrayList<>();
        ArrayList<Human> childrenChild = new ArrayList<>();

        Human dedOleg = new Human("ded Oleg", true, 55, childrenMom);
        Human babaLuda = new Human("baba Luda", false, 53, childrenMom);
        Human dedGena = new Human("ded Gena", true, 56, childrenDad);
        Human babaSveta = new Human("baba Sveta", false, 54, childrenDad);
        Human papaSol = new Human("papa Sol", true, 32, childrenChild);
        Human mamaAla = new Human("mama Ala", false, 28, childrenChild);
        Human sonAldar = new Human("Aldar", true, 2, null);
        Human dochaMasha = new Human("Masha", false, 1, null);
        Human sonNext = new Human("Boris", true, 4, null);


        childrenDad.add(papaSol);
        childrenMom.add(mamaAla);
        childrenChild.add(sonAldar);
        childrenChild.add(dochaMasha);
        childrenChild.add(sonNext);


        System.out.println(dedGena);
        System.out.println(dedOleg);
        System.out.println(babaSveta);
        System.out.println(babaLuda);
        System.out.println(papaSol);
        System.out.println(mamaAla);
        System.out.println(sonAldar);
        System.out.println(dochaMasha);
        System.out.println(sonNext);

    }

    public static class Human
    {
        //Написать тут ваш код
        private String name;
        private boolean sex;
        private int age;
        private ArrayList<Human> children;

        public Human(String name, boolean sex, int age, ArrayList<Human> children) {
            this.name = name;
            this.sex = sex;
            this.age = age;
            this.children = children;
        }

        public Human(String name, boolean sex, int age) {
            this.name = name;
            this.sex = sex;
            this.age = age;
            this.children = null;
        }

        public String toString()
        {
            String text = "";
            text += "Имя: " + this.name;
            text += ", пол: " + (this.sex ? "мужской" : "женский");
            text += ", возраст: " + this.age;

            int childCount = 0;

            if (!(this.children == null))
            {

                childCount = this.children.size();}

            if (childCount > 0)
            {
                text += ", дети: "+this.children.get(0).name;

                for (int i = 1; i < childCount; i++)
                {
                    Human child = this.children.get(i);
                    text += ", "+child.name;
                }
            }

            return text;
        }
    }

}
