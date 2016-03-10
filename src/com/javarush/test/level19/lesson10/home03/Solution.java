package com.javarush.test.level19.lesson10.home03;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/* Хуан Хуанович
 В метод main первым параметром приходит имя файла.
 В этом файле каждая строка имеет следующий вид:
 имя день месяц год
 где [имя] - может состоять из нескольких слов, разделенных пробелами, и имеет тип String
 [день] - int, [месяц] - int, [год] - int
 данные разделены пробелами

 Заполнить список PEOPLE импользуя данные из файла
 Закрыть потоки. Не использовать try-with-resources

 Пример входного файла:
 Иванов Иван Иванович 31 12 1987
 Вася 15 5 2013
 */

public class Solution {
	public static final List<Person> PEOPLE = new ArrayList<Person>();

	public static void main(String[] args) throws IOException {
		String filename = args[0];

		BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(filename), "UTF-8"));
		String line;
		while ((line = reader.readLine()) != null) {
			int index = findIndexOfNumber(line);
			String name = line.substring(0, index).trim();
			Date bday = getDateFromFile(line.substring(index, line.length()));
			PEOPLE.add(new Person(name, bday));
		}
		reader.close();
	}

	private static int findIndexOfNumber(String line) {
		for (int i = 0; i < line.length(); i++) {
			char c = line.charAt(i);
			if (Character.isDigit(c)) {
				return i;
			}
		}
		return 0;
	}

	private static Date getDateFromFile(String line) {
		String[] strings = line.split(" ");
		int year = Integer.valueOf(strings[2]) - 1900;
		int month = Integer.valueOf(strings[1]) - 1;
		int day = Integer.valueOf(strings[0]);
		return new Date(year, month, day);
	}

}
