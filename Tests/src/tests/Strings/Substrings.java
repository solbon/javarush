package tests.Strings;

/**
 * Created by admin on 23.11.2015.
 */
public class Substrings {
	public static void main(String[] args) {
		String file = "/C:/tmp/bla.pdf";
		String file2 = file.substring(1, file.length());
		System.out.println(file2);
	}
}
