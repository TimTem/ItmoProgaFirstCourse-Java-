package sample.FieldInitialization;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InitializationNumberOfRooms {
    public static String numberOfRooms(Integer number1){
        String number = number1.toString();
        Pattern pattern = Pattern.compile("^[1-9][0-9]*$");
        Matcher mt = pattern.matcher(number);
        if(mt.matches()){
            return number;
        }
//        System.out.println("The variable was entered incorrectly. Do you want to change this?(Yes|No)");
//        String answer = scanner.nextLine();
//        answer = answer.replaceAll(" ", "");
//        Pattern pattern_2 = Pattern.compile("(YES|Yes|yes|yEs|yeS|Да|ДА|да|дА)");
//        Matcher mt_2 = pattern_2.matcher(answer);
//        if (mt_2.matches()){
//            return numberOfRooms();
//        }
        return "1";
    }
}