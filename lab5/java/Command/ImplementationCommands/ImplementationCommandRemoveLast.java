package Command.ImplementationCommands;

import Flat.Flat;

import java.util.Scanner;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ImplementationCommandRemoveLast {
    public static void implemenatationRemoveLast(Stack <Flat> flats){
        if(flats.size() == 0){
            System.out.println("The collection is empty, the command cannot be used");
        }
        System.out.println("You seriously want to remove the last element of the collection? Yes|yes");
        Scanner scanner = new Scanner(System.in);
        String clear = scanner.nextLine();
        Pattern pattern = Pattern.compile("yes");
        Matcher matcher = pattern.matcher(clear.toLowerCase());
        if(matcher.matches()){
            flats.pop();
            System.out.println("Last item in collection removed");
        }else{
            System.out.println("Incorrect syntax");
        }
    }
}
