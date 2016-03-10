package tests.crypto;

/**
 * Created by admin on 11.12.2015.
 */


import org.apache.commons.lang3.RandomStringUtils;

/**
 * Created by Solbon
 */
public class PasswordGenerator {
	private StringBuilder sb = new StringBuilder();

	public PasswordGenerator addUpperCaseLetters(int count) {
		sb.append(RandomStringUtils.randomAlphabetic(count).toUpperCase());
		return this;
	}

	public PasswordGenerator addLowerCaseLetters(int count) {
		sb.append(RandomStringUtils.randomAlphabetic(count).toLowerCase());
		return this;
	}

	public PasswordGenerator addNumbers(int count) {
		sb.append(RandomStringUtils.randomNumeric(count));
		return this;
	}

	public String getPasword() {
		return sb.toString();
	}

	public static void main(String[] args) {
		System.out.println(new tests.crypto.PasswordGenerator().addUpperCaseLetters(1).addLowerCaseLetters(6).addNumbers(3).getPasword());
	}

}