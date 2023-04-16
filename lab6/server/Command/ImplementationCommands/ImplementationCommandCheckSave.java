package Command.ImplementationCommands;

import Flat.Flat;
import Json.Serializer;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Stack;
import java.util.TreeSet;

public class ImplementationCommandCheckSave {
    public ImplementationCommandCheckSave() {
    }

    public static void saveChecker(Stack<Flat> flats) throws IOException {
        FileWriter fileWriter = new FileWriter("/home/studs/s371814/proga/lab5/SaverChecker.txt");
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        new StringBuilder();
        bufferedWriter.write(Serializer.serializer(flats));
        bufferedWriter.close();
    }

    public static void saveAgain() throws IOException {
        FileWriter fileWriter = new FileWriter("D:\\Berserk\\Server_Test\\src\\test\\java\\file.txt");
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        bufferedWriter.flush();
        bufferedWriter.close();
    }
}
