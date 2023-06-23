package sample.RegularExpressions;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegExpInfo {
    public static boolean infoRegExp(String str){
        str = str.toLowerCase().replaceAll(" ", "");
        Pattern pattern = Pattern.compile("^info$");
        Matcher mt = pattern.matcher(str);

        if (mt.matches()){
            return true;
        }
        return false;
    }
}
