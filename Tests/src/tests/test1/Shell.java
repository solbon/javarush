package tests.test1;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Created by admin on 08.02.2016.
 */
public class Shell {
	public static void main(String[] args) {
		Process proc = null;
		try {
			proc = Runtime.getRuntime().exec("idea.exe");
			InputStream inputstream = proc.getInputStream();
			InputStreamReader inputstreamreader = new InputStreamReader(inputstream);
			BufferedReader bufferedreader = new BufferedReader(inputstreamreader);
			String line;
			while ((line = bufferedreader.readLine()) != null) {
				System.out.println("line = " + line);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
