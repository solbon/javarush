package tests.regexp;

import java.util.HashMap;
import java.util.Map;
import java.util.StringJoiner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by sdaribazaron on 2016-08-03.
 */
public class SourceOperator {
    public static void main(String[] args) {
        Map<String, String> params = new HashMap<>();
        params.put("SOURCE", "");
        params.put("OPERATOR", "OPER1");

        String source = "VT-${SOURCE} and ${SOURCE:} blablacar ${SOURCE:SRC0} kkkk ${SOURCE:SRC:011}";

        Pattern p = Pattern.compile("(\\$\\{(\\w*)(:?)(.*?)\\})");

        System.out.println(multipleReplace(source, p, params));

    }

    static String multipleReplace(String s, Pattern p, Map<String, String> params) {
        Matcher matcher = p.matcher(s);

        StringBuffer sb = new StringBuffer();
        while (matcher.find()) {
//            String placeholder = matcher.group(1);
            String src = matcher.group(2);
            String colon = matcher.group(3);
            String toAppend = matcher.group(4);
            if (params.keySet().contains(src)) { //&& !params.get(src).isEmpty()
                toAppend = params.get(src);
            }
            if (colon.isEmpty() && !params.keySet().contains(src)) {
                continue;
            }
            matcher.appendReplacement(sb, toAppend);
        }
        matcher.appendTail(sb);
        return sb.toString();
    }

    private static void catDogReplace() {
        Pattern p2 = Pattern.compile("cat");
        Matcher m2 = p2.matcher("one cat two cats in the yard");
        StringBuffer sb2 = new StringBuffer();
        while (m2.find()) {
            m2.appendReplacement(sb2, "dog");
        }
        m2.appendTail(sb2);
        System.out.println(sb2.toString());
    }
}
