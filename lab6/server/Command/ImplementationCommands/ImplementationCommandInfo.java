package Command.ImplementationCommands;

import Flat.Flat;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Stack;

public class ImplementationCommandInfo {
    public static LocalDate localDate = LocalDate.now();
    public static void implementationInfo(Stack<Flat> flats) {
        System.out.println(
                "Type collection: " + flats.getClass() + "\n"
                        + "Сollection creation date: " + localDate + "\n"
                        + "Number of elements in the collection " + flats.size() + ""
        );
    }
}
