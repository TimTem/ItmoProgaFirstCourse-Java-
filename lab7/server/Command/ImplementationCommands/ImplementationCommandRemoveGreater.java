package Command.ImplementationCommands;

import Flat.Flat;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Stack;

public class ImplementationCommandRemoveGreater {
    public static void removeGreater(Stack<Flat> flats, String str, ObjectOutputStream out) throws IOException {
        if (flats.size() == 0) {
            out.writeObject("Collection empty");
            return;
        }
        final Long number = Long.parseLong(str);
        flats.removeIf(flat -> flat.getNumberOfRooms() > number);

    }
}
