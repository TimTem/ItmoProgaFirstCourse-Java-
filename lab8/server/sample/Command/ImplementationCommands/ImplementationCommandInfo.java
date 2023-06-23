package sample.Command.ImplementationCommands;


import sample.Flat.Flat;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Stack;

public class ImplementationCommandInfo {
    public static LocalDate localDate = LocalDate.now();
    public static void implementationInfo(Stack<Flat> flats, ObjectOutputStream out) throws IOException {
        out.writeObject(
                "Type collection: " + flats.getClass() + "\n"
                        + "Сollection creation date: " + localDate + "\n"
                        + "Number of elements in the collection " + flats.size() + ""
        );
    }
}
