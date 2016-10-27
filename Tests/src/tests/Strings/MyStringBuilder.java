package tests.Strings;

/**
 * Created by solbon on 13.09.2014.
 */
public class MyStringBuilder {
    public static void main(String[] args) {
        StringBuilder builder = new StringBuilder();
        char ch = 'h';
        String str = "ello";
        builder.append(ch).append(str);
        String newString = builder.toString();
        System.out.println(newString);
        str.intern();

    }
}
