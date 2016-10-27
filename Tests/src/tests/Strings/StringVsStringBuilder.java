package tests.Strings;

/**
 * Created by admin on 04.02.2016.
 */
public class StringVsStringBuilder {
	public static void main(String[] args) {
		String s = "string: ";
		long startTime = System.currentTimeMillis();
		for (int i = 0; i < 10_000; i++) {
			s = s + i;
		}
		long timeForString = System.currentTimeMillis() - startTime;
		System.out.println(s);
		System.out.println(timeForString);

		StringBuilder sb = new StringBuilder("string builder: ");
		startTime = System.currentTimeMillis();
		for (int i = 0; i < 10_000; i++) {
			sb.append(i);
		}
		timeForString = System.currentTimeMillis() - startTime;
		System.out.println(sb.toString());
		System.out.println(timeForString);

	}
}
