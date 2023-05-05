package Command.ImplementationCommands.FieldInitialization;

import Flat.Transports;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InitializationTransports {
    public static String initializationTransports(){
        System.out.println("Enter transport value(Few, None, Litle, Normal, Enough): ");
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        Transports[] transports = Transports.values();
        for(Transports transports1 : transports){
            if(str.toLowerCase().equals(transports1.getName().toLowerCase())){
                return transports1.getName();
            }
        }
        System.out.print("Invalid value. Do you want to change it?");
        String answer = scanner.nextLine();
        answer = answer.replaceAll(" ", "");
        Pattern pattern_2 = Pattern.compile("(YES|Yes|yes|yEs|yeS|Да|ДА|да|дА)");
        Matcher mt_2 = pattern_2.matcher(answer);
        if (mt_2.matches()){
            return initializationTransports();
        }
    return Transports.NONE.getName();
    }
}
