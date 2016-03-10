package com.javarush.test.level19.lesson10.home06;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/* Замена чисел
 1. В статическом блоке инициализировать словарь map парами [число-слово] от 0 до 12 включительно
 Например, 0 - "ноль", 1 - "один", 2 - "два"
 2. Считать с консоли имя файла
 3. Заменить все числа на слова используя словарь map
 4. Результат вывести на экран
 5. Закрыть потоки. Не использовать try-with-resources

 Пример данных:
 Это стоит 1 бакс, а вот это - 12 .
 Переменная имеет имя file1.
 110 - это число.

 Пример вывода:
 Это стоит один бакс, а вот это - двенадцать .
 Переменная имеет имя file1.
 110 - это число.
 */

public class Solution {
	public static Map<Integer, String> map = new HashMap<Integer, String>();

	static {
		map.put(0, "ноль");
		map.put(1, "один");
		map.put(2, "два");
		map.put(3, "три");
		map.put(4, "четыре");
		map.put(5, "пять");
		map.put(6, "шесть");
		map.put(7, "семь");
		map.put(8, "восемь");
		map.put(9, "девять");
		map.put(10, "десять");
		map.put(11, "одиннадцать");
		map.put(12, "двенадцать");
	}

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		BufferedReader fileReader = new BufferedReader(new InputStreamReader(new FileInputStream(reader.readLine())));
		String line;
		while ((line = fileReader.readLine()) != null) {
			String[] strings = line.split(" ");
			for (String s : strings) {
				try {
					int i = Integer.parseInt(s);
					if (i >= 0 && i <= 12) {
						System.out.print(map.get(i) + " ");
					} else {
						System.out.print(i + " ");
					}
				} catch (NumberFormatException e) {
					System.out.print(s + " ");
				}
			}
			System.out.println();
		}
		fileReader.close();
		reader.close();
	}
}
