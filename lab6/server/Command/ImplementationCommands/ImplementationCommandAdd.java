package Command.ImplementationCommands;
import Flat.*;
import Command.ImplementationCommands.FieldInitialization.*;

import java.util.ArrayList;
import java.util.Stack;

public class ImplementationCommandAdd {
    public static void implementationAdd(Stack<Flat> flats, ArrayList<String> arrayList){
        System.out.println("Выполнение команды".toUpperCase());
        Flat flat = new Flat();
        flat.setId();
        flat.setName(arrayList.get(0));
        flat.setCoordinates(new Coordinates(Double.parseDouble(arrayList.get(1)), Double.parseDouble(arrayList.get(2))));
        flat.setArea(Long.parseLong(arrayList.get(3)));
        flat.setNumberOfRooms(Long.parseLong(arrayList.get(4)));
        flat.setNew(Boolean.parseBoolean(arrayList.get(5)));
        flat.setFurnish(arrayList.get(6));
        flat.setTransport(arrayList.get(7));
        flat.setHouse(new House(arrayList.get(8),Integer.parseInt(arrayList.get(9)),Long.parseLong(arrayList.get(10))));
        flats.add(flat);
        System.out.println("Добавлена новая квартира.");
    }
}
