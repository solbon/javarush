package tests.test1;

/**
 * Created by admin on 05.02.2016.
 */
public class Practice {
	public static void main(String... args) {
		Boolean b = new Boolean("/true");
		System.out.println(b);
	}

	public static void main(String args) {
		Boolean b = new Boolean("/false");
		System.out.println(b == false);
	}
}