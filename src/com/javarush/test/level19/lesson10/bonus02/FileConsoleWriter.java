package com.javarush.test.level19.lesson10.bonus02;

/* Свой FileWriter
 Реализовать логику FileConsoleWriter
 Должен наследоваться от FileWriter
 При записи данных в файл, должен дублировать эти данные на консоль
 */

import java.io.File;
import java.io.FileDescriptor;
import java.io.FileWriter;
import java.io.IOException;

public class FileConsoleWriter extends FileWriter {

	public FileConsoleWriter(String fileName) throws IOException {
		super(fileName);
	}

	public FileConsoleWriter(String fileName, boolean append) throws IOException {
		super(fileName, append);
	}

	public FileConsoleWriter(File file) throws IOException {
		super(file);
	}

	public FileConsoleWriter(File file, boolean append) throws IOException {
		super(file, append);
	}

	public FileConsoleWriter(FileDescriptor fd) {
		super(fd);
	}

	@Override
	public void write(int c) throws IOException {
		System.out.println((char) c);
		super.write(c);
	}

	@Override
	public void write(char[] cbuf, int off, int len) throws IOException {
		System.out.println(String.valueOf(cbuf).substring(off, off + len));
		super.write(cbuf, off, len);
	}

	@Override
	public void write(String str, int off, int len) throws IOException {
		System.out.println(str.substring(off, off + len));
		super.write(str, off, len);
	}

	public static void main(String[] args) throws IOException
	{
		FileConsoleWriter fileConsoleWriter = new FileConsoleWriter("test");
		fileConsoleWriter.write("Проверка String:");
		fileConsoleWriter.write(1234);
		char[] buff = "Проверка char buff:".toCharArray();
		fileConsoleWriter.write(buff);
		fileConsoleWriter.write(buff, 3, 5);
		fileConsoleWriter.write("Проверка String обрезка:", 1, 6);
		fileConsoleWriter.flush();
		fileConsoleWriter.close();
	}
}
