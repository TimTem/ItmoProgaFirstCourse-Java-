package Command.ImplementationCommands.FieldInitialization;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InitializationName {
    public static String initalizationName(){
        System.out.print("Enter the name: ");
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();
        Pattern patern = Pattern.compile("^([A-z0-9]{1,}|[А-я0-9]{1,} [А-я0-9]{1,}|[А-я0-9]{1,}_[А-я0-9]{2,}|[A-z0-9]{1,} [A-z0-9]{1,}|[А-я0-9]{1,})$");
        Matcher mat = patern.matcher(name);
        if (mat.matches()){
            return name;
        }
        System.out.print("The name of thhe film is entered incorrectly. Do you want to fix it? ");
        String answer = scanner.nextLine();
        answer = answer.replaceAll(" ", "");
        Pattern pattern_2 = Pattern.compile("(YES|Yes|yes|yEs|yeS|Да|ДА|да|дА)");
        Matcher mt_2 = pattern_2.matcher(answer);
        if (mt_2.matches()){
            return initalizationName();
        }
        return null;
    }
}
