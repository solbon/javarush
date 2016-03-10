package tests.polymorphism;

/**
 * Created by admin on 02.11.2015.
 */
public class ClassCasting {
	public static void main(String[] args) {
		B b = new B();
		A a = new A();
		ClassCasting c = new ClassCasting();

		b = (B) a;
		b = (B) c;

		a = b;
		a = (A) c;

		c = a;
		c = b;

		A a2 = new B(); 				//	no cast is required if we cast from derive to parent class
		A a3 = (A) new ClassCasting(); // explicit casting is required if we cast from parent to derive class

		B b2 = (B) new A();
		B b3 = (B) new ClassCasting();

		ClassCasting c2 = new A();
		ClassCasting c3 = new B();

	}
}

class A extends ClassCasting {}
class B extends A {}


