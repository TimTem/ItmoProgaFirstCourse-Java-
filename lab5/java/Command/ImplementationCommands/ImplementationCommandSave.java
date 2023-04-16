package Command.ImplementationCommands;

import Flat.Flat;
import Json.Serializer;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.Stack;

public class ImplementationCommandSave {
    public static void save(Stack<Flat> flats){
        System.out.println("conservation...".toUpperCase());
        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("/home/studs/s371814/proga/lab5/json.json"));
            bufferedWriter.write(Serializer.serializer(flats));
            bufferedWriter.close();
            System.out.println("Stack was successfully saved.");
        }
        catch (Exception exception){
           exception.printStackTrace();
        }

    }
}
