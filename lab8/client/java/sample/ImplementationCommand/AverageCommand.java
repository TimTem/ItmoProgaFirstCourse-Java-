package sample.ImplementationCommand;

import sample.Flat.Flat;
import sample.Launcher.ClientLauncher;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.sql.PreparedStatement;
import java.util.Stack;

public class AverageCommand {
    private static float average;
    private static int count;
    public static String averageOfNumberOfRooms(){
            if (ClientLauncher.stack.size() == 0) {
                return "Collection is empty";
            }else{
                for(Flat flat : ClientLauncher.stack){
                    average += flat.getNumberOfRooms();
                    count++;
                }
                return "Average of number of rooms: " + average/count + ".";
            }
        }
}
