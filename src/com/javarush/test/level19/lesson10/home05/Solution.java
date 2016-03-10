package com.javarush.test.level19.lesson10.home05;

/* Слова с цифрами
В метод main первым параметром приходит имя файла1, вторым - файла2.
Файл1 содержит строки со слов, разделенные пробелом.
Записать через пробел в Файл2 все слова, которые содержат цифры, например, а1 или abc3d
Закрыть потоки. Не использовать try-with-resources
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
		while ((line = readerFile1.readLine()) != null) {
			String[] words = line.split(" ");
			for (String word : words) {
				if (containsDigit(word)) {
					writerFile2.write(word + " ");
				}
			}
		}
		readerFile1.close();
		writerFile2.close();
	}

	private static boolean containsDigit(String word) {
		for (Character c : word.toCharArray()) {
			if (Character.isDigit(c)) {
				return true;
			}
		}
		return false;
	}
}
