package tests.polymorphism;

/**
 * Created by admin on 02.02.2016.
 */
public class App0 implements App0Interface {
	@Override
	public void display() {
		System.out.println("App0");
	}
}

class App01 extends App0 implements App01Interface{
	public static void main(String[] args) {
		App0 object = new App01();
		object.display();
		((App01)object).display2();
	}

	@Override
	public void display2() {
		System.out.println("App01");
	}
}
