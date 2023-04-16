package Command.ImplementationCommands;

import Flat.Flat;

import java.util.ArrayList;
import java.util.Stack;

public class ImplementationCommandRemoveById {
    public static void RemoveById(Stack<Flat> flats, ArrayList<String> arrayList){
        if(flats.size() == 0 ){
            System.out.println("Collection is empty");
            return;
        }
        if(flats.removeIf(flat -> flat.getId() == Integer.parseInt(arrayList.get(0)))){
            flats.removeIf(flat -> flat.getId() == Integer.parseInt(arrayList.get(0)));
            System.out.println("Collection item " + arrayList.get(0) + " has been removed");
        }else{
            System.out.println("The object with id equal " + arrayList.get(0) +  " was not found.");
        }
    }
}
