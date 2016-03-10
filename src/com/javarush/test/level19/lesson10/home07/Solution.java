package com.javarush.test.level19.lesson10.home07;

/* Длинные слова
 В метод main первым параметром приходит имя файла1, вторым - файла2
 Файл1 содержит слова, разделенные пробелом.
 Записать через запятую в Файл2 слова, длина которых строго больше 6
 Закрыть потоки. Не использовать try-with-resources

 Пример выходных данных:
 длинное,короткое,аббревиатура
 */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Solution {
	public static void main(String[] args) throws IOException {
		String file1 = args[0];
		String file2 = args[1];
		BufferedReader readerFile1 = new BufferedReader(new InputStreamReader(new FileInputStream(file1)));
		BufferedWriter writerFile2 = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file2)));
		String line;
		boolean firstWord = true;
		while ((line = readerFile1.readLine()) != null) {
			String[] strings = line.split(" ");
			for (String s : strings) {
				if (s.length() > 6 && firstWord) {
					writerFile2.write(s);
					firstWord = false;
				} else if (s.length() > 6){
					writerFile2.write("," + s);
				}
			}
		}
		readerFile1.close();
		writerFile2.close();
	}
}
