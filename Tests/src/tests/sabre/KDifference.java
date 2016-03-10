package tests.sabre;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by admin on 26.01.2016.
 */
public class KDifference {
	static int diff(int[] a, int k) {
		List<Integer> numbers = new ArrayList<Integer>();
		int count = 0;
		for (int i : numbers) {
			if ((numbers.get(0) - i) == k) {
				count++;
				numbers.remove(numbers.get(0));
				numbers.remove(numbers.get(i));
			}
		}
		return 0;
	}
}
