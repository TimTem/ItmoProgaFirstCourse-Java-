package RegularExpressions;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegExpRemoveById {
    public static String removeByIdRegExp(String str){
        Pattern pattern = Pattern.compile("remove_by_id \\{([1-9]*)\\}");
        Matcher mt = pattern.matcher(str);

        if (mt.matches()){
            return mt.group(1);
        }
    return null;
    }
}
