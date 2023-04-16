package Command.ImplementationCommands;

import Flat.Flat;

import java.util.Stack;

public class ImplementationCommandRemoveById {
    public static void RemoveById(Stack<Flat> flats, String str){
        if(flats.size() == 0 ){
            System.out.println("Collection is empty");
            return;
        }
        if(flats.removeIf(flat -> flat.getId() == Integer.parseInt(str))){
            flats.removeIf(flat -> flat.getId() == Integer.parseInt(str));
            System.out.println("Collection item " + str + " has been removed");
        }else{
            System.out.println("The object with id equal " + str +  " was not found.");
        }
    }
}
