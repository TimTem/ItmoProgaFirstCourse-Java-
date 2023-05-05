package RegularExpressions;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegExpFilterStartsWithName {
    public static String filterStartsWithNameRegExp(String str){
        Pattern pattern = Pattern.compile("filter_starts_with_name \\{([A-z0-9]*|[A-z0-9]*\\s[A-z0-9]*|[A-z0-9]*\\s[A-z0-9]*\\s[A-z0-9]*|[A-z0-9]*\\s[A-z0-9]*\\s[A-z0-9]*\\s[A-z0-9]*)\\}");
        Matcher mt = pattern.matcher(str);

        if (mt.matches()){
            return mt.group(1);
        }
        return null;
    }
}
