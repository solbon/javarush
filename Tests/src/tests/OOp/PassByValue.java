package tests.oop;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by admin on 05.02.2016.
 */
public class PassByValue {
	public static void main(String[] args) {
		List<String> list = new ArrayList<>();
		myAddMethod("new string", list);
		myAddMethod("Hello World", list);
		myAddMethod("Oh yeah!!", list);

		System.out.println(list);
	}

	private static void myAddMethod(String s, List<String> list) {
		list.add(s);
	}

}
