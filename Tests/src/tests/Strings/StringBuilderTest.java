package tests.Strings;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * Created by admin on 27.10.2015.
 */
public class StringBuilderTest {

	public static void main(String[] args) {
		String pesel = "06302503038";
		StringBuilderTest instance = new StringBuilderTest();
		System.out.println(instance.checkDate(pesel));

	}

	private boolean checkDate(String pesel) {
		DateFormat df = new SimpleDateFormat("yyMMdd");
		df.setLenient(false);
		try {
			StringBuilder sb = new StringBuilder(pesel);
			String peselNumber;
			int i;
			if ((i = Integer.valueOf(pesel.substring(2, 3))) > 1) {
				sb.setCharAt(2, Integer.toString(i - 2).charAt(0));
				peselNumber = sb.toString();
			} else {
				peselNumber = pesel;
			}
			df.parse(peselNumber.substring(0, 6));
			System.out.println(peselNumber);
		} catch (ParseException e) {
			return false;
		}
		return true;
	}

}
