package Command.ImplementationCommands;

import Flat.Flat;

import java.util.Stack;

public class ImplementationFilterStartsWithName {
    public static void filterStartsWithName(Stack<Flat> flats, String str){
        if(flats.size() == 0){
            System.out.println("Collection is empty");
            return;
        }
        for(Flat flat : flats){
            if(flat.getName().equals(str)){
                System.out.println(flat);
            }
            System.out.println("All elements of the collection whose field values: " + str);
        }
    }
}
