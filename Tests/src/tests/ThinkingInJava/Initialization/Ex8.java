package tests.ThinkingInJava.Initialization;

/**
 * Created by admin on 28.08.2015.
 */
public class Ex8 {
	void method1() {
		System.out.println("method1");
	}

	void method2() {
		method1();
		this.method1();
	}

	public static void main(String[] args) {
		new Ex8().method2();
	}
}
