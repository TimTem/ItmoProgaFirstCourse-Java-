package Command.ImplementationCommands;

import Flat.Flat;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Stack;

public class ImplementationFilterStartsWithName {
    public static void filterStartsWithName(Stack<Flat> flats, ArrayList<String> arrayList, ObjectOutputStream out) throws IOException {
        if(flats.size() == 0){
            out.writeObject("Collection is empty");
            return;
        }
        for(Flat flat : flats){
            if(flat.getName().equals(arrayList.get(0))){
                out.writeObject(flat);
            }
            out.writeObject("Все элементы коллекции, значения полей которых: " + arrayList.get(0));
        }
    }
}
