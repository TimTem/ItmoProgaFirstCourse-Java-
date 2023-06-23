package sample.Command.ImplementationCommands.FieldInitialization;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InitializationHouse {
    public static String initializationHouseName(){
        System.out.println("Enter house name: ");
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        Pattern patern = Pattern.compile("^([A-z]{2,}|[А-я]{2,} [А-я]{2,}|[А-я]{2,}_[А-я]{2,}|[A-z]{2,} [A-z]{2,}|[А-я]{2,})$");
        Matcher mat = patern.matcher(str);
        if (mat.matches()){
            return str;
        }
        System.out.print("The name of operator is entered incorrectly. Do you want to fix it? ");
        String answer = scanner.nextLine();
        answer = answer.replaceAll(" ", "");
        Pattern pattern_2 = Pattern.compile("(YES|Yes|yes|yEs|yeS|Да|ДА|да|дА)");
        Matcher mt_2 = pattern_2.matcher(answer);
        if (mt_2.matches()){
            return initializationHouseName();
        }
        return null;
    }
    public static Integer initializationYear() throws NullPointerException{
        System.out.println("Enter the values of the years field: ");
        Scanner scanner = new Scanner(System.in);
        String answer = scanner.nextLine();
        Pattern pattern = Pattern.compile("^[1-9][0-9]*$");
        Matcher mt = pattern.matcher(answer);
        if(mt.matches()){
            return Integer.parseInt(answer);
        }
        System.out.print("The year of operator is entered incorrectly. Do you want to fix it? ");
        String answer1 = scanner.nextLine();
        answer1 = answer1.replaceAll(" ", "");
        Pattern pattern_2 = Pattern.compile("(YES|Yes|yes|yEs|yeS|Да|ДА|да|дА)");
        Matcher mt_2 = pattern_2.matcher(answer1);
        if (mt_2.matches()){
            return initializationYear();
        }
        return 1;
    }
    public static Long initializationNumberOfFlatsOnFloor(){
        System.out.println("Enter the number of apartments per floor: ");
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        Pattern pattern = Pattern.compile("^[1-9][0-9]*$");
        Matcher mt = pattern.matcher(str);
        if(mt.matches()){
            return Long.parseLong(str);
        }
        System.out.print("The number of flats on floor of operator is entered incorrectly. Do you want to fix it? ");
        String answer1 = scanner.nextLine();
        answer1 = answer1.replaceAll(" ", "");
        Pattern pattern_2 = Pattern.compile("(YES|Yes|yes|yEs|yeS|Да|ДА|да|дА)");
        Matcher mt_2 = pattern_2.matcher(answer1);
        if (mt_2.matches()){
            return initializationNumberOfFlatsOnFloor();
        }
        return 1l;
    }
}
