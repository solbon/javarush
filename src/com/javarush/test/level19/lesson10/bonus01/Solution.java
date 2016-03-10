package com.javarush.test.level19.lesson10.bonus01;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* Отслеживаем изменения
Считать в консоли 2 имени файла - file1, file2.
Файлы содержат строки, file2 является обновленной версией file1, часть строк совпадают.
Нужно создать объединенную версию строк, записать их в список lines
Операции ADDED и REMOVED не могут идти подряд, они всегда разделены SAME
Пример:
оригинальный   редактированный    общий
file1:         file2:             результат:(lines)

строка1        строка1            SAME строка1
строка2                           REMOVED строка2
строка3        строка3            SAME строка3
строка4                           REMOVED строка4
строка5        строка5            SAME строка5
строка0                           ADDED строка0
строка1        строка1            SAME строка1
строка2                           REMOVED строка2
строка3        строка3            SAME строка3
строка5                           ADDED строка5
строка4        строка4            SAME строка4
строка5                           REMOVED строка5
*/

public class Solution {
    public static List<LineItem> lines = new ArrayList<LineItem>();

    public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		BufferedReader fileReader1 = new BufferedReader(new InputStreamReader(new FileInputStream(reader.readLine())));
		BufferedReader fileReader2 = new BufferedReader(new InputStreamReader(new FileInputStream(reader.readLine())));
		reader.close();

		List<String> list1 = getList(fileReader1);
		List<String> list2 = getList(fileReader2);
		fileReader1.close();
		fileReader2.close();

		int i = 0, j = 0;
		while (i < list1.size() && j < list2.size()) {
			String line1 = list1.get(i);
			String line2 = list2.get(j);
			if (line1.equals(line2)) {
				lines.add(new LineItem(Type.SAME, line1));
				i++;
				j++;
			} else if (((j + 1) < list2.size()) && line1.equals(list2.get(j + 1))) {
				lines.add(new LineItem(Type.ADDED, line2));
				j++;

			} else if (((i + 1) < list1.size()) && list1.get(i + 1).equals(line2)) {
				lines.add(new LineItem(Type.REMOVED, line1));
				i++;
			}
		}

		if (i < list1.size()) {
			lines.add(new LineItem(Type.REMOVED, list1.get(list1.size()-1)));
			System.out.println("REMOVED " + list1.get(list1.size()-1));
		}
		if (j < list2.size()) {
			lines.add(new LineItem(Type.ADDED, list2.get(list2.size()-1)));
			System.out.println("ADDED " + list2.get(list2.size()-1));
		}

		for (LineItem line : lines) {
			System.out.println(line.type + " " + line.line);
		}

	}

	private static List getList(BufferedReader reader) throws IOException {
		List<String> list = new ArrayList<>();
		String lineFile1;
		while ((lineFile1 = reader.readLine()) != null) {
			list.add(lineFile1);
		}
		return list;
	}


	public static enum Type {
        ADDED,        //добавлена новая строка
        REMOVED,      //удалена строка
        SAME          //без изменений
    }

    public static class LineItem {
        public Type type;
        public String line;

        public LineItem(Type type, String line) {
            this.type = type;
            this.line = line;
        }
    }
}
