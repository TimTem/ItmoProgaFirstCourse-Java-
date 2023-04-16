package Command.ImplementationCommands;

import Flat.Flat;

import java.util.Stack;

public class ImplementationCommandRemoveGreater {
    public static void removeGreater(Stack<Flat> flats, String str) {
        if (flats.size() == 0) {
            System.out.println("Collection empty111");
            return;
        }
        final Long number = Long.parseLong(str);
        flats.removeIf(flat -> flat.getNumberOfRooms() > number);

    }
}
