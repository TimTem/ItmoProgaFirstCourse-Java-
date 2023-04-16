package RegularExpressions;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegExpSave {
    public static boolean saveRegExp(String str){
        str = str.toLowerCase().replaceAll(" ", "");
        Pattern pattern = Pattern.compile("^save$");
        Matcher mt = pattern.matcher(str);

        if (mt.matches()){
            return true;
        }
        return false;
    }
}
