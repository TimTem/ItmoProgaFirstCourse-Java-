package sample.FieldInitialization;

import sample.Flat.Furnish;

import java.util.Objects;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InitializationFurnish {
    public static String initializationFurnish(String str){
        Furnish[] furnishes = Furnish.values();
        for(Furnish furnish : furnishes){
            if(str.toLowerCase().equals(furnish.getName().toLowerCase())){
                return furnish.getName();
            }
        }
//        System.out.print("Finish value is incorrect. Do you want to change it? ");
//        String answer = scanner.nextLine();
//        answer = answer.replaceAll(" ", "");
//        Pattern pattern_2 = Pattern.compile("(YES|Yes|yes|yEs|yeS|Да|ДА|да|дА)");
//        Matcher mt_2 = pattern_2.matcher(answer);
//        if (mt_2.matches()){
//            return initializationFurnish();
//        }
    return Furnish.NONE.getName();
    }
}
