package com.javarush.test.level19.lesson10.home09;

/* Контекстная реклама
В методе main подмените объект System.out написанной вами реадер-оберткой
Ваша реадер-обертка должна выводить на консоль контекстную рекламу после каждого второго println-а
Вызовите готовый метод printSomething(), воспользуйтесь testString
Верните переменной System.out первоначальный поток

Рекламный текст: "JavaRush - курсы Java онлайн"

Пример вывода:
first
second
JavaRush - курсы Java онлайн
third
fourth
JavaRush - курсы Java онлайн
fifth
*/

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) throws IOException {
		PrintStream printStream = System.out;
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
		PrintStream newPrintStream = new PrintStream(outputStream);
		System.setOut(newPrintStream);
		testString.printSomething();

		String text = outputStream.toString();
		outputStream.reset();
		String[] lines = text.split(System.getProperty("line.separator"));
		int count = 1;
		for (String line : lines) {
			if (count == 2) {
				System.out.println(line);
				System.out.println("JavaRush - курсы Java онлайн");
				count = 0;
			} else {
				System.out.println(line);
			}
			count++;
		}
		System.setOut(printStream);
		System.out.println(outputStream.toString());
		newPrintStream.close();
		outputStream.close();
		printStream.close();
	}

    public static class TestString {
        public void printSomething() {
            System.out.println("first");
            System.out.println("second");
            System.out.println("third");
            System.out.println("fourth");
            System.out.println("fifth");
        }
    }
}
