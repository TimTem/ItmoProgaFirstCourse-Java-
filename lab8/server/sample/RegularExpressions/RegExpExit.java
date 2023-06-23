package sample.RegularExpressions;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegExpExit {
    public static boolean exitRegExp(String str){
        str = str.toLowerCase().replaceAll(" ", "");
        Pattern pattern = Pattern.compile("^exit$");
        Matcher mt = pattern.matcher(str);

        if (mt.matches()){
            return true;
        }
        return false;
    }
}
