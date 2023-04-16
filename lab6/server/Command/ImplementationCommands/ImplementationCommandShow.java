package Command.ImplementationCommands;

import Flat.Flat;

import java.util.Iterator;
import java.util.Stack;

public class ImplementationCommandShow  {
    public static void ImplementationShow(Stack <Flat> flats){
        if (flats.size() == 0) {
            System.out.println("Stack is empty. Command wasn`t executed.");
        } else {
            System.out.println("The show command is activated.".toUpperCase());
            Iterator var1 = flats.iterator();

            while(var1.hasNext()) {
                Flat movie = (Flat) var1.next();
                System.out.println(movie);
            }

        }
    }
}
