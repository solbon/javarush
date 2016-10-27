package tests.other;

/**
 * Created by admin on 05.02.2016.
 */
public class TestPackage {
	int b;

	static void printB(int b) {
		System.out.println(b);
	}

	public static void main(String[] args) {
		// PackageModifier.printA(5); // can't be accessed from outside package. PackageModifier.printA() is in tests package
	}
}
