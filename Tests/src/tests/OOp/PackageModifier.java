package tests.oop;

/**
 * Created by admin on 05.02.2016.
 */
public class PackageModifier {
	int a;

	static void printA(int a) {
		System.out.println(a);
	}

	public static void main(String[] args) {
//		TestPackage.printB(5);  // can't be accessed from outside package. TestPackage.printB() is in tests package
	}
}
