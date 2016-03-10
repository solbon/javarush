package tests.sabre;

/**
 * Created by admin on 26.01.2016.
 */
public class Solution {
	public void div(int a, int b) {
		try {
			int c = a / b;
		} catch (Exception e) {
			System.out.println("Exception");
		} finally {
			System.out.println("Finally");
		}
		Class c;
	}

	public static void main(String[] args) {
		new Solution().div(4, 0);
	}
}
