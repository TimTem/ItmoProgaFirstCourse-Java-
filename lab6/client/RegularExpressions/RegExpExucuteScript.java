package RegularExpressions;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegExpExucuteScript {
    public RegExpExucuteScript(){

    }
    public static String executeScriptReg(String str) {
        Pattern pattern = Pattern.compile("execute_script \\{([a-zA-Z]:[\\\\\\\\[\\w]*]*.txt)}");
        Matcher mt = pattern.matcher(str);
        if (mt.matches()){
            return mt.group(1);
        }
        return null;
    }
}
