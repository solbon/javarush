package tests.Strings;

import java.nio.charset.Charset;

/**
 * Created by admin on 26.11.2015.
 */
public class StringToByteArray {
	public static void main(String[] args) {
		String str = "MyPassword1";
		byte[] bytes = str.getBytes(Charset.defaultCharset());
		StringBuilder sb = new StringBuilder();
		for (Byte b : bytes) {
			System.out.print(b + " ");
			sb.append(b + " ");
		}
		String myPassword = new String(bytes);
		System.out.println();
		System.out.println(myPassword);
		System.out.println(sb.toString());

		String[] strArray = sb.toString().split(" ");
		byte[] myByteArray = new byte[strArray.length];
		for (int i = 0; i < strArray.length; i++) {
			myByteArray[i] = Byte.valueOf(strArray[i]);
		}

		System.out.println("decoded password: " + new String(myByteArray));
	}
}
