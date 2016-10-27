package tests.ThinkingInJava.Initialization;

/**
 * Created by admin on 28.08.2015.
 */
class Banana {
	void peel(int i) {
		System.out.println("peel " + i);
	}
}

public class A {
	public static void main(String[] args) {
		Banana a = new Banana();
		Banana b = new Banana();
		a.peel(1);
		b.peel(2);
	}

}
