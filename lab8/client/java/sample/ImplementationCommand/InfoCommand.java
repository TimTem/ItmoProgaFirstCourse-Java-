package sample.ImplementationCommand;

import sample.Flat.Flat;
import sample.Launcher.ClientLauncher;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.time.LocalDate;
import java.util.Stack;

public class InfoCommand {
    public static LocalDate localDate = LocalDate.now();
    public static String implementationInfo(){
        return "Type collection: " + ClientLauncher.stack.getClass() + "\n"
                + "Сollection creation date: " + localDate + "\n"
                + "Number of elements in the collection " + ClientLauncher.stack.size() + "";
    }
}
