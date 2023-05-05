package RegularExpressions;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegExpHelp {
    public static boolean regExpHelp(String str){
        str = str.toLowerCase().replaceAll(" ", "");
        Pattern pattern = Pattern.compile("^help$");
        Matcher mt = pattern.matcher(str);

        if (mt.matches()){
            return true;
        }
        return false;
    }
}
