package Command.ImplementationCommands;

import Flat.Flat;
import Json.Serializer;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.Stack;

public class ImplementationCommandSave {
    public static void save(Stack<Flat> flats){
        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("D:\\Berserk\\Server_Test\\src\\test\\java\\file.txt"));
            bufferedWriter.write(Serializer.serializer(flats));
            bufferedWriter.close();
            System.out.println("Стек успешно сохранен.");
        }
        catch (Exception exception){
           exception.printStackTrace();
        }

    }
}
