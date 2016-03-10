package tests.OOP;

/**
 * Created by admin on 08.02.2016.
 */
public class Test {
	public static void main(String[] args) {
		new TestB();
	}

}
class TestA {
	String str = "ab";

	TestA() {
		printLength();
	}

	void printLength() {
		System.out.println(str.length());
	}
}

class TestB extends TestA {
	static String str = "abc";

	void printLength() {
		System.out.println(str.length());
	}
}
