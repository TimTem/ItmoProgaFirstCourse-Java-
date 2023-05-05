package RegularExpressions;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegExpUpdate {
    public static String updateReg(String str){
        Pattern pattern = Pattern.compile("update \\{([1-9]*)\\}");
        Matcher mt = pattern.matcher(str);

        if (mt.matches()){
            return mt.group(1);
        }
        return null;
    }
}
