package com.javarush.test.level19.lesson10.bonus03;

/* Знакомство с тегами
 Считайте с консоли имя файла, который имеет HTML-формат
 Пример:
 Info about Leela <span xml:lang="en" lang="en"><b><span>Turanga Leela
 </span></b></span><span>Super</span><span>girl</span>
 Первым параметром в метод main приходит тег. Например, "span"
 Вывести на консоль все теги, которые соответствуют заданному тегу
 Каждый тег на новой строке, порядок должен соответствовать порядку следования в файле
 Количество пробелов, \n, \r не влияют на результат
 Файл не содержит тег CDATA, для всех открывающих тегов имеется отдельный закрывающий тег, одиночных тегов нету
 Тег может содержать вложенные теги
 Пример вывода:
 <span xml:lang="en" lang="en"><b><span>Turanga Leela</span></b></span>
 <span>Turanga Leela</span>
 <span>Super</span>
 <span>girl</span>

 Шаблон тега:
 <tag>text1</tag>
 <tag text2>text1</tag>
 <tag
 text2>text1</tag>

 text1, text2 могут быть пустыми
 */

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
	public static void main(String[] args) throws IOException {
		String tagName = args[0];
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		BufferedReader fileReader = new BufferedReader(new InputStreamReader(new FileInputStream(reader.readLine())));
		StringBuilder sb = new StringBuilder();
		String line;
		while ((line = fileReader.readLine()) != null) {
			sb.append(line);
		}
		String text = sb.toString();

		List<Pair> tags = findMatches(text, "</?" + tagName + "([^>]*)>");

		printTags(tags, text);

		fileReader.close();
		reader.close();
	}

	private static void printTags(List<Pair> tags, String text) {
		boolean startTag = true;
		int count = 0;
		int index = 0	;
		for (int i = 0; i < tags.size(); i++) {
			String s = text.substring(tags.get(i).getStart(), tags.get(i).getStart() + 2);
			switch (s) {
			case "<s":
				if (startTag) {
					index = i;
					count++;
					startTag = false;
				} else {
					count++;
				}
				break;
			case "</":
				if (--count == 0) {
					System.out.println(text.substring(tags.get(index).getStart(), tags.get(i).getEnd()));
					index = i + 1;
				}
			}
		}
	}

	public static List<Pair> findMatches(String text, String regex) {
		List<Pair> list = new ArrayList<>();
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(text);
		// Check all occurrences
		while (matcher.find()) {
			list.add(new Pair(matcher.start(), matcher.end()));
		}
		return list;
	}

}

class Pair {
	private int start;
	private int end;

	Pair(int start, int end) {
		this.start = start;
		this.end = end;
	}

	public int getStart() {
		return start;
	}

	public void setStart(int start) {
		this.start = start;
	}

	public int getEnd() {
		return end;
	}

	public void setEnd(int end) {
		this.end = end;
	}
}
