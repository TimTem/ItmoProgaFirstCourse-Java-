package sample.RegularExpressions;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegExpRemoveGreater {
    public static String removeGreaterRegExp(String str){
            Pattern pattern = Pattern.compile("remove_greater \\{([1-9]*)\\}");
            Matcher mt = pattern.matcher(str);

            if (mt.matches()){
                return mt.group(1);
            }
        return null;
    }
}