package tests.test1;

import java.util.Random;

/**
 * Created by admin on 10.11.2015.
 */
public class CoinFlip {
	public static void main(String[] args) {
		Random random = new Random();
		int bigger = 0;
		int smaller = 0;
		for (int i = 0; i < 100_000; i++) {
			int next = random.nextInt(100);
			if (next > 50) {
				bigger++;
			} else {
				smaller++;
			}
		}

		System.out.println("bigger: " + bigger);
		System.out.println("smaller: " + smaller);

	}
}
