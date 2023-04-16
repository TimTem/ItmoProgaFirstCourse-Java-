package Command.ImplementationCommands;

import Flat.Flat;

import java.util.Scanner;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ImplementationCommandRemoveLast {
    public static void implemenatationRemoveLast(Stack <Flat> flats){
        if(flats.size() == 0){
            System.out.println("Коллекция пуста, команда не может быть использована");
            return;
        }
            flats.pop();
            System.out.println("Последний элемент в коллекции удален");
    }
}
