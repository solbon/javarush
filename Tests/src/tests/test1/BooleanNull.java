package tests.test1;

import org.apache.commons.lang3.BooleanUtils;

/**
 * Created by admin on 30.12.2015.
 */
public class BooleanNull {
	public static void main(String[] args) {
		f(true);
		f(false);
		f(null);
	}
	static void f(Boolean active) {
		if (BooleanUtils.isTrue(active)) {
			System.out.println("true");
		} else if (BooleanUtils.isFalse(active)) {
			System.out.println("false");
		} else if (active == null){
			System.out.println("null");
		}
	}
}

