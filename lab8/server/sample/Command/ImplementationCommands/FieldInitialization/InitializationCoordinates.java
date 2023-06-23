package sample.Command.ImplementationCommands.FieldInitialization;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InitializationCoordinates {
    public static double initializationCoordinateX(){
        System.out.print("Enter the X coordinate: ");
        Scanner scanner = new Scanner(System.in);
        String X = scanner.nextLine();
        X = X.replaceAll(" ", "");
        Pattern pattern = Pattern.compile("^[+-]?\\d*\\.?\\d+(?:[eE][+-]?\\d+)?$");
        Matcher mt = pattern.matcher(X);
        if (mt.matches()){
            return Double.parseDouble(X);
        }
        System.out.print("The X coordinate is entered incorrectly. Do you want to fix it? ");
        String answer = scanner.nextLine();
        answer = answer.replaceAll(" ", "");
        Pattern pattern_2 = Pattern.compile("(YES|Yes|yes|yEs|yeS|Да|ДА|да|дА)");
        Matcher mt_2 = pattern_2.matcher(answer);
        if (mt_2.matches()){
            return initializationCoordinateX();
        }
        return 0d;
    }
    public static Double initializationCoordinateY(){
        System.out.print("Enter the Y coordinate: ");
        Scanner scanner = new Scanner(System.in);
        String Y = scanner.nextLine();
        Y = Y.replaceAll(" ", "");
        Pattern pattern = Pattern.compile("^[+-]?\\d*\\.?\\d+(?:[eE][+-]?\\d+)?$");
        Matcher mt = pattern.matcher(Y);
        if (mt.matches()){
            return Double.parseDouble(Y);
        }
        System.out.print("The X coordinate is entered incorrectly. Do you want to fix it? ");
        String answer = scanner.nextLine();
        answer = answer.replaceAll(" ", "");
        Pattern pattern_2 = Pattern.compile("(YES|Yes|yes|yEs|yeS|Да|ДА|да|дА)");
        Matcher mt_2 = pattern_2.matcher(answer);
        if (mt_2.matches()){
            return initializationCoordinateY();
        }
        return 0D;
    }
}
