package Command.ImplementationCommands;

import Flat.Flat;

import java.util.ArrayList;
import java.util.Stack;

public class ImplementationFilterStartsWithName {
    public static void filterStartsWithName(Stack<Flat> flats, ArrayList<String> arrayList){
        if(flats.size() == 0){
            System.out.println("Collection is empty");
            return;
        }
        for(Flat flat : flats){
            if(flat.getName().equals(arrayList.get(0))){
                System.out.println(flat);
            }
                System.out.println("Все элементы коллекции, значения полей которых: " + arrayList.get(0));
        }
    }
}
