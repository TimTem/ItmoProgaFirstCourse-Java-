package RegularExpressions;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegExpShow {
    public static boolean showRegExp(String str){
        str = str.toLowerCase().replaceAll(" ", "");
        Pattern pattern = Pattern.compile("^show$");
        Matcher mt = pattern.matcher(str);

        if (mt.matches()){
            return true;
        }
        return false;
    }
}
