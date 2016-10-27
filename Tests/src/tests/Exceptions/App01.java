package tests.Exceptions;

/**
 * Created by admin on 05.11.2015.
 */
public class App01 {
	public static void main(String[] args) throws MyException {
		try {
			throw new MyException();
		} catch (Exception e) {
			 System.out.println("I do nothing if I catch exception");
		} finally {
			throw new MyException();
		}
	}

	public static class MyException extends Exception {

	}

}
