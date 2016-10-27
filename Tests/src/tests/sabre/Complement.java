package tests.sabre;

import java.util.Scanner;

/**
 * Created by admin on 26.01.2016.
 */
public class Complement {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int res;
		int _n;
		_n = Integer.parseInt(in.nextLine());

		res = getIntegerComplement(_n);
		System.out.println(res);
	}

	static int getIntegerComplement(int n) {
		if (n < 0 || n > 100_000) {
			System.out.println("Number should be in the scope: 0 <= n <= 100_000");
			return 0;
		}
		String binaryCode = getBinaryCode(n);
		String invertedBinaryCode = inverseCode(binaryCode);
		int res = getDecimalCode(invertedBinaryCode);
		return res;
	}

	static String getBinaryCode(int n) {
		return Integer.toBinaryString(n);
	}

	 static String inverseCode(String code) {
		 return code.replaceAll("0", "x").replaceAll("1", "0").replaceAll("x", "1");
	 }

	static int getDecimalCode(String code) {
		return Integer.parseInt(code, 2);
	}
}
