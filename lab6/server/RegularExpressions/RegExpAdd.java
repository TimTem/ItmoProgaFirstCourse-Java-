package RegularExpressions;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegExpAdd {
    public static String addRegExp(String str){
        Pattern pattern = Pattern.compile("add \\{([A-z0-9]*|[A-z0-9]*\\s[A-z0-9]*|[A-z0-9]*\\s[A-z0-9]*\\s[A-z0-9]*|[A-z0-9]*\\s[A-z0-9]*\\s[A-z0-9]*\\s[A-z0-9]*)\\}");
        Matcher mt = pattern.matcher(str);

        if (mt.matches()){
            return mt.group(1);
        }
        return null;
    }
}
