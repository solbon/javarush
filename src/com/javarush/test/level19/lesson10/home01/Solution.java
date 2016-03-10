package com.javarush.test.level19.lesson10.home01;

/* Считаем зарплаты
 В метод main первым параметром приходит имя файла.
 В этом файле каждая строка имеет следующий вид:
 имя значение
 где [имя] - String, [значение] - double. [имя] и [значение] разделены пробелом

 Для каждого имени посчитать сумму всех его значений
 Все данные вывести в консоль, предварительно отсортировав в возрастающем порядке по имени
 Закрыть потоки

 Пример входного файла:
 Петров 2
 Сидоров 6
 Иванов 1.35
 Петров 3.1

 Пример вывода:
 Иванов 1.35
 Петров 5.1
 Сидоров 6.0
 */

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
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

		// Map<String, Double> sortedMap = sortByValue(map);

		for (Map.Entry pair : map.entrySet()) {
			System.out.println(pair.getKey() + " " + pair.getValue());

		}
		reader.close();
	}

	public static <K, V extends Comparable<? super V>> Map<K, V> sortByValue(Map<K, V> map) {
		List<Map.Entry<K, V>> list = new LinkedList<Map.Entry<K, V>>(map.entrySet());

		Collections.sort(list, new Comparator<Map.Entry<K, V>>() {
			public int compare(Map.Entry<K, V> o1, Map.Entry<K, V> o2) {
				return (o1.getValue()).compareTo(o2.getValue());
			}
		});

		Map<K, V> result = new LinkedHashMap<K, V>();
		for (Map.Entry<K, V> entry : list) {
			result.put(entry.getKey(), entry.getValue());
		}
		return result;
	}
}
