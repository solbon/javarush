package tests.Reflection;

import java.lang.reflect.Field;

/**
 * Created by admin on 08.02.2016.
 */
public class GetPrivateField {
	public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
		A a = new A();
		Field field = A.class.getDeclaredField("field");
		field.setAccessible(true);
		System.out.println(field.get(a));
	}
}

class A {
	private String field = "I'm private field";
}
