package sample.FieldInitialization;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InitializationNew {
    public static String whatApartment(Boolean quality){
        if(quality == true){
            return "true";
        }
        if(quality == false){
            return "false";
        }
//        System.out.println("Is your apartment new?(Yes|No)");
//        Scanner scanner = new Scanner(System.in);
//        String answer = scanner.nextLine();
//        Pattern pattern = Pattern.compile("(YES|Yes|yes|yEs|yeS|Да|ДА|да|дА)");
//        Matcher mt = pattern.matcher(answer);
//        if(mt.matches()){
//            return "true";
//        }
//        Pattern pattern1 = Pattern.compile("(NO|No|no|nO|Нет|нет|нЕт|НЕТ|неТ)");
//        Matcher mt1 = pattern.matcher(answer);
//        if(mt1.matches()){
//            return "false";
//        }
//        System.out.println("The variable was entered incorrectly. Do you want to change this?(Yes|No)");
//        String answer1 = scanner.nextLine();
//        answer1 = answer1.replaceAll(" ", "");
//        Pattern pattern_2 = Pattern.compile("(YES|Yes|yes|yEs|yeS|Да|ДА|да|дА)");
//        Matcher mt_2 = pattern_2.matcher(answer);
//        if (mt_2.matches()){
//            return whatApartment();
//        }        return "false";
        return "false";
    }
}
