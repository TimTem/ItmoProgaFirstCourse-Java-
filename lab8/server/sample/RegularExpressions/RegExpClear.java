package sample.RegularExpressions;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegExpClear {
    public static boolean clearRegExp(String str){
        str = str.toLowerCase().replaceAll(" ", "");
        Pattern pattern = Pattern.compile("^clear$");
        Matcher mt = pattern.matcher(str);

        if (mt.matches()){
            return true;
        }
        return false;
    }
}
