package sample.Command.ImplementationCommands;

import java.util.Stack;

public class ImplementationCommandHistory {
    public static Stack<String> stack = new Stack<>();
    public static void separatlyHistory( String str){

        if (stack.size() == 10){
            stack.remove(0);
        }

        stack.push(str);
    }

    public static void showHistory(){

        System.out.println("The history command is activated.".toUpperCase());

        int counter = 1;
        for (String string : stack){
            System.out.println(counter + ") " + string);
            counter += 1;
        }
    }
}
