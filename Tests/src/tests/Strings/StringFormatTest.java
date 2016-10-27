package tests.Strings;

/**
 * Created by admin on 28.10.2015.
 */
public class StringFormatTest {
	public static void main(String[] args) {
		System.out.println(new StringFormatTest().getUniqueLogin(3));
	}

	private String getUniqueLogin(int loginNumber) {
		String userLogin;
		if (loginNumber > 10) {
			userLogin = "M-" + String.format("%1$04d", loginNumber);
		} else {
			userLogin = "R" + String.format("%1$02d", 5) + "-" + String.format("%1$04d", loginNumber);
		}
		return userLogin;
	}
}
