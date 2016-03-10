package tests.Pattern;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by admin on 03.02.2016.
 */
/**
 * A complete Java program that demonstrates how to
 * extract a tag from a line of HTML using the Pattern
 * and Matcher classes.
 */
public class PatternMatcherGroupHtml
{
	public static void main(String[] args)
	{
		String stringToSearch = "<p>Yada yada yada <code>StringBuffer <code>hello</code> world</code> yada yada ...</p>";

		// the pattern we want to search for
		Pattern p = Pattern.compile("<code>(.+?)</code>");
		Matcher m = p.matcher(stringToSearch);

		// if we find a match, get the group
		if (m.find())
		{
			// get the matching group
			String codeGroup = m.group();

			// print the group
			System.out.format("%s\n", codeGroup);
		}

	}
}
