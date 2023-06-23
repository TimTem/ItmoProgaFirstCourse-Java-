package sample.RegularExpressions;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegExpExucuteScript {
    public RegExpExucuteScript(){

    }
    public static String executeScriptReg(String str) {
        Pattern pattern = Pattern.compile("execute_script (\\{((/(\\w*|\\w*.txt))*)})");
        Matcher mt = pattern.matcher(str);
        return mt.matches() ? mt.group(2) : null;
    }
}
