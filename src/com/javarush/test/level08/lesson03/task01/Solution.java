package com.javarush.test.level08.lesson03.task01;

/* HashSet из растений
 Создать коллекцию HashSet с типом элементов String.
 Добавить в неё 10 строк: арбуз, банан, вишня, груша, дыня, ежевика, жень-шень, земляника, ирис, картофель.
 Вывести содержимое коллекции на экран, каждый элемент с новой строки.
 Посмотреть, как изменился порядок добавленных элементов.
 */

import java.util.HashSet;

public class Solution
{
	public static void main(String[] args) throws Exception
	{
		// Напишите тут ваш код
		HashSet<String> fruit = new HashSet<String>();
		fruit.add("арбуз");
		fruit.add("банан");
		fruit.add("вишня");
		fruit.add("груша");
		fruit.add("дыня");
		fruit.add("ежевика");
		fruit.add("жень-шень");
		fruit.add("земляника");
		fruit.add("ирис");
		fruit.add("картофель");

		for (String s : fruit) {
			System.out.println(s);
		}

	}
}
