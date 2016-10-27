package tests.Strings;

import java.util.Random;

/**
 * Created by admin on 26.11.2015.
 */
public class PasswordGenerator {
	static final String upperCaseCharacters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	static final String lowerCaseCharacters = "abcdefghijklmnopqrstuvwxyz";
	static final String numberCharacters = "0123456789";
	static final Random random = new Random();

	public static void main(String[] args) {
		for (int i = 0; i < 10; i++) {
			System.out.println(PasswordGenerator.generatePassword(8));
		}
	}

	static String generatePassword(int length) {
		StringBuilder sb = new StringBuilder(length);
		sb.append(upperCaseCharacters.charAt(random.nextInt(upperCaseCharacters.length())));
		for (int i = 0; i < length - 2; i++) {
			sb.append(lowerCaseCharacters.charAt(random.nextInt(lowerCaseCharacters.length())));
		}
		sb.append(numberCharacters.charAt(random.nextInt(numberCharacters.length())));
		return sb.toString();
	}
}
