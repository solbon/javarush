package tests.Strings;

/**
 * Created by admin on 26.11.2015.
 */

import java.math.BigInteger;
import java.security.SecureRandom;

public final class SessionIdentifierGenerator {
	private SecureRandom random = new SecureRandom();

	public String nextSessionId() {
		return new BigInteger(100, random).toString(32);
	}

	public static void main(String[] args) {
		for (int i = 0; i < 10; i++) {

			System.out.println(new SessionIdentifierGenerator().nextSessionId());
		}
	}
}