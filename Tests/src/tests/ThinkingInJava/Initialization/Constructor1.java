package tests.ThinkingInJava.Initialization;

/**
 * Created by admin on 28.08.2015.
 */
public class Constructor1 {
	String someString;
	String definedStr = new String("definedStr");
	String undefStr;

	public Constructor1() {
		someString = "someString";
	}

	public static void main(String[] args) {
		String mainStr = new Constructor1().someString;
		System.out.println(new Constructor1().someString);
		System.out.println(new Constructor1().definedStr);
		System.out.println(new Constructor1().undefStr);
		System.out.println(mainStr);
	}
}
