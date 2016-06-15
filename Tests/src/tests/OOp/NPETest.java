package tests.oop;

/**
 * Created by admin on 26.01.2016.
 */
public class NPETest {
	public static String name;
	private String privName;
	private int price;

	public static void main(String[] args) {
		NPETest test = null;
		try {
			System.out.println(test.privName);
		} catch (NullPointerException e) {
			System.out.println("NPE caught");
			System.out.println(String.valueOf(test));
		}
	}

}
