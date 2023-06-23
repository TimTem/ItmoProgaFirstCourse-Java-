package sample.FieldInitialization;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InitializationCoordinates {
    public static String initializationCoordinateX(Double X1){
        String X = X1.toString();
        X = X.replaceAll(" ", "");
        Pattern pattern = Pattern.compile("^[+-]?\\d*\\.?\\d+(?:[eE][+-]?\\d+)?$");
        Matcher mt = pattern.matcher(X);
        if (mt.matches()){
            return X;
        }
//        System.out.print("The X coordinate is entered incorrectly. Do you want to fix it? ");
//        String answer = scanner.nextLine();
//        answer = answer.replaceAll(" ", "");
//        Pattern pattern_2 = Pattern.compile("(YES|Yes|yes|yEs|yeS|Да|ДА|да|дА)");
//        Matcher mt_2 = pattern_2.matcher(answer);
//        if (mt_2.matches()){
//            return initializationCoordinateX();
//        }
        return "0";
    }
    public static String initializationCoordinateY(Double Y1){
        String Y = Y1.toString();
        Y = Y.replaceAll(" ", "");
        Pattern pattern = Pattern.compile("^[+-]?\\d*\\.?\\d+(?:[eE][+-]?\\d+)?$");
        Matcher mt = pattern.matcher(Y);
        if (mt.matches()){
            return Y;
        }
//        System.out.print("The X coordinate is entered incorrectly. Do you want to fix it? ");
//        String answer = scanner.nextLine();
//        answer = answer.replaceAll(" ", "");
//        Pattern pattern_2 = Pattern.compile("(YES|Yes|yes|yEs|yeS|Да|ДА|да|дА)");
//        Matcher mt_2 = pattern_2.matcher(answer);
//        if (mt_2.matches()){
//            return initializationCoordinateY();
//        }
        return "0";
    }
}
