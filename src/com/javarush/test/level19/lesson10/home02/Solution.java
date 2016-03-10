package com.javarush.test.level19.lesson10.home02;

/* Самый богатый
 В метод main первым параметром приходит имя файла.
 В этом файле каждая строка имеет следующий вид:
 имя значение
 где [имя] - String, [значение] - double. [имя] и [значение] разделены пробелом

 Для каждого имени посчитать сумму всех его значений
 Вывести в консоль имена, у которых максимальная сумма. Имена разделять пробелом
 Закрыть потоки

 Пример входного файла:
 Петров 0.501
 Иванов 1.35
 Петров 0.85

 Пример вывода:
 Петров
 */

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.TreeMap;

public class Solution {
	public static void main(String[] args) throws Exception {
		String filename = args[0];
		Map<String, Double> map = new TreeMap<>();
		BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(filename), "UTF-8"));
		String line;
		while ((line = reader.readLine()) != null) {
			String str[] = line.split(" ");
			String name = str[0];
			Double salary = Double.valueOf(str[1]);
			Double sum;
			if (map.get(name) != null) {
				sum = map.get(name) + salary;
				map.put(name, sum);
			} else {
				map.put(name, salary);
			}
		}

		Double max = 0.0;
		for (Double d : map.values()) {
			if (d > max) {
				max = d;
			}
		}

		for (Map.Entry pair : map.entrySet()) {
			if (pair.getValue().equals(max))
				System.out.println(pair.getKey());

		}

		reader.close();
	}
}
