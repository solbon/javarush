package tests.Exceptions;

/**
 * Created by admin on 05.02.2016.
 */
public class SOverflow {
	public static void main(String[] args) {
		f(null);
	}
	public static void f(NullPointerException e) {
		try {
			throw e;
		} catch (NullPointerException npe) {
			f(npe);
		}
	}
}