package RegularExpressions;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegExpAverageOfNumberOfRooms {
    public static boolean averageOfNumberOfRoomsRegExp(String str){
        str = str.toLowerCase().replaceAll(" ", "");
        Pattern pattern = Pattern.compile("^average_of_number_of_rooms$");
        Matcher mt = pattern.matcher(str);

        if (mt.matches()){
            return true;
        }
        return false;
    }
}
