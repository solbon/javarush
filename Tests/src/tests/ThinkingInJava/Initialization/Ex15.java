package tests.ThinkingInJava.Initialization;

/**
 * Created by admin on 31.08.2015.
 */
public class Ex15 {
	public static void main(String[] args) {
		InitString is = new InitString();
		InitString is2 = new InitString();

	}
}

class InitString {
	static String s;
	InitString() {
		s = "Constructor";
		System.out.println(s);
	}
	{
		s = "instance initialization";
		System.out.println(s);
	}
	static {
		s = "static init";
		System.out.println(s);
	}
}
