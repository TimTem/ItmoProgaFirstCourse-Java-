package Command.ImplementationCommands;

import Flat.Flat;

import java.io.IOException;
import java.util.Scanner;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ImplementationCommandExit {
    public static void exit(Stack<Flat>flats){
        System.out.println("The exit command is activated.".toUpperCase());
        Scanner scanner = new Scanner(System.in);
        System.out.print("Do you want to save treeSet? ");
        String answer = scanner.nextLine();
        answer = answer.replaceAll(" ", "");
        Pattern pattern_2 = Pattern.compile("(YES|Yes|yes)");
        Matcher mt_2 = pattern_2.matcher(answer);
        if (mt_2.matches()) {
            ImplementationCommandSave.save(flats);
        }
        try {
            ImplementationCommandCheckSave.saveAgain();
        } catch (IOException var6) {
        }

        flats.clear();
        System.exit(1);
    }
}
