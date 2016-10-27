package tests.sabre;

import java.util.Scanner;

/**
 * Created by admin on 26.01.2016.
 */
public class FizzBuzz {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		while (n < 0 || n > 10_000_000) {
			System.out.println("Number should be in scope: 0 < n < 10_000_000");
			n = sc.nextInt();
		}
		for (int i = 1; i <= n; i++) {
			StringBuilder sb = new StringBuilder();
			if (i < 3) {
				System.out.println(i);
				continue;
			}
			if (multiply3(i)) {
				sb.append("Fizz");
			}
			if (multiply5(i)) {
				sb.append("Buzz");
			}
			if (sb.length() == 0) {
				System.out.println(i);
			} else {
				System.out.println(sb.toString());
			}
		}
	}

	public static boolean multiply3(int number) {
		return number % 3 == 0;
	}

	public static boolean multiply5(int number) {
		return number % 5 == 0;
	}
}
