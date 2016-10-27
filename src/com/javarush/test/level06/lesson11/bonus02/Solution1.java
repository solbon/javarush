package com.javarush.test.level06.lesson11.bonus02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* Нужно добавить в программу новую функциональность
Задача: У каждой кошки есть имя и кошка-мама. Создать класс, который бы описывал данную ситуацию.
Создать два объекта: кошку-дочь и кошку-маму. Вывести их на экран.
Новая задача: У каждой кошки есть имя, кошка-папа и кошка-мама. Изменить класс Cat так, чтобы он мог описать данную ситуацию.
Создать 6 объектов: маму, папу, сына, дочь, бабушку(мамина мама) и дедушку(папин папа).
Вывести их всех на экран в порядке: дедушка, бабушка, папа, мама, сын, дочь.

Пример ввода:
дедушка Вася
бабушка Мурка
папа Котофей
мама Василиса
сын Мурчик
дочь Пушинка

Пример вывода:
Cat name is дедушка Вася, no mother, no father
Cat name is бабушка Мурка, no mother, no father
Cat name is папа Котофей, no mother, father is дедушка Вася
Cat name is мама Василиса, mother is бабушка Мурка, no father
Cat name is сын Мурчик, mother is мама Василиса, father is папа Котофей
Cat name is дочь Пушинка, mother is мама Василиса, father is папа Котофей
*/

public class Solution1
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String gfName = br.readLine();
        String gmName = br.readLine();
        String fName = br.readLine();
        String mName = br.readLine();
        String sName = br.readLine();
        String dName = br.readLine();

        Cat gf = new Cat(gfName, null, null);
        Cat gm = new Cat(gmName, null, null);
        Cat f = new Cat(fName, gf, null);
        Cat m = new Cat(mName, null, gm);
        Cat s = new Cat(sName, f, m);
        Cat d = new Cat(dName, f, m);
        System.out.println(gf);
        System.out.println(gm);
        System.out.println(f);
        System.out.println(m);
        System.out.println(s);
        System.out.println(d);
    }

    public static class Cat
    {
        private String name;
        private Cat father;
        private Cat mother;

        Cat(String name, Cat father, Cat mother)
        {
            this.name = name;
            this.father = father;
            this.mother = mother;
        }

        @Override
        public String toString()
        {
            return "Cat name is " + name +
                    (mother != null ? ", mother is " + mother.name : ", no mother") +
                    (father != null ? ", father is " + father.name : ", no father");
        }
    }
}
